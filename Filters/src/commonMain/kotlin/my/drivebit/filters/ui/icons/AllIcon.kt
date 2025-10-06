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

val AllIcon: ImageVector =
    Builder(
        name = "All",
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
            moveTo(12.0f, 2.0f)
            lineTo(13.09f, 8.26f)
            lineTo(22.0f, 9.0f)
            lineTo(17.0f, 14.74f)
            lineTo(18.18f, 22.02f)
            lineTo(12.0f, 18.77f)
            lineTo(5.82f, 22.02f)
            lineTo(7.0f, 14.74f)
            lineTo(2.0f, 9.0f)
            lineTo(10.91f, 8.26f)
            lineTo(12.0f, 2.0f)
            close()
        }
    }.build()

@Preview
@Composable
private fun AllIconPreview() {
    Icon(
        imageVector = AllIcon,
        contentDescription = "All Icon",
    )
}
