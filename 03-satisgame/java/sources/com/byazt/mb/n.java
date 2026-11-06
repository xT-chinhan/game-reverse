package com.byazt.mb;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.jm.qg;
import com.byazt.jm.s;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 919, 19})
public class n extends s {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.jm.s
    public void n(final ImageView imageView, String str) {
        sz.n(this.qg, str, new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.mb.n.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                imageView.setImageDrawable(qg.n(bitmap));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
