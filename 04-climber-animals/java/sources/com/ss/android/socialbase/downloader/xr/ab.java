package com.ss.android.socialbase.downloader.xr;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.ny.ny;

/* JADX INFO: loaded from: classes3.dex */
public class ab {
    private SQLiteStatement ab;
    private final String[] ah;
    private SQLiteStatement c;
    private final String[] d;
    private SQLiteStatement ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final SQLiteDatabase f4804ms;
    private SQLiteStatement x;
    private final String xr;

    public ab(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f4804ms = sQLiteDatabase;
        this.xr = str;
        this.ah = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement ms() {
        if (this.ka == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.f4804ms.compileStatement(ny.ms("INSERT INTO ", this.xr, this.ah));
            synchronized (this) {
                if (this.ka == null) {
                    this.ka = sQLiteStatementCompileStatement;
                }
            }
            if (this.ka != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.ka;
    }

    public SQLiteStatement xr() {
        if (this.ab == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.f4804ms.compileStatement(ny.ms(this.xr, this.d));
            synchronized (this) {
                if (this.ab == null) {
                    this.ab = sQLiteStatementCompileStatement;
                }
            }
            if (this.ab != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.ab;
    }

    public SQLiteStatement ah() {
        if (this.c == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.f4804ms.compileStatement(ny.ms(this.xr, this.ah, this.d));
            synchronized (this) {
                if (this.c == null) {
                    this.c = sQLiteStatementCompileStatement;
                }
            }
            if (this.c != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.c;
    }

    public SQLiteStatement d() {
        if (this.x == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.f4804ms.compileStatement(ny.xr(this.xr, this.ah, this.d));
            synchronized (this) {
                if (this.x == null) {
                    this.x = sQLiteStatementCompileStatement;
                }
            }
            if (this.x != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.x;
    }
}
