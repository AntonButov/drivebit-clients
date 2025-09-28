package my.drivebit.clients.screens.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.tab.TabNavigator
import my.drivebit.clients.screens.main.tabs.SearchTab
import my.drivebit.clients.screens.splash.LoaderScreen
import my.drivebit.clients.screens.splash.SplashState
import my.drivebit.clients.screens.splash.SplashViewModel

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = koinScreenModel()

        val state = viewModel.state.collectAsState().value
        when (state) {
            SplashState.Init,
            SplashState.Loading,
            -> {
                LoaderScreen()
            }
            SplashState.Loaded -> {
                TabNavigator(SearchTab) { tabNavigator ->
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                currentTab = tabNavigator.current,
                                onTabSelected = { tab ->
                                    tabNavigator.current = tab
                                },
                            )
                        },
                    ) { paddingValues ->
                        tabNavigator.current.Content()
                    }
                }
            }
        }
    }
}
