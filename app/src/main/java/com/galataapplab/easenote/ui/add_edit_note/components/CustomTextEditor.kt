package com.galataapplab.easenote.ui.add_edit_note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.testTag
import com.galataapplab.easenote.core.ui.theme.Shapes
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.BasicRichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorDefaults

@Composable
fun CustomTextEditor(
    richTextState: RichTextState, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        BasicRichTextEditor(
            state = richTextState,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("custom text editor")
            ,
            textStyle = MaterialTheme.typography.h2,
        )
        if (richTextState.annotatedString.isEmpty()) {
            Text(
                text = "type here..", style = MaterialTheme.typography.h2, color = Color(0X803A3A3A)
            )
        }
    }

}