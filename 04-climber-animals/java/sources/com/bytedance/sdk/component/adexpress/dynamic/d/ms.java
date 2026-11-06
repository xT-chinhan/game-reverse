package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.anythink.core.common.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(j.z) > 0) {
            return sb.append(str).toString();
        }
        return sb.append(str).append(".png").toString();
    }
}
