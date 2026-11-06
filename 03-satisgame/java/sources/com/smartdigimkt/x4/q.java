package com.smartdigimkt.x4;

import com.anythink.core.api.ATAdConst;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements ISDMAdManager.BidTokenCallBack {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.smartdigimkt.p4.e d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ x f;

    public q(x xVar, com.smartdigimkt.v4.a aVar, String str, String str2, com.smartdigimkt.p4.e eVar, boolean z) {
        this.f = xVar;
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = eVar;
        this.e = z;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMAdManager.BidTokenCallBack
    public final void onComplete(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.a(this.f, this.a, com.smartdigimkt.z3.b.a("10008", "Bid request token is empty."), -2);
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
            x xVar = this.f;
            com.smartdigimkt.h3.b bVar = this.a.x;
            xVar.getClass();
            if (bVar != null) {
                bVar.a("bidToken");
                bVar.d("bid");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(jSONObject);
            com.smartdigimkt.g4.e eVar = new com.smartdigimkt.g4.e(this.b, this.c, this.d, arrayList, this.e, false);
            com.smartdigimkt.h3.b bVar2 = this.a.x;
            if (bVar2 != null) {
                eVar.a = bVar2;
                eVar.b = "bid";
                com.smartdigimkt.g4.l lVar = eVar.i;
                lVar.a = bVar2;
                lVar.b = "bid";
            }
            com.smartdigimkt.o4.h hVarA = com.smartdigimkt.o4.h.a();
            w wVar = new w(this.f, this.a);
            hVarA.getClass();
            com.smartdigimkt.o4.h.a(eVar, wVar);
            x xVar2 = this.f;
            com.smartdigimkt.v4.a aVar3 = this.a;
            String str = this.c;
            com.smartdigimkt.p4.e eVar2 = this.d;
            xVar2.getClass();
            if (eVar2 != null) {
                return;
            }
            aVar3.B = true;
            com.smartdigimkt.y3.a aVar4 = new com.smartdigimkt.y3.a(str);
            aVar4.b = null;
            aVar4.c = new r(aVar3);
            com.smartdigimkt.q3.f.a().c(new s(new com.smartdigimkt.y3.b(aVar4)));
        } catch (Throwable unused) {
            x.a(this.f, this.a, com.smartdigimkt.z3.b.a("10008", "Bid request token is invalid."), -2);
        }
    }
}
