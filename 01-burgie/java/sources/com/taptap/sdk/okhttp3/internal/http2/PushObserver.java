package com.taptap.sdk.okhttp3.internal.http2;

import com.taptap.sdk.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() { // from class: com.taptap.sdk.okhttp3.internal.http2.PushObserver.1
        @Override // com.taptap.sdk.okhttp3.internal.http2.PushObserver
        public boolean onRequest(int streamId, List<Header> requestHeaders) {
            return true;
        }

        @Override // com.taptap.sdk.okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int streamId, List<Header> responseHeaders, boolean last) {
            return true;
        }

        @Override // com.taptap.sdk.okhttp3.internal.http2.PushObserver
        public boolean onData(int streamId, BufferedSource source, int byteCount, boolean last) throws IOException {
            source.skip(byteCount);
            return true;
        }

        @Override // com.taptap.sdk.okhttp3.internal.http2.PushObserver
        public void onReset(int streamId, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
