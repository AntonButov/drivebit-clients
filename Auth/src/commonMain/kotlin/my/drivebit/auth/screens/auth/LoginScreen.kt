package my.drivebit.auth.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import my.drivebit.ui.theme.DrivebitTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
// menuAnchor() extension comes from ExposedDropdownMenuBoxScope
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import my.drivebit.ui.components.ApplicationTopBar
import org.jetbrains.compose.ui.tooling.preview.Preview

private data class Country(
    val name: String,
    val dialCode: String,
)

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                ApplicationTopBar(
                    title = "Log In",
                    onBackClick = { navigator.pop() },
                )
            },
        ) { paddingValues ->
            LoginScreenContent(
                modifier = Modifier.padding(paddingValues),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreenContent(modifier: Modifier = Modifier) {
    val countries =
        remember {
            listOf(
                Country("Russia", "+7"),
                Country("United States", "+1"),
                Country("Kazakhstan", "+7"),
            )
        }
    var countryExpanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf(countries.first()) }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        // Country code dropdown
        ExposedDropdownMenuBox(
            expanded = countryExpanded,
            onExpandedChange = { countryExpanded = !countryExpanded },
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = "${selectedCountry.name} ${selectedCountry.dialCode}",
                onValueChange = {},
                label = { Text("Country Code") },
                readOnly = true,
                singleLine = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = countryExpanded) },
                modifier =
                    Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surface),
                enabled = true,
            )
            DropdownMenu(
                expanded = countryExpanded,
                onDismissRequest = { countryExpanded = false },
            ) {
                countries.forEach { country ->
                    DropdownMenuItem(text = { Text("${country.name} ${country.dialCode}") }, onClick = {
                        selectedCountry = country
                        countryExpanded = false
                    })
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { newValue ->
                val digitsOnly = newValue.filter { it.isDigit() }
                phone = formatPhoneNumber(digitsOnly)
            },
            label = { Text("Phone Number") },
            placeholder = { Text("Phone Number") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier =
                Modifier
                    .fillMaxWidth(),
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "We'll send you a confirmation code",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

private fun formatPhoneNumber(digits: String): String =
    when {
        digits.length <= 3 -> digits
        digits.length <= 6 -> "${digits.substring(0, 3)}-${digits.substring(3)}"
        else -> "${digits.substring(0, 3)}-${digits.substring(3, 6)}-${digits.substring(6, minOf(10, digits.length))}"
    }

@Composable
@Preview
fun LoginScreenPreview() {
    DrivebitTheme {
        LoginScreenContent()
    }
}
