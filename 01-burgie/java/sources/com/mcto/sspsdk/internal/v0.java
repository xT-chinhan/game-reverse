package com.mcto.sspsdk.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {
    public static volatile v0 a;

    public static v0 a() {
        if (a == null) {
            synchronized (v0.class) {
                if (a == null) {
                    a = new v0();
                }
            }
        }
        return a;
    }

    public static void b(u0 u0Var) {
        t4 t4VarB = t4.b();
        if (t4VarB == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseC = t4VarB.c();
        try {
            if (sQLiteDatabaseC == null) {
                return;
            }
            u0Var.c();
            sQLiteDatabaseC.execSQL("update A set b=?, d=?, f=?, j=?,e=?,h=?,k=?,i=?,l=? where c=?", new Object[]{u0Var.g, u0Var.h, Integer.valueOf(u0Var.a), Long.valueOf(u0Var.b), u0Var.f, u0Var.i, Integer.valueOf(u0Var.l), Integer.valueOf(u0Var.m), u0Var.j, u0Var.a()});
        } catch (Exception e) {
            r9.a("ssp_sdk", "ssp_downloader", e);
        } finally {
            t4VarB.a();
        }
    }

    public static void a(u0 u0Var) {
        SQLiteDatabase sQLiteDatabaseC;
        t4 t4VarB = t4.b();
        if (t4VarB == null || (sQLiteDatabaseC = t4VarB.c()) == null) {
            return;
        }
        u0Var.c();
        try {
            sQLiteDatabaseC.execSQL("insert into A (c,a, b,d,f,e,j,h,g,k,l,i) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{u0Var.a(), u0Var.d, u0Var.g, u0Var.h, Integer.valueOf(u0Var.a), u0Var.f, Long.valueOf(u0Var.b), u0Var.i, u0Var.b(), Integer.valueOf(u0Var.l), u0Var.j, Integer.valueOf(u0Var.m)});
        } catch (Exception e) {
            r9.a("ssp_sdk", "ssp_downloader", e);
        } finally {
            t4VarB.a();
        }
    }

    public static u0 b(String str) {
        SQLiteDatabase sQLiteDatabaseC;
        u0 u0Var;
        t4 t4VarB = t4.b();
        u0 u0Var2 = null;
        if (t4VarB == null || (sQLiteDatabaseC = t4VarB.c()) == null) {
            return null;
        }
        try {
            try {
                Cursor cursorRawQuery = sQLiteDatabaseC.rawQuery("select * from A where c=? or h=?", new String[]{str, str});
                if (cursorRawQuery.moveToFirst()) {
                    t0 t0Var = new t0();
                    t0Var.e = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.aF));
                    t0Var.g = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("b"));
                    t0Var.h = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d"));
                    t0Var.d = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.av));
                    t0Var.c = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("g"));
                    t0Var.a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("f"));
                    t0 t0VarA = t0Var.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("e")));
                    t0VarA.b = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("j"));
                    t0VarA.i = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(an.aG));
                    t0VarA.k = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("k"));
                    t0VarA.o = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(an.aC));
                    t0VarA.p = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("l"));
                    u0Var = new u0(t0VarA);
                    try {
                        u0Var.c();
                        u0Var2 = u0Var;
                    } catch (Exception e) {
                        e = e;
                        r9.a("ssp_sdk", "ssp_downloader", e);
                        return u0Var;
                    }
                }
                cursorRawQuery.close();
                return u0Var2;
            } catch (Exception e2) {
                e = e2;
                u0Var = u0Var2;
            }
        } finally {
            t4VarB.a();
        }
    }

    public static void a(String str) {
        SQLiteDatabase sQLiteDatabaseC;
        t4 t4VarB = t4.b();
        if (t4VarB == null || (sQLiteDatabaseC = t4VarB.c()) == null) {
            return;
        }
        try {
            sQLiteDatabaseC.execSQL("delete from A where c=?", new String[]{str});
        } catch (Exception e) {
            r9.a("ssp_sdk", "ssp_downloader", e);
        } finally {
            t4VarB.a();
        }
    }
}
