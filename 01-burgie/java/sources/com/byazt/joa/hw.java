package com.byazt.joa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mr.w;
import com.byazt.nz.x;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.wt.gz;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 13})
public class hw extends w {
    public long c;
    public final String fw;
    public com.byazt.rf.pr g;
    public com.byazt.nv.pr ho;
    public final of hw;
    public com.byazt.qe.hw m;
    public com.byazt.ei.hn nt;
    public final Context pr;
    public String x;
    public boolean yb;
    public final AtomicBoolean uc = new AtomicBoolean(false);
    public int zo = -1;
    public Double aj = null;
    public boolean vk = false;
    public boolean w = false;
    public long k = System.currentTimeMillis();
    public boolean hn = false;

    public hw(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        this.pr = context;
        this.hw = ofVar;
        this.m = hwVar;
        this.fw = ofVar.hashCode() + ofVar.ny() + hashCode();
        com.byazt.qd.hw.pr(ofVar, hwVar, 8, zo());
    }

    public void pr(boolean z) {
        this.yb = z;
    }

    public void pr(com.byazt.ei.hn hnVar) {
        this.nt = hnVar;
    }

    public void pr() {
        if (this.uc.get()) {
            return;
        }
        this.hn = true;
    }

    public void pr(int i) {
        this.zo = i;
    }

    @Override // com.byazt.mr.w
    public void pr(com.byazt.rf.pr prVar) {
        if (this.uc.get()) {
            pr.pr(this.fw, prVar);
        }
        this.g = prVar;
    }

    @Override // com.byazt.mr.w
    public void pr(com.byazt.rkl.hn hnVar) {
        this.ho = com.byazt.nv.pr.C0146pr.pr(hnVar);
    }

    @Override // com.byazt.mr.w
    public int hw() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.aj();
    }

    @Override // com.byazt.mr.w
    public void pr(Activity activity) {
        Intent intent;
        com.byazt.qd.hw.hw(zo());
        com.byazt.pj.pr.pr(this.hw, "fullscreen_interstitial_ad", "show_start", (com.byazt.ttf.pr) null);
        if (activity != null && activity.isFinishing()) {
            ho.hw("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.uc.get()) {
            return;
        }
        of ofVar = this.hw;
        if (ofVar != null) {
            com.byazt.ua.hw.pr(ofVar, "fullscreen_interstitial_ad", activity, this.x, this.hn);
        }
        this.uc.set(true);
        of ofVar2 = this.hw;
        if (ofVar2 != null) {
            if (qv.ho(ofVar2) == null && this.hw.de() == null) {
                return;
            }
            if (hw() == 4) {
                zo.pr(new fw("full_register_download") { // from class: com.byazt.joa.hw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.jx.zo.pr(hw.this.pr, hw.this.hw, "fullscreen_interstitial_ad").pr(hw.this.ho);
                    }
                });
            }
            com.byazt.sd.hw.pr().hw("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.pr : activity;
            if (context == null) {
                context = a.getContext();
            }
            vk();
            if (this.hw.rf() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.qe.hw hwVar = this.m;
            if (hwVar != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(hwVar.cz()));
            }
            intent.putExtra("is_preload", this.hn);
            intent.putExtra("object_create_ts", this.k);
            Double d = this.aj;
            intent.putExtra("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
            if (!TextUtils.isEmpty(this.x)) {
                intent.putExtra("rit_scene", this.x);
            }
            int i = this.zo;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            if (this.yb) {
                intent.putExtra("is_second_page", true);
            }
            ls.pr(intent, this.hw);
            intent.putExtra("multi_process_key", this.fw);
            com.byazt.ei.hn hnVar = this.nt;
            if (hnVar != null) {
                intent.putExtra("insert_ad_bundle", hnVar.aj().toString());
            }
            pr(context, intent);
            x.pr().pr(this.hw).pr(8);
        }
    }

    private void vk() {
        if (this.g != null) {
            pr.pr(this.fw, new com.byazt.rf.pr(null) { // from class: com.byazt.joa.hw.2
                @Override // com.byazt.rf.pr
                public void pr(Bundle bundle) {
                    boolean z;
                    if (bundle == null) {
                        z = false;
                    } else {
                        z = bundle.getBoolean("has_show_event");
                    }
                    com.byazt.qd.hw.pr(hw.this.zo(), false, z);
                    if (hw.this.g != null) {
                        hw.this.g.pr(bundle);
                    }
                }

                @Override // com.byazt.rf.pr
                public void hw(Bundle bundle) {
                    com.byazt.qd.hw.hn(hw.this.zo());
                    if (hw.this.g != null) {
                        hw.this.g.hw(bundle);
                    }
                }

                @Override // com.byazt.rf.pr
                public void hn(Bundle bundle) {
                    final Boolean boolValueOf;
                    final Boolean boolValueOf2 = null;
                    if (bundle != null && bundle.containsKey("send_show_event_result")) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("send_show_event_result"));
                    } else {
                        boolValueOf = null;
                    }
                    if (bundle != null && bundle.containsKey("send_click_event_result")) {
                        boolValueOf2 = Boolean.valueOf(bundle.getBoolean("send_click_event_result"));
                    }
                    com.byazt.qd.hw.pr().pr(hw.this.zo(), new com.byazt.ewt.x.pr() { // from class: com.byazt.joa.hw.2.1
                        @Override // com.byazt.ewt.x.pr
                        public void pr(com.byazt.ewt.hw hwVar) {
                            if (hwVar instanceof com.byazt.pv.hn) {
                                Boolean bool = boolValueOf;
                                if (bool != null) {
                                    ((com.byazt.pv.hn) hwVar).fw = bool.booleanValue() ? 1 : 0;
                                }
                                Boolean bool2 = boolValueOf2;
                                if (bool2 != null) {
                                    ((com.byazt.pv.hn) hwVar).zo = bool2.booleanValue() ? 1 : 0;
                                }
                            }
                        }
                    });
                    com.byazt.qd.hw.hn(hw.this.zo(), 1);
                    if (hw.this.g != null) {
                        hw.this.g.hn(bundle);
                    }
                }

                @Override // com.byazt.rf.pr
                public void pr() {
                    if (hw.this.g != null) {
                        hw.this.g.pr();
                    }
                }

                @Override // com.byazt.rf.pr
                public void hw() {
                    if (hw.this.g != null) {
                        hw.this.g.hw();
                    }
                }
            });
        }
    }

    private void pr(Context context, Intent intent) {
        com.byazt.ca.pr.pr(context, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.joa.hw.3
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                ho.pr("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.m == null) {
            return;
        }
        com.byazt.bv.pr prVarPr = com.byazt.bv.pr.pr();
        com.byazt.qe.hw hwVar = this.m;
        prVarPr.pr(hwVar, hwVar.x());
        if (!this.yb) {
            com.byazt.vh.hn.pr(8, this.hw);
        }
        hn();
    }

    public void hn() {
        if (this.hw == null || this.m == null || this.yb || a.hw().to() != 0) {
            return;
        }
        try {
            boolean z = this.hn;
            if (this.m != null && z) {
                com.byazt.vh.hw.pr().pr(this.m);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mr.w
    public void pr(Activity activity, Object obj, String str) {
        if (obj == null) {
            ho.hw("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strPr = com.byazt.nq.hn.pr(obj);
        if ("customize_scenes".equalsIgnoreCase(strPr)) {
            this.x = str;
        } else {
            this.x = strPr;
        }
        pr(activity);
    }

    @Override // com.byazt.mr.w
    public Map<String, Object> x() {
        of ofVar = this.hw;
        if (ofVar != null) {
            Map<String, Object> mapZc = ofVar.zc();
            mapZc.put("expireTimestamp", Long.valueOf(uc()));
            mapZc.put("adSceneType", Integer.valueOf(com.byazt.lu.x.pr(this.hw)));
            return mapZc;
        }
        return null;
    }

    @Override // com.byazt.mr.w
    public int c() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        if (ny.hn(ofVar)) {
            return 2;
        }
        if (ny.x(this.hw)) {
            return 1;
        }
        if (com.byazt.lpk.pr.pr(this.hw)) {
            return 3;
        }
        return 0;
    }

    public void pr(long j) {
        this.c = j;
    }

    @Override // com.byazt.mr.w
    public long uc() {
        return this.c;
    }

    @Override // com.byazt.mr.w
    public com.byazt.wd.hn fw() {
        return new com.byazt.vd.hw();
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d) {
        if (this.vk) {
            return;
        }
        gz.pr(this.hw, d);
        this.vk = true;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.w) {
            return;
        }
        gz.pr(this.hw, d, str, str2);
        this.w = true;
    }

    @Override // com.byazt.mr.zo
    public void hw(Double d) {
        this.aj = d;
    }

    @Override // com.byazt.mr.zo
    public void pr(com.byazt.rkl.hw hwVar) {
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.pr(ofVar.cz(), hwVar, com.byazt.rkl.hw.class);
        }
    }

    public String zo() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return null;
        }
        return ofVar.z();
    }

    public void finalize() throws Throwable {
        String strZo = zo();
        try {
            if (!TextUtils.isEmpty(strZo)) {
                pr(strZo);
            }
        } finally {
            super.finalize();
        }
    }

    private static void pr(final String str) {
        zo.pr(new fw("fullscreen_finalize_end") { // from class: com.byazt.joa.hw.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.qd.hw.hn(str, 3);
            }
        });
    }
}
