package com.xugege.xushortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

/**
 *  Shortcuts 分动态和静态，因鄙人嫌弃静态的，所以这里只用动态的做示范。
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 只能在安卓7之后试用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {

            var intent = Intent(this,ContentActivity::class.java)
            intent.setAction(Intent.ACTION_VIEW);
            var intentThree = Intent(this,ThreeActivity::class.java)
            intentThree.setAction(Intent.ACTION_VIEW);
            var intentArray = arrayOf(intentThree,intent)


            var shortcutManager = getSystemService(ShortcutManager::class.java)
            var shortcut = ShortcutInfo.Builder(this, "xugege")
                .setShortLabel("打开")
                .setLongLabel("旭哥哥快捷操作")
                .setDisabledMessage("Disabled")
                .setIcon(
                    Icon.createWithResource(
                        applicationContext,
                        R.drawable.ic_launcher_background
                    )
                )
                .setIntent(intent)
                .setIntents(intentArray)
//                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trinea.cn/")))
                .build();


            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut)); //创建一个
            shortcutManager.updateShortcuts(Arrays.asList(shortcut)); //更新一个
//            shortcutManager.removeDynamicShortcuts(Arrays.asList("xugege")); //更新一个
        };

    }


}
