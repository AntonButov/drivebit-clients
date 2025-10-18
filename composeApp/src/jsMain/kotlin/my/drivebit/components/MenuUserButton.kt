package my.drivebit.components

import androidx.compose.runtime.Composable
import my.drivebit.viewmodels.IconUserViewModel
import my.drivebit.viewmodels.imageUrl
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Img
import org.koin.compose.koinInject

@Composable
fun MenuUserButton(onClick: () -> Unit) {
    val iconUserViewModel: IconUserViewModel = koinInject()

    UniversalButton(
        isSelected = false,
        onClick = onClick,
    ) {
        Img(
            src = "$imageUrl/burger.svg",
            alt = "Menu",
            attrs = {
                style {
                    width(20.px)
                    height(20.px)
                }
            },
        )

        Img(
            src = iconUserViewModel.userIconUrl,
            alt = "User",
            attrs = {
                style {
                    width(20.px)
                    height(20.px)
                    borderRadius(50.percent)
                }
            },
        )
    }
}
