package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C0872s extends CameraCaptureSession.StateCallback {
    final /* synthetic */ C0880w a;

    C0872s(C0880w c0880w) {
        this.a = c0880w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0886z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        StringBuilder sbAppend;
        C0880w c0880w = this.a;
        if (c0880w.b == null) {
            return;
        }
        synchronized (c0880w.s) {
            C0880w c0880w2 = this.a;
            c0880w2.r = cameraCaptureSession;
            try {
                try {
                    c0880w2.q = c0880w2.b.createCaptureRequest(1);
                    C0880w c0880w3 = this.a;
                    c0880w3.q.addTarget(c0880w3.v);
                    C0880w c0880w4 = this.a;
                    c0880w4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c0880w4.n);
                    this.a.g();
                } catch (IllegalStateException e) {
                    sbAppend = new StringBuilder("Camera2: IllegalStateException ").append(e);
                    AbstractC0886z.Log(6, sbAppend.toString());
                }
            } catch (CameraAccessException e2) {
                sbAppend = new StringBuilder("Camera2: CameraAccessException ").append(e2);
                AbstractC0886z.Log(6, sbAppend.toString());
            }
        }
    }
}
