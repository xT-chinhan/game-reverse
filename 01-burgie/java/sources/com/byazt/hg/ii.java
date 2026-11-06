package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1490})
public class ii {
    public int aj;
    public int c;
    public long fw;
    public int hn;
    public int hw;
    public of pr;
    public long uc;
    public int vk = 0;
    public int x;
    public long zo;

    public ii(of ofVar) {
        this.pr = ofVar;
    }

    public ii(of ofVar, JSONObject jSONObject) {
        this.pr = ofVar;
        if (jSONObject != null) {
            this.hw = jSONObject.optInt("req_type", 0);
            this.hn = jSONObject.optInt("load_type", 0);
            this.x = jSONObject.optInt("bidding_result", 0);
            this.c = jSONObject.optInt("reuse_count", 0);
            this.uc = jSONObject.optLong("object_create_time", 0L);
            this.fw = jSONObject.optLong("show_time", 0L);
            this.zo = jSONObject.optLong("final_ts", 0L);
            this.aj = jSONObject.optInt("final_status", 0);
        }
    }

    public void pr(JSONObject jSONObject, boolean z) {
        int iValueOf;
        int iValueOf2;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.pr.ja());
            jSONObject.put("ca_bid_rst", this.x);
            jSONObject.put("ca_reuse_cnt", this.c);
            jSONObject.put("ca_obj_ts", this.uc);
            jSONObject.put("ca_fnl_st", this.aj);
            jSONObject.put("ca_rpt_show_cnt", this.vk);
            jSONObject.put("ca_libra_group", zo.pr(com.byazt.wt.ls.k(this.pr)).m());
            jSONObject.put("ca_ad_index", this.pr.tc());
            if (z) {
                String str = this.pr.ny() + this.pr.x();
                Integer numRemove = com.byazt.ra.pr.hw().remove(str);
                if (numRemove != null) {
                    iValueOf = Integer.valueOf(numRemove.intValue() + 1);
                } else {
                    iValueOf = 1;
                }
                com.byazt.ra.pr.hw().put(str, iValueOf);
                jSONObject.put("meta_show_count", iValueOf);
                String str2 = com.byazt.wt.ls.g(this.pr) + this.pr.x();
                Integer numRemove2 = com.byazt.ra.pr.hn().remove(str2);
                if (numRemove2 != null) {
                    iValueOf2 = Integer.valueOf(numRemove2.intValue() + 1);
                } else {
                    iValueOf2 = 1;
                }
                com.byazt.ra.pr.hn().put(str2, iValueOf2);
                jSONObject.put("meta_origin_show_count", iValueOf2);
                com.byazt.ra.hn.pr(this.pr);
                JSONObject jSONObjectPr = com.byazt.ra.hn.pr(com.byazt.wt.ls.k(this.pr), this.pr.yn());
                if (jSONObjectPr != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObjectPr.toString());
                        int iK = com.byazt.wt.ls.k(this.pr);
                        zo.hn hnVarPr = zo.pr(iK);
                        zo.c cVarYb = hnVarPr != null ? hnVarPr.yb() : null;
                        if (cVarYb != null && cVarYb.hw() && cVarYb.hn() > 0) {
                            com.byazt.qe.hw hwVarP = this.pr.p();
                            long jPr = com.byazt.cf.hw.pr().pr(iK, hwVarP != null ? hwVarP.x() : null);
                            if (jPr > 0) {
                                jSONObject2.put("dynamic_tmax", jPr);
                            }
                            jSONObject2.put("dynamic_tmax_type", cVarYb.c());
                        }
                        jSONObjectPr = jSONObject2;
                    } catch (Throwable th) {
                    }
                    jSONObject.put("ca_interval_info", jSONObjectPr);
                }
            }
        } catch (JSONException e) {
        }
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("req_type", this.hw);
            jSONObject.put("load_type", this.hn);
            jSONObject.put("bidding_result", this.x);
            jSONObject.put("reuse_count", this.c);
            jSONObject.put("object_create_time", this.uc);
            jSONObject.put("show_time", this.fw);
            jSONObject.put("final_ts", this.zo);
            jSONObject.put("final_status", this.aj);
            jSONObject.put("show_count", this.vk);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public void hw(int i) {
        this.hn = i;
        if (i == 2) {
            this.c++;
        }
    }

    public void hn(int i) {
        this.x = i;
    }

    public void hw() {
        this.uc = System.currentTimeMillis();
    }

    public void hn() {
        this.fw = System.currentTimeMillis();
        this.vk++;
        x(1);
    }

    public void x(int i) {
        this.aj = i;
        this.zo = System.currentTimeMillis();
    }
}
