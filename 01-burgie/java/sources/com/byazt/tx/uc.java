package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 5})
public class uc {
    public static com.byazt.ynb.hw pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.eqw.m<PointF, PointF> mVarHw = null;
        com.byazt.eqw.uc ucVarHn = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "p":
                    mVarHw = pr.hw(jsonReader, ucVar);
                    break;
                case "s":
                    ucVarHn = x.hn(jsonReader, ucVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.hw(strNextString, mVarHw, ucVarHn, z, zNextBoolean);
    }
}
