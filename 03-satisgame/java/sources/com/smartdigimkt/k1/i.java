package com.smartdigimkt.k1;

import com.smartdigimkt.b2.y;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.z.z;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements z {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ l c;

    public i(l lVar, int i, int i2) {
        this.c = lVar;
        this.a = i;
        this.b = i2;
    }

    @Override // com.smartdigimkt.z.z
    public final void a() {
        com.smartdigimkt.j1.a aVar = this.c.i;
        if (aVar != null) {
            w wVar = new w();
            int i = this.a;
            int i2 = this.b;
            wVar.a = i;
            wVar.b = i2;
            aVar.onAdClick(wVar);
        }
    }

    @Override // com.smartdigimkt.z.z
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        return false;
    }

    @Override // com.smartdigimkt.z.z
    public final void b() {
    }

    @Override // com.smartdigimkt.z.z
    public final void c() {
        y yVarA = y.a();
        synchronized (yVarA.b) {
            yVarA.d = true;
        }
    }

    @Override // com.smartdigimkt.z.z
    public final void a(boolean z) {
        com.smartdigimkt.j1.a aVar = this.c.i;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }
}
