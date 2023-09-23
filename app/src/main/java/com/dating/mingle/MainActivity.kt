package com.dating.mingle

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dating.mingle.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Declare the ShortcutManager for managing shortcuts.
    private lateinit var shortcutManager: ShortcutManager

    // Initialize the MainViewModel using viewModels from the AndroidX library
    private val viewModel by viewModels<MainViewModel>()

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        // Set the theme for the activity.
        setTheme(R.style.Base_Theme_Mingle)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ShortcutManager for creating dynamic shortcuts.
        shortcutManager = getSystemService(ShortcutManager::class.java)

        // Call the showShortCut method from the MainViewModel to create and show a dynamic shortcut menu.
        viewModel.showShortCut(shortcutManager)


    }

}