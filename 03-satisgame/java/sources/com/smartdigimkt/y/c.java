package com.smartdigimkt.y;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public AudioManager a;
    public AudioFocusRequest b;
    public WeakReference d;
    public boolean e;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final b f = new b(this);

    public static void a(c cVar, int i) {
        if (cVar.e) {
            WeakReference weakReference = cVar.d;
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = weakReference == null ? null : (AudioManager.OnAudioFocusChangeListener) weakReference.get();
            if (onAudioFocusChangeListener != null) {
                onAudioFocusChangeListener.onAudioFocusChange(i);
            }
        }
    }

    public final int b() {
        int iRequestAudioFocus;
        try {
            this.e = true;
            iRequestAudioFocus = Build.VERSION.SDK_INT >= 26 ? this.a.requestAudioFocus(this.b) : this.a.requestAudioFocus(this.f, 3, 2);
        } catch (Exception unused) {
            iRequestAudioFocus = 0;
        }
        this.e = iRequestAudioFocus == 1 || iRequestAudioFocus == 2;
        return iRequestAudioFocus;
    }

    public final void a(Context context) {
        this.a = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        if (Build.VERSION.SDK_INT >= 26) {
            this.b = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(true).setOnAudioFocusChangeListener(this.f, this.c).build();
        }
    }

    public final void a() {
        this.e = false;
        this.c.removeCallbacksAndMessages(null);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.a.abandonAudioFocusRequest(this.b);
            } else {
                this.a.abandonAudioFocus(this.f);
            }
        } catch (Exception unused) {
        }
    }
}
