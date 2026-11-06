package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.content.ContentModel;
import com.tapsdk.tapad.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class ShapeGroupParser {
    private ShapeGroupParser() {
    }

    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                    if (contentModel != null) {
                        arrayList.add(contentModel);
                    }
                }
                jsonReader.endArray();
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeGroup(strNextString, arrayList);
    }
}
