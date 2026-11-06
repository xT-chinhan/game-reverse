package com.tapsdk.tapad.internal.download.m;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.util.Log;
import com.tapsdk.tapad.internal.download.core.breakpoint.h;
import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import com.tapsdk.tapad.internal.download.f;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final String a = "HEAD";
    public static final String b = "Range";
    public static final String c = "If-Match";
    public static final String d = "User-Agent";
    public static final String e = "Content-Length";
    public static final String f = "Content-Range";
    public static final String g = "Etag";
    public static final String h = "Transfer-Encoding";
    public static final String i = "Accept-Ranges";
    public static final String j = "Content-Disposition";
    public static final String k = "chunked";
    public static final int l = -1;
    public static final int m = 416;
    private static InterfaceC0607c n = new b();

    static class a implements ThreadFactory {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.a);
            thread.setDaemon(this.b);
            return thread;
        }
    }

    public static class b implements InterfaceC0607c {
        @Override // com.tapsdk.tapad.internal.download.m.c.InterfaceC0607c
        public void a(String str, String str2) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.c.InterfaceC0607c
        public void a(String str, String str2, Exception exc) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.c.InterfaceC0607c
        public void b(String str, String str2) {
        }

        @Override // com.tapsdk.tapad.internal.download.m.c.InterfaceC0607c
        public void c(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.c$c, reason: collision with other inner class name */
    public interface InterfaceC0607c {
        void a(String str, String str2);

        void a(String str, String str2, Exception exc);

        void b(String str, String str2);

        void c(String str, String str2);
    }

    public static long a(StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static i a(Context context) {
        try {
            return (i) Class.forName("com.tapsdk.tapad.internal.download.core.breakpoint.BreakpointStoreOnSQLite").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new h();
        }
    }

    public static i a(i iVar) {
        try {
            iVar = (i) iVar.getClass().getMethod("createRemitSelf", new Class[0]).invoke(iVar, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        a("Util", "Get final download store is " + iVar);
        return iVar;
    }

    public static com.tapsdk.tapad.internal.download.core.connection.a.b a() {
        try {
            return (com.tapsdk.tapad.internal.download.core.connection.a.b) Class.forName("com.tapsdk.tapad.internal.core.connection.DownloadOkHttp3Connection$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new com.tapsdk.tapad.internal.download.core.connection.b.C0606b();
        }
    }

    public static File a(File file) {
        File parentFile = file.getParentFile();
        return parentFile == null ? new File("/") : parentFile;
    }

    public static String a(long j2, boolean z) {
        int i2 = z ? 1000 : 1024;
        if (j2 < i2) {
            return j2 + " B";
        }
        double d2 = j2;
        double d3 = i2;
        int iLog = (int) (Math.log(d2) / Math.log(d3));
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d2 / Math.pow(d3, iLog)), (z ? "kMGTPE" : "KMGTPE").charAt(iLog - 1) + (z ? "" : "i"));
    }

    public static String a(Uri uri) {
        Cursor cursorQuery = com.tapsdk.tapad.internal.download.i.j().d().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
        } finally {
            cursorQuery.close();
        }
    }

    public static ThreadFactory a(String str, boolean z) {
        return new a(str, z);
    }

    public static void a(com.tapsdk.tapad.internal.download.core.breakpoint.a aVar) {
        if (aVar.c() < 0 || aVar.c() > aVar.b()) {
            c("resetBlockIfDirty", "block is dirty so have to reset: " + aVar);
            aVar.g();
        }
    }

    public static void a(com.tapsdk.tapad.internal.download.core.connection.a aVar) {
        aVar.a("User-Agent", "OkDownload/3.16.3.45");
    }

    public static void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, long j2, boolean z) {
        ((Integer) com.tapsdk.tapad.internal.j.a.b().a("isUseMultiBlock", Integer.class, -1)).intValue();
        int iA = (fVar.B() && com.tapsdk.tapad.internal.download.i.j().f().a(z)) ? com.tapsdk.tapad.internal.download.i.j().f().a(fVar, j2) : 1;
        cVar.n();
        long j3 = iA;
        long j4 = j2 / j3;
        long j5 = 0;
        int i2 = 0;
        long j6 = 0;
        while (i2 < iA) {
            j5 += j6;
            j6 = i2 == 0 ? (j2 % j3) + j4 : j4;
            cVar.a(new com.tapsdk.tapad.internal.download.core.breakpoint.a(j5, j6));
            i2++;
        }
    }

    public static void a(InterfaceC0607c interfaceC0607c) {
        n = interfaceC0607c;
    }

    public static void a(String str, String str2) {
        InterfaceC0607c interfaceC0607c = n;
        if (interfaceC0607c != null) {
            interfaceC0607c.c(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Exception exc) {
        InterfaceC0607c interfaceC0607c = n;
        if (interfaceC0607c != null) {
            interfaceC0607c.a(str, str2, exc);
        } else {
            Log.e(str, str2, exc);
        }
    }

    public static void a(Map<String, List<String>> map) throws IOException {
        if (map.containsKey("If-Match") || map.containsKey("Range")) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static void a(Map<String, List<String>> map, com.tapsdk.tapad.internal.download.core.connection.a aVar) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                aVar.a(key, it.next());
            }
        }
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean a(String str) {
        return com.tapsdk.tapad.internal.download.i.j().d().checkCallingOrSelfPermission(str) == 0;
    }

    public static long b(Uri uri) {
        Cursor cursorQuery = com.tapsdk.tapad.internal.download.i.j().d().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return 0L;
        }
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
        } finally {
            cursorQuery.close();
        }
    }

    public static String b(String str) {
        byte[] bArrDigest;
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        if (bArrDigest == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        for (byte b2 : bArrDigest) {
            int i2 = b2 & UByte.MAX_VALUE;
            if (i2 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static void b() {
        n = null;
    }

    public static void b(String str, String str2) {
        InterfaceC0607c interfaceC0607c = n;
        if (interfaceC0607c != null) {
            interfaceC0607c.a(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void b(Map<String, List<String>> map, com.tapsdk.tapad.internal.download.core.connection.a aVar) throws IOException {
        a(map);
        a(map, aVar);
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static long c(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            a("Util", "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static InterfaceC0607c c() {
        return n;
    }

    public static void c(String str, String str2) {
        InterfaceC0607c interfaceC0607c = n;
        if (interfaceC0607c != null) {
            interfaceC0607c.b(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static boolean c(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static long d(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                c("Util", "parse content-length from content-range failed " + e2);
            }
        }
        return -1L;
    }

    public static boolean d(Uri uri) {
        return uri.getScheme().equals("file");
    }
}
