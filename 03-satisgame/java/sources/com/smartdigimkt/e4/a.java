package com.smartdigimkt.e4;

import android.text.TextUtils;
import com.smartdigimkt.d4.d;
import com.smartdigimkt.d4.e;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final com.smartdigimkt.d4.a a;

    public a(com.smartdigimkt.d4.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0108 A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #0 {all -> 0x010b, blocks: (B:52:0x0103, B:54:0x0108), top: B:59:0x0103 }] */
    public final e a(com.smartdigimkt.d4.c cVar, ArrayList arrayList) {
        HttpURLConnection httpURLConnection;
        String headerField;
        byte[] bArr;
        d dVar = new d();
        dVar.a = cVar;
        arrayList.add(cVar.a);
        dVar.f = arrayList;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(cVar.a).openConnection();
            try {
                String str = cVar.b;
                if (TextUtils.isEmpty(str)) {
                    str = TapHttp.METHOD_GET;
                }
                httpURLConnection.setRequestMethod(str);
                if (TapHttp.METHOD_POST.equals(str)) {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                } else if (TapHttp.METHOD_GET.equals(str)) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                }
                httpURLConnection.setConnectTimeout((int) this.a.b);
                httpURLConnection.setReadTimeout((int) this.a.a);
                Map map = cVar.d;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.connect();
                if (TapHttp.METHOD_POST.equals(str) && (bArr = cVar.c) != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                dVar.b = responseCode;
                dVar.e = httpURLConnection.getHeaderFields();
                if (responseCode == 200) {
                    dVar.d = new c(httpURLConnection, a(httpURLConnection));
                    dVar.g = -1L;
                    dVar.h = -1L;
                    dVar.i = -1L;
                    dVar.j = -1L;
                    dVar.k = false;
                    return dVar.a();
                }
                if ((responseCode != 302 && responseCode != 301 && responseCode != 307) || !cVar.e || (headerField = httpURLConnection.getHeaderField("Location")) == null || !headerField.toLowerCase().startsWith("http")) {
                    httpURLConnection.disconnect();
                    return dVar.a();
                }
                cVar.a = headerField;
                httpURLConnection.disconnect();
                return a(cVar, arrayList);
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable unused) {
                        dVar.c = th;
                        return dVar.a();
                    }
                } else if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                dVar.c = th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception unused) {
            inputStream = null;
        }
        if (!"gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int i = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (i == -1 || (((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE)) != 35615) ? bufferedInputStream : new GZIPInputStream(bufferedInputStream);
        } catch (Exception unused2) {
            return inputStream;
        }
    }
}
