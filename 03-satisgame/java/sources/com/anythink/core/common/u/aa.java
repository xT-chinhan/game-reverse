package com.anythink.core.common.u;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.h.by;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aa {
    public static final String a = "anythink_bidding";
    private static final String b = "anythink";
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;

    public static void a(String str, com.anythink.core.common.h.n nVar, String str2, by byVar, int i, int i2) {
        a(str, nVar, str2, byVar, i, i2, null);
    }

    public static void a(String str, com.anythink.core.common.h.n nVar, String str2, by byVar, int i, int i2, List<String> list) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.KEY_REASON, str2);
                jSONObject.put("placementId", str);
                jSONObject.put("adtype", nVar.aT());
                jSONObject.put("adsourceId", byVar.G());
                jSONObject.put("networkFirmId", byVar.n());
                jSONObject.put(com.anythink.core.common.k.D, nVar.Y());
                jSONObject.put("hourly_frequency", i);
                jSONObject.put("hourly_limit", byVar.q());
                jSONObject.put("daily_frequency", i2);
                jSONObject.put("daily_limit", byVar.p());
                jSONObject.put("pacing_limit", byVar.F());
                jSONObject.put("request_fail_interval", byVar.T());
                jSONObject.put("filter_source_ids", list != null ? list : "");
                a("anythink_network", jSONObject.toString(), 2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, String str3, by byVar) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", com.anythink.core.common.d.i.s.D);
                jSONObject.put("result", str);
                jSONObject.put("placementId", str2);
                jSONObject.put("adtype", str3);
                jSONObject.put("adsourceId", byVar.G());
                jSONObject.put("networkFirmId", byVar.n());
                jSONObject.put(com.anythink.core.common.k.D, byVar.r());
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, byVar.M());
                a(a, jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.i.s.n, str));
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(String str, String str2, String str3, String str4) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", com.anythink.core.common.d.i.s.E);
                jSONObject.put("result", str);
                jSONObject.put("placementId", str2);
                jSONObject.put("adtype", str3);
                jSONObject.put(MediationConstant.KEY_ERROR_MSG, str4);
                a("anythink_network", jSONObject.toString(), TextUtils.equals(com.anythink.core.common.d.i.s.n, str));
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
        String str6 = str + (com.anythink.core.common.d.s.b().A() ? "(DebuggerMode)" : "");
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
                    str6 = com.anythink.core.common.d.i.s.s;
                    break;
                case "1":
                    str6 = com.anythink.core.common.d.i.s.r;
                    break;
                case "2":
                    str6 = com.anythink.core.common.d.i.s.p;
                    break;
                case "3":
                    str6 = com.anythink.core.common.d.i.s.q;
                    break;
                case "4":
                    str6 = com.anythink.core.common.d.i.s.t;
                    break;
                default:
                    str6 = "";
                    break;
            }
            a(str, str6, str3, str4, str5, (com.anythink.core.common.f) null);
        }
    }

    public static void b(String str, String str2, String str3, String str4, String str5) {
        a(str, str2, str3, str4, str5, (com.anythink.core.common.f) null);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, com.anythink.core.common.f fVar) {
        if (ATSDK.isNetworkLogDebug()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("placementId", str);
                jSONObject.put("adtype", str2);
                jSONObject.put("api", str3);
                jSONObject.put("result", str4);
                jSONObject.put(MediationConstant.KEY_REASON, str5);
                if (fVar != null) {
                    jSONObject.put("multiton", fVar.v());
                    jSONObject.put("hashCode", fVar.hashCode());
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(str)) {
                        Map<String, Object> mapR = fVar.r();
                        if (!mapR.isEmpty()) {
                            for (Map.Entry<String, Object> entry : mapR.entrySet()) {
                                sb.append("key=").append(entry.getKey()).append(",value=").append(entry.getValue().toString()).append(";");
                            }
                            sb = new StringBuilder("[" + ((Object) sb) + "]");
                        }
                    }
                    jSONObject.put("extra", sb.toString());
                }
                Log.i("anythink_network" + (com.anythink.core.common.d.s.b().A() ? "(DebuggerMode)" : ""), jSONObject.toString());
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
            int iZ = nVar.Z();
            if (iZ == 66) {
                jSONObject.put("isAdxNetworkMode", nVar.al());
            }
            if (nVar.j() == 2) {
                jSONObject.put("placementType", "shared placement");
            }
            if (nVar.O() != 0) {
                jSONObject.put("defaultAdSourceType", nVar.O());
            }
            jSONObject.put("placementId", nVar.aQ());
            jSONObject.put("adType", nVar.aT());
            jSONObject.put("mixedFormatAdType", nVar.ad());
            jSONObject.put("action", str);
            jSONObject.put("loadType", nVar.V());
            jSONObject.put("result", str2);
            jSONObject.put("segmentId", nVar.aa());
            jSONObject.put("adSourceId", nVar.N());
            jSONObject.put("position", nVar.P());
            jSONObject.put("networkFirmId", iZ);
            jSONObject.put("networkName", nVar.aN());
            jSONObject.put("networkVersion", nVar.y);
            jSONObject.put("networkUnit", nVar.Y());
            if (nVar.K() == 1) {
                String strA = o.a(nVar.l());
                if (!TextUtils.isEmpty(strA)) {
                    jSONObject.put("isHB", "1 (" + strA + ")");
                } else {
                    jSONObject.put("isHB", 1);
                }
            } else {
                jSONObject.put("isHB", 0);
            }
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str3);
            jSONObject.put("hourly_frequency", nVar.R());
            jSONObject.put("daily_frequency", nVar.S());
            jSONObject.put("network_list", nVar.T());
            jSONObject.put("request_network_num", nVar.U());
            jSONObject.put("handle_class", nVar.x());
        } catch (Throwable unused) {
        }
        a("network", jSONObject.toString());
    }
}
