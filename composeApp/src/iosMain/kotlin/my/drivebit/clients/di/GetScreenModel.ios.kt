package my.drivebit.clients.di

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

@Composable
actual inline fun <reified T : ScreenModel> Screen.platformScreenModel(): T = koinScreenModel()
