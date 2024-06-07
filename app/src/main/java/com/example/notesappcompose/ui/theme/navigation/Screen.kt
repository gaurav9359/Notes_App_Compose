package com.example.notesappcompose.ui.theme.navigation

sealed class Screen(val route:String) {
    object MainScreen:Screen("main_screen")
    object EditScreen:Screen("edit_screen")
}