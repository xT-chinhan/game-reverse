package com.byazt.db;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byazt.ca.b;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.hs;
import com.byazt.mr.ho;
import com.byazt.sd.a;
import com.byazt.sd.g;
import com.byazt.vh.x;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wv.vk;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 908, 13})
public class hw implements pr {
    public com.byazt.xu.pr hw;
    public final pr.InterfaceC0038pr pr;
    public int uc;
    public boolean zo;
    public final AtomicBoolean hn = new AtomicBoolean(false);
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicBoolean c = new AtomicBoolean(false);
    public int fw = 0;
    public boolean aj = true;
    public String vk = "";
    public String w = "";
    public String k = "";
    public String m = "";
    public String g = "";

    public hw(pr.InterfaceC0038pr interfaceC0038pr) {
        this.pr = interfaceC0038pr;
    }

    @Override // com.byazt.db.pr
    public void pr(boolean z) {
        this.c.set(z);
    }

    @Override // com.byazt.db.pr
    public void pr(int i) {
        this.fw = i;
    }

    @Override // com.byazt.db.pr
    public void hw(boolean z) {
        this.zo = z;
    }

    @Override // com.byazt.db.pr
    public void hw(int i) {
        this.uc = i;
    }

    @Override // com.byazt.db.pr
    public boolean pr() {
        return this.c.get();
    }

    @Override // com.byazt.db.pr
    public boolean hn(int i) {
        pr.InterfaceC0038pr interfaceC0038pr = this.pr;
        if (interfaceC0038pr == null || interfaceC0038pr.getActivity() == null || this.pr.pr() == null || this.hn.get() || !this.aj) {
            return false;
        }
        switch (i) {
            case 1:
                pr.InterfaceC0038pr interfaceC0038pr2 = this.pr;
                interfaceC0038pr2.pr(0, pr(interfaceC0038pr2.getActivity()));
                aj();
                com.byazt.pj.pr.pr(this.pr.pr(), "reward_endcard", "reward_again", "endcard");
                return true;
            case 2:
                return vk();
            case 3:
                pr.InterfaceC0038pr interfaceC0038pr3 = this.pr;
                interfaceC0038pr3.pr(0, pr(interfaceC0038pr3.getActivity()));
                aj();
                com.byazt.pj.pr.pr(this.pr.pr(), "reward_endcard", "reward_again", "videoplaying");
                return true;
            default:
                return true;
        }
    }

    @Override // com.byazt.db.pr
    public boolean hw() {
        return this.x.get();
    }

    @Override // com.byazt.db.pr
    public void hn() {
        com.byazt.xu.pr prVar = this.hw;
        if (prVar != null) {
            prVar.hn();
        }
        w();
    }

    @Override // com.byazt.db.pr
    public void x() {
        pr.InterfaceC0038pr interfaceC0038pr = this.pr;
        if (interfaceC0038pr == null || interfaceC0038pr.getActivity() == null || this.pr.pr() == null || !hs.pr(this.pr.pr())) {
            return;
        }
        if (!this.zo) {
            boolean z = this.fw == 0;
            this.pr.pr(z, null, null);
            this.aj = z;
        } else {
            this.aj = false;
            this.pr.pr(false, this.vk, this.w);
            final int i = this.fw + 1;
            c.hw(new fw("executeMultiProcessCallback") { // from class: com.byazt.db.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g gVarPr = com.byazt.us.pr.pr(com.byazt.gt.pr.pr(a.getContext()).pr(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        hw.this.pr(gVarPr.hn(hs.hw(hw.this.pr.hw()), "getPlayAgainCondition", bundle));
                    } catch (Throwable th) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.byazt.db.pr
    public boolean c() {
        com.byazt.xu.pr prVar = this.hw;
        if (prVar == null) {
            return false;
        }
        return prVar.hw();
    }

    @Override // com.byazt.db.pr
    public void pr(String str) {
        this.k = str;
    }

    @Override // com.byazt.db.pr
    public void hw(String str) {
        this.m = str;
    }

    @Override // com.byazt.db.pr
    public String fw() {
        return this.m;
    }

    @Override // com.byazt.db.pr
    public String uc() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bundle bundle) {
        boolean z = bundle.getBoolean("play_again_allow");
        this.vk = bundle.getString("play_again_reward_name");
        this.w = bundle.getString("play_again_reward_amount");
        this.g = bundle.getString("extra_info");
        this.aj = z;
        if (z) {
            zo.pr(new Runnable() { // from class: com.byazt.db.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.pr.pr(true, hw.this.vk, hw.this.w);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        try {
            this.hn.set(true);
            String strX = hs.x(this.pr.pr());
            if (TextUtils.isEmpty(strX)) {
                strX = String.valueOf(this.uc);
            }
            if (TextUtils.isEmpty(strX)) {
                strX = String.valueOf(ls.m(this.pr.pr()));
            }
            com.byazt.vh.fw.pr().pr(com.byazt.bv.pr.pr().pr(this.pr.pr(), strX), hs.hn(this.pr.pr()), this.fw, new x(new com.byazt.pis.fw(null) { // from class: com.byazt.db.hw.3
                @Override // com.byazt.pis.fw
                public void pr(int i, String str) {
                    zo.pr(new Runnable() { // from class: com.byazt.db.hw.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hw.this.x("当前无新视频，请点击重试");
                            hw.this.hn.set(false);
                            if (hw.this.hw != null) {
                                hw.this.hw.c();
                            }
                            hw.this.pr.pr(8, null);
                        }
                    });
                }

                @Override // com.byazt.pis.fw
                public void pr(final ho hoVar) {
                    zo.pr(new Runnable() { // from class: com.byazt.db.hw.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ho hoVar2 = hoVar;
                            if (!(hoVar2 instanceof com.byazt.joa.hn)) {
                                hw.this.x("当前无新视频，请点击重试");
                                hw.this.hn.set(false);
                            } else {
                                com.byazt.joa.hn hnVar = (com.byazt.joa.hn) hoVar2;
                                hnVar.hw(true);
                                hnVar.pr(hw.this.uc);
                                hnVar.hw(hw.this.fw + 1);
                                hnVar.hn(hw.this.pr.hw());
                                if (!TextUtils.isEmpty(hw.this.vk) && !TextUtils.isEmpty(hw.this.w)) {
                                    hnVar.hw(hw.this.w);
                                    hnVar.pr(hw.this.vk);
                                }
                                hnVar.hn(hw.this.zo);
                                hnVar.pr(hw.this.pr.getActivity());
                                hw.this.pr.c();
                                hw.this.x.set(true);
                            }
                            hw.this.pr.pr(8, null);
                        }
                    });
                }

                @Override // com.byazt.pis.fw
                public void hw() {
                }

                @Override // com.byazt.pis.fw
                public void hw(ho hoVar) {
                }
            }));
        } catch (Throwable th) {
            this.hn.set(false);
            x("当前无新视频，请退出后重试");
        }
    }

    private boolean vk() {
        if (!hs.hw(this.pr.pr())) {
            return false;
        }
        if (this.hn.get()) {
            return true;
        }
        vk vkVar = new vk() { // from class: com.byazt.db.hw.4
            @Override // com.byazt.wv.vk
            public void pr() {
                if (!hw.this.hn.get()) {
                    if (hw.this.hw != null) {
                        hw.this.hw.x();
                    }
                    hw.this.aj();
                    com.byazt.pj.pr.pr(hw.this.pr.pr(), "reward_endcard", "reward_again", "popup");
                }
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                if (!hw.this.hn.get()) {
                    com.byazt.pj.pr.pr(hw.this.pr.pr(), "reward_endcard", "popup_cancel", (String) null);
                    hw.this.pr.hn();
                }
            }
        };
        com.byazt.xu.hw hwVar = new com.byazt.xu.hw(this.pr.getActivity(), this.pr.pr());
        this.hw = hwVar;
        hwVar.x(this.vk);
        this.hw.hn(this.w);
        this.hw.pr(this.g);
        this.pr.x();
        return this.hw.pr(vkVar).hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final String str) {
        pr.InterfaceC0038pr interfaceC0038pr = this.pr;
        if (interfaceC0038pr == null || interfaceC0038pr.getActivity() == null) {
            return;
        }
        zo.pr(new Runnable() { // from class: com.byazt.db.hw.5
            @Override // java.lang.Runnable
            public void run() {
                b.pr(hw.this.pr.getActivity(), str, 0);
            }
        });
    }

    private TTProgressBar pr(final Context context) {
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(er.hn(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iHn = er.hn(context, 10.0f);
        tTProgressBar.setPadding(iHn, iHn, iHn, iHn);
        com.byazt.ca.g.pr(context, "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.db.hw.6
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.pr(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return tTProgressBar;
    }

    @Override // com.byazt.db.pr
    public String zo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.c.get());
            jSONObject.put("mSourceRitId", this.uc);
            jSONObject.put("mNowPlayAgainCount", this.fw);
            jSONObject.put("isCustomPlayAgain", this.zo);
            jSONObject.put("isCanPlayAgain", this.aj);
            jSONObject.put("mPlayAgainRewardName", this.vk);
            jSONObject.put("mPlayAgainRewardAmount", this.w);
            jSONObject.put("mLastRewardName", this.k);
            jSONObject.put("mLastRewardAmount", this.m);
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.db.pr
    public void hn(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c.set(jSONObject.getBoolean("isPlayAgain"));
            this.uc = jSONObject.optInt("mSourceRitId");
            this.fw = jSONObject.optInt("mNowPlayAgainCount");
            this.zo = jSONObject.optBoolean("isCustomPlayAgain");
            this.aj = jSONObject.optBoolean("isCanPlayAgain");
            this.vk = jSONObject.optString("mPlayAgainRewardName");
            this.w = jSONObject.optString("mPlayAgainRewardAmount");
            this.k = jSONObject.optString("mLastRewardName");
            this.w = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception e) {
        }
    }

    private void w() {
        c.hw(new fw("executeMultiProcessCallback") { // from class: com.byazt.db.hw.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.us.pr.pr(com.byazt.gt.pr.pr(a.getContext()).pr(5)).hn(hs.hw(hw.this.pr.hw()), "recycleRes", null);
                } catch (Throwable th) {
                }
            }
        }, 5);
    }
}
