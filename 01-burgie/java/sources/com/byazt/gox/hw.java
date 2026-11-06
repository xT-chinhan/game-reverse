package com.byazt.gox;

import com.byazt.ec.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 13})
public abstract class hw {
    public boolean hn;
    public int hw = 0;
    public final x pr;
    public volatile boolean x;

    public abstract boolean hn() throws JSONException;

    public abstract long[] hw();

    public abstract long pr();

    public abstract String x();

    public hw(x xVar) {
        this.pr = xVar;
    }

    public void c() {
        this.hn = true;
    }

    public boolean uc() {
        return this.hn;
    }

    public final long fw() {
        boolean zHn;
        long jPr = pr();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.x) {
            jPr = 0;
            this.x = false;
        }
        if (jPr <= 1000 + jCurrentTimeMillis) {
            try {
                zHn = hn();
            } catch (Exception e) {
                w.hw(e);
                zHn = false;
            }
            if (zHn) {
                this.hw = 0;
                return pr() - System.currentTimeMillis();
            }
            long[] jArrHw = hw();
            int i = this.hw;
            this.hw = i + 1;
            return jArrHw[i % jArrHw.length];
        }
        return jPr - jCurrentTimeMillis;
    }

    public void zo() {
        w.pr("setImmediately, " + x());
        this.x = true;
    }
}
