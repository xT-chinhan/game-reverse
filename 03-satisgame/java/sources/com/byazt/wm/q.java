package com.byazt.wm;

import android.text.TextUtils;
import com.anythink.core.common.l.b;
import com.byazt.m.x;
import com.byazt.ta.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 5})
public class q {
    public long l;
    public final String n;
    public long q;
    public final x qg;
    public final int s;

    public q(String str, x xVar) throws IOException {
        this.n = str;
        this.s = xVar.qg();
        this.qg = xVar;
    }

    public boolean n() {
        return w.s(this.s);
    }

    public boolean qg() {
        return w.n(this.s, this.qg.n("Accept-Ranges"));
    }

    public String s() {
        return this.qg.n("Etag");
    }

    public String q() {
        return this.qg.n(b.g);
    }

    public String l() {
        return w.qg(this.qg, "Content-Range");
    }

    public String w() {
        String strQg = w.qg(this.qg, "last-modified");
        return TextUtils.isEmpty(strQg) ? w.qg(this.qg, "Last-Modified") : strQg;
    }

    public String x() {
        return w.qg(this.qg, "Cache-Control");
    }

    public long fs() {
        if (this.q <= 0) {
            this.q = w.n(this.qg);
        }
        return this.q;
    }

    public boolean rv() {
        if (com.byazt.ta.n.n(8)) {
            return w.s(this.qg);
        }
        return w.qg(fs());
    }

    public long tj() {
        if (this.l <= 0) {
            if (!rv()) {
                String strL = l();
                if (!TextUtils.isEmpty(strL)) {
                    this.l = w.qg(strL);
                }
            } else {
                this.l = -1L;
            }
        }
        return this.l;
    }

    public long cp() {
        return w.rv(x());
    }
}
