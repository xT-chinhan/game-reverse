package com.byazt.shh;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 13})
public class hw {
    public String aj;
    public String c;
    public String fw;
    public String hn;
    public long hw;
    public long pr;
    public String uc;
    public String x;
    public final List<Pair<String, String>> zo = new ArrayList();

    public long pr() {
        return pr(this.pr, this.hw);
    }

    public static long pr(long j, long j2) {
        return j > 0 ? j : j2;
    }
}
