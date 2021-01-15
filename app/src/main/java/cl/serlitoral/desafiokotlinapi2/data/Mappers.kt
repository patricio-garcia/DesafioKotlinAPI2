package cl.serlitoral.desafiokotlinapi2.data

fun mapAPI2DB(photo: Photo): PhotoEntity {
    return PhotoEntity(photo.albumId, photo.id, photo.title, photo.url, photo.thumbnailUrl)
}

fun mapDB2API(photo: PhotoEntity): Photo {
    return Photo(photo.albumId, photo.id, photo.title, photo.url, photo.thumbnailUrl)
}