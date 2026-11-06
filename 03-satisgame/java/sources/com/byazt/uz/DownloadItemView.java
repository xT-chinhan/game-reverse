package com.byazt.uz;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.cb.qg;
import com.byazt.cp.n;
import com.byazt.gct.pk;
import com.byazt.gct.v;
import com.byazt.ndr.TTRatingBar;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.okk.s;
import com.byazt.tk.sz;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 748, 1419})
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void n(pk pkVar) {
        String strJb;
        if (pkVar == null) {
            return;
        }
        Context context = getContext();
        addView(qg.an(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(s.s(context, 12.0f));
            tTRatingBar.setStarImageHeight(s.s(context, 12.0f));
            tTRatingBar.setStarImagePadding(s.s(context, 4.0f));
            tTRatingBar.n();
        }
        if (textView4 != null) {
            int iW = pkVar.k() != null ? pkVar.k().w() : 6870;
            textView4.setText(String.format("%1$s个评分", iW > 10000 ? (iW / 10000) + "万" : String.valueOf(iW)));
        }
        if (tTRoundRectImageView != null) {
            v vVarXu = pkVar.xu();
            if (vVarXu != null && !TextUtils.isEmpty(vVarXu.n())) {
                com.byazt.imu.s.n(vVarXu).n(tTRoundRectImageView);
            } else {
                sz.n(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
        if (textView != null) {
            textView.setText(w.m(pkVar));
        }
        if (textView2 != null) {
            textView2.setText(w.hu(pkVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(pkVar.jb())) {
                strJb = pkVar.rv() != 4 ? "查看详情" : "立即下载";
            } else {
                strJb = pkVar.jb();
            }
            textView3.setText(strJb);
        }
    }
}
