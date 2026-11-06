package com.taptap.sdk.okhttp3.internal.cache;

import com.taptap.sdk.okio.Buffer;
import com.taptap.sdk.okio.ForwardingSink;
import com.taptap.sdk.okio.Sink;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    FaultHidingSink(Sink delegate) {
        super(delegate);
    }

    @Override // com.taptap.sdk.okio.ForwardingSink, com.taptap.sdk.okio.Sink
    public void write(Buffer source, long byteCount) throws IOException {
        if (this.hasErrors) {
            source.skip(byteCount);
            return;
        }
        try {
            super.write(source, byteCount);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // com.taptap.sdk.okio.ForwardingSink, com.taptap.sdk.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // com.taptap.sdk.okio.ForwardingSink, com.taptap.sdk.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    protected void onException(IOException e) {
    }
}
