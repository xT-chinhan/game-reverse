package com.byazt.tc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byazt.lpr.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 422, 8})
public class s implements q.n {
    public com.byazt.wo.n n;

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "gromore_prime_rit_adn_perform";
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
        if (com.byazt.qt.qg.getContext() != null) {
            this.n = new com.byazt.wo.n(com.byazt.qt.qg.getContext());
        }
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.byazt.wo.n nVar = this.n;
        if (nVar != null) {
            return nVar.n(str, strArr2);
        }
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        com.byazt.wo.n nVar = this.n;
        if (nVar == null) {
            return null;
        }
        nVar.n(contentValues);
        return uri;
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        com.byazt.wo.n nVar = this.n;
        if (nVar == null) {
            return 0;
        }
        nVar.qg(str, strArr);
        return 1;
    }
}
