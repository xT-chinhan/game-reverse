package com.byazt.un;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 101})
public class fs implements com.byazt.lz.n {
    @Override // com.byazt.lz.n
    public View qg(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387870);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(16);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387817);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        textView.setLayoutParams(layoutParams);
        textView.setIncludeFontPadding(false);
        textView.setText("播放将消耗");
        textView.setTextColor(13290186);
        textView.setTextSize(2, 14.0f);
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387880);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387817);
        layoutParams2.addRule(13, -1);
        relativeLayout2.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387800);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 44.0f), com.byazt.okk.s.s(context, 44.0f));
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(14, -1);
        imageView.setLayoutParams(layoutParams3);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        sz.n(context, "tt_new_play_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(imageView);
        relativeLayout.addView(relativeLayout2);
        return relativeLayout;
    }
}
