package com.mcto.sspsdk.internal;

import com.bumptech.glide.load.Key;
import com.efs.sdk.base.Constants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes2.dex */
public final class g4 {
    public int a = -1;

    /* JADX WARN: Code duplicated, block: B:32:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(HttpURLConnection httpURLConnection) throws IOException {
        String contentEncoding = httpURLConnection.getContentEncoding();
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Constants.CP_GZIP.equals(contentEncoding) ? new GZIPInputStream(inputStream) : inputStream, Key.STRING_CHARSET_NAME));
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int i = bufferedReader.read(cArr);
                    if (i == -1) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                    throw th;
                }
                String string = sb.toString();
                bufferedReader.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return string;
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th4;
        }
    }

    public final String a(cg cgVar, int i) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(gj.c(cgVar.f)).openConnection();
            if (httpURLConnection == null) {
                this.a = -1;
                return "";
            }
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            HashMap map = cgVar.j;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : cgVar.j.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            byte[] bArr = cgVar.l;
            if (TapHttp.METHOD_POST.equals(cgVar.h)) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty(Util.CONTENT_LENGTH, String.valueOf(bArr.length));
                httpURLConnection.setRequestProperty("Content-Type", cgVar.i);
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Accept-Encoding", Constants.CP_GZIP);
            httpURLConnection.setRequestProperty("User-Agent", y4.r.f());
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            try {
                httpURLConnection.setRequestMethod(cgVar.h);
                if (bArr != null && bArr.length > 0 && TapHttp.METHOD_POST.equals(cgVar.h)) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArr);
                        outputStream.flush();
                        outputStream.close();
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                this.a = responseCode;
                if (responseCode >= 200 && responseCode < 300) {
                    return a(httpURLConnection);
                }
            } catch (UnsupportedEncodingException e) {
                this.a = -2;
            } catch (ProtocolException e2) {
                this.a = -3;
            } catch (SocketTimeoutException e3) {
                this.a = -4;
            } catch (SSLException e4) {
                this.a = -6;
            } catch (IOException e5) {
                this.a = -5;
            } catch (Exception e6) {
                this.a = -7;
            }
            return "";
        } catch (Exception e7) {
            this.a = -5;
            return "";
        }
    }
}
