package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes2.dex */
public final class DummySurface extends Surface {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    public static synchronized boolean isSecureSupported(Context context) {
        if (!secureModeInitialized) {
            secureMode = Build.VERSION.SDK_INT < 24 ? 0 : getSecureModeV24(context);
            secureModeInitialized = true;
        }
        return secureMode != 0;
    }

    public static DummySurface newInstanceV17(boolean z) {
        assertApiLevel17OrHigher();
        return new DummySurfaceThread().init(z ? secureMode : 0);
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (Build.VERSION.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    private static int getSecureModeV24(Context context) {
        String strEglQueryString;
        if ((Build.VERSION.SDK_INT >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return strEglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    private static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public DummySurface init(int i) {
            boolean z;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z = false;
                this.handler.obtainMessage(1, i, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.initError;
            if (error != null) {
                throw error;
            }
            DummySurface dummySurface = this.surface;
            if (dummySurface == null) {
                throw new NullPointerException();
            }
            return dummySurface;
        }

        public void release() {
            Handler handler = this.handler;
            if (handler == null) {
                throw new NullPointerException();
            }
            handler.sendEmptyMessage(2);
        }

        /* JADX WARN: Code duplicated, block: B:55:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1:
                        try {
                            initInternal(message.arg1);
                            synchronized (this) {
                                notify();
                                break;
                            }
                        } catch (Error e) {
                            ho.pr(DummySurface.TAG, "Failed to initialize dummy surface", e);
                            this.initError = e;
                            synchronized (this) {
                                notify();
                            }
                        } catch (RuntimeException e2) {
                            ho.pr(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                            this.initException = e2;
                            synchronized (this) {
                                notify();
                                break;
                            }
                        }
                        return true;
                    case 2:
                        try {
                            releaseInternal();
                            break;
                        } catch (Throwable th) {
                            try {
                                ho.pr(DummySurface.TAG, "Failed to release dummy surface", th);
                            } finally {
                                quit();
                            }
                            break;
                        }
                        return true;
                    default:
                        return true;
                }
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
            synchronized (this) {
                notify();
                throw th2;
            }
        }

        private void initInternal(int i) {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            if (eGLSurfaceTexture == null) {
                throw new NullPointerException();
            }
            eGLSurfaceTexture.init(i);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i != 0);
        }

        private void releaseInternal() {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            if (eGLSurfaceTexture == null) {
                throw new NullPointerException();
            }
            eGLSurfaceTexture.release();
        }
    }
}
