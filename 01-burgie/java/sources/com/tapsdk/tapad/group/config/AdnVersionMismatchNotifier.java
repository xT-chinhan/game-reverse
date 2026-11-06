package com.tapsdk.tapad.group.config;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tapsdk.tapad.group.AdNetworkType;

/* JADX INFO: loaded from: classes2.dex */
final class AdnVersionMismatchNotifier {
    private AdnVersionMismatchNotifier() {
    }

    private static String display(String str) {
        return (str == null || str.trim().isEmpty()) ? "未知" : str.trim();
    }

    public static String message(AdNetworkType adNetworkType, String str, String str2) {
        return ((adNetworkType == null || adNetworkType.getName().isEmpty()) ? "第三方 ADN" : adNetworkType.getName()) + " SDK 版本与预期版本不一致，当前版本：" + display(str2) + "，预期版本：" + display(str) + "。将继续初始化，请尽快接入预期版本。";
    }

    public static void notify(final Context context, AdNetworkType adNetworkType, String str, String str2, boolean z) {
        final String strMessage = message(adNetworkType, str, str2);
        if (!z || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.group.config.AdnVersionMismatchNotifier$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(context, strMessage, 1).show();
            }
        };
        if (Looper.myLooper() == mainLooper) {
            runnable.run();
        } else {
            new Handler(mainLooper).post(runnable);
        }
    }
}
