package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.anythink.core.common.b.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a {
    public static final Interpolator n = new LinearInterpolator();
    public static SparseArray<WeakReference<Interpolator>> qg;

    private static SparseArray<WeakReference<Interpolator>> n() {
        if (qg == null) {
            qg = new SparseArray<>();
        }
        return qg;
    }

    private static WeakReference<Interpolator> n(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (a.class) {
            weakReference = n().get(i);
        }
        return weakReference;
    }

    private static void n(int i, WeakReference<Interpolator> weakReference) {
        synchronized (a.class) {
            qg.put(i, weakReference);
        }
    }

    public static <T> com.byazt.yt.n<T> n(JsonReader jsonReader, com.byazt.pp.w wVar, float f, dg<T> dgVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return qg(wVar, jsonReader, f, dgVar);
        }
        if (z) {
            return n(wVar, jsonReader, f, dgVar);
        }
        return n(jsonReader, f, dgVar);
    }

    private static <T> com.byazt.yt.n<T> n(com.byazt.pp.w wVar, JsonReader jsonReader, float f, dg<T> dgVar) throws IOException {
        Interpolator interpolatorN;
        jsonReader.beginObject();
        PointF pointFQg = null;
        T tQg = null;
        T tQg2 = null;
        PointF pointFQg2 = null;
        PointF pointFQg3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFQg4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tQg = dgVar.qg(jsonReader, f);
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
                    pointFQg4 = um.qg(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFQg = um.qg(jsonReader, 1.0f);
                    break;
                case "s":
                    tQg2 = dgVar.qg(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFQg3 = um.qg(jsonReader, f);
                    break;
                case "to":
                    pointFQg2 = um.qg(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFQg != null && pointFQg4 != null) {
                interpolatorN = n(pointFQg, pointFQg4);
            }
            com.byazt.yt.n<T> nVar = new com.byazt.yt.n<>(wVar, tQg2, tQg, interpolatorN, fNextDouble, null);
            nVar.fs = pointFQg2;
            nVar.rv = pointFQg3;
            return nVar;
        }
        tQg = tQg2;
        interpolatorN = n;
        com.byazt.yt.n<T> nVar2 = new com.byazt.yt.n<>(wVar, tQg2, tQg, interpolatorN, fNextDouble, null);
        nVar2.fs = pointFQg2;
        nVar2.rv = pointFQg3;
        return nVar2;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0273  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static <T> com.byazt.yt.n<T> qg(com.byazt.pp.w wVar, JsonReader jsonReader, float f, dg<T> dgVar) throws IOException {
        Interpolator interpolatorN;
        Interpolator interpolatorN2;
        T t;
        Interpolator interpolatorN3;
        com.byazt.yt.n<T> nVar;
        float f2;
        PointF pointF;
        PointF pointF2;
        T t2;
        String str;
        String str2;
        jsonReader.beginObject();
        PointF pointFQg = null;
        boolean z = false;
        PointF pointFQg2 = null;
        PointF pointFQg3 = null;
        PointF pointF3 = null;
        T tQg = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fNextDouble = 0.0f;
        PointF pointFQg4 = null;
        T tQg2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 101:
                    if (strNextName.equals(e.a)) {
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
                    if (strNextName.equals(com.anythink.core.common.s.a)) {
                        b = 4;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
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
            String str4 = com.byazt.af.x.n;
            switch (b) {
                case 0:
                    f2 = fNextDouble;
                    tQg2 = dgVar.qg(jsonReader, f);
                    fNextDouble = f2;
                    break;
                case 1:
                    pointF = pointFQg;
                    f2 = fNextDouble;
                    pointF2 = pointFQg4;
                    t2 = tQg;
                    z = jsonReader.nextInt() == 1;
                    tQg = t2;
                    pointFQg4 = pointF2;
                    pointFQg = pointF;
                    fNextDouble = f2;
                    break;
                case 2:
                    pointF = pointFQg;
                    f2 = fNextDouble;
                    pointF2 = pointFQg4;
                    t2 = tQg;
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
                        pointFQg3 = um.qg(jsonReader, f);
                    }
                    tQg = t2;
                    pointFQg4 = pointF2;
                    pointFQg = pointF;
                    fNextDouble = f2;
                    break;
                case 3:
                    pointF2 = pointFQg4;
                    pointF = pointFQg;
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
                            if (strNextName3.equals(com.byazt.af.x.n)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                }
                                tQg = tQg;
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
                        pointFQg2 = um.qg(jsonReader, f);
                    }
                    pointFQg4 = pointF2;
                    pointFQg = pointF;
                    fNextDouble = f2;
                    break;
                case 4:
                    tQg = dgVar.qg(jsonReader, f);
                    break;
                case 5:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    pointFQg = um.qg(jsonReader, f);
                    break;
                case 7:
                    pointFQg4 = um.qg(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF11 = pointFQg;
        float f4 = fNextDouble;
        PointF pointF12 = pointFQg4;
        T t3 = tQg;
        jsonReader.endObject();
        if (!z) {
            if (pointFQg2 != null && pointFQg3 != null) {
                interpolatorN3 = n(pointFQg2, pointFQg3);
                t = tQg2;
                interpolatorN = null;
                interpolatorN2 = null;
            } else if (pointF3 != null && pointF4 != null && pointF5 != null && pointF6 != null) {
                interpolatorN = n(pointF3, pointF5);
                interpolatorN2 = n(pointF4, pointF6);
                t = tQg2;
                interpolatorN3 = null;
            }
            if (interpolatorN == null && interpolatorN2 != null) {
                nVar = new com.byazt.yt.n<>(wVar, t3, t, interpolatorN, interpolatorN2, f4, null);
            } else {
                nVar = new com.byazt.yt.n<>(wVar, t3, t, interpolatorN3, f4, null);
            }
            nVar.fs = pointF12;
            nVar.rv = pointF11;
            return nVar;
        }
        tQg2 = t3;
        interpolatorN3 = n;
        t = tQg2;
        interpolatorN = null;
        interpolatorN2 = null;
        if (interpolatorN == null) {
            nVar = new com.byazt.yt.n<>(wVar, t3, t, interpolatorN3, f4, null);
        } else {
            nVar = new com.byazt.yt.n<>(wVar, t3, t, interpolatorN3, f4, null);
        }
        nVar.fs = pointF12;
        nVar.rv = pointF11;
        return nVar;
    }

    private static Interpolator n(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.byazt.nu.rv.qg(pointF.x, -1.0f, 1.0f);
        pointF.y = com.byazt.nu.rv.qg(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.byazt.nu.rv.qg(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.byazt.nu.rv.qg(pointF2.y, -100.0f, 100.0f);
        int iN = com.byazt.nu.tj.n(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceN = com.byazt.pp.l.n() ? null : n(iN);
        Interpolator interpolator = weakReferenceN != null ? weakReferenceN.get() : null;
        if (weakReferenceN == null || interpolator == null) {
            try {
                linearInterpolator = com.byazt.pp.cd.n(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.byazt.pp.cd.n(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.byazt.pp.l.n()) {
                try {
                    n(iN, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.byazt.yt.n<T> n(JsonReader jsonReader, float f, dg<T> dgVar) throws IOException {
        return new com.byazt.yt.n<>(dgVar.qg(jsonReader, f));
    }
}
