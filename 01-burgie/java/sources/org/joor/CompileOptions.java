package org.joor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Processor;

/* JADX INFO: loaded from: classes3.dex */
public final class CompileOptions {
    final List<String> options;
    final List<? extends Processor> processors;

    public CompileOptions() {
        this(Collections.emptyList(), Collections.emptyList());
    }

    private CompileOptions(List<? extends Processor> processors, List<String> options) {
        this.processors = processors;
        this.options = options;
    }

    public final CompileOptions processors(Processor... newProcessors) {
        return processors(Arrays.asList(newProcessors));
    }

    public final CompileOptions processors(List<? extends Processor> newProcessors) {
        return new CompileOptions(newProcessors, this.options);
    }

    public final CompileOptions options(String... newOptions) {
        return options(Arrays.asList(newOptions));
    }

    public final CompileOptions options(List<String> newOptions) {
        return new CompileOptions(this.processors, newOptions);
    }
}
