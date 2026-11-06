package com.byazt.rv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.fvm.cp;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.iz.fs;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 5})
public class q extends cp {
    public com.byazt.aq.s cy;
    public boolean hd;
    public AppDownloadListener k;
    public long l;
    public final Context n;
    public com.byazt.zq.qg oa;
    public String q;
    public final pk qg;
    public com.byazt.rzx.n sz;
    public final String x;
    public final AtomicBoolean w = new AtomicBoolean(false);
    public int fs = -1;
    public Double rv = null;
    public boolean tj = false;
    public boolean cp = false;
    public long d = System.currentTimeMillis();
    public boolean s = false;

    public q(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        this.n = context;
        this.qg = pkVar;
        this.oa = qgVar;
        this.x = pkVar.hashCode() + pkVar.ou() + hashCode();
        com.byazt.de.qg.n(pkVar, qgVar, 8, fs());
    }

    public void n(boolean z) {
        this.hd = z;
    }

    public void n(com.byazt.aq.s sVar) {
        this.cy = sVar;
    }

    public void w() {
        if (this.w.get()) {
            return;
        }
        this.s = true;
    }

    public void n(int i) {
        this.fs = i;
    }

    @Override // com.byazt.fvm.cp
    public void n(com.byazt.rzx.n nVar) {
        if (this.w.get()) {
            qg.n(this.x, nVar);
        }
        this.sz = nVar;
    }

    @Override // com.byazt.fvm.cp
    public void n(com.byazt.mi.s sVar) {
        this.k = AppDownloadListener.Converter.convert(sVar);
    }

    @Override // com.byazt.fvm.cp
    public int n() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.rv();
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity) {
        Intent intent;
        com.byazt.de.qg.qg(fs());
        com.byazt.hm.n.n(this.qg, "fullscreen_interstitial_ad", "show_start", (com.byazt.rs.n) null);
        if (activity != null && activity.isFinishing()) {
            k.qg("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.w.get()) {
            return;
        }
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.uq.qg.n(pkVar, "fullscreen_interstitial_ad", activity, this.q, this.s);
        }
        this.w.set(true);
        pk pkVar2 = this.qg;
        if (pkVar2 != null) {
            if (ta.k(pkVar2) == null && this.qg.jo() == null) {
                return;
            }
            if (n() == 4) {
                com.byazt.ag.qg.n(new x("full_register_download") { // from class: com.byazt.rv.q.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fs.n(q.this.n, q.this.qg, "fullscreen_interstitial_ad").addAppDownloadListener(q.this.k);
                    }
                });
            }
            com.byazt.ikv.n.n().qg("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.n : activity;
            if (context == null) {
                context = rv.getContext();
            }
            tj();
            if (this.qg.ys() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.byazt.zq.qg qgVar = this.oa;
            if (qgVar != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(qgVar.py()));
            }
            intent.putExtra("is_preload", this.s);
            intent.putExtra("object_create_ts", this.d);
            Double d = this.rv;
            intent.putExtra("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
            if (!TextUtils.isEmpty(this.q)) {
                intent.putExtra("rit_scene", this.q);
            }
            int i = this.fs;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            if (this.hd) {
                intent.putExtra("is_second_page", true);
            }
            w.n(intent, this.qg);
            intent.putExtra("multi_process_key", this.x);
            com.byazt.aq.s sVar = this.cy;
            if (sVar != null) {
                intent.putExtra("insert_ad_bundle", sVar.rv().toString());
            }
            n(context, intent);
            com.byazt.eo.q.n().n(this.qg).n(8);
        }
    }

    private void tj() {
        if (this.sz != null) {
            qg.n(this.x, new com.byazt.rzx.n(null) { // from class: com.byazt.rv.q.2
                @Override // com.byazt.rzx.n
                public void n(Bundle bundle) {
                    com.byazt.de.qg.n(q.this.fs(), false, bundle != null ? bundle.getBoolean("has_show_event") : false);
                    if (q.this.sz != null) {
                        q.this.sz.n(bundle);
                    }
                }

                @Override // com.byazt.rzx.n
                public void qg(Bundle bundle) {
                    com.byazt.de.qg.s(q.this.fs());
                    if (q.this.sz != null) {
                        q.this.sz.qg(bundle);
                    }
                }

                @Override // com.byazt.rzx.n
                public void s(Bundle bundle) {
                    final Boolean boolValueOf = null;
                    final Boolean boolValueOf2 = (bundle == null || !bundle.containsKey("send_show_event_result")) ? null : Boolean.valueOf(bundle.getBoolean("send_show_event_result"));
                    if (bundle != null && bundle.containsKey("send_click_event_result")) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("send_click_event_result"));
                    }
                    com.byazt.de.qg.n().n(q.this.fs(), new com.byazt.bok.qg.n() { // from class: com.byazt.rv.q.2.1
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
                    com.byazt.de.qg.s(q.this.fs(), 1);
                    if (q.this.sz != null) {
                        q.this.sz.s(bundle);
                    }
                }

                @Override // com.byazt.rzx.n
                public void n() {
                    if (q.this.sz != null) {
                        q.this.sz.n();
                    }
                }

                @Override // com.byazt.rzx.n
                public void qg() {
                    if (q.this.sz != null) {
                        q.this.sz.qg();
                    }
                }
            });
        }
    }

    private void n(Context context, Intent intent) {
        com.byazt.tk.n.n(context, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.rv.q.3
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                k.n("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.oa == null) {
            return;
        }
        com.byazt.tf.n nVarN = com.byazt.tf.n.n();
        com.byazt.zq.qg qgVar = this.oa;
        nVarN.n(qgVar, qgVar.q());
        if (!this.hd) {
            com.byazt.pj.s.n(8, this.qg);
        }
        x();
    }

    public void x() {
        if (this.qg == null || this.oa == null || this.hd || rv.qg().ts() != 0) {
            return;
        }
        try {
            boolean z = this.s;
            if (this.oa == null || !z) {
                return;
            }
            com.byazt.pj.qg.n().n(this.oa);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity, Object obj, String str) {
        if (obj == null) {
            k.qg("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strN = com.byazt.lpr.l.n(obj);
        if ("customize_scenes".equalsIgnoreCase(strN)) {
            this.q = str;
        } else {
            this.q = strN;
        }
        n(activity);
    }

    @Override // com.byazt.fvm.cp
    public Map<String, Object> qg() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return null;
        }
        Map<String, Object> mapWl = pkVar.wl();
        mapWl.put("expireTimestamp", Long.valueOf(q()));
        mapWl.put("adSceneType", Integer.valueOf(com.byazt.has.q.n(this.qg)));
        return mapWl;
    }

    @Override // com.byazt.fvm.cp
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
        this.l = j;
    }

    @Override // com.byazt.fvm.cp
    public long q() {
        return this.l;
    }

    @Override // com.byazt.fvm.cp
    public com.byazt.nq.q l() {
        return new com.byazt.fp.qg();
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
        if (this.tj) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d);
        this.tj = true;
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.cp) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d, str, str2);
        this.cp = true;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
        this.rv = d;
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
                n(strFs);
            }
        } finally {
            super.finalize();
        }
    }

    private static void n(final String str) {
        com.byazt.ag.qg.n(new x("fullscreen_finalize_end") { // from class: com.byazt.rv.q.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.de.qg.s(str, 3);
            }
        });
    }
}
