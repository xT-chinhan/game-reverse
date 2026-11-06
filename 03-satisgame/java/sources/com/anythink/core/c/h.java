package com.anythink.core.c;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.p;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.o;
import com.anythink.core.common.u.t;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static String a = "h";
    com.anythink.core.common.h.a b;
    Map<String, Object> c;
    a d;
    String e;
    long f;
    boolean g;
    boolean h;

    public interface a {
        void a(com.anythink.core.c.c.a aVar);

        void a(by byVar, ATBaseAdAdapter aTBaseAdAdapter);

        void b(com.anythink.core.c.c.a aVar);
    }

    public h(String str, com.anythink.core.common.h.a aVar, long j) {
        this.e = str;
        this.b = aVar;
        this.c = aVar.q;
        this.f = j;
    }

    private void a() {
        this.g = true;
    }

    private void b() {
        this.h = true;
    }

    public final void a(final by byVar, final a aVar) {
        this.d = aVar;
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bU, new Runnable() { // from class: com.anythink.core.c.h.1
            @Override // java.lang.Runnable
            public final void run() {
                p pVarB = t.b(byVar);
                ATBaseAdAdapter aTBaseAdAdapter = pVarB != null ? pVarB.a : null;
                if (aTBaseAdAdapter == null) {
                    String strB = ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE;
                    if (pVarB != null) {
                        strB = pVarB.b(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE);
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(new com.anythink.core.c.c.a(byVar, strB));
                        return;
                    }
                    return;
                }
                h.a(h.this, aTBaseAdAdapter, byVar);
            }
        }));
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, by byVar) {
        try {
            Map<String, Object> mapA = this.b.n.a().a(this.b.e, this.b.d, byVar, this.b.c != null ? this.b.c.b() : null);
            n nVarAh = this.b.s.ah();
            ai.a(nVarAh, byVar, 0, false);
            o.a(mapA, nVarAh);
            if (byVar.n() == 66) {
                byVar.a(aTBaseAdAdapter);
            }
            aTBaseAdAdapter.internalGetBidRequestInfo(this.b.b, mapA, this.c, new AnonymousClass2(byVar));
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(byVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.b(new com.anythink.core.c.c.a(byVar, th.getMessage()));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.c.h$2, reason: invalid class name */
    final class AnonymousClass2 implements ATBidRequestInfoListener {
        final /* synthetic */ by a;

        AnonymousClass2(by byVar) {
            this.a = byVar;
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onSuccess(ATBidRequestInfo aTBidRequestInfo) {
            h.a(h.this, this.a, aTBidRequestInfo);
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onFailed(String str) {
            if (h.this.d != null) {
                h.this.d.b(new com.anythink.core.c.c.a(this.a, str));
            }
        }
    }

    private void a(by byVar, ATBidRequestInfo aTBidRequestInfo) {
        ATAdxBidFloorInfo aTAdxBidFloorInfo;
        com.anythink.core.common.h.a aVar;
        if (aTBidRequestInfo != null) {
            try {
                JSONObject requestJSONObject = aTBidRequestInfo.toRequestJSONObject();
                if (requestJSONObject != null) {
                    String strValueOf = String.valueOf(this.b.f);
                    this.b.n.a();
                    com.anythink.core.c.d.b.a(requestJSONObject, strValueOf, byVar, this.b);
                    if (byVar.y() == 3) {
                        try {
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, s.b().l());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (this.b.z == 1) {
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                        }
                        if (this.b.s.al() && (aTAdxBidFloorInfo = this.b.A) != null) {
                            double bidFloor = aTAdxBidFloorInfo.getBidFloor();
                            if (bidFloor > 0.0d) {
                                ATAdConst.CURRENCY currency = aTAdxBidFloorInfo.getCurrency();
                                if (currency == null) {
                                    currency = ATAdConst.CURRENCY.USD;
                                }
                                double dM = this.b.n.a().M();
                                if (currency == ATAdConst.CURRENCY.RMB) {
                                    bidFloor *= dM;
                                } else if (currency == ATAdConst.CURRENCY.RMB_CENT) {
                                    bidFloor /= 100.0d;
                                    bidFloor *= dM;
                                }
                                Map<String, Object> extraMap = aTAdxBidFloorInfo.getExtraMap();
                                boolean z = false;
                                if (extraMap != null) {
                                    Object obj = extraMap.get("extra_type");
                                    if (obj instanceof Integer) {
                                        z = ((Integer) obj).intValue() == 1;
                                    }
                                    if (z) {
                                        try {
                                            requestJSONObject.put(com.anythink.core.common.a.b.c.b, bidFloor);
                                            Object obj2 = extraMap.get("extra_m_info");
                                            Object obj3 = extraMap.get("extra_tp_m_info");
                                            Object obj4 = extraMap.get("extra_l_s_p");
                                            if (obj2 instanceof JSONObject) {
                                                JSONObject jSONObject = (JSONObject) obj2;
                                                Iterator<String> itKeys = jSONObject.keys();
                                                while (itKeys.hasNext()) {
                                                    String next = itKeys.next();
                                                    requestJSONObject.put(next, jSONObject.opt(next));
                                                }
                                            }
                                            if (obj3 instanceof JSONArray) {
                                                requestJSONObject.put(com.anythink.core.common.a.b.c.c, (JSONArray) obj3);
                                            }
                                            if (obj4 instanceof Double) {
                                                requestJSONObject.put(com.anythink.core.common.a.b.c.d, ((Double) obj4).doubleValue());
                                            }
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                        }
                                    }
                                }
                                if (!z) {
                                    requestJSONObject.put("c_bidfloor", bidFloor);
                                }
                            }
                        }
                        try {
                            Object objRemove = requestJSONObject.remove(com.anythink.core.bridge.a.b.k);
                            if (objRemove != null && (objRemove instanceof JSONArray[])) {
                                com.anythink.core.common.c.b.a().a((JSONArray[]) objRemove);
                            }
                            Object objRemove2 = requestJSONObject.remove(com.anythink.core.bridge.a.b.l);
                            if (objRemove2 != null && (objRemove2 instanceof Map)) {
                                com.anythink.core.common.c.b.a().a((Map<String, String>) objRemove2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (byVar != null && requestJSONObject != null && byVar.n() == 2) {
                        try {
                            requestJSONObject.put("admob_bid_type", byVar.aU());
                            requestJSONObject.put("network_id", byVar.aT());
                        } catch (Throwable unused2) {
                        }
                    }
                    com.anythink.core.c.c.a aVar2 = new com.anythink.core.c.c.a(byVar, requestJSONObject);
                    aVar2.a(this.g);
                    if (byVar.bJ() && this.h && (aVar = this.b) != null && aVar.J != null) {
                        com.anythink.core.common.f fVar = this.b.J;
                        if (fVar.f() != null) {
                            f fVarF = fVar.f();
                            String str = this.e;
                            long jA = byVar.A();
                            if (jA <= 0) {
                                jA = com.anythink.core.common.g.c.a;
                            }
                            aVar2.a(System.currentTimeMillis() + jA);
                            fVarF.d.put(str + byVar.G(), aVar2);
                        }
                    }
                    a aVar3 = this.d;
                    if (aVar3 != null) {
                        aVar3.a(aVar2);
                        return;
                    }
                    return;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
                a aVar4 = this.d;
                if (aVar4 != null) {
                    aVar4.b(new com.anythink.core.c.c.a(byVar, th3.getMessage()));
                    return;
                }
                return;
            }
        }
        a aVar5 = this.d;
        if (aVar5 != null) {
            aVar5.b(new com.anythink.core.c.c.a(byVar, ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE));
        }
    }

    private static void a(JSONObject jSONObject, by byVar) {
        if (byVar == null || jSONObject == null || byVar.n() != 2) {
            return;
        }
        try {
            jSONObject.put("admob_bid_type", byVar.aU());
            jSONObject.put("network_id", byVar.aT());
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(h hVar, ATBaseAdAdapter aTBaseAdAdapter, by byVar) {
        try {
            Map<String, Object> mapA = hVar.b.n.a().a(hVar.b.e, hVar.b.d, byVar, hVar.b.c != null ? hVar.b.c.b() : null);
            n nVarAh = hVar.b.s.ah();
            ai.a(nVarAh, byVar, 0, false);
            o.a(mapA, nVarAh);
            if (byVar.n() == 66) {
                byVar.a(aTBaseAdAdapter);
            }
            aTBaseAdAdapter.internalGetBidRequestInfo(hVar.b.b, mapA, hVar.c, hVar.new AnonymousClass2(byVar));
            a aVar = hVar.d;
            if (aVar != null) {
                aVar.a(byVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar2 = hVar.d;
            if (aVar2 != null) {
                aVar2.b(new com.anythink.core.c.c.a(byVar, th.getMessage()));
            }
        }
    }

    static /* synthetic */ void a(h hVar, by byVar, ATBidRequestInfo aTBidRequestInfo) {
        ATAdxBidFloorInfo aTAdxBidFloorInfo;
        com.anythink.core.common.h.a aVar;
        if (aTBidRequestInfo != null) {
            try {
                JSONObject requestJSONObject = aTBidRequestInfo.toRequestJSONObject();
                if (requestJSONObject != null) {
                    String strValueOf = String.valueOf(hVar.b.f);
                    hVar.b.n.a();
                    com.anythink.core.c.d.b.a(requestJSONObject, strValueOf, byVar, hVar.b);
                    if (byVar.y() == 3) {
                        try {
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, s.b().l());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (hVar.b.z == 1) {
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                        }
                        if (hVar.b.s.al() && (aTAdxBidFloorInfo = hVar.b.A) != null) {
                            double bidFloor = aTAdxBidFloorInfo.getBidFloor();
                            if (bidFloor > 0.0d) {
                                ATAdConst.CURRENCY currency = aTAdxBidFloorInfo.getCurrency();
                                if (currency == null) {
                                    currency = ATAdConst.CURRENCY.USD;
                                }
                                double dM = hVar.b.n.a().M();
                                if (currency == ATAdConst.CURRENCY.RMB) {
                                    bidFloor *= dM;
                                } else if (currency == ATAdConst.CURRENCY.RMB_CENT) {
                                    bidFloor /= 100.0d;
                                    bidFloor *= dM;
                                }
                                Map<String, Object> extraMap = aTAdxBidFloorInfo.getExtraMap();
                                boolean z = false;
                                if (extraMap != null) {
                                    Object obj = extraMap.get("extra_type");
                                    if (obj instanceof Integer) {
                                        z = ((Integer) obj).intValue() == 1;
                                    }
                                    if (z) {
                                        try {
                                            requestJSONObject.put(com.anythink.core.common.a.b.c.b, bidFloor);
                                            Object obj2 = extraMap.get("extra_m_info");
                                            Object obj3 = extraMap.get("extra_tp_m_info");
                                            Object obj4 = extraMap.get("extra_l_s_p");
                                            if (obj2 instanceof JSONObject) {
                                                JSONObject jSONObject = (JSONObject) obj2;
                                                Iterator<String> itKeys = jSONObject.keys();
                                                while (itKeys.hasNext()) {
                                                    String next = itKeys.next();
                                                    requestJSONObject.put(next, jSONObject.opt(next));
                                                }
                                            }
                                            if (obj3 instanceof JSONArray) {
                                                requestJSONObject.put(com.anythink.core.common.a.b.c.c, (JSONArray) obj3);
                                            }
                                            if (obj4 instanceof Double) {
                                                requestJSONObject.put(com.anythink.core.common.a.b.c.d, ((Double) obj4).doubleValue());
                                            }
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                        }
                                    }
                                }
                                if (!z) {
                                    requestJSONObject.put("c_bidfloor", bidFloor);
                                }
                            }
                        }
                        try {
                            Object objRemove = requestJSONObject.remove(com.anythink.core.bridge.a.b.k);
                            if (objRemove != null && (objRemove instanceof JSONArray[])) {
                                com.anythink.core.common.c.b.a().a((JSONArray[]) objRemove);
                            }
                            Object objRemove2 = requestJSONObject.remove(com.anythink.core.bridge.a.b.l);
                            if (objRemove2 != null && (objRemove2 instanceof Map)) {
                                com.anythink.core.common.c.b.a().a((Map<String, String>) objRemove2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (byVar != null && requestJSONObject != null && byVar.n() == 2) {
                        try {
                            requestJSONObject.put("admob_bid_type", byVar.aU());
                            requestJSONObject.put("network_id", byVar.aT());
                        } catch (Throwable unused2) {
                        }
                    }
                    com.anythink.core.c.c.a aVar2 = new com.anythink.core.c.c.a(byVar, requestJSONObject);
                    aVar2.a(hVar.g);
                    if (byVar.bJ() && hVar.h && (aVar = hVar.b) != null && aVar.J != null) {
                        com.anythink.core.common.f fVar = hVar.b.J;
                        if (fVar.f() != null) {
                            f fVarF = fVar.f();
                            String str = hVar.e;
                            long jA = byVar.A();
                            if (jA <= 0) {
                                jA = com.anythink.core.common.g.c.a;
                            }
                            aVar2.a(System.currentTimeMillis() + jA);
                            fVarF.d.put(str + byVar.G(), aVar2);
                        }
                    }
                    a aVar3 = hVar.d;
                    if (aVar3 != null) {
                        aVar3.a(aVar2);
                        return;
                    }
                    return;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
                a aVar4 = hVar.d;
                if (aVar4 != null) {
                    aVar4.b(new com.anythink.core.c.c.a(byVar, th3.getMessage()));
                    return;
                }
                return;
            }
        }
        a aVar5 = hVar.d;
        if (aVar5 != null) {
            aVar5.b(new com.anythink.core.c.c.a(byVar, ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE));
        }
    }
}
