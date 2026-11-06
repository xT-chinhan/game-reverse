package com.byazt.guh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1775, 19})
public class n extends com.byazt.ny.n {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ny.n
    public void d(String str) {
        sz.n(this.qg, str, new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.guh.n.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                n.this.qg(new BitmapDrawable(n.this.qg.getResources(), bitmap));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
