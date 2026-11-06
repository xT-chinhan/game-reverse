package com.anythink.core.common.f;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.d.s;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    private static d a;

    @Override // com.anythink.core.common.f.c
    protected final String c() {
        return "anythink.db";
    }

    @Override // com.anythink.core.common.f.c
    protected final int d() {
        return 20;
    }

    private d(Context context) {
        super(context);
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    @Override // com.anythink.core.common.f.c
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.f.c
    protected final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            if (i == 1 || i == 2) {
                d(sQLiteDatabase);
                c(sQLiteDatabase);
            } else if (i == 4) {
                sQLiteDatabase.execSQL(i.a.j);
            } else if (i == 13) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
                sQLiteDatabase.execSQL(i.a.j);
            } else if (i == 16) {
                sQLiteDatabase.execSQL(f.a.g);
                sQLiteDatabase.execSQL(f.a.h);
                sQLiteDatabase.execSQL(f.a.i);
                sQLiteDatabase.execSQL(f.a.j);
                sQLiteDatabase.execSQL(f.a.k);
                sQLiteDatabase.execSQL(f.a.l);
            } else if (i == 18) {
                sQLiteDatabase.execSQL(a.C0017a.r);
            } else if (i != 19) {
                switch (i) {
                    case 7:
                        sQLiteDatabase.execSQL(k.a.h);
                        break;
                    case 8:
                        sQLiteDatabase.execSQL(h.b.i);
                        break;
                    case 9:
                        sQLiteDatabase.execSQL(com.anythink.core.d.b.e.a.l);
                        break;
                    case 10:
                        try {
                            sQLiteDatabase.execSQL(com.anythink.core.d.b.e.a.l);
                            break;
                        } catch (Throwable unused) {
                        }
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
                        sQLiteDatabase.execSQL(i.a.j);
                        break;
                    case 11:
                        sQLiteDatabase.execSQL(com.anythink.core.d.b.e.a.m);
                        sQLiteDatabase.execSQL(com.anythink.core.d.b.e.a.n);
                        break;
                }
            } else {
                try {
                    sQLiteDatabase.execSQL(a.C0017a.s);
                    sQLiteDatabase.execSQL(a.C0017a.t);
                    sQLiteDatabase.execSQL(a.C0017a.u);
                } catch (SQLException unused2) {
                }
            }
            i++;
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(e.a.f);
            a(sQLiteDatabase, 3, 20);
            s.b().g();
            String str = com.anythink.core.common.d.i.u;
            new String[]{com.anythink.core.d.b.e.a.a, a.C0017a.a};
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'sdkconfig'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'video_res_cache_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'notice_url_fail_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'user_value_placement'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.f.c
    protected final void b(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }
}
