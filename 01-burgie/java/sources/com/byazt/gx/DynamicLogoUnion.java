package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.rk.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2248})
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.ho = new ImageView(context);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        if (com.byazt.dj.x.pr()) {
            this.zo = Math.max(dynamicRootView.getLogoUnionHeight(), this.zo);
        }
        addView(this.ho, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (com.byazt.dj.x.pr()) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        g.pr(getContext(), "tt_ad_logo", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.gx.DynamicLogoUnion.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                ((ImageView) DynamicLogoUnion.this.ho).setImageDrawable(new BitmapDrawable(DynamicLogoUnion.this.getContext().getResources(), bitmap));
                ((ImageView) DynamicLogoUnion.this.ho).setColorFilter(DynamicLogoUnion.this.k.fw(), PorterDuff.Mode.SRC_IN);
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return true;
    }
}
