package com.example.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.maharjanm.connectivity.NetworkConnectivityObserver
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val observer = NetworkConnectivityObserver(applicationContext)

        lifecycleScope.launch {
            observer.observe().collect { status ->
                Log.d("Connectivity", "Status: $status")
            }
        }
    }
}