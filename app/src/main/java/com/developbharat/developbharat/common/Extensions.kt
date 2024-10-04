package com.developbharat.developbharat.common

import android.graphics.Bitmap
import android.graphics.Canvas


fun Bitmap.fillColor(color: Int): Bitmap {
    val canvas = Canvas(this)
    canvas.drawColor(color)
    return this
}