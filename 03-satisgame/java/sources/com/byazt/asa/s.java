package com.byazt.asa;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.tk.k;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 8})
public class s implements com.byazt.sf.s, Function {
    public cp fs;
    public com.byazt.vf.n l;
    public com.byazt.vr.l q;
    public com.byazt.vr.qg qg;
    public Context s;
    public com.byazt.kp.n w;
    public static String n = UUID.randomUUID().toString();
    public static AtomicLong sAppLogEventIndex = new AtomicLong(0);
    public static AtomicLong sStatsEventIndex = new AtomicLong(0);
    public static AtomicLong sMediationEventIndex = new AtomicLong(0);
    public static volatile List<com.byazt.sf.n> tj = new CopyOnWriteArrayList();
    public wo rv = (wo) com.byazt.qp.q.n("thread_service");
    public oa x = (oa) com.byazt.qp.q.n("device_info_new");

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            n((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return w();
        }
        switch (iIntValue) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                Object obj5 = sparseArray.get(4);
                Object obj6 = sparseArray.get(5);
                Object obj7 = sparseArray.get(6);
                Object obj8 = sparseArray.get(7);
                Object qgVar = sparseArray.get(8);
                if (qgVar != null) {
                    qgVar = new com.byazt.rs.qg((Function) qgVar);
                }
                n((String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (JSONObject) obj8, (com.byazt.rs.n) qgVar);
                return null;
            case 2:
                Object obj9 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                Object qgVar2 = sparseArray.get(3);
                if (qgVar2 != null) {
                    qgVar2 = new com.byazt.rs.qg((Function) qgVar2);
                }
                n((String) obj9, ((Byte) obj10).byteValue(), (com.byazt.rs.n) qgVar2);
                return null;
            case 3:
                n((JSONObject) sparseArray.get(1), ((Byte) sparseArray.get(2)).byteValue());
                return null;
            case 4:
                n();
                return null;
            case 5:
                n((String) sparseArray.get(1), (List) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (Map) sparseArray.get(4), (JSONObject) sparseArray.get(5));
                return null;
            case 6:
                n((String) sparseArray.get(1));
                return null;
            case 7:
                n(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 8:
                Object qgVar3 = sparseArray.get(1);
                if (qgVar3 != null) {
                    qgVar3 = new com.byazt.sf.qg((Function) qgVar3);
                }
                n((com.byazt.sf.n) qgVar3);
                return null;
            case 9:
                Object qgVar4 = sparseArray.get(1);
                if (qgVar4 != null) {
                    qgVar4 = new com.byazt.sf.qg((Function) qgVar4);
                }
                qg((com.byazt.sf.n) qgVar4);
                return null;
            case 10:
                return qg();
            case 11:
                return Boolean.valueOf(n((String) sparseArray.get(1), ((Double) sparseArray.get(2)).doubleValue()));
            case 12:
                return s();
            default:
                return null;
        }
    }

    public void n(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            n = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            sAppLogEventIndex = (AtomicLong) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            sStatsEventIndex = (AtomicLong) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            sMediationEventIndex = (AtomicLong) obj4;
        }
    }

    public SparseArray w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, n);
        sparseArray.put(2, sAppLogEventIndex);
        sparseArray.put(3, sStatsEventIndex);
        sparseArray.put(4, sMediationEventIndex);
        return sparseArray;
    }

    public s(com.byazt.vf.n nVar, Context context, com.byazt.vr.qg qgVar) {
        this.qg = qgVar;
        this.l = nVar;
        this.s = context;
        this.fs = (cp) com.byazt.qp.q.n("csj_settings", nVar);
        this.q = new com.byazt.kp.s(context, this.qg, nVar, this.x);
        this.w = new com.byazt.kp.n(context, this.q);
    }

    private boolean n(Context context, com.byazt.vr.s sVar) {
        if (context == null || sVar == null) {
            return false;
        }
        try {
            return ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n();
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.byazt.sf.s
    public void n(final boolean z) {
        com.byazt.vr.s sVarN;
        com.byazt.hls.x.n("EventMultiUtils start");
        com.byazt.vr.qg qgVar = this.qg;
        if (qgVar == null || (sVarN = qgVar.n()) == null || this.s == null) {
            return;
        }
        if (this.l.qg()) {
            if (n(this.s, sVarN)) {
                com.byazt.vr.l lVar = this.q;
                if (lVar != null) {
                    lVar.n(z);
                    return;
                }
                return;
            }
            if (x()) {
                this.rv.qg().execute(new Runnable() { // from class: com.byazt.asa.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.hls.x.n("TTExecutor start");
                        s.this.w.n(s.this.qg, z);
                    }
                });
                return;
            } else {
                this.w.n(this.qg, z);
                return;
            }
        }
        com.byazt.vr.l lVar2 = this.q;
        if (lVar2 != null) {
            lVar2.n(z);
        }
    }

    @Override // com.byazt.sf.s
    public void n() {
        com.byazt.vr.s sVarN;
        com.byazt.vr.qg qgVar = this.qg;
        if (qgVar == null || (sVarN = qgVar.n()) == null || this.s == null || !this.l.qg() || n(this.s, sVarN)) {
            return;
        }
        if (x()) {
            this.rv.qg().execute(new Runnable() { // from class: com.byazt.asa.s.2
                @Override // java.lang.Runnable
                public void run() {
                    s.this.w.n(s.this.qg);
                }
            });
        } else {
            this.w.n(this.qg);
        }
    }

    @Override // com.byazt.sf.s
    public String qg() {
        return n + "_" + l();
    }

    @Override // com.byazt.sf.s
    public void n(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, com.byazt.rs.n nVar) {
        if (com.byazt.hls.w.n(this.l, str, 1.0d) || qg(str)) {
            l lVarN = new l.n().qg(str).n(str2).s(str3).q(str4).l(str5).w(str6).n(jSONObject).n(nVar);
            lVarN.n(this.l, this.qg);
            n(str, lVarN);
            n(lVarN);
        }
    }

    private void n(String str, q qVar) {
        if (this.fs.w()) {
            try {
                qVar.qg(com.byazt.hls.q.qg(str));
            } catch (Exception e) {
                com.byazt.hls.x.q(e.getMessage());
            }
        }
    }

    private boolean qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        return str.equals("ad_request_result");
    }

    @Override // com.byazt.sf.s
    public void n(String str, byte b, com.byazt.rs.n nVar) {
        boolean z = com.byazt.hls.w.n(this.l, str, 1.0d) || qg(str);
        if (b == 0) {
            if (z) {
                l lVarN = new l.n().qg(str).n(nVar);
                lVarN.n(this.l, this.qg);
                n(lVarN);
                return;
            }
            return;
        }
        if (b != 1) {
            if (b != 3) {
                return;
            }
            w wVar = new w(str, this.x);
            wVar.n(this.l, this.qg);
            wVar.n(nVar);
            n(wVar);
            return;
        }
        if (z) {
            if (TextUtils.equals(str, "exception")) {
                try {
                    if (!com.byazt.hls.w.n(this.l, nVar.n(new JSONObject()).optString("scene"), 1.0d)) {
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            x xVar = new x(str, this.q);
            xVar.n(nVar);
            xVar.n(this.l, this.qg);
            n(xVar);
        }
    }

    @Override // com.byazt.sf.s
    public void n(JSONObject jSONObject, byte b) {
        com.byazt.vr.n lVar;
        com.byazt.vr.n nVar = null;
        if (b == 0) {
            lVar = new l(null, jSONObject);
        } else if (b == 1) {
            lVar = new x((String) null, jSONObject);
        } else {
            if (b == 3) {
                lVar = new w((String) null, jSONObject);
            }
            n(nVar);
        }
        nVar = lVar;
        n(nVar);
    }

    private boolean x() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void n(final com.byazt.vr.n nVar) {
        com.byazt.hls.x.n("dispatchEvent()");
        com.byazt.vr.qg qgVar = this.qg;
        if (qgVar == null || this.q == null) {
            k.qg("log_error", "dispatch event configManager is null");
            return;
        }
        com.byazt.vr.s sVarN = qgVar.n();
        if (nVar == null || sVarN == null) {
            return;
        }
        if (this.l.qg()) {
            boolean zN = n(this.s, sVarN);
            com.byazt.hls.x.n("dispatchEvent mainProcess:".concat(String.valueOf(zN)));
            if (zN) {
                this.q.n(nVar);
                return;
            }
            com.byazt.hls.x.n("sub thread dispatch:" + x());
            if (x()) {
                this.rv.qg().execute(new Runnable() { // from class: com.byazt.asa.s.3
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.w.n(nVar, s.this.qg);
                    }
                });
                return;
            } else {
                this.w.n(nVar, this.qg);
                return;
            }
        }
        this.q.n(nVar);
    }

    @Override // com.byazt.sf.s
    public void n(final String str, List<String> list, final boolean z, final Map<String, String> map, final JSONObject jSONObject) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final List<String> listN = n(list, ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(false));
        com.byazt.vr.qg qgVar = this.qg;
        if (qgVar == null) {
            k.qg("log_error", "track configManager is null");
            return;
        }
        com.byazt.vr.s sVarN = qgVar.n();
        if (sVarN == null || this.s == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.l.qg() || n(this.s, sVarN)) {
            com.byazt.tzz.n.n(this.s, this.qg).n(str, listN, z, map, jSONObject);
        } else if (x()) {
            this.rv.qg().execute(new Runnable() { // from class: com.byazt.asa.s.4
                @Override // java.lang.Runnable
                public void run() {
                    s.this.w.n(str, listN, z, s.this.qg, map, jSONObject);
                }
            });
        } else {
            this.w.n(str, listN, z, this.qg, map, jSONObject);
        }
    }

    private static List<String> n(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String strReplace = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("{OAID}") || strReplace.contains("__OAID__")) {
                        strReplace = strReplace.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(strReplace);
                }
            }
        }
        return list;
    }

    @Override // com.byazt.sf.s
    public void n(final String str) {
        com.byazt.vr.qg qgVar = this.qg;
        if (qgVar == null) {
            com.byazt.hls.x.q("log_error", "trackFailedUrls configManager is null");
            return;
        }
        com.byazt.vr.s sVarN = qgVar.n();
        if (sVarN == null || this.s == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.l.qg() || n(this.s, sVarN)) {
            com.byazt.tzz.n.n(this.s, this.qg).n(str);
        } else if (x()) {
            this.rv.qg().execute(new Runnable() { // from class: com.byazt.asa.s.5
                @Override // java.lang.Runnable
                public void run() {
                    s.this.w.n(str, s.this.qg);
                }
            });
        } else {
            this.w.n(str, this.qg);
        }
    }

    @Override // com.byazt.sf.s
    public void qg(com.byazt.sf.n nVar) {
        if (nVar == null || tj.isEmpty()) {
            return;
        }
        tj.remove(nVar);
    }

    public static List<com.byazt.sf.n> q() {
        return tj;
    }

    @Override // com.byazt.sf.s
    public void n(com.byazt.sf.n nVar) {
        if (nVar != null) {
            tj.add(nVar);
        }
    }

    public int l() {
        return com.byazt.qp.q.n().s("ad_log").s;
    }

    @Override // com.byazt.sf.s
    public boolean n(String str, double d) {
        return com.byazt.hls.w.n(this.l, str, d);
    }

    @Override // com.byazt.sf.s
    public String s() {
        return com.byazt.hls.q.qg();
    }
}
