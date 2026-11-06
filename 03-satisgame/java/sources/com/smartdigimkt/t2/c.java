package com.smartdigimkt.t2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;

    public c(e eVar, Context context, String str) {
        this.c = eVar;
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.c;
        if (eVar.a == null) {
            eVar.a = com.smartdigimkt.z2.q.a(com.smartdigimkt.z2.d.a(this.a.getApplicationContext()));
        }
        com.smartdigimkt.z2.q qVar = this.c.a;
        String str = this.b;
        synchronized (qVar) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    SQLiteDatabase sQLiteDatabaseB = qVar.b();
                    if (sQLiteDatabaseB == null) {
                    } else {
                        sQLiteDatabaseB.delete(com.anythink.core.common.f.i.a.a, "bid_id = ? ", new String[]{str});
                    }
                }
            } catch (Throwable th) {
                com.smartdigimkt.n3.k.a("Error_SQL_DELETE", th.getMessage() + ", " + com.smartdigimkt.r4.k.a(th.getStackTrace()), SDKContext.getInstance().f(), "");
            }
        }
    }
}
