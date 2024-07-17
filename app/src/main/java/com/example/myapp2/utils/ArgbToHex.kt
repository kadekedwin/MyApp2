package com.example.myapp2.utils

fun argbToHex(argb: Int): String {
    val alpha = (argb shr 24) and 0xFF
    val red = (argb shr 16) and 0xFF
    val green = (argb shr 8) and 0xFF
    val blue = argb and 0xFF

//    return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
    return String.format("#%02X%02X%02X", red, green, blue)
}