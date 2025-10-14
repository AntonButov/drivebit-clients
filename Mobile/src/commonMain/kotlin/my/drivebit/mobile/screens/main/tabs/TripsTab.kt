package my.drivebit.mobile.screens.main.tabs

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
import my.drivebit.ui.icons.Icons
import my.drivebit.ui.theme.DrivebitTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

object TripsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return TabOptions(
                index = 2u,
                title = "Поездки",
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
                text = "Поездки",
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
