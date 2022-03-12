package com.yhjoo.corona.utils

import com.orhanobut.logger.Logger

object Utils {
    fun log(vararg msgs: Any?) {
        Logger.d("YHJOO %s", *msgs)
    }
}