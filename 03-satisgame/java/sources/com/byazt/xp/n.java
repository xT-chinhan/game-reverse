package com.byazt.xp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.byp.l;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1704, 19})
public class n {
    private static ContentResolver n(Context context) {
        if (context == null) {
            try {
                context = rv.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String n(String str) {
        return l.qg + "/t_db/" + (com.byazt.gha.qg.n(str) ? "ttopensdk2.db" : "ttopensdk.db") + "/";
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverN = n(context);
            if (contentResolverN != null) {
                contentResolverN.insert(n(Uri.parse(n(str) + str), str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverN = n(context);
            if (contentResolverN != null) {
                return contentResolverN.delete(n(Uri.parse(n(str) + str), str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverN = n(context);
                if (contentResolverN != null) {
                    return contentResolverN.update(n(Uri.parse(n(str) + str), str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverN = n(context);
            if (contentResolverN != null) {
                return contentResolverN.query(n(Uri.parse(n(str) + str), str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void n(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverN = n(context);
            if (contentResolverN != null) {
                contentResolverN.getType(n(Uri.parse(n(str2) + "unknown/execSQL?sql=" + Uri.encode(str)), str2));
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean qg(String str) {
        return TextUtils.equals(str, "setting_global_info") || TextUtils.equals(str, "setting_base_info") || TextUtils.equals(str, "setting_rit");
    }

    public static Uri n(Uri uri, String str) {
        if (uri == null) {
            return uri;
        }
        try {
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.appendQueryParameter("layerType", qg(str) ? "1" : String.valueOf(com.byazt.gv.n.l()));
            return builderBuildUpon.build();
        } catch (Throwable unused) {
            return uri;
        }
    }
}
