package com.anythink.basead.k;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.f.b.a.d;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import com.qumeng.advlib.core.AppInformation;
import com.qumeng.advlib.core.IAppDownloadListener;
import com.qumeng.advlib.core.IMultiAdObject;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {
    IMultiAdObject a;
    AppInformation b;
    FrameLayout c;
    private final String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    @Override // com.anythink.basead.f.b.a.d
    protected final View H() {
        return null;
    }

    @Override // com.anythink.basead.f.a
    public final ViewGroup b() {
        return null;
    }

    public c(Context context, IMultiAdObject iMultiAdObject, bj bjVar, x xVar, boolean z) {
        Integer num;
        Integer num2;
        super(context, bjVar, xVar, z);
        this.d = getClass().getSimpleName();
        this.a = iMultiAdObject;
        this.b = iMultiAdObject.getAppInformation();
        this.c = new FrameLayout(context.getApplicationContext());
        this.i = 0;
        Pair mediaSize = this.a.getMediaSize();
        if (mediaSize != null) {
            num = (Integer) mediaSize.first;
            num2 = (Integer) mediaSize.second;
        } else {
            num = null;
            num2 = null;
        }
        int materialType = this.a.getMaterialType();
        if (materialType == 1 || materialType == 2 || materialType == 3) {
            this.z = 2;
            this.g = num.intValue();
            this.h = num2.intValue();
        } else if (materialType == 4 || materialType == 9) {
            this.z = 1;
            this.e = num.intValue();
            this.f = num2.intValue();
        }
    }

    @Override // com.anythink.basead.f.a
    public final View a(Context context, boolean z, BaseMediaATView.a aVar) {
        try {
            if (this.a == null) {
                return null;
            }
            if (this.u) {
                return this.c;
            }
            if (this.a.getMaterialType() == 4 || this.a.getMaterialType() == 9) {
                return this.a.getVideoView(this.r);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.basead.f.a
    public final void a(View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, View view2) {
        try {
            IMultiAdObject iMultiAdObject = this.a;
            if (iMultiAdObject == null) {
                Log.e(this.d, "prepare: adModel is null");
                return;
            }
            iMultiAdObject.setADStateListener(new IMultiAdObject.ADStateListener() { // from class: com.anythink.basead.k.c.1
                private void a(int i) {
                    if (i != 2 || c.this.v == null) {
                        return;
                    }
                    c.this.v.onAdClosed();
                }
            });
            IMultiAdObject.ADEventListener aDEventListener = new IMultiAdObject.ADEventListener() { // from class: com.anythink.basead.k.c.2
                private void a() {
                    if (c.this.v != null) {
                        c.this.v.onAdClick(new j());
                    }
                }

                private void b() {
                    if (c.this.v != null) {
                        c.this.v.onAdShow(new j());
                    }
                }

                private void a(String str) {
                    Log.e(c.this.d, "onAdFailed: ".concat(String.valueOf(str)));
                }
            };
            if (this.u) {
                this.a.bindView(this.c, aDEventListener);
            } else if (view instanceof ViewGroup) {
                if (list2 != null) {
                    this.a.bindEvent((ViewGroup) view, list, list2, aDEventListener);
                } else {
                    this.a.bindEvent((ViewGroup) view, list, aDEventListener);
                }
            }
            this.a.setOnMediaStateListener(new AnonymousClass3());
            this.a.setDownloadListener(new AnonymousClass4());
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void r() {
        super.r();
        this.a.destroy();
        this.a = null;
        this.c = null;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final View B() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getTwistView(this.r);
        }
        return super.B();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int D() {
        return this.e;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int E() {
        return this.f;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int x() {
        return this.g;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int y() {
        return this.h;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String h() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getQMLogo();
        }
        return super.h();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final long F() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getVideoDuration();
        }
        return super.F();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String c() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getTitle();
        }
        return super.c();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String d() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getDesc();
        }
        return super.d();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String g() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null && iMultiAdObject.getImageUrls() != null && this.a.getImageUrls().size() > 0) {
            return (String) this.a.getImageUrls().get(0);
        }
        return super.g();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String f() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getAppLogoUrl();
        }
        return super.f();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String e() {
        IMultiAdObject iMultiAdObject = this.a;
        return (iMultiAdObject == null || iMultiAdObject.getInteractionType() != 2) ? super.e() : "立即下载";
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int z() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            int interactionType = iMultiAdObject.getInteractionType();
            if (interactionType == 1) {
                return 3;
            }
            if (interactionType == 2) {
                return 4;
            }
        }
        return super.z();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String j() {
        AppInformation appInformation = this.b;
        if (appInformation != null) {
            return appInformation.getDevelopers();
        }
        return super.j();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String m() {
        AppInformation appInformation = this.b;
        if (appInformation != null) {
            return appInformation.getAppVersion();
        }
        return super.m();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String l() {
        AppInformation appInformation = this.b;
        if (appInformation != null) {
            return appInformation.getPrivacyProtocolUrl();
        }
        return super.l();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String k() {
        AppInformation appInformation = this.b;
        if (appInformation != null) {
            return appInformation.getPermissionProtocolUrl();
        }
        return super.k();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String i() {
        IMultiAdObject iMultiAdObject = this.a;
        if (iMultiAdObject != null) {
            return iMultiAdObject.getAppName();
        }
        return super.i();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final String n() {
        AppInformation appInformation = this.b;
        if (appInformation != null) {
            return appInformation.getFunctionDescUrl();
        }
        return super.n();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final boolean o() {
        IMultiAdObject iMultiAdObject = this.a;
        return iMultiAdObject != null && iMultiAdObject.getInteractionType() == 2;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final int A() {
        return this.i;
    }

    /* JADX INFO: renamed from: com.anythink.basead.k.c$3, reason: invalid class name */
    final class AnonymousClass3 implements IMultiAdObject.MediaStateListener {
        private static void a() {
        }

        private static void c() {
        }

        private static void d() {
        }

        private static void f() {
        }

        AnonymousClass3() {
        }

        private void b() {
            if (c.this.w != null) {
                c.this.w.onVideoAdStartPlay(c.this.F());
            }
        }

        private void e() {
            if (c.this.w != null) {
                c.this.w.onVideoAdComplete();
            }
        }
    }

    private void G() {
        this.a.setOnMediaStateListener(new AnonymousClass3());
        this.a.setDownloadListener(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: com.anythink.basead.k.c$4, reason: invalid class name */
    final class AnonymousClass4 implements IAppDownloadListener {
        boolean a;

        AnonymousClass4() {
        }

        private void a() {
            c.this.i = 1;
        }

        private void b() {
            c.this.i = 4;
        }

        private void c() {
            if (this.a) {
                this.a = false;
                c.this.i = 7;
            }
        }

        private void d() {
            this.a = false;
            c.this.i = 6;
        }

        private void e() {
            c.this.i = 5;
        }

        private void f() {
            c.this.i = 2;
        }
    }
}
