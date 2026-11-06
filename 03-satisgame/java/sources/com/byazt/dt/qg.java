package com.byazt.dt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byazt.aqe.tj;
import com.byazt.fvm.k;
import com.byazt.gct.dh;
import com.byazt.kfh.TTProgressBar;
import com.byazt.nf.rv;
import com.byazt.pj.q;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.tk.h;
import com.byazt.tk.sz;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 212, 26})
public class qg implements n {
    public boolean fs;
    public final n.InterfaceC0156n n;
    public com.byazt.ez.n qg;
    public int w;
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicBoolean q = new AtomicBoolean(false);
    public final AtomicBoolean l = new AtomicBoolean(false);
    public int x = 0;
    public boolean rv = true;
    public String tj = "";
    public String cp = "";
    public String d = "";
    public String oa = "";
    public String sz = "";

    public qg(n.InterfaceC0156n interfaceC0156n) {
        this.n = interfaceC0156n;
    }

    @Override // com.byazt.dt.n
    public void n(boolean z) {
        this.l.set(z);
    }

    @Override // com.byazt.dt.n
    public void n(int i) {
        this.x = i;
    }

    @Override // com.byazt.dt.n
    public void qg(boolean z) {
        this.fs = z;
    }

    @Override // com.byazt.dt.n
    public void qg(int i) {
        this.w = i;
    }

    @Override // com.byazt.dt.n
    public boolean n() {
        return this.l.get();
    }

    @Override // com.byazt.dt.n
    public boolean s(int i) {
        n.InterfaceC0156n interfaceC0156n = this.n;
        if (interfaceC0156n == null || interfaceC0156n.getActivity() == null || this.n.n() == null || this.s.get() || !this.rv) {
            return false;
        }
        if (i == 1) {
            n.InterfaceC0156n interfaceC0156n2 = this.n;
            interfaceC0156n2.n(0, n(interfaceC0156n2.getActivity()));
            rv();
            com.byazt.hm.n.n(this.n.n(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return tj();
            }
            if (i == 3) {
                n.InterfaceC0156n interfaceC0156n3 = this.n;
                interfaceC0156n3.n(0, n(interfaceC0156n3.getActivity()));
                rv();
                com.byazt.hm.n.n(this.n.n(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.byazt.dt.n
    public boolean qg() {
        return this.q.get();
    }

    @Override // com.byazt.dt.n
    public void s() {
        com.byazt.ez.n nVar = this.qg;
        if (nVar != null) {
            nVar.s();
        }
        cp();
    }

    @Override // com.byazt.dt.n
    public void q() {
        n.InterfaceC0156n interfaceC0156n = this.n;
        if (interfaceC0156n == null || interfaceC0156n.getActivity() == null || this.n.n() == null || !dh.n(this.n.n())) {
            return;
        }
        if (!this.fs) {
            boolean z = this.x == 0;
            this.n.n(z, null, null);
            this.rv = z;
        } else {
            this.rv = false;
            this.n.n(false, this.tj, this.cp);
            final int i = this.x + 1;
            l.qg(new x("executeMultiProcessCallback") { // from class: com.byazt.dt.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.nf.l lVarN = com.byazt.ptd.n.n(com.byazt.prx.n.n(rv.getContext()).n(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        qg.this.n(lVarN.s(dh.qg(qg.this.n.qg()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.byazt.dt.n
    public boolean l() {
        com.byazt.ez.n nVar = this.qg;
        if (nVar == null) {
            return false;
        }
        return nVar.qg();
    }

    @Override // com.byazt.dt.n
    public void n(String str) {
        this.d = str;
    }

    @Override // com.byazt.dt.n
    public void qg(String str) {
        this.oa = str;
    }

    @Override // com.byazt.dt.n
    public String x() {
        return this.oa;
    }

    @Override // com.byazt.dt.n
    public String w() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bundle bundle) {
        boolean z = bundle.getBoolean("play_again_allow");
        this.tj = bundle.getString("play_again_reward_name");
        this.cp = bundle.getString("play_again_reward_amount");
        this.sz = bundle.getString("extra_info");
        this.rv = z;
        if (z) {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.dt.qg.2
                @Override // java.lang.Runnable
                public void run() {
                    qg.this.n.n(true, qg.this.tj, qg.this.cp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        try {
            this.s.set(true);
            String strQ = dh.q(this.n.n());
            if (TextUtils.isEmpty(strQ)) {
                strQ = String.valueOf(this.w);
            }
            if (TextUtils.isEmpty(strQ)) {
                strQ = String.valueOf(w.cy(this.n.n()));
            }
            com.byazt.pj.x.n().n(com.byazt.tf.n.n().n(this.n.n(), strQ), dh.s(this.n.n()), this.x, new q(new com.byazt.ap.x(null) { // from class: com.byazt.dt.qg.3
                @Override // com.byazt.ap.x
                public void n() {
                }

                @Override // com.byazt.ap.x
                public void qg(k kVar) {
                }

                @Override // com.byazt.ap.x
                public void n(int i, String str) {
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.dt.qg.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qg.this.q("当前无新视频，请点击重试");
                            qg.this.s.set(false);
                            if (qg.this.qg != null) {
                                qg.this.qg.l();
                            }
                            qg.this.n.n(8, null);
                        }
                    });
                }

                @Override // com.byazt.ap.x
                public void n(final k kVar) {
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.dt.qg.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            k kVar2 = kVar;
                            if (!(kVar2 instanceof com.byazt.rv.l)) {
                                qg.this.q("当前无新视频，请点击重试");
                                qg.this.s.set(false);
                            } else {
                                com.byazt.rv.l lVar = (com.byazt.rv.l) kVar2;
                                lVar.qg(true);
                                lVar.n(qg.this.w);
                                lVar.qg(qg.this.x + 1);
                                lVar.s(qg.this.n.qg());
                                if (!TextUtils.isEmpty(qg.this.tj) && !TextUtils.isEmpty(qg.this.cp)) {
                                    lVar.qg(qg.this.cp);
                                    lVar.n(qg.this.tj);
                                }
                                lVar.s(qg.this.fs);
                                lVar.n(qg.this.n.getActivity());
                                qg.this.n.l();
                                qg.this.q.set(true);
                            }
                            qg.this.n.n(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.s.set(false);
            q("当前无新视频，请退出后重试");
        }
    }

    private boolean tj() {
        if (!dh.qg(this.n.n())) {
            return false;
        }
        if (this.s.get()) {
            return true;
        }
        tj tjVar = new tj() { // from class: com.byazt.dt.qg.4
            @Override // com.byazt.aqe.tj
            public void n() {
                if (qg.this.s.get()) {
                    return;
                }
                if (qg.this.qg != null) {
                    qg.this.qg.q();
                }
                qg.this.rv();
                com.byazt.hm.n.n(qg.this.n.n(), "reward_endcard", "reward_again", "popup");
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                if (qg.this.s.get()) {
                    return;
                }
                com.byazt.hm.n.n(qg.this.n.n(), "reward_endcard", "popup_cancel", (String) null);
                qg.this.n.s();
            }
        };
        com.byazt.ez.qg qgVar = new com.byazt.ez.qg(this.n.getActivity(), this.n.n());
        this.qg = qgVar;
        qgVar.q(this.tj);
        this.qg.s(this.cp);
        this.qg.n(this.sz);
        this.n.q();
        return this.qg.n(tjVar).s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final String str) {
        n.InterfaceC0156n interfaceC0156n = this.n;
        if (interfaceC0156n == null || interfaceC0156n.getActivity() == null) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.dt.qg.5
            @Override // java.lang.Runnable
            public void run() {
                h.n(qg.this.n.getActivity(), str, 0);
            }
        });
    }

    private TTProgressBar n(final Context context) {
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iS = com.byazt.okk.s.s(context, 10.0f);
        tTProgressBar.setPadding(iS, iS, iS, iS);
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.dt.qg.6
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return tTProgressBar;
    }

    @Override // com.byazt.dt.n
    public String fs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.l.get());
            jSONObject.put("mSourceRitId", this.w);
            jSONObject.put("mNowPlayAgainCount", this.x);
            jSONObject.put("isCustomPlayAgain", this.fs);
            jSONObject.put("isCanPlayAgain", this.rv);
            jSONObject.put("mPlayAgainRewardName", this.tj);
            jSONObject.put("mPlayAgainRewardAmount", this.cp);
            jSONObject.put("mLastRewardName", this.d);
            jSONObject.put("mLastRewardAmount", this.oa);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.dt.n
    public void s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.l.set(jSONObject.getBoolean("isPlayAgain"));
            this.w = jSONObject.optInt("mSourceRitId");
            this.x = jSONObject.optInt("mNowPlayAgainCount");
            this.fs = jSONObject.optBoolean("isCustomPlayAgain");
            this.rv = jSONObject.optBoolean("isCanPlayAgain");
            this.tj = jSONObject.optString("mPlayAgainRewardName");
            this.cp = jSONObject.optString("mPlayAgainRewardAmount");
            this.d = jSONObject.optString("mLastRewardName");
            this.cp = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }

    private void cp() {
        l.qg(new x("executeMultiProcessCallback") { // from class: com.byazt.dt.qg.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.ptd.n.n(com.byazt.prx.n.n(rv.getContext()).n(5)).s(dh.qg(qg.this.n.qg()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }
}
