package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.d.ms.xr;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.x.ms.ah;
import com.bytedance.sdk.component.x.xr.ms;
import com.bytedance.sdk.openadsdk.core.component.reward.ms.ka;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.of;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.op;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.x.d;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String ce;
    private int jm;
    private ah jy;
    private String qr;
    private String vl;
    private final int vm = 10111;
    private final int zf = 10112;
    private final int rt = 10113;
    private final int vy = 10114;
    private final int sk = 10115;
    private final int gy = 10116;
    private final AtomicBoolean bz = new AtomicBoolean();

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean op() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (qf.h(this.ka)) {
            this.lm.d(d.xr);
            d.ah = false;
            d.xr = 0;
            d.f3760ms = this.lm.az();
            ah(0);
        }
        if (qf.y(this.ka) && d.d) {
            gy();
            d(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void ah() {
        ah ahVar = new ah() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.component.x.ms.ah
            public void ms(String str, String str2) {
                if (TTRewardVideoActivity.this.ka != null) {
                    String strEu = TTRewardVideoActivity.this.ka.eu();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, strEu)) {
                        TTRewardVideoActivity.this.bz.set(true);
                    }
                }
            }
        };
        this.jy = ahVar;
        ms.ms(ahVar);
        super.ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void ms(Intent intent) {
        super.ms(intent);
        if (intent == null) {
            return;
        }
        this.vl = intent.getStringExtra("media_extra");
        this.qr = intent.getStringExtra("user_id");
        this.ce = intent.getStringExtra("reward_name");
        this.jm = intent.getIntExtra("reward_amount", 0);
        this.qk.ms(intent.getBooleanExtra("is_play_again", false));
        this.qk.ms(intent.getIntExtra("play_again_count", 0));
        this.qk.xr(intent.getBooleanExtra("custom_play_again", false));
        this.qk.xr(intent.getIntExtra("source_rit_id", 0));
        this.qk.ms(intent.getStringExtra("reward_again_name"));
        this.qk.xr(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean ms(Bundle bundle) {
        xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        xrVarMs.ms("is_reward_deep_link_to_live", false);
        xrVarMs.ms("click_to_live_duration", System.currentTimeMillis());
        return super.ms(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void nw() {
        super.nw();
        if (of.xr(op(), this.ka, true)) {
            if (this.v.ms() > this.lm.f()) {
                this.v.ms(false);
            }
            int iMax = Math.max(this.lm.c(true) - this.v.ms(), 0);
            int iC = this.lm.c(false) - this.v.ms();
            if (this.c.containsKey(0)) {
                iMax = 999;
                iC = 999;
            }
            ch(iC);
            hi(iMax);
            if (this.c.containsKey(0)) {
                ah(0, true);
            }
            this.v.ms(this.cv);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int g() {
        if (this.jm != 0 && !TextUtils.isEmpty(this.ce)) {
            return this.jm;
        }
        if (qf.xr(this.ka) == 0 || TextUtils.isEmpty(qf.ms(this.ka))) {
            return 0;
        }
        return qf.xr(this.ka);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String of() {
        if (this.jm == 0 || TextUtils.isEmpty(this.ce)) {
            return (qf.xr(this.ka) == 0 || TextUtils.isEmpty(qf.ms(this.ka))) ? "" : qf.ms(this.ka);
        }
        return this.ce;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String p() {
        if (this.qk.ms() && !TextUtils.isEmpty(this.qk.ab()) && !TextUtils.isEmpty(this.qk.c())) {
            return this.qk.ab();
        }
        return new StringBuilder().append(g()).toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String pc() {
        if (this.qk.ms() && !TextUtils.isEmpty(this.qk.ab()) && !TextUtils.isEmpty(this.qk.c())) {
            return this.qk.c();
        }
        return of();
    }

    private void rt() {
        if (qf.ab(this.ka) && this.ul.nw() >= qf.ch(this.ka)) {
            if (this.lm.ab() && this.of != null && this.of.ny() == 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("toast_text", qf.ny(this.ka));
                    this.of.ms("showToast", jSONObject);
                    return;
                } catch (JSONException e) {
                    sl.ms(e);
                    return;
                }
            }
            ul.ms(this.e, qf.ny(this.ka), 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void xn() {
        super.xn();
        if (qf.h(this.ka) || this.jw.cv() || t.d(this.ka)) {
            return;
        }
        if (this.ul.pc()) {
            this.pc.ms(false, null, null, true, true);
            return;
        }
        int iC = this.lm.c(true);
        int iC2 = this.lm.c(of.xr(op(), this.ka, true));
        if (zf() || this.lm.h()) {
            this.pc.ms(false, iC2 > 0 ? iC2 + "s" : "已领取奖励", "跳过", false, true);
        } else {
            this.pc.ms(false, iC2 > 0 ? iC2 + "s" : "已领取奖励", null, false, false);
        }
        this.lm.xr(iC);
    }

    public boolean zf() {
        return Math.round(((float) (this.ul.g() + (((long) this.lm.xn()) * 1000))) / 1000.0f) >= this.lm.il();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void ah(int i) {
        if (i != 0) {
            d(i);
            return;
        }
        if (this.lm.f() > 0) {
            return;
        }
        if ((!qf.yu(this.ka) || this.x.get()) && this.lm.of()) {
            d(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void d(final int i) {
        if (!this.qv.getAndSet(true)) {
            this.qk.d();
        }
        if (this.c.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.c.put(Integer.valueOf(i), Boolean.TRUE);
        this.m.ah();
        boolean z = !qf.w(this.ka);
        final int iG = g();
        final String strOf = of();
        int iSk = sk();
        boolean z2 = iSk == 0;
        if (!z2 || z) {
            ah(ms(i, z2, iSk, "reward failed", iG, strOf, false));
            ah(i, z2);
        } else {
            ah(i, true);
            re.ms().ms(xr(i, true), new yu.ka() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.yu.ka
                public void ms(int i2, String str) {
                    TTRewardVideoActivity.this.ah(TTRewardVideoActivity.this.ms(i, false, i2, str, iG, strOf, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.yu.ka
                public void ms(op.d dVar) {
                    int iMs = dVar.ah.ms();
                    String strXr = dVar.ah.xr();
                    TTRewardVideoActivity.this.ah(dVar.xr ? TTRewardVideoActivity.this.ms(i, true, 10111, "reward failed", iMs, strXr, true) : TTRewardVideoActivity.this.ms(i, false, 10112, "server refuse", iMs, strXr, true));
                }
            });
        }
    }

    @DungeonFlag
    private JSONObject xr(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("reward_name", of());
            jSONObject.put("reward_amount", g());
            jSONObject.put("network", u.ah(re.getContext()));
            jSONObject.put("sdk_version", g.ah);
            jSONObject.put("user_agent", f.ab());
            jSONObject.put("extra", this.ka.it());
            jSONObject.put("media_extra", this.vl);
            jSONObject.put("video_duration", this.ul.le());
            jSONObject.put("play_start_ts", this.il);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.ul.nw());
            jSONObject.put("user_id", this.qr);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put("reward_type", i);
            if (qf.d(this.ka)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.ub.xr.ms(this.e, jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle ms(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", qf.ms(this.ka, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && qf.ab(this.ka) && this.ul.nw() >= qf.ch(this.ka)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void x(int i) {
        if (!this.c.containsKey(0)) {
            this.xr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.op.ms(TTRewardVideoActivity.this.e, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (fm.ms(this.ka)) {
            this.xr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.op.ms(TTRewardVideoActivity.this.e, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.qk.ah(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void ms() {
        if (this.c.containsKey(0) && this.qk.ah(2)) {
            return;
        }
        super.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void le() {
        if (this.ah.getAndSet(true) || this.qk.ms() || of.xr(op(), this.ka, true)) {
            return;
        }
        d("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        ah ahVar;
        super.onDestroy();
        this.qk.ah();
        List<ah> listMs = ms.ms();
        if (listMs == null || listMs.size() == 0 || (ahVar = this.jy) == null) {
            return;
        }
        listMs.remove(ahVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void ah(boolean z) {
        int i;
        if (this.w) {
            if (re.xr().ad() == 1) {
                i = 2000;
            } else {
                i = -1;
            }
        } else if (z) {
            i = 0;
        } else {
            i = -1;
        }
        int i2 = this.qk.ms() ? -1 : i;
        if (i2 < 0 || this.b.get()) {
            return;
        }
        if (i2 == 0) {
            if (this.b.getAndSet(true)) {
                return;
            }
            ka.ms().ms(String.valueOf(this.k));
            return;
        }
        this.xr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.b.getAndSet(true)) {
                    return;
                }
                ka.ms().ms(String.valueOf(TTRewardVideoActivity.this.k));
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            ms("onRewardVerify", bundle);
        }
        ms("onRewardArrived", bundle);
        this.m.ms(bundle);
        this.lm.ms(i);
    }

    private void ms(String str, Bundle bundle) {
        com.bytedance.sdk.openadsdk.core.component.reward.ms.ms(0, this.qk.ms() ? k.ms(this.eg) : this.eg, str, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void d(String str) {
        ms(str, (Bundle) null);
    }

    private boolean vy() {
        if (TextUtils.isEmpty(this.ka.eu())) {
            return false;
        }
        return this.bz.get();
    }

    @DungeonFlag
    private int sk() {
        final int i = 0;
        if (qf.d(this.ka)) {
            if (this.ao.get()) {
                i = 10116;
            } else if (!vy()) {
                i = 10111;
            }
        }
        if (re.xr().eu() == 0) {
            return i;
        }
        boolean zC = com.bytedance.sdk.openadsdk.core.jw.re.c();
        int iMs = com.bytedance.sdk.openadsdk.core.jw.re.ms(this.ka.zj() + "_" + this.ka.yq());
        if (zC) {
            i = 10115;
        } else if (iMs == com.bytedance.sdk.openadsdk.core.jw.re.xr) {
            i = 10114;
        } else if (iMs == com.bytedance.sdk.openadsdk.core.jw.re.ah) {
            i = 10113;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                com.bytedance.sdk.openadsdk.core.t.ms.xr<com.bytedance.sdk.openadsdk.core.t.ms.xr> xrVarXr = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr();
                xrVarXr.ms("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.KEY_ERROR_CODE, i);
                xrVarXr.xr(jSONObject.toString());
                return xrVarXr;
            }
        }, "armor_reward");
        return i;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jw.pc()) {
            return;
        }
        this.lm.ms(i, i2, intent);
    }

    private void ah(int i, boolean z) {
        if (i == 0) {
            this.of.zb();
            this.az.xr(z);
            rt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean w() {
        return super.w() || this.qk.ka();
    }

    private void gy() {
        this.of.ms("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean cv() {
        return this.qk.ms() || this.v.d();
    }
}
