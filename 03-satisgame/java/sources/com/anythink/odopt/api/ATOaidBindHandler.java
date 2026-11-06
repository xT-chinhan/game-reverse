package com.anythink.odopt.api;

import android.content.Context;
import com.anythink.odopt.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ATOaidBindHandler {
    private static boolean allowUserBindOaidService = true;

    public static void handleInitOaidBind(Context context, a aVar) {
        try {
            if (allowUserBindOaidService) {
                new com.anythink.odopt.a.a.a.a().a(context, aVar);
            } else if (aVar != null) {
                aVar.a("No Support Oaid");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAllowUseBindOaidService(boolean z) {
        allowUserBindOaidService = z;
    }
}
