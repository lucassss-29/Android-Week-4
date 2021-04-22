package com.thesis.android_challenge_w3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thesis.android_challenge_w3.activity.welcome.WelcomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, RestaurantActivity::class.java)
        startActivity(intent)
    }
}