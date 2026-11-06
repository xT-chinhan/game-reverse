package com.anythink.basead.a;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    private AudioManager b;
    private AudioFocusRequest c;

    public final void a(Context context) {
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setAcceptsDelayedFocusGain(false).build();
    }

    public final boolean a() {
        try {
            return this.b.requestAudioFocus(this.c) == 1;
        } catch (Exception unused) {
        }
    }

    public final void b() {
        try {
            this.b.abandonAudioFocusRequest(this.c);
        } catch (Exception unused) {
        }
    }
}
