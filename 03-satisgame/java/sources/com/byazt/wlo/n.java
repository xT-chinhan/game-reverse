package com.byazt.wlo;

import com.byazt.gh.q;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1250, 19})
public class n extends com.byazt.qg.s<qg> implements com.byazt.wlo.qg {
    @Override // com.byazt.qg.s
    public String n() {
        return "";
    }

    public static n x() {
        return (n) n(n.class);
    }

    @Override // com.byazt.qg.s
    public String qg() {
        return rv.qg().yw();
    }

    @Override // com.byazt.qg.s
    public boolean s() {
        return rv.qg().e();
    }

    @Override // com.byazt.qg.s
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public qg n(JSONObject jSONObject, com.byazt.rr.rv rvVar) {
        return new qg(jSONObject, rvVar);
    }

    @Override // com.byazt.qg.s
    public void n(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("action", "init_feature_store");
        } catch (JSONException e) {
            k.qg("request_drop", "build init feature store params error:" + e.getMessage());
        }
        n(new C0386n(jSONObject), (com.byazt.qg.qg) null);
    }

    public void n(JSONObject jSONObject, com.byazt.wlo.qg.n nVar) {
        try {
            if (q.qg()) {
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                }
                jSONObject2.putOpt("action", "predict_exemption");
                jSONObject2.putOpt("feature_engine_data", com.byazt.aun.q.n().qg());
                jSONObject2.putOpt("feature_data_v2", com.byazt.aun.q.n().s());
                n(new C0386n(jSONObject2), new s(jSONObject2, nVar));
                return;
            }
            if (nVar != null) {
                com.byazt.wd.s sVar = new com.byazt.wd.s();
                sVar.n(-701);
                sVar.n(jSONObject);
                nVar.n(sVar);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("error", "pitaya not init");
            com.byazt.eji.s.n().s(jSONObject3);
        } catch (Exception e) {
            if (nVar != null) {
                com.byazt.wd.s sVar2 = new com.byazt.wd.s();
                sVar2.n(-702);
                sVar2.n(jSONObject);
                nVar.n(sVar2);
            }
            com.byazt.eji.s.n().n("exempt_pitaya", e);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1250, 829})
    public static class s implements com.byazt.qg.qg<qg> {
        public com.byazt.wlo.qg.n n;
        public JSONObject qg;

        public s(JSONObject jSONObject, com.byazt.wlo.qg.n nVar) {
            this.n = nVar;
            this.qg = jSONObject;
        }

        @Override // com.byazt.qg.qg
        public void n(qg qgVar, long j) {
            JSONObject jSONObject = new JSONObject();
            try {
                com.byazt.wlo.qg.n nVar = this.n;
                if (nVar != null && qgVar != null) {
                    com.byazt.wd.s sVar = new com.byazt.wd.s();
                    sVar.n(this.qg);
                    sVar.n(qgVar.n());
                    sVar.qg(qgVar.qg());
                    sVar.n(qgVar.s());
                    sVar.qg(j);
                    this.n.n(sVar);
                    jSONObject.putOpt("strategy_result", qgVar.qg());
                    jSONObject.putOpt("request_params", this.qg);
                    jSONObject.putOpt("cost_time", Long.valueOf(j));
                } else if (nVar == null) {
                    jSONObject.putOpt("error", "mListener is null");
                } else {
                    com.byazt.wd.s sVar2 = new com.byazt.wd.s();
                    sVar2.n(-703);
                    sVar2.n(this.qg);
                    sVar2.qg(j);
                    this.n.n(sVar2);
                    jSONObject.putOpt("error", "returnObject is null");
                    jSONObject.putOpt("cost_time", Long.valueOf(j));
                    jSONObject.putOpt("request_params", this.qg);
                }
            } catch (Exception e) {
                com.byazt.eji.s.n().n("exempt_pitaya", e);
            }
            com.byazt.eji.s.n().s(jSONObject);
        }

        @Override // com.byazt.qg.qg
        public void n(int i, String str, JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                if (this.n != null) {
                    com.byazt.wd.s sVar = new com.byazt.wd.s();
                    sVar.n(i);
                    sVar.n(this.qg);
                    sVar.qg(jSONObject);
                    sVar.qg(jSONObject.optLong("cost_time", -1L));
                    this.n.n(sVar);
                }
                jSONObject.putOpt("error_ad_request", str);
                jSONObject.putOpt("request_params", this.qg);
            } catch (Exception e) {
                com.byazt.eji.s.n().n("exempt_pitaya", e);
            }
            com.byazt.eji.s.n().s(jSONObject);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1250, 226})
    public static class qg {
        public boolean n;
        public JSONObject qg;
        public com.byazt.rr.rv s;

        public qg(JSONObject jSONObject, com.byazt.rr.rv rvVar) {
            JSONObject jSONObjectOptJSONObject;
            this.qg = jSONObject;
            this.s = rvVar;
            if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("result")) == null) {
                return;
            }
            this.n = jSONObjectOptJSONObject.optBoolean("need_pass", false);
        }

        public boolean n() {
            return this.n;
        }

        public JSONObject qg() {
            return this.qg;
        }

        public com.byazt.rr.rv s() {
            return this.s;
        }
    }

    /* JADX INFO: renamed from: com.byazt.wlo.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1250, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0386n implements com.byazt.qg.n {
        public JSONObject n;

        public C0386n(JSONObject jSONObject) {
            this.n = jSONObject;
        }

        @Override // com.byazt.qg.n
        public JSONObject n() {
            return this.n;
        }
    }
}
