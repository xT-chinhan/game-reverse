package com.smartdigimkt.t2;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ o a;

    public l(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.e) {
            this.a.a();
            ArrayList arrayListD = this.a.b.d();
            if (arrayListD != null) {
                for (int i = 0; i < arrayListD.size(); i++) {
                    p pVar = (p) arrayListD.get(i);
                    String str = TextUtils.isEmpty(pVar.a) ? "" : pVar.a;
                    if (!TextUtils.isEmpty(str)) {
                        q qVar = (q) this.a.c.get(str);
                        if (qVar == null) {
                            qVar = new q();
                            this.a.c.put(str, qVar);
                        }
                        qVar.a(pVar);
                    }
                }
            }
        }
    }
}
