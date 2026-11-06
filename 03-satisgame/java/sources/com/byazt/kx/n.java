package com.byazt.kx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.byazt.gct.pk;
import com.byazt.ia.l;
import com.byazt.ia.q;
import com.byazt.ia.w;
import com.byazt.kfh.TTProgressBar;
import com.byazt.tk.sz;
import com.byazt.un.LayoutVideoDetail;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1706, 19})
public class n extends q {
    public n(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, pkVar, str, z, z2, z3);
    }

    @Override // com.byazt.ia.q
    public w n(Context context, EnumSet<com.byazt.iag.qg.n> enumSet) {
        View layoutVideoDetail;
        if (this.d) {
            layoutVideoDetail = n(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.d) {
            return new w(context, view, true, enumSet, this.w, this, fi(), null);
        }
        return new l(context, view, true, enumSet, this.w, this, false);
    }

    private View n(final Context context) {
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
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.kx.n.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
