package com.example.llmlearningassistant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.llmlearningassistant.BuildConfig
import com.example.llmlearningassistant.data.model.LLMResponse
import com.example.llmlearningassistant.data.model.LearningTask
import com.example.llmlearningassistant.data.remote.NetworkModule
import com.example.llmlearningassistant.data.repository.DataRepository
import com.example.llmlearningassistant.data.repository.LLMRepository
import com.example.llmlearningassistant.data.repository.LLMRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiState<out T> {
    object Idle : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

class MainViewModel : ViewModel() {
    private val dataRepository = DataRepository()
    
    // 安全接入：从 BuildConfig 读取 API Key，避免泄露到 GitHub
    private val llmRepository: LLMRepository = LLMRepositoryImpl(
        apiService = NetworkModule.apiService,
        apiKey = BuildConfig.OPENAI_API_KEY
    )

    val interests = dataRepository.interests
    val selectedInterests = dataRepository.selectedInterests

    private val _llmState = MutableStateFlow<UiState<LLMResponse>>(UiState.Idle)
    val llmState: StateFlow<UiState<LLMResponse>> = _llmState.asStateFlow()

    private val _currentTask = MutableStateFlow<LearningTask?>(null)
    val currentTask: StateFlow<LearningTask?> = _currentTask.asStateFlow()

    private val _userAnswers = MutableStateFlow<Map<String, String>>(emptyMap())
    val userAnswers: StateFlow<Map<String, String>> = _userAnswers.asStateFlow()

    fun toggleInterest(id: String) {
        dataRepository.toggleInterest(id)
    }

    fun getTasks() = dataRepository.getTasks()

    fun selectTask(task: LearningTask) {
        _currentTask.value = task
        _userAnswers.value = emptyMap()
        _llmState.value = UiState.Idle
    }

    fun setUserAnswer(questionId: String, answer: String) {
        val current = _userAnswers.value.toMutableMap()
        current[questionId] = answer
        _userAnswers.value = current
    }

    fun explainAnswer(question: String, correctAnswer: String, userAnswer: String) {
        viewModelScope.launch {
            _llmState.value = UiState.Loading
            llmRepository.explainAnswer(question, correctAnswer, userAnswer)
                .onSuccess { _llmState.value = UiState.Success(it) }
                .onFailure { _llmState.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }

    fun generateFlashcards(topic: String) {
        viewModelScope.launch {
            _llmState.value = UiState.Loading
            llmRepository.generateFlashcards(topic)
                .onSuccess { _llmState.value = UiState.Success(it) }
                .onFailure { _llmState.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }
    
    fun resetLlmState() {
        _llmState.value = UiState.Idle
    }
}
