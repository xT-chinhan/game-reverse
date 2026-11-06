package com.byazt.udc;

import com.anythink.core.common.l.b;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 26})
public class qg {

    public interface n {
        void n(int i, String str);

        void n(String str);
    }

    private static SSLSocketFactory n(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager n() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void n(String str, File file, Map<String, String> map, n nVar, Map<String, String> map2) {
        DataOutputStream dataOutputStream;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setRequestMethod(TapHttp.METHOD_POST);
                httpsURLConnection2.setReadTimeout(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
                httpsURLConnection2.setConnectTimeout(10000);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setUseCaches(false);
                String string = UUID.randomUUID().toString();
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        httpsURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpsURLConnection2.setRequestProperty(b.g, "multipart/form-data;boundary=" + string);
                httpsURLConnection2.setSSLSocketFactory(n(n()));
                httpsURLConnection2.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("--").append(string).append("\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"").append(file.getName()).append("\"\r\nContent-Type: multipart/form-data\r\nContent-Length: ").append(file.length()).append("\r\n\r\n");
                    dataOutputStream.writeBytes(sb.toString());
                    dataOutputStream.flush();
                    com.byazt.xu.s.n(dataOutputStream, file);
                    dataOutputStream.writeBytes("\r\n");
                    if (map != null) {
                        for (Map.Entry<String, String> entry2 : map.entrySet()) {
                            String key = entry2.getKey();
                            String value = entry2.getValue();
                            if (value != null && key != null) {
                                n(dataOutputStream, key, value, string);
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + string + "--\r\n");
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    n(httpsURLConnection2, nVar);
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    com.byazt.xu.s.n(dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (nVar != null) {
                        try {
                            nVar.n(-1, th.getMessage());
                        } finally {
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            com.byazt.xu.s.n(dataOutputStream);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
        }
    }

    private void n(DataOutputStream dataOutputStream, String str, String str2, String str3) throws IOException {
        dataOutputStream.writeBytes("\r\n--" + str3 + "\r\nContent-Disposition: form-data; name=\"" + str + "\";\r\nContent-Length: " + str2.length() + "\r\n\r\n" + str2 + "\r\n");
    }

    private void n(HttpURLConnection httpURLConnection, n nVar) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            } else {
                sb.append(line);
            }
        }
        if (responseCode == 200) {
            if (nVar != null) {
                nVar.n(sb.toString());
            }
        } else if (nVar != null) {
            nVar.n(responseCode, sb.toString());
        }
    }
}
