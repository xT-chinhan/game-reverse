package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.eg;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.op.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements le.ms {
    private PlayableVideoContainer ab;
    private final lm ah;
    private FrameLayout c;
    private boolean hi;
    private final int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f3281ms;
    private final com.bytedance.sdk.openadsdk.core.video.xr.xr u;
    private ah x;
    private final Context xr;
    private final le d = new le(Looper.getMainLooper(), this);
    private boolean ny = false;
    private boolean ch = true;
    private boolean sl = false;
    private boolean zb = false;

    public ms(String str, Activity activity, lm lmVar, int i, com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar, FrameLayout frameLayout) {
        this.f3281ms = str;
        this.xr = activity;
        this.ah = lmVar;
        this.ka = i;
        if (!t.d(lmVar)) {
            this.c = frameLayout;
        }
        ka();
        this.u = xrVar;
    }

    private void ka() {
        if (this.c == null) {
            return;
        }
        if (eg.ms(this.ah, this.ka) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.xr);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ul.ah(this.xr, 156.0f), ul.ah(this.xr, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = ul.ah(this.xr, 55.0f);
            layoutParams.rightMargin = ul.ah(this.xr, 20.0f);
            this.c.addView(playableVideoContainer, layoutParams);
            this.ab = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.xr);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ul.ah(this.xr, 73.0f), ul.ah(this.xr, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = ul.ah(this.xr, 55.0f);
        layoutParams2.rightMargin = ul.ah(this.xr, 30.0f);
        this.c.addView(playableVideoContainer2, layoutParams2);
        this.ab = playableVideoContainer2;
    }

    public void ms(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.zb = true;
        this.ch = z;
        ms(j);
        if (this.ny) {
            if (this.u != null && (playableVideoContainer = this.ab) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.ch();
                    }
                }, 500L);
                this.ab.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.ms.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ms.this.c != null) {
                            ms.this.ms();
                            ms.this.u.xr();
                        }
                    }
                });
            } else if (ch.ms(this.ah)) {
                c();
            } else {
                ab();
            }
        }
    }

    public void ms() {
        this.zb = false;
        d();
        c();
    }

    private void c() {
        ul.ms((View) this.c, 8);
        ul.ms((View) this.ab, 8);
    }

    private void ab() {
        ul.ms((View) this.c, 0);
        ul.ms((View) this.ab, 0);
    }

    private void ms(long j) {
        if (this.ab == null) {
            return;
        }
        if (this.u != null || ch.ms(this.ah)) {
            if (this.ny) {
                ah ahVar = this.x;
                if (ahVar != null) {
                    ahVar.xr(j);
                    this.x.ms(j);
                    return;
                }
                return;
            }
            this.ny = true;
            com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(1, this.ah, this.ka);
            dVarMs.xr(this.ah.df());
            dVarMs.xr(this.ab.getWidth());
            dVarMs.ah(this.ab.getHeight());
            dVarMs.ah(this.ah.lx());
            dVarMs.ms(j);
            dVarMs.xr(this.ch);
            if (ch.ms(this.ah)) {
                dVarMs.ms(true);
            }
            ah ahVar2 = new ah(this.xr, this.ab.getVideoContainer(), this.ah, null);
            this.x = ahVar2;
            ahVar2.ms(new com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms() { // from class: com.bytedance.sdk.openadsdk.core.playable.ms.3
                @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
                public void ms() {
                    if (ms.this.u == null) {
                        if (!ch.ms(ms.this.ah) || ms.this.x == null || ms.this.x.ka()) {
                            return;
                        }
                        ms.this.ms();
                        return;
                    }
                    ms.this.ms();
                    ms.this.u.ah();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
                public void ms(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    ms.this.ab.ms(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
                public void xr() {
                    ms.this.ab.ms(true);
                    if (ms.this.u != null) {
                        ms.this.u.ch();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
                public void ms(long j2, long j3) {
                    ms.this.ab.ms(false);
                    if (ms.this.u != null) {
                        ms.this.u.ms(j2, j3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
                public void ah() {
                    ms.this.x();
                }
            });
            this.x.xr(j);
            this.x.ms(dVarMs);
            if (this.u != null) {
                this.x.i();
                this.x.ab(false);
                this.ab.ms();
            } else {
                if (ch.ms(this.ah)) {
                    this.x.ab(true);
                }
                ny();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.sl = true;
        if (this.hi) {
            this.hi = false;
            xr();
        }
        ms(this.ch);
    }

    public void xr() {
        if (this.zb && this.ny && this.x != null) {
            this.d.removeMessages(1);
            if (this.sl) {
                this.x.c();
            } else {
                this.hi = true;
            }
        }
    }

    public void ah() {
        if (this.zb && this.ny && this.x != null) {
            this.hi = false;
            this.d.sendEmptyMessageDelayed(1, a.f);
            if (this.x.sa()) {
                return;
            }
            this.x.x();
        }
    }

    public void d() {
        ah ahVar = this.x;
        if (ahVar == null) {
            return;
        }
        ahVar.ch();
        this.x = null;
        this.ny = false;
        this.hi = false;
        this.sl = false;
    }

    public void ms(boolean z) {
        ah ahVar = this.x;
        if (ahVar == null) {
            return;
        }
        this.ch = z;
        ahVar.xr(z);
    }

    private void ny() {
        PlayableVideoContainer playableVideoContainer = this.ab;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.xr(true);
        this.d.sendEmptyMessageDelayed(1, a.f);
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        PlayableVideoContainer playableVideoContainer = this.ab;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.xr(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        if (this.ab == null || this.c == null) {
            return;
        }
        ab();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ab, "translationX", -ul.ah(this.xr, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ab, "translationY", -ul.ah(this.xr, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ab, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}
