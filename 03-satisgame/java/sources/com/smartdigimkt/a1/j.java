package com.smartdigimkt.a1;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final WindowManager a;
    public final i b;
    public final h c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public long j;
    public long k;
    public long l;

    public j(Context context) {
        DisplayManager displayManager;
        h hVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.a = (WindowManager) context.getSystemService("window");
        } else {
            this.a = null;
        }
        if (this.a != null) {
            if (u.a >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                hVar = new h(this, displayManager);
            }
            this.c = hVar;
            this.b = i.e;
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
    }

    public final void a() {
        try {
            Display defaultDisplay = this.a.getDefaultDisplay();
            if (defaultDisplay != null) {
                long refreshRate = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
                this.d = refreshRate;
                this.e = (refreshRate * 80) / 100;
            }
        } catch (Throwable unused) {
        }
    }
}
