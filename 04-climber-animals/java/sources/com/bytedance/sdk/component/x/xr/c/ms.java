package com.bytedance.sdk.component.x.xr.c;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f1552ms;

    public static xr ms(com.bytedance.sdk.component.x.ms.ka kaVar) {
        if (f1552ms == null) {
            synchronized (xr.class) {
                if (f1552ms == null) {
                    f1552ms = new ah(new c(kaVar), kaVar);
                }
            }
        }
        return f1552ms;
    }
}
