package com.taptap.sdk.retrofit2.converter.kotlinx.serialization;

import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.retrofit2.Converter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.StringFormat;

/* JADX INFO: compiled from: Factory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"asConverterFactory", "Lcom/taptap/sdk/retrofit2/Converter$Factory;", "Lkotlinx/serialization/BinaryFormat;", "contentType", "Lcom/taptap/sdk/okhttp3/MediaType;", "create", "Lkotlinx/serialization/StringFormat;", "com.taptap.sdk.retrofit2-kotlinx-serialization-converter"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class KotlinSerializationConverterFactory {
    public static final Converter.Factory create(StringFormat $this$asConverterFactory, MediaType contentType) {
        Intrinsics.checkNotNullParameter($this$asConverterFactory, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new Factory(contentType, new Serializer.FromString($this$asConverterFactory));
    }

    public static final Converter.Factory create(BinaryFormat $this$asConverterFactory, MediaType contentType) {
        Intrinsics.checkNotNullParameter($this$asConverterFactory, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new Factory(contentType, new Serializer.FromBytes($this$asConverterFactory));
    }
}
