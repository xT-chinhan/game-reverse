package com.bytedance.sdk.openadsdk.core.live.d;

import com.bytedance.sdk.openadsdk.core.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String f2832ms;
    public final List<String> xr = new ArrayList();

    public ms(String str) {
        this.f2832ms = str;
    }

    public static void ms(String str, String str2) {
        ms msVar = (ms) i.ms(str, ms.class);
        if (msVar == null) {
            ms msVar2 = new ms(str);
            msVar2.ms(str2);
            i.ms(str, msVar2, ms.class);
            return;
        }
        msVar.ms(str2);
    }

    public void ms(String str) {
        this.xr.add(str);
    }
}
