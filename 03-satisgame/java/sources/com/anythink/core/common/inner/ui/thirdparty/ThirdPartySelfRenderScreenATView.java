package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.o;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.ui.BaseScreenATView;
import com.anythink.core.common.inner.ui.CloseImageView;
import com.anythink.core.common.k.e.a.e;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartySelfRenderScreenATView extends BaseScreenATView implements e {
    private static final String K = "ThirdPartySelfRenderScreenATView";
    private static final int L = 0;
    private View M;
    private View N;
    private BaseAd O;
    private ATNativeAdInfo.AdPrepareInfo P;
    private com.anythink.core.common.k.e.a.b Q;
    private boolean R;
    private boolean S;
    private FrameLayout T;

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a() {
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final int g() {
        return 0;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void q() {
    }

    static /* synthetic */ boolean b(ThirdPartySelfRenderScreenATView thirdPartySelfRenderScreenATView) {
        thirdPartySelfRenderScreenATView.S = true;
        return true;
    }

    public ThirdPartySelfRenderScreenATView(Context context) {
        super(context);
        this.R = true;
        this.S = false;
    }

    public ThirdPartySelfRenderScreenATView(Context context, x xVar, w wVar, String str, int i, int i2, BaseAd baseAd, View view, ATNativeAdInfo.AdPrepareInfo adPrepareInfo) {
        super(context, xVar, wVar, str, i, i2);
        this.R = true;
        this.S = false;
        this.T = new FrameLayout(getContext());
        this.T.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (adPrepareInfo != null) {
            this.P = adPrepareInfo;
        } else {
            this.P = new ATNativeAdInfo.AdPrepareInfo();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p.a(context, 32.0f), p.a(context, 8.0f));
            layoutParams.gravity = 85;
            this.P.setChoiceViewLayoutParams(layoutParams);
        }
        if (xVar != null && (xVar.t instanceof com.anythink.core.common.inner.mixad.e.c)) {
            this.R = ((com.anythink.core.common.inner.mixad.e.c) xVar.t).ah();
        }
        this.M = view;
        this.O = baseAd;
        al.a(view);
        BaseAd baseAd2 = this.O;
        ViewGroup customAdContainer = baseAd2 != null ? baseAd2.getCustomAdContainer() : null;
        try {
            if (this.M.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.gravity = 17;
                if (customAdContainer != null) {
                    al.a((View) customAdContainer);
                    customAdContainer.addView(this.M);
                    this.T.addView(customAdContainer, layoutParams2);
                } else {
                    this.T.addView(this.M, layoutParams2);
                }
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.M.getLayoutParams();
                if (customAdContainer != null) {
                    al.a((View) customAdContainer);
                    customAdContainer.addView(this.M);
                    this.T.addView(customAdContainer, layoutParams3);
                } else {
                    this.T.addView(this.M, layoutParams3);
                }
            }
            if (customAdContainer != null) {
                customAdContainer.setBackgroundColor(0);
            }
        } catch (Throwable th) {
            Log.e(K, "addAdView() >>> failed: " + th.getMessage());
        }
        p();
        setBackgroundColor(0);
        addView(this.T);
    }

    private void a(Context context, x xVar, ATNativeAdInfo.AdPrepareInfo adPrepareInfo) {
        if (adPrepareInfo != null) {
            this.P = adPrepareInfo;
        } else {
            this.P = new ATNativeAdInfo.AdPrepareInfo();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p.a(context, 32.0f), p.a(context, 8.0f));
            layoutParams.gravity = 85;
            this.P.setChoiceViewLayoutParams(layoutParams);
        }
        if (xVar == null || !(xVar.t instanceof com.anythink.core.common.inner.mixad.e.c)) {
            return;
        }
        this.R = ((com.anythink.core.common.inner.mixad.e.c) xVar.t).ah();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    public void init() {
        BaseAd baseAd = this.O;
        if (baseAd == null) {
            return;
        }
        baseAd.setNativeEventListener(new o() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartySelfRenderScreenATView.1
            @Override // com.anythink.core.common.d.n
            public final void onAdActReward(int i) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdActRewardSuccess() {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoProgress(int i) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdImpressed() {
                if (ThirdPartySelfRenderScreenATView.this.S) {
                    return;
                }
                ThirdPartySelfRenderScreenATView.b(ThirdPartySelfRenderScreenATView.this);
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.a(new com.anythink.core.common.inner.e.e());
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onAdImpressed();
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdClicked(View view) {
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.b(new com.anythink.core.common.inner.e.e().a(com.anythink.core.common.inner.mixad.f.b.g, com.anythink.core.common.inner.mixad.f.b.a));
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onAdClicked(view);
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoStart() {
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.a();
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onAdVideoStart();
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoEnd() {
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.b();
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onAdVideoEnd();
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void a(String str, String str2) {
                ThirdPartySelfRenderScreenATView.this.a(com.anythink.core.common.inner.b.b.a(str, str2));
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onVideoError(str, str2);
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdDislikeButtonClick() {
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.d();
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onClose();
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onDeeplinkCallback(boolean z) {
                if (ThirdPartySelfRenderScreenATView.this.E != null) {
                    ThirdPartySelfRenderScreenATView.this.E.a(z);
                }
                if (ThirdPartySelfRenderScreenATView.this.Q != null) {
                    ThirdPartySelfRenderScreenATView.this.Q.onDeeplinkCallback(z);
                }
            }
        });
        this.O.registerListener(this.T, this.P);
        View view = this.N;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartySelfRenderScreenATView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ThirdPartySelfRenderScreenATView.this.l();
                }
            });
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void l() {
        if (this.E != null) {
            this.E.d();
        }
        com.anythink.core.common.k.e.a.b bVar = this.Q;
        if (bVar != null) {
            bVar.onClose();
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void p() {
        ATNativeAdInfo.AdPrepareInfo adPrepareInfo = this.P;
        if (adPrepareInfo == null) {
            return;
        }
        View closeView = adPrepareInfo.getCloseView();
        if (closeView == null && (!A() || this.R)) {
            closeView = y();
        }
        this.N = closeView;
    }

    private View y() {
        try {
            Context context = getContext();
            CloseImageView closeImageView = new CloseImageView(context, null);
            closeImageView.setBackgroundResource(p.a(context, "myoffer_base_close_icon", "drawable"));
            int iA = p.a(getContext(), 24.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 5;
            int iA2 = p.a(context, 5.0f);
            if (A()) {
                layoutParams.topMargin = iA2;
            } else {
                layoutParams.topMargin = p.b(context) + iA2;
            }
            layoutParams.rightMargin = iA2;
            this.T.addView(closeImageView, layoutParams);
            return closeImageView;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void z() {
        al.a(this.M);
        BaseAd baseAd = this.O;
        ViewGroup customAdContainer = baseAd != null ? baseAd.getCustomAdContainer() : null;
        try {
            if (this.M.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                if (customAdContainer != null) {
                    al.a((View) customAdContainer);
                    customAdContainer.addView(this.M);
                    this.T.addView(customAdContainer, layoutParams);
                } else {
                    this.T.addView(this.M, layoutParams);
                }
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
                if (customAdContainer != null) {
                    al.a((View) customAdContainer);
                    customAdContainer.addView(this.M);
                    this.T.addView(customAdContainer, layoutParams2);
                } else {
                    this.T.addView(this.M, layoutParams2);
                }
            }
            if (customAdContainer != null) {
                customAdContainer.setBackgroundColor(0);
            }
        } catch (Throwable th) {
            Log.e(K, "addAdView() >>> failed: " + th.getMessage());
        }
    }

    public void setMixNativeAdEventListener(com.anythink.core.common.k.e.a.b bVar) {
        this.Q = bVar;
    }

    private boolean A() {
        return this.f != null && this.f.b == Integer.parseInt("2");
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView, com.anythink.core.common.inner.ui.BaseATView
    public void destroy() {
        super.destroy();
        BaseAd baseAd = this.O;
        if (baseAd != null) {
            baseAd.setNativeEventListener(null);
            this.O.clear(this);
            this.O.destroy();
        }
        if (this.v != null) {
            this.v.removeAllViews();
        }
        removeAllViews();
    }
}
