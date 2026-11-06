package com.byazt.osr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.cq.rv;
import com.byazt.lh.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1182})
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.byazt.tq.qg {
    @Override // com.byazt.osr.DynamicBaseWidget
    public boolean q() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.k = new ImageView(context);
        this.k.setTag(5);
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().t()) {
            return;
        }
        this.k.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        if (com.byazt.twc.q.n()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.sz.qg);
        if (com.byazt.twc.q.n()) {
            Drawable drawableN = com.byazt.cq.q.n(getContext(), this.d);
            if (drawableN != null) {
                ((ImageView) this.k).setBackground(drawableN);
            }
        } else {
            ((ImageView) this.k).setBackgroundDrawable(rv.n(0, Integer.valueOf(this.d.ur()), new int[]{this.fs / 2}, null, null, null));
        }
        return true;
    }

    @Override // com.byazt.tq.qg
    public void setSoundMute(boolean z) {
        sz.n(getContext(), z ? "tt_mute" : "tt_unmute", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.osr.DynamicMutedView.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                ((ImageView) DynamicMutedView.this.k).setImageDrawable(new BitmapDrawable(DynamicMutedView.this.getContext().getResources(), bitmap));
                if (((ImageView) DynamicMutedView.this.k).getDrawable() != null) {
                    ((ImageView) DynamicMutedView.this.k).getDrawable().setAutoMirrored(true);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
