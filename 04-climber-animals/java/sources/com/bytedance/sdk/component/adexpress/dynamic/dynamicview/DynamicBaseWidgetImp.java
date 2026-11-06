package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

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
import com.bytedance.sdk.component.adexpress.d.c;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ab;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.d.ny;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.ch;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String t = "";
    private ImageView b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Runnable f805ms;
    private volatile boolean nw;
    private Runnable xr;
    protected InteractViewContainer y;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.nw = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = xVar.ch().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.x - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, this.sl.xr() + this.sl.ms())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.x - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, this.sl.xr() + this.sl.ms())));
        }
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.ab, this.x);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.ub == null ? this : this.ub;
        setContentDescription(this.zb.ms(this.sl.op()));
        String strJy = this.sl.jy();
        String strOp = null;
        String strMs = (TextUtils.isEmpty(strJy) || this.u == null || this.u.getRenderRequest() == null || this.u.getRenderRequest().ka() == null || (jSONObjectOptJSONObject = this.u.getRenderRequest().ka().optJSONObject("creative")) == null) ? null : ms(jSONObjectOptJSONObject.opt(strJy));
        if (TextUtils.isEmpty(strMs)) {
            strMs = this.sl.nw();
        }
        if (this.sl.t()) {
            com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka().ms(this.sl.xr).ah(2).ms(new ah(this.hi, this.sl.y())).ms(new xr(view, this));
        } else if (!TextUtils.isEmpty(strMs)) {
            if (!strMs.startsWith("http:") && !strMs.startsWith("https:")) {
                if (this.u != null && this.u.getRenderRequest() != null) {
                    strOp = this.u.getRenderRequest().op();
                }
                strMs = ny.xr(strMs, strOp);
            }
            ch chVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka().ms(strMs).ah(2);
            ms(chVarAh);
            if (!com.bytedance.sdk.component.adexpress.d.ms()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.zb.ch().getType(), "vessel")) {
                    if (com.bytedance.sdk.component.adexpress.d.ch.xr(strMs)) {
                        this.b = new GifView(this.hi);
                    } else {
                        this.b = new ImageView(this.hi);
                    }
                    ((FrameLayout) view).addView(this.b, new FrameLayout.LayoutParams(-1, -1));
                    chVarAh.ah(3).ms(new ao() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                        @Override // com.bytedance.sdk.component.c.ao
                        @ATSMethod(2)
                        public void ms(int i, String str, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.c.ao
                        @ATSMethod(1)
                        public void ms(hi hiVar) {
                            Object objAh = hiVar.ah();
                            if (objAh instanceof byte[]) {
                                c.xr(DynamicBaseWidgetImp.this.b, (byte[]) objAh, DynamicBaseWidgetImp.this.ab, DynamicBaseWidgetImp.this.x);
                            }
                        }
                    }, 4);
                } else {
                    ms(chVarAh, view);
                }
            } else {
                chVarAh.ms(new ms(view, this.u, this.zb));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.sl.cv() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.sl.jw() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableXr = dynamicBaseWidgetImp.xr(dynamicBaseWidgetImp.u.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.sl.jw())));
                            if (drawableXr == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableXr = dynamicBaseWidgetImp2.ms(true, dynamicBaseWidgetImp2.u.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.sl.jw())));
                            }
                            if (drawableXr != null) {
                                view.setBackground(drawableXr);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.ms(true, dynamicBaseWidgetImp3.u.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.sl.cv() * 1000.0d));
        }
        if (this.ub != null) {
            this.ub.setPadding((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ah()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.xr()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.d()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ms()));
        }
        if (this.ao || this.sl.u() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class ah implements com.bytedance.sdk.component.c.x {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<Context> f813ms;
        private final int xr;

        public ah(Context context, int i) {
            this.f813ms = new WeakReference<>(context);
            this.xr = i;
        }

        @Override // com.bytedance.sdk.component.c.x
        @ATSMethod(1)
        public Bitmap ms(Bitmap bitmap) {
            Context context = this.f813ms.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.d.xr.ms(context, bitmap, this.xr);
            }
            return null;
        }
    }

    private static class xr implements ao<Bitmap> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<View> f815ms;
        private final WeakReference<DynamicBaseWidget> xr;

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(int i, String str, Throwable th) {
        }

        public xr(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.f815ms = new WeakReference<>(view);
            this.xr = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(hi<Bitmap> hiVar) {
            Bitmap bitmapAh;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.f815ms.get();
            if (view == null || (bitmapAh = hiVar.ah()) == null || hiVar.d() == null || (dynamicBaseWidget = this.xr.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.ms(bitmapAh));
        }
    }

    private static class ms implements ao<Bitmap> {
        private final x ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final WeakReference<View> f814ms;
        private final WeakReference<DynamicRootView> xr;

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(int i, String str, Throwable th) {
        }

        public ms(View view, DynamicRootView dynamicRootView, x xVar) {
            this.f814ms = new WeakReference<>(view);
            this.xr = new WeakReference<>(dynamicRootView);
            this.ah = xVar;
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(hi<Bitmap> hiVar) {
            View view = this.f814ms.get();
            if (!com.bytedance.sdk.component.adexpress.d.ms()) {
                DynamicRootView dynamicRootView = this.xr.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().c()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().c())) {
                    view.setBackground(new BitmapDrawable(hiVar.ah()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(hiVar.ah()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(hiVar.ah()));
            x xVar = this.ah;
            if (xVar == null || xVar.ch() == null || 6 != this.ah.ch().ms() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String ms(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return ms(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return ms((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void ms(ch chVar, final View view) {
        chVar.ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(2)
            public void ms(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.c.ao
            @ATSMethod(1)
            public void ms(hi<Bitmap> hiVar) {
                if (DynamicBaseWidgetImp.this.u == null) {
                    return;
                }
                if (!"open_ad".equals(DynamicBaseWidgetImp.this.u.getRenderRequest().c()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.u.getRenderRequest().c())) {
                    view.setBackground(new BitmapDrawable(hiVar.ah()));
                } else {
                    if (com.bytedance.sdk.component.adexpress.d.ms()) {
                        view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ms(hiVar.ah(), ((DynamicRoot) DynamicBaseWidgetImp.this.u.getChildAt(0)).f826ms));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(hiVar.ah()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable xr(String str) {
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
                iArr[i2] = ab.ms(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableMs = ms(ms(string), iArr);
            gradientDrawableMs.setShape(0);
            gradientDrawableMs.setCornerRadius(com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ub()));
            return gradientDrawableMs;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void ms(ch chVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            chVar.ms(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            t = i.ms();
        } catch (Throwable unused) {
            t = Build.MODEL;
        }
        if (TextUtils.isEmpty(t)) {
            t = Build.MODEL;
        }
        return t;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.ub == null ? this : this.ub;
        double dT = this.zb.ch().ka().t();
        if (dT < 90.0d && dT > 0.0d) {
            com.bytedance.sdk.component.utils.x.xr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dT * 1000.0d));
        }
        ms(this.zb.ch().ka().y(), view);
        if (!TextUtils.isEmpty(this.sl.e())) {
            ny();
        }
        super.onAttachedToWindow();
    }

    private void ms(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.x.xr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.zb.ch().ka().qo() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.f805ms);
            removeCallbacks(this.xr);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void ny() {
        if (this.nw) {
            int iIl = this.sl.il();
            int iQf = this.sl.qf();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.u != null && DynamicBaseWidgetImp.this.u.getRenderRequest() != null) {
                        zb renderRequest = DynamicBaseWidgetImp.this.u.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar = new com.bytedance.sdk.component.adexpress.dynamic.ah.ch();
                        chVar.ms(renderRequest.qv());
                        chVar.xr(renderRequest.y());
                        chVar.ah(renderRequest.t());
                        chVar.ms(renderRequest.nw());
                        chVar.xr(renderRequest.b());
                        chVar.ah(renderRequest.re());
                        chVar.d(renderRequest.i());
                        chVar.ka(renderRequest.w());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        Context context = DynamicBaseWidgetImp.this.hi;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.y = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.sl, chVar, renderRequest);
                    } else {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        Context context2 = DynamicBaseWidgetImp.this.hi;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.y = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.sl);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.xr(dynamicBaseWidgetImp5.y);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.y.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.ms((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.y, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.y.ah();
                }
            };
            this.f805ms = runnable;
            postDelayed(runnable, ((long) iIl) * 1000);
            if (this.sl.l() || iQf >= Integer.MAX_VALUE || iIl >= iQf) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.y != null) {
                        DynamicBaseWidgetImp.this.nw = false;
                        DynamicBaseWidgetImp.this.y.d();
                        DynamicBaseWidgetImp.this.y.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.y);
                    }
                }
            };
            this.xr = runnable2;
            postDelayed(runnable2, ((long) iQf) * 1000);
        }
    }
}
