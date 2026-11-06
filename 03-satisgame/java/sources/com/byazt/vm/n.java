package com.byazt.vm;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.byazt.byp.l;
import com.byazt.lpr.q;
import com.byazt.nf.rv;
import com.byazt.wd.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 956, 19})
public class n implements q.n {
    public Context n;

    @Override // com.byazt.lpr.q.n
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.byazt.lpr.q.n
    public String getTableName() {
        return "t_frequent";
    }

    @Override // com.byazt.lpr.q.n
    public void init() {
    }

    @Override // com.byazt.lpr.q.n
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.byazt.lpr.q.n
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static ContentResolver l() {
        try {
            if (rv.getContext() != null) {
                return rv.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean n(String str) {
        return n(str, "checkFrequency");
    }

    public static boolean qg(String str) {
        return n(str, "checkAggFrequency");
    }

    public static boolean n(String str, String str2) {
        if (rv.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverL = l();
            if (contentResolverL != null) {
                return "true".equals(contentResolverL.getType(Uri.parse(w() + str2 + "?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean n() {
        return s("isSilent");
    }

    public static boolean qg() {
        return s("isAggSilent");
    }

    public static boolean s(String str) {
        if (rv.getContext() == null) {
            return false;
        }
        try {
            ContentResolver contentResolverL = l();
            if (contentResolverL != null) {
                return "true".equals(contentResolverL.getType(Uri.parse(w() + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String s() {
        return q("maxRit");
    }

    public static String q() {
        return q("maxAggRit");
    }

    public static String q(String str) {
        if (rv.getContext() == null) {
            return null;
        }
        try {
            ContentResolver contentResolverL = l();
            if (contentResolverL != null) {
                return contentResolverL.getType(Uri.parse(w() + str));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String w() {
        return l.qg + "/t_frequent/";
    }

    @Override // com.byazt.lpr.q.n
    public void injectContext(Context context) {
        this.n = context;
    }

    private Context getContext() {
        Context context = this.n;
        return context == null ? rv.getContext() : context;
    }

    @Override // com.byazt.lpr.q.n
    public String getType(Uri uri) {
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return fs.n().n(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return fs.n().q() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return fs.n().l();
        }
        if ("checkAggFrequency".equals(str)) {
            return com.byazt.wd.n.n().n(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isAggSilent".equals(str)) {
            return com.byazt.wd.n.n().q() ? "true" : "false";
        }
        if ("maxAggRit".equals(str)) {
            return com.byazt.wd.n.n().l();
        }
        return null;
    }
}
