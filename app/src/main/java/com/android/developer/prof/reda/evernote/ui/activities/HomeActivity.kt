package com.android.developer.prof.reda.evernote.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.developer.prof.reda.evernote.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}