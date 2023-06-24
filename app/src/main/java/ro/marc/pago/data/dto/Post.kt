package ro.marc.pago.data.dto

import android.annotation.SuppressLint

data class Post(
    var id: Long,
    var user_id: Long,
    var title: String,
    var body: String,
)
