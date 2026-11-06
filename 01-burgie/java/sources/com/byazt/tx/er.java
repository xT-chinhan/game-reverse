package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 1620})
public class er {
    public static com.byazt.ynb.yb pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        String strNextString = null;
        com.byazt.eqw.zo zoVarC = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "ks":
                    zoVarC = x.c(jsonReader, ucVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.yb(strNextString, iNextInt, zoVarC, zNextBoolean);
    }
}
