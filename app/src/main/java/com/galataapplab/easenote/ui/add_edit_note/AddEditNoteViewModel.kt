package com.galataapplab.easenote.ui.add_edit_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(AddEditNoteState())
        private set

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.OnTittleChange -> {
                state = state.copy(
                    title = event.newTitle,
                    isTitleHintVisible = event.newTitle.isEmpty()
                )
            }
        }
    }

}