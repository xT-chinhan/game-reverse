package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 672})
public class gz {
    public static com.byazt.ynb.vk pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        com.byazt.ynb.vk.pr prVarPr = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.m<PointF, PointF> mVarHw = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        com.byazt.eqw.hw hwVarPr3 = null;
        com.byazt.eqw.hw hwVarPr4 = null;
        com.byazt.eqw.hw hwVarPr5 = null;
        com.byazt.eqw.hw hwVarPr6 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "sy":
                    prVarPr = com.byazt.ynb.vk.pr.pr(jsonReader.nextInt());
                    break;
                case "pt":
                    hwVarPr = x.pr(jsonReader, ucVar, false);
                    break;
                case "p":
                    mVarHw = pr.hw(jsonReader, ucVar);
                    break;
                case "r":
                    hwVarPr2 = x.pr(jsonReader, ucVar, false);
                    break;
                case "or":
                    hwVarPr4 = x.pr(jsonReader, ucVar);
                    break;
                case "os":
                    hwVarPr6 = x.pr(jsonReader, ucVar, false);
                    break;
                case "ir":
                    hwVarPr3 = x.pr(jsonReader, ucVar);
                    break;
                case "is":
                    hwVarPr5 = x.pr(jsonReader, ucVar, false);
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
        return new com.byazt.ynb.vk(strNextString, prVarPr, hwVarPr, mVarHw, hwVarPr2, hwVarPr3, hwVarPr4, hwVarPr5, hwVarPr6, zNextBoolean, z);
    }
}
