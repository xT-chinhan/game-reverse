package com.unity3d.player;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: renamed from: com.unity3d.player.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0525t extends CameraDevice.StateCallback {
    final /* synthetic */ C0531w a;

    C0525t(C0531w c0531w) {
        this.a = c0531w;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C0531w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        AbstractC0537z.Log(5, "Camera2: CameraDevice disconnected.");
        this.a.a(cameraDevice);
        C0531w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        AbstractC0537z.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.a.a(cameraDevice);
        C0531w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.a.b = cameraDevice;
        C0531w.D.release();
    }
}
