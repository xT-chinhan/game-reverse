package com.byazt.ry;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public hw c;
    public Context fw;
    public pr hn;
    public int qa;
    public boolean x;
    public x zo;
    public long hw = 0;
    public boolean uc = false;
    public int aj = 0;
    public long vk = 19700101000L;
    public int w = 0;
    public HashMap<String, Integer> k = new HashMap<>();
    public HashMap<String, Integer> m = new HashMap<>();
    public int g = 0;
    public HashMap<String, Integer> ho = new HashMap<>();
    public HashMap<String, Integer> nt = new HashMap<>();
    public boolean yb = true;
    public Map<String, Integer> lb = new HashMap();
    public Handler pr = new Handler(Looper.getMainLooper()) { // from class: com.byazt.ry.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10000:
                    c.this.hw(message.arg1 != 0);
                    break;
            }
        }
    };

    private c() {
    }

    public c(int i) {
        this.qa = i;
    }

    public String pr() {
        return "ttnet_tnc_config" + this.qa;
    }

    public pr hw() {
        return this.hn;
    }

    public void pr(boolean z) {
        this.x = z;
    }

    public void pr(hw hwVar) {
        this.c = hwVar;
    }

    public boolean hn() {
        return this.x;
    }

    public hw x() {
        return this.c;
    }

    public void c() {
        this.lb.clear();
    }

    public synchronized void pr(Context context, boolean z) {
        if (!this.uc) {
            if (context != null) {
                this.fw = context.getApplicationContext();
            }
            this.yb = z;
            this.zo = new x(context, z, this.qa);
            if (z) {
                aj();
            }
            this.hn = fw.pr().pr(this.qa, this.fw);
            this.uc = true;
        }
    }

    private void aj() {
        SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(this.fw, pr(), 0);
        this.aj = sharedPreferencesHw.getInt("tnc_probe_cmd", 0);
        this.vk = sharedPreferencesHw.getLong("tnc_probe_version", 19700101000L);
    }

    public hn uc() {
        x xVar = this.zo;
        if (xVar != null) {
            return xVar.hn();
        }
        return null;
    }

    public Map<String, String> fw() {
        hn hnVarUc = uc();
        if (hnVarUc != null) {
            return hnVarUc.x;
        }
        return null;
    }

    public x zo() {
        return this.zo;
    }

    public String pr(String str) {
        String protocol;
        Map<String, String> mapFw;
        if (TextUtils.isEmpty(str) || str.contains("/network/get_network") || str.contains("/get_domains/v4") || str.contains("/ies/speed")) {
            return str;
        }
        String host = null;
        try {
            URL url = new URL(str);
            protocol = url.getProtocol();
            try {
                host = url.getHost();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            protocol = null;
        }
        if (TextUtils.isEmpty(protocol) || ((!"http".equals(protocol) && !BaseConstants.SCHEME_HTTPS.equals(protocol)) || TextUtils.isEmpty(host) || x(host) || (mapFw = fw()) == null || !mapFw.containsKey(host))) {
            return str;
        }
        String str2 = mapFw.get(host);
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = protocol + "://" + host;
        String str4 = protocol + "://" + str2;
        if (str.startsWith(str3)) {
            return str.replaceFirst(str3, str4);
        }
        return str;
    }

    public synchronized void pr(g gVar, nt ntVar) {
        if (gVar == null || ntVar == null) {
            return;
        }
        if (this.yb) {
            if (com.byazt.am.x.pr(this.fw)) {
                URL url = null;
                try {
                    url = new URL(gVar.hw().toString());
                } catch (Exception e) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String strPr = pr(gVar);
                int iHn = ntVar.hn();
                if ("http".equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                    if (TextUtils.isEmpty(strPr)) {
                        return;
                    }
                    hn hnVarUc = uc();
                    if (hnVarUc != null && hnVarUc.hw) {
                        pr(ntVar, host);
                    }
                    if (hnVarUc == null) {
                        return;
                    }
                    this.k.size();
                    this.m.size();
                    this.ho.size();
                    this.nt.size();
                    if (iHn > 0) {
                        if (pr(iHn)) {
                            if (this.w > 0 || this.g > 0) {
                                vk();
                            }
                            hn(host);
                            return;
                        }
                        if (!hw(iHn)) {
                            this.g++;
                            this.ho.put(path, 0);
                            this.nt.put(strPr, 0);
                            if (this.g >= hnVarUc.zo && this.ho.size() >= hnVarUc.aj && this.nt.size() >= hnVarUc.vk) {
                                pr(false, 0L);
                                vk();
                            }
                            hw(host);
                        }
                    }
                }
            }
        }
    }

    private String pr(g gVar) {
        if (gVar == null || gVar.hw() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(new URL(gVar.hw().toString()).getHost()).getHostAddress();
        } catch (Exception e) {
            return "";
        }
    }

    private void hw(String str) {
        Map<String, String> mapFw;
        if (TextUtils.isEmpty(str) || (mapFw = fw()) == null || !mapFw.containsValue(str)) {
            return;
        }
        if (this.lb.get(str) == null) {
            this.lb.put(str, 1);
        } else {
            this.lb.put(str, Integer.valueOf(this.lb.get(str).intValue() + 1));
        }
    }

    private void hn(String str) {
        if (TextUtils.isEmpty(str) || !this.lb.containsKey(str)) {
            return;
        }
        this.lb.put(str, 0);
    }

    private boolean x(String str) {
        Map<String, String> mapFw = fw();
        if (mapFw == null) {
            return false;
        }
        String str2 = mapFw.get(str);
        if (TextUtils.isEmpty(str2) || this.lb.get(str2) == null || this.lb.get(str2).intValue() < 3) {
            return false;
        }
        return true;
    }

    public synchronized void pr(g gVar, Exception exc) {
        if (gVar != null) {
            if (gVar.hw() != null && exc != null) {
                if (this.yb) {
                    if (com.byazt.am.x.pr(this.fw)) {
                        URL url = null;
                        try {
                            url = new URL(gVar.hw().toString());
                        } catch (Exception e) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String strPr = pr(gVar);
                        if ("http".equals(protocol) || BaseConstants.SCHEME_HTTPS.equals(protocol)) {
                            hn hnVarUc = uc();
                            if (hnVarUc == null) {
                                return;
                            }
                            this.k.size();
                            this.m.size();
                            this.ho.size();
                            this.nt.size();
                            this.w++;
                            this.k.put(path, 0);
                            this.m.put(strPr, 0);
                            if (this.w >= hnVarUc.c && this.k.size() >= hnVarUc.uc && this.m.size() >= hnVarUc.fw) {
                                pr(false, 0L);
                                vk();
                            }
                            hw(host);
                        }
                    }
                }
            }
        }
    }

    private void pr(nt ntVar, String str) {
        String[] strArrSplit;
        int i;
        long j;
        hn hnVarUc;
        if (ntVar == null || !this.yb) {
            return;
        }
        String strPr = ntVar.pr("tnc-cmd", null);
        if (TextUtils.isEmpty(strPr) || (strArrSplit = strPr.split("@")) == null || strArrSplit.length != 2) {
            return;
        }
        try {
            i = Integer.parseInt(strArrSplit[0]);
            try {
                j = Long.parseLong(strArrSplit[1]);
            } catch (Throwable th) {
                j = 0;
            }
        } catch (Throwable th2) {
            i = 0;
        }
        if (j <= this.vk) {
            return;
        }
        this.aj = i;
        this.vk = j;
        com.byazt.mg.hw.hw(this.fw, pr(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
        if (this.aj != 10000 || (hnVarUc = uc()) == null) {
            return;
        }
        pr(true, hnVarUc.k > 0 ? ((long) new Random(System.currentTimeMillis()).nextInt(hnVarUc.k)) * 1000 : 0L);
    }

    private void pr(boolean z, long j) {
        if (this.pr.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.pr.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.pr.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.pr.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(boolean z) {
        hn hnVarUc = uc();
        if (hnVarUc == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.hw + (((long) hnVarUc.w) * 1000) > jElapsedRealtime) {
            return;
        }
        this.hw = jElapsedRealtime;
        fw.pr().pr(this.qa, this.fw).hn();
    }

    private void vk() {
        this.w = 0;
        this.k.clear();
        this.m.clear();
        this.g = 0;
        this.ho.clear();
        this.nt.clear();
    }

    private boolean pr(int i) {
        if (i >= 200 && i < 400) {
            return true;
        }
        return false;
    }

    private boolean hw(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        hn hnVarUc = uc();
        if (hnVarUc != null && !TextUtils.isEmpty(hnVarUc.m) && hnVarUc.m.contains(String.valueOf(i))) {
            return true;
        }
        return false;
    }
}
