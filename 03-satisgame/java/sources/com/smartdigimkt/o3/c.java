package com.smartdigimkt.o3;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ View c;

    public c(View view, float f, View view2) {
        this.a = view;
        this.b = f;
        this.c = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect rect = new Rect();
        this.a.getHitRect(rect);
        int iWidth = ((int) ((this.b - 1.0f) * rect.width())) / 2;
        int iHeight = ((int) ((this.b - 1.0f) * rect.height())) / 2;
        int i = rect.top - iHeight;
        if (i < 0) {
            rect.top = 0;
        } else {
            rect.top = i;
        }
        if (rect.bottom + iHeight > this.c.getHeight()) {
            rect.bottom = this.c.getHeight();
        } else {
            rect.bottom += iHeight;
        }
        int i2 = rect.left - iWidth;
        if (i2 < 0) {
            rect.left = 0;
        } else {
            rect.left = i2;
        }
        if (rect.right + iWidth > this.c.getWidth()) {
            rect.right = this.c.getWidth();
        } else {
            rect.right += iWidth;
        }
        this.c.setTouchDelegate(new TouchDelegate(rect, this.a));
    }
}
