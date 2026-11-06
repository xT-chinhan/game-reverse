package com.smartdigimkt.s3;

import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.v2.p;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.smartdigimkt.x.i {
    public final /* synthetic */ ISDMAdManager.BidTokenCallBack a;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ com.smartdigimkt.a3.a d;
    public final /* synthetic */ m e;

    public l(m mVar, ISDMAdManager.BidTokenCallBack bidTokenCallBack, com.smartdigimkt.h3.b bVar, Map map, com.smartdigimkt.a3.a aVar) {
        this.e = mVar;
        this.a = bidTokenCallBack;
        this.b = bVar;
        this.c = map;
        this.d = aVar;
    }

    public final void a() {
        if (this.a == null) {
            return;
        }
        p.c().a(new k(this), this.b, "bidToken");
    }
}
