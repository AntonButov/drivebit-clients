package my.drivebit.viewmodels

import kotlin.test.Test
import kotlin.test.assertEquals

class FiltersViewModelTest {
    @Test
    fun `initial state should have correct selected filter`() {
        val viewModel = FiltersViewModel()
        val initialState = viewModel.state.value

        assertEquals("Все", initialState.selected)
        assertEquals(2, initialState.filters.size)
        assertEquals("Все", initialState.filters[0].title)
        assertEquals("Airports", initialState.filters[1].title)
    }

    @Test
    fun `onSelect should update selected filter when selecting All`() {
        val viewModel = FiltersViewModel()

        viewModel.onSelect("Все")

        assertEquals("Все", viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should update selected filter when selecting Airports`() {
        val viewModel = FiltersViewModel()

        viewModel.onSelect("Airports")

        assertEquals("Airports", viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should handle multiple selections correctly`() {
        val viewModel = FiltersViewModel()

        viewModel.onSelect("Все")
        assertEquals("Все", viewModel.state.value.selected)

        viewModel.onSelect("Airports")
        assertEquals("Airports", viewModel.state.value.selected)

        viewModel.onSelect("Все")
        assertEquals("Все", viewModel.state.value.selected)
    }

    @Test
    fun `onSelect should maintain filters list unchanged`() {
        val viewModel = FiltersViewModel()
        val initialFilters = viewModel.state.value.filters

        viewModel.onSelect("Airports")

        assertEquals(initialFilters.size, viewModel.state.value.filters.size)
        assertEquals(initialFilters, viewModel.state.value.filters)
    }
}
