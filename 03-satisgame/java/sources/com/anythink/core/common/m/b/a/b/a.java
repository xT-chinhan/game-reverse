package com.anythink.core.common.m.b.a.b;

import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.w;
import com.anythink.core.common.m.b.z;
import com.taptap.sdk.kit.internal.http.TapHttp;

/* JADX INFO: loaded from: classes.dex */
public final class a implements w {
    public final z a;

    public a(z zVar) {
        this.a = zVar;
    }

    @Override // com.anythink.core.common.m.b.w
    public final af a(w.a aVar) {
        com.anythink.core.common.m.b.a.c.g gVar = (com.anythink.core.common.m.b.a.c.g) aVar;
        ad adVarA = gVar.a();
        j jVarG = gVar.g();
        return gVar.a(adVarA, jVarG, jVarG.a(aVar, !adVarA.b().equals(TapHttp.METHOD_GET)));
    }
}
