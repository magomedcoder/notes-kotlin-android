package su.voo.notes.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import su.voo.notes.R
import android.widget.ImageView
import android.content.Intent

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val splashImage = findViewById<ImageView>(R.id.imageLogo)
        splashImage.alpha = 0f
        splashImage
            .animate()
            .setDuration(1500)
            .alpha(1f).withEndAction {
                val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(i)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
    }

}