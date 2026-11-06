package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr extends com.bytedance.sdk.openadsdk.ao.xr.d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int[] f3012ms;
    protected Dialog ny;
    protected ms x;

    public abstract lm ab();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public com.bytedance.sdk.openadsdk.ao.xr.xr.d ah() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public int d() {
        return 0;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms hi() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ka() {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public View ms() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public com.bytedance.sdk.openadsdk.ao.xr.xr.ab ms(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
    }

    protected void ms(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ms msVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr xrVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public Map<String, Object> x() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public int xr() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void c() {
        if (ab() != null) {
            com.bytedance.sdk.openadsdk.core.i.ms(ab().da());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.d
    public void ms(Dialog dialog, int[] iArr) {
        this.ny = dialog;
        this.f3012ms = iArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.xr.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (xr.this.ab() != null) {
                        xr xrVar = xr.this;
                        xrVar.ms(xrVar.ab().ca());
                    }
                }
            });
        } catch (Throwable unused) {
        }
        ms(this.ny);
    }

    protected void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        Dialog dialog;
        if (xrVar == null || (dialog = this.ny) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ms.xr.ms(xrVar, dialog, this.f3012ms);
    }

    protected static class ms implements com.bytedance.sdk.openadsdk.core.hi.xr.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> f3014ms;
        private String xr;

        public ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar, String str) {
            this.xr = "";
            this.f3014ms = new WeakReference<>(msVar);
            this.xr = str;
        }

        public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
            this.f3014ms = new WeakReference<>(msVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms() {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().ms();
            }
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().ms(j, j2, str, str2);
            }
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void xr(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().xr(j, j2, str, str2);
            }
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ah(long j, long j2, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().ah(j, j2, str, str2);
            }
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().ms(j, str, str2);
            }
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.hi.xr.ms> weakReference = this.f3014ms;
            if (weakReference != null && weakReference.get() != null) {
                this.f3014ms.get().ms(str, str2);
            }
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(this.xr, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar) {
        if (ab() != null) {
            com.bytedance.sdk.openadsdk.core.i.ms(ab().da(), msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        }
    }
}
