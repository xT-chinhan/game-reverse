package com.byazt.auw;

import android.text.TextUtils;
import com.byazt.edb.fw;
import com.byazt.tuy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 121})
public class x {
    public long c;
    public final int hn;
    public final fw hw;
    public final String pr;
    public long x;

    public x(String str, fw fwVar) throws IOException {
        this.pr = str;
        this.hn = fwVar.hw();
        this.hw = fwVar;
    }

    public boolean pr() {
        return uc.hn(this.hn);
    }

    public boolean hw() {
        return uc.pr(this.hn, this.hw.pr(Util.ACCEPT_RANGES));
    }

    public String hn() {
        return this.hw.pr(Util.ETAG);
    }

    public String x() {
        return this.hw.pr("Content-Type");
    }

    public String c() {
        return uc.hw(this.hw, Util.CONTENT_RANGE);
    }

    public String uc() {
        String strHw = uc.hw(this.hw, "last-modified");
        if (TextUtils.isEmpty(strHw)) {
            return uc.hw(this.hw, "Last-Modified");
        }
        return strHw;
    }

    public String fw() {
        return uc.hw(this.hw, "Cache-Control");
    }

    public long zo() {
        if (this.x <= 0) {
            this.x = uc.pr(this.hw);
        }
        return this.x;
    }

    public boolean aj() {
        if (com.byazt.tuy.pr.pr(8)) {
            return uc.hn(this.hw);
        }
        return uc.hw(zo());
    }

    public long vk() {
        if (this.c <= 0) {
            if (!aj()) {
                String strC = c();
                if (!TextUtils.isEmpty(strC)) {
                    this.c = uc.hw(strC);
                }
            } else {
                this.c = -1L;
            }
        }
        return this.c;
    }

    public long w() {
        return uc.aj(fw());
    }
}
