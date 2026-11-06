package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bv;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sa {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String[] f520ms = {"ab_version", bv.F, "language", "os_api", bv.z, "google_aid", "build_serial", bv.P, "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] xr = {"ab_version", bv.F, "language", "os_api", bv.z, "google_aid", "build_serial", bv.P, "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bv.ac, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String ms(Context context, JSONObject jSONObject, String str, boolean z, xr xrVar) {
        HashMap<String, String> mapMs;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(f520ms.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = f520ms;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(xr[i], strOptString);
            }
            i++;
        }
        if (xrVar != null) {
            try {
                mapMs = xrVar.ms(context);
            } catch (Exception e) {
                oh.xr(e);
            }
        } else {
            mapMs = null;
        }
        if (zd.xr(context) && mapMs != null) {
            map.putAll(mapMs);
        }
        try {
            HashMap<String, String> mapMs2 = ms.ah() == null ? null : ms.ah().ms();
            if (mapMs2 != null) {
                map.putAll(mapMs2);
            }
        } catch (Exception e2) {
            oh.xr(e2);
        }
        if (ms.ah.size() > 0) {
            map.putAll(ms.ah);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strMs = jm.ms(context);
        if (!TextUtils.isEmpty(strMs)) {
            map.put("ac", strMs);
        }
        String str2 = (String) ms.ms("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) ms.ms("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString(bv.y, null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put(bv.y, strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) ms.ms("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) ms.ms("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) ms.ms("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strMs2 = vf.ms(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strMs2)) {
            map.put("oaid", strMs2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return zd.ms(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, "UTF-8");
    }

    public static String[] ms(b bVar, Context context, JSONObject jSONObject) {
        String[] strArrXr = bVar.x().xr();
        String[] strArr = new String[strArrXr.length];
        String str = ms.ab() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrXr.length; i++) {
            String strMs = ms(context, jSONObject, strArrXr[i] + str, true, ms.d());
            strArr[i] = strMs;
            strArr[i] = am.ms(strMs, am.xr);
        }
        return strArr;
    }
}
