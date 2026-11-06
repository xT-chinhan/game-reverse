package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.QyAdSlot;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class di implements f7 {
    public IQYNative.SplashAdListener a;
    public QyAdSlot b;
    public final Context c;
    public final Handler d = new Handler(Looper.getMainLooper());
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final yh f = new yh(this);

    public di(Context context) {
        this.c = context;
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        if (this.a == null) {
            return;
        }
        try {
            ArrayList arrayList = vhVar.b;
            if (arrayList != null && !arrayList.isEmpty()) {
                arrayList.size();
                kh.a.a(new zh(this, arrayList));
                return;
            }
            a(3);
        } catch (Exception e) {
            r9.a("ssp_splash", "onSuccess: ", e);
            a(2);
        }
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        if (this.a != null) {
            a(i);
        }
    }

    public final void a(int i) {
        if (this.a != null && this.e.compareAndSet(false, true)) {
            this.d.post(new ci(this, i));
            if (this.b.isSupportPreRequest()) {
                fi.a(this.b, 0);
            }
        }
    }
}
