package com.anythink.core.common.h;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    public ATAdxBidFloorInfo A;
    public String B;
    public double C;
    public int D;
    public com.anythink.core.common.h F;
    public Context b;
    public ar c;
    public String d;
    public String e;
    public int f;
    public long g;
    public long h;
    public long i;
    public List<bv> j;
    public List<bv> k;
    public String l;
    public boolean m;
    public cb n;
    public String o;
    public String p;
    public Map<String, Object> q;
    public JSONObject r;
    public n s;
    public Map<String, Double> u;
    public bz v;
    public bq w;
    public ac x;
    public com.anythink.core.common.w.i y;
    public int t = 2;
    public int z = 0;
    public int E = 2;

    private a d(List<bv> list) {
        a aVar = new a();
        aVar.b = this.b;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.h = this.h;
        aVar.n = this.n;
        long j = this.g;
        if (j < 0) {
            aVar.g = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        } else {
            aVar.g = j;
        }
        aVar.m = this.m;
        aVar.o = this.o;
        aVar.p = this.p;
        aVar.j = list;
        aVar.q = this.q;
        aVar.i = this.i;
        aVar.c = this.c;
        aVar.s = this.s;
        aVar.t = this.t;
        aVar.u = this.u;
        aVar.z = this.z;
        aVar.y = this.y;
        aVar.x = this.x;
        aVar.A = this.A;
        aVar.B = this.B;
        aVar.C = this.C;
        aVar.D = this.D;
        aVar.E = this.E;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0095  */
    public final a a(List<bv> list, List<bv> list2) {
        a aVarD = d(list);
        aVarD.l = this.l;
        if (list2 != null && list2.size() > 0) {
            Collections.sort(list2);
            List<bv> listA = com.anythink.core.common.v.p.a(list2, (com.anythink.core.common.k.f) null);
            aVarD.k = listA;
            byte b = 0;
            bv bvVar = listA.get(0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (bv bvVar2 : listA) {
                if (bvVar2.q() == 7) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(bvVar2.z())));
                    arrayList2.add(bvVar2.z());
                }
            }
            JSONObject jSONObject = new JSONObject();
            String strValueOf = String.valueOf(aVarD.f);
            this.n.a();
            com.anythink.core.b.d.b.a(jSONObject, strValueOf, bvVar, aVarD);
            try {
                String strValueOf2 = String.valueOf(aVarD.f);
                int iHashCode = strValueOf2.hashCode();
                if (iHashCode != 50) {
                    if (iHashCode == 52 && strValueOf2.equals("4")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (!strValueOf2.equals("2")) {
                    b = -1;
                }
                if (b == 0) {
                    ar arVar = aVarD.c;
                    String string = aVarD.n.a().a(aVarD.e, aVarD.d, bvVar, arVar != null ? arVar.b() : null).get("size").toString();
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("size", string);
                    }
                } else if (b == 1) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                }
                if (aVarD.z == aVarD.k.size()) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                }
                List<be> listA2 = com.anythink.core.common.f.c.a(aVarD.b).a(arrayList2);
                if (listA2.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    for (be beVar : listA2) {
                        if (beVar.d() > 0) {
                            jSONObject2.put(beVar.a(), beVar.d());
                        }
                        if (beVar.c() > 0) {
                            jSONObject3.put(beVar.a(), beVar.c());
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_CLICK, jSONObject2);
                    }
                    if (jSONObject3.length() > 0) {
                        jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_IMPRESSION, jSONObject3);
                    }
                }
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS, new JSONArray(arrayList.toString()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            aVarD.r = jSONObject;
        }
        aVarD.v = this.v;
        aVarD.w = this.w;
        return aVarD;
    }

    public final a a(List<bv> list) {
        return d(list);
    }

    public final a b(List<bv> list) {
        a aVarD = d(list);
        aVarD.o = this.o;
        aVarD.h = this.h;
        return aVarD;
    }

    public final a c(List<bv> list) {
        a aVarD = d(list);
        aVarD.p = this.p;
        return aVarD;
    }
}
