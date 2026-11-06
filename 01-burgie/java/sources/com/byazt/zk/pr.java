package com.byazt.zk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1382, 37})
public class pr extends com.byazt.nu.pr {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.nu.pr
    public void w(String str) {
        g.pr(this.hw, str, new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.zk.pr.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                pr.this.hw(new BitmapDrawable(pr.this.hw.getResources(), bitmap));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
