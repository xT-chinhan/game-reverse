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
import com.bytedance.sdk.openadsdk.ao.xr.xr.hi;
import com.bytedance.sdk.openadsdk.core.ab.d;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.hi.ka;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.le;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import com.bytedance.sdk.openadsdk.op.ab;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends hi {
    private final String ab;
    private com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms ao;
    private String d;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms h;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2291ms;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah qv;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr ub;
    private boolean x;
    private final lm xr;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private int ny = 102;
    private int ch = -1;
    private Double hi = null;
    private boolean sl = false;
    private boolean zb = false;
    private long u = System.currentTimeMillis();
    private boolean ah = false;

    public xr(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.f2291ms = context;
        this.xr = lmVar;
        this.ub = xrVar;
        this.ab = lmVar.hashCode() + lmVar.eu() + hashCode();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah ahVar) {
        this.qv = ahVar;
    }

    public void ms() {
        if (this.c.get()) {
            return;
        }
        this.ah = true;
    }

    public void ms(boolean z) {
        this.x = z;
    }

    public void ms(int i) {
        this.ny = i;
    }

    public void xr(int i) {
        this.ch = i;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public void ms(com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar) {
        if (this.c.get()) {
            ms.ms(this.ab, msVar);
        }
        this.ao = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        this.h = com.bytedance.sdk.openadsdk.core.hi.xr.ms.C0291ms.ms(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public int xr() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.jr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public void ms(Activity activity) {
        Intent intent;
        lm lmVar = this.xr;
        String strLx = lmVar != null ? lmVar.lx() : "";
        lm lmVar2 = this.xr;
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(lmVar2 != null ? lmVar2.df() : "0").ms("fullscreen_interstitial_ad").xr("show_start").d(strLx).ms((com.bytedance.sdk.openadsdk.c.ms.ms) null);
        if (activity != null && activity.isFinishing()) {
            sl.d("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        lm lmVar3 = this.xr;
        if (lmVar3 != null) {
            if (qr.u(lmVar3) == null && this.xr.fk() == null) {
                return;
            }
            if (xr() == 4) {
                ab.ms(new ny("full_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.ms(xr.this.f2291ms, xr.this.xr, "fullscreen_interstitial_ad", false).ms(xr.this.h);
                    }
                });
            }
            com.bytedance.sdk.openadsdk.core.xr.ms().xr("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.f2291ms : activity;
            if (context == null) {
                context = re.getContext();
            }
            x();
            if (this.xr.od() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = this.ub;
            if (xrVar != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(xrVar.nw()));
            }
            intent.putExtra(b.c.i, this.ah);
            intent.putExtra("object_create_ts", this.u);
            Double d = this.hi;
            intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
            if (!TextUtils.isEmpty(this.d)) {
                intent.putExtra("rit_scene", this.d);
            }
            this.xr.x(this.x);
            this.xr.az(this.ny);
            int i = this.ch;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            f.ms(intent, this.xr);
            intent.putExtra("multi_process_key", this.ab);
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.ah ahVar = this.qv;
            if (ahVar != null) {
                intent.putExtra("insert_ad_bundle", ahVar.ch().toString());
            }
            ms(context, intent);
            d.ms().ms(this.xr).ms(8);
        }
    }

    private void x() {
        com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = this.ao;
        if (msVar != null) {
            ms.ms(this.ab, msVar);
        }
    }

    private void ms(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.xr.ms(context, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.2
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
                sl.ah("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.ub == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms();
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = this.ub;
        xrVarMs.ms(xrVar, xrVar.d());
        com.bytedance.sdk.openadsdk.core.component.reward.ms.d.ms(false, false).ms(this.ub.d(), this.xr);
        ah();
    }

    public void ah() {
        if (this.xr == null || this.ub == null || re.xr().ad() != 0) {
            return;
        }
        try {
            boolean z = this.ah;
            if (this.ub == null || !z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms().ms(this.ub);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public void ms(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            sl.d("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.d = str;
        } else {
            this.d = ritScenes.getScenesName();
        }
        ms(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public Map<String, Object> d() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return null;
        }
        Map<String, Object> mapOu = lmVar.ou();
        mapOu.put("expireTimestamp", Long.valueOf(c()));
        mapOu.put("materialMetaIsFromPreload", Boolean.valueOf(this.x));
        mapOu.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.d.d.ms(this.xr)));
        return mapOu;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public int ka() {
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
        this.ka = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public long c() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.hi
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ah ab() {
        return new MediationFullScreenManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.sl) {
            return;
        }
        le.ms(this.xr, d);
        this.sl = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.zb) {
            return;
        }
        le.ms(this.xr, d, str, str2);
        this.zb = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        this.hi = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar) {
        lm lmVar = this.xr;
        if (lmVar != null) {
            i.ms(lmVar.da(), msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        }
    }
}
