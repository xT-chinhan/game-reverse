package com.byazt.rv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.fvm.k;
import com.byazt.gct.cx;
import com.byazt.gct.dh;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.iz.fs;
import com.byazt.nf.rv;
import com.byazt.nq.w;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.qit.x;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 18})
public class l extends k {
    public boolean cd;
    public AppDownloadListener cp;
    public String cy;
    public String d;
    public com.byazt.tmn.n fs;
    public String hd;
    public boolean hu;
    public String l;
    public com.byazt.aq.s m;
    public final Context n;
    public int oa;
    public final pk qg;
    public com.byazt.tmn.n rv;
    public final com.byazt.zq.qg s;
    public boolean sz;
    public com.byazt.tmn.qg tj;
    public long w;
    public final AtomicBoolean x = new AtomicBoolean(false);
    public int k = 1;
    public int um = -1;
    public Double a = null;
    public boolean py = false;
    public boolean ou = false;
    public long wm = System.currentTimeMillis();
    public boolean q = false;

    public l(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        this.n = context;
        this.qg = pkVar;
        this.s = qgVar;
        this.d = pkVar.hashCode() + pkVar.ou() + hashCode();
        com.byazt.de.qg.n(pkVar, qgVar, 7, fs());
    }

    public void n(boolean z) {
        this.hu = z;
    }

    public void n(com.byazt.aq.s sVar) {
        this.m = sVar;
    }

    public void w() {
        if (this.x.get()) {
            return;
        }
        this.q = true;
    }

    public void n(int i) {
        this.oa = i;
    }

    public void qg(int i) {
        this.k = i;
    }

    public void n(String str) {
        this.cy = str;
    }

    public void qg(String str) {
        this.hd = str;
    }

    public void s(int i) {
        this.um = i;
    }

    @Override // com.byazt.fvm.k
    public void n(com.byazt.tmn.n nVar) {
        if (this.x.get()) {
            qg.n(this.d, nVar);
        } else {
            this.fs = nVar;
        }
    }

    @Override // com.byazt.fvm.k
    public void qg(com.byazt.tmn.n nVar) {
        if (this.x.get()) {
            qg.n(dh.n(this.d), nVar);
        } else {
            this.rv = nVar;
        }
    }

    @Override // com.byazt.fvm.k
    public void n(com.byazt.tmn.qg qgVar) {
        if (this.x.get()) {
            s(true);
            qg.n(dh.qg(this.d), qgVar);
        } else {
            this.tj = qgVar;
        }
    }

    @Override // com.byazt.fvm.k
    public void n(com.byazt.mi.s sVar) {
        this.cp = AppDownloadListener.Converter.convert(sVar);
    }

    @Override // com.byazt.fvm.k
    public int n() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.rv();
    }

    @Override // com.byazt.fvm.k
    public int s() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        if (com.byazt.qq.qg.s(pkVar)) {
            return 2;
        }
        if (com.byazt.qq.qg.q(this.qg)) {
            return 1;
        }
        return com.byazt.gks.n.n(this.qg) ? 3 : 0;
    }

    public void n(long j) {
        this.w = j;
    }

    @Override // com.byazt.fvm.k
    public long q() {
        return this.w;
    }

    @Override // com.byazt.fvm.k
    public w l() {
        return new com.byazt.fp.q();
    }

    @Override // com.byazt.fvm.k
    public void n(Activity activity) {
        Intent intent;
        com.byazt.de.qg.qg(fs());
        com.byazt.hm.n.n(this.qg, "rewarded_video", "show_start", (com.byazt.rs.n) null);
        if (activity != null && activity.isFinishing()) {
            com.byazt.tk.k.qg("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.x.get()) {
            return;
        }
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.uq.qg.n(pkVar, "rewarded_video", activity, this.l, this.q);
        }
        this.x.set(true);
        pk pkVar2 = this.qg;
        if (pkVar2 == null || ta.k(pkVar2) == null) {
            return;
        }
        if (n() == 4) {
            com.byazt.ag.qg.n(new x("reward_register_download") { // from class: com.byazt.rv.l.1
                @Override // java.lang.Runnable
                public void run() {
                    fs.n(l.this.n, l.this.qg, "rewarded_video").addAppDownloadListener(l.this.cp);
                }
            });
        }
        com.byazt.ikv.n.n().n("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.n : activity;
        if (context == null) {
            context = rv.getContext();
        }
        tj();
        if (this.qg.ys() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (this.sz) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.k);
        } else {
            this.oa = com.byazt.vgx.w.cy(this.qg);
        }
        if (this.hu) {
            intent.putExtra("is_second_page", true);
        }
        intent.putExtra("source_rit_id", this.oa);
        intent.putExtra("custom_play_again", this.cd);
        com.byazt.zq.qg qgVar = this.s;
        if (qgVar != null) {
            intent.putExtra("media_extra", qgVar.oa());
            intent.putExtra("userData", this.s.ou());
            intent.putExtra("user_id", this.s.sz());
            intent.putExtra("reward_name", this.s.m());
            intent.putExtra("reward_amount", this.s.hu());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.s.py()));
        }
        if (this.sz && !TextUtils.isEmpty(this.cy) && !TextUtils.isEmpty(this.hd)) {
            intent.putExtra("reward_again_name", this.cy);
            intent.putExtra("reward_again_amount", this.hd);
        }
        intent.putExtra("is_preload", this.q);
        intent.putExtra("object_create_ts", this.wm);
        Double d = this.a;
        intent.putExtra("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        if (!TextUtils.isEmpty(this.l)) {
            intent.putExtra("rit_scene", this.l);
        }
        int i = this.um;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        com.byazt.vgx.w.n(intent, this.qg);
        intent.putExtra("multi_process_key", this.d);
        com.byazt.aq.s sVar = this.m;
        if (sVar != null) {
            intent.putExtra("insert_ad_bundle", sVar.rv().toString());
        }
        n(context, intent);
        com.byazt.eo.q.n().n(this.qg).n(7);
    }

    private void tj() {
        qg.n(this.d, new com.byazt.tmn.n(null) { // from class: com.byazt.rv.l.2
            @Override // com.byazt.tmn.n
            public void n(Bundle bundle) {
                com.byazt.de.qg.n(l.this.fs(), false, bundle != null ? bundle.getBoolean("has_show_event") : false);
                if (l.this.fs != null) {
                    l.this.fs.n(bundle);
                }
            }

            @Override // com.byazt.tmn.n
            public void qg(Bundle bundle) {
                com.byazt.de.qg.s(l.this.fs());
                if (l.this.fs != null) {
                    l.this.fs.qg(bundle);
                }
            }

            @Override // com.byazt.tmn.n
            public void s(Bundle bundle) {
                final Boolean boolValueOf = null;
                final Boolean boolValueOf2 = (bundle == null || !bundle.containsKey("send_show_event_result")) ? null : Boolean.valueOf(bundle.getBoolean("send_show_event_result"));
                if (bundle != null && bundle.containsKey("send_click_event_result")) {
                    boolValueOf = Boolean.valueOf(bundle.getBoolean("send_click_event_result"));
                }
                com.byazt.de.qg.n().n(l.this.fs(), new com.byazt.bok.qg.n() { // from class: com.byazt.rv.l.2.1
                    @Override // com.byazt.bok.qg.n
                    public void n(com.byazt.wea.fs fsVar) {
                        if (fsVar instanceof com.byazt.wea.q) {
                            Boolean bool = boolValueOf2;
                            if (bool != null) {
                                ((com.byazt.wea.q) fsVar).oa = bool.booleanValue() ? 1 : 0;
                            }
                            Boolean bool2 = boolValueOf;
                            if (bool2 != null) {
                                ((com.byazt.wea.q) fsVar).sz = bool2.booleanValue() ? 1 : 0;
                            }
                        }
                    }
                });
                com.byazt.de.qg.s(l.this.fs(), 1);
                if (l.this.fs != null) {
                    l.this.fs.s(bundle);
                }
            }

            @Override // com.byazt.tmn.n
            public void n() {
                if (l.this.fs != null) {
                    l.this.fs.n();
                }
            }

            @Override // com.byazt.tmn.n
            public void qg() {
                if (l.this.fs != null) {
                    l.this.fs.qg();
                }
            }

            @Override // com.byazt.tmn.n
            public void n(boolean z, int i, String str, int i2, String str2) {
                if (l.this.fs != null) {
                    l.this.fs.n(z, i, str, i2, str2);
                }
            }

            @Override // com.byazt.tmn.n
            public void n(boolean z, int i, Bundle bundle) {
                if (l.this.fs != null) {
                    l.this.fs.n(z, i, bundle);
                }
            }

            @Override // com.byazt.tmn.n
            public void s() {
                if (l.this.fs != null) {
                    l.this.fs.s();
                }
            }
        });
        if (this.rv != null) {
            qg.n(dh.n(this.d), this.rv);
        }
        if (this.tj != null) {
            s(true);
            qg.n(dh.qg(this.d), this.tj);
        }
    }

    private void n(Context context, Intent intent) {
        com.byazt.tk.n.n(context, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.rv.l.3
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                com.byazt.tk.k.n("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.s == null) {
            return;
        }
        com.byazt.tf.n nVarN = com.byazt.tf.n.n();
        com.byazt.zq.qg qgVar = this.s;
        nVarN.n(qgVar, qgVar.q());
        if (dh.n(this.qg)) {
            com.byazt.tf.n.n().qg(this.s, dh.q(this.qg));
        }
        if (!this.hu && !this.sz) {
            com.byazt.pj.s.n(7, this.qg);
        }
        x();
    }

    public void x() {
        if (this.qg == null || this.s == null || this.sz || this.hu || rv.qg().ts() != 0) {
            return;
        }
        try {
            if (this.q) {
                com.byazt.pj.x.n().n(this.s);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.fvm.k
    public Map<String, Object> qg() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return null;
        }
        Map<String, Object> mapWl = pkVar.wl();
        if (mapWl == null) {
            mapWl = new HashMap<>();
        }
        mapWl.put("expireTimestamp", Long.valueOf(q()));
        mapWl.put("isRDEnable", Boolean.valueOf(cx.q(this.qg)));
        mapWl.put("isPangle", Boolean.TRUE);
        mapWl.put("adSceneType", Integer.valueOf(com.byazt.has.q.n(this.qg)));
        return mapWl;
    }

    @Override // com.byazt.fvm.k
    public void n(Activity activity, Object obj, String str) {
        if (obj == null) {
            com.byazt.tk.k.qg("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strN = com.byazt.lpr.l.n(obj);
        if ("customize_scenes".equalsIgnoreCase(strN)) {
            this.l = str;
        } else {
            this.l = strN;
        }
        n(activity);
    }

    public void qg(boolean z) {
        this.sz = z;
    }

    public void s(String str) {
        this.d = str;
    }

    public void s(boolean z) {
        this.cd = z;
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
        if (this.py) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d);
        this.py = true;
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.ou) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d, str, str2);
        this.ou = true;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
        this.a = d;
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.n(pkVar.py(), qgVar, com.byazt.mi.qg.class);
        }
    }

    public String fs() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return null;
        }
        return pkVar.h();
    }

    public void finalize() throws Throwable {
        String strFs = fs();
        try {
            if (!TextUtils.isEmpty(strFs)) {
                q(strFs);
            }
        } finally {
            super.finalize();
        }
    }

    private static void q(final String str) {
        com.byazt.ag.qg.n(new x("reward_finalize_end") { // from class: com.byazt.rv.l.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.de.qg.s(str, 3);
            }
        });
    }
}
