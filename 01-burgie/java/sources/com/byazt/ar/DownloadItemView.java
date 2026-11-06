package com.byazt.ar;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.hg.of;
import com.byazt.hg.y;
import com.byazt.pi.TTRatingBar;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.sdv.c;
import com.byazt.ub.hw;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO, 1293})
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void pr(of ofVar) {
        String strSe;
        if (ofVar == null) {
            return;
        }
        Context context = getContext();
        addView(c.e(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(er.hn(context, 12.0f));
            tTRatingBar.setStarImageHeight(er.hn(context, 12.0f));
            tTRatingBar.setStarImagePadding(er.hn(context, 4.0f));
            tTRatingBar.pr();
        }
        if (textView4 != null) {
            int iUc = 6870;
            if (ofVar.ho() != null) {
                iUc = ofVar.ho().uc();
            }
            textView4.setText(String.format("%1$s个评分", iUc > 10000 ? (iUc / 10000) + "万" : String.valueOf(iUc)));
        }
        if (tTRoundRectImageView != null) {
            y yVarMo = ofVar.mo();
            if (yVarMo != null && !TextUtils.isEmpty(yVarMo.pr())) {
                hw.pr(yVarMo).pr(tTRoundRectImageView);
            } else {
                g.pr(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (textView != null) {
            textView.setText(ls.cz(ofVar));
        }
        if (textView2 != null) {
            textView2.setText(ls.ny(ofVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(ofVar.se())) {
                if (ofVar.aj() == 4) {
                    strSe = "立即下载";
                } else {
                    strSe = "查看详情";
                }
            } else {
                strSe = ofVar.se();
            }
            textView3.setText(strSe);
        }
    }
}
