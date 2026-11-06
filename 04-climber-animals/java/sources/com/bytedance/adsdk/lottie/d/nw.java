package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class nw {
    static <T> List<com.bytedance.adsdk.lottie.c.ms<T>> ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, float f, e<T> eVar, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            cVar.ms("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.kuaishou.weapon.p0.t.a)) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(t.ms(jsonReader, cVar, f, eVar, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(t.ms(jsonReader, cVar, f, eVar, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(t.ms(jsonReader, cVar, f, eVar, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        ms(arrayList);
        return arrayList;
    }

    public static <T> void ms(List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.lottie.c.ms<T> msVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.lottie.c.ms<T> msVar2 = list.get(i2);
            msVar.ab = Float.valueOf(msVar2.c);
            if (msVar.xr == null && msVar2.f150ms != null) {
                msVar.xr = msVar2.f150ms;
                if (msVar instanceof com.bytedance.adsdk.lottie.ms.xr.ny) {
                    ((com.bytedance.adsdk.lottie.ms.xr.ny) msVar).ms();
                }
            }
        }
        com.bytedance.adsdk.lottie.c.ms<T> msVar3 = list.get(i);
        if ((msVar3.f150ms == null || msVar3.xr == null) && list.size() > 1) {
            list.remove(msVar3);
        }
    }
}
