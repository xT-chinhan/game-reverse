package com.anythink.basead.mixad.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.f;
import com.anythink.basead.g.h;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.BaseATActivity;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.basead.ui.thirdparty.ThirdPartyBannerATView;
import com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView;
import com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView;
import com.anythink.basead.ui.thirdparty.ThirdPartyNativeTemplateView;
import com.anythink.basead.ui.thirdparty.ThirdPartySelfRenderScreenATView;
import com.anythink.basead.ui.thirdparty.ThirdPartySplashATView;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.l.e.a.g;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.anythink.core.common.l.e.a.a {
    private static final String a = "b";
    private com.anythink.basead.mixad.c.a.a b;

    public b(com.anythink.basead.mixad.c.a.a aVar) {
        this.b = aVar;
    }

    public b(com.anythink.core.common.l.d.a aVar) {
        if (aVar == null) {
            return;
        }
        BaseAd baseAdB = aVar.b();
        if (baseAdB instanceof com.anythink.core.common.l.g.d) {
            Context contextA = aVar.a();
            ATNativeAdCustomRender aTNativeAdCustomRenderC = aVar.c();
            com.anythink.core.common.l.g.d dVar = (com.anythink.core.common.l.g.d) baseAdB;
            com.anythink.basead.mixad.e.a aVar2 = new com.anythink.basead.mixad.e.a(dVar);
            com.anythink.basead.mixad.e.b bVar = new com.anythink.basead.mixad.e.b(dVar, aVar.g(), aVar.e());
            com.anythink.basead.mixad.c.a.a.C0045a c0045aA = new com.anythink.basead.mixad.c.a.a.C0045a().a(contextA);
            c cVar = new c(baseAdB);
            cVar.a(new a(baseAdB));
            cVar.a(aTNativeAdCustomRenderC);
            this.b = c0045aA.a(cVar).a(aVar2).a(bVar).b(aVar.h()).a(aVar.d()).b(aVar.j()).c(aVar.k()).a();
        }
    }

    private static ATNativeAdInfo a(ATNativeAdCustomRender aTNativeAdCustomRender, BaseAd baseAd) {
        c cVar = new c(baseAd);
        cVar.a(new a(baseAd));
        cVar.a(aTNativeAdCustomRender);
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x014a  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.common.l.e.a.a
    public final com.anythink.core.common.l.e.a.c a() {
        int i;
        com.anythink.basead.mixad.e.c cVar;
        int iC;
        boolean zA;
        int iB;
        com.anythink.core.common.l.a aVarA;
        byte b;
        com.anythink.core.common.l.e.a.c thirdPartyHalfScreenATView;
        com.anythink.basead.mixad.c.a.a aVar;
        byte b2;
        int iA;
        com.anythink.basead.mixad.c.a.a aVar2 = this.b;
        if (aVar2 == null) {
            return null;
        }
        try {
            x xVarB = aVar2.b();
            w<?> wVarC = this.b.c();
            Context contextJ = this.b.j();
            int iF = this.b.f();
            String strE = this.b.e();
            Object[] objArr = new Object[2];
            if (contextJ != null && xVarB != null && wVarC != null) {
                if (contextJ instanceof Activity) {
                    contextJ = (Context) new WeakReference(contextJ).get();
                }
                Context context = contextJ;
                if (xVarB.o instanceof com.anythink.basead.mixad.e.c) {
                    cVar = (com.anythink.basead.mixad.e.c) xVarB.o;
                    zA = cVar.a();
                    iB = cVar.b();
                    iC = cVar.c();
                } else {
                    cVar = null;
                    iC = 2;
                    zA = true;
                    iB = 1;
                }
                i = xVarB.j;
                try {
                    g gVar = (g) this.b.a();
                    BaseAd baseAdA = gVar.a();
                    com.anythink.basead.mixad.shake.a aVar3 = new com.anythink.basead.mixad.shake.a(context, baseAdA, cVar);
                    gVar.a(aVar3);
                    ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                    if (aTNativeAdCustomRenderD != null && !zA) {
                        View viewI = this.b.i();
                        View mediationViewFromNativeAd = viewI == null ? aTNativeAdCustomRenderD.getMediationViewFromNativeAd(gVar, l.a(baseAdA, gVar.b())) : viewI;
                        if (mediationViewFromNativeAd != null) {
                            Object[] objArr2 = new Object[1];
                            ThirdPartySelfRenderScreenATView thirdPartySelfRenderScreenATView = new ThirdPartySelfRenderScreenATView(context, xVarB, wVarC, strE, i, iF, baseAdA, mediationViewFromNativeAd, gVar.c());
                            if (String.valueOf(i).equals("2") || String.valueOf(i).equals("4")) {
                                thirdPartySelfRenderScreenATView.setMixNativeAdEventListener(this.b.h());
                                thirdPartySelfRenderScreenATView.init();
                            }
                            Object[] objArr3 = new Object[1];
                            return thirdPartySelfRenderScreenATView;
                        }
                    }
                    String strValueOf = String.valueOf(i);
                    if (iC == 1) {
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
                        if (b2 == 0 || b2 == 1) {
                            iA = q.a(context, 148.0f);
                        } else {
                            iA = b2 != 2 ? 0 : q.a(context, 50.0f);
                        }
                        aVarA = aVar3.a(iA, iA, null);
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
                        default:
                            b = -1;
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
                    }
                    if (b == 0) {
                        Object[] objArr4 = new Object[1];
                        Integer.valueOf(iB);
                        if (iB == 1) {
                            thirdPartyHalfScreenATView = new ThirdPartyFullScreenATView(context, xVarB, wVarC, strE, i, iF, baseAdA, aVarA);
                        } else {
                            thirdPartyHalfScreenATView = new ThirdPartyHalfScreenATView(context, xVarB, wVarC, strE, i, iF, baseAdA, aVarA);
                        }
                        return thirdPartyHalfScreenATView;
                    }
                    if (b == 1) {
                        com.anythink.basead.mixad.c.a.a aVar4 = this.b;
                        if (aVar4 != null) {
                            com.anythink.core.common.l.e.a.b bVarH = aVar4.h();
                            ThirdPartySplashATView thirdPartySplashATView = new ThirdPartySplashATView(context, xVarB, wVarC, new AnonymousClass2(bVarH), "", baseAdA, aVarA);
                            baseAdA.setNativeEventListener(new AnonymousClass3(new boolean[]{false}, bVarH, thirdPartySplashATView));
                            thirdPartySplashATView.setDontCountDown(aVar4.g());
                            return thirdPartySplashATView;
                        }
                    } else if (b == 2) {
                        com.anythink.basead.mixad.c.a.a aVar5 = this.b;
                        if (aVar5 != null) {
                            com.anythink.core.common.l.e.a.b bVarH2 = aVar5.h();
                            ThirdPartyBannerATView thirdPartyBannerATView = new ThirdPartyBannerATView(context, baseAdA, xVarB, wVarC, new AnonymousClass4(bVarH2));
                            baseAdA.setNativeEventListener(new AnonymousClass5(new boolean[]{false}, bVarH2, thirdPartyBannerATView));
                            return thirdPartyBannerATView;
                        }
                    } else if (b == 3 && (aVar = this.b) != null) {
                        ThirdPartyNativeTemplateView thirdPartyNativeTemplateView = new ThirdPartyNativeTemplateView(context, wVarC, xVarB, true, new AnonymousClass6(aVar.h()), baseAdA);
                        thirdPartyNativeTemplateView.init(aVar.k(), aVar.l(), xVarB.o.bg());
                        thirdPartyNativeTemplateView.setLayoutParams(new ViewGroup.LayoutParams(thirdPartyNativeTemplateView.getMediaViewWidth(), thirdPartyNativeTemplateView.getMediaViewHeight()));
                        return thirdPartyNativeTemplateView;
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    e.b("createView error:".concat(String.valueOf(i)), th.getMessage() + ", " + q.a(th.getStackTrace()), t.b().r());
                    Object[] objArr5 = new Object[1];
                    th.getStackTrace()[0].toString();
                    return null;
                }
            }
            Object[] objArr6 = new Object[3];
            return null;
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007d  */
    @Override // com.anythink.core.common.l.e.a.a
    public final void a(Activity activity, com.anythink.core.basead.b.c cVar, com.anythink.core.common.l.e.a.a.InterfaceC0086a interfaceC0086a) {
        com.anythink.basead.mixad.c.a.a aVar;
        boolean z;
        View mediationViewFromNativeAd;
        if (activity == null || cVar == null || (aVar = this.b) == null) {
            return;
        }
        cVar.c = aVar.c();
        cVar.h = this.b.b();
        final String str = cVar.d;
        final com.anythink.core.common.l.e.a.b bVarH = this.b.h();
        com.anythink.basead.g.b.a().a(str, new com.anythink.basead.g.b.AbstractC0044b() { // from class: com.anythink.basead.mixad.c.b.1
            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void c() {
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(j jVar) {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdImpressed();
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(f fVar) {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    if (fVar != null) {
                        bVar.onVideoError(fVar.a(), fVar.b());
                    } else {
                        bVar.onVideoError("", "");
                    }
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a() {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdVideoStart();
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b() {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onAdVideoEnd();
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void d() {
                com.anythink.basead.g.b.a().b(str);
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onClose();
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b(j jVar) {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if ((bVar instanceof com.anythink.core.common.l.e.a) && jVar != null) {
                    ((com.anythink.core.common.l.e.a) bVar).setClickedArea(jVar.b);
                }
                com.anythink.core.common.l.e.a.b bVar2 = bVarH;
                if (bVar2 != null) {
                    bVar2.onAdClicked(null);
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(boolean z2) {
                com.anythink.core.common.l.e.a.b bVar = bVarH;
                if (bVar != null) {
                    bVar.onDeeplinkCallback(z2);
                }
            }
        });
        com.anythink.basead.mixad.a.a().a(str, interfaceC0086a);
        com.anythink.basead.mixad.a.a().a(str, this.b);
        com.anythink.basead.mixad.c.a.a aVar2 = this.b;
        if (aVar2 != null) {
            x xVarB = aVar2.b();
            if (!(xVarB.o instanceof com.anythink.basead.mixad.e.c) || ((com.anythink.basead.mixad.e.c) xVarB.o).a()) {
                z = false;
            } else {
                ATNativeAdInfo aTNativeAdInfoA = aVar2.a();
                if (aTNativeAdInfoA instanceof g) {
                    g gVar = (g) aTNativeAdInfoA;
                    BaseAd baseAdA = gVar.a();
                    ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                    if (aTNativeAdCustomRenderD == null || (mediationViewFromNativeAd = aTNativeAdCustomRenderD.getMediationViewFromNativeAd(aTNativeAdInfoA, l.a(baseAdA, gVar.b()))) == null) {
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
                return q.a(context, 50.0f);
            case "3":
            case "4":
                return q.a(context, 148.0f);
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mixad.c.b$2, reason: invalid class name */
    final class AnonymousClass2 extends h {
        final /* synthetic */ com.anythink.core.common.l.e.a.b a;

        AnonymousClass2(com.anythink.core.common.l.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.basead.g.h, com.anythink.basead.g.a
        public final void onAdClosed() {
            com.anythink.core.common.l.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onClose();
            }
        }

        @Override // com.anythink.basead.g.h, com.anythink.basead.g.a
        public final void onShowFailed(f fVar) {
            com.anythink.core.common.l.e.a.b bVar = this.a;
            if (bVar != null) {
                if (fVar != null) {
                    bVar.onVideoError(fVar.a(), fVar.b());
                } else {
                    bVar.onVideoError("", "");
                }
            }
        }
    }

    private com.anythink.core.common.l.e.a.c a(com.anythink.basead.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w wVar, com.anythink.core.common.l.a aVar2) {
        if (aVar == null) {
            return null;
        }
        com.anythink.core.common.l.e.a.b bVarH = aVar.h();
        ThirdPartySplashATView thirdPartySplashATView = new ThirdPartySplashATView(context, xVar, wVar, new AnonymousClass2(bVarH), "", baseAd, aVar2);
        baseAd.setNativeEventListener(new AnonymousClass3(new boolean[]{false}, bVarH, thirdPartySplashATView));
        thirdPartySplashATView.setDontCountDown(aVar.g());
        return thirdPartySplashATView;
    }

    /* JADX INFO: renamed from: com.anythink.basead.mixad.c.b$3, reason: invalid class name */
    final class AnonymousClass3 extends i {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ com.anythink.core.common.l.e.a.b b;
        final /* synthetic */ ThirdPartySplashATView c;

        AnonymousClass3(boolean[] zArr, com.anythink.core.common.l.e.a.b bVar, ThirdPartySplashATView thirdPartySplashATView) {
            this.a = zArr;
            this.b = bVar;
            this.c = thirdPartySplashATView;
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onAdImpressed();
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdClicked(View view) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onAdClicked(null);
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdVideoStart() {
            this.c.disableHWVideoViewClickable();
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mixad.c.b$4, reason: invalid class name */
    final class AnonymousClass4 extends h {
        final /* synthetic */ com.anythink.core.common.l.e.a.b a;

        AnonymousClass4(com.anythink.core.common.l.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.basead.g.h, com.anythink.basead.g.a
        public final void onAdClosed() {
            com.anythink.core.common.l.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onClose();
            }
        }
    }

    private com.anythink.core.common.l.e.a.c a(com.anythink.basead.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w<?> wVar) {
        if (aVar == null) {
            return null;
        }
        com.anythink.core.common.l.e.a.b bVarH = aVar.h();
        ThirdPartyBannerATView thirdPartyBannerATView = new ThirdPartyBannerATView(context, baseAd, xVar, wVar, new AnonymousClass4(bVarH));
        baseAd.setNativeEventListener(new AnonymousClass5(new boolean[]{false}, bVarH, thirdPartyBannerATView));
        return thirdPartyBannerATView;
    }

    /* JADX INFO: renamed from: com.anythink.basead.mixad.c.b$5, reason: invalid class name */
    final class AnonymousClass5 extends i {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ com.anythink.core.common.l.e.a.b b;
        final /* synthetic */ ThirdPartyBannerATView c;

        AnonymousClass5(boolean[] zArr, com.anythink.core.common.l.e.a.b bVar, ThirdPartyBannerATView thirdPartyBannerATView) {
            this.a = zArr;
            this.b = bVar;
            this.c = thirdPartyBannerATView;
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onAdImpressed();
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdClicked(View view) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                if (bVar instanceof com.anythink.core.common.l.e.a) {
                    ((com.anythink.core.common.l.e.a) bVar).setClickedArea(this.c.getClickedArea());
                }
                this.b.onAdClicked(null);
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
            }
        }

        @Override // com.anythink.core.common.d.i, com.anythink.core.common.d.o
        public final void onAdDislikeButtonClick() {
            super.onAdDislikeButtonClick();
            com.anythink.core.common.l.e.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onClose();
            }
        }
    }

    private com.anythink.core.common.l.e.a.c b(com.anythink.basead.mixad.c.a.a aVar, BaseAd baseAd, Context context, x xVar, w<?> wVar) {
        if (aVar == null) {
            return null;
        }
        ThirdPartyNativeTemplateView thirdPartyNativeTemplateView = new ThirdPartyNativeTemplateView(context, wVar, xVar, true, new AnonymousClass6(aVar.h()), baseAd);
        thirdPartyNativeTemplateView.init(aVar.k(), aVar.l(), xVar.o.bg());
        thirdPartyNativeTemplateView.setLayoutParams(new ViewGroup.LayoutParams(thirdPartyNativeTemplateView.getMediaViewWidth(), thirdPartyNativeTemplateView.getMediaViewHeight()));
        return thirdPartyNativeTemplateView;
    }

    /* JADX INFO: renamed from: com.anythink.basead.mixad.c.b$6, reason: invalid class name */
    final class AnonymousClass6 implements BaseMediaATView.a {
        final /* synthetic */ com.anythink.core.common.l.e.a.b a;

        AnonymousClass6(com.anythink.core.common.l.e.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.anythink.basead.ui.BaseMediaATView.a
        public final void onClickCloseView() {
            com.anythink.core.common.l.e.a.b bVar = this.a;
            if (bVar != null) {
                bVar.onAdDislikeButtonClick();
            }
        }
    }

    private static boolean a(com.anythink.basead.mixad.c.a.a aVar) {
        View mediationViewFromNativeAd;
        if (aVar == null) {
            return false;
        }
        x xVarB = aVar.b();
        if ((xVarB.o instanceof com.anythink.basead.mixad.e.c) && !((com.anythink.basead.mixad.e.c) xVarB.o).a()) {
            ATNativeAdInfo aTNativeAdInfoA = aVar.a();
            if (aTNativeAdInfoA instanceof g) {
                g gVar = (g) aTNativeAdInfoA;
                BaseAd baseAdA = gVar.a();
                ATNativeAdCustomRender aTNativeAdCustomRenderD = gVar.d();
                if (aTNativeAdCustomRenderD != null && (mediationViewFromNativeAd = aTNativeAdCustomRenderD.getMediationViewFromNativeAd(aTNativeAdInfoA, l.a(baseAdA, gVar.b()))) != null) {
                    aVar.a(mediationViewFromNativeAd);
                    return true;
                }
            }
        }
        return false;
    }
}
