package com.byazt.gl;

import android.content.Context;
import com.byazt.jt.GifView;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 840, 841})
public class UgenGif extends GifView {
    public c pr;

    public UgenGif(Context context) {
        super(context);
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.jt.GifView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.hn();
        }
    }

    @Override // com.byazt.jt.GifView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(z);
        }
    }
}
