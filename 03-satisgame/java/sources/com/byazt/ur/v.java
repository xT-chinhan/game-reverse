package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 984})
public class v {
    public static com.byazt.aw.oa n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        String strNextString = null;
        com.byazt.ccr.qg qgVarN = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "r":
                    qgVarN = q.n(jsonReader, wVar, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.byazt.aw.oa(strNextString, qgVarN);
    }
}
