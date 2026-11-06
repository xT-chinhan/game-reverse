package com.bytedance.sdk.openadsdk.core.jw;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ao {
    public static String ms(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? "Content-Type" : "content-type");
    }
}
