package com.anythink.basead.k;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.g;
import com.anythink.basead.f.b.d;
import com.anythink.basead.g.j;
import com.anythink.basead.g.k;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.basead.f.b.c, d {
    com.anythink.basead.g.a a;
    com.anythink.basead.f.b.a.d b;
    private IMultiAdObject c;

    @Override // com.anythink.basead.f.b.c
    public final View a(Context context) {
        return null;
    }

    public a(IMultiAdObject iMultiAdObject) {
        this.c = iMultiAdObject;
    }

    @Override // com.anythink.basead.f.b.c
    public final boolean a() {
        return this.c != null;
    }

    @Override // com.anythink.basead.f.b.c
    public final void a(com.anythink.basead.g.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.f.b.c
    public final void b() {
        this.c.destroy();
        this.c = null;
    }

    @Override // com.anythink.basead.f.b.c
    public final void a(Activity activity, Map<String, Object> map, int i, String str, String str2, String str3) {
        IMultiAdObject iMultiAdObject;
        if (activity != null && (iMultiAdObject = this.c) != null) {
            iMultiAdObject.showRewardVideo(activity, new AdRequestParam.ADRewardVideoListener() { // from class: com.anythink.basead.k.a.1
                private static void g() {
                }

                private void a() {
                    if (a.this.a != null) {
                        a.this.a.onAdShow(new j());
                    }
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onVideoAdPlayStart();
                }

                private void b() {
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onAdClick(new j());
                }

                private void c() {
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onAdClosed();
                }

                private void d() {
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onVideoAdPlayEnd();
                }

                private void e() {
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onShowFailed(g.a("", "Callback VideoError"));
                }

                private void f() {
                    if (a.this.a == null || !(a.this.a instanceof k)) {
                        return;
                    }
                    ((k) a.this.a).onRewarded();
                }
            });
            return;
        }
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onShowFailed(g.a("", "DSP Model is empty"));
        }
    }

    @Override // com.anythink.basead.f.b.c
    public final void b(Activity activity, Map<String, Object> map, int i, String str, String str2, String str3) {
        IMultiAdObject iMultiAdObject;
        if (activity != null && (iMultiAdObject = this.c) != null) {
            iMultiAdObject.showInteractionAd(activity, new AdRequestParam.ADInteractionListener() { // from class: com.anythink.basead.k.a.2
                private void a() {
                    if (a.this.a != null) {
                        a.this.a.onAdClosed();
                    }
                }

                private void b() {
                    if (a.this.a != null) {
                        a.this.a.onAdClick(new j());
                    }
                }

                private void c() {
                    if (a.this.a != null) {
                        a.this.a.onAdShow(new j());
                    }
                }

                private void a(String str4) {
                    if (a.this.a != null) {
                        a.this.a.onShowFailed(g.a("", "Callback VideoError,".concat(String.valueOf(str4))));
                    }
                }
            });
            return;
        }
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onShowFailed(g.a("", "DSP Model is empty"));
        }
    }

    @Override // com.anythink.basead.f.b.c
    public final void a(ViewGroup viewGroup, final Map<String, Object> map, boolean z) {
        IMultiAdObject iMultiAdObject;
        if (viewGroup != null && (iMultiAdObject = this.c) != null) {
            iMultiAdObject.showSplashView(viewGroup, new IMultiAdObject.SplashEventListener() { // from class: com.anythink.basead.k.a.3
                private void a() {
                    if (a.this.a != null) {
                        a.this.a.onAdClick(new j());
                    }
                }

                private void b() {
                    if (a.this.a != null) {
                        a.this.a.onAdShow(new j());
                    }
                }

                private void c() {
                    map.put(com.anythink.core.common.a.b.C0077b.a, 1);
                    if (a.this.a != null) {
                        a.this.a.onAdClosed();
                    }
                }

                private void d() {
                    map.put(com.anythink.core.common.a.b.C0077b.a, 2);
                    if (a.this.a != null) {
                        a.this.a.onAdClosed();
                    }
                }
            });
            return;
        }
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.anythink.basead.f.b.c
    public final com.anythink.basead.f.b.a.d a(Context context, bj bjVar, x xVar, boolean z) {
        com.anythink.basead.f.b.a.d dVar = this.b;
        return dVar == null ? new c(context, this.c, bjVar, xVar, z) : dVar;
    }
}
