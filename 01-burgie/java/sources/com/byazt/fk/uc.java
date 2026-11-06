package com.byazt.fk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 5})
public class uc {
    public final com.byazt.fk.pr hw;
    public final Context pr;
    public boolean hn = false;
    public int x = 0;
    public int c = -3;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 129})
    public static final class pr {
        public static String pr(int i) {
            switch (i) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    public uc(Context context, com.byazt.fk.pr prVar) {
        this.pr = context;
        this.hw = prVar;
    }

    public void pr(String str, hn hnVar) {
        if (hnVar == null) {
            return;
        }
        boolean zPr = c.pr(this.pr);
        this.x = c.pr(this.pr, zPr);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("headers");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapPr = pr(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String strOptString = jSONObject.optString(BreakpointSQLiteKey.URL);
            this.hw.pr("method", upperCase);
            this.hw.pr(BreakpointSQLiteKey.URL, strOptString);
            this.c = jSONObject.optInt("operType");
            try {
                if (pr(zPr, this.hw, hnVar)) {
                    if (this.hn) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            pr(mapPr, jSONObjectOptJSONObject2, hnVar);
                            return;
                        } else {
                            ho.hw("transmit_business", "unSupport 5.0 low check sim netWork");
                            hnVar.pr(false, this.x, 102508, pr.pr(102508), null, null);
                            return;
                        }
                    }
                    pr(null, mapPr, jSONObjectOptJSONObject2, hnVar);
                }
            } catch (Throwable th) {
                hnVar.pr(false, this.x, 102204, pr.pr(102204), null, null);
            }
        } catch (JSONException e) {
            hnVar.pr(false, this.x, 102203, pr.pr(102203), null, null);
        }
    }

    private Map<String, List<String>> pr(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                List list = (List) map.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(strOptString);
                    map.put(next, arrayList);
                } else {
                    list.add(strOptString);
                }
            }
        } catch (Exception e) {
        }
        return map;
    }

    private boolean pr(boolean z, com.byazt.fk.pr prVar, hn hnVar) {
        prVar.pr("networktype", this.x);
        String packageName = this.pr.getPackageName();
        String strPr = com.byazt.fk.hw.pr(x.pr(this.pr, packageName));
        prVar.pr("apppackage", packageName);
        prVar.pr("appsign", strPr);
        int i = this.x;
        if (i == 3) {
            this.hn = true;
        }
        if (!z) {
            hnVar.pr(false, i, 200010, pr.pr(200010), null, null);
            return false;
        }
        if (i == 0) {
            hnVar.pr(false, i, 102101, pr.pr(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        hnVar.pr(false, i, 102103, pr.pr(102103), null, null);
        return false;
    }

    private void pr(final Map<String, List<String>> map, final JSONObject jSONObject, final hn hnVar) {
        final hw hwVarPr = hw.pr(this.pr);
        hw.pr(this.pr).pr(new ConnectivityManager.NetworkCallback() { // from class: com.byazt.fk.uc.1
            public final AtomicBoolean uc = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                if (!this.uc.getAndSet(true) && network != null) {
                    uc.this.pr(network, map, jSONObject, hnVar);
                    hwVarPr.pr(1000L);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                hnVar.pr(false, uc.this.x, 102508, pr.pr(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Network network, Map<String, List<String>> map, JSONObject jSONObject, hn hnVar) throws Throwable {
        String strPr = this.hw.pr(BreakpointSQLiteKey.URL);
        String strPr2 = this.hw.pr("method");
        fw fwVar = new fw(strPr, strPr2, map, jSONObject);
        fwVar.pr(this.hw.pr("apppackage"));
        fwVar.hw(this.hw.pr("appsign"));
        if ("get".equalsIgnoreCase(strPr2)) {
            fwVar.pr("Content-Type", "application/x-www-form-urlencoded");
        }
        try {
            com.byazt.cp.pr.pr(fwVar, this.hw.hw("networktype"), this.hw.pr("apppackage"), this.c);
            pr(network, fwVar, hnVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:116:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:126:0x0202  */
    /* JADX WARN: Code duplicated, block: B:129:0x020d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0213  */
    /* JADX WARN: Code duplicated, block: B:134:0x021b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.byazt.fk.uc] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.byazt.fk.hn] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private void pr(Network network, fw fwVar, hn hnVar) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        ?? sb;
        ?? headerFields;
        int responseCode;
        ?? inputStream;
        String strPr;
        int i;
        String strPr2;
        boolean z;
        SystemClock.elapsedRealtime();
        String string = null;
        try {
            URL url = new URL(fwVar.hw());
            httpsURLConnection = network != null ? (HttpsURLConnection) network.openConnection(url) : (HttpsURLConnection) url.openConnection();
            try {
                Map<String, List<String>> mapPr = fwVar.pr();
                if (mapPr != null) {
                    for (String str : mapPr.keySet()) {
                        List<String> list = mapPr.get(str);
                        if (list != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                httpsURLConnection.addRequestProperty(str, it.next());
                            }
                        }
                    }
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setInstanceFollowRedirects(false);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setDefaultUseCaches(false);
                httpsURLConnection.setRequestMethod(fwVar.x());
                if (fwVar.x().equalsIgnoreCase("post")) {
                    fwVar.hn();
                    httpsURLConnection.setDoOutput(true);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(fwVar.hn().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (IOException e) {
                        e = e;
                        sb = 0;
                        headerFields = sb;
                        inputStream = headerFields;
                        ho.hw("transmit_business", "doRealTransmitRequest e: " + e.toString());
                        if (e instanceof EOFException) {
                            i = 200050;
                        } else {
                            i = 102102;
                        }
                        pr(outputStream);
                        pr(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        int i2 = this.x;
                        if (TextUtils.isEmpty(null)) {
                            strPr2 = pr.pr(i);
                        } else {
                            strPr2 = null;
                        }
                        hnVar.pr(false, i2, i, strPr2, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    } catch (Throwable th) {
                        th = th;
                        sb = 0;
                        headerFields = sb;
                        responseCode = -1;
                        inputStream = headerFields;
                        pr(outputStream);
                        pr(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        int i3 = this.x;
                        if (TextUtils.isEmpty(null)) {
                            strPr = pr.pr(responseCode);
                        } else {
                            strPr = null;
                        }
                        hnVar.pr(false, i3, responseCode, strPr, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                responseCode = httpsURLConnection.getResponseCode();
                try {
                    headerFields = httpsURLConnection.getHeaderFields();
                    try {
                        inputStream = httpsURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            sb = new StringBuilder();
                            while (true) {
                                try {
                                    try {
                                        int i4 = inputStream.read(bArr);
                                        if (i4 <= 0) {
                                            break;
                                        } else {
                                            sb.append(new String(bArr, 0, i4, "utf-8"));
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        ho.hw("transmit_business", "doRealTransmitRequest e: " + e.toString());
                                        if (e instanceof EOFException) {
                                            i = 200050;
                                        } else {
                                            i = 102102;
                                        }
                                        pr(outputStream);
                                        pr(inputStream);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        int i5 = this.x;
                                        if (TextUtils.isEmpty(null)) {
                                            strPr2 = pr.pr(i);
                                        } else {
                                            strPr2 = null;
                                        }
                                        hnVar.pr(false, i5, i, strPr2, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    pr(outputStream);
                                    pr(inputStream);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    int i6 = this.x;
                                    if (TextUtils.isEmpty(null)) {
                                        strPr = pr.pr(responseCode);
                                    } else {
                                        strPr = null;
                                    }
                                    hnVar.pr(false, i6, responseCode, strPr, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                    throw th;
                                }
                            }
                            String string2 = sb.toString();
                            if (TextUtils.isEmpty(string2)) {
                                z = false;
                            } else if (!string2.contains("getNewUnicomPhone") && !string2.contains("getTelecomPhone")) {
                                try {
                                    JSONObject jSONObject = new JSONObject(sb.toString());
                                    String string3 = jSONObject.getString("resultCode");
                                    if (string3 == null || !string3.equals("103000")) {
                                        string = jSONObject.getString("desc");
                                        z = false;
                                    } else {
                                        string = "取号成功";
                                        z = true;
                                    }
                                } catch (Exception e3) {
                                    z = false;
                                }
                            } else if ((string2.contains("\"result\":0") || string2.contains("\"result\":\"0\"")) && string2.contains("\"data\":")) {
                                string = "取号成功";
                                z = true;
                            } else {
                                string = string2.contains("getNewUnicomPhone") ? "联通取号失败" : "电信取号失败";
                                z = false;
                            }
                            pr(outputStream);
                            pr(inputStream);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            hnVar.pr(z, this.x, responseCode, TextUtils.isEmpty(string) ? pr.pr(responseCode) : string, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        } catch (IOException e4) {
                            e = e4;
                            sb = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            sb = 0;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        inputStream = 0;
                        sb = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = 0;
                        sb = 0;
                    }
                } catch (IOException e6) {
                    e = e6;
                    inputStream = 0;
                    sb = 0;
                    headerFields = 0;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = 0;
                    sb = 0;
                    headerFields = 0;
                }
            } catch (IOException e7) {
                e = e7;
                outputStream = null;
                sb = outputStream;
                headerFields = sb;
                inputStream = headerFields;
                ho.hw("transmit_business", "doRealTransmitRequest e: " + e.toString());
                if (e instanceof EOFException) {
                    i = 200050;
                } else {
                    i = 102102;
                }
                pr(outputStream);
                pr(inputStream);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                int i7 = this.x;
                if (TextUtils.isEmpty(null)) {
                    strPr2 = pr.pr(i);
                } else {
                    strPr2 = null;
                }
                hnVar.pr(false, i7, i, strPr2, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                sb = outputStream;
                headerFields = sb;
                responseCode = -1;
                inputStream = headerFields;
                pr(outputStream);
                pr(inputStream);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                int i8 = this.x;
                if (TextUtils.isEmpty(null)) {
                    strPr = pr.pr(responseCode);
                } else {
                    strPr = null;
                }
                hnVar.pr(false, i8, responseCode, strPr, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable th7) {
            th = th7;
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    private void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    private static class hw {
        public static volatile hw c;
        public final Runnable fw = new Runnable() { // from class: com.byazt.fk.uc.hw.2
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr();
            }
        };
        public ConnectivityManager.NetworkCallback hn;
        public Network hw;
        public ConnectivityManager pr;
        public Handler uc;
        public boolean x;

        private hw(Context context) {
            try {
                this.pr = (ConnectivityManager) context.getSystemService("connectivity");
                this.uc = new Handler(Looper.getMainLooper());
            } catch (Exception e) {
            }
        }

        public static hw pr(Context context) {
            if (c == null) {
                synchronized (hw.class) {
                    if (c == null) {
                        c = new hw(context);
                    }
                }
            }
            return c;
        }

        public void pr(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.uc.removeCallbacks(this.fw);
            ConnectivityManager connectivityManager = this.pr;
            if (connectivityManager == null) {
                return;
            }
            Network network = this.hw;
            if (network != null && !this.x && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                networkCallback.onAvailable(this.hw);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.hn;
            if (networkCallback2 != null) {
                try {
                    this.pr.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e) {
                    this.hn = null;
                }
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            this.hn = new ConnectivityManager.NetworkCallback() { // from class: com.byazt.fk.uc.hw.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (hw.this.pr.getNetworkCapabilities(network2).hasTransport(0)) {
                            hw.this.hw = network2;
                            networkCallback.onAvailable(network2);
                            hw.this.x = false;
                        } else {
                            hw.this.hw = null;
                            networkCallback.onAvailable(null);
                            hw.this.x = true;
                        }
                    } catch (Exception e2) {
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    hw.this.x = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    if (Build.VERSION.SDK_INT >= 26) {
                        networkCallback.onUnavailable();
                    }
                }
            };
            if (Build.VERSION.SDK_INT >= 26) {
                this.pr.requestNetwork(networkRequestBuild, this.hn, 5000);
            } else {
                this.pr.requestNetwork(networkRequestBuild, this.hn);
            }
        }

        public void pr(long j) {
            this.uc.postDelayed(this.fw, j);
        }

        public void pr() {
            ConnectivityManager.NetworkCallback networkCallback;
            if (this.pr == null) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 21 || (networkCallback = this.hn) == null) {
                    return;
                }
                this.pr.unregisterNetworkCallback(networkCallback);
                this.hn = null;
                this.hw = null;
            } catch (Exception e) {
            }
        }
    }
}
