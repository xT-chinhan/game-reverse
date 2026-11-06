package com.smartdigimkt.t2;

import android.database.sqlite.SQLiteDatabase;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.a;
        if (eVar.a == null) {
            eVar.a = com.smartdigimkt.z2.q.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        }
        com.smartdigimkt.z2.q qVar = this.a.a;
        synchronized (qVar) {
            try {
                SQLiteDatabase sQLiteDatabaseB = qVar.b();
                if (sQLiteDatabaseB == null) {
                } else {
                    sQLiteDatabaseB.delete(com.anythink.core.common.f.i.a.a, "out_date_timestamp < ? ", new String[]{String.valueOf(System.currentTimeMillis())});
                }
            } catch (Throwable th) {
                com.smartdigimkt.n3.k.a("Error_SQL_DELETE", th.getMessage() + ", " + com.smartdigimkt.r4.k.a(th.getStackTrace()), SDKContext.getInstance().f(), "");
            }
        }
    }
}
