package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

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
import com.bytedance.sdk.component.adexpress.dynamic.ah.ab;
import com.bytedance.sdk.component.adexpress.dynamic.ah.c;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr, d, ka {
    protected int ab;
    protected float ah;
    protected boolean ao;
    private boolean b;
    protected float c;
    protected int ch;
    protected float d;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.ms.xr h;
    protected Context hi;
    protected float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f802ms;
    private b nw;
    protected int ny;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.ms qv;
    protected ab sl;
    private float t;
    protected DynamicRootView u;
    protected View ub;
    protected int x;
    private float xr;
    private float y;
    protected x zb;
    private static final View.OnTouchListener re = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener i = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getShineValue() {
        return this.xr;
    }

    public void setShineValue(float f) {
        this.xr = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getRippleValue() {
        return this.f802ms;
    }

    public void setRippleValue(float f) {
        this.f802ms = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getMarqueeValue() {
        return this.y;
    }

    public void setMarqueeValue(float f) {
        this.y = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.t;
    }

    public void setStretchValue(float f) {
        this.t = f;
        this.qv.ms(this, f);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context);
        this.b = true;
        this.hi = context;
        this.u = dynamicRootView;
        this.zb = xVar;
        this.ah = xVar.c();
        this.d = xVar.ab();
        this.ka = xVar.x();
        this.c = xVar.ny();
        this.ny = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.ah);
        this.ch = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.d);
        this.ab = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.ka);
        this.x = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.c);
        ab abVar = new ab(xVar.ch());
        this.sl = abVar;
        if (abVar.qv() > 0) {
            this.ab += this.sl.qv() * 2;
            this.x += this.sl.qv() * 2;
            this.ny -= this.sl.qv();
            this.ch -= this.sl.qv();
            List<x> listHi = xVar.hi();
            if (listHi != null) {
                for (x xVar2 : listHi) {
                    xVar2.ah(xVar2.c() + com.bytedance.sdk.component.adexpress.d.x.xr(this.hi, this.sl.qv()));
                    xVar2.d(xVar2.ab() + com.bytedance.sdk.component.adexpress.d.x.xr(this.hi, this.sl.qv()));
                    xVar2.ms(com.bytedance.sdk.component.adexpress.d.x.xr(this.hi, this.sl.qv()));
                    xVar2.xr(com.bytedance.sdk.component.adexpress.d.x.xr(this.hi, this.sl.qv()));
                }
            }
        }
        this.ao = this.sl.u() > 0.0d;
        this.qv = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.ms();
    }

    public void setShouldInvisible(boolean z) {
        this.ao = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.ao;
    }

    public boolean ms() {
        x();
        ka();
        ah();
        return true;
    }

    public void ms(int i2) {
        ab abVar = this.sl;
        if (abVar != null && abVar.ms(i2)) {
            x();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (getChildAt(i3) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).ms(i2);
                }
            }
        }
    }

    protected boolean ah() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.ub;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (d()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = re;
            onClickListener = i;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iMs = com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(this.sl);
            if (iMs == 2 || iMs == 3) {
                view2.setOnClickListener(i);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        ms(view2);
        xr(view2);
        return true;
    }

    protected void ms(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.zb.x());
            jSONObject.put("height", this.zb.ny());
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.ms.t, this.sl.ul());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.ms.nw, this.zb.ch().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.ms.b, this.zb.ah());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.ms.re, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.sl.ul());
            view.setTag(2097610715, this.zb.ch().getType());
            view.setTag(2097610714, this.zb.ah());
            view.setTag(2097610713, jSONObject.toString());
            int iMs = com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(this.sl);
            if (iMs == 1) {
                view.setTag(2097610707, new Pair(this.sl.w(), Long.valueOf(this.sl.yu())));
                view.setTag(2097610708, Integer.valueOf(iMs));
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    protected void xr(View view) {
        c cVarKa;
        x xVar = this.zb;
        if (xVar == null || (cVarKa = xVar.ch().ka()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(cVarKa.ph()));
    }

    public boolean d() {
        ab abVar = this.sl;
        return (abVar == null || abVar.op() == 0) ? false : true;
    }

    public void ka() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ab, this.x);
        layoutParams.topMargin = this.ch;
        layoutParams.leftMargin = this.ny;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.sl.op();
    }

    public String getImageObjectFit() {
        return this.sl.sa();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ka.ms getDynamicClickListener() {
        return this.u.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        return ms(false, "");
    }

    protected Drawable ms(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iLe;
        if (!TextUtils.isEmpty(this.sl.f())) {
            try {
                String strF = this.sl.f();
                String strSubstring = strF.substring(strF.indexOf("(") + 1, strF.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{ab.ms(strArrSplit[1]), ab.ms(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{ab.ms(strArrSplit[1].substring(0, 7)), ab.ms(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i2 = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i2;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableMs = ms(ms(strArrSplit[0]), iArr);
                gradientDrawableMs.setShape(0);
                gradientDrawableMs.setCornerRadius(com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ub()));
                return gradientDrawableMs;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fMs = com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ub());
        drawable.setCornerRadius(fMs);
        if (fMs < 1.0f) {
            float fMs2 = com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.g());
            float fMs3 = com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.of());
            float fMs4 = com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.p());
            float fMs5 = com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.pc());
            float[] fArr = new float[8];
            if (fMs2 > 0.0f) {
                fArr[0] = fMs2;
                fArr[1] = fMs2;
            }
            if (fMs3 > 0.0f) {
                fArr[2] = fMs3;
                fArr[3] = fMs3;
            }
            if (fMs4 > 0.0f) {
                fArr[4] = fMs4;
                fArr[5] = fMs4;
            }
            if (fMs5 > 0.0f) {
                fArr[6] = fMs5;
                fArr[7] = fMs5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iLe = Color.parseColor(str);
        } else {
            iLe = this.sl.le();
        }
        drawable.setColor(iLe);
        if (this.sl.h() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.h()), this.sl.ao());
            return drawable;
        }
        if (this.sl.qv() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.sl.qv(), this.sl.ao());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.zb.ch().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new ah((int) fMs, this.sl.qv());
    }

    protected xr ms(Bitmap bitmap) {
        return new ms(bitmap, null);
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(ms(xr(this.sl.f().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] ms(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i3 = 0;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    iArr[i3] = ab.ms(strArrSplit[i4].substring(0, 7));
                    i3 = i4;
                }
                GradientDrawable gradientDrawableMs = ms(ms(strArrSplit[0]), iArr);
                gradientDrawableMs.setShape(0);
                gradientDrawableMs.setCornerRadius(com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ub()));
                drawableArr[(list.size() - 1) - i2] = gradientDrawableMs;
            }
        }
        return drawableArr;
    }

    private List<String> xr(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == '(') {
                i2++;
                z = true;
            } else if (str.charAt(i4) == ')' && (i2 = i2 - 1) == 0 && z) {
                int i5 = i4 + 1;
                arrayList.add(str.substring(i3, i5));
                i3 = i5;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    protected GradientDrawable ms(GradientDrawable.Orientation orientation, int[] iArr) {
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

    protected GradientDrawable.Orientation ms(String str) {
        try {
            int i2 = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i2 <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i2 <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i2 <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.qv.ms(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.ms msVar = this.qv;
        View view = this.ub;
        if (view == null) {
            view = this;
        }
        msVar.ms(view, i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        ny();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.nw != null) {
            DynamicRootView dynamicRootView = this.u;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.nw.ms(0);
                    return;
                } else {
                    this.nw.xr(0);
                    return;
                }
            }
            if (z) {
                this.nw.ms(this.u.getRenderRequest().cv());
            } else {
                this.nw.xr(this.u.getRenderRequest().cv());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        xr();
        super.onDetachedFromWindow();
        if (this.nw != null) {
            DynamicRootView dynamicRootView = this.u;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.nw.xr(this.u.getRenderRequest().cv());
            } else {
                this.nw.xr(0);
            }
        }
    }

    public void c() {
        if (ab()) {
            return;
        }
        View view = this.ub;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.ms.xr xrVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.ms.xr(view, this.zb.ch().ka().qo());
        this.h = xrVar;
        xrVar.ms();
    }

    public void xr() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.ms.xr xrVar = this.h;
        if (xrVar != null) {
            xrVar.xr();
        }
    }

    protected boolean ab() {
        x xVar = this.zb;
        return xVar == null || xVar.ch() == null || this.zb.ch().ka() == null || this.zb.ch().ka().qo() == null;
    }

    public int getDynamicWidth() {
        return this.ab;
    }

    public int getDynamicHeight() {
        return this.x;
    }

    public c getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.ah.ka kaVarCh;
        x xVar = this.zb;
        if (xVar == null || (kaVarCh = xVar.ch()) == null) {
            return null;
        }
        return kaVarCh.ka();
    }

    private void ny() {
        if (isShown()) {
            int iMs = com.bytedance.sdk.component.adexpress.dynamic.xr.ms.ms(this.sl);
            if (iMs == 2) {
                if (this.nw == null) {
                    this.nw = new b(getContext().getApplicationContext(), 1, this.b);
                }
                this.nw.ms(new b.ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.b.ms
                    public void ms(int i2) {
                        if (i2 == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.ch();
                        }
                    }
                });
                zb renderRequest = this.u.getRenderRequest();
                if (renderRequest != null) {
                    this.nw.ms(renderRequest.qv());
                    this.nw.ka(renderRequest.i());
                    this.nw.ah(renderRequest.b());
                    this.nw.xr(renderRequest.t());
                    this.nw.c(renderRequest.w());
                    this.nw.ms(renderRequest.nw());
                    this.nw.xr(renderRequest.re());
                }
            } else if (iMs == 3) {
                if (this.nw == null) {
                    this.nw = new b(getContext().getApplicationContext(), 2, this.b);
                }
                this.nw.ms(new b.ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.b.ms
                    public void ms(int i2) {
                        if (i2 == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.ch();
                        }
                    }
                });
                zb renderRequest2 = this.u.getRenderRequest();
                if (renderRequest2 != null) {
                    this.nw.xr(renderRequest2.t());
                    this.nw.c(renderRequest2.w());
                    this.nw.ms(renderRequest2.nw());
                    this.nw.xr(renderRequest2.re());
                }
            }
            b bVar = this.nw;
            if (bVar != null) {
                DynamicRootView dynamicRootView = this.u;
                if (dynamicRootView != null) {
                    zb renderRequest3 = dynamicRootView.getRenderRequest();
                    if (renderRequest3 != null) {
                        this.nw.ms(renderRequest3.cv());
                        return;
                    }
                    return;
                }
                bVar.ms(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        try {
            View view = this.ub;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(i);
        } catch (Exception unused) {
        }
    }

    public void setCanUseSensor(boolean z) {
        this.b = z;
    }
}
