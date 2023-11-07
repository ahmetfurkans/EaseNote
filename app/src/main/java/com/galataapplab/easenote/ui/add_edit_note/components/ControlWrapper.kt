package com.galataapplab.easenote.ui.add_edit_note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatAlignLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.galataapplab.easenote.core.ui.theme.MidnightBlue
import com.galataapplab.easenote.core.ui.theme.Shapes

@Composable
fun ControlWrapper(
    selected: Boolean,
    selectedColor: Color = MidnightBlue,
    unselectedColor: Color = Color.Transparent,
    onChangeClick: (Boolean) -> Unit,
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String,
) {
    Box(modifier = Modifier
        .clip(Shapes.small)
        .clickable {
            onClick()
            onChangeClick(!selected)
        }
        .background(
            if (selected) selectedColor
            else unselectedColor
        )
        .padding(all = 8.dp), contentAlignment = Alignment.Center) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = if (selected) Color.White else MaterialTheme.colors.onSurface
        )
    }
}