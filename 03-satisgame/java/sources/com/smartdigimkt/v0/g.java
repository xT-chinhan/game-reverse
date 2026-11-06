package com.smartdigimkt.v0;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final com.smartdigimkt.n0.e[] a;
    public final com.smartdigimkt.n0.f b;
    public com.smartdigimkt.n0.e c;

    public g(com.smartdigimkt.n0.e[] eVarArr, com.smartdigimkt.n0.f fVar) {
        this.a = eVarArr;
        this.b = fVar;
    }

    public final com.smartdigimkt.n0.e a(com.smartdigimkt.n0.c cVar) throws l0 {
        com.smartdigimkt.n0.e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        for (com.smartdigimkt.n0.e eVar2 : this.a) {
            try {
                if (eVar2.a(cVar)) {
                    this.c = eVar2;
                    cVar.f = 0;
                    break;
                }
                continue;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                cVar.f = 0;
                throw th;
            }
            cVar.f = 0;
        }
        com.smartdigimkt.n0.e eVar3 = this.c;
        if (eVar3 != null) {
            eVar3.a(this.b);
            return this.c;
        }
        StringBuilder sb = new StringBuilder("None of the available extractors (");
        com.smartdigimkt.n0.e[] eVarArr = this.a;
        int i = com.smartdigimkt.z0.u.a;
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            sb2.append(eVarArr[i2].getClass().getSimpleName());
            if (i2 < eVarArr.length - 1) {
                sb2.append(", ");
            }
        }
        throw new l0(sb.append(sb2.toString()).append(") could read the stream.").toString());
    }
}
