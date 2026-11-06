package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.m.a.m;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.dh;
import com.byazt.gct.j;
import com.byazt.gct.pe;
import com.byazt.ikv.n;
import com.byazt.mw.qg;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.pj.x;
import com.byazt.qp.q;
import com.byazt.rv.s;
import com.byazt.tk.h;
import com.byazt.tk.hd;
import com.byazt.vf.oa;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String dw;
    private String fl;
    private String ha;
    private String i;
    private int su;
    private final int kc = 10111;
    private final int z = 10112;
    private final int dn = 10113;
    private final int he = 10114;
    private final int el = 10115;
    private final int vb = 10116;

    @Override // com.byazt.df.TTBaseVideoActivity
    public boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (cx.hd(this.ae)) {
            this.dg.s(s.qg);
            s.s = false;
            s.qg = 0;
            s.n = this.dg.dg();
            s(0);
        }
        if (cx.um(this.ae) && s.q) {
            i();
            q(4);
        }
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public String n() {
        return this.ha;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void n(Intent intent) {
        super.n(intent);
        if (intent == null) {
            return;
        }
        this.fl = intent.getStringExtra("media_extra");
        this.i = intent.getStringExtra("user_id");
        this.dw = intent.getStringExtra("reward_name");
        this.ha = intent.getStringExtra("userData");
        this.su = intent.getIntExtra("reward_amount", 0);
        this.ci.n(intent.getBooleanExtra("is_play_again", false));
        this.ci.n(intent.getIntExtra("play_again_count", 0));
        this.ci.qg(intent.getBooleanExtra("custom_play_again", false));
        this.ci.qg(intent.getIntExtra("source_rit_id", 0));
        this.ci.n(intent.getStringExtra("reward_again_name"));
        this.ci.qg(intent.getStringExtra("reward_again_amount"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public boolean n(Bundle bundle) {
        com.byazt.gwu.s sVarN = n.n();
        sVarN.n("is_reward_deep_link_to_live", false);
        sVarN.n("click_to_live_duration", System.currentTimeMillis());
        return super.n(bundle);
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public void py() {
        super.py();
        z();
    }

    public void z() {
        if (j.qg(t(), this.ae, true)) {
            if (this.ic.n() > this.dg.oj()) {
                this.ic.n(false);
            }
            int iMax = Math.max(this.dg.w(true) - this.ic.n(), 0);
            int iW = this.dg.w(false) - this.ic.n();
            if (this.dg.rv(false)) {
                iW = Math.max(0, iW - iMax);
            }
            if (this.q.containsKey(0)) {
                iMax = m.h;
                iW = 999;
            }
            cp(iW);
            d(iMax);
            if (this.q.containsKey(0)) {
                s(0, true);
            }
            hf();
        }
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public int ln() {
        if (this.su != 0 && !TextUtils.isEmpty(this.dw)) {
            return this.su;
        }
        if (cx.qg(this.ae) == 0 || TextUtils.isEmpty(cx.n(this.ae))) {
            return 0;
        }
        return cx.qg(this.ae);
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public String lh() {
        if (this.su == 0 || TextUtils.isEmpty(this.dw)) {
            return (cx.qg(this.ae) == 0 || TextUtils.isEmpty(cx.n(this.ae))) ? "" : cx.n(this.ae);
        }
        return this.dw;
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public String v() {
        if (this.ci.n() && !TextUtils.isEmpty(this.ci.x()) && !TextUtils.isEmpty(this.ci.w())) {
            return this.ci.x();
        }
        return new StringBuilder().append(ln()).toString();
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public String j() {
        if (this.ci.n() && !TextUtils.isEmpty(this.ci.x()) && !TextUtils.isEmpty(this.ci.w())) {
            return this.ci.w();
        }
        return lh();
    }

    private void he() {
        if (cx.x(this.ae) && this.fi.a() >= cx.tj(this.ae)) {
            if (this.dg.x() && this.lh != null && this.lh.fs() == 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("toast_text", cx.rv(this.ae));
                    this.lh.n("showToast", jSONObject);
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            com.byazt.okk.s.n(this.u, cx.rv(this.ae), 0);
        }
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public void sh() {
        super.sh();
        if (cx.hd(this.ae) || this.an.ln() || cd.q(this.ae)) {
            return;
        }
        if (this.fi.lh()) {
            this.j.n(false, null, null, true, true);
            return;
        }
        int iW = this.dg.w(true);
        int iW2 = this.dg.w(j.qg(t(), this.ae, true));
        if (cx.q()) {
            iW2 = iW;
        }
        if (dn() || this.dg.um()) {
            this.j.n(false, iW2 > 0 ? iW2 + com.anythink.core.common.s.a : "已领取奖励", "跳过", false, true);
        } else {
            this.j.n(false, iW2 > 0 ? iW2 + com.anythink.core.common.s.a : "已领取奖励", null, false, false);
        }
        this.dg.qg(iW);
    }

    public boolean dn() {
        return Math.round(((float) (this.fi.bb() + (((long) this.dg.rf()) * 1000))) / 1000.0f) >= this.dg.dh();
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void s(int i) {
        if (i != 0) {
            q(i);
            return;
        }
        if (this.dg.oj() > 0) {
            return;
        }
        if ((!cx.t(this.ae) || this.w.get()) && this.dg.an()) {
            q(i);
        }
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void q(final int i) {
        if (!this.cy.getAndSet(true)) {
            this.ci.q();
        }
        if (this.q.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.q.put(Integer.valueOf(i), Boolean.TRUE);
        this.oj.s();
        boolean z = !cx.hu(this.ae);
        final int iLn = ln();
        final String strLh = lh();
        int iFl = fl();
        boolean z2 = iFl == 0;
        if (!z2 || z) {
            s(n(i, z2, iFl, "reward failed", iLn, strLh, false));
            s(i, z2);
        } else {
            s(i, true);
            rv.n().n(qg(i, true), new com.byazt.mw.n.l() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
                @Override // com.byazt.mw.n.l
                public void n(int i2, String str) {
                    TTRewardVideoActivity.this.s(TTRewardVideoActivity.this.n(i, false, i2, str, iLn, strLh, false));
                }

                @Override // com.byazt.mw.n.l
                public void n(qg.q qVar) {
                    int iN = qVar.s.n();
                    String strQg = qVar.s.qg();
                    TTRewardVideoActivity.this.s(qVar.qg ? TTRewardVideoActivity.this.n(i, true, 10111, "reward failed", iN, strQg, true) : TTRewardVideoActivity.this.n(i, false, 10112, "server refuse", iN, strQg, true));
                }
            });
        }
    }

    @DungeonFlag
    private JSONObject qg(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", lh());
            jSONObject.put("reward_amount", ln());
            jSONObject.put("network", hd.s(rv.getContext()));
            jSONObject.put("sdk_version", tj.w);
            jSONObject.put("user_agent", ((oa) q.n("device_info_new")).qg(false));
            jSONObject.put("extra", this.ae.A_());
            jSONObject.put("media_extra", this.fl);
            jSONObject.put("video_duration", this.fi.t());
            jSONObject.put("play_start_ts", this.dh);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.fi.a());
            jSONObject.put("user_id", this.i);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put(MediationConstant.BAIDU_REWARD_TYPE, i);
            jSONObject.putOpt("rs_info", el());
            if (cx.q(this.ae)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.byazt.hnb.n.n(jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Object el() {
        Map<String, Object> mapWl;
        if (this.ae == null || (mapWl = this.ae.wl()) == null || !mapWl.containsKey("rs_info")) {
            return null;
        }
        return mapWl.get("rs_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle n(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", cx.n(this.ae, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && cx.x(this.ae) && this.fi.a() >= cx.tj(this.ae)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public void fs(int i) {
        if (!this.q.containsKey(0)) {
            this.qg.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    h.n(TTRewardVideoActivity.this.u, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (pe.n(this.ae)) {
            this.qg.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    h.n(TTRewardVideoActivity.this.u, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.ci.s(i);
        }
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public void qg() {
        if (!this.ic.l() && this.q.containsKey(0) && this.ci.s(2)) {
            return;
        }
        super.qg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void ur() {
        if (this.s.getAndSet(true) || this.ci.n()) {
            return;
        }
        if ((this.pe == null || !this.pe.s()) && !j.qg(t(), this.ae, true)) {
            Bundle bundle = new Bundle();
            if (this.e.get()) {
                bundle.putBoolean("send_show_event_result", this.e.get());
            }
            if (this.yw.get()) {
                bundle.putBoolean("send_click_event_result", this.yw.get());
            }
            n("onAdClose", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ci.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void s(boolean z) {
        int i;
        if (this.hu) {
            if (rv.qg().ts() == 1) {
                i = 2000;
            } else {
                i = -1;
            }
        } else if (z) {
            i = 0;
        } else {
            i = -1;
        }
        int i2 = this.ci.n() ? -1 : i;
        if (i2 < 0 || this.a.get()) {
            return;
        }
        if (i2 == 0) {
            if (this.a.getAndSet(true)) {
                return;
            }
            x.n().n(this.ae, String.valueOf(this.wo));
            return;
        }
        this.qg.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.a.getAndSet(true)) {
                    return;
                }
                x.n().n(TTRewardVideoActivity.this.ae, String.valueOf(TTRewardVideoActivity.this.wo));
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            qg("onRewardVerify", bundle);
        }
        qg("onRewardArrived", bundle);
        this.oj.n(bundle);
        this.dg.n(i);
    }

    private void qg(String str, Bundle bundle) {
        com.byazt.rv.qg.n(0, this.ci.n() ? dh.n(this.sh) : this.sh, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void n(String str, Bundle bundle) {
        qg(str, bundle);
    }

    private boolean vb() {
        if (TextUtils.isEmpty(this.ae.ou())) {
            return false;
        }
        return this.e.get();
    }

    @DungeonFlag
    private int fl() {
        final int i = 0;
        if (cx.q(this.ae)) {
            if (this.sz.get()) {
                i = 10116;
            } else if (!vb()) {
                i = 10111;
            }
        }
        if (rv.qg().ys() == 0) {
            return i;
        }
        boolean zRv = com.byazt.cl.s.rv();
        int iQg = com.byazt.cl.s.qg(this.ae.ff() + "_" + this.ae.xf());
        if (zRv) {
            i = 10115;
        } else if (iQg == com.byazt.cl.s.qg) {
            i = 10114;
        } else if (iQg == com.byazt.cl.s.s) {
            i = 10113;
        }
        com.byazt.eji.s.n().n("armor_reward", this.ae == null ? null : this.ae.ou(), new com.byazt.rs.n() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MediationConstant.KEY_ERROR_CODE, i);
                return jSONObject2;
            }
        });
        return i;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.an.an()) {
            return;
        }
        this.dg.n(i, i2, intent);
    }

    private void s(int i, boolean z) {
        if (i == 0) {
            this.lh.oa();
            this.df.qg(z);
            he();
            if (this.dg != null) {
                this.dg.oa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public boolean hu() {
        return super.hu() || this.ci.l();
    }

    private void i() {
        this.lh.n("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public boolean bb() {
        return this.ci.n() || this.ic.q();
    }
}
