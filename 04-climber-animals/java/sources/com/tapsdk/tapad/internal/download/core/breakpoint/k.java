package com.tapsdk.tapad.internal.download.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class k implements l.a, i {
    private static final String e = "RemitStoreOnSQLite";
    private final m a;
    private final BreakpointStoreOnSQLite b;
    private final e c;
    private final i d;

    k(BreakpointStoreOnSQLite breakpointStoreOnSQLite) {
        this.a = new m(this);
        this.b = breakpointStoreOnSQLite;
        this.d = breakpointStoreOnSQLite.b;
        this.c = breakpointStoreOnSQLite.a;
    }

    k(m mVar, BreakpointStoreOnSQLite breakpointStoreOnSQLite, i iVar, e eVar) {
        this.a = mVar;
        this.b = breakpointStoreOnSQLite;
        this.d = iVar;
        this.c = eVar;
    }

    public static void h(int i) {
        g gVarA = com.tapsdk.tapad.internal.download.i.j().a();
        if (!(gVarA instanceof k)) {
            throw new IllegalStateException("The current store is " + gVarA + " not RemitStoreOnSQLite!");
        }
        ((k) gVarA).a.b = Math.max(0, i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public c a(com.tapsdk.tapad.internal.download.f fVar) throws IOException {
        return this.a.c(fVar.b()) ? this.d.a(fVar) : this.b.a(fVar);
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
        this.d.a(i, endCause, exc);
        if (endCause == EndCause.COMPLETED) {
            this.a.a(i);
        } else {
            this.a.b(i);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void a(c cVar, int i, long j) throws IOException {
        if (this.a.c(cVar.g())) {
            this.d.a(cVar, i, j);
        } else {
            this.b.a(cVar, i, j);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.l.a
    public void a(List<Integer> list) throws IOException {
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                f(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
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
        return this.a.c(cVar.g()) ? this.d.a(cVar) : this.b.a(cVar);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.g
    public int b(com.tapsdk.tapad.internal.download.f fVar) {
        return this.b.b(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public void b(int i) {
        this.b.b(i);
        this.a.d(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean c(int i) {
        return this.b.c(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.l.a
    public void d(int i) {
        this.c.d(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.i
    public boolean e(int i) {
        return this.b.e(i);
    }

    @Override // com.tapsdk.tapad.internal.download.core.breakpoint.l.a
    public void f(int i) throws IOException {
        this.c.d(i);
        c cVar = this.d.get(i);
        if (cVar == null || cVar.e() == null || cVar.i() <= 0) {
            return;
        }
        this.c.a(cVar);
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
        this.d.remove(i);
        this.a.a(i);
    }
}
