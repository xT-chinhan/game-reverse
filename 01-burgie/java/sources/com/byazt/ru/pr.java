package com.byazt.ru;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.hl.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1084, 37})
public class pr extends hw {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.hl.hw
    public void pr(final ImageView imageView, String str) {
        g.pr(this.hw, str, new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.ru.pr.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                imageView.setImageDrawable(com.byazt.hl.pr.pr(bitmap));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
