package com.galataapplab.easenote.ui.add_edit_note.components

import android.widget.Toolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuBoxScope
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.galataapplab.easenote.core.ui.theme.Shapes

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onSaveClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clickable {
                onNavigateUp()
            },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "navigate back",
            tint = MaterialTheme.colors.primary
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .clickable {
                    onSaveClick()
                }
                .background(Color.White)
                .padding(all = 8.dp), elevation = 4.dp) {
                Icon(
                    modifier = Modifier.padding(4.dp),
                    imageVector = Icons.Default.Save,
                    contentDescription = "save",
                    tint = Color.Black
                )
            }
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.Default.DensityMedium,
                contentDescription = "dropdown menu",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}