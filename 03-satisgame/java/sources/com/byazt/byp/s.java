package com.byazt.byp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 8})
public class s implements com.byazt.lpr.q.n {
    public com.byazt.jz.q n = new com.byazt.jz.q();

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
    }

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return this.n.n();
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        return this.n.getType(uri);
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.n.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.n.insert(uri, contentValues);
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        return this.n.delete(uri, str, strArr);
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.n.update(uri, contentValues, str, strArr);
    }
}
