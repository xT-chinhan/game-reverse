package com.byazt.mef;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.byazt.tuy.aj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 798, 62})
public class fw {
    public SQLiteStatement c;
    public SQLiteStatement fw;
    public final String[] hn;
    public final String hw;
    public final SQLiteDatabase pr;
    public SQLiteStatement uc;
    public final String[] x;
    public SQLiteStatement zo;

    public fw(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.pr = sQLiteDatabase;
        this.hw = str;
        this.hn = strArr;
        this.x = strArr2;
    }

    public SQLiteStatement pr() {
        if (this.c == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.pr.compileStatement(aj.pr("INSERT INTO ", this.hw, this.hn));
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

    public SQLiteStatement hw() {
        if (this.fw == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.pr.compileStatement(aj.pr(this.hw, this.x));
            synchronized (this) {
                if (this.fw == null) {
                    this.fw = sQLiteStatementCompileStatement;
                }
            }
            if (this.fw != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.fw;
    }

    public SQLiteStatement hn() {
        if (this.uc == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.pr.compileStatement(aj.pr(this.hw, this.hn, this.x));
            synchronized (this) {
                if (this.uc == null) {
                    this.uc = sQLiteStatementCompileStatement;
                }
            }
            if (this.uc != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.uc;
    }

    public SQLiteStatement x() {
        if (this.zo == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.pr.compileStatement(aj.hw(this.hw, this.hn, this.x));
            synchronized (this) {
                if (this.zo == null) {
                    this.zo = sQLiteStatementCompileStatement;
                }
            }
            if (this.zo != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.zo;
    }
}
