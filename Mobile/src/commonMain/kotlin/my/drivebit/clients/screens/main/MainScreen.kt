package my.drivebit.clients.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.TabNavigator
import my.drivebit.clients.screens.main.tabs.SearchTab
import my.drivebit.clients.theme.DrivebitTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

class MainScreen : Screen {
    @Composable
    override fun Content() {
        DrivebitTheme {
            MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent(onTabSelected: (cafe.adriel.voyager.navigator.tab.Tab) -> Unit = {}) {
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
        MainScreenContent()
    }
}
