package com.example.spotifyclone.exoplayer.callbacks


import android.app.Service.STOP_FOREGROUND_REMOVE
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.spotifyclone.exoplayer.MusicService
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player

class MusicPlayerEventListener(
    private val musicService: MusicService
) : Player.Listener {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        if (playbackState == Player.STATE_READY) {
            musicService.stopForeground(STOP_FOREGROUND_REMOVE)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
        super.onPlayWhenReadyChanged(playWhenReady, reason)
        if(!playWhenReady) {
            musicService.stopForeground(STOP_FOREGROUND_REMOVE)
        }
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Toast.makeText(musicService, "An unknown error occurred", Toast.LENGTH_LONG).show()
    }
}

