package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public static SparseArray<WeakReference<Interpolator>> hw;
    public static final Interpolator pr = new LinearInterpolator();

    private static SparseArray<WeakReference<Interpolator>> pr() {
        if (hw == null) {
            hw = new SparseArray<>();
        }
        return hw;
    }

    private static WeakReference<Interpolator> pr(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (a.class) {
            weakReference = pr().get(i);
        }
        return weakReference;
    }

    private static void pr(int i, WeakReference<Interpolator> weakReference) {
        synchronized (a.class) {
            hw.put(i, weakReference);
        }
    }

    public static <T> com.byazt.cz.pr<T> pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, float f, qn<T> qnVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return hw(ucVar, jsonReader, f, qnVar);
        }
        if (z) {
            return pr(ucVar, jsonReader, f, qnVar);
        }
        return pr(jsonReader, f, qnVar);
    }

    private static <T> com.byazt.cz.pr<T> pr(com.byazt.dx.uc ucVar, JsonReader jsonReader, float f, qn<T> qnVar) throws IOException {
        Interpolator interpolatorPr;
        T t;
        jsonReader.beginObject();
        PointF pointFHw = null;
        boolean z = false;
        T tHw = null;
        T tHw2 = null;
        PointF pointFHw2 = null;
        PointF pointFHw3 = null;
        float fNextDouble = 0.0f;
        PointF pointFHw4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "s":
                    tHw2 = qnVar.hw(jsonReader, f);
                    break;
                case "e":
                    tHw = qnVar.hw(jsonReader, f);
                    break;
                case "o":
                    pointFHw = qa.hw(jsonReader, 1.0f);
                    break;
                case "i":
                    pointFHw4 = qa.hw(jsonReader, 1.0f);
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
                case "to":
                    pointFHw2 = qa.hw(jsonReader, f);
                    break;
                case "ti":
                    pointFHw3 = qa.hw(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            tHw = tHw2;
        } else {
            if (pointFHw != null && pointFHw4 != null) {
                interpolatorPr = pr(pointFHw, pointFHw4);
                t = tHw;
            }
            com.byazt.cz.pr<T> prVar = new com.byazt.cz.pr<>(ucVar, tHw2, t, interpolatorPr, fNextDouble, null);
            prVar.zo = pointFHw2;
            prVar.aj = pointFHw3;
            return prVar;
        }
        interpolatorPr = pr;
        t = tHw;
        com.byazt.cz.pr<T> prVar2 = new com.byazt.cz.pr<>(ucVar, tHw2, t, interpolatorPr, fNextDouble, null);
        prVar2.zo = pointFHw2;
        prVar2.aj = pointFHw3;
        return prVar2;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x02ea  */
    private static <T> com.byazt.cz.pr<T> hw(com.byazt.dx.uc ucVar, JsonReader jsonReader, float f, qn<T> qnVar) throws IOException {
        Interpolator interpolatorPr;
        Interpolator interpolatorPr2;
        Interpolator interpolatorPr3;
        com.byazt.cz.pr<T> prVar;
        byte b;
        byte b2;
        jsonReader.beginObject();
        PointF pointFHw = null;
        boolean z = false;
        PointF pointFHw2 = null;
        PointF pointFHw3 = null;
        PointF pointF = null;
        T tHw = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        float fNextDouble = 0.0f;
        PointF pointFHw4 = null;
        T tHw2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "e":
                    b = 2;
                    break;
                case "h":
                    b = 5;
                    break;
                case "i":
                    b = 4;
                    break;
                case "o":
                    b = 3;
                    break;
                case "s":
                    b = 1;
                    break;
                case "t":
                    b = 0;
                    break;
                case "ti":
                    b = 7;
                    break;
                case "to":
                    b = 6;
                    break;
                default:
                    b = -1;
                    break;
            }
            PointF pointF5 = pointFHw4;
            String str = "x";
            switch (b) {
                case 0:
                    fNextDouble = (float) jsonReader.nextDouble();
                    pointFHw4 = pointF5;
                    pointFHw = pointFHw;
                    pointF2 = pointF2;
                    break;
                case 1:
                    tHw = qnVar.hw(jsonReader, f);
                    pointFHw4 = pointF5;
                    break;
                case 2:
                    tHw2 = qnVar.hw(jsonReader, f);
                    pointFHw4 = pointF5;
                    pointF2 = pointF2;
                    break;
                case 3:
                    PointF pointF6 = pointFHw;
                    PointF pointF7 = pointF2;
                    float f2 = fNextDouble;
                    T t = tHw;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName = jsonReader.nextName();
                            switch (strNextName.hashCode()) {
                                case 120:
                                    b2 = !strNextName.equals(str) ? (byte) -1 : (byte) 0;
                                    break;
                                case 121:
                                    b2 = !strNextName.equals("y") ? (byte) -1 : (byte) 1;
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        fNextDouble4 = (float) jsonReader.nextDouble();
                                        fNextDouble2 = fNextDouble4;
                                        t = t;
                                        str = str;
                                    } else {
                                        T t2 = t;
                                        String str2 = str;
                                        jsonReader.beginArray();
                                        fNextDouble2 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == JsonToken.NUMBER) {
                                            fNextDouble4 = (float) jsonReader.nextDouble();
                                        } else {
                                            fNextDouble4 = fNextDouble2;
                                        }
                                        jsonReader.endArray();
                                        t = t2;
                                        str = str2;
                                    }
                                    break;
                                case 1:
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        fNextDouble5 = (float) jsonReader.nextDouble();
                                        fNextDouble3 = fNextDouble5;
                                    } else {
                                        jsonReader.beginArray();
                                        fNextDouble3 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == JsonToken.NUMBER) {
                                            fNextDouble5 = (float) jsonReader.nextDouble();
                                        } else {
                                            fNextDouble5 = fNextDouble3;
                                        }
                                        jsonReader.endArray();
                                    }
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        PointF pointF8 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF9 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF = pointF8;
                        tHw = t;
                        pointFHw4 = pointF5;
                        fNextDouble = f2;
                        pointF2 = pointF9;
                        pointFHw = pointF6;
                    } else {
                        pointFHw2 = qa.hw(jsonReader, f);
                        tHw = t;
                        pointFHw4 = pointF5;
                        pointFHw = pointF6;
                        fNextDouble = f2;
                        pointF2 = pointF7;
                    }
                    break;
                case 4:
                    PointF pointF10 = pointFHw;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            fNextDouble = fNextDouble;
                            switch (jsonReader.nextName()) {
                                case "x":
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        fNextDouble8 = (float) jsonReader.nextDouble();
                                        fNextDouble6 = fNextDouble8;
                                        tHw = tHw;
                                        pointF2 = pointF2;
                                        break;
                                    } else {
                                        T t3 = tHw;
                                        PointF pointF11 = pointF2;
                                        jsonReader.beginArray();
                                        fNextDouble6 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == JsonToken.NUMBER) {
                                            fNextDouble8 = (float) jsonReader.nextDouble();
                                        } else {
                                            fNextDouble8 = fNextDouble6;
                                        }
                                        jsonReader.endArray();
                                        tHw = t3;
                                        pointF2 = pointF11;
                                        break;
                                    }
                                    break;
                                case "y":
                                    if (jsonReader.peek() == JsonToken.NUMBER) {
                                        fNextDouble9 = (float) jsonReader.nextDouble();
                                        fNextDouble7 = fNextDouble9;
                                        break;
                                    } else {
                                        jsonReader.beginArray();
                                        fNextDouble7 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == JsonToken.NUMBER) {
                                            fNextDouble9 = (float) jsonReader.nextDouble();
                                        } else {
                                            fNextDouble9 = fNextDouble7;
                                        }
                                        jsonReader.endArray();
                                        break;
                                    }
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        PointF pointF12 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF13 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF4 = pointF13;
                        pointF3 = pointF12;
                        pointFHw4 = pointF5;
                        pointFHw = pointF10;
                        fNextDouble = fNextDouble;
                    } else {
                        pointFHw3 = qa.hw(jsonReader, f);
                        pointFHw4 = pointF5;
                        pointFHw = pointF10;
                        fNextDouble = fNextDouble;
                    }
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    pointFHw4 = pointF5;
                    break;
                case 6:
                    pointFHw4 = qa.hw(jsonReader, f);
                    break;
                case 7:
                    pointFHw = qa.hw(jsonReader, f);
                    pointFHw4 = pointF5;
                    break;
                default:
                    jsonReader.skipValue();
                    pointFHw4 = pointF5;
                    pointF2 = pointF2;
                    break;
            }
        }
        PointF pointF14 = pointFHw;
        PointF pointF15 = pointF2;
        float f3 = fNextDouble;
        PointF pointF16 = pointFHw4;
        T t4 = tHw;
        jsonReader.endObject();
        if (z) {
            tHw2 = t4;
        } else {
            if (pointFHw2 != null && pointFHw3 != null) {
                interpolatorPr3 = pr(pointFHw2, pointFHw3);
                interpolatorPr = null;
                interpolatorPr2 = null;
            } else if (pointF != null && pointF15 != null && pointF3 != null && pointF4 != null) {
                interpolatorPr = pr(pointF, pointF3);
                interpolatorPr2 = pr(pointF15, pointF4);
                interpolatorPr3 = null;
            }
            if (interpolatorPr == null && interpolatorPr2 != null) {
                prVar = new com.byazt.cz.pr<>(ucVar, t4, tHw2, interpolatorPr, interpolatorPr2, f3, null);
            } else {
                prVar = new com.byazt.cz.pr<>(ucVar, t4, tHw2, interpolatorPr3, f3, null);
            }
            prVar.zo = pointF16;
            prVar.aj = pointF14;
            return prVar;
        }
        interpolatorPr3 = pr;
        interpolatorPr = null;
        interpolatorPr2 = null;
        if (interpolatorPr == null) {
            prVar = new com.byazt.cz.pr<>(ucVar, t4, tHw2, interpolatorPr3, f3, null);
        } else {
            prVar = new com.byazt.cz.pr<>(ucVar, t4, tHw2, interpolatorPr3, f3, null);
        }
        prVar.zo = pointF16;
        prVar.aj = pointF14;
        return prVar;
    }

    private static Interpolator pr(PointF pointF, PointF pointF2) {
        pointF.x = com.byazt.ptr.aj.hw(pointF.x, -1.0f, 1.0f);
        pointF.y = com.byazt.ptr.aj.hw(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.byazt.ptr.aj.hw(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.byazt.ptr.aj.hw(pointF2.y, -100.0f, 100.0f);
        int iPr = com.byazt.ptr.vk.pr(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferencePr = com.byazt.dx.c.pr() ? null : pr(iPr);
        Interpolator linearInterpolator = weakReferencePr != null ? weakReferencePr.get() : null;
        if (weakReferencePr == null || linearInterpolator == null) {
            try {
                linearInterpolator = com.byazt.dx.lb.pr(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.byazt.dx.lb.pr(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            if (!com.byazt.dx.c.pr()) {
                try {
                    pr(iPr, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
            }
        }
        return linearInterpolator;
    }

    private static <T> com.byazt.cz.pr<T> pr(JsonReader jsonReader, float f, qn<T> qnVar) throws IOException {
        return new com.byazt.cz.pr<>(qnVar.hw(jsonReader, f));
    }
}
