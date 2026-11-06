package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.i a;
    public final /* synthetic */ p b;

    public o(p pVar, com.smartdigimkt.b3.i iVar) {
        this.b = pVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SQLiteDatabase sQLiteDatabaseB;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(this.a.a));
            contentValues.put("unit_id", this.a.b);
            contentValues.put("click_count", Integer.valueOf(this.a.e));
            contentValues.put("show_count", Integer.valueOf(this.a.d));
            contentValues.put("expire_time", Long.valueOf(this.a.c));
            p pVar = this.b;
            String str = pVar.b;
            synchronized (pVar) {
                sQLiteDatabaseB = pVar.a.b();
            }
            sQLiteDatabaseB.update("offer_action_record", contentValues, "type = ? and unit_id = ?", new String[]{String.valueOf(this.a.a), this.a.b});
        } catch (Exception unused) {
        }
    }
}
