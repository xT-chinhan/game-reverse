package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private com.bytedance.sdk.openadsdk.core.ugeno.x.ms ao;
    private AtomicBoolean b;
    private com.bytedance.sdk.openadsdk.core.ugeno.ny.xr h;
    private boolean i;
    private AtomicBoolean nw;
    private AtomicBoolean qv;
    private com.bytedance.sdk.openadsdk.core.component.reward.xr.ka re;
    private RewardLpBottomView t;
    private com.bytedance.sdk.openadsdk.core.zb.ka u;
    private com.bytedance.sdk.openadsdk.core.ugeno.ny.d ub;
    private String y;
    private com.bytedance.sdk.openadsdk.core.ugeno.c.ms zb;

    public ms(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z, com.bytedance.sdk.openadsdk.core.zb.ka kaVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar2) {
        super(tTBaseVideoActivity, lmVar, z);
        this.zb = lmVar.op();
        this.u = kaVar;
        this.xr.ab(0);
        this.qv = new AtomicBoolean();
        this.nw = new AtomicBoolean();
        this.b = new AtomicBoolean();
        this.re = kaVar2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.y = f.ms(f.xr(this.f2216ms));
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = this.zb;
        if (msVar == null) {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.xr.ab(8);
                    ms.this.xr.t();
                }
            });
            return;
        }
        int iD = msVar.d();
        if (iD == 2) {
            h();
            return;
        }
        if (iD == 3) {
            qv();
        } else if (iD == 4) {
            y();
        } else {
            this.xr.ab(8);
            this.xr.t();
        }
    }

    private void h() {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.d dVar = new com.bytedance.sdk.openadsdk.core.ugeno.ny.d(this.xr, this.ab, this.u, this.ah, this.y, f.xr(this.f2216ms));
        this.ub = dVar;
        dVar.xr(true);
        this.ub.ms(new com.bytedance.sdk.openadsdk.core.ugeno.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(View view) {
                ms.this.xr.ab(8);
                ms.this.qv.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(int i) {
                nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr.ab(8);
                        ms.this.xr.t();
                    }
                });
                ms.this.qv.set(false);
            }
        });
        this.ub.zb();
    }

    private void qv() {
        FrameLayout frameLayout = new FrameLayout(this.xr);
        this.ab.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = new com.bytedance.sdk.openadsdk.core.ugeno.ny.xr(this.xr, frameLayout, this.u, this.ah, this.y, f.xr(this.f2216ms));
        this.h = xrVar;
        xrVar.xr(true);
        this.h.ms(new com.bytedance.sdk.openadsdk.core.ugeno.ab.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.xr
            public void ms() {
                ms.this.xr.e();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.xr
            public void xr() {
                ms.this.xr.k();
                ms.this.nw.set(true);
                ms.this.h.t();
            }
        });
        this.h.ms(new com.bytedance.sdk.openadsdk.core.ugeno.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(View view) {
                ms.this.xr.ab(8);
                ms.this.qv.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(int i) {
                nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr.ab(8);
                        ms.this.h.h();
                        ms.this.h.ms(t.ms(ms.this.xr, "tt_ecomm_page_reward_acquire"));
                        ms.this.xr.d(0);
                    }
                });
                ms.this.qv.set(false);
            }
        });
        this.h.ms(new com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.InterfaceC0313ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ms.InterfaceC0313ms
            public void ms() {
                nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ms.this.xr.tz()) {
                            ms.this.h.ms(t.ms(ms.this.xr, "tt_ecomm_page_reward_acquire"));
                        } else {
                            ms.this.h.ms(String.format(t.ms(ms.this.xr, "tt_ecomm_page_reward_tip"), Integer.valueOf(ms.this.xr.sa().f())));
                        }
                    }
                });
            }
        });
        this.h.zb();
        com.bytedance.sdk.openadsdk.core.ch.ub().d().xr(new com.bytedance.sdk.openadsdk.core.jw.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.6
            @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
            public void xr() {
                if (ms.this.nw.get() || !ms.this.h.u()) {
                    ms.this.b.set(false);
                } else {
                    ms.this.b.set(true);
                }
            }
        });
        if (TextUtils.equals(this.zb.ms(), "3")) {
            return;
        }
        xr();
    }

    public void xr() {
        final ImageView imageView = new ImageView(this.xr);
        float fAh = ul.ah(this.xr, 18.0f);
        float fAh2 = ul.ah(this.xr, 20.0f);
        int i = (int) fAh;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) fAh2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.ab.addView(imageView, layoutParams);
        t.ms((Context) this.xr, "tt_unmute", imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ms msVar = ms.this;
                msVar.i = !msVar.i;
                t.ms((Context) ms.this.xr, ms.this.i ? "tt_mute" : "tt_unmute", imageView);
                ms.this.h.ah(ms.this.i);
            }
        });
    }

    private void y() {
        com.bytedance.sdk.openadsdk.core.ugeno.x.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.x.ms(this.xr, t(), this.zb, this.ah);
        this.ao = msVar;
        msVar.ms(this.xr.eg());
        this.ao.ms(new com.bytedance.sdk.openadsdk.core.ugeno.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(View view) {
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr.ab(8);
                        ms.this.qv.set(true);
                        if (ms.this.t != null) {
                            ms.this.t.ms();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.d.ms
            public void ms(int i) {
                nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr.ab(8);
                        ms.this.xr.t();
                    }
                });
                ms.this.qv.set(false);
            }
        });
        this.ao.ms();
    }

    private ViewGroup t() {
        if (this.ab == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.xr);
        this.ab.addView(playableEndcardFrameLayout);
        this.t = new RewardLpBottomView(this.xr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.ab.addView(this.t, layoutParams);
        this.t.ms(this.ah, this.y);
        playableEndcardFrameLayout.ms(new PlayableEndcardFrameLayout.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ms.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.ms
            public void ms() {
                if (ms.this.t != null) {
                    ms.this.t.xr();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    public boolean ah() {
        return this.b.get();
    }

    public void ms(boolean z) {
        this.b.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        super.ms(xrVar, xrVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.ny.d dVar = this.ub;
        if (dVar != null) {
            dVar.ms(this.xr.eg());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar3 = this.h;
        if (xrVar3 != null) {
            xrVar3.ms(this.xr.eg());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.x.ms msVar = this.ao;
        if (msVar != null) {
            msVar.ms(xrVar);
        }
    }

    public boolean d() {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = this.h;
        if (xrVar != null) {
            return xrVar.u();
        }
        return false;
    }

    public AtomicInteger ka() {
        return new AtomicInteger(0);
    }

    public void ms(int i) {
        if (this.ub == null || !com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.ah)) {
            return;
        }
        this.ub.ah(i);
    }

    public void xr(boolean z) {
        if (this.h == null || !com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.ah)) {
            return;
        }
        this.h.ah(z);
    }

    public boolean c() {
        return this.qv.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.x.ms msVar = this.ao;
        if (msVar != null) {
            msVar.ms(downloadListener);
        }
    }

    public void ab() {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = this.h;
        if (xrVar != null) {
            xrVar.y();
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = this.h;
        if (xrVar != null) {
            xrVar.qv();
        }
    }

    public void ny() {
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = this.h;
        if (xrVar != null) {
            xrVar.nw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ch() {
        com.bytedance.sdk.openadsdk.core.ugeno.x.ms msVar = this.ao;
        if (msVar != null) {
            msVar.xr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ny.xr xrVar = this.h;
        if (xrVar != null) {
            xrVar.ao();
        }
        RewardLpBottomView rewardLpBottomView = this.t;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.xr();
        }
    }
}
