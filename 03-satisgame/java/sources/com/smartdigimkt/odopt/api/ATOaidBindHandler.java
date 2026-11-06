package com.smartdigimkt.odopt.api;

import android.content.Context;
import com.smartdigimkt.q.a;
import com.smartdigimkt.s.b;

/* JADX INFO: loaded from: classes3.dex */
public class ATOaidBindHandler {
    private static boolean allowUserBindOaidService = true;

    public static void handleInitOaidBind(Context context, a aVar) {
        try {
            if (allowUserBindOaidService) {
                new b().a(context, aVar);
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
