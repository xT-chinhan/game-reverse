package com.ss.android.download.api.ah;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.basead.c.b;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.appdownloader.c.ka;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    public static boolean ms(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (hi.ny().optInt("market_url_opt", 1) == 0) {
            return "market".equals(scheme);
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme);
    }

    public static String xr(Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (hi.ny().optInt("market_scheme_opt") == 1 && ka.ab() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return xr.ms(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter(b.a.A), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    public static Uri ms(String str) {
        Uri.Builder builder = new Uri.Builder();
        if (ka.h() && hi.ny().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str).build();
        }
        return Uri.parse("market://details?id=".concat(String.valueOf(str)));
    }
}
