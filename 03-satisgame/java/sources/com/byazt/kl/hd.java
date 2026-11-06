package com.byazt.kl;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd {
    public int fs;
    public final List<oa> l;
    public final String n;
    public final boolean q;
    public final String qg;
    public String rv;
    public final String s;
    public final AtomicLong tj;
    public int w;
    public boolean x;

    public hd(String str, boolean z) {
        this.l = new ArrayList();
        this.tj = new AtomicLong();
        this.n = str;
        this.q = z;
        this.qg = null;
        this.s = null;
    }

    public hd(String str, String str2) {
        this.l = new ArrayList();
        this.tj = new AtomicLong();
        this.n = str;
        this.q = false;
        this.qg = str2;
        this.s = n(str2);
    }

    private String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(i.E);
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void n(oa oaVar) {
        this.l.add(oaVar);
    }

    public synchronized void qg(oa oaVar) {
        try {
            this.l.remove(oaVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int n() {
        return this.l.size();
    }

    public synchronized void qg() {
        this.w++;
        this.x = true;
    }

    public synchronized void s() {
        this.x = false;
    }

    public synchronized boolean q() {
        return this.x;
    }

    public void n(long j) {
        this.tj.addAndGet(j);
    }

    public int hashCode() {
        if (this.fs == 0) {
            this.fs = l().hashCode();
        }
        return this.fs;
    }

    private String l() {
        if (this.rv == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.n).append("_");
            String str = this.qg;
            if (str == null) {
                str = "";
            }
            this.rv = sbAppend.append(str).append("_").append(this.q).toString();
        }
        return this.rv;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof hd) {
            return l().equals(((hd) obj).l());
        }
        return false;
    }

    public String toString() {
        return "UrlRecord{url='" + this.n + "', ip='" + this.qg + "', ipFamily='" + this.s + "', isMainUrl=" + this.q + ", failedTimes=" + this.w + ", isCurrentFailed=" + this.x + AbstractJsonLexerKt.END_OBJ;
    }
}
