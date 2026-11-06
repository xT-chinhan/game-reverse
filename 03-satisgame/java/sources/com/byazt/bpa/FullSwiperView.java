package com.byazt.bpa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.j;
import com.byazt.gct.pk;
import com.byazt.gct.ur;
import com.byazt.lb.BaseSwiper;
import com.byazt.wd.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 405, 780})
public class FullSwiperView extends FrameLayout {
    public List<FullSwiperItemView> cp;
    public int d;
    public List<Integer> fs;
    public AtomicBoolean k;
    public float l;
    public BaseSwiper<ViewGroup> n;
    public boolean oa;
    public float q;
    public List<n> qg;
    public List<Integer> rv;
    public TTBaseVideoActivity s;
    public boolean sz;
    public List<Long> tj;
    public String w;
    public boolean x;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.x = false;
        this.oa = true;
        this.sz = true;
        this.k = new AtomicBoolean(false);
        this.s = tTBaseVideoActivity;
        this.fs = new ArrayList();
        this.rv = new ArrayList();
        this.tj = new ArrayList();
        this.n = new SwiperView(tTBaseVideoActivity);
        this.cp = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.n, layoutParams);
    }

    public FullSwiperView n(List<n> list) {
        this.qg = list;
        return this;
    }

    public FullSwiperView n(float f) {
        this.q = f;
        return this;
    }

    public FullSwiperView qg(float f) {
        this.l = f;
        return this;
    }

    public FullSwiperView n(String str) {
        this.w = str;
        return this;
    }

    public void n() {
        ur urVarNq;
        List<n> list = this.qg;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.n.n(false).n("dot").q(false).s(false).qg(false);
        this.n.setOnPageChangeListener(new com.byazt.lb.n() { // from class: com.byazt.bpa.FullSwiperView.1
            @Override // com.byazt.lb.n
            public void n(boolean z, int i) {
            }

            @Override // com.byazt.lb.n
            public void n(boolean z, int i, float f, int i2) {
            }

            @Override // com.byazt.lb.n
            public void n(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (FullSwiperView.this.sz && i == 1) {
                    return;
                }
                FullSwiperView.this.sz = false;
                FullSwiperView.this.d = i;
                FullSwiperItemView fullSwiperItemViewS = FullSwiperView.this.s(i);
                if (fullSwiperItemViewS != null && FullSwiperView.this.d != 0) {
                    fullSwiperItemViewS.qg(false);
                }
                FullSwiperItemView fullSwiperItemViewS2 = FullSwiperView.this.s(i - 1);
                if (fullSwiperItemViewS2 != null) {
                    fullSwiperItemViewS2.k();
                    fullSwiperItemViewS2.hd();
                }
                FullSwiperView.this.qg(i + 1);
                if (!FullSwiperView.this.x && i > 0) {
                    FullSwiperView.this.x = true;
                    x.qg(FullSwiperView.this.w);
                }
                int iIntValue = ((Integer) FullSwiperView.this.fs.get(i)).intValue();
                if (iIntValue > 0 && i != FullSwiperView.this.cp.size() - 1) {
                    FullSwiperView.this.tj.add(i, Long.valueOf(System.currentTimeMillis()));
                    int i3 = iIntValue / 1000;
                    int iMin = Math.min(j.qg(false), i3);
                    int iMax = Math.max(i3 - j.qg(false), 0);
                    if (iMin > 0) {
                        FullSwiperView.this.k.set(false);
                        FullSwiperView.this.s.n(-1, iMin, iMax);
                    } else {
                        if (j.sz() != 1) {
                            if (FullSwiperView.this.k.get()) {
                                return;
                            }
                            FullSwiperView.this.n(iIntValue);
                            return;
                        }
                        FullSwiperView.this.n(iIntValue);
                    }
                }
            }
        });
        for (n nVar : this.qg) {
            pk pkVarN = nVar.n();
            if (pkVarN != null && (urVarNq = pkVarN.nq()) != null) {
                this.fs.add(Integer.valueOf((int) urVarNq.qg()));
                this.rv.add(0);
                this.tj.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.s, nVar, this.q, this.l);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.n() { // from class: com.byazt.bpa.FullSwiperView.2
                    @Override // com.byazt.bpa.FullSwiperItemView.n
                    public void n() {
                        if (j.sz() == 0) {
                            FullSwiperView.this.w();
                            FullSwiperView.this.s.ic();
                        }
                        FullSwiperView.this.k.set(true);
                    }
                });
                this.n.n(fullSwiperItemView);
                this.cp.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.cp.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.qg() { // from class: com.byazt.bpa.FullSwiperView.3
            @Override // com.byazt.bpa.FullSwiperItemView.qg
            public void n(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.fs.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.n.w();
                } else {
                    FullSwiperView.this.tj.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.n.w();
                    if (FullSwiperView.this.cp.size() > 1) {
                        int i = iIntValue / 1000;
                        int iMin = Math.min(j.qg(false), i);
                        int iMax = Math.max(i - j.qg(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.s.n(-1, iMin, iMax);
                        } else {
                            FullSwiperView.this.n(iIntValue);
                        }
                    }
                }
                fullSwiperItemView2.qg(true);
                FullSwiperView.this.qg(1);
            }
        });
        fullSwiperItemView2.oa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        FullSwiperItemView fullSwiperItemViewS = s(i);
        if (fullSwiperItemViewS != null) {
            fullSwiperItemViewS.oa();
        }
    }

    public void qg() {
        FullSwiperItemView fullSwiperItemViewS = s(this.d);
        if (fullSwiperItemViewS != null) {
            fullSwiperItemViewS.k();
        }
        List<Long> list = this.tj;
        if (list != null && this.d < list.size()) {
            this.rv.add(this.d, Integer.valueOf(this.fs.get(this.d).intValue() - ((int) (System.currentTimeMillis() - this.tj.get(this.d).longValue()))));
        }
        w();
    }

    public void s() {
        FullSwiperItemView fullSwiperItemViewS = s(this.d);
        if (fullSwiperItemViewS != null) {
            fullSwiperItemViewS.cy();
        }
        if (this.d == this.cp.size() - 1) {
            return;
        }
        this.n.sz(this.d);
        List<Integer> list = this.rv;
        if (list == null || this.d >= list.size()) {
            return;
        }
        if (!this.oa && (!this.k.get() || j.sz() == 1)) {
            n(this.rv.get(this.d).intValue());
        }
        this.oa = false;
    }

    public void q() {
        w();
    }

    public void l() {
        for (FullSwiperItemView fullSwiperItemView : this.cp) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.cd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView s(int i) {
        List<FullSwiperItemView> list = this.cp;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.cp.get(i);
    }

    public int getCurrentPosition() {
        return this.d;
    }

    public void n(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(j.qg(false), i / 1000) <= 0 && (baseSwiper = this.n) != null) {
            baseSwiper.k(i);
        }
    }

    public void w() {
        BaseSwiper<ViewGroup> baseSwiper = this.n;
        if (baseSwiper != null) {
            baseSwiper.x();
        }
    }

    public void x() {
        BaseSwiper<ViewGroup> baseSwiper = this.n;
        if (baseSwiper != null) {
            baseSwiper.sz(this.d + 1);
        }
    }
}
