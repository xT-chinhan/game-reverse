package com.bytedance.adsdk.lottie.ka;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f175ms = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    private static final String xr = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface ms<T> {
        void ms(int i, String str);

        void ms(T t);
    }

    public static String ms(Context context) {
        return com.bytedance.sdk.component.utils.c.ms(context, com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl(), f175ms).getAbsolutePath();
    }

    public static String xr(Context context) {
        return com.bytedance.sdk.component.utils.c.ms(context, com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl(), xr).getAbsolutePath();
    }

    public static void ms(String str, Context context, final ms<File> msVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (msVar != null) {
                msVar.ms(2, "url is empty");
                return;
            }
            return;
        }
        com.bytedance.sdk.component.ny.xr.xr xrVarD = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().d();
        if (xrVarD == null) {
            if (msVar != null) {
                msVar.ms(3, "exec is null");
            }
        } else {
            final String strMs = ms(context);
            final String strXr = com.bytedance.sdk.component.utils.ka.xr(str);
            xrVarD.ms(str);
            xrVarD.ms(strMs, strXr);
            xrVarD.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.adsdk.lottie.ka.xr.1
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (msVar != null) {
                        File file = new File(strMs, strXr);
                        if (file.exists()) {
                            msVar.ms(file);
                        } else {
                            msVar.ms(4, "file not exist");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ms(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }
}
