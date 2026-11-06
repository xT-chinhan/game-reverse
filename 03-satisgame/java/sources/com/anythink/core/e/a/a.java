package com.anythink.core.e.a;

import com.anythink.core.common.l.p;
import com.anythink.core.common.l.s;
import com.anythink.core.common.s.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends p {
    private static final String a = "a";
    public static final int h = 0;
    public static final int i = 1;
    private List<Integer> b;
    com.anythink.core.common.s.a j;
    d k;
    d l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;

    protected abstract void a(int i2, p pVar);

    protected abstract void a(boolean z, int i2);

    protected abstract void b(int i2, Object obj);

    protected abstract boolean c();

    protected abstract long d();

    protected abstract long e();

    protected abstract void f();

    public a(boolean z, s sVar) {
        super(sVar);
        this.b = new ArrayList(4);
        this.q = 0;
        this.n = z;
        this.j = c.a();
    }

    public final void g() {
        d dVar = new d(e.dr, new Runnable() { // from class: com.anythink.core.e.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.o = true;
                if (a.this.h()) {
                    return;
                }
                a.this.k();
            }
        });
        this.k = dVar;
        this.j.a(dVar, d());
        a(0, (p) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (c()) {
            d dVar = new d(e.ds, new Runnable() { // from class: com.anythink.core.e.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.p = true;
                    if (a.this.h()) {
                        return;
                    }
                    a.this.f();
                }
            });
            this.l = dVar;
            this.j.a(dVar, e());
            a(1, (p) this);
            return;
        }
        f();
    }

    @Override // com.anythink.core.common.l.p
    protected final void a(int i2, Object obj) {
        if (i2 == 0) {
            this.q = 1;
        }
        a(i2, true);
        this.b.add(Integer.valueOf(i2));
        a(true, i2);
        if (i2 == 0 && this.b.size() == 2) {
            b(i2, obj);
        }
    }

    @Override // com.anythink.core.common.l.p
    protected final void a(int i2) {
        if (i2 == 0) {
            this.q = 2;
        }
        a(i2, false);
        a(false, i2);
        k();
    }

    private void a(int i2, boolean z) {
        d dVar;
        d dVar2;
        if (i2 == 0 && (dVar2 = this.k) != null && !this.o) {
            this.j.a(dVar2);
            this.k = null;
        } else {
            if (i2 != 1 || (dVar = this.l) == null || this.p) {
                return;
            }
            if (z || this.q != 0) {
                this.j.a(dVar);
                this.l = null;
            }
        }
    }

    public final boolean h() {
        return this.b.contains(0);
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.p;
    }
}
