package com.bytedance.sdk.openadsdk.core.component.ms;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.b.d;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.ao.xr.ms implements LazeLayout.ms<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.ms<NativeVideoTsView> {
    private final lm ab;
    private int ah;
    private final Context c;
    private volatile WeakReference<NativeVideoTsView> ch;
    private com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms d;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms hi;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f2057ms;
    private LazeLayout ny;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr x;
    private Bitmap xr;

    public xr(Context context, lm lmVar, int i, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(new ah(context, lmVar, i, xrVar));
        this.ny = null;
        this.ch = null;
        this.hi = new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms(null) { // from class: com.bytedance.sdk.openadsdk.core.component.ms.xr.3
            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void ms(View view, zb zbVar) {
                NativeVideoTsView nativeVideoTsViewC = xr.this.ka.c();
                if (nativeVideoTsViewC != null) {
                    nativeVideoTsViewC.ch();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void xr(View view, zb zbVar) {
                NativeVideoTsView nativeVideoTsViewC = xr.this.ka.c();
                if (nativeVideoTsViewC != null) {
                    nativeVideoTsViewC.ch();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void ms(zb zbVar) {
                NativeVideoTsView nativeVideoTsViewC = xr.this.ka.c();
                if (nativeVideoTsViewC != null) {
                    nativeVideoTsViewC.y();
                }
            }
        };
        this.x = xrVar;
        ah ahVar = (ah) d();
        this.ka = ahVar;
        this.ab = lmVar;
        this.c = context;
        ((d) ahVar.nw()).ms(this.hi);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ms, com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public View ms() {
        NativeVideoTsView nativeVideoTsViewXr = null;
        if (this.ab == null || this.c == null) {
            return null;
        }
        if (this.ka.n_()) {
            if (ab.ms()) {
                this.ny = new LazeLayout(this.c, this, this);
            } else {
                try {
                    nativeVideoTsViewXr = xr(this.c);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewXr != null) {
                    ms(nativeVideoTsViewXr);
                }
                return nativeVideoTsViewXr;
            }
        } else if (com.bytedance.sdk.openadsdk.ka.ms.x(this.ab)) {
            return new UpieImageView(this.c, com.bytedance.sdk.openadsdk.ka.ms.ny(this.ab), null);
        }
        com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(this.ab).ms(this.ka.l_()).xr(this.ka.x());
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.ms
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView xr(Context context) {
        NativeVideoTsView nativeVideoTsViewMs = this.ka.ms(true);
        nativeVideoTsViewMs.setControllerStatusCallBack(new NativeVideoTsView.d() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.d
            public void ms(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                xr.this.ka.f2045ms.f2932ms = z;
                xr.this.ka.f2045ms.ka = j;
                xr.this.ka.f2045ms.c = j2;
                xr.this.ka.f2045ms.ab = j3;
                xr.this.ka.f2045ms.d = z2;
                xr.this.ka.f2045ms.x = z3;
            }
        });
        nativeVideoTsViewMs.setAdCreativeClickListener(new NativeVideoTsView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ms
            public void ms(View view, int i) {
                b bVarI = ((d) xr.this.ka.nw()).i();
                if (bVarI != null) {
                    bVarI.ms(view, i);
                }
            }
        });
        nativeVideoTsViewMs.setVideoAdLoadListener(this.ka);
        nativeVideoTsViewMs.setVideoAdInteractionListener(this.ka);
        int iNy = f.ny(this.ab);
        nativeVideoTsViewMs.setIsAutoPlay(ms(iNy));
        nativeVideoTsViewMs.setIsQuiet(re.xr().d(iNy));
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewMs;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.f2057ms);
        Bitmap bitmap = this.xr;
        if (bitmap != null) {
            nativeDrawVideoTsView.ms(bitmap, this.ah);
        }
        nativeVideoTsViewMs.setDrawVideoListener(this.d);
        this.ch = new WeakReference<>(nativeVideoTsViewMs);
        return nativeVideoTsViewMs;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.ms
    public void ms(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.ms(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.ms msVar2) {
        View viewMs;
        try {
            ms(viewGroup, (List<View>) null, list, list2, list3, (View) null, msVar);
            if (msVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(msVar2.xr());
                if (viewFindViewById != null && ab() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(ab());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = ul.ah(viewGroup.getContext(), 38.0f);
                        layoutParams.height = ul.ah(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(ab());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(msVar2.ms());
                if (frameLayout == null || (viewMs = ms()) == null) {
                    return;
                }
                ul.x(viewMs);
                frameLayout.removeAllViews();
                frameLayout.addView(viewMs, -1, -1);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        ah ahVar = this.ka;
        if (ahVar != null) {
            ahVar.ms(xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d xr() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ny
    public void ms(boolean z) {
        this.f2057ms = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ny
    public void ms(Bitmap bitmap, int i) {
        this.xr = bitmap;
        this.ah = i;
        ka();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ms, com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ah() {
        NativeVideoTsView nativeVideoTsView;
        super.ah();
        if (this.ch != null && (nativeVideoTsView = this.ch.get()) != null) {
            nativeVideoTsView.y();
        }
        LazeLayout lazeLayout = this.ny;
        if (lazeLayout != null) {
            lazeLayout.ms();
        }
    }

    private boolean ms(int i) {
        int iAb = re.xr().ab(i);
        if (3 == iAb) {
            return false;
        }
        if (1 != iAb || !u.d(this.c)) {
            if (2 == iAb) {
                if (!u.ka(this.c) && !u.d(this.c)) {
                    u.c(this.c);
                }
            } else if (5 == iAb && !u.d(this.c)) {
                u.c(this.c);
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ny
    public void ms(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar) {
        this.d = msVar;
    }

    private void ka() {
        int i = this.ah;
        if (i >= 200) {
            this.ah = 200;
        } else if (i <= 20) {
            this.ah = 20;
        }
    }
}
