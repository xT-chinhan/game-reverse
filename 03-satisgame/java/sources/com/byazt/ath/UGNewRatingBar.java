package com.byazt.ath;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.far.UGRatingBar;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2254, 2440})
public class UGNewRatingBar extends UGRatingBar {
    public UGNewRatingBar(Context context) {
        super(context);
    }

    @Override // com.byazt.far.UGRatingBar
    public void n(ImageView imageView, String str) {
        sz.n(getContext(), str, imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
