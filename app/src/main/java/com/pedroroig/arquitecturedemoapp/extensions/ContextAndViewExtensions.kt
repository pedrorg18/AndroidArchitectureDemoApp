package com.pedroroig.arquitecturedemoapp.extensions

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisibilize() {
    visibility = View.INVISIBLE
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun TextView.setTextHideIfNull(text: String?) {
    if(text != null) this.apply {
        visibility = View.VISIBLE
        this.text = text
    }
    else visibility = View.GONE
}
