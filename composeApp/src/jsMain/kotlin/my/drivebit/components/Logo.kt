package my.drivebit.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Img

@Composable
fun Logo() {
    Img(
        src = "https://antonbutov.github.io/drivebit-clients/images/logos/turo_logo.svg",
        alt = "Drive bit Logo",
        attrs = {
            style {
                width(120.px)
                height(32.px)
                property("object-fit", "contain")
                property("transition", "all 0.3s ease")
                property("max-width", "120px")
                property("max-height", "32px")
            }
            classes("turo-logo")
        },
    )
}
