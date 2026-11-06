package com.anythink.basead.exoplayer.l;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.anythink.basead.exoplayer.k.af;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Surface {
    private static final String b = "DummySurface";
    private static final String c = "EGL_EXT_protected_content";
    private static final String d = "EGL_KHR_surfaceless_context";
    private static int e;
    private static boolean f;
    public final boolean a;
    private final a g;
    private boolean h;

    /* synthetic */ c(a aVar, SurfaceTexture surfaceTexture, boolean z, byte b2) {
        this(aVar, surfaceTexture, z);
    }

    public static synchronized boolean a(Context context) {
        String strEglQueryString;
        int i;
        if (!f) {
            if (af.a >= 24 && ((af.a >= 26 || !("samsung".equals(af.c) || "XT1650".equals(af.d))) && ((af.a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(c)))) {
                i = strEglQueryString.contains(d) ? 1 : 2;
            } else {
                i = 0;
            }
            e = i;
            f = true;
        }
        return e != 0;
    }

    private c(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.g = aVar;
        this.a = z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.g) {
            if (!this.h) {
                this.g.a();
                this.h = true;
            }
        }
    }

    private static void a() {
        if (af.a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    private static int b(Context context) {
        String strEglQueryString;
        if (af.a < 26 && ("samsung".equals(af.c) || "XT1650".equals(af.d))) {
            return 0;
        }
        if ((af.a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(c)) {
            return strEglQueryString.contains(d) ? 1 : 2;
        }
        return 0;
    }

    private static class a extends HandlerThread implements Handler.Callback {
        private static final int a = 1;
        private static final int b = 2;
        private com.anythink.basead.exoplayer.k.g c;
        private Handler d;
        private Error e;
        private RuntimeException f;
        private c g;

        public a() {
            super("dummySurface");
        }

        public final c a(int i) {
            boolean z;
            start();
            this.d = new Handler(getLooper(), this);
            this.c = new com.anythink.basead.exoplayer.k.g(this.d);
            synchronized (this) {
                z = false;
                this.d.obtainMessage(1, i, 0).sendToTarget();
                while (this.g == null && this.f == null && this.e == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.e;
            if (error != null) {
                throw error;
            }
            return (c) com.anythink.basead.exoplayer.k.a.a(this.g);
        }

        public final void a() {
            com.anythink.basead.exoplayer.k.a.a(this.d);
            this.d.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        com.anythink.basead.exoplayer.k.a.a(this.c);
                        this.c.a();
                    } catch (Throwable th) {
                        try {
                            Log.e(c.b, "Failed to release dummy surface", th);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
                try {
                    int i2 = message.arg1;
                    com.anythink.basead.exoplayer.k.a.a(this.c);
                    this.c.a(i2);
                    this.g = new c(this, this.c.b(), i2 != 0, (byte) 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e(c.b, "Failed to initialize dummy surface", e);
                    this.e = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e(c.b, "Failed to initialize dummy surface", e2);
                    this.f = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }

        private void b(int i) {
            com.anythink.basead.exoplayer.k.a.a(this.c);
            this.c.a(i);
            this.g = new c(this, this.c.b(), i != 0, (byte) 0);
        }

        private void b() {
            com.anythink.basead.exoplayer.k.a.a(this.c);
            this.c.a();
        }
    }

    public static c a(Context context, boolean z) {
        if (af.a >= 17) {
            com.anythink.basead.exoplayer.k.a.b(!z || a(context));
            return new a().a(z ? e : 0);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
