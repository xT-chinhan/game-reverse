package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyFullScreenAd;

/* JADX INFO: loaded from: classes2.dex */
public final class t6 {
    public final IQYNative.FullScreenAdListener a;

    public t6(IQYNative.FullScreenAdListener fullScreenAdListener) {
        this.a = fullScreenAdListener;
    }

    public final void a(Object obj) {
        kh.a.a(new r6(this, (IQyFullScreenAd) obj));
    }

    public final void a(int i, String str) {
        kh.a.a(new s6(this, i, str));
    }
}
