package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1695})
public class sh {
    public long fs;
    public int l;
    public pk n;
    public int q;
    public int qg;
    public int rv;
    public int s;
    public long w;
    public long x;
    public int tj = 0;
    public long cp = 0;
    public long d = 0;

    public sh(pk pkVar) {
        this.n = pkVar;
    }

    public sh(pk pkVar, JSONObject jSONObject) {
        this.n = pkVar;
        if (jSONObject != null) {
            this.qg = jSONObject.optInt(com.anythink.core.common.f.h.b.c, 0);
            this.s = jSONObject.optInt("load_type", 0);
            this.q = jSONObject.optInt("bidding_result", 0);
            this.l = jSONObject.optInt("reuse_count", 0);
            this.w = jSONObject.optLong("object_create_time", 0L);
            this.x = jSONObject.optLong("show_time", 0L);
            this.fs = jSONObject.optLong("final_ts", 0L);
            this.rv = jSONObject.optInt("final_status", 0);
        }
    }

    public void n(JSONObject jSONObject, boolean z) {
        int iValueOf;
        int iValueOf2;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ca_send_ts", this.n.vx());
            jSONObject.put("ca_bid_rst", this.q);
            jSONObject.put("ca_reuse_cnt", this.l);
            jSONObject.put("ca_obj_ts", this.w);
            jSONObject.put("ca_fnl_st", this.rv);
            jSONObject.put("ca_rpt_show_cnt", this.tj);
            jSONObject.put("ca_libra_group", fs.n(com.byazt.vgx.w.d(this.n)).oa());
            jSONObject.put("ca_ad_index", this.n.uc());
            if (z) {
                String str = this.n.ou() + this.n.q();
                Integer numRemove = com.byazt.msp.n.qg().remove(str);
                if (numRemove == null) {
                    iValueOf = 1;
                } else {
                    iValueOf = Integer.valueOf(numRemove.intValue() + 1);
                }
                com.byazt.msp.n.qg().put(str, iValueOf);
                jSONObject.put("meta_show_count", iValueOf);
                String str2 = com.byazt.vgx.w.hd(this.n) + this.n.q();
                Integer numRemove2 = com.byazt.msp.n.s().remove(str2);
                if (numRemove2 == null) {
                    iValueOf2 = 1;
                } else {
                    iValueOf2 = Integer.valueOf(numRemove2.intValue() + 1);
                }
                com.byazt.msp.n.s().put(str2, iValueOf2);
                jSONObject.put("meta_origin_show_count", iValueOf2);
                com.byazt.msp.s.n(this.n);
                JSONObject jSONObjectN = com.byazt.msp.s.n(com.byazt.vgx.w.d(this.n), this.n.mk());
                if (jSONObjectN != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObjectN.toString());
                        int iD = com.byazt.vgx.w.d(this.n);
                        fs.s sVarN = fs.n(iD);
                        fs.w wVarHd = sVarN != null ? sVarN.hd() : null;
                        if (wVarHd != null && wVarHd.n(iD) && wVarHd.qg() > 0) {
                            com.byazt.zq.qg qgVarXd = this.n.xd();
                            String strQ = qgVarXd != null ? qgVarXd.q() : null;
                            long jN = com.byazt.bh.qg.n().n(iD, strQ);
                            if (jN > 0) {
                                jSONObject2.put("dynamic_tmax", jN);
                            }
                            jSONObject2.put("dynamic_tmax_type", wVarHd.q());
                            jSONObject2.put("dynamic_tmax_cached_callback", com.byazt.bh.qg.n().q(iD, strQ));
                            jSONObject2.put("dynamic_tmax_cached", com.byazt.bh.qg.n().l(iD, strQ));
                        }
                        jSONObjectN = jSONObject2;
                    } catch (Throwable unused) {
                    }
                    jSONObject.put("ca_interval_info", jSONObjectN);
                }
            }
        } catch (JSONException unused2) {
        }
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.core.common.f.h.b.c, this.qg);
            jSONObject.put("load_type", this.s);
            jSONObject.put("bidding_result", this.q);
            jSONObject.put("reuse_count", this.l);
            jSONObject.put("object_create_time", this.w);
            jSONObject.put("show_time", this.x);
            jSONObject.put("final_ts", this.fs);
            jSONObject.put("final_status", this.rv);
            jSONObject.put("show_count", this.tj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void n(int i) {
        this.qg = i;
    }

    public void qg(int i) {
        this.s = i;
        if (i == 2) {
            this.l++;
        }
    }

    public void s(int i) {
        this.q = i;
    }

    public void qg() {
        this.w = System.currentTimeMillis();
    }

    public void s() {
        this.x = System.currentTimeMillis();
        this.tj++;
        q(1);
    }

    public void q(int i) {
        this.rv = i;
        this.fs = System.currentTimeMillis();
    }

    public void n(long j, long j2) {
        this.cp = j;
        this.d = j2;
    }

    public long q() {
        return this.cp;
    }

    public long l() {
        return this.d;
    }
}
