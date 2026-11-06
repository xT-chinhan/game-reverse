package com.byazt.bsb;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.byazt.gct.b;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.okk.s;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 19})
public class n implements wo.n {
    public boolean cp;
    public qg fs;
    public final int l;
    public final String n;
    public final Context qg;
    public final pk s;
    public final com.byazt.zx.qg sz;
    public FrameLayout w;
    public PlayableVideoContainer x;
    public final t q = new t(Looper.getMainLooper(), this);
    public boolean rv = false;
    public boolean tj = true;
    public boolean d = false;
    public boolean oa = false;

    public n(String str, Activity activity, pk pkVar, int i, com.byazt.zx.qg qgVar, FrameLayout frameLayout) {
        this.n = str;
        this.qg = activity;
        this.s = pkVar;
        this.l = i;
        if (!cd.q(pkVar)) {
            this.w = frameLayout;
        }
        l();
        this.sz = qgVar;
    }

    private void l() {
        if (this.w == null) {
            return;
        }
        if (b.qg(this.s) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.qg);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s.s(this.qg, 156.0f), s.s(this.qg, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = s.s(this.qg, 55.0f);
            layoutParams.rightMargin = s.s(this.qg, 20.0f);
            this.w.addView(playableVideoContainer, layoutParams);
            this.x = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.qg);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(s.s(this.qg, 73.0f), s.s(this.qg, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = s.s(this.qg, 55.0f);
        layoutParams2.rightMargin = s.s(this.qg, 30.0f);
        this.w.addView(playableVideoContainer2, layoutParams2);
        this.x = playableVideoContainer2;
    }

    public void n(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.oa = true;
        this.tj = z;
        n(j);
        if (this.rv) {
            if (this.sz != null && (playableVideoContainer = this.x) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.byazt.bsb.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.tj();
                    }
                }, 500L);
                this.x.setCustomClickListener(new View.OnClickListener() { // from class: com.byazt.bsb.n.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (n.this.w != null) {
                            n.this.n();
                            n.this.sz.qg();
                        }
                    }
                });
            } else if (com.byazt.ql.s.n(this.s)) {
                w();
            } else {
                x();
            }
        }
    }

    public void n() {
        this.oa = false;
        q();
        w();
    }

    private void w() {
        s.n((View) this.w, 8);
        s.n((View) this.x, 8);
    }

    private void x() {
        s.n((View) this.w, 0);
        s.n((View) this.x, 0);
    }

    private void n(long j) {
        if (this.x == null) {
            return;
        }
        if (this.sz != null || com.byazt.ql.s.n(this.s)) {
            if (this.rv) {
                qg qgVar = this.fs;
                if (qgVar != null) {
                    qgVar.qg(j);
                    this.fs.n(j);
                    return;
                }
                return;
            }
            this.rv = true;
            l lVarN = ta.n(1, this.s);
            lVarN.qg(this.s.q());
            lVarN.qg(this.x.getWidth());
            lVarN.s(this.x.getHeight());
            lVarN.s(this.s.F_());
            lVarN.n(j);
            lVarN.qg(this.tj);
            if (com.byazt.ql.s.n(this.s)) {
                lVarN.n(true);
            }
            qg qgVar2 = new qg(this.qg, this.x.getVideoContainer(), this.s, null);
            this.fs = qgVar2;
            qgVar2.n(new com.byazt.zx.n.InterfaceC0421n() { // from class: com.byazt.bsb.n.3
                @Override // com.byazt.zx.n.InterfaceC0421n
                public void n() {
                    if (n.this.sz == null) {
                        if (!com.byazt.ql.s.n(n.this.s) || n.this.fs == null || n.this.fs.l()) {
                            return;
                        }
                        n.this.n();
                        return;
                    }
                    n.this.n();
                    n.this.sz.s();
                }

                @Override // com.byazt.zx.n.InterfaceC0421n
                public void n(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    n.this.x.n(true);
                }

                @Override // com.byazt.zx.n.InterfaceC0421n
                public void qg() {
                    n.this.x.n(true);
                    if (n.this.sz != null) {
                        n.this.sz.tj();
                    }
                }

                @Override // com.byazt.zx.n.InterfaceC0421n
                public void n(long j2, long j3) {
                    n.this.x.n(false);
                    if (n.this.sz != null) {
                        n.this.sz.n(j2, j3);
                    }
                }

                @Override // com.byazt.zx.n.InterfaceC0421n
                public void s() {
                    n.this.fs();
                }
            });
            this.fs.qg(j);
            this.fs.n(lVarN);
            if (this.sz != null) {
                this.fs.hu();
                this.fs.x(false);
                this.x.n();
            } else {
                if (com.byazt.ql.s.n(this.s)) {
                    this.fs.x(true);
                }
                rv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        this.d = true;
        if (this.cp) {
            this.cp = false;
            qg();
        }
        n(this.tj);
    }

    public void qg() {
        if (this.oa && this.rv && this.fs != null) {
            this.q.removeMessages(1);
            if (this.d) {
                this.fs.w();
            } else {
                this.cp = true;
            }
        }
    }

    public void s() {
        if (this.oa && this.rv && this.fs != null) {
            this.cp = false;
            this.q.sendEmptyMessageDelayed(1, 2000L);
            if (this.fs.ri()) {
                return;
            }
            this.fs.fs();
        }
    }

    public void q() {
        qg qgVar = this.fs;
        if (qgVar == null) {
            return;
        }
        qgVar.tj();
        this.fs = null;
        this.rv = false;
        this.cp = false;
        this.d = false;
    }

    public void n(boolean z) {
        qg qgVar = this.fs;
        if (qgVar == null) {
            return;
        }
        this.tj = z;
        qgVar.qg(z);
    }

    private void rv() {
        PlayableVideoContainer playableVideoContainer = this.x;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.qg(true);
        this.q.sendEmptyMessageDelayed(1, 2000L);
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        PlayableVideoContainer playableVideoContainer = this.x;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.qg(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        if (this.x == null || this.w == null) {
            return;
        }
        x();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "translationX", -s.s(this.qg, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.x, "translationY", -s.s(this.qg, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.x, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}
