package com.yhjoo.corona_android.utils

import android.content.Context
import android.util.Patterns
import com.orhanobut.logger.Logger
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

object Utils {
    fun log(vararg msgs: Any?) {
        Logger.d("YHJOO %s", *msgs)
    }
}