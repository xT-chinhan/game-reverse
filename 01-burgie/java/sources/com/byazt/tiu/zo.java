package com.byazt.tiu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.byazt.fe.fw;
import com.byazt.fe.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public abstract class zo<R extends com.byazt.fe.uc, W extends com.byazt.fe.fw> {
    public int aj;
    public final R fw;
    public int k;
    public int vk;
    public int w;
    public int zo;
    public final Rect m = new Rect();
    public final Rect g = new Rect();

    public abstract Bitmap pr(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public zo(R r) {
        this.fw = r;
    }
}
