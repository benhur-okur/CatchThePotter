package com.benhurokur.catchthepotter

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.benhurokur.catchthedoga.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val imageList = ArrayList<ImageView>()
    var score = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val builder = AlertDialog.Builder(this@MainActivity2)

        imageList.add(binding.imageView1)
        imageList.add(binding.imageView2)
        imageList.add(binding.imageView3)
        imageList.add(binding.imageView4)
        imageList.add(binding.imageView5)
        imageList.add(binding.imageView6)
        imageList.add(binding.imageView7)
        imageList.add(binding.imageView8)
        imageList.add(binding.imageView9)

        game(view)

        object : CountDownTimer(15000, 1000) {
            override fun onTick(p0: Long) {
                binding.textView.text = "Time : ${p0/1000}"
            }

            override fun onFinish() {
                binding.textView.text = "Time : 0"
                handler.removeCallbacks(runnable)
                builder.setTitle("Do you want to play again")
                builder.setMessage("You Sure?")
                val alertDialog : AlertDialog = builder.create()
                builder.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        val intent = Intent(this@MainActivity2, MenuActivty::class.java)
                        startActivity(intent)
                        finish()
                    }

                })
                builder.setNegativeButton("No", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        onDestroy()
                    }

                })
                builder.show()

             //TODO("high scoru görebilecegi bir toast oluştur
            }

        }.start()


    }

    fun changeImage(view : View) {
        var randomNumber = Random.nextInt(9) // 0'dan 8'e kadar 8 de dahil
        for (i in 0 .. 8) {
            if (i == randomNumber) {
                imageList[i].visibility = View.VISIBLE
            } else {
                imageList[i].visibility = View.INVISIBLE

            }
        }
    }

    fun earnPoint (view : View) {
        score++
        binding.textView2.text = "Score : ${score}"
    }


    fun game (view : View) {
        runnable = object : Runnable {
            override fun run() {
                changeImage(view)
                handler.postDelayed(runnable, 500)

            }

        }
        handler.post(runnable)
    }





}