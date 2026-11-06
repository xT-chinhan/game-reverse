package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
public class qr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile String f517ms;

    public static String ms(Context context, pc pcVar) {
        String id;
        if (TextUtils.isEmpty(f517ms)) {
            synchronized (qr.class) {
                if (!TextUtils.isEmpty(f517ms)) {
                    return f517ms;
                }
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                    id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                    }
                }
                if (TextUtils.isEmpty(id)) {
                    id = pcVar.d().getString("google_aid", null);
                } else if (!TextUtils.equals(pcVar.d().getString("google_aid", null), id)) {
                    ms(context, id, pcVar);
                }
                f517ms = id;
            }
        }
        return f517ms;
    }

    private static void ms(Context context, String str, pc pcVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        pcVar.d().edit().putString("google_aid", str).apply();
    }
}
