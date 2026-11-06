package com.smartdigimkt.x4;

import com.anythink.core.api.ATAdConst;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ISDMAdManager.BidTokenCallBack {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ com.smartdigimkt.p4.g b;
    public final /* synthetic */ com.smartdigimkt.h3.b c;
    public final /* synthetic */ List d;
    public final /* synthetic */ String e;
    public final /* synthetic */ com.smartdigimkt.p4.e f;
    public final /* synthetic */ h g;

    public e(h hVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar, com.smartdigimkt.h3.b bVar, ArrayList arrayList, String str, com.smartdigimkt.p4.e eVar) {
        this.g = hVar;
        this.a = aVar;
        this.b = gVar;
        this.c = bVar;
        this.d = arrayList;
        this.e = str;
        this.f = eVar;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMAdManager.BidTokenCallBack
    public final void onComplete(JSONObject jSONObject) {
        if (jSONObject == null) {
            h.a(this.g, this.a, this.b, "bid token is empty");
            return;
        }
        try {
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
            com.smartdigimkt.v4.a aVar = this.a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.smartdigimkt.w4.a aVar2 = aVar.i;
            if (aVar2 != null) {
                aVar2.e = jCurrentTimeMillis;
            }
            com.smartdigimkt.h3.b bVar = this.c;
            if (bVar != null) {
                bVar.a("bidToken");
                this.c.d("bid");
            }
            this.d.add(jSONObject);
            String str = this.e;
            com.smartdigimkt.p4.e eVar = this.f;
            com.smartdigimkt.g4.e eVar2 = new com.smartdigimkt.g4.e(str, eVar != null ? eVar.e : "", eVar, this.d, eVar != null, true);
            com.smartdigimkt.h3.b bVar2 = this.c;
            eVar2.a = bVar2;
            eVar2.b = "bid";
            com.smartdigimkt.g4.l lVar = eVar2.i;
            lVar.a = bVar2;
            lVar.b = "bid";
            com.smartdigimkt.o4.h hVarA = com.smartdigimkt.o4.h.a();
            d dVar = new d(this);
            hVarA.getClass();
            com.smartdigimkt.o4.h.a(eVar2, dVar);
        } catch (Throwable unused) {
            h.a(this.g, this.a, this.b, "bid token handle fail");
        }
    }
}
