package com.mar.sdk.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.mar.sdk.log.Log;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpConnect {
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "MARSDK-HttpConnect";

    public static boolean check(String address) throws Throwable {
        HttpURLConnection connection = null;
        try {
            try {
                URL url = new URL(address);
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(2500);
                    int state = connection.getResponseCode();
                    if (state == 200) {
                        if (connection != null) {
                            connection.disconnect();
                        }
                        return true;
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                    return false;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Long getBaiduTime() {
        try {
            URL url = new URL("https://www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            return Long.valueOf(httpURLConnection.getDate());
        } catch (Exception exception) {
            Log.e("MARSDK", "getBaiduTime" + exception.toString());
            return 0L;
        }
    }

    public static Long getCCTVTime() {
        try {
            URL url = new URL("https://www.cctv.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            return Long.valueOf(httpURLConnection.getDate());
        } catch (Exception exception) {
            Log.e("MARSDK", "getCCTVTime" + exception.toString());
            return 0L;
        }
    }

    public static Bitmap getBitmap(String url) throws Throwable {
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            try {
                URL imgUrl = new URL(url);
                try {
                    connection = (HttpURLConnection) imgUrl.openConnection();
                    connection.setConnectTimeout(3000);
                    connection.connect();
                    int state = connection.getResponseCode();
                    if (state == 200) {
                        inputStream = connection.getInputStream();
                        bitmap2 = BitmapFactory.decodeStream(inputStream);
                        inputStream.close();
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        bitmap = bitmap2;
                    } else {
                        if (connection != null) {
                            connection.disconnect();
                        }
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        bitmap = bitmap2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (connection != null) {
                        connection.disconnect();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        return bitmap;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String postRequest(String urlStr, Map<String, String> params) throws Throwable {
        Exception e;
        String result = null;
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
                        try {
                            in.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return result;
                }
            }
            URL url = new URL(urlStr);
            try {
                Log.i(TAG, urlStr + "?" + paramsEncoded);
                connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod(TapHttp.METHOD_POST);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Charset", "utf-8");
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
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
                            in.close();
                        }
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
                    Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode() + "; url:" + urlStr);
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
            } catch (Throwable th2) {
                th = th2;
            }
            return result;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:44:0x0110  */
    /* JADX WARN: Code duplicated, block: B:57:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    public static String postRequest(String urlStr, String header, Map<String, String> params) throws Throwable {
        Throwable th;
        Exception e;
        if (TextUtils.isEmpty(header)) {
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
        URL url = new URL(urlStr);
        try {
            Log.i(TAG, header);
            Log.i(TAG, urlStr + "?" + paramsEncoded);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(TapHttp.METHOD_POST);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Authorization", header);
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
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
                Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode() + "; url:" + urlStr);
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

    public static String postRequest(String urlStr, String header, String json) throws Throwable {
        if (TextUtils.isEmpty(header)) {
            return null;
        }
        String result = null;
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        try {
            try {
                URL url = new URL(urlStr);
                try {
                    Log.i(TAG, header);
                    Log.i(TAG, urlStr);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestMethod(TapHttp.METHOD_POST);
                    connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                    connection.setRequestProperty("Charset", "utf-8");
                    connection.setRequestProperty("Authorization", header);
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.connect();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), Key.STRING_CHARSET_NAME));
                    writer.write(json);
                    writer.close();
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
                            Log.e("MARSDK", "post connection failed. code: Exception" + e.toString());
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
                    } else {
                        Log.e("MARSDK", "post connection failed. code:" + connection.getResponseCode() + "; url:" + urlStr);
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
                } catch (Exception e5) {
                    e = e5;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            e = e6;
        }
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:55:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String getRequest(String urlStr, Map<String, String> params) throws Throwable {
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
        String fullUrl = urlStr + "?" + paramsEncoded;
        Log.i(TAG, fullUrl);
        URL url = new URL(fullUrl);
        try {
            connection = (HttpURLConnection) url.openConnection();
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
                Log.e("MARSDK", "get connection failed. code:" + connection.getResponseCode() + ";url:" + fullUrl);
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

    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    public static String getRequest(String urlStr, String header, Map<String, String> params) throws Throwable {
        Exception e;
        if (TextUtils.isEmpty(header)) {
            return null;
        }
        String result = null;
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
            String fullUrl = urlStr + "?" + paramsEncoded;
            Log.i(TAG, header);
            Log.i(TAG, fullUrl);
            URL url = new URL(fullUrl);
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Authorization", header);
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void download(DownloadInfo downloadInfo, DownloadListener downloadListener) {
        int end;
        int size;
        if (downloadListener == null) {
            android.util.Log.e(TAG, "download: exception! listener is null!");
            return;
        }
        if (downloadInfo == null) {
            android.util.Log.e(TAG, "download: exception!download info is null!");
            return;
        }
        android.util.Log.d(TAG, "download: range:" + downloadInfo.getRange());
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            try {
                URL url1 = new URL(downloadInfo.getUrl());
                connection = (HttpURLConnection) url1.openConnection();
                connection.setConnectTimeout(com.taptap.sdk.update.download.DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
                connection.setRequestMethod(TapHttp.METHOD_GET);
                connection.setRequestProperty("Charset", Key.STRING_CHARSET_NAME);
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty(Util.RANGE, downloadInfo.getRange());
                connection.connect();
                int contentLen = connection.getContentLength();
                if (contentLen <= 0) {
                    android.util.Log.d(TAG, "download fail , file not exists");
                    downloadListener.onFail();
                    if (end == size) {
                        return;
                    } else {
                        return;
                    }
                }
                if (connection.getResponseCode() == 206) {
                    inputStream = connection.getInputStream();
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = inputStream.read(buffer);
                        if (len == -1) {
                            break;
                        } else {
                            downloadInfo.getRandomAccessFile().write(buffer, 0, len);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                downloadListener.onFail();
            }
        } finally {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
            if (downloadInfo.getEnd() == downloadInfo.getSize()) {
                downloadListener.onComplete(downloadInfo.getFile());
            }
        }
    }

    public static void getNetFileSize(String url, DownloadListener listener) {
        if (listener == null) {
            android.util.Log.d(TAG, "listener can not null");
            return;
        }
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setConnectTimeout(1000);
            connection.setRequestMethod(TapHttp.METHOD_GET);
            connection.setRequestProperty("Charset", Key.STRING_CHARSET_NAME);
            connection.setRequestProperty("accept", "*/*");
            connection.connect();
            int length = connection.getContentLength();
            if (length > 0) {
                listener.onSuc(length);
            } else {
                listener.onFail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            listener.onFail();
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
}
