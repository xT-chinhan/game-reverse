package com.smartdigimkt.d0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public volatile boolean a = false;
    public final k b;
    public final /* synthetic */ long c;
    public final /* synthetic */ q d;

    public n(q qVar, long j, long j2) {
        this.d = qVar;
        this.c = j2;
        k kVar = new k(this);
        this.b = kVar;
        com.smartdigimkt.m3.g.a().a.a(kVar, j);
    }

    public final void a(long j, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q qVar = this.d;
        if (qVar.g.w1 != 1) {
            a(0, j, "", str, true);
        } else {
            com.smartdigimkt.q3.f.a().a(new m(this, str, s.c(qVar.f), str2, j));
        }
    }

    public final void a(int i, long j, String str, String str2, boolean z) {
        if (this.a) {
            return;
        }
        this.a = true;
        com.smartdigimkt.m3.g.a().a(this.b);
        if (!z) {
            q qVar = this.d;
            com.smartdigimkt.n3.k.a(qVar.f, qVar.h, false, System.currentTimeMillis() - this.c, i, str, 0L, str2);
            this.d.a(5);
        } else {
            q qVar2 = this.d;
            com.smartdigimkt.n3.k.a(qVar2.f, qVar2.h, true, System.currentTimeMillis() - this.c, 0, "", j, str2);
            this.d.a(5);
        }
    }

    public final void a(int i, String str, String str2) {
        if (this.a) {
            return;
        }
        this.a = true;
        com.smartdigimkt.m3.g.a().a(this.b);
        q qVar = this.d;
        com.smartdigimkt.n3.k.a(qVar.f, qVar.h, false, System.currentTimeMillis() - this.c, i, str2, 0L, str);
        this.d.a(5);
    }
}
