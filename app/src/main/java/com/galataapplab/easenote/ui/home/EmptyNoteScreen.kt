package com.galataapplab.easenote.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.galataapplab.easenote.R
import com.galataapplab.easenote.core.ui.theme.LocalSpacing

@Composable
fun EmptyNoteScreen(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_bg_empty_list), contentDescription = null
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Text(
            text = stringResource(R.string.it_s_empty),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface,
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
        Text(
            text = stringResource(R.string.no_notes),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSurface,
        )
    }
}