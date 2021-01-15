package cl.serlitoral.desafiokotlinapi2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

@Entity(tableName = "photo_table")
data class PhotoEntity(
    @PrimaryKey
    @ColumnInfo(name = "album_id")
    val albumId: Int,
    @ColumnInfo(name = "photo_id")
    val id: Int,
    @ColumnInfo(name = "photo_title")
    val title: String,
    @ColumnInfo(name = "photo_url")
    val url: String,
    @ColumnInfo(name = "photo_thumb")
    val thumbnailUrl: String
)

