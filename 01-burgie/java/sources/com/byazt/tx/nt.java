package com.byazt.tx;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 74})
public class nt {
    public static com.byazt.ynb.c pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.eqw.x xVarHw = null;
        Path.FillType fillType = Path.FillType.WINDING;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.ynb.fw fwVar = null;
        com.byazt.eqw.hn hnVarPr = null;
        com.byazt.eqw.uc ucVarHn = null;
        com.byazt.eqw.uc ucVarHn2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "p":
                                iNextInt = jsonReader.nextInt();
                                break;
                            case "k":
                                hnVarPr = x.pr(jsonReader, ucVar, iNextInt);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    xVarHw = x.hw(jsonReader, ucVar);
                    break;
                case "t":
                    fwVar = jsonReader.nextInt() == 1 ? com.byazt.ynb.fw.LINEAR : com.byazt.ynb.fw.RADIAL;
                    break;
                case "s":
                    ucVarHn = x.hn(jsonReader, ucVar);
                    break;
                case "e":
                    ucVarHn2 = x.hn(jsonReader, ucVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.c(strNextString, fwVar, fillType, hnVarPr, xVarHw == null ? new com.byazt.eqw.x(Collections.singletonList(new com.byazt.cz.pr(100))) : xVarHw, ucVarHn, ucVarHn2, null, null, zNextBoolean);
    }
}
