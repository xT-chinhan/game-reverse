package com.smartdigimkt.g1;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationAsseblemSplashATView;
import com.smartdigimkt.china.formatbusiness.ui.BubbleVibrationSinglePictureSplashATView;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipAsseblemSplashATView;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipSinglePictureSplashATView;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.j1.e;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.sdk.basead.ui.AsseblemCardSplashATView;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;
import com.smartdigimkt.sdk.basead.ui.BaseATActivity;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureBottomSlideSplashATView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;
import com.smartdigimkt.z.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public l a;
    public final com.smartdigimkt.a3.a b;
    public com.smartdigimkt.j1.a c;
    public BaseSplashATView d;
    public SdkBannerATView e;

    public c(l lVar, com.smartdigimkt.a3.a aVar) {
        this.a = lVar;
        this.b = aVar;
    }

    public final void a(Activity activity, Map map, String str, String str2, String str3) {
        e eVar = com.smartdigimkt.j1.b.a;
        eVar.a.put(str, new b(this, map, str3, str));
        com.smartdigimkt.b3.a aVar = new com.smartdigimkt.b3.a();
        aVar.c = this.a;
        aVar.d = str;
        aVar.a = 3;
        aVar.f = this.b;
        aVar.e = h.y(activity);
        aVar.b = str2;
        if (this.a.d() == 3) {
            aVar.g = true;
        }
        BaseATActivity.a(activity, aVar);
    }

    public final void a(Activity activity, Map map, String str, String str2, String str3, boolean z) {
        e eVar = com.smartdigimkt.j1.b.a;
        eVar.a.put(str, new a(this, map, str3, str));
        com.smartdigimkt.b3.a aVar = new com.smartdigimkt.b3.a();
        aVar.c = this.a;
        aVar.d = str;
        aVar.a = 1;
        aVar.f = this.b;
        aVar.e = h.y(activity);
        aVar.b = str2;
        aVar.h = z;
        BaseATActivity.a(activity, aVar);
    }

    public final void a(ViewGroup viewGroup) {
        this.d = null;
        if (this.a.d() == 3 && s.b(this.a)) {
            this.d = new WTWebViewSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
        }
        if (c0.i(this.a, this.b) || c0.b(this.a, this.b)) {
            l lVar = this.a;
            try {
                if (c0.c(lVar, this.b) && 1 == lVar.U) {
                    int i = BubbleVibrationSinglePictureSplashATView.p0;
                    this.d = (BaseSplashATView) BubbleVibrationSinglePictureSplashATView.class.getConstructor(Context.class, com.smartdigimkt.a3.a.class, com.smartdigimkt.b3.c.class, com.smartdigimkt.j1.a.class).newInstance(viewGroup.getContext(), this.b, this.a, this.c);
                } else {
                    l lVar2 = this.a;
                    if (c0.c(lVar2, this.b) && 3 == lVar2.U) {
                        int i2 = BubbleVibrationAsseblemSplashATView.r0;
                        this.d = (BaseSplashATView) BubbleVibrationAsseblemSplashATView.class.getConstructor(Context.class, com.smartdigimkt.a3.a.class, com.smartdigimkt.b3.c.class, com.smartdigimkt.j1.a.class).newInstance(viewGroup.getContext(), this.b, this.a, this.c);
                    } else {
                        l lVar3 = this.a;
                        if (c0.e(lVar3, this.b) && 1 == lVar3.U) {
                            int i3 = LeftSkipSinglePictureSplashATView.r0;
                            this.d = (BaseSplashATView) LeftSkipSinglePictureSplashATView.class.getConstructor(Context.class, com.smartdigimkt.a3.a.class, com.smartdigimkt.b3.c.class, com.smartdigimkt.j1.a.class).newInstance(viewGroup.getContext(), this.b, this.a, this.c);
                        } else {
                            l lVar4 = this.a;
                            if (c0.e(lVar4, this.b) && 3 == lVar4.U) {
                                int i4 = LeftSkipAsseblemSplashATView.t0;
                                this.d = (BaseSplashATView) LeftSkipAsseblemSplashATView.class.getConstructor(Context.class, com.smartdigimkt.a3.a.class, com.smartdigimkt.b3.c.class, com.smartdigimkt.j1.a.class).newInstance(viewGroup.getContext(), this.b, this.a, this.c);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (this.d == null && BaseSdkSplashATView.isSinglePicture(this.a, this.b.s)) {
            com.smartdigimkt.b3.e eVar = this.b.s;
            if (eVar.l1 == 2 && eVar.m != 2) {
                this.d = new SinglePictureBottomSlideSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                return;
            } else {
                this.d = new SinglePictureSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
                return;
            }
        }
        if (this.d == null) {
            com.smartdigimkt.b3.e eVar2 = this.b.s;
            if (eVar2.k1 == 2 && eVar2.m != 2) {
                this.d = new AsseblemCardSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
            } else {
                this.d = new AsseblemSplashATView(viewGroup.getContext(), this.b, this.a, this.c);
            }
        }
    }
}
