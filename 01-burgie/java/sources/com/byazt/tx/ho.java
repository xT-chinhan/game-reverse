package com.byazt.tx;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 19})
public class ho implements qn<com.byazt.ynb.x> {
    public int pr;

    public ho(int i) {
        this.pr = i;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c4  */
    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.ynb.x hw(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.pr = 2;
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.pr == -1) {
            this.pr = arrayList.size() / 4;
        }
        int i = this.pr;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.pr * 4; i4++) {
            int i5 = i4 / 4;
            double dFloatValue = arrayList.get(i4).floatValue();
            switch (i4 % 4) {
                case 0:
                    if (i5 > 0) {
                        float f2 = (float) dFloatValue;
                        if (fArr[i5 - 1] >= f2) {
                            fArr[i5] = f2 + 0.01f;
                        } else {
                            fArr[i5] = (float) dFloatValue;
                        }
                    } else {
                        fArr[i5] = (float) dFloatValue;
                    }
                    break;
                case 1:
                    i2 = (int) (dFloatValue * 255.0d);
                    break;
                case 2:
                    i3 = (int) (dFloatValue * 255.0d);
                    break;
                case 3:
                    iArr[i5] = Color.argb(255, i2, i3, (int) (dFloatValue * 255.0d));
                    break;
            }
        }
        return pr(new com.byazt.ynb.x(fArr, iArr), arrayList);
    }

    private com.byazt.ynb.x pr(com.byazt.ynb.x xVar, List<Float> list) {
        int i = this.pr * 4;
        if (list.size() <= i) {
            return xVar;
        }
        float[] fArrPr = xVar.pr();
        int[] iArrHw = xVar.hw();
        int size = (list.size() - i) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                fArr[i2] = list.get(i).floatValue();
            } else {
                fArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        float[] fArrPr2 = pr(xVar.pr(), fArr);
        int length = fArrPr2.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            float f = fArrPr2[i3];
            int iBinarySearch = Arrays.binarySearch(fArrPr, f);
            int iBinarySearch2 = Arrays.binarySearch(fArr, f);
            if (iBinarySearch < 0 || iBinarySearch2 > 0) {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = -(iBinarySearch2 + 1);
                }
                iArr[i3] = pr(f, fArr2[iBinarySearch2], fArrPr, iArrHw);
            } else {
                iArr[i3] = pr(f, iArrHw[iBinarySearch], fArr, fArr2);
            }
        }
        return new com.byazt.ynb.x(fArrPr2, iArr);
    }

    public int pr(float f, float f2, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f == fArr[0]) {
            return iArr[0];
        }
        for (int i = 1; i < fArr.length; i++) {
            float f3 = fArr[i];
            if (f3 >= f || i == fArr.length - 1) {
                int i2 = i - 1;
                float f4 = fArr[i2];
                float f5 = (f - f4) / (f3 - f4);
                int i3 = iArr[i];
                int i4 = iArr[i2];
                return Color.argb((int) (f2 * 255.0f), com.byazt.ptr.x.pr(f5, Color.red(i4), Color.red(i3)), com.byazt.ptr.x.pr(f5, Color.green(i4), Color.green(i3)), com.byazt.ptr.x.pr(f5, Color.blue(i4), Color.blue(i3)));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    private int pr(float f, int i, float[] fArr, float[] fArr2) {
        int iPr;
        if (fArr2.length < 2 || f <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 >= f || i2 == fArr.length - 1) {
                if (f2 <= f) {
                    iPr = (int) (fArr2[i2] * 255.0f);
                } else {
                    int i3 = i2 - 1;
                    float f3 = fArr[i3];
                    iPr = (int) (com.byazt.ptr.aj.pr(fArr2[i3], fArr2[i2], (f - f3) / (f2 - f3)) * 255.0f);
                }
                return Color.argb(iPr, Color.red(i), Color.green(i), Color.blue(i));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    public static float[] pr(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f = i2 < fArr.length ? fArr[i2] : Float.NaN;
            float f2 = i3 < fArr2.length ? fArr2[i3] : Float.NaN;
            if (Float.isNaN(f2) || f < f2) {
                fArr3[i4] = f;
                i2++;
            } else if (Float.isNaN(f) || f2 < f) {
                fArr3[i4] = f2;
                i3++;
            } else {
                fArr3[i4] = f;
                i2++;
                i3++;
                i++;
            }
        }
        if (i == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i);
    }
}
