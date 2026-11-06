package com.byazt.ub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.anythink.core.common.d.i;
import com.byazt.af.x;
import com.byazt.ho.BaseConstants;
import com.byazt.qf.fs;
import com.byazt.yw.oa;
import com.byazt.yw.rv;
import com.byazt.yw.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1675, 26})
public final class qg {
    public static final String[] n = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    public Context qg;
    public JSONObject s = new JSONObject();

    public qg(Context context) {
        this.qg = context;
    }

    public static qg n(Context context) {
        qg qgVar = new qg(context);
        JSONObject jSONObjectN = qgVar.n();
        qgVar.n(jSONObjectN);
        qgVar.s(jSONObjectN);
        qgVar.q(jSONObjectN);
        qgVar.l(jSONObjectN);
        qgVar.w(jSONObjectN);
        qgVar.x(jSONObjectN);
        qgVar.qg(jSONObjectN);
        return qgVar;
    }

    private void n(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.qg.getPackageManager().getPackageInfo(this.qg.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.qg.getString(i));
            }
            jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.18-cloud");
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "Android");
            jSONObject.put("os_version", s());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", qg());
        } catch (Exception unused) {
        }
    }

    private String qg() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e) {
            tj.qg(e);
            return "unknown";
        }
    }

    private void qg(JSONObject jSONObject) {
        Map<String, Object> mapQg;
        Object obj;
        com.byazt.qi.n nVarN = fs.n();
        if (nVarN == null || jSONObject == null || (mapQg = nVarN.qg()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapQg.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapQg.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e) {
            tj.qg(e);
        }
    }

    private String s() {
        String str = Build.VERSION.RELEASE;
        return str.contains(i.E) ? str : str + ".0";
    }

    private void s(JSONObject jSONObject) {
        String str;
        try {
            DisplayMetrics displayMetrics = this.qg.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            if (i == 120) {
                str = "ldpi";
            } else if (i != 240) {
                str = i != 320 ? "mdpi" : "xhdpi";
            } else {
                str = "hdpi";
            }
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + x.n + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void q(JSONObject jSONObject) {
        try {
            String language = this.qg.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    private void l(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.byazt.yw.s.s()) {
                sb.append("MIUI-");
            } else if (com.byazt.yw.s.q()) {
                sb.append("FLYME-");
            } else {
                String strN = com.byazt.yw.s.n();
                if (com.byazt.yw.s.n(strN)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strN)) {
                    sb.append(strN).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(TapEventParamConstants.PARAM_SUB_ROM, sb.toString());
            }
            jSONObject.put("rom_version", oa.n());
        } catch (Throwable unused) {
        }
    }

    private void w(JSONObject jSONObject) {
        try {
            jSONObject.put("access", rv.n(this.qg));
        } catch (JSONException unused) {
        }
    }

    private void x(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.qg.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject n(Map<String, Object> map) {
        try {
            if (map == null) {
                return this.s;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.s.has(entry.getKey())) {
                    this.s.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : n) {
                if (map.containsKey(str)) {
                    try {
                        this.s.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused) {
                        this.s.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.s.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                this.s.put("udid", map.get("iid"));
                this.s.remove("iid");
            }
            return this.s;
        } catch (Throwable unused2) {
        }
    }

    public JSONObject n(String str) {
        try {
            this.s.put(TapEventParamConstants.PARAM_DEVICE_ID, str);
        } catch (JSONException unused) {
        }
        return this.s;
    }

    public JSONObject qg(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.s.put("user_id", str);
            }
        } catch (JSONException unused) {
        }
        return this.s;
    }

    public JSONObject n() {
        return this.s;
    }
}
