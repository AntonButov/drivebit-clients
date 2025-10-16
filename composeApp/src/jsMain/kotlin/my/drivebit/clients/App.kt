package my.drivebit.clients

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import my.drivebit.components.filterButton
import my.drivebit.components.FilterBackgroundImage
import my.drivebit.shared.storage.Storage
import my.drivebit.shared.storage.create
import my.drivebit.ui.theme.DrivebitTheme
import my.drivebit.viewmodels.FiltersViewModel
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.dsl.module

val appModule =
    module {
        single<Storage> { create() }
        // Регистрируем ViewModel как factory для создания новых экземпляров
        single { FiltersViewModel() }
    }

@Composable
@Suppress("FunctionName")
actual fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        appContent()
    }
}

@Composable
fun appContent() {
    // DrivebitTheme {
    val filterViewModel: FiltersViewModel = koinInject()
    val state = filterViewModel.state.collectAsState()
    val filters = state.value.filters
    val selected = state.value.selected

    Div({
        style {
            padding(20.px, 40.px)
            fontFamily("system-ui, -apple-system, sans-serif")
            property("min-width", "320px")
            property("max-width", "1200px")
            property("margin", "0 auto")
            property("box-sizing", "border-box")
        }
    }) {
        // Логотип Turo сверху
        Img(
            src = "https://antonbutov.github.io/drivebit-clients/images/logos/turo_logo.svg",
            alt = "Turo Logo",
            attrs = {
                style {
                    width(120.px)
                    height(40.px)
                    marginBottom(20.px)
                    property("object-fit", "contain")
                    property("transition", "all 0.3s ease")
                    property("max-width", "120px")
                    property("max-height", "40px")
                }
                classes("turo-logo")
            }
        )

        // Фоновая картинка для выбранного фильтра
        val selectedFilter = filters.find { it.title == selected }
        selectedFilter?.let { filter ->
            FilterBackgroundImage(
                backgroundIconUrl = "https://antonbutov.github.io/drivebit-clients/images/searchbackground/car${filter.backgroundIcon}.jpg"
            )
        }

        // Фильтры
        Div({
            style {
                display(DisplayStyle.Flex)
                gap(12.px)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                marginBottom(20.px)
                flexWrap(FlexWrap.Wrap)
            }
        }) {
            filters.forEach { filter ->
                filterButton(
                    filter = filter,
                    isSelected = filter.title == selected,
                    onClick = { filterViewModel.onSelect(filter.title) },
                )
            }
        }
          }
   // }
}
