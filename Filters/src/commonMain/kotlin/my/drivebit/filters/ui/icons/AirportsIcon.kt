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

val AirportsIcon: ImageVector =
    Builder(
        name = "Airports",
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
            moveTo(21.0f, 16.0f)
            verticalLineTo(14.0f)
            lineTo(13.0f, 9.0f)
            verticalLineTo(3.5f)
            arcTo(0.5f, 0.5f, 0.0f, false, false, 12.0f, 3.0f)
            horizontalLineTo(11.0f)
            verticalLineTo(9.0f)
            lineTo(3.0f, 14.0f)
            verticalLineTo(16.0f)
            lineTo(21.0f, 16.0f)
            close()
        }
    }.build()

@Preview
@Composable
private fun AirportsIconPreview() {
    Icon(
        imageVector = AirportsIcon,
        contentDescription = "Airports Icon",
    )
}
