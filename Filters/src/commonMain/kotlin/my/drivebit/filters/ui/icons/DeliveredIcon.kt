package my.drivebit.filters.ui.icons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

val DeliveredIcon: ImageVector =
    Builder(
        name = "Delivered",
        defaultWidth = 24.0.dp,
        defaultHeight = 24.0.dp,
        viewportWidth = 24.0f,
        viewportHeight = 24.0f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF000000)),
            stroke = null,
            strokeLineWidth = 0.0f,
            strokeLineCap = Butt,
            strokeLineJoin = Miter,
            strokeLineMiter = 4.0f,
            pathFillType = NonZero,
        ) {
            moveTo(8.0f, 5.0f)
            verticalLineTo(14.0f)
            lineTo(11.0f, 11.0f)
            lineTo(13.0f, 13.0f)
            lineTo(16.0f, 10.0f)
            verticalLineTo(5.0f)
            horizontalLineTo(8.0f)
            close()
        }
    }.build()

@Preview
@Composable
private fun DeliveredIconPreview() {
    Icon(
        imageVector = DeliveredIcon,
        contentDescription = "Delivered Icon",
    )
}
