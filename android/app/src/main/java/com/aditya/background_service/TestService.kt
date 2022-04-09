package com.aditya.background_service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast

class TestService : Service() {

    // declaring object of MediaPlayer
    private lateinit var player: MediaPlayer

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            applicationContext,
            "Service started. Media player started",
            Toast.LENGTH_LONG
        ).show()

        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        // providing the boolean
        // value as true to play
        // the audio on loop
        player.isLooping = true

        // starting the process
        player.start()

        // returns the status
        // of the program
        return START_NOT_STICKY
    }

    // execution of the service will
    // stop on calling this method
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(
            applicationContext,
            "Service stopped... Media player stopped...",
            Toast.LENGTH_LONG
        ).show()
        // stopping the process
        player.stop()
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }
}
