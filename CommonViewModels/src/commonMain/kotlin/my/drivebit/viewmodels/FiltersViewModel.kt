package my.drivebit.viewmodels

import com.russhwolf.settings.Settings
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

class FiltersViewModel(
    private val settings: Settings
) {
    private val defaultFilters = listOf(
        FilterItem(
            icon = "https://antonbutov.github.io/drivebit-clients/images/filter-main/airplane.svg",
            title = "Все",
            backgroundIcon = "2",
        ),
        FilterItem(
            icon = "https://antonbutov.github.io/drivebit-clients/images/filter-main/airplane.svg",
            title = "Airports",
            backgroundIcon = "3",
        ),
    )
    
    private val _state = MutableStateFlow(loadStateFromSettings())

    val state
        get() = _state.asStateFlow()

    private fun loadStateFromSettings(): FilterScreenState {
        val savedSelected = settings.getString("selected_filter", "Все")
        return FilterScreenState(
            selected = savedSelected,
            filters = defaultFilters
        )
    }

    fun onSelect(title: String) {
        _state.update { it.copy(selected = title) }
        // ✅ Сохраняем в настройки (переживет перезагрузку страницы)
        settings.putString("selected_filter", title)
    }
}
