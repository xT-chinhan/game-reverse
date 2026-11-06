package com.smartdigimkt.v2;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ p a;

    public l(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a.f) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Context contextD = SDKContext.getInstance().d();
            if (contextD == null) {
                return;
            }
            Long l = this.a.t;
            if (l != null) {
                long jLongValue = jCurrentTimeMillis - l.longValue();
                p pVar = this.a;
                if (jLongValue >= pVar.r) {
                    if (pVar.s.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = this.a.e.entrySet().iterator();
                        while (it.hasNext()) {
                            b bVar = (b) ((Map.Entry) it.next()).getValue();
                            String str = bVar.a;
                            if (!TextUtils.isEmpty(str)) {
                                long j = jCurrentTimeMillis - bVar.b;
                                p pVar2 = this.a;
                                if (j > pVar2.r && !pVar2.s.contains(str)) {
                                    String str2 = this.a.a;
                                    arrayList.add(new c(contextD, str, bVar.f, bVar.b, bVar.c, false));
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            p.a(this.a, arrayList, true);
                        }
                    }
                }
            }
        }
    }
}
