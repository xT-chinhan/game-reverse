package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t implements dg<PointF> {
    public static final t n = new t();

    private t() {
    }

    @Override // com.byazt.ur.dg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF qg(JsonReader jsonReader, float f) throws IOException {
        return um.qg(jsonReader, f);
    }
}
