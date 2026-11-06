package com.smartdigimkt.x4;

import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ com.smartdigimkt.p4.g b;
    public final /* synthetic */ h c;

    public f(h hVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar) {
        this.c = hVar;
        this.a = aVar;
        this.b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.f3.a aVarA = this.a.v.a();
        aVarA.Y = this.a.A;
        String str = this.c.c;
        JSONArray jSONArray = new JSONArray();
        com.smartdigimkt.w4.a aVar = this.a.i;
        if (aVar != null) {
            aVarA.o = aVar.d;
        }
        aVarA.p = System.currentTimeMillis();
        aVarA.j = 2;
        com.smartdigimkt.p4.g gVar = this.b;
        if (gVar.b == 67 || gVar.n != 1 || gVar.a == null) {
            return;
        }
        try {
            int i = gVar.q;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sorttype", i);
            jSONObject.put("unit_id", this.b.r);
            jSONObject.put("bidresult", this.b.a.a ? "1" : "0");
            if (aVar != null) {
                jSONObject.put("bid_token_succ_t", aVar.e);
                jSONObject.put("bid_start_t", aVar.d);
            }
            com.smartdigimkt.p4.g gVar2 = this.b;
            jSONObject.put("bidprice", gVar2.t == 2 ? String.valueOf(gVar2.m) : "0");
            com.smartdigimkt.p4.g gVar3 = this.b;
            jSONObject.put("bidprice_cny", gVar3.t == 2 ? String.valueOf(gVar3.K) : "0");
            com.smartdigimkt.p4.g gVar4 = this.b;
            jSONObject.put(com.anythink.core.common.k.aq, gVar4.t == 2 ? String.valueOf(gVar4.A) : "0");
            jSONObject.put("nw_firm_id", String.valueOf(this.b.b));
            com.smartdigimkt.d3.c cVar = this.b.a;
            String str2 = null;
            jSONObject.put("tp_bid_id", cVar != null ? cVar.s : null);
            jSONObject.put("rl_bid_status", this.b.v);
            jSONObject.put("errormsg", this.b.p);
            jSONObject.put("ad_type", -1);
            jSONObject.put("ads_list_type", this.b.w);
            jSONObject.put("unit_type", this.b.E);
            com.smartdigimkt.d3.c cVar2 = this.b.a;
            jSONObject.put("dd_ori_price", cVar2 != null ? String.valueOf(cVar2.b) : "0");
            jSONObject.put(com.anythink.core.common.k.aP, this.b.F);
            jSONObject.put(com.anythink.core.common.k.aS, this.b.G);
            jSONObject.put("bid_floor", this.b.z);
            if (cVar2 == null) {
                str2 = "";
            }
            jSONObject.put("en_p", str2);
            if (cVar2 != null && cVar2.N != 0) {
                jSONObject.put("deal_id", cVar2.O);
                jSONObject.put("deal_type", cVar2.M);
                aVarA.J = cVar2.M;
                aVarA.K = cVar2.O;
            }
            jSONObject.put(com.anythink.core.common.k.bk, this.b.I);
            jSONObject.put(com.anythink.core.common.k.bl, this.b.H);
            jSONObject.put("network_pl_id", aVarA.b);
            jSONArray.put(jSONObject);
        } catch (Exception unused) {
        }
        aVarA.d = this.a.v.d;
        aVarA.q = jSONArray.toString();
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(11, aVarA, -1L);
    }
}
