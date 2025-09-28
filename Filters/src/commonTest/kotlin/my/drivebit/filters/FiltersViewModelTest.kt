package my.drivebit.filters

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class FiltersViewModelTest {
    @Test
    fun `initial state should have correct selected filter`() {
        val viewModel = FiltersViewModel()
        val initialState = viewModel.state.value

        assertEquals(FilterAll().title, initialState.selected)
        assertEquals(6, initialState.filters.size)
        assertNotNull(initialState.filters.find { it is FilterAll })
        assertNotNull(initialState.filters.find { it is FilterAirports })
        assertNotNull(initialState.filters.find { it is FilterMonthly })
        assertNotNull(initialState.filters.find { it is FilterNearby })
        assertNotNull(initialState.filters.find { it is FilterDelivered })
        assertNotNull(initialState.filters.find { it is FilterCities })
    }

    @Test
    fun `onSelect should update selected filter when selecting All`() {
        val viewModel = FiltersViewModel()
        val allFilter = FilterAll()

        viewModel.onSelect(allFilter.title)

        assertEquals(allFilter.title, viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should update selected filter when selecting Airports`() {
        val viewModel = FiltersViewModel()
        val airportsFilter = FilterAirports()

        viewModel.onSelect(airportsFilter.title)

        assertEquals(airportsFilter.title, viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should handle multiple selections correctly`() {
        val viewModel = FiltersViewModel()
        val allFilter = FilterAll()
        val airportsFilter = FilterAirports()

        // Select All first
        viewModel.onSelect(allFilter.title)
        assertEquals(allFilter.title, viewModel.state.value.selected)

        // Then select Airports
        viewModel.onSelect(airportsFilter.title)
        assertEquals(airportsFilter.title, viewModel.state.value.selected)

        // Back to All
        viewModel.onSelect(allFilter.title)
        assertEquals(allFilter.title, viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should maintain filters list unchanged`() {
        val viewModel = FiltersViewModel()
        val initialFilters = viewModel.state.value.filters

        viewModel.onSelect(FilterAirports().title)

        assertEquals(initialFilters.size, viewModel.state.value.filters.size)
        assertEquals(initialFilters, viewModel.state.value.filters)
    }
}
