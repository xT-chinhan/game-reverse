package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 91})
public class rc {
    public static com.byazt.ynb.zo pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.ynb.zo.pr prVar = null;
        boolean zNextBoolean = false;
        com.byazt.eqw.zo zoVarC = null;
        com.byazt.eqw.x xVarHw = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            switch (strNextName) {
                case "mode":
                    switch (jsonReader.nextString()) {
                        case "a":
                            prVar = com.byazt.ynb.zo.pr.MASK_MODE_ADD;
                            break;
                        case "s":
                            prVar = com.byazt.ynb.zo.pr.MASK_MODE_SUBTRACT;
                            break;
                        case "n":
                            prVar = com.byazt.ynb.zo.pr.MASK_MODE_NONE;
                            break;
                        case "i":
                            ucVar.pr("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            prVar = com.byazt.ynb.zo.pr.MASK_MODE_INTERSECT;
                            break;
                        default:
                            com.byazt.ptr.uc.hw("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            prVar = com.byazt.ynb.zo.pr.MASK_MODE_ADD;
                            break;
                    }
                    break;
                case "pt":
                    zoVarC = x.c(jsonReader, ucVar);
                    break;
                case "o":
                    xVarHw = x.hw(jsonReader, ucVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.ynb.zo(prVar, zoVarC, xVarHw, zNextBoolean);
    }
}
