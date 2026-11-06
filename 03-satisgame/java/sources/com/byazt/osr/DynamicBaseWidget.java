package com.byazt.osr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.lh.fs;
import com.byazt.lh.w;
import com.byazt.lh.x;
import com.byazt.tk.ou;
import com.byazt.udb.oa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1876})
public abstract class DynamicBaseWidget extends FrameLayout implements com.byazt.zw.qg, l, q {
    public float a;
    public com.byazt.zw.n cd;
    public Context cp;
    public boolean cy;
    public x d;
    public int fs;
    public com.byazt.jfs.qg hd;
    public View k;
    public float l;
    public float n;
    public fs oa;
    public boolean ou;
    public ou py;
    public float q;
    public float qg;
    public int rv;
    public float s;
    public DynamicRootView sz;
    public int tj;
    public float um;
    public float w;
    public int x;
    public static final View.OnTouchListener wm = new View.OnTouchListener() { // from class: com.byazt.osr.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    public static final View.OnClickListener m = new View.OnClickListener() { // from class: com.byazt.osr.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @Override // com.byazt.zw.qg
    public float getShineValue() {
        return this.qg;
    }

    public void setShineValue(float f) {
        this.qg = f;
        postInvalidate();
    }

    @Override // com.byazt.zw.qg
    public float getRippleValue() {
        return this.n;
    }

    public void setRippleValue(float f) {
        this.n = f;
        postInvalidate();
    }

    @Override // com.byazt.zw.qg
    public float getMarqueeValue() {
        return this.um;
    }

    public void setMarqueeValue(float f) {
        this.um = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.a;
    }

    public void setStretchValue(float f) {
        this.a = f;
        this.cd.n(this, f);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context);
        this.ou = true;
        this.cp = context;
        this.sz = dynamicRootView;
        this.oa = fsVar;
        this.s = fsVar.w();
        this.q = fsVar.x();
        this.l = fsVar.fs();
        this.w = fsVar.rv();
        this.rv = (int) com.byazt.cq.fs.n(this.cp, this.s);
        this.tj = (int) com.byazt.cq.fs.n(this.cp, this.q);
        this.x = (int) com.byazt.cq.fs.n(this.cp, this.l);
        this.fs = (int) com.byazt.cq.fs.n(this.cp, this.w);
        x xVar = new x(fsVar.tj());
        this.d = xVar;
        if (xVar.cd() > 0) {
            this.x += this.d.cd() * 2;
            this.fs += this.d.cd() * 2;
            this.rv -= this.d.cd();
            this.tj -= this.d.cd();
            List<fs> listCp = fsVar.cp();
            if (listCp != null) {
                for (fs fsVar2 : listCp) {
                    fsVar2.s(fsVar2.w() + com.byazt.cq.fs.qg(this.cp, this.d.cd()));
                    fsVar2.q(fsVar2.x() + com.byazt.cq.fs.qg(this.cp, this.d.cd()));
                    fsVar2.n(com.byazt.cq.fs.qg(this.cp, this.d.cd()));
                    fsVar2.qg(com.byazt.cq.fs.qg(this.cp, this.d.cd()));
                }
            }
        }
        this.cy = this.d.sz() > 0.0d;
        this.cd = new com.byazt.zw.n();
    }

    public void setShouldInvisible(boolean z) {
        this.cy = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.cy;
    }

    public boolean n() {
        fs();
        l();
        s();
        return true;
    }

    public void n(int i) {
        x xVar = this.d;
        if (xVar != null && xVar.n(i)) {
            fs();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).n(i);
                }
            }
        }
    }

    public boolean s() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.k;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (q()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = wm;
            onClickListener = m;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iN = com.byazt.ii.n.n(this.d);
            if (iN == 2 || iN == 3) {
                view2.setOnClickListener(m);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        n(view2);
        qg(view2);
        return true;
    }

    public void n(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.oa.fs());
            jSONObject.put("height", this.oa.rv());
            if (com.byazt.twc.q.n()) {
                view.setTag(com.byazt.tq.n.a, this.d.f());
                view.setTag(com.byazt.tq.n.py, this.oa.tj().getType());
                view.setTag(com.byazt.tq.n.ou, this.oa.s());
                view.setTag(com.byazt.tq.n.wm, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.d.f());
            view.setTag(2097610715, this.oa.tj().getType());
            view.setTag(2097610714, this.oa.s());
            view.setTag(2097610713, jSONObject.toString());
            int iN = com.byazt.ii.n.n(this.d);
            if (iN == 1) {
                view.setTag(2097610707, new Pair(this.d.hu(), Long.valueOf(this.d.h())));
                view.setTag(2097610708, Integer.valueOf(iN));
            }
        } catch (JSONException unused) {
        }
    }

    public void qg(View view) {
        w wVarL;
        fs fsVar = this.oa;
        if (fsVar == null || (wVarL = fsVar.tj().l()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(wVarL.xd()));
    }

    public boolean q() {
        x xVar = this.d;
        return (xVar == null || xVar.t() == 0) ? false : true;
    }

    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
        layoutParams.topMargin = this.tj;
        layoutParams.leftMargin = this.rv;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.d.t();
    }

    public String getImageObjectFit() {
        return this.d.ri();
    }

    public com.byazt.xnr.n getDynamicClickListener() {
        return this.sz.getDynamicClickListener();
    }

    public Drawable getBackgroundDrawable() {
        return n(false, "");
    }

    public Drawable n(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iUr;
        if (!TextUtils.isEmpty(this.d.ae())) {
            try {
                String strAe = this.d.ae();
                String strSubstring = strAe.substring(strAe.indexOf("(") + 1, strAe.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{x.n(strArrSplit[1]), x.n(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{x.n(strArrSplit[1].substring(0, 7)), x.n(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableN = n(n(strArrSplit[0]), iArr);
                gradientDrawableN.setShape(0);
                gradientDrawableN.setCornerRadius(com.byazt.cq.fs.n(this.cp, this.d.k()));
                return gradientDrawableN;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fN = com.byazt.cq.fs.n(this.cp, this.d.k());
        drawable.setCornerRadius(fN);
        if (fN < 1.0f) {
            float fN2 = com.byazt.cq.fs.n(this.cp, this.d.ln());
            float fN3 = com.byazt.cq.fs.n(this.cp, this.d.lh());
            float fN4 = com.byazt.cq.fs.n(this.cp, this.d.v());
            float fN5 = com.byazt.cq.fs.n(this.cp, this.d.j());
            float[] fArr = new float[8];
            if (fN2 > 0.0f) {
                fArr[0] = fN2;
                fArr[1] = fN2;
            }
            if (fN3 > 0.0f) {
                fArr[2] = fN3;
                fArr[3] = fN3;
            }
            if (fN4 > 0.0f) {
                fArr[4] = fN4;
                fArr[5] = fN4;
            }
            if (fN5 > 0.0f) {
                fArr[6] = fN5;
                fArr[7] = fN5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iUr = Color.parseColor(str);
        } else {
            iUr = this.d.ur();
        }
        drawable.setColor(iUr);
        if (this.d.hd() > 0.0f) {
            drawable.setStroke((int) com.byazt.cq.fs.n(this.cp, this.d.hd()), this.d.cy());
            return drawable;
        }
        if (this.d.cd() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.d.cd(), this.d.cy());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.oa.tj().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new s((int) fN, this.d.cd());
    }

    public qg n(Bitmap bitmap) {
        return new n(bitmap, null);
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(n(qg(this.d.ae().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] n(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = x.n(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableN = n(n(strArrSplit[0]), iArr);
                gradientDrawableN.setShape(0);
                gradientDrawableN.setCornerRadius(com.byazt.cq.fs.n(this.cp, this.d.k()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableN;
            }
        }
        return drawableArr;
    }

    private List<String> qg(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && (i = i - 1) == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public GradientDrawable n(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr[0]);
            return gradientDrawable;
        }
        return new GradientDrawable(orientation, iArr);
    }

    public GradientDrawable.Orientation n(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cd.n(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.zw.n nVar = this.cd;
        View view = this.k;
        if (view == null) {
            view = this;
        }
        nVar.n(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
        rv();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.py != null) {
            DynamicRootView dynamicRootView = this.sz;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.py.n(0);
                    return;
                } else {
                    this.py.qg(0);
                    return;
                }
            }
            if (z) {
                this.py.n(this.sz.getRenderRequest().ur());
            } else {
                this.py.qg(this.sz.getRenderRequest().ur());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        qg();
        super.onDetachedFromWindow();
        if (this.py != null) {
            DynamicRootView dynamicRootView = this.sz;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.py.qg(this.sz.getRenderRequest().ur());
            } else {
                this.py.qg(0);
            }
        }
    }

    public void w() {
        if (x()) {
            return;
        }
        View view = this.k;
        if (view == null) {
            view = this;
        }
        com.byazt.jfs.qg qgVar = new com.byazt.jfs.qg(view, this.oa.tj().l().vo());
        this.hd = qgVar;
        qgVar.n();
    }

    public void qg() {
        com.byazt.jfs.qg qgVar = this.hd;
        if (qgVar != null) {
            qgVar.qg();
        }
    }

    public boolean x() {
        fs fsVar = this.oa;
        return fsVar == null || fsVar.tj() == null || this.oa.tj().l() == null || this.oa.tj().l().vo() == null;
    }

    public int getDynamicWidth() {
        return this.x;
    }

    public int getDynamicHeight() {
        return this.fs;
    }

    public w getDynamicLayoutBrickValue() {
        com.byazt.lh.l lVarTj;
        fs fsVar = this.oa;
        if (fsVar == null || (lVarTj = fsVar.tj()) == null) {
            return null;
        }
        return lVarTj.l();
    }

    private void rv() {
        if (isShown()) {
            int iN = com.byazt.ii.n.n(this.d);
            if (iN == 2) {
                if (this.py == null) {
                    this.py = new ou(getContext().getApplicationContext(), 1, this.ou);
                }
                this.py.n(new ou.n() { // from class: com.byazt.osr.DynamicBaseWidget.3
                    @Override // com.byazt.tk.ou.n
                    public void n(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tj();
                        }
                    }
                });
                oa renderRequest = this.sz.getRenderRequest();
                if (renderRequest != null) {
                    this.py.n(renderRequest.hd());
                    this.py.l(renderRequest.wm());
                    this.py.s(renderRequest.py());
                    this.py.qg(renderRequest.um());
                    this.py.w(renderRequest.m());
                    this.py.n(renderRequest.a());
                    this.py.qg(renderRequest.ou());
                }
            } else if (iN == 3) {
                if (this.py == null) {
                    this.py = new ou(getContext().getApplicationContext(), 2, this.ou);
                }
                this.py.n(new ou.n() { // from class: com.byazt.osr.DynamicBaseWidget.4
                    @Override // com.byazt.tk.ou.n
                    public void n(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tj();
                        }
                    }
                });
                oa renderRequest2 = this.sz.getRenderRequest();
                if (renderRequest2 != null) {
                    this.py.qg(renderRequest2.um());
                    this.py.w(renderRequest2.m());
                    this.py.n(renderRequest2.a());
                    this.py.qg(renderRequest2.ou());
                }
            }
            ou ouVar = this.py;
            if (ouVar != null) {
                DynamicRootView dynamicRootView = this.sz;
                if (dynamicRootView != null) {
                    oa renderRequest3 = dynamicRootView.getRenderRequest();
                    if (renderRequest3 != null) {
                        this.py.n(renderRequest3.ur());
                        return;
                    }
                    return;
                }
                ouVar.n(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        try {
            View view = this.k;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(m);
        } catch (Exception unused) {
        }
    }

    public void setCanUseSensor(boolean z) {
        this.ou = z;
    }
}
