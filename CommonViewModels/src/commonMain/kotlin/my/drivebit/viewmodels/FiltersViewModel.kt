package my.drivebit.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class FilterItem(
    val icon: String,
    val title: String,
    val backgroundIcon: String,
)

data class FilterScreenState(
    val selected: String,
    val filters: List<FilterItem>,
)

class FiltersViewModel {
    private val _state =
        MutableStateFlow(
            FilterScreenState(
                selected = "Все",
                filters =
                    listOf(
                        FilterItem(
                            icon = "https://github.com/AntonButov/drivebit-clients/blob/trunk/images/logos/logo.png",
                            title = "Все",
                            backgroundIcon = "2",
                        ),
                        FilterItem(
                            icon = "https://github.com/AntonButov/drivebit-clients/blob/trunk/images/logos/logo.png",
                            title = "Airports",
                            backgroundIcon = "3",
                        ),
                    ),
            ),
        )

    val state
        get() = _state.asStateFlow()

    fun onSelect(title: String) {
        _state.update { it.copy(selected = title) }
    }
}
