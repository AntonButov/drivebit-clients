package my.drivebit.clients.screens.main.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import drivebitclients.composeapp.generated.resources.Res
import drivebitclients.composeapp.generated.resources.trips
import my.drivebit.clients.theme.DrivebitTheme
import my.drivebit.clients.ui.icons.Icons
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

object TripsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = 2u,
                title = stringResource(Res.string.trips),
                icon = rememberVectorPainter(Icons.TripIcon),
            )
        }

    @Composable
    override fun Content() {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Trips Tab",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
@Preview
fun TripsTabPreview() {
    DrivebitTheme {
        TripsTab.Content()
    }
}
