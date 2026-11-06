package com.mcto.sspsdk.component.imageview2;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends ViewOutlineProvider {
    public final /* synthetic */ QYImageView2 a;

    public h(QYImageView2 qYImageView2) {
        this.a = qYImageView2;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0 || this.a.g <= 0.0f) {
            outline.setEmpty();
        } else {
            outline.setRoundRect(0, 0, width, height, this.a.g);
        }
    }
}
