package com.byazt.fo;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ScrollView;
import com.byazt.llk.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 1814})
public class UGScrollView extends ScrollView {
    public c pr;

    public UGScrollView(Context context) {
        super(context);
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.pr;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
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

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }
}
