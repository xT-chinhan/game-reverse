package com.byazt.zp;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 37})
public class pr {
    public boolean c;
    public AudioManager hn;
    public AudioFocusRequest hw;
    public AudioAttributes pr;
    public AudioManager.OnAudioFocusChangeListener x;

    public pr() {
        this.c = false;
        boolean zIi = a.hw().ii();
        this.c = zIi;
        if (zIi) {
            this.x = new AudioManager.OnAudioFocusChangeListener() { // from class: com.byazt.zp.pr.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.hn = (AudioManager) a.getContext().getSystemService(MediaFormat.KEY_AUDIO);
        }
    }

    public int pr() {
        if (!this.c) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.pr = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.x).setAudioAttributes(this.pr).build();
            this.hw = audioFocusRequestBuild;
            AudioManager audioManager = this.hn;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(audioFocusRequestBuild);
            }
            return -1;
        }
        AudioManager audioManager2 = this.hn;
        if (audioManager2 != null) {
            return audioManager2.requestAudioFocus(this.x, 3, 2);
        }
        return -1;
    }

    public void hw() {
        if (!this.c) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager audioManager = this.hn;
            if (audioManager != null) {
                audioManager.abandonAudioFocusRequest(this.hw);
                return;
            }
            return;
        }
        AudioManager audioManager2 = this.hn;
        if (audioManager2 != null) {
            audioManager2.abandonAudioFocus(this.x);
        }
    }
}
