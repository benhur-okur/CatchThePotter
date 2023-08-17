package com.benhurokur.catchthepotter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.benhurokur.catchthedoga.databinding.ActivityMainBinding
import com.benhurokur.catchthedoga.databinding.ActivityMenuActivtyBinding

class MenuActivty : AppCompatActivity() {

    private lateinit var binding : ActivityMenuActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuActivtyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun start(view : View) {
        val intent = Intent(this@MenuActivty, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}