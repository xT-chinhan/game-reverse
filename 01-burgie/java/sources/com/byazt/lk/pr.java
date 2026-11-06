package com.byazt.lk;

import android.content.Context;
import android.net.Network;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ca.aj;
import com.byazt.ca.c;
import com.byazt.hg.j;
import com.byazt.mg.PluginConstants;
import com.byazt.mp.x;
import com.byazt.mx.hn;
import com.byazt.qam.hw;
import com.byazt.vkw.g;
import com.byazt.wt.a;
import com.byazt.wt.ls;
import com.byazt.zs.uc;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1160, 37})
public class pr {
    public final x c;
    public final hn hn;
    public final Context hw;
    public final j x;
    public String[] zo;
    public static volatile pr pr = null;
    public static final List<String> m = Arrays.asList("-10001", "-10008", "103111", "105002", "110023", "-5", "-2", "-15", "-10", "-11");
    public final AtomicBoolean fw = new AtomicBoolean(false);
    public long aj = 0;
    public long vk = 0;
    public long w = 0;
    public long k = 0;
    public boolean uc = true;

    private pr(Context context) {
        this.hw = context;
        this.hn = hn.pr(context);
        x xVarPr = x.pr();
        this.c = xVarPr;
        if (xVarPr != null) {
            String strHn = xVarPr.hn("cr", 3300000L);
            if (!TextUtils.isEmpty(strHn)) {
                this.x = new j(xVarPr.hn("vd", pr(strHn)), xVarPr.hn(NotificationCompat.CATEGORY_ERROR, pr(strHn)), xVarPr.hn("tk", pr(strHn)), xVarPr.hn("cr", pr(strHn)));
            } else {
                this.x = new j("", "", "", "");
            }
            hn();
            return;
        }
        this.x = new j("", "-1", "", "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private long pr(String str) {
        switch (str) {
            case "2":
                return 50000L;
            case "1":
            case "3":
            default:
                return 3300000L;
        }
    }

    private boolean hw() {
        x xVar = this.c;
        if (xVar == null) {
            return false;
        }
        String strHn = xVar.hn("cr", 3300000L);
        return (TextUtils.isEmpty(strHn) || TextUtils.isEmpty(this.c.hn("tk", pr(strHn)))) ? false : true;
    }

    private void hn() {
        x xVar = this.c;
        if (xVar != null) {
            this.vk = xVar.hw("uni_fir_ts", 0L);
            if (ls.pr(System.currentTimeMillis(), this.vk)) {
                this.w = this.c.hw("uni_times", 0L);
                this.k = this.c.hw("uni_ts", 0L);
            } else {
                this.w = 0L;
                this.k = 0L;
            }
        }
    }

    public static pr pr(Context context) {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr(context);
                }
            }
        }
        return pr;
    }

    public j pr() {
        if (hw() || !this.uc) {
            return this.x;
        }
        if (!this.fw.compareAndSet(false, true)) {
            return this.x;
        }
        aj.pr().post(new Runnable() { // from class: com.byazt.lk.pr.1
            /* JADX WARN: Code duplicated, block: B:47:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:49:0x00e6  */
            /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
            /* JADX WARN: Code duplicated, block: B:53:0x0100  */
            @Override // java.lang.Runnable
            public void run() {
                int iPr;
                final ArrayList arrayList = new ArrayList();
                int iPr2 = hw.pr(pr.this.hw, "android.permission.ACCESS_NETWORK_STATE");
                String strConcat = GlobalSetting.SPLASH_AD;
                byte b = -1;
                if (iPr2 != -1) {
                    iPr = pr.this.hn.pr();
                    if (iPr != 3 || hw.pr(pr.this.hw, "android.permission.CHANGE_NETWORK_STATE") != -1) {
                        if (iPr != 3 && iPr != 2) {
                            strConcat = GlobalSetting.NATIVE_EXPRESS_AD.concat(String.valueOf(iPr));
                        } else {
                            String strY = ((g) uc.pr("device_info_new")).y();
                            switch (strY.hashCode()) {
                                case 48:
                                    if (strY.equals("0")) {
                                        b = 5;
                                    }
                                    break;
                                case 49:
                                    if (strY.equals("1")) {
                                        b = 2;
                                    }
                                    break;
                                case 50:
                                    if (strY.equals("2")) {
                                        b = 4;
                                    }
                                    break;
                                case 51:
                                    if (strY.equals(GlobalSetting.SPLASH_AD)) {
                                        b = 3;
                                    }
                                    break;
                                case 52:
                                    if (strY.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                                        b = 0;
                                    }
                                    break;
                                case 54:
                                    if (strY.equals(GlobalSetting.NATIVE_UNIFIED_AD)) {
                                        b = 1;
                                    }
                                    break;
                            }
                            switch (b) {
                                case 0:
                                case 1:
                                    arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                    arrayList.add("https://id6.me/gw/preuniq.do");
                                    arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                    strConcat = "";
                                    break;
                                case 2:
                                    arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                    strConcat = "";
                                    break;
                                case 3:
                                    arrayList.add("https://id6.me/gw/preuniq.do");
                                    strConcat = "";
                                    break;
                                case 4:
                                    arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                    strConcat = "";
                                    break;
                                case 5:
                                    pr.this.uc = false;
                                    break;
                                default:
                                    pr.this.uc = false;
                                    strConcat = "2";
                                    break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        pr.this.x.pr("", strConcat, "", "");
                        pr.this.fw.set(false);
                        return;
                    }
                    pr.this.x.pr("", "1", "", "");
                    if (iPr == 3) {
                        pr.this.hn.pr(new hn.pr() { // from class: com.byazt.lk.pr.1.1
                            @Override // com.byazt.mx.hn.pr
                            public void pr(Network network) {
                                if (network == null) {
                                    pr.this.x();
                                } else {
                                    pr.this.pr(network, (List<String>) arrayList);
                                }
                            }
                        });
                    } else {
                        pr.this.pr((Network) null, arrayList);
                    }
                }
                iPr = 0;
                pr.this.uc = false;
                strConcat = GlobalSetting.REWARD_VIDEO_AD;
                if (!TextUtils.isEmpty(strConcat)) {
                    pr.this.x.pr("", strConcat, "", "");
                    pr.this.fw.set(false);
                    return;
                }
                pr.this.x.pr("", "1", "", "");
                if (iPr == 3) {
                    pr.this.hn.pr(new hn.pr() { // from class: com.byazt.lk.pr.1.1
                        @Override // com.byazt.mx.hn.pr
                        public void pr(Network network) {
                            if (network == null) {
                                pr.this.x();
                            } else {
                                pr.this.pr(network, (List<String>) arrayList);
                            }
                        }
                    });
                } else {
                    pr.this.pr((Network) null, arrayList);
                }
            }
        });
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:53:0x010e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void pr(Network network, List<String> list) {
        String str;
        String str2;
        String str3;
        String str4;
        for (String str5 : list) {
            byte b = -1;
            try {
                switch (str5.hashCode()) {
                    case 15305274:
                        if (str5.equals("https://msg.cmpassport.com/h5/getMobile")) {
                            b = 0;
                        }
                        break;
                    case 899606572:
                        if (str5.equals("https://nisportal.10010.com:9001/api?appid=1554778161154")) {
                            b = 2;
                        }
                        break;
                    case 1964448447:
                        if (str5.equals("https://id6.me/gw/preuniq.do")) {
                            b = 1;
                        }
                        break;
                    default:
                        break;
                }
                String strPr = null;
                switch (b) {
                    case 0:
                        str = "1";
                        str2 = "0";
                        str3 = null;
                        str4 = str5;
                        strPr = com.byazt.mx.x.pr();
                        pr(network, str4, strPr, str, str2, str3);
                        if (TextUtils.isEmpty(this.x.hw()) || (!TextUtils.isEmpty(this.x.pr()) && !m.contains(this.x.pr()))) {
                            if (!TextUtils.isEmpty(this.x.pr()) && m.contains(this.x.pr())) {
                                this.uc = false;
                            }
                            x();
                        }
                        break;
                    case 1:
                        String strPr2 = c.pr(8);
                        String strPr3 = com.byazt.mx.x.pr(str5, strPr2);
                        str3 = strPr2;
                        str2 = "1";
                        str = GlobalSetting.SPLASH_AD;
                        str4 = strPr3;
                        pr(network, str4, strPr, str, str2, str3);
                        if (TextUtils.isEmpty(this.x.hw())) {
                        }
                        if (!TextUtils.isEmpty(this.x.pr())) {
                            this.uc = false;
                        }
                        x();
                        break;
                    case 2:
                        long j = this.w + 1;
                        this.w = j;
                        x xVar = this.c;
                        if (xVar != null) {
                            xVar.pr("uni_times", j);
                            if (this.w == 1) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                this.vk = jCurrentTimeMillis;
                                this.c.pr("uni_fir_ts", jCurrentTimeMillis);
                            }
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (ls.pr(jCurrentTimeMillis2, this.vk) && this.w >= 30 && jCurrentTimeMillis2 - this.k < 3000000) {
                            this.x.pr("2", GlobalSetting.UNIFIED_BANNER_AD, "", "2");
                        } else {
                            long jCurrentTimeMillis3 = System.currentTimeMillis();
                            this.k = jCurrentTimeMillis3;
                            x xVar2 = this.c;
                            if (xVar2 != null) {
                                xVar2.pr("uni_ts", jCurrentTimeMillis3);
                            }
                            str = "2";
                            str2 = str;
                            str3 = null;
                            str4 = str5;
                            pr(network, str4, strPr, str, str2, str3);
                            if (TextUtils.isEmpty(this.x.hw())) {
                            }
                            if (!TextUtils.isEmpty(this.x.pr())) {
                                this.uc = false;
                            }
                            x();
                        }
                        break;
                    default:
                        this.fw.set(false);
                        break;
                }
                return;
            } catch (Exception e) {
                this.x.pr("", GlobalSetting.NATIVE_UNIFIED_AD, "", "");
            }
        }
        if (!TextUtils.isEmpty(this.x.pr())) {
            this.uc = false;
        }
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.fw.set(false);
        this.hn.hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a0  */
    private void pr(Network network, String str, String str2, String str3, String str4, String str5) {
        String string;
        String strOptString;
        JSONObject jSONObjectPr = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : com.byazt.mx.hw.pr(network, str, str2);
        String str6 = "";
        if (jSONObjectPr == null) {
            this.x.pr(str4, GlobalSetting.NATIVE_UNIFIED_AD, "", str3);
            return;
        }
        try {
            switch (str3) {
                case "1":
                    JSONObject jSONObject = jSONObjectPr.getJSONObject("body");
                    String string2 = jSONObject.getString("resultCode");
                    if (!"103000".equals(string2)) {
                        string = "";
                        str6 = string2;
                        break;
                    } else {
                        string = jSONObject.getString("token");
                        str6 = "0";
                        break;
                    }
                    break;
                case "3":
                    String strValueOf = String.valueOf(jSONObjectPr.getInt("result"));
                    if (!"0".equals(strValueOf)) {
                        str6 = strValueOf;
                        string = "";
                        break;
                    } else {
                        string = new JSONObject(com.byazt.mx.pr.pr(false, c.pr(jSONObjectPr.getString("data")), str5)).getString("accessCode");
                        str6 = "0";
                        break;
                    }
                    break;
                case "2":
                    if (!jSONObjectPr.has(PluginConstants.KEY_ERROR_CODE)) {
                        strOptString = "";
                    } else {
                        strOptString = jSONObjectPr.optString(PluginConstants.KEY_ERROR_CODE);
                    }
                    if (!jSONObjectPr.has("authurl")) {
                        string = "";
                        str6 = strOptString;
                        break;
                    } else {
                        String string3 = jSONObjectPr.getString("authurl");
                        if (TextUtils.isEmpty(string3)) {
                            string = "";
                            str6 = strOptString;
                        } else {
                            Pair<String, String> pairPr = pr(network, string3 + "/api?appid=1554778161154", str3, str4);
                            if (pairPr.first != null) {
                                strOptString = (String) pairPr.first;
                            }
                            if (pairPr.second == null) {
                                string = "";
                                str6 = strOptString;
                            } else {
                                string = (String) pairPr.second;
                                str6 = strOptString;
                            }
                        }
                        break;
                    }
                    break;
                default:
                    string = "";
                    break;
            }
            this.x.pr(str4, str6, string, str3);
            if (this.c != null && !TextUtils.isEmpty(string)) {
                this.c.hn("vd", str4);
                this.c.hn("cr", str3);
                this.c.hn(NotificationCompat.CATEGORY_ERROR, str6);
                this.c.hn("tk", string);
            }
        } catch (Exception e) {
        }
    }

    private Pair<String, String> pr(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectPr = com.byazt.mx.hw.pr(network, str, null);
        String string2 = GlobalSetting.NATIVE_UNIFIED_AD;
        try {
            if (jSONObjectPr == null) {
                this.x.pr(str3, GlobalSetting.NATIVE_UNIFIED_AD, "", str2);
                return new Pair<>(GlobalSetting.NATIVE_UNIFIED_AD, "");
            }
            if (jSONObjectPr.has("err_code")) {
                string2 = jSONObjectPr.getString("err_code");
            }
            if (this.zo == null || System.currentTimeMillis() - this.aj > 3600000) {
                this.zo = a.hw(com.byazt.zb.pr.c());
                this.aj = System.currentTimeMillis();
            }
            String[] strArr = this.zo;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.x.pr(this.zo[1]);
            }
            if (jSONObjectPr.has("province")) {
                this.x.hw(jSONObjectPr.getString("province"));
            }
            if (!jSONObjectPr.has(PluginConstants.KEY_ERROR_CODE)) {
                string = "";
            } else {
                string2 = "0";
                string = jSONObjectPr.getString(PluginConstants.KEY_ERROR_CODE);
            }
            return new Pair<>(string2, string);
        } catch (Throwable th) {
            return new Pair<>(GlobalSetting.NATIVE_UNIFIED_AD, "");
        }
    }
}
