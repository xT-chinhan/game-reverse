package com.byazt.mv;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 701, 19})
public class n {
    public static final com.byazt.gwu.s n = com.byazt.lk.l.n(com.byazt.qt.n.d().oa(), "gm_tt_user_live_day_time");
    public static final SimpleDateFormat qg = new SimpleDateFormat("yyyy-MM-dd");
    public static final Calendar s = Calendar.getInstance();

    public static void n() {
        com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.byazt.qt.qg.n().b());
        if (com.byazt.qt.qg.n().b()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strX = x();
            com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(strX)));
            com.byazt.gwu.s sVar = n;
            if (sVar.getBoolean(strX, false)) {
                com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "key=" + strX + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(sVar.getString("start_index", null))) {
                sVar.n("start_index", strX);
                com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(strX)));
            }
            sVar.n(strX, true);
            sVar.n("user_live_times", sVar.getInt("user_live_times", 0) + 1);
            String string = sVar.getString("start_index", null);
            if (!TextUtils.equals(string, strX)) {
                try {
                    SimpleDateFormat simpleDateFormat = qg;
                    Date date = simpleDateFormat.parse(string);
                    Date date2 = simpleDateFormat.parse(strX);
                    if (date2 == null) {
                        date2 = new Date();
                    }
                    if (date != null) {
                        int iN = n(date.getTime(), date2.getTime());
                        int iKc = com.byazt.qt.qg.n().kc();
                        if (iKc - iN < 0) {
                            int i = iN - iKc;
                            String strN = n(date, i);
                            if (!TextUtils.isEmpty(strN)) {
                                sVar.n("start_index", strN);
                                n(string, date, i);
                            }
                            com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "old-startIndex:" + string + ",diff=" + i + ",new-startIndex:" + strN);
                        }
                    }
                } catch (ParseException e) {
                    com.byazt.rb.qg.q("AdLoadDynamicParamHandler", "计算生成日期出错：" + e.getMessage());
                }
            } else {
                com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "startDay:" + string + ",key=" + strX + "，同一天，不处理");
            }
            com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
    }

    private static void n(String str, Date date, int i) {
        if (i == 1) {
            com.byazt.gwu.s sVar = n;
            if (sVar.getBoolean(str, false)) {
                sVar.n("user_live_times", Math.max(sVar.getInt("user_live_times", 0) - 1, 0));
            }
            sVar.n(str);
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String strN = n(date, i2);
            com.byazt.gwu.s sVar2 = n;
            if (sVar2.getBoolean(strN, false)) {
                sVar2.n("user_live_times", Math.max(sVar2.getInt("user_live_times", 0) - 1, 0));
            }
            sVar2.n(strN);
        }
    }

    public static int qg() {
        if (com.byazt.qt.qg.n().b()) {
            return n.getInt("user_live_times", 0);
        }
        return -1;
    }

    public static void n(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return;
        }
        n(str, "_dislike_count_");
    }

    public static int qg(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return -1;
        }
        return rv(n.getString(qg(str, "_dislike_count_"), ""));
    }

    public static void s(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return;
        }
        n(str, "_show_count_");
    }

    public static int q(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return -1;
        }
        return rv(n.getString(qg(str, "_show_count_"), null));
    }

    public static void l(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return;
        }
        n(str, "_click_count_");
    }

    public static int w(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return -1;
        }
        return rv(n.getString(qg(str, "_click_count_"), null));
    }

    public static void s() {
        com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.byazt.qt.qg.n().b());
        if (com.byazt.qt.qg.n().b()) {
            n((String) null, "tt_sdk_start_count_");
        }
    }

    public static int q() {
        if (com.byazt.qt.qg.n().b()) {
            return rv(n.getString("tt_sdk_start_count_", null));
        }
        return -1;
    }

    public static void x(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return;
        }
        String strQg = qg(str, "_show_current_time_");
        String strQg2 = qg(str, "_show_last_time_");
        com.byazt.gwu.s sVar = n;
        String string = sVar.getString("_show_gap_time_day", null);
        String strX = x();
        com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + strQg + ",lastKey :" + strQg2 + ",today:" + strX + ",recordDate:" + string);
        if (!TextUtils.equals(string, strX)) {
            sVar.n(strQg2, 0L);
            sVar.n(strQg, System.currentTimeMillis());
            sVar.n("_show_gap_time_day", strX);
        } else {
            sVar.n(strQg2, sVar.getLong(strQg, 0L));
            sVar.n(strQg, System.currentTimeMillis());
        }
    }

    public static long fs(String str) {
        if (!com.byazt.qt.qg.n().b() || str == null) {
            return -1L;
        }
        String strQg = qg(str, "_show_current_time_");
        String strQg2 = qg(str, "_show_last_time_");
        com.byazt.gwu.s sVar = n;
        if (!TextUtils.equals(sVar.getString("_show_gap_time_day", null), x())) {
            return 0L;
        }
        long j = sVar.getLong(strQg2, 0L);
        if (j == 0) {
            return 0L;
        }
        long j2 = sVar.getLong(strQg, 0L) - j;
        if (j2 < 0) {
            return 0L;
        }
        return Math.round(j2 / 1000.0f);
    }

    public static int l() {
        if (com.byazt.qt.qg.n().b()) {
            return n(com.byazt.qt.n.d().s(), System.currentTimeMillis());
        }
        return -1;
    }

    public static long w() {
        if (!com.byazt.qt.qg.n().b()) {
            return -1L;
        }
        float fL = com.byazt.qt.n.d().l() / 60000.0f;
        if (fL <= 0.0f || fL >= 1.0f) {
            return Math.round(fL);
        }
        return 1L;
    }

    private static void n(String str, String str2) {
        String strQg = qg(str, str2);
        String strX = x();
        com.byazt.gwu.s sVar = n;
        String string = sVar.getString(strQg, null);
        com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction key:" + strQg + ",old value:" + string);
        int i = 1;
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split("_");
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(strX, str3)) {
                    i = 1 + Integer.parseInt(strArrSplit[1]);
                    strX = str3;
                }
                string = n(strX, i);
            }
            com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction key:" + strQg + "，new value：" + string);
            sVar.n(strQg, string);
            return;
        }
        sVar.n(strQg, n(strX, 1));
        com.byazt.rb.qg.qg("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction 首次记录 key:" + strQg + "，new value：" + n(strX, 1));
    }

    private static String n(String str, int i) {
        return str + "_" + i;
    }

    private static int rv(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 2 || (str2 = strArrSplit[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    private static int n(long j, long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Period.between(Instant.ofEpochMilli(j).atZone(ZoneOffset.systemDefault()).toLocalDate(), Instant.ofEpochMilli(j2).atZone(ZoneOffset.systemDefault()).toLocalDate()).getDays();
        }
        return (int) ((j2 - j) / 86400000);
    }

    private static String qg(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str + str2;
    }

    private static String x() {
        return qg.format(new Date());
    }

    private static String n(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar calendar = s;
        calendar.setTime(date);
        calendar.add(5, i);
        return qg.format(calendar.getTime());
    }

    public static void n(List<com.byazt.sg.s> list, com.byazt.ws.qg qgVar) {
        if (!com.byazt.qt.qg.n().b() || list == null || qgVar == null) {
            return;
        }
        for (com.byazt.sg.s sVar : list) {
            if (sVar != null) {
                sVar.bb().put(MediationConstant.KEY_GM_PRIME_RIT, qgVar.f());
            }
        }
    }
}
