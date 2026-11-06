package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mcto.sspsdk.IQyAppComplianceInfo;
import com.mcto.sspsdk.IQyAppDownloadListener;
import com.mcto.sspsdk.IQyNativeAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyImage;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n3 implements IQyNativeAd {
    public final Context a;
    public final QyAdSlot b;
    public View c;
    public final p d;
    public final JSONObject e;
    public final sd f;
    public final sd g;
    public ViewGroup h;
    public d8 k;
    public final u0 m;
    public IQyNativeAd.IQyNativeAdInteractionListener o;
    public IQyAppDownloadListener p;
    public IQyNativeAd.IQyVideoAdListener q;
    public l3 r;
    public s0 u;
    public final j3 v;
    public m3 w;
    public volatile int i = 0;
    public u5 j = null;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public boolean n = false;
    public float s = -999.0f;
    public float t = -999.0f;

    static {
        new g3();
    }

    public n3(Context context, QyAdSlot qyAdSlot, p pVar) {
        j3 j3Var = new j3(this);
        this.v = j3Var;
        this.b = qyAdSlot;
        this.d = pVar;
        pVar.t0 = 1;
        this.a = context;
        JSONObject jSONObjectI = pVar.i();
        this.e = jSONObjectI;
        this.f = new sd(pVar.h());
        String strOptString = jSONObjectI.optString("appIcon");
        if (!TextUtils.isEmpty(strOptString)) {
            this.g = new sd(gj.c(strOptString));
        }
        if (j.b(3, pVar.S0) && j.b(3, pVar.S0)) {
            t0 t0Var = new t0();
            t0Var.i = pVar.i().optString("apkName");
            t0Var.d = pVar.E;
            u0 u0Var = new u0(t0Var);
            this.m = u0Var;
            this.u = c1.a().a(u0Var, j3Var);
        }
    }

    public abstract void a();

    public final void a(List list, z3 z3Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view != null) {
                view.setOnTouchListener(new h3(this));
                view.setOnClickListener(new i3(this, z3Var));
            }
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public void destroy() {
        u5 u5Var = this.j;
        if (u5Var != null) {
            u5Var.b();
            ViewGroup viewGroup = this.h;
            if (viewGroup != null) {
                viewGroup.removeView(this.j);
            }
        }
        if (this.m != null) {
            c1.a().b(this.m, this.v);
        }
        setActionStop();
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final int getActionType() {
        p pVar = this.d;
        return (pVar.w0 == 4 || pVar.L0.q == 1) ? 4 : 0;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final Map getAdExtra() {
        return this.d.j();
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final View getAdView() {
        return this.c;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final IQyAppComplianceInfo getAppComplianceInfo() {
        if (!this.d.p()) {
            return null;
        }
        p pVar = this.d;
        return new f4(pVar.P, pVar.H0);
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public String getButtonText() {
        return this.d.g();
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final int getClickThroughType() {
        switch (this.d.S0) {
            case 1:
                return -1;
            case 2:
                return 0;
            case 3:
                return 11;
            case 4:
                return 14;
            case 5:
                return 67;
            default:
                throw null;
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final QyImage getCoverImage() {
        return this.f;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final String getDspName() {
        return this.d.g0;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final long getDuration() {
        return this.d.h;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final int getHeight() {
        return this.e.optInt("height");
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final QyImage getIcon() {
        return this.g;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final String getName() {
        return this.d.P;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final int getTemplateType() {
        return this.d.s0;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final String getTitle() {
        return this.e.optString(BundleKey.TITLE);
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final int getWidth() {
        return this.e.optInt("width");
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, List list3, View view, IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener) {
        if (viewGroup == null || list == null) {
            throw new IllegalArgumentException("container和clickViews不能为空");
        }
        this.h = viewGroup;
        if (this.j == null) {
            d8 d8Var = new d8();
            d8Var.a = viewGroup;
            d8Var.c = 100;
            d8Var.b = 50;
            this.k = d8Var;
            u5 u5Var = new u5(this.a, this.k);
            this.j = u5Var;
            u5Var.f = new f3(this);
            viewGroup.addView(u5Var);
        }
        u5 u5Var2 = this.j;
        u5Var2.a = true;
        if (!u5Var2.b) {
            u5Var2.a();
        }
        a(list, z3.GRAPHIC);
        a(list2, z3.BUTTON);
        a(list3, z3.DIRECT_ACTION_BTN);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        a(arrayList, z3.NEGATIVE);
        this.o = iQyNativeAdInteractionListener;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final synchronized void setActionStart() {
        r9.a("ssp_native_ad", this.d, "setActionStart 1");
        if (!this.n && getActionType() == 4) {
            e eVar = this.d.L0;
            if (this.w == null) {
                this.w = new m3(this, eVar.q == 1);
            }
            this.n = true;
            if (eVar.q == 1) {
                qh qhVarA = qh.a();
                int i = eVar.l;
                float f = eVar.m;
                int i2 = eVar.n;
                qhVarA.g = i;
                qhVarA.i = Math.max(i2, 1);
                qhVarA.h = f;
            } else {
                qh qhVarA2 = qh.a();
                qhVarA2.g = 1000;
                qhVarA2.h = 12.0f;
                qhVarA2.i = 1;
            }
            r9.a("ssp_native_ad", this.d, "setActionStart 2");
            qh.a().a(this.w);
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final synchronized void setActionStop() {
        r9.a("ssp_native_ad", this.d, "setActionStop 1");
        if (this.n && this.w != null) {
            this.n = false;
            qh.a().b(this.w);
            r9.a("ssp_native_ad", this.d, "setActionStop 2");
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final void setActivityForDownloadApp(Activity activity) {
        new WeakReference(activity);
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final void setAppVideoAdListener(IQyNativeAd.IQyVideoAdListener iQyVideoAdListener) {
        this.q = iQyVideoAdListener;
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final void setDownloadListener(IQyAppDownloadListener iQyAppDownloadListener) {
        if (j.b(3, this.d.S0)) {
            this.p = iQyAppDownloadListener;
            kh.a.a(new k3(this, this.u));
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public void setMute(boolean z) {
    }

    public void a(View view) {
        HashMap map = new HashMap(1);
        map.put(v5.KEY_CLICK_AREA, z3.NEGATIVE);
        l lVarA = l.a();
        p pVar = this.d;
        lVarA.getClass();
        l.a(21, pVar, map);
        if (this.d.o()) {
            l lVarA2 = l.a();
            p pVar2 = this.d;
            lVarA2.getClass();
            l.a(17, pVar2, null);
        }
        IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener = this.o;
        if (iQyNativeAdInteractionListener != null) {
            iQyNativeAdInteractionListener.onAdClose(this);
        }
    }

    @Override // com.mcto.sspsdk.IQyNativeAd
    public final void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, View view, IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener) {
        registerViewForInteraction(viewGroup, list, list2, null, view, iQyNativeAdInteractionListener);
    }

    public static void a(n3 n3Var, z3 z3Var, View view) {
        IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener;
        r9.a("ssp_native_ad", "setOnGenericMotionListener: ", Integer.valueOf(n3Var.d.a));
        if (z3Var.equals(z3.NEGATIVE)) {
            n3Var.a(view);
            return;
        }
        if (n3Var.d.m()) {
            n3Var.l.set(true);
            a4 a4Var = new a4();
            a4Var.b = z3Var;
            a4Var.a = view;
            a4Var.e = gj.a(view);
            u5 u5Var = n3Var.j;
            float f = u5Var.g;
            float f2 = u5Var.h;
            a4Var.h = f;
            a4Var.i = f2;
            a4Var.j = f;
            a4Var.k = f2;
            b4 b4Var = new b4(a4Var.a(n3Var.s, n3Var.t));
            s0 s0Var = n3Var.u;
            if (s0Var != null) {
                b4Var.a(s0Var.a);
                b4Var.k = n3Var.u.c;
            }
            HashMap mapA = gj.a(b4Var, n3Var.h);
            int iIntValue = -1;
            if (n3Var.b.getAdType() == 2) {
                p pVar = n3Var.d;
                z3 z3Var2 = z3.SHAKE_TEMPLATE;
                z3 z3Var3 = b4Var.a;
                if (z3Var3 == null) {
                    z3Var3 = z3.GRAPHIC;
                }
                iIntValue = pVar.c(z3Var2 == z3Var3 ? 4 : 0).intValue();
            }
            l lVarA = l.a();
            p pVar2 = n3Var.d;
            lVarA.getClass();
            l.a(21, pVar2, mapA);
            n3Var.d.d0 = n3Var.b.isAutoDownloadInLandingPage();
            if (y3.a(n3Var.a, n3Var.d, b4Var) == 4) {
                l lVarA2 = l.a();
                p pVar3 = n3Var.d;
                lVarA2.getClass();
                l.a(25, pVar3, null);
            }
            if (iIntValue == 0 || (iQyNativeAdInteractionListener = n3Var.o) == null) {
                return;
            }
            iQyNativeAdInteractionListener.onAdClicked(view, n3Var);
        }
    }
}
