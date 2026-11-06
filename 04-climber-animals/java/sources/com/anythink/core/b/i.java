package com.anythink.core.b;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.p;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.u;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static String a = "i";
    com.anythink.core.common.h.a b;
    Map<String, Object> c;
    a d;

    public interface a {
        void a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter);

        void a(bv bvVar, JSONObject jSONObject);

        void a(String str, bv bvVar);
    }

    public i(com.anythink.core.common.h.a aVar) {
        this.b = aVar;
        this.c = aVar.q;
    }

    private void a(bv bvVar, a aVar) {
        this.d = aVar;
        p pVarA = u.a(bvVar);
        ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
        if (aTBaseAdAdapter == null) {
            String strA = ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE;
            if (pVarA != null) {
                strA = pVarA.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE);
            }
            aVar.a(strA, bvVar);
            return;
        }
        com.anythink.core.common.v.b.b.a().a(new AnonymousClass1(aTBaseAdAdapter, bvVar));
    }

    /* JADX INFO: renamed from: com.anythink.core.b.i$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ bv b;

        AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar) {
            this.a = aTBaseAdAdapter;
            this.b = bvVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(i.this, this.a, this.b);
        }
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, bv bvVar) {
        try {
            Map<String, Object> mapA = this.b.n.a().a(this.b.e, this.b.d, bvVar, this.b.c != null ? this.b.c.b() : null);
            n nVarAf = this.b.s.af();
            aj.a(nVarAf, bvVar, 0, false);
            com.anythink.core.common.v.p.a(mapA, nVarAf);
            aTBaseAdAdapter.internalGetBidRequestInfo(this.b.b, mapA, this.c, new AnonymousClass2(bvVar));
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(bvVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(th.getMessage(), bvVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.i$2, reason: invalid class name */
    final class AnonymousClass2 implements ATBidRequestInfoListener {
        final /* synthetic */ bv a;

        AnonymousClass2(bv bvVar) {
            this.a = bvVar;
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onSuccess(ATBidRequestInfo aTBidRequestInfo) {
            i.a(i.this, this.a, aTBidRequestInfo);
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onFailed(String str) {
            if (i.this.d != null) {
                i.this.d.a(str, this.a);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.b.i$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ATBidRequestInfo a;
        final /* synthetic */ bv b;

        AnonymousClass3(ATBidRequestInfo aTBidRequestInfo, bv bvVar) {
            this.a = aTBidRequestInfo;
            this.b = bvVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject requestJSONObject;
            ATAdxBidFloorInfo aTAdxBidFloorInfo;
            try {
                ATBidRequestInfo aTBidRequestInfo = this.a;
                if (aTBidRequestInfo != null && (requestJSONObject = aTBidRequestInfo.toRequestJSONObject()) != null) {
                    String strValueOf = String.valueOf(i.this.b.f);
                    i.this.b.n.a();
                    com.anythink.core.b.d.b.a(requestJSONObject, strValueOf, this.b, i.this.b);
                    if (this.b.q() == 3) {
                        try {
                            requestJSONObject.put("unit_id", this.b.z());
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, t.b().l());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (i.this.b.z == 1) {
                            requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                        }
                        if (i.this.b.s.ah() && (aTAdxBidFloorInfo = i.this.b.A) != null) {
                            double bidFloor = aTAdxBidFloorInfo.getBidFloor();
                            if (bidFloor > 0.0d) {
                                ATAdConst.CURRENCY currency = aTAdxBidFloorInfo.getCurrency();
                                if (currency == null) {
                                    currency = ATAdConst.CURRENCY.USD;
                                }
                                double dL = i.this.b.n.a().L();
                                if (currency == ATAdConst.CURRENCY.RMB) {
                                    bidFloor *= dL;
                                } else if (currency == ATAdConst.CURRENCY.RMB_CENT) {
                                    bidFloor /= 100.0d;
                                    bidFloor *= dL;
                                }
                                Map<String, Object> extraMap = aTAdxBidFloorInfo.getExtraMap();
                                boolean z = false;
                                if (extraMap != null) {
                                    Object obj = extraMap.get(ATAdxBidFloorInfo.EXTRA_TYPE);
                                    if (obj instanceof Integer) {
                                        z = ((Integer) obj).intValue() == 1;
                                    }
                                    if (z) {
                                        try {
                                            requestJSONObject.put(com.anythink.core.common.a.b.c.b, bidFloor);
                                            Object obj2 = extraMap.get(ATAdxBidFloorInfo.EXTRA_M_INFO);
                                            Object obj3 = extraMap.get(ATAdxBidFloorInfo.EXTRA_TP_M_INFO);
                                            Object obj4 = extraMap.get(ATAdxBidFloorInfo.EXTRA_L_S_P);
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
                    }
                    i.a(requestJSONObject, this.b);
                    if (i.this.d != null) {
                        i.this.d.a(this.b, requestJSONObject);
                        return;
                    }
                    return;
                }
                if (i.this.d != null) {
                    i.this.d.a(ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE, this.b);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
                if (i.this.d != null) {
                    i.this.d.a(th3.getMessage(), this.b);
                }
            }
        }
    }

    private void a(bv bvVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.v.b.b.a().a(new AnonymousClass3(aTBidRequestInfo, bvVar));
    }

    private static void b(JSONObject jSONObject, bv bvVar) {
        if (bvVar == null || jSONObject == null || bvVar.g() != 2) {
            return;
        }
        try {
            jSONObject.put("admob_bid_type", bvVar.aM());
            jSONObject.put("network_id", bvVar.aL());
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(i iVar, ATBaseAdAdapter aTBaseAdAdapter, bv bvVar) {
        try {
            Map<String, Object> mapA = iVar.b.n.a().a(iVar.b.e, iVar.b.d, bvVar, iVar.b.c != null ? iVar.b.c.b() : null);
            n nVarAf = iVar.b.s.af();
            aj.a(nVarAf, bvVar, 0, false);
            com.anythink.core.common.v.p.a(mapA, nVarAf);
            aTBaseAdAdapter.internalGetBidRequestInfo(iVar.b.b, mapA, iVar.c, iVar.new AnonymousClass2(bvVar));
            a aVar = iVar.d;
            if (aVar != null) {
                aVar.a(bvVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar2 = iVar.d;
            if (aVar2 != null) {
                aVar2.a(th.getMessage(), bvVar);
            }
        }
    }

    static /* synthetic */ void a(i iVar, bv bvVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.v.b.b.a().a(iVar.new AnonymousClass3(aTBidRequestInfo, bvVar));
    }

    static /* synthetic */ void a(JSONObject jSONObject, bv bvVar) {
        if (bvVar == null || jSONObject == null || bvVar.g() != 2) {
            return;
        }
        try {
            jSONObject.put("admob_bid_type", bvVar.aM());
            jSONObject.put("network_id", bvVar.aL());
        } catch (Throwable unused) {
        }
    }
}
