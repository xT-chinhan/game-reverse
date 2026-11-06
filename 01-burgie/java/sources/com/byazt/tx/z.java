package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 110})
public class z {
    public static com.byazt.ynb.aj pr(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        boolean zNextBoolean = false;
        com.byazt.ynb.aj.pr prVarPr = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "mm":
                    prVarPr = com.byazt.ynb.aj.pr.pr(jsonReader.nextInt());
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.aj(strNextString, prVarPr, zNextBoolean);
    }
}
