package my.drivebit.clients.ui.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

// Re-export all icons from their individual files
// This maintains backward compatibility while organizing icons into separate files

// Import all individual icon functions
import my.drivebit.clients.ui.icons.SearchIcon as SearchIconImpl
import my.drivebit.clients.ui.icons.FavoriteIcon as FavoriteIconImpl
import my.drivebit.clients.ui.icons.TripIcon as TripIconImpl
import my.drivebit.clients.ui.icons.InboxIcon as InboxIconImpl
import my.drivebit.clients.ui.icons.MoreIcon as MoreIconImpl
import my.drivebit.clients.ui.icons.RoadIcon as RoadIconImpl

// Custom icons using Compose Drawable
object Icons {
    val SearchIcon: ImageVector
        @Composable get() = SearchIconImpl()

    val FavoriteIcon: ImageVector
        @Composable get() = FavoriteIconImpl()

    val TripIcon: ImageVector
        @Composable get() = TripIconImpl()

    val InboxIcon: ImageVector
        @Composable get() = InboxIconImpl()

    val MoreIcon: ImageVector
        @Composable get() = MoreIconImpl()

    val RoadIcon: ImageVector
        @Composable get() = RoadIconImpl()
}
