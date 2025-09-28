package my.drivebit.clients.screens.main.searchbackground

import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.model.StateScreenModel
import my.drivebit.clients.ui.icons.Icons

sealed interface SearchBackGroundState {
    val icon: String
    val nameId: Int
    val backGroundIcon: ImageVector
    val searchScreen: String
}

data class All(
    override val icon: String = "",
    override val nameId: Int = 1,
    override val backGroundIcon: ImageVector = Icons.SearchIcon,
    override val searchScreen: String = "",
) : SearchBackGroundState

data class AirPort(
    override val icon: String,
    override val nameId: Int = 2,
    override val backGroundIcon: ImageVector = Icons.SearchIcon,
    override val searchScreen: String = "",
) : SearchBackGroundState

class SearchBackGroundViewModel : StateScreenModel<SearchBackGroundState>(All())
