package com.hva.madlevel6example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withTimeout

class TriviaRepository {
    private val triviaApiService: TriviaApiService =
        TriviaApi.createApi()

    private val _trivia: MutableLiveData<Trivia> = MutableLiveData()

    val trivia: LiveData<Trivia>
    get() = _trivia

    suspend fun getRandomNumberTrivia() {
        try {
            val result = withTimeout(5000) {
                triviaApiService.getRandomNumberTrivia()
            }

            _trivia.value = result
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to refresh trivia", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}