package com.byazt.cg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.byazt.al.ho;
import com.byazt.dx.cz;
import com.byazt.ynb.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 250})
public class k extends hn {
    public com.byazt.al.pr<Integer, Integer> a;
    public final Matrix aj;
    public com.byazt.al.pr<Float, Float> b;
    public com.byazt.al.pr<Integer, Integer> cz;
    public com.byazt.al.pr<Float, Float> fo;
    public final StringBuilder fw;
    public final List<pr> g;
    public String gz;
    public int ho;
    public com.byazt.al.pr<Float, Float> iu;
    public final Map<com.byazt.uxi.x, List<com.byazt.ova.x>> k;
    public final com.byazt.dx.uc lb;
    public final LongSparseArray<String> m;
    public final ho nt;
    public com.byazt.al.pr<Integer, Integer> ny;
    public com.byazt.al.pr<Integer, Integer> qa;
    public com.byazt.al.pr<Float, Float> rc;
    public com.byazt.al.pr<Typeface, Typeface> ve;
    public final Paint vk;
    public final Paint w;
    public final com.byazt.dx.zo yb;
    public com.byazt.al.pr<Float, Float> z;
    public final RectF zo;

    public k(com.byazt.dx.zo zoVar, zo zoVar2) {
        super(zoVar, zoVar2);
        this.fw = new StringBuilder(2);
        this.zo = new RectF();
        this.aj = new Matrix();
        int i = 1;
        this.vk = new Paint(i) { // from class: com.byazt.cg.k.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.w = new Paint(i) { // from class: com.byazt.cg.k.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.k = new HashMap();
        this.m = new LongSparseArray<>();
        this.g = new ArrayList();
        this.ho = 0;
        this.yb = zoVar;
        this.lb = zoVar2.pr();
        ho hoVarPr = zoVar2.qa().pr();
        this.nt = hoVarPr;
        hoVarPr.pr(this);
        pr(hoVarPr);
        com.byazt.eqw.w wVarA = zoVar2.a();
        if (wVarA != null && wVarA.pr != null) {
            com.byazt.al.pr<Integer, Integer> prVarPr = wVarA.pr.pr();
            this.qa = prVarPr;
            prVarPr.pr(this);
            pr(this.qa);
        }
        if (wVarA != null && wVarA.hw != null) {
            com.byazt.al.pr<Integer, Integer> prVarPr2 = wVarA.hw.pr();
            this.cz = prVarPr2;
            prVarPr2.pr(this);
            pr(this.cz);
        }
        if (wVarA != null && wVarA.hn != null) {
            com.byazt.al.pr<Float, Float> prVarPr3 = wVarA.hn.pr();
            this.fo = prVarPr3;
            prVarPr3.pr(this);
            pr(this.fo);
        }
        if (wVarA != null && wVarA.x != null) {
            com.byazt.al.pr<Float, Float> prVarPr4 = wVarA.x.pr();
            this.z = prVarPr4;
            prVarPr4.pr(this);
            pr(this.z);
        }
    }

    @Override // com.byazt.cg.hn, com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        super.pr(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.lb.x().width(), this.lb.x().height());
    }

    @Override // com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        super.hw(canvas, matrix, i);
        com.byazt.uxi.hw hwVarFw = this.nt.fw();
        com.byazt.uxi.hn hnVar = this.lb.nt().get(hwVarFw.hw);
        if (hnVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        pr(hwVarFw, matrix);
        if (this.yb.b()) {
            pr(hwVarFw, matrix, hnVar, canvas);
        } else {
            pr(hwVarFw, hnVar, canvas);
        }
        canvas.restore();
    }

    private void pr(com.byazt.uxi.hw hwVar, Matrix matrix) {
        com.byazt.al.pr<Integer, Integer> prVar = this.a;
        if (prVar != null) {
            this.vk.setColor(prVar.fw().intValue());
        } else {
            com.byazt.al.pr<Integer, Integer> prVar2 = this.qa;
            if (prVar2 != null) {
                this.vk.setColor(prVar2.fw().intValue());
            } else {
                this.vk.setColor(hwVar.zo);
            }
        }
        com.byazt.al.pr<Integer, Integer> prVar3 = this.ny;
        if (prVar3 != null) {
            this.w.setColor(prVar3.fw().intValue());
        } else {
            com.byazt.al.pr<Integer, Integer> prVar4 = this.cz;
            if (prVar4 != null) {
                this.w.setColor(prVar4.fw().intValue());
            } else {
                this.w.setColor(hwVar.aj);
            }
        }
        int iIntValue = ((this.x.pr() == null ? 100 : this.x.pr().fw().intValue()) * 255) / 100;
        this.vk.setAlpha(iIntValue);
        this.w.setAlpha(iIntValue);
        com.byazt.al.pr<Float, Float> prVar5 = this.rc;
        if (prVar5 != null) {
            this.w.setStrokeWidth(prVar5.fw().floatValue());
            return;
        }
        com.byazt.al.pr<Float, Float> prVar6 = this.fo;
        if (prVar6 != null) {
            this.w.setStrokeWidth(prVar6.fw().floatValue());
        } else {
            this.w.setStrokeWidth(hwVar.vk * com.byazt.ptr.vk.pr());
        }
    }

    private void pr(com.byazt.uxi.hw hwVar, Matrix matrix, com.byazt.uxi.hn hnVar, Canvas canvas) {
        float fFloatValue;
        cz czVarZ;
        float fFloatValue2;
        int iMin;
        List<pr> listPr;
        cz czVarZ2;
        String strHn;
        g();
        com.byazt.al.pr<Float, Float> prVar = this.iu;
        if (prVar != null) {
            fFloatValue = prVar.fw().floatValue();
        } else if (!TextUtils.isEmpty(hwVar.nt) && (czVarZ = this.yb.z()) != null) {
            try {
                fFloatValue = Float.parseFloat(czVarZ.hn(w(), hwVar.nt));
            } catch (NumberFormatException e) {
                fFloatValue = hwVar.hn;
            }
        } else {
            fFloatValue = hwVar.hn;
        }
        float f = fFloatValue / 100.0f;
        float fPr = com.byazt.ptr.vk.pr(matrix);
        String str = this.gz;
        if (TextUtils.isEmpty(str)) {
            str = hwVar.pr;
            if (!TextUtils.isEmpty(hwVar.ho) && (czVarZ2 = this.yb.z()) != null && (strHn = czVarZ2.hn(w(), hwVar.ho)) != null) {
                str = strHn;
            }
        }
        List<String> listHw = hw(str);
        int size = listHw.size();
        float f2 = hwVar.c / 10.0f;
        com.byazt.al.pr<Float, Float> prVar2 = this.b;
        if (prVar2 != null) {
            fFloatValue2 = f2 + prVar2.fw().floatValue();
        } else {
            com.byazt.al.pr<Float, Float> prVar3 = this.z;
            if (prVar3 == null) {
                fFloatValue2 = f2;
            } else {
                fFloatValue2 = f2 + prVar3.fw().floatValue();
            }
        }
        com.byazt.uxi.c cVar = hwVar.g;
        int i = Integer.MAX_VALUE;
        if (hwVar.m != null && hwVar.m.y > 0.0f) {
            float fPr2 = com.byazt.ptr.vk.pr();
            float f3 = hwVar.m.y;
            float f4 = hwVar.uc * fPr2;
            if (f4 > 0.0f) {
                float f5 = f3 - ((hwVar.uc * 0.6f) * fPr2);
                if (f5 > 0.0f) {
                    i = ((int) (f5 / f4)) + 1;
                }
            }
        }
        if (cVar.pr == 1) {
            iMin = 1;
        } else if (cVar.pr == 0) {
            iMin = i;
        } else {
            iMin = Math.min(cVar.pr, i);
        }
        int i2 = cVar.hw;
        float f6 = hwVar.m == null ? 0.0f : hwVar.m.x;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < size) {
            ArrayList arrayList2 = arrayList;
            arrayList2.addAll(pr(listHw.get(i3), f6, hnVar, f, fFloatValue2, true, Integer.MAX_VALUE, 0));
            i3++;
            arrayList = arrayList2;
            iMin = iMin;
            i2 = i2;
            listHw = listHw;
        }
        ArrayList arrayList3 = arrayList;
        int i4 = i2;
        int i5 = iMin;
        if (arrayList3.size() <= i5) {
            listPr = arrayList3;
        } else {
            listPr = pr((List<pr>) arrayList3, i5, i4, f6, hnVar, f, fFloatValue2, true);
        }
        for (int i6 = 0; i6 < listPr.size(); i6++) {
            pr prVar4 = listPr.get(i6);
            canvas.save();
            pr(canvas, hwVar, i6, prVar4.hw);
            pr(prVar4.pr, hwVar, hnVar, canvas, fPr, f, fFloatValue2);
            canvas.restore();
        }
    }

    private void pr(String str, com.byazt.uxi.hw hwVar, com.byazt.uxi.hn hnVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.byazt.uxi.x xVar = this.lb.ho().get(com.byazt.uxi.x.pr(str.charAt(i), hnVar.pr(), hnVar.hn()));
            if (xVar != null) {
                pr(xVar, f2, hwVar, canvas);
                canvas.translate((((float) xVar.hw()) * f2 * com.byazt.ptr.vk.pr()) + f3, 0.0f);
            }
        }
    }

    private void pr(com.byazt.uxi.hw hwVar, com.byazt.uxi.hn hnVar, Canvas canvas) {
        float fFloatValue;
        int iMin;
        List<pr> listPr;
        g();
        Typeface typefacePr = pr(hnVar);
        if (typefacePr == null) {
            return;
        }
        cz czVarZ = this.yb.z();
        String strHn = this.gz;
        if (TextUtils.isEmpty(strHn)) {
            strHn = hwVar.pr;
            if (czVarZ != null) {
                if (!TextUtils.isEmpty(hwVar.ho)) {
                    String strHn2 = czVarZ.hn(w(), hwVar.ho);
                    if (strHn2 != null) {
                        strHn = strHn2;
                    }
                } else {
                    strHn = czVarZ.hn(w(), strHn);
                }
            }
        }
        this.vk.setTypeface(typefacePr);
        com.byazt.al.pr<Float, Float> prVar = this.iu;
        if (prVar != null) {
            fFloatValue = prVar.fw().floatValue();
        } else if (!TextUtils.isEmpty(hwVar.nt) && czVarZ != null) {
            try {
                fFloatValue = Float.parseFloat(czVarZ.hn(w(), hwVar.nt));
            } catch (NumberFormatException e) {
                fFloatValue = hwVar.hn;
            }
        } else {
            fFloatValue = hwVar.hn;
        }
        this.vk.setTextSize(com.byazt.ptr.vk.pr() * fFloatValue);
        this.w.setTypeface(this.vk.getTypeface());
        this.w.setTextSize(this.vk.getTextSize());
        float fFloatValue2 = hwVar.c / 10.0f;
        com.byazt.al.pr<Float, Float> prVar2 = this.b;
        if (prVar2 != null) {
            fFloatValue2 += prVar2.fw().floatValue();
        } else {
            com.byazt.al.pr<Float, Float> prVar3 = this.z;
            if (prVar3 != null) {
                fFloatValue2 += prVar3.fw().floatValue();
            }
        }
        float fPr = ((fFloatValue2 * com.byazt.ptr.vk.pr()) * fFloatValue) / 100.0f;
        com.byazt.uxi.c cVar = hwVar.g;
        int i = Integer.MAX_VALUE;
        if (hwVar.m != null && hwVar.m.y > 0.0f) {
            float fPr2 = com.byazt.ptr.vk.pr();
            float f = hwVar.m.y;
            float f2 = hwVar.uc * fPr2;
            if (f2 > 0.0f) {
                float f3 = f - ((hwVar.uc * 0.6f) * fPr2);
                if (f3 > 0.0f) {
                    i = ((int) (f3 / f2)) + 1;
                }
            }
        }
        if (cVar.pr == 1) {
            iMin = 1;
        } else if (cVar.pr == 0) {
            iMin = i;
        } else {
            iMin = Math.min(cVar.pr, i);
        }
        List<String> listHw = hw(strHn);
        int i2 = cVar.hw;
        float f4 = hwVar.m == null ? 0.0f : hwVar.m.x;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int size = listHw.size(); i3 < size; size = size) {
            ArrayList arrayList2 = arrayList;
            arrayList2.addAll(pr(listHw.get(i3), f4, hnVar, 0.0f, fPr, false, Integer.MAX_VALUE, 0));
            i3++;
            arrayList = arrayList2;
            i2 = i2;
        }
        ArrayList arrayList3 = arrayList;
        int i4 = i2;
        if (arrayList3.size() <= iMin) {
            listPr = arrayList3;
        } else {
            listPr = pr((List<pr>) arrayList3, iMin, i4, f4, hnVar, 0.0f, fPr, false);
        }
        for (int i5 = 0; i5 < listPr.size(); i5++) {
            pr prVar4 = listPr.get(i5);
            canvas.save();
            pr(canvas, hwVar, i5, prVar4.hw);
            pr(prVar4.pr, hwVar, canvas, fPr);
            canvas.restore();
        }
    }

    private void pr(Canvas canvas, com.byazt.uxi.hw hwVar, int i, float f) {
        PointF pointF = hwVar.k;
        PointF pointF2 = hwVar.m;
        float fPr = com.byazt.ptr.vk.pr();
        float f2 = (i * hwVar.uc * fPr) + (pointF == null ? 0.0f : (hwVar.uc * 0.6f * fPr) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        switch (AnonymousClass3.pr[hwVar.x.ordinal()]) {
            case 1:
                canvas.translate(f3, f2);
                break;
            case 2:
                canvas.translate((f3 + f4) - f, f2);
                break;
            case 3:
                canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
                break;
        }
    }

    /* JADX INFO: renamed from: com.byazt.cg.k$3, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 35})
    static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.uxi.hw.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.uxi.hw.pr.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.uxi.hw.pr.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.uxi.hw.pr.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private Typeface pr(com.byazt.uxi.hn hnVar) {
        Typeface typefaceFw;
        com.byazt.al.pr<Typeface, Typeface> prVar = this.ve;
        if (prVar != null && (typefaceFw = prVar.fw()) != null) {
            return typefaceFw;
        }
        Typeface typefacePr = this.yb.pr(hnVar);
        if (typefacePr != null) {
            return typefacePr;
        }
        return hnVar.x();
    }

    private List<String> hw(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void pr(String str, com.byazt.uxi.hw hwVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strPr = pr(str, length);
            length += strPr.length();
            pr(strPr, hwVar, canvas);
            canvas.translate(this.vk.measureText(strPr) + f, 0.0f);
        }
    }

    private List<pr> pr(String str, float f, com.byazt.uxi.hn hnVar, float f2, float f3, boolean z, int i, int i2) {
        float fMeasureText;
        float f4;
        int i3;
        float fMeasureText2;
        int i4 = i;
        int i5 = this.ho;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z2 = false;
        while (i8 < str.length()) {
            char cCharAt = str.charAt(i8);
            if (z) {
                com.byazt.uxi.x xVar = this.lb.ho().get(com.byazt.uxi.x.pr(cCharAt, hnVar.pr(), hnVar.hn()));
                if (xVar == null) {
                    f4 = f7;
                    i8 = i8;
                    i4 = i4;
                } else {
                    fMeasureText = (((float) xVar.hw()) * f2 * com.byazt.ptr.vk.pr()) + f3;
                }
                i8++;
                i4 = i4;
                f7 = f4;
                f5 = 0.0f;
            } else {
                fMeasureText = this.vk.measureText(str.substring(i8, i8 + 1)) + f3;
            }
            if (cCharAt != ' ') {
                f4 = f7;
            } else {
                f4 = fMeasureText;
            }
            float f9 = f6 + fMeasureText;
            int i9 = i6 + 1;
            boolean z3 = i9 >= i4;
            if (f <= f5 || f9 < f || cCharAt == ' ') {
                i7 = i7;
                f6 = f9;
            } else {
                if (!z3) {
                    i3 = i9;
                } else if (i2 == 3) {
                    String strPr = pr(str, i7, f, hnVar, f2, f3, z);
                    if (strPr != null) {
                        ho().pr(strPr, f);
                        return this.g.subList(i5, this.ho);
                    }
                    i3 = i9;
                } else {
                    if (!z2) {
                        if (z) {
                            fMeasureText2 = 3.0f * fMeasureText;
                        } else {
                            fMeasureText2 = this.vk.measureText("...") + (2.0f * f3);
                        }
                        z2 = true;
                        f8 = fMeasureText2;
                    }
                    i3 = i9;
                    String strPr2 = pr(str, i7, f, f8, hnVar, f2, f3, z, i2);
                    if (strPr2 != null) {
                        ho().pr(strPr2, f);
                        return this.g.subList(i5, this.ho);
                    }
                }
                pr prVarHo = ho();
                String strSubstring = str.substring(i7, i8);
                String strTrim = strSubstring.trim();
                prVarHo.pr(strTrim, (f9 - fMeasureText) - ((strTrim.length() - strSubstring.length()) * f4));
                i4 = i;
                i6 = i3;
                if (i6 >= i4) {
                    return this.g.subList(i5, this.ho);
                }
                i7 = i8;
                f6 = fMeasureText;
            }
            i8++;
            i4 = i4;
            f7 = f4;
            f5 = 0.0f;
        }
        int i10 = i7;
        if (f6 > 0.0f) {
            ho().pr(str.substring(i10), f6);
        }
        return this.g.subList(i5, this.ho);
    }

    private String pr(String str, int i, float f, float f2, com.byazt.uxi.hn hnVar, float f3, float f4, boolean z, int i2) {
        if (i2 == 3) {
            return pr(str, i, f, hnVar, f3, f4, z);
        }
        float f5 = f - f2;
        if (f5 <= 0.0f) {
            return null;
        }
        String strSubstring = str.substring(i);
        switch (i2) {
            case 0:
                return pr(strSubstring, f5, f2, hnVar, f3, f4, z);
            case 1:
                return hw(strSubstring, f5, f2, hnVar, f3, f4, z);
            case 2:
                return hn(strSubstring, f5, f2, hnVar, f3, f4, z);
            default:
                return pr(strSubstring, f5, f2, hnVar, f3, f4, z);
        }
    }

    private String pr(String str, int i, float f, com.byazt.uxi.hn hnVar, float f2, float f3, boolean z) {
        String strSubstring = str.substring(i);
        float fPr = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i2 < strSubstring.length()) {
            fPr += pr(strSubstring.charAt(i2), hnVar, f2, f3, z);
            if (fPr > f) {
                break;
            }
            i3 = i2 + 1;
            i2 = i3;
        }
        return strSubstring.substring(0, i3);
    }

    private String pr(String str, float f, float f2, com.byazt.uxi.hn hnVar, float f3, float f4, boolean z) {
        float fPr = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            fPr += pr(str.charAt(i), hnVar, f3, f4, z);
            if (fPr > f) {
                break;
            }
            i2 = i + 1;
            i = i2;
        }
        return str.substring(0, i2) + "...";
    }

    private String hw(String str, float f, float f2, com.byazt.uxi.hn hnVar, float f3, float f4, boolean z) {
        int i;
        int length = str.length();
        int length2 = str.length() - 1;
        float fPr = 0.0f;
        while (true) {
            int i2 = length2;
            i = length;
            length = i2;
            if (length < 0) {
                break;
            }
            fPr += pr(str.charAt(length), hnVar, f3, f4, z);
            if (fPr > f) {
                break;
            }
            length2 = length - 1;
        }
        return "..." + str.substring(i);
    }

    private String hn(String str, float f, float f2, com.byazt.uxi.hn hnVar, float f3, float f4, boolean z) {
        if (str.length() <= 1) {
            return str + "...";
        }
        float f5 = f / 2.0f;
        float fPr = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length() / 2) {
            float fPr2 = pr(str.charAt(i), hnVar, f3, f4, z) + f6;
            if (fPr2 > f5) {
                break;
            }
            i2 = i + 1;
            i = i2;
            f6 = fPr2;
        }
        float f7 = f - f6;
        int length = str.length();
        for (int length2 = str.length() - 1; length2 >= str.length() / 2; length2--) {
            fPr += pr(str.charAt(length2), hnVar, f3, f4, z);
            if (fPr > f7) {
                break;
            }
            length = length2;
        }
        if (i2 != 0 && length != str.length()) {
            return str.substring(0, i2) + "..." + str.substring(length);
        }
        return pr(str, f, f2, hnVar, f3, f4, z);
    }

    private float pr(char c, com.byazt.uxi.hn hnVar, float f, float f2, boolean z) {
        if (z) {
            com.byazt.uxi.x xVar = this.lb.ho().get(com.byazt.uxi.x.pr(c, hnVar.pr(), hnVar.hn()));
            if (xVar == null) {
                return 0.0f;
            }
            return (((float) xVar.hw()) * f * com.byazt.ptr.vk.pr()) + f2;
        }
        return this.vk.measureText(String.valueOf(c)) + f2;
    }

    private void g() {
        this.ho = 0;
    }

    private pr ho() {
        if (this.ho >= this.g.size()) {
            this.g.add(new pr());
        }
        List<pr> list = this.g;
        int i = this.ho;
        this.ho = i + 1;
        return list.get(i);
    }

    private void pr(com.byazt.uxi.x xVar, float f, com.byazt.uxi.hw hwVar, Canvas canvas) {
        List<com.byazt.ova.x> listPr = pr(xVar);
        for (int i = 0; i < listPr.size(); i++) {
            Path pathX = listPr.get(i).x();
            pathX.computeBounds(this.zo, false);
            this.aj.reset();
            this.aj.preTranslate(0.0f, (-hwVar.fw) * com.byazt.ptr.vk.pr());
            this.aj.preScale(f, f);
            pathX.transform(this.aj);
            if (hwVar.w) {
                pr(pathX, this.vk, canvas);
                pr(pathX, this.w, canvas);
            } else {
                pr(pathX, this.w, canvas);
                pr(pathX, this.vk, canvas);
            }
        }
    }

    private void pr(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void pr(String str, com.byazt.uxi.hw hwVar, Canvas canvas) {
        if (hwVar.w) {
            pr(str, this.vk, canvas);
            pr(str, this.w, canvas);
        } else {
            pr(str, this.w, canvas);
            pr(str, this.vk, canvas);
        }
    }

    private void pr(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.byazt.ova.x> pr(com.byazt.uxi.x xVar) {
        if (this.k.containsKey(xVar)) {
            return this.k.get(xVar);
        }
        List<nt> listPr = xVar.pr();
        int size = listPr.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.byazt.ova.x(this.yb, this, listPr.get(i), this.lb));
        }
        this.k.put(xVar, arrayList);
        return arrayList;
    }

    private String pr(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!hw(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.m.indexOfKey(j) >= 0) {
            return this.m.get(j);
        }
        this.fw.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.fw.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.fw.toString();
        this.m.put(j, string);
        return string;
    }

    private boolean hw(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private List<pr> pr(List<pr> list, int i, int i2, float f, com.byazt.uxi.hn hnVar, float f2, float f3, boolean z) {
        String strPr;
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            String strPr2 = pr(list);
            if (i2 == 3) {
                strPr = pr(strPr2, f, hnVar, f2, f3, z);
            } else {
                strPr = pr(strPr2, f, hnVar, f2, f3, z, i2);
            }
            pr prVarHo = ho();
            prVarHo.pr(strPr, f);
            arrayList.add(prVarHo);
        } else {
            int i3 = 0;
            switch (i2) {
                case 0:
                    while (true) {
                        int i4 = i - 1;
                        if (i3 < i4) {
                            arrayList.add(list.get(i3));
                            i3++;
                        } else {
                            String strPr3 = pr(pr(list, i4, list.size()), f, hnVar, f2, f3, z, 0);
                            pr prVarHo2 = ho();
                            prVarHo2.pr(strPr3, f);
                            arrayList.add(prVarHo2);
                        }
                        break;
                    }
                    break;
                case 1:
                    int i5 = i - 1;
                    String strPr4 = pr(pr(list, 0, list.size() - i5), f, hnVar, f2, f3, z, 1);
                    pr prVarHo3 = ho();
                    prVarHo3.pr(strPr4, f);
                    arrayList.add(prVarHo3);
                    for (int size = list.size() - i5; size < list.size(); size++) {
                        arrayList.add(list.get(size));
                    }
                    break;
                case 2:
                    int i6 = i / 2;
                    while (i3 < i6) {
                        arrayList.add(list.get(i3));
                        i3++;
                    }
                    int i7 = (i - i6) - 1;
                    int size2 = list.size() - i7;
                    if (size2 <= i6) {
                        size2 = list.size();
                    }
                    String strPr5 = pr(pr(list, i6, size2), f, hnVar, f2, f3, z, 2);
                    pr prVarHo4 = ho();
                    prVarHo4.pr(strPr5, f);
                    arrayList.add(prVarHo4);
                    for (int size3 = list.size() - i7; size3 < list.size(); size3++) {
                        arrayList.add(list.get(size3));
                    }
                    break;
                case 3:
                    while (i3 < i) {
                        arrayList.add(list.get(i3));
                        i3++;
                    }
                    break;
                default:
                    while (true) {
                        int i8 = i - 1;
                        if (i3 < i8) {
                            arrayList.add(list.get(i3));
                            i3++;
                        } else {
                            String strPr6 = pr(pr(list, i8, list.size()), f, hnVar, f2, f3, z, 0);
                            pr prVarHo5 = ho();
                            prVarHo5.pr(strPr6, f);
                            arrayList.add(prVarHo5);
                        }
                        break;
                    }
                    break;
            }
        }
        return arrayList;
    }

    private String pr(List<pr> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<pr> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().pr);
        }
        return sb.toString();
    }

    private String pr(List<pr> list, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2 && i < list.size()) {
            sb.append(list.get(i).pr);
            i++;
        }
        return sb.toString();
    }

    private String pr(String str, float f, com.byazt.uxi.hn hnVar, float f2, float f3, boolean z, int i) {
        float fMeasureText;
        if (z) {
            com.byazt.uxi.x xVar = this.lb.ho().get(com.byazt.uxi.x.pr(str.length() > 0 ? str.charAt(0) : ' ', hnVar.pr(), hnVar.hn()));
            fMeasureText = (xVar != null ? (((float) xVar.hw()) * f2 * com.byazt.ptr.vk.pr()) + f3 : 10.0f) * 3.0f;
        } else {
            fMeasureText = this.vk.measureText("...") + (2.0f * f3);
        }
        String strPr = pr(str, 0, f, fMeasureText, hnVar, f2, f3, z, i);
        return strPr != null ? strPr : str;
    }

    private String pr(String str, float f, com.byazt.uxi.hn hnVar, float f2, float f3, boolean z) {
        return pr(str, 0, f, hnVar, f2, f3, z);
    }

    public void pr(String str) {
        this.gz = str;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 785})
    private static class pr {
        public float hw;
        public String pr;

        private pr() {
            this.pr = "";
            this.hw = 0.0f;
        }

        public void pr(String str, float f) {
            this.pr = str;
            this.hw = f;
        }
    }
}
