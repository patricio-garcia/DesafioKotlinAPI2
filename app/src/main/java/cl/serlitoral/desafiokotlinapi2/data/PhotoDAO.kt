package cl.serlitoral.desafiokotlinapi2.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhotoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photoEntity: List<PhotoEntity>)

    @Query("SELECT * FROM photo_table")
    fun getPhotos(): LiveData<List<PhotoEntity>>

    @Database(entities = [PhotoEntity::class], version = 1)
    abstract class PhotoDB: RoomDatabase() {
        abstract fun photoDao(): PhotoDAO
    }

    class UserApplication: Application() {
        companion object {
            var photoDatabase: PhotoDB? = null
        }

        override fun onCreate() {
            super.onCreate()

            photoDatabase = Room.databaseBuilder(this, PhotoDB::class.java, "photo_db").build()
        }
    }
}