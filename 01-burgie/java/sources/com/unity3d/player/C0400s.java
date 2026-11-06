package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0400s extends CameraCaptureSession.StateCallback {
    final /* synthetic */ C0408w a;

    C0400s(C0408w c0408w) {
        this.a = c0408w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0414z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        String str;
        C0408w c0408w = this.a;
        if (c0408w.b == null) {
            return;
        }
        synchronized (c0408w.s) {
            C0408w c0408w2 = this.a;
            c0408w2.r = cameraCaptureSession;
            try {
                c0408w2.q = c0408w2.b.createCaptureRequest(1);
                C0408w c0408w3 = this.a;
                c0408w3.q.addTarget(c0408w3.v);
                C0408w c0408w4 = this.a;
                c0408w4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c0408w4.n);
                this.a.g();
            } catch (CameraAccessException e) {
                str = "Camera2: CameraAccessException " + e;
                AbstractC0414z.Log(6, str);
            } catch (IllegalStateException e2) {
                str = "Camera2: IllegalStateException " + e2;
                AbstractC0414z.Log(6, str);
            }
        }
    }
}
