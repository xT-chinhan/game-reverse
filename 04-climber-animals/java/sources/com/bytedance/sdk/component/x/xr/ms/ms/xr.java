package com.bytedance.sdk.component.x.xr.ms.ms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.x.ms.ka;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void insert(Context context, String str, ContentValues contentValues, ka kaVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ms.ms(context).ms().insert(kaVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.x.ms.xr> list, ka kaVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ms.ms(context).ms().insert(kaVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, ka kaVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return ms.ms(context).ms().delete(kaVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, ka kaVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return ms.ms(context).ms().update(kaVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, ka kaVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms.ms(context).ms().query(kaVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String ms(Context context, String str, ka kaVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            ms.ms(context).ms().ms(kaVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }
}
