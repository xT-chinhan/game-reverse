package com.bytedance.sdk.openadsdk.core.pc;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.res.image.c;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.ah.d;
import com.bytedance.sdk.openadsdk.core.i.xr;
import com.bytedance.sdk.openadsdk.core.jw.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.vy;
import com.bytedance.sdk.openadsdk.core.pc.ms.ah;
import com.bytedance.sdk.openadsdk.core.pc.ms.ka;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3270ms;
    private static final List<String> zb = Arrays.asList(c.b, "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");
    private final ah ah;
    private final vy d;
    private final d ka;
    private String[] x;
    private final Context xr;
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private long ny = 0;
    private long ch = 0;
    private long hi = 0;
    private long sl = 0;
    private boolean c = true;

    private ms(Context context) {
        this.xr = context;
        this.ah = ah.ms(context);
        d dVarMs = d.ms();
        this.ka = dVarMs;
        if (dVarMs != null) {
            String strAh = dVarMs.ah("cr", 3300000L);
            if (!TextUtils.isEmpty(strAh)) {
                this.d = new vy(dVarMs.ah("vd", ms(strAh)), dVarMs.ah(NotificationCompat.CATEGORY_ERROR, ms(strAh)), dVarMs.ah("tk", ms(strAh)), dVarMs.ah("cr", ms(strAh)));
            } else {
                this.d = new vy("", "", "", "");
            }
            ah();
            return;
        }
        this.d = new vy("", "-1", "", "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private long ms(String str) {
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

    private boolean xr() {
        d dVar = this.ka;
        if (dVar != null) {
            String strAh = dVar.ah("cr", 3300000L);
            if (!TextUtils.isEmpty(strAh) && !TextUtils.isEmpty(this.ka.ah("tk", ms(strAh)))) {
                return true;
            }
        }
        return false;
    }

    private void ah() {
        d dVar = this.ka;
        if (dVar != null) {
            this.ch = dVar.xr("uni_fir_ts", 0L);
            if (f.ms(System.currentTimeMillis(), this.ch)) {
                this.hi = this.ka.xr("uni_times", 0L);
                this.sl = this.ka.xr("uni_ts", 0L);
            } else {
                this.hi = 0L;
                this.sl = 0L;
            }
        }
    }

    public static ms ms(Context context) {
        if (f3270ms == null) {
            synchronized (ms.class) {
                if (f3270ms == null) {
                    f3270ms = new ms(context);
                }
            }
        }
        return f3270ms;
    }

    public vy ms() {
        if (xr() || !this.c) {
            return this.d;
        }
        if (!this.ab.compareAndSet(false, true)) {
            return this.d;
        }
        x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.ms.1
            /* JADX WARN: Code duplicated, block: B:53:0x00cf  */
            /* JADX WARN: Code duplicated, block: B:55:0x00e2  */
            /* JADX WARN: Code duplicated, block: B:57:0x00ed  */
            /* JADX WARN: Code duplicated, block: B:59:0x00fc  */
            @Override // java.lang.Runnable
            public void run() {
                int iMs;
                String strConcat;
                final ArrayList arrayList = new ArrayList();
                byte b = -1;
                if (xr.ms(ms.this.xr, g.b) != -1) {
                    iMs = ms.this.ah.ms();
                    if (iMs != 3 || xr.ms(ms.this.xr, "android.permission.CHANGE_NETWORK_STATE") != -1) {
                        if (iMs != 3 && iMs != 2) {
                            strConcat = "4".concat(String.valueOf(iMs));
                        } else {
                            String strMs = ka.ms();
                            strMs.hashCode();
                            switch (strMs.hashCode()) {
                                case 48:
                                    if (strMs.equals("0")) {
                                        b = 0;
                                    }
                                    break;
                                case 49:
                                    if (strMs.equals("1")) {
                                        b = 1;
                                    }
                                    break;
                                case 50:
                                    if (strMs.equals("2")) {
                                        b = 2;
                                    }
                                    break;
                                case 51:
                                    if (strMs.equals("3")) {
                                        b = 3;
                                    }
                                    break;
                                case 52:
                                    if (strMs.equals("4")) {
                                        b = 4;
                                    }
                                    break;
                                case 54:
                                    if (strMs.equals("6")) {
                                        b = 5;
                                    }
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    ms.this.c = false;
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
                                    ms.this.c = false;
                                    strConcat = "2";
                                    break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        ms.this.d.ms("", strConcat, "", "");
                        ms.this.ab.set(false);
                        return;
                    }
                    ms.this.d.ms("", "1", "", "");
                    if (iMs == 3) {
                        ms.this.ah.ms(new ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.pc.ms.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.pc.ms.ah.ms
                            public void ms(Network network) {
                                if (network == null) {
                                    ms.this.d();
                                } else {
                                    ms.this.ms(network, (List<String>) arrayList);
                                }
                            }
                        });
                    } else {
                        ms.this.ms((Network) null, arrayList);
                    }
                }
                iMs = 0;
                ms.this.c = false;
                strConcat = "5";
                if (!TextUtils.isEmpty(strConcat)) {
                    ms.this.d.ms("", strConcat, "", "");
                    ms.this.ab.set(false);
                    return;
                }
                ms.this.d.ms("", "1", "", "");
                if (iMs == 3) {
                    ms.this.ah.ms(new ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.pc.ms.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.pc.ms.ah.ms
                        public void ms(Network network) {
                            if (network == null) {
                                ms.this.d();
                            } else {
                                ms.this.ms(network, (List<String>) arrayList);
                            }
                        }
                    });
                } else {
                    ms.this.ms((Network) null, arrayList);
                }
            }
        });
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    public void ms(Network network, List<String> list) {
        byte b;
        String str;
        String str2;
        String strMs;
        String str3;
        String strMs2;
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
                    strMs = str4;
                    str3 = "0";
                    strMs2 = com.bytedance.sdk.openadsdk.core.pc.ms.d.ms();
                } else if (b == 1) {
                    String strMs3 = com.bytedance.sdk.component.utils.ms.ms(8);
                    str2 = strMs3;
                    str = "3";
                    strMs2 = null;
                    str3 = "1";
                    strMs = com.bytedance.sdk.openadsdk.core.pc.ms.d.ms(str4, strMs3);
                } else if (b == 2) {
                    long j = this.hi + 1;
                    this.hi = j;
                    d dVar = this.ka;
                    if (dVar != null) {
                        dVar.ms("uni_times", j);
                        if (this.hi == 1) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            this.ch = jCurrentTimeMillis;
                            this.ka.ms("uni_fir_ts", jCurrentTimeMillis);
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    str = "2";
                    if (f.ms(jCurrentTimeMillis2, this.ch) && this.hi >= 30 && jCurrentTimeMillis2 - this.sl < 3000000) {
                        this.d.ms("2", "7", "", "2");
                    } else {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        this.sl = jCurrentTimeMillis3;
                        d dVar2 = this.ka;
                        if (dVar2 != null) {
                            dVar2.ms("uni_ts", jCurrentTimeMillis3);
                        }
                        strMs = str4;
                        strMs2 = null;
                        str2 = null;
                        str3 = "2";
                    }
                } else {
                    this.ab.set(false);
                    return;
                }
                ms(network, strMs, strMs2, str, str3, str2);
            } catch (Exception unused) {
                this.d.ms("", "6", "", "");
            }
            if (!TextUtils.isEmpty(this.d.xr()) || (!TextUtils.isEmpty(this.d.ms()) && !zb.contains(this.d.ms()))) {
                break;
            }
        }
        if (!TextUtils.isEmpty(this.d.ms()) && zb.contains(this.d.ms())) {
            this.c = false;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.ab.set(false);
        this.ah.xr();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void ms(Network network, String str, String str2, String str3, String str4, String str5) {
        byte b;
        String str6;
        String string;
        JSONObject jSONObjectMs = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : com.bytedance.sdk.openadsdk.core.pc.ms.xr.ms(network, str, str2);
        String str7 = "";
        if (jSONObjectMs == null) {
            this.d.ms(str4, "6", "", str3);
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
                JSONObject jSONObject = jSONObjectMs.getJSONObject("body");
                String string2 = jSONObject.getString("resultCode");
                if ("103000".equals(string2)) {
                    string = jSONObject.getString("token");
                    str6 = string;
                    str7 = "0";
                } else {
                    str6 = "";
                    str7 = string2;
                }
            } else if (b == 1) {
                String strValueOf = String.valueOf(jSONObjectMs.getInt("result"));
                if ("0".equals(strValueOf)) {
                    string = new JSONObject(com.bytedance.sdk.openadsdk.core.pc.ms.ms.ms(false, com.bytedance.sdk.component.utils.ka.ms(jSONObjectMs.getString("data")), str5)).getString("accessCode");
                    str6 = string;
                    str7 = "0";
                } else {
                    str7 = strValueOf;
                    str6 = "";
                }
            } else if (b != 2) {
                str6 = "";
            } else {
                String strOptString = jSONObjectMs.has("code") ? jSONObjectMs.optString("code") : "";
                if (jSONObjectMs.has("authurl")) {
                    String string3 = jSONObjectMs.getString("authurl");
                    if (!TextUtils.isEmpty(string3)) {
                        Pair<String, String> pairMs = ms(network, string3 + "/api?appid=1554778161154", str3, str4);
                        if (pairMs.first != null) {
                            strOptString = (String) pairMs.first;
                        }
                        if (pairMs.second != null) {
                            str7 = (String) pairMs.second;
                        }
                    }
                }
                str6 = str7;
                str7 = strOptString;
            }
            this.d.ms(str4, str7, str6, str3);
            if (this.ka == null || TextUtils.isEmpty(str6)) {
                return;
            }
            this.ka.d("vd", str4);
            this.ka.d("cr", str3);
            this.ka.d(NotificationCompat.CATEGORY_ERROR, str7);
            this.ka.d("tk", str6);
        } catch (Exception unused) {
        }
    }

    private Pair<String, String> ms(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.pc.ms.xr.ms(network, str, null);
        try {
            if (jSONObjectMs == null) {
                this.d.ms(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string2 = jSONObjectMs.has("err_code") ? jSONObjectMs.getString("err_code") : "6";
            if (this.x == null || System.currentTimeMillis() - this.ny > 3600000) {
                this.x = ch.ny();
                this.ny = System.currentTimeMillis();
            }
            String[] strArr = this.x;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.d.ms(this.x[1]);
            }
            if (jSONObjectMs.has("province")) {
                this.d.xr(jSONObjectMs.getString("province"));
            }
            if (jSONObjectMs.has("code")) {
                string2 = "0";
                string = jSONObjectMs.getString("code");
            } else {
                string = "";
            }
            return new Pair<>(string2, string);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
