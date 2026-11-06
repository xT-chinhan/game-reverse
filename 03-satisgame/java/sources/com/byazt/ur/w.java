package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 13})
public class w {
    public static com.byazt.aw.qg n(JsonReader jsonReader, com.byazt.pp.w wVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.ccr.oa<PointF, PointF> oaVarQg = null;
        com.byazt.ccr.w wVarS = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    oaVarQg = n.qg(jsonReader, wVar);
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
        return new com.byazt.aw.qg(strNextString, oaVarQg, wVarS, z, zNextBoolean);
    }
}
