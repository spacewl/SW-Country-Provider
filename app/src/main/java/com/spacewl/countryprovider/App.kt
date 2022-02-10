package com.spacewl.countryprovider

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy


class App  : Application() {
    override fun onCreate() {
        super.onCreate()
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build()
        )
    }
}