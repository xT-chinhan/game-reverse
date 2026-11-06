package com.bytedance.ms.xr.ah;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.anythink.core.common.d.j;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.ms.xr.x.ny;
import com.bytedance.ms.xr.x.zb;
import com.bytedance.sdk.component.utils.sl;
import com.tapsdk.tapad.internal.tracker.experiment.a;
import com.umeng.analytics.pro.bv;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String[] f560ms = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private JSONObject ah = new JSONObject();
    private Context xr;

    public xr(Context context) {
        this.xr = context;
    }

    public static xr ms(Context context) {
        xr xrVar = new xr(context);
        JSONObject jSONObjectMs = xrVar.ms();
        xrVar.ms(jSONObjectMs);
        xrVar.ah(jSONObjectMs);
        xrVar.d(jSONObjectMs);
        xrVar.ka(jSONObjectMs);
        xrVar.c(jSONObjectMs);
        xrVar.ab(jSONObjectMs);
        xrVar.xr(jSONObjectMs);
        return xrVar;
    }

    private void ms(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.xr.getPackageManager().getPackageInfo(this.xr.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put(bv.s, this.xr.getString(i));
            }
            jSONObject.put("sdk_version", 137);
            jSONObject.put(a.b, "0.0.1-alpha.17-cloud");
            jSONObject.put("os", "Android");
            jSONObject.put(bv.y, ah());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(bv.F, Build.BRAND);
            jSONObject.put(bv.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", xr());
        } catch (Exception unused) {
        }
    }

    private String xr() {
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
            ch.xr(e);
            return "unknown";
        }
    }

    private void xr(JSONObject jSONObject) {
        Map<String, Object> mapXr;
        Object obj;
        com.bytedance.ms.xr.ka.ms msVarMs = x.ms();
        if (msVarMs == null || jSONObject == null || (mapXr = msVarMs.xr()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapXr.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapXr.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e) {
            ch.xr(e);
        }
    }

    private String ah() {
        String str = Build.VERSION.RELEASE;
        return str.contains(j.z) ? str : str + ".0";
    }

    private void ah(JSONObject jSONObject) {
        String str;
        try {
            DisplayMetrics displayMetrics = this.xr.getResources().getDisplayMetrics();
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
            jSONObject.put(bv.z, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        try {
            String language = this.xr.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
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

    private void ka(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.ms.xr.x.ah.ah()) {
                sb.append("MIUI-");
            } else if (com.bytedance.ms.xr.x.ah.d()) {
                sb.append("FLYME-");
            } else {
                String strMs = com.bytedance.ms.xr.x.ah.ms();
                if (com.bytedance.ms.xr.x.ah.ms(strMs)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strMs)) {
                    sb.append(strMs).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", zb.ms());
        } catch (Throwable unused) {
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            jSONObject.put(bv.Q, ny.ms(this.xr));
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    private void ab(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.xr.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(bv.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public JSONObject ms(Map<String, Object> map) {
        try {
            if (map == null) {
                return this.ah;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.ah.has(entry.getKey())) {
                    this.ah.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : f560ms) {
                if (map.containsKey(str)) {
                    try {
                        this.ah.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception unused) {
                        this.ah.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.ah.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                this.ah.put("udid", map.get("iid"));
                this.ah.remove("iid");
            }
            return this.ah;
        } catch (Throwable unused2) {
        }
    }

    public JSONObject ms(String str) {
        try {
            this.ah.put("device_id", str);
        } catch (JSONException e) {
            sl.ms(e);
        }
        return this.ah;
    }

    public JSONObject xr(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.ah.put("user_id", str);
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        return this.ah;
    }

    public JSONObject ms() {
        return this.ah;
    }
}
