package com.byazt.iy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.byazt.gq.w;
import com.byazt.gq.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 101})
public abstract class fs<R extends com.byazt.gq.w, W extends com.byazt.gq.x> {
    public int cp;
    public int d;
    public int fs;
    public int rv;
    public int tj;
    public final R x;
    public final Rect oa = new Rect();
    public final Rect sz = new Rect();

    public abstract Bitmap n(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public fs(R r) {
        this.x = r;
    }
}
