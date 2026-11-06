package com.bytedance.adsdk.ms.ms.ms;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.ms.ms.xr.ab;
import com.bytedance.adsdk.ms.ms.xr.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x<R extends com.bytedance.adsdk.ms.ms.xr.c, W extends com.bytedance.adsdk.ms.ms.xr.ab> {
    protected final R ab;
    public int ch;
    public int hi;
    public int ny;
    public int sl;
    public int x;
    protected final Rect zb = new Rect();
    protected final Rect u = new Rect();

    public abstract Bitmap ms(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public x(R r) {
        this.ab = r;
    }
}
