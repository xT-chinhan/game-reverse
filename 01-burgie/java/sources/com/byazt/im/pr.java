package com.byazt.im;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byazt.dt.zo;
import com.byazt.iy.c;
import com.byazt.nq.hw;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1858, 37})
public class pr implements hw.pr {
    public Context pr;

    private static ContentResolver c() {
        try {
            if (a.getContext() != null) {
                return a.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean pr(String str) {
        return pr(str, "checkFrequency");
    }

    public static boolean hw(String str) {
        return pr(str, "checkAggFrequency");
    }

    public static boolean pr(String str, String str2) {
        if (a.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverC = c();
            if (contentResolverC != null) {
                return "true".equals(contentResolverC.getType(Uri.parse(uc() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean pr() {
        return hn("isSilent");
    }

    public static boolean hw() {
        return hn("isAggSilent");
    }

    public static boolean hn(String str) {
        if (a.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverC = c();
            if (contentResolverC != null) {
                return "true".equals(contentResolverC.getType(Uri.parse(uc() + str)));
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String hn() {
        return x("maxRit");
    }

    public static String x() {
        return x("maxAggRit");
    }

    public static String x(String str) {
        if (a.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverC = c();
            if (contentResolverC != null) {
                return contentResolverC.getType(Uri.parse(uc() + str));
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static String uc() {
        return c.hw + "/t_frequent/";
    }

    @Override // com.byazt.nq.hw.pr
    public void injectContext(Context context) {
        this.pr = context;
    }

    @Override // com.byazt.nq.hw.pr
    public String getTableName() {
        return "t_frequent";
    }

    private Context getContext() {
        Context context = this.pr;
        return context == null ? a.getContext() : context;
    }

    @Override // com.byazt.nq.hw.pr
    public void init() {
    }

    @Override // com.byazt.nq.hw.pr
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return zo.pr().pr(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return zo.pr().x() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return zo.pr().c();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.byazt.dt.pr.pr().pr(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isAggSilent".equals(str)) {
            return com.byazt.dt.pr.pr().x() ? "true" : "false";
        }
        if ("maxAggRit".equals(str)) {
            return com.byazt.dt.pr.pr().c();
        }
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.byazt.nq.hw.pr
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.nq.hw.pr
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
