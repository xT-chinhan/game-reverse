package com.anythink.core.common.m.b.a.c;

import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.ae;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.m;
import com.anythink.core.common.m.b.n;
import com.anythink.core.common.m.b.w;
import com.anythink.core.common.m.b.x;
import com.anythink.core.common.m.c.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements w {
    private final n a;

    public a(n nVar) {
        this.a = nVar;
    }

    @Override // com.anythink.core.common.m.b.w
    public final af a(w.a aVar) {
        ad adVarA = aVar.a();
        ad.a aVarE = adVarA.e();
        ae aeVarD = adVarA.d();
        if (aeVarD != null) {
            x xVarA = aeVarD.a();
            if (xVarA != null) {
                aVarE.a(com.anythink.core.common.l.b.g, xVarA.toString());
            }
            long jB = aeVarD.b();
            if (jB != -1) {
                aVarE.a("Content-Length", Long.toString(jB));
                aVarE.b("Transfer-Encoding");
            } else {
                aVarE.a("Transfer-Encoding", "chunked");
                aVarE.b("Content-Length");
            }
        }
        if (adVarA.a("Host") == null) {
            aVarE.a("Host", com.anythink.core.common.m.b.a.c.a(adVarA.a(), false));
        }
        if (adVarA.a("Connection") == null) {
            aVarE.a("Connection", "Keep-Alive");
        }
        n nVar = this.a;
        adVarA.a();
        List<m> listB = nVar.b();
        if (!listB.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = listB.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                m mVar = listB.get(i);
                sb.append(mVar.a()).append('=').append(mVar.b());
            }
            aVarE.a("Cookie", sb.toString());
        }
        af afVarA = aVar.a(aVarE.b());
        e.a(this.a, adVarA.a(), afVarA.g());
        af.a aVarA = afVarA.i().a(adVarA);
        if ("gzip".equalsIgnoreCase(afVarA.a("Content-Encoding")) && e.d(afVarA)) {
            l lVar = new l(afVarA.h().c());
            aVarA.a(afVarA.g().b().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(afVarA.a(com.anythink.core.common.l.b.g), -1L, com.anythink.core.common.m.c.n.a(lVar)));
        }
        return aVarA.a();
    }

    private static String a(List<m> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            m mVar = list.get(i);
            sb.append(mVar.a()).append('=').append(mVar.b());
        }
        return sb.toString();
    }
}
