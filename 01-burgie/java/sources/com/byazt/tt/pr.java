package com.byazt.tt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ca.b;
import com.byazt.ca.ho;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.mr.aj;
import com.byazt.mr.vk;
import com.byazt.mr.w;
import com.byazt.vh.fw;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 37})
public class pr {
    public Context hw;
    public of pr;
    public AtomicBoolean hn = new AtomicBoolean(false);
    public AtomicBoolean x = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);

    public pr(of ofVar, Context context) {
        this.pr = ofVar;
        this.hw = context;
    }

    public void pr(int i, com.byazt.qe.hw hwVar) {
        if (this.pr == null) {
            pr();
            hn.pr(null, false, i, 2);
        }
        if (this.hw == null) {
            pr();
            hn.pr(this.pr, false, i, 3);
            return;
        }
        if (hwVar == null) {
            pr();
            hn.pr(this.pr, false, i, 7);
            return;
        }
        if (this.c.get()) {
            hn.pr(this.pr, false, i, 4);
            return;
        }
        this.c.set(true);
        switch (ls.k(this.pr)) {
            case 5:
                pr(i, hwVar, this.pr);
                break;
            case 6:
            default:
                pr();
                hn.pr(this.pr, false, i, 5);
                this.c.set(false);
                break;
            case 7:
                hn(i, hwVar, this.pr);
                break;
            case 8:
                x(i, hwVar, this.pr);
                break;
            case 9:
                hw(i, hwVar, this.pr);
                break;
        }
    }

    public void pr(final int i, com.byazt.qe.hw hwVar, final of ofVar) {
        try {
            final x xVarHw = hw(ofVar, i);
            hw();
            com.byazt.yb.pr.x().pr(hwVar, xVarHw, new com.byazt.pis.hn(null) { // from class: com.byazt.tt.pr.1
                @Override // com.byazt.pis.hn
                public void pr(List<vk> list) {
                    list.size();
                    of ofVarHw = xVarHw.hw();
                    if (ofVarHw != null) {
                        pr.this.pr(ofVarHw, i);
                    } else {
                        pr.this.pr();
                        hn.hw(ofVar, false, i, 5);
                    }
                    pr.this.c.set(false);
                }

                @Override // com.byazt.pis.hn
                public void pr(int i2, String str) {
                    ho.hw("SecondPageImpl", "requestNewFeedAd onError code:" + i2 + " message:" + str);
                    pr.this.c.set(false);
                    pr.this.pr();
                    hn.hw(ofVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.c.set(false);
            ho.pr("SecondPageImpl", "requestNewFeedAd error", th.toString());
            pr();
            hn.pr(ofVar, false, i, 6);
        }
    }

    public void hw(final int i, com.byazt.qe.hw hwVar, final of ofVar) {
        try {
            final x xVarHw = hw(ofVar, i);
            hw();
            com.byazt.ju.pr.x().pr(hwVar, xVarHw, new com.byazt.pis.hw(null) { // from class: com.byazt.tt.pr.2
                @Override // com.byazt.pis.hw
                public void pr(List<aj> list) {
                    list.size();
                    of ofVarHw = xVarHw.hw();
                    if (ofVarHw != null) {
                        pr.this.pr(ofVarHw, i);
                    } else {
                        pr.this.pr();
                        hn.hw(ofVar, false, i, 5);
                    }
                    pr.this.c.set(false);
                }

                @Override // com.byazt.pis.hw
                public void pr(int i2, String str) {
                    ho.hw("SecondPageImpl", "requestNewDrawAd onError code:" + i2 + " message:" + str);
                    pr.this.c.set(false);
                    pr.this.pr();
                    hn.hw(ofVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.c.set(false);
            ho.pr("SecondPageImpl", "requestNewDrawAd error", th.toString());
            pr();
            hn.pr(ofVar, false, i, 6);
        }
    }

    public void hn(final int i, com.byazt.qe.hw hwVar, final of ofVar) {
        try {
            fw.pr().pr(hwVar, hw(ofVar, i), new com.byazt.vh.x(new com.byazt.pis.fw(null) { // from class: com.byazt.tt.pr.3
                @Override // com.byazt.pis.fw
                public void pr(final com.byazt.mr.ho hoVar) {
                    zo.pr(new Runnable() { // from class: com.byazt.tt.pr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (hoVar instanceof com.byazt.joa.hn) {
                                if (pr.this.hw instanceof Activity) {
                                    com.byazt.joa.hn hnVar = (com.byazt.joa.hn) hoVar;
                                    hnVar.pr(true);
                                    hnVar.pr((Activity) pr.this.hw);
                                    hn.hw(ofVar, true, i, 0);
                                } else {
                                    pr.this.pr();
                                    hn.hw(ofVar, false, i, 3);
                                }
                            } else {
                                pr.this.pr();
                                hn.hw(ofVar, false, i, 1);
                            }
                            pr.this.c.set(false);
                        }
                    });
                }

                @Override // com.byazt.pis.fw
                public void pr(int i2, String str) {
                    ho.hw("SecondPageImpl", "requestNewRewardAd onError code:" + i2 + " message:" + str);
                    pr.this.c.set(false);
                    pr.this.pr();
                    hn.hw(ofVar, false, i, 2);
                }

                @Override // com.byazt.pis.fw
                public void hw() {
                }

                @Override // com.byazt.pis.fw
                public void hw(com.byazt.mr.ho hoVar) {
                }
            }));
        } catch (Throwable th) {
            this.c.set(false);
            ho.pr("SecondPageImpl", "requestNewAd error", th.toString());
            pr();
            hn.pr(ofVar, false, i, 6);
        }
    }

    public void x(final int i, com.byazt.qe.hw hwVar, final of ofVar) {
        try {
            com.byazt.vh.hw.pr().pr(hwVar, hw(ofVar, i), new com.byazt.vh.x(new com.byazt.pis.x(null) { // from class: com.byazt.tt.pr.4
                @Override // com.byazt.pis.x
                public void pr(final w wVar) {
                    zo.pr(new Runnable() { // from class: com.byazt.tt.pr.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (wVar instanceof com.byazt.joa.hw) {
                                if (pr.this.hw instanceof Activity) {
                                    com.byazt.joa.hw hwVar2 = (com.byazt.joa.hw) wVar;
                                    hwVar2.pr(true);
                                    hwVar2.pr((Activity) pr.this.hw);
                                    hn.hw(ofVar, true, i, 0);
                                } else {
                                    pr.this.pr();
                                    hn.hw(ofVar, false, i, 3);
                                }
                            } else {
                                pr.this.pr();
                                hn.hw(ofVar, false, i, 1);
                            }
                            pr.this.c.set(false);
                        }
                    });
                }

                @Override // com.byazt.pis.x
                public void pr(int i2, String str) {
                    ho.hw("SecondPageImpl", "requestNewFullScreenAd onError code:" + i2 + " message:" + str);
                    pr.this.c.set(false);
                    pr.this.pr();
                    hn.hw(ofVar, false, i, 2);
                }

                @Override // com.byazt.pis.x
                public void hw(w wVar) {
                }

                @Override // com.byazt.pis.x
                public void hw() {
                }
            }));
        } catch (Throwable th) {
            ho.pr("SecondPageImpl", "requestNewAd error", th.toString());
            this.c.set(false);
            pr();
            hn.pr(ofVar, false, i, 6);
        }
    }

    public void pr() {
        zo.pr(new Runnable() { // from class: com.byazt.tt.pr.5
            @Override // java.lang.Runnable
            public void run() {
                b.pr(pr.this.hw, "加载失败了，将跳转至推荐页面", 1);
            }
        });
        com.byazt.xb.pr.pr((View) null, this.pr, this.hw);
    }

    public void hw() {
        zo.pr(new Runnable() { // from class: com.byazt.tt.pr.6
            @Override // java.lang.Runnable
            public void run() {
                b.pr(pr.this.hw, "正在努力加载中", 0);
            }
        });
    }

    public void pr(of ofVar, int i) {
        String strZo;
        String strHw = ls.hw(ls.k(ofVar));
        String strZo2 = lb.zo(ofVar);
        if (!TextUtils.isEmpty(strZo2)) {
            strZo = strZo2;
        } else {
            strZo = ofVar.zo();
        }
        com.byazt.ov.pr prVar = new com.byazt.ov.pr(ofVar, this.hw, strHw, ls.x(strHw), new HashMap(), null, ofVar.to());
        prVar.pr(strZo);
        if (prVar.pr(new HashMap())) {
            com.byazt.pj.pr.pr(ofVar, strHw, new HashMap(), (Double) null);
            hn.hw(ofVar, true, i, 0);
        } else {
            pr();
            hn.hw(ofVar, false, i, 4);
        }
    }

    public x hw(of ofVar, int i) {
        String strG = ls.g(ofVar);
        x xVar = new x();
        xVar.pr(i);
        xVar.pr(strG);
        xVar.pr(ofVar);
        return xVar;
    }

    public void pr(boolean z) {
        this.x.set(z);
    }

    public boolean hn() {
        return this.x.get();
    }

    public void hw(boolean z) {
        this.hn.set(z);
    }

    public boolean x() {
        return this.hn.get();
    }
}
