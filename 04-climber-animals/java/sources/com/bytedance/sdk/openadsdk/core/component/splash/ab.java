package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.ti;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.ms> ab;
    private FrameLayout ah;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah c;
    private xr d;
    private com.bytedance.sdk.openadsdk.core.xr.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f2346ms;
    private Handler ny = new Handler(Looper.getMainLooper());
    private SoftReference<com.bytedance.sdk.openadsdk.ao.xr.ms.xr> x;
    private lm xr;

    public interface ms {
        Context getActivity();

        void ms();

        void ms(long j);

        void xr();
    }

    public void ms(Context context, lm lmVar) {
        this.f2346ms = context;
        this.xr = lmVar;
        this.ah = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ah.setLayoutParams(layoutParams);
        ti.xr(this.xr);
    }

    public ViewGroup ms() {
        return this.ah;
    }

    public void ms(String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.ms msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        this.ab = new SoftReference<>(msVar);
        if (xrVar != null) {
            this.x = new SoftReference<>(xrVar);
        }
        HashMap map = new HashMap();
        map.put("splash_show_type", Integer.valueOf(i));
        com.bytedance.sdk.openadsdk.core.xr.ms msVar2 = new com.bytedance.sdk.openadsdk.core.xr.ms(this.f2346ms, this.xr, str, 4);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
        SoftReference<com.bytedance.sdk.openadsdk.ao.xr.ms.xr> softReference = this.x;
        if (softReference == null) {
            ms(str, this.ah, null);
        } else {
            ms(str, this.ah, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.c);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar2.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ab.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.ms
            public void ms(View view, int i2) {
                if (ab.this.ab != null && ab.this.ab.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.ms) ab.this.ab.get()).xr();
                }
                ab.this.ah();
            }
        });
        this.ka = msVar2;
        xr xrVar2 = this.d;
        if (xrVar2 != null) {
            xrVar2.ms(msVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ms(lm lmVar, String str) {
        if (lmVar.jr() == 4) {
            return com.bytedance.sdk.openadsdk.core.hi.ka.ms(this.f2346ms, lmVar, str, false);
        }
        return null;
    }

    private void ms(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        lm lmVar = this.xr;
        if (lmVar == null || this.f2346ms == null || viewGroup == null) {
            return;
        }
        this.c = ms(lmVar, str);
        EmptyView emptyView = new EmptyView(this.f2346ms, viewGroup, this.xr.kf());
        emptyView.ms(this.xr, str);
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (xrVar != null) {
            ms(xrVar);
        }
        emptyView.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ab.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z) {
                if (ab.this.c != null && z) {
                    ab.this.c.x();
                }
                ab.this.ms(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                ViewGroup viewGroup2;
                Context context;
                if (ab.this.c != null) {
                    ab.this.c.ka(false);
                }
                if (ab.this.c == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                    context = null;
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                ab.this.c.ms((Activity) context);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
                if (ab.this.c != null) {
                    ab.this.c.ny();
                }
            }
        });
    }

    private void ms(final com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.c;
        if (ahVar == null) {
            return;
        }
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ab.3
            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms() {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void xr(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.xr(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ah(long j, long j2, String str, String str2) {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ah(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, String str, String str2) {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(String str, String str2) {
                com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar2 = xrVar;
                if (xrVar2 != null) {
                    xrVar2.ms(str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        this.ny.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ab.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.f2579ms) {
                    com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.f2579ms = false;
                    if (ab.this.c instanceof com.bytedance.sdk.openadsdk.core.hi.ah.x) {
                        ((com.bytedance.sdk.openadsdk.core.hi.ah.x) ab.this.c).hi().ms(new com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ab.4.1
                            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.ms
                            public void ms() {
                                ab.this.xr();
                            }
                        });
                        return;
                    }
                    return;
                }
                ab.this.xr();
            }
        }, 100L);
    }

    public void ms(int i) {
        if (i == 2 && ti.ms(this.xr)) {
            this.d = new ah();
        }
        xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms(this.f2346ms, this.ah, this.xr);
            this.d.ms(this.ka);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, ms msVar) {
        xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms(dVar, msVar);
        }
    }

    public void xr() {
        xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.xr();
        }
    }

    public void ms(boolean z) {
        xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms(z);
        }
    }
}
