package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 576})
public class ww {
    public static com.byazt.ynb.m pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.eqw.hw hwVarPr = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "r":
                    hwVarPr = x.pr(jsonReader, ucVar, true);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (zNextBoolean) {
            return null;
        }
        return new com.byazt.ynb.m(strNextString, hwVarPr);
    }
}
