package com.byazt.vy;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.qg.UGRatingBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2007, 2008})
public class UGNewRatingBar extends UGRatingBar {
    public UGNewRatingBar(Context context) {
        super(context);
    }

    @Override // com.byazt.qg.UGRatingBar
    public void pr(ImageView imageView, String str) {
        g.pr(getContext(), str, imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
