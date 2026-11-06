package com.bytedance.sdk.openadsdk.core.live;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static String ms(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri ms(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && map.size() > 0) {
            try {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        builderBuildUpon.appendQueryParameter(str, map.get(str));
                    }
                }
                return builderBuildUpon.build();
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        return uri;
    }
}
