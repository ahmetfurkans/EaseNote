package com.galataapplab.easenote.ui.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.galataapplab.easenote.core.ui.theme.LocalSpacing
import com.galataapplab.easenote.core.ui.theme.Shapes
import com.galataapplab.easenote.core.util.removeHtmlTags
import com.galataapplab.easenote.domain.model.Note

@SuppressLint("UnrememberedMutableState")
@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    navigateToEditNote: () -> Unit,
    onDeleteClick: () -> Unit
) {

    val spacing = LocalSpacing.current
    val content = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        val htmlContent = note.content
        val cleanedContent = removeHtmlTags(htmlContent)
        content.value = cleanedContent
    }

    Column(modifier = modifier
        .fillMaxWidth()
        .clickable {
            navigateToEditNote()
        }
        .border(width = 1.dp, color = Color(0xFFEEEEEE), shape = Shapes.small)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = spacing.spaceSmall, end = spacing.spaceSmall, top = spacing.spaceSmall
                ), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface
            )
            Icon(
                modifier = Modifier.clickable { onDeleteClick() },
                imageVector = Icons.Default.Delete,
                contentDescription = "delete button",
                tint = MaterialTheme.colors.onSurface
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = spacing.spaceSmall
                )
                .background(Color(0XFFEEEEEE))
                .height(1.dp)
        )
        Text(
            modifier = Modifier.padding(spacing.spaceMedium),
            text = content.value,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface,
            maxLines = 1
        )
    }
}