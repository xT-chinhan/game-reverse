package com.byazt.cg;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.dx.cz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 5})
public class uc extends fw {
    public int a;
    public final LinearLayout.LayoutParams aj;
    public Camera cz;
    public float g;
    public boolean ho;
    public String k;
    public SpannableStringBuilder lb;
    public List<String> m;
    public pr nt;
    public com.byazt.dx.aj.hw ny;
    public int qa;
    public final List<String> vk;
    public final List<TextView> w;
    public SpannableStringBuilder yb;
    public LinearLayout zo;

    public uc(com.byazt.dx.zo zoVar, zo zoVar2, Context context) {
        List<com.byazt.dx.aj.hn> listHn;
        super(zoVar, zoVar2);
        this.aj = new LinearLayout.LayoutParams(-2, -2);
        this.vk = new ArrayList();
        this.w = new ArrayList();
        this.g = -1.0f;
        this.ho = true;
        if (this.fw != null && (listHn = this.fw.hn()) != null && listHn.size() > 0) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.zo = linearLayout;
            linearLayout.setOrientation(0);
            hw(listHn.get(0).vk);
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(80);
            this.zo.addView(linearLayout2);
            List<String> listHo = ho();
            int i = 0;
            while (i < listHn.size()) {
                com.byazt.dx.aj.hn hnVar = listHn.get(i);
                TextView textView = new TextView(context);
                pr(textView, hnVar, (listHo == null || i >= listHo.size()) ? "" : listHo.get(i), i, listHn.size() - 1, listHn.get(0));
                if (hnVar.aj != 0) {
                    this.aj.bottomMargin = (int) (hnVar.aj * com.byazt.ptr.vk.pr());
                    linearLayout2.addView(textView, this.aj);
                } else {
                    linearLayout2.addView(textView);
                }
                i++;
            }
            float fPr = com.byazt.ptr.vk.pr();
            this.qa = (int) (this.fw.pr() * fPr);
            int iHw = (int) (this.fw.hw() * fPr);
            this.a = iHw;
            pr(this.zo, this.qa, iHw);
            com.byazt.dx.aj.hw hwVarW = this.fw.w();
            this.ny = hwVarW;
            if (hwVarW != null) {
                this.cz = new Camera();
            }
        }
    }

    private void hw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zo.setGravity(17);
        }
        switch (str) {
            case "left":
                this.zo.setGravity(19);
                break;
            case "right":
                this.zo.setGravity(21);
                break;
            default:
                this.zo.setGravity(17);
                break;
        }
    }

    private void pr(TextView textView, com.byazt.dx.aj.hn hnVar, String str, int i, int i2, com.byazt.dx.aj.hn hnVar2) {
        cz czVarZ;
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("");
            str = "";
        }
        if (!TextUtils.isEmpty(hnVar.hn)) {
            textView.setTextColor(Color.parseColor(hnVar.hn));
        } else if (!TextUtils.isEmpty(hnVar.x)) {
            textView.setTextColor(Color.parseColor(hnVar.x));
        }
        if (!TextUtils.isEmpty(hnVar.c)) {
            textView.setBackgroundColor(Color.parseColor(hnVar.c));
        }
        if (hnVar.zo == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, hnVar.uc);
        if (!TextUtils.isEmpty(hnVar.fw) && this.hw != null && (czVarZ = this.hw.z()) != null) {
            try {
                int i3 = Integer.parseInt(czVarZ.pr(hnVar.fw));
                if (i3 > 0) {
                    textView.setTextSize(1, i3);
                }
            } catch (Throwable th) {
            }
        }
        if (hnVar.w != null && hnVar.w.pr > 0 && !TextUtils.isEmpty(hnVar.w.hw)) {
            if (this.yb == null) {
                this.yb = new SpannableStringBuilder(str);
            }
            if (this.nt == null) {
                this.nt = new pr();
            }
            this.nt.hw = Color.parseColor(hnVar.w.hw);
            this.nt.hn = hnVar.w.pr * com.byazt.ptr.vk.pr();
            this.yb.clear();
            this.yb.clearSpans();
            this.yb.append((CharSequence) str);
            this.yb.setSpan(this.nt, 0, str.length(), 33);
            textView.setText(this.yb);
        }
        if (hnVar.k != null && hnVar.k.pr > 0 && !TextUtils.isEmpty(hnVar.k.hw)) {
            if (this.lb == null) {
                this.lb = new SpannableStringBuilder(str);
            }
            if (this.nt == null) {
                this.nt = new pr();
            }
            this.nt.x = Color.parseColor(hnVar.k.hw);
            this.nt.c = hnVar.k.pr * com.byazt.ptr.vk.pr();
            this.lb.clear();
            this.lb.clearSpans();
            this.lb.append((CharSequence) str);
            this.lb.setSpan(this.nt, 0, str.length(), 33);
            textView.setText(this.lb);
        }
        if (hnVar2.g > 0) {
            textView.setMaxLines(hnVar2.g);
            if (hnVar2.m == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (hnVar2.m == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (hnVar2.m == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override // com.byazt.cg.fw, com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        View childAt;
        if (this.zo != null) {
            canvas.save();
            canvas.concat(matrix);
            pr(i);
            hn(zo());
            if (this.cz != null && (this.ny.pr != 0 || this.ny.hw != 0 || this.ny.hn != 0)) {
                int width = this.qa >> 1;
                int height = this.a >> 1;
                if (this.zo.getChildCount() > 0 && (childAt = this.zo.getChildAt(0)) != null) {
                    int left = childAt.getLeft() - this.zo.getLeft();
                    int top = childAt.getTop() - this.zo.getTop();
                    width = left + (childAt.getWidth() >> 1);
                    height = top + (childAt.getHeight() >> 1);
                }
                canvas.translate(width, height);
                if (this.ny.pr != 0 || this.ny.hw != 0) {
                    this.cz.save();
                    if (this.ny.pr != 0) {
                        this.cz.rotateX(this.ny.pr);
                    }
                    if (this.ny.hw != 0) {
                        this.cz.rotateY(this.ny.hw);
                    }
                    this.cz.applyToCanvas(canvas);
                    this.cz.restore();
                }
                if (this.ny.hn != 0) {
                    canvas.rotate(this.ny.hn);
                }
                canvas.translate(-width, -height);
            }
            this.zo.draw(canvas);
            canvas.restore();
            return;
        }
        super.hw(canvas, matrix, i);
    }

    private void hn(float f) {
        List<com.byazt.dx.aj.hn> listHn;
        if (this.fw != null && (listHn = this.fw.hn()) != null && listHn.size() > 0) {
            List<String> listHo = ho();
            boolean z = this.ho || !hw(this.m, listHo);
            boolean z2 = Float.compare(this.g, f) != 0;
            if (!z && !z2) {
                return;
            }
            if (!z) {
                x(f);
                this.g = f;
                return;
            }
            this.zo.setOrientation(0);
            hw(listHn.get(0).vk);
            if (this.zo.getChildCount() <= 0) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.zo.getChildAt(0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(80);
            this.zo.removeAllViews();
            if (linearLayout.getChildCount() != listHn.size()) {
                return;
            }
            this.w.clear();
            int i = 0;
            while (i < listHn.size()) {
                com.byazt.dx.aj.hn hnVar = listHn.get(i);
                TextView textView = (TextView) linearLayout.getChildAt(i);
                this.w.add(textView);
                pr(textView, hnVar, (listHo == null || i >= listHo.size()) ? "" : listHo.get(i), i, listHn.size() - 1, listHn.get(0));
                i++;
            }
            linearLayout.removeAllViews();
            for (int i2 = 0; i2 < listHn.size(); i2++) {
                com.byazt.dx.aj.hn hnVar2 = listHn.get(i2);
                TextView textView2 = this.w.get(i2);
                textView2.setAlpha(f);
                linearLayout.setAlpha(f);
                if (hnVar2.aj != 0) {
                    this.aj.bottomMargin = (int) (hnVar2.aj * com.byazt.ptr.vk.pr());
                    linearLayout.addView(textView2, this.aj);
                } else {
                    linearLayout.addView(textView2);
                }
            }
            this.zo.setAlpha(f);
            this.zo.addView(linearLayout);
            pr(this.zo, this.qa, this.a);
            this.m = listHo != null ? new ArrayList(listHo) : null;
            this.g = f;
            this.ho = false;
        }
    }

    private void x(float f) {
        if (this.zo.getChildCount() > 0) {
            View childAt = this.zo.getChildAt(0);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                linearLayout.setAlpha(f);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    linearLayout.getChildAt(i).setAlpha(f);
                }
            }
        }
        this.zo.setAlpha(f);
    }

    private boolean hw(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<String> ho() {
        cz czVarZ;
        List<com.byazt.dx.aj.hn> listHn;
        if (this.fw == null || this.hw == null || (czVarZ = this.hw.z()) == null) {
            return null;
        }
        String strX = this.fw.x();
        if ((!TextUtils.isEmpty(strX) || !TextUtils.isEmpty(this.k)) && (listHn = this.fw.hn()) != null) {
            String strPr = this.k;
            if (TextUtils.isEmpty(strPr)) {
                strPr = czVarZ.pr(strX);
            }
            if (!TextUtils.isEmpty(strPr)) {
                int length = strPr.length();
                this.vk.clear();
                for (int i = 0; i < listHn.size(); i++) {
                    com.byazt.dx.aj.hn hnVar = listHn.get(i);
                    int iMax = hnVar.pr;
                    int iMax2 = hnVar.hw;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.vk.add("");
                    } else {
                        if (listHn.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.vk.add(strPr.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.vk;
            }
        }
        return null;
    }

    private static void pr(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void pr(String str) {
        if (!TextUtils.equals(this.k, str)) {
            this.k = str;
            this.ho = true;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 129})
    public static class pr implements LineBackgroundSpan {
        public float c;
        public float hn;
        public int hw;
        public final Paint pr = new Paint();
        public int x;

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.hn > 0.0f) {
                this.pr.setColor(this.hw);
                this.pr.setStrokeWidth(this.hn);
                float f = i4 + this.hn;
                canvas.drawLine(i, f, i2, f, this.pr);
            }
            if (this.c > 0.0f) {
                this.pr.setColor(this.x);
                this.pr.setStrokeWidth(this.c);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.pr);
            }
        }
    }
}
