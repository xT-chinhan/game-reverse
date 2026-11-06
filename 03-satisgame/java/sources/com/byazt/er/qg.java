package com.byazt.er;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.hls.x;
import com.byazt.vf.k;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 717, 26})
public class qg {
    private static SQLiteDatabase n(Context context, com.byazt.vr.qg qgVar, String str) {
        if (TextUtils.equals(str, "adevent_applog")) {
            return com.byazt.kh.n.n(context).n().n();
        }
        return qgVar.n().n(context);
    }

    public static void insert(Context context, String str, ContentValues contentValues, com.byazt.vr.qg qgVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            n.n().qg().insert(n(context, qgVar, str), str, null, contentValues);
        } catch (Throwable th) {
            x.n("insert ignore", th);
        }
    }

    public static void insert(Context context, k kVar, String str, List<com.byazt.vr.n> list, com.byazt.vr.qg qgVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            n.n().qg().insert(n(context, qgVar, str), kVar, str, null, list);
        } catch (Throwable th) {
            x.n("insert ignore", th);
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, com.byazt.vr.qg qgVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            x.n("DBMultiUtils  delete start");
            return n.n().qg().delete(n(context, qgVar, str), str, str2, strArr);
        } catch (Throwable th) {
            x.n("delete ignore", th);
            return 0;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, com.byazt.vr.qg qgVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return n.n().qg().update(n(context, qgVar, str), str, contentValues, str2, strArr);
            } catch (Throwable th) {
                x.n("update ignore", th);
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, com.byazt.vr.qg qgVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n.n().qg().query(n(context, qgVar, str), str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable th) {
            x.n("query ignore", th);
            return null;
        }
    }

    public static String n(Context context, String str, com.byazt.vr.qg qgVar, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            n.n().qg().n(n(context, qgVar, str2), Uri.decode(str), str2);
            return "execSql ok";
        } catch (Throwable th) {
            x.n("execSQL ignore", th);
            return "exec sql exception:" + th.getMessage();
        }
    }
}
