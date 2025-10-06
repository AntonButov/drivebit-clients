package my.drivebit.clients.ui.icons

import androidx.compose.ui.graphics.vector.ImageVector

// Re-export all icons from their individual files
// This maintains backward compatibility while organizing icons into separate files

// Import all individual icon functions
import my.drivebit.clients.ui.icons.SearchIcon as SearchIconImpl
import my.drivebit.clients.ui.icons.FavoriteIcon as FavoriteIconImpl
import my.drivebit.clients.ui.icons.TripIcon as TripIconImpl
import my.drivebit.clients.ui.icons.InboxIcon as InboxIconImpl
import my.drivebit.clients.ui.icons.MoreIcon as MoreIconImpl
import my.drivebit.clients.ui.icons.ArrowBackIcon as ArrowBackIconImpl

// Custom icons using Compose Drawable
object Icons {
    val SearchIcon: ImageVector
        get() = SearchIconImpl()

    val FavoriteIcon: ImageVector
        get() = FavoriteIconImpl()

    val TripIcon: ImageVector
        get() = TripIconImpl()

    val InboxIcon: ImageVector
        get() = InboxIconImpl()

    val MoreIcon: ImageVector
        get() = MoreIconImpl()

    val ArrowBackIcon: ImageVector
        get() = ArrowBackIconImpl()
}
