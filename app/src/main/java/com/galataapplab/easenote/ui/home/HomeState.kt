package com.galataapplab.easenote.ui.home

import com.galataapplab.easenote.domain.model.Note

data class HomeState(
    val notes: List<Note> = emptyList()
)