package com.byazt.imu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qyu.PluginConstants;
import com.byazt.si.um;
import com.byazt.si.w;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1664, 26})
public class qg {
    public static volatile SQLiteDatabase n;

    public static Context getContext() {
        return rv.getContext();
    }

    public static com.byazt.tbi.s n() {
        return new com.byazt.tbi.s() { // from class: com.byazt.imu.qg.1
            @Override // com.byazt.tbi.s
            public boolean w() {
                return false;
            }

            @Override // com.byazt.tbi.s
            public com.byazt.vf.n n() {
                return com.byazt.vgx.s.l();
            }

            @Override // com.byazt.tbi.s
            public int qg() {
                return tj.l;
            }

            @Override // com.byazt.tbi.s
            public boolean s() {
                return rv.qg().mp();
            }

            @Override // com.byazt.tbi.s
            public boolean q() {
                return tj.s;
            }

            @Override // com.byazt.tbi.s
            public Map<String, Object> l() {
                return com.byazt.hnb.s.tj();
            }
        };
    }

    public static um qg() {
        return new com.byazt.gxb.l.n().n(new com.byazt.dl.n(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), 524288, 41943040L, true, true, new File(com.byazt.ql.qg.w()))).n(com.byazt.qit.l.n()).n(new com.byazt.si.l() { // from class: com.byazt.imu.qg.2
            @Override // com.byazt.si.l
            public com.byazt.tb.q call(w wVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                d dVarN = com.byazt.mw.s.n().qg().n();
                sz szVarQg = new sz.n().qg(wVar.n()).n().n("csj_client_source_from", "2").qg();
                cy cyVar = null;
                com.byazt.tb.l lVar = wVar.s() ? new com.byazt.tb.l() : null;
                if (lVar != null) {
                    lVar.n(jCurrentTimeMillis);
                }
                try {
                    cy cyVarQg = dVarN.n(szVarQg).qg();
                    if (lVar != null) {
                        try {
                            lVar.qg(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            cyVar = cyVarQg;
                            try {
                                return n(lVar, th);
                            } finally {
                                com.byazt.wvr.qg.n(cyVar);
                            }
                        }
                    }
                    if (wVar.q() != null) {
                        wVar.q().n(3, null);
                    }
                    Map<String, String> mapN = n(wVar, cyVarQg);
                    byte[] bArrQ = cyVarQg.x().q();
                    mapN.put("image_size", String.valueOf(bArrQ == null ? 0 : bArrQ.length));
                    com.byazt.tb.q qVar = new com.byazt.tb.q(cyVarQg.q(), bArrQ, "", mapN);
                    if (lVar != null) {
                        lVar.s(System.currentTimeMillis());
                    }
                    qVar.n(lVar);
                    com.byazt.wvr.qg.n(cyVarQg);
                    return qVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private Map<String, String> n(w wVar, cy cyVar) {
                HashMap map = new HashMap();
                if (wVar.qg()) {
                    com.byazt.tbt.w wVarFs = cyVar.fs();
                    int iN = wVarFs.n();
                    for (int i = 0; i < iN; i++) {
                        String strN = wVarFs.n(i);
                        String strQg = wVarFs.qg(i);
                        if (strN != null) {
                            map.put(strN, strQg);
                        }
                    }
                }
                return map;
            }

            private com.byazt.tb.q n(com.byazt.tb.l lVar, Throwable th) {
                th.getMessage();
                if (lVar != null) {
                    lVar.s(System.currentTimeMillis());
                }
                com.byazt.tb.q qVar = new com.byazt.tb.q(0, th, "net failed");
                qVar.n(lVar);
                return qVar;
            }
        }).n();
    }

    public static com.byazt.zve.n s() {
        final com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
        return new com.byazt.zve.n() { // from class: com.byazt.imu.qg.3
            @Override // com.byazt.zve.n
            public boolean cp() {
                return true;
            }

            @Override // com.byazt.zve.n
            public int cy() {
                return 7814;
            }

            @Override // com.byazt.zve.n
            public String n() {
                return com.byazt.yu.n.l();
            }

            @Override // com.byazt.zve.n
            public String qg() {
                return com.byazt.yu.n.w();
            }

            @Override // com.byazt.zve.n
            public boolean s() {
                com.byazt.af.rv rvVar = rvVarHd;
                if (rvVar != null) {
                    return com.byazt.af.rv.n(rvVar, 0) && com.byazt.af.rv.n(rvVarHd, 3);
                }
                return true;
            }

            @Override // com.byazt.zve.n
            public String q() {
                com.byazt.af.rv rvVar = rvVarHd;
                if (rvVar == null) {
                    return "";
                }
                boolean z = false;
                if (com.byazt.af.rv.n(rvVar, 0) && com.byazt.af.rv.n(rvVarHd, 3)) {
                    z = true;
                }
                return !z ? rvVarHd.l() : "";
            }

            @Override // com.byazt.zve.n
            public boolean l() {
                com.byazt.af.rv rvVar = rvVarHd;
                if (rvVar == null) {
                    return true;
                }
                return com.byazt.af.rv.n(rvVar, 2);
            }

            @Override // com.byazt.zve.n
            public boolean w() {
                com.byazt.af.rv rvVar = rvVarHd;
                if (rvVar == null) {
                    return true;
                }
                return rvVar.tj();
            }

            @Override // com.byazt.zve.n
            public String x() {
                return (rvVarHd == null || !tj.fs()) ? "" : rvVarHd.cp();
            }

            @Override // com.byazt.zve.n
            public boolean fs() {
                return !com.byazt.gv.n.qg();
            }

            @Override // com.byazt.zve.n
            public com.byazt.zve.w rv() {
                return new com.byazt.zve.w() { // from class: com.byazt.imu.qg.3.1
                    @Override // com.byazt.zve.w
                    public String n(Context context) {
                        return ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
                    }

                    @Override // com.byazt.zve.w
                    public boolean n() {
                        return rv.qg().b();
                    }

                    @Override // com.byazt.zve.w
                    public boolean qg() {
                        return com.byazt.jc.n.n();
                    }

                    @Override // com.byazt.zve.w
                    public Looper s() {
                        return com.byazt.tk.rv.n().getLooper();
                    }

                    @Override // com.byazt.zve.w
                    public Looper q() {
                        return com.byazt.tk.rv.n().getLooper();
                    }

                    @Override // com.byazt.zve.w
                    public String n(String str) {
                        return com.byazt.ehw.rv.n(str);
                    }

                    @Override // com.byazt.zve.w
                    public JSONObject n(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            JSONArray jSONArrayN = com.byazt.ehw.w.n(com.byazt.vgx.s.l());
                            try {
                                if (jSONArrayN.length() != 0) {
                                    jSONObject.put("ipv6_list", jSONArrayN);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        return jSONObject;
                    }

                    @Override // com.byazt.zve.w
                    public void n(String[] strArr, int[] iArr, boolean z) {
                        com.byazt.xf.n.n().n(iArr);
                    }

                    @Override // com.byazt.zve.w
                    public void n(JSONObject jSONObject, JSONObject jSONObject2) {
                        com.byazt.eji.s.n().n(jSONObject, jSONObject2);
                    }
                };
            }

            @Override // com.byazt.zve.n
            public boolean tj() {
                return rv.qg().fi();
            }

            @Override // com.byazt.zve.n
            public boolean d() {
                return com.byazt.vyf.s.cy().x() && !com.byazt.vyf.s.cy().fs();
            }

            @Override // com.byazt.zve.n
            public HashMap<String, Object> oa() {
                HashMap<String, Object> map = new HashMap<>();
                String strOu = com.byazt.vyf.s.cy().ou();
                if (TextUtils.isEmpty(strOu)) {
                    strOu = com.byazt.yu.n.l();
                }
                map.put("host_appid", strOu);
                map.put("is_plugin", Boolean.valueOf(tj.n()));
                map.put("sdk_version", "7.8.1.4");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
                map.put("sdk_api_version", tj.w);
                map.put("channel", tj.w());
                if (rv.qg().ln()) {
                    map.put("use_apm_sdk", "1");
                }
                return map;
            }

            @Override // com.byazt.zve.n
            public String sz() {
                return com.byazt.vyf.s.cy().a().rv();
            }

            @Override // com.byazt.zve.n
            public com.byazt.vf.n k() {
                return com.byazt.vgx.s.l();
            }

            @Override // com.byazt.zve.n
            public boolean hd() {
                return com.byazt.vyf.s.cy().x();
            }
        };
    }

    public static com.byazt.xl.n q() {
        return new com.byazt.xl.n() { // from class: com.byazt.imu.qg.4
            @Override // com.byazt.xl.n
            public boolean l() {
                return true;
            }

            @Override // com.byazt.xl.n
            public String q() {
                return "7814";
            }

            @Override // com.byazt.xl.n
            public long n() {
                return com.byazt.cl.n.s();
            }

            @Override // com.byazt.xl.n
            public Context qg() {
                return rv.getContext();
            }

            @Override // com.byazt.xl.n
            public String s() {
                return tj.x();
            }
        };
    }

    public static com.byazt.vr.qg l() {
        return new com.byazt.asa.n.C0129n().n(com.byazt.gv.n.l()).n(new com.byazt.vr.s() { // from class: com.byazt.imu.qg.5
            @Override // com.byazt.vr.s
            public String n() {
                return "7.8.1.4";
            }

            @Override // com.byazt.vr.s
            public boolean qg() {
                return com.byazt.ivn.l.n();
            }

            @Override // com.byazt.vr.s
            public String s() {
                return tj.rv;
            }

            @Override // com.byazt.vr.s
            public void n(JSONObject jSONObject, JSONObject jSONObject2) {
                boolean zJh = rv.qg().jh();
                boolean z = false;
                if (jSONObject2 != null && jSONObject2.optInt("success") == 1) {
                    z = true;
                }
                if (z && zJh) {
                    return;
                }
                com.byazt.hm.n.n(jSONObject, jSONObject2);
            }

            @Override // com.byazt.vr.s
            public void n(int i, List<com.byazt.vr.n> list) {
                for (com.byazt.vr.n nVar : list) {
                }
            }

            @Override // com.byazt.vr.s
            public void n(JSONObject jSONObject) {
                if (jSONObject != null && jSONObject.has("armor_load_status")) {
                    com.byazt.eji.s.n().n(jSONObject.optInt("error_code"), jSONObject.optLong("cost_time"), jSONObject.optString("type"), jSONObject.optInt("armor_load_status"));
                    return;
                }
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("type");
                    if (TextUtils.equals(strOptString, "new_adlog_monitor") || TextUtils.equals(strOptString, "delete_event") || TextUtils.equals(strOptString, "exception")) {
                        jSONObject.remove("type");
                        com.byazt.hm.w.n(strOptString, jSONObject, true);
                    }
                }
            }

            @Override // com.byazt.vr.s
            public SQLiteDatabase n(Context context) {
                if (qg.n == null) {
                    synchronized (qg.class) {
                        if (qg.n == null) {
                            com.byazt.gha.q qVarN = com.byazt.gha.s.n(rv.getContext()).n();
                            qVarN.n();
                            SQLiteDatabase unused = qg.n = qVarN.qg();
                        }
                    }
                }
                return qg.n;
            }

            @Override // com.byazt.vr.s
            public String q() {
                return com.byazt.ehw.l.n();
            }

            @Override // com.byazt.vr.s
            public String l() {
                return com.byazt.ehw.w.qg((String) null);
            }

            @Override // com.byazt.vr.s
            public String w() {
                if (com.byazt.vyf.s.cy().sh()) {
                    return com.byazt.lk.l.n(null, "gm_tt_mediation_ppe_info").getString("tt_ppe_content", "");
                }
                return null;
            }

            @Override // com.byazt.vr.s
            public boolean x() {
                return !com.byazt.vyf.s.cy().n();
            }

            @Override // com.byazt.vr.s
            public int fs() {
                return com.byazt.mw.qg.n;
            }
        }).n();
    }
}
