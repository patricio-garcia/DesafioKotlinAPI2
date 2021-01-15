package cl.serlitoral.desafiokotlinapi2.domain

import cl.serlitoral.desafiokotlinapi2.data.Photo
import retrofit2.Response
import retrofit2.http.GET

interface iWebService {
    @GET("photos")
    suspend fun getPhotos(): Response<List<Photo>>
}