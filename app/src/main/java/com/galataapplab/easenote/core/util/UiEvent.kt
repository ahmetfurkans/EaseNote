package com.galataapplab.easenote.core.util
sealed class UiEvent {
    object Success: UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: String): UiEvent()
}