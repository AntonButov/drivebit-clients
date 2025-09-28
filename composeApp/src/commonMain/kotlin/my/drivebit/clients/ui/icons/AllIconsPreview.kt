package my.drivebit.clients.ui.icons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import my.drivebit.clients.theme.DrivebitTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

data class IconInfo(
    val name: String,
    val icon: @Composable () -> androidx.compose.ui.graphics.vector.ImageVector,
    val description: String,
)

@Composable
fun AllIconsPreview(modifier: Modifier = Modifier) {
    val icons =
        listOf(
            IconInfo("Search", { SearchIcon() }, "Search functionality"),
            IconInfo("Favorite", { FavoriteIcon() }, "Favorites tab"),
            IconInfo("Trip", { TripIcon() }, "Trips tab"),
            IconInfo("Inbox", { InboxIcon() }, "Inbox tab"),
            IconInfo("More", { MoreIcon() }, "More options"),
            IconInfo("Road", { RoadIcon() }, "Road navigation"),
            IconInfo("Arrow Back", { ArrowBackIcon() }, "Back navigation"),
        )

    LazyColumn(
        modifier =
            modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Text(
                text = "All Icons Preview",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp),
            )
        }

        items(icons.chunked(2)) { iconRow ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                iconRow.forEach { iconInfo ->
                    IconCard(
                        iconInfo = iconInfo,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun IconCard(
    iconInfo: IconInfo,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Icon(
                imageVector = iconInfo.icon(),
                contentDescription = iconInfo.description,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary,
            )

            Text(
                text = iconInfo.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Text(
                text = iconInfo.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
@Preview
fun AllIconsPreviewPreview() {
    DrivebitTheme {
        AllIconsPreview()
    }
}
