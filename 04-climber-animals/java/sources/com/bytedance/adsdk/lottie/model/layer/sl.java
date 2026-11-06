package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.xr.ao;
import com.bytedance.adsdk.lottie.ms.xr.ub;
import com.bytedance.adsdk.lottie.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ah {
    private final StringBuilder ab;
    private final com.bytedance.adsdk.lottie.x ao;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> b;
    private final Paint ch;
    private final com.bytedance.adsdk.lottie.c h;
    private final Paint hi;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> i;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> nw;
    private final Matrix ny;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Typeface, Typeface> op;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> qv;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> re;
    private final Map<com.bytedance.adsdk.lottie.model.d, List<com.bytedance.adsdk.lottie.ms.ms.d>> sl;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> t;
    private final List<ms> u;
    private final ub ub;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> w;
    private final RectF x;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> y;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> yu;
    private final LongSparseArray<String> zb;

    sl(com.bytedance.adsdk.lottie.x xVar, x xVar2) {
        super(xVar, xVar2);
        this.ab = new StringBuilder(2);
        this.x = new RectF();
        this.ny = new Matrix();
        int i = 1;
        this.ch = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.sl.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.hi = new Paint(i) { // from class: com.bytedance.adsdk.lottie.model.layer.sl.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.sl = new HashMap();
        this.zb = new LongSparseArray<>();
        this.u = new ArrayList();
        this.ao = xVar;
        this.h = xVar2.ms();
        ub ubVarMs = xVar2.y().ms();
        this.ub = ubVarMs;
        ubVarMs.ms(this);
        ms(ubVarMs);
        com.bytedance.adsdk.lottie.model.ms.hi hiVarT = xVar2.t();
        if (hiVarT != null && hiVarT.f209ms != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs = hiVarT.f209ms.ms();
            this.qv = msVarMs;
            msVarMs.ms(this);
            ms(this.qv);
        }
        if (hiVarT != null && hiVarT.xr != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs2 = hiVarT.xr.ms();
            this.t = msVarMs2;
            msVarMs2.ms(this);
            ms(this.t);
        }
        if (hiVarT != null && hiVarT.ah != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs3 = hiVarT.ah.ms();
            this.b = msVarMs3;
            msVarMs3.ms(this);
            ms(this.b);
        }
        if (hiVarT == null || hiVarT.d == null) {
            return;
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs4 = hiVarT.d.ms();
        this.i = msVarMs4;
        msVarMs4.ms(this);
        ms(this.i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        super.ms(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.h.d().width(), this.h.d().height());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        super.xr(canvas, matrix, i);
        com.bytedance.adsdk.lottie.model.xr xrVarAb = this.ub.ab();
        com.bytedance.adsdk.lottie.model.ah ahVar = this.h.ao().get(xrVarAb.xr);
        if (ahVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        ms(xrVarAb, matrix);
        if (this.ao.yu()) {
            ms(xrVarAb, matrix, ahVar, canvas);
        } else {
            ms(xrVarAb, ahVar, canvas);
        }
        canvas.restore();
    }

    private void ms(com.bytedance.adsdk.lottie.model.xr xrVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar = this.y;
        if (msVar != null) {
            this.ch.setColor(msVar.ab().intValue());
        } else {
            com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2 = this.qv;
            if (msVar2 != null) {
                this.ch.setColor(msVar2.ab().intValue());
            } else {
                this.ch.setColor(xrVar.x);
            }
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar3 = this.nw;
        if (msVar3 != null) {
            this.hi.setColor(msVar3.ab().intValue());
        } else {
            com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar4 = this.t;
            if (msVar4 != null) {
                this.hi.setColor(msVar4.ab().intValue());
            } else {
                this.hi.setColor(xrVar.ny);
            }
        }
        int iIntValue = ((this.d.ms() == null ? 100 : this.d.ms().ab().intValue()) * 255) / 100;
        this.ch.setAlpha(iIntValue);
        this.hi.setAlpha(iIntValue);
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar5 = this.re;
        if (msVar5 != null) {
            this.hi.setStrokeWidth(msVar5.ab().floatValue());
            return;
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar6 = this.b;
        if (msVar6 != null) {
            this.hi.setStrokeWidth(msVar6.ab().floatValue());
        } else {
            this.hi.setStrokeWidth(xrVar.ch * com.bytedance.adsdk.lottie.ka.ny.ms());
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0053  */
    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    /* JADX WARN: Code duplicated, block: B:18:0x0060  */
    /* JADX WARN: Code duplicated, block: B:22:0x007c A[LOOP:1: B:20:0x0076->B:22:0x007c, LOOP_END] */
    private void ms(com.bytedance.adsdk.lottie.model.xr xrVar, Matrix matrix, com.bytedance.adsdk.lottie.model.ah ahVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float f;
        int i;
        int i2;
        float f2;
        List<ms> listMs;
        int i3;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar = this.yu;
        if (msVar != null) {
            fFloatValue = msVar.ab().floatValue();
        } else {
            fFloatValue = xrVar.ah;
        }
        float f3 = fFloatValue / 100.0f;
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms(matrix);
        List<String> listMs2 = ms(xrVar.f214ms);
        int size = listMs2.size();
        float f4 = xrVar.ka / 10.0f;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar2 = this.w;
        if (msVar2 != null) {
            fFloatValue2 = msVar2.ab().floatValue();
        } else {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar3 = this.i;
            if (msVar3 != null) {
                fFloatValue2 = msVar3.ab().floatValue();
            }
            f = f4;
            i = -1;
            i2 = 0;
            while (i2 < size) {
                String str = listMs2.get(i2);
                if (xrVar.zb == null) {
                    f2 = 0.0f;
                } else {
                    f2 = xrVar.zb.x;
                }
                int i4 = i2;
                listMs = ms(str, f2, ahVar, f3, f, true);
                i3 = 0;
                while (i3 < listMs.size()) {
                    ms msVar4 = listMs.get(i3);
                    int i5 = i + 1;
                    canvas.save();
                    ms(canvas, xrVar, i5, msVar4.xr);
                    ms(msVar4.f198ms, xrVar, ahVar, canvas, fMs, f3, f);
                    canvas.restore();
                    i3++;
                    listMs = listMs;
                    i = i5;
                }
                i2 = i4 + 1;
            }
        }
        f4 += fFloatValue2;
        f = f4;
        i = -1;
        i2 = 0;
        while (i2 < size) {
            String str2 = listMs2.get(i2);
            if (xrVar.zb == null) {
                f2 = 0.0f;
            } else {
                f2 = xrVar.zb.x;
            }
            int i6 = i2;
            listMs = ms(str2, f2, ahVar, f3, f, true);
            i3 = 0;
            while (i3 < listMs.size()) {
                ms msVar5 = listMs.get(i3);
                int i7 = i + 1;
                canvas.save();
                ms(canvas, xrVar, i7, msVar5.xr);
                ms(msVar5.f198ms, xrVar, ahVar, canvas, fMs, f3, f);
                canvas.restore();
                i3++;
                listMs = listMs;
                i = i7;
            }
            i2 = i6 + 1;
        }
    }

    private void ms(String str, com.bytedance.adsdk.lottie.model.xr xrVar, com.bytedance.adsdk.lottie.model.ah ahVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.lottie.model.d dVar = this.h.ub().get(com.bytedance.adsdk.lottie.model.d.ms(str.charAt(i), ahVar.ms(), ahVar.ah()));
            if (dVar != null) {
                ms(dVar, f2, xrVar, canvas);
                canvas.translate((((float) dVar.xr()) * f2 * com.bytedance.adsdk.lottie.ka.ny.ms()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0094  */
    /* JADX WARN: Code duplicated, block: B:23:0x009f  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bd A[LOOP:1: B:26:0x00b7->B:28:0x00bd, LOOP_END] */
    private void ms(com.bytedance.adsdk.lottie.model.xr xrVar, com.bytedance.adsdk.lottie.model.ah ahVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float fMs;
        List<String> listMs;
        int size;
        int i;
        int i2;
        float f;
        List<ms> listMs2;
        int i3;
        Typeface typefaceMs = ms(ahVar);
        if (typefaceMs == null) {
            return;
        }
        String strAh = xrVar.f214ms;
        t tVarW = this.ao.w();
        if (tVarW != null) {
            strAh = tVarW.ah(hi(), strAh);
        }
        this.ch.setTypeface(typefaceMs);
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar = this.yu;
        if (msVar != null) {
            fFloatValue = msVar.ab().floatValue();
        } else {
            fFloatValue = xrVar.ah;
        }
        this.ch.setTextSize(com.bytedance.adsdk.lottie.ka.ny.ms() * fFloatValue);
        this.hi.setTypeface(this.ch.getTypeface());
        this.hi.setTextSize(this.ch.getTextSize());
        float f2 = xrVar.ka / 10.0f;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar2 = this.w;
        if (msVar2 != null) {
            fFloatValue2 = msVar2.ab().floatValue();
        } else {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar3 = this.i;
            if (msVar3 != null) {
                fFloatValue2 = msVar3.ab().floatValue();
            }
            fMs = ((f2 * com.bytedance.adsdk.lottie.ka.ny.ms()) * fFloatValue) / 100.0f;
            listMs = ms(strAh);
            size = listMs.size();
            i = -1;
            i2 = 0;
            while (i2 < size) {
                String str = listMs.get(i2);
                if (xrVar.zb == null) {
                    f = 0.0f;
                } else {
                    f = xrVar.zb.x;
                }
                int i4 = i2;
                listMs2 = ms(str, f, ahVar, 0.0f, fMs, false);
                for (i3 = 0; i3 < listMs2.size(); i3++) {
                    ms msVar4 = listMs2.get(i3);
                    i++;
                    canvas.save();
                    ms(canvas, xrVar, i, msVar4.xr);
                    ms(msVar4.f198ms, xrVar, canvas, fMs);
                    canvas.restore();
                }
                i2 = i4 + 1;
            }
        }
        f2 += fFloatValue2;
        fMs = ((f2 * com.bytedance.adsdk.lottie.ka.ny.ms()) * fFloatValue) / 100.0f;
        listMs = ms(strAh);
        size = listMs.size();
        i = -1;
        i2 = 0;
        while (i2 < size) {
            String str2 = listMs.get(i2);
            if (xrVar.zb == null) {
                f = 0.0f;
            } else {
                f = xrVar.zb.x;
            }
            int i5 = i2;
            listMs2 = ms(str2, f, ahVar, 0.0f, fMs, false);
            while (i3 < listMs2.size()) {
                ms msVar5 = listMs2.get(i3);
                i++;
                canvas.save();
                ms(canvas, xrVar, i, msVar5.xr);
                ms(msVar5.f198ms, xrVar, canvas, fMs);
                canvas.restore();
            }
            i2 = i5 + 1;
        }
    }

    private void ms(Canvas canvas, com.bytedance.adsdk.lottie.model.xr xrVar, int i, float f) {
        PointF pointF = xrVar.sl;
        PointF pointF2 = xrVar.zb;
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        float f2 = (i * xrVar.c * fMs) + (pointF == null ? 0.0f : (xrVar.c * 0.6f * fMs) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.f197ms[xrVar.d.ordinal()];
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

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.sl$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f197ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.lottie.model.xr.ms.values().length];
            f197ms = iArr;
            try {
                iArr[com.bytedance.adsdk.lottie.model.xr.ms.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f197ms[com.bytedance.adsdk.lottie.model.xr.ms.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f197ms[com.bytedance.adsdk.lottie.model.xr.ms.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface ms(com.bytedance.adsdk.lottie.model.ah ahVar) {
        Typeface typefaceAb;
        com.bytedance.adsdk.lottie.ms.xr.ms<Typeface, Typeface> msVar = this.op;
        if (msVar != null && (typefaceAb = msVar.ab()) != null) {
            return typefaceAb;
        }
        Typeface typefaceMs = this.ao.ms(ahVar);
        return typefaceMs != null ? typefaceMs : ahVar.d();
    }

    private List<String> ms(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void ms(String str, com.bytedance.adsdk.lottie.model.xr xrVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strMs = ms(str, length);
            length += strMs.length();
            ms(strMs, xrVar, canvas);
            canvas.translate(this.ch.measureText(strMs) + f, 0.0f);
        }
    }

    private List<ms> ms(String str, float f, com.bytedance.adsdk.lottie.model.ah ahVar, float f2, float f3, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.lottie.model.d dVar = this.h.ub().get(com.bytedance.adsdk.lottie.model.d.ms(cCharAt, ahVar.ms(), ahVar.ah()));
                if (dVar != null) {
                    fMeasureText = ((float) dVar.xr()) * f2 * com.bytedance.adsdk.lottie.ka.ny.ms();
                }
            } else {
                fMeasureText = this.ch.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                ms msVarXr = xr(i);
                if (i3 == i2) {
                    String strSubstring = str.substring(i2, i4);
                    String strTrim = strSubstring.trim();
                    msVarXr.ms(strTrim, (f4 - f7) - ((strTrim.length() - strSubstring.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    String strSubstring2 = str.substring(i2, i3 - 1);
                    String strTrim2 = strSubstring2.trim();
                    msVarXr.ms(strTrim2, ((f4 - f5) - ((strSubstring2.length() - strTrim2.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            xr(i).ms(str.substring(i2), f4);
        }
        return this.u.subList(0, i);
    }

    private ms xr(int i) {
        for (int size = this.u.size(); size < i; size++) {
            this.u.add(new ms());
        }
        return this.u.get(i - 1);
    }

    private void ms(com.bytedance.adsdk.lottie.model.d dVar, float f, com.bytedance.adsdk.lottie.model.xr xrVar, Canvas canvas) {
        List<com.bytedance.adsdk.lottie.ms.ms.d> listMs = ms(dVar);
        for (int i = 0; i < listMs.size(); i++) {
            Path pathD = listMs.get(i).d();
            pathD.computeBounds(this.x, false);
            this.ny.reset();
            this.ny.preTranslate(0.0f, (-xrVar.ab) * com.bytedance.adsdk.lottie.ka.ny.ms());
            this.ny.preScale(f, f);
            pathD.transform(this.ny);
            if (xrVar.hi) {
                ms(pathD, this.ch, canvas);
                ms(pathD, this.hi, canvas);
            } else {
                ms(pathD, this.hi, canvas);
                ms(pathD, this.ch, canvas);
            }
        }
    }

    private void ms(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void ms(String str, com.bytedance.adsdk.lottie.model.xr xrVar, Canvas canvas) {
        if (xrVar.hi) {
            ms(str, this.ch, canvas);
            ms(str, this.hi, canvas);
        } else {
            ms(str, this.hi, canvas);
            ms(str, this.ch, canvas);
        }
    }

    private void ms(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.lottie.ms.ms.d> ms(com.bytedance.adsdk.lottie.model.d dVar) {
        if (this.sl.containsKey(dVar)) {
            return this.sl.get(dVar);
        }
        List<ao> listMs = dVar.ms();
        int size = listMs.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.lottie.ms.ms.d(this.ao, this, listMs.get(i), this.h));
        }
        this.sl.put(dVar, arrayList);
        return arrayList;
    }

    private String ms(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!ah(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.zb.indexOfKey(j) >= 0) {
            return this.zb.get(j);
        }
        this.ab.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.ab.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.ab.toString();
        this.zb.put(j, string);
        return string;
    }

    private boolean ah(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f198ms;
        private float xr;

        private ms() {
            this.f198ms = "";
            this.xr = 0.0f;
        }

        void ms(String str, float f) {
            this.f198ms = str;
            this.xr = f;
        }
    }
}
