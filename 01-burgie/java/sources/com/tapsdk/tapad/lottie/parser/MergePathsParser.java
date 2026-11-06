package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.model.content.MergePaths;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class MergePathsParser {
    private MergePathsParser() {
    }

    public static MergePaths parse(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        MergePaths.MergePathsMode mergePathsModeForId = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("mm")) {
                mergePathsModeForId = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(strNextString, mergePathsModeForId);
    }
}
