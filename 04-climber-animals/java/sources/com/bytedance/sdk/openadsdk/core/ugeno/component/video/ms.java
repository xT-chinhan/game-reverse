package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.ka;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends d {
    public ms(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, lmVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    protected c ms(Context context, EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSet) {
        View layoutVideoDetail;
        if (this.sl) {
            layoutVideoDetail = ms(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.sl) {
            return new c(context, view, true, enumSet, this.c, this, ul(), null);
        }
        return new ka(context, view, true, enumSet, this.c, this, false);
    }

    private View ms(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387720);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387906);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387637);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        tTProgressBar.setIndeterminateDrawable(t.ah(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
