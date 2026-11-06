package com.taptap.sdk.okio;

import com.anythink.china.a.c;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    static Segment take() {
        synchronized (SegmentPool.class) {
            Segment segment = next;
            if (segment != null) {
                next = segment.next;
                segment.next = null;
                byteCount -= c.n;
                return segment;
            }
            return new Segment();
        }
    }

    static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (SegmentPool.class) {
            long j = byteCount;
            if (j + c.n > 65536) {
                return;
            }
            byteCount = j + c.n;
            segment.next = next;
            segment.limit = 0;
            segment.pos = 0;
            next = segment;
        }
    }
}
