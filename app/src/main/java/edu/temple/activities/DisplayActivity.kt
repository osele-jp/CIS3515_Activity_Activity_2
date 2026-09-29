package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size valu
    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    val launchForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK) {
            result.data?.getIntExtra("TEXT_SIZE", 0)?.let {
                if (it > 0) {
                    lyricsDisplayTextView.textSize = it.toFloat()
                }
            }
        }
    }
    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {

            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            launchForResult.launch(launchIntent)
        }

    }
}