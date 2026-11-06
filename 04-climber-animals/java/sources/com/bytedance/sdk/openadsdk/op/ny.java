package com.bytedance.sdk.openadsdk.op;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static volatile com.bykv.vk.openvk.component.video.api.ms.xr ah = null;
    private static int c = 1;
    private static String d;
    private static String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f4079ms;
    public static volatile com.bykv.vk.openvk.component.video.api.ms.xr xr;

    private static com.bykv.vk.openvk.component.video.api.ms.xr ab() {
        if (xr == null) {
            synchronized (ny.class) {
                if (xr == null) {
                    com.bykv.vk.openvk.component.video.ms.ms.ms.ms msVar = new com.bykv.vk.openvk.component.video.ms.ms.ms.ms();
                    xr = msVar;
                    msVar.ms(ny());
                    xr.ka();
                }
            }
        }
        return xr;
    }

    private static com.bykv.vk.openvk.component.video.api.ms.xr x() {
        if (ah == null) {
            synchronized (ny.class) {
                if (ah == null) {
                    com.bytedance.sdk.component.sl.xr.ms.ms msVar = new com.bytedance.sdk.component.sl.xr.ms.ms();
                    ah = msVar;
                    msVar.ms(ny());
                    ah.ka();
                }
            }
        }
        return ah;
    }

    private static String ny() {
        if (!TextUtils.isEmpty(f4079ms)) {
            return f4079ms;
        }
        int iA = re.xr().a();
        c = iA;
        String strXr = xr(iA);
        f4079ms = strXr;
        return strXr;
    }

    private static String xr(int i) {
        File fileMs;
        Context context = re.getContext();
        if (i == 1) {
            sl.ms("CacheDirConstants", "使用内部存储");
            fileMs = com.bytedance.sdk.component.utils.c.xr(context, com.bytedance.sdk.openadsdk.core.multipro.xr.ah(), "tt_ad");
        } else {
            sl.ms("CacheDirConstants", "使用外部存储");
            fileMs = com.bytedance.sdk.component.utils.c.ms(context, com.bytedance.sdk.openadsdk.core.multipro.xr.ah(), "tt_ad");
        }
        if (fileMs.isFile()) {
            fileMs.delete();
        }
        if (!fileMs.exists()) {
            fileMs.mkdirs();
        }
        return fileMs.getAbsolutePath();
    }

    public static com.bykv.vk.openvk.component.video.api.ms.xr ms(int i) {
        if (i == 1) {
            return x();
        }
        return ab();
    }

    public static String ms() {
        return ny() + File.separator + "video_brand";
    }

    public static String[] xr() {
        String strXr = xr(1);
        com.bytedance.sdk.component.sl.xr.ms.ms msVar = new com.bytedance.sdk.component.sl.xr.ms.ms();
        msVar.ms(strXr);
        String strXr2 = xr(0);
        com.bytedance.sdk.component.sl.xr.ms.ms msVar2 = new com.bytedance.sdk.component.sl.xr.ms.ms();
        msVar2.ms(strXr2);
        return new String[]{msVar.xr(), msVar.ah(), msVar.ms(), msVar.d(), msVar2.xr(), msVar2.ah(), msVar2.ms(), msVar2.d()};
    }

    public static long[] ah() {
        return new long[]{10485760, 20971520, 31457280, 20971520, 10485760, 20971520, 31457280, 20971520};
    }

    public static int d() {
        return c;
    }

    public static String ms(String str) {
        return ny() + File.separator + str;
    }

    public static String ka() {
        if (d == null) {
            d = ms("splash_image");
        }
        return d;
    }

    public static String c() {
        if (ka == null) {
            ka = ms("image");
        }
        return ka;
    }
}
