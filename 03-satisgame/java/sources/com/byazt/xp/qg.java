package com.byazt.xp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.gha.s;
import com.byazt.lpr.q;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1704, 26})
public class qg implements q.n {
    public Context n;

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "t_db";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
        this.n = context;
    }

    private boolean n(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context getContext() {
        Context context = this.n;
        return context == null ? rv.getContext() : context;
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (n(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit == null || strArrSplit.length < 4) {
            return null;
        }
        String str3 = strArrSplit[2];
        String str4 = strArrSplit[3];
        com.byazt.gha.q qVarN = n(str3);
        if (qVarN != null) {
            return qVarN.query(str4, strArr, str, strArr2, null, null, str2);
        }
        return null;
    }

    private com.byazt.gha.q n(String str) {
        if ("ttopensdk.db".equals(str)) {
            return s.n(getContext()).n();
        }
        if ("ttopensdk2.db".equals(str)) {
            return com.byazt.gha.n.n(getContext()).n();
        }
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        String[] strArrSplit;
        if (!n(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 5) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[4];
            com.byazt.gha.q qVarN = n(str);
            if (qVarN != null) {
                if ("execSQL".equals(str2)) {
                    String queryParameter = uri.getQueryParameter("sql");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        qVarN.n(Uri.decode(queryParameter));
                    }
                } else if ("transactionBegin".equals(str2)) {
                    qVarN.s();
                } else if ("transactionSetSuccess".equals(str2)) {
                    qVarN.q();
                } else if ("transactionEnd".equals(str2)) {
                    qVarN.l();
                }
            }
        }
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) throws Exception {
        String[] strArrSplit;
        if (!n(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            com.byazt.gha.q qVarN = n(str);
            if (qVarN != null) {
                qVarN.insert(str2, null, contentValues);
            }
        }
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!n(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            com.byazt.gha.q qVarN = n(str2);
            if (qVarN != null) {
                qVarN.delete(str3, str, strArr);
            }
        }
        return 0;
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws Exception {
        String[] strArrSplit;
        if (!n(uri) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length >= 4) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            com.byazt.gha.q qVarN = n(str2);
            if (qVarN != null) {
                qVarN.update(str3, contentValues, str, strArr);
            }
        }
        return 0;
    }
}
