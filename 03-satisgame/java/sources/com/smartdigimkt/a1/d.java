package com.smartdigimkt.a1;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends Surface {
    public static int c;
    public static boolean d;
    public final c a;
    public boolean b;

    public d(c cVar, SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.a = cVar;
    }

    public static synchronized boolean a(Context context) {
        String strEglQueryString;
        int i;
        if (!d) {
            int i2 = u.a;
            if (i2 >= 24 && ((i2 >= 26 || !("samsung".equals(u.c) || "XT1650".equals(u.d))) && ((i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content")))) {
                i = strEglQueryString.contains("EGL_KHR_surfaceless_context") ? 1 : 2;
            } else {
                i = 0;
            }
            c = i;
            d = true;
        }
        return c != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.a) {
            if (!this.b) {
                c cVar = this.a;
                cVar.b.getClass();
                cVar.b.sendEmptyMessage(2);
                this.b = true;
            }
        }
    }
}
