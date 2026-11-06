package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.js.aj;
import com.byazt.rk.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1107})
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.byazt.imd.hw {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.ho = new ImageView(context);
        this.ho.setTag(5);
        addView(this.ho, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().iu()) {
            this.ho.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (com.byazt.dj.x.pr()) {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.ho).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.g.hw);
        if (com.byazt.dj.x.pr()) {
            Drawable drawablePr = com.byazt.js.x.pr(getContext(), this.k);
            if (drawablePr != null) {
                ((ImageView) this.ho).setBackground(drawablePr);
            }
        } else {
            ((ImageView) this.ho).setBackgroundDrawable(aj.pr(0, Integer.valueOf(this.k.ve()), new int[]{this.zo / 2}, null, null, null));
        }
        return true;
    }

    @Override // com.byazt.imd.hw
    public void setSoundMute(boolean z) {
        g.pr(getContext(), z ? "tt_mute" : "tt_unmute", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.gx.DynamicMutedView.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                ((ImageView) DynamicMutedView.this.ho).setImageDrawable(new BitmapDrawable(DynamicMutedView.this.getContext().getResources(), bitmap));
                if (((ImageView) DynamicMutedView.this.ho).getDrawable() != null) {
                    ((ImageView) DynamicMutedView.this.ho).getDrawable().setAutoMirrored(true);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public boolean x() {
        return true;
    }
}
