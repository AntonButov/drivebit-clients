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
fun MoreIcon(): ImageVector {
    return ImageVector.Builder(
        name = "more",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
            path(fill = SolidColor(Color.Black), fillAlpha = 1f, stroke = null, strokeAlpha = 1f,
                strokeLineWidth = 1f, strokeLineCap = StrokeCap.Butt, strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4f, pathFillType = PathFillType.NonZero
            ) {
            moveTo(12f, 8f)
            curveTo(10.9f, 8f, 10f, 7.1f, 10f, 6f)
            curveTo(10f, 4.9f, 10.9f, 4f, 12f, 4f)
            curveTo(13.1f, 4f, 14f, 4.9f, 14f, 6f)
            curveTo(14f, 7.1f, 13.1f, 8f, 12f, 8f)
            close()
            moveTo(12f, 10f)
            curveTo(13.1f, 10f, 14f, 10.9f, 14f, 12f)
            curveTo(14f, 13.1f, 13.1f, 14f, 12f, 14f)
            curveTo(10.9f, 14f, 10f, 13.1f, 10f, 12f)
            curveTo(10f, 10.9f, 10.9f, 10f, 12f, 10f)
            close()
            moveTo(12f, 16f)
            curveTo(13.1f, 16f, 14f, 16.9f, 14f, 18f)
            curveTo(14f, 19.1f, 13.1f, 20f, 12f, 20f)
            curveTo(10.9f, 20f, 10f, 19.1f, 10f, 18f)
            curveTo(10f, 16.9f, 10.9f, 16f, 12f, 16f)
            close()
        }
    }.build()
}

@Composable
@Preview
fun MoreIconPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "More Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Icon(
                imageVector = MoreIcon(),
                contentDescription = "More",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
