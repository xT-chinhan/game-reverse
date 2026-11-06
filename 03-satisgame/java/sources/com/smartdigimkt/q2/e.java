package com.smartdigimkt.q2;

import android.content.Context;
import com.smartdigimkt.n3.a0;
import com.smartdigimkt.n3.q;
import com.smartdigimkt.n3.r;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ Context a;

    public e(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (k.c(this.a)) {
            a0.a().b();
            com.smartdigimkt.c0.g gVarA = com.smartdigimkt.c0.g.a();
            synchronized (gVarA) {
                try {
                    gVarA.b();
                    List<com.smartdigimkt.h0.e> listSynchronizedList = gVarA.b != null ? Collections.synchronizedList(new ArrayList(gVarA.b)) : null;
                    if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
                        for (com.smartdigimkt.h0.e eVar : listSynchronizedList) {
                            eVar.getClass();
                            gVarA.a(eVar, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            r rVarA = r.a();
            if (rVarA.f != null && SDKContext.getInstance().e && k.c(rVarA.f)) {
                com.smartdigimkt.q3.f.a().a(new q(rVarA), 0L, 13);
            }
        }
    }
}
