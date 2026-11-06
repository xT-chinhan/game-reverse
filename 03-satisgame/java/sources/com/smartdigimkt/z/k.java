package com.smartdigimkt.z;

import android.net.Uri;
import com.byazt.ho.BaseConstants;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final HashSet a = new HashSet(Arrays.asList("market", "mimarket", "oppomarket", "oaps", "heytapmarket", "vivomarket", "appmarket", BaseConstants.MARKET_SCHEME_HW_HONOR, "honormarket", BaseConstants.MARKET_SCHEME_SAMSUNG, "mstore"));
    public static final String[] b = {"id", "packagename", SDMAdConst.NETWORK_CUSTOM_KEY.PKG};

    public static boolean a(String str) {
        String scheme;
        return (str == null || (scheme = Uri.parse(str).getScheme()) == null || !a.contains(scheme.toLowerCase(Locale.ROOT))) ? false : true;
    }

    public static String b(String str) {
        if (!a(str)) {
            return "";
        }
        Uri uri = Uri.parse(str);
        for (String str2 : b) {
            try {
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null && queryParameter.length() >= 3 && queryParameter.length() <= 255 && queryParameter.indexOf(46) >= 0) {
                    int i = 0;
                    while (true) {
                        if (i >= queryParameter.length()) {
                            if (queryParameter.charAt(0) == '.' || queryParameter.charAt(queryParameter.length() - 1) == '.' || queryParameter.contains("..")) {
                                break;
                            }
                            return queryParameter;
                        }
                        char cCharAt = queryParameter.charAt(i);
                        if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.' || cCharAt == '_'))) {
                            break;
                        }
                        i++;
                    }
                }
            } catch (UnsupportedOperationException unused) {
            }
        }
        return "";
    }
}
