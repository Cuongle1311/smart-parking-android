package com.tienhuynh.happystudio.smartparking.extension

import android.graphics.Typeface
import android.widget.TextView

/**
 *
 * @author at-tienhuynh3
 */

internal fun TextView.setFontApp() {
    val tf = Typeface.createFromAsset(context.assets, "fonts/fontAller.ttf")
    this.typeface = tf
}
