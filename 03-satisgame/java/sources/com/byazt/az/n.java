package com.byazt.az;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.q;
import com.byazt.ng.l;
import com.byazt.np.d;
import com.byazt.q.AdBaseConstants;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qyu.PluginConstants;
import com.byazt.sg.s;
import com.byazt.vy.a;
import com.byazt.vy.hd;
import com.byazt.vy.hu;
import com.byazt.vy.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 964, 19})
public class n {
    public qg cd;
    public String cy;
    public long k;
    public com.byazt.qn.qg oa;
    public int qg;
    public int s;
    public s sz;
    public com.byazt.fd.n x;
    public boolean q = false;
    public boolean l = false;
    public long w = -1;
    public boolean fs = false;
    public boolean rv = false;
    public boolean tj = true;
    public int cp = -1;
    public String d = "";
    public AtomicInteger n = new AtomicInteger(1);
    public final com.byazt.fd.n hd = new com.byazt.fd.n() { // from class: com.byazt.az.n.1
        @Override // com.byazt.fd.n
        public boolean n() {
            return false;
        }

        @Override // com.byazt.fd.n
        public float qg() {
            if (n.this.oa != null) {
                return n.this.oa.t();
            }
            return 0.0f;
        }

        @Override // com.byazt.fd.n
        public String s() {
            return n.this.oa != null ? n.this.oa.h() : "";
        }

        @Override // com.byazt.fd.n
        @DungeonFlag
        public Map<String, Object> q() {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
            map.put("transId", n.this.cy);
            map.put(MediationConstant.KEY_REASON, 0);
            map.put("gromoreExtra", (n.this.oa == null || n.this.oa.an() == null) ? "" : n.this.oa.an().get("gromoreExtra"));
            map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(n.this.cp));
            map.put(MediationConstant.KEY_ERROR_MSG, n.this.d);
            com.byazt.mj.s sVarN = x.n(n.this.oa, n.this.sz, true);
            map.put(MediationConstant.KEY_ADN_NAME, sVarN != null ? sVarN.d() : "");
            map.put("ecpm", sVarN != null ? sVarN.oa() : "");
            return map;
        }
    };

    public interface qg {
        void n(com.byazt.fd.n nVar);
    }

    public n(String str) {
        com.byazt.ws.qg qgVarN;
        l lVarN = com.byazt.qt.qg.n();
        if (lVarN != null && (qgVarN = lVarN.n(str, 7, 101)) != null) {
            this.qg = qgVarN.pk();
            this.s = qgVarN.wo();
        }
        if (this.qg < 0) {
            this.qg = 15000;
        }
    }

    public boolean n() {
        boolean z = this.s == 1;
        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z)));
        return z;
    }

    public void qg() {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.l = true;
            }
        });
    }

    public void s() {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.q = true;
            }
        });
    }

    public void n(com.byazt.qn.qg qgVar, s sVar) {
        this.k = System.currentTimeMillis();
        this.oa = qgVar;
        this.sz = sVar;
        if (q()) {
            com.byazt.rb.qg.qg("GROMORE_SS_REWARD_VERIFY", "onAdnAdShow:开启了show强校验，先不进行15s逻辑->startPreRequest");
        } else {
            w();
        }
    }

    public boolean q() {
        s sVar = this.sz;
        if (sVar != null && sVar.bb() != null) {
            Map<String, Object> mapBb = this.sz.bb();
            if (!n(mapBb.get("isPangle"))) {
                return false;
            }
            Object obj = mapBb.get("isRDEnable");
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean n(Object obj) {
        if (MediationConstant.ADN_PANGLE.equals(this.sz.ci())) {
            return true;
        }
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public void n(com.byazt.fd.n nVar, s sVar) {
        if (q() && nVar != null && !nVar.n()) {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
            map.put("transId", this.cy);
            map.put(MediationConstant.KEY_REASON, 0);
            com.byazt.qn.qg qgVar = this.oa;
            Object obj = "";
            if (qgVar != null && qgVar.an() != null) {
                obj = this.oa.an().get("gromoreExtra");
            }
            map.put("gromoreExtra", obj);
            map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(q.n));
            map.put(MediationConstant.KEY_ERROR_MSG, "ADN 回调 rewardVerify:false");
            com.byazt.fd.n nVarN = d.n(this.oa, nVar, sVar, map);
            qg qgVar2 = this.cd;
            if (qgVar2 == null || this.rv) {
                return;
            }
            this.rv = true;
            qgVar2.n(nVarN);
            return;
        }
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (!n.this.q) {
                    n.this.fs = true;
                    if (n.this.x != null) {
                        if (n.this.cd == null || n.this.rv) {
                            return;
                        }
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                        n.this.rv = true;
                        n.this.cd.n(n.this.x);
                        return;
                    }
                    if (n.this.w == -1) {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                        n.this.w = SystemClock.elapsedRealtime();
                        if (n.this.tj) {
                            n.this.x();
                        } else {
                            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                        }
                    } else if (SystemClock.elapsedRealtime() - n.this.w > 2000) {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                        if (n.this.tj) {
                            n.this.x();
                        } else {
                            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                        }
                    }
                    com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!n.this.q) {
                                if (n.this.cd == null || n.this.rv) {
                                    return;
                                }
                                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                                n.this.rv = true;
                                n.this.cd.n(n.this.x != null ? n.this.x : n.this.hd);
                                return;
                            }
                            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                        }
                    }, 3000L);
                    return;
                }
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
            }
        });
    }

    public void l() {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (!n.this.q) {
                    if (n.this.x != null || n.this.rv) {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经有响应(" + (n.this.x != null) + ")或已经给出开发者回调(" + n.this.rv + "), 直接return");
                        return;
                    }
                    if (n.this.w == -1) {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                        n.this.w = SystemClock.elapsedRealtime();
                        if (n.this.tj) {
                            n.this.x();
                            return;
                        } else {
                            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    if (SystemClock.elapsedRealtime() - n.this.w > 2000) {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                        if (n.this.tj) {
                            n.this.x();
                            return;
                        } else {
                            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    return;
                }
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void n(oa oaVar, boolean z, long j) {
        if (this.q) {
            return;
        }
        if (oaVar == null) {
            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            n(-1, "response is null", z);
            return;
        }
        int iN = oaVar.n();
        if (hu.n(oaVar)) {
            String strN = hu.n(oaVar.q());
            if (!TextUtils.isEmpty(strN)) {
                try {
                    this.cp = AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                    n(new JSONObject(strN), z, j);
                    return;
                } catch (Throwable th) {
                    this.cp = 1;
                    n(-1, th.getMessage(), z);
                    return;
                }
            }
            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
            n(iN, "data is empty", z);
            return;
        }
        try {
            JSONObject jSONObjectL = oaVar.l();
            int iOptInt = jSONObjectL.optInt("cypher", -1);
            String strOptString = jSONObjectL.optString("message");
            this.cp = jSONObjectL.optInt("code");
            this.d = jSONObjectL.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
            int i = this.cp;
            if (i == 50001) {
                this.tj = true;
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                n(this.cp, this.d, z);
                return;
            }
            if (i != 0 && i != 20000) {
                this.tj = false;
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.cp + ", msg: " + this.d + "，不能再重试");
                n(this.cp, this.d, z);
                return;
            }
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject = null;
                if (iOptInt == 2) {
                    String strN2 = hu.n(strOptString);
                    if (!TextUtils.isEmpty(strN2)) {
                        jSONObject = new JSONObject(strN2);
                    }
                } else if (iOptInt == 1) {
                    String strQg = com.byazt.vy.n.qg(strOptString, com.byazt.vy.qg.n());
                    if (!TextUtils.isEmpty(strQg)) {
                        jSONObject = new JSONObject(strQg);
                    }
                } else if (iOptInt == 0) {
                    jSONObject = new JSONObject(strOptString);
                }
                n(jSONObject, z, j);
                return;
            }
            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
            n(iN, "message is null", z);
        } catch (Throwable th2) {
            n(-1, th2.getMessage(), z);
        }
    }

    @DungeonFlag
    private void n(JSONObject jSONObject, boolean z, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
            final boolean zOptBoolean = jSONObject.optBoolean("is_verify");
            final int iOptInt = jSONObject.optInt(MediationConstant.KEY_REASON);
            final String strOptString = jSONObject.optString("reward_name");
            final int iOptInt2 = jSONObject.optInt("reward_amount");
            this.x = new com.byazt.fd.n() { // from class: com.byazt.az.n.6
                @Override // com.byazt.fd.n
                public boolean n() {
                    return zOptBoolean;
                }

                @Override // com.byazt.fd.n
                public float qg() {
                    return iOptInt2;
                }

                @Override // com.byazt.fd.n
                public String s() {
                    return strOptString;
                }

                @Override // com.byazt.fd.n
                @DungeonFlag
                public Map<String, Object> q() {
                    HashMap map = new HashMap();
                    map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                    map.put("transId", n.this.cy);
                    map.put(MediationConstant.KEY_REASON, Integer.valueOf(iOptInt));
                    map.put("gromoreExtra", (n.this.oa == null || n.this.oa.an() == null) ? "" : n.this.oa.an().get("gromoreExtra"));
                    map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(n.this.cp));
                    map.put(MediationConstant.KEY_ERROR_MSG, n.this.d);
                    com.byazt.mj.s sVarN = x.n(n.this.oa, n.this.sz, true);
                    map.put(MediationConstant.KEY_ADN_NAME, sVarN != null ? sVarN.d() : "");
                    map.put("ecpm", sVarN != null ? sVarN.oa() : "");
                    return map;
                }
            };
            if (this.fs && this.cd != null && !this.rv) {
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
                this.rv = true;
                this.cd.n(this.x);
            }
            n(z, jCurrentTimeMillis);
            return;
        }
        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
        n(-1, "data is null", z);
    }

    private void n(boolean z, long j) {
        a.n(z ? "v4Enc_reward" : "v2Enc_reward", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, boolean z) {
        a.n(z ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i + "，msg = " + str);
    }

    private void w() {
        com.byazt.rb.qg.qg("GROMORE_SS_REWARD_VERIFY", "startPreRequest:CSJ代码位没有开启show强校验，执行15s逻辑->startPreRequest");
        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.7
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.w != -1 || n.this.q || n.this.l) {
                    com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                n.this.x();
                com.byazt.rb.l.n(n.this.new RunnableC0132n(1), 3000L);
                com.byazt.rb.l.n(n.this.new RunnableC0132n(2), 6000L);
                com.byazt.rb.l.n(n.this.new RunnableC0132n(3), 9000L);
            }
        }, this.qg);
    }

    /* JADX INFO: renamed from: com.byazt.az.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 964, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class RunnableC0132n implements Runnable {
        public final int qg;

        public RunnableC0132n(int i) {
            this.qg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.x != null || n.this.rv || !n.this.tj || n.this.q || n.this.l) {
                return;
            }
            com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.qg + "次重试请求");
            n.this.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void x() {
        rv rvVarQ = com.byazt.phf.s.q(com.byazt.qt.s.q());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String strFs = com.byazt.qt.n.d().fs();
        if (!TextUtils.isEmpty(strFs)) {
            rvVarQ.n("X-Tt-Env", strFs);
            rvVarQ.n("x-use-ppe", "1");
        }
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.sg.qg.n);
        final boolean z = !com.byazt.qt.qg.n().w();
        if (z) {
            rvVarQ.n("x-pglcypher", "4");
            rvVarQ.n(hu.qg(n(true)));
        } else {
            rvVarQ.qg(n(false));
        }
        rvVarQ.n(new com.byazt.qk.x() { // from class: com.byazt.az.n.8
            @Override // com.byazt.qk.x
            public void n(final oa oaVar) {
                com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n(oaVar, z, jCurrentTimeMillis);
                    }
                });
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, final Throwable th) {
                com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.az.n.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.rb.qg.n("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + th.toString());
                        n.this.n(-2, "request error" + th.getMessage(), z);
                    }
                });
            }
        });
    }

    @DungeonFlag
    private String n(boolean z) {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", com.byazt.sg.qg.n());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.sg.qg.s());
            jSONObject.put("user_agent", com.byazt.sg.qg.n);
            jSONObject.put("try_value", this.n.getAndIncrement());
            jSONObject.put("network", hd.qg());
            jSONObject.put("play_start_ts", this.k);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.byazt.qn.qg qgVar = this.oa;
            jSONObject.put("user_id", qgVar != null ? qgVar.bb() : "");
            if (TextUtils.isEmpty(this.cy)) {
                string = UUID.randomUUID().toString();
                this.cy = string;
            } else {
                string = this.cy;
            }
            jSONObject.put("trans_id", string);
            com.byazt.qn.qg qgVar2 = this.oa;
            jSONObject.put("link_id", qgVar2 != null ? qgVar2.n() : "");
            com.byazt.qn.qg qgVar3 = this.oa;
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, qgVar3 != null ? qgVar3.a() : "");
            s sVar = this.sz;
            jSONObject.put("adn_rit", sVar != null ? sVar.el() : "");
            com.byazt.qn.qg qgVar4 = this.oa;
            jSONObject.put("reward_name", qgVar4 != null ? qgVar4.h() : "");
            com.byazt.qn.qg qgVar5 = this.oa;
            jSONObject.put("reward_amount", qgVar5 != null ? qgVar5.t() : 0);
            jSONObject.putOpt("rs_info", fs());
            com.byazt.qn.qg qgVar6 = this.oa;
            jSONObject.put("media_extra", (qgVar6 == null || qgVar6.an() == null) ? "" : this.oa.an().get("gromoreExtra"));
            com.byazt.qn.qg qgVar7 = this.oa;
            if (qgVar7 != null && qgVar7.py() != null) {
                jSONObject.put("scenario_id", this.oa.py());
            }
            com.byazt.mj.s sVarN = x.n(this.oa, this.sz, true);
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, sVarN != null ? sVarN.d() : "");
            jSONObject.put("ecpm", sVarN != null ? sVarN.oa() : "");
        } catch (JSONException unused) {
        }
        if (z) {
            return jSONObject.toString();
        }
        return hu.n(jSONObject).toString();
    }

    private Object fs() {
        Map<String, Object> mapBb;
        s sVar = this.sz;
        if (sVar == null || (mapBb = sVar.bb()) == null || !mapBb.containsKey("rs_info")) {
            return null;
        }
        return mapBb.get("rs_info");
    }

    public void n(qg qgVar) {
        this.cd = qgVar;
    }
}
