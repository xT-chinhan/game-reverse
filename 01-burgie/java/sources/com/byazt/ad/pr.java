package com.byazt.ad;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.iy.c;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 37})
public class pr {
    private static ContentResolver pr(Context context) {
        if (context == null) {
            try {
                context = a.getContext();
            } catch (Throwable th) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    private static String pr(String str) {
        String str2;
        if (!com.byazt.bu.hw.pr(str)) {
            str2 = "ttopensdk.db";
        } else {
            str2 = "ttopensdk2.db";
        }
        return c.hw + "/t_db/" + str2 + "/";
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr(context);
            if (contentResolverPr != null) {
                contentResolverPr.insert(pr(Uri.parse(pr(str) + str), str), contentValues);
            }
        } catch (Throwable th) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverPr = pr(context);
            if (contentResolverPr != null) {
                return contentResolverPr.delete(pr(Uri.parse(pr(str) + str), str), str2, strArr);
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver contentResolverPr = pr(context);
            if (contentResolverPr != null) {
                return contentResolverPr.update(pr(Uri.parse(pr(str) + str), str), contentValues, str2, strArr);
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver contentResolverPr = pr(context);
            if (contentResolverPr != null) {
                return contentResolverPr.query(pr(Uri.parse(pr(str) + str), str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static void pr(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverPr = pr(context);
            if (contentResolverPr != null) {
                contentResolverPr.getType(pr(Uri.parse(pr(str2) + "unknown/execSQL?sql=" + Uri.encode(str)), str2));
            }
        } catch (Throwable th) {
        }
    }

    private static boolean hw(String str) {
        return TextUtils.equals(str, "setting_global_info") || TextUtils.equals(str, "setting_base_info") || TextUtils.equals(str, "setting_rit");
    }

    public static Uri pr(Uri uri, String str) {
        String strValueOf;
        if (uri != null) {
            try {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                if (hw(str)) {
                    strValueOf = "1";
                } else {
                    strValueOf = String.valueOf(com.byazt.iq.pr.c());
                }
                builderBuildUpon.appendQueryParameter("layerType", strValueOf);
                return builderBuildUpon.build();
            } catch (Throwable th) {
                return uri;
            }
        }
        return uri;
    }
}
