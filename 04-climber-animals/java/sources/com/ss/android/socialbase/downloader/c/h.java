package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
class h {
    private boolean ab;
    final String ah;
    private int c;
    private final AtomicLong ch;
    final boolean d;
    private final List<zb> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final String f4615ms;
    private String ny;
    private int x;
    final String xr;

    public h(String str, boolean z) {
        this.ka = new ArrayList();
        this.ch = new AtomicLong();
        this.f4615ms = str;
        this.d = z;
        this.xr = null;
        this.ah = null;
    }

    public h(String str, String str2) {
        this.ka = new ArrayList();
        this.ch = new AtomicLong();
        this.f4615ms = str;
        this.d = false;
        this.xr = str2;
        this.ah = ms(str2);
    }

    private String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(j.z);
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return null;
        }
    }

    public synchronized void ms(zb zbVar) {
        this.ka.add(zbVar);
    }

    public synchronized void xr(zb zbVar) {
        try {
            this.ka.remove(zbVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized int ms() {
        return this.ka.size();
    }

    public synchronized void xr() {
        this.c++;
        this.ab = true;
    }

    public synchronized void ah() {
        this.ab = false;
    }

    public synchronized boolean d() {
        return this.ab;
    }

    public void ms(long j) {
        this.ch.addAndGet(j);
    }

    public int hashCode() {
        if (this.x == 0) {
            this.x = ka().hashCode();
        }
        return this.x;
    }

    private String ka() {
        if (this.ny == null) {
            StringBuilder sbAppend = new StringBuilder().append(this.f4615ms).append("_");
            String str = this.xr;
            if (str == null) {
                str = "";
            }
            this.ny = sbAppend.append(str).append("_").append(this.d).toString();
        }
        return this.ny;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return ka().equals(((h) obj).ka());
        }
        return false;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f4615ms + "', ip='" + this.xr + "', ipFamily='" + this.ah + "', isMainUrl=" + this.d + ", failedTimes=" + this.c + ", isCurrentFailed=" + this.ab + AbstractJsonLexerKt.END_OBJ;
    }
}
