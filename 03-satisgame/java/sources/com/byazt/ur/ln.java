package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, PointerIconCompat.TYPE_ZOOM_IN})
public class ln {
    public static com.byazt.aw.cp n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        String strNextString = null;
        com.byazt.ccr.oa<PointF, PointF> oaVarQg = null;
        com.byazt.ccr.w wVarS = null;
        com.byazt.ccr.qg qgVarN = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    oaVarQg = n.qg(jsonReader, wVar);
                    break;
                case "r":
                    qgVarN = q.n(jsonReader, wVar);
                    break;
                case "s":
                    wVarS = q.s(jsonReader, wVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.cp(strNextString, oaVarQg, wVarS, qgVarN, zNextBoolean);
    }
}
