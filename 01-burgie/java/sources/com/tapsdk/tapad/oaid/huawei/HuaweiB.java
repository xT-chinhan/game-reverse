package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public class HuaweiB {
    private static final Uri a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    public static final class HuaweiB1 implements Runnable {
        final HuaweiD.HuaweiDA a;
        final Context b;

        public HuaweiB1(HuaweiD.HuaweiDA huaweiDA, Context context) {
            this.a = huaweiDA;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.c()) {
                return;
            }
            this.a.b();
            this.a.a(HuaweiB.d(this.b));
        }
    }

    public static final class HuaweiB2 implements Runnable {
        final Context a;
        final HuaweiD.HuaweiDA b;

        public HuaweiB2(Context context, HuaweiD.HuaweiDA huaweiDA) {
            this.a = context;
            this.b = huaweiDA;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(HuaweiB.d(this.a));
        }
    }

    public static AdvertisingIdClient.Info a(Context context) {
        if (!a(context, a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        HuaweiD.HuaweiDA huaweiDAA = HuaweiD.HuaweiDA.a(context);
        String strA = huaweiDAA.a();
        if (TextUtils.isEmpty(strA)) {
            HuaweiE.a.execute(new HuaweiB1(huaweiDAA, context));
            if (huaweiDAA.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            huaweiDAA.d();
            return null;
        }
        String strA2 = HuaweiD.a(string, strA);
        if (!TextUtils.isEmpty(strA2)) {
            return new AdvertisingIdClient.Info(strA2, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strA2));
        }
        HuaweiE.a.execute(new HuaweiB2(context, huaweiDAA));
        return null;
    }

    public static AdvertisingIdClient.Info b(Context context) {
        if (!c(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(b, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
                HuaweiE.a(cursorQuery);
                return info;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
            String string = cursorQuery.getString(columnIndexOrThrow);
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
            HuaweiE.a(cursorQuery);
            return info2;
        } catch (Throwable th) {
            try {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } finally {
                HuaweiE.a((Closeable) null);
            }
        }
    }

    public static boolean c(Context context) {
        return a(context, b);
    }

    public static String d(Context context) {
        return e(context);
    }

    private static String e(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(a, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                HuaweiE.a(cursorQuery);
                return "";
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
            HuaweiE.a(cursorQuery);
            return string;
        } catch (Throwable th) {
            HuaweiE.a(cursorQuery);
            return "";
        }
    }

    private static boolean a(Context context, Uri uri) {
        Integer numB;
        return (context == null || uri == null || (numB = HuaweiE.b(context)) == null || 30462100 > numB.intValue() || !HuaweiE.a(context, uri)) ? false : true;
    }
}
