package com.dating.mingle.vm

import android.app.Application
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dating.mingle.MainActivity
import com.dating.mingle.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val app:Application
) :ViewModel(){

    /**
     * Creates and registers a dynamic shortcut for launching the main activity.
     *
     * @param shortcutManager The [ShortcutManager] instance used to manage shortcuts.
     */
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    fun showShortCut(shortcutManager: ShortcutManager){
        viewModelScope.launch {

            // Create an explicit intent to launch the main activity
            val intent = Intent(app, MainActivity::class.java)
            intent.action = Intent.ACTION_MAIN
            intent.addCategory(Intent.CATEGORY_LAUNCHER)

            // Create a ShortcutInfo object to define the shortcut's properties
            val shortcutInfo = ShortcutInfo.Builder(app,"1D1")
                .setShortLabel("Home Page")
                .setLongLabel("Open app")
                .setIcon(
                    Icon.createWithResource(app,R.drawable.splash_imagesplash))
                .setIntent(intent)
                .build()

            // Add the shortcut to the list
            val list = mutableListOf<ShortcutInfo>()
            list.add(shortcutInfo)

            // Register the dynamic shortcut
            shortcutManager.addDynamicShortcuts(list)
        }

    }
}