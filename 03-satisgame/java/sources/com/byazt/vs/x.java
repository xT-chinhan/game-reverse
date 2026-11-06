package com.byazt.vs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, 21})
public class x extends com.byazt.cf.q<JSONObject, JSONObject> {
    public WeakReference<com.byazt.gcl.s> n;

    @Override // com.byazt.cf.q
    public void q() {
    }

    public static void n(com.byazt.cf.cy cyVar, final com.byazt.gcl.s sVar) {
        cyVar.n("commonConvert", new com.byazt.cf.q.qg() { // from class: com.byazt.vs.x.1
            @Override // com.byazt.cf.q.qg
            public com.byazt.cf.q n() {
                return new x(sVar);
            }
        });
    }

    public x(com.byazt.gcl.s sVar) {
        this.n = new WeakReference<>(sVar);
    }

    @Override // com.byazt.cf.q
    public void n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        com.byazt.ul.n nVarFl;
        JSONObject jSONObjectQg;
        com.byazt.eji.s sVarN;
        int i;
        com.byazt.vyf.s.cy().pk();
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.gct.pk pkVarN = null;
        try {
            WeakReference<com.byazt.gcl.s> weakReference = this.n;
            if (weakReference == null) {
                com.byazt.eji.s.n().n("commonConvert", "js", 1, jSONObject2);
            } else {
                com.byazt.gcl.s sVar = weakReference.get();
                if (sVar == null) {
                    s();
                    sVarN = com.byazt.eji.s.n();
                    i = 2;
                } else if (jSONObject == null) {
                    sVarN = com.byazt.eji.s.n();
                    i = 3;
                } else {
                    pkVarN = com.byazt.vgx.qg.n(jSONObject);
                    int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
                    int iOptInt2 = jSONObject.optInt("j_download_adapter_mode", 0);
                    int iOptInt3 = jSONObject.optInt("j_common_convert_source", 0);
                    if (pkVarN != null) {
                        pkVarN.n(true);
                        jSONObject2.putOpt("live_interaction_type", Integer.valueOf(pkVarN.l()));
                        jSONObject2.putOpt("ext", pkVarN.F_());
                        if (pkVarN.um() == null && (nVarFl = pkVarN.fl()) != null && (jSONObjectQg = nVarFl.qg()) != null) {
                            pkVarN.n(com.byazt.gct.sz.n(jSONObjectQg));
                        }
                        sVar.n(iOptInt3, pkVarN, iOptInt, iOptInt2);
                        com.byazt.eji.s.n().n("commonConvert", "js", 0, jSONObject2);
                        com.byazt.wq.qg.n().q(pkVarN);
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("code", 200);
                            n(jSONObject3);
                            return;
                        } catch (Exception e) {
                            e.getMessage();
                            return;
                        }
                    }
                    sVarN = com.byazt.eji.s.n();
                    i = 4;
                }
                sVarN.n("commonConvert", "js", i, jSONObject2);
            }
            com.byazt.wq.qg.n().q(pkVarN);
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.byazt.eji.s.n().n("commonConvert", "js", 0, jSONObject2);
            com.byazt.wq.qg.n().q(null);
            throw th;
        }
    }
}
