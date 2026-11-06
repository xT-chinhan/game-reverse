package com.byazt.stx;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public String aj;
    public final List<m> c;
    public boolean fw;
    public final String hn;
    public final String hw;
    public final String pr;
    public int uc;
    public final AtomicLong vk;
    public final boolean x;
    public int zo;

    public yb(String str, boolean z) {
        this.c = new ArrayList();
        this.vk = new AtomicLong();
        this.pr = str;
        this.x = z;
        this.hw = null;
        this.hn = null;
    }

    public yb(String str, String str2) {
        this.c = new ArrayList();
        this.vk = new AtomicLong();
        this.pr = str;
        this.x = false;
        this.hw = str2;
        this.hn = pr(str2);
    }

    private String pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int iLastIndexOf = str.lastIndexOf(".");
                if (iLastIndexOf > 0 && iLastIndexOf < str.length()) {
                    return str.substring(0, iLastIndexOf);
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public synchronized void pr(m mVar) {
        this.c.add(mVar);
    }

    public synchronized void hw(m mVar) {
        try {
            this.c.remove(mVar);
        } catch (Throwable th) {
        }
    }

    public synchronized int pr() {
        return this.c.size();
    }

    public synchronized void hw() {
        this.uc++;
        this.fw = true;
    }

    public synchronized void hn() {
        this.fw = false;
    }

    public synchronized boolean x() {
        return this.fw;
    }

    public void pr(long j) {
        this.vk.addAndGet(j);
    }

    public int hashCode() {
        if (this.zo == 0) {
            this.zo = c().hashCode();
        }
        return this.zo;
    }

    private String c() {
        if (this.aj == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.pr).append("_");
            String str = this.hw;
            if (str == null) {
                str = "";
            }
            this.aj = sbAppend.append(str).append("_").append(this.x).toString();
        }
        return this.aj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yb)) {
            return false;
        }
        return c().equals(((yb) obj).c());
    }

    public String toString() {
        return "UrlRecord{url='" + this.pr + "', ip='" + this.hw + "', ipFamily='" + this.hn + "', isMainUrl=" + this.x + ", failedTimes=" + this.uc + ", isCurrentFailed=" + this.fw + AbstractJsonLexerKt.END_OBJ;
    }
}
