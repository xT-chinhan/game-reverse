package com.bytedance.sdk.component.c.xr;

import com.bytedance.sdk.component.utils.sl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.c.d<d> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.bytedance.sdk.component.c.d
    public d<byte[]> call(com.bytedance.sdk.component.c.ka kaVar) throws Throwable {
        InputStream inputStream;
        byte[] byteArray;
        ?? byteArrayOutputStream;
        String message;
        ?? r6;
        InputStream inputStream2 = null;
        Map<String, String> mapMs = null;
        int i = 0;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kaVar.ms()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        while (true) {
                            try {
                                int i2 = inputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } catch (MalformedURLException e) {
                                e = e;
                                byteArray = null;
                            } catch (IOException e2) {
                                e = e2;
                                byteArray = null;
                            }
                            sl.xr("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                            message = e.getMessage();
                            r6 = byteArrayOutputStream;
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(r6);
                            return new d<>(i, byteArray, message, mapMs);
                        }
                        mapMs = kaVar.xr() ? ms(httpURLConnection) : null;
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
                        message = "success";
                    } catch (MalformedURLException e3) {
                        e = e3;
                        sl.xr("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(r6);
                    } catch (IOException e4) {
                        e = e4;
                        sl.xr("InternalHttpClient", "IOException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(r6);
                    }
                    i = 200;
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (MalformedURLException e5) {
                    e = e5;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                } catch (IOException e6) {
                    e = e6;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                    sl.xr("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    r6 = byteArrayOutputStream;
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(r6);
                    return new d<>(i, byteArray, message, mapMs);
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream2);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(0);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MalformedURLException e7) {
            e = e7;
            inputStream = null;
            byteArray = null;
        } catch (IOException e8) {
            e = e8;
            inputStream = null;
            byteArray = null;
        } catch (Throwable th3) {
            th = th3;
            com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream2);
            com.bytedance.sdk.component.c.ah.ah.xr.ms(0);
            throw th;
        }
        return new d<>(i, byteArray, message, mapMs);
    }

    private Map<String, String> ms(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
