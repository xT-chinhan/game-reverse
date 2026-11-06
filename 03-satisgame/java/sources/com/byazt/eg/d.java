package com.byazt.eg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.byazt.aw.cy;
import com.byazt.bd.k;
import com.byazt.pp.py;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 113})
public class d extends s {
    public com.byazt.bd.n<Integer, Integer> a;
    public String bb;
    public final com.byazt.pp.w cd;
    public final Paint cp;
    public final k cy;
    public final Map<com.byazt.ld.q, List<com.byazt.sp.q>> d;
    public final RectF fs;
    public com.byazt.bd.n<Float, Float> h;
    public final com.byazt.pp.fs hd;
    public com.byazt.bd.n<Float, Float> hu;
    public int k;
    public com.byazt.bd.n<Float, Float> m;
    public final LongSparseArray<String> oa;
    public com.byazt.bd.n<Integer, Integer> ou;
    public com.byazt.bd.n<Integer, Integer> py;
    public final Matrix rv;
    public final List<n> sz;
    public com.byazt.bd.n<Float, Float> t;
    public final Paint tj;
    public com.byazt.bd.n<Integer, Integer> um;
    public com.byazt.bd.n<Typeface, Typeface> ur;
    public com.byazt.bd.n<Float, Float> wm;
    public final StringBuilder x;

    public d(com.byazt.pp.fs fsVar, fs fsVar2) {
        super(fsVar, fsVar2);
        this.x = new StringBuilder(2);
        this.fs = new RectF();
        this.rv = new Matrix();
        int i = 1;
        this.tj = new Paint(i) { // from class: com.byazt.eg.d.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.cp = new Paint(i) { // from class: com.byazt.eg.d.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.d = new HashMap();
        this.oa = new LongSparseArray<>();
        this.sz = new ArrayList();
        this.k = 0;
        this.hd = fsVar;
        this.cd = fsVar2.n();
        k kVarN = fsVar2.um().n();
        this.cy = kVarN;
        kVarN.n(this);
        n(kVarN);
        com.byazt.ccr.cp cpVarA = fsVar2.a();
        if (cpVarA != null && cpVarA.n != null) {
            com.byazt.bd.n<Integer, Integer> nVarN = cpVarA.n.n();
            this.um = nVarN;
            nVarN.n(this);
            n(this.um);
        }
        if (cpVarA != null && cpVarA.qg != null) {
            com.byazt.bd.n<Integer, Integer> nVarN2 = cpVarA.qg.n();
            this.py = nVarN2;
            nVarN2.n(this);
            n(this.py);
        }
        if (cpVarA != null && cpVarA.s != null) {
            com.byazt.bd.n<Float, Float> nVarN3 = cpVarA.s.n();
            this.wm = nVarN3;
            nVarN3.n(this);
            n(this.wm);
        }
        if (cpVarA == null || cpVarA.q == null) {
            return;
        }
        com.byazt.bd.n<Float, Float> nVarN4 = cpVarA.q.n();
        this.hu = nVarN4;
        nVarN4.n(this);
        n(this.hu);
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.cd.q().width(), this.cd.q().height());
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
        com.byazt.ld.qg qgVarX = this.cy.x();
        com.byazt.ld.s sVar = this.cd.cy().get(qgVarX.qg);
        if (sVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        n(qgVarX, matrix);
        if (this.hd.h()) {
            n(qgVarX, matrix, sVar, canvas);
        } else {
            n(qgVarX, sVar, canvas);
        }
        canvas.restore();
    }

    private void n(com.byazt.ld.qg qgVar, Matrix matrix) {
        com.byazt.bd.n<Integer, Integer> nVar = this.a;
        if (nVar != null) {
            this.tj.setColor(nVar.x().intValue());
        } else {
            com.byazt.bd.n<Integer, Integer> nVar2 = this.um;
            if (nVar2 != null) {
                this.tj.setColor(nVar2.x().intValue());
            } else {
                this.tj.setColor(qgVar.fs);
            }
        }
        com.byazt.bd.n<Integer, Integer> nVar3 = this.ou;
        if (nVar3 != null) {
            this.cp.setColor(nVar3.x().intValue());
        } else {
            com.byazt.bd.n<Integer, Integer> nVar4 = this.py;
            if (nVar4 != null) {
                this.cp.setColor(nVar4.x().intValue());
            } else {
                this.cp.setColor(qgVar.rv);
            }
        }
        int iIntValue = ((this.q.n() == null ? 100 : this.q.n().x().intValue()) * 255) / 100;
        this.tj.setAlpha(iIntValue);
        this.cp.setAlpha(iIntValue);
        com.byazt.bd.n<Float, Float> nVar5 = this.m;
        if (nVar5 != null) {
            this.cp.setStrokeWidth(nVar5.x().floatValue());
            return;
        }
        com.byazt.bd.n<Float, Float> nVar6 = this.wm;
        if (nVar6 != null) {
            this.cp.setStrokeWidth(nVar6.x().floatValue());
        } else {
            this.cp.setStrokeWidth(qgVar.tj * com.byazt.nu.tj.n());
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f4 A[LOOP:0: B:52:0x00f2->B:53:0x00f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0135  */
    /* JADX WARN: Code duplicated, block: B:57:0x0137  */
    /* JADX WARN: Code duplicated, block: B:61:0x0150 A[LOOP:1: B:59:0x014a->B:61:0x0150, LOOP_END] */
    private void n(com.byazt.ld.qg qgVar, Matrix matrix, com.byazt.ld.s sVar, Canvas canvas) {
        float fFloatValue;
        py pyVarHu;
        float fFloatValue2;
        float f;
        com.byazt.ld.l lVar;
        int iMin;
        int i;
        int i2;
        float f2;
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2;
        int i4;
        int i5;
        List<n> listN;
        int i6;
        py pyVarHu2;
        String strS;
        sz();
        com.byazt.bd.n<Float, Float> nVar = this.t;
        if (nVar != null) {
            fFloatValue = nVar.x().floatValue();
        } else if (!TextUtils.isEmpty(qgVar.cy) && (pyVarHu = this.hd.hu()) != null) {
            try {
                fFloatValue = Float.parseFloat(pyVarHu.s(cp(), qgVar.cy));
            } catch (NumberFormatException unused) {
                fFloatValue = qgVar.s;
            }
        } else {
            fFloatValue = qgVar.s;
        }
        float f3 = fFloatValue / 100.0f;
        float fN = com.byazt.nu.tj.n(matrix);
        String str = this.bb;
        if (TextUtils.isEmpty(str)) {
            str = qgVar.n;
            if (!TextUtils.isEmpty(qgVar.k) && (pyVarHu2 = this.hd.hu()) != null && (strS = pyVarHu2.s(cp(), qgVar.k)) != null) {
                str = strS;
            }
        }
        List<String> listQg = qg(str);
        int size = listQg.size();
        float f4 = qgVar.l / 10.0f;
        com.byazt.bd.n<Float, Float> nVar2 = this.h;
        if (nVar2 != null) {
            fFloatValue2 = nVar2.x().floatValue();
        } else {
            com.byazt.bd.n<Float, Float> nVar3 = this.hu;
            if (nVar3 != null) {
                fFloatValue2 = nVar3.x().floatValue();
            }
            f = f4;
            lVar = qgVar.sz;
            if (qgVar.oa != null || qgVar.oa.y <= 0.0f) {
                iMin = Integer.MAX_VALUE;
            } else {
                float fN2 = com.byazt.nu.tj.n();
                float f5 = qgVar.oa.y;
                float f6 = qgVar.w * fN2;
                if (f6 > 0.0f) {
                    float f7 = f5 - ((qgVar.w * 0.6f) * fN2);
                    if (f7 > 0.0f) {
                        iMin = ((int) (f7 / f6)) + 1;
                    } else {
                        iMin = Integer.MAX_VALUE;
                    }
                } else {
                    iMin = Integer.MAX_VALUE;
                }
            }
            if (lVar.n == 1) {
                i = 1;
            } else {
                if (lVar.n != 0) {
                    iMin = Math.min(lVar.n, iMin);
                }
                i = iMin;
            }
            i2 = lVar.qg;
            if (qgVar.oa == null) {
                f2 = 0.0f;
            } else {
                f2 = qgVar.oa.x;
            }
            arrayList = new ArrayList();
            i3 = 0;
            while (i3 < size) {
                ArrayList arrayList3 = arrayList;
                arrayList3.addAll(n(listQg.get(i3), f2, sVar, f3, f, true, Integer.MAX_VALUE, 0));
                i3++;
                arrayList = arrayList3;
                i = i;
                i2 = i2;
                listQg = listQg;
            }
            arrayList2 = arrayList;
            i4 = i2;
            i5 = i;
            if (arrayList2.size() <= i5) {
                listN = arrayList2;
            } else {
                listN = n((List<n>) arrayList2, i5, i4, f2, sVar, f3, f, true);
            }
            for (i6 = 0; i6 < listN.size(); i6++) {
                n nVar4 = listN.get(i6);
                canvas.save();
                n(canvas, qgVar, i6, nVar4.qg);
                n(nVar4.n, qgVar, sVar, canvas, fN, f3, f);
                canvas.restore();
            }
        }
        f4 += fFloatValue2;
        f = f4;
        lVar = qgVar.sz;
        if (qgVar.oa != null) {
            iMin = Integer.MAX_VALUE;
        } else {
            iMin = Integer.MAX_VALUE;
        }
        if (lVar.n == 1) {
            i = 1;
        } else {
            if (lVar.n != 0) {
                iMin = Math.min(lVar.n, iMin);
            }
            i = iMin;
        }
        i2 = lVar.qg;
        if (qgVar.oa == null) {
            f2 = 0.0f;
        } else {
            f2 = qgVar.oa.x;
        }
        arrayList = new ArrayList();
        i3 = 0;
        while (i3 < size) {
            ArrayList arrayList4 = arrayList;
            arrayList4.addAll(n(listQg.get(i3), f2, sVar, f3, f, true, Integer.MAX_VALUE, 0));
            i3++;
            arrayList = arrayList4;
            i = i;
            i2 = i2;
            listQg = listQg;
        }
        arrayList2 = arrayList;
        i4 = i2;
        i5 = i;
        if (arrayList2.size() <= i5) {
            listN = arrayList2;
        } else {
            listN = n((List<n>) arrayList2, i5, i4, f2, sVar, f3, f, true);
        }
        while (i6 < listN.size()) {
            n nVar5 = listN.get(i6);
            canvas.save();
            n(canvas, qgVar, i6, nVar5.qg);
            n(nVar5.n, qgVar, sVar, canvas, fN, f3, f);
            canvas.restore();
        }
    }

    private void n(String str, com.byazt.ld.qg qgVar, com.byazt.ld.s sVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.byazt.ld.q qVar = this.cd.k().get(com.byazt.ld.q.n(str.charAt(i), sVar.n(), sVar.s()));
            if (qVar != null) {
                n(qVar, f2, qgVar, canvas);
                canvas.translate((((float) qVar.qg()) * f2 * com.byazt.nu.tj.n()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    /* JADX WARN: Code duplicated, block: B:53:0x0117  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128 A[LOOP:0: B:55:0x0126->B:56:0x0128, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0166  */
    /* JADX WARN: Code duplicated, block: B:60:0x0168  */
    /* JADX WARN: Code duplicated, block: B:64:0x0180 A[LOOP:1: B:62:0x017a->B:64:0x0180, LOOP_END] */
    private void n(com.byazt.ld.qg qgVar, com.byazt.ld.s sVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float fN;
        com.byazt.ld.l lVar;
        int iMin;
        int i;
        List<String> listQg;
        int size;
        int i2;
        float f;
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2;
        int i4;
        List<n> listN;
        int i5;
        sz();
        Typeface typefaceN = n(sVar);
        if (typefaceN == null) {
            return;
        }
        py pyVarHu = this.hd.hu();
        String strS = this.bb;
        if (TextUtils.isEmpty(strS)) {
            strS = qgVar.n;
            if (pyVarHu != null) {
                if (!TextUtils.isEmpty(qgVar.k)) {
                    String strS2 = pyVarHu.s(cp(), qgVar.k);
                    if (strS2 != null) {
                        strS = strS2;
                    }
                } else {
                    strS = pyVarHu.s(cp(), strS);
                }
            }
        }
        this.tj.setTypeface(typefaceN);
        com.byazt.bd.n<Float, Float> nVar = this.t;
        if (nVar != null) {
            fFloatValue = nVar.x().floatValue();
        } else if (!TextUtils.isEmpty(qgVar.cy) && pyVarHu != null) {
            try {
                fFloatValue = Float.parseFloat(pyVarHu.s(cp(), qgVar.cy));
            } catch (NumberFormatException unused) {
                fFloatValue = qgVar.s;
            }
        } else {
            fFloatValue = qgVar.s;
        }
        this.tj.setTextSize(com.byazt.nu.tj.n() * fFloatValue);
        this.cp.setTypeface(this.tj.getTypeface());
        this.cp.setTextSize(this.tj.getTextSize());
        float f2 = qgVar.l / 10.0f;
        com.byazt.bd.n<Float, Float> nVar2 = this.h;
        if (nVar2 != null) {
            fFloatValue2 = nVar2.x().floatValue();
        } else {
            com.byazt.bd.n<Float, Float> nVar3 = this.hu;
            if (nVar3 != null) {
                fFloatValue2 = nVar3.x().floatValue();
            }
            fN = ((f2 * com.byazt.nu.tj.n()) * fFloatValue) / 100.0f;
            lVar = qgVar.sz;
            if (qgVar.oa != null || qgVar.oa.y <= 0.0f) {
                iMin = Integer.MAX_VALUE;
            } else {
                float fN2 = com.byazt.nu.tj.n();
                float f3 = qgVar.oa.y;
                float f4 = qgVar.w * fN2;
                if (f4 > 0.0f) {
                    float f5 = f3 - ((qgVar.w * 0.6f) * fN2);
                    if (f5 > 0.0f) {
                        iMin = ((int) (f5 / f4)) + 1;
                    } else {
                        iMin = Integer.MAX_VALUE;
                    }
                } else {
                    iMin = Integer.MAX_VALUE;
                }
            }
            if (lVar.n == 1) {
                i = 1;
            } else {
                if (lVar.n != 0) {
                    iMin = Math.min(lVar.n, iMin);
                }
                i = iMin;
            }
            listQg = qg(strS);
            i2 = lVar.qg;
            if (qgVar.oa == null) {
                f = 0.0f;
            } else {
                f = qgVar.oa.x;
            }
            arrayList = new ArrayList();
            i3 = 0;
            for (size = listQg.size(); i3 < size; size = size) {
                ArrayList arrayList3 = arrayList;
                arrayList3.addAll(n(listQg.get(i3), f, sVar, 0.0f, fN, false, Integer.MAX_VALUE, 0));
                i3++;
                arrayList = arrayList3;
                i2 = i2;
            }
            arrayList2 = arrayList;
            i4 = i2;
            if (arrayList2.size() <= i) {
                listN = arrayList2;
            } else {
                listN = n((List<n>) arrayList2, i, i4, f, sVar, 0.0f, fN, false);
            }
            for (i5 = 0; i5 < listN.size(); i5++) {
                n nVar4 = listN.get(i5);
                canvas.save();
                n(canvas, qgVar, i5, nVar4.qg);
                n(nVar4.n, qgVar, canvas, fN);
                canvas.restore();
            }
        }
        f2 += fFloatValue2;
        fN = ((f2 * com.byazt.nu.tj.n()) * fFloatValue) / 100.0f;
        lVar = qgVar.sz;
        if (qgVar.oa != null) {
            iMin = Integer.MAX_VALUE;
        } else {
            iMin = Integer.MAX_VALUE;
        }
        if (lVar.n == 1) {
            i = 1;
        } else {
            if (lVar.n != 0) {
                iMin = Math.min(lVar.n, iMin);
            }
            i = iMin;
        }
        listQg = qg(strS);
        i2 = lVar.qg;
        if (qgVar.oa == null) {
            f = 0.0f;
        } else {
            f = qgVar.oa.x;
        }
        arrayList = new ArrayList();
        i3 = 0;
        while (i3 < size) {
            ArrayList arrayList4 = arrayList;
            arrayList4.addAll(n(listQg.get(i3), f, sVar, 0.0f, fN, false, Integer.MAX_VALUE, 0));
            i3++;
            arrayList = arrayList4;
            i2 = i2;
        }
        arrayList2 = arrayList;
        i4 = i2;
        if (arrayList2.size() <= i) {
            listN = arrayList2;
        } else {
            listN = n((List<n>) arrayList2, i, i4, f, sVar, 0.0f, fN, false);
        }
        while (i5 < listN.size()) {
            n nVar5 = listN.get(i5);
            canvas.save();
            n(canvas, qgVar, i5, nVar5.qg);
            n(nVar5.n, qgVar, canvas, fN);
            canvas.restore();
        }
    }

    private void n(Canvas canvas, com.byazt.ld.qg qgVar, int i, float f) {
        PointF pointF = qgVar.d;
        PointF pointF2 = qgVar.oa;
        float fN = com.byazt.nu.tj.n();
        float f2 = (i * qgVar.w * fN) + (pointF == null ? 0.0f : (qgVar.w * 0.6f * fN) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.n[qgVar.q.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.eg.d$3, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 959, 217})
    static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.ld.qg.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.ld.qg.n.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.ld.qg.n.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.ld.qg.n.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface n(com.byazt.ld.s sVar) {
        Typeface typefaceX;
        com.byazt.bd.n<Typeface, Typeface> nVar = this.ur;
        if (nVar != null && (typefaceX = nVar.x()) != null) {
            return typefaceX;
        }
        Typeface typefaceN = this.hd.n(sVar);
        return typefaceN != null ? typefaceN : sVar.q();
    }

    private List<String> qg(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void n(String str, com.byazt.ld.qg qgVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strN = n(str, length);
            length += strN.length();
            n(strN, qgVar, canvas);
            canvas.translate(this.tj.measureText(strN) + f, 0.0f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0127  */
    /* JADX WARN: Code duplicated, block: B:60:0x011e A[SYNTHETIC] */
    private List<n> n(String str, float f, com.byazt.ld.s sVar, float f2, float f3, boolean z, int i, int i2) {
        float fMeasureText;
        float f4;
        int i3;
        int i4;
        int i5 = i;
        int i6 = this.k;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float fMeasureText2 = 0.0f;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        boolean z2 = false;
        while (i9 < str.length()) {
            char cCharAt = str.charAt(i9);
            if (z) {
                com.byazt.ld.q qVar = this.cd.k().get(com.byazt.ld.q.n(cCharAt, sVar.n(), sVar.s()));
                if (qVar != null) {
                    fMeasureText = ((float) qVar.qg()) * f2 * com.byazt.nu.tj.n();
                } else {
                    f4 = f6;
                    i9 = i9;
                    i3 = i5;
                }
                i9++;
                i5 = i3;
                f6 = f4;
            } else {
                fMeasureText = this.tj.measureText(str.substring(i9, i9 + 1));
            }
            float f7 = fMeasureText + f3;
            f4 = cCharAt == ' ' ? f7 : f6;
            float f8 = f5 + f7;
            int i10 = i7 + 1;
            boolean z3 = i10 >= i5;
            if (f <= 0.0f || f8 < f || cCharAt == ' ') {
                i9 = i9;
                i3 = i5;
                i8 = i8;
                f5 = f8;
            } else {
                if (z3) {
                    if (i2 == 3) {
                        String strN = n(str, i8, f, sVar, f2, f3, z);
                        if (strN != null) {
                            k().n(strN, f);
                            return this.sz.subList(i6, this.k);
                        }
                        i4 = i10;
                    } else {
                        if (!z2) {
                            z2 = true;
                            fMeasureText2 = z ? 3.0f * f7 : this.tj.measureText("...") + (2.0f * f3);
                        }
                        i8 = i8;
                        i4 = i10;
                        String strN2 = n(str, i8, f, fMeasureText2, sVar, f2, f3, z, i2);
                        if (strN2 != null) {
                            k().n(strN2, f);
                            return this.sz.subList(i6, this.k);
                        }
                    }
                    n nVarK = k();
                    String strSubstring = str.substring(i8, i9);
                    String strTrim = strSubstring.trim();
                    nVarK.n(strTrim, (f8 - f7) - ((strTrim.length() - strSubstring.length()) * f4));
                    i3 = i;
                    i7 = i4;
                    if (i7 >= i3) {
                        return this.sz.subList(i6, this.k);
                    }
                    i8 = i9;
                    f5 = f7;
                } else {
                    i4 = i10;
                }
                n nVarK2 = k();
                String strSubstring2 = str.substring(i8, i9);
                String strTrim2 = strSubstring2.trim();
                nVarK2.n(strTrim2, (f8 - f7) - ((strTrim2.length() - strSubstring2.length()) * f4));
                i3 = i;
                i7 = i4;
                if (i7 >= i3) {
                    return this.sz.subList(i6, this.k);
                }
                i8 = i9;
                f5 = f7;
            }
            i9++;
            i5 = i3;
            f6 = f4;
        }
        int i11 = i8;
        if (f5 > 0.0f) {
            k().n(str.substring(i11), f5);
        }
        return this.sz.subList(i6, this.k);
    }

    private String n(String str, int i, float f, float f2, com.byazt.ld.s sVar, float f3, float f4, boolean z, int i2) {
        if (i2 == 3) {
            return n(str, i, f, sVar, f3, f4, z);
        }
        float f5 = f - f2;
        if (f5 <= 0.0f) {
            return null;
        }
        String strSubstring = str.substring(i);
        if (i2 == 0) {
            return n(strSubstring, f5, f2, sVar, f3, f4, z);
        }
        if (i2 == 1) {
            return qg(strSubstring, f5, f2, sVar, f3, f4, z);
        }
        if (i2 == 2) {
            return s(strSubstring, f5, f2, sVar, f3, f4, z);
        }
        return n(strSubstring, f5, f2, sVar, f3, f4, z);
    }

    private String n(String str, int i, float f, com.byazt.ld.s sVar, float f2, float f3, boolean z) {
        String strSubstring = str.substring(i);
        float fN = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i2 < strSubstring.length()) {
            fN += n(strSubstring.charAt(i2), sVar, f2, f3, z);
            if (fN > f) {
                break;
            }
            i3 = i2 + 1;
            i2 = i3;
        }
        return strSubstring.substring(0, i3);
    }

    private String n(String str, float f, float f2, com.byazt.ld.s sVar, float f3, float f4, boolean z) {
        float fN = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            fN += n(str.charAt(i), sVar, f3, f4, z);
            if (fN > f) {
                break;
            }
            i2 = i + 1;
            i = i2;
        }
        return str.substring(0, i2) + "...";
    }

    private String qg(String str, float f, float f2, com.byazt.ld.s sVar, float f3, float f4, boolean z) {
        int i;
        int length = str.length();
        int length2 = str.length() - 1;
        float fN = 0.0f;
        while (true) {
            int i2 = length2;
            i = length;
            length = i2;
            if (length < 0) {
                break;
            }
            fN += n(str.charAt(length), sVar, f3, f4, z);
            if (fN > f) {
                break;
            }
            length2 = length - 1;
        }
        return "..." + str.substring(i);
    }

    private String s(String str, float f, float f2, com.byazt.ld.s sVar, float f3, float f4, boolean z) {
        if (str.length() <= 1) {
            return str + "...";
        }
        float f5 = f / 2.0f;
        float fN = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length() / 2) {
            float fN2 = n(str.charAt(i), sVar, f3, f4, z) + f6;
            if (fN2 > f5) {
                break;
            }
            i2 = i + 1;
            i = i2;
            f6 = fN2;
        }
        float f7 = f - f6;
        int length = str.length();
        for (int length2 = str.length() - 1; length2 >= str.length() / 2; length2--) {
            fN += n(str.charAt(length2), sVar, f3, f4, z);
            if (fN > f7) {
                break;
            }
            length = length2;
        }
        if (i2 == 0 || length == str.length()) {
            return n(str, f, f2, sVar, f3, f4, z);
        }
        return str.substring(0, i2) + "..." + str.substring(length);
    }

    private float n(char c, com.byazt.ld.s sVar, float f, float f2, boolean z) {
        float fMeasureText;
        if (z) {
            com.byazt.ld.q qVar = this.cd.k().get(com.byazt.ld.q.n(c, sVar.n(), sVar.s()));
            if (qVar == null) {
                return 0.0f;
            }
            fMeasureText = ((float) qVar.qg()) * f * com.byazt.nu.tj.n();
        } else {
            fMeasureText = this.tj.measureText(String.valueOf(c));
        }
        return fMeasureText + f2;
    }

    private void sz() {
        this.k = 0;
    }

    private n k() {
        if (this.k >= this.sz.size()) {
            this.sz.add(new n());
        }
        List<n> list = this.sz;
        int i = this.k;
        this.k = i + 1;
        return list.get(i);
    }

    private void n(com.byazt.ld.q qVar, float f, com.byazt.ld.qg qgVar, Canvas canvas) {
        List<com.byazt.sp.q> listN = n(qVar);
        for (int i = 0; i < listN.size(); i++) {
            Path pathQ = listN.get(i).q();
            pathQ.computeBounds(this.fs, false);
            this.rv.reset();
            this.rv.preTranslate(0.0f, (-qgVar.x) * com.byazt.nu.tj.n());
            this.rv.preScale(f, f);
            pathQ.transform(this.rv);
            if (qgVar.cp) {
                n(pathQ, this.tj, canvas);
                n(pathQ, this.cp, canvas);
            } else {
                n(pathQ, this.cp, canvas);
                n(pathQ, this.tj, canvas);
            }
        }
    }

    private void n(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void n(String str, com.byazt.ld.qg qgVar, Canvas canvas) {
        if (qgVar.cp) {
            n(str, this.tj, canvas);
            n(str, this.cp, canvas);
        } else {
            n(str, this.cp, canvas);
            n(str, this.tj, canvas);
        }
    }

    private void n(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.byazt.sp.q> n(com.byazt.ld.q qVar) {
        if (this.d.containsKey(qVar)) {
            return this.d.get(qVar);
        }
        List<cy> listN = qVar.n();
        int size = listN.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.byazt.sp.q(this.hd, this, listN.get(i), this.cd));
        }
        this.d.put(qVar, arrayList);
        return arrayList;
    }

    private String n(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!qg(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.oa.indexOfKey(j) >= 0) {
            return this.oa.get(j);
        }
        this.x.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.x.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.x.toString();
        this.oa.put(j, string);
        return string;
    }

    private boolean qg(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private List<n> n(List<n> list, int i, int i2, float f, com.byazt.ld.s sVar, float f2, float f3, boolean z) {
        int i3;
        int i4;
        String strN;
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            String strN2 = n(list);
            if (i2 == 3) {
                strN = n(strN2, f, sVar, f2, f3, z);
            } else {
                strN = n(strN2, f, sVar, f2, f3, z, i2);
            }
            n nVarK = k();
            nVarK.n(strN, f);
            arrayList.add(nVarK);
        } else {
            int i5 = 0;
            if (i2 == 0) {
                while (true) {
                    i3 = i - 1;
                    if (i5 >= i3) {
                        break;
                    }
                    arrayList.add(list.get(i5));
                    i5++;
                }
                String strN3 = n(n(list, i3, list.size()), f, sVar, f2, f3, z, 0);
                n nVarK2 = k();
                nVarK2.n(strN3, f);
                arrayList.add(nVarK2);
            } else if (i2 == 1) {
                int i6 = i - 1;
                String strN4 = n(n(list, 0, list.size() - i6), f, sVar, f2, f3, z, 1);
                n nVarK3 = k();
                nVarK3.n(strN4, f);
                arrayList.add(nVarK3);
                for (int size = list.size() - i6; size < list.size(); size++) {
                    arrayList.add(list.get(size));
                }
            } else if (i2 == 2) {
                int i7 = i / 2;
                while (i5 < i7) {
                    arrayList.add(list.get(i5));
                    i5++;
                }
                int i8 = (i - i7) - 1;
                int size2 = list.size() - i8;
                if (size2 <= i7) {
                    size2 = list.size();
                }
                String strN5 = n(n(list, i7, size2), f, sVar, f2, f3, z, 2);
                n nVarK4 = k();
                nVarK4.n(strN5, f);
                arrayList.add(nVarK4);
                for (int size3 = list.size() - i8; size3 < list.size(); size3++) {
                    arrayList.add(list.get(size3));
                }
            } else if (i2 != 3) {
                while (true) {
                    i4 = i - 1;
                    if (i5 >= i4) {
                        break;
                    }
                    arrayList.add(list.get(i5));
                    i5++;
                }
                String strN6 = n(n(list, i4, list.size()), f, sVar, f2, f3, z, 0);
                n nVarK5 = k();
                nVarK5.n(strN6, f);
                arrayList.add(nVarK5);
            } else {
                while (i5 < i) {
                    arrayList.add(list.get(i5));
                    i5++;
                }
            }
        }
        return arrayList;
    }

    private String n(List<n> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().n);
        }
        return sb.toString();
    }

    private String n(List<n> list, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2 && i < list.size()) {
            sb.append(list.get(i).n);
            i++;
        }
        return sb.toString();
    }

    private String n(String str, float f, com.byazt.ld.s sVar, float f2, float f3, boolean z, int i) {
        float fMeasureText;
        if (z) {
            com.byazt.ld.q qVar = this.cd.k().get(com.byazt.ld.q.n(str.length() > 0 ? str.charAt(0) : ' ', sVar.n(), sVar.s()));
            fMeasureText = (qVar != null ? (((float) qVar.qg()) * f2 * com.byazt.nu.tj.n()) + f3 : 10.0f) * 3.0f;
        } else {
            fMeasureText = this.tj.measureText("...") + (2.0f * f3);
        }
        String strN = n(str, 0, f, fMeasureText, sVar, f2, f3, z, i);
        return strN != null ? strN : str;
    }

    private String n(String str, float f, com.byazt.ld.s sVar, float f2, float f3, boolean z) {
        return n(str, 0, f, sVar, f2, f3, z);
    }

    public void n(String str) {
        this.bb = str;
    }

    @com.byazt.cp.n(n = {0, 1, 959, 89})
    private static class n {
        public String n;
        public float qg;

        private n() {
            this.n = "";
            this.qg = 0.0f;
        }

        public void n(String str, float f) {
            this.n = str;
            this.qg = f;
        }
    }
}
