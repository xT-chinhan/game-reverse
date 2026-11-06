package com.bytedance.sdk.openadsdk.core.component.reward.business.xr;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.anythink.core.common.e.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ub;
import com.bytedance.sdk.openadsdk.core.ao;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.component.reward.ms.ka;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms {
    private int c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ms.InterfaceC0272ms f2124ms;
    private boolean x;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms xr;
    private final AtomicBoolean ah = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean ka = new AtomicBoolean(false);
    private int ab = 0;
    private boolean ny = true;
    private String ch = "";
    private String hi = "";
    private String sl = "";
    private String zb = "";
    private String u = "";

    public xr(ms.InterfaceC0272ms interfaceC0272ms) {
        this.f2124ms = interfaceC0272ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void ms(boolean z) {
        this.ka.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void ms(int i) {
        this.ab = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void xr(boolean z) {
        this.x = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void xr(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public boolean ms() {
        return this.ka.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public boolean ah(int i) {
        ms.InterfaceC0272ms interfaceC0272ms = this.f2124ms;
        if (interfaceC0272ms == null || interfaceC0272ms.getActivity() == null || this.f2124ms.ms() == null || this.ah.get() || !this.ny) {
            return false;
        }
        if (i == 1) {
            ms.InterfaceC0272ms interfaceC0272ms2 = this.f2124ms;
            interfaceC0272ms2.ms(0, ms(interfaceC0272ms2.getActivity()));
            ny();
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2124ms.ms(), "reward_endcard", "reward_again", "endcard");
        } else {
            if (i == 2) {
                return ch();
            }
            if (i == 3) {
                ms.InterfaceC0272ms interfaceC0272ms3 = this.f2124ms;
                interfaceC0272ms3.ms(0, ms(interfaceC0272ms3.getActivity()));
                ny();
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.f2124ms.ms(), "reward_endcard", "reward_again", "videoplaying");
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public boolean xr() {
        return this.d.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void ah() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms msVar = this.xr;
        if (msVar != null) {
            msVar.ah();
        }
        hi();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void d() {
        ms.InterfaceC0272ms interfaceC0272ms = this.f2124ms;
        if (interfaceC0272ms == null || interfaceC0272ms.getActivity() == null || this.f2124ms.ms() == null || !k.ms(this.f2124ms.ms())) {
            return;
        }
        if (!this.x) {
            boolean z = this.ab == 0;
            this.f2124ms.ms(z, null, null);
            this.ny = z;
        } else {
            this.ny = false;
            this.f2124ms.ms(false, this.ch, this.hi);
            final int i = this.ab + 1;
            ab.xr(new ny("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ao aoVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(5));
                        Bundle bundle = new Bundle();
                        bundle.putInt("callback_extra_key_next_play_again_count", i);
                        xr.this.ms(aoVarMs.xr(k.xr(xr.this.f2124ms.xr()), "getPlayAgainCondition", bundle));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public boolean ka() {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms msVar = this.xr;
        if (msVar == null) {
            return false;
        }
        return msVar.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void ms(String str) {
        this.sl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void xr(String str) {
        this.zb = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public String ab() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public String c() {
        return this.sl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Bundle bundle) {
        boolean z = bundle.getBoolean(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_ALLOW);
        this.ch = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_NAME);
        this.hi = bundle.getString(TTRewardVideoAd.RewardAdPlayAgainController.KEY_PLAY_AGAIN_REWARD_AMOUNT);
        this.u = bundle.getString(b.a.f);
        this.ny = z;
        if (z) {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.2
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.f2124ms.ms(true, xr.this.ch, xr.this.hi);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        try {
            this.ah.set(true);
            String strD = k.d(this.f2124ms.ms());
            if (TextUtils.isEmpty(strD)) {
                strD = String.valueOf(this.c);
            }
            if (TextUtils.isEmpty(strD)) {
                strD = String.valueOf(f.ny(this.f2124ms.ms()));
            }
            ka.ms().ms(com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.xr.ms().ms(strD), k.ah(this.f2124ms.ms()), this.ab, new com.bytedance.sdk.openadsdk.core.component.reward.ms.ah(new com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab(null) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.3
                @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
                public void xr() {
                }

                @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
                public void xr(ub ubVar) {
                }

                @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
                public void ms(int i, String str) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xr.this.d("当前无新视频，请点击重试");
                            xr.this.ah.set(false);
                            if (xr.this.xr != null) {
                                xr.this.xr.ka();
                            }
                            xr.this.f2124ms.ms(8, null);
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab
                public void ms(final ub ubVar) {
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ub ubVar2 = ubVar;
                            if (!(ubVar2 instanceof com.bytedance.sdk.openadsdk.core.component.reward.ah)) {
                                xr.this.d("当前无新视频，请点击重试");
                                xr.this.ah.set(false);
                            } else {
                                com.bytedance.sdk.openadsdk.core.component.reward.ah ahVar = (com.bytedance.sdk.openadsdk.core.component.reward.ah) ubVar2;
                                ahVar.xr(true);
                                ahVar.ms(xr.this.c);
                                ahVar.xr(xr.this.ab + 1);
                                ahVar.ah(xr.this.f2124ms.xr());
                                if (!TextUtils.isEmpty(xr.this.ch) && !TextUtils.isEmpty(xr.this.hi)) {
                                    ahVar.xr(xr.this.hi);
                                    ahVar.ms(xr.this.ch);
                                }
                                ahVar.ah(xr.this.x);
                                ahVar.ms(xr.this.f2124ms.getActivity());
                                xr.this.f2124ms.ka();
                                xr.this.d.set(true);
                            }
                            xr.this.f2124ms.ms(8, null);
                        }
                    });
                }
            }));
        } catch (Throwable unused) {
            this.ah.set(false);
            d("当前无新视频，请退出后重试");
        }
    }

    private boolean ch() {
        if (!k.xr(this.f2124ms.ms())) {
            return false;
        }
        if (this.ah.get()) {
            return true;
        }
        ch chVar = new ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                if (xr.this.ah.get()) {
                    return;
                }
                if (xr.this.xr != null) {
                    xr.this.xr.d();
                }
                xr.this.ny();
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(xr.this.f2124ms.ms(), "reward_endcard", "reward_again", "popup");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                if (xr.this.ah.get()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(xr.this.f2124ms.ms(), "reward_endcard", "popup_cancel", (String) null);
                xr.this.f2124ms.ah();
            }
        };
        com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.xr xrVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.xr(this.f2124ms.getActivity(), this.f2124ms.ms());
        this.xr = xrVar;
        xrVar.d(this.ch);
        this.xr.ah(this.hi);
        this.xr.ms(this.u);
        this.f2124ms.d();
        return this.xr.ms(chVar).ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        ms.InterfaceC0272ms interfaceC0272ms = this.f2124ms;
        if (interfaceC0272ms == null || interfaceC0272ms.getActivity() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.5
            @Override // java.lang.Runnable
            public void run() {
                op.ms(xr.this.f2124ms.getActivity(), str, 0);
            }
        });
    }

    private TTProgressBar ms(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
        layoutParams.gravity = 17;
        tTProgressBar.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#77000000"));
        gradientDrawable.setCornerRadius(ul.ah(context, 2.0f));
        tTProgressBar.setBackground(gradientDrawable);
        int iAh = ul.ah(context, 10.0f);
        tTProgressBar.setPadding(iAh, iAh, iAh, iAh);
        tTProgressBar.setIndeterminateDrawable(t.ah(context, "tt_video_loading_progress_bar"));
        return tTProgressBar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public String x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPlayAgain", this.ka.get());
            jSONObject.put("mSourceRitId", this.c);
            jSONObject.put("mNowPlayAgainCount", this.ab);
            jSONObject.put("isCustomPlayAgain", this.x);
            jSONObject.put("isCanPlayAgain", this.ny);
            jSONObject.put("mPlayAgainRewardName", this.ch);
            jSONObject.put("mPlayAgainRewardAmount", this.hi);
            jSONObject.put("mLastRewardName", this.sl);
            jSONObject.put("mLastRewardAmount", this.zb);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms
    public void ah(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ka.set(jSONObject.getBoolean("isPlayAgain"));
            this.c = jSONObject.optInt("mSourceRitId");
            this.ab = jSONObject.optInt("mNowPlayAgainCount");
            this.x = jSONObject.optBoolean("isCustomPlayAgain");
            this.ny = jSONObject.optBoolean("isCanPlayAgain");
            this.ch = jSONObject.optString("mPlayAgainRewardName");
            this.hi = jSONObject.optString("mPlayAgainRewardAmount");
            this.sl = jSONObject.optString("mLastRewardName");
            this.hi = jSONObject.optString("mPlayAgainRewardAmount");
        } catch (Exception unused) {
        }
    }

    private void hi() {
        ab.xr(new ny("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.xr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(5)).xr(k.xr(xr.this.f2124ms.xr()), "recycleRes", null);
                } catch (Throwable unused) {
                }
            }
        }, 5);
    }
}
