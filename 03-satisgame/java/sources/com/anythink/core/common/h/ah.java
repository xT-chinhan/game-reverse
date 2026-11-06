package com.anythink.core.common.h;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    private long A;
    private int B;
    private int C;
    private int D;
    private int E;
    private String F = "";
    private String G;
    private String H;
    private String I;
    private String J;
    private long K;
    private long L;
    private long M;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q;
    private String r;
    private int s;
    private String t;
    private String u;
    private String v;
    private String w;
    private int x;
    private boolean y;
    private long z;

    private int a() {
        return this.D;
    }

    private void a(int i) {
        this.D = i;
    }

    private int b() {
        return this.E;
    }

    private void b(int i) {
        this.E = i;
    }

    private String c() {
        return this.F;
    }

    private void a(String str) {
        this.F = str;
    }

    private String d() {
        return this.H;
    }

    private void b(String str) {
        this.H = str;
    }

    private String e() {
        return this.I;
    }

    private void c(String str) {
        this.I = str;
    }

    private String f() {
        return this.J;
    }

    private void d(String str) {
        this.J = str;
    }

    private String g() {
        return this.w;
    }

    private void e(String str) {
        this.w = str;
    }

    private int h() {
        return this.x;
    }

    private void c(int i) {
        this.x = i;
    }

    private boolean i() {
        return this.y;
    }

    private void a(boolean z) {
        this.y = z;
    }

    private String j() {
        return this.a;
    }

    private void f(String str) {
        this.a = str;
    }

    private String k() {
        return this.b;
    }

    private void g(String str) {
        this.b = str;
    }

    private String l() {
        return this.c;
    }

    private void h(String str) {
        this.c = str;
    }

    private String m() {
        return this.d;
    }

    private void i(String str) {
        this.d = str;
    }

    private String n() {
        return this.e;
    }

    private void j(String str) {
        this.e = str;
    }

    private String o() {
        return this.f;
    }

    private void k(String str) {
        this.f = str;
    }

    private String p() {
        return this.g;
    }

    private void l(String str) {
        this.g = str;
    }

    private String q() {
        return this.h;
    }

    private void m(String str) {
        this.h = str;
    }

    private int r() {
        return this.j;
    }

    private void d(int i) {
        this.j = i;
    }

    private int s() {
        return this.k;
    }

    private void e(int i) {
        this.k = i;
    }

    private int t() {
        return this.l;
    }

    private void f(int i) {
        this.l = i;
    }

    private int u() {
        return this.m;
    }

    private void g(int i) {
        this.m = i;
    }

    private String v() {
        return this.q;
    }

    private void n(String str) {
        this.q = str;
    }

    private String w() {
        return this.r;
    }

    private void o(String str) {
        this.r = str;
    }

    private boolean x() {
        return this.i == 1;
    }

    private void h(int i) {
        this.i = i;
    }

    private int y() {
        return this.i;
    }

    private int z() {
        return this.s;
    }

    private void i(int i) {
        this.s = i;
    }

    private long A() {
        return this.z;
    }

    private void a(long j) {
        this.z = j;
    }

    private long B() {
        return this.A;
    }

    private void b(long j) {
        this.A = j;
    }

    private int C() {
        return this.n;
    }

    private void j(int i) {
        this.n = i;
    }

    private int D() {
        return this.B;
    }

    private void k(int i) {
        this.B = i;
    }

    private int E() {
        return this.C;
    }

    private void l(int i) {
        this.C = i;
    }

    private long F() {
        return this.K;
    }

    private void c(long j) {
        this.K = j;
    }

    private long G() {
        return this.L;
    }

    private void d(long j) {
        this.L = j;
    }

    private int H() {
        return this.o;
    }

    private void m(int i) {
        this.o = i;
    }

    private int I() {
        return this.p;
    }

    private void n(int i) {
        this.p = i;
    }

    private long J() {
        return this.M;
    }

    private void e(long j) {
        this.M = j;
    }

    private void p(String str) {
        this.t = str;
    }

    private String K() {
        return this.t;
    }

    private void q(String str) {
        this.u = str;
    }

    private String L() {
        return this.u;
    }

    private String M() {
        return this.G;
    }

    private void r(String str) {
        this.G = str;
    }

    private String N() {
        return this.v;
    }

    private void s(String str) {
        this.v = str;
    }

    public final String toString() {
        return "DownloadTaskBean{uniqueID='" + this.a + "', clickId='" + this.b + "', requestId='" + this.c + "', offerId='" + this.d + "', url='" + this.e + "', pkgName='" + this.f + "', title='" + this.g + "', deeplinkClickAction='" + this.h + "', enableUseWebViewUa=" + this.i + ", downloadType=" + this.j + ", notificationType=" + this.k + ", intOpenSwitch=" + this.l + ", intOpenTime=" + this.m + ", apkVerify=" + this.n + ", apkReDownload=" + this.o + ", apkAllowInstallInBg=" + this.p + ", iconUrl='" + this.q + "', deeplinkUrl='" + this.r + "', offerSourceType=" + this.s + ", appName='" + this.t + "', filePath='" + this.w + "', partCount=" + this.x + ", enablePartDownload=" + this.y + ", downloadStartTimeStamp=" + this.z + ", downloadEndTimeStamp=" + this.A + ", status=" + this.B + ", isUploadInstalledAgentEvent=" + this.C + ", downloadingScene=" + this.D + ", recoverDownloadScene=" + this.E + ", downloadFailedSceneList='" + this.F + "', actionOfferDownloadTk='" + this.G + "', placementId='" + this.H + "', adSourceId='" + this.I + "', networkFirmId='" + this.J + "', progress=" + this.K + ", fileSize=" + this.L + ", offerCacheTime=" + this.M + ", dspId=" + this.u + ", desc=" + this.v + AbstractJsonLexerKt.END_OBJ;
    }
}
