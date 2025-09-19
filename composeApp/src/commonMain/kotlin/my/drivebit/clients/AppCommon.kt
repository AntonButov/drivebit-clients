package my.drivebit.clients

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import drivebitclients.composeapp.generated.resources.Res
import drivebitclients.composeapp.generated.resources.drivebitstub
import drivebitclients.composeapp.generated.resources.soon
import my.drivebit.clients.theme.DrivebitTheme

// Единственная expect функция для всех платформ
@Composable
expect fun App()