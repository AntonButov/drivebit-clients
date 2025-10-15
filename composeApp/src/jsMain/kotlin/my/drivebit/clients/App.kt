package my.drivebit.clients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.russhwolf.settings.Settings
import my.drivebit.components.FilterButton
import my.drivebit.design.WebDrivebitColors
import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.create
import my.drivebit.shared.storage.di.storageModule
import my.drivebit.viewmodels.FiltersViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.KoinApplication
import org.koin.dsl.module

val appModule =
    module {
        single<Storage> { create() }
        // ✅ ViewModel получает Settings для сохранения состояния
        single { FiltersViewModel(get<Settings>()) }
    }


@Composable
actual fun App() {
    KoinApplication(application = {
        modules(appModule, storageModule)
    }) {
        AppContent()
    }
}

@Composable
fun AppContent() {
    val filterViewModel: FiltersViewModel = koinInject()
    val state = filterViewModel.state.collectAsState()
    val filters = state.value.filters
    val selected = state.value.selected

    Div({
        style {
            padding(20.px)
            fontFamily("system-ui, -apple-system, sans-serif")
            backgroundColor(WebDrivebitColors.Gray100)
        }
    }) {
        // Фильтры
        Div({
            style {
                display(DisplayStyle.Flex)
                gap(12.px)
                alignItems(AlignItems.Center)
                marginBottom(20.px)
                flexWrap(FlexWrap.Wrap)
            }
        }) {
            filters.forEach { filter ->
                FilterButton(
                    filter = filter,
                    isSelected = filter.title == selected,
                    onClick = { filterViewModel.onSelect(filter.title) },
                )
            }
        }

        // Информация о выбранном фильтре
        Div({
            style {
                padding(16.px)
                backgroundColor(WebDrivebitColors.White)
                borderRadius(8.px)
                fontSize(14.px)
                color(WebDrivebitColors.Gray500)
                border(1.px, LineStyle.Solid, WebDrivebitColors.Gray300)
            }
        }) {
            Text("Выбранный фильтр: $selected")
        }
    }
}
