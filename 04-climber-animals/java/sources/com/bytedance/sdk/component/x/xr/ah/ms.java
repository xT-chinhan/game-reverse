package com.bytedance.sdk.component.x.xr.ah;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.express.b.a;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final LinkedList<String> f1546ms = new LinkedList<>();
    private static final LinkedList<String> xr = new LinkedList<>();
    private static final LinkedList<String> ah = new LinkedList<>();
    private static final LinkedList<String> d = new LinkedList<>();
    private static final Map<String, Integer> ka = new HashMap();
    private static String c = "upload_init";
    private static int ab = 0;
    private static int x = 0;
    private static AtomicLong ny = new AtomicLong();

    public static boolean ah(String str) {
        return false;
    }

    public static boolean ms(int i) {
        return i == 72 || i == 71;
    }

    public static String xr(int i) {
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
                return a.f;
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    public static synchronized int ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, Integer> map = ka;
        Integer num = map.get(str);
        if (num == null) {
            map.put(str, 1);
            return 1;
        }
        int iIntValue = num.intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static synchronized String xr(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = f1546ms;
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

    private static synchronized String d(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = xr;
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

    private static synchronized String ka(String str) {
        StringBuilder sb;
        LinkedList<String> linkedList = ah;
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

    private static synchronized String xr() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator<String> it = d.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.toString();
    }

    private static synchronized void c(String str) {
        LinkedList<String> linkedList = d;
        if (linkedList.size() >= 10) {
            linkedList.removeFirst();
            linkedList.add(str);
        } else {
            linkedList.add(str);
        }
    }

    public static String ms(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar == null || xrVar.ab() == null || xr(kaVar) || d(kaVar)) {
            return null;
        }
        if (xrVar.xr() == 3) {
            return xrVar.ab().optString(NotificationCompat.CATEGORY_EVENT);
        }
        return xrVar.ab().optString(TTDownloadField.TT_LABEL);
    }

    public static String xr(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar == null || xrVar.ab() == null || xr(kaVar) || d(kaVar)) {
            return null;
        }
        return xrVar.ab().optString("type");
    }

    public static String ah(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (kaVar == null || kaVar.d() == null || !kaVar.d().ah()) {
            return "";
        }
        String strMs = ms(xrVar, kaVar);
        if (TextUtils.isEmpty(strMs)) {
            if (TextUtils.isEmpty(xr(xrVar, kaVar))) {
                return null;
            }
            return "type:" + xr(xrVar, kaVar);
        }
        return "label:" + strMs;
    }

    public static int d(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar != null && xrVar.ab() != null && xrVar.d() == 1) {
            try {
                return new JSONObject(xrVar.ab().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return -1;
    }

    public static void ms(List<com.bytedance.sdk.component.x.ms.xr> list, String str, com.bytedance.sdk.component.x.xr.ms.xr xrVar) {
        JSONObject jSONObjectAb;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.x.ms.xr xrVar2 = list.get(0);
                    if (xrVar2 == null || xrVar2.d() == 0) {
                        long jIncrementAndGet = ny.incrementAndGet();
                        for (com.bytedance.sdk.component.x.ms.xr xrVar3 : list) {
                            if (xrVar3 != null && (jSONObjectAb = xrVar3.ab()) != null) {
                                String strOptString = jSONObjectAb.optString("ad_extra_data");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject = new JSONObject(strOptString);
                                    jSONObject.put("upload_count", jIncrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (xrVar != null) {
                                        String strXr = xrVar.xr();
                                        boolean zMs = xrVar.ms();
                                        if (!TextUtils.isEmpty(strXr)) {
                                            jSONObject.put("delete_msg", strXr + " success:" + zMs);
                                        }
                                    }
                                    jSONObjectAb.put("ad_extra_data", jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    public static synchronized int ka(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar != null) {
            if (xrVar.ab() != null) {
                try {
                    return new JSONObject(xrVar.ab().optString("ad_extra_data")).optInt("sdk_event_self_count");
                } catch (Exception e) {
                    sl.ms(e);
                    return 0;
                }
            }
        }
        return 0;
    }

    public static String ms(JSONObject jSONObject, ka kaVar) {
        if (jSONObject != null && !xr(kaVar) && !d(kaVar)) {
            String strOptString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("rit");
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        }
        return "";
    }

    public static String c(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (xrVar != null && xrVar.ab() != null && !xr(kaVar) && !d(kaVar)) {
            String strOptString = xrVar.ab().optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("req_id");
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        }
        return null;
    }

    public static void ms(List<com.bytedance.sdk.component.x.ms.xr> list, ka kaVar) {
        try {
            if (kaVar.d().ny()) {
                for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
                    if (xrVar != null && xrVar.ny() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - xrVar.ny();
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.x().incrementAndGet();
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.zb().getAndAdd(jCurrentTimeMillis);
                        xrVar.ah(System.currentTimeMillis());
                    }
                    if (xrVar != null) {
                        ab(xrVar, kaVar);
                    }
                }
                com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ch().getAndAdd(list.size());
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public static void ab(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        try {
            if (xrVar.d() == 0 && kaVar.d() != null && kaVar.d().ms()) {
                JSONObject jSONObjectAb = xrVar.ab();
                String strMs = ms(xrVar, kaVar);
                if (ah(strMs)) {
                    return;
                }
                String strOptString = jSONObjectAb.optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("will_send_labels"))) {
                        jSONObject.put("will_send_labels", ka(strMs));
                        jSONObject.put("send_success_valid_labels", xr());
                    }
                    jSONObjectAb.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("will_send_labels", ka(strMs));
                jSONObject2.put("send_success_valid_labels", xr());
                jSONObjectAb.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public static void x(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        if (kaVar == null || kaVar.d() == null || !kaVar.d().ny()) {
            return;
        }
        try {
            com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ms(System.currentTimeMillis() - xrVar.x());
            xrVar.xr(System.currentTimeMillis());
            if (xrVar.d() == 0 && kaVar.d() != null && kaVar.d().ms()) {
                String strMs = ms(xrVar, kaVar);
                if (ah(strMs)) {
                    return;
                }
                JSONObject jSONObjectAb = xrVar.ab();
                String strOptString = xrVar.ab().optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject.optString("save_success_labels"))) {
                        jSONObject.put("save_success_labels", d(strMs));
                    }
                    jSONObjectAb.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("save_success_labels", d(strMs));
                jSONObjectAb.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
    }

    public static boolean ms(ka kaVar) {
        return kaVar != null && TextUtils.equals(kaVar.ka(), "csj");
    }

    public static boolean xr(ka kaVar) {
        return kaVar != null && TextUtils.equals(kaVar.ka(), "csj_mediation");
    }

    public static boolean ah(ka kaVar) {
        return kaVar != null && TextUtils.equals(kaVar.ka(), MediationConstant.ADN_PANGLE);
    }

    public static boolean d(ka kaVar) {
        return kaVar != null && TextUtils.equals(kaVar.ka(), "pgl_mediation");
    }

    public static boolean ka(ka kaVar) {
        return ms(kaVar) || ah(kaVar);
    }

    public static void ms(JSONObject jSONObject, com.bytedance.sdk.component.x.xr.d.ms.ms msVar, ka kaVar, int i) {
        d dVarD;
        if (kaVar != null && (dVarD = kaVar.d()) != null && dVarD.ah() && ka(kaVar)) {
            jSONObject.optString(TTDownloadField.TT_LABEL);
        }
    }

    public static void ms(List<com.bytedance.sdk.component.x.ms.xr> list, int i, String str, ka kaVar) {
        d dVarD;
        if (kaVar == null || (dVarD = kaVar.d()) == null || !dVarD.ah() || list == null || xr(kaVar) || d(kaVar)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
            if (xrVar.d() == 0) {
                JSONObject jSONObjectAb = xrVar.ab();
                String strMs = ms(xrVar, kaVar);
                if (xrVar.xr() == 3) {
                    if (jSONObjectAb != null) {
                        strMs = jSONObjectAb.optString(NotificationCompat.CATEGORY_EVENT);
                    }
                    sb.append(" [v3:").append(strMs).append("] ");
                } else {
                    long jMs = ms(kaVar, xrVar);
                    int iKa = ka(xrVar, kaVar);
                    sb.append(" [").append(jMs).append("_").append(strMs);
                    if (iKa == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_").append(iKa).append("] ");
                    }
                }
                z = true;
            } else if (xrVar.d() == 1) {
                sb.append(" [").append(d(xrVar, kaVar)).append("_").append(xr(xrVar, kaVar)).append("] ");
            }
        }
        if (z) {
            ah.xr("_upload", "ads:" + ((Object) sb) + xr(i) + "," + str + ",total:" + list.size(), kaVar);
        } else {
            ah.xr("_upload", "stats:" + ((Object) sb) + xr(i) + "," + str + ",total:" + list.size(), kaVar);
        }
    }

    public static boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 0 && xrVar.ka() == 1;
    }

    public static boolean xr(List<com.bytedance.sdk.component.x.ms.xr> list, ka kaVar) {
        com.bytedance.sdk.component.x.ms.xr xrVar;
        return (list == null || list.size() == 0 || (xrVar = list.get(0)) == null || xrVar.d() != 0 || !ms(kaVar)) ? false : true;
    }

    public static boolean ny(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar) {
        return xrVar != null && xrVar.d() == 0 && ms(kaVar);
    }

    public static boolean xr(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 3 && xrVar.ka() == 2;
    }

    public static boolean ah(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 0 && xrVar.ka() == 2;
    }

    public static boolean d(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 1 && xrVar.ka() == 2;
    }

    public static boolean ka(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 1 && xrVar.ka() == 3;
    }

    public static boolean c(com.bytedance.sdk.component.x.ms.xr xrVar) {
        return xrVar != null && xrVar.d() == 2 && xrVar.ka() == 3;
    }

    private static void ms(com.bytedance.sdk.component.x.ms.xr xrVar, String str, d dVar, ka kaVar) {
        String strMs = ms(xrVar, kaVar);
        if (ah(strMs)) {
            return;
        }
        String strC = c(xrVar, kaVar);
        if (xrVar.d() == 0 && dVar.ms()) {
            c(strMs + "_" + strC + "_" + str);
        }
    }

    public static long ms(ka kaVar, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (xrVar != null && xrVar.ab() != null) {
            try {
                return new JSONObject(xrVar.ab().optString("ad_extra_data")).optLong("sdk_event_index");
            } catch (Exception e) {
                ah.ah(e.getMessage(), kaVar);
            }
        }
        return 0L;
    }

    public static void ms(boolean z, int i, String str, String str2, int i2, String str3) {
        ab++;
        if (z) {
            x++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", x);
            jSONObject.put("acnt", ab);
            jSONObject.put("code", i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            d dVarKa = com.bytedance.sdk.component.x.xr.ms.ah("csj").ka();
            if (dVarKa != null) {
                jSONObject.put("url", dVarKa.u().c());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            c = jSONObject.toString();
        } catch (Exception unused) {
            c = "unknown_json";
        }
    }

    public static String ms() {
        return c;
    }

    public static void ms(com.bytedance.sdk.component.x.ms.xr xrVar, ka kaVar, String str) {
        d dVarKa;
        if (xr(kaVar) || kaVar == null || d(kaVar) || (dVarKa = com.bytedance.sdk.component.x.xr.ms.ah(kaVar.ka()).ka()) == null || !dVarKa.ah()) {
            return;
        }
        if (!TextUtils.isEmpty(xr(xrVar, kaVar))) {
            d(xrVar, kaVar);
        }
        if (TextUtils.isEmpty(ms(xrVar, kaVar))) {
            return;
        }
        ms(kaVar, xrVar);
    }

    public static void ms(List<com.bytedance.sdk.component.x.ms.xr> list, ka kaVar, String str) {
        if (kaVar == null) {
            return;
        }
        try {
            d dVarD = kaVar.d();
            if (dVarD == null || !dVarD.ah()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
                if (xrVar.d() == 1) {
                    sb.append(xr(xrVar, kaVar)).append("_").append(d(xrVar, kaVar)).append("; ");
                } else if (xrVar.d() == 0) {
                    if (xrVar.xr() == 3) {
                        if (xrVar.ab() != null) {
                            sb.append(xrVar.ab().optString(NotificationCompat.CATEGORY_EVENT));
                            long jMs = ms(kaVar, xrVar);
                            if (jMs != 0) {
                                sb.append("_").append(jMs);
                            }
                            sb.append("; ");
                        } else {
                            ah.xr("_delete", "v3_error", kaVar);
                        }
                    } else {
                        sb.append(ms(xrVar, kaVar));
                        long jMs2 = ms(kaVar, xrVar);
                        if (jMs2 != 0) {
                            sb.append("_").append(jMs2);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]").append(" total:" + list.size()).append(" table:" + str);
            ah.xr("_remove", sb.toString(), kaVar);
        } catch (Exception e) {
            ah.ah("_delete error", e.getMessage(), kaVar);
        }
    }

    public static void ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list, long j, ka kaVar, com.bytedance.sdk.component.x.xr.xr.ah.ms msVar) {
        com.bytedance.sdk.component.x.ms.xr xrVar;
        if (kaVar != null) {
            try {
                if (kaVar.d().ny()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j;
                    if (i == 200) {
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.re().getAndAdd(jCurrentTimeMillis);
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.nw().incrementAndGet();
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.qv().getAndAdd(list.size());
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ka().getAndAdd(list.size());
                        return;
                    }
                    ah.ah("-------AdThread code is " + i + " error  ------------", kaVar);
                    byte bD = -1;
                    if (i == -1) {
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.y().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ab().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.i().getAndAdd(jCurrentTimeMillis);
                    com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.b().incrementAndGet();
                    if (!list.isEmpty() && (xrVar = list.get(0)) != null) {
                        bD = xrVar.d();
                    }
                    if (msVar != null) {
                        com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.w().append((int) bD).append("_").append(msVar.d).append("_").append(msVar.xr).append("_").append(msVar.ah).append(" ");
                        return;
                    }
                    com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.w().append((int) bD).append("_").append(i).append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int ah(List<com.bytedance.sdk.component.x.ms.xr> list, ka kaVar) {
        JSONObject jSONObjectAb;
        String strOptString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.x.ms.xr xrVar = list.get(0);
                if (xrVar != null && xrVar.ka() == 1 && (jSONObjectAb = xrVar.ab()) != null && xrVar.d() == 0) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectAb.optJSONObject("params");
                    if (jSONObjectOptJSONObject == null) {
                        strOptString = jSONObjectAb.optString("ad_extra_data");
                    } else {
                        strOptString = jSONObjectOptJSONObject.optString("ad_extra_data");
                    }
                    JSONObject jSONObject = new JSONObject(strOptString);
                    int iOptInt = jSONObject.optInt("inner_appid", 0);
                    if (iOptInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectAb.put("ad_extra_data", jSONObject.toString());
                        } else {
                            jSONObjectOptJSONObject.put("ad_extra_data", jSONObject.toString());
                            jSONObjectAb.put("params", jSONObjectOptJSONObject);
                        }
                        return iOptInt;
                    }
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return 0;
    }

    public static void ms(List<com.bytedance.sdk.component.x.ms.xr> list, String str, ka kaVar) {
        try {
            d dVarD = kaVar.d();
            if (dVarD != null && dVarD.ny() && list != null && dVarD.ms()) {
                for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
                    if (xrVar != null) {
                        ms(xrVar, str, dVarD, kaVar);
                    }
                }
            }
        } catch (Exception e) {
            ah.ah(e.getMessage(), kaVar);
        }
    }
}
