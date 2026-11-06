package com.byazt.joa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.hg.hs;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mr.ho;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.vd.x;
import com.byazt.wd.c;
import com.byazt.wt.gz;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 20})
public class hn extends ho {
    public com.byazt.yg.pr aj;
    public String c;
    public boolean g;
    public final com.byazt.qe.hw hn;
    public final of hw;
    public String k;
    public boolean lb;
    public int m;
    public String nt;
    public final Context pr;
    public com.byazt.ei.hn rc;
    public long uc;
    public com.byazt.yg.hw vk;
    public com.byazt.nv.pr w;
    public String yb;
    public boolean z;
    public com.byazt.yg.pr zo;
    public final AtomicBoolean fw = new AtomicBoolean(false);
    public int ho = 1;
    public int qa = -1;
    public Double a = null;
    public boolean cz = false;
    public boolean ny = false;
    public long fo = System.currentTimeMillis();
    public boolean x = false;

    public hn(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        this.pr = context;
        this.hw = ofVar;
        this.hn = hwVar;
        this.k = ofVar.hashCode() + ofVar.ny() + hashCode();
        com.byazt.qd.hw.pr(ofVar, hwVar, 7, zo());
    }

    public void pr(boolean z) {
        this.z = z;
    }

    public void pr(com.byazt.ei.hn hnVar) {
        this.rc = hnVar;
    }

    public void pr() {
        if (this.fw.get()) {
            return;
        }
        this.x = true;
    }

    public void pr(int i) {
        this.m = i;
    }

    public void hw(int i) {
        this.ho = i;
    }

    public void pr(String str) {
        this.nt = str;
    }

    public void hw(String str) {
        this.yb = str;
    }

    public void hn(int i) {
        this.qa = i;
    }

    @Override // com.byazt.mr.ho
    public void pr(com.byazt.yg.pr prVar) {
        if (this.fw.get()) {
            pr.pr(this.k, prVar);
        } else {
            this.zo = prVar;
        }
    }

    @Override // com.byazt.mr.ho
    public void hw(com.byazt.yg.pr prVar) {
        if (this.fw.get()) {
            pr.pr(hs.pr(this.k), prVar);
        } else {
            this.aj = prVar;
        }
    }

    @Override // com.byazt.mr.ho
    public void pr(com.byazt.yg.hw hwVar) {
        if (this.fw.get()) {
            hn(true);
            pr.pr(hs.hw(this.k), hwVar);
        } else {
            this.vk = hwVar;
        }
    }

    @Override // com.byazt.mr.ho
    public void pr(com.byazt.rkl.hn hnVar) {
        this.w = com.byazt.nv.pr.C0146pr.pr(hnVar);
    }

    @Override // com.byazt.mr.ho
    public int hw() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.aj();
    }

    @Override // com.byazt.mr.ho
    public int hn() {
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
        this.uc = j;
    }

    @Override // com.byazt.mr.ho
    public long x() {
        return this.uc;
    }

    @Override // com.byazt.mr.ho
    public c c() {
        return new x();
    }

    @Override // com.byazt.mr.ho
    public void pr(Activity activity) {
        Intent intent;
        com.byazt.qd.hw.hw(zo());
        com.byazt.pj.pr.pr(this.hw, "rewarded_video", "show_start", (com.byazt.ttf.pr) null);
        if (activity != null && activity.isFinishing()) {
            com.byazt.ca.ho.hw("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.fw.get()) {
            return;
        }
        of ofVar = this.hw;
        if (ofVar != null) {
            com.byazt.ua.hw.pr(ofVar, "rewarded_video", activity, this.c, this.x);
        }
        this.fw.set(true);
        of ofVar2 = this.hw;
        if (ofVar2 == null || qv.ho(ofVar2) == null) {
            return;
        }
        if (hw() == 4) {
            zo.pr(new fw("reward_register_download") { // from class: com.byazt.joa.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.jx.zo.pr(hn.this.pr, hn.this.hw, "rewarded_video").pr(hn.this.w);
                }
            });
        }
        com.byazt.sd.hw.pr().pr("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.pr : activity;
        if (context == null) {
            context = a.getContext();
        }
        vk();
        if (this.hw.rf() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (this.g) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.ho);
        } else {
            this.m = ls.m(this.hw);
        }
        if (this.z) {
            intent.putExtra("is_second_page", true);
        }
        intent.putExtra("source_rit_id", this.m);
        intent.putExtra("custom_play_again", this.lb);
        com.byazt.qe.hw hwVar = this.hn;
        if (hwVar != null) {
            intent.putExtra("media_extra", hwVar.m());
            intent.putExtra("userData", this.hn.ny());
            intent.putExtra(Common.System.USER_ID, this.hn.g());
            intent.putExtra("reward_name", this.hn.rc());
            intent.putExtra("reward_amount", this.hn.z());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.hn.cz()));
        }
        if (this.g && !TextUtils.isEmpty(this.nt) && !TextUtils.isEmpty(this.yb)) {
            intent.putExtra("reward_again_name", this.nt);
            intent.putExtra("reward_again_amount", this.yb);
        }
        intent.putExtra("is_preload", this.x);
        intent.putExtra("object_create_ts", this.fo);
        Double d = this.a;
        intent.putExtra("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        if (!TextUtils.isEmpty(this.c)) {
            intent.putExtra("rit_scene", this.c);
        }
        int i = this.qa;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        ls.pr(intent, this.hw);
        intent.putExtra("multi_process_key", this.k);
        com.byazt.ei.hn hnVar = this.rc;
        if (hnVar != null) {
            intent.putExtra("insert_ad_bundle", hnVar.aj().toString());
        }
        pr(context, intent);
        com.byazt.nz.x.pr().pr(this.hw).pr(7);
    }

    private void vk() {
        pr.pr(this.k, new com.byazt.yg.pr(null) { // from class: com.byazt.joa.hn.2
            @Override // com.byazt.yg.pr
            public void pr(Bundle bundle) {
                boolean z;
                if (bundle == null) {
                    z = false;
                } else {
                    z = bundle.getBoolean("has_show_event");
                }
                com.byazt.qd.hw.pr(hn.this.zo(), false, z);
                if (hn.this.zo != null) {
                    hn.this.zo.pr(bundle);
                }
            }

            @Override // com.byazt.yg.pr
            public void hw(Bundle bundle) {
                com.byazt.qd.hw.hn(hn.this.zo());
                if (hn.this.zo != null) {
                    hn.this.zo.hw(bundle);
                }
            }

            @Override // com.byazt.yg.pr
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
                com.byazt.qd.hw.pr().pr(hn.this.zo(), new com.byazt.ewt.x.pr() { // from class: com.byazt.joa.hn.2.1
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
                com.byazt.qd.hw.hn(hn.this.zo(), 1);
                if (hn.this.zo != null) {
                    hn.this.zo.hn(bundle);
                }
            }

            @Override // com.byazt.yg.pr
            public void pr() {
                if (hn.this.zo != null) {
                    hn.this.zo.pr();
                }
            }

            @Override // com.byazt.yg.pr
            public void hw() {
                if (hn.this.zo != null) {
                    hn.this.zo.hw();
                }
            }

            @Override // com.byazt.yg.pr
            public void pr(boolean z, int i, String str, int i2, String str2) {
                if (hn.this.zo != null) {
                    hn.this.zo.pr(z, i, str, i2, str2);
                }
            }

            @Override // com.byazt.yg.pr
            public void pr(boolean z, int i, Bundle bundle) {
                if (hn.this.zo != null) {
                    hn.this.zo.pr(z, i, bundle);
                }
            }

            @Override // com.byazt.yg.pr
            public void hn() {
                if (hn.this.zo != null) {
                    hn.this.zo.hn();
                }
            }
        });
        if (this.aj != null) {
            pr.pr(hs.pr(this.k), this.aj);
        }
        if (this.vk != null) {
            hn(true);
            pr.pr(hs.hw(this.k), this.vk);
        }
    }

    private void pr(Context context, Intent intent) {
        com.byazt.ca.pr.pr(context, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.joa.hn.3
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                com.byazt.ca.ho.pr("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.hn == null) {
            return;
        }
        com.byazt.bv.pr prVarPr = com.byazt.bv.pr.pr();
        com.byazt.qe.hw hwVar = this.hn;
        prVarPr.pr(hwVar, hwVar.x());
        if (hs.pr(this.hw)) {
            com.byazt.bv.pr.pr().hw(this.hn, hs.x(this.hw));
        }
        if (!this.z && !this.g) {
            com.byazt.vh.hn.pr(7, this.hw);
        }
        uc();
    }

    public void uc() {
        if (this.hw == null || this.hn == null || this.g || this.z || a.hw().to() != 0) {
            return;
        }
        try {
            if (this.x) {
                com.byazt.vh.fw.pr().pr(this.hn);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mr.ho
    public Map<String, Object> fw() {
        of ofVar = this.hw;
        if (ofVar != null) {
            Map<String, Object> mapZc = ofVar.zc();
            if (mapZc == null) {
                mapZc = new HashMap<>();
            }
            mapZc.put("expireTimestamp", Long.valueOf(x()));
            mapZc.put("isRDEnable", Boolean.valueOf(jn.x(this.hw)));
            mapZc.put("isPangle", Boolean.TRUE);
            mapZc.put("adSceneType", Integer.valueOf(com.byazt.lu.x.pr(this.hw)));
            return mapZc;
        }
        return null;
    }

    @Override // com.byazt.mr.ho
    public void pr(Activity activity, Object obj, String str) {
        if (obj == null) {
            com.byazt.ca.ho.hw("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strPr = com.byazt.nq.hn.pr(obj);
        if ("customize_scenes".equalsIgnoreCase(strPr)) {
            this.c = str;
        } else {
            this.c = strPr;
        }
        pr(activity);
    }

    public void hw(boolean z) {
        this.g = z;
    }

    public void hn(String str) {
        this.k = str;
    }

    public void hn(boolean z) {
        this.lb = z;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d) {
        if (this.cz) {
            return;
        }
        gz.pr(this.hw, d);
        this.cz = true;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.ny) {
            return;
        }
        gz.pr(this.hw, d, str, str2);
        this.ny = true;
    }

    @Override // com.byazt.mr.zo
    public void hw(Double d) {
        this.a = d;
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
                x(strZo);
            }
        } finally {
            super.finalize();
        }
    }

    private static void x(final String str) {
        zo.pr(new fw("reward_finalize_end") { // from class: com.byazt.joa.hn.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.qd.hw.hn(str, 3);
            }
        });
    }
}
