package kr.ac.ex10_2_2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var voteCount = IntArray(9)
        for(i in 0..8)
            voteCount[i] = 0
        var image = arrayOfNulls<ImageView>(9)
        var imageId = arrayOf(R.id.a, R.id.b, R.id.c, R.id.d, R.id.e,
            R.id.f, R.id.g, R.id.h, R.id.i)

        var imgName = arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i")


        for(i in imageId.indices){
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext,
                imgName[i] + ": 총 "
                    + voteCount[i] + " 표",
                    Toast.LENGTH_SHORT).show()
            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}