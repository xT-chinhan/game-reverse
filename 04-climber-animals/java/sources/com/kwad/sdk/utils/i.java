package com.kwad.sdk.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private AudioManager aKz;
    private AudioManager.OnAudioFocusChangeListener aYH = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (i.this.kf == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        i.this.kf.onAudioBeOccupied();
                    } else {
                        i.this.kf.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a kf;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public i(Context context) {
        this.aKz = (AudioManager) context.getSystemService("audio");
    }

    public final boolean PF() {
        try {
            return (this.aYH == null || this.aKz == null || 1 != this.aKz.requestAudioFocus(PG())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    private AudioFocusRequest PG() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.aYH).build();
    }

    public final void c(a aVar) {
        this.kf = aVar;
    }
}
