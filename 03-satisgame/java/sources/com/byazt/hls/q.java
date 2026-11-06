package com.byazt.hls;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.byazt.ho.BaseConstants;
import com.byazt.qk.rv;
import com.byazt.vf.bb;
import com.byazt.vf.cp;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 5})
public class q {
    public static final LinkedList<String> n = new LinkedList<>();
    public static final LinkedList<String> qg = new LinkedList<>();
    public static final LinkedList<String> s = new LinkedList<>();
    public static final LinkedList<String> q = new LinkedList<>();
    public static final Map<String, Integer> l = new HashMap();
    public static String w = "upload_init";
    public static int x = 0;
    public static int fs = 0;
    public static AtomicLong rv = new AtomicLong();
    public static AtomicLong tj = new AtomicLong();

    public static void n(List<com.byazt.vr.n> list, int i, String str) {
    }

    public static boolean n(int i) {
        return i == 72 || i == 71;
    }

    public static String qg(int i) {
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

    public static void qg(List<com.byazt.vr.n> list, String str) {
    }

    public static synchronized int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = l;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static boolean n() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized String qg(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = n;
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

    private static synchronized String x(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = qg;
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

    public static void n(String str, JSONObject jSONObject, Throwable th, com.byazt.vr.qg qgVar) {
        com.byazt.vr.s sVarN;
        if (qgVar == null || (sVarN = qgVar.n()) == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "exception");
            jSONObject2.putOpt("scene", str);
            jSONObject2.putOpt("object", jSONObject);
            if (th != null) {
                jSONObject2.putOpt("exception", Log.getStackTraceString(th));
            }
        } catch (Exception unused) {
        }
        sVarN.n(jSONObject2);
    }

    private static synchronized String fs(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = s;
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

    private static synchronized String s() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = q.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized void rv(String str) {
        LinkedList<String> linkedList = q;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
    }

    public static String n(com.byazt.vr.n nVar) {
        JSONObject jSONObjectN;
        if (q(nVar) && (jSONObjectN = nVar.n()) != null && TextUtils.isEmpty(jSONObjectN.optString("label"))) {
            return jSONObjectN.optString(NotificationCompat.CATEGORY_EVENT);
        }
        return null;
    }

    public static void n(List<com.byazt.vr.n> list, String str) {
        com.byazt.vr.n nVar;
        JSONObject jSONObjectN;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectN2;
        if (list != null) {
            try {
                if (list.isEmpty() || (nVar = list.get(0)) == null) {
                    return;
                }
                byte bCp = nVar.cp();
                if (bCp == 0) {
                    long jIncrementAndGet = rv.incrementAndGet();
                    for (com.byazt.vr.n nVar2 : list) {
                        if (nVar2 != null && (jSONObjectN = nVar2.n()) != null && (jSONObjectOptJSONObject = jSONObjectN.optJSONObject("params")) != null) {
                            String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (!TextUtils.isEmpty(strOptString)) {
                                jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, n(strOptString, jIncrementAndGet));
                            }
                        }
                    }
                    return;
                }
                if (bCp != 1) {
                    return;
                }
                long jIncrementAndGet2 = tj.incrementAndGet();
                for (com.byazt.vr.n nVar3 : list) {
                    if (nVar3 != null && (jSONObjectN2 = nVar3.n()) != null) {
                        String strOptString2 = jSONObjectN2.optString("event_extra");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            jSONObjectN2.put("event_extra", n(strOptString2, jIncrementAndGet2));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String n(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("upload_count", j);
            jSONObject.put("upload_ts", System.currentTimeMillis());
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "adevent":
            case "adevent_applog":
            case "loghighpriority":
                return true;
            default:
                return false;
        }
    }

    public static rv q(String str) {
        return l(str).n(1);
    }

    public static rv l(String str) {
        return ((bb) com.byazt.qp.q.n("net")).n().n(str);
    }

    public static rv w(String str) {
        return l(str).n(2);
    }

    public static String n(JSONObject jSONObject) {
        return qg(s(jSONObject));
    }

    public static String qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("rit");
    }

    public static JSONObject s(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("log_extra");
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                return new JSONObject(strOptString);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static String q(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("req_id");
        }
        return null;
    }

    public static String qg(com.byazt.vr.n nVar) {
        JSONObject jSONObjectOptJSONObject;
        if (nVar == null || nVar.n() == null || w(nVar) || (jSONObjectOptJSONObject = nVar.n().optJSONObject("params")) == null) {
            return null;
        }
        try {
            return q(new JSONObject(jSONObjectOptJSONObject.optString("log_extra")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n(List<com.byazt.vr.n> list, cp cpVar) {
        try {
            if (cpVar.fs()) {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                for (com.byazt.vr.n nVar : list) {
                    if (nVar != null) {
                        if (nVar.rv() <= 1) {
                            i++;
                        }
                        String strN = n(nVar);
                        if (TextUtils.equals("show", strN)) {
                            if (nVar.rv() <= 1) {
                                i3++;
                            } else {
                                i2++;
                            }
                        }
                        if (TextUtils.equals("click", strN)) {
                            if (nVar.rv() <= 1) {
                                i5++;
                            } else {
                                i4++;
                            }
                        }
                        if (nVar.fs() != 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - nVar.fs();
                            com.byazt.kp.s.n.fs().incrementAndGet();
                            com.byazt.kp.s.n.oa().getAndAdd(jCurrentTimeMillis);
                        }
                        n(nVar, cpVar);
                    }
                }
                com.byazt.kp.s.n.tj().getAndAdd(list.size());
                com.byazt.kp.s.n.t().getAndAdd(i);
                com.byazt.kp.s.n.ur().getAndAdd(i2);
                com.byazt.kp.s.n.bb().getAndAdd(i3);
                com.byazt.kp.s.n.lh().getAndAdd(i4);
                com.byazt.kp.s.n.v().getAndAdd(i5);
            }
        } catch (Exception unused) {
        }
    }

    public static void n(com.byazt.vr.n nVar, cp cpVar) {
        try {
            if (nVar.cp() == 0 && cpVar.w()) {
                JSONObject jSONObjectN = nVar.n();
                String strN = n(nVar);
                if (TextUtils.isEmpty(strN)) {
                    return;
                }
                String strOptString = jSONObjectN.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("will_send_labels"))) {
                        jSONObject.put("will_send_labels", fs(strN));
                        jSONObject.put("send_success_valid_labels", s());
                    }
                    jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("will_send_labels", fs(strN));
                jSONObject2.put("send_success_valid_labels", s());
                jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static void qg(com.byazt.vr.n nVar, cp cpVar) {
        if (cpVar == null || !cpVar.fs()) {
            return;
        }
        try {
            com.byazt.kp.s.n.n(System.currentTimeMillis() - nVar.x(), nVar);
            nVar.n(System.currentTimeMillis());
            if (nVar.cp() == 0 && cpVar.w()) {
                String strN = n(nVar);
                if (TextUtils.isEmpty(strN)) {
                    return;
                }
                JSONObject jSONObjectN = nVar.n();
                String strOptString = nVar.n().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("save_success_labels"))) {
                        jSONObject.put("save_success_labels", x(strN));
                    }
                    jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_success_labels", x(strN));
                jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean n(List<com.byazt.vr.n> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return w(list.get(0));
    }

    public static void n(JSONObject jSONObject, com.byazt.asa.q qVar, com.byazt.vr.qg qgVar, int i, boolean z) {
        if (qgVar == null || jSONObject == null) {
            x.q("query error");
        }
    }

    private static int s(List<com.byazt.vr.n> list, String str) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            for (com.byazt.vr.n nVar : list) {
                if (nVar != null && TextUtils.equals(n(nVar), str)) {
                    i++;
                }
            }
        }
        return i;
    }

    public static boolean s(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 0 && nVar.d() == 1;
    }

    public static boolean qg(List<com.byazt.vr.n> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        return q(list.get(0));
    }

    public static boolean q(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 0;
    }

    public static boolean l(com.byazt.vr.n nVar) {
        return q(nVar) || w(nVar);
    }

    public static boolean w(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 3 && nVar.d() == 2;
    }

    public static boolean x(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 0 && nVar.d() == 2;
    }

    public static boolean fs(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 1 && nVar.d() == 2;
    }

    public static boolean rv(com.byazt.vr.n nVar) {
        return nVar != null && nVar.cp() == 1 && nVar.d() == 3;
    }

    private static void n(com.byazt.vr.n nVar, String str, cp cpVar) {
        String strN = n(nVar);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        String strQg = qg(nVar);
        if (nVar.cp() == 0 && cpVar.w()) {
            rv(strN + "_" + strQg + "_" + str);
        }
    }

    public static void n(boolean z, int i, String str, String str2, int i2, String str3, cp cpVar, String str4, String str5) {
        x++;
        if (z) {
            fs++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", fs);
            jSONObject.put("acnt", x);
            jSONObject.put("code", i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put(ImagesContract.URL, str5);
            } else if (cpVar != null) {
                jSONObject.put(ImagesContract.URL, cpVar.qg());
            } else {
                jSONObject.put(ImagesContract.URL, "emptyurl");
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("ip", str4);
            }
            w = jSONObject.toString();
        } catch (Exception unused) {
            w = "unknown_json";
        }
    }

    public static String qg() {
        return w;
    }

    public static void n(com.byazt.vr.n nVar, String str) {
        w(nVar);
    }

    public static void n(int i, List<com.byazt.vr.n> list, long j, com.byazt.vr.qg qgVar, com.byazt.zad.n nVar, com.byazt.fa.qg qgVar2) {
        com.byazt.vr.n nVar2;
        if (qgVar != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                x.n("uploadCost:" + jCurrentTimeMillis);
                if (i == 200) {
                    com.byazt.kp.s.n.wm().getAndAdd(jCurrentTimeMillis);
                    com.byazt.kp.s.n.py().incrementAndGet();
                    com.byazt.kp.s.n.cd().getAndAdd(list.size());
                    com.byazt.kp.s.n.ln().getAndAdd(s(list, "show"));
                    com.byazt.kp.s.n.j().getAndAdd(s(list, "click"));
                    com.byazt.kp.s.n.l().getAndAdd(list.size());
                    return;
                }
                x.q("-------AdThread code is " + i + " error  ------------");
                byte bCp = -1;
                if (i == -1) {
                    com.byazt.kp.s.n.um().getAndAdd(list.size());
                } else {
                    com.byazt.kp.s.n.x().getAndAdd(list.size());
                }
                com.byazt.kp.s.n.m().getAndAdd(jCurrentTimeMillis);
                com.byazt.kp.s.n.ou().incrementAndGet();
                if (!list.isEmpty() && (nVar2 = list.get(0)) != null) {
                    bCp = nVar2.cp();
                }
                if (nVar != null) {
                    com.byazt.kp.s.n.hu().append((int) bCp).append("_").append(nVar.q()).append("_").append(nVar.qg()).append("_").append(nVar.s()).append(" ");
                } else {
                    com.byazt.kp.s.n.hu().append((int) bCp).append("_").append(i).append(" ");
                }
                if (qgVar2 != null) {
                    com.byazt.kp.s.n.h().append((int) bCp).append("_").append(qgVar2.n()).append("_").append(qgVar2.qg());
                } else {
                    com.byazt.kp.s.n.h().append((int) bCp).append("_ok");
                }
            } catch (Exception e) {
                x.n("result", e);
            }
        }
    }

    public static int s(List<com.byazt.vr.n> list) {
        JSONObject jSONObjectN;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.byazt.vr.n nVar = list.get(0);
                if (nVar != null && nVar.d() == 1 && (jSONObjectN = nVar.n()) != null && nVar.cp() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectN.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectN.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectN.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                            jSONObjectN.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static void n(List<com.byazt.vr.n> list, String str, cp cpVar) {
        try {
            if (cpVar.fs() && list != null && cpVar.w()) {
                for (com.byazt.vr.n nVar : list) {
                    if (nVar != null) {
                        n(nVar, str, cpVar);
                    }
                }
            }
        } catch (Exception e) {
            x.q("logId", e.getMessage());
        }
    }

    public static JSONObject tj(com.byazt.vr.n nVar) {
        JSONObject jSONObjectOptJSONObject;
        if (nVar == null || nVar.n() == null || !q(nVar) || (jSONObjectOptJSONObject = nVar.n().optJSONObject("params")) == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
        } catch (JSONException unused) {
            return null;
        }
    }
}
