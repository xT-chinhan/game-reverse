package com.bytedance.sdk.component.ny.ah;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.u;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private Context ab;
    private ms ah;
    private boolean d;
    private xr ka;
    private d x;
    private int y;
    private long xr = 0;
    private boolean c = false;
    private int ny = 0;
    private long ch = 19700101000L;
    private int hi = 0;
    private HashMap<String, Integer> sl = new HashMap<>();
    private HashMap<String, Integer> zb = new HashMap<>();
    private int u = 0;
    private HashMap<String, Integer> ub = new HashMap<>();
    private HashMap<String, Integer> ao = new HashMap<>();
    private boolean h = true;
    private Map<String, Integer> qv = new HashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Handler f1278ms = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.ny.ah.ka.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            ka.this.xr(message.arg1 != 0);
        }
    };

    private boolean ms(int i) {
        return i >= 200 && i < 400;
    }

    private ka() {
    }

    public ka(int i) {
        this.y = i;
    }

    public String ms() {
        return "ttnet_tnc_config" + this.y;
    }

    public ms xr() {
        return this.ah;
    }

    public void ms(boolean z) {
        this.d = z;
    }

    public void ms(xr xrVar) {
        this.ka = xrVar;
    }

    public boolean ah() {
        return this.d;
    }

    public xr d() {
        return this.ka;
    }

    public void ka() {
        this.qv.clear();
    }

    public synchronized void ms(Context context, boolean z) {
        if (!this.c) {
            this.ab = context;
            this.h = z;
            this.x = new d(context, z, this.y);
            if (z) {
                ny();
            }
            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.ny + " probeVersion: " + this.ch);
            this.ah = ab.ms().ms(this.y, this.ab);
            this.c = true;
        }
    }

    private void ny() {
        SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.ab, ms(), 0);
        this.ny = sharedPreferencesXr.getInt("tnc_probe_cmd", 0);
        this.ch = sharedPreferencesXr.getLong("tnc_probe_version", 19700101000L);
    }

    public ah c() {
        d dVar = this.x;
        if (dVar != null) {
            return dVar.ah();
        }
        return null;
    }

    public Map<String, String> ab() {
        ah ahVarC = c();
        if (ahVarC != null) {
            return ahVarC.d;
        }
        return null;
    }

    public d x() {
        return this.x;
    }

    public String ms(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    sl.ms(th);
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (d(host)) {
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(host)));
                    return str;
                }
                Map<String, String> mapAb = ab();
                if (mapAb == null || !mapAb.containsKey(host)) {
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleHostMapping, nomatch: ".concat(String.valueOf(host)));
                } else {
                    String str2 = mapAb.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleHostMapping, match, origin: ".concat(String.valueOf(str)));
                    String str3 = protocol + "://" + host;
                    String str4 = protocol + "://" + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleHostMapping, target: ".concat(String.valueOf(str)));
                    return str;
                }
            }
        }
        return str;
    }

    public synchronized void ms(u uVar, ao aoVar) {
        URL urlMs;
        if (uVar == null || aoVar == null) {
            return;
        }
        if (this.h) {
            if (com.bytedance.sdk.component.ny.d.c.ms(this.ab)) {
                try {
                    urlMs = uVar.xr().ms();
                } catch (Exception unused) {
                    urlMs = null;
                }
                if (urlMs == null) {
                    return;
                }
                String protocol = urlMs.getProtocol();
                String host = urlMs.getHost();
                String path = urlMs.getPath();
                String strMs = ms(uVar);
                int iAh = aoVar.ah();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strMs)) {
                        return;
                    }
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strMs + "#" + iAh);
                    ah ahVarC = c();
                    if (ahVarC != null && ahVarC.xr) {
                        ms(aoVar, host);
                    }
                    if (ahVarC == null) {
                        return;
                    }
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strMs + "#" + iAh + " " + this.hi + "#" + this.sl.size() + "#" + this.zb.size() + " " + this.u + "#" + this.ub.size() + "#" + this.ao.size());
                    if (iAh > 0) {
                        if (ms(iAh)) {
                            if (this.hi > 0 || this.u > 0) {
                                ch();
                            }
                            ah(host);
                            return;
                        }
                        if (!xr(iAh)) {
                            this.u++;
                            this.ub.put(path, 0);
                            this.ao.put(strMs, 0);
                            if (this.u >= ahVarC.x && this.ub.size() >= ahVarC.ny && this.ao.size() >= ahVarC.ch) {
                                com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strMs + "#" + iAh);
                                ms(false, 0L);
                                ch();
                            }
                            xr(host);
                        }
                    }
                }
            }
        }
    }

    private String ms(u uVar) {
        if (uVar == null || uVar.xr() == null || uVar.xr().ms() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(uVar.xr().ms().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void xr(String str) {
        Map<String, String> mapAb;
        if (TextUtils.isEmpty(str) || (mapAb = ab()) == null || !mapAb.containsValue(str)) {
            return;
        }
        if (this.qv.get(str) == null) {
            this.qv.put(str, 1);
        } else {
            this.qv.put(str, Integer.valueOf(this.qv.get(str).intValue() + 1));
        }
    }

    private void ah(String str) {
        if (!TextUtils.isEmpty(str) && this.qv.containsKey(str)) {
            this.qv.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> mapAb = ab();
        if (mapAb == null) {
            return false;
        }
        String str2 = mapAb.get(str);
        if (TextUtils.isEmpty(str2) || this.qv.get(str2) == null || this.qv.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    public synchronized void ms(u uVar, Exception exc) {
        URL urlMs;
        if (uVar != null) {
            if (uVar.xr() != null && exc != null) {
                if (this.h) {
                    if (com.bytedance.sdk.component.ny.d.c.ms(this.ab)) {
                        try {
                            urlMs = uVar.xr().ms();
                        } catch (Exception unused) {
                            urlMs = null;
                        }
                        if (urlMs == null) {
                            return;
                        }
                        String protocol = urlMs.getProtocol();
                        String host = urlMs.getHost();
                        String path = urlMs.getPath();
                        String strMs = ms(uVar);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            ah ahVarC = c();
                            if (ahVarC == null) {
                                return;
                            }
                            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strMs + "# " + this.hi + "#" + this.sl.size() + "#" + this.zb.size() + " " + this.u + "#" + this.ub.size() + "#" + this.ao.size());
                            this.hi++;
                            this.sl.put(path, 0);
                            this.zb.put(strMs, 0);
                            if (this.hi >= ahVarC.ka && this.sl.size() >= ahVarC.c && this.zb.size() >= ahVarC.ab) {
                                com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strMs);
                                ms(false, 0L);
                                ch();
                            }
                            xr(host);
                        }
                    }
                }
            }
        }
    }

    private void ms(ao aoVar, String str) {
        int i;
        long j;
        ah ahVarC;
        if (aoVar != null && this.h) {
            String strMs = aoVar.ms("tnc-cmd", null);
            if (TextUtils.isEmpty(strMs)) {
                com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleTncProbe, no probeProto, ".concat(String.valueOf(str)));
                return;
            }
            String[] strArrSplit = strMs.split("@");
            if (strArrSplit == null || strArrSplit.length != 2) {
                com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleTncProbe, probeProto err, ".concat(String.valueOf(str)));
                return;
            }
            try {
                i = Integer.parseInt(strArrSplit[0]);
                try {
                    j = Long.parseLong(strArrSplit[1]);
                } catch (Throwable th) {
                    th = th;
                    sl.ms(th);
                    com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleTncProbe, probeProto except, ".concat(String.valueOf(str)));
                    j = 0;
                }
            } catch (Throwable th2) {
                th = th2;
                i = 0;
            }
            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleTncProbe, local: " + this.ny + "@" + this.ch + " svr: " + i + "@" + j + " " + str);
            if (j <= this.ch) {
                return;
            }
            this.ny = i;
            this.ch = j;
            com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.ab, ms(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
            if (this.ny != 10000 || (ahVarC = c()) == null) {
                return;
            }
            long jNextInt = ahVarC.sl > 0 ? ((long) new Random(System.currentTimeMillis()).nextInt(ahVarC.sl)) * 1000 : 0L;
            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
            ms(true, jNextInt);
        }
    }

    private void ms(boolean z, long j) {
        if (this.f1278ms.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.f1278ms.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.f1278ms.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.f1278ms.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        ah ahVarC = c();
        if (ahVarC == null) {
            return;
        }
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.xr + (((long) ahVarC.hi) * 1000) > jElapsedRealtime) {
            com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.xr = jElapsedRealtime;
            ab.ms().ms(this.y, this.ab).ah();
        }
    }

    private void ch() {
        com.bytedance.sdk.component.ny.d.ah.xr("TNCManager", "resetTNCControlState");
        this.hi = 0;
        this.sl.clear();
        this.zb.clear();
        this.u = 0;
        this.ub.clear();
        this.ao.clear();
    }

    private boolean xr(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        ah ahVarC = c();
        return (ahVarC == null || TextUtils.isEmpty(ahVarC.zb) || !ahVarC.zb.contains(String.valueOf(i))) ? false : true;
    }
}
