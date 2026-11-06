package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;

/* JADX INFO: loaded from: classes3.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser INSTANCE = new FloatParser();

    private FloatParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tapsdk.tapad.lottie.parser.ValueParser
    public Float parse(JsonReader jsonReader, float f) {
        return Float.valueOf(JsonUtils.valueFromObject(jsonReader) * f);
    }
}
