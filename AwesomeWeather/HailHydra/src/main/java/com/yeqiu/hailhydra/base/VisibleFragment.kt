package com.yeqiu.hailhydra.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2020/9/25
 * @describe：
 * @fix：
 */

abstract class VisibleFragment : Fragment() {


    /**
     * 上次是否不可见
     */
    private var isLastVisible = false

    /**
     * 是否是第一次可见
     */
    private var isFirst = true

    /**
     * 是否已经执行onResume
     */
    private var isResuming = false

    /**
     * view是否已经创建
     */
    private var isViewCreate = false

    /**
     * 是否被隐藏
     */
    private var hidden = false
    private var contentView: View? = null

    protected abstract fun getContentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?


    /**
     * fragment可见
     *
     * @param isFirst
     * @param isViewCreate
     */
    private fun onVisible(isFirst: Boolean, isViewCreate: Boolean) {
        if (isViewCreate) {
            onVisible()
        }
    }

    /**
     * 当前fragment可见
     */
    protected  fun onVisible(){}


    /**
     * fragment不可见
     */
    protected fun onInvisible() {}




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentView = getContentView(inflater, container, savedInstanceState)
        isViewCreate = true
        isLastVisible = false
        isFirst = true
        hidden = false
        return contentView
    }


    override fun onResume() {
        super.onResume()
        isResuming = true
        //  尝试设置可见
        trySetVisibility(true)
    }


    override fun onPause() {
        super.onPause()
        isResuming = false
        //  尝试设置不可见
        trySetVisibility(false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreate = false
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        //设置子Fragment当前可见状态改变了
        setChildFragmentUserVisibleHint(isVisibleToUser)
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        setChildFragmentHiddenChanged(hidden)
    }


    /**
     * 尝试修改可见状态
     * 根据当前是否显示判断
     *
     * @param tryToShow
     */
    private fun trySetVisibility(tryToShow: Boolean) {
        if (isLastVisible) {
            //当前可见
            if (tryToShow) {
                //尝试显示  当前已经是显示
                return
            }

            //尝试隐藏
            if (!isFragmentVisible()) {
                //当前已经是不可见,回调隐藏方法
                onInvisible()
                isLastVisible = false
            }
        } else {
            //当前不可见
            if (!tryToShow) {
                //尝试隐藏 当前已经是隐藏
                return
            }
            if (isFragmentVisible()) {
                onVisible(isFirst, isViewCreate)
                isLastVisible = true
                isFirst = false
            }
        }
    }


    /**
     * Fragment是否可见
     *
     * @return
     */
    fun isFragmentVisible(): Boolean {
        return isResuming && userVisibleHint && !hidden
    }


    private fun setChildFragmentUserVisibleHint(isVisibleToUser: Boolean) {
        // 尝试设置可见状态
        trySetVisibility(isVisibleToUser)
        if (isAdded) {
            //已经被添加
            // 当Fragment状态改变，其子Fragment也状态改变。
            val fragments = childFragmentManager.fragments
            for (fragment in fragments) {
                if (fragment is VisibleFragment) {
                    (fragment as VisibleFragment).setChildFragmentUserVisibleHint(
                        isVisibleToUser
                    )
                }
            }
        }
    }


    private fun setChildFragmentHiddenChanged(hidden: Boolean) {
        this.hidden = hidden
        trySetVisibility(!hidden)
        if (isAdded) {
            val fragments = childFragmentManager.fragments
            for (fragment in fragments) {
                if (fragment is VisibleFragment) {
                    (fragment as VisibleFragment).setChildFragmentHiddenChanged(hidden)
                }
            }
        }
    }

}