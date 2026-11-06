package com.taptap.sdk.retrofit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class BuiltInFactories {
    BuiltInFactories() {
    }

    List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(callbackExecutor));
    }

    List<? extends Converter.Factory> createDefaultConverterFactories() {
        return Collections.emptyList();
    }

    static final class Java8 extends BuiltInFactories {
        Java8() {
        }

        @Override // com.taptap.sdk.retrofit2.BuiltInFactories
        List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
            return Arrays.asList(new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(callbackExecutor));
        }

        @Override // com.taptap.sdk.retrofit2.BuiltInFactories
        List<? extends Converter.Factory> createDefaultConverterFactories() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }
}
