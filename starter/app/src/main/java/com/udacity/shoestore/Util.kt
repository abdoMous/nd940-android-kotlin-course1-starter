package com.udacity.shoestore

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.udacity.shoestore.models.Shoe

fun formatShoesList(list: List<Shoe?>, resources: Resources) : Spanned {
    val sb = StringBuilder()
    sb.apply {
        list.forEach { shoe ->
            append(resources.getString(R.string.name))
            append(shoe?.name)
            append(resources.getString(R.string.size))
            append(shoe?.size)
            append(resources.getString(R.string.company))
            append(shoe?.company)
            append(resources.getString(R.string.description))
            append(shoe?.description)
            append("<br><br>")
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}