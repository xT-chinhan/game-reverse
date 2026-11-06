package com.bytedance.adsdk.lottie.ka;

import com.bytedance.adsdk.lottie.hi;
import com.bytedance.sdk.component.utils.sl;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d implements hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Set<String> f170ms = new HashSet();

    @Override // com.bytedance.adsdk.lottie.hi
    public void ms(String str) {
        ms(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.hi
    public void ms(String str, Throwable th) {
        Set<String> set = f170ms;
        if (set.contains(str)) {
            return;
        }
        sl.xr("LOTTIE", str, th);
        set.add(str);
    }

    @Override // com.bytedance.adsdk.lottie.hi
    public void xr(String str, Throwable th) {
        boolean z = com.bytedance.adsdk.lottie.ka.f166ms;
    }
}
