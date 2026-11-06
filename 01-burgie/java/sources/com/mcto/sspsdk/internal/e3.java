package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.QyAdSlot;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e3 implements f7 {
    public final QyAdSlot a;
    public final Context b;
    public final IQYNative.QYNativeAdListener c;
    public final Handler d = new Handler(Looper.getMainLooper());

    public e3(Context context, QyAdSlot qyAdSlot, IQYNative.QYNativeAdListener qYNativeAdListener) {
        this.b = context;
        this.c = qYNativeAdListener;
        this.a = qyAdSlot;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public void a(vh vhVar, int i, String str) {
        if (this.c != null) {
            this.d.post(new d3(this, i, str));
        }
    }
}
