package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.efs.sdk.base.Constants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class am {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static JSONObject f476ms;
    private static final String[] d = {"GET", "POST"};
    private static final String[] ka = {"aid", "app_version", "tt_data"};
    static final String[] xr = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] ah = {"tt_data", "device_platform"};

    public static boolean ms(int i) {
        return i >= 500 && i < 600;
    }

    private static String ms(String str) {
        if (TextUtils.isEmpty(str) || !ms.ab()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : ka) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(vl.ms(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String ms(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String ms(int i, String str, HashMap<String, String> map, byte[] bArr) {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        String str2;
        String string;
        BufferedReader bufferedReader2;
        if (oh.xr) {
            oh.ms("http: ".concat(String.valueOf(str)), null);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        oh.ms("http headers key:" + entry.getKey() + " value:" + entry.getValue(), null);
                    }
                }
            }
            if (bArr != null) {
                oh.ms("http data length:" + bArr.length, null);
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                oh.xr((Throwable) null);
            }
            httpURLConnection.setRequestMethod(d[i]);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    } else {
                        oh.xr((Throwable) null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", Constants.CP_GZIP);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream = null;
            } else {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Throwable th) {
                    bufferedReader = null;
                    str2 = null;
                    dataOutputStream = dataOutputStream;
                    th = th;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                if (httpURLConnection.getContentLength() < 10240) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                    } else {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                    }
                    try {
                        StringBuilder sb = new StringBuilder(inputStream.available());
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line).append("\n");
                            bufferedReader = bufferedReader2;
                            try {
                                oh.xr(th);
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                string = str2;
                            } catch (Throwable th2) {
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        throw th2;
                                    } catch (IOException unused4) {
                                        throw th2;
                                    }
                                }
                                throw th2;
                            }
                        }
                        String string2 = sb.toString();
                        try {
                            JSONObject jSONObject = new JSONObject(string2);
                            jSONObject.put("http_code", 200);
                            string = jSONObject.toString();
                        } catch (Throwable th3) {
                            th = th3;
                            str2 = string2;
                            bufferedReader = bufferedReader2;
                            oh.xr(th);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            string = str2;
                        }
                    } catch (Throwable th4) {
                        str2 = null;
                        th = th4;
                    }
                } else {
                    oh.xr((Throwable) null);
                    bufferedReader2 = null;
                    string = null;
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused6) {
                    }
                }
            } else {
                String string3 = new JSONObject().put("http_code", responseCode).toString();
                try {
                    com.bytedance.sdk.component.utils.sl.ms(new RuntimeException("HttpCode:".concat(String.valueOf(responseCode))));
                    string = string3;
                    bufferedReader2 = null;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Throwable th5) {
                    str2 = string3;
                    dataOutputStream = dataOutputStream;
                    th = th5;
                    bufferedReader = null;
                    oh.xr(th);
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    string = str2;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
            bufferedReader = null;
            str2 = null;
        }
        if (oh.xr) {
            oh.ms("http response: ".concat(String.valueOf(string)), null);
        }
        return string;
    }

    public static JSONObject ms(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (ms.ab()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strMs = ms(1, ms(str), map, vl.ms(jSONObject.toString()));
        if (strMs != null) {
            try {
                return new JSONObject(strMs);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        return null;
    }

    public static int ms(String[] strArr, byte[] bArr, pc pcVar) {
        JSONObject jSONObject;
        int iOptInt;
        HashMap map = new HashMap(2);
        if (ms.ab()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strMs = null;
        for (String str : strArr) {
            strMs = ms(1, str, map, bArr);
            if (!TextUtils.isEmpty(strMs)) {
                break;
            }
        }
        try {
            if (TextUtils.isEmpty(strMs)) {
                jSONObject = null;
                iOptInt = 0;
            } else {
                jSONObject = new JSONObject(strMs);
                try {
                    iOptInt = jSONObject.optInt("http_code");
                    if (iOptInt == 200) {
                        if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            iOptInt = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                        } else {
                            iOptInt = Integer.valueOf("102").intValue();
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    oh.xr(e);
                    iOptInt = 0;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (iOptInt == 200) {
            try {
                long jOptLong = jSONObject.optLong("server_time");
                if (jOptLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", jOptLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    f476ms = jSONObject2;
                }
            } catch (Exception e3) {
                oh.xr(e3);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("blacklist");
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("v1");
                int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
                HashSet hashSet = new HashSet(length);
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i, null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        hashSet.add(strOptString);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("v3");
                int length2 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                HashSet hashSet2 = new HashSet(length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2, null);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        hashSet2.add(strOptString2);
                    }
                }
            }
        }
        return iOptInt;
    }

    public static JSONObject xr(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (ms.ab()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strMs = ms(1, str, map, vl.ms(jSONObject.toString()));
        if (strMs != null) {
            try {
                jSONObject2 = new JSONObject(strMs);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject("config");
        }
        return null;
    }

    public static JSONObject ah(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strMs = ms(1, str, null, vl.ms(jSONObject.toString()));
        if (strMs != null) {
            try {
                jSONObject2 = new JSONObject(strMs);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }
}
