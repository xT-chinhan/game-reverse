package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class jw implements e<com.bytedance.adsdk.lottie.model.xr.u> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final jw f156ms = new jw();

    private jw() {
    }

    @Override // com.bytedance.adsdk.lottie.d.e
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xr.u xr(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listMs = null;
        List<PointF> listMs2 = null;
        List<PointF> listMs3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "c":
                        zNextBoolean = jsonReader.nextBoolean();
                        break;
                    case "i":
                        listMs2 = y.ms(jsonReader, f);
                        break;
                    case "o":
                        listMs3 = y.ms(jsonReader, f);
                        break;
                    case "v":
                        listMs = y.ms(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listMs == null || listMs2 == null || listMs3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listMs.isEmpty()) {
                    return new com.bytedance.adsdk.lottie.model.xr.u(new PointF(), false, Collections.emptyList());
                }
                int size = listMs.size();
                PointF pointF = listMs.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listMs.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.ms(com.bytedance.adsdk.lottie.ka.x.ms(listMs.get(i2), listMs3.get(i2)), com.bytedance.adsdk.lottie.ka.x.ms(pointF2, listMs2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listMs.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.lottie.model.ms(com.bytedance.adsdk.lottie.ka.x.ms(listMs.get(i3), listMs3.get(i3)), com.bytedance.adsdk.lottie.ka.x.ms(pointF3, listMs2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.lottie.model.xr.u(pointF, zNextBoolean, arrayList);
            }
        }
    }
}
