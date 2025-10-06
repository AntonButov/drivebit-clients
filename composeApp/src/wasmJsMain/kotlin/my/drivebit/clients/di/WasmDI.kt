package my.drivebit.clients.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen

@Composable
inline fun <reified T : ScreenModel> Screen.wasmScreenModel(): T =
    remember {
        throw IllegalArgumentException("Unknown ScreenModel type: ${T::class}")
    }
