package com.ss.android.downloadlib.xr;

import android.os.Build;
import com.ss.android.downloadlib.addownload.hi;

/* JADX INFO: loaded from: classes3.dex */
public class ny {
    public static boolean ms(com.ss.android.downloadad.api.ms.ms msVar) {
        return com.ss.android.socialbase.appdownloader.c.ka.ka() && Build.VERSION.SDK_INT < 29 && hi.sl() != null && hi.sl().ms() && com.ss.android.downloadlib.ab.ka.ms(msVar).xr("invoke_app_form_background_switch") == 1 && msVar.h();
    }
}
