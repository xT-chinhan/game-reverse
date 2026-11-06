package com.byazt.eg;

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
import com.byazt.pp.py;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 13})
public class w extends x {
    public int a;
    public SpannableStringBuilder cd;
    public final List<TextView> cp;
    public n cy;
    public String d;
    public LinearLayout fs;
    public SpannableStringBuilder hd;
    public boolean k;
    public List<String> oa;
    public com.byazt.pp.rv.qg ou;
    public Camera py;
    public final LinearLayout.LayoutParams rv;
    public float sz;
    public final List<String> tj;
    public int um;

    public w(com.byazt.pp.fs fsVar, fs fsVar2, Context context) {
        List<com.byazt.pp.rv.s> listS;
        super(fsVar, fsVar2);
        this.rv = new LinearLayout.LayoutParams(-2, -2);
        this.tj = new ArrayList();
        this.cp = new ArrayList();
        this.sz = -1.0f;
        this.k = true;
        if (this.x == null || (listS = this.x.s()) == null || listS.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.fs = linearLayout;
        linearLayout.setOrientation(0);
        qg(listS.get(0).tj);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.fs.addView(linearLayout2);
        List<String> listK = k();
        int i = 0;
        while (i < listS.size()) {
            com.byazt.pp.rv.s sVar = listS.get(i);
            TextView textView = new TextView(context);
            n(textView, sVar, (listK == null || i >= listK.size()) ? "" : listK.get(i), i, listS.size() - 1, listS.get(0));
            if (sVar.rv != 0) {
                this.rv.bottomMargin = (int) (sVar.rv * com.byazt.nu.tj.n());
                linearLayout2.addView(textView, this.rv);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fN = com.byazt.nu.tj.n();
        this.um = (int) (this.x.n() * fN);
        int iQg = (int) (this.x.qg() * fN);
        this.a = iQg;
        n(this.fs, this.um, iQg);
        com.byazt.pp.rv.qg qgVarCp = this.x.cp();
        this.ou = qgVarCp;
        if (qgVarCp != null) {
            this.py = new Camera();
        }
    }

    private void qg(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fs.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.fs.setGravity(19);
        } else if (str.equals("right")) {
            this.fs.setGravity(21);
        } else {
            this.fs.setGravity(17);
        }
    }

    private void n(TextView textView, com.byazt.pp.rv.s sVar, String str, int i, int i2, com.byazt.pp.rv.s sVar2) {
        py pyVarHu;
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            str = "";
            textView.setText("");
        }
        if (!TextUtils.isEmpty(sVar.s)) {
            textView.setTextColor(Color.parseColor(sVar.s));
        } else if (!TextUtils.isEmpty(sVar.q)) {
            textView.setTextColor(Color.parseColor(sVar.q));
        }
        if (!TextUtils.isEmpty(sVar.l)) {
            textView.setBackgroundColor(Color.parseColor(sVar.l));
        }
        if (sVar.fs == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, sVar.w);
        if (!TextUtils.isEmpty(sVar.x) && this.qg != null && (pyVarHu = this.qg.hu()) != null) {
            try {
                int i3 = Integer.parseInt(pyVarHu.n(sVar.x));
                if (i3 > 0) {
                    textView.setTextSize(1, i3);
                }
            } catch (Throwable unused) {
            }
        }
        if (sVar.cp != null && sVar.cp.n > 0 && !TextUtils.isEmpty(sVar.cp.qg)) {
            if (this.hd == null) {
                this.hd = new SpannableStringBuilder(str);
            }
            if (this.cy == null) {
                this.cy = new n();
            }
            this.cy.qg = Color.parseColor(sVar.cp.qg);
            this.cy.s = sVar.cp.n * com.byazt.nu.tj.n();
            this.hd.clear();
            this.hd.clearSpans();
            this.hd.append((CharSequence) str);
            this.hd.setSpan(this.cy, 0, str.length(), 33);
            textView.setText(this.hd);
        }
        if (sVar.d != null && sVar.d.n > 0 && !TextUtils.isEmpty(sVar.d.qg)) {
            if (this.cd == null) {
                this.cd = new SpannableStringBuilder(str);
            }
            if (this.cy == null) {
                this.cy = new n();
            }
            this.cy.q = Color.parseColor(sVar.d.qg);
            this.cy.l = sVar.d.n * com.byazt.nu.tj.n();
            this.cd.clear();
            this.cd.clearSpans();
            this.cd.append((CharSequence) str);
            this.cd.setSpan(this.cy, 0, str.length(), 33);
            textView.setText(this.cd);
        }
        if (sVar2.sz > 0) {
            textView.setMaxLines(sVar2.sz);
            if (sVar2.oa == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (sVar2.oa == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (sVar2.oa == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override // com.byazt.eg.x, com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        View childAt;
        if (this.fs != null) {
            canvas.save();
            canvas.concat(matrix);
            n(i);
            s(fs());
            if (this.py != null && (this.ou.n != 0 || this.ou.qg != 0 || this.ou.s != 0)) {
                int width = this.um >> 1;
                int height = this.a >> 1;
                if (this.fs.getChildCount() > 0 && (childAt = this.fs.getChildAt(0)) != null) {
                    int left = childAt.getLeft() - this.fs.getLeft();
                    int top = childAt.getTop() - this.fs.getTop();
                    width = left + (childAt.getWidth() >> 1);
                    height = top + (childAt.getHeight() >> 1);
                }
                canvas.translate(width, height);
                if (this.ou.n != 0 || this.ou.qg != 0) {
                    this.py.save();
                    if (this.ou.n != 0) {
                        this.py.rotateX(this.ou.n);
                    }
                    if (this.ou.qg != 0) {
                        this.py.rotateY(this.ou.qg);
                    }
                    this.py.applyToCanvas(canvas);
                    this.py.restore();
                }
                if (this.ou.s != 0) {
                    canvas.rotate(this.ou.s);
                }
                canvas.translate(-width, -height);
            }
            this.fs.draw(canvas);
            canvas.restore();
            return;
        }
        super.qg(canvas, matrix, i);
    }

    private void s(float f) {
        List<com.byazt.pp.rv.s> listS;
        if (this.x == null || (listS = this.x.s()) == null || listS.size() <= 0) {
            return;
        }
        List<String> listK = k();
        boolean z = this.k || !qg(this.oa, listK);
        boolean z2 = Float.compare(this.sz, f) != 0;
        if (z || z2) {
            if (!z) {
                q(f);
                this.sz = f;
                return;
            }
            this.fs.setOrientation(0);
            qg(listS.get(0).tj);
            if (this.fs.getChildCount() <= 0) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.fs.getChildAt(0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(80);
            this.fs.removeAllViews();
            if (linearLayout.getChildCount() != listS.size()) {
                return;
            }
            this.cp.clear();
            int i = 0;
            while (i < listS.size()) {
                com.byazt.pp.rv.s sVar = listS.get(i);
                TextView textView = (TextView) linearLayout.getChildAt(i);
                this.cp.add(textView);
                n(textView, sVar, (listK == null || i >= listK.size()) ? "" : listK.get(i), i, listS.size() - 1, listS.get(0));
                i++;
            }
            linearLayout.removeAllViews();
            for (int i2 = 0; i2 < listS.size(); i2++) {
                com.byazt.pp.rv.s sVar2 = listS.get(i2);
                TextView textView2 = this.cp.get(i2);
                textView2.setAlpha(f);
                linearLayout.setAlpha(f);
                if (sVar2.rv != 0) {
                    this.rv.bottomMargin = (int) (sVar2.rv * com.byazt.nu.tj.n());
                    linearLayout.addView(textView2, this.rv);
                } else {
                    linearLayout.addView(textView2);
                }
            }
            this.fs.setAlpha(f);
            this.fs.addView(linearLayout);
            n(this.fs, this.um, this.a);
            this.oa = listK != null ? new ArrayList(listK) : null;
            this.sz = f;
            this.k = false;
        }
    }

    private void q(float f) {
        if (this.fs.getChildCount() > 0) {
            View childAt = this.fs.getChildAt(0);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                linearLayout.setAlpha(f);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    linearLayout.getChildAt(i).setAlpha(f);
                }
            }
        }
        this.fs.setAlpha(f);
    }

    private boolean qg(List<String> list, List<String> list2) {
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

    private List<String> k() {
        py pyVarHu;
        List<com.byazt.pp.rv.s> listS;
        if (this.x == null || this.qg == null || (pyVarHu = this.qg.hu()) == null) {
            return null;
        }
        String strQ = this.x.q();
        if ((!TextUtils.isEmpty(strQ) || !TextUtils.isEmpty(this.d)) && (listS = this.x.s()) != null) {
            String strN = this.d;
            if (TextUtils.isEmpty(strN)) {
                strN = pyVarHu.n(strQ);
            }
            if (!TextUtils.isEmpty(strN)) {
                int length = strN.length();
                this.tj.clear();
                for (int i = 0; i < listS.size(); i++) {
                    com.byazt.pp.rv.s sVar = listS.get(i);
                    int iMax = sVar.n;
                    int iMax2 = sVar.qg;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.tj.add("");
                    } else {
                        if (listS.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.tj.add(strN.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.tj;
            }
        }
        return null;
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void n(String str) {
        if (TextUtils.equals(this.d, str)) {
            return;
        }
        this.d = str;
        this.k = true;
    }

    @com.byazt.cp.n(n = {0, 1, 959, 108})
    public static class n implements LineBackgroundSpan {
        public float l;
        public final Paint n = new Paint();
        public int q;
        public int qg;
        public float s;

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.s > 0.0f) {
                this.n.setColor(this.qg);
                this.n.setStrokeWidth(this.s);
                float f = i4 + this.s;
                canvas.drawLine(i, f, i2, f, this.n);
            }
            if (this.l > 0.0f) {
                this.n.setColor(this.q);
                this.n.setStrokeWidth(this.l);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.n);
            }
        }
    }
}
