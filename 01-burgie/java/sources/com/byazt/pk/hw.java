package com.byazt.pk;

import android.os.SystemClock;
import com.byazt.nzn.aj;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import com.byazt.nzn.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 13})
public class hw {
    public static volatile long pr = 0;
    public static volatile String hw = "0";

    public static String pr() {
        if (System.currentTimeMillis() - pr < 7200000) {
            return hw;
        }
        return "0";
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr implements aj {
        @Override // com.byazt.nzn.aj
        public nt pr(aj.pr prVar) throws IOException {
            yb ybVarUc;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            g gVarPr = prVar.pr();
            nt ntVarPr = prVar.pr(gVarPr);
            if (!TapHttp.METHOD_GET.equalsIgnoreCase(gVarPr.hn()) || (ybVarUc = ntVarPr.uc()) == null) {
                return ntVarPr;
            }
            long jPr = ybVarUc.pr();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 0 && jPr > 10240) {
                String unused = hw.hw = String.format("%.2f", Double.valueOf(((jPr / 1024.0d) / jElapsedRealtime2) * 1000.0d));
                long unused2 = hw.pr = System.currentTimeMillis();
                String unused3 = hw.hw;
            }
            return ntVarPr;
        }
    }
}
