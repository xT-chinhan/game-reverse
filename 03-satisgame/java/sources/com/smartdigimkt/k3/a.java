package com.smartdigimkt.k3;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final SoftReference a;
    public final boolean b;

    public a(Bitmap bitmap, int i, int i2) {
        this.a = new SoftReference(bitmap);
        this.b = i <= 0 || i2 <= 0 || bitmap.getWidth() * 2 < i || bitmap.getHeight() * 2 < i2;
    }
}
