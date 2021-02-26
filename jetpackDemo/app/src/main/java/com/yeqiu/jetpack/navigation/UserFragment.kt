package com.yeqiu.jetpack.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.yeqiu.jetpack.R



class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        view.findViewById<Button>(R.id.btOrder).setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_userFragment_to_orderFragment)
        }
        return view
    }

}