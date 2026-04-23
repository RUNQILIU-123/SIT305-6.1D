package com.example.llmlearningassistant.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.llmlearningassistant.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(
    viewModel: MainViewModel,
    onContinue: () -> Unit
) {
    val task by viewModel.currentTask.collectAsState()
    val userAnswers by viewModel.userAnswers.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Task Results") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text("Summary", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
            }

            task?.questions?.let { questions ->
                items(questions) { question ->
                    val answer = userAnswers[question.id] ?: "No answer provided"
                    val isCorrect = answer == question.correctAnswer

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isCorrect) 
                                MaterialTheme.colorScheme.primaryContainer 
                            else 
                                MaterialTheme.colorScheme.errorContainer
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = question.questionText, style = MaterialTheme.typography.titleSmall)
                            Text(text = "Your Answer: $answer", style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Correct Answer: ${question.correctAnswer}", style = MaterialTheme.typography.bodyMedium)
                            
                            Text(
                                text = if (isCorrect) "Correct!" else "Incorrect",
                                style = MaterialTheme.typography.labelLarge,
                                color = if (isCorrect) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onContinue,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Return to Home")
                }
            }
        }
    }
}
