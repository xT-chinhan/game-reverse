package com.smartdigimkt.i;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.j.u;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ com.smartdigimkt.g3.a a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ Context c;

    public b(com.smartdigimkt.g3.a aVar, com.smartdigimkt.b3.c cVar, Context context) {
        this.a = aVar;
        this.b = cVar;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.g3.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        if (this.b == null) {
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        u uVarA = u.a(this.c);
        com.smartdigimkt.b3.c cVar = this.b;
        uVarA.getClass();
        String strA = com.smartdigimkt.r4.j.a(cVar);
        ConcurrentHashMap concurrentHashMap = uVarA.c;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(strA)) {
            this.a.a(true);
        } else if (com.smartdigimkt.n.b.b(this.c, this.b.m)) {
            this.a.a(true);
        } else {
            String strA2 = com.smartdigimkt.n.c.a(com.smartdigimkt.r4.j.a(this.b));
            com.smartdigimkt.q3.f.a().a(new a(this, TextUtils.isEmpty(strA2) ? false : new File(strA2).exists()));
        }
    }
}
