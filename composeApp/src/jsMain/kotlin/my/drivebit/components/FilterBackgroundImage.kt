package my.drivebit.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun FilterBackgroundImage(
    backgroundIconUrl: String,
) {
    Div({
        style {
            width(100.percent)
            height(200.px)
            borderRadius(12.px)
            overflow("hidden")
            position(Position.Relative)
            marginBottom(20.px)
        }
    }) {
        Img(
            src = backgroundIconUrl,
            alt = "Filter background",
            attrs = {
                style {
                    width(100.percent)
                    height(100.percent)
                    property("object-fit", "cover")
                    property("object-position", "center")
                }
            }
        )
        
        // Градиентный оверлей для лучшей читаемости
        Div({
            style {
                position(Position.Absolute)
                top(0.px)
                left(0.px)
                right(0.px)
                bottom(0.px)
                background("linear-gradient(to bottom, rgba(0,0,0,0.1), rgba(0,0,0,0.3))")
            }
        })
    }
}
