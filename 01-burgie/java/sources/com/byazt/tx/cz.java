package com.byazt.tx;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 213})
public class cz {
    public static <T> List<com.byazt.cz.pr<T>> pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, float f, qn<T> qnVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            ucVar.pr("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "k":
                    if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                        jsonReader.beginArray();
                        if (jsonReader.peek() == JsonToken.NUMBER) {
                            arrayList.add(a.pr(jsonReader, ucVar, f, qnVar, false, z));
                        } else {
                            while (jsonReader.hasNext()) {
                                arrayList.add(a.pr(jsonReader, ucVar, f, qnVar, true, z));
                            }
                        }
                        jsonReader.endArray();
                        break;
                    } else {
                        arrayList.add(a.pr(jsonReader, ucVar, f, qnVar, false, z));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        pr(arrayList);
        return arrayList;
    }

    public static <T> void pr(List<? extends com.byazt.cz.pr<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.byazt.cz.pr<T> prVar = list.get(i2);
            i2++;
            com.byazt.cz.pr<T> prVar2 = list.get(i2);
            prVar.fw = Float.valueOf(prVar2.uc);
            if (prVar.hw == null && prVar2.pr != null) {
                prVar.hw = prVar2.pr;
                if (prVar instanceof com.byazt.al.aj) {
                    ((com.byazt.al.aj) prVar).pr();
                }
            }
        }
        com.byazt.cz.pr<T> prVar3 = list.get(i);
        if ((prVar3.pr == null || prVar3.hw == null) && list.size() > 1) {
            list.remove(prVar3);
        }
    }
}
