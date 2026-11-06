package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class hi {
    private com.bytedance.adsdk.lottie.model.ms.xr ah;
    private com.bytedance.adsdk.lottie.model.ms.xr d;
    private com.bytedance.adsdk.lottie.model.ms.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.ms.ms f155ms;
    private com.bytedance.adsdk.lottie.model.ms.xr xr;

    ch ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    xr(jsonReader, cVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.f155ms == null || this.xr == null || this.ah == null || this.d == null || this.ka == null) {
            return null;
        }
        return new ch(this.f155ms, this.xr, this.ah, this.d, this.ka);
    }

    private void xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.d = d.ms(jsonReader, cVar);
                        break;
                    case "Opacity":
                        this.xr = d.ms(jsonReader, cVar, false);
                        break;
                    case "Direction":
                        this.ah = d.ms(jsonReader, cVar, false);
                        break;
                    case "Shadow Color":
                        this.f155ms = d.ab(jsonReader, cVar);
                        break;
                    case "Softness":
                        this.ka = d.ms(jsonReader, cVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
