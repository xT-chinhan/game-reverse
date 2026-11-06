package com.smartdigimkt.n;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final /* synthetic */ int a = 0;

    public static String a(Context context, String str) {
        if (SDKContext.getInstance().a("it_src")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return context.getPackageManager().getInstallerPackageName(str);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context, com.smartdigimkt.k.c cVar) {
        if (context == null || cVar == null) {
            return "";
        }
        switch (cVar.ordinal()) {
            case 1:
                return context.getResources().getString(k.a(context, "cta_downloading", "string"));
            case 2:
            case 3:
            case 5:
                return context.getResources().getString(k.a(context, "cta_download_paused", "string"));
            case 4:
                return context.getResources().getString(k.a(context, "cta_download_finished", "string"));
            case 6:
                return context.getResources().getString(k.a(context, "cta_download_installed", "string"));
            default:
                return "";
        }
    }
}
