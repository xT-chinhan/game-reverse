package com.smartdigimkt.s3;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.byazt.af.x;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.LoadInfoEntity;
import com.smartdigimkt.t2.o;
import com.smartdigimkt.t2.q;
import com.smartdigimkt.t2.r;
import com.smartdigimkt.v2.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements ISDMAdManager {
    public static volatile m a;

    /* JADX WARN: Code duplicated, block: B:67:0x0169 A[Catch: all -> 0x018b, TryCatch #3 {all -> 0x018b, blocks: (B:65:0x0141, B:67:0x0169, B:68:0x016e, B:70:0x0186), top: B:87:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0186 A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #3 {all -> 0x018b, blocks: (B:65:0x0141, B:67:0x0169, B:68:0x016e, B:70:0x0186), top: B:87:0x0141 }] */
    public static JSONObject a(m mVar, Map map, com.smartdigimkt.a3.a aVar) {
        JSONArray jSONArray;
        int i;
        mVar.getClass();
        if (aVar == null) {
            SDKContext.getInstance().getClass();
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SUPPORT_TEMPLATE_VERSION, 0);
                jSONObject.put("unit_id", aVar.f);
                int i2 = aVar.r;
                if (i2 > 0) {
                    ArrayList arrayListB = com.smartdigimkt.t2.j.a().b(i2);
                    if (arrayListB.size() > 0) {
                        jSONObject.put(com.anythink.core.e.l.a.P, a(arrayListB));
                    }
                }
                int i3 = aVar.q;
                if (i3 > 0) {
                    ArrayList arrayListA = com.smartdigimkt.t2.j.a().a(i3);
                    if (arrayListA.size() > 0) {
                        jSONObject.put(a.a, a(arrayListA));
                    }
                }
                a(jSONObject, map, aVar.c);
                o oVarB = o.b();
                String str = aVar.b;
                oVarB.getClass();
                if (!TextUtils.isEmpty(str)) {
                    synchronized (oVarB.e) {
                        long jC = o.c();
                        if (oVarB.d != jC) {
                            oVarB.c.clear();
                            oVarB.d = jC;
                        }
                        q qVar = (q) oVarB.c.get(str);
                        if (qVar != null) {
                            qVar.a(jSONObject);
                        }
                    }
                }
                if (SDKContext.getInstance().a("sensor_deny")) {
                    jSONObject.put("sensor_deny", 1);
                }
                int i4 = aVar.c;
                try {
                    try {
                        if (i4 == 0) {
                            boolean z = !TextUtils.equals("1", com.smartdigimkt.r4.k.a("layout_type", map));
                            if (!z) {
                                com.smartdigimkt.x.j.a().getClass();
                                JSONArray jSONArrayA = com.smartdigimkt.x.j.a(map);
                                try {
                                    JSONArray jSONArray2 = new JSONArray();
                                    int length = jSONArrayA.length();
                                    for (int i5 = 0; i5 < length; i5++) {
                                        jSONArray2.put(jSONArrayA.getInt(i5));
                                    }
                                    jSONObject.put("nv_unit_type", jSONArray2);
                                } catch (Throwable unused) {
                                }
                            }
                            if (z) {
                                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY_ONLY_PMP_SELF_REDNER));
                            }
                            jSONObject.put("unit_id", aVar.f);
                            jSONObject.put("ad_source_id", aVar.f);
                            jSONObject.put("nw_firm_id", aVar.k);
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, String.valueOf(aVar.c));
                            if (SDKContext.getInstance().B) {
                                jSONObject.put("test", 1);
                            }
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, aVar.x);
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.P_BIDFLOOR, aVar.y);
                            jSONArray = SDKContext.getInstance().r.b;
                            if (jSONArray != null) {
                                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, jSONArray);
                            }
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.NETWORK_SDK_VERSION, com.smartdigimkt.r4.j.a());
                            return jSONObject;
                        }
                        if (i4 == 3) {
                            String strA = com.smartdigimkt.r4.k.a("unit_type", map);
                            if (!TextUtils.isEmpty(strA)) {
                                jSONObject.put("unit_type", Integer.parseInt(strA));
                            }
                            String strA2 = com.smartdigimkt.r4.k.a(com.anythink.core.common.k.aG, map);
                            if (!TextUtils.isEmpty(strA2)) {
                                jSONObject.put("ir_type", strA2);
                            }
                        } else if (i4 == 4) {
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                        }
                        jSONObject.put("unit_id", aVar.f);
                        jSONObject.put("ad_source_id", aVar.f);
                        jSONObject.put("nw_firm_id", aVar.k);
                        jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, String.valueOf(aVar.c));
                        if (SDKContext.getInstance().B) {
                            jSONObject.put("test", 1);
                        }
                        jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, aVar.x);
                        jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.P_BIDFLOOR, aVar.y);
                        jSONArray = SDKContext.getInstance().r.b;
                        if (jSONArray != null) {
                            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, jSONArray);
                        }
                    } catch (Throwable unused2) {
                    }
                    JSONArray jSONArray3 = new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY_ONLY_PMP_SELF_REDNER);
                    if ((i == 1 || i == 3 || i == 4) && com.smartdigimkt.x.j.a().b()) {
                        jSONArray3.put(4);
                    }
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, jSONArray3);
                } catch (Throwable unused3) {
                }
                i = aVar.c;
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.NETWORK_SDK_VERSION, com.smartdigimkt.r4.j.a());
                return jSONObject;
            } catch (Throwable th) {
                if (SDKContext.getInstance().j()) {
                    th.getMessage();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0078 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:11:0x0021, B:13:0x0027, B:15:0x0031, B:17:0x0036, B:19:0x0053, B:20:0x0060, B:24:0x006d, B:25:0x0078, B:27:0x0081), top: B:42:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0081 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:11:0x0021, B:13:0x0027, B:15:0x0031, B:17:0x0036, B:19:0x0053, B:20:0x0060, B:24:0x006d, B:25:0x0078, B:27:0x0081), top: B:42:0x0003 }] */
    @Override // com.smartdigimkt.sdk.api.ISDMAdManager
    public final void getBidTokenJSONObject(Map map, ISDMAdManager.BidTokenCallBack bidTokenCallBack) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    SDKContext.getInstance().getClass();
                    if (bidTokenCallBack != null) {
                        bidTokenCallBack.onComplete(null);
                    }
                } else {
                    Object obj = map.get(com.anythink.core.bridge.a.C0010a.c);
                    LoadInfoEntity loadInfoEntity = obj instanceof Bundle ? (LoadInfoEntity) com.smartdigimkt.r2.b.a((Bundle) obj, LoadInfoEntity.class) : null;
                    if (loadInfoEntity != null && loadInfoEntity.getRequestInfoEntity() != null) {
                        com.smartdigimkt.a3.a aVarConvertToBaseAdRequestInfo = loadInfoEntity.getRequestInfoEntity().convertToBaseAdRequestInfo();
                        com.smartdigimkt.h3.b bVar = aVarConvertToBaseAdRequestInfo != null ? aVarConvertToBaseAdRequestInfo.z : null;
                        com.smartdigimkt.x.j jVarA = com.smartdigimkt.x.j.a();
                        l lVar = new l(this, bidTokenCallBack, bVar, map, aVarConvertToBaseAdRequestInfo);
                        jVarA.getClass();
                        com.smartdigimkt.q3.f.a().getClass();
                        if (com.smartdigimkt.q3.f.c()) {
                            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.x.e(jVarA, lVar));
                        } else {
                            jVarA.a(lVar);
                        }
                        com.smartdigimkt.o4.e.c().a((com.smartdigimkt.h3.b) null);
                        return;
                    }
                    if (bidTokenCallBack != null) {
                        SDKContext.getInstance().getClass();
                        bidTokenCallBack.onComplete(null);
                    }
                }
            } catch (Throwable th) {
                try {
                    if (SDKContext.getInstance().j()) {
                        th.getMessage();
                    }
                    if (bidTokenCallBack != null) {
                        bidTokenCallBack.onComplete(null);
                    }
                } finally {
                    com.smartdigimkt.o4.e.c().a((com.smartdigimkt.h3.b) null);
                }
            }
        } else {
            SDKContext.getInstance().getClass();
            if (bidTokenCallBack != null) {
                bidTokenCallBack.onComplete(null);
            }
        }
    }

    @Override // com.smartdigimkt.sdk.api.ISDMAdManager
    public final JSONObject getDirectlyBidTokenJSONObject(Context context, Map map, Map map2) {
        if (map2 == null) {
            return null;
        }
        try {
            if (map2.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map2.entrySet()) {
                arrayList.add((String) entry.getKey());
                com.smartdigimkt.u2.c.a(context).a((String) entry.getKey(), (String) entry.getValue());
            }
            JSONObject jSONObject = new JSONObject();
            ArrayList<com.smartdigimkt.b3.i> arrayListA = com.smartdigimkt.u2.c.a(context).a(arrayList);
            if (arrayListA.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                for (com.smartdigimkt.b3.i iVar : arrayListA) {
                    int i = iVar.e;
                    if (i > 0) {
                        jSONObject2.put(iVar.b, i);
                    }
                    int i2 = iVar.d;
                    if (i2 > 0) {
                        jSONObject3.put(iVar.b, i2);
                    }
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_CLICK, jSONObject2);
                }
                if (jSONObject3.length() > 0) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_IMPRESSION, jSONObject3);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.smartdigimkt.sdk.api.ISDMAdManager
    public final void getS2SBidToken(String str, Map map, ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback) {
        Object obj = j.a;
        if (s2SBidTokenCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.smartdigimkt.q3.f.a().c(new i(s2SBidTokenCallback, ""));
            return;
        }
        p pVarC = p.c();
        pVarC.getClass();
        com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v2.l(pVarC), 0L, 17);
        if (j.f.compareAndSet(false, true)) {
            p pVarC2 = p.c();
            pVarC2.u.add(new h());
        }
        SDKContext sDKContext = SDKContext.getInstance();
        boolean z = sDKContext.e;
        boolean z2 = sDKContext.f;
        if (z && z2) {
            com.smartdigimkt.q3.f.a().c(new d(str, null, s2SBidTokenCallback, map));
        } else {
            com.smartdigimkt.q3.f.a().c(new c(z, z2, sDKContext, str, map, s2SBidTokenCallback));
        }
    }

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    public static JSONObject a(ArrayList arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap map = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                r rVar = (r) it.next();
                List arrayList2 = (List) map.get(rVar.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(rVar.a, arrayList2);
                }
                arrayList2.add(rVar.b);
            }
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject, Map map, int i) {
        try {
            if (i == 0 || i == 1) {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, com.smartdigimkt.r4.h.k(SDKContext.getInstance().d()));
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, com.smartdigimkt.r4.h.j(SDKContext.getInstance().d()));
            } else if (i == 2) {
                String string = map.get("size").toString();
                if (!TextUtils.isEmpty(string)) {
                    String[] strArrSplit = string.split(x.n);
                    int i2 = Integer.parseInt(strArrSplit[0]);
                    int i3 = Integer.parseInt(strArrSplit[1]);
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, i2);
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, i3);
                }
            } else {
                if (i != 3 && i != 4) {
                    return;
                }
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, com.smartdigimkt.r4.h.k(SDKContext.getInstance().d()));
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, com.smartdigimkt.r4.h.j(SDKContext.getInstance().d()));
            }
        } catch (Throwable unused) {
        }
    }
}
