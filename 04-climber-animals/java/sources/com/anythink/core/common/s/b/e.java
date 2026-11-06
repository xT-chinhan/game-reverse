package com.anythink.core.common.s.b;

import com.anythink.core.common.d.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.anythink.core.common.s.a {
    private static final String a = "e";
    private c b;
    private f c;
    private a d;
    private final com.anythink.core.common.s.c e;
    private String f;
    private int g;

    public e(com.anythink.core.common.s.c cVar) {
        this.e = cVar;
        this.f = cVar.b();
        this.g = cVar.c();
        this.b = d.a(cVar);
        this.c = d.b(cVar);
        this.d = new a(this.b, this.c);
        Object[] objArr = new Object[3];
        Integer.valueOf(this.g);
        Integer.valueOf(cVar.d());
    }

    @Override // com.anythink.core.common.s.a
    public final <V> void a(String str, V v) {
        com.anythink.core.common.s.c cVar = this.e;
        if (cVar != null) {
            a(str, v, cVar.d());
        } else {
            a(str, v, 1);
        }
    }

    @Override // com.anythink.core.common.s.a
    public final <V> void a(String str, V v, int i) {
        c cVar;
        if (c(str)) {
            b(str, v, i);
            return;
        }
        if (this.g == 1 && (cVar = this.b) != null) {
            cVar.a(str, v, i);
        } else {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a(str, v, i);
            }
        }
        Object[] objArr = new Object[5];
        Integer.valueOf(this.g);
        Integer.valueOf(i);
    }

    @Override // com.anythink.core.common.s.a
    public final <V> V b(String str, V v) {
        f fVar;
        if (!c(str)) {
            if (this.g == 0 && (fVar = this.c) != null) {
                v = (V) fVar.b(str, v);
            } else {
                c cVar = this.b;
                if (cVar != null) {
                    Object objB = cVar.b(str, v);
                    if ((objB == null || objB == v) && !this.b.c()) {
                        f fVar2 = this.c;
                        v = (V) (fVar2 != null ? fVar2.b(str, v) : null);
                        Object[] objArr = new Object[5];
                        Integer.valueOf(this.g);
                    } else {
                        v = (V) objB;
                    }
                }
            }
            Object[] objArr2 = new Object[5];
            Integer.valueOf(this.g);
            return v;
        }
        c cVarD = d();
        return cVarD != null ? (V) cVarD.b(str, v) : v;
    }

    @Override // com.anythink.core.common.s.a
    public final void b(String str) {
        c cVar;
        if (!c(str)) {
            if (this.g == 1 && (cVar = this.b) != null && cVar.c()) {
                this.b.b(str);
            } else {
                f fVar = this.c;
                if (fVar != null) {
                    fVar.b(str);
                }
            }
            Object[] objArr = new Object[3];
            Integer.valueOf(this.g);
            return;
        }
        c cVarD = d();
        if (cVarD != null) {
            cVarD.b(str);
        }
    }

    @Override // com.anythink.core.common.s.a
    public final void b() {
        c cVar;
        if (this.g == 1 && (cVar = this.b) != null && cVar.c()) {
            this.b.b();
        } else {
            f fVar = this.c;
            if (fVar != null) {
                fVar.b();
            }
        }
        Object[] objArr = new Object[2];
        Integer.valueOf(this.g);
    }

    @Override // com.anythink.core.common.s.a
    public final Map<String, Object> a() {
        Map<String, Object> mapA;
        c cVar;
        if (this.g == 1 && (cVar = this.b) != null && cVar.c()) {
            mapA = this.b.a();
        } else {
            f fVar = this.c;
            mapA = fVar != null ? fVar.a() : null;
        }
        Object[] objArr = new Object[3];
        Integer.valueOf(this.g);
        return mapA;
    }

    @Override // com.anythink.core.common.s.a
    public final boolean a(String str) {
        c cVar;
        boolean zA = false;
        if (!c(str)) {
            if (this.g == 1 && (cVar = this.b) != null && cVar.c()) {
                zA = this.b.a(str);
            } else {
                f fVar = this.c;
                if (fVar != null) {
                    zA = fVar.a(str);
                }
            }
            Object[] objArr = new Object[4];
            Integer.valueOf(this.g);
            Boolean.valueOf(zA);
            return zA;
        }
        c cVarD = d();
        return cVarD != null && cVarD.a(str);
    }

    private void a(com.anythink.core.common.s.c cVar) {
        this.f = cVar.b();
        this.g = cVar.c();
        this.b = d.a(cVar);
        this.c = d.b(cVar);
        this.d = new a(this.b, this.c);
    }

    public final void c() {
        a aVar = this.d;
        if (aVar == null || this.g != 1) {
            return;
        }
        aVar.a();
    }

    private boolean c(String str) {
        com.anythink.core.common.s.b.a();
        return com.anythink.core.common.s.b.a(str) && u.b.a.equals(this.f);
    }

    private c a(int i) {
        if (this.e == null) {
            return null;
        }
        return d.a(new com.anythink.core.common.s.c.a().a(this.e.a()).a(u.b.q).a(this.e.c()).b(i).a());
    }

    private c d() {
        com.anythink.core.common.s.c cVar = this.e;
        if (cVar != null) {
            return a(cVar.d());
        }
        return null;
    }

    private <V> void b(String str, V v, int i) {
        c cVarA = a(i);
        if (cVarA != null) {
            cVarA.a(str, v);
        }
    }

    private void d(String str) {
        c cVarD = d();
        if (cVarD != null) {
            cVarD.b(str);
        }
    }

    private <V> V c(String str, V v) {
        c cVarD = d();
        return cVarD != null ? (V) cVarD.b(str, v) : v;
    }

    private boolean e(String str) {
        c cVarD = d();
        return cVarD != null && cVarD.a(str);
    }
}
