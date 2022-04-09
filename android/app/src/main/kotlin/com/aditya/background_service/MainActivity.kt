package com.aditya.background_service

import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.background_service"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            // Note: this method is invoked on the main thread.
            println(call.method)
            println(call.arguments)
            println(call.hasArgument("first value"))
            if (call.method == "startService") {
                val intent = Intent(this, TestService::class.java)
                startService(intent)
            } else if (call.method == "stopService") {
                val intent = Intent(this, TestService::class.java)
                stopService(intent)
            }
        }
    }
}
