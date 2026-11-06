package com.byazt.jf;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.fj.TTProgressBar;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 22, 20})
public class hn extends pr {
    @Override // com.byazt.bs.pr
    public View hw(final Context context) {
        RelativeLayout relativeLayoutPr = pr(context, 2114387616);
        relativeLayoutPr.addView(hw(context, 159));
        relativeLayoutPr.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387911);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, er.hn(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayoutPr.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387742);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, er.hn(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("数据加载中...");
        relativeLayoutPr.addView(textView2);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387683);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(er.hn(context, 32.0f), er.hn(context, 32.0f));
        layoutParams3.addRule(3, 2114387807);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, er.hn(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        g.pr(context, "tt_live_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jf.hn.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.pr(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayoutPr.addView(tTProgressBar);
        relativeLayoutPr.addView(pr(context, 158, 6));
        return relativeLayoutPr;
    }
}
