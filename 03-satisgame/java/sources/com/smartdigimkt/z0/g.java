package com.smartdigimkt.z0;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int[] g = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public final Handler a;
    public final int[] b = new int[1];
    public EGLDisplay c;
    public EGLContext d;
    public EGLSurface e;
    public SurfaceTexture f;

    public g(Handler handler) {
        this.a = handler;
    }

    public final void a(int i) {
        EGLConfig eGLConfig;
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new f("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new f("eglInitialize failed");
        }
        this.c = eGLDisplayEglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, g, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (!zEglChooseConfig || iArr2[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            Object[] objArr = {Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]};
            int i2 = u.a;
            throw new f(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr));
        }
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.c, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eGLContextEglCreateContext == null) {
            throw new f("eglCreateContext failed");
        }
        this.d = eGLContextEglCreateContext;
        EGLDisplay eGLDisplay = this.c;
        if (i == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new f("eglCreatePbufferSurface failed");
            }
        }
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
            throw new f("eglMakeCurrent failed");
        }
        this.e = eGLSurfaceEglCreatePbufferSurface;
        GLES20.glGenTextures(1, this.b, 0);
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            throw new f("glGenTextures failed. Error: " + Integer.toHexString(iGlGetError));
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.b[0]);
        this.f = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public final SurfaceTexture b() {
        SurfaceTexture surfaceTexture = this.f;
        surfaceTexture.getClass();
        return surfaceTexture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        this.a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.e;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.c, this.e);
            }
            EGLContext eGLContext = this.d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.c, eGLContext);
            }
            if (u.a >= 19) {
                EGL14.eglReleaseThread();
            }
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }
}
