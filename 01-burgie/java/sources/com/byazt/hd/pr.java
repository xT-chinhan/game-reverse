package com.byazt.hd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.byazt.ca.g;
import com.byazt.fj.TTProgressBar;
import com.byazt.gz.c;
import com.byazt.gz.uc;
import com.byazt.gz.x;
import com.byazt.hg.of;
import com.byazt.jf.LayoutVideoDetail;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.INTERACTION_TYPE_CODE, 37})
public class pr extends x {
    public pr(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, ofVar, str, z, z2, z3);
    }

    @Override // com.byazt.gz.x
    public uc pr(Context context, EnumSet<com.byazt.w.hw.pr> enumSet) {
        View layoutVideoDetail;
        if (this.k) {
            layoutVideoDetail = pr(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        if (layoutVideoDetail == null) {
            return null;
        }
        if (this.k) {
            return new uc(context, layoutVideoDetail, true, enumSet, this.uc, this, n(), null);
        }
        return new c(context, layoutVideoDetail, true, enumSet, this.uc, this, false);
    }

    private View pr(final Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        g.pr(context, "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.hd.pr.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.pr(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
