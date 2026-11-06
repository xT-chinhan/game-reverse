package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.rk.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR})
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.byazt.imd.hn {
    public boolean pr;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.pr = dynamicRootView.getRenderRequest().ho();
        }
        this.fw = this.zo;
        this.ho = new ImageView(context);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        addView(this.ho, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().iu()) {
            this.ho.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawablePr = com.byazt.js.x.pr(getContext(), this.k);
        if (drawablePr != null) {
            ((ImageView) this.ho).setBackground(drawablePr);
        }
        if (this.pr) {
            g.pr(getContext(), "tt_close_btn", (ImageView) this.ho, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } else {
            g.pr(getContext(), "tt_skip_btn", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.gx.DynamicTimeOuterRewardFullSkip.1
                @Override // com.byazt.ezf.pr
                public void pr(Bitmap bitmap) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(DynamicTimeOuterRewardFullSkip.this.getContext().getResources(), bitmap);
                    bitmapDrawable.setAutoMirrored(true);
                    ((ImageView) DynamicTimeOuterRewardFullSkip.this.ho).setImageDrawable(bitmapDrawable);
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
