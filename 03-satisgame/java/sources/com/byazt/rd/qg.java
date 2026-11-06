package com.byazt.rd;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 896, 26})
public class qg {
    public static String n(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri n(Uri uri, Map<String, String> map) {
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
        } catch (Exception unused) {
            return uri;
        }
    }
}
