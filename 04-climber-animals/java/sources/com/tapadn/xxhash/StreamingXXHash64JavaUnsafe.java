package com.tapadn.xxhash;

import com.tapadn.util.SafeUtils;
import com.tapadn.util.UnsafeUtils;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
final class StreamingXXHash64JavaUnsafe extends AbstractStreamingXXHash64Java {

    static class Factory implements StreamingXXHash64.Factory {
        public static final StreamingXXHash64.Factory INSTANCE = new Factory();

        Factory() {
        }

        @Override // com.tapadn.xxhash.StreamingXXHash64.Factory
        public StreamingXXHash64 newStreamingHash(long j) {
            return new StreamingXXHash64JavaUnsafe(j);
        }
    }

    StreamingXXHash64JavaUnsafe(long j) {
        super(j);
    }

    @Override // com.tapadn.xxhash.StreamingXXHash64
    public long getValue() {
        long jRotateLeft;
        int i;
        if (this.totalLen >= 32) {
            long j = this.v1;
            long j2 = this.v2;
            long j3 = this.v3;
            long j4 = this.v4;
            jRotateLeft = ((((((Long.rotateLeft(j3 * (-4417276706812531889L), 31) * (-7046029288634856825L)) ^ (((((((((Long.rotateLeft(j, 1) + Long.rotateLeft(j2, 7)) + Long.rotateLeft(j3, 12)) + Long.rotateLeft(j4, 18)) ^ (Long.rotateLeft(j * (-4417276706812531889L), 31) * (-7046029288634856825L))) * (-7046029288634856825L)) - 8796714831421723037L) ^ (Long.rotateLeft(j2 * (-4417276706812531889L), 31) * (-7046029288634856825L))) * (-7046029288634856825L)) - 8796714831421723037L)) * (-7046029288634856825L)) - 8796714831421723037L) ^ (Long.rotateLeft(j4 * (-4417276706812531889L), 31) * (-7046029288634856825L))) * (-7046029288634856825L)) - 8796714831421723037L;
        } else {
            jRotateLeft = this.seed + 2870177450012600261L;
        }
        long jRotateLeft2 = jRotateLeft + this.totalLen;
        int i2 = 0;
        while (true) {
            i = this.memSize;
            if (i2 > i - 8) {
                break;
            }
            jRotateLeft2 = (Long.rotateLeft(jRotateLeft2 ^ (Long.rotateLeft(UnsafeUtils.readLongLE(this.memory, i2) * (-4417276706812531889L), 31) * (-7046029288634856825L)), 27) * (-7046029288634856825L)) - 8796714831421723037L;
            i2 += 8;
        }
        if (i2 <= i - 4) {
            jRotateLeft2 = (Long.rotateLeft(jRotateLeft2 ^ ((((long) UnsafeUtils.readIntLE(this.memory, i2)) & 4294967295L) * (-7046029288634856825L)), 23) * (-4417276706812531889L)) + 1609587929392839161L;
            i2 += 4;
        }
        while (i2 < this.memSize) {
            jRotateLeft2 = Long.rotateLeft(jRotateLeft2 ^ (((long) (this.memory[i2] & UByte.MAX_VALUE)) * 2870177450012600261L), 11) * (-7046029288634856825L);
            i2++;
        }
        long j5 = (jRotateLeft2 ^ (jRotateLeft2 >>> 33)) * (-4417276706812531889L);
        long j6 = (j5 ^ (j5 >>> 29)) * 1609587929392839161L;
        return j6 ^ (j6 >>> 32);
    }

    @Override // com.tapadn.xxhash.StreamingXXHash64
    public void update(byte[] bArr, int i, int i2) {
        int i3 = i;
        SafeUtils.checkRange(bArr, i, i2);
        this.totalLen += (long) i2;
        int i4 = this.memSize;
        if (i4 + i2 < 32) {
            System.arraycopy(bArr, i3, this.memory, i4, i2);
            this.memSize += i2;
            return;
        }
        int i5 = i2 + i3;
        if (i4 > 0) {
            System.arraycopy(bArr, i3, this.memory, i4, 32 - i4);
            long longLE = this.v1 + (UnsafeUtils.readLongLE(this.memory, 0) * (-4417276706812531889L));
            this.v1 = longLE;
            long jRotateLeft = Long.rotateLeft(longLE, 31);
            this.v1 = jRotateLeft;
            this.v1 = jRotateLeft * (-7046029288634856825L);
            long longLE2 = this.v2 + (UnsafeUtils.readLongLE(this.memory, 8) * (-4417276706812531889L));
            this.v2 = longLE2;
            long jRotateLeft2 = Long.rotateLeft(longLE2, 31);
            this.v2 = jRotateLeft2;
            this.v2 = jRotateLeft2 * (-7046029288634856825L);
            long longLE3 = this.v3 + (UnsafeUtils.readLongLE(this.memory, 16) * (-4417276706812531889L));
            this.v3 = longLE3;
            long jRotateLeft3 = Long.rotateLeft(longLE3, 31);
            this.v3 = jRotateLeft3;
            this.v3 = jRotateLeft3 * (-7046029288634856825L);
            long longLE4 = this.v4 + (UnsafeUtils.readLongLE(this.memory, 24) * (-4417276706812531889L));
            this.v4 = longLE4;
            long jRotateLeft4 = Long.rotateLeft(longLE4, 31);
            this.v4 = jRotateLeft4;
            this.v4 = jRotateLeft4 * (-7046029288634856825L);
            i3 += 32 - this.memSize;
            this.memSize = 0;
        }
        int i6 = i5 - 32;
        long jRotateLeft5 = this.v1;
        long jRotateLeft6 = this.v2;
        long jRotateLeft7 = this.v3;
        long jRotateLeft8 = this.v4;
        while (i3 <= i6) {
            jRotateLeft5 = Long.rotateLeft(jRotateLeft5 + (UnsafeUtils.readLongLE(bArr, i3) * (-4417276706812531889L)), 31) * (-7046029288634856825L);
            int i7 = i3 + 8;
            jRotateLeft6 = Long.rotateLeft(jRotateLeft6 + (UnsafeUtils.readLongLE(bArr, i7) * (-4417276706812531889L)), 31) * (-7046029288634856825L);
            int i8 = i7 + 8;
            jRotateLeft7 = Long.rotateLeft(jRotateLeft7 + (UnsafeUtils.readLongLE(bArr, i8) * (-4417276706812531889L)), 31) * (-7046029288634856825L);
            int i9 = i8 + 8;
            jRotateLeft8 = Long.rotateLeft(jRotateLeft8 + (UnsafeUtils.readLongLE(bArr, i9) * (-4417276706812531889L)), 31) * (-7046029288634856825L);
            i3 = i9 + 8;
        }
        this.v1 = jRotateLeft5;
        this.v2 = jRotateLeft6;
        this.v3 = jRotateLeft7;
        this.v4 = jRotateLeft8;
        if (i3 < i5) {
            int i10 = i5 - i3;
            System.arraycopy(bArr, i3, this.memory, 0, i10);
            this.memSize = i10;
        }
    }
}
