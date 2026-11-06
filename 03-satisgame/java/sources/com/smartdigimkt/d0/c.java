package com.smartdigimkt.d0;

import android.text.TextUtils;
import com.smartdigimkt.z.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ q a;

    public c(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        com.smartdigimkt.b3.c cVar = this.a.f;
        if (cVar != null) {
            synchronized (cVar) {
                i = cVar.E;
            }
            if (i == 0 && this.a.f.b() == 0) {
                String str = this.a.f.f;
                try {
                    e0.a().getClass();
                    String strA = e0.a(1, str);
                    String str2 = this.a.c;
                    if (TextUtils.isEmpty(strA)) {
                        String str3 = this.a.c;
                        return;
                    }
                    int[] iArrA = com.smartdigimkt.s4.d.a(strA);
                    if (iArrA == null || iArrA.length != 2 || (i2 = iArrA[0]) <= 0 || (i3 = iArrA[1]) <= 0) {
                        return;
                    }
                    this.a.f.b(i2);
                    this.a.f.a(i3);
                    String str4 = this.a.c;
                } catch (Throwable unused) {
                }
            }
        }
    }
}
