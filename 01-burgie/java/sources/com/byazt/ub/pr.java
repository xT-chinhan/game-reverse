package com.byazt.ub;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ld.qa;
import com.byazt.ld.uc;
import com.byazt.mg.PluginConstants;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.qam.fw;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.sl.c;
import com.byazt.vlp.x;
import com.byazt.wt.rc;
import com.byazt.wt.z;
import com.byazt.zp.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 37})
public class pr {
    public static volatile SQLiteDatabase pr;

    public static Context getContext() {
        return a.getContext();
    }

    public static x pr() {
        return new x() { // from class: com.byazt.ub.pr.1
            @Override // com.byazt.vlp.x
            public com.byazt.vkw.pr pr() {
                return com.byazt.zb.pr.c();
            }

            @Override // com.byazt.vlp.x
            public int hw() {
                return iu.x;
            }

            @Override // com.byazt.vlp.x
            public boolean hn() {
                return a.hw().jr();
            }

            @Override // com.byazt.vlp.x
            public boolean x() {
                return iu.hn;
            }

            @Override // com.byazt.vlp.x
            public Map<String, Object> c() {
                return com.byazt.igw.hn.vk();
            }

            @Override // com.byazt.vlp.x
            public boolean uc() {
                return false;
            }
        };
    }

    public static qa hw() {
        return new c.pr().pr(new com.byazt.bbo.pr(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), 524288, 41943040L, true, true, new File(w.uc()))).pr(com.byazt.xlm.c.pr()).pr(new com.byazt.ld.c() { // from class: com.byazt.ub.pr.2
            @Override // com.byazt.ld.c
            public com.byazt.xw.x call(uc ucVar) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                k kVarPr = com.byazt.pk.uc.pr().hw().pr();
                g gVarHw = new g.pr().pr(ucVar.pr()).pr().pr("csj_client_source_from", "2").hw();
                nt ntVar = null;
                com.byazt.xw.c cVar = ucVar.hn() ? new com.byazt.xw.c() : null;
                if (cVar != null) {
                    cVar.pr(jCurrentTimeMillis);
                }
                try {
                    nt ntVarHw = kVarPr.pr(gVarHw).hw();
                    if (cVar != null) {
                        try {
                            cVar.hw(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            ntVar = ntVarHw;
                            try {
                                return pr(cVar, th);
                            } finally {
                                com.byazt.cb.hw.pr(ntVar);
                            }
                        }
                    }
                    if (ucVar.x() != null) {
                        ucVar.x().pr(3, null);
                    }
                    Map<String, String> mapPr = pr(ucVar, ntVarHw);
                    byte[] bArrX = ntVarHw.uc().x();
                    mapPr.put("image_size", String.valueOf(bArrX == null ? 0 : bArrX.length));
                    com.byazt.xw.x xVar = new com.byazt.xw.x(ntVarHw.hn(), bArrX, "", mapPr);
                    if (cVar != null) {
                        cVar.hn(System.currentTimeMillis());
                    }
                    xVar.pr(cVar);
                    com.byazt.cb.hw.pr(ntVarHw);
                    return xVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private Map<String, String> pr(uc ucVar, nt ntVar) {
                HashMap map = new HashMap();
                if (ucVar.hw()) {
                    com.byazt.nzn.uc ucVarFw = ntVar.fw();
                    int iPr = ucVarFw.pr();
                    for (int i = 0; i < iPr; i++) {
                        String strPr = ucVarFw.pr(i);
                        String strHw = ucVarFw.hw(i);
                        if (strPr != null) {
                            map.put(strPr, strHw);
                        }
                    }
                }
                return map;
            }

            private com.byazt.xw.x pr(com.byazt.xw.c cVar, Throwable th) {
                th.getMessage();
                if (cVar != null) {
                    cVar.hn(System.currentTimeMillis());
                }
                com.byazt.xw.x xVar = new com.byazt.xw.x(0, th, "net failed");
                xVar.pr(cVar);
                return xVar;
            }
        }).pr();
    }

    public static com.byazt.lq.pr hn() {
        final fw fwVarYb = zo.nt().yb();
        return new com.byazt.lq.pr() { // from class: com.byazt.ub.pr.3
            @Override // com.byazt.lq.pr
            public String pr() {
                return com.byazt.sd.uc.c();
            }

            @Override // com.byazt.lq.pr
            public String hw() {
                return com.byazt.sd.uc.uc();
            }

            @Override // com.byazt.lq.pr
            public boolean hn() {
                fw fwVar = fwVarYb;
                if (fwVar != null) {
                    return fw.pr(fwVar, 0) && fw.pr(fwVarYb, 3);
                }
                return true;
            }

            @Override // com.byazt.lq.pr
            public String x() {
                fw fwVar = fwVarYb;
                if (fwVar == null) {
                    return "";
                }
                boolean z = false;
                if (fw.pr(fwVar, 0) && fw.pr(fwVarYb, 3)) {
                    z = true;
                }
                return !z ? fwVarYb.vk() : "";
            }

            @Override // com.byazt.lq.pr
            public boolean c() {
                fw fwVar = fwVarYb;
                if (fwVar == null) {
                    return true;
                }
                return fw.pr(fwVar, 2);
            }

            @Override // com.byazt.lq.pr
            public boolean uc() {
                fw fwVar = fwVarYb;
                if (fwVar == null) {
                    return true;
                }
                return fwVar.uc();
            }

            @Override // com.byazt.lq.pr
            public String fw() {
                if (fwVarYb != null && iu.fw()) {
                    return fwVarYb.ho();
                }
                return "";
            }

            @Override // com.byazt.lq.pr
            public boolean zo() {
                return !com.byazt.iq.pr.hw();
            }

            @Override // com.byazt.lq.pr
            public com.byazt.lq.uc aj() {
                return new com.byazt.lq.uc() { // from class: com.byazt.ub.pr.3.1
                    @Override // com.byazt.lq.uc
                    public String pr(Context context) {
                        return ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).hw();
                    }

                    @Override // com.byazt.lq.uc
                    public boolean pr() {
                        return a.hw().nw();
                    }

                    @Override // com.byazt.lq.uc
                    public boolean hw() {
                        return com.byazt.wt.g.pr();
                    }

                    @Override // com.byazt.lq.uc
                    public Looper hn() {
                        return aj.pr().getLooper();
                    }

                    @Override // com.byazt.lq.uc
                    public Looper x() {
                        return aj.pr().getLooper();
                    }

                    @Override // com.byazt.lq.uc
                    public String pr(String str) {
                        return z.pr(str);
                    }

                    @Override // com.byazt.lq.uc
                    public JSONObject pr(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            JSONArray jSONArrayPr = com.byazt.wt.a.pr(com.byazt.zb.pr.c());
                            try {
                                if (jSONArrayPr.length() != 0) {
                                    jSONObject.put("ipv6_list", jSONArrayPr);
                                }
                            } catch (Exception e) {
                            }
                        }
                        return jSONObject;
                    }

                    @Override // com.byazt.lq.uc
                    public void pr(String[] strArr, int[] iArr, boolean z) {
                        com.byazt.vq.pr.pr().pr(iArr);
                    }

                    @Override // com.byazt.lq.uc
                    public void pr(JSONObject jSONObject, JSONObject jSONObject2) {
                        com.byazt.xk.hw.pr().pr(jSONObject, jSONObject2);
                    }
                };
            }

            @Override // com.byazt.lq.pr
            public boolean vk() {
                return a.hw().ls();
            }

            @Override // com.byazt.lq.pr
            public boolean w() {
                return true;
            }

            @Override // com.byazt.lq.pr
            public boolean k() {
                return zo.nt().fw() && !zo.nt().zo();
            }

            @Override // com.byazt.lq.pr
            public HashMap<String, Object> m() {
                HashMap<String, Object> map = new HashMap<>();
                String strNy = zo.nt().ny();
                if (TextUtils.isEmpty(strNy)) {
                    strNy = com.byazt.sd.uc.c();
                }
                map.put("host_appid", strNy);
                map.put("is_plugin", Boolean.valueOf(iu.pr()));
                map.put("sdk_version", "7.7.1.4");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
                map.put("sdk_api_version", iu.c);
                map.put("channel", iu.c());
                if (a.hw().nl()) {
                    map.put("use_apm_sdk", "1");
                }
                return map;
            }

            @Override // com.byazt.lq.pr
            public String g() {
                return zo.nt().a().k();
            }

            @Override // com.byazt.lq.pr
            public com.byazt.vkw.pr ho() {
                return com.byazt.zb.pr.c();
            }

            @Override // com.byazt.lq.pr
            public int nt() {
                return 7714;
            }

            @Override // com.byazt.lq.pr
            public boolean yb() {
                return zo.nt().fw();
            }
        };
    }

    public static com.byazt.vlp.pr x() {
        return new com.byazt.vlp.pr() { // from class: com.byazt.ub.pr.4
            @Override // com.byazt.vlp.pr
            public com.byazt.vkw.fw.hw pr() {
                return new rc.pr();
            }
        };
    }

    public static com.byazt.hh.hw c() {
        return new com.byazt.yt.pr.C0240pr().pr(com.byazt.iq.pr.c()).pr(new com.byazt.hh.hn() { // from class: com.byazt.ub.pr.5
            @Override // com.byazt.hh.hn
            public String pr() {
                return "7.7.1.4";
            }

            @Override // com.byazt.hh.hn
            public boolean hw() {
                return com.byazt.is.aj.pr();
            }

            @Override // com.byazt.hh.hn
            public String hn() {
                return iu.zo;
            }

            @Override // com.byazt.hh.hn
            public void pr(JSONObject jSONObject, JSONObject jSONObject2) {
                boolean zUk = a.hw().uk();
                boolean z = false;
                if (jSONObject2 != null && jSONObject2.optInt(TrackAction.SUCCESS) == 1) {
                    z = true;
                }
                if (!z || !zUk) {
                    com.byazt.pj.pr.pr(jSONObject, jSONObject2);
                }
            }

            @Override // com.byazt.hh.hn
            public void pr(int i, List<com.byazt.hh.pr> list) {
                for (com.byazt.hh.pr prVar : list) {
                }
            }

            @Override // com.byazt.hh.hn
            public void pr(JSONObject jSONObject) throws Throwable {
                if (jSONObject != null && jSONObject.has("armor_load_status")) {
                    com.byazt.xk.hw.pr().pr(jSONObject.optInt(Constants.ERROR_CODE_FIELD), jSONObject.optLong("cost_time"), jSONObject.optString("type"), jSONObject.optInt("armor_load_status"));
                    return;
                }
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("type");
                    if (TextUtils.equals(strOptString, "new_adlog_monitor") || TextUtils.equals(strOptString, "delete_event") || TextUtils.equals(strOptString, "exception")) {
                        jSONObject.remove("type");
                        com.byazt.pj.uc.pr(strOptString, jSONObject, true);
                    }
                }
            }

            @Override // com.byazt.hh.hn
            public SQLiteDatabase pr(Context context) {
                if (pr.pr == null) {
                    synchronized (pr.class) {
                        if (pr.pr == null) {
                            com.byazt.bu.x xVarPr = com.byazt.bu.hn.pr(a.getContext()).pr();
                            xVarPr.pr();
                            SQLiteDatabase unused = pr.pr = xVarPr.hw();
                        }
                    }
                }
                return pr.pr;
            }

            @Override // com.byazt.hh.hn
            public String x() {
                return com.byazt.wt.nt.pr();
            }

            @Override // com.byazt.hh.hn
            public String c() {
                return com.byazt.wt.a.hw((String) null);
            }

            @Override // com.byazt.hh.hn
            public String uc() {
                if (zo.nt().i()) {
                    return com.byazt.qn.x.pr(null, "gm_tt_mediation_ppe_info").getString("tt_ppe_content", "");
                }
                return null;
            }

            @Override // com.byazt.hh.hn
            public boolean fw() {
                return !zo.nt().pr();
            }

            @Override // com.byazt.hh.hn
            public int zo() {
                return com.byazt.sd.rc.pr;
            }
        }).pr();
    }
}
