package com.byazt.osr;

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
import com.byazt.cq.tj;
import com.byazt.cq.w;
import com.byazt.hkc.rv;
import com.byazt.jmk.InteractViewContainer;
import com.byazt.lh.fs;
import com.byazt.lh.x;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.si.sz;
import com.byazt.stl.GifView;
import com.byazt.udb.oa;
import com.google.android.gms.common.internal.ImagesContract;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1024})
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    public static String a = "";
    public Runnable n;
    public ImageView ou;
    public volatile boolean py;
    public Runnable qg;
    public InteractViewContainer um;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.py = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = fsVar.tj().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.fs - ((int) com.byazt.cq.fs.n(context, this.d.qg() + this.d.n())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.fs - ((int) com.byazt.cq.fs.n(context, this.d.qg() + this.d.n())));
        }
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.x, this.fs);
    }

    @Override // com.byazt.osr.q
    public boolean fs() {
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.k == null ? this : this.k;
        setContentDescription(this.oa.n(this.d.t()));
        String strI = this.d.i();
        String strH = null;
        String strN = (TextUtils.isEmpty(strI) || this.sz == null || this.sz.getRenderRequest() == null || this.sz.getRenderRequest().l() == null || (jSONObjectOptJSONObject = this.sz.getRenderRequest().l().optJSONObject("creative")) == null) ? null : n(jSONObjectOptJSONObject.opt(strI));
        if (TextUtils.isEmpty(strN)) {
            strN = this.d.py();
        }
        if (this.d.a()) {
            com.byazt.gkj.n.n().l().n(this.d.qg).s(2).n(new s(this.cp, this.d.um())).n(new qg(view, this));
        } else if (!TextUtils.isEmpty(strN)) {
            if (!strN.startsWith("http:") && !strN.startsWith("https:")) {
                if (this.sz != null && this.sz.getRenderRequest() != null) {
                    strH = this.sz.getRenderRequest().h();
                }
                strN = rv.qg(strN, strH);
            }
            sz szVarS = com.byazt.gkj.n.n().l().n(strN).s(2);
            n(szVarS);
            if (!com.byazt.twc.q.n()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.oa.tj().getType(), "vessel")) {
                    if (tj.qg(strN)) {
                        this.ou = new GifView(this.cp);
                    } else {
                        this.ou = new ImageView(this.cp);
                    }
                    ((FrameLayout) view).addView(this.ou, new FrameLayout.LayoutParams(-1, -1));
                    szVarS.s(3).n(new m() { // from class: com.byazt.osr.DynamicBaseWidgetImp.1
                        @Override // com.byazt.si.m
                        public void n(int i, String str, Throwable th) {
                        }

                        @Override // com.byazt.si.m
                        public void n(cy cyVar) {
                            Object objS = cyVar.s();
                            if (objS instanceof byte[]) {
                                w.qg(DynamicBaseWidgetImp.this.ou, (byte[]) objS, DynamicBaseWidgetImp.this.x, DynamicBaseWidgetImp.this.fs);
                            }
                        }
                    }, 4);
                } else {
                    n(szVarS, view);
                }
            } else {
                szVarS.n(new n(view, this.sz, this.oa));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.d.bb() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.byazt.osr.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.d.an() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableQg = dynamicBaseWidgetImp.qg(dynamicBaseWidgetImp.sz.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.d.an())));
                            if (drawableQg == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableQg = dynamicBaseWidgetImp2.n(true, dynamicBaseWidgetImp2.sz.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.d.an())));
                            }
                            if (drawableQg != null) {
                                view.setBackground(drawableQg);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.n(true, dynamicBaseWidgetImp3.sz.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.d.bb() * 1000.0d));
        }
        if (this.k != null) {
            this.k.setPadding((int) com.byazt.cq.fs.n(this.cp, this.d.s()), (int) com.byazt.cq.fs.n(this.cp, this.d.qg()), (int) com.byazt.cq.fs.n(this.cp, this.d.q()), (int) com.byazt.cq.fs.n(this.cp, this.d.n()));
        }
        if (this.cy || this.d.sz() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    @com.byazt.cp.n(n = {0, 1, 38, 1770})
    private static class s implements com.byazt.si.tj {
        public final WeakReference<Context> n;
        public final int qg;

        public s(Context context, int i) {
            this.n = new WeakReference<>(context);
            this.qg = i;
        }

        @Override // com.byazt.si.tj
        public Bitmap n(Bitmap bitmap) {
            Context context = this.n.get();
            if (context != null) {
                return com.byazt.cq.qg.n(context, bitmap, this.qg);
            }
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 38, 2458})
    private static class qg implements m<Bitmap> {
        public final WeakReference<View> n;
        public final WeakReference<DynamicBaseWidget> qg;

        @Override // com.byazt.si.m
        public void n(int i, String str, Throwable th) {
        }

        public qg(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.n = new WeakReference<>(view);
            this.qg = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.byazt.si.m
        public void n(cy<Bitmap> cyVar) {
            Bitmap bitmapS;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.n.get();
            if (view == null || (bitmapS = cyVar.s()) == null || cyVar.q() == null || (dynamicBaseWidget = this.qg.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.n(bitmapS));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 38, 1769})
    private static class n implements m<Bitmap> {
        public final WeakReference<View> n;
        public final WeakReference<DynamicRootView> qg;
        public final fs s;

        @Override // com.byazt.si.m
        public void n(int i, String str, Throwable th) {
        }

        public n(View view, DynamicRootView dynamicRootView, fs fsVar) {
            this.n = new WeakReference<>(view);
            this.qg = new WeakReference<>(dynamicRootView);
            this.s = fsVar;
        }

        @Override // com.byazt.si.m
        public void n(cy<Bitmap> cyVar) {
            View view = this.n.get();
            if (!com.byazt.twc.q.n()) {
                DynamicRootView dynamicRootView = this.qg.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().w()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().w())) {
                    view.setBackground(new BitmapDrawable(cyVar.s()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(cyVar.s()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(cyVar.s()));
            fs fsVar = this.s;
            if (fsVar == null || fsVar.tj() == null || 6 != this.s.tj().n() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String n(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return n(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return n((Object) ((JSONObject) obj).optString(ImagesContract.URL));
        }
        return null;
    }

    private void n(sz szVar, final View view) {
        szVar.n(new m<Bitmap>() { // from class: com.byazt.osr.DynamicBaseWidgetImp.3
            @Override // com.byazt.si.m
            public void n(int i, String str, Throwable th) {
            }

            @Override // com.byazt.si.m
            public void n(cy<Bitmap> cyVar) {
                if (DynamicBaseWidgetImp.this.sz == null) {
                    return;
                }
                if (!"open_ad".equals(DynamicBaseWidgetImp.this.sz.getRenderRequest().w()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.sz.getRenderRequest().w())) {
                    view.setBackground(new BitmapDrawable(cyVar.s()));
                } else {
                    if (com.byazt.twc.q.n()) {
                        view.setBackground(new com.byazt.osr.n(cyVar.s(), ((DynamicRoot) DynamicBaseWidgetImp.this.sz.getChildAt(0)).n));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(cyVar.s()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable qg(String str) {
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
                iArr[i2] = x.n(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableN = n(n(string), iArr);
            gradientDrawableN.setShape(0);
            gradientDrawableN.setCornerRadius(com.byazt.cq.fs.n(this.cp, this.d.k()));
            return gradientDrawableN;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void n(sz szVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            szVar.n(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            a = com.byazt.tk.m.n();
        } catch (Throwable unused) {
            a = Build.MODEL;
        }
        if (TextUtils.isEmpty(a)) {
            a = Build.MODEL;
        }
        return a;
    }

    @Override // com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.k == null ? this : this.k;
        double dA = this.oa.tj().l().a();
        if (dA < 90.0d && dA > 0.0d) {
            com.byazt.tk.rv.qg().postDelayed(new Runnable() { // from class: com.byazt.osr.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dA * 1000.0d));
        }
        n(this.oa.tj().l().um(), view);
        if (!TextUtils.isEmpty(this.d.dg())) {
            rv();
        }
        super.onAttachedToWindow();
    }

    private void n(double d, final View view) {
        if (d > 0.0d) {
            com.byazt.tk.rv.qg().postDelayed(new Runnable() { // from class: com.byazt.osr.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.oa.tj().l().vo() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    @Override // com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.n);
            removeCallbacks(this.qg);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void rv() {
        if (this.py) {
            int iY = this.d.y();
            int iRf = this.d.rf();
            Runnable runnable = new Runnable() { // from class: com.byazt.osr.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.sz != null && DynamicBaseWidgetImp.this.sz.getRenderRequest() != null) {
                        oa renderRequest = DynamicBaseWidgetImp.this.sz.getRenderRequest();
                        com.byazt.lh.tj tjVar = new com.byazt.lh.tj();
                        tjVar.n(renderRequest.hd());
                        tjVar.qg(renderRequest.cd());
                        tjVar.s(renderRequest.um());
                        tjVar.n(renderRequest.a());
                        tjVar.qg(renderRequest.py());
                        tjVar.s(renderRequest.ou());
                        tjVar.q(renderRequest.wm());
                        tjVar.l(renderRequest.m());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        Context context = DynamicBaseWidgetImp.this.cp;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.um = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.d, tjVar, renderRequest);
                    } else {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        Context context2 = DynamicBaseWidgetImp.this.cp;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.um = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.d);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.qg(dynamicBaseWidgetImp5.um);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.um.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.n((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.um, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.um.s();
                }
            };
            this.n = runnable;
            postDelayed(runnable, ((long) iY) * 1000);
            if (this.d.dh() || iRf >= Integer.MAX_VALUE || iY >= iRf) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.byazt.osr.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.um != null) {
                        DynamicBaseWidgetImp.this.py = false;
                        DynamicBaseWidgetImp.this.um.q();
                        DynamicBaseWidgetImp.this.um.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.um);
                    }
                }
            };
            this.qg = runnable2;
            postDelayed(runnable2, ((long) iRf) * 1000);
        }
    }
}
