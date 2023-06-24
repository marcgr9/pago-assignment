package ro.marc.pago.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ro.marc.pago.R

class MainActivity: AppCompatActivity() {

    var navController: NavController? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController
    }

    fun configureHeader(text: String?) {
        if (text == null) {
            findViewById<ConstraintLayout>(R.id.header).visibility = View.INVISIBLE
            return
        }

        findViewById<TextView>(R.id.title).text = text
    }

}