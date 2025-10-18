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
            src = "$imageUrl/menu/burger.svg",
            alt = "Menu",
            attrs = {
                style {
                    width(26.px)
                    height(26.px)
                }
            },
        )

        Img(
            src = iconUserViewModel.userIconUrl,
            alt = "User",
            attrs = {
                style {
                    width(26.px)
                    height(26.px)
                    borderRadius(50.percent)
                }
            },
        )
    }
}
