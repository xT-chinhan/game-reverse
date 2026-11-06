package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;

/* JADX INFO: loaded from: classes3.dex */
interface ValueParser<V> {
    V parse(JsonReader jsonReader, float f);
}
