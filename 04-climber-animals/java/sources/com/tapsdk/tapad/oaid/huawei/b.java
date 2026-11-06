package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final Uri a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
    private static final Uri b = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();

    static final class a implements Runnable {
        final d.b a;
        final Context b;

        a(d.b bVar, Context context) {
            this.a = bVar;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.c()) {
                Log.d("InfoProviderUtil", "within key update interval.");
                return;
            }
            this.a.b();
            this.a.a(b.d(this.b));
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.oaid.huawei.b$b, reason: collision with other inner class name */
    static final class RunnableC0646b implements Runnable {
        final Context a;
        final d.b b;

        RunnableC0646b(Context context, d.b bVar) {
            this.a = context;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(b.d(this.a));
        }
    }

    public static AdvertisingIdClient.Info a(Context context) {
        if (context == null || !a(context, a)) {
            return null;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        d.b bVarA = d.b.a(context);
        String strA = bVarA.a();
        if (TextUtils.isEmpty(strA)) {
            Log.d("InfoProviderUtil", "scp is empty");
            e.a.execute(new a(bVarA, context));
            if (bVarA.e()) {
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            }
            bVarA.d();
            return null;
        }
        String strA2 = d.a(string, strA);
        if (!TextUtils.isEmpty(strA2)) {
            return new AdvertisingIdClient.Info(strA2, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strA2));
        }
        Log.d("InfoProviderUtil", "decrypt oaid failed.");
        e.a.execute(new RunnableC0646b(context, bVarA));
        return null;
    }

    private static boolean a(Context context, Uri uri) {
        Integer numB;
        if (context == null || uri == null || (numB = e.b(context)) == null || 30462100 > numB.intValue()) {
            return false;
        }
        return e.a(context, uri);
    }

    public static AdvertisingIdClient.Info b(Context context) {
        if (context == null || !c(context)) {
            return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(b, null, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                AdvertisingIdClient.Info info = new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
                e.a(cursorQuery);
                return info;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
            String string = cursorQuery.getString(columnIndexOrThrow);
            AdvertisingIdClient.Info info2 = new AdvertisingIdClient.Info(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
            e.a(cursorQuery);
            return info2;
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "query oaid via provider ex: " + th.getClass().getSimpleName());
                return new AdvertisingIdClient.Info("00000000-0000-0000-0000-000000000000", true);
            } finally {
                e.a((Closeable) null);
            }
        }
    }

    public static boolean c(Context context) {
        return a(context, b);
    }

    static String d(Context context) {
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
                e.a(cursorQuery);
                return "";
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
            e.a(cursorQuery);
            return string;
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th.getClass().getSimpleName());
                return "";
            } finally {
                e.a(cursorQuery);
            }
        }
    }
}
