package com.byazt.zo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 29})
public class cp implements com.byazt.lpr.q.n {
    public com.byazt.lpr.q.n n;
    public com.byazt.lpr.q.n qg = com.byazt.tc.qg.n();

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    public cp(com.byazt.lpr.q.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
        com.byazt.lpr.q.n nVar = this.n;
        if (nVar != null) {
            nVar.injectContext(context);
        }
        com.byazt.lpr.q.n nVar2 = this.qg;
        if (nVar2 != null) {
            nVar2.injectContext(context);
        }
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        return (n(uri) ? this.qg : this.n).getType(uri);
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (n(uri)) {
            return this.qg.query(uri, strArr, str, strArr2, str2);
        }
        return this.n.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (n(uri)) {
            return this.qg.insert(uri, contentValues);
        }
        return this.n.insert(uri, contentValues);
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        if (n(uri)) {
            return this.qg.delete(uri, str, strArr);
        }
        return this.n.delete(uri, str, strArr);
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (n(uri)) {
            return this.qg.update(uri, contentValues, str, strArr);
        }
        return this.n.update(uri, contentValues, str, strArr);
    }

    private boolean n(Uri uri) {
        if (uri == null) {
            return false;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return false;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("gromore");
    }
}
