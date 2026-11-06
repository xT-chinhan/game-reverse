package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.js.uc;
import com.byazt.js.vk;
import com.byazt.jt.GifView;
import com.byazt.ld.g;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.mq.m;
import com.byazt.rk.fw;
import com.byazt.rk.zo;
import com.byazt.uko.aj;
import com.byazt.yhm.InteractViewContainer;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 963})
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public static String a = "";
    public volatile boolean cz;
    public Runnable hw;
    public ImageView ny;
    public Runnable pr;
    public InteractViewContainer qa;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.cz = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = zoVar.vk().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.zo - ((int) com.byazt.js.zo.pr(context, this.k.hw() + this.k.pr())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.zo - ((int) com.byazt.js.zo.pr(context, this.k.hw() + this.k.pr())));
        }
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.fw, this.zo);
    }

    @Override // com.byazt.gx.x
    public boolean zo() {
        String strHw;
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.ho == null ? this : this.ho;
        setContentDescription(this.m.pr(this.k.iu()));
        String strJ = this.k.j();
        String strB = null;
        if (!TextUtils.isEmpty(strJ) && this.g != null && this.g.getRenderRequest() != null && this.g.getRenderRequest().c() != null && (jSONObjectOptJSONObject = this.g.getRenderRequest().c().optJSONObject(ProviderInteractionViews.ROLE_CREATIVE)) != null) {
            strHw = pr(jSONObjectOptJSONObject.opt(strJ));
        } else {
            strHw = null;
        }
        if (TextUtils.isEmpty(strHw)) {
            strHw = this.k.cz();
        }
        if (this.k.a() && Build.VERSION.SDK_INT >= 17) {
            com.byazt.bg.pr.pr().c().pr(this.k.hw).hn(2).pr(new hn(this.w, this.k.qa())).pr(new hw(view, this));
        } else if (!TextUtils.isEmpty(strHw)) {
            if (!strHw.startsWith("http:") && !strHw.startsWith("https:")) {
                if (this.g != null && this.g.getRenderRequest() != null) {
                    strB = this.g.getRenderRequest().b();
                }
                strHw = aj.hw(strHw, strB);
            }
            g gVarHn = com.byazt.bg.pr.pr().c().pr(strHw).hn(2);
            pr(gVarHn);
            if (!com.byazt.dj.x.pr()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.m.vk().getType(), "vessel")) {
                    if (vk.hw(strHw)) {
                        this.ny = new GifView(this.w);
                    } else {
                        this.ny = new ImageView(this.w);
                    }
                    ((FrameLayout) view).addView(this.ny, new FrameLayout.LayoutParams(-1, -1));
                    gVarHn.hn(3).pr(new rc() { // from class: com.byazt.gx.DynamicBaseWidgetImp.1
                        @Override // com.byazt.ld.rc
                        public void pr(nt ntVar) {
                            Object objHn = ntVar.hn();
                            if (objHn instanceof byte[]) {
                                uc.hw(DynamicBaseWidgetImp.this.ny, (byte[]) objHn, DynamicBaseWidgetImp.this.fw, DynamicBaseWidgetImp.this.zo);
                            }
                        }

                        @Override // com.byazt.ld.rc
                        public void pr(int i, String str, Throwable th) {
                        }
                    }, 4);
                } else {
                    pr(gVarHn, view);
                }
            } else {
                gVarHn.pr(new pr(view, this.g, this.m));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.k.gz() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.byazt.gx.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.k.e() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableHw = dynamicBaseWidgetImp.hw(dynamicBaseWidgetImp.g.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.k.e())));
                            if (drawableHw == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableHw = dynamicBaseWidgetImp2.pr(true, dynamicBaseWidgetImp2.g.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.k.e())));
                            }
                            if (drawableHw != null) {
                                view.setBackground(drawableHw);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.pr(true, dynamicBaseWidgetImp3.g.getBgColor()));
                        }
                    } catch (Exception e) {
                    }
                }
            }, (long) (this.k.gz() * 1000.0d));
        }
        if (this.ho != null) {
            this.ho.setPadding((int) com.byazt.js.zo.pr(this.w, this.k.hn()), (int) com.byazt.js.zo.pr(this.w, this.k.hw()), (int) com.byazt.js.zo.pr(this.w, this.k.x()), (int) com.byazt.js.zo.pr(this.w, this.k.pr()));
        }
        if (this.nt || this.k.g() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, 2191})
    private static class hn implements com.byazt.ld.vk {
        public final int hw;
        public final WeakReference<Context> pr;

        public hn(Context context, int i) {
            this.pr = new WeakReference<>(context);
            this.hw = i;
        }

        @Override // com.byazt.ld.vk
        public Bitmap pr(Bitmap bitmap) {
            Context context = this.pr.get();
            if (context != null) {
                return com.byazt.js.hw.pr(context, bitmap, this.hw);
            }
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, 2182})
    private static class hw implements rc<Bitmap> {
        public final WeakReference<DynamicBaseWidget> hw;
        public final WeakReference<View> pr;

        public hw(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.pr = new WeakReference<>(view);
            this.hw = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.byazt.ld.rc
        public void pr(nt<Bitmap> ntVar) {
            Bitmap bitmapHn;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.pr.get();
            if (view != null && (bitmapHn = ntVar.hn()) != null && ntVar.x() != null && (dynamicBaseWidget = this.hw.get()) != null) {
                view.setBackground(dynamicBaseWidget.pr(bitmapHn));
            }
        }

        @Override // com.byazt.ld.rc
        public void pr(int i, String str, Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, 2273})
    private static class pr implements rc<Bitmap> {
        public final zo hn;
        public final WeakReference<DynamicRootView> hw;
        public final WeakReference<View> pr;

        public pr(View view, DynamicRootView dynamicRootView, zo zoVar) {
            this.pr = new WeakReference<>(view);
            this.hw = new WeakReference<>(dynamicRootView);
            this.hn = zoVar;
        }

        @Override // com.byazt.ld.rc
        public void pr(nt<Bitmap> ntVar) {
            View view = this.pr.get();
            if (com.byazt.dj.x.pr()) {
                if (view == null) {
                    return;
                }
                view.setBackground(new BitmapDrawable(ntVar.hn()));
                zo zoVar = this.hn;
                if (zoVar != null && zoVar.vk() != null && 6 == this.hn.vk().pr() && Build.VERSION.SDK_INT >= 19 && view.getBackground() != null) {
                    view.getBackground().setAutoMirrored(true);
                    return;
                }
                return;
            }
            DynamicRootView dynamicRootView = this.hw.get();
            if (dynamicRootView == null) {
                return;
            }
            if (!"open_ad".equals(dynamicRootView.getRenderRequest().uc()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().uc())) {
                view.setBackground(new BitmapDrawable(ntVar.hn()));
            } else {
                view.setBackground(new BitmapDrawable(ntVar.hn()));
            }
        }

        @Override // com.byazt.ld.rc
        public void pr(int i, String str, Throwable th) {
        }
    }

    private String pr(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return pr(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return pr((Object) ((JSONObject) obj).optString(BreakpointSQLiteKey.URL));
        }
        return null;
    }

    private void pr(g gVar, final View view) {
        gVar.pr(new rc<Bitmap>() { // from class: com.byazt.gx.DynamicBaseWidgetImp.3
            @Override // com.byazt.ld.rc
            public void pr(nt<Bitmap> ntVar) {
                if (DynamicBaseWidgetImp.this.g == null) {
                    return;
                }
                if (!"open_ad".equals(DynamicBaseWidgetImp.this.g.getRenderRequest().uc()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.g.getRenderRequest().uc())) {
                    view.setBackground(new BitmapDrawable(ntVar.hn()));
                } else {
                    if (com.byazt.dj.x.pr()) {
                        view.setBackground(new com.byazt.gx.pr(ntVar.hn(), ((DynamicRoot) DynamicBaseWidgetImp.this.g.getChildAt(0)).pr));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(ntVar.hn()));
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str, Throwable th) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable hw(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = fw.pr(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawablePr = pr(pr(string), iArr);
            gradientDrawablePr.setShape(0);
            gradientDrawablePr.setCornerRadius(com.byazt.js.zo.pr(this.w, this.k.ho()));
            return gradientDrawablePr;
        } catch (Throwable th) {
            return null;
        }
    }

    private static void pr(g gVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            gVar.pr(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            a = com.byazt.ca.rc.pr();
        } catch (Throwable th) {
            a = Build.MODEL;
        }
        if (TextUtils.isEmpty(a)) {
            a = Build.MODEL;
        }
        return a;
    }

    @Override // com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.ho == null ? this : this.ho;
        double dA = this.m.vk().c().a();
        if (dA < 90.0d && dA > 0.0d) {
            com.byazt.ca.aj.hw().postDelayed(new Runnable() { // from class: com.byazt.gx.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dA * 1000.0d));
        }
        pr(this.m.vk().c().qa(), view);
        if (!TextUtils.isEmpty(this.k.qn())) {
            aj();
        }
        super.onAttachedToWindow();
    }

    private void pr(double d, final View view) {
        if (d > 0.0d) {
            com.byazt.ca.aj.hw().postDelayed(new Runnable() { // from class: com.byazt.gx.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.m.vk().c().sr() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.pr);
            removeCallbacks(this.hw);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void aj() {
        if (!this.cz) {
            return;
        }
        int iHs = this.k.hs();
        int iNw = this.k.nw();
        Runnable runnable = new Runnable() { // from class: com.byazt.gx.DynamicBaseWidgetImp.6
            @Override // java.lang.Runnable
            public void run() {
                if (DynamicBaseWidgetImp.this.g != null && DynamicBaseWidgetImp.this.g.getRenderRequest() != null) {
                    m renderRequest = DynamicBaseWidgetImp.this.g.getRenderRequest();
                    com.byazt.rk.vk vkVar = new com.byazt.rk.vk();
                    vkVar.pr(renderRequest.yb());
                    vkVar.hw(renderRequest.lb());
                    vkVar.hn(renderRequest.qa());
                    vkVar.pr(renderRequest.a());
                    vkVar.hw(renderRequest.cz());
                    vkVar.hn(renderRequest.ny());
                    vkVar.x(renderRequest.fo());
                    vkVar.c(renderRequest.rc());
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    Context context = DynamicBaseWidgetImp.this.w;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp.qa = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.k, vkVar, renderRequest);
                } else {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                    Context context2 = DynamicBaseWidgetImp.this.w;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp3.qa = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.k);
                }
                DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp5.hw(dynamicBaseWidgetImp5.qa);
                if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                }
                DynamicBaseWidgetImp.this.setClipChildren(false);
                DynamicBaseWidgetImp.this.qa.setTag(2);
                DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp6.pr((ViewGroup) dynamicBaseWidgetImp6);
                DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.qa, new FrameLayout.LayoutParams(-1, -1));
                DynamicBaseWidgetImp.this.qa.hn();
            }
        };
        this.pr = runnable;
        postDelayed(runnable, ((long) iHs) * 1000);
        if (this.k.ie() || iNw >= Integer.MAX_VALUE || iHs >= iNw) {
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.byazt.gx.DynamicBaseWidgetImp.7
            @Override // java.lang.Runnable
            public void run() {
                if (DynamicBaseWidgetImp.this.qa != null) {
                    DynamicBaseWidgetImp.this.cz = false;
                    DynamicBaseWidgetImp.this.qa.x();
                    DynamicBaseWidgetImp.this.qa.setVisibility(4);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.qa);
                }
            }
        };
        this.hw = runnable2;
        postDelayed(runnable2, ((long) iNw) * 1000);
    }
}
