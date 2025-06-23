package com.example.dailybeat.articles

import com.example.dailybeat.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    // when the ui is instanciate article view model it is going to subscribe to the articles state flow
    // this is observable state between UI and viewmodel
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    // this is public state that is exposed to UI
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    // going to call getArticles() when the viewmodel is initialized
    init {
        getArticles()
    }

    // this fun is going to return articles
    private fun getArticles() {
        scope.launch {

            delay(2000)

            _articlesState.emit(ArticlesState(error = "Something went wrong"))

            delay(2000)

            val fetchArticles = fetchArticles()
            _articlesState.emit(ArticlesState(articles = fetchArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Article 1",
            description = "Description 1",
            date = "2023-01-01",
            imageUrl = "https://picsum.photos/100"
        ),
        Article(
            title = "Article 2",
            description = "Description 2",
            date = "2023-01-01",
            imageUrl = "https://picsum.photos/200"
        ),
        Article(
            title = "Article 3",
            description = "Description 3",
            date = "2023-01-01",
            imageUrl = "https://picsum.photos/300"
        ),
    )
}