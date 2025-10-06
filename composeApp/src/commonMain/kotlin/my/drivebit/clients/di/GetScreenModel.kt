package my.drivebit.clients.di

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen

@Composable
expect inline fun <reified T : ScreenModel> Screen.platformScreenModel(): T
