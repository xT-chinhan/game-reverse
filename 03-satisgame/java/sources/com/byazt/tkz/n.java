package com.byazt.tkz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.ep.cp;
import com.byazt.gct.pk;
import com.byazt.tk.sz;
import com.byazt.uz.RewardLpBottomView;
import com.byazt.xk.PlayableEndcardFrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 19})
public class n extends qg {
    public String a;
    public com.byazt.ul.qg cd;
    public com.byazt.ul.q cy;
    public com.byazt.guz.n hd;
    public boolean hu;
    public com.byazt.hm.q k;
    public com.byazt.re.l m;
    public AtomicBoolean ou;
    public RewardLpBottomView py;
    public com.byazt.ai.n sz;
    public AtomicBoolean um;
    public AtomicBoolean wm;

    public n(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z, com.byazt.hm.q qVar, com.byazt.re.l lVar) {
        super(tTBaseVideoActivity, pkVar, z);
        this.sz = pkVar.vb();
        this.k = qVar;
        this.qg.x(0);
        this.um = new AtomicBoolean();
        this.ou = new AtomicBoolean();
        this.wm = new AtomicBoolean();
        this.m = lVar;
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.a = com.byazt.vgx.w.n(com.byazt.vgx.w.q(this.n));
        com.byazt.ai.n nVar = this.sz;
        if (nVar == null) {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.tkz.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.qg.x(8);
                    n.this.qg.um();
                }
            });
            return;
        }
        int iQ = nVar.q();
        if (iQ == 2) {
            hd();
            return;
        }
        if (iQ == 3) {
            cd();
        } else if (iQ == 4) {
            um();
        } else {
            this.qg.x(8);
            this.qg.um();
        }
    }

    private void hd() {
        com.byazt.ul.q qVar = new com.byazt.ul.q(this.qg, this.x, this.k, this.s, this.a, com.byazt.vgx.w.q(this.n));
        this.cy = qVar;
        qVar.qg(true);
        this.cy.n(new com.byazt.au.n() { // from class: com.byazt.tkz.n.2
            @Override // com.byazt.au.n
            public void n(View view) {
                n.this.qg.x(8);
                n.this.um.set(true);
            }

            @Override // com.byazt.au.n
            public void n(int i) {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.tkz.n.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.x(8);
                        n.this.qg.um();
                    }
                });
                n.this.um.set(false);
            }
        });
        this.cy.d();
    }

    private void cd() {
        FrameLayout frameLayout = new FrameLayout(this.qg);
        this.x.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.byazt.ul.qg qgVar = new com.byazt.ul.qg(this.qg, frameLayout, this.k, this.s, this.a, com.byazt.vgx.w.q(this.n));
        this.cd = qgVar;
        qgVar.qg(true);
        this.cd.n(new com.byazt.ozc.qg() { // from class: com.byazt.tkz.n.3
            @Override // com.byazt.ozc.qg
            public void n() {
                n.this.qg.dg();
            }

            @Override // com.byazt.ozc.qg
            public void qg() {
                n.this.qg.u();
                n.this.ou.set(true);
                n.this.cd.um();
            }
        });
        this.cd.n(new com.byazt.au.n() { // from class: com.byazt.tkz.n.4
            @Override // com.byazt.au.n
            public void n(View view) {
                n.this.qg.x(8);
                n.this.um.set(true);
            }

            @Override // com.byazt.au.n
            public void n(int i) {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.tkz.n.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.x(8);
                        n.this.cd.cy();
                        n.this.cd.n("\"暂无更多内容，奖励已发放\"");
                        n.this.qg.q(0);
                    }
                });
                n.this.um.set(false);
            }
        });
        this.cd.n(new com.byazt.ozc.n.InterfaceC0290n() { // from class: com.byazt.tkz.n.5
            @Override // com.byazt.ozc.n.InterfaceC0290n
            public void n() {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.tkz.n.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.qg.pe()) {
                            n.this.cd.n("\"暂无更多内容，奖励已发放\"");
                        } else {
                            n.this.cd.n(String.format("\"暂无更多内容，继续浏览%1$s秒可得奖励\"", Integer.valueOf(n.this.qg.nf().oj())));
                        }
                    }
                });
            }
        });
        this.cd.d();
        com.byazt.vyf.s.cy().s().s(new com.byazt.ot.n.qg() { // from class: com.byazt.tkz.n.6
            @Override // com.byazt.ot.n.qg
            public void n() {
            }

            @Override // com.byazt.ot.n.qg
            public void q() {
            }

            @Override // com.byazt.ot.n.qg
            public void s() {
            }

            @Override // com.byazt.ot.n.qg
            public void qg() {
                if (n.this.ou.get() || !n.this.cd.oa()) {
                    n.this.wm.set(false);
                } else {
                    n.this.wm.set(true);
                }
            }
        });
        if (TextUtils.equals(this.sz.n(), "3")) {
            return;
        }
        qg();
    }

    public void qg() {
        final ImageView imageView = new ImageView(this.qg);
        float fS = com.byazt.okk.s.s(this.qg, 18.0f);
        float fS2 = com.byazt.okk.s.s(this.qg, 20.0f);
        int i = (int) fS;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) fS2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.x.addView(imageView, layoutParams);
        sz.n((Context) this.qg, "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.tkz.n.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n nVar = n.this;
                nVar.hu = !nVar.hu;
                sz.n((Context) n.this.qg, n.this.hu ? "tt_mute" : "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                n.this.cd.s(n.this.hu);
            }
        });
    }

    private void um() {
        com.byazt.guz.n nVar = new com.byazt.guz.n(this.qg, a(), this.sz, this.s);
        this.hd = nVar;
        nVar.n(this.qg.pk());
        this.hd.n(new com.byazt.au.n() { // from class: com.byazt.tkz.n.8
            @Override // com.byazt.au.n
            public void n(View view) {
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.tkz.n.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.x(8);
                        n.this.um.set(true);
                        if (n.this.py != null) {
                            n.this.py.n();
                        }
                    }
                });
            }

            @Override // com.byazt.au.n
            public void n(int i) {
                com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.tkz.n.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.x(8);
                        n.this.qg.um();
                    }
                });
                n.this.um.set(false);
            }
        });
        this.hd.n();
    }

    private ViewGroup a() {
        if (this.x == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.qg);
        this.x.addView(playableEndcardFrameLayout);
        this.py = new RewardLpBottomView(this.qg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.x.addView(this.py, layoutParams);
        this.py.n(this.s, this.a);
        playableEndcardFrameLayout.n(new PlayableEndcardFrameLayout.n() { // from class: com.byazt.tkz.n.9
            @Override // com.byazt.xk.PlayableEndcardFrameLayout.n
            public void n() {
                if (n.this.py != null) {
                    n.this.py.qg();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    public boolean s() {
        return this.wm.get();
    }

    public void n(boolean z) {
        this.wm.set(z);
    }

    @Override // com.byazt.tkz.qg
    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
        super.n(qgVar, qgVar2);
        com.byazt.ul.q qVar = this.cy;
        if (qVar != null) {
            qVar.n(this.qg.pk());
        }
        com.byazt.ul.qg qgVar3 = this.cd;
        if (qgVar3 != null) {
            qgVar3.n(this.qg.pk());
        }
        com.byazt.guz.n nVar = this.hd;
        if (nVar != null) {
            nVar.n(qgVar);
        }
    }

    public boolean q() {
        com.byazt.ul.qg qgVar = this.cd;
        if (qgVar != null) {
            return qgVar.oa();
        }
        return false;
    }

    public AtomicInteger l() {
        return new AtomicInteger(0);
    }

    public void n(int i) {
        if (this.cy == null || !cp.l(this.s)) {
            return;
        }
        this.cy.l(i);
    }

    public void qg(boolean z) {
        if (this.cd == null || !cp.q(this.s)) {
            return;
        }
        this.cd.s(z);
    }

    public boolean w() {
        return this.um.get();
    }

    @Override // com.byazt.tkz.qg
    public void n(DownloadListener downloadListener) {
        com.byazt.guz.n nVar = this.hd;
        if (nVar != null) {
            nVar.n(downloadListener);
        }
    }

    public void x() {
        com.byazt.ul.qg qgVar = this.cd;
        if (qgVar != null) {
            qgVar.cd();
        }
    }

    public void fs() {
        com.byazt.ul.qg qgVar = this.cd;
        if (qgVar != null) {
            qgVar.hd();
        }
    }

    public void rv() {
        com.byazt.ul.qg qgVar = this.cd;
        if (qgVar != null) {
            qgVar.a();
        }
    }

    @Override // com.byazt.tkz.qg
    public void tj() {
        com.byazt.guz.n nVar = this.hd;
        if (nVar != null) {
            nVar.qg();
        }
        com.byazt.ul.qg qgVar = this.cd;
        if (qgVar != null) {
            qgVar.k();
        }
        RewardLpBottomView rewardLpBottomView = this.py;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.qg();
        }
    }
}
