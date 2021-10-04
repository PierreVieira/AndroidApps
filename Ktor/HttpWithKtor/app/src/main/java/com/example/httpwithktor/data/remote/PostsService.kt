package com.example.httpwithktor.data.remote

import com.example.httpwithktor.data.remote.dto.PostRequest
import com.example.httpwithktor.data.remote.dto.PostResponse

interface PostsService {
    suspend fun getPosts(): List<PostResponse>
    suspend fun createPost(postRequest: PostRequest): PostResponse?
}