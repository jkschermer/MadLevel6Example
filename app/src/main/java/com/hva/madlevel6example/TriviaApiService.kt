package com.hva.madlevel6example

import retrofit2.http.GET

interface TriviaApiService {

    @GET("/random/trivia?json")
    suspend fun getRandomNumberTrivia() : Trivia
}