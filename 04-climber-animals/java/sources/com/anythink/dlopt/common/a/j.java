package com.anythink.dlopt.common.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class j {
    private long A;
    private long B;
    private int C;
    private String F;
    private int G;
    public String a;
    public String b;
    public String c;
    public Bitmap d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public w j;
    public x k;
    public String l;
    public com.anythink.core.common.k.b m;
    public String n;
    public String o;
    public int q;
    public int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private int y;
    private boolean z;
    public boolean p = false;
    private volatile c.e s = c.e.IDLE;
    private int x = 2;
    private int D = 4;
    private String E = "";

    public final c.e a() {
        return this.s;
    }

    public final boolean b() {
        return this.s == c.e.IDLE;
    }

    public final boolean c() {
        return this.s == c.e.PAUSE;
    }

    public final boolean d() {
        return this.s == c.e.STOP;
    }

    public final boolean e() {
        return this.s == c.e.LOADING;
    }

    public final void f() {
        this.s = c.e.IDLE;
    }

    public final boolean g() {
        return this.s == c.e.INSTALLED;
    }

    public final boolean h() {
        return this.s == c.e.FINISH;
    }

    public final boolean i() {
        return this.s == c.e.FAIL;
    }

    public final void j() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(4);
        }
        this.s = c.e.LOADING;
    }

    public final void k() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(7);
        }
        this.s = c.e.STOP;
    }

    public final void l() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(7);
        }
        this.s = c.e.PAUSE;
    }

    public final void m() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(5);
        }
        this.s = c.e.FINISH;
    }

    public final void n() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(2);
        }
        this.s = c.e.INSTALLED;
    }

    public final void o() {
        w wVar = this.j;
        if (wVar != null) {
            wVar.m(6);
        }
        this.s = c.e.FAIL;
    }

    public final long p() {
        return this.h - this.g;
    }

    public final boolean q() {
        if (this.z) {
            return true;
        }
        if (TextUtils.isEmpty(s())) {
            return false;
        }
        try {
            return new File(com.anythink.dlopt.common.c.b.a(this.w, 1)).exists();
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public final int r() {
        return this.x;
    }

    public final void a(int i) {
        this.x = i;
    }

    public final void a(String str) {
        this.w = str;
    }

    public final String s() {
        if (!TextUtils.isEmpty(this.w)) {
            return this.w;
        }
        String strB = com.anythink.dlopt.common.c.b.b(this.o);
        this.w = strB;
        return strB;
    }

    public final void a(boolean z) {
        this.z = z;
    }

    public final long t() {
        return this.A;
    }

    public final void a(long j) {
        this.A = j;
    }

    public final long u() {
        return this.B;
    }

    public final void b(long j) {
        this.B = j;
    }

    public final String v() {
        return this.t;
    }

    public final void b(String str) {
        this.t = str;
    }

    public final String w() {
        return this.u;
    }

    public final void c(String str) {
        this.u = str;
    }

    public final String x() {
        return this.v;
    }

    public final void d(String str) {
        this.v = str;
    }

    public final int y() {
        return this.y;
    }

    public final void b(int i) {
        this.y = i;
    }

    public final int z() {
        return this.C;
    }

    public final void c(int i) {
        this.C = i;
    }

    public final int A() {
        return this.D;
    }

    public final void d(int i) {
        this.D = i;
    }

    public final void e(String str) {
        this.E = str;
    }

    public final void e(int i) {
        String strValueOf = String.valueOf(i);
        if (TextUtils.isEmpty(this.E)) {
            this.E = strValueOf;
            return;
        }
        try {
            if (this.E.endsWith(strValueOf)) {
                return;
            }
            if (this.E.contains(strValueOf + ",")) {
                this.E = this.E.replace(strValueOf + ",", "");
            }
        } catch (Throwable unused) {
        }
        this.E += "," + i;
    }

    public final String B() {
        if (TextUtils.isEmpty(this.E)) {
            this.E = "1";
        }
        return this.E;
    }

    public final String C() {
        return this.F;
    }

    public final void f(String str) {
        this.F = str;
    }

    public final int D() {
        return this.G;
    }

    public final void f(int i) {
        this.G = i;
    }

    public String toString() {
        return "ApkRequest{requestId='" + this.a + "', url='" + this.b + "', title='" + this.c + "', icon=" + this.d + ", pkgName='" + this.e + "', offerId='" + this.f + "', progress=" + this.g + ", apkSize=" + this.h + ", downloadTime=" + this.i + ", baseAdContent=" + this.j + ", deeplinkUrl='" + this.l + "', deeplinkClickAction=" + this.m + ", clickId='" + this.n + "', uniqueID='" + this.o + "', useWebViewUa=" + this.p + ", notificationType=" + this.q + ", downloadType=" + this.r + ", status=" + this.s + ", apkFilePath='" + this.w + "', partCount=" + this.x + ", enablePartDownload=" + this.z + ", downloadStartTimeStamp=" + this.A + ", downloadFinishTimeStamp=" + this.B + ", placementId=" + this.t + ", adSourceId=" + this.u + ", networkFirmId=" + this.v + ", installScene=" + this.y + ", downloadingScene=" + this.C + ", recoverDownloadScene=" + this.D + ", downloadFailedSceneList=" + this.E + ", actionOfferDownloadTk=" + this.F + ", isUploadInstalledAgentEvent=" + this.G + AbstractJsonLexerKt.END_OBJ;
    }
}
