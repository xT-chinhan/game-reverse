package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.res.ka;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void ms(lm lmVar) {
        String strBn;
        if (lmVar == null) {
            return;
        }
        Context context = getContext();
        addView(ka.pc(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387799);
        TextView textView = (TextView) findViewById(2114387881);
        TextView textView2 = (TextView) findViewById(2114387643);
        TextView textView3 = (TextView) findViewById(2114387836);
        TextView textView4 = (TextView) findViewById(2114387636);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387615);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(ul.ah(context, 12.0f));
            tTRatingBar.setStarImageHeight(ul.ah(context, 12.0f));
            tTRatingBar.setStarImagePadding(ul.ah(context, 4.0f));
            tTRatingBar.ms();
        }
        if (textView4 != null) {
            int iC = lmVar.zh() != null ? lmVar.zh().c() : 6870;
            textView4.setText(String.format(t.ms(context, "tt_comment_num"), iC > 10000 ? (iC / 10000) + "万" : String.valueOf(iC)));
        }
        if (tTRoundRectImageView != null) {
            g gVarQd = lmVar.qd();
            if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
                xr.ms(gVarQd).ms(tTRoundRectImageView);
            } else {
                t.ms(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(f.h(lmVar));
        }
        if (textView2 != null) {
            textView2.setText(f.qv(lmVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(lmVar.bn())) {
                strBn = lmVar.jr() != 4 ? "查看详情" : "立即下载";
            } else {
                strBn = lmVar.bn();
            }
            textView3.setText(strBn);
        }
    }
}
