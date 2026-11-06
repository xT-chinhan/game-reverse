package com.smartdigimkt.t2;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ j a;

    public h(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SQLiteDatabase sQLiteDatabaseB;
        com.smartdigimkt.z2.i iVar = this.a.b;
        iVar.getClass();
        String str = "create_time < " + (System.currentTimeMillis() - 86400000);
        synchronized (iVar) {
            sQLiteDatabaseB = iVar.a.b();
        }
        if (sQLiteDatabaseB == null) {
            return;
        }
        try {
            sQLiteDatabaseB.delete("dsp_offer_show_record", str, null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
