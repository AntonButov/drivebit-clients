package my.drivebit.components

import androidx.compose.runtime.Composable
import my.drivebit.viewmodels.FilterItem
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun filterButton(
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
                    color(if (isSelected) Color.white else Color.black)
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
