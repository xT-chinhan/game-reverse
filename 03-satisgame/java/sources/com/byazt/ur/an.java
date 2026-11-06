package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 1758})
public class an implements dg<com.byazt.aw.sz> {
    public static final an n = new an();

    private an() {
    }

    @Override // com.byazt.ur.dg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.aw.sz qg(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listN = null;
        List<PointF> listN2 = null;
        List<PointF> listN3 = null;
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
                        listN2 = um.n(jsonReader, f);
                        break;
                    case "o":
                        listN3 = um.n(jsonReader, f);
                        break;
                    case "v":
                        listN = um.n(jsonReader, f);
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
                if (listN == null || listN2 == null || listN3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listN.isEmpty()) {
                    return new com.byazt.aw.sz(new PointF(), false, Collections.emptyList());
                }
                int size = listN.size();
                PointF pointF = listN.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listN.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.byazt.ld.n(com.byazt.nu.rv.n(listN.get(i2), listN3.get(i2)), com.byazt.nu.rv.n(pointF2, listN2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listN.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.byazt.ld.n(com.byazt.nu.rv.n(listN.get(i3), listN3.get(i3)), com.byazt.nu.rv.n(pointF3, listN2.get(0)), pointF3));
                }
                return new com.byazt.aw.sz(pointF, zNextBoolean, arrayList);
            }
        }
    }
}
