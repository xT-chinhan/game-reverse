package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f702ms;

    public static String ms(Context context) {
        if (f702ms == null) {
            String[] strArrMs = ah.ms(new File(context.getApplicationInfo().sourceDir));
            String str = strArrMs[0];
            f702ms = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrMs[2]);
            }
        }
        return f702ms;
    }

    public static boolean ms() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
