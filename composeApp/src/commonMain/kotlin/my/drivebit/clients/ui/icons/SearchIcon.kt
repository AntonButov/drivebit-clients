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

fun SearchIcon(): ImageVector =
    ImageVector
        .Builder(
            name = "Search",
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
                moveTo(409.65f, 665.0f)
                quadToRelative(106.93f, 0.0f, 181.14f, -74.56f)
                quadTo(665.0f, 515.87f, 665.0f, 409.35f)
                quadToRelative(0.0f, -106.93f, -74.32f, -181.64f)
                quadTo(516.35f, 153.0f, 410.18f, 153.0f)
                quadTo(304.0f, 153.0f, 229.0f, 227.53f)
                reflectiveQuadToRelative(-75.0f, 181.0f)
                quadTo(154.0f, 515.0f, 228.56f, 590.0f)
                quadToRelative(74.57f, 75.0f, 181.09f, 75.0f)
                close()
                moveTo(369.0f, 505.0f)
                lineToRelative(174.0f, -174.0f)
                lineToRelative(-15.0f, -16.0f)
                lineToRelative(-159.0f, 159.0f)
                lineToRelative(-80.0f, -81.0f)
                lineToRelative(-16.0f, 16.0f)
                lineToRelative(96.0f, 96.0f)
                close()
                moveTo(410.0f, 687.0f)
                quadToRelative(-115.0f, 0.0f, -196.5f, -81.5f)
                reflectiveQuadToRelative(-81.5f, -197.0f)
                quadTo(132.0f, 293.0f, 213.5f, 212.0f)
                reflectiveQuadToRelative(197.0f, -81.0f)
                quadToRelative(115.5f, 0.0f, 196.0f, 81.5f)
                reflectiveQuadTo(687.0f, 409.0f)
                quadToRelative(0.0f, 53.83f, -19.33f, 102.33f)
                reflectiveQuadTo(614.0f, 597.0f)
                lineToRelative(214.0f, 214.0f)
                lineToRelative(-15.0f, 17.0f)
                lineToRelative(-215.0f, -215.0f)
                quadToRelative(-37.42f, 34.96f, -85.51f, 54.48f)
                quadTo(464.4f, 687.0f, 410.0f, 687.0f)
                close()
                moveTo(410.0f, 409.0f)
                close()
            }
        }.build()

@Composable
@Preview
fun SearchIconPreview() {
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
                text = "Search Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = SearchIcon(),
                contentDescription = "Search",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}
