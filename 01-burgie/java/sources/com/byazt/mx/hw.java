package com.byazt.mx;

import android.net.Network;
import android.text.TextUtils;
import com.byazt.zp.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 13})
public class hw {
    /* JADX WARN: Code duplicated, block: B:46:0x00b2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStream] */
    public static JSONObject pr(Network network, String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        ?? inputStream;
        JSONObject jSONObject;
        ?? r0 = 0;
        if (str == null) {
            return null;
        }
        try {
            if (network == null) {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            } else {
                httpsURLConnection = (HttpsURLConnection) network.openConnection(new URL(str));
            }
            if (httpsURLConnection != null) {
                try {
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDefaultUseCaches(false);
                    if (!TextUtils.isEmpty(str2)) {
                        httpsURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                        httpsURLConnection.setDoOutput(true);
                        outputStream = httpsURLConnection.getOutputStream();
                        try {
                            outputStream.write(str2.getBytes());
                            outputStream.flush();
                        } catch (Throwable th) {
                            inputStream = 0;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            c.pr(outputStream);
                            c.pr((Closeable) inputStream);
                            return null;
                        }
                    } else {
                        httpsURLConnection.setRequestMethod(TapHttp.METHOD_GET);
                        outputStream = null;
                    }
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() != 200) {
                        jSONObject = null;
                    } else {
                        inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                            }
                            jSONObject = new JSONObject(sb.toString());
                            r0 = inputStream;
                        } catch (Throwable th2) {
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            c.pr(outputStream);
                            c.pr((Closeable) inputStream);
                            return null;
                        }
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    c.pr(outputStream);
                    c.pr((Closeable) r0);
                    return jSONObject;
                } catch (Throwable th3) {
                    outputStream = null;
                    inputStream = outputStream;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    c.pr(outputStream);
                    c.pr((Closeable) inputStream);
                    return null;
                }
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            c.pr((Closeable) null);
            c.pr((Closeable) null);
            return null;
        } catch (Throwable th4) {
            httpsURLConnection = null;
            outputStream = null;
        }
    }
}
