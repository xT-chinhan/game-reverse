package com.byazt.tc;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.lpr.q;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 422, 19})
public class n {
    public final com.byazt.byp.n n = new com.byazt.byp.n(com.byazt.qt.n.d().oa());
    public q.n qg;

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        q.n nVarN = n(uri);
        if (nVarN != null) {
            return nVarN.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public String getType(Uri uri) {
        q.n nVarN = n(uri);
        if (nVarN != null) {
            return nVarN.getType(uri);
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        q.n nVarN = n(uri);
        if (nVarN != null) {
            return nVarN.insert(uri, contentValues);
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        q.n nVarN = n(uri);
        if (nVarN != null) {
            return nVarN.delete(uri, str, strArr);
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        q.n nVarN = n(uri);
        if (nVarN != null) {
            return nVarN.update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private q.n n(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "uri is error3");
            return null;
        }
        if (this.qg == null) {
            s sVar = new s();
            this.qg = sVar;
            sVar.init();
        }
        if (str.equals(this.qg.getTableName())) {
            return this.qg;
        }
        if (str.equals(this.n.getTableName())) {
            return this.n;
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, "uri is error4");
        return null;
    }
}
