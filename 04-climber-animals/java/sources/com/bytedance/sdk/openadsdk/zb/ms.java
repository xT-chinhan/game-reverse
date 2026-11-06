package com.bytedance.sdk.openadsdk.zb;

import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.op.d;
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
public class ms {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.zb.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0343ms {
        void ms(int i, String str);

        void ms(String str);
    }

    private static SSLSocketFactory ms(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Throwable th) {
            throw new RuntimeException("No System TLS", th);
        }
    }

    private static X509TrustManager ms() {
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
        } catch (Throwable th) {
            sl.xr("Https", th);
            return null;
        }
    }

    public void ms(String str, File file, Map<String, String> map, InterfaceC0343ms interfaceC0343ms, Map<String, String> map2) {
        DataOutputStream dataOutputStream;
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setReadTimeout(20000);
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
                httpsURLConnection2.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string);
                httpsURLConnection2.setSSLSocketFactory(ms(ms()));
                httpsURLConnection2.connect();
                dataOutputStream = new DataOutputStream(httpsURLConnection2.getOutputStream());
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("--").append(string).append("\r\nContent-Disposition: form-data; name=\"logFile\"; filename=\"").append(file.getName()).append("\"\r\nContent-Type: multipart/form-data\r\nContent-Length: ").append(file.length()).append("\r\n\r\n");
                    dataOutputStream.writeBytes(sb.toString());
                    dataOutputStream.flush();
                    d.ms(dataOutputStream, file);
                    dataOutputStream.writeBytes("\r\n");
                    if (map != null) {
                        for (Map.Entry<String, String> entry2 : map.entrySet()) {
                            String key = entry2.getKey();
                            String value = entry2.getValue();
                            if (value != null && key != null) {
                                ms(dataOutputStream, key, value, string);
                            }
                        }
                    }
                    dataOutputStream.writeBytes("--" + string + "--\r\n");
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    ms(httpsURLConnection2, interfaceC0343ms);
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    d.ms(dataOutputStream);
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    try {
                        sl.xr("Https", th);
                        if (interfaceC0343ms != null) {
                            interfaceC0343ms.ms(-1, th.getMessage());
                        }
                    } finally {
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        d.ms(dataOutputStream);
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

    private void ms(DataOutputStream dataOutputStream, String str, String str2, String str3) throws IOException {
        dataOutputStream.writeBytes("\r\n--" + str3 + "\r\nContent-Disposition: form-data; name=\"" + str + "\";\r\nContent-Length: " + str2.length() + "\r\n\r\n" + str2 + "\r\n");
    }

    private void ms(HttpURLConnection httpURLConnection, InterfaceC0343ms interfaceC0343ms) throws IOException {
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
            if (interfaceC0343ms != null) {
                interfaceC0343ms.ms(sb.toString());
            }
        } else if (interfaceC0343ms != null) {
            interfaceC0343ms.ms(responseCode, sb.toString());
        }
    }
}
