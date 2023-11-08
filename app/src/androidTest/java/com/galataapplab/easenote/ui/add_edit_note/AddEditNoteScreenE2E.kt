package com.galataapplab.easenote.ui.add_edit_note

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.galataapplab.easenote.core.ui.MainActivity
import com.galataapplab.easenote.core.ui.navigation.Navigation
import com.galataapplab.easenote.core.ui.theme.EaseNoteTheme
import com.galataapplab.easenote.core.util.Routes
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class AddEditNoteScreenE2E {
    private lateinit var navController: NavHostController

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            EaseNoteTheme {
                val scaffoldState = rememberScaffoldState()
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Navigation(navController = navController, scaffoldState = scaffoldState)
                }
            }
        }
    }

    @Test
    fun toolbar_navigate_back_work_properly() {
        composeRule.onNodeWithContentDescription("Add note").performClick()
        composeRule.onNodeWithContentDescription("navigate back").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Routes.HOME)
        ).isTrue()
    }

}
