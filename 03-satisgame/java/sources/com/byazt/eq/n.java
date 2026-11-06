package com.byazt.eq;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.h.au;
import com.anythink.core.common.l.f;
import com.anythink.core.common.res.image.c;
import com.byazt.ed.s;
import com.byazt.qp.q;
import com.byazt.tk.l;
import com.byazt.tk.rv;
import com.byazt.vf.oa;
import com.byazt.vgx.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 672, 19})
public class n {
    public static volatile n n;
    public static final List<String> oa = Arrays.asList(c.b, "-10008", "103111", "105002", "110023", "-5", "-2", "-15", "-10", "-11");
    public String[] fs;
    public final s l;
    public final qg q;
    public final Context qg;
    public final com.byazt.tv.s s;
    public final AtomicBoolean x = new AtomicBoolean(false);
    public long rv = 0;
    public long tj = 0;
    public long cp = 0;
    public long d = 0;
    public boolean w = true;

    private n(Context context) {
        this.qg = context;
        this.s = com.byazt.tv.s.n(context);
        s sVarN = s.n();
        this.l = sVarN;
        if (sVarN != null) {
            String strS = sVarN.s("cr", 3300000L);
            if (!TextUtils.isEmpty(strS)) {
                this.q = new qg(sVarN.s("vd", n(strS)), sVarN.s(NotificationCompat.CATEGORY_ERROR, n(strS)), sVarN.s("tk", n(strS)), sVarN.s("cr", n(strS)));
            } else {
                this.q = new qg("", "", "", "");
            }
            s();
            return;
        }
        this.q = new qg("", "-1", "", "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private long n(String str) {
        byte b;
        switch (str) {
            case "1":
                b = 1;
                break;
            case "2":
                b = 0;
                break;
            case "3":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        return b != 0 ? 3300000L : 50000L;
    }

    private boolean qg() {
        s sVar = this.l;
        if (sVar != null) {
            String strS = sVar.s("cr", 3300000L);
            if (!TextUtils.isEmpty(strS) && !TextUtils.isEmpty(this.l.s("tk", n(strS)))) {
                return true;
            }
        }
        return false;
    }

    private void s() {
        s sVar = this.l;
        if (sVar != null) {
            this.tj = sVar.qg("uni_fir_ts", 0L);
            if (w.n(System.currentTimeMillis(), this.tj)) {
                this.cp = this.l.qg("uni_times", 0L);
                this.d = this.l.qg("uni_ts", 0L);
            } else {
                this.cp = 0L;
                this.d = 0L;
            }
        }
    }

    public static n n(Context context) {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n(context);
                }
            }
        }
        return n;
    }

    public qg n() {
        if (qg() || !this.w) {
            return this.q;
        }
        if (!this.x.compareAndSet(false, true)) {
            return this.q;
        }
        rv.n().post(new Runnable() { // from class: com.byazt.eq.n.1
            /* JADX WARN: Code duplicated, block: B:53:0x00d7  */
            /* JADX WARN: Code duplicated, block: B:55:0x00ea  */
            /* JADX WARN: Code duplicated, block: B:57:0x00f5  */
            /* JADX WARN: Code duplicated, block: B:59:0x0104  */
            @Override // java.lang.Runnable
            public void run() {
                int iN;
                String strConcat;
                final ArrayList arrayList = new ArrayList();
                byte b = -1;
                if (com.byazt.af.s.n(n.this.qg, "android.permission.ACCESS_NETWORK_STATE") != -1) {
                    iN = n.this.s.n();
                    if (iN != 3 || com.byazt.af.s.n(n.this.qg, "android.permission.CHANGE_NETWORK_STATE") != -1) {
                        if (iN != 3 && iN != 2) {
                            strConcat = "4".concat(String.valueOf(iN));
                        } else {
                            String strLh = ((oa) q.n("device_info_new")).lh();
                            strLh.hashCode();
                            switch (strLh.hashCode()) {
                                case 48:
                                    if (strLh.equals("0")) {
                                        b = 0;
                                    }
                                    break;
                                case 49:
                                    if (strLh.equals("1")) {
                                        b = 1;
                                    }
                                    break;
                                case 50:
                                    if (strLh.equals("2")) {
                                        b = 2;
                                    }
                                    break;
                                case 51:
                                    if (strLh.equals("3")) {
                                        b = 3;
                                    }
                                    break;
                                case 52:
                                    if (strLh.equals("4")) {
                                        b = 4;
                                    }
                                    break;
                                case 54:
                                    if (strLh.equals("6")) {
                                        b = 5;
                                    }
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    n.this.w = false;
                                    strConcat = "3";
                                    break;
                                case 1:
                                    arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                    strConcat = "";
                                    break;
                                case 2:
                                    arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                    strConcat = "";
                                    break;
                                case 3:
                                    arrayList.add("https://id6.me/gw/preuniq.do");
                                    strConcat = "";
                                    break;
                                case 4:
                                case 5:
                                    arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                    arrayList.add("https://id6.me/gw/preuniq.do");
                                    arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                    strConcat = "";
                                    break;
                                default:
                                    n.this.w = false;
                                    strConcat = "2";
                                    break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        n.this.q.n("", strConcat, "", "");
                        n.this.x.set(false);
                        return;
                    }
                    n.this.q.n("", "1", "", "");
                    if (iN == 3) {
                        n.this.s.n(new com.byazt.tv.s.n() { // from class: com.byazt.eq.n.1.1
                            @Override // com.byazt.tv.s.n
                            public void n(Network network) {
                                if (network == null) {
                                    n.this.q();
                                } else {
                                    n.this.n(network, (List<String>) arrayList);
                                }
                            }
                        });
                    } else {
                        n.this.n((Network) null, arrayList);
                    }
                }
                iN = 0;
                n.this.w = false;
                strConcat = "5";
                if (!TextUtils.isEmpty(strConcat)) {
                    n.this.q.n("", strConcat, "", "");
                    n.this.x.set(false);
                    return;
                }
                n.this.q.n("", "1", "", "");
                if (iN == 3) {
                    n.this.s.n(new com.byazt.tv.s.n() { // from class: com.byazt.eq.n.1.1
                        @Override // com.byazt.tv.s.n
                        public void n(Network network) {
                            if (network == null) {
                                n.this.q();
                            } else {
                                n.this.n(network, (List<String>) arrayList);
                            }
                        }
                    });
                } else {
                    n.this.n((Network) null, arrayList);
                }
            }
        });
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    public void n(Network network, List<String> list) {
        byte b;
        String str;
        String str2;
        String strN;
        String str3;
        String strN2;
        for (String str4 : list) {
            try {
                int iHashCode = str4.hashCode();
                if (iHashCode != 15305274) {
                    if (iHashCode != 899606572) {
                        if (iHashCode == 1964448447 && str4.equals("https://id6.me/gw/preuniq.do")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (str4.equals("https://nisportal.10010.com:9001/api?appid=1554778161154")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str4.equals("https://msg.cmpassport.com/h5/getMobile")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    str = "1";
                    str2 = null;
                    strN = str4;
                    str3 = "0";
                    strN2 = com.byazt.tv.q.n();
                } else if (b == 1) {
                    String strN3 = l.n(8);
                    str2 = strN3;
                    str = "3";
                    strN2 = null;
                    str3 = "1";
                    strN = com.byazt.tv.q.n(str4, strN3);
                } else if (b == 2) {
                    long j = this.cp + 1;
                    this.cp = j;
                    s sVar = this.l;
                    if (sVar != null) {
                        sVar.n("uni_times", j);
                        if (this.cp == 1) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            this.tj = jCurrentTimeMillis;
                            this.l.n("uni_fir_ts", jCurrentTimeMillis);
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    str = "2";
                    if (w.n(jCurrentTimeMillis2, this.tj) && this.cp >= 30 && jCurrentTimeMillis2 - this.d < 3000000) {
                        this.q.n("2", "7", "", "2");
                    } else {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        this.d = jCurrentTimeMillis3;
                        s sVar2 = this.l;
                        if (sVar2 != null) {
                            sVar2.n("uni_ts", jCurrentTimeMillis3);
                        }
                        strN = str4;
                        strN2 = null;
                        str2 = null;
                        str3 = "2";
                    }
                } else {
                    this.x.set(false);
                    return;
                }
                n(network, strN, strN2, str, str3, str2);
            } catch (Exception unused) {
                this.q.n("", "6", "", "");
            }
            if (!TextUtils.isEmpty(this.q.qg()) || (!TextUtils.isEmpty(this.q.n()) && !oa.contains(this.q.n()))) {
                break;
            }
        }
        if (!TextUtils.isEmpty(this.q.n()) && oa.contains(this.q.n())) {
            this.w = false;
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.x.set(false);
        this.s.qg();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void n(Network network, String str, String str2, String str3, String str4, String str5) {
        byte b;
        String str6;
        String string;
        JSONObject jSONObjectN = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : com.byazt.tv.qg.n(network, str, str2);
        String str7 = "";
        if (jSONObjectN == null) {
            this.q.n(str4, "6", "", str3);
            return;
        }
        try {
            switch (str3.hashCode()) {
                case 49:
                    if (!str3.equals("1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 50:
                    if (!str3.equals("2")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 51:
                    if (!str3.equals("3")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                JSONObject jSONObject = jSONObjectN.getJSONObject("body");
                String string2 = jSONObject.getString("resultCode");
                if ("103000".equals(string2)) {
                    string = jSONObject.getString(au.b.a);
                    str6 = string;
                    str7 = "0";
                } else {
                    str6 = "";
                    str7 = string2;
                }
            } else if (b == 1) {
                String strValueOf = String.valueOf(jSONObjectN.getInt("result"));
                if ("0".equals(strValueOf)) {
                    string = new JSONObject(com.byazt.tv.n.n(false, l.n(jSONObjectN.getString(f.R)), str5)).getString("accessCode");
                    str6 = string;
                    str7 = "0";
                } else {
                    str7 = strValueOf;
                    str6 = "";
                }
            } else if (b != 2) {
                str6 = "";
            } else {
                String strOptString = jSONObjectN.has("code") ? jSONObjectN.optString("code") : "";
                if (jSONObjectN.has("authurl")) {
                    String string3 = jSONObjectN.getString("authurl");
                    if (!TextUtils.isEmpty(string3)) {
                        Pair<String, String> pairN = n(network, string3 + "/api?appid=1554778161154", str3, str4);
                        if (pairN.first != null) {
                            strOptString = (String) pairN.first;
                        }
                        if (pairN.second != null) {
                            str7 = (String) pairN.second;
                        }
                    }
                }
                str6 = str7;
                str7 = strOptString;
            }
            this.q.n(str4, str7, str6, str3);
            if (this.l == null || TextUtils.isEmpty(str6)) {
                return;
            }
            this.l.s("vd", str4);
            this.l.s("cr", str3);
            this.l.s(NotificationCompat.CATEGORY_ERROR, str7);
            this.l.s("tk", str6);
        } catch (Exception unused) {
        }
    }

    private Pair<String, String> n(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectN = com.byazt.tv.qg.n(network, str, null);
        try {
            if (jSONObjectN == null) {
                this.q.n(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string2 = jSONObjectN.has("err_code") ? jSONObjectN.getString("err_code") : "6";
            if (this.fs == null || System.currentTimeMillis() - this.rv > 3600000) {
                this.fs = com.byazt.ehw.w.qg(com.byazt.vgx.s.l());
                this.rv = System.currentTimeMillis();
            }
            String[] strArr = this.fs;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.q.n(this.fs[1]);
            }
            if (jSONObjectN.has("province")) {
                this.q.qg(jSONObjectN.getString("province"));
            }
            if (jSONObjectN.has("code")) {
                string2 = "0";
                string = jSONObjectN.getString("code");
            } else {
                string = "";
            }
            return new Pair<>(string2, string);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
