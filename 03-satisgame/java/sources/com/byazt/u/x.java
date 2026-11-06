package com.byazt.u;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.byazt.ta.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 745, 21})
public class x {
    public SQLiteStatement fs;
    public SQLiteStatement l;
    public final SQLiteDatabase n;
    public final String[] q;
    public final String qg;
    public final String[] s;
    public SQLiteStatement w;
    public SQLiteStatement x;

    public x(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.n = sQLiteDatabase;
        this.qg = str;
        this.s = strArr;
        this.q = strArr2;
    }

    public SQLiteStatement n() {
        if (this.l == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.n.compileStatement(rv.n("INSERT INTO ", this.qg, this.s));
            synchronized (this) {
                if (this.l == null) {
                    this.l = sQLiteStatementCompileStatement;
                }
            }
            if (this.l != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.l;
    }

    public SQLiteStatement qg() {
        if (this.x == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.n.compileStatement(rv.n(this.qg, this.q));
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

    public SQLiteStatement s() {
        if (this.w == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.n.compileStatement(rv.n(this.qg, this.s, this.q));
            synchronized (this) {
                if (this.w == null) {
                    this.w = sQLiteStatementCompileStatement;
                }
            }
            if (this.w != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.w;
    }

    public SQLiteStatement q() {
        if (this.fs == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.n.compileStatement(rv.qg(this.qg, this.s, this.q));
            synchronized (this) {
                if (this.fs == null) {
                    this.fs = sQLiteStatementCompileStatement;
                }
            }
            if (this.fs != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.fs;
    }
}
