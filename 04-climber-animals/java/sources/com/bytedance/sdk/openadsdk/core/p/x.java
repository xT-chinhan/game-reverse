package com.bytedance.sdk.openadsdk.core.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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
public class x {
    private boolean ah = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f3247ms;
    private final xr xr;

    public x(Context context, xr xrVar) {
        this.f3247ms = context;
        this.xr = xrVar;
    }

    public void ms(String str, d dVar) {
        if (dVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(TTDownloadField.TT_HEADERS);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapMs = ms(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String strOptString = jSONObject.optString("url");
            this.xr.ms("method", upperCase);
            this.xr.ms("url", strOptString);
            try {
                if (ms(this.xr, dVar)) {
                    if (this.ah) {
                        ms(mapMs, jSONObjectOptJSONObject2, dVar);
                    } else {
                        ms(null, mapMs, jSONObjectOptJSONObject2, dVar);
                    }
                }
            } catch (Throwable th) {
                sl.ms(th);
                dVar.ms(Integer.parseInt("102204"), null, null);
            }
        } catch (JSONException e) {
            sl.ms(e);
            dVar.ms(Integer.parseInt("102203"), null, null);
        }
    }

    private Map<String, List<String>> ms(JSONObject jSONObject) {
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
            sl.ms(e);
        }
        return map;
    }

    private boolean ms(xr xrVar, d dVar) {
        boolean zMs = c.ms(this.f3247ms);
        int iMs = c.ms(this.f3247ms, zMs, xrVar);
        xrVar.ms("networktype", iMs);
        sl.ms("transmit_business", "preCheck networkType:" + iMs);
        String packageName = this.f3247ms.getPackageName();
        String strMs = ah.ms(ka.ms(this.f3247ms, packageName));
        xrVar.ms("apppackage", packageName);
        xrVar.ms("appsign", strMs);
        if (iMs == 3) {
            this.ah = true;
        }
        if (!zMs) {
            dVar.ms(Integer.parseInt("200010"), null, null);
            return false;
        }
        if (iMs == 0) {
            dVar.ms(Integer.parseInt("102101"), null, null);
            return false;
        }
        if (iMs != 2) {
            return true;
        }
        dVar.ms(Integer.parseInt("102103"), null, null);
        return false;
    }

    private void ms(final Map<String, List<String>> map, final JSONObject jSONObject, final d dVar) {
        sl.ms("transmit_business", "wifiSwitchAndDoRequest");
        final ms msVarMs = ms.ms(this.f3247ms);
        ms.ms(this.f3247ms).ms(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.p.x.1
            private final AtomicBoolean c = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                sl.ms("transmit_business", "wifiSwitchAndDoRequest onAvailable:".concat(String.valueOf(network)));
                if (this.c.getAndSet(true) || network == null) {
                    return;
                }
                x.this.ms(network, map, jSONObject, dVar);
                msVarMs.ms(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                sl.ms("transmit_business", "wifiSwitchAndDoRequest onUnavailable");
                dVar.ms(102508, null, "数据网络切换失败");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Network network, Map<String, List<String>> map, JSONObject jSONObject, d dVar) throws Throwable {
        String strMs = this.xr.ms("url");
        String strMs2 = this.xr.ms("method");
        ny nyVar = new ny(strMs, strMs2, map, jSONObject);
        nyVar.ms(this.xr.ms("apppackage"));
        nyVar.xr(this.xr.ms("appsign"));
        if ("get".equalsIgnoreCase(strMs2)) {
            nyVar.ms("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        }
        try {
            com.bytedance.sdk.openadsdk.core.p.ms.ms.ms(nyVar, this.xr.xr("networktype"), this.xr.ms("apppackage"));
            ms(network, nyVar, dVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0172  */
    /* JADX WARN: Code duplicated, block: B:72:0x0176  */
    /* JADX WARN: Code duplicated, block: B:75:0x0181  */
    /* JADX WARN: Code duplicated, block: B:79:0x018b  */
    /* JADX WARN: Code duplicated, block: B:85:0x019c  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.sdk.openadsdk.core.p.x] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.bytedance.sdk.openadsdk.core.p.d] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private void ms(Network network, ny nyVar, d dVar) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream;
        StringBuilder sb;
        int i;
        ?? r3;
        int i2;
        HttpsURLConnection httpsURLConnection2;
        OutputStream outputStream;
        sl.ms("transmit_business", "doRealTransmitRequest: " + nyVar.xr());
        SystemClock.elapsedRealtime();
        OutputStream outputStream2 = null;
        int responseCode = -1;
        try {
            URL url = new URL(nyVar.xr());
            if (network != null) {
                httpsURLConnection2 = (HttpsURLConnection) network.openConnection(url);
            } else {
                httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            }
            try {
                Map<String, List<String>> mapMs = nyVar.ms();
                if (mapMs != null) {
                    for (String str : mapMs.keySet()) {
                        List<String> list = mapMs.get(str);
                        if (list != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                httpsURLConnection2.addRequestProperty(str, it.next());
                            }
                        }
                    }
                }
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setInstanceFollowRedirects(false);
                httpsURLConnection2.setConnectTimeout(5000);
                httpsURLConnection2.setReadTimeout(5000);
                httpsURLConnection2.setDefaultUseCaches(false);
                httpsURLConnection2.setRequestMethod(nyVar.d());
                if (nyVar.d().equalsIgnoreCase("post")) {
                    sl.ms("transmit_business", "doRealTransmitRequest params:" + nyVar.ah());
                    httpsURLConnection2.setDoOutput(true);
                    outputStream = httpsURLConnection2.getOutputStream();
                    try {
                        outputStream.write(nyVar.ah().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (IOException e) {
                        e = e;
                        inputStream = null;
                        sb = null;
                        outputStream2 = outputStream;
                        i = responseCode;
                        r3 = sb;
                        IOException iOException = e;
                        httpsURLConnection = httpsURLConnection2;
                        e = iOException;
                        try {
                            sl.d("transmit_business", "doRealTransmitRequest e: " + e.toString());
                            sl.ms(e);
                            if (e instanceof EOFException) {
                                i2 = 200050;
                            } else {
                                i2 = 102102;
                            }
                            ms(outputStream2);
                            ms(inputStream);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            dVar.ms(i2, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            ms(outputStream2);
                            ms(inputStream);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            dVar.ms(i, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        sb = null;
                        outputStream2 = outputStream;
                        i = responseCode;
                        r3 = sb;
                        Throwable th3 = th;
                        httpsURLConnection = httpsURLConnection2;
                        th = th3;
                        ms(outputStream2);
                        ms(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        dVar.ms(i, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                responseCode = httpsURLConnection2.getResponseCode();
                Map headerFields = httpsURLConnection2.getHeaderFields();
                try {
                    inputStream = httpsURLConnection2.getInputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        sb = new StringBuilder();
                        while (true) {
                            try {
                                int i3 = inputStream.read(bArr);
                                if (i3 <= 0) {
                                    break;
                                } else {
                                    sb.append(new String(bArr, 0, i3, "utf-8"));
                                }
                            } catch (IOException e2) {
                                httpsURLConnection = httpsURLConnection2;
                                e = e2;
                                outputStream2 = outputStream;
                                i = responseCode;
                                r3 = headerFields;
                                sl.d("transmit_business", "doRealTransmitRequest e: " + e.toString());
                                sl.ms(e);
                                if (e instanceof EOFException) {
                                    i2 = 200050;
                                } else {
                                    i2 = 102102;
                                }
                                ms(outputStream2);
                                ms(inputStream);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                dVar.ms(i2, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                            } catch (Throwable th4) {
                                httpsURLConnection = httpsURLConnection2;
                                th = th4;
                                outputStream2 = outputStream;
                                i = responseCode;
                                r3 = headerFields;
                                ms(outputStream2);
                                ms(inputStream);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                dVar.ms(i, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                throw th;
                            }
                        }
                        ms(outputStream);
                        ms(inputStream);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        dVar.ms(responseCode, headerFields, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    } catch (IOException e3) {
                        e = e3;
                        sb = null;
                        outputStream2 = outputStream;
                        i = responseCode;
                        r3 = headerFields;
                        httpsURLConnection = httpsURLConnection2;
                        e = e;
                        sl.d("transmit_business", "doRealTransmitRequest e: " + e.toString());
                        sl.ms(e);
                        if (e instanceof EOFException) {
                            i2 = 200050;
                        } else {
                            i2 = 102102;
                        }
                        ms(outputStream2);
                        ms(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        dVar.ms(i2, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    } catch (Throwable th5) {
                        th = th5;
                        sb = null;
                        outputStream2 = outputStream;
                        i = responseCode;
                        r3 = headerFields;
                        httpsURLConnection = httpsURLConnection2;
                        th = th;
                        ms(outputStream2);
                        ms(inputStream);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        dVar.ms(i, r3, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    inputStream = null;
                    sb = null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    sb = null;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
                sb = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                sb = null;
            }
        } catch (IOException e6) {
            e = e6;
            httpsURLConnection = null;
            inputStream = null;
            sb = null;
            i = -1;
            r3 = 0;
        } catch (Throwable th8) {
            th = th8;
            httpsURLConnection = null;
            inputStream = null;
            sb = null;
            i = -1;
            r3 = 0;
        }
    }

    private void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                sl.ms(e);
            }
        }
    }

    private static class ms {
        private static volatile ms ka;
        private final Runnable ab = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.p.x.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ms();
            }
        };
        private ConnectivityManager.NetworkCallback ah;
        private Handler c;
        private boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ConnectivityManager f3249ms;
        private Network xr;

        private ms(Context context) {
            try {
                this.f3249ms = (ConnectivityManager) context.getSystemService("connectivity");
                this.c = new Handler(Looper.getMainLooper());
            } catch (Exception e) {
                sl.ms(e);
            }
        }

        public static ms ms(Context context) {
            if (ka == null) {
                synchronized (ms.class) {
                    if (ka == null) {
                        ka = new ms(context);
                    }
                }
            }
            return ka;
        }

        public void ms(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.c.removeCallbacks(this.ab);
            ConnectivityManager connectivityManager = this.f3249ms;
            if (connectivityManager == null) {
                sl.ms("transmit_business", "forceNet mConnectivityManager is null");
                return;
            }
            Network network = this.xr;
            if (network != null && !this.d && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                sl.ms("transmit_business", "forceNet reuse network");
                networkCallback.onAvailable(this.xr);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.ah;
            if (networkCallback2 != null) {
                try {
                    this.f3249ms.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e) {
                    sl.ms(e);
                    this.ah = null;
                }
                sl.ms("transmit_business", "forceNet clear");
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            this.ah = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.p.x.ms.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (ms.this.f3249ms.getNetworkCapabilities(network2).hasTransport(0)) {
                            ms.this.xr = network2;
                            networkCallback.onAvailable(network2);
                            ms.this.d = false;
                        } else {
                            sl.ms("transmit_business", "forceNet check fail...");
                            ms.this.xr = null;
                            networkCallback.onAvailable(null);
                            ms.this.d = true;
                        }
                    } catch (Exception e2) {
                        sl.ms(e2);
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    ms.this.d = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    networkCallback.onUnavailable();
                }
            };
            this.f3249ms.requestNetwork(networkRequestBuild, this.ah, 5000);
        }

        public void ms(long j) {
            this.c.postDelayed(this.ab, j);
        }

        public void ms() {
            if (this.f3249ms == null) {
                return;
            }
            try {
                if (this.ah == null) {
                    return;
                }
                sl.ms("transmit_business", "unregisterNetwork");
                this.f3249ms.unregisterNetworkCallback(this.ah);
                this.ah = null;
                this.xr = null;
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }
}
