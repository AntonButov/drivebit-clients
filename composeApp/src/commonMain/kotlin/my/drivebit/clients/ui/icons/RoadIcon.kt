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
fun RoadIcon(): ImageVector =
    ImageVector
        .Builder(
            name = "road",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4f,
                pathFillType = PathFillType.NonZero,
            ) {
                moveTo(18f, 4f)
                lineTo(16f, 4f)
                lineTo(16f, 2f)
                lineTo(18f, 2f)
                lineTo(18f, 4f)
                close()
                moveTo(18f, 6f)
                lineTo(16f, 6f)
                lineTo(16f, 8f)
                lineTo(18f, 8f)
                lineTo(18f, 6f)
                close()
                moveTo(18f, 10f)
                lineTo(16f, 10f)
                lineTo(16f, 12f)
                lineTo(18f, 12f)
                lineTo(18f, 10f)
                close()
                moveTo(18f, 14f)
                lineTo(16f, 14f)
                lineTo(16f, 16f)
                lineTo(18f, 16f)
                lineTo(18f, 14f)
                close()
                moveTo(18f, 18f)
                lineTo(16f, 18f)
                lineTo(16f, 20f)
                lineTo(18f, 20f)
                lineTo(18f, 18f)
                close()
                moveTo(14f, 4f)
                lineTo(10f, 4f)
                lineTo(10f, 2f)
                lineTo(14f, 2f)
                lineTo(14f, 4f)
                close()
                moveTo(14f, 6f)
                lineTo(10f, 6f)
                lineTo(10f, 8f)
                lineTo(14f, 8f)
                lineTo(14f, 6f)
                close()
                moveTo(14f, 10f)
                lineTo(10f, 10f)
                lineTo(10f, 12f)
                lineTo(14f, 12f)
                lineTo(14f, 10f)
                close()
                moveTo(14f, 14f)
                lineTo(10f, 14f)
                lineTo(10f, 16f)
                lineTo(14f, 16f)
                lineTo(14f, 14f)
                close()
                moveTo(14f, 18f)
                lineTo(10f, 18f)
                lineTo(10f, 20f)
                lineTo(14f, 20f)
                lineTo(14f, 18f)
                close()
                moveTo(8f, 4f)
                lineTo(6f, 4f)
                lineTo(6f, 2f)
                lineTo(8f, 2f)
                lineTo(8f, 4f)
                close()
                moveTo(8f, 6f)
                lineTo(6f, 6f)
                lineTo(6f, 8f)
                lineTo(8f, 8f)
                lineTo(8f, 6f)
                close()
                moveTo(8f, 10f)
                lineTo(6f, 10f)
                lineTo(6f, 12f)
                lineTo(8f, 12f)
                lineTo(8f, 10f)
                close()
                moveTo(8f, 14f)
                lineTo(6f, 14f)
                lineTo(6f, 16f)
                lineTo(8f, 16f)
                lineTo(8f, 14f)
                close()
                moveTo(8f, 18f)
                lineTo(6f, 18f)
                lineTo(6f, 20f)
                lineTo(8f, 20f)
                lineTo(8f, 18f)
                close()
            }
        }.build()

@Composable
@Preview
fun RoadIconPreview() {
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
                text = "Road Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = RoadIcon(),
                contentDescription = "Road",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary,
            )
        }
    }
}
