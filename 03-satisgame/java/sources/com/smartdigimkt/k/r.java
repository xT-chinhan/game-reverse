package com.smartdigimkt.k;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public long A;
    public long B;
    public int C;
    public String F;
    public int G;
    public String a;
    public String b;
    public String c;
    public Bitmap d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public com.smartdigimkt.b3.c j;
    public com.smartdigimkt.a3.a k;
    public String l;
    public com.smartdigimkt.g3.b m;
    public String n;
    public String o;
    public int q;
    public int r;
    public String t;
    public String u;
    public String v;
    public String w;
    public int y;
    public boolean z;
    public boolean p = false;
    public volatile c s = c.IDLE;
    public int x = 2;
    public int D = 4;
    public String E = "";

    public final String a() {
        if (!TextUtils.isEmpty(this.w)) {
            return this.w;
        }
        String strA = com.smartdigimkt.n.c.a(this.o);
        this.w = strA;
        return strA;
    }

    public final boolean b() {
        if (this.z) {
            return true;
        }
        if (TextUtils.isEmpty(a())) {
            return false;
        }
        try {
            return new File(com.smartdigimkt.n.c.a(1, this.w)).exists();
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public final String toString() {
        return "ApkRequest{requestId='" + this.a + "', url='" + this.b + "', title='" + this.c + "', icon=" + this.d + ", pkgName='" + this.e + "', offerId='" + this.f + "', progress=" + this.g + ", apkSize=" + this.h + ", downloadTime=" + this.i + ", baseAdContent=" + this.j + ", deeplinkUrl='" + this.l + "', deeplinkClickAction=" + this.m + ", clickId='" + this.n + "', uniqueID='" + this.o + "', useWebViewUa=" + this.p + ", notificationType=" + this.q + ", downloadType=" + this.r + ", status=" + this.s + ", apkFilePath='" + this.w + "', partCount=" + this.x + ", enablePartDownload=" + this.z + ", downloadStartTimeStamp=" + this.A + ", downloadFinishTimeStamp=" + this.B + ", placementId=" + this.t + ", adSourceId=" + this.u + ", networkFirmId=" + this.v + ", installScene=" + this.y + ", downloadingScene=" + this.C + ", recoverDownloadScene=" + this.D + ", downloadFailedSceneList=" + this.E + ", actionOfferDownloadTk=" + this.F + ", isUploadInstalledAgentEvent=" + this.G + AbstractJsonLexerKt.END_OBJ;
    }

    public final void a(int i) {
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
}
