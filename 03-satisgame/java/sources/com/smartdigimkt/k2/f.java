package com.smartdigimkt.k2;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ d a;

    public f(d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            d dVar = this.a;
            Object obj = dVar.b;
            com.smartdigimkt.p2.b bVar = dVar.c;
            if (bVar == null || obj == null) {
                return;
            }
            Object[] objArr = {dVar, TextUtils.isEmpty(dVar.f) ? "{}" : this.a.f};
            Method method = bVar.a;
            if (method == null) {
                return;
            }
            try {
                method.invoke(obj, objArr);
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (Throwable unused) {
        }
    }
}
