package my.drivebit.auth.di

import my.drivebit.auth.NavigateToLoginScreenViewModel
import org.koin.dsl.module

val authModule =
    module {
        factory { NavigateToLoginScreenViewModel(get()) }
    }
