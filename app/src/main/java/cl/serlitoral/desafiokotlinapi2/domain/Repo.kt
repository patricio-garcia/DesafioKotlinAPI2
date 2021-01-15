package cl.serlitoral.desafiokotlinapi2.domain

import android.util.Log
import cl.serlitoral.desafiokotlinapi2.data.PhotoDAO
import cl.serlitoral.desafiokotlinapi2.data.mapAPI2DB
import cl.serlitoral.desafiokotlinapi2.vo.RetrofitClient

class Repo {
    private val photoDatabase = PhotoDAO.UserApplication.photoDatabase!!
    val photoList = photoDatabase.photoDao().getPhotos()

    suspend fun loadFromApi2DB() {
        val response = RetrofitClient.RetrofitInstance().getPhotos()

        when(response.isSuccessful) {
            true -> {
                response.body()?.let { photoList ->
                    val r = photoList.map {
                        mapAPI2DB(it)
                    }
                    photoDatabase.photoDao().insertPhoto(r)
                }
            }
            false -> {
                Log.d("Repo Error", "${response.errorBody()} ")
            }
        }
    }
}