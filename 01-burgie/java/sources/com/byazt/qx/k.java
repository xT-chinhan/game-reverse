package com.byazt.qx;

import com.byazt.hg.of;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 250})
public class k implements w {
    public Queue<Runnable> hw = new LinkedList();
    public WeakReference<w> pr;

    public w w() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void pr(w wVar) {
        this.pr = new WeakReference<>(wVar);
        while (!this.hw.isEmpty()) {
            try {
                Runnable runnablePoll = this.hw.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final boolean z) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(z);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.1
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void uc() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().uc();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.11
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).uc();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void fw() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().fw();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.12
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).fw();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final int i) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(i);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.13
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public long pr() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().pr();
        }
        return 0L;
    }

    @Override // com.byazt.qx.w
    public int hw() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().hw();
        }
        return 0;
    }

    @Override // com.byazt.qx.w
    public void zo() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().zo();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.14
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).zo();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public int hn() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            return this.pr.get().hn();
        }
        return 0;
    }

    @Override // com.byazt.qx.w
    public void aj() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().aj();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.15
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).aj();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void vk() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().vk();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.16
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).vk();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void x(final int i) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().x(i);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.17
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).x(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(f, f2, f3, f4, i);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.18
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(f, f2, f3, f4, i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void x() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().x();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).x();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void hw(final int i) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().hw(i);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.3
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).hw(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void c() {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().c();
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.4
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).c();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final int i, final String str) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(i, str);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.5
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(i, str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().setPauseFromExpressView(z);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.6
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).setPauseFromExpressView(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final float f) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(f);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.7
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(f);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final int i, final int i2) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(i, i2);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.8
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(i, i2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void hn(final int i) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().hn(i);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.9
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).hn(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.w
    public void pr(final of ofVar) {
        WeakReference<w> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().pr(ofVar);
        } else {
            this.hw.add(new Runnable() { // from class: com.byazt.qx.k.10
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.pr != null && k.this.pr.get() != null) {
                        ((w) k.this.pr.get()).pr(ofVar);
                    }
                }
            });
        }
    }
}
