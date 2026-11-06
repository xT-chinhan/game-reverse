package com.byazt.yt;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.ho;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.qi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, 20})
public class hn implements com.byazt.fu.hn, Function {
    public com.byazt.vkw.pr c;
    public Context hn;
    public com.byazt.hh.hw hw;
    public com.byazt.kbl.pr uc;
    public com.byazt.hh.c x;
    public k zo;
    public static String pr = UUID.randomUUID().toString();
    public static AtomicLong sAppLogEventIndex = new AtomicLong(0);
    public static AtomicLong sStatsEventIndex = new AtomicLong(0);
    public static AtomicLong sMediationEventIndex = new AtomicLong(0);
    public static volatile List<com.byazt.fu.pr> vk = new CopyOnWriteArrayList();
    public qi aj = (qi) com.byazt.zs.uc.pr("thread_service");
    public g fw = (g) com.byazt.zs.uc.pr("device_info_new");

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return uc();
            case -1:
            case 0:
            default:
                return null;
            case 1:
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                Object obj5 = sparseArray.get(4);
                Object obj6 = sparseArray.get(5);
                Object obj7 = sparseArray.get(6);
                Object obj8 = sparseArray.get(7);
                Object hwVar = sparseArray.get(8);
                if (hwVar != null) {
                    hwVar = new com.byazt.ttf.hw((Function) hwVar);
                }
                pr((String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (JSONObject) obj8, (com.byazt.ttf.pr) hwVar);
                return null;
            case 2:
                Object obj9 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                Object hwVar2 = sparseArray.get(3);
                if (hwVar2 != null) {
                    hwVar2 = new com.byazt.ttf.hw((Function) hwVar2);
                }
                pr((String) obj9, ((Byte) obj10).byteValue(), (com.byazt.ttf.pr) hwVar2);
                return null;
            case 3:
                pr((JSONObject) sparseArray.get(1), ((Byte) sparseArray.get(2)).byteValue());
                return null;
            case 4:
                pr();
                return null;
            case 5:
                pr((String) sparseArray.get(1), (List) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (Map) sparseArray.get(4), (JSONObject) sparseArray.get(5));
                return null;
            case 6:
                pr((String) sparseArray.get(1));
                return null;
            case 7:
                pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 8:
                Object hwVar3 = sparseArray.get(1);
                if (hwVar3 != null) {
                    hwVar3 = new com.byazt.fu.hw((Function) hwVar3);
                }
                pr((com.byazt.fu.pr) hwVar3);
                return null;
            case 9:
                Object hwVar4 = sparseArray.get(1);
                if (hwVar4 != null) {
                    hwVar4 = new com.byazt.fu.hw((Function) hwVar4);
                }
                hw((com.byazt.fu.pr) hwVar4);
                return null;
            case 10:
                return hw();
            case 11:
                return Boolean.valueOf(pr((String) sparseArray.get(1), ((Double) sparseArray.get(2)).doubleValue()));
            case 12:
                return hn();
        }
    }

    public void pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            pr = (String) obj;
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

    public SparseArray uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, pr);
        sparseArray.put(2, sAppLogEventIndex);
        sparseArray.put(3, sStatsEventIndex);
        sparseArray.put(4, sMediationEventIndex);
        return sparseArray;
    }

    public hn(com.byazt.vkw.pr prVar, Context context, com.byazt.hh.hw hwVar) {
        this.hw = hwVar;
        this.c = prVar;
        this.hn = context;
        this.zo = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        this.x = new com.byazt.kbl.hn(context, this.hw, prVar, this.fw);
        this.uc = new com.byazt.kbl.pr(context, this.x);
    }

    private boolean pr(Context context, com.byazt.hh.hn hnVar) {
        if (context == null || hnVar == null) {
            return false;
        }
        try {
            return ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr();
        } catch (Throwable th) {
            return true;
        }
    }

    @Override // com.byazt.fu.hn
    public void pr(final boolean z) {
        com.byazt.hh.hn hnVarPr;
        com.byazt.nn.fw.pr("EventMultiUtils start");
        com.byazt.hh.hw hwVar = this.hw;
        if (hwVar == null || (hnVarPr = hwVar.pr()) == null || this.hn == null) {
            return;
        }
        if (this.c.hw()) {
            if (pr(this.hn, hnVarPr)) {
                com.byazt.hh.c cVar = this.x;
                if (cVar != null) {
                    cVar.pr(z);
                    return;
                }
                return;
            }
            if (fw()) {
                this.aj.hw().execute(new Runnable() { // from class: com.byazt.yt.hn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.nn.fw.pr("TTExecutor start");
                        hn.this.uc.pr(hn.this.hw, z);
                    }
                });
                return;
            } else {
                this.uc.pr(this.hw, z);
                return;
            }
        }
        com.byazt.hh.c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.pr(z);
        }
    }

    @Override // com.byazt.fu.hn
    public void pr() {
        com.byazt.hh.hn hnVarPr;
        com.byazt.hh.hw hwVar = this.hw;
        if (hwVar == null || (hnVarPr = hwVar.pr()) == null || this.hn == null || !this.c.hw() || pr(this.hn, hnVarPr)) {
            return;
        }
        if (fw()) {
            this.aj.hw().execute(new Runnable() { // from class: com.byazt.yt.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.uc.pr(hn.this.hw);
                }
            });
        } else {
            this.uc.pr(this.hw);
        }
    }

    @Override // com.byazt.fu.hn
    public String hw() {
        return pr + "_" + c();
    }

    @Override // com.byazt.fu.hn
    public void pr(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, com.byazt.ttf.pr prVar) {
        if (!(com.byazt.nn.uc.pr(this.c, str, 1.0d) || hw(str))) {
            return;
        }
        c cVarPr = new c.pr().hw(str).pr(str2).hn(str3).x(str4).c(str5).uc(str6).pr(jSONObject).pr(prVar);
        cVarPr.pr(this.c, this.hw);
        pr(str, cVarPr);
        pr(cVarPr);
    }

    private void pr(String str, x xVar) {
        if (this.zo.uc()) {
            try {
                xVar.hw(com.byazt.nn.x.hw(str));
            } catch (Exception e) {
                com.byazt.nn.fw.x(e.getMessage());
            }
        }
    }

    private boolean hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        switch (str) {
            case "ad_request_result":
                return true;
            default:
                return false;
        }
    }

    @Override // com.byazt.fu.hn
    public void pr(String str, byte b, com.byazt.ttf.pr prVar) {
        boolean z = com.byazt.nn.uc.pr(this.c, str, 1.0d) || hw(str);
        switch (b) {
            case 0:
                if (z) {
                    c cVarPr = new c.pr().hw(str).pr(prVar);
                    cVarPr.pr(this.c, this.hw);
                    pr(cVarPr);
                    break;
                }
                break;
            case 1:
                if (z) {
                    if (TextUtils.equals(str, "exception")) {
                        try {
                            if (!com.byazt.nn.uc.pr(this.c, prVar.pr(new JSONObject()).optString("scene"), 1.0d)) {
                            }
                        } catch (Exception e) {
                        }
                    }
                    fw fwVar = new fw(str, this.x);
                    fwVar.pr(prVar);
                    fwVar.pr(this.c, this.hw);
                    pr(fwVar);
                    break;
                }
                break;
            case 3:
                uc ucVar = new uc(str, this.fw);
                ucVar.pr(this.c, this.hw);
                ucVar.pr(prVar);
                pr(ucVar);
                break;
        }
    }

    @Override // com.byazt.fu.hn
    public void pr(JSONObject jSONObject, byte b) {
        com.byazt.hh.pr cVar = null;
        switch (b) {
            case 0:
                cVar = new c(null, jSONObject);
                break;
            case 1:
                cVar = new fw((String) null, jSONObject);
                break;
            case 3:
                cVar = new uc((String) null, jSONObject);
                break;
        }
        pr(cVar);
    }

    private boolean fw() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void pr(final com.byazt.hh.pr prVar) {
        com.byazt.nn.fw.pr("dispatchEvent()");
        com.byazt.hh.hw hwVar = this.hw;
        if (hwVar == null || this.x == null) {
            ho.hw("log_error", "dispatch event configManager is null");
            return;
        }
        com.byazt.hh.hn hnVarPr = hwVar.pr();
        if (prVar == null || hnVarPr == null) {
            return;
        }
        if (this.c.hw()) {
            boolean zPr = pr(this.hn, hnVarPr);
            com.byazt.nn.fw.pr("dispatchEvent mainProcess:".concat(String.valueOf(zPr)));
            if (zPr) {
                this.x.pr(prVar);
                return;
            }
            com.byazt.nn.fw.pr("sub thread dispatch:" + fw());
            if (fw()) {
                this.aj.hw().execute(new Runnable() { // from class: com.byazt.yt.hn.3
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.this.uc.pr(prVar, hn.this.hw);
                    }
                });
                return;
            } else {
                this.uc.pr(prVar, this.hw);
                return;
            }
        }
        this.x.pr(prVar);
    }

    @Override // com.byazt.fu.hn
    public void pr(final String str, List<String> list, final boolean z, final Map<String, String> map, final JSONObject jSONObject) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final List<String> listPr = pr(list, ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr(false));
        com.byazt.hh.hw hwVar = this.hw;
        if (hwVar == null) {
            ho.hw("log_error", "track configManager is null");
            return;
        }
        com.byazt.hh.hn hnVarPr = hwVar.pr();
        if (hnVarPr == null || this.hn == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.c.hw() || pr(this.hn, hnVarPr)) {
            com.byazt.yd.pr.pr(this.hn, this.hw).pr(str, listPr, z, map, jSONObject);
        } else if (fw()) {
            this.aj.hw().execute(new Runnable() { // from class: com.byazt.yt.hn.4
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.uc.pr(str, listPr, z, hn.this.hw, map, jSONObject);
                }
            });
        } else {
            this.uc.pr(str, listPr, z, this.hw, map, jSONObject);
        }
    }

    private static List<String> pr(List<String> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            String strReplace = (String) arrayList.get(i);
            if (!TextUtils.isEmpty(strReplace)) {
                if (strReplace.contains("{OAID}") || strReplace.contains("__OAID__")) {
                    strReplace = strReplace.replace("{OAID}", str).replace("__OAID__", str);
                }
                arrayList2.add(strReplace);
            }
        }
        return arrayList2;
    }

    @Override // com.byazt.fu.hn
    public void pr(final String str) {
        com.byazt.hh.hw hwVar = this.hw;
        if (hwVar == null) {
            com.byazt.nn.fw.x("log_error", "trackFailedUrls configManager is null");
            return;
        }
        com.byazt.hh.hn hnVarPr = hwVar.pr();
        if (hnVarPr == null || this.hn == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.c.hw() || pr(this.hn, hnVarPr)) {
            com.byazt.yd.pr.pr(this.hn, this.hw).pr(str);
        } else if (fw()) {
            this.aj.hw().execute(new Runnable() { // from class: com.byazt.yt.hn.5
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.uc.pr(str, hn.this.hw);
                }
            });
        } else {
            this.uc.pr(str, this.hw);
        }
    }

    @Override // com.byazt.fu.hn
    public void hw(com.byazt.fu.pr prVar) {
        if (prVar != null && !vk.isEmpty()) {
            vk.remove(prVar);
        }
    }

    public static List<com.byazt.fu.pr> x() {
        return vk;
    }

    @Override // com.byazt.fu.hn
    public void pr(com.byazt.fu.pr prVar) {
        if (prVar != null) {
            vk.add(prVar);
        }
    }

    public int c() {
        return com.byazt.zs.uc.pr().hn("ad_log").hn;
    }

    @Override // com.byazt.fu.hn
    public boolean pr(String str, double d) {
        return com.byazt.nn.uc.pr(this.c, str, d);
    }

    @Override // com.byazt.fu.hn
    public String hn() {
        return com.byazt.nn.x.hw();
    }
}
