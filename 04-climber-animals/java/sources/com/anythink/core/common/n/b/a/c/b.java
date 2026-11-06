package com.anythink.core.common.n.b.a.c;

import com.anythink.core.common.n.b.ad;
import com.anythink.core.common.n.b.af;
import com.anythink.core.common.n.b.w;
import com.anythink.core.common.n.c.n;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements w {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // com.anythink.core.common.n.b.w
    public final af a(w.a aVar) throws IOException {
        af afVarA;
        g gVar = (g) aVar;
        com.anythink.core.common.n.b.a.b.c cVarH = gVar.h();
        ad adVarA = gVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarH.a(adVarA);
        af.a aVarA = null;
        if (f.c(adVarA.b()) && adVarA.d() != null) {
            if ("100-continue".equalsIgnoreCase(adVarA.a("Expect"))) {
                cVarH.c();
                aVarA = cVarH.a(true);
            }
            if (aVarA == null) {
                adVarA.d();
                com.anythink.core.common.n.c.d dVarA = n.a(cVarH.b(adVarA));
                adVarA.d().a(dVarA);
                dVarA.close();
            } else {
                cVarH.j();
                if (!cVarH.a().g()) {
                    cVarH.h();
                }
            }
        } else {
            cVarH.j();
        }
        if (adVarA.d() != null) {
            adVarA.d();
        }
        cVarH.d();
        if (aVarA == null) {
            aVarA = cVarH.a(false);
        }
        af afVarA2 = aVarA.a(adVarA).a(cVarH.a().c()).a(jCurrentTimeMillis).b(System.currentTimeMillis()).a();
        int iC = afVarA2.c();
        if (iC == 100) {
            afVarA2 = cVarH.a(false).a(adVarA).a(cVarH.a().c()).a(jCurrentTimeMillis).b(System.currentTimeMillis()).a();
            iC = afVarA2.c();
        }
        if (this.a && iC == 101) {
            afVarA = afVarA2.h().a(com.anythink.core.common.n.b.a.c.d).a();
        } else {
            afVarA = afVarA2.h().a(cVarH.a(afVarA2)).a();
        }
        if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(afVarA.a().a("Connection")) || ILivePush.ClickType.CLOSE.equalsIgnoreCase(afVarA.a("Connection"))) {
            cVarH.h();
        }
        if ((iC == 204 || iC == 205) && afVarA.g().b() > 0) {
            throw new ProtocolException("HTTP " + iC + " had non-zero Content-Length: " + afVarA.g().b());
        }
        return afVarA;
    }
}
