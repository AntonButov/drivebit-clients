package my.drivebit.viewmodels.di

import my.drivebit.viewmodels.FiltersViewModel
import my.drivebit.viewmodels.IconUserViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelsModule: Module =
    module {

        factory {
            FiltersViewModel(
                storage = get(),
            )
        }

        factory {
            IconUserViewModel(
                storage = get(),
            )
        }
    }
