package com.anythink.core.common.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class j extends c {
    private static j a;

    private static void e() {
    }

    private static void f() {
    }

    @Override // com.anythink.core.common.f.c
    protected final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.anythink.core.common.f.c
    protected final String c() {
        return "anythink_upload.db";
    }

    @Override // com.anythink.core.common.f.c
    protected final int d() {
        return 2;
    }

    private j(Context context) {
        super(context);
    }

    public static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE agent_request_info ADD COLUMN create_time INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("UPDATE agent_request_info SET create_time = rowid");
        } catch (Throwable unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(com.anythink.core.common.t.a.a.a.C0049a.f);
            sQLiteDatabase.execSQL(com.anythink.core.common.t.a.a.b.a.g);
            a(sQLiteDatabase, 0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.f.c
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(com.anythink.core.common.t.a.a.a.C0049a.f);
            sQLiteDatabase.execSQL(com.anythink.core.common.t.a.a.b.a.g);
            a(sQLiteDatabase, 0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.f.c
    protected final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE agent_request_info ADD COLUMN create_time INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("UPDATE agent_request_info SET create_time = rowid");
            } catch (Throwable unused) {
            }
        }
    }
}
