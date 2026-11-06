package com.byazt.iy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1110, 20})
public class hn implements com.byazt.nq.hw.pr {
    public com.byazt.jc.x pr = new com.byazt.jc.x();

    @Override // com.byazt.nq.hw.pr
    public void injectContext(Context context) {
    }

    @Override // com.byazt.nq.hw.pr
    public String getTableName() {
        return this.pr.pr();
    }

    @Override // com.byazt.nq.hw.pr
    public void init() {
    }

    @Override // com.byazt.nq.hw.pr
    public String getType(Uri uri) {
        return this.pr.getType(uri);
    }

    @Override // com.byazt.nq.hw.pr
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.pr.query(uri, strArr, str, strArr2, str2);
    }

    @Override // com.byazt.nq.hw.pr
    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.pr.insert(uri, contentValues);
    }

    @Override // com.byazt.nq.hw.pr
    public int delete(Uri uri, String str, String[] strArr) {
        return this.pr.delete(uri, str, strArr);
    }

    @Override // com.byazt.nq.hw.pr
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.pr.update(uri, contentValues, str, strArr);
    }
}
