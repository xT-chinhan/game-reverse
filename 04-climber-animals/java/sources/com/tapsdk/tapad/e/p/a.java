package com.tapsdk.tapad.e.p;

import com.anythink.core.common.e.f;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final int a = 500;

    public static int a(TapAdConfig tapAdConfig) {
        String str = tapAdConfig.data;
        int i = 1;
        if (str == null || str.length() <= 0 || tapAdConfig.data.length() > 500) {
            return 1;
        }
        try {
            JSONArray jSONArray = new JSONArray(tapAdConfig.data);
            int i2 = 1;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject.has(Common.System.NAME) && jSONObject.has(f.a.d) && "personal_ads_type".equals(jSONObject.optString(Common.System.NAME))) {
                        i2 = !"0".equals(jSONObject.optString(f.a.d)) ? 1 : 0;
                    }
                } catch (Exception unused) {
                    i = i2;
                    TapADLogger.e("extractEnabledCustomRecommend fail");
                    return i;
                }
            }
            return i2;
        } catch (Exception unused2) {
        }
    }

    public static boolean b(TapAdConfig tapAdConfig) {
        String str = tapAdConfig.data;
        boolean z = false;
        if (str == null || str.length() <= 0 || tapAdConfig.data.length() > 500) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(tapAdConfig.data);
            boolean zEquals = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has(Common.System.NAME) && jSONObject.has(f.a.d) && "enable_oaid_strict_mode".equals(jSONObject.optString(Common.System.NAME))) {
                        zEquals = "1".equals(jSONObject.optString(f.a.d));
                    }
                } catch (Exception unused) {
                    z = zEquals;
                    TapADLogger.e("extractEnabledOaidStrictMode fail");
                    return z;
                }
            }
            return zEquals;
        } catch (Exception unused2) {
        }
    }
}
