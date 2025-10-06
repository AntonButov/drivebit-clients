package my.drivebit.mobile.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import my.drivebit.auth.Idle
import my.drivebit.auth.NavigateToLoginScreen
import my.drivebit.auth.NavigateToLoginScreenViewModel
import my.drivebit.auth.screens.auth.LoginScreen
import my.drivebit.mobile.screens.main.tabs.InboxTab
import my.drivebit.mobile.screens.main.tabs.SearchTab
import my.drivebit.mobile.screens.main.tabs.TripsTab
import my.drivebit.splash.LoaderScreen
import my.drivebit.splash.SplashState
import my.drivebit.splash.SplashViewModel
import my.drivebit.ui.theme.DrivebitTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

class MainScreen : Screen {
    @Composable
    override fun Content() {
        DrivebitTheme {
            val navigateToLoginScreenViewModel: NavigateToLoginScreenViewModel = koinScreenModel()
            when (navigateToLoginScreenViewModel.state) {
                Idle -> {}
                NavigateToLoginScreen -> LocalNavigator.currentOrThrow.push(LoginScreen())
            }

            val splashViewModel: SplashViewModel = koinScreenModel()
            val splashState = splashViewModel.state.collectAsState()
            when (splashState.value) {
                SplashState.Init -> {}
                SplashState.Loading -> LoaderScreen()
                SplashState.Loaded ->
                    MainScreenContent {
                        when (it) {
                            TripsTab,
                            InboxTab,
                            -> {
                                navigateToLoginScreenViewModel.checkLogin()
                            }
                        }
                    }
            }
        }
    }
}

@Composable
fun MainScreenContent(onTabSelected: (Tab) -> Unit) {
    TabNavigator(SearchTab) { tabNavigator ->
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    currentTab = tabNavigator.current,
                    onTabSelected = { tab ->
                        tabNavigator.current = tab
                        onTabSelected(tab)
                    },
                )
            },
        ) { paddingValues ->
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
            ) {
                tabNavigator.current.Content()
            }
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    DrivebitTheme {
        MainScreenContent {}
    }
}
