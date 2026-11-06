package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 109})
public class w {
    public com.byazt.eqw.hw c;
    public com.byazt.eqw.hw hn;
    public com.byazt.eqw.hw hw;
    public com.byazt.eqw.pr pr;
    public com.byazt.eqw.hw x;

    public vk pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.eqw.hw hwVar;
        com.byazt.eqw.hw hwVar2;
        com.byazt.eqw.hw hwVar3;
        com.byazt.eqw.hw hwVar4;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "ef":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        hw(jsonReader, ucVar);
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        com.byazt.eqw.pr prVar = this.pr;
        if (prVar != null && (hwVar = this.hw) != null && (hwVar2 = this.hn) != null && (hwVar3 = this.x) != null && (hwVar4 = this.c) != null) {
            return new vk(prVar, hwVar, hwVar2, hwVar3, hwVar4);
        }
        return null;
    }

    private void hw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "v":
                    switch (strNextString) {
                        case "Shadow Color":
                            this.pr = x.fw(jsonReader, ucVar);
                            break;
                        case "Opacity":
                            this.hw = x.pr(jsonReader, ucVar, false);
                            break;
                        case "Direction":
                            this.hn = x.pr(jsonReader, ucVar, false);
                            break;
                        case "Distance":
                            this.x = x.pr(jsonReader, ucVar);
                            break;
                        case "Softness":
                            this.c = x.pr(jsonReader, ucVar);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
    }
}
