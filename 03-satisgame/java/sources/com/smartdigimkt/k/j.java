package com.smartdigimkt.k;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ o b;

    public j(o oVar, r rVar) {
        this.b = oVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.z2.g gVar = this.b.b;
        if (gVar != null) {
            com.smartdigimkt.b3.f fVar = new com.smartdigimkt.b3.f();
            r rVar = this.a;
            fVar.a = rVar.o;
            fVar.K = rVar.g;
            synchronized (gVar) {
                try {
                    SQLiteDatabase sQLiteDatabaseB = gVar.b();
                    if (gVar.b(fVar)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(NotificationCompat.CATEGORY_PROGRESS, Long.valueOf(fVar.K));
                        sQLiteDatabaseB.update("download_task", contentValues, "unique_id = ?", new String[]{fVar.a});
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
    }
}
