package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 20})
public class hn {
    public static com.byazt.eqw.k pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.eqw.m<PointF, PointF> mVar;
        com.byazt.eqw.hw hwVar;
        com.byazt.eqw.fw fwVar;
        com.byazt.eqw.hw hwVar2;
        com.byazt.eqw.hw hwVar3;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.byazt.eqw.hw hwVar4 = null;
        com.byazt.eqw.c cVarPr = null;
        com.byazt.eqw.m<PointF, PointF> mVarHw = null;
        com.byazt.eqw.fw fwVarX = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        com.byazt.eqw.x xVarHw = null;
        com.byazt.eqw.hw hwVarPr3 = null;
        com.byazt.eqw.hw hwVarPr4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "k":
                                cVarPr = pr.pr(jsonReader, ucVar);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "p":
                    mVarHw = pr.hw(jsonReader, ucVar);
                    continue;
                    break;
                case "s":
                    fwVarX = x.x(jsonReader, ucVar);
                    continue;
                    break;
                case "rz":
                    ucVar.pr("Lottie doesn't support 3D layers.");
                    break;
                case "r":
                    break;
                case "o":
                    xVarHw = x.hw(jsonReader, ucVar);
                    continue;
                    break;
                case "so":
                    hwVarPr3 = x.pr(jsonReader, ucVar, false);
                    continue;
                    break;
                case "eo":
                    hwVarPr4 = x.pr(jsonReader, ucVar, false);
                    continue;
                    break;
                case "sk":
                    hwVarPr = x.pr(jsonReader, ucVar, false);
                    continue;
                    break;
                case "sa":
                    hwVarPr2 = x.pr(jsonReader, ucVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.byazt.eqw.hw hwVarPr5 = x.pr(jsonReader, ucVar, false);
            if (hwVarPr5.hn().isEmpty()) {
                hwVarPr5.hn().add(new com.byazt.cz.pr(ucVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(ucVar.fw())));
            } else if (((com.byazt.cz.pr) hwVarPr5.hn().get(0)).pr != 0) {
                hwVar4 = hwVarPr5;
            } else {
                hwVarPr5.hn().set(0, new com.byazt.cz.pr(ucVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(ucVar.fw())));
            }
            hwVar4 = hwVarPr5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (pr(cVarPr)) {
            cVarPr = null;
        }
        if (!pr(mVarHw)) {
            mVar = mVarHw;
        } else {
            mVar = null;
        }
        if (!pr(hwVar4)) {
            hwVar = hwVar4;
        } else {
            hwVar = null;
        }
        if (!pr(fwVarX)) {
            fwVar = fwVarX;
        } else {
            fwVar = null;
        }
        if (!hw(hwVarPr)) {
            hwVar2 = hwVarPr;
        } else {
            hwVar2 = null;
        }
        if (!hn(hwVarPr2)) {
            hwVar3 = hwVarPr2;
        } else {
            hwVar3 = null;
        }
        return new com.byazt.eqw.k(cVarPr, mVar, fwVar, hwVar, xVarHw, hwVarPr3, hwVarPr4, hwVar2, hwVar3);
    }

    private static boolean pr(com.byazt.eqw.c cVar) {
        if (cVar != null) {
            return cVar.hw() && cVar.hn().get(0).pr.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean pr(com.byazt.eqw.m<PointF, PointF> mVar) {
        if (mVar != null) {
            return !(mVar instanceof com.byazt.eqw.aj) && mVar.hw() && mVar.hn().get(0).pr.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean pr(com.byazt.eqw.hw hwVar) {
        if (hwVar != null) {
            return hwVar.hw() && ((Float) ((com.byazt.cz.pr) hwVar.hn().get(0)).pr).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean pr(com.byazt.eqw.fw fwVar) {
        if (fwVar != null) {
            return fwVar.hw() && ((com.byazt.cz.x) ((com.byazt.cz.pr) fwVar.hn().get(0)).pr).hw(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean hw(com.byazt.eqw.hw hwVar) {
        if (hwVar != null) {
            return hwVar.hw() && ((Float) ((com.byazt.cz.pr) hwVar.hn().get(0)).pr).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean hn(com.byazt.eqw.hw hwVar) {
        if (hwVar != null) {
            return hwVar.hw() && ((Float) ((com.byazt.cz.pr) hwVar.hn().get(0)).pr).floatValue() == 0.0f;
        }
        return true;
    }
}
