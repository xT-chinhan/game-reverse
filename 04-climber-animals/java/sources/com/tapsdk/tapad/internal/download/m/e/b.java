package com.tapsdk.tapad.internal.download.m.e;

import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.i;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private boolean a;
    private boolean b;
    ResumeFailedCause c;
    private long d;
    private final com.tapsdk.tapad.internal.download.f e;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.c f;

    public b(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        this.e = fVar;
        this.f = cVar;
    }

    public void a() throws IOException {
        g gVarF = i.j().f();
        c cVarB = b();
        cVarB.a();
        boolean zF = cVarB.f();
        boolean zG = cVarB.g();
        long jB = cVarB.b();
        String strD = cVarB.d();
        String strE = cVarB.e();
        int iC = cVarB.c();
        gVarF.a(strE, this.e, this.f);
        this.f.a(zG);
        this.f.a(strD);
        if (i.j().e().h(this.e)) {
            throw com.tapsdk.tapad.internal.download.m.f.b.a;
        }
        ResumeFailedCause resumeFailedCauseA = gVarF.a(iC, this.f.i() != 0, this.f, strD);
        boolean z = resumeFailedCauseA == null;
        this.b = z;
        this.c = resumeFailedCauseA;
        this.d = jB;
        this.a = zF;
        if (a(iC, jB, z)) {
            return;
        }
        if (gVarF.a(iC, this.f.i() != 0)) {
            throw new com.tapsdk.tapad.internal.download.m.f.i(iC, this.f.i());
        }
    }

    boolean a(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }

    c b() {
        return new c(this.e, this.f);
    }

    public ResumeFailedCause c() {
        return this.c;
    }

    public ResumeFailedCause d() {
        ResumeFailedCause resumeFailedCause = this.c;
        if (resumeFailedCause != null) {
            return resumeFailedCause;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.b);
    }

    public long e() {
        return this.d;
    }

    public boolean f() {
        return this.a;
    }

    public boolean g() {
        return this.b;
    }

    public String toString() {
        return "acceptRange[" + this.a + "] resumable[" + this.b + "] failedCause[" + this.c + "] instanceLength[" + this.d + "] " + super.toString();
    }
}
