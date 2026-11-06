package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.xr.ms.sl;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    private static String ah = null;
    private static int c = 1;
    private static boolean d = false;
    private static sl ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f14ms = false;
    private static Context xr;

    public static Context getContext() {
        return xr;
    }

    public static String ms() {
        if (TextUtils.isEmpty(ah)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                ah = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
        }
        return ah;
    }

    public static void ms(Context context, String str) {
        xr = context;
        ah = str;
    }

    public static boolean xr() {
        return d;
    }

    public static void ms(boolean z) {
        d = z;
    }

    public static sl ah() {
        if (ka == null) {
            ka = new sl.ms("v_config").ms(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).xr(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).ah(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).ms();
        }
        return ka;
    }

    public static void ms(sl slVar) {
        ka = slVar;
    }

    public static boolean d() {
        return f14ms;
    }

    public static int ka() {
        return c;
    }
}
