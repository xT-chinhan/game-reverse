package com.byazt.ql;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 19})
public class n {
    public boolean l;
    public AudioAttributes n;
    public AudioManager.OnAudioFocusChangeListener q;
    public AudioFocusRequest qg;
    public AudioManager s;

    public n() {
        this.l = false;
        boolean zSh = rv.qg().sh();
        this.l = zSh;
        if (zSh) {
            this.q = new AudioManager.OnAudioFocusChangeListener() { // from class: com.byazt.ql.n.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.s = (AudioManager) rv.getContext().getSystemService(MediaFormat.KEY_AUDIO);
        }
    }

    public int n() {
        if (!this.l) {
            return -1;
        }
        this.n = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.q).setAudioAttributes(this.n).build();
            this.qg = audioFocusRequestBuild;
            AudioManager audioManager = this.s;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(audioFocusRequestBuild);
            }
            return -1;
        }
        AudioManager audioManager2 = this.s;
        if (audioManager2 != null) {
            return audioManager2.requestAudioFocus(this.q, 3, 2);
        }
        return -1;
    }

    public void qg() {
        if (this.l) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioManager audioManager = this.s;
                if (audioManager != null) {
                    audioManager.abandonAudioFocusRequest(this.qg);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.s;
            if (audioManager2 != null) {
                audioManager2.abandonAudioFocus(this.q);
            }
        }
    }
}
