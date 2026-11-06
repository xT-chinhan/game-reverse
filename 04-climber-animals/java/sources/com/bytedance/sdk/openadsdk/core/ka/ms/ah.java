package com.bytedance.sdk.openadsdk.core.ka.ms;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.basead.webtemplet.a.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.reward.ms.d;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.ka.ka.ka;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ao;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.of;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.ny;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.yu;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ka.ka.xr f2807ms;

    protected boolean ms() {
        return true;
    }

    public ah(com.bytedance.sdk.openadsdk.core.ka.ka.xr xrVar) {
        this.f2807ms = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar) {
        if (!com.bytedance.sdk.openadsdk.core.ka.ms.ms(xrVar, lmVar, ms())) {
            return false;
        }
        ms(xrVar, lmVar, ms());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public com.bytedance.sdk.openadsdk.core.ka.ka.ah ms(final lm lmVar, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, Bundle bundle) {
        final com.bytedance.sdk.openadsdk.core.component.reward.ah ahVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah(re.getContext(), lmVar, xrVar);
        final boolean z = bundle.getBoolean("is_cache", false);
        final boolean z2 = bundle.getBoolean("is_playAgain", false);
        final long j = bundle.getLong("start_time");
        ahVar.ms(z);
        ahVar.ah(z ? 101 : 102);
        if (lmVar.no() <= 0) {
            ahVar.ms(System.currentTimeMillis() + 10500000);
        } else {
            ahVar.ms(lmVar.no() * 1000);
        }
        if (!com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar) && !nw.ah(lmVar) && !fm.ms(lmVar) && z) {
            ahVar.ms();
        }
        return new com.bytedance.sdk.openadsdk.core.ka.ka.ah() { // from class: com.bytedance.sdk.openadsdk.core.ka.ms.ah.1
            private final AtomicBoolean ny = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void ms() {
                if (ah.this.f2807ms != null) {
                    ah.this.f2807ms.ms().ms(xrVar, lmVar, ahVar, z);
                }
                ka kaVar2 = kaVar;
                if (kaVar2 != null) {
                    kaVar2.ms(ahVar);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_play_again", z2);
                    jSONObject.put("is_from_cache", z);
                    jSONObject.put("is_adm", !TextUtils.isEmpty(xrVar.nw()));
                    jSONObject.put("cache_strategy", d.ms(ah.this.ms()));
                    jSONObject.put("src_req_id", lmVar.wn());
                    jSONObject.put("is_map", lmVar.fg());
                    jSONObject.put("load_duration", System.currentTimeMillis() - j);
                } catch (JSONException unused) {
                }
                u.ms().ms(lmVar, "stats_reward_full_ad_loaded", jSONObject);
                ah.this.ms(this, lmVar, xrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void xr() {
                if (j != 0) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.xr(lmVar, f.xr(xrVar.t()), j);
                }
                ahVar.d(1);
                ka kaVar2 = kaVar;
                if (kaVar2 != null) {
                    kaVar2.xr(ahVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ah
            public void ah() {
                if (this.ny.compareAndSet(false, true)) {
                    if (z) {
                        if (ah.this.f2807ms != null) {
                            ah.this.f2807ms.ms().ah(xrVar, lmVar);
                        }
                    } else if (ah.this.f2807ms != null) {
                        ah.this.f2807ms.ms().xr(xrVar, lmVar);
                    }
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
        if (xrVar != null) {
            ms(xrVar.d(), i, str, xrVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public com.bytedance.sdk.openadsdk.core.ka.ka.ah ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar, e eVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar2, ka kaVar) {
        if (msVar.xr() == null || msVar.xr().isEmpty()) {
            if (kaVar != null) {
                kaVar.ms(-3, ny.ms(-3));
            }
            ms(xrVar2.d(), -3, ny.ms(-3), xrVar);
            return null;
        }
        Bundle bundle = eVar == null ? null : eVar.ub;
        boolean z = bundle != null && bundle.getBoolean(b.c.i, false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong("start_time", 0L) : 0L;
        msVar.xr().size();
        lm lmVar = msVar.xr().get(0);
        if (xr(xrVar2.d(), lmVar)) {
            return null;
        }
        if (!lmVar.jl() || ms(msVar, xrVar2)) {
            if (kaVar != null) {
                kaVar.ms(-4, ny.ms(-4));
            }
            ms(xrVar2.d(), -4, ny.ms(-4), xrVar);
            return null;
        }
        ms(msVar);
        if (z) {
            com.bytedance.sdk.openadsdk.core.ka.ka.xr xrVar3 = this.f2807ms;
            if (xrVar3 != null) {
                xrVar3.ms().ms(xrVar2, lmVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cache_strategy", d.ms(ms()));
                jSONObject.put("src_req_id", lmVar.wn());
                jSONObject.put("is_map", lmVar.fg());
            } catch (Exception unused) {
            }
            u.ms().ms(lmVar, "stats_reward_full_preload", jSONObject);
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("start_time", j);
        bundle2.putBoolean("is_playAgain", z2);
        bundle2.putBoolean("is_cache", false);
        return ms(lmVar, xrVar2, kaVar, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, int i, String str2, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
        xrVar.ms(i);
        xrVar.xr(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cache_strategy", d.ms(ms()));
            jSONObject.put("app_id", ch.ub().t());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        xrVar.ms(jSONObject);
        com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar);
    }

    protected void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar, boolean z) {
        if (lmVar == null) {
            return;
        }
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ka(lmVar.df()).ms(z ? "rewarded_video" : "fullscreen_interstitial_ad").d(lmVar.lx()).xr("get_preload_ad").ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ms.ah.2
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (xrVar.re() != null) {
                    int i = AnonymousClass6.f2813ms[xrVar.re().ordinal()];
                    if (i == 1) {
                        jSONObject2.put("req_type", 3);
                    } else if (i == 2) {
                        jSONObject2.put("req_type", 1);
                    } else {
                        jSONObject2.put("req_type", -1);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.ms.ah$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f2813ms;

        static {
            int[] iArr = new int[TTAdLoadType.values().length];
            f2813ms = iArr;
            try {
                iArr[TTAdLoadType.LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2813ms[TTAdLoadType.PRELOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void ms(com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        ms(lmVar, xrVar);
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            com.bytedance.sdk.openadsdk.core.video.ah.ms.xr(lmVar);
            ahVar.xr();
        } else {
            if (nw.ah(lmVar)) {
                if (t.ms(lmVar) && com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
                    ms(xrVar, lmVar, ahVar);
                }
                ahVar.xr();
                return;
            }
            ms(xrVar, lmVar, ahVar);
        }
    }

    protected void ms(lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        lm.ms msVarSi;
        xrVar.d();
        ms(xrVar.d(), lmVar);
        if (com.bytedance.sdk.openadsdk.core.ugeno.ch.ny(lmVar) && !com.bytedance.sdk.openadsdk.core.ugeno.ch.hi(lmVar) && (msVarSi = lmVar.si()) != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(msVarSi.ch(), msVarSi.ny(), (ao) null);
        }
        if (ms()) {
            for (gy gyVar : qf.t(lmVar)) {
                com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
                msVar.ms(gyVar.d());
                msVar.xr(gyVar.ka());
                msVar.ah(gyVar.d());
                com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(gyVar.ka(), gyVar.d(), (ao) null);
            }
            for (gy gyVar2 : k.ka(lmVar)) {
                com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
                msVar2.ms(gyVar2.d());
                msVar2.xr(gyVar2.ka());
                msVar2.ah(gyVar2.d());
                com.bytedance.sdk.openadsdk.core.ugeno.ch.ms(gyVar2.ka(), gyVar2.d(), (ao) null);
            }
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar, final com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar) {
        if (qr.u(lmVar) == null) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(1, lmVar);
        dVarMs.ms("material_meta", lmVar);
        dVarMs.ms("ad_slot", xrVar);
        com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, new com.bykv.vk.openvk.component.video.api.ka.xr() { // from class: com.bytedance.sdk.openadsdk.core.ka.ms.ah.3
            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, int i) {
                sl.ms("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar2 = ahVar;
                if (ahVar2 != null) {
                    ahVar2.xr();
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
            public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, int i, String str) {
                sl.ms("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadFail");
                if (!qr.sl(lmVar)) {
                    sl.ms("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar2 = ahVar;
                if (ahVar2 != null) {
                    ahVar2.xr();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ka.ms.ah$4, reason: invalid class name */
    class AnonymousClass4 implements com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms.InterfaceC0275ms<Object> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.ka.ka.ah f2811ms;

        AnonymousClass4(com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar) {
            this.f2811ms = ahVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms.InterfaceC0275ms
        public void ms(boolean z, Object obj) {
            com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar = this.f2811ms;
            if (ahVar != null) {
                ahVar.xr();
            }
        }
    }

    private void ms(String str, lm lmVar) {
        try {
            g gVarQd = lmVar.qd();
            if (gVarQd == null || TextUtils.isEmpty(gVarQd.ms())) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.re.ah ahVar = new com.bytedance.sdk.openadsdk.core.re.ah(true);
            ahVar.ms(str);
            ahVar.ms(8);
            ahVar.ah(lmVar.df());
            ahVar.d(lmVar.lx());
            ahVar.xr(f.zb(lmVar));
            com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(ahVar);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xr(String str, lm lmVar) {
        if (!re.xr().xr(str) || lmVar == null) {
            return false;
        }
        int i = ms() ? 7 : 8;
        lm lmVarXr = com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().xr(ms(), str);
        if (lmVarXr == null) {
            return false;
        }
        if (lmVarXr.f() + lmVarXr.re() < System.currentTimeMillis()) {
            com.bytedance.sdk.openadsdk.core.ka.d.d.ms(i).ms(str);
            return true;
        }
        if (!TextUtils.equals(lmVarXr.p(), lmVar.p())) {
            if (com.bytedance.sdk.openadsdk.core.ms.ms(lmVar, ms() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(lmVar.of());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                lmVarXr.it().put(next, jSONObject.get(next));
            }
            lmVarXr.nw(lmVarXr.it().toString());
        } catch (Exception e) {
            sl.ms(e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar) {
        if (msVar.xr().size() <= 1) {
            return;
        }
        List<lm> listSubList = msVar.xr().subList(1, msVar.xr().size());
        JSONArray jSONArray = new JSONArray();
        for (lm lmVar : listSubList) {
            le leVarFi = lmVar.fi();
            if (leVarFi != null) {
                leVarFi.ms(true);
            }
            jSONArray.put(lmVar.rm());
        }
        if (jSONArray.length() > 0) {
            msVar.xr().get(0).f(jSONArray.toString());
        }
    }

    protected boolean ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        List<lm> listXr;
        if (msVar != null && (listXr = msVar.xr()) != null) {
            lm lmVar = listXr.get(0);
            if (of.xr(ms(), lmVar, false) && of.d(lmVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ms.xr
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (re.xr().xr(xrVar.d())) {
            e eVar = new e();
            eVar.f3048ms = 2;
            if (re.xr().ch(xrVar.d()) || xrVar.x() > 0.0f) {
                eVar.c = 2;
            }
            re.ms().xr(xrVar, eVar, ms() ? 7 : 8, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.ka.ms.ah.5
                @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                    xrVar2.ms(i);
                    xrVar2.xr(str);
                    com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                    if (msVar.xr() == null || msVar.xr().isEmpty()) {
                        ah.this.ms(xrVar.d(), -3, ny.ms(-3), xrVar2);
                        return;
                    }
                    lm lmVar = msVar.xr().get(0);
                    if (ah.this.xr(xrVar.d(), lmVar)) {
                        return;
                    }
                    if (!lmVar.jl() || ah.this.ms(msVar, xrVar)) {
                        ah.this.ms(xrVar.d(), -4, ny.ms(-4), xrVar2);
                        return;
                    }
                    ah.this.ms(msVar);
                    if (ah.this.f2807ms != null) {
                        ah.this.f2807ms.ms().ms(xrVar, lmVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cache_strategy", d.ms(ah.this.ms()));
                        jSONObject.put("src_req_id", lmVar.wn());
                        jSONObject.put("is_map", lmVar.fg());
                    } catch (Exception unused) {
                    }
                    u.ms().ms(lmVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
