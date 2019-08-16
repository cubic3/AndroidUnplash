package com.kc.unsplash

import com.kc.unsplash.api.Order
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.PhotosEndpointInterface
import com.kc.unsplash.models.Download
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults

class PhotoAPI(private var photosApiService: PhotosEndpointInterface) {

    fun getPhotos(page: Int?, perPage: Int?, order: Order, onComplete: (List<Photo>) -> Unit, onError: (String) -> Unit) {
        val call = photosApiService.getPhotos(page, perPage, order.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    @Deprecated("")
    fun getCuratedPhotos(page: Int?, perPage: Int?, order: Order, onComplete: (List<Photo>) -> Unit, onError: (String) -> Unit) {
        val call = photosApiService.getCuratedPhotos(page, perPage, order.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getPhoto(id: String, width: Int? = null, height: Int? = null, onComplete: (Photo) -> Unit, onError: (String) -> Unit) {
        val call = photosApiService.getPhoto(id, width, height)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRandomPhoto(collections: String?,
                       featured: Boolean?,
                       username: String?,
                       query: String?,
                       width: Int?,
                       height: Int?,
                       orientation: String?,
                       onComplete: (Photo) -> Unit,
                       onError: (String) -> Unit) {
        val call = photosApiService.getRandomPhoto(collections, featured, username, query, width, height, orientation)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRandomPhotos(collections: String?,
                        featured: Boolean?,
                        username: String?,
                        query: String?,
                        width: Int?,
                        height: Int?,
                        orientation: String?,
                        count: Int?,
                        onComplete: (List<Photo>) -> Unit,
                        onError: (String) -> Unit) {
        val call = photosApiService.getRandomPhotos(collections!!, featured!!, username!!, query!!, width, height, orientation!!, count)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun searchPhotos(query: String,
                     page: Int = 1,
                     perPage: Int = 10,
                     orientation: String? = null,
                     onComplete: (SearchResults) -> Unit,
                     onError: (String) -> Unit) {
        val call = photosApiService.searchPhotos(query, page, perPage, orientation)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getPhotoDownloadLink(id: String,
                             onComplete: (Download) -> Unit,
                             onError: (String) -> Unit) {
        val call = photosApiService.getPhotoDownloadLink(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

}