package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ca.b;
import com.byazt.ca.yb;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hb.uc;
import com.byazt.hg.hs;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.o;
import com.byazt.hg.ww;
import com.byazt.joa.pr;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.sd.hw;
import com.byazt.sd.iu;
import com.byazt.sd.rc;
import com.byazt.vh.fw;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.zq.hn;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.DownloadTask;
import com.umeng.analytics.pro.an;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String bh;
    private String cr;
    private String iy;
    private String j;
    private int qo;
    private final int gu = 10111;
    private final int d = 10112;
    private final int pq = 10113;
    private final int jw = 10114;
    private final int wt = 10115;
    private final int aa = 10116;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (jn.yb(this.s)) {
            this.qi.hn(uc.hw);
            uc.hn = false;
            uc.hw = 0;
            uc.pr = this.qi.qi();
            hn(0);
        }
        if (jn.qa(this.s) && uc.x) {
            j();
            x(4);
        }
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public String pr() {
        return this.bh;
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public boolean iu() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void pr(Intent intent) {
        super.pr(intent);
        if (intent == null) {
            return;
        }
        this.iy = intent.getStringExtra("media_extra");
        this.cr = intent.getStringExtra(Common.System.USER_ID);
        this.j = intent.getStringExtra("reward_name");
        this.bh = intent.getStringExtra("userData");
        this.qo = intent.getIntExtra("reward_amount", 0);
        this.mw.pr(intent.getBooleanExtra("is_play_again", false));
        this.mw.pr(intent.getIntExtra("play_again_count", 0));
        this.mw.hw(intent.getBooleanExtra("custom_play_again", false));
        this.mw.hw(intent.getIntExtra("source_rit_id", 0));
        this.mw.pr(intent.getStringExtra("reward_again_name"));
        this.mw.hw(intent.getStringExtra("reward_again_amount"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public boolean pr(Bundle bundle) {
        hn hnVarPr = hw.pr();
        hnVarPr.pr("is_reward_deep_link_to_live", false);
        hnVarPr.pr("click_to_live_duration", System.currentTimeMillis());
        return super.pr(bundle);
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public void cz() {
        super.cz();
        pq();
    }

    public void pq() {
        if (ww.hw(iu(), this.s, true)) {
            if (this.vj.pr() > this.qi.er()) {
                this.vj.pr(false);
            }
            int iMax = Math.max(this.qi.uc(true) - this.vj.pr(), 0);
            int iUc = this.qi.uc(false) - this.vj.pr();
            if (this.qi.zo(false)) {
                iUc = Math.max(0, iUc - iMax);
            }
            if (this.x.containsKey(0)) {
                iMax = 999;
                iUc = 999;
            }
            w(iUc);
            k(iMax);
            if (this.x.containsKey(0)) {
                hn(0, true);
            }
            gu();
        }
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public int nl() {
        if (this.qo != 0 && !TextUtils.isEmpty(this.j)) {
            return this.qo;
        }
        if (jn.hw(this.s) != 0 && !TextUtils.isEmpty(jn.pr(this.s))) {
            return jn.hw(this.s);
        }
        return 0;
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public String y() {
        if (this.qo != 0 && !TextUtils.isEmpty(this.j)) {
            return this.j;
        }
        if (jn.hw(this.s) != 0 && !TextUtils.isEmpty(jn.pr(this.s))) {
            return jn.pr(this.s);
        }
        return "";
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public String ww() {
        if (this.mw.pr() && !TextUtils.isEmpty(this.mw.fw()) && !TextUtils.isEmpty(this.mw.uc())) {
            return this.mw.fw();
        }
        return new StringBuilder().append(nl()).toString();
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public String n() {
        if (this.mw.pr() && !TextUtils.isEmpty(this.mw.fw()) && !TextUtils.isEmpty(this.mw.uc())) {
            return this.mw.uc();
        }
        return y();
    }

    private void wt() {
        if (!jn.fw(this.s) || this.ls.a() < jn.vk(this.s)) {
            return;
        }
        if (this.qi.fw() && this.nl != null && this.nl.zo() == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("toast_text", jn.aj(this.s));
                this.nl.pr("showToast", jSONObject);
                return;
            } catch (JSONException e) {
                return;
            }
        }
        er.pr(this.qn, jn.aj(this.s), 0);
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public void r() {
        super.r();
        if (jn.yb(this.s) || this.n.nl() || lb.x(this.s)) {
            return;
        }
        if (this.ls.y()) {
            this.ww.pr(false, null, null, true, true);
            return;
        }
        int iUc = this.qi.uc(true);
        int iUc2 = this.qi.uc(ww.hw(iu(), this.s, true));
        if (jn.x()) {
            iUc2 = iUc;
        }
        if (jw() || this.qi.lb()) {
            this.ww.pr(false, iUc2 > 0 ? iUc2 + an.aB : "已领取奖励", "跳过", false, true);
        } else {
            this.ww.pr(false, iUc2 > 0 ? iUc2 + an.aB : "已领取奖励", null, false, false);
        }
        this.qi.hw(iUc);
    }

    public boolean jw() {
        return Math.round(((float) (this.ls.gz() + (((long) this.qi.hs()) * 1000))) / 1000.0f) >= this.qi.nw();
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void hn(int i) {
        if (i != 0) {
            x(i);
            return;
        }
        if (this.qi.er() > 0) {
            return;
        }
        if ((jn.iu(this.s) && !this.uc.get()) || !this.qi.n()) {
            return;
        }
        x(i);
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void x(final int i) {
        boolean z;
        if (!this.nt.getAndSet(true)) {
            this.mw.x();
        }
        if (this.x.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.x.put(Integer.valueOf(i), Boolean.TRUE);
        this.v.hn();
        boolean z2 = !jn.z(this.s);
        final int iNl = nl();
        final String strY = y();
        int iCr = cr();
        if (iCr == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || z2) {
            hn(pr(i, z, iCr, "reward failed", iNl, strY, false));
            hn(i, z);
        } else {
            hn(i, true);
            a.pr().pr(hw(i, true), new fo.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
                @Override // com.byazt.sd.fo.c
                public void pr(int i2, String str) {
                    TTRewardVideoActivity.this.hn(TTRewardVideoActivity.this.pr(i, false, i2, str, iNl, strY, false));
                }

                @Override // com.byazt.sd.fo.c
                public void pr(rc.x xVar) {
                    int iPr = xVar.hn.pr();
                    String strHw = xVar.hn.hw();
                    TTRewardVideoActivity.this.hn(xVar.hw ? TTRewardVideoActivity.this.pr(i, true, 10111, "reward failed", iPr, strHw, true) : TTRewardVideoActivity.this.pr(i, false, 10112, "server refuse", iPr, strHw, true));
                }
            });
        }
    }

    @DungeonFlag
    private JSONObject hw(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", y());
            jSONObject.put("reward_amount", nl());
            jSONObject.put("network", yb.hn(a.getContext()));
            jSONObject.put("sdk_version", iu.c);
            jSONObject.put("user_agent", ((g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
            jSONObject.put("extra", this.s.v_());
            jSONObject.put("media_extra", this.iy);
            jSONObject.put(Constants.VIDEO_DURATION_FIELD, this.ls.iu());
            jSONObject.put("play_start_ts", this.nw);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.ls.a());
            jSONObject.put(Common.System.USER_ID, this.cr);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put(MediationConstant.BAIDU_REWARD_TYPE, i);
            jSONObject.putOpt("rs_info", aa());
            if (jn.x(this.s)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.byazt.igw.hw.pr(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    private Object aa() {
        Map<String, Object> mapZc;
        if (this.s == null || (mapZc = this.s.zc()) == null || !mapZc.containsKey("rs_info")) {
            return null;
        }
        return mapZc.get("rs_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle pr(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", jn.pr(this.s, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && jn.fw(this.s) && this.ls.a() >= jn.vk(this.s)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public void zo(int i) {
        if (!this.x.containsKey(0)) {
            this.hw.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    b.pr(TTRewardVideoActivity.this.qn, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (o.pr(this.s)) {
            this.hw.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    b.pr(TTRewardVideoActivity.this.qn, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.mw.hn(i);
        }
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public void hw() {
        if (!this.vj.c() && this.x.containsKey(0) && this.mw.hn(2)) {
            return;
        }
        super.hw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void ve() {
        if (this.hn.getAndSet(true) || this.mw.pr()) {
            return;
        }
        if ((this.bm != null && this.bm.hn()) || ww.hw(iu(), this.s, true)) {
            return;
        }
        Bundle bundle = new Bundle();
        if (this.jn.get()) {
            bundle.putBoolean("send_show_event_result", this.jn.get());
        }
        if (this.l.get()) {
            bundle.putBoolean("send_click_event_result", this.l.get());
        }
        pr("onAdClose", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mw.hn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void hn(boolean z) {
        int i;
        if (!this.rc) {
            i = z ? 0 : -1;
        } else if (a.hw().to() != 1) {
            i = -1;
        } else {
            i = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
        }
        int i2 = this.mw.pr() ? -1 : i;
        if (i2 >= 0 && !this.a.get()) {
            if (i2 == 0) {
                if (!this.a.getAndSet(true)) {
                    fw.pr().pr(this.s, String.valueOf(this.ii));
                    return;
                }
                return;
            }
            this.hw.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!TTRewardVideoActivity.this.a.getAndSet(true)) {
                        fw.pr().pr(TTRewardVideoActivity.this.s, String.valueOf(TTRewardVideoActivity.this.ii));
                    }
                }
            }, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            hw("onRewardVerify", bundle);
        }
        hw("onRewardArrived", bundle);
        this.v.pr(bundle);
        this.qi.pr(i);
    }

    private void hw(String str, Bundle bundle) {
        pr.pr(0, this.mw.pr() ? hs.pr(this.i) : this.i, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void pr(String str, Bundle bundle) {
        hw(str, bundle);
    }

    private boolean iy() {
        if (!TextUtils.isEmpty(this.s.ny())) {
            return this.jn.get();
        }
        return false;
    }

    @DungeonFlag
    private int cr() {
        final int i = 0;
        if (jn.x(this.s)) {
            if (this.g.get()) {
                i = 10116;
            } else if (!iy()) {
                i = 10111;
            }
        }
        if (a.hw().da() == 0) {
            return i;
        }
        boolean zAj = com.byazt.wt.rc.aj();
        int iHw = com.byazt.wt.rc.hw(this.s.da() + "_" + this.s.kp());
        if (zAj) {
            i = 10115;
        } else if (iHw == com.byazt.wt.rc.hw) {
            i = 10114;
        } else if (iHw == com.byazt.wt.rc.hn) {
            i = 10113;
        }
        com.byazt.xk.hw.pr().pr("armor_reward", this.s == null ? null : this.s.ny(), new com.byazt.ttf.pr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
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
        if (this.n.e()) {
            return;
        }
        this.qi.pr(i, i2, intent);
    }

    private void hn(int i, boolean z) {
        if (i == 0) {
            this.nl.m();
            this.er.hw(z);
            wt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public boolean z() {
        return super.z() || this.mw.c();
    }

    private void j() {
        this.nl.pr("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public boolean gz() {
        return this.mw.pr() || this.vj.x();
    }
}
