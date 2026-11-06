package com.byazt.ya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.nn.fw;
import com.byazt.vkw.nt;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1039, 13})
public class hw {
    private static SQLiteDatabase pr(Context context, com.byazt.hh.hw hwVar, String str) {
        if (TextUtils.equals(str, "adevent_applog")) {
            return com.byazt.gsb.pr.pr(context).pr().pr();
        }
        return hwVar.pr().pr(context);
    }

    public static void insert(Context context, String str, ContentValues contentValues, com.byazt.hh.hw hwVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            pr.pr().hw().insert(pr(context, hwVar, str), str, null, contentValues);
        } catch (Throwable th) {
            fw.pr("insert ignore", th);
        }
    }

    public static void insert(Context context, nt ntVar, String str, List<com.byazt.hh.pr> list, com.byazt.hh.hw hwVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            pr.pr().hw().insert(pr(context, hwVar, str), ntVar, str, null, list);
        } catch (Throwable th) {
            fw.pr("insert ignore", th);
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, com.byazt.hh.hw hwVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            fw.pr("DBMultiUtils  delete start");
            return pr.pr().hw().delete(pr(context, hwVar, str), str, str2, strArr);
        } catch (Throwable th) {
            fw.pr("delete ignore", th);
            return 0;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, com.byazt.hh.hw hwVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return pr.pr().hw().update(pr(context, hwVar, str), str, contentValues, str2, strArr);
        } catch (Throwable th) {
            fw.pr("update ignore", th);
            return 0;
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, com.byazt.hh.hw hwVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return pr.pr().hw().query(pr(context, hwVar, str), str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable th) {
            fw.pr("query ignore", th);
            return null;
        }
    }

    public static String pr(Context context, String str, com.byazt.hh.hw hwVar, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            pr.pr().hw().pr(pr(context, hwVar, str2), Uri.decode(str), str2);
            return "execSql ok";
        } catch (Throwable th) {
            fw.pr("execSQL ignore", th);
            return "exec sql exception:" + th.getMessage();
        }
    }
}
