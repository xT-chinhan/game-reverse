package com.mar.sdk.utils;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.mar.sdk.MARSDK;
import com.mar.sdk.log.Log;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARHttpUtils {
    public static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.mar.sdk.utils.MARHttpUtils.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";

    /* JADX WARN: Code duplicated, block: B:26:0x010c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0171  */
    /* JADX WARN: Code duplicated, block: B:62:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    public static String httpGet(String urlStr, Map<String, String> params) throws Throwable {
        Throwable th;
        Exception e;
        String token = MARSDK.getInstance().getServerToken();
        if (TextUtils.isEmpty(token)) {
            return null;
        }
        String result = null;
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        String paramsEncoded = "";
        if (params != null) {
            try {
                try {
                    paramsEncoded = urlParamsFormat(params, Key.STRING_CHARSET_NAME);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        return null;
                    }
                    try {
                        in.close();
                        return null;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (connection != null) {
                    connection.disconnect();
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        String fullUrl = urlStr + "?" + paramsEncoded;
        JSONObject jsonObject = new JSONObject(params);
        Log.i("MARSDK", "the params is：" + jsonObject.toString());
        Log.i("MARSDK", "the token is：" + token);
        Log.i("MARSDK", "the userid is：" + MARSDK.getInstance().getSeverUserID() + "\t\tthe fullUrl is：" + fullUrl);
        URL url = new URL(fullUrl);
        try {
            if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                connection = https;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }
            connection.setRequestProperty("Authorization", token);
            if (connection.getResponseCode() == 200) {
                InputStreamReader in2 = new InputStreamReader(connection.getInputStream());
                try {
                    BufferedReader bufferedReader = new BufferedReader(in2);
                    StringBuffer strBuffer = new StringBuffer();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        strBuffer.append(line);
                    }
                    result = strBuffer.toString();
                    in = in2;
                } catch (Exception e5) {
                    e = e5;
                    in = in2;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        return null;
                    }
                    in.close();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    in = in2;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
            } else {
                Log.e("MARSDK", "get connection failed. code:" + connection.getResponseCode() + ";url:" + fullUrl);
            }
            if (connection != null) {
                connection.disconnect();
            }
            if (in == null) {
                return result;
            }
            try {
                in.close();
                return result;
            } catch (IOException e6) {
                e6.printStackTrace();
                return result;
            }
        } catch (Exception e7) {
            e = e7;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x014e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    public static String httpPost(String urlStr, Map<String, String> params) {
        Exception e;
        String result;
        String token = MARSDK.getInstance().getServerToken();
        if (TextUtils.isEmpty(token)) {
            return null;
        }
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        try {
            String paramsEncoded = "";
            if (params != null) {
                try {
                    paramsEncoded = urlParamsFormat(params, Key.STRING_CHARSET_NAME);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        return null;
                    }
                    try {
                        in.close();
                        return null;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
            }
            URL url = new URL(urlStr);
            try {
                String fullUrl = urlStr + "?" + paramsEncoded;
                JSONObject jsonObject = new JSONObject(params);
                Log.i("MARSDK", "the params is：" + jsonObject.toString());
                Log.i("MARSDK", "the token is：" + token);
                Log.i("MARSDK", "the userid is：" + MARSDK.getInstance().getSeverUserID() + "\t\thttpPost the fullUrl is " + fullUrl);
                if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                    trustAllHosts();
                    HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                    https.setHostnameVerifier(DO_NOT_VERIFY);
                    connection = https;
                } else {
                    connection = (HttpURLConnection) url.openConnection();
                }
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod(TapHttp.METHOD_POST);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Charset", "utf-8");
                connection.setRequestProperty("Authorization", token);
                DataOutputStream dop = new DataOutputStream(connection.getOutputStream());
                dop.writeBytes(paramsEncoded);
                dop.flush();
                dop.close();
                if (connection.getResponseCode() == 200) {
                    InputStreamReader in2 = new InputStreamReader(connection.getInputStream());
                    try {
                        BufferedReader bufferedReader = new BufferedReader(in2);
                        StringBuffer strBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            strBuffer.append(line);
                        }
                        result = strBuffer.toString();
                        in = in2;
                    } catch (Exception e4) {
                        e = e4;
                        in = in2;
                        e.printStackTrace();
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (in != null) {
                            return null;
                        }
                        in.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        in = in2;
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode() + ";url:" + urlStr);
                    result = null;
                }
                if (connection != null) {
                    connection.disconnect();
                }
                if (in == null) {
                    return result;
                }
                try {
                    in.close();
                    return result;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    return result;
                }
            } catch (Exception e7) {
                e = e7;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String httpGetRemoveHead(String urlStr, Map<String, String> params) throws Throwable {
        URL url;
        String result = null;
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        try {
            try {
                if (params != null) {
                    String paramsEncoded = urlParamsFormat(params, Key.STRING_CHARSET_NAME);
                    String fullUrl = urlStr + "?" + paramsEncoded;
                    JSONObject jsonObject = new JSONObject(params);
                    Log.i("MARSDK", "the params is：" + jsonObject.toString());
                    Log.i("MARSDK", "the token is：" + MARSDK.getInstance().getServerToken());
                    Log.i("MARSDK", "the userid is：" + MARSDK.getInstance().getSeverUserID() + "\t\tthe fullUrl is：" + fullUrl);
                    URL url2 = new URL(fullUrl);
                    url = url2;
                } else {
                    URL url3 = new URL(urlStr);
                    url = url3;
                }
                if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                    trustAllHosts();
                    HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                    https.setHostnameVerifier(DO_NOT_VERIFY);
                    connection = https;
                } else {
                    connection = (HttpURLConnection) url.openConnection();
                }
                if (connection.getResponseCode() == 200) {
                    InputStreamReader in2 = new InputStreamReader(connection.getInputStream());
                    try {
                        BufferedReader bufferedReader = new BufferedReader(in2);
                        StringBuffer strBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            strBuffer.append(line);
                        }
                        result = strBuffer.toString();
                        in = in2;
                    } catch (Exception e) {
                        e = e;
                        in = in2;
                        e.printStackTrace();
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        in = in2;
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return result;
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x011c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String httpPostRemoveHead(String urlStr, Map<String, String> params) throws Throwable {
        Throwable th;
        Exception e;
        String result = null;
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        String paramsEncoded = "";
        if (params != null) {
            try {
                try {
                    paramsEncoded = urlParamsFormat(params, Key.STRING_CHARSET_NAME);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return result;
                }
            } catch (Throwable th2) {
                th = th2;
                if (connection != null) {
                    connection.disconnect();
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        URL url = new URL(urlStr);
        try {
            String fullUrl = urlStr + "?" + paramsEncoded;
            JSONObject jsonObject = new JSONObject(params);
            Log.i("MARSDK", "the params is：" + jsonObject.toString());
            Log.i("MARSDK", "the userid is：" + MARSDK.getInstance().getSeverUserID() + "\t\thttpPost the fullUrl is " + fullUrl);
            if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                connection = https;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(TapHttp.METHOD_POST);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            DataOutputStream dop = new DataOutputStream(connection.getOutputStream());
            dop.writeBytes(paramsEncoded);
            dop.flush();
            dop.close();
            if (connection.getResponseCode() == 200) {
                InputStreamReader in2 = new InputStreamReader(connection.getInputStream());
                try {
                    BufferedReader bufferedReader = new BufferedReader(in2);
                    StringBuffer strBuffer = new StringBuffer();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        strBuffer.append(line);
                    }
                    result = strBuffer.toString();
                    in = in2;
                } catch (Exception e5) {
                    e = e5;
                    in = in2;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        in.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    in = in2;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
            } else {
                result = null;
                Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode() + ";url:" + urlStr);
            }
            if (connection != null) {
                connection.disconnect();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (Exception e7) {
            e = e7;
        } catch (Throwable th4) {
            th = th4;
        }
        return result;
    }

    public static Long getBaiduNetworkTime() {
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            return Long.valueOf(httpURLConnection.getDate());
        } catch (Exception exception) {
            exception.printStackTrace();
            return 0L;
        }
    }

    public static Long getZKYTime() {
        try {
            URL url = new URL("http://www.ntsc.ac.cn");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            return Long.valueOf(httpURLConnection.getDate());
        } catch (Exception exception) {
            exception.printStackTrace();
            return 0L;
        }
    }

    public static Long getTaobaoTime() throws Throwable {
        long jValueOf;
        InputStreamReader inputStreamReader = null;
        HttpURLConnection connection = null;
        try {
            try {
                URL url = new URL("http://api.m.taobao.com/rest/api3.do?api=mtop.common.getTimestamp");
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod(TapHttp.METHOD_POST);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Charset", "utf-8");
                if (connection.getResponseCode() == 200) {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(connection.getInputStream());
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader2);
                        StringBuffer strBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            strBuffer.append(line);
                        }
                        String result = strBuffer.toString();
                        JSONObject jsonObject = new JSONObject(result);
                        jValueOf = Long.valueOf(jsonObject.getJSONObject("data").getLong(an.aI));
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        inputStreamReader = inputStreamReader2;
                    } catch (Exception e2) {
                        e = e2;
                        inputStreamReader = inputStreamReader2;
                        e.printStackTrace();
                        jValueOf = 0L;
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = inputStreamReader2;
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode());
                    jValueOf = 0L;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (0 != 0) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
            return jValueOf;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String urlParamsFormat(Map<String, String> params, String charset) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            String val = params.get(key);
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(val)) {
                String encodedName = URLEncoder.encode(key, charset);
                String encodedValue = URLEncoder.encode(val, charset);
                if (sb.length() > 0) {
                    sb.append(PARAMETER_SEPARATOR);
                }
                sb.append(encodedName).append(NAME_VALUE_SEPARATOR).append(encodedValue);
            }
        }
        return sb.toString();
    }

    public static void trustAllHosts() {
        TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: com.mar.sdk.utils.MARHttpUtils.1
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }
        }};
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
