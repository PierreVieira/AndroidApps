package com.example.httpwithktor.data.remote

import android.util.Log
import com.example.httpwithktor.data.remote.dto.PostRequest
import com.example.httpwithktor.data.remote.dto.PostResponse
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

@ViewModelScoped
class PostsServiceImplementation @Inject constructor(
    private val client: HttpClient
) : PostsService {

    companion object {
        private val TAG = PostsServiceImplementation::class.java.simpleName
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private const val POSTS = "${BASE_URL}posts"
    }

    override suspend fun getPosts(): List<PostResponse> = try {
        client.get { url(POSTS) }
    } catch (e: RedirectResponseException) {
        // 3xx - responses
        Log.e(TAG, e.response.status.description)
        emptyList()
    } catch (e: ClientRequestException) {
        // 4xx - responses
        Log.e(TAG, e.response.status.description)
        emptyList()
    } catch (e: ServerResponseException) {
        // 5xx - responses
        Log.e(TAG, e.response.status.description)
        emptyList()
    } catch (e: Exception) {
        Log.e(TAG, "${e.message}")
        emptyList()
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? = try {
        client.post<PostResponse> {
            url(POSTS)
            contentType(ContentType.Application.Json)
            body = postRequest
        }
    } catch (e: RedirectResponseException) {
        // 3xx - responses
        Log.e(TAG, e.response.status.description)
        null
    } catch (e: ClientRequestException) {
        // 4xx - responses
        Log.e(TAG, e.response.status.description)
        null
    } catch (e: ServerResponseException) {
        // 5xx - responses
        Log.e(TAG, e.response.status.description)
        null
    } catch (e: Exception) {
        Log.e(TAG, "${e.message}")
        null
    }
}