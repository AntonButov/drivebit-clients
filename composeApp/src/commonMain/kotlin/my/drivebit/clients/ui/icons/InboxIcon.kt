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

fun InboxIcon(): ImageVector =
    ImageVector
        .Builder(
            name = "Message",
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
                moveTo(696.0f, 763.0f)
                lineTo(594.0f, 660.0f)
                lineToRelative(15.0f, -14.0f)
                lineToRelative(87.0f, 86.0f)
                lineToRelative(172.0f, -172.0f)
                lineToRelative(15.0f, 16.0f)
                lineToRelative(-187.0f, 187.0f)
                close()
                moveTo(132.0f, 780.0f)
                verticalLineToRelative(-594.0f)
                quadToRelative(0.0f, -22.78f, 15.61f, -38.39f)
                quadTo(163.23f, 132.0f, 186.0f, 132.0f)
                horizontalLineToRelative(588.0f)
                quadToRelative(22.78f, 0.0f, 38.39f, 15.61f)
                reflectiveQuadTo(828.0f, 186.0f)
                verticalLineToRelative(283.0f)
                horizontalLineToRelative(-22.0f)
                verticalLineToRelative(-283.0f)
                quadToRelative(0.0f, -12.0f, -10.0f, -22.0f)
                reflectiveQuadToRelative(-22.0f, -10.0f)
                lineTo(186.0f, 154.0f)
                quadToRelative(-12.0f, 0.0f, -22.0f, 10.0f)
                reflectiveQuadToRelative(-10.0f, 22.0f)
                verticalLineToRelative(542.0f)
                lineToRelative(80.0f, -82.0f)
                horizontalLineToRelative(275.0f)
                verticalLineToRelative(22.0f)
                lineTo(244.0f, 668.0f)
                lineTo(132.0f, 780.0f)
                close()
                moveTo(154.0f, 646.0f)
                verticalLineToRelative(72.0f)
                verticalLineToRelative(-564.0f)
                verticalLineToRelative(492.0f)
                close()
            }
        }.build()

@Composable
@Preview
fun InboxIconPreview() {
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
                text = "Inbox Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = InboxIcon(),
                contentDescription = "Inbox",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}
