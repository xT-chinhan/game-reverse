package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 574})
public class nl {
    public static com.byazt.ynb.w pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.eqw.m<PointF, PointF> mVarHw = null;
        com.byazt.eqw.uc ucVarHn = null;
        com.byazt.eqw.hw hwVarPr = null;
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
                case "r":
                    hwVarPr = x.pr(jsonReader, ucVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.w(strNextString, mVarHw, ucVarHn, hwVarPr, zNextBoolean);
    }
}
