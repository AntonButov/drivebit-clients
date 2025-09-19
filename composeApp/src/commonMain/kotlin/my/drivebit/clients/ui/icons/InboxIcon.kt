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
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun InboxIcon(): ImageVector {
    return ImageVector.Builder(
        name = "inbox",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
            path(fill = SolidColor(Color.Black), fillAlpha = 1f, stroke = null, strokeAlpha = 1f,
                strokeLineWidth = 1f, strokeLineCap = StrokeCap.Butt, strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4f, pathFillType = PathFillType.NonZero
            ) {
            moveTo(19f, 3f)
            lineTo(5f, 3f)
            curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f)
            lineTo(3f, 19f)
            curveTo(3f, 20.1f, 3.9f, 21f, 5f, 21f)
            lineTo(19f, 21f)
            curveTo(20.1f, 21f, 21f, 20.1f, 21f, 19f)
            lineTo(21f, 5f)
            curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f)
            close()
            moveTo(19f, 19f)
            lineTo(5f, 19f)
            lineTo(5f, 5f)
            lineTo(19f, 5f)
            lineTo(19f, 19f)
            close()
            moveTo(17f, 8f)
            lineTo(7f, 8f)
            lineTo(7f, 10f)
            lineTo(17f, 10f)
            lineTo(17f, 8f)
            close()
            moveTo(17f, 12f)
            lineTo(7f, 12f)
            lineTo(7f, 14f)
            lineTo(17f, 14f)
            lineTo(17f, 12f)
            close()
            moveTo(17f, 16f)
            lineTo(7f, 16f)
            lineTo(7f, 18f)
            lineTo(17f, 18f)
            lineTo(17f, 16f)
            close()
        }
    }.build()
}

@Composable
@Preview
fun InboxIconPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Inbox Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Icon(
                imageVector = InboxIcon(),
                contentDescription = "Inbox",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
