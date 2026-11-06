package com.byazt.cby;

import android.text.TextUtils;
import com.anythink.core.common.b.e;
import com.anythink.core.common.d.i;
import com.anythink.core.common.q.g;
import com.anythink.core.e.d;
import com.anythink.core.e.j;
import com.byazt.qf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 19})
public abstract class n {
    public final Map<String, String> n = new HashMap();
    public final com.byazt.gwu.s qg;

    public static String n(int i) {
        switch (i) {
            case 1:
                return MediationConstant.RIT_TYPE_BANNER;
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
            case 4:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 5:
                return "native";
            case 6:
            default:
                return null;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return "fullscreenVideo";
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    public abstract Map<String, String> n();

    public abstract JSONObject n(com.byazt.ws.s sVar);

    public abstract void n(String str, int i, String str2);

    public abstract void n(String str, String str2);

    public abstract boolean qg(String str, JSONObject jSONObject, Map<String, Object> map);

    public n(String str) {
        this.qg = com.byazt.lk.l.n(com.byazt.qt.n.d().oa(), str);
        s();
    }

    public void n(int i, String str, int i2, double d) {
        if (i2 == 1) {
            n(i, str, d);
        } else if (i2 == 3) {
            qg(i, str, d);
        } else if (i2 == 2) {
            s(i, str, d);
        }
    }

    public double n(int i, String str, int i2) {
        if (i2 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(n(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(qg(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(s(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    public void n(double d, double d2, String str, String str2) {
        if (this.qg == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        n(str, "_last_post_cpm_", str2, d);
        n(str, "_last_bidding_cpm_", str2, d2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0095  */
    /* JADX WARN: Code duplicated, block: B:27:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:41:0x0106  */
    /* JADX WARN: Code duplicated, block: B:70:0x0144  */
    public double[] n(int i, double d, double d2, String str, String str2) {
        double dDoubleValue;
        double dDoubleValue2;
        double dDoubleValue3;
        int i2;
        int i3;
        String string = this.qg.getString(str2 + "_last_post_cpm_", "");
        String string2 = this.qg.getString(str2 + "_last_load_cpm_", "");
        String string3 = this.qg.getString(str2 + "_last_bidding_cpm_", "");
        if (TextUtils.isEmpty(string)) {
            dDoubleValue = 0.0d;
        } else {
            String[] strArrSplit = string.split("_");
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (TextUtils.isEmpty(str3) || !TextUtils.equals(str3, str)) {
                    dDoubleValue = 0.0d;
                } else {
                    String str4 = strArrSplit[1];
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "0";
                    }
                    dDoubleValue = BigDecimal.valueOf(Double.parseDouble(str4)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue = 0.0d;
            }
        }
        if (TextUtils.isEmpty(string2)) {
            dDoubleValue2 = 0.0d;
        } else {
            String[] strArrSplit2 = string2.split("_");
            if (strArrSplit2.length == 2) {
                String str5 = strArrSplit2[0];
                if (TextUtils.isEmpty(str5) || !TextUtils.equals(str5, str)) {
                    dDoubleValue2 = 0.0d;
                } else {
                    String str6 = strArrSplit2[1];
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "0";
                    }
                    dDoubleValue2 = BigDecimal.valueOf(Double.parseDouble(str6)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue2 = 0.0d;
            }
        }
        if (TextUtils.isEmpty(string3)) {
            dDoubleValue3 = 0.0d;
        } else {
            String[] strArrSplit3 = string3.split("_");
            if (strArrSplit3.length == 2) {
                String str7 = strArrSplit3[0];
                if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, str)) {
                    dDoubleValue3 = 0.0d;
                } else {
                    String str8 = strArrSplit3[1];
                    dDoubleValue3 = BigDecimal.valueOf(Double.parseDouble(TextUtils.isEmpty(str8) ? "0" : str8)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue3 = 0.0d;
            }
        }
        if (d == 0.0d && dDoubleValue == 0.0d && dDoubleValue2 == 0.0d && d2 == 0.0d && dDoubleValue3 == 0.0d) {
            return new double[]{0.0d, 0.0d};
        }
        if (d != 0.0d) {
            dDoubleValue = d;
            i2 = 2;
        } else {
            i2 = 3;
        }
        if (d2 != 0.0d) {
            dDoubleValue3 = d2;
            i3 = 5;
        } else {
            i3 = 4;
        }
        if (dDoubleValue >= dDoubleValue2) {
            if (dDoubleValue >= dDoubleValue3) {
                dDoubleValue2 = dDoubleValue;
            } else {
                dDoubleValue2 = dDoubleValue3;
                i2 = i3;
            }
        } else if (dDoubleValue2 > dDoubleValue3) {
            i2 = 1;
        } else {
            dDoubleValue2 = dDoubleValue3;
            i2 = i3;
        }
        if (i == 3 && i2 == 3) {
            i2 = 2;
        }
        return new double[]{dDoubleValue2, (i == 3 && i2 == 4) ? 5 : i2};
    }

    public void n(String str, String str2, String str3, double d) {
        this.qg.n(str + str2, str3 + "_" + d);
    }

    public void qg() {
        Map all = this.qg.getAll();
        if (all != null) {
            for (Map.Entry entry : all.entrySet()) {
                if (entry != null) {
                    n(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    private synchronized void n(int i, String str, double d) {
        String str2 = "label_size_" + str;
        int i2 = this.qg.getInt(str2, 0) + 1;
        String strN = n(str, i2);
        String strN2 = n(str, d);
        n(strN, i, strN2);
        this.qg.n(strN, strN2);
        this.qg.n(str2, i2);
    }

    private String n(int i, String str) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return "0";
        }
        double[] dArr = new double[2];
        Iterator<Map.Entry<String, String>> it = n().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next != null) {
                String value = next.getValue();
                if (!TextUtils.isEmpty(value) && value.contains(str)) {
                    String[] strArrSplit = value.split("_");
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    String str4 = strArrSplit[2];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (com.byazt.qt.qg.n().n(System.currentTimeMillis() - Long.parseLong(str4))) {
                            dArr[0] = dArr[0] + 1.0d;
                            dArr[1] = dArr[1] + Double.parseDouble(str3);
                        } else {
                            it.remove();
                            this.qg.n(next.getKey());
                            String str5 = "label_size_" + str;
                            int i2 = this.qg.getInt(str5, 0);
                            if (i2 > 0) {
                                this.qg.n(str5, i2 - 1);
                            }
                        }
                    }
                }
            }
        }
        return n(dArr);
    }

    private void qg(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.qg.n(str, d + "_" + System.currentTimeMillis());
        n(str);
    }

    public void n(String str) {
        for (int i = this.qg.getInt("label_size_" + str, 0); i > 0; i--) {
            try {
                String strN = n(str, i);
                this.qg.n(strN);
                n().remove(strN);
            } catch (Throwable th) {
                com.byazt.rb.qg.q("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String n(String str, int i) {
        return "cpm_key_" + str + "_" + i;
    }

    private String qg(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String string = this.qg.getString(str, null);
            if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                String[] strArrSplit = string.split("_");
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.byazt.qt.qg.n().n(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.qg.n(str);
                }
            }
        }
        return "0";
    }

    private String n(String str, double d) {
        return str + "_" + d + "_" + System.currentTimeMillis();
    }

    private void s(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.qg.n(str, d + "_" + System.currentTimeMillis());
        n(str);
    }

    private String s(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String string = this.qg.getString(str, null);
            if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                String[] strArrSplit = string.split("_");
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.byazt.qt.qg.n().n(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.qg.n(str);
                        } catch (NumberFormatException unused) {
                            this.qg.n(str);
                            x.n("自定义上报 saveTime format exception valueTimestamp " + string);
                        }
                    } else {
                        this.qg.n(str);
                        x.n("自定义上报 saveTime is not number valueTimestamp " + string);
                    }
                }
            }
        }
        return "0";
    }

    public String n(double[] dArr) {
        double d = dArr[0];
        return d != 0.0d ? new BigDecimal(dArr[1] / d).setScale(2, RoundingMode.HALF_UP).toString() : "-1.0";
    }

    public void s() {
        this.n.put("0", "a");
        this.n.put("1", "b");
        this.n.put("2", "c");
        this.n.put("3", d.a);
        this.n.put("4", e.a);
        this.n.put("5", "f");
        this.n.put("6", g.a);
        this.n.put("7", "h");
        this.n.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "i");
        this.n.put(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, j.a);
        this.n.put(i.E, "k");
    }

    public String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(this.n.get(String.valueOf(c)));
        }
        return sb.toString();
    }

    public void n(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.byazt.qt.qg.n().ci() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (qg(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException unused) {
            }
        }
    }
}
