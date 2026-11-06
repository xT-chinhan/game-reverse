package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.content.Context;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointStoreOnSQLite implements i {
    private static final String c = "BreakpointStoreOnSQLite";
    protected final e a;
    protected final h b;

    public BreakpointStoreOnSQLite(Context context) {
        e eVar = new e(context.getApplicationContext());
        this.a = eVar;
        this.b = new h(eVar.c(), eVar.a(), eVar.b());
    }

    BreakpointStoreOnSQLite(e eVar, h hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c a(com.tapsdk.tapad.internal.download.f fVar) throws IOException {
        c cVarA = this.b.a(fVar);
        this.a.a(cVarA);
        return cVarA;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c a(com.tapsdk.tapad.internal.download.f fVar, c cVar) {
        return this.b.a(fVar, cVar);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public String a(String str) {
        return this.b.a(str);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void a(int i, EndCause endCause, Exception exc) {
        this.b.a(i, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.a.d(i);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void a(c cVar, int i, long j) throws IOException {
        this.b.a(cVar, i, j);
        this.a.a(cVar, i, cVar.b(i).c());
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a(int i) {
        return this.b.a(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public boolean a(c cVar) throws IOException {
        boolean zA = this.b.a(cVar);
        this.a.c(cVar);
        String strE = cVar.e();
        com.tapsdk.tapad.internal.download.m.c.a(c, "update " + cVar);
        if (cVar.m() && strE != null) {
            this.a.a(cVar.j(), strE);
        }
        return zA;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public int b(com.tapsdk.tapad.internal.download.f fVar) {
        int iB = this.b.b(fVar);
        try {
            c cVar = this.b.get(iB);
            if (cVar != null && !cVar.j().equals(fVar.e())) {
                cVar.b(fVar.e());
                a(cVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iB;
    }

    void b() {
        this.a.close();
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void b(int i) {
        this.b.b(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean c(int i) {
        if (!this.b.c(i)) {
            return false;
        }
        this.a.b(i);
        return true;
    }

    public i createRemitSelf() {
        return new k(this);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean e(int i) {
        if (!this.b.e(i)) {
            return false;
        }
        this.a.a(i);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public c g(int i) {
        return null;
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c get(int i) {
        return this.b.get(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public void remove(int i) {
        this.b.remove(i);
        this.a.d(i);
    }
}
