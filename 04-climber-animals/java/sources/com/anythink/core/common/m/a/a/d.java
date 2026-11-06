package com.anythink.core.common.m.a.a;

import com.anythink.core.common.m.a.i;
import com.anythink.core.common.n.b.k;
import com.anythink.core.common.n.b.p;
import com.anythink.core.common.n.b.q;
import com.anythink.core.common.n.b.z;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static volatile d b;
    private volatile z c;
    private volatile z d;
    private final k e = new k(10, TimeUnit.MINUTES);

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final synchronized z a(com.anythink.core.common.m.a.f fVar, i iVar) {
        z zVar;
        com.anythink.core.common.m.a.d dVar = fVar.i;
        if (dVar != null) {
            if (this.d == null) {
                this.d = new z.a().c(fVar.c, fVar.d).b(fVar.a, fVar.b).a(fVar.e, fVar.f).a(this.e).a(new p(fVar.g)).a(new a(dVar)).a();
            } else {
                this.d = this.d.t().a(new a(dVar)).a();
            }
            zVar = this.d;
            Object[] objArr = new Object[1];
            String str = iVar.a;
        } else {
            zVar = null;
        }
        if (zVar == null) {
            if (this.c == null) {
                this.c = new z.a().c(fVar.c, fVar.d).b(fVar.a, fVar.b).a(fVar.e, fVar.f).a(this.e).a(new p(fVar.g)).a();
            }
            zVar = this.c;
            Object[] objArr2 = new Object[1];
            String str2 = iVar.a;
        }
        return zVar;
    }

    private static class a implements q {
        private final com.anythink.core.common.m.a.d b;

        public a(com.anythink.core.common.m.a.d dVar) {
            this.b = dVar;
        }

        @Override // com.anythink.core.common.n.b.q
        public final List<InetAddress> lookup(String str) {
            com.anythink.core.common.m.a.d dVar = this.b;
            return dVar != null ? dVar.a(str) : q.a.lookup(str);
        }
    }
}
