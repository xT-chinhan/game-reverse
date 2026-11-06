package com.byazt.two;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.byazt.tbt.cy;
import com.byazt.tbt.sz;
import com.byazt.vf.ae;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 5})
public class q {
    public final int cy;
    public volatile com.byazt.gwu.s hd;
    public final Context l;
    public final n q;
    public long qg = 0;
    public boolean s = true;
    public int w = 0;
    public long x = 19700101000L;
    public int fs = 0;
    public HashMap<String, Integer> rv = new HashMap<>();
    public HashMap<String, Integer> tj = new HashMap<>();
    public int cp = 0;
    public HashMap<String, Integer> d = new HashMap<>();
    public HashMap<String, Integer> oa = new HashMap<>();
    public boolean sz = true;
    public Map<String, Integer> k = new HashMap();
    public Handler n = new Handler(Looper.getMainLooper()) { // from class: com.byazt.two.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            q.this.n(message.arg1 != 0);
        }
    };

    private boolean n(int i) {
        return i >= 200 && i < 400;
    }

    public q(n nVar, Context context, int i) {
        this.q = nVar;
        this.l = context;
        this.cy = i;
        w();
    }

    public String n() {
        return "ttnet_tnc_config" + this.cy;
    }

    public boolean qg() {
        return this.s;
    }

    public void s() {
        this.k.clear();
    }

    private void w() {
        com.byazt.gwu.s sVarX = x();
        this.w = sVarX != null ? sVarX.getInt("tnc_probe_cmd", 0) : 0;
        this.x = sVarX != null ? sVarX.getLong("tnc_probe_version", 19700101000L) : 19700101000L;
    }

    private com.byazt.gwu.s x() {
        if (this.hd == null) {
            com.byazt.vf.n nVarQg = com.byazt.qp.q.qg(null);
            ae aeVar = (ae) com.byazt.qp.q.n("storage_service");
            if (aeVar != null) {
                this.hd = aeVar.qg(nVarQg, n(), 0, com.byazt.p001if.n.n());
            }
        }
        return this.hd;
    }

    public qg q() {
        n nVar = this.q;
        if (nVar != null) {
            return nVar.qg();
        }
        return null;
    }

    public Map<String, String> l() {
        qg qgVarQ = q();
        if (qgVarQ != null) {
            return qgVarQ.q;
        }
        return null;
    }

    public String n(String str) {
        String protocol;
        Map<String, String> mapL;
        if (TextUtils.isEmpty(str) || str.contains("/network/get_network") || str.contains("/get_domains/v4") || str.contains("/ies/speed")) {
            return str;
        }
        String host = null;
        try {
            URL url = new URL(str);
            protocol = url.getProtocol();
            try {
                host = url.getHost();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            protocol = null;
        }
        if (TextUtils.isEmpty(protocol)) {
            return str;
        }
        if ((!"http".equals(protocol) && !BaseConstants.SCHEME_HTTPS.equals(protocol)) || TextUtils.isEmpty(host) || q(host) || (mapL = l()) == null || !mapL.containsKey(host)) {
            return str;
        }
        String str2 = mapL.get(host);
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = protocol + "://" + host;
        return str.startsWith(str3) ? str.replaceFirst(str3, protocol + "://" + str2) : str;
    }

    public synchronized void n(sz szVar, cy cyVar) {
        URL url;
        if (szVar == null || cyVar == null) {
            return;
        }
        if (this.sz) {
            if (com.byazt.nx.s.n(this.l)) {
                try {
                    url = new URL(szVar.s());
                } catch (Exception unused) {
                    url = null;
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String strN = n(szVar);
                int iQ = cyVar.q();
                if ("http".equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                    if (TextUtils.isEmpty(strN)) {
                        return;
                    }
                    qg qgVarQ = q();
                    if (qgVarQ != null && qgVarQ.qg) {
                        n(cyVar, host);
                    }
                    if (qgVarQ == null) {
                        return;
                    }
                    this.rv.size();
                    this.tj.size();
                    this.d.size();
                    this.oa.size();
                    if (iQ > 0) {
                        if (n(iQ)) {
                            if (this.fs > 0 || this.cp > 0) {
                                fs();
                            }
                            s(host);
                            return;
                        }
                        if (!qg(iQ)) {
                            this.cp++;
                            this.d.put(path, 0);
                            this.oa.put(strN, 0);
                            if (this.cp >= qgVarQ.fs && this.d.size() >= qgVarQ.rv && this.oa.size() >= qgVarQ.tj) {
                                n(false, 0L);
                                fs();
                            }
                            qg(host);
                        }
                    }
                }
            }
        }
    }

    private String n(sz szVar) {
        if (szVar == null || TextUtils.isEmpty(szVar.s())) {
            return "";
        }
        try {
            return InetAddress.getByName(new URL(szVar.s()).getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void qg(String str) {
        Map<String, String> mapL;
        if (TextUtils.isEmpty(str) || (mapL = l()) == null || !mapL.containsValue(str)) {
            return;
        }
        if (this.k.get(str) == null) {
            this.k.put(str, 1);
        } else {
            this.k.put(str, Integer.valueOf(this.k.get(str).intValue() + 1));
        }
    }

    private void s(String str) {
        if (!TextUtils.isEmpty(str) && this.k.containsKey(str)) {
            this.k.put(str, 0);
        }
    }

    private boolean q(String str) {
        Map<String, String> mapL = l();
        if (mapL == null) {
            return false;
        }
        String str2 = mapL.get(str);
        return (TextUtils.isEmpty(str2) || this.k.get(str2) == null || this.k.get(str2).intValue() < 3) ? false : true;
    }

    public synchronized void n(sz szVar, Exception exc) {
        URL url;
        if (szVar != null) {
            if (!TextUtils.isEmpty(szVar.s()) && exc != null) {
                if (this.sz) {
                    if (com.byazt.nx.s.n(this.l)) {
                        try {
                            url = new URL(szVar.s());
                        } catch (Exception unused) {
                            url = null;
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String strN = n(szVar);
                        if ("http".equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                            qg qgVarQ = q();
                            if (qgVarQ == null) {
                                return;
                            }
                            this.rv.size();
                            this.tj.size();
                            this.d.size();
                            this.oa.size();
                            this.fs++;
                            this.rv.put(path, 0);
                            this.tj.put(strN, 0);
                            if (this.fs >= qgVarQ.l && this.rv.size() >= qgVarQ.w && this.tj.size() >= qgVarQ.x) {
                                n(false, 0L);
                                fs();
                            }
                            qg(host);
                        }
                    }
                }
            }
        }
    }

    private void n(cy cyVar, String str) {
        String[] strArrSplit;
        long j;
        qg qgVarQ;
        if (cyVar != null && this.sz) {
            String strN = cyVar.n("tnc-cmd", null);
            if (TextUtils.isEmpty(strN) || (strArrSplit = strN.split("@")) == null || strArrSplit.length != 2) {
                return;
            }
            int i = 0;
            try {
                i = Integer.parseInt(strArrSplit[0]);
                j = Long.parseLong(strArrSplit[1]);
            } catch (Throwable unused) {
                j = 0;
            }
            if (j <= this.x) {
                return;
            }
            this.w = i;
            this.x = j;
            com.byazt.gwu.s sVarX = x();
            if (sVarX != null) {
                sVarX.n("tnc_probe_cmd", i);
                sVarX.n("tnc_probe_version", j);
            }
            if (this.w != 10000 || (qgVarQ = q()) == null) {
                return;
            }
            n(true, qgVarQ.d > 0 ? ((long) new Random(System.currentTimeMillis()).nextInt(qgVarQ.d)) * 1000 : 0L);
        }
    }

    private void n(boolean z, long j) {
        if (this.n.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.n.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.n.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.n.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        qg qgVarQ = q();
        if (qgVarQ == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z || this.qg + (((long) qgVarQ.cp) * 1000) <= jElapsedRealtime) {
            this.qg = jElapsedRealtime;
            this.q.w();
        }
    }

    private void fs() {
        this.fs = 0;
        this.rv.clear();
        this.tj.clear();
        this.cp = 0;
        this.d.clear();
        this.oa.clear();
    }

    private boolean qg(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        qg qgVarQ = q();
        return (qgVarQ == null || TextUtils.isEmpty(qgVarQ.oa) || !qgVarQ.oa.contains(String.valueOf(i))) ? false : true;
    }
}
