package com.smartdigimkt.z2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ p d;

    public n(p pVar, String str, int i, String str2) {
        this.d = pVar;
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SQLiteDatabase sQLiteDatabaseA;
        p pVar = this.d;
        String str = this.a;
        int i = this.b;
        String str2 = this.c;
        synchronized (pVar) {
            sQLiteDatabaseA = pVar.a.a();
        }
        Cursor cursorQuery = sQLiteDatabaseA.query("offer_action_record", null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i), str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        this.d.a(this.b, this.a, this.c);
    }
}
