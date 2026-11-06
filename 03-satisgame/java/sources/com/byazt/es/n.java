package com.byazt.es;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.bk.l;
import com.byazt.ho.BaseConstants;
import com.byazt.ug.d;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2158, 19})
public class n {
    public static boolean n(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (d.rv().optInt("market_url_opt", 1) == 0) {
            return "market".equals(scheme);
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) || "honormarket".equals(scheme) || "prizeappcenter".equals(scheme);
    }

    public static String qg(Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (d.rv().optInt("market_scheme_opt") == 1 && l.x() && BaseConstants.MARKET_SCHEME_SAMSUNG.equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return qg.n(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter(SDMAdConst.NETWORK_CUSTOM_KEY.PKG), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    public static Uri n(Context context, String str) {
        String string = Settings.System.getString(context.getContentResolver(), "persit.sys.tid");
        Uri.Builder builder = new Uri.Builder();
        if (l.hd() && d.rv().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str).build();
        }
        if (!TextUtils.isEmpty(string) && d.rv().optInt("enable_persit_market_scheme_opt", 1) == 1) {
            return builder.scheme("prizeappcenter").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter(SDMAdConst.NETWORK_CUSTOM_KEY.PKG, str).build();
        }
        return Uri.parse(BaseConstants.MARKET_PREFIX.concat(String.valueOf(str)));
    }
}
