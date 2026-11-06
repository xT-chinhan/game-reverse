package com.byazt.nn;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.fi.BaseConstants;
import com.byazt.hcx.aj;
import com.byazt.mg.PluginConstants;
import com.byazt.vkw.gz;
import com.byazt.vkw.k;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 938, 121})
public class x {
    public static final LinkedList<String> pr = new LinkedList<>();
    public static final LinkedList<String> hw = new LinkedList<>();
    public static final LinkedList<String> hn = new LinkedList<>();
    public static final LinkedList<String> x = new LinkedList<>();
    public static final Map<String, Integer> c = new HashMap();
    public static String uc = "upload_init";
    public static int fw = 0;
    public static int zo = 0;
    public static AtomicLong aj = new AtomicLong();
    public static AtomicLong vk = new AtomicLong();

    public static synchronized int pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, Integer> map = c;
            Integer num = map.get(str);
            if (num != null) {
                int iIntValue = num.intValue() + 1;
                map.put(str, Integer.valueOf(iIntValue));
                return iIntValue;
            }
            map.put(str, 1);
            return 1;
        }
        return 0;
    }

    public static boolean pr() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static synchronized String hw(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = pr;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String fw(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = hw;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    public static void pr(String str, JSONObject jSONObject, Throwable th, com.byazt.hh.hw hwVar) {
        com.byazt.hh.hn hnVarPr;
        if (hwVar != null && (hnVarPr = hwVar.pr()) != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", "exception");
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                if (th != null) {
                    jSONObject2.putOpt("exception", Log.getStackTraceString(th));
                }
            } catch (Exception e) {
            }
            hnVarPr.pr(jSONObject2);
        }
    }

    private static synchronized String zo(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = hn;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
        sb = new StringBuilder();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized String hn() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = x.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized void aj(String str) {
        LinkedList<String> linkedList = x;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
    }

    public static String pr(com.byazt.hh.pr prVar) {
        JSONObject jSONObjectPr;
        if (x(prVar) && (jSONObjectPr = prVar.pr()) != null && TextUtils.isEmpty(jSONObjectPr.optString("label"))) {
            return jSONObjectPr.optString(NotificationCompat.CATEGORY_EVENT);
        }
        return null;
    }

    public static void pr(List<com.byazt.hh.pr> list, String str) {
        com.byazt.hh.pr prVar;
        JSONObject jSONObjectPr;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPr2;
        if (list == null) {
        }
        try {
            if (list.isEmpty() || (prVar = list.get(0)) == null) {
                return;
            }
            switch (prVar.w()) {
                case 0:
                    long jIncrementAndGet = aj.incrementAndGet();
                    for (com.byazt.hh.pr prVar2 : list) {
                        if (prVar2 != null && (jSONObjectPr = prVar2.pr()) != null && (jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("params")) != null) {
                            String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (!TextUtils.isEmpty(strOptString)) {
                                jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, pr(strOptString, jIncrementAndGet));
                            }
                        }
                    }
                    break;
                case 1:
                    long jIncrementAndGet2 = vk.incrementAndGet();
                    for (com.byazt.hh.pr prVar3 : list) {
                        if (prVar3 != null && (jSONObjectPr2 = prVar3.pr()) != null) {
                            String strOptString2 = jSONObjectPr2.optString("event_extra");
                            if (!TextUtils.isEmpty(strOptString2)) {
                                jSONObjectPr2.put("event_extra", pr(strOptString2, jIncrementAndGet2));
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (Throwable th) {
        }
    }

    private static String pr(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("upload_count", j);
            jSONObject.put("upload_ts", System.currentTimeMillis());
            return jSONObject.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static boolean hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        switch (str) {
            case "loghighpriority":
            case "adevent":
            case "adevent_applog":
                return true;
            default:
                return false;
        }
    }

    public static aj x(String str) {
        return c(str).pr(1);
    }

    public static aj c(String str) {
        return ((gz) com.byazt.zs.uc.pr("net")).pr().pr(str);
    }

    public static aj uc(String str) {
        return c(str).pr(2);
    }

    public static String pr(JSONObject jSONObject) {
        return hw(hn(jSONObject));
    }

    public static String hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("rit");
    }

    public static JSONObject hn(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("log_extra");
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                return new JSONObject(strOptString);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static String x(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("req_id");
        }
        return null;
    }

    public static String hw(com.byazt.hh.pr prVar) {
        JSONObject jSONObjectOptJSONObject;
        if (prVar == null || prVar.pr() == null || uc(prVar) || (jSONObjectOptJSONObject = prVar.pr().optJSONObject("params")) == null) {
            return null;
        }
        try {
            return x(new JSONObject(jSONObjectOptJSONObject.optString("log_extra")));
        } catch (Exception e) {
            return null;
        }
    }

    public static void pr(List<com.byazt.hh.pr> list, k kVar) {
        try {
            if (kVar.zo()) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                for (com.byazt.hh.pr prVar : list) {
                    if (prVar != null) {
                        if (prVar.aj() <= 1) {
                            i++;
                        }
                        String strPr = pr(prVar);
                        if (TextUtils.equals("show", strPr)) {
                            if (prVar.aj() <= 1) {
                                i3++;
                            } else {
                                i2++;
                            }
                        }
                        if (TextUtils.equals("click", strPr)) {
                            if (prVar.aj() <= 1) {
                                i5++;
                            } else {
                                i4++;
                            }
                        }
                        if (prVar.zo() != 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - prVar.zo();
                            com.byazt.kbl.hn.pr.zo().incrementAndGet();
                            com.byazt.kbl.hn.pr.m().getAndAdd(jCurrentTimeMillis);
                        }
                        pr(prVar, kVar);
                    }
                }
                com.byazt.kbl.hn.pr.vk().getAndAdd(list.size());
                com.byazt.kbl.hn.pr.iu().getAndAdd(i);
                com.byazt.kbl.hn.pr.ve().getAndAdd(i2);
                com.byazt.kbl.hn.pr.gz().getAndAdd(i3);
                com.byazt.kbl.hn.pr.y().getAndAdd(i4);
                com.byazt.kbl.hn.pr.ww().getAndAdd(i5);
            }
        } catch (Exception e) {
        }
    }

    public static void pr(com.byazt.hh.pr prVar, k kVar) {
        try {
            if (prVar.w() == 0 && kVar.uc()) {
                JSONObject jSONObjectPr = prVar.pr();
                String strPr = pr(prVar);
                if (TextUtils.isEmpty(strPr)) {
                    return;
                }
                String strOptString = jSONObjectPr.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("will_send_labels"))) {
                        jSONObject.put("will_send_labels", zo(strPr));
                        jSONObject.put("send_success_valid_labels", hn());
                    }
                    jSONObjectPr.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("will_send_labels", zo(strPr));
                jSONObject2.put("send_success_valid_labels", hn());
                jSONObjectPr.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception e) {
        }
    }

    public static void hw(com.byazt.hh.pr prVar, k kVar) {
        if (kVar == null || !kVar.zo()) {
            return;
        }
        try {
            com.byazt.kbl.hn.pr.pr(System.currentTimeMillis() - prVar.fw(), prVar);
            prVar.pr(System.currentTimeMillis());
            if (prVar.w() == 0 && kVar.uc()) {
                String strPr = pr(prVar);
                if (TextUtils.isEmpty(strPr)) {
                    return;
                }
                JSONObject jSONObjectPr = prVar.pr();
                String strOptString = prVar.pr().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("save_success_labels"))) {
                        jSONObject.put("save_success_labels", fw(strPr));
                    }
                    jSONObjectPr.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_success_labels", fw(strPr));
                jSONObjectPr.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception e) {
        }
    }

    public static boolean pr(List<com.byazt.hh.pr> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return uc(list.get(0));
    }

    public static void pr(JSONObject jSONObject, com.byazt.yt.x xVar, com.byazt.hh.hw hwVar, int i, boolean z) {
        if (hwVar == null || jSONObject == null) {
            fw.x("query error");
        }
    }

    private static int hn(List<com.byazt.hh.pr> list, String str) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        for (com.byazt.hh.pr prVar : list) {
            if (prVar != null && TextUtils.equals(pr(prVar), str)) {
                i++;
            }
        }
        return i;
    }

    public static void pr(List<com.byazt.hh.pr> list, int i, String str) {
    }

    public static boolean pr(int i) {
        return i == 72 || i == 71;
    }

    public static boolean hn(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 0 && prVar.k() == 1;
    }

    public static boolean hw(List<com.byazt.hh.pr> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        return x(list.get(0));
    }

    public static boolean x(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 0;
    }

    public static boolean c(com.byazt.hh.pr prVar) {
        return x(prVar) || uc(prVar);
    }

    public static boolean uc(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 3 && prVar.k() == 2;
    }

    public static boolean fw(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 0 && prVar.k() == 2;
    }

    public static boolean zo(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 1 && prVar.k() == 2;
    }

    public static boolean aj(com.byazt.hh.pr prVar) {
        return prVar != null && prVar.w() == 1 && prVar.k() == 3;
    }

    public static String hw(int i) {
        switch (i) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return "default";
            case 76:
                return "empty message";
            case 77:
                return "net error";
            case 78:
                return "direct upload";
        }
    }

    private static void pr(com.byazt.hh.pr prVar, String str, k kVar) {
        String strPr = pr(prVar);
        if (TextUtils.isEmpty(strPr)) {
            return;
        }
        String strHw = hw(prVar);
        if (prVar.w() == 0 && kVar.uc()) {
            aj(strPr + "_" + strHw + "_" + str);
        }
    }

    public static void pr(boolean z, int i, String str, String str2, int i2, String str3, k kVar, String str4) {
        fw++;
        if (z) {
            zo++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", zo);
            jSONObject.put("acnt", fw);
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            if (kVar != null) {
                jSONObject.put(BreakpointSQLiteKey.URL, kVar.hw());
            } else {
                jSONObject.put(BreakpointSQLiteKey.URL, "emptyurl");
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("ip", str4);
            }
            uc = jSONObject.toString();
        } catch (Exception e) {
            uc = "unknown_json";
        }
    }

    public static String hw() {
        return uc;
    }

    public static void pr(com.byazt.hh.pr prVar, String str) {
        uc(prVar);
    }

    public static void hw(List<com.byazt.hh.pr> list, String str) {
    }

    public static void pr(int i, List<com.byazt.hh.pr> list, long j, com.byazt.hh.hw hwVar, com.byazt.mqu.pr prVar, com.byazt.ie.hw hwVar2) {
        com.byazt.hh.pr prVar2;
        if (hwVar != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                fw.pr("uploadCost:" + jCurrentTimeMillis);
                if (i == 200) {
                    com.byazt.kbl.hn.pr.fo().getAndAdd(jCurrentTimeMillis);
                    com.byazt.kbl.hn.pr.cz().incrementAndGet();
                    com.byazt.kbl.hn.pr.lb().getAndAdd(list.size());
                    com.byazt.kbl.hn.pr.nl().getAndAdd(hn(list, "show"));
                    com.byazt.kbl.hn.pr.n().getAndAdd(hn(list, "click"));
                    com.byazt.kbl.hn.pr.c().getAndAdd(list.size());
                    return;
                }
                fw.x("-------AdThread code is " + i + " error  ------------");
                byte bW = -1;
                if (i == -1) {
                    com.byazt.kbl.hn.pr.qa().getAndAdd(list.size());
                } else {
                    com.byazt.kbl.hn.pr.fw().getAndAdd(list.size());
                }
                com.byazt.kbl.hn.pr.rc().getAndAdd(jCurrentTimeMillis);
                com.byazt.kbl.hn.pr.ny().incrementAndGet();
                if (!list.isEmpty() && (prVar2 = list.get(0)) != null) {
                    bW = prVar2.w();
                }
                if (prVar == null) {
                    com.byazt.kbl.hn.pr.z().append((int) bW).append("_").append(i).append(" ");
                } else {
                    com.byazt.kbl.hn.pr.z().append((int) bW).append("_").append(prVar.x()).append("_").append(prVar.hw()).append("_").append(prVar.hn()).append(" ");
                }
                if (hwVar2 != null) {
                    com.byazt.kbl.hn.pr.b().append((int) bW).append("_").append(hwVar2.pr()).append("_").append(hwVar2.hw());
                } else {
                    com.byazt.kbl.hn.pr.b().append((int) bW).append("_ok");
                }
            } catch (Exception e) {
                fw.pr("result", e);
            }
        }
    }

    public static int hn(List<com.byazt.hh.pr> list) {
        JSONObject jSONObjectPr;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.byazt.hh.pr prVar = list.get(0);
                if (prVar != null && prVar.k() == 1 && (jSONObjectPr = prVar.pr()) != null && prVar.w() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectPr.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectPr.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectPr.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                            jSONObjectPr.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable th) {
            }
        }
        return 0;
    }

    public static void pr(List<com.byazt.hh.pr> list, String str, k kVar) {
        try {
            if (kVar.zo() && list != null && kVar.uc()) {
                for (com.byazt.hh.pr prVar : list) {
                    if (prVar != null) {
                        pr(prVar, str, kVar);
                    }
                }
            }
        } catch (Exception e) {
            fw.x("logId", e.getMessage());
        }
    }

    public static JSONObject vk(com.byazt.hh.pr prVar) {
        JSONObject jSONObjectOptJSONObject;
        if (prVar == null || prVar.pr() == null || !x(prVar) || (jSONObjectOptJSONObject = prVar.pr().optJSONObject("params")) == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
        } catch (JSONException e) {
            return null;
        }
    }
}
