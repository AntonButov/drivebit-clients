package my.drivebit.clients.ui.icons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

fun FavoriteIcon(): ImageVector =
    ImageVector
        .Builder(
            name = "Favorite",
            defaultWidth = 48.0.dp,
            defaultHeight = 48.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1f1f1f)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveToRelative(480.0f, 770.0f)
                lineToRelative(-17.0f, -16.0f)
                quadToRelative(-98.77f, -90.12f, -162.88f, -154.56f)
                quadTo(236.0f, 535.0f, 198.5f, 486.5f)
                reflectiveQuadToRelative(-52.0f, -87.17f)
                quadTo(132.0f, 360.66f, 132.0f, 323.0f)
                quadToRelative(0.0f, -69.72f, 47.5f, -117.36f)
                reflectiveQuadTo(297.0f, 158.0f)
                quadToRelative(54.0f, 0.0f, 100.5f, 30.0f)
                reflectiveQuadToRelative(82.5f, 88.0f)
                quadToRelative(38.0f, -59.0f, 83.36f, -88.5f)
                quadTo(608.71f, 158.0f, 663.0f, 158.0f)
                quadToRelative(70.0f, 0.0f, 117.5f, 47.64f)
                reflectiveQuadTo(828.0f, 323.0f)
                quadToRelative(0.0f, 37.66f, -14.5f, 76.33f)
                reflectiveQuadToRelative(-51.89f, 86.95f)
                quadTo(724.23f, 534.57f, 660.0f, 599.22f)
                quadTo(595.77f, 663.88f, 497.0f, 754.0f)
                lineToRelative(-17.0f, 16.0f)
                close()
                moveTo(480.0f, 740.0f)
                quadToRelative(97.29f, -88.55f, 160.13f, -151.66f)
                quadToRelative(62.83f, -63.1f, 99.85f, -110.22f)
                quadTo(777.0f, 431.0f, 791.5f, 394.71f)
                reflectiveQuadToRelative(14.5f, -71.57f)
                quadTo(806.0f, 262.0f, 765.0f, 221.0f)
                reflectiveQuadToRelative(-101.78f, -41.0f)
                quadToRelative(-50.52f, 0.0f, -91.87f, 29.0f)
                reflectiveQuadTo(490.0f, 302.0f)
                horizontalLineToRelative(-20.0f)
                quadToRelative(-41.0f, -64.0f, -82.33f, -93.0f)
                reflectiveQuadToRelative(-90.89f, -29.0f)
                quadTo(237.0f, 180.0f, 195.5f, 221.0f)
                reflectiveQuadTo(154.0f, 323.65f)
                quadToRelative(0.0f, 34.96f, 14.66f, 71.19f)
                quadToRelative(14.66f, 36.24f, 51.0f, 83.2f)
                reflectiveQuadTo(319.5f, 588.0f)
                quadTo(383.0f, 651.0f, 480.0f, 740.0f)
                close()
                moveTo(480.0f, 460.0f)
                close()
            }
        }.build()

@Composable
@Preview
fun FavoriteIconPreview() {
    MaterialTheme {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Favorite Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = FavoriteIcon(),
                contentDescription = "Favorite",
                modifier = Modifier.size(48.dp),
                tint = Color.Red,
            )
        }
    }
}
