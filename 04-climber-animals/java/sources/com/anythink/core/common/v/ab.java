package com.anythink.core.common.v;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.h.bv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ab {
    public static final String a = "anythink_bidding";
    private static final String b = "anythink";
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;

    public static void a(String str, com.anythink.core.common.h.n nVar, String str2, bv bvVar, int i, int i2) {
        a(str, nVar, str2, bvVar, i, i2, null);
    }

    public static void a(String str, com.anythink.core.common.h.n nVar, String str2, bv bvVar, int i, int i2, List<String> list) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.KEY_REASON, str2);
                jSONObject.put("placementId", str);
                jSONObject.put("adtype", nVar.aL());
                jSONObject.put("adsourceId", bvVar.z());
                jSONObject.put("networkFirmId", bvVar.g());
                jSONObject.put("content", nVar.X());
                jSONObject.put("hourly_frequency", i);
                jSONObject.put("hourly_limit", bvVar.j());
                jSONObject.put("daily_frequency", i2);
                jSONObject.put("daily_limit", bvVar.i());
                jSONObject.put("pacing_limit", bvVar.y());
                jSONObject.put("request_fail_interval", bvVar.M());
                jSONObject.put("filter_source_ids", list != null ? list : "");
                a("anythink_network", jSONObject.toString(), 2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, String str3, bv bvVar) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.ccg.a.z, com.anythink.core.common.d.j.r.D);
                jSONObject.put("result", str);
                jSONObject.put("placementId", str2);
                jSONObject.put("adtype", str3);
                jSONObject.put("adsourceId", bvVar.z());
                jSONObject.put("networkFirmId", bvVar.g());
                jSONObject.put("content", bvVar.k());
                jSONObject.put("msg", bvVar.F());
                a(a, jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.j.r.n, str));
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.ccg.a.z, com.anythink.core.common.d.j.r.E);
                jSONObject.put("result", str);
                jSONObject.put("placementId", str2);
                jSONObject.put("adtype", str3);
                jSONObject.put(MediationConstant.KEY_ERROR_MSG, str4);
                a("anythink_network", jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.j.r.n, str));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) {
        if (ATSDK.isNetworkLogDebug()) {
            a("anythink_".concat(String.valueOf(str)), str2, false);
        }
    }

    public static void a(String str, String str2, boolean z) {
        if (z) {
            a(str, str2, 1);
        } else {
            a(str, str2, 0);
        }
    }

    private static void a(String str, String str2, int i) {
        String property = System.getProperty("line.separator");
        try {
            if (str2.startsWith("{")) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        String str3 = "╔═══════════════════════════════════════════════════════════════════════════════════════";
        for (String str4 : str2.split(property)) {
            str3 = (str3 + "\n") + "║ " + str4;
        }
        String str5 = str3 + "\n╚═══════════════════════════════════════════════════════════════════════════════════════";
        String str6 = str + (com.anythink.core.common.d.t.b().z() ? "(DebuggerMode)" : "");
        String strConcat = " \n".concat(String.valueOf(str5));
        if (i == 1) {
            Log.e(str6, strConcat);
        } else if (i == 2) {
            Log.w(str6, strConcat);
        } else {
            Log.i(str6, strConcat);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (ATSDK.isNetworkLogDebug()) {
            str2.hashCode();
            switch (str2) {
                case "0":
                    str6 = com.anythink.core.common.d.j.r.s;
                    break;
                case "1":
                    str6 = com.anythink.core.common.d.j.r.r;
                    break;
                case "2":
                    str6 = com.anythink.core.common.d.j.r.p;
                    break;
                case "3":
                    str6 = com.anythink.core.common.d.j.r.q;
                    break;
                case "4":
                    str6 = com.anythink.core.common.d.j.r.t;
                    break;
                default:
                    str6 = "";
                    break;
            }
            a(str, str6, str3, str4, str5, false);
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        a(str, str2, str3, str4, str5, false);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x009d  */
    public static void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        String str6;
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("placementId", str);
                jSONObject.put("adtype", str2);
                jSONObject.put("api", str3);
                jSONObject.put("result", str4);
                jSONObject.put(MediationConstant.KEY_REASON, str5);
                if (z) {
                    if (TextUtils.isEmpty(str)) {
                        str6 = "";
                    } else {
                        Map<String, Object> mapB = com.anythink.core.common.u.a().b(str);
                        if (mapB.size() > 0) {
                            String str7 = "";
                            for (Map.Entry<String, Object> entry : mapB.entrySet()) {
                                str7 = str7 + "key=" + entry.getKey() + ",value=" + entry.getValue().toString() + ";";
                            }
                            str6 = "[" + str7 + "]";
                        } else {
                            str6 = "";
                        }
                    }
                    jSONObject.put("extra", str6);
                }
                Log.i("anythink_network" + (com.anythink.core.common.d.t.b().z() ? "(DebuggerMode)" : ""), jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str, String str2) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(str, str2);
        }
    }

    public static void a(com.anythink.core.common.h.n nVar, String str, String str2, String str3) {
        if (!ATSDK.isNetworkLogDebug() || nVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int iY = nVar.Y();
            if (iY == 66) {
                jSONObject.put("isAdxNetworkMode", nVar.ah());
            }
            if (nVar.i() == 2) {
                jSONObject.put(com.anythink.core.express.b.a.a, "shared placement");
            }
            if (nVar.N() != 0) {
                jSONObject.put("defaultAdSourceType", nVar.N());
            }
            jSONObject.put("placementId", nVar.aI());
            jSONObject.put("adType", nVar.aL());
            jSONObject.put("mixedFormatAdType", nVar.ac());
            jSONObject.put(com.umeng.ccg.a.z, str);
            jSONObject.put("loadType", nVar.U());
            jSONObject.put("result", str2);
            jSONObject.put("segmentId", nVar.Z());
            jSONObject.put("adSourceId", nVar.M());
            jSONObject.put("position", nVar.O());
            jSONObject.put("networkFirmId", iY);
            jSONObject.put("networkName", nVar.aF());
            jSONObject.put("networkVersion", nVar.x);
            jSONObject.put("networkUnit", nVar.X());
            if (nVar.J() == 1) {
                String strA = p.a(nVar.k());
                if (!TextUtils.isEmpty(strA)) {
                    jSONObject.put("isHB", "1 (" + strA + ")");
                } else {
                    jSONObject.put("isHB", 1);
                }
            } else {
                jSONObject.put("isHB", 0);
            }
            jSONObject.put("msg", str3);
            jSONObject.put("hourly_frequency", nVar.Q());
            jSONObject.put("daily_frequency", nVar.R());
            jSONObject.put("network_list", nVar.S());
            jSONObject.put("request_network_num", nVar.T());
            jSONObject.put("handle_class", nVar.w());
        } catch (Throwable unused) {
        }
        a("network", jSONObject.toString());
    }
}
