package com.byazt.ur;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 849})
public class ou {
    public static com.byazt.eg.fs n(com.byazt.pp.w wVar) {
        Rect rectQ = wVar.q();
        return new com.byazt.eg.fs(Collections.emptyList(), wVar, "__container", -1L, com.byazt.eg.fs.n.PRE_COMP, -1L, null, Collections.emptyList(), new com.byazt.ccr.d(), 0, 0, 0, 0.0f, 0.0f, rectQ.width(), rectQ.height(), null, null, Collections.emptyList(), com.byazt.eg.fs.qg.NONE, null, false, null, null);
    }

    public static com.byazt.eg.fs n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.eg.fs.qg qgVar = com.byazt.eg.fs.qg.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        com.byazt.eg.fs.qg qgVar2 = qgVar;
        com.byazt.eg.fs.n nVar = null;
        String strNextString = null;
        com.byazt.ccr.d dVarN = null;
        com.byazt.ccr.tj tjVarW = null;
        com.byazt.ccr.cp cpVarN = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.aw.n nVarN = null;
        tj tjVarN = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fX = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "parent":
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case "shapes":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.aw.s sVarN = fs.n(jsonReader, wVar);
                        if (sVarN != null) {
                            arrayList2.add(sVarN);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "h":
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.byazt.nu.tj.n()));
                    break;
                case "t":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                cpVarN = qg.n(jsonReader, wVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals(com.anythink.core.e.d.a)) {
                            tjVarW = q.w(jsonReader, wVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "w":
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.byazt.nu.tj.n()));
                    break;
                case "cl":
                    strNextString3 = jsonReader.nextString();
                    break;
                case "ef":
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    nVarN = l.n(jsonReader, wVar);
                                } else if (iNextInt3 == 25) {
                                    tjVarN = new cp().n(jsonReader, wVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    wVar.n("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ip":
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case "ks":
                    dVarN = s.n(jsonReader, wVar);
                    break;
                case "nm":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "op":
                    fX = (float) jsonReader.nextDouble();
                    break;
                case "sc":
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case "sh":
                    iNextInt2 = (int) (jsonReader.nextInt() * com.byazt.nu.tj.n());
                    break;
                case "sr":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case "st":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "sw":
                    iNextInt = (int) (jsonReader.nextInt() * com.byazt.nu.tj.n());
                    break;
                case "tm":
                    qgVarN = q.n(jsonReader, wVar, false);
                    break;
                case "tt":
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= com.byazt.eg.fs.qg.values().length) {
                        wVar.n("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                        break;
                    } else {
                        qgVar2 = com.byazt.eg.fs.qg.values()[iNextInt4];
                        int i = AnonymousClass1.n[qgVar2.ordinal()];
                        if (i == 1) {
                            wVar.n("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            wVar.n("Unsupported matte type: Luma Inverted");
                        }
                        wVar.n(1);
                        break;
                    }
                    break;
                case "ty":
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < com.byazt.eg.fs.n.UNKNOWN.ordinal()) {
                        nVar = com.byazt.eg.fs.n.values()[iNextInt5];
                        break;
                    } else {
                        nVar = com.byazt.eg.fs.n.UNKNOWN;
                        break;
                    }
                    break;
                case "ind":
                    jNextInt = jsonReader.nextInt();
                    break;
                case "refId":
                    strNextString = jsonReader.nextString();
                    break;
                case "masksProperties":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(m.n(jsonReader, wVar));
                    }
                    wVar.n(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList4.add(new com.byazt.yt.n(wVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        }
        if (fX <= 0.0f) {
            fX = wVar.x();
        }
        arrayList4.add(new com.byazt.yt.n(wVar, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fX)));
        arrayList4.add(new com.byazt.yt.n(wVar, fValueOf, fValueOf, null, fX, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            wVar.n("Convert your Illustrator layers to shape layers.");
        }
        return new com.byazt.eg.fs(arrayList2, wVar, strNextString2, jNextInt, nVar, jNextInt2, strNextString, arrayList, dVarN, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, tjVarW, cpVarN, arrayList4, qgVar2, qgVarN, zNextBoolean, nVarN, tjVarN);
    }

    /* JADX INFO: renamed from: com.byazt.ur.ou$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1088, 760})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.eg.fs.qg.values().length];
            n = iArr;
            try {
                iArr[com.byazt.eg.fs.qg.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.eg.fs.qg.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
