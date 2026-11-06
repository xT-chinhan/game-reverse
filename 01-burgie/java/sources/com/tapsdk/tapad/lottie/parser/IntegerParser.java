package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;

/* JADX INFO: loaded from: classes3.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tapsdk.tapad.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f));
    }
}
