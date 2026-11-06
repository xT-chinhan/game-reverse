package com.byazt.rij;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.byazt.ik.hn;
import com.byazt.llk.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 1483})
public class Swiper extends BaseSwiper<hn> {
    public c x;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.byazt.rij.BaseSwiper
    public View w(int i) {
        return ((hn) this.pr.get(i)).aj();
    }

    public void pr(c cVar) {
        this.x = cVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.x;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
        c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.hn();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.x;
        if (cVar != null) {
            cVar.x();
        }
        super.onLayout(z, i, i2, i3, i4);
        c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.pr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.x;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.x;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c cVar = this.x;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.x;
        if (cVar != null) {
            cVar.pr(z);
        }
    }
}
