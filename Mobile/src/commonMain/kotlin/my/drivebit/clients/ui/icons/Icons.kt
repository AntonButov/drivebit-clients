package my.drivebit.clients.ui.icons

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Icons {
    val SearchIcon: ImageVector
        get() =
            ImageVector
                .Builder(
                    name = "search",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        fill = null,
                        strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Round,
                        strokeLineWidth = 2f,
                        pathBuilder = {
                            moveTo(21f, 21f)
                            lineTo(16.65f, 16.65f)
                            moveTo(19f, 11f)
                            arcTo(8f, 8f, 0f, true, true, 11f, 3f)
                            arcTo(8f, 8f, 0f, true, true, 19f, 11f)
                            close()
                        },
                    )
                }.build()

    val FavoriteIcon: ImageVector
        get() =
            ImageVector
                .Builder(
                    name = "favorite",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        fill = null,
                        strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Round,
                        strokeLineWidth = 2f,
                        pathBuilder = {
                            moveTo(20.84f, 4.61f)
                            arcTo(5.5f, 5.5f, 0f, false, false, 7.5f, 4.61f)
                            arcTo(5.5f, 5.5f, 0f, false, false, 20.84f, 4.61f)
                            close()
                            moveTo(12f, 21f)
                            lineTo(7.5f, 16.5f)
                            arcTo(5.5f, 5.5f, 0f, false, true, 7.5f, 4.61f)
                        },
                    )
                }.build()

    val TripIcon: ImageVector
        get() =
            ImageVector
                .Builder(
                    name = "trip",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        fill = null,
                        strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Round,
                        strokeLineWidth = 2f,
                        pathBuilder = {
                            moveTo(3f, 12f)
                            lineTo(21f, 12f)
                            moveTo(12f, 3f)
                            lineTo(12f, 21f)
                        },
                    )
                }.build()

    val InboxIcon: ImageVector
        get() =
            ImageVector
                .Builder(
                    name = "inbox",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        fill = null,
                        strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Round,
                        strokeLineWidth = 2f,
                        pathBuilder = {
                            moveTo(4f, 4f)
                            horizontalLineTo(20f)
                            verticalLineTo(20f)
                            horizontalLineTo(4f)
                            close()
                            moveTo(4f, 4f)
                            lineTo(12f, 12f)
                            lineTo(20f, 4f)
                        },
                    )
                }.build()

    val MoreIcon: ImageVector
        get() =
            ImageVector
                .Builder(
                    name = "more",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                ).apply {
                    path(
                        fill = null,
                        strokeLineCap = androidx.compose.ui.graphics.StrokeCap.Round,
                        strokeLineWidth = 2f,
                        pathBuilder = {
                            moveTo(12f, 12f)
                            moveTo(19f, 12f)
                            moveTo(5f, 12f)
                        },
                    )
                }.build()
}
