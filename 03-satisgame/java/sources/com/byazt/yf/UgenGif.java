package com.byazt.yf;

import android.content.Context;
import com.byazt.gu.l;
import com.byazt.stl.GifView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 1646})
public class UgenGif extends GifView {
    public l n;

    public UgenGif(Context context) {
        super(context);
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    @Override // com.byazt.stl.GifView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        l lVar = this.n;
        if (lVar != null) {
            lVar.s();
        }
    }

    @Override // com.byazt.stl.GifView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }
}
