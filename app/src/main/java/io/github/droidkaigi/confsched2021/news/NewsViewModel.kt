package io.github.droidkaigi.confsched2021.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.droidkaigi.confsched2021.news.data.Api
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModel : ViewModel(), INewsViewModel {
    override val articles: MutableStateFlow<Articles> = MutableStateFlow(Articles())

    init {
        viewModelScope.launch {
            articles.value = Api().fetch()
        }
    }
}