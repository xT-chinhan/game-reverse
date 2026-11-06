package com.anythink.core.common.r.b;

import com.anythink.core.common.d.t;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.anythink.core.common.r.a {
    private static final String a = "e";
    private c b;
    private f c;
    private a d;
    private final com.anythink.core.common.r.c e;
    private String f;
    private int g;

    public e(com.anythink.core.common.r.c cVar) {
        this.e = cVar;
        this.f = cVar.b();
        this.g = cVar.c();
        this.b = d.a(cVar);
        this.c = d.b(cVar);
        this.d = new a(this.b, this.c);
    }

    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v) {
        com.anythink.core.common.r.c cVar = this.e;
        if (cVar != null) {
            a(str, v, cVar.d());
        } else {
            a(str, v, 1);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final <V> void a(String str, V v, int i) {
        c cVar;
        if (c(str)) {
            b(str, v, i);
            return;
        }
        if (this.g == 1 && (cVar = this.b) != null) {
            cVar.a(str, v, i);
            return;
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(str, v, i);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map) {
        com.anythink.core.common.r.c cVar = this.e;
        if (cVar != null) {
            a(map, cVar.d());
        } else {
            a(map, 1);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void a(Map<String, Object> map, int i) {
        c cVar;
        if (this.g == 1 && (cVar = this.b) != null) {
            cVar.a(map, i);
            return;
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(map, i);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final <V> V b(String str, V v) {
        Object objB;
        f fVar;
        if (!c(str)) {
            if (this.g == 0 && (fVar = this.c) != null) {
                objB = fVar.b(str, v);
            } else {
                c cVar = this.b;
                if (cVar == null) {
                    return v;
                }
                V v2 = (V) cVar.b(str, v);
                if ((v2 != null && v2 != v) || this.b.d()) {
                    return v2;
                }
                f fVar2 = this.c;
                objB = fVar2 != null ? fVar2.b(str, v) : null;
            }
            return (V) objB;
        }
        c cVarE = e();
        return cVarE != null ? (V) cVarE.b(str, v) : v;
    }

    @Override // com.anythink.core.common.r.a
    public final void b(String str) {
        c cVar;
        if (!c(str)) {
            if (this.g == 1 && (cVar = this.b) != null && cVar.d()) {
                this.b.b(str);
                return;
            }
            f fVar = this.c;
            if (fVar != null) {
                fVar.b(str);
                return;
            }
            return;
        }
        c cVarE = e();
        if (cVarE != null) {
            cVarE.b(str);
        }
    }

    @Override // com.anythink.core.common.r.a
    public final void b() {
        c cVar;
        if (this.g == 1 && (cVar = this.b) != null && cVar.d()) {
            this.b.b();
            return;
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.anythink.core.common.r.a
    public final Map<String, Object> a() {
        c cVar;
        if (this.g == 1 && (cVar = this.b) != null && cVar.d()) {
            return this.b.a();
        }
        f fVar = this.c;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // com.anythink.core.common.r.a
    public final boolean a(String str) {
        c cVar;
        if (!c(str)) {
            if (this.g == 1 && (cVar = this.b) != null && cVar.d()) {
                return this.b.a(str);
            }
            f fVar = this.c;
            if (fVar != null) {
                return fVar.a(str);
            }
            return false;
        }
        c cVarE = e();
        return cVarE != null && cVarE.a(str);
    }

    private void a(com.anythink.core.common.r.c cVar) {
        this.f = cVar.b();
        this.g = cVar.c();
        this.b = d.a(cVar);
        this.c = d.b(cVar);
        this.d = new a(this.b, this.c);
    }

    public final void d() {
        a aVar = this.d;
        if (aVar == null || this.g != 1) {
            return;
        }
        aVar.a();
    }

    private boolean c(String str) {
        com.anythink.core.common.r.b.a();
        return com.anythink.core.common.r.b.a(str) && t.b.a.equals(this.f);
    }

    private c a(int i) {
        if (this.e == null) {
            return null;
        }
        return d.a(new com.anythink.core.common.r.c.a().a(this.e.a()).a(t.b.m).a(this.e.c()).b(i).a());
    }

    public final c e() {
        com.anythink.core.common.r.c cVar = this.e;
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
        c cVarE = e();
        if (cVarE != null) {
            cVarE.b(str);
        }
    }

    private <V> V c(String str, V v) {
        c cVarE = e();
        return cVarE != null ? (V) cVarE.b(str, v) : v;
    }

    private boolean e(String str) {
        c cVarE = e();
        return cVarE != null && cVarE.a(str);
    }

    @Override // com.anythink.core.common.r.a
    public final int c() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.c();
        }
        return 0;
    }
}
