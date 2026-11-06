package com.byazt.tc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byazt.lpr.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 422, 26})
public class qg implements q.n {
    public static volatile qg n;
    public n qg = new n();

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
    }

    private qg() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        return this.qg.getType(uri);
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.qg.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.qg.insert(uri, contentValues);
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        return this.qg.delete(uri, str, strArr);
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.qg.update(uri, contentValues, str, strArr);
    }
}
