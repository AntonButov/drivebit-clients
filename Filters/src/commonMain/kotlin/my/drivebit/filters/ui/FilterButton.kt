package my.drivebit.filters.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import drivebitclients.filters.generated.resources.Res
import drivebitclients.filters.generated.resources.filter_airports
import drivebitclients.filters.generated.resources.filter_all
import my.drivebit.filters.ui.icons.AirportsIcon
import my.drivebit.filters.ui.icons.AllIcon
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FilterButton(
    title: StringResource,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor =
        if (isSelected) {
            Color.Black
        } else {
            Color.White
        }

    val textColor =
        if (isSelected) {
            Color.White
        } else {
            Color.Black
        }

    val iconTint =
        if (isSelected) {
            Color.White
        } else {
            Color.Black
        }

    val borderColor =
        if (isSelected) {
            Color.Black
        } else {
            Color.Gray
        }

    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(8.dp))
                .background(backgroundColor)
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(8.dp),
                ).clickable { onClick() }
                .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(20.dp),
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(title),
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun FilterButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Selected state
        FilterButton(
            title = Res.string.filter_all,
            icon = AllIcon,
            isSelected = true,
            onClick = { },
        )

        // Unselected state
        FilterButton(
            title = Res.string.filter_airports,
            icon = AirportsIcon,
            isSelected = false,
            onClick = { },
        )
    }
}
