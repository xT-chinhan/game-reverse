package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFile {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int SOCKET_TIMEOUT = 120000;

    public static class DownloadResult {
        public final String errorMsg;
        public final int httpCode;
        public final boolean isSuccess;

        private DownloadResult(boolean z, int i, String str) {
            this.isSuccess = z;
            this.httpCode = i;
            this.errorMsg = str;
        }

        public static DownloadResult success() {
            return new DownloadResult(true, 200, "");
        }

        public static DownloadResult failure(int i, String str) {
            return new DownloadResult(false, i, str);
        }
    }

    public static DownloadResult downloadFileSync(Context context, String str, File file) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        int responseCode = 0;
        HttpURLConnection httpURLConnection = null;
        try {
            if (file.exists()) {
                Dir.safeDeleteFile(file);
            }
            fileOutputStream = new FileOutputStream(file, false);
            try {
                HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(str);
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnectionCreateUrlConnection.getInputStream());
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        DownloadResult downloadResultSuccess = DownloadResult.success();
                        closeQuietly(fileOutputStream);
                        closeQuietly(bufferedInputStream);
                        if (httpURLConnectionCreateUrlConnection != null) {
                            httpURLConnectionCreateUrlConnection.disconnect();
                        }
                        return downloadResultSuccess;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnectionCreateUrlConnection;
                        if (httpURLConnection != null) {
                            try {
                                try {
                                    responseCode = httpURLConnection.getResponseCode();
                                } finally {
                                    closeQuietly(fileOutputStream);
                                    closeQuietly(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                        Dir.safeDeleteFile(file);
                        return DownloadResult.failure(responseCode, "Download failed, url=" + str + " msg=" + th.getMessage());
                    }
                } catch (Throwable th3) {
                    bufferedInputStream = null;
                    httpURLConnection = httpURLConnectionCreateUrlConnection;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            bufferedInputStream = null;
            th = th5;
            fileOutputStream = null;
        }
    }

    private static HttpURLConnection createUrlConnection(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(SOCKET_TIMEOUT);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
