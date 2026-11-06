package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ab;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ab {
    private boolean ab;
    private ah ah;
    private AtomicBoolean c;
    private InterfaceC0288ms ch;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xr d;
    private com.bytedance.sdk.openadsdk.core.dislike.xr.ms hi;
    private TTDislikeToast ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2484ms;
    private xr ny;
    private SoftReference<View> x;
    private com.bytedance.sdk.openadsdk.core.dislike.ah.xr xr;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0288ms {
        void ms();

        void ms(int i, String str, boolean z);

        void xr();
    }

    public ms(Context context, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, String str, boolean z) {
        this.c = new AtomicBoolean(false);
        xrVar.xr(str);
        xrVar.ms(AdnName.OTHER);
        this.f2484ms = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            sl.xr("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.xr = xrVar;
        this.ab = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            d();
        } else {
            x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.d();
                }
            });
        }
    }

    public ms(Context context, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, boolean z) {
        this(context, xrVar, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ViewGroup viewGroup;
        ah ahVar = new ah(this.f2484ms, this.xr);
        this.ah = ahVar;
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.dislike.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ah
            public void ms() {
                ms.this.ka();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ah
            public void ms(int i, c cVar) {
                try {
                    if (ms.this.hi != null) {
                        if (ms.this.hi.ms(cVar, ms.this.d != null ? ms.this.d.d() : "", ms.this.d)) {
                            sl.xr("TTAdDislikeImpl", "click feedback :" + cVar.xr() + ":" + cVar.ms());
                        }
                    }
                    if (!cVar.c()) {
                        if (ms.this.ch != null) {
                            ms.this.ch.ms(i, cVar.xr(), ms.this.xr != null ? ms.this.xr.x() : false);
                        }
                        ms.this.c.set(true);
                        if (ms.this.ka != null) {
                            ms.this.ka.ms();
                        }
                        ms.this.c();
                    }
                    sl.d("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + cVar.xr());
                } catch (Throwable th) {
                    sl.ah("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ah
            public void xr() {
                if (ms.this.ch != null) {
                    ms.this.ch.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.ah
            public void ah() {
                sl.d("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (ms.this.ch == null || ms.this.ah()) {
                        return;
                    }
                    ms.this.ch.xr();
                } catch (Throwable th) {
                    sl.ah("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ui.xr xrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.xr(this.f2484ms, this.xr);
        this.d = xrVar;
        xrVar.ms(new com.bytedance.sdk.openadsdk.core.dislike.xr.xr() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ms.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.xr
            public void ms() {
                try {
                    if (ms.this.c.get()) {
                        return;
                    }
                    ms.this.ah.show();
                    if (ms.this.d != null) {
                        String strD = ms.this.d.d();
                        if (TextUtils.isEmpty(strD)) {
                            return;
                        }
                        ms.this.ah.ms(strD);
                    }
                } catch (Throwable th) {
                    sl.ah("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.xr.xr
            public void ms(int i, c cVar) {
                try {
                    if (cVar.c()) {
                        return;
                    }
                    if (ms.this.ch != null) {
                        ms.this.ch.ms(i, cVar.xr(), ms.this.xr != null ? ms.this.xr.x() : false);
                    }
                    ms.this.c.set(true);
                    if (ms.this.ka != null) {
                        ms.this.ka.ms();
                    }
                    ms.this.c();
                } catch (Throwable th) {
                    sl.ah("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.f2484ms instanceof Activity) && this.ab) {
            this.ka = new TTDislikeToast(this.f2484ms);
            Window window = ((Activity) this.f2484ms).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.ka);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
    public void ms() {
        TTDislikeToast tTDislikeToast;
        Context context = this.f2484ms;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.c.get() && this.ab && (tTDislikeToast = this.ka) != null) {
            tTDislikeToast.xr();
        } else {
            if (!z || ah()) {
                return;
            }
            this.ah.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        Context context = this.f2484ms;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.d.isShowing()) {
            this.d.show();
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        if ((this.f2484ms instanceof Activity) && xrVar != null) {
            this.ah.ms(xrVar);
            this.d.ms(xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
    public void ms(final com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        this.ch = new InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ms.4
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms() {
                com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void ms(int i, String str, boolean z) {
                com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(i, str, z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
            public void xr() {
                com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.xr();
                }
            }
        };
    }

    public void ms(InterfaceC0288ms interfaceC0288ms) {
        this.ch = interfaceC0288ms;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar = this.xr;
        if (xrVar != null) {
            xrVar.ms(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
    public void xr() {
        if (this.f2484ms instanceof Activity) {
            ah ahVar = this.ah;
            if (ahVar != null) {
                ahVar.hide();
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.xr xrVar = this.d;
            if (xrVar != null) {
                xrVar.ms();
            }
            TTDislikeToast tTDislikeToast = this.ka;
            if (tTDislikeToast != null) {
                tTDislikeToast.ah();
            }
            this.c.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
    public boolean ah() {
        if (!(this.f2484ms instanceof Activity)) {
            return false;
        }
        ah ahVar = this.ah;
        boolean zIsShowing = ahVar != null ? ahVar.isShowing() : false;
        com.bytedance.sdk.openadsdk.core.dislike.ui.xr xrVar = this.d;
        return xrVar != null ? zIsShowing | xrVar.isShowing() : zIsShowing;
    }

    public void ms(View view) {
        this.x = new SoftReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar = this.xr;
        if (xrVar == null) {
            return;
        }
        final String strAb = xrVar.ab();
        if ("slide_banner_ad".equals(strAb) || "banner_ad".equals(strAb) || "embeded_ad".equals(strAb)) {
            if (this.x.get() != null && this.xr.x()) {
                this.x.get().setVisibility(8);
            }
            if (this.ny == null) {
                this.ny = new xr(this.f2484ms);
            }
            this.ny.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ms.5
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.xr.xr("dislike");
                    if (ms.this.x == null || ms.this.x.get() == null || !((View) ms.this.x.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(ms.this.f2484ms, ms.this.xr, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(ms.this.f2484ms, ms.this.xr, "close_fail");
                    }
                    ms.this.xr.xr(strAb);
                }
            }, 500L);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.xr.ms msVar) {
        this.hi = msVar;
        com.bytedance.sdk.openadsdk.core.dislike.ui.xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms(msVar);
        }
    }

    public static class xr extends Handler {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public WeakReference<Context> f2490ms;

        public xr(Context context) {
            this.f2490ms = new WeakReference<>(context);
        }
    }
}
