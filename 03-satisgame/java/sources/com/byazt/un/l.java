package com.byazt.un;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 18})
public class l implements com.byazt.lz.n {
    @Override // com.byazt.lz.n
    public View qg(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387810);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setVisibility(8);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387954);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        relativeLayout.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387847);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setVisibility(8);
        sz.n(context, "tt_new_play_video", (View) imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
