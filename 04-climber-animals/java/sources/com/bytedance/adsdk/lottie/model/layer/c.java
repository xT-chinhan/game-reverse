package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ab {
    private final List<String> ch;
    private final List<TextView> hi;
    private final LinearLayout.LayoutParams ny;
    private String sl;
    private LinearLayout x;

    public c(com.bytedance.adsdk.lottie.x xVar, x xVar2, Context context) {
        List<com.bytedance.adsdk.lottie.ny.xr> listAh;
        super(xVar, xVar2);
        this.ny = new LinearLayout.LayoutParams(-2, -2);
        this.ch = new ArrayList();
        this.hi = new ArrayList();
        if (this.ab == null || (listAh = this.ab.ah()) == null || listAh.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.x = linearLayout;
        int i = 0;
        linearLayout.setOrientation(0);
        xr(listAh.get(0).ny);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.x.addView(linearLayout2);
        List<String> listU = u();
        while (i < listAh.size()) {
            com.bytedance.adsdk.lottie.ny.xr xrVar = listAh.get(i);
            TextView textView = new TextView(context);
            ms(textView, xrVar, (listU == null || i >= listU.size()) ? "" : listU.get(i));
            if (xrVar.x != 0) {
                this.ny.bottomMargin = (int) (xrVar.x * com.bytedance.adsdk.lottie.ka.ny.ms());
                linearLayout2.addView(textView, this.ny);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        ms(this.x, (int) (this.ab.ms() * fMs), (int) (this.ab.xr() * fMs));
    }

    private void xr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.x.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.x.setGravity(3);
        } else if (str.equals("right")) {
            this.x.setGravity(5);
        } else {
            this.x.setGravity(17);
        }
    }

    private void ms(TextView textView, com.bytedance.adsdk.lottie.ny.xr xrVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        if (!TextUtils.isEmpty(xrVar.ah)) {
            textView.setTextColor(Color.parseColor(xrVar.ah));
        } else if (!TextUtils.isEmpty(xrVar.d)) {
            textView.setTextColor(Color.parseColor(xrVar.d));
        }
        if (!TextUtils.isEmpty(xrVar.ka)) {
            textView.setBackgroundColor(Color.parseColor(xrVar.ka));
        }
        if (xrVar.ab == 0) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(xrVar.c);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ab, com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        if (this.x != null) {
            canvas.save();
            canvas.concat(matrix);
            ms(i);
            ah(x());
            this.x.draw(canvas);
            canvas.restore();
            return;
        }
        super.xr(canvas, matrix, i);
    }

    private void ah(float f) {
        List<com.bytedance.adsdk.lottie.ny.xr> listAh;
        if (this.ab == null || (listAh = this.ab.ah()) == null || listAh.size() <= 0) {
            return;
        }
        this.x.setOrientation(0);
        this.x.setGravity(17);
        if (this.x.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.x.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.x.removeAllViews();
        if (linearLayout.getChildCount() != listAh.size()) {
            return;
        }
        List<String> listU = u();
        this.hi.clear();
        int i = 0;
        while (i < listAh.size()) {
            com.bytedance.adsdk.lottie.ny.xr xrVar = listAh.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.hi.add(textView);
            ms(textView, xrVar, (listU == null || i >= listU.size()) ? "" : listU.get(i));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listAh.size(); i2++) {
            com.bytedance.adsdk.lottie.ny.xr xrVar2 = listAh.get(i2);
            TextView textView2 = this.hi.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            if (xrVar2.x != 0) {
                this.ny.bottomMargin = (int) (xrVar2.x * com.bytedance.adsdk.lottie.ka.ny.ms());
                linearLayout.addView(textView2, this.ny);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.x.setAlpha(f);
        this.x.addView(linearLayout);
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        ms(this.x, (int) (this.ab.ms() * fMs), (int) (this.ab.xr() * fMs));
    }

    private List<String> u() {
        t tVarW;
        List<com.bytedance.adsdk.lottie.ny.xr> listAh;
        if (this.ab == null || this.xr == null || (tVarW = this.xr.w()) == null) {
            return null;
        }
        String strD = this.ab.d();
        if ((!TextUtils.isEmpty(strD) || !TextUtils.isEmpty(this.sl)) && (listAh = this.ab.ah()) != null) {
            String strMs = this.sl;
            if (TextUtils.isEmpty(strMs)) {
                strMs = tVarW.ms(strD);
            }
            if (!TextUtils.isEmpty(strMs)) {
                int length = strMs.length();
                this.ch.clear();
                for (int i = 0; i < listAh.size(); i++) {
                    com.bytedance.adsdk.lottie.ny.xr xrVar = listAh.get(i);
                    int iMax = xrVar.f268ms;
                    int iMax2 = xrVar.xr;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.ch.add("");
                    } else {
                        if (listAh.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.ch.add(strMs.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.ch;
            }
        }
        return null;
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void ms(String str) {
        this.sl = str;
    }
}
