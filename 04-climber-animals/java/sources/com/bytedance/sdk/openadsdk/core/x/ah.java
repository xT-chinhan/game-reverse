package com.bytedance.sdk.openadsdk.core.x;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static String ms(String str) {
        String strH = re.xr().h();
        if (TextUtils.isEmpty(strH)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strH + str;
    }
}
