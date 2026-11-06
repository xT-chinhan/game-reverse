package com.byazt.xi;

import android.media.MediaPlayer;
import android.media.SoundPool;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1484, 19})
public class n {
    public SoundPool n;
    public MediaPlayer qg;
    public boolean s = false;

    public void n() {
        this.n = new SoundPool.Builder().setMaxStreams(4).build();
    }

    public void qg() {
        try {
            MediaPlayer mediaPlayer = this.qg;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.qg.pause();
        } catch (Throwable unused) {
        }
    }

    public void s() {
        try {
            MediaPlayer mediaPlayer = this.qg;
            if (mediaPlayer == null || this.s) {
                return;
            }
            mediaPlayer.start();
        } catch (Throwable unused) {
        }
    }

    public void q() {
        this.s = true;
        try {
            SoundPool soundPool = this.n;
            if (soundPool != null) {
                soundPool.release();
                this.n = null;
            }
        } catch (Throwable unused) {
        }
        try {
            MediaPlayer mediaPlayer = this.qg;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.qg = null;
            }
        } catch (Throwable unused2) {
        }
    }
}
