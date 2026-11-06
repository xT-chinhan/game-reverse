package com.anythink.core.common.q;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k;
import com.anythink.core.common.m.q;
import com.anythink.core.common.u;
import com.anythink.core.common.v.ak;
import com.anythink.core.d.l;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.anythink.core.common.k.e {
    private static String a = "anythink_s2s_reward";
    private int b = -1;
    private String c = "";
    private String d = "";

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.d;
    }

    @Override // com.anythink.core.common.k.e
    public final void a(final long j, final ATBaseAdAdapter aTBaseAdAdapter, final n nVar) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.q.e.1
            @Override // java.lang.Runnable
            public final void run() {
                n nVar2;
                String str;
                String str2;
                try {
                    if (aTBaseAdAdapter == null || (nVar2 = nVar) == null) {
                        return;
                    }
                    final String strAI = nVar2.aI();
                    String strG = nVar.g();
                    if (TextUtils.isEmpty(strG) || TextUtils.equals(strAI, strG)) {
                        str = strAI;
                        str2 = "";
                    } else {
                        str2 = strAI;
                        str = strG;
                    }
                    l lVarA = com.anythink.core.d.n.a(t.b().g()).a(str);
                    if (lVarA != null && lVarA.bG() == 1) {
                        try {
                            Object objOpt = new JSONObject(a.a(lVarA.Q())).opt("api_c");
                            if (objOpt == null) {
                                objOpt = new JSONObject();
                            }
                            String strB = e.b(aTBaseAdAdapter, lVarA, nVar, str, str2, j, objOpt);
                            bv unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                            if (TextUtils.isEmpty(strB) || unitGroupInfo == null || TextUtils.isEmpty(unitGroupInfo.aj())) {
                                return;
                            }
                            new c(t.b().g(), unitGroupInfo.aj(), strB, nVar, lVarA, str, str2).a(0, new q() { // from class: com.anythink.core.common.q.e.1.1
                                @Override // com.anythink.core.common.m.q
                                public final void onLoadCanceled(int i) {
                                }

                                @Override // com.anythink.core.common.m.q
                                public final void onLoadStart(int i) {
                                }

                                @Override // com.anythink.core.common.m.q
                                public final void onLoadFinish(int i, Object obj) {
                                    if (t.b().F()) {
                                        Log.i(e.a, "S2S impression succeeded. PlacementId: " + strAI + ":" + obj);
                                    }
                                    if (obj != null) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(obj.toString());
                                            e.this.b = jSONObject.optInt("code");
                                            if (e.this.b == 0) {
                                                e.this.c = jSONObject.optString("data");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                @Override // com.anythink.core.common.m.q
                                public final void onLoadError(int i, String str3, AdError adError) {
                                    e.this.b = -2;
                                    if (adError != null) {
                                        Log.e(e.a, "S2S impression error! PlacementId: " + strAI + ", " + adError.printStackTrace());
                                        e.this.d = adError.toString();
                                        try {
                                            e.this.b = Integer.parseInt(adError.getPlatformCode());
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
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(ATBaseAdAdapter aTBaseAdAdapter, l lVar, n nVar, String str, String str2, long j, Object obj) {
        if (nVar == null) {
            return "";
        }
        try {
            JSONObject jSONObjectO = nVar.O(4);
            if (jSONObjectO == null) {
                return "";
            }
            jSONObjectO.put("sdk_time", j);
            String userId = aTBaseAdAdapter.getUserId();
            if (TextUtils.isEmpty(userId) && !TextUtils.isEmpty(str2)) {
                userId = ATInitMediation.getStringFromMap(u.a().b(str), "user_id");
            }
            jSONObjectO.put("api_c", obj);
            jSONObjectO.put("user_id", userId);
            jSONObjectO.put("curr_ts", j);
            jSONObjectO.put("ps_ct", lVar.ar());
            jSONObjectO.put(l.a.ay, lVar.bo());
            jSONObjectO.put(k.x, ak.c(aTBaseAdAdapter.getUnitGroupInfo()));
            return com.anythink.core.common.v.k.d(jSONObjectO.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.common.k.e
    public final void a(final long j, final long j2, final ATBaseAdAdapter aTBaseAdAdapter, final n nVar) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.q.e.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    final String strAI = nVar.aI();
                    String strG = nVar.g();
                    String str = "";
                    if (TextUtils.isEmpty(strG) || TextUtils.equals(strAI, strG)) {
                        strG = strAI;
                    } else {
                        str = strAI;
                    }
                    l lVarA = com.anythink.core.d.n.a(t.b().g()).a(strG);
                    if (lVarA.v() != 1) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j3 = j2;
                    long j4 = (j3 == 0 || jElapsedRealtime < j3) ? jElapsedRealtime : j3;
                    JSONObject jSONObject = new JSONObject(a.a(lVarA.Q()));
                    int iOptInt = jSONObject.optInt("a");
                    String strOptString = jSONObject.optString("b");
                    Object objOpt = jSONObject.opt("api_c");
                    if (objOpt == null) {
                        objOpt = new JSONObject();
                    }
                    b bVarA = a.a(strOptString, e.this.a(strG, str, j, j4, nVar, aTBaseAdAdapter, objOpt));
                    if (TextUtils.isEmpty(bVarA.a())) {
                        com.anythink.core.common.u.e.a("1004658", strG, str, nVar, lVarA, "", bVarA.b());
                    } else {
                        new d(t.b().g(), iOptInt, bVarA.a(), nVar, lVarA, strG, str).a(0, new q() { // from class: com.anythink.core.common.q.e.2.1
                            @Override // com.anythink.core.common.m.q
                            public final void onLoadCanceled(int i) {
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadStart(int i) {
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadFinish(int i, Object obj) {
                                if (t.b().F()) {
                                    Log.i(e.a, "S2S reward succeeded. PlacementId: " + strAI);
                                }
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadError(int i, String str2, AdError adError) {
                                Log.e(e.a, "S2S reward error! PlacementId: " + strAI + ", " + adError.printStackTrace());
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, long j, long j2, n nVar, ATBaseAdAdapter aTBaseAdAdapter, Object obj) {
        String string;
        String stringFromMap;
        Map<String, Object> mapB;
        try {
            Map<String, Object> internalNetworkInfoMap = aTBaseAdAdapter.getInternalNetworkInfoMap();
            string = internalNetworkInfoMap != null ? new JSONObject(internalNetworkInfoMap).toString() : "";
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.anythink.core.common.m.e.bk, str);
            jSONObject.put("req_id", nVar.aJ());
            jSONObject.put("show_id", nVar.z());
            jSONObject.put("unit_id", nVar.M());
            jSONObject.put("nw_firm_id", nVar.Y());
            jSONObject.put("scenario_id", nVar.F);
            jSONObject.put("rv_start_ts", j);
            jSONObject.put("r_callback_ts", j2);
            jSONObject.put("rv_play_dur", j2 - j);
            jSONObject.put("tp_bid_id", nVar.o());
            jSONObject.put(com.anythink.core.common.e.b.a.f, string);
            String userId = aTBaseAdAdapter.getUserId();
            if (!TextUtils.isEmpty(userId) || TextUtils.isEmpty(str2)) {
                stringFromMap = userId;
                mapB = null;
            } else {
                mapB = u.a().b(str);
                stringFromMap = ATInitMediation.getStringFromMap(mapB, "user_id");
            }
            String userCustomData = aTBaseAdAdapter.getUserCustomData();
            if (TextUtils.isEmpty(userCustomData) && !TextUtils.isEmpty(str2)) {
                if (mapB == null) {
                    mapB = u.a().b(str);
                }
                userCustomData = ATInitMediation.getStringFromMap(mapB, ATAdConst.KEY.USER_CUSTOM_DATA);
            }
            jSONObject.put("user_id", stringFromMap);
            jSONObject.put("extra_data", userCustomData);
            jSONObject.put("curr_ts", System.currentTimeMillis());
            jSONObject.put("api_c", obj);
            JSONObject jSONObjectA = com.anythink.core.common.d.l.a(nVar, aTBaseAdAdapter).a();
            jSONObjectA.put("o_p_usd", nVar.L());
            jSONObjectA.put("cur_rate", nVar.u());
            jSONObject.put(l.a.i, jSONObjectA.toString());
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(l.a.an, str2);
            }
            jSONObject.put("i_t", this.c);
            jSONObject.put("i_t_c", this.b);
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void a(String str, String str2, ATBaseAdAdapter aTBaseAdAdapter, JSONObject jSONObject) throws JSONException {
        String stringFromMap;
        Map<String, Object> mapB;
        String userId = aTBaseAdAdapter.getUserId();
        if (!TextUtils.isEmpty(userId) || TextUtils.isEmpty(str2)) {
            stringFromMap = userId;
            mapB = null;
        } else {
            mapB = u.a().b(str);
            stringFromMap = ATInitMediation.getStringFromMap(mapB, "user_id");
        }
        String userCustomData = aTBaseAdAdapter.getUserCustomData();
        if (TextUtils.isEmpty(userCustomData) && !TextUtils.isEmpty(str2)) {
            if (mapB == null) {
                mapB = u.a().b(str);
            }
            userCustomData = ATInitMediation.getStringFromMap(mapB, ATAdConst.KEY.USER_CUSTOM_DATA);
        }
        jSONObject.put("user_id", stringFromMap);
        jSONObject.put("extra_data", userCustomData);
    }
}
