package com.anythink.basead.f.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.g.j;
import com.anythink.basead.g.k;
import com.anythink.basead.ui.AsseblemCardSplashATView;
import com.anythink.basead.ui.AsseblemSplashATView;
import com.anythink.basead.ui.BaseATActivity;
import com.anythink.basead.ui.BaseBannerATView;
import com.anythink.basead.ui.BaseSdkSplashATView;
import com.anythink.basead.ui.BaseSplashATView;
import com.anythink.basead.ui.MraidBannerATView;
import com.anythink.basead.ui.MraidSplashATView;
import com.anythink.basead.ui.SdkBannerATView;
import com.anythink.basead.ui.SinglePictureBottomSlideSplashATView;
import com.anythink.basead.ui.SinglePictureSplashATView;
import com.anythink.basead.ui.h5template.WTWebViewSplashATView;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {
    bj a;
    x b;
    com.anythink.basead.g.a c;
    BaseSplashATView d;
    BaseBannerATView e;

    public a(bj bjVar, x xVar) {
        this.a = bjVar;
        this.b = xVar;
    }

    @Override // com.anythink.basead.f.b.c
    public final boolean a() {
        bj bjVar = this.a;
        if (bjVar == null) {
            return false;
        }
        if (bjVar.m() != 2 || this.a.ag()) {
            return com.anythink.basead.b.c.d.a(this.a, this.b);
        }
        return false;
    }

    @Override // com.anythink.basead.f.b.c
    public final void a(com.anythink.basead.g.a aVar) {
        this.c = aVar;
    }

    @Override // com.anythink.basead.f.b.c
    public final void b() {
        BaseSplashATView baseSplashATView = this.d;
        if (baseSplashATView != null) {
            baseSplashATView.destroy();
            this.d = null;
        }
        BaseBannerATView baseBannerATView = this.e;
        if (baseBannerATView != null) {
            baseBannerATView.destroy();
            this.e = null;
        }
    }

    @Override // com.anythink.basead.f.b.c
    public final void a(Activity activity, Map<String, Object> map, int i, final String str, String str2, String str3) {
        com.anythink.basead.g.b.a().a(str, new com.anythink.basead.g.b.AbstractC0044b(map, str3) { // from class: com.anythink.basead.f.b.a.1
            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(j jVar) {
                if (a.this.c != null) {
                    a.this.c.onAdShow(jVar);
                }
                a.this.a = null;
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(f fVar) {
                if (a.this.c != null) {
                    a.this.c.onShowFailed(fVar);
                }
                a.this.a = null;
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a() {
                if (a.this.c == null || !(a.this.c instanceof k)) {
                    return;
                }
                ((k) a.this.c).onVideoAdPlayStart();
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b() {
                if (a.this.c == null || !(a.this.c instanceof k)) {
                    return;
                }
                ((k) a.this.c).onVideoAdPlayEnd();
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void c() {
                if (a.this.c == null || !(a.this.c instanceof k)) {
                    return;
                }
                ((k) a.this.c).onRewarded();
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void d() {
                super.d();
                if (a.this.c != null) {
                    a.this.c.onAdClosed();
                }
                com.anythink.basead.g.b.a().b(str);
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b(j jVar) {
                if (a.this.c != null) {
                    a.this.c.onAdClick(jVar);
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(boolean z) {
                if (a.this.c != null) {
                    a.this.c.onDeeplinkCallback(z);
                }
            }
        });
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        cVar.c = this.a;
        cVar.d = str;
        cVar.a = 1;
        cVar.h = this.b;
        cVar.e = i;
        cVar.b = str2;
        BaseATActivity.a(activity, cVar);
    }

    @Override // com.anythink.basead.f.b.c
    public final void b(Activity activity, Map<String, Object> map, int i, final String str, String str2, String str3) {
        com.anythink.basead.g.b.a().a(str, new com.anythink.basead.g.b.AbstractC0044b(map, str3) { // from class: com.anythink.basead.f.b.a.2
            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void c() {
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(j jVar) {
                if (a.this.c != null) {
                    a.this.c.onAdShow(jVar);
                }
                a.this.a = null;
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(f fVar) {
                if (a.this.c != null) {
                    a.this.c.onShowFailed(fVar);
                }
                a.this.a = null;
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a() {
                if (a.this.c == null || !(a.this.c instanceof k)) {
                    return;
                }
                ((k) a.this.c).onVideoAdPlayStart();
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b() {
                if (a.this.c == null || !(a.this.c instanceof k)) {
                    return;
                }
                ((k) a.this.c).onVideoAdPlayEnd();
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void d() {
                super.d();
                if (a.this.c != null) {
                    a.this.c.onAdClosed();
                }
                com.anythink.basead.g.b.a().b(str);
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void b(j jVar) {
                if (a.this.c != null) {
                    a.this.c.onAdClick(jVar);
                }
            }

            @Override // com.anythink.basead.g.b.AbstractC0044b
            public final void a(boolean z) {
                if (a.this.c != null) {
                    a.this.c.onDeeplinkCallback(z);
                }
            }
        });
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        cVar.c = this.a;
        cVar.d = str;
        cVar.a = 3;
        cVar.h = this.b;
        cVar.e = i;
        cVar.b = str2;
        BaseATActivity.a(activity, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x0077  */
    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    @Override // com.anythink.basead.f.b.c
    public final void a(ViewGroup viewGroup, Map<String, Object> map, boolean z) {
        int iAo = this.a.ao();
        if (iAo == 2) {
            this.d = new MraidSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
        } else if (iAo == 3) {
            if (com.anythink.basead.b.c.d.b(this.a)) {
                this.d = new WTWebViewSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
            } else {
                if (this.a.r().bC() != 1) {
                    com.anythink.basead.g.a aVar = this.c;
                    if (aVar != null) {
                        aVar.onShowFailed(g.a(g.k, "Splash show without h5 template html!"));
                        return;
                    }
                    return;
                }
                if (BaseSdkSplashATView.isSinglePicture(this.a, this.b.o)) {
                    if (this.b.o.bu() != 2 && this.b.o.A() != 2) {
                        this.d = new SinglePictureBottomSlideSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                    } else {
                        this.d = new SinglePictureSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                    }
                } else if (this.b.o.bt() != 2 && this.b.o.A() != 2) {
                    this.d = new AsseblemCardSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                } else {
                    this.d = new AsseblemSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                }
            }
        } else if (BaseSdkSplashATView.isSinglePicture(this.a, this.b.o)) {
            if (this.b.o.bu() != 2) {
                this.d = new SinglePictureSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
            } else {
                this.d = new SinglePictureSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
            }
        } else if (this.b.o.bt() != 2) {
            this.d = new AsseblemSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
        } else {
            this.d = new AsseblemSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
        }
        this.d.setAdExtraInfoMap(map);
        this.d.setDontCountDown(z);
        viewGroup.addView(this.d, -1, -1);
    }

    @Override // com.anythink.basead.f.b.c
    public final View a(Context context) {
        if (this.e == null && a()) {
            if (this.a.n()) {
                this.e = new MraidBannerATView(context, this.b, this.a, this.c);
            } else {
                this.e = new SdkBannerATView(context, this.b, this.a, this.c);
            }
        }
        return this.e;
    }

    @Override // com.anythink.basead.f.b.c
    public final com.anythink.basead.f.b.a.d a(Context context, bj bjVar, x xVar, boolean z) {
        if (z) {
            return new com.anythink.basead.f.b.a.c(context, bjVar, xVar, z);
        }
        return new com.anythink.basead.f.b.a.b(context, bjVar, xVar, z);
    }
}
