package com.bytedance.sdk.component.x.xr.ms.ms;

import com.bytedance.sdk.component.x.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f1562ms = "com.bytedance.openadsdk";
    private static String xr = "content://" + f1562ms + ".TTMultiProvider";

    public static String ms(ka kaVar) {
        if (kaVar.getContext() != null) {
            f1562ms = kaVar.getContext().getPackageName();
            xr = "content://" + f1562ms + ".TTMultiProvider";
        }
        return xr;
    }
}
