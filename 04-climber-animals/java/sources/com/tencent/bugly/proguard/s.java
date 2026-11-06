package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    private static s b;
    public Map<String, String> a = null;
    private Context c;

    private s(Context context) {
        this.c = context;
    }

    public static s a(Context context) {
        if (b == null) {
            b = new s(context);
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x018b A[PHI: r4 r6 r7 r10 r13 r14 r15
      0x018b: PHI (r4v5 java.lang.Throwable) = (r4v4 java.lang.Throwable), (r4v18 java.lang.Throwable) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r6v8 int) = (r6v7 int), (r6v13 int) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r7v4 char) = (r7v3 char), (r7v10 char) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r10v10 java.lang.String) = (r10v9 java.lang.String), (r10v15 java.lang.String) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r13v5 int) = (r13v4 int), (r13v8 int) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r14v6 int) = (r14v5 int), (r14v13 int) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x018b: PHI (r15v3 int) = (r15v2 int), (r15v9 int) binds: [B:103:0x0189, B:87:0x016b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x017c A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #1 {all -> 0x0170, blocks: (B:23:0x009c, B:25:0x00a4, B:29:0x00b5, B:28:0x00b3, B:49:0x00de, B:51:0x00e6, B:64:0x0117, B:66:0x0121, B:79:0x013c, B:82:0x015e, B:96:0x0176, B:98:0x017c), top: B:119:0x009c }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final byte[] a(String str, byte[] bArr, v vVar, Map<String, String> map) {
        int i;
        char c;
        int i2;
        Throwable th;
        byte[] bArr2 = null;
        int i3 = 0;
        if (str == null) {
            x.e("Failed for no URL.", new Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        int i4 = 1;
        x.c("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(length), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 <= 0 && i6 <= 0) {
            if (i7 != 0) {
                i = i5;
                i7 = i3;
            } else {
                int i8 = i5 + 1;
                if (i8 > i4) {
                    x.c("try time: " + i8, new Object[i3]);
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(10000)) + ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                }
                i = i8;
            }
            String strE = com.tencent.bugly.crashreport.common.info.b.e(this.c);
            if (strE == null) {
                x.d("Failed to request for network not avail", new Object[i3]);
                i5 = i;
                i4 = 1;
            } else {
                vVar.a(length);
                HttpURLConnection httpURLConnectionA = a(str2, bArr, strE, map);
                if (httpURLConnectionA != null) {
                    try {
                        try {
                            try {
                                int responseCode = httpURLConnectionA.getResponseCode();
                                if (responseCode == 200) {
                                    this.a = a(httpURLConnectionA);
                                    byte[] bArrB = b(httpURLConnectionA);
                                    vVar.b(bArrB == null ? 0L : bArrB.length);
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (Throwable th2) {
                                        if (!x.a(th2)) {
                                            th2.printStackTrace();
                                        }
                                    }
                                    return bArrB;
                                }
                                if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                                    try {
                                        String headerField = httpURLConnectionA.getHeaderField("Location");
                                        if (headerField == null) {
                                            try {
                                                x.e("Failed to redirect: %d" + responseCode, new Object[0]);
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                    return null;
                                                } catch (Throwable th3) {
                                                    if (x.a(th3)) {
                                                        return null;
                                                    }
                                                    th3.printStackTrace();
                                                    return null;
                                                }
                                            } catch (IOException e) {
                                                e = e;
                                                c = 2;
                                                i7 = 1;
                                            }
                                        } else {
                                            i6++;
                                            c = 2;
                                            try {
                                                Object[] objArr = new Object[2];
                                                objArr[0] = Integer.valueOf(responseCode);
                                                i2 = 1;
                                                try {
                                                    objArr[1] = headerField;
                                                    x.c("redirect code: %d ,to:%s", objArr);
                                                    str2 = headerField;
                                                    i7 = 1;
                                                    i = 0;
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    str2 = headerField;
                                                    i7 = i2;
                                                    i = 0;
                                                }
                                            } catch (IOException e3) {
                                                e = e3;
                                                i2 = 1;
                                            }
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                        c = 2;
                                        i2 = 1;
                                        i7 = 1;
                                    }
                                } else {
                                    c = 2;
                                    i2 = 1;
                                }
                                try {
                                    x.d("response code " + responseCode, new Object[0]);
                                    long contentLength = httpURLConnectionA.getContentLength();
                                    if (contentLength < 0) {
                                        contentLength = 0;
                                    }
                                    vVar.b(contentLength);
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        if (!x.a(th)) {
                                            th.printStackTrace();
                                        }
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    if (!x.a(e)) {
                                        e.printStackTrace();
                                    }
                                    httpURLConnectionA.disconnect();
                                }
                                i5 = i;
                            } catch (Throwable th5) {
                                try {
                                    httpURLConnectionA.disconnect();
                                    throw th5;
                                } catch (Throwable th6) {
                                    if (x.a(th6)) {
                                        throw th5;
                                    }
                                    th6.printStackTrace();
                                    throw th5;
                                }
                            }
                        } catch (IOException e6) {
                            e = e6;
                            c = 2;
                        }
                        httpURLConnectionA.disconnect();
                    } catch (Throwable th7) {
                        th = th7;
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                    }
                    i2 = 1;
                    if (!x.a(e)) {
                        e.printStackTrace();
                    }
                    i5 = i;
                } else {
                    c = 2;
                    i2 = 1;
                    x.c("Failed to execute post.", new Object[0]);
                    vVar.b(0L);
                    i5 = i;
                }
                i4 = i2;
                bArr2 = null;
                i3 = 0;
            }
        }
        return bArr2;
    }

    private static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    private static byte[] b(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    private HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            x.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            x.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionA.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionA.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionA;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            x.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
