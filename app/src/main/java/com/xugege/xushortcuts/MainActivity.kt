package com.xugege.xushortcuts

import android.content.pm.ShortcutManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

/**
 *  Shortcuts 分动态和静态，因鄙人嫌弃静态的，所以这里只用动态的做示范。
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 只能在安卓7之后试用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            getSystemService(ShortcutManager::class.java)
        };

    }


}
