package com.galataapplab.easenote.ui.add_edit_note.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatAlignCenter
import androidx.compose.material.icons.filled.FormatAlignLeft
import androidx.compose.material.icons.filled.FormatAlignRight
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material.icons.filled.FormatUnderlined
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamedrejeb.richeditor.model.RichTextState

@Composable
fun EditorControls(
    modifier: Modifier = Modifier,
    onBoldClick: () -> Unit,
    onItalicClick: () -> Unit,
    onUnderlineClick: () -> Unit,
    onStartAlignClick: () -> Unit,
    onListSelected: () -> Unit,
    onEndAlignClick: () -> Unit,
    onCenterAlignClick: () -> Unit,
) {
    var boldSelected by rememberSaveable { mutableStateOf(false) }
    var italicSelected by rememberSaveable { mutableStateOf(false) }
    var underlineSelected by rememberSaveable { mutableStateOf(false) }
    var listSelected by rememberSaveable { mutableStateOf(false) }
    var linkSelected by rememberSaveable { mutableStateOf(false) }
    var alignmentSelected by rememberSaveable { mutableIntStateOf(0) }
    var showLinkDialog by remember { mutableStateOf(false) }


    Card(modifier = modifier, elevation = 10.dp) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ControlWrapper(
                selected = alignmentSelected == 0,
                onChangeClick = { alignmentSelected = 0 },
                onClick = onStartAlignClick,
                imageVector = Icons.Default.FormatAlignLeft,
                contentDescription = "Start Align Control",
            )
            ControlWrapper(
                selected = alignmentSelected == 1,
                onChangeClick = { alignmentSelected = 1 },
                onClick = onCenterAlignClick,
                imageVector = Icons.Default.FormatAlignCenter,
                contentDescription = "Center Align Control",
            )
            ControlWrapper(
                selected = alignmentSelected == 2,
                onChangeClick = { alignmentSelected = 2 },
                onClick = onEndAlignClick,
                imageVector = Icons.Default.FormatAlignRight,
                contentDescription = "End Align Control"
            )
            ControlWrapper(
                selected = listSelected,
                onChangeClick = { listSelected = it },
                onClick = onListSelected,
                imageVector = Icons.Filled.List,
                contentDescription = "List Control",
            )
            ControlWrapper(
                selected = boldSelected,
                onChangeClick = { boldSelected = it },
                onClick = onBoldClick,
                imageVector = Icons.Filled.FormatBold,
                contentDescription = "Bold Control",
            )
            ControlWrapper(
                selected = italicSelected,
                onChangeClick = { italicSelected = it },
                onClick = onItalicClick,
                imageVector = Icons.Default.FormatItalic,
                contentDescription = "Italic Control",
            )
            ControlWrapper(
                selected = underlineSelected,
                onChangeClick = { underlineSelected = it },
                onClick = onUnderlineClick,
                imageVector = Icons.Default.FormatUnderlined,
                contentDescription = "Underline Control",
            )
        }
    }
}