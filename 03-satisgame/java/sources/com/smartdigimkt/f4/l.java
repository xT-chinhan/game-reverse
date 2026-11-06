package com.smartdigimkt.f4;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b {
    public boolean r;
    public final com.smartdigimkt.a3.a s;

    public l(int i, String str, com.smartdigimkt.b3.l lVar, HashMap map, com.smartdigimkt.a3.a aVar) {
        super(new com.smartdigimkt.g4.j(i, str, lVar, map));
        this.r = false;
        this.s = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0018  */
    @Override // com.smartdigimkt.f4.b
    public final void a(int i) {
        com.smartdigimkt.g4.j jVar;
        boolean z;
        String string;
        if (i == 302 || i == 301 || i == 307) {
            com.smartdigimkt.g4.d dVar = this.d;
            if (dVar != null) {
                try {
                    if (dVar instanceof com.smartdigimkt.g4.j) {
                        jVar = (com.smartdigimkt.g4.j) dVar;
                    } else {
                        jVar = null;
                    }
                } catch (Throwable unused) {
                }
            } else {
                jVar = null;
            }
            if (jVar != null && !jVar.m()) {
                com.smartdigimkt.b3.l lVar = jVar.e;
                if (lVar != null) {
                    int i2 = jVar.c;
                    String strK = jVar.k();
                    if (i2 == 8) {
                        com.smartdigimkt.n3.k.a(lVar, this.s, "1", strK);
                        return;
                    } else {
                        if (i2 == 9) {
                            com.smartdigimkt.n3.k.a(lVar, this.s, "2", strK);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (this.r) {
            this.d.k();
            com.smartdigimkt.c0.g.a().getClass();
            switch (i) {
                case com.anythink.core.common.l.q.d /* -1003 */:
                case -1002:
                case -1001:
                case -1000:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if ((z || ((i < -99 || i >= 200) && i < 400)) && !z) {
                return;
            }
            try {
                string = new JSONObject(this.d.e()).toString();
            } catch (Throwable unused2) {
                string = new JSONObject().toString();
            }
            int iJ = this.d.j();
            com.smartdigimkt.g4.d dVar2 = this.d;
            com.smartdigimkt.b3.l lVar2 = dVar2 instanceof com.smartdigimkt.g4.j ? ((com.smartdigimkt.g4.j) dVar2).e : null;
            if (lVar2 != null) {
                com.smartdigimkt.c0.g gVarA = com.smartdigimkt.c0.g.a();
                String str = this.a;
                long j = lVar2.g0;
                synchronized (gVarA) {
                    com.smartdigimkt.h0.e eVar = new com.smartdigimkt.h0.e();
                    eVar.b = iJ;
                    eVar.d = str;
                    eVar.c = string;
                    eVar.f = j;
                    gVarA.a(eVar, false);
                }
            }
        }
    }

    @Override // com.smartdigimkt.f4.b
    public final boolean e() {
        return false;
    }
}
