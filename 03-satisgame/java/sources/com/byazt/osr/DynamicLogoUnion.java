package com.byazt.osr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.byazt.lh.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2434})
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.k = new ImageView(context);
        this.k.setTag(Integer.valueOf(getClickArea()));
        if (com.byazt.twc.q.n()) {
            this.fs = Math.max(dynamicRootView.getLogoUnionHeight(), this.fs);
        }
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        if (com.byazt.twc.q.n()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        sz.n(getContext(), "tt_ad_logo", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.osr.DynamicLogoUnion.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                ((ImageView) DynamicLogoUnion.this.k).setImageDrawable(new BitmapDrawable(DynamicLogoUnion.this.getContext().getResources(), bitmap));
                ((ImageView) DynamicLogoUnion.this.k).setColorFilter(DynamicLogoUnion.this.d.x(), PorterDuff.Mode.SRC_IN);
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return true;
    }
}
