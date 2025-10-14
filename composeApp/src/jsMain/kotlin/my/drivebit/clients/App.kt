package my.drivebit.clients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.create
import my.drivebit.viewmodels.FilterItem
import my.drivebit.viewmodels.FiltersViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule =
    module {
        single<Storage> { create() }
    }

@Composable
fun FilterButton(
    filter: FilterItem,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            gap(8.px)
            padding(12.px, 16.px)
            borderRadius(8.px)
            cursor("pointer")
            border(1.px, LineStyle.Solid, if (isSelected) Color.black else Color.gray)
            backgroundColor(if (isSelected) Color.black else Color.white)
            color(if (isSelected) Color.white else Color.black)
            property("transition", "all 0.2s ease")
        }
        onClick { onClick() }
    }) {
        // Асинхронная загрузка иконки по URL
        Img(
            src = filter.icon,
            alt = filter.icon,
            attrs = {
                style {
                    width(20.px)
                    height(20.px)
                    property("object-fit", "contain")
                    property("transition", "opacity 0.3s ease")
                }
            },
        )

        // Название
        Span({
            style {
                fontSize(14.px)
                fontWeight("500")
                marginLeft(8.px)
            }
        }) {
            Text(filter.title)
        }
    }
}

@Composable
actual fun App() {
    val koin =
        remember {
            startKoin {
                modules(appModule)
            }
        }

    val storage = remember { koin.koin.get<Storage>() }
    val filterViewModel: FiltersViewModel = remember { FiltersViewModel() }
    val state = filterViewModel.state.collectAsState()
    val filters = state.value.filters
    val selected = state.value.selected

    Div({
        style {
            padding(20.px)
            fontFamily("system-ui, -apple-system, sans-serif")
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
                backgroundColor(Color("#f8f9fa"))
                borderRadius(8.px)
                fontSize(14.px)
                color(Color("#666"))
            }
        }) {
            Text("Выбранный фильтр: $selected")
        }
    }
}
