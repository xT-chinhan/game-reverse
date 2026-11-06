package com.byazt.so;

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
import com.anythink.core.common.l.b;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 427, 13})
public class w {
    public final Context n;
    public final com.byazt.so.n qg;
    public boolean s = false;
    public int q = 0;
    public int l = -3;

    @com.byazt.cp.n(n = {0, 1, 427, 108})
    public static final class n {
        public static String n(int i) {
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

    public w(Context context, com.byazt.so.n nVar) {
        this.n = context;
        this.qg = nVar;
    }

    public void n(String str, s sVar) {
        if (sVar == null) {
            return;
        }
        boolean zN = l.n(this.n);
        this.q = l.n(this.n, zN);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("headers");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapN = n(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String strOptString = jSONObject.optString(ImagesContract.URL);
            this.qg.n("method", upperCase);
            this.qg.n(ImagesContract.URL, strOptString);
            this.l = jSONObject.optInt("operType");
            try {
                if (n(zN, this.qg, sVar)) {
                    if (this.s) {
                        n(mapN, jSONObjectOptJSONObject2, sVar);
                    } else {
                        n(null, mapN, jSONObjectOptJSONObject2, sVar);
                    }
                }
            } catch (Throwable unused) {
                sVar.n(false, this.q, 102204, n.n(102204), null, null);
            }
        } catch (JSONException unused2) {
            sVar.n(false, this.q, 102203, n.n(102203), null, null);
        }
    }

    private Map<String, List<String>> n(JSONObject jSONObject) {
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
        } catch (Exception unused) {
        }
        return map;
    }

    private boolean n(boolean z, com.byazt.so.n nVar, s sVar) {
        nVar.n("networktype", this.q);
        String packageName = this.n.getPackageName();
        String strN = com.byazt.so.qg.n(q.n(this.n, packageName));
        nVar.n("apppackage", packageName);
        nVar.n("appsign", strN);
        int i = this.q;
        if (i == 3) {
            this.s = true;
        }
        if (!z) {
            sVar.n(false, i, 200010, n.n(200010), null, null);
            return false;
        }
        if (i == 0) {
            sVar.n(false, i, 102101, n.n(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        sVar.n(false, i, 102103, n.n(102103), null, null);
        return false;
    }

    private void n(final Map<String, List<String>> map, final JSONObject jSONObject, final s sVar) {
        final qg qgVarN = qg.n(this.n);
        qg.n(this.n).n(new ConnectivityManager.NetworkCallback() { // from class: com.byazt.so.w.1
            public final AtomicBoolean w = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                if (this.w.getAndSet(true) || network == null) {
                    return;
                }
                w.this.n(network, map, jSONObject, sVar);
                qgVarN.n(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                sVar.n(false, w.this.q, 102508, n.n(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Network network, Map<String, List<String>> map, JSONObject jSONObject, s sVar) throws Throwable {
        String strN = this.qg.n(ImagesContract.URL);
        String strN2 = this.qg.n("method");
        x xVar = new x(strN, strN2, map, jSONObject);
        xVar.n(this.qg.n("apppackage"));
        xVar.qg(this.qg.n("appsign"));
        if ("get".equalsIgnoreCase(strN2)) {
            xVar.n(b.g, "application/x-www-form-urlencoded");
        }
        try {
            com.byazt.fcl.n.n(xVar, this.qg.qg("networktype"), this.qg.n("apppackage"), this.l);
            n(network, xVar, sVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:116:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:130:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:134:0x0204  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.byazt.so.w] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.byazt.so.s] */
    private void n(Network network, x xVar, s sVar) throws Throwable {
        StringBuilder sb;
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int i;
        OutputStream outputStream4;
        int responseCode;
        OutputStream outputStream5;
        ?? r11;
        ?? r12;
        int i2;
        HttpsURLConnection httpsURLConnection2;
        InputStream inputStream;
        InputStream inputStream2;
        SystemClock.elapsedRealtime();
        String string = null;
        boolean z = false;
        try {
            URL url = new URL(xVar.qg());
            if (network != null) {
                httpsURLConnection2 = (HttpsURLConnection) network.openConnection(url);
            } else {
                httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            }
            httpsURLConnection = httpsURLConnection2;
            try {
                Map<String, List<String>> mapN = xVar.n();
                if (mapN != null) {
                    for (String str : mapN.keySet()) {
                        List<String> list = mapN.get(str);
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
                httpsURLConnection.setRequestMethod(xVar.q());
                if (xVar.q().equalsIgnoreCase("post")) {
                    xVar.s();
                    httpsURLConnection.setDoOutput(true);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(xVar.s().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (IOException e) {
                        e = e;
                        sb = null;
                        outputStream3 = null;
                        responseCode = -1;
                        outputStream5 = outputStream3;
                        r12 = outputStream3;
                        try {
                            k.qg("transmit_business", "doRealTransmitRequest e: " + e.toString());
                            if (e instanceof EOFException) {
                                i2 = 200050;
                            } else {
                                i2 = 102102;
                            }
                            int i3 = i2;
                            n(outputStream);
                            n(outputStream5);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            sVar.n(false, this.q, i3, TextUtils.isEmpty(null) ? n.n(i3) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            i = responseCode;
                            outputStream4 = outputStream5;
                            r11 = r12;
                            n(outputStream);
                            n(outputStream4);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            sVar.n(false, this.q, i, TextUtils.isEmpty(null) ? n.n(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sb = null;
                        outputStream2 = null;
                        i = -1;
                        outputStream4 = outputStream2;
                        r11 = outputStream2;
                        n(outputStream);
                        n(outputStream4);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        sVar.n(false, this.q, i, TextUtils.isEmpty(null) ? n.n(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                responseCode = httpsURLConnection.getResponseCode();
                try {
                    Map headerFields = httpsURLConnection.getHeaderFields();
                    try {
                        InputStream inputStream3 = httpsURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                try {
                                    int i4 = inputStream3.read(bArr);
                                    if (i4 <= 0) {
                                        break;
                                    } else {
                                        sb2.append(new String(bArr, 0, i4, "utf-8"));
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    sb = sb2;
                                    inputStream2 = inputStream3;
                                    r12 = headerFields;
                                    outputStream5 = inputStream2;
                                    k.qg("transmit_business", "doRealTransmitRequest e: " + e.toString());
                                    if (e instanceof EOFException) {
                                        i2 = 200050;
                                    } else {
                                        i2 = 102102;
                                    }
                                    int i5 = i2;
                                    n(outputStream);
                                    n(outputStream5);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    sVar.n(false, this.q, i5, TextUtils.isEmpty(null) ? n.n(i5) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                } catch (Throwable th3) {
                                    th = th3;
                                    sb = sb2;
                                    inputStream = inputStream3;
                                    i = responseCode;
                                    r11 = headerFields;
                                    outputStream4 = inputStream;
                                    n(outputStream);
                                    n(outputStream4);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    sVar.n(false, this.q, i, TextUtils.isEmpty(null) ? n.n(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                    throw th;
                                }
                            }
                            String string2 = sb2.toString();
                            if (!TextUtils.isEmpty(string2)) {
                                if (string2.contains("getNewUnicomPhone") || string2.contains("getTelecomPhone")) {
                                    if ((string2.contains("\"result\":0") || string2.contains("\"result\":\"0\"")) && string2.contains("\"data\":")) {
                                        z = true;
                                        string = "取号成功";
                                    } else {
                                        string = string2.contains("getNewUnicomPhone") ? "联通取号失败" : "电信取号失败";
                                    }
                                } else {
                                    try {
                                        JSONObject jSONObject = new JSONObject(sb2.toString());
                                        String string3 = jSONObject.getString("resultCode");
                                        if (string3 == null || !string3.equals("103000")) {
                                            string = jSONObject.getString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
                                        } else {
                                            z = true;
                                            string = "取号成功";
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            n(outputStream);
                            n(inputStream3);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            sVar.n(z, this.q, responseCode, TextUtils.isEmpty(string) ? n.n(responseCode) : string, headerFields, TextUtils.isEmpty(sb2) ? "" : sb2.toString());
                        } catch (IOException e3) {
                            e = e3;
                            sb = null;
                            inputStream2 = inputStream3;
                        } catch (Throwable th4) {
                            th = th4;
                            sb = null;
                            inputStream = inputStream3;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        sb = null;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        sb = null;
                        inputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    sb = null;
                    outputStream5 = null;
                    r12 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    sb = null;
                    outputStream5 = null;
                    r12 = 0;
                    i = responseCode;
                    outputStream4 = outputStream5;
                    r11 = r12;
                    n(outputStream);
                    n(outputStream4);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    sVar.n(false, this.q, i, TextUtils.isEmpty(null) ? n.n(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                sb = null;
                outputStream = null;
                outputStream3 = outputStream;
                responseCode = -1;
                outputStream5 = outputStream3;
                r12 = outputStream3;
                k.qg("transmit_business", "doRealTransmitRequest e: " + e.toString());
                if (e instanceof EOFException) {
                    i2 = 200050;
                } else {
                    i2 = 102102;
                }
                int i6 = i2;
                n(outputStream);
                n(outputStream5);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                sVar.n(false, this.q, i6, TextUtils.isEmpty(null) ? n.n(i6) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
            } catch (Throwable th7) {
                th = th7;
                sb = null;
                outputStream = null;
                outputStream2 = outputStream;
                i = -1;
                outputStream4 = outputStream2;
                r11 = outputStream2;
                n(outputStream);
                n(outputStream4);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                sVar.n(false, this.q, i, TextUtils.isEmpty(null) ? n.n(i) : null, r11, TextUtils.isEmpty(sb) ? "" : sb.toString());
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            sb = null;
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable th8) {
            th = th8;
            sb = null;
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    private void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 427, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    private static class qg {
        public static volatile qg l;
        public ConnectivityManager n;
        public boolean q;
        public Network qg;
        public ConnectivityManager.NetworkCallback s;
        public Handler w;
        public final Runnable x = new Runnable() { // from class: com.byazt.so.w.qg.2
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n();
            }
        };

        private qg(Context context) {
            try {
                this.n = (ConnectivityManager) context.getSystemService("connectivity");
                this.w = new Handler(Looper.getMainLooper());
            } catch (Exception unused) {
            }
        }

        public static qg n(Context context) {
            if (l == null) {
                synchronized (qg.class) {
                    if (l == null) {
                        l = new qg(context);
                    }
                }
            }
            return l;
        }

        public void n(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.w.removeCallbacks(this.x);
            ConnectivityManager connectivityManager = this.n;
            if (connectivityManager == null) {
                return;
            }
            Network network = this.qg;
            if (network != null && !this.q && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                networkCallback.onAvailable(this.qg);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.s;
            if (networkCallback2 != null) {
                try {
                    this.n.unregisterNetworkCallback(networkCallback2);
                } catch (Exception unused) {
                    this.s = null;
                }
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            this.s = new ConnectivityManager.NetworkCallback() { // from class: com.byazt.so.w.qg.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (qg.this.n.getNetworkCapabilities(network2).hasTransport(0)) {
                            qg.this.qg = network2;
                            networkCallback.onAvailable(network2);
                            qg.this.q = false;
                        } else {
                            qg.this.qg = null;
                            networkCallback.onAvailable(null);
                            qg.this.q = true;
                        }
                    } catch (Exception unused2) {
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    qg.this.q = true;
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
                this.n.requestNetwork(networkRequestBuild, this.s, 5000);
            } else {
                this.n.requestNetwork(networkRequestBuild, this.s);
            }
        }

        public void n(long j) {
            this.w.postDelayed(this.x, j);
        }

        public void n() {
            if (this.n == null) {
                return;
            }
            try {
                ConnectivityManager.NetworkCallback networkCallback = this.s;
                if (networkCallback == null) {
                    return;
                }
                this.n.unregisterNetworkCallback(networkCallback);
                this.s = null;
                this.qg = null;
            } catch (Exception unused) {
            }
        }
    }
}
