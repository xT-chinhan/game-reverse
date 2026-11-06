package com.byazt.un;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.kfh.TTProgressBar;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 8})
public class s extends n {
    @Override // com.byazt.lz.n
    public View qg(final Context context) {
        RelativeLayout relativeLayoutN = n(context, 2114387616);
        relativeLayoutN.addView(qg(context, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FRAMES_DROP));
        relativeLayoutN.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387911);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, com.byazt.okk.s.s(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayoutN.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387742);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, com.byazt.okk.s.s(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("数据加载中...");
        relativeLayoutN.addView(textView2);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387683);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 32.0f), com.byazt.okk.s.s(context, 32.0f));
        layoutParams3.addRule(3, 2114387807);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, com.byazt.okk.s.s(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        sz.n(context, "tt_live_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.un.s.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayoutN.addView(tTProgressBar);
        relativeLayoutN.addView(n(context, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, 6));
        return relativeLayoutN;
    }
}
