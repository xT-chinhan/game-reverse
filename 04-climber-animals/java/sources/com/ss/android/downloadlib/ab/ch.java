package com.ss.android.downloadlib.ab;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, ms> f4338ms = Collections.synchronizedMap(new HashMap());

    public interface ms {
        void ms();

        void ms(String str);
    }

    public static void ms(String[] strArr, ms msVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ms(strValueOf, msVar);
        TTDelegateActivity.ms(strValueOf, strArr);
    }

    public static void ms(String str) {
        ms msVarAh;
        if (TextUtils.isEmpty(str) || (msVarAh = ah(str)) == null) {
            return;
        }
        msVarAh.ms();
    }

    public static void ms(String str, String str2) {
        ms msVarAh;
        if (TextUtils.isEmpty(str) || (msVarAh = ah(str)) == null) {
            return;
        }
        msVarAh.ms(str2);
    }

    private static void ms(String str, ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        f4338ms.put(str, msVar);
    }

    private static ms ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f4338ms.remove(str);
    }

    public static boolean xr(String str) {
        return com.ss.android.downloadlib.addownload.hi.ka().ms(com.ss.android.downloadlib.addownload.hi.getContext(), str);
    }
}
