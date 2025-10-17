package my.drivebit.clients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import my.drivebit.viewmodels.FiltersViewModel
import my.drivebit.viewmodels.IconUserViewModel
import org.koin.compose.koinInject
import org.koin.core.component.inject

@Composable
fun ExampleFiltersScreen() {
    val filtersViewModel: FiltersViewModel = koinInject()
    val state by filtersViewModel.state.collectAsState()
}

@Composable
fun ExampleUserScreen() {
    val userViewModel: IconUserViewModel = koinInject()
    val isLoggedIn = userViewModel.isUserLoggedIn()
    val token = userViewModel.getUserToken()
}

class SomeService {
    private val filtersViewModel: FiltersViewModel by inject()
    private val userViewModel: IconUserViewModel by inject()
    
    fun doSomething() {
        val isLoggedIn = userViewModel.isUserLoggedIn()
        if (isLoggedIn) {
        }
    }
}

class AnotherService(
    private val filtersViewModel: FiltersViewModel,
    private val userViewModel: IconUserViewModel
) {
    fun processFilters() {
        val currentState = filtersViewModel.state.value
    }
}
