package com.byazt.jy;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.fo.q;
import com.byazt.gc.AbsServerManager;
import com.byazt.km.cp;
import com.byazt.km.sz;
import com.byazt.km.w;
import com.byazt.yb.x;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 995, 26})
public class qg {
    public static final String[] n = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", AbsServerManager.PACKAGE_QUERY_BINDER, "app_version", TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", TapEventParamConstants.PARAM_DEVICE_ID, "openudid", "clientudid", "aid"};
    public static final String[] qg = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "device_type", "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", TapEventParamConstants.PARAM_DEVICE_ID, "openudid", "clientudid", "aid"};

    public static String n(Context context, JSONObject jSONObject, String str, boolean z, com.byazt.wv.s sVar) {
        HashMap<String, String> mapN;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(n.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = n;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(qg[i], strOptString);
            }
            i++;
        }
        if (sVar != null) {
            try {
                mapN = sVar.n(context);
            } catch (Exception e) {
                cp.qg(e);
            }
        } else {
            mapN = null;
        }
        if (sz.s(context) && mapN != null) {
            map.putAll(mapN);
        }
        try {
            HashMap<String, String> mapN2 = com.byazt.wv.n.s() == null ? null : com.byazt.wv.n.s().n();
            if (mapN2 != null) {
                map.putAll(mapN2);
            }
        } catch (Exception e2) {
            cp.qg(e2);
        }
        if (com.byazt.wv.n.s.size() > 0) {
            map.putAll(com.byazt.wv.n.s);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strN = w.n(context);
        if (!TextUtils.isEmpty(strN)) {
            map.put("ac", strN);
        }
        String str2 = (String) com.byazt.wv.n.n("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) com.byazt.wv.n.n("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) com.byazt.wv.n.n("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) com.byazt.wv.n.n("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) com.byazt.wv.n.n("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strN2 = x.n(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strN2)) {
            map.put("oaid", strN2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return sz.n(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, "UTF-8");
    }

    public static String[] n(q qVar, Context context, JSONObject jSONObject) {
        String[] strArrQg = qVar.x().qg();
        String[] strArr = new String[strArrQg.length];
        String str = com.byazt.wv.n.fs() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrQg.length; i++) {
            String strN = n(context, jSONObject, strArrQg[i] + str, true, com.byazt.wv.n.q());
            strArr[i] = strN;
            strArr[i] = n.n(strN, n.qg);
        }
        return strArr;
    }
}
