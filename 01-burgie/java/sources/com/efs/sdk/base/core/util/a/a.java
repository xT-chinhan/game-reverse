package com.efs.sdk.base.core.util.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.http.IHttpUtil;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IHttpUtil {
    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    /* JADX INFO: renamed from: com.efs.sdk.base.core.util.a.a$a, reason: collision with other inner class name */
    static class C0252a {
        private static final a a = new a(0);
    }

    public static a a() {
        return C0252a.a;
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0055: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x0055 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static HttpResponse a(HttpURLConnection httpURLConnection) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Closeable closeable;
        ?? r5;
        HttpResponse httpResponse = new HttpResponse();
        if (httpURLConnection == 0) {
            return httpResponse;
        }
        Closeable closeable2 = null;
        try {
            try {
                httpResponse.setHttpCode(httpURLConnection.getResponseCode());
                httpURLConnection = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(httpURLConnection.available());
                    while (true) {
                        try {
                            int i = httpURLConnection.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        } catch (Throwable th2) {
                            th = th2;
                            Log.e("efs.util.http", "get response error", th);
                            r5 = httpURLConnection;
                        }
                    }
                    httpResponse.data = byteArrayOutputStream.toString();
                    r5 = httpURLConnection;
                } catch (Throwable th3) {
                    th = th3;
                    com.efs.sdk.base.core.util.b.a((Closeable) httpURLConnection);
                    com.efs.sdk.base.core.util.b.a(closeable2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable2 = closeable;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = 0;
        }
        com.efs.sdk.base.core.util.b.a((Closeable) r5);
        com.efs.sdk.base.core.util.b.a(byteArrayOutputStream);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse get(String str, Map<String, String> map) throws Throwable {
        HttpURLConnection httpURLConnectionA;
        Throwable th;
        UnknownHostException e;
        SocketTimeoutException e2;
        HttpResponse httpResponse = new HttpResponse();
        int i = 0;
        while (i < 3) {
            try {
                httpURLConnectionA = a(str, map);
                try {
                    httpURLConnectionA.setRequestMethod(TapHttp.METHOD_GET);
                    httpURLConnectionA.setInstanceFollowRedirects(true);
                    httpURLConnectionA.setRequestProperty("Connection", ILivePush.ClickType.CLOSE);
                    httpURLConnectionA.connect();
                    HttpResponse httpResponseA = a(httpURLConnectionA);
                    b(httpURLConnectionA);
                    httpResponse = httpResponseA;
                    break;
                } catch (SocketTimeoutException e3) {
                    e2 = e3;
                    httpResponse.setHttpCode(-3);
                    Log.e("efs.util.http", "post file '" + str + "' error", e2);
                    b(httpURLConnectionA);
                } catch (UnknownHostException e4) {
                    e = e4;
                    httpResponse.setHttpCode(-2);
                    Log.e("efs.util.http", "get request '" + str + "' error， maybe network is disconnect", e);
                    b(httpURLConnectionA);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.e("efs.util.http", "get request '" + str + "' error", th);
                        i++;
                        b(httpURLConnectionA);
                    } catch (Throwable th3) {
                        th = th3;
                        b(httpURLConnectionA);
                        throw th;
                    }
                }
            } catch (SocketTimeoutException e5) {
                httpURLConnectionA = null;
                e2 = e5;
            } catch (UnknownHostException e6) {
                httpURLConnectionA = null;
                e = e6;
            } catch (Throwable th4) {
                httpURLConnectionA = null;
                th = th4;
            }
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return a(str, map, null, bArr);
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull File file) {
        return a(str, map, file, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.io.Closeable, java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v26, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v9 */
    @NonNull
    private static HttpResponse a(@NonNull String str, @Nullable Map<String, String> map, @Nullable File file, @Nullable byte[] bArr) throws Throwable {
        ?? r9;
        OutputStream outputStream;
        ?? r3;
        HttpURLConnection httpURLConnectionA;
        ?? r10;
        ?? r4;
        ?? r11;
        ?? r5;
        ?? dataOutputStream;
        HttpResponse httpResponseA;
        HttpResponse httpResponse = new HttpResponse();
        HttpURLConnection httpURLConnection = null;
         = 0;
         = 0;
         = 0;
         = 0;
         = 0;
         = 0;
        ?? r1 = 0;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                httpURLConnectionA = a(str, map);
                try {
                    httpURLConnectionA.setRequestMethod(TapHttp.METHOD_POST);
                    httpURLConnectionA.setRequestProperty("Connection", ILivePush.ClickType.CLOSE);
                    httpURLConnectionA.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    outputStream = httpURLConnectionA.getOutputStream();
                    try {
                        dataOutputStream = new DataOutputStream(outputStream);
                        try {
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == 0) {
                                if (file != null && file.exists()) {
                                    dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    bArr = new FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int i = bArr.read(bArr2);
                                            if (i == -1) {
                                                break;
                                            }
                                            dataOutputStream.write(bArr2, 0, i);
                                        }
                                        r1 = bArr;
                                    } catch (SocketTimeoutException e) {
                                        e = e;
                                        httpURLConnection = httpURLConnectionA;
                                        r5 = dataOutputStream;
                                        r11 = bArr;
                                        httpResponse.setHttpCode(-3);
                                        Log.e("efs.util.http", "post file '" + str + "' error", e);
                                        dataOutputStream = r5;
                                        bArr = r11;
                                        b(httpURLConnection);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) bArr);
                                        httpResponseA = httpResponse;
                                    } catch (UnknownHostException e2) {
                                        e = e2;
                                        httpURLConnection = httpURLConnectionA;
                                        r4 = dataOutputStream;
                                        r10 = bArr;
                                        httpResponse.setHttpCode(-2);
                                        Log.e("efs.util.http", "post file '" + str + "' error， maybe network is disconnect", e);
                                        dataOutputStream = r4;
                                        bArr = r10;
                                        b(httpURLConnection);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) bArr);
                                        httpResponseA = httpResponse;
                                    } catch (Throwable th) {
                                        th = th;
                                        httpURLConnection = httpURLConnectionA;
                                        r3 = dataOutputStream;
                                        r9 = bArr;
                                        Log.e("efs.util.http", "post file '" + str + "' error", th);
                                        dataOutputStream = r3;
                                        bArr = r9;
                                        b(httpURLConnection);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a((Closeable) bArr);
                                        httpResponseA = httpResponse;
                                    }
                                }
                                b(httpURLConnectionA);
                                com.efs.sdk.base.core.util.b.a(outputStream);
                                com.efs.sdk.base.core.util.b.a((Closeable) dataOutputStream);
                                com.efs.sdk.base.core.util.b.a((Closeable) null);
                                return httpResponse;
                            }
                            dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(bArr, 0, bArr.length);
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            httpResponseA = a(httpURLConnectionA);
                            b(httpURLConnectionA);
                            com.efs.sdk.base.core.util.b.a(outputStream);
                            com.efs.sdk.base.core.util.b.a((Closeable) dataOutputStream);
                            com.efs.sdk.base.core.util.b.a((Closeable) r1);
                        } catch (SocketTimeoutException e3) {
                            e = e3;
                            bArr = r1;
                        } catch (UnknownHostException e4) {
                            e = e4;
                            bArr = r1;
                        } catch (Throwable th2) {
                            th = th2;
                            bArr = r1;
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        bArr = 0;
                        dataOutputStream = 0;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        bArr = 0;
                        dataOutputStream = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        bArr = 0;
                        dataOutputStream = 0;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    bArr = 0;
                    outputStream = null;
                    dataOutputStream = 0;
                } catch (UnknownHostException e8) {
                    e = e8;
                    bArr = 0;
                    outputStream = null;
                    dataOutputStream = 0;
                } catch (Throwable th4) {
                    th = th4;
                    bArr = 0;
                    outputStream = null;
                    dataOutputStream = 0;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnectionA = httpURLConnection;
            }
        } catch (SocketTimeoutException e9) {
            e = e9;
            r11 = 0;
            outputStream = null;
            r5 = 0;
        } catch (UnknownHostException e10) {
            e = e10;
            r10 = 0;
            outputStream = null;
            r4 = 0;
        } catch (Throwable th6) {
            th = th6;
            r9 = 0;
            outputStream = null;
            r3 = 0;
        }
        httpResponseA.setReqUrl(str);
        return httpResponseA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr) throws Throwable {
        ?? r7;
        HttpResponse httpResponseA;
        HttpResponse httpResponse = new HttpResponse();
        OutputStream outputStream = null;
        try {
            try {
                map = a(str, map);
                try {
                    map.setRequestMethod(TapHttp.METHOD_POST);
                    map.setRequestProperty("Connection", ILivePush.ClickType.CLOSE);
                    OutputStream outputStream2 = map.getOutputStream();
                    try {
                        outputStream2.write(bArr);
                        httpResponseA = a(map);
                        com.efs.sdk.base.core.util.b.a(outputStream2);
                        b(map);
                    } catch (SocketTimeoutException e) {
                        e = e;
                        outputStream = outputStream2;
                        httpResponse.setHttpCode(-3);
                        Log.e("efs.util.http", "post file '" + str + "' error", e);
                        r7 = map;
                        com.efs.sdk.base.core.util.b.a(outputStream);
                        b(r7);
                        httpResponseA = httpResponse;
                    } catch (UnknownHostException e2) {
                        e = e2;
                        outputStream = outputStream2;
                        httpResponse.setHttpCode(-2);
                        Log.e("efs.util.http", "post data to '" + str + "' error， maybe network is disconnect", e);
                        r7 = map;
                        com.efs.sdk.base.core.util.b.a(outputStream);
                        b(r7);
                        httpResponseA = httpResponse;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = outputStream2;
                        com.efs.sdk.base.core.util.b.a(outputStream);
                        b(map);
                        throw th;
                    }
                } catch (SocketTimeoutException e3) {
                    e = e3;
                } catch (UnknownHostException e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SocketTimeoutException e5) {
            e = e5;
            map = 0;
        } catch (UnknownHostException e6) {
            e = e6;
            map = 0;
        } catch (Throwable th4) {
            th = th4;
            map = 0;
        }
        httpResponseA.setReqUrl(str);
        return httpResponseA;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                com.efs.sdk.base.core.util.b.a(httpURLConnection.getInputStream());
            } catch (Throwable th) {
            }
        }
    }
}
