package com.byazt.yj;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.ec.g;
import com.byazt.ec.uc;
import com.byazt.ec.w;
import com.byazt.ewn.AbsServerManager;
import com.byazt.gox.x;
import com.byazt.xev.fw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2298, 13})
public class hw {
    public static final String[] pr = {"ab_version", an.F, "language", "os_api", an.z, "google_aid", "build_serial", an.P, "install_id", AbsServerManager.PACKAGE_QUERY_BINDER, "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    public static final String[] hw = {"ab_version", an.F, "language", "os_api", an.z, "google_aid", "build_serial", an.P, "iid", NativeUnifiedADAppInfoImpl.Keys.APP_NAME, NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, an.ai, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String pr(Context context, JSONObject jSONObject, String str, boolean z, com.byazt.zrg.hn hnVar) {
        HashMap<String, String> mapPr;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(pr.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = pr;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(hw[i], strOptString);
            }
            i++;
        }
        if (hnVar == null) {
            mapPr = null;
        } else {
            try {
                mapPr = hnVar.pr(context);
            } catch (Exception e) {
                w.hw(e);
            }
        }
        if (g.hn(context) && mapPr != null) {
            map.putAll(mapPr);
        }
        try {
            HashMap<String, String> mapPr2 = com.byazt.zrg.pr.hn() == null ? null : com.byazt.zrg.pr.hn().pr();
            if (mapPr2 != null) {
                map.putAll(mapPr2);
            }
        } catch (Exception e2) {
            w.hw(e2);
        }
        if (com.byazt.zrg.pr.hn.size() > 0) {
            map.putAll(com.byazt.zrg.pr.hn);
        }
        if (z) {
            map.put("ssmix", an.av);
        }
        String strPr = uc.pr(context);
        if (!TextUtils.isEmpty(strPr)) {
            map.put("ac", strPr);
        }
        String str2 = (String) com.byazt.zrg.pr.pr("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) com.byazt.zrg.pr.pr("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString(an.y, null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put(an.y, strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) com.byazt.zrg.pr.pr("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) com.byazt.zrg.pr.pr("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) com.byazt.zrg.pr.pr("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strPr2 = fw.pr(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strPr2)) {
            map.put("oaid", strPr2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return g.pr(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, Key.STRING_CHARSET_NAME);
    }

    public static String[] pr(x xVar, Context context, JSONObject jSONObject) {
        String str;
        String[] strArrHw = xVar.fw().hw();
        String[] strArr = new String[strArrHw.length];
        if (com.byazt.zrg.pr.zo()) {
            str = "?tt_data=a";
        } else {
            str = "?";
        }
        for (int i = 0; i < strArrHw.length; i++) {
            String strPr = pr(context, jSONObject, strArrHw[i] + str, true, com.byazt.zrg.pr.x());
            strArr[i] = strPr;
            strArr[i] = pr.pr(strPr, pr.hw);
        }
        return strArr;
    }
}
