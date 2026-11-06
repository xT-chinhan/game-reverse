package com.mcto.sspsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h6 {
    public static final Set a = Collections.newSetFromMap(new ConcurrentHashMap());

    public static void a(Context context, TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        gh.a.a(new e6(context, textView, str));
    }

    public static void a(File file, String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        FileOutputStream fileOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(AVMDLDataLoader.KeyIsLiveSetLoaderType);
                httpURLConnection.setReadTimeout(AVMDLDataLoader.KeyIsLiveSetLoaderType);
                httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream2.write(bArr, 0, i);
                                }
                            }
                            fileOutputStream2.flush();
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                            }
                            httpURLConnection.disconnect();
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    throw new IOException("HTTP " + httpURLConnection.getResponseCode());
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }
}
