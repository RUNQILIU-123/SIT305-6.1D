package com.example.llmlearningassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.llmlearningassistant.ui.screens.*
import com.example.llmlearningassistant.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("interests") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("interests") },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable("interests") {
            InterestsScreen(
                viewModel = viewModel,
                onContinue = { navController.navigate("home") }
            )
        }
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onTaskClick = { task ->
                    viewModel.selectTask(task)
                    navController.navigate("task_detail")
                }
            )
        }
        composable("task_detail") {
            TaskDetailScreen(
                viewModel = viewModel,
                onNavigateToResults = { navController.navigate("results") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("results") {
            ResultsScreen(
                viewModel = viewModel,
                onContinue = { navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                } }
            )
        }
    }
}
