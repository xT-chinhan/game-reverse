package com.byazt.za;

import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements d {
    public WeakReference<d> n;
    public Queue<Runnable> qg = new LinkedList();

    public d cp() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void n(d dVar) {
        this.n = new WeakReference<>(dVar);
        while (!this.qg.isEmpty()) {
            try {
                Runnable runnablePoll = this.qg.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.byazt.za.d
    public void n(final boolean z) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(z);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.1
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(z);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void w() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().w();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.11
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).w();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void x() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().x();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.12
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).x();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final int i) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(i);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.13
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(i);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public long n() {
        WeakReference<d> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.n.get().n();
    }

    @Override // com.byazt.za.d
    public int qg() {
        WeakReference<d> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.n.get().qg();
    }

    @Override // com.byazt.za.d
    public void fs() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().fs();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.14
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).fs();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public int s() {
        WeakReference<d> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.n.get().s();
    }

    @Override // com.byazt.za.d
    public void rv() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().rv();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.15
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).rv();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void tj() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().tj();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.16
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).tj();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void q(final int i) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().q(i);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.17
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).q(i);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(f, f2, f3, f4, i);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.18
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void q() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().q();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.2
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).q();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void qg(final int i) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().qg(i);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.3
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).qg(i);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void l() {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().l();
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.4
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).l();
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final int i, final String str) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(i, str);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.5
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(i, str);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().setPauseFromExpressView(z);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.6
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).setPauseFromExpressView(z);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final float f) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(f);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.7
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(f);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final int i, final int i2) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(i, i2);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.8
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(i, i2);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void s(final int i) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().s(i);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.9
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).s(i);
                }
            });
        }
    }

    @Override // com.byazt.za.d
    public void n(final pk pkVar) {
        WeakReference<d> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            this.n.get().n(pkVar);
        } else {
            this.qg.add(new Runnable() { // from class: com.byazt.za.oa.10
                @Override // java.lang.Runnable
                public void run() {
                    if (oa.this.n == null || oa.this.n.get() == null) {
                        return;
                    }
                    ((d) oa.this.n.get()).n(pkVar);
                }
            });
        }
    }
}
