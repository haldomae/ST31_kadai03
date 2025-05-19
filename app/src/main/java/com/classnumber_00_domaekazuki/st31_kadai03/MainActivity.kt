package com.classnumber_00_domaekazuki.st31_kadai03

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 画像の表示領域を取得
        val imageArea: ImageView = findViewById(R.id.image_area)

        // レイアウトからボタンを取得
        val beforeButton: ImageButton = findViewById(R.id.before_button)
        val nextButton: ImageButton = findViewById(R.id.next_button)

        // 画像IDを配列として定義
        val imageList = listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
        )

        // ページ数を表示
        val pageNumber: TextView = findViewById(R.id.page_number)

        var currentIndex = 0
        fun updateUI() {
            imageArea.setImageResource(imageList[currentIndex])
            pageNumber.text = "${currentIndex + 1}/${imageList.size}"
            beforeButton.visibility = if (currentIndex == 0) ImageButton.INVISIBLE else ImageButton.VISIBLE
            nextButton.visibility = if (currentIndex == imageList.size - 1) ImageButton.INVISIBLE else ImageButton.VISIBLE
        }
        // 画像のクリックイベントを付与
        beforeButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateUI()
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < imageList.size - 1) {
                currentIndex++
                updateUI()
            }
        }





        updateUI()

    }
}