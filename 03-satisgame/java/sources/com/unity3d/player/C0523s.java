package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0523s extends CameraCaptureSession.StateCallback {
    final /* synthetic */ C0531w a;

    C0523s(C0531w c0531w) {
        this.a = c0531w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0537z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        StringBuilder sbAppend;
        C0531w c0531w = this.a;
        if (c0531w.b == null) {
            return;
        }
        synchronized (c0531w.s) {
            C0531w c0531w2 = this.a;
            c0531w2.r = cameraCaptureSession;
            try {
                try {
                    c0531w2.q = c0531w2.b.createCaptureRequest(1);
                    C0531w c0531w3 = this.a;
                    c0531w3.q.addTarget(c0531w3.v);
                    C0531w c0531w4 = this.a;
                    c0531w4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c0531w4.n);
                    this.a.g();
                } catch (IllegalStateException e) {
                    sbAppend = new StringBuilder("Camera2: IllegalStateException ").append(e);
                    AbstractC0537z.Log(6, sbAppend.toString());
                }
            } catch (CameraAccessException e2) {
                sbAppend = new StringBuilder("Camera2: CameraAccessException ").append(e2);
                AbstractC0537z.Log(6, sbAppend.toString());
            }
        }
    }
}
