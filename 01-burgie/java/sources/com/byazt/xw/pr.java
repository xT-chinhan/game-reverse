package com.byazt.xw;

import com.byazt.ld.uc;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, 1525, 37})
public class pr implements com.byazt.ld.c<x> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.byazt.ld.c
    public x<byte[]> call(uc ucVar) throws Throwable {
        InputStream inputStream;
        byte[] byteArray;
        ?? byteArrayOutputStream;
        String message;
        ?? r5;
        int i = 0;
        InputStream inputStream2 = null;
        Map<String, String> mapPr = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(ucVar.pr()).openConnection();
                httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
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
                            e.getMessage();
                            message = e.getMessage();
                            r5 = byteArrayOutputStream;
                            com.byazt.cb.hw.pr(inputStream);
                            com.byazt.cb.hw.pr(r5);
                            return new x<>(i, byteArray, message, mapPr);
                        }
                        mapPr = ucVar.hw() ? pr(httpURLConnection) : null;
                        com.byazt.cb.hw.pr(inputStream);
                        com.byazt.cb.hw.pr(byteArrayOutputStream);
                        message = TrackAction.SUCCESS;
                    } catch (MalformedURLException e3) {
                        e = e3;
                        e.getMessage();
                        message = e.getMessage();
                        r5 = byteArrayOutputStream;
                        com.byazt.cb.hw.pr(inputStream);
                        com.byazt.cb.hw.pr(r5);
                    } catch (IOException e4) {
                        e = e4;
                        e.getMessage();
                        message = e.getMessage();
                        r5 = byteArrayOutputStream;
                        com.byazt.cb.hw.pr(inputStream);
                        com.byazt.cb.hw.pr(r5);
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
                    e.getMessage();
                    message = e.getMessage();
                    r5 = byteArrayOutputStream;
                    com.byazt.cb.hw.pr(inputStream);
                    com.byazt.cb.hw.pr(r5);
                    return new x<>(i, byteArray, message, mapPr);
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    com.byazt.cb.hw.pr(inputStream2);
                    com.byazt.cb.hw.pr(0);
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
            com.byazt.cb.hw.pr(inputStream2);
            com.byazt.cb.hw.pr(0);
            throw th;
        }
        return new x<>(i, byteArray, message, mapPr);
    }

    private Map<String, String> pr(HttpURLConnection httpURLConnection) {
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
