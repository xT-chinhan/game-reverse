package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.anythink.core.common.l.b;
import com.anythink.core.common.l.f;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ConfigRequest {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CONNECTION_TIME_OUT = 10000;
    private static final int MAX_REDIRECTS = 21;
    private static final int READ_WRITE_TIME_OUT = 30000;
    private int currentNum;
    private String mCurrentUrl;
    private final UpdaterProvider mProvider;
    private final String mUrl;

    public interface RequestCallBack {
        void onError(Exception exc);

        void onSuccess(Api.UpdateData updateData);
    }

    private boolean disableEncrypt() {
        return false;
    }

    ConfigRequest(UpdaterProvider updaterProvider) {
        this.mProvider = updaterProvider;
        String updateUrl = updaterProvider.getUpdateUrl();
        this.mUrl = updateUrl;
        this.mCurrentUrl = updateUrl;
    }

    public void request(RequestCallBack requestCallBack) {
        HttpURLConnection httpURLConnectionCreateUrlConnection = null;
        try {
            try {
                Map<String, String> mapBuildHeader = buildHeader();
                String strBuildBody = buildBody(mapBuildHeader);
                httpURLConnectionCreateUrlConnection = createUrlConnection(this.mCurrentUrl);
                setConnectionHeader(httpURLConnectionCreateUrlConnection, mapBuildHeader);
                httpURLConnectionCreateUrlConnection.connect();
                new DataOutputStream(httpURLConnectionCreateUrlConnection.getOutputStream()).write(strBuildBody.getBytes());
                int responseCode = httpURLConnectionCreateUrlConnection.getResponseCode();
                if (responseCode == 200) {
                    String strInputStream2String = inputStream2String(httpURLConnectionCreateUrlConnection.getInputStream());
                    Api.UpdateData updateData = new Api.UpdateData();
                    JSONObject jSONObject = new JSONObject(strInputStream2String);
                    String strOptString = jSONObject.optString(f.R);
                    if (!TextUtils.isEmpty(strOptString) && !AbstractJsonLexerKt.NULL.equals(strOptString)) {
                        jSONObject.put(f.R, new JSONObject(this.mProvider.getKSSDK().getRD(strOptString)));
                    }
                    updateData.parseJson(jSONObject);
                    requestCallBack.onSuccess(updateData);
                } else if (responseCode / 100 == 3) {
                    if (this.currentNum < 21) {
                        this.mCurrentUrl = httpURLConnectionCreateUrlConnection.getHeaderField("Location");
                        this.currentNum++;
                        request(requestCallBack);
                    }
                } else {
                    throw new RuntimeException("response code = " + responseCode);
                }
                if (httpURLConnectionCreateUrlConnection == null) {
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        httpURLConnectionCreateUrlConnection.disconnect();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            requestCallBack.onError(e);
            if (0 == 0) {
                return;
            }
        }
        try {
            httpURLConnectionCreateUrlConnection.disconnect();
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x004c */
    private static String inputStream2String(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
                String string = byteArrayOutputStream.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return string;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
                throw th;
            }
            throw th;
        }
    }

    private void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private String buildBody(Map<String, String> map) {
        String currentDynamicVersion = DVersionUtils.getCurrentDynamicVersion(this.mProvider.getContext());
        if (TextUtils.isEmpty(currentDynamicVersion)) {
            currentDynamicVersion = this.mProvider.getKSSDK().getSDKVersion();
        }
        int sDKVersionCode = this.mProvider.getKSSDK().getSDKVersionCode();
        JSONObject appInfo = this.mProvider.getKSSDK().getAppInfo();
        JSONObject deviceInfo = this.mProvider.getKSSDK().getDeviceInfo();
        JSONObject networkInfo = this.mProvider.getKSSDK().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        JsonUtil.putValue(jSONObject, "sdkApiVersion", "5.9.10.1");
        JsonUtil.putValue(jSONObject, "sdkApiVersionCode", 5091001);
        JsonUtil.putValue(jSONObject, "sdkVersion", currentDynamicVersion);
        JsonUtil.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        JsonUtil.putValue(jSONObject, "sdkType", 1);
        JsonUtil.putValue(jSONObject, "appInfo", appInfo);
        JsonUtil.putValue(jSONObject, "deviceInfo", deviceInfo);
        JsonUtil.putValue(jSONObject, "networkInfo", networkInfo);
        JsonUtil.putValue(jSONObject, "sdkAbi", VMRuntimeCompat.getSDKAbi());
        String string = jSONObject.toString();
        if (disableEncrypt()) {
            map.put("x-ksad-ignore-decrypt", String.valueOf(true));
            return jSONObject.toString();
        }
        this.mProvider.getKSSDK().addHp(map);
        JSONObject jSONObject2 = new JSONObject();
        JsonUtil.putValue(jSONObject2, "version", "5.9.10.1");
        JsonUtil.putValue(jSONObject2, "appId", appInfo.optString("appId"));
        JsonUtil.putValue(jSONObject2, "message", this.mProvider.getKSSDK().getRM(string));
        this.mProvider.getKSSDK().sR(this.mUrl, map, jSONObject2.toString());
        return jSONObject2.toString();
    }

    private Map<String, String> buildHeader() {
        HashMap map = new HashMap();
        map.put("Accept-Language", "zh-CN");
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put(b.g, "application/json; charset=UTF-8");
        map.put(RequestParamsUtils.USER_AGENT_KEY, RequestParamsUtils.getUserAgent());
        return map;
    }

    private HttpURLConnection createUrlConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(READ_WRITE_TIME_OUT);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod(TapHttp.METHOD_POST);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }
}
