package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 8})
public class s {
    public static com.byazt.ccr.d n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.byazt.ccr.qg qgVar = null;
        com.byazt.ccr.l lVarN = null;
        com.byazt.ccr.oa<PointF, PointF> oaVarQg = null;
        com.byazt.ccr.x xVarQ = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.qg qgVarN2 = null;
        com.byazt.ccr.q qVarQg = null;
        com.byazt.ccr.qg qgVarN3 = null;
        com.byazt.ccr.qg qgVarN4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            lVarN = n.n(jsonReader, wVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    qVarQg = q.qg(jsonReader, wVar);
                    continue;
                    break;
                case "p":
                    oaVarQg = n.qg(jsonReader, wVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    xVarQ = q.q(jsonReader, wVar);
                    continue;
                    break;
                case "eo":
                    qgVarN4 = q.n(jsonReader, wVar, false);
                    continue;
                    break;
                case "rz":
                    wVar.n("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    qgVarN2 = q.n(jsonReader, wVar, false);
                    continue;
                    break;
                case "sk":
                    qgVarN = q.n(jsonReader, wVar, false);
                    continue;
                    break;
                case "so":
                    qgVarN3 = q.n(jsonReader, wVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.byazt.ccr.qg qgVarN5 = q.n(jsonReader, wVar, false);
            if (qgVarN5.s().isEmpty()) {
                qgVarN5.s().add(new com.byazt.yt.n(wVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(wVar.x())));
            } else if (((com.byazt.yt.n) qgVarN5.s().get(0)).n == 0) {
                qgVarN5.s().set(0, new com.byazt.yt.n(wVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(wVar.x())));
            }
            qgVar = qgVarN5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (n(lVarN)) {
            lVarN = null;
        }
        return new com.byazt.ccr.d(lVarN, n(oaVarQg) ? null : oaVarQg, n(xVarQ) ? null : xVarQ, n(qgVar) ? null : qgVar, qVarQg, qgVarN3, qgVarN4, qg(qgVarN) ? null : qgVarN, s(qgVarN2) ? null : qgVarN2);
    }

    private static boolean n(com.byazt.ccr.l lVar) {
        if (lVar != null) {
            return lVar.qg() && lVar.s().get(0).n.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean n(com.byazt.ccr.oa<PointF, PointF> oaVar) {
        if (oaVar != null) {
            return !(oaVar instanceof com.byazt.ccr.rv) && oaVar.qg() && oaVar.s().get(0).n.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean n(com.byazt.ccr.qg qgVar) {
        if (qgVar != null) {
            return qgVar.qg() && ((Float) ((com.byazt.yt.n) qgVar.s().get(0)).n).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean n(com.byazt.ccr.x xVar) {
        if (xVar != null) {
            return xVar.qg() && ((com.byazt.yt.q) ((com.byazt.yt.n) xVar.s().get(0)).n).qg(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean qg(com.byazt.ccr.qg qgVar) {
        if (qgVar != null) {
            return qgVar.qg() && ((Float) ((com.byazt.yt.n) qgVar.s().get(0)).n).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean s(com.byazt.ccr.qg qgVar) {
        if (qgVar != null) {
            return qgVar.qg() && ((Float) ((com.byazt.yt.n) qgVar.s().get(0)).n).floatValue() == 0.0f;
        }
        return true;
    }
}
