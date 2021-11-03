package com.rolo.gltestrolando.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ItemGL(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: String?
) {

    @PrimaryKey(autoGenerate = true)
    var iid: Int = 0
}
