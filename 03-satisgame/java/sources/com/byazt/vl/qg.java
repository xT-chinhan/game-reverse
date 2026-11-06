package com.byazt.vl;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 26})
public class qg {
    public final List<Pair<String, String>> fs = new ArrayList();
    public String l;
    public long n;
    public String q;
    public long qg;
    public String rv;
    public String s;
    public String w;
    public String x;

    public static long n(long j, long j2) {
        return j > 0 ? j : j2;
    }

    public long n() {
        return n(this.n, this.qg);
    }
}
