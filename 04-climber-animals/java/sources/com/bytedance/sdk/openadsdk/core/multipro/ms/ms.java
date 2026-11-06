package com.bytedance.sdk.openadsdk.core.multipro.ms;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.multipro.ka;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static ContentResolver ms(Context context) {
        if (context == null) {
            try {
                context = re.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String ms() {
        return ka.xr + "/t_db/ttopensdk.db/";
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverMs = ms(context);
            if (contentResolverMs != null) {
                contentResolverMs.insert(Uri.parse(ms() + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverMs = ms(context);
            if (contentResolverMs != null) {
                return contentResolverMs.delete(Uri.parse(ms() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver contentResolverMs = ms(context);
                if (contentResolverMs != null) {
                    return contentResolverMs.update(Uri.parse(ms() + str), contentValues, str2, strArr);
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
            ContentResolver contentResolverMs = ms(context);
            if (contentResolverMs != null) {
                return contentResolverMs.query(Uri.parse(ms() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void ms(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverMs = ms(context);
            if (contentResolverMs != null) {
                contentResolverMs.getType(Uri.parse(ms() + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
