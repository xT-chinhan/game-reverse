package com.smartdigimkt.t2;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {
    public final /* synthetic */ v a;
    public final /* synthetic */ z b;

    public x(z zVar, v vVar) {
        this.b = zVar;
        this.a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SQLiteDatabase sQLiteDatabaseB;
        try {
            File file = new File(this.a.b);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
        com.smartdigimkt.z2.r rVar = this.b.b;
        String str = this.a.a;
        rVar.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (rVar) {
            sQLiteDatabaseB = rVar.a.b();
        }
        if (sQLiteDatabaseB == null) {
            return;
        }
        try {
            sQLiteDatabaseB.delete(com.anythink.core.common.f.k.a.a, "video_url=?", new String[]{str});
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
