package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.ca.ny;
import com.byazt.mq.m;
import com.byazt.rk.fw;
import com.byazt.rk.uc;
import com.byazt.rk.zo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1712})
public abstract class DynamicBaseWidget extends FrameLayout implements com.byazt.vry.hw, c, x {
    public static final View.OnTouchListener fo = new View.OnTouchListener() { // from class: com.byazt.gx.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    public static final View.OnClickListener rc = new View.OnClickListener() { // from class: com.byazt.gx.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    public float a;
    public int aj;
    public float c;
    public ny cz;
    public int fw;
    public DynamicRootView g;
    public float hn;
    public View ho;
    public float hw;
    public fw k;
    public com.byazt.vry.pr lb;
    public zo m;
    public boolean nt;
    public boolean ny;
    public float pr;
    public float qa;
    public float uc;
    public int vk;
    public Context w;
    public float x;
    public com.byazt.hv.hw yb;
    public int zo;

    @Override // com.byazt.vry.hw
    public float getShineValue() {
        return this.hw;
    }

    public void setShineValue(float f) {
        this.hw = f;
        postInvalidate();
    }

    @Override // com.byazt.vry.hw
    public float getRippleValue() {
        return this.pr;
    }

    public void setRippleValue(float f) {
        this.pr = f;
        postInvalidate();
    }

    @Override // com.byazt.vry.hw
    public float getMarqueeValue() {
        return this.qa;
    }

    public void setMarqueeValue(float f) {
        this.qa = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.a;
    }

    public void setStretchValue(float f) {
        this.a = f;
        this.lb.pr(this, f);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context);
        this.ny = true;
        this.w = context;
        this.g = dynamicRootView;
        this.m = zoVar;
        this.hn = zoVar.uc();
        this.x = zoVar.fw();
        this.c = zoVar.zo();
        this.uc = zoVar.aj();
        this.aj = (int) com.byazt.js.zo.pr(this.w, this.hn);
        this.vk = (int) com.byazt.js.zo.pr(this.w, this.x);
        this.fw = (int) com.byazt.js.zo.pr(this.w, this.c);
        this.zo = (int) com.byazt.js.zo.pr(this.w, this.uc);
        fw fwVar = new fw(zoVar.vk());
        this.k = fwVar;
        if (fwVar.lb() > 0) {
            this.fw += this.k.lb() * 2;
            this.zo += this.k.lb() * 2;
            this.aj -= this.k.lb();
            this.vk -= this.k.lb();
            List<zo> listW = zoVar.w();
            if (listW != null) {
                for (zo zoVar2 : listW) {
                    zoVar2.hn(zoVar2.uc() + com.byazt.js.zo.hw(this.w, this.k.lb()));
                    zoVar2.x(zoVar2.fw() + com.byazt.js.zo.hw(this.w, this.k.lb()));
                    zoVar2.pr(com.byazt.js.zo.hw(this.w, this.k.lb()));
                    zoVar2.hw(com.byazt.js.zo.hw(this.w, this.k.lb()));
                }
            }
        }
        this.nt = this.k.g() > 0.0d;
        this.lb = new com.byazt.vry.pr();
    }

    public void setShouldInvisible(boolean z) {
        this.nt = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.nt;
    }

    public boolean pr() {
        zo();
        c();
        hn();
        return true;
    }

    public void pr(int i) {
        fw fwVar = this.k;
        if (fwVar == null || !fwVar.pr(i)) {
            return;
        }
        zo();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                ((DynamicBaseWidget) childAt).pr(i);
            }
        }
    }

    public boolean hn() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.ho;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (x()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = fo;
            onClickListener = rc;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iPr = com.byazt.we.pr.pr(this.k);
            if (iPr == 2 || iPr == 3) {
                view2.setOnClickListener(rc);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        pr(view2);
        hw(view2);
        return true;
    }

    public void pr(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.m.zo());
            jSONObject.put("height", this.m.aj());
            if (com.byazt.dj.x.pr()) {
                view.setTag(com.byazt.imd.pr.a, this.k.ls());
                view.setTag(com.byazt.imd.pr.cz, this.m.vk().getType());
                view.setTag(com.byazt.imd.pr.ny, this.m.hn());
                view.setTag(com.byazt.imd.pr.fo, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.k.ls());
            view.setTag(2097610715, this.m.vk().getType());
            view.setTag(2097610714, this.m.hn());
            view.setTag(2097610713, jSONObject.toString());
            int iPr = com.byazt.we.pr.pr(this.k);
            if (iPr == 1) {
                view.setTag(2097610707, new Pair(this.k.z(), Long.valueOf(this.k.b())));
                view.setTag(2097610708, Integer.valueOf(iPr));
            }
        } catch (JSONException e) {
        }
    }

    public void hw(View view) {
        uc ucVarC;
        zo zoVar = this.m;
        if (zoVar != null && (ucVarC = zoVar.vk().c()) != null) {
            view.setTag(2097610716, Boolean.valueOf(ucVarC.h()));
        }
    }

    public boolean x() {
        fw fwVar = this.k;
        if (fwVar == null || fwVar.iu() == 0) {
            return false;
        }
        return true;
    }

    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
        layoutParams.topMargin = this.vk;
        layoutParams.leftMargin = this.aj;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.k.iu();
    }

    public String getImageObjectFit() {
        return this.k.f();
    }

    public com.byazt.mft.pr getDynamicClickListener() {
        return this.g.getDynamicClickListener();
    }

    public Drawable getBackgroundDrawable() {
        return pr(false, "");
    }

    public Drawable pr(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iVe;
        if (!TextUtils.isEmpty(this.k.s())) {
            try {
                String strS = this.k.s();
                String strSubstring = strS.substring(strS.indexOf("(") + 1, strS.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{fw.pr(strArrSplit[1]), fw.pr(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{fw.pr(strArrSplit[1].substring(0, 7)), fw.pr(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception e) {
                }
                GradientDrawable gradientDrawablePr = pr(pr(strArrSplit[0]), iArr);
                gradientDrawablePr.setShape(0);
                gradientDrawablePr.setCornerRadius(com.byazt.js.zo.pr(this.w, this.k.ho()));
                return gradientDrawablePr;
            } catch (Exception e2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fPr = com.byazt.js.zo.pr(this.w, this.k.ho());
        drawable.setCornerRadius(fPr);
        if (fPr < 1.0f) {
            float fPr2 = com.byazt.js.zo.pr(this.w, this.k.nl());
            float fPr3 = com.byazt.js.zo.pr(this.w, this.k.y());
            float fPr4 = com.byazt.js.zo.pr(this.w, this.k.ww());
            float fPr5 = com.byazt.js.zo.pr(this.w, this.k.n());
            float[] fArr = new float[8];
            if (fPr2 > 0.0f) {
                fArr[0] = fPr2;
                fArr[1] = fPr2;
            }
            if (fPr3 > 0.0f) {
                fArr[2] = fPr3;
                fArr[3] = fPr3;
            }
            if (fPr4 > 0.0f) {
                fArr[4] = fPr4;
                fArr[5] = fPr4;
            }
            if (fPr5 > 0.0f) {
                fArr[6] = fPr5;
                fArr[7] = fPr5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iVe = Color.parseColor(str);
        } else {
            iVe = this.k.ve();
        }
        drawable.setColor(iVe);
        if (this.k.yb() > 0.0f) {
            drawable.setStroke((int) com.byazt.js.zo.pr(this.w, this.k.yb()), this.k.nt());
        } else if (this.k.lb() > 0) {
            drawable.setStroke(this.k.lb(), this.k.nt());
            drawable.setAlpha(50);
            if (TextUtils.equals(this.m.vk().getType(), "video-vd")) {
                setLayerType(1, null);
                return new hn((int) fPr, this.k.lb());
            }
        }
        return drawable;
    }

    public hw pr(Bitmap bitmap) {
        return new pr(bitmap, null);
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(pr(hw(this.k.s().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception e) {
            return null;
        }
    }

    private Drawable[] pr(List<String> list) {
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
                    iArr[i2] = fw.pr(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawablePr = pr(pr(strArrSplit[0]), iArr);
                gradientDrawablePr.setShape(0);
                gradientDrawablePr.setCornerRadius(com.byazt.js.zo.pr(this.w, this.k.ho()));
                drawableArr[(list.size() - 1) - i] = gradientDrawablePr;
            }
        }
        return drawableArr;
    }

    private List<String> hw(String str) {
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

    public GradientDrawable pr(GradientDrawable.Orientation orientation, int[] iArr) {
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

    public GradientDrawable.Orientation pr(String str) {
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
        } catch (Exception e) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.lb.pr(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.vry.pr prVar = this.lb;
        View view = this.ho;
        if (view == null) {
            view = this;
        }
        prVar.pr(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uc();
        aj();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.cz != null) {
            DynamicRootView dynamicRootView = this.g;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.cz.pr(0);
                    return;
                } else {
                    this.cz.hw(0);
                    return;
                }
            }
            if (z) {
                this.cz.pr(this.g.getRenderRequest().ve());
            } else {
                this.cz.hw(this.g.getRenderRequest().ve());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        hw();
        super.onDetachedFromWindow();
        if (this.cz != null) {
            DynamicRootView dynamicRootView = this.g;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.cz.hw(this.g.getRenderRequest().ve());
            } else {
                this.cz.hw(0);
            }
        }
    }

    public void uc() {
        if (fw()) {
            return;
        }
        View view = this.ho;
        if (view == null) {
            view = this;
        }
        com.byazt.hv.hw hwVar = new com.byazt.hv.hw(view, this.m.vk().c().sr());
        this.yb = hwVar;
        hwVar.pr();
    }

    public void hw() {
        com.byazt.hv.hw hwVar = this.yb;
        if (hwVar != null) {
            hwVar.hw();
        }
    }

    public boolean fw() {
        zo zoVar = this.m;
        return zoVar == null || zoVar.vk() == null || this.m.vk().c() == null || this.m.vk().c().sr() == null;
    }

    public int getDynamicWidth() {
        return this.fw;
    }

    public int getDynamicHeight() {
        return this.zo;
    }

    public uc getDynamicLayoutBrickValue() {
        com.byazt.rk.c cVarVk;
        zo zoVar = this.m;
        if (zoVar == null || (cVarVk = zoVar.vk()) == null) {
            return null;
        }
        return cVarVk.c();
    }

    private void aj() {
        if (!isShown()) {
            return;
        }
        int iPr = com.byazt.we.pr.pr(this.k);
        if (iPr == 2) {
            if (this.cz == null) {
                this.cz = new ny(getContext().getApplicationContext(), 1, this.ny);
            }
            this.cz.pr(new ny.pr() { // from class: com.byazt.gx.DynamicBaseWidget.3
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    if (i == 1 && DynamicBaseWidget.this.isShown()) {
                        DynamicBaseWidget.this.vk();
                    }
                }
            });
            m renderRequest = this.g.getRenderRequest();
            if (renderRequest != null) {
                this.cz.pr(renderRequest.yb());
                this.cz.c(renderRequest.fo());
                this.cz.hn(renderRequest.cz());
                this.cz.hw(renderRequest.qa());
                this.cz.uc(renderRequest.rc());
                this.cz.pr(renderRequest.a());
                this.cz.hw(renderRequest.ny());
            }
        } else if (iPr == 3) {
            if (this.cz == null) {
                this.cz = new ny(getContext().getApplicationContext(), 2, this.ny);
            }
            this.cz.pr(new ny.pr() { // from class: com.byazt.gx.DynamicBaseWidget.4
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    if (i == 2 && DynamicBaseWidget.this.isShown()) {
                        DynamicBaseWidget.this.vk();
                    }
                }
            });
            m renderRequest2 = this.g.getRenderRequest();
            if (renderRequest2 != null) {
                this.cz.hw(renderRequest2.qa());
                this.cz.uc(renderRequest2.rc());
                this.cz.pr(renderRequest2.a());
                this.cz.hw(renderRequest2.ny());
            }
        }
        ny nyVar = this.cz;
        if (nyVar != null) {
            DynamicRootView dynamicRootView = this.g;
            if (dynamicRootView != null) {
                m renderRequest3 = dynamicRootView.getRenderRequest();
                if (renderRequest3 != null) {
                    this.cz.pr(renderRequest3.ve());
                    return;
                }
                return;
            }
            nyVar.pr(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        try {
            View view = this.ho;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(rc);
        } catch (Exception e) {
        }
    }

    public void setCanUseSensor(boolean z) {
        this.ny = z;
    }
}
