package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;

/* JADX INFO: renamed from: com.unity3d.player.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C0876u implements ImageReader.OnImageAvailableListener {
    final /* synthetic */ C0880w a;

    C0876u(C0880w c0880w) {
        this.a = c0880w;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        if (C0880w.D.tryAcquire()) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            if (imageAcquireNextImage != null) {
                Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                if (imageAcquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    ((Camera2Wrapper) this.a.a).a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC0886z.Log(6, "Camera2: Wrong image format.");
                }
                Image image = this.a.p;
                if (image != null) {
                    image.close();
                }
                this.a.p = imageAcquireNextImage;
            }
            C0880w.D.release();
        }
    }
}
