package my.drivebit.filters

import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.model.StateScreenModel
import drivebitclients.filters.generated.resources.*
import my.drivebit.filters.ui.icons.Icons

sealed interface FilterItem {
    val icon: ImageVector
    val title: String
    val backgroundIcon: String
}

data class FilterAll(
    override val icon: ImageVector = Icons.AllIcon,
    override val title: String = "Все",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterAirports(
    override val icon: ImageVector = Icons.AirportsIcon,
    override val title: String = "Аэропорты",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterMonthly(
    override val icon: ImageVector = Icons.MonthlyIcon,
    override val title: String = "Месяц",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterNearby(
    override val icon: ImageVector = Icons.NearbyIcon,
    override val title: String = "Рядом",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterDelivered(
    override val icon: ImageVector = Icons.DeliveredIcon,
    override val title: String = "C доставкой",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterCities(
    override val icon: ImageVector = Icons.CitiesIcon,
    override val title: String = "Города",
    override val backgroundIcon: String = "2",
) : FilterItem

data class FilterScreenState(
    val selected: String,
    val filters: List<FilterItem>,
)

class FiltersViewModel :
    StateScreenModel<FilterScreenState>(
        FilterScreenState(
            selected = FilterAll().title,
            filters =
                listOf(
                    FilterAll(),
                    FilterAirports(),
                    FilterMonthly(),
                    FilterNearby(),
                    FilterDelivered(),
                    FilterCities(),
                ),
        ),
    ) {
    fun onSelect(title: String) {
        mutableState.value = mutableState.value.copy(selected = title)
    }
}
