package com.byazt.ur;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 866})
public class py {
    public static <T> List<com.byazt.yt.n<T>> n(JsonReader jsonReader, com.byazt.pp.w wVar, float f, dg<T> dgVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            wVar.n("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("k")) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(a.n(jsonReader, wVar, f, dgVar, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(a.n(jsonReader, wVar, f, dgVar, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(a.n(jsonReader, wVar, f, dgVar, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        n(arrayList);
        return arrayList;
    }

    public static <T> void n(List<? extends com.byazt.yt.n<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.byazt.yt.n<T> nVar = list.get(i2);
            i2++;
            com.byazt.yt.n<T> nVar2 = list.get(i2);
            nVar.x = Float.valueOf(nVar2.w);
            if (nVar.qg == null && nVar2.n != null) {
                nVar.qg = nVar2.n;
                if (nVar instanceof com.byazt.bd.rv) {
                    ((com.byazt.bd.rv) nVar).n();
                }
            }
        }
        com.byazt.yt.n<T> nVar3 = list.get(i);
        if ((nVar3.n == null || nVar3.qg == null) && list.size() > 1) {
            list.remove(nVar3);
        }
    }
}
