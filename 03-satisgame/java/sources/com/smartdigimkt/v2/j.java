package com.smartdigimkt.v2;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ p b;

    public j(p pVar, d dVar) {
        this.b = pVar;
        this.a = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015c A[Catch: all -> 0x0163, TryCatch #0 {, blocks: (B:87:0x0152, B:89:0x015c, B:90:0x0161), top: B:98:0x0152 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        b bVarA;
        String str;
        try {
            d dVar = this.a;
            if (dVar != null) {
                this.b.getClass();
                if (p.a(dVar)) {
                    this.b.getClass();
                }
                bVarA = this.a.a();
                synchronized (this.b.f) {
                    try {
                        int iB = this.a.b();
                        if (iB != 1) {
                            if (iB == 2) {
                                this.b.e.put(bVarA.f, bVarA);
                                String str2 = bVarA.a;
                                if (!TextUtils.isEmpty(str2)) {
                                    p pVar = this.b;
                                    if (pVar.t == null) {
                                        pVar.t = Long.valueOf(System.currentTimeMillis());
                                    }
                                    this.b.s.remove(str2);
                                    p pVar2 = this.b;
                                    pVar2.t = Long.valueOf(Math.min(pVar2.t.longValue(), bVarA.b));
                                }
                            }
                        } else if (!TextUtils.isEmpty(bVarA.f) && bVarA.c) {
                            this.b.d.put(bVarA.f, bVarA.d);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else {
                bVarA = null;
            }
            d dVar2 = this.a;
            if (dVar2 != null && dVar2.b() == 2) {
                p.a(this.b, this.a, bVarA);
                this.b.getClass();
                str = bVarA != null ? bVarA.f : null;
                if (TextUtils.isEmpty(str)) {
                    d dVar3 = this.a;
                    if (dVar3 instanceof d) {
                        str = dVar3.c;
                    }
                }
                p.a(this.b, str);
            }
            p pVar3 = this.b;
            d dVar4 = this.a;
            pVar3.getClass();
            if (!p.a(dVar4) && (bVarA == null || bVarA.e)) {
                long j = this.b.b;
                if (j > 0) {
                    try {
                        Thread.sleep(j);
                    } catch (Throwable unused) {
                    }
                }
            }
            p.b(this.b);
            this.b.a();
            synchronized (this.b.f) {
                if (this.b.c.isEmpty()) {
                    p.c(this.b);
                }
            }
            return;
        } catch (Throwable unused2) {
            bVarA = null;
        }
        d dVar5 = this.a;
        if (dVar5 != null && dVar5.b() == 2) {
            p.a(this.b, this.a, bVarA);
            this.b.getClass();
            str = bVarA != null ? bVarA.f : null;
            if (TextUtils.isEmpty(str)) {
                d dVar6 = this.a;
                if (dVar6 instanceof d) {
                    str = dVar6.c;
                }
            }
            p.a(this.b, str);
        }
        p pVar4 = this.b;
        d dVar7 = this.a;
        pVar4.getClass();
        if (!p.a(dVar7) && (bVarA == null || bVarA.e)) {
            long j2 = this.b.b;
            if (j2 > 0) {
                try {
                    Thread.sleep(j2);
                } catch (Throwable unused3) {
                }
            }
        }
        p.b(this.b);
        this.b.a();
        synchronized (this.b.f) {
            if (this.b.c.isEmpty()) {
                p.c(this.b);
            }
        }
        p.b(this.b);
        this.b.a();
        synchronized (this.b.f) {
            if (this.b.c.isEmpty()) {
                p.c(this.b);
            }
        }
    }
}
