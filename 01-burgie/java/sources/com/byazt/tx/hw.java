package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 13})
public class hw {
    public static com.byazt.eqw.w pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.eqw.w wVarHw = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "a":
                    wVarHw = hw(jsonReader, ucVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (wVarHw == null) {
            return new com.byazt.eqw.w(null, null, null, null);
        }
        return wVarHw;
    }

    private static com.byazt.eqw.w hw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.eqw.pr prVarFw = null;
        com.byazt.eqw.pr prVarFw2 = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "fc":
                    prVarFw = x.fw(jsonReader, ucVar);
                    break;
                case "sc":
                    prVarFw2 = x.fw(jsonReader, ucVar);
                    break;
                case "sw":
                    hwVarPr = x.pr(jsonReader, ucVar);
                    break;
                case "t":
                    hwVarPr2 = x.pr(jsonReader, ucVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.eqw.w(prVarFw, prVarFw2, hwVarPr, hwVarPr2);
    }
}
