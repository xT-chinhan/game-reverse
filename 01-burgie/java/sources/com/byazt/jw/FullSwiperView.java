package com.byazt.jw;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.dt.fw;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.byazt.hg.ww;
import com.byazt.rij.BaseSwiper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE})
public class FullSwiperView extends FrameLayout {
    public List<Integer> aj;
    public float c;
    public boolean fw;
    public boolean g;
    public TTBaseVideoActivity hn;
    public AtomicBoolean ho;
    public List<pr> hw;
    public int k;
    public boolean m;
    public BaseSwiper<ViewGroup> pr;
    public String uc;
    public List<Long> vk;
    public List<FullSwiperItemView> w;
    public float x;
    public List<Integer> zo;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.fw = false;
        this.m = true;
        this.g = true;
        this.ho = new AtomicBoolean(false);
        this.hn = tTBaseVideoActivity;
        this.zo = new ArrayList();
        this.aj = new ArrayList();
        this.vk = new ArrayList();
        this.pr = new SwiperView(tTBaseVideoActivity);
        this.w = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.pr, layoutParams);
    }

    public FullSwiperView pr(List<pr> list) {
        this.hw = list;
        return this;
    }

    public FullSwiperView pr(float f) {
        this.x = f;
        return this;
    }

    public FullSwiperView hw(float f) {
        this.c = f;
        return this;
    }

    public FullSwiperView pr(String str) {
        this.uc = str;
        return this;
    }

    public void pr() {
        ve veVarSb;
        List<pr> list = this.hw;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.pr.pr(false).pr("dot").x(false).hn(false).hw(false);
        this.pr.setOnPageChangeListener(new com.byazt.rij.pr() { // from class: com.byazt.jw.FullSwiperView.1
            @Override // com.byazt.rij.pr
            public void pr(boolean z, int i, float f, int i2) {
            }

            @Override // com.byazt.rij.pr
            public void pr(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (!FullSwiperView.this.g || i != 1) {
                    FullSwiperView.this.g = false;
                    FullSwiperView.this.k = i;
                    FullSwiperItemView fullSwiperItemViewHn = FullSwiperView.this.hn(i);
                    if (fullSwiperItemViewHn != null && FullSwiperView.this.k != 0) {
                        fullSwiperItemViewHn.hw(false);
                    }
                    FullSwiperItemView fullSwiperItemViewHn2 = FullSwiperView.this.hn(i - 1);
                    if (fullSwiperItemViewHn2 != null) {
                        fullSwiperItemViewHn2.ho();
                        fullSwiperItemViewHn2.yb();
                    }
                    FullSwiperView.this.hw(i + 1);
                    if (!FullSwiperView.this.fw && i > 0) {
                        FullSwiperView.this.fw = true;
                        fw.hw(FullSwiperView.this.uc);
                    }
                    int iIntValue = ((Integer) FullSwiperView.this.zo.get(i)).intValue();
                    if (iIntValue > 0 && i != FullSwiperView.this.w.size() - 1) {
                        FullSwiperView.this.vk.add(i, Long.valueOf(System.currentTimeMillis()));
                        int i3 = iIntValue / 1000;
                        int iMin = Math.min(ww.hw(false), i3);
                        int iMax = Math.max(i3 - ww.hw(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.ho.set(false);
                            FullSwiperView.this.hn.pr(-1, iMin, iMax);
                        } else {
                            if (ww.g() != 1) {
                                if (!FullSwiperView.this.ho.get()) {
                                    FullSwiperView.this.pr(iIntValue);
                                    return;
                                }
                                return;
                            }
                            FullSwiperView.this.pr(iIntValue);
                        }
                    }
                }
            }

            @Override // com.byazt.rij.pr
            public void pr(boolean z, int i) {
            }
        });
        for (pr prVar : this.hw) {
            of ofVarPr = prVar.pr();
            if (ofVarPr != null && (veVarSb = ofVarPr.sb()) != null) {
                this.zo.add(Integer.valueOf((int) veVarSb.hw()));
                this.aj.add(0);
                this.vk.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.hn, prVar, this.x, this.c);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.pr() { // from class: com.byazt.jw.FullSwiperView.2
                    @Override // com.byazt.jw.FullSwiperItemView.pr
                    public void pr() {
                        if (ww.g() == 0) {
                            FullSwiperView.this.uc();
                            FullSwiperView.this.hn.mw();
                        }
                        FullSwiperView.this.ho.set(true);
                    }
                });
                this.pr.pr(fullSwiperItemView);
                this.w.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.w.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.hw() { // from class: com.byazt.jw.FullSwiperView.3
            @Override // com.byazt.jw.FullSwiperItemView.hw
            public void pr(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.zo.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.pr.uc();
                } else {
                    FullSwiperView.this.vk.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.pr.uc();
                    if (FullSwiperView.this.w.size() > 1) {
                        int i = iIntValue / 1000;
                        int iMin = Math.min(ww.hw(false), i);
                        int iMax = Math.max(i - ww.hw(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.hn.pr(-1, iMin, iMax);
                        } else {
                            FullSwiperView.this.pr(iIntValue);
                        }
                    }
                }
                fullSwiperItemView2.hw(true);
                FullSwiperView.this.hw(1);
            }
        });
        fullSwiperItemView2.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i) {
        FullSwiperItemView fullSwiperItemViewHn = hn(i);
        if (fullSwiperItemViewHn != null) {
            fullSwiperItemViewHn.m();
        }
    }

    public void hw() {
        FullSwiperItemView fullSwiperItemViewHn = hn(this.k);
        if (fullSwiperItemViewHn != null) {
            fullSwiperItemViewHn.ho();
        }
        List<Long> list = this.vk;
        if (list != null && this.k < list.size()) {
            this.aj.add(this.k, Integer.valueOf(this.zo.get(this.k).intValue() - ((int) (System.currentTimeMillis() - this.vk.get(this.k).longValue()))));
        }
        uc();
    }

    public void hn() {
        FullSwiperItemView fullSwiperItemViewHn = hn(this.k);
        if (fullSwiperItemViewHn != null) {
            fullSwiperItemViewHn.nt();
        }
        if (this.k == this.w.size() - 1) {
            return;
        }
        this.pr.g(this.k);
        List<Integer> list = this.aj;
        if (list != null && this.k < list.size()) {
            if (!this.m && (!this.ho.get() || ww.g() == 1)) {
                pr(this.aj.get(this.k).intValue());
            }
            this.m = false;
        }
    }

    public void x() {
        uc();
    }

    public void c() {
        for (FullSwiperItemView fullSwiperItemView : this.w) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.lb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView hn(int i) {
        List<FullSwiperItemView> list = this.w;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.w.get(i);
    }

    public int getCurrentPosition() {
        return this.k;
    }

    public void pr(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(ww.hw(false), i / 1000) <= 0 && (baseSwiper = this.pr) != null) {
            baseSwiper.ho(i);
        }
    }

    public void uc() {
        BaseSwiper<ViewGroup> baseSwiper = this.pr;
        if (baseSwiper != null) {
            baseSwiper.fw();
        }
    }

    public void fw() {
        BaseSwiper<ViewGroup> baseSwiper = this.pr;
        if (baseSwiper != null) {
            baseSwiper.g(this.k + 1);
        }
    }
}
