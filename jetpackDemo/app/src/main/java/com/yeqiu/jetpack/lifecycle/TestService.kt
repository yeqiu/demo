package com.yeqiu.jetpack.lifecycle

import androidx.lifecycle.LifecycleService

class TestService : LifecycleService() {

    private var testServiceObserver: TestServiceObserver = TestServiceObserver()

    init {
     lifecycle.addObserver(testServiceObserver)
    }

}