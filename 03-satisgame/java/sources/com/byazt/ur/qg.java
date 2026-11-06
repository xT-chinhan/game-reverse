package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 26})
public class qg {
    public static com.byazt.ccr.cp n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.ccr.cp cpVarQg = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                cpVarQg = qg(jsonReader, wVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return cpVarQg == null ? new com.byazt.ccr.cp(null, null, null, null) : cpVarQg;
    }

    private static com.byazt.ccr.cp qg(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.ccr.n nVarX = null;
        com.byazt.ccr.n nVarX2 = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.qg qgVarN2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    qgVarN2 = q.n(jsonReader, wVar);
                    break;
                case "fc":
                    nVarX = q.x(jsonReader, wVar);
                    break;
                case "sc":
                    nVarX2 = q.x(jsonReader, wVar);
                    break;
                case "sw":
                    qgVarN = q.n(jsonReader, wVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.ccr.cp(nVarX, nVarX2, qgVarN, qgVarN2);
    }
}
