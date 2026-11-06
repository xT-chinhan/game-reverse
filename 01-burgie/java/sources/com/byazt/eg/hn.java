package com.byazt.eg;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1609, 20})
public class hn {
    public static String pr(Uri uri, String str) {
        if (uri != null && uri.isHierarchical() && str != null) {
            return uri.getQueryParameter(str);
        }
        return "";
    }

    public static Uri pr(Uri uri, Map<String, String> map) {
        if (uri == null || map == null || map.size() <= 0) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    builderBuildUpon.appendQueryParameter(str, map.get(str));
                }
            }
            return builderBuildUpon.build();
        } catch (Exception e) {
            return uri;
        }
    }
}
