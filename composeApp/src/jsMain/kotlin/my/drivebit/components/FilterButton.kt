package my.drivebit.components

import androidx.compose.runtime.Composable
import my.drivebit.design.CSSColors
import my.drivebit.design.CSSTypography
import my.drivebit.design.applyTypography
import my.drivebit.viewmodels.FilterItem
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
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
            backgroundColor(if (isSelected) CSSColors.Black else CSSColors.White)
            color(if (isSelected) CSSColors.White else CSSColors.Black)
            property("transition", "all 0.2s ease")
            property("border", "none")
        }
        classes("filter-button")
        onClick { onClick() }
    }) {
        Img(
            src = filter.icon,
            alt = filter.icon,
            attrs = {
                style {
                    width(20.px)
                    height(20.px)
                    property("object-fit", "contain")
                    property("transition", "opacity 0.3s ease")
                    if (isSelected) {
                        property("filter", "brightness(0) invert(1)")
                    }
                }
            },
        )

        Span({
            style {
                applyTypography(CSSTypography.Styles.button)
                marginLeft(8.px)
            }
        }) {
            Text(filter.title)
        }
    }
}
