package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.basead.webtemplet.a.b;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ub;
import com.bytedance.sdk.openadsdk.core.ab.d;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.le;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ka;
import com.bytedance.sdk.openadsdk.op.ab;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ub {
    private final com.bytedance.sdk.openadsdk.ao.xr.ah.xr ah;
    private String ao;
    private long c;
    private com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr ch;
    private String h;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2091ms;
    private com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms ny;
    private boolean qv;
    private String sl;
    private boolean u;
    private com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms x;
    private final lm xr;
    private boolean y;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah yu;
    private int zb;
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private int ub = 1;
    private int t = 102;
    private int nw = -1;
    private Double b = null;
    private boolean re = false;
    private boolean i = false;
    private long w = System.currentTimeMillis();
    private boolean d = false;

    public ah(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.f2091ms = context;
        this.xr = lmVar;
        this.ah = xrVar;
        this.sl = lmVar.hashCode() + lmVar.eu() + hashCode();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah ahVar) {
        this.yu = ahVar;
    }

    public void ms() {
        if (this.ab.get()) {
            return;
        }
        this.d = true;
    }

    public void ms(int i) {
        this.zb = i;
    }

    public void xr(int i) {
        this.ub = i;
    }

    public void ms(String str) {
        this.ao = str;
    }

    public void xr(String str) {
        this.h = str;
    }

    public void ms(boolean z) {
        this.y = z;
    }

    public void ah(int i) {
        this.t = i;
    }

    public void d(int i) {
        this.nw = i;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void ms(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar) {
        if (this.ab.get()) {
            ms.ms(this.sl, msVar);
        } else {
            this.x = msVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void xr(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar) {
        if (this.ab.get()) {
            ms.ms(k.ms(this.sl), msVar);
        } else {
            this.ny = msVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void ms(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr xrVar) {
        if (this.ab.get()) {
            ah(true);
            ms.ms(k.xr(this.sl), xrVar);
        } else {
            this.ch = xrVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        this.hi = com.bytedance.sdk.openadsdk.core.hi.xr.ms.C0291ms.ms(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public int xr() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.jr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public int ah() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        if (nw.ah(lmVar)) {
            return 2;
        }
        if (nw.d(this.xr)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr) ? 3 : 0;
    }

    public void ms(long j) {
        this.c = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public long d() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public ka ka() {
        return new MediationRewardManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void ms(Activity activity) {
        Intent intent;
        lm lmVar = this.xr;
        String strLx = lmVar != null ? lmVar.lx() : "";
        lm lmVar2 = this.xr;
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(lmVar2 != null ? lmVar2.df() : "0").ms("rewarded_video").xr("show_start").d(strLx).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
        if (activity != null && activity.isFinishing()) {
            sl.d("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.ab.get()) {
            return;
        }
        this.ab.set(true);
        lm lmVar3 = this.xr;
        if (lmVar3 == null || qr.u(lmVar3) == null) {
            return;
        }
        if (xr() == 4) {
            ab.ms(new ny("reward_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.ka.ms(ah.this.f2091ms, ah.this.xr, "rewarded_video", false).ms(ah.this.hi);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.xr.ms().ms("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.f2091ms : activity;
        if (context == null) {
            context = re.getContext();
        }
        x();
        if (this.xr.od() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (this.u) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.ub);
        } else {
            this.zb = f.ny(this.xr);
        }
        intent.putExtra("source_rit_id", this.zb);
        intent.putExtra("custom_play_again", this.qv);
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = this.ah;
        if (xrVar != null) {
            intent.putExtra("media_extra", xrVar.zb());
            intent.putExtra("user_id", this.ah.u());
            intent.putExtra("reward_name", this.ah.i());
            intent.putExtra("reward_amount", this.ah.w());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.ah.nw()));
        }
        if (this.u && !TextUtils.isEmpty(this.ao) && !TextUtils.isEmpty(this.h)) {
            intent.putExtra("reward_again_name", this.ao);
            intent.putExtra("reward_again_amount", this.h);
        }
        intent.putExtra(b.c.i, this.d);
        intent.putExtra("object_create_ts", this.w);
        Double d = this.b;
        intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
        if (!TextUtils.isEmpty(this.ka)) {
            intent.putExtra("rit_scene", this.ka);
        }
        this.xr.x(this.y);
        this.xr.az(this.t);
        int i = this.nw;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        f.ms(intent, this.xr);
        intent.putExtra("multi_process_key", this.sl);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah ahVar = this.yu;
        if (ahVar != null) {
            intent.putExtra("insert_ad_bundle", ahVar.ch().toString());
        }
        ms(context, intent);
        d.ms().ms(this.xr).ms(7);
    }

    private void x() {
        com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = this.x;
        if (msVar != null) {
            ms.ms(this.sl, msVar);
        }
        if (this.ny != null) {
            ms.ms(k.ms(this.sl), this.ny);
        }
        if (this.ch != null) {
            ah(true);
            ms.ms(k.xr(this.sl), this.ch);
        }
    }

    private void ms(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.xr.ms(context, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.2
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
                sl.ah("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.ah == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms();
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = this.ah;
        xrVarMs.ms(xrVar, xrVar.d());
        if (k.ms(this.xr)) {
            com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().xr(this.ah, k.d(this.xr));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ms.d.ms(true, this.u).ms(this.ah.d(), this.xr);
        c();
    }

    public void c() {
        if (this.xr == null || this.ah == null || this.u || re.xr().ad() != 0) {
            return;
        }
        try {
            if (this.d) {
                com.bytedance.sdk.openadsdk.core.component.reward.ms.ka.ms().ms(this.ah);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public Map<String, Object> ab() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return null;
        }
        Map<String, Object> mapOu = lmVar.ou();
        mapOu.put("expireTimestamp", Long.valueOf(d()));
        mapOu.put("materialMetaIsFromPreload", Boolean.valueOf(this.y));
        mapOu.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.d.d.ms(this.xr)));
        return mapOu;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ub
    public void ms(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            sl.d("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.ka = str;
        } else {
            this.ka = ritScenes.getScenesName();
        }
        ms(activity);
    }

    public void xr(boolean z) {
        this.u = z;
    }

    public void ah(String str) {
        this.sl = str;
    }

    public void ah(boolean z) {
        this.qv = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.re) {
            return;
        }
        le.ms(this.xr, d);
        this.re = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.i) {
            return;
        }
        le.ms(this.xr, d, str, str2);
        this.i = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        this.b = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar) {
        lm lmVar = this.xr;
        if (lmVar != null) {
            i.ms(lmVar.da(), msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        }
    }
}
