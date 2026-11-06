package com.anythink.core.common.inner.mixad.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.h;
import com.anythink.core.common.d.k;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;
import com.anythink.core.common.inner.ui.BaseATActivity;
import com.anythink.core.common.inner.ui.BaseMediaATView;
import com.anythink.core.common.inner.ui.CloseShadeView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyBannerATView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyNativeTemplateView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartySelfRenderScreenATView;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartySplashATView;
import com.anythink.core.common.k.e.a.g;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.p;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.anythink.core.common.k.e.a.a {
    private static final String a = "b";
    private com.anythink.core.common.inner.mixad.c.a.a b;

    public b(com.anythink.core.common.inner.mixad.c.a.a aVar) {
        this.b = aVar;
    }

    public b(com.anythink.core.common.k.d.a aVar) {
        if (aVar == null) {
            return;
        }
        BaseAd baseAdB = aVar.b();
        if (baseAdB instanceof com.anythink.core.common.k.g.d) {
            Context contextA = aVar.a();
            ATNativeAdCustomRender aTNativeAdCustomRenderC = aVar.c();
            com.anythink.core.common.k.g.d dVar = (com.anythink.core.common.k.g.d) baseAdB;
            com.anythink.core.common.inner.mixad.e.a aVar2 = new com.anythink.core.common.inner.mixad.e.a(dVar);
            com.anythink.core.common.inner.mixad.e.b bVar = new com.anythink.core.common.inner.mixad.e.b(dVar, aVar.g(), aVar.e());
            com.anythink.core.common.inner.mixad.c.a.a.C0024a c0024aA = new com.anythink.core.common.inner.mixad.c.a.a.C0024a().a(contextA);
            c cVar = new c(baseAdB);
            cVar.a(new a(baseAdB));
            cVar.a(aTNativeAdCustomRenderC);
            this.b = c0024aA.a(cVar).a(aVar2).a(bVar).b(aVar.h()).a(aVar.d()).b(aVar.j()).c(aVar.k()).a();
        }
    }

    private static ATNativeAdInfo a(ATNativeAdCustomRender aTNativeAdCustomRender, BaseAd baseAd) {
        c cVar = new c(baseAd);
        cVar.a(new a(baseAd));
        cVar.a(aTNativeAdCustomRender);
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0100  */
    /* JADX WARN: Code duplicated, block: B:83:0x015a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.common.k.e.a.a
    public final com.anythink.core.common.k.e.a.c a() {
        int i;
        com.anythink.core.common.inner.mixad.e.c cVar;
        int iAg;
        boolean zAe;
        int iAf;
        com.anythink.core.common.k.a aVarA;
        byte b;
        com.anythink.core.common.k.e.a.c cVar2;
        byte b2;
        int iA;
        com.anythink.core.common.inner.mixad.c.a.a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        try {
            x xVarB = aVar.b();
            w<?> wVarC = this.b.c();
            Context contextJ = this.b.j();
            int iF = this.b.f();
            String strE = this.b.e();
            if (contextJ != null && xVarB != null && wVarC != null) {
                if (contextJ instanceof Activity) {
                    try {
                        contextJ = (Context) new WeakReference(contextJ).get();
                    } catch (Throwable th) {
                        th = th;
                        i = -1;
                        f.b("createView error:".concat(String.valueOf(i)), th.getMessage() + ", " + p.a(th.getStackTrace()), s.b().r());
                        return null;
                    }
                }
                Context context = contextJ;
                if (xVarB.t instanceof com.anythink.core.common.inner.mixad.e.c) {
                    cVar = (com.anythink.core.common.inner.mixad.e.c) xVarB.t;
                    zAe = cVar.ae();
                    iAf = cVar.af();
                    iAg = cVar.ag();
                } else {
                    cVar = null;
                    iAg = 2;
                    zAe = true;
                    iAf = 1;
                }
                int i2 = xVarB.b;
                try {
                    g gVar = (g) this.b.a();
                    BaseAd baseAdA = gVar.a();
                    com.anythink.core.common.inner.mixad.shake.a aVar2 = new com.anythink.core.common.inner.mixad.shake.a(context, baseAdA, cVar);
                    gVar.a(aVar2);
                    ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                    if (aTNativeAdCustomRenderD != null && !zAe) {
                        View viewI = this.b.i();
                        View mediationViewFromNativeAd = viewI == null ? aTNativeAdCustomRenderD.getMediationViewFromNativeAd(gVar, k.a(baseAdA, gVar.b())) : viewI;
                        if (mediationViewFromNativeAd != null) {
                            ThirdPartySelfRenderScreenATView thirdPartySelfRenderScreenATView = new ThirdPartySelfRenderScreenATView(context, xVarB, wVarC, strE, i2, iF, baseAdA, mediationViewFromNativeAd, gVar.c());
                            if (String.valueOf(i2).equals("2") || String.valueOf(i2).equals("4")) {
                                thirdPartySelfRenderScreenATView.setMixNativeAdEventListener(this.b.h());
                                thirdPartySelfRenderScreenATView.init();
                            }
                            return thirdPartySelfRenderScreenATView;
                        }
                    }
                    String strValueOf = String.valueOf(i2);
                    if (iAg == 1) {
                        switch (strValueOf.hashCode()) {
                            case 50:
                                if (!strValueOf.equals("2")) {
                                    b2 = -1;
                                } else {
                                    b2 = 2;
                                }
                                break;
                            case 51:
                                if (!strValueOf.equals("3")) {
                                    b2 = -1;
                                } else {
                                    b2 = 0;
                                }
                                break;
                            case 52:
                                if (!strValueOf.equals("4")) {
                                    b2 = -1;
                                } else {
                                    b2 = 1;
                                }
                                break;
                            default:
                                b2 = -1;
                                break;
                        }
                        if (b2 != 0 && b2 != 1) {
                            if (b2 != 2) {
                                iA = 0;
                            } else {
                                iA = p.a(context, 50.0f);
                            }
                            aVarA = aVar2.a(iA, iA, null);
                        } else {
                            iA = p.a(context, 148.0f);
                        }
                        aVarA = aVar2.a(iA, iA, null);
                    } else {
                        aVarA = null;
                    }
                    switch (strValueOf.hashCode()) {
                        case 48:
                            if (!strValueOf.equals("0")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        case 49:
                            if (!strValueOf.equals("1")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 50:
                            if (!strValueOf.equals("2")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 51:
                            if (!strValueOf.equals("3")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 52:
                            if (!strValueOf.equals("4")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        if (iAf == 1) {
                            return new ThirdPartyFullScreenATView(context, xVarB, wVarC, strE, i2, iF, baseAdA, aVarA);
                        }
                        return new ThirdPartyHalfScreenATView(context, xVarB, wVarC, strE, i2, iF, baseAdA, aVarA);
                    }
                    if (b == 1) {
                        com.anythink.core.common.inner.mixad.c.a.a aVar3 = this.b;
                        if (aVar3 != null) {
                            com.anythink.core.common.k.e.a.b bVarH = aVar3.h();
                            ThirdPartySplashATView thirdPartySplashATView = new ThirdPartySplashATView(context, xVarB, wVarC, new AnonymousClass2(bVarH), "", baseAdA, aVarA);
                            baseAdA.setNativeEventListener(new AnonymousClass3(new boolean[]{false}, bVarH, thirdPartySplashATView));
                            thirdPartySplashATView.setDontCountDown(aVar3.g());
                            return thirdPartySplashATView;
                        }
                    } else if (b == 2) {
                        com.anythink.core.common.inner.mixad.c.a.a aVar4 = this.b;
                        if (aVar4 != null) {
                            com.anythink.core.common.k.e.a.b bVarH2 = aVar4.h();
                            ThirdPartyBannerATView thirdPartyBannerATView = new ThirdPartyBannerATView(context, baseAdA, xVarB, wVarC, new AnonymousClass4(bVarH2));
                            baseAdA.setNativeEventListener(new AnonymousClass5(new boolean[]{false}, bVarH2, thirdPartyBannerATView));
                            cVar2 = thirdPartyBannerATView;
                            return cVar2;
                        }
                    } else if (b == 3) {
                        com.anythink.core.common.inner.mixad.c.a.a aVar5 = this.b;
                        if (aVar5 != null) {
                            ThirdPartyNativeTemplateView thirdPartyNativeTemplateView = new ThirdPartyNativeTemplateView(context, wVarC, xVarB, true, new AnonymousClass6(aVar5.h()), baseAdA);
                            thirdPartyNativeTemplateView.init(aVar5.k(), aVar5.l(), xVarB.t.M());
                            int mediaViewWidth = thirdPartyNativeTemplateView.getMediaViewWidth();
                            int mediaViewHeight = thirdPartyNativeTemplateView.getMediaViewHeight();
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                            if (mediaViewWidth > 0) {
                                layoutParams.width = mediaViewWidth;
                            }
                            if (mediaViewHeight > 0) {
                                layoutParams.height = mediaViewHeight;
                            }
                            thirdPartyNativeTemplateView.setLayoutParams(layoutParams);
                            cVar2 = thirdPartyNativeTemplateView;
                            return cVar2;
                        }
                    } else if (b == 4) {
                        return new ThirdPartyFullScreenATView(context, xVarB, wVarC, strE, i2, iF, baseAdA, aVarA);
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    i = i2;
                    f.b("createView error:".concat(String.valueOf(i)), th.getMessage() + ", " + p.a(th.getStackTrace()), s.b().r());
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            i = -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007d  */
    @Override // com.anythink.core.common.k.e.a.a
    public final void a(Activity activity, com.anythink.core.basead.b.c cVar, com.anythink.core.common.k.e.a.a.InterfaceC0029a interfaceC0029a) {
        com.anythink.core.common.inner.mixad.c.a.a aVar;
        boolean z;
        View mediationViewFromNativeAd;
        if (activity == null || cVar == null || (aVar = this.b) == null) {
            return;
        }
        cVar.c = aVar.c();
        cVar.h = this.b.b();
        final String str = cVar.d;
        final com.anythink.core.common.k.e.a.b bVarH = this.b.h();
        com.anythink.core.common.inner.e.b.a().a(str, new com.anythink.core.common.inner.e.b.AbstractC0023b() { // from class: com.anythink.core.common.inner.mixad.c.b.1
            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void c() {
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void a(e eVar) {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdImpressed();
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void a(com.anythink.core.common.inner.b.a aVar2) {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    if (aVar2 != null) {
                        bVar.onVideoError(aVar2.a(), aVar2.b());
                    } else {
                        bVar.onVideoError("", "");
                    }
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void a() {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdVideoStart();
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void b() {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdVideoEnd();
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void d() {
                com.anythink.core.common.inner.e.b.a().b(str);
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onClose();
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void b(e eVar) {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if ((bVar instanceof com.anythink.core.common.k.e.a) && eVar != null) {
                    ((com.anythink.core.common.k.e.a) bVar).setClickedArea(eVar.b);
                    ((com.anythink.core.common.k.e.a) bVarH).setClickType(eVar.a);
                }
                com.anythink.core.common.k.e.a.b bVar2 = bVarH;
                if (bVar2 != null) {
                    bVar2.onAdClicked(null);
                }
            }

            @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
            public final void a(boolean z2) {
                com.anythink.core.common.k.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onDeeplinkCallback(z2);
                }
            }
        });
        com.anythink.core.common.inner.mixad.a.a().a(str, interfaceC0029a);
        com.anythink.core.common.inner.mixad.a.a().a(str, this.b);
        com.anythink.core.common.inner.mixad.c.a.a aVar2 = this.b;
        if (aVar2 != null) {
            x xVarB = aVar2.b();
            if (!(xVarB.t instanceof com.anythink.core.common.inner.mixad.e.c) || ((com.anythink.core.common.inner.mixad.e.c) xVarB.t).ae()) {
                z = false;
            } else {
                ATNativeAdInfo aTNativeAdInfoA = aVar2.a();
                if (aTNativeAdInfoA instanceof g) {
                    g gVar = (g) aTNativeAdInfoA;
                    BaseAd baseAdA = gVar.a();
                    ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                    if (aTNativeAdCustomRenderD == null || (mediationViewFromNativeAd = aTNativeAdCustomRenderD.getMediationViewFromNativeAd(aTNativeAdInfoA, k.a(baseAdA, gVar.b()))) == null) {
                        z = false;
                    } else {
                        aVar2.a(mediationViewFromNativeAd);
                        z = true;
                    }
                } else {
                    z = false;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            cVar.j = true;
        }
        BaseATActivity.a(activity, cVar);
    }

    private static int a(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "2":
                return p.a(context, 50.0f);
            case "3":
            case "4":
                return p.a(context, 148.0f);
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.b$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.core.common.inner.e.c {
        final /* synthetic */ com.anythink.core.common.k.e.a.b a;

        AnonymousClass2(com.anythink.core.common.k.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.core.common.inner.e.c, com.anythink.core.common.inner.e.a
        public final void b() {
            com.anythink.core.common.k.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onClose();
            }
        }

        @Override // com.anythink.core.common.inner.e.c, com.anythink.core.common.inner.e.a
        public final void a(com.anythink.core.common.inner.b.a aVar) {
            com.anythink.core.common.k.e.a.b bVar = this.a;
            if (bVar != null) {
                if (aVar != null) {
                    bVar.onVideoError(aVar.a(), aVar.b());
                } else {
                    bVar.onVideoError("", "");
                }
            }
        }
    }

    private com.anythink.core.common.k.e.a.c a(com.anythink.core.common.inner.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w wVar, com.anythink.core.common.k.a aVar2) {
        if (aVar == null) {
            return null;
        }
        com.anythink.core.common.k.e.a.b bVarH = aVar.h();
        ThirdPartySplashATView thirdPartySplashATView = new ThirdPartySplashATView(context, xVar, wVar, new AnonymousClass2(bVarH), "", baseAd, aVar2);
        baseAd.setNativeEventListener(new AnonymousClass3(new boolean[]{false}, bVarH, thirdPartySplashATView));
        thirdPartySplashATView.setDontCountDown(aVar.g());
        return thirdPartySplashATView;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.b$3, reason: invalid class name */
    final class AnonymousClass3 extends h {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ com.anythink.core.common.k.e.a.b b;
        final /* synthetic */ ThirdPartySplashATView c;

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdVideoStart() {
        }

        AnonymousClass3(boolean[] zArr, com.anythink.core.common.k.e.a.b bVar, ThirdPartySplashATView thirdPartySplashATView) {
            this.a = zArr;
            this.b = bVar;
            this.c = thirdPartySplashATView;
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onAdImpressed();
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdClicked(View view) {
            if (this.b != null) {
                CloseShadeView closeShadeView = this.c.getCloseShadeView();
                if (closeShadeView != null) {
                    if (closeShadeView.isTouch()) {
                        com.anythink.core.common.k.e.a.b bVar = this.b;
                        if (bVar instanceof com.anythink.core.common.k.e.a) {
                            ((com.anythink.core.common.k.e.a) bVar).setClickType(com.anythink.core.common.inner.mixad.f.b.h);
                        }
                    }
                    closeShadeView.setVisibility(8);
                }
                this.b.onAdClicked(null);
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.b$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.core.common.inner.e.c {
        final /* synthetic */ com.anythink.core.common.k.e.a.b a;

        AnonymousClass4(com.anythink.core.common.k.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.core.common.inner.e.c, com.anythink.core.common.inner.e.a
        public final void b() {
            com.anythink.core.common.k.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onClose();
            }
        }
    }

    private com.anythink.core.common.k.e.a.c a(com.anythink.core.common.inner.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w<?> wVar) {
        if (aVar == null) {
            return null;
        }
        com.anythink.core.common.k.e.a.b bVarH = aVar.h();
        ThirdPartyBannerATView thirdPartyBannerATView = new ThirdPartyBannerATView(context, baseAd, xVar, wVar, new AnonymousClass4(bVarH));
        baseAd.setNativeEventListener(new AnonymousClass5(new boolean[]{false}, bVarH, thirdPartyBannerATView));
        return thirdPartyBannerATView;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.b$5, reason: invalid class name */
    final class AnonymousClass5 extends h {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ com.anythink.core.common.k.e.a.b b;
        final /* synthetic */ ThirdPartyBannerATView c;

        AnonymousClass5(boolean[] zArr, com.anythink.core.common.k.e.a.b bVar, ThirdPartyBannerATView thirdPartyBannerATView) {
            this.a = zArr;
            this.b = bVar;
            this.c = thirdPartyBannerATView;
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onAdImpressed();
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdClicked(View view) {
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                if (bVar instanceof com.anythink.core.common.k.e.a) {
                    ((com.anythink.core.common.k.e.a) bVar).setClickedArea(this.c.getClickedArea());
                }
                this.b.onAdClicked(null);
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
            }
        }

        @Override // com.anythink.core.common.d.h, com.anythink.core.common.d.n
        public final void onAdDislikeButtonClick() {
            super.onAdDislikeButtonClick();
            com.anythink.core.common.k.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onClose();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.c.b$6, reason: invalid class name */
    final class AnonymousClass6 implements BaseMediaATView.a {
        final /* synthetic */ com.anythink.core.common.k.e.a.b a;

        AnonymousClass6(com.anythink.core.common.k.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.core.common.inner.ui.BaseMediaATView.a
        public final void a() {
            com.anythink.core.common.k.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onAdDislikeButtonClick();
            }
        }
    }

    private com.anythink.core.common.k.e.a.c b(com.anythink.core.common.inner.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w<?> wVar) {
        if (aVar == null) {
            return null;
        }
        ThirdPartyNativeTemplateView thirdPartyNativeTemplateView = new ThirdPartyNativeTemplateView(context, wVar, xVar, true, new AnonymousClass6(aVar.h()), baseAd);
        thirdPartyNativeTemplateView.init(aVar.k(), aVar.l(), xVar.t.M());
        int mediaViewWidth = thirdPartyNativeTemplateView.getMediaViewWidth();
        int mediaViewHeight = thirdPartyNativeTemplateView.getMediaViewHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        if (mediaViewWidth > 0) {
            layoutParams.width = mediaViewWidth;
        }
        if (mediaViewHeight > 0) {
            layoutParams.height = mediaViewHeight;
        }
        thirdPartyNativeTemplateView.setLayoutParams(layoutParams);
        return thirdPartyNativeTemplateView;
    }

    private static boolean a(com.anythink.core.common.inner.mixad.c.a.a aVar) {
        View mediationViewFromNativeAd;
        if (aVar == null) {
            return false;
        }
        x xVarB = aVar.b();
        if ((xVarB.t instanceof com.anythink.core.common.inner.mixad.e.c) && !((com.anythink.core.common.inner.mixad.e.c) xVarB.t).ae()) {
            ATNativeAdInfo aTNativeAdInfoA = aVar.a();
            if (aTNativeAdInfoA instanceof g) {
                g gVar = (g) aTNativeAdInfoA;
                BaseAd baseAdA = gVar.a();
                ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                if (aTNativeAdCustomRenderD != null && (mediationViewFromNativeAd = aTNativeAdCustomRenderD.getMediationViewFromNativeAd(aTNativeAdInfoA, k.a(baseAdA, gVar.b()))) != null) {
                    aVar.a(mediationViewFromNativeAd);
                    return true;
                }
            }
        }
        return false;
    }
}
