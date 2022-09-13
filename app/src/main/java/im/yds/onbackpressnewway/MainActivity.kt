package im.yds.onbackpressnewway

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import im.yds.onbackpressnewway.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleOnBack()
    }

    private fun handleOnBack() {
        onBackPressedDispatcher.addCallback(
            this@MainActivity, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    when {
                        isEnabled -> {
                            Snackbar.make(binding.root, "OnBackPressed", Snackbar.LENGTH_LONG)
                                .show()
                            isEnabled = false
                        }
                        else -> {
                            isEnabled = false
                            finish()
                        }
                    }
                }
            })
    }
}