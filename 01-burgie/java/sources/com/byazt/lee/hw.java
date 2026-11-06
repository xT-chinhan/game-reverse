package com.byazt.lee;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.byazt.fi.BaseConstants;
import com.byazt.vlj.zo;
import com.byazt.wf.aj;
import com.byazt.wf.m;
import com.byazt.wf.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 424, 13})
public final class hw {
    public static final String[] pr = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    public JSONObject hn = new JSONObject();
    public Context hw;

    public hw(Context context) {
        this.hw = context;
    }

    public static hw pr(Context context) {
        hw hwVar = new hw(context);
        JSONObject jSONObjectPr = hwVar.pr();
        hwVar.pr(jSONObjectPr);
        hwVar.hn(jSONObjectPr);
        hwVar.x(jSONObjectPr);
        hwVar.c(jSONObjectPr);
        hwVar.uc(jSONObjectPr);
        hwVar.fw(jSONObjectPr);
        hwVar.hw(jSONObjectPr);
        return hwVar;
    }

    private void pr(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.hw.getPackageManager().getPackageInfo(this.hw.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put(an.s, this.hw.getString(i));
            }
            jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.18-cloud");
            jSONObject.put("os", "Android");
            jSONObject.put(an.y, hn());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(an.F, Build.BRAND);
            jSONObject.put(an.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", hw());
        } catch (Exception e) {
        }
    }

    private String hw() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "unknown";
            }
            return sb.toString();
        } catch (Exception e) {
            vk.hw(e);
            return "unknown";
        }
    }

    private void hw(JSONObject jSONObject) {
        Map<String, Object> mapHw;
        com.byazt.sds.pr prVarPr = zo.pr();
        if (prVarPr != null && jSONObject != null && (mapHw = prVarPr.hw()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : mapHw.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        Object obj = mapHw.get(str);
                        if (obj != null) {
                            jSONObject2.put(str, obj);
                        }
                    }
                }
                jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
            } catch (Exception e) {
                vk.hw(e);
            }
        }
    }

    private String hn() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private void hn(JSONObject jSONObject) {
        String str;
        try {
            DisplayMetrics displayMetrics = this.hw.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            switch (i) {
                case 120:
                    str = "ldpi";
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA /* 240 */:
                    str = "hdpi";
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME /* 320 */:
                    str = "xhdpi";
                    break;
                default:
                    str = "mdpi";
                    break;
            }
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put(an.z, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception e) {
        }
    }

    private void x(JSONObject jSONObject) {
        try {
            String language = this.hw.getResources().getConfiguration().locale.getLanguage();
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
            jSONObject.put(an.M, rawOffset);
        } catch (Exception e) {
        }
    }

    private void c(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.byazt.wf.hn.hn()) {
                sb.append("MIUI-");
            } else if (com.byazt.wf.hn.x()) {
                sb.append("FLYME-");
            } else {
                String strPr = com.byazt.wf.hn.pr();
                if (com.byazt.wf.hn.pr(strPr)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strPr)) {
                    sb.append(strPr).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(Common.Predefined.SUB_ROM, sb.toString());
            }
            jSONObject.put("rom_version", m.pr());
        } catch (Throwable th) {
        }
    }

    private void uc(JSONObject jSONObject) {
        try {
            jSONObject.put(an.Q, aj.pr(this.hw));
        } catch (JSONException e) {
        }
    }

    private void fw(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.hw.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(an.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e) {
        }
    }

    public JSONObject pr(Map<String, Object> map) {
        try {
            if (map == null) {
                return this.hn;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.hn.has(entry.getKey())) {
                    this.hn.put(entry.getKey(), entry.getValue());
                }
            }
            for (String str : pr) {
                if (map.containsKey(str)) {
                    try {
                        this.hn.put(str, Integer.parseInt((String) map.get(str)));
                    } catch (Exception e) {
                        this.hn.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                this.hn.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
            }
            if (map.containsKey("iid")) {
                this.hn.put("udid", map.get("iid"));
                this.hn.remove("iid");
            }
            return this.hn;
        } catch (Throwable th) {
        }
    }

    public JSONObject pr(String str) {
        try {
            this.hn.put("device_id", str);
        } catch (JSONException e) {
        }
        return this.hn;
    }

    public JSONObject hw(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.hn.put(Common.System.USER_ID, str);
            }
        } catch (JSONException e) {
        }
        return this.hn;
    }

    public JSONObject pr() {
        return this.hn;
    }
}
