package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.umeng.analytics.pro.bv;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Interpolator f163ms = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> xr;

    t() {
    }

    private static SparseArray<WeakReference<Interpolator>> ms() {
        if (xr == null) {
            xr = new SparseArray<>();
        }
        return xr;
    }

    private static WeakReference<Interpolator> ms(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (t.class) {
            weakReference = ms().get(i);
        }
        return weakReference;
    }

    private static void ms(int i, WeakReference<Interpolator> weakReference) {
        synchronized (t.class) {
            xr.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.lottie.c.ms<T> ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, float f, e<T> eVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return xr(cVar, jsonReader, f, eVar);
        }
        if (z) {
            return ms(cVar, jsonReader, f, eVar);
        }
        return ms(jsonReader, f, eVar);
    }

    private static <T> com.bytedance.adsdk.lottie.c.ms<T> ms(com.bytedance.adsdk.lottie.c cVar, JsonReader jsonReader, float f, e<T> eVar) throws IOException {
        Interpolator interpolatorMs;
        jsonReader.beginObject();
        PointF pointFXr = null;
        T tXr = null;
        T tXr2 = null;
        PointF pointFXr2 = null;
        PointF pointFXr3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFXr4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tXr = eVar.xr(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFXr4 = y.xr(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFXr = y.xr(jsonReader, 1.0f);
                    break;
                case "s":
                    tXr2 = eVar.xr(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFXr3 = y.xr(jsonReader, f);
                    break;
                case "to":
                    pointFXr2 = y.xr(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFXr != null && pointFXr4 != null) {
                interpolatorMs = ms(pointFXr, pointFXr4);
            }
            com.bytedance.adsdk.lottie.c.ms<T> msVar = new com.bytedance.adsdk.lottie.c.ms<>(cVar, tXr2, tXr, interpolatorMs, fNextDouble, null);
            msVar.x = pointFXr2;
            msVar.ny = pointFXr3;
            return msVar;
        }
        tXr = tXr2;
        interpolatorMs = f163ms;
        com.bytedance.adsdk.lottie.c.ms<T> msVar2 = new com.bytedance.adsdk.lottie.c.ms<>(cVar, tXr2, tXr, interpolatorMs, fNextDouble, null);
        msVar2.x = pointFXr2;
        msVar2.ny = pointFXr3;
        return msVar2;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0273  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static <T> com.bytedance.adsdk.lottie.c.ms<T> xr(com.bytedance.adsdk.lottie.c cVar, JsonReader jsonReader, float f, e<T> eVar) throws IOException {
        Interpolator interpolatorMs;
        Interpolator interpolatorMs2;
        T t;
        Interpolator interpolatorMs3;
        com.bytedance.adsdk.lottie.c.ms<T> msVar;
        float f2;
        PointF pointF;
        PointF pointF2;
        T t2;
        String str;
        String str2;
        jsonReader.beginObject();
        PointF pointFXr = null;
        boolean z = false;
        PointF pointFXr2 = null;
        PointF pointFXr3 = null;
        PointF pointF3 = null;
        T tXr = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fNextDouble = 0.0f;
        PointF pointFXr4 = null;
        T tXr2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 101:
                    if (strNextName.equals("e")) {
                        b = 0;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 1;
                    }
                    break;
                case 105:
                    if (strNextName.equals("i")) {
                        b = 2;
                    }
                    break;
                case 111:
                    if (strNextName.equals("o")) {
                        b = 3;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 4;
                    }
                    break;
                case 116:
                    if (strNextName.equals(bv.aI)) {
                        b = 5;
                    }
                    break;
                case 3701:
                    if (strNextName.equals("ti")) {
                        b = 6;
                    }
                    break;
                case 3707:
                    if (strNextName.equals("to")) {
                        b = 7;
                    }
                    break;
            }
            String str3 = "y";
            String str4 = "x";
            switch (b) {
                case 0:
                    f2 = fNextDouble;
                    tXr2 = eVar.xr(jsonReader, f);
                    fNextDouble = f2;
                    break;
                case 1:
                    pointF = pointFXr;
                    f2 = fNextDouble;
                    pointF2 = pointFXr4;
                    t2 = tXr;
                    z = jsonReader.nextInt() == 1;
                    tXr = t2;
                    pointFXr4 = pointF2;
                    pointFXr = pointF;
                    fNextDouble = f2;
                    break;
                case 2:
                    pointF = pointFXr;
                    f2 = fNextDouble;
                    pointF2 = pointFXr4;
                    t2 = tXr;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(str4)) {
                                str = str3;
                                str2 = str4;
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (strNextName2.equals(str3)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    str = str3;
                                    str2 = str4;
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                    fNextDouble3 = fNextDouble5;
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    jsonReader.beginArray();
                                    fNextDouble3 = (float) jsonReader.nextDouble();
                                    fNextDouble5 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble3;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            str3 = str;
                            str4 = str2;
                        }
                        PointF pointF7 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF8 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF6 = pointF8;
                        pointF5 = pointF7;
                    } else {
                        pointFXr3 = y.xr(jsonReader, f);
                    }
                    tXr = t2;
                    pointFXr4 = pointF2;
                    pointFXr = pointF;
                    fNextDouble = f2;
                    break;
                case 3:
                    pointF2 = pointFXr4;
                    pointF = pointFXr;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            float f3 = fNextDouble;
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("x")) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                }
                                tXr = tXr;
                            } else if (strNextName3.equals("y")) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble9 = (float) jsonReader.nextDouble();
                                    fNextDouble7 = fNextDouble9;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble7 = (float) jsonReader.nextDouble();
                                    fNextDouble9 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble7;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            fNextDouble = f3;
                        }
                        f2 = fNextDouble;
                        PointF pointF9 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF10 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF4 = pointF10;
                        pointF3 = pointF9;
                    } else {
                        f2 = fNextDouble;
                        pointFXr2 = y.xr(jsonReader, f);
                    }
                    pointFXr4 = pointF2;
                    pointFXr = pointF;
                    fNextDouble = f2;
                    break;
                case 4:
                    tXr = eVar.xr(jsonReader, f);
                    break;
                case 5:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    pointFXr = y.xr(jsonReader, f);
                    break;
                case 7:
                    pointFXr4 = y.xr(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF11 = pointFXr;
        float f4 = fNextDouble;
        PointF pointF12 = pointFXr4;
        T t3 = tXr;
        jsonReader.endObject();
        if (!z) {
            if (pointFXr2 != null && pointFXr3 != null) {
                interpolatorMs3 = ms(pointFXr2, pointFXr3);
                t = tXr2;
                interpolatorMs = null;
                interpolatorMs2 = null;
            } else if (pointF3 != null && pointF4 != null && pointF5 != null && pointF6 != null) {
                interpolatorMs = ms(pointF3, pointF5);
                interpolatorMs2 = ms(pointF4, pointF6);
                t = tXr2;
                interpolatorMs3 = null;
            }
            if (interpolatorMs == null && interpolatorMs2 != null) {
                msVar = new com.bytedance.adsdk.lottie.c.ms<>(cVar, t3, t, interpolatorMs, interpolatorMs2, f4, null);
            } else {
                msVar = new com.bytedance.adsdk.lottie.c.ms<>(cVar, t3, t, interpolatorMs3, f4, null);
            }
            msVar.x = pointF12;
            msVar.ny = pointF11;
            return msVar;
        }
        tXr2 = t3;
        interpolatorMs3 = f163ms;
        t = tXr2;
        interpolatorMs = null;
        interpolatorMs2 = null;
        if (interpolatorMs == null) {
            msVar = new com.bytedance.adsdk.lottie.c.ms<>(cVar, t3, t, interpolatorMs3, f4, null);
        } else {
            msVar = new com.bytedance.adsdk.lottie.c.ms<>(cVar, t3, t, interpolatorMs3, f4, null);
        }
        msVar.x = pointF12;
        msVar.ny = pointF11;
        return msVar;
    }

    private static Interpolator ms(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.ka.x.xr(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.ka.x.xr(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.ka.x.xr(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.lottie.ka.x.xr(pointF2.y, -100.0f, 100.0f);
        int iMs = com.bytedance.adsdk.lottie.ka.ny.ms(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceMs = com.bytedance.adsdk.lottie.ka.ms() ? null : ms(iMs);
        Interpolator interpolator = weakReferenceMs != null ? weakReferenceMs.get() : null;
        if (weakReferenceMs == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.lottie.h.ms(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.lottie.h.ms(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.lottie.ka.ms()) {
                try {
                    ms(iMs, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.c.ms<T> ms(JsonReader jsonReader, float f, e<T> eVar) throws IOException {
        return new com.bytedance.adsdk.lottie.c.ms<>(eVar.xr(jsonReader, f));
    }
}
