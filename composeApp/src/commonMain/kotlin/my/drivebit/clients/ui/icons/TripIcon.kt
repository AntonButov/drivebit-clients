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
import my.drivebit.clients.theme.BlueRed
import org.jetbrains.compose.ui.tooling.preview.Preview

fun TripIcon(): ImageVector =
    ImageVector
        .Builder(
            name = "Trip",
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
                moveTo(212.0f, 748.0f)
                verticalLineToRelative(-536.0f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(536.0f)
                horizontalLineToRelative(-22.0f)
                close()
                moveTo(469.0f, 748.0f)
                verticalLineToRelative(-112.0f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(112.0f)
                horizontalLineToRelative(-22.0f)
                close()
                moveTo(726.0f, 748.0f)
                verticalLineToRelative(-536.0f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(536.0f)
                horizontalLineToRelative(-22.0f)
                close()
                moveTo(469.0f, 536.0f)
                verticalLineToRelative(-112.0f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(112.0f)
                horizontalLineToRelative(-22.0f)
                close()
                moveTo(469.0f, 324.0f)
                verticalLineToRelative(-112.0f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(112.0f)
                horizontalLineToRelative(-22.0f)
                close()
            }
        }.build()

@Composable
@Preview
fun TripIconPreview() {
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
                text = "Trip Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = TripIcon(),
                contentDescription = "Trip",
                modifier = Modifier.size(48.dp),
                tint = BlueRed,
            )
        }
    }
}
