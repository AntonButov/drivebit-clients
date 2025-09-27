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
fun FavoriteIcon(): ImageVector {
    return ImageVector.Builder(
        name = "favorite",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
            path(fill = SolidColor(Color.Red), fillAlpha = 1f, stroke = null, strokeAlpha = 1f,
                strokeLineWidth = 1f, strokeLineCap = StrokeCap.Butt, strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 4f, pathFillType = PathFillType.NonZero
            ) {
            moveTo(12f, 21.35f)
            lineTo(10.55f, 20.03f)
            curveTo(5.4f, 15.36f, 2f, 12.27f, 2f, 8.5f)
            curveTo(2f, 5.41f, 4.42f, 3f, 7.5f, 3f)
            curveTo(9.24f, 3f, 10.91f, 3.81f, 12f, 5.08f)
            curveTo(13.09f, 3.81f, 14.76f, 3f, 16.5f, 3f)
            curveTo(19.58f, 3f, 22f, 5.41f, 22f, 8.5f)
            curveTo(22f, 12.27f, 18.6f, 15.36f, 13.45f, 20.03f)
            lineTo(12f, 21.35f)
            close()
        }
    }.build()
}

@Composable
@Preview
fun FavoriteIconPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Favorite Icon",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Icon(
                imageVector = FavoriteIcon(),
                contentDescription = "Favorite",
                modifier = Modifier.size(48.dp),
                tint = Color.Red
            )
        }
    }
}
