package com.anythink.basead.g;

import com.anythink.core.common.h.n;
import com.anythink.core.common.h.w;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends e implements k {
    public g(w wVar, n nVar) {
        super(wVar, nVar);
    }

    @Override // com.anythink.basead.g.e, com.anythink.basead.g.a
    public void onAdShow(j jVar) {
        super.onAdShow(jVar);
        if (this.b == null || jVar == null) {
            return;
        }
        String strAK = this.b.aK();
        strAK.hashCode();
        if (strAK.equals("1")) {
            this.b.t(jVar.c);
            this.b.aa(jVar.g);
            return;
        }
        if (strAK.equals("3")) {
            this.b.e(jVar.d);
            this.b.aa(jVar.g);
            if (jVar.f) {
                if (jVar.d == 1) {
                    this.b.Z(3);
                    return;
                } else {
                    this.b.Z(1);
                    return;
                }
            }
            if (jVar.d == 1) {
                this.b.Z(4);
            } else {
                this.b.Z(2);
            }
        }
    }
}
