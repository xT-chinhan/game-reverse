package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayerSetting {
    private final Context mContext;
    private float mCurrentPlayerVolume = 1.0f;
    private float mLastVolume;
    private MediaPlayer mPlayer;

    public PlayerSetting(Context context, MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
        this.mContext = context;
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void setVolume(float f) {
        AudioManager audioManager;
        if (this.mPlayer != null && (audioManager = (AudioManager) this.mContext.getSystemService(MediaFormat.KEY_AUDIO)) != null) {
            audioManager.setStreamVolume(3, (int) f, 0);
        }
    }

    public void setPlayerVolume(float f) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.mCurrentPlayerVolume = f;
        mediaPlayer.setVolume(f, f);
    }

    public float getMaxVolume() {
        int streamMaxVolume;
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        int i = 0;
        if (audioManager == null) {
            streamMaxVolume = 0;
        } else {
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
        }
        if (streamMaxVolume >= 0) {
            i = streamMaxVolume;
        }
        return i;
    }

    public float getVolume() {
        int streamVolume;
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        int i = 0;
        if (audioManager == null) {
            streamVolume = 0;
        } else {
            streamVolume = audioManager.getStreamVolume(3);
        }
        if (streamVolume >= 0) {
            i = streamVolume;
        }
        return i;
    }

    public float getPlayerVolume() {
        return this.mCurrentPlayerVolume;
    }

    public void setMute(boolean z) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer.isOSPlayer()) {
            float maxVolume = getMaxVolume();
            if (maxVolume > 0.0f) {
                this.mLastVolume = getVolume() / maxVolume;
            }
            if (z) {
                this.mPlayer.setVolume(0.0f, 0.0f);
                return;
            }
            MediaPlayer mediaPlayer2 = this.mPlayer;
            float f = this.mLastVolume;
            mediaPlayer2.setVolume(f, f);
            return;
        }
        this.mPlayer.setIsMute(z);
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        if (mediaPlayer.isOSPlayer()) {
            return getVolume() < 0.001f;
        }
        return this.mPlayer.isMute();
    }
}
