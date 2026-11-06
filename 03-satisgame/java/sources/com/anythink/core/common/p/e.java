package com.anythink.core.common.p;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.AdError;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.j;
import com.anythink.core.e.l;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.anythink.core.common.j.e {
    private static String b = "anythink_s2s_reward";
    f a;
    private int c = -1;
    private String d = "";
    private String e = "";

    public e(f fVar) {
        this.a = fVar;
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.e;
    }

    @Override // com.anythink.core.common.j.e
    public final void a(final long j, final ATBaseAdAdapter aTBaseAdAdapter, final n nVar) {
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cz, new Runnable() { // from class: com.anythink.core.common.p.e.1
            @Override // java.lang.Runnable
            public final void run() {
                n nVar2;
                String str;
                String str2;
                try {
                    if (aTBaseAdAdapter == null || (nVar2 = nVar) == null) {
                        return;
                    }
                    final String strAQ = nVar2.aQ();
                    String strH = nVar.h();
                    if (TextUtils.isEmpty(strH) || TextUtils.equals(strAQ, strH)) {
                        str = strAQ;
                        str2 = "";
                    } else {
                        str2 = strAQ;
                        str = strH;
                    }
                    l lVarA = com.anythink.core.e.n.a(s.b().g()).a(str);
                    if (lVarA != null && lVarA.bG() == 1) {
                        try {
                            Object objOpt = new JSONObject(a.a(lVarA.R())).opt("api_c");
                            if (objOpt == null) {
                                objOpt = new JSONObject();
                            }
                            String strA = e.this.a(aTBaseAdAdapter, lVarA, nVar, str2, j, objOpt);
                            by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                            if (TextUtils.isEmpty(strA) || unitGroupInfo == null || TextUtils.isEmpty(unitGroupInfo.ap())) {
                                return;
                            }
                            new c(s.b().g(), unitGroupInfo.ap(), strA, nVar, lVarA, str, str2).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.common.p.e.1.1
                                @Override // com.anythink.core.common.l.s
                                public final void onLoadCanceled(int i) {
                                }

                                @Override // com.anythink.core.common.l.s
                                public final void onLoadStart(int i) {
                                }

                                @Override // com.anythink.core.common.l.s
                                public final void onLoadFinish(int i, Object obj) {
                                    if (s.b().G()) {
                                        Log.i(e.b, "S2S impression succeeded. PlacementId: " + strAQ + ":" + obj);
                                    }
                                    if (obj != null) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(obj.toString());
                                            e.this.c = jSONObject.optInt("code");
                                            if (e.this.c == 0) {
                                                e.this.d = jSONObject.optString(com.anythink.core.common.l.f.R);
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                @Override // com.anythink.core.common.l.s
                                public final void onLoadError(int i, String str3, AdError adError) {
                                    e.this.c = -2;
                                    if (adError != null) {
                                        Log.e(e.b, "S2S impression error! PlacementId: " + strAQ + ", " + adError.printStackTrace());
                                        e.this.e = adError.toString();
                                        try {
                                            e.this.c = Integer.parseInt(adError.getPlatformCode());
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ATBaseAdAdapter aTBaseAdAdapter, l lVar, n nVar, String str, long j, Object obj) {
        if (nVar == null) {
            return "";
        }
        try {
            JSONObject jSONObjectO = nVar.O(4);
            if (jSONObjectO == null) {
                return "";
            }
            jSONObjectO.put(com.anythink.core.common.l.f.br, j);
            String userId = aTBaseAdAdapter.getUserId();
            if (TextUtils.isEmpty(userId) && !TextUtils.isEmpty(str)) {
                userId = ATInitMediation.getStringFromMap(this.a.r(), "user_id");
            }
            jSONObjectO.put("api_c", obj);
            jSONObjectO.put("user_id", userId);
            jSONObjectO.put("curr_ts", j);
            jSONObjectO.put("ps_ct", lVar.aq());
            jSONObjectO.put(l.a.ay, lVar.bp());
            jSONObjectO.put(k.y, aj.c(aTBaseAdAdapter.getUnitGroupInfo()));
            return j.d(jSONObjectO.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.common.j.e
    public final void a(final long j, final long j2, final ATBaseAdAdapter aTBaseAdAdapter, final n nVar) {
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cA, new Runnable() { // from class: com.anythink.core.common.p.e.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    final String strAQ = nVar.aQ();
                    String strH = nVar.h();
                    String str = "";
                    if (TextUtils.isEmpty(strH) || TextUtils.equals(strAQ, strH)) {
                        strH = strAQ;
                    } else {
                        str = strAQ;
                    }
                    l lVarA = com.anythink.core.e.n.a(s.b().g()).a(strH);
                    if (lVarA.w() != 1) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = j2;
                    long j4 = (j3 == 0 || jElapsedRealtime < j3) ? jElapsedRealtime : j3;
                    JSONObject jSONObject = new JSONObject(a.a(lVarA.R()));
                    int iOptInt = jSONObject.optInt("a");
                    String strOptString = jSONObject.optString("b");
                    Object objOpt = jSONObject.opt("api_c");
                    if (objOpt == null) {
                        objOpt = new JSONObject();
                    }
                    b bVarA = a.a(strOptString, e.this.a(strH, str, j, j4, nVar, aTBaseAdAdapter, objOpt));
                    if (TextUtils.isEmpty(bVarA.a())) {
                        com.anythink.core.common.t.f.a("1004658", strH, str, nVar, lVarA, "", bVarA.b());
                    } else {
                        new d(s.b().g(), iOptInt, bVarA.a(), nVar, lVarA, strH, str).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.common.p.e.2.1
                            @Override // com.anythink.core.common.l.s
                            public final void onLoadCanceled(int i) {
                            }

                            @Override // com.anythink.core.common.l.s
                            public final void onLoadStart(int i) {
                            }

                            @Override // com.anythink.core.common.l.s
                            public final void onLoadFinish(int i, Object obj) {
                                if (s.b().G()) {
                                    Log.i(e.b, "S2S reward succeeded. PlacementId: " + strAQ);
                                }
                            }

                            @Override // com.anythink.core.common.l.s
                            public final void onLoadError(int i, String str2, AdError adError) {
                                Log.e(e.b, "S2S reward error! PlacementId: " + strAQ + ", " + adError.printStackTrace());
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, long j, long j2, n nVar, ATBaseAdAdapter aTBaseAdAdapter, Object obj) {
        String string;
        String stringFromMap;
        Map<String, Object> mapR;
        try {
            Map<String, Object> internalNetworkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
            string = internalNetworkInfoMap != null ? new JSONObject(internalNetworkInfoMap).toString() : "";
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.anythink.core.common.l.f.bn, str);
            jSONObject.put("req_id", nVar.aR());
            jSONObject.put("show_id", nVar.A());
            jSONObject.put("unit_id", nVar.N());
            jSONObject.put("nw_firm_id", nVar.Z());
            jSONObject.put("scenario_id", nVar.H);
            jSONObject.put("rv_start_ts", j);
            jSONObject.put("r_callback_ts", j2);
            jSONObject.put("rv_play_dur", j2 - j);
            jSONObject.put("tp_bid_id", nVar.p());
            jSONObject.put("extra_info", string);
            try {
                String userId = aTBaseAdAdapter.getUserId();
                if (!TextUtils.isEmpty(userId) || TextUtils.isEmpty(str2)) {
                    stringFromMap = userId;
                    mapR = null;
                } else {
                    mapR = this.a.r();
                    stringFromMap = ATInitMediation.getStringFromMap(mapR, "user_id");
                }
                String userCustomData = aTBaseAdAdapter.getUserCustomData();
                if (TextUtils.isEmpty(userCustomData) && !TextUtils.isEmpty(str2)) {
                    if (mapR == null) {
                        mapR = this.a.r();
                    }
                    userCustomData = ATInitMediation.getStringFromMap(mapR, ATAdConst.KEY.USER_CUSTOM_DATA);
                }
                jSONObject.put("user_id", stringFromMap);
                jSONObject.put("extra_data", userCustomData);
            } catch (Exception unused2) {
            }
            jSONObject.put("curr_ts", System.currentTimeMillis());
            jSONObject.put("api_c", obj);
            JSONObject jSONObjectA = com.anythink.core.common.d.k.a(nVar, aTBaseAdAdapter).a();
            jSONObjectA.put("o_p_usd", nVar.M());
            jSONObjectA.put("cur_rate", nVar.v());
            jSONObject.put(l.a.i, jSONObjectA.toString());
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(l.a.an, str2);
            }
            jSONObject.put("i_t", this.d);
            jSONObject.put("i_t_c", this.c);
            return jSONObject.toString();
        } catch (Throwable unused3) {
            return "";
        }
    }

    private void a(String str, ATBaseAdAdapter aTBaseAdAdapter, JSONObject jSONObject) {
        String stringFromMap;
        Map<String, Object> mapR;
        try {
            String userId = aTBaseAdAdapter.getUserId();
            if (!TextUtils.isEmpty(userId) || TextUtils.isEmpty(str)) {
                stringFromMap = userId;
                mapR = null;
            } else {
                mapR = this.a.r();
                stringFromMap = ATInitMediation.getStringFromMap(mapR, "user_id");
            }
            String userCustomData = aTBaseAdAdapter.getUserCustomData();
            if (TextUtils.isEmpty(userCustomData) && !TextUtils.isEmpty(str)) {
                if (mapR == null) {
                    mapR = this.a.r();
                }
                userCustomData = ATInitMediation.getStringFromMap(mapR, ATAdConst.KEY.USER_CUSTOM_DATA);
            }
            jSONObject.put("user_id", stringFromMap);
            jSONObject.put("extra_data", userCustomData);
        } catch (Exception unused) {
        }
    }
}
