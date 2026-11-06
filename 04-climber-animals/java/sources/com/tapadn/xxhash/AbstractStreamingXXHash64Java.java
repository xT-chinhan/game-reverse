package com.tapadn.xxhash;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractStreamingXXHash64Java extends StreamingXXHash64 {
    int memSize;
    final byte[] memory;
    long totalLen;
    long v1;
    long v2;
    long v3;
    long v4;

    AbstractStreamingXXHash64Java(long j) {
        super(j);
        this.memory = new byte[32];
        reset();
    }

    @Override // com.tapadn.xxhash.StreamingXXHash64
    public void reset() {
        long j = this.seed;
        this.v1 = (j - 7046029288634856825L) - 4417276706812531889L;
        this.v2 = (-4417276706812531889L) + j;
        this.v3 = j + 0;
        this.v4 = j - (-7046029288634856825L);
        this.totalLen = 0L;
        this.memSize = 0;
    }
}
