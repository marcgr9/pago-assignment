package ro.marc.pago.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ro.marc.pago.R

class MainActivity: AppCompatActivity() {

    var navController: NavController? = null
        private set

    var hasLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { !hasLoaded }

        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController

        findViewById<ImageView>(R.id.icon).setOnClickListener {
            onBackPressed()
        }
    }

    fun configureHeader(text: String?) {
        if (text == null) {
            findViewById<ConstraintLayout>(R.id.header).visibility = View.INVISIBLE
            return
        }

        findViewById<ConstraintLayout>(R.id.header).visibility = View.VISIBLE
        findViewById<TextView>(R.id.title).text = text
    }

}
