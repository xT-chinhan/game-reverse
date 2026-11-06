package com.bytedance.sdk.openadsdk.core.nativeexpress;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<hi> f2994ms;
    private Queue<Runnable> xr = new LinkedList();

    public hi sl() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void ms(hi hiVar) {
        this.f2994ms = new WeakReference<>(hiVar);
        while (!this.xr.isEmpty()) {
            try {
                Runnable runnablePoll = this.xr.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final boolean z) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ms(z);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ms(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ab();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.8
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ab();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().x();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.9
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).x();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final int i) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ms(i);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.10
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ms(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.f2994ms.get().ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.f2994ms.get().xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ny();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.11
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ny();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int ah() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.f2994ms.get().ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long getActualPlayDuration() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.f2994ms.get().getActualPlayDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ch();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.12
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ch();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().hi();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.13
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).hi();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final float f, final float f2, final float f3, final float f4, final int i) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ms(f, f2, f3, f4, i);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.14
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ms(f, f2, f3, f4, i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void d() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().d();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.15
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).d();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void xr(final int i) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().xr(i);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).xr(i);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ka() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ka();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ka();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final int i, final String str) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ms(i, str);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.4
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ms(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(final boolean z) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().setPauseFromExpressView(z);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.5
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).setPauseFromExpressView(z);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(final float f) {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().ms(f);
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).ms(f);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
        WeakReference<hi> weakReference = this.f2994ms;
        if (weakReference != null && weakReference.get() != null) {
            this.f2994ms.get().c();
        } else {
            this.xr.add(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sl.7
                @Override // java.lang.Runnable
                public void run() {
                    if (sl.this.f2994ms == null || sl.this.f2994ms.get() == null) {
                        return;
                    }
                    ((hi) sl.this.f2994ms.get()).c();
                }
            });
        }
    }
}
