package com.anythink.core.express.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static double a = -1.0d;
    private static final String b = "android.media.VOLUME_CHANGED_ACTION";
    private static final String c = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private Context d;
    private AudioManager e;
    private boolean f = false;
    private b g;
    private a h;

    public interface b {
        void a(double d);
    }

    public c(Context context) {
        this.d = context;
        this.e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public final double a() {
        AudioManager audioManager = this.e;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.e;
        double streamVolume = (((double) (audioManager2 != null ? audioManager2.getStreamVolume(3) : -1)) * 100.0d) / ((double) streamMaxVolume);
        a = streamVolume;
        return streamVolume;
    }

    public final b b() {
        return this.g;
    }

    public final void a(b bVar) {
        this.g = bVar;
    }

    public final void c() {
        if (this.d != null) {
            this.h = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b);
            this.d.registerReceiver(this.h, intentFilter);
            this.f = true;
        }
    }

    public final void d() {
        Context context;
        if (!this.f || (context = this.d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.h);
            this.g = null;
            this.f = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class a extends BroadcastReceiver {
        private WeakReference<c> a;

        public a(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            c cVar;
            b bVarB;
            if (!c.b.equals(intent.getAction()) || intent.getIntExtra(c.c, -1) != 3 || (cVar = this.a.get()) == null || (bVarB = cVar.b()) == null) {
                return;
            }
            double dA = cVar.a();
            if (dA >= 0.0d) {
                bVarB.a(dA);
            }
        }
    }
}
