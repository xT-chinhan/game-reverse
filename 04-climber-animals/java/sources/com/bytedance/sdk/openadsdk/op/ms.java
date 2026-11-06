package com.bytedance.sdk.openadsdk.op;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private AudioManager ah;
    private AudioManager.OnAudioFocusChangeListener d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AudioAttributes f4077ms;
    private AudioFocusRequest xr;

    public ms() {
        this.ka = false;
        boolean zLe = re.xr().le();
        this.ka = zLe;
        if (zLe) {
            this.d = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.op.ms.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.ah = (AudioManager) re.getContext().getSystemService("audio");
        }
    }

    public int ms() {
        if (!this.ka) {
            return -1;
        }
        this.f4077ms = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.d).setAudioAttributes(this.f4077ms).build();
        this.xr = audioFocusRequestBuild;
        AudioManager audioManager = this.ah;
        if (audioManager != null) {
            return audioManager.requestAudioFocus(audioFocusRequestBuild);
        }
        return -1;
    }

    public void xr() {
        AudioManager audioManager;
        if (this.ka && (audioManager = this.ah) != null) {
            audioManager.abandonAudioFocusRequest(this.xr);
        }
    }
}
