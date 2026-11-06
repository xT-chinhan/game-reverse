package com.byazt.osr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.lh.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD})
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.byazt.tq.s {
    public boolean n;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.n = dynamicRootView.getRenderRequest().k();
        }
        this.x = this.fs;
        this.k = new ImageView(context);
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().t()) {
            return;
        }
        this.k.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableN = com.byazt.cq.q.n(getContext(), this.d);
        if (drawableN != null) {
            ((ImageView) this.k).setBackground(drawableN);
        }
        if (this.n) {
            sz.n(getContext(), "tt_close_btn", (ImageView) this.k, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } else {
            sz.n(getContext(), "tt_skip_btn", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.osr.DynamicTimeOuterRewardFullSkip.1
                @Override // com.byazt.qyj.n
                public void n(Bitmap bitmap) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(DynamicTimeOuterRewardFullSkip.this.getContext().getResources(), bitmap);
                    bitmapDrawable.setAutoMirrored(true);
                    ((ImageView) DynamicTimeOuterRewardFullSkip.this.k).setImageDrawable(bitmapDrawable);
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
