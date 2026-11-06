package org.repackage.com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes4.dex */
class OpenId {
    long a;
    String b;
    String c;
    int d;

    OpenId(String str) {
        this.c = str;
    }

    void a(int i) {
        this.d = i;
    }

    void a(long j) {
        this.a = j;
    }

    void a(String str) {
        this.b = str;
    }

    boolean a() {
        return this.a > System.currentTimeMillis();
    }

    void b() {
        this.a = 0L;
    }
}
