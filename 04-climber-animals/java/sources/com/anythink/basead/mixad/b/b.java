package com.anythink.basead.mixad.b;

import com.anythink.core.api.IATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static com.anythink.core.common.l.c.a.a a(IATBaseAdAdapter iATBaseAdAdapter) {
        return a(iATBaseAdAdapter, null);
    }

    public static com.anythink.core.common.l.c.a.a a(IATBaseAdAdapter iATBaseAdAdapter, com.anythink.core.common.l.d.a aVar) {
        com.anythink.core.common.l.c.a.a eVar = null;
        if (iATBaseAdAdapter == null) {
            return null;
        }
        com.anythink.core.common.l.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
        if (serverExtraInfo != null && serverExtraInfo.k()) {
            if (aVar != null) {
                aVar.a(serverExtraInfo);
            }
            if (serverExtraInfo.f()) {
                eVar = new c();
            } else if (serverExtraInfo.g()) {
                eVar = new g();
            } else if (serverExtraInfo.h()) {
                eVar = new d();
            } else if (serverExtraInfo.i()) {
                eVar = new f();
            } else if (serverExtraInfo.j()) {
                eVar = new e();
            }
            if (eVar != null) {
                if (serverExtraInfo.l()) {
                    eVar.a(new com.anythink.basead.mixad.c.b(aVar));
                } else if (serverExtraInfo.m()) {
                    if (eVar instanceof com.anythink.core.common.l.c.a.e) {
                        ((com.anythink.core.common.l.c.a.e) eVar).a(new com.anythink.basead.mixad.d.a());
                    } else if (eVar instanceof com.anythink.core.common.l.c.a.c) {
                        ((com.anythink.core.common.l.c.a.c) eVar).a(new com.anythink.basead.mixad.d.a());
                    }
                } else if (serverExtraInfo.n() && (eVar instanceof com.anythink.core.common.l.c.a.f)) {
                    ((com.anythink.core.common.l.c.a.f) eVar).a(new com.anythink.basead.mixad.a.a(aVar));
                }
            }
        }
        return eVar;
    }

    private static com.anythink.core.common.l.c.a.a b(IATBaseAdAdapter iATBaseAdAdapter, com.anythink.core.common.l.d.a aVar) {
        e eVar = null;
        if (iATBaseAdAdapter == null) {
            return null;
        }
        com.anythink.core.common.l.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
        if (serverExtraInfo != null) {
            if (aVar != null) {
                aVar.a(serverExtraInfo);
            }
            eVar = serverExtraInfo.j() ? new e() : null;
            if (eVar != null) {
                eVar.a(new com.anythink.basead.mixad.c.b(aVar));
            }
        }
        return eVar;
    }
}
