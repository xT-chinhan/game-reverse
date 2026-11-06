package com.tapadn.xxhash;

import com.tapadn.util.SafeUtils;
import com.tapadn.util.UnsafeUtils;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
final class StreamingXXHash32JavaUnsafe extends AbstractStreamingXXHash32Java {

    static class Factory implements StreamingXXHash32.Factory {
        public static final StreamingXXHash32.Factory INSTANCE = new Factory();

        Factory() {
        }

        @Override // com.tapadn.xxhash.StreamingXXHash32.Factory
        public StreamingXXHash32 newStreamingHash(int i) {
            return new StreamingXXHash32JavaUnsafe(i);
        }
    }

    StreamingXXHash32JavaUnsafe(int i) {
        super(i);
    }

    @Override // com.tapadn.xxhash.StreamingXXHash32
    public int getValue() {
        int iRotateLeft = (int) (((long) (this.totalLen >= 16 ? Integer.rotateLeft(this.v1, 1) + Integer.rotateLeft(this.v2, 7) + Integer.rotateLeft(this.v3, 12) + Integer.rotateLeft(this.v4, 18) : this.seed + 374761393)) + this.totalLen);
        int i = 0;
        while (i <= this.memSize - 4) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + (UnsafeUtils.readIntLE(this.memory, i) * (-1028477379)), 17) * 668265263;
            i += 4;
        }
        while (i < this.memSize) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + ((UnsafeUtils.readByte(this.memory, i) & UByte.MAX_VALUE) * 374761393), 11) * (-1640531535);
            i++;
        }
        int i2 = (iRotateLeft ^ (iRotateLeft >>> 15)) * (-2048144777);
        int i3 = (i2 ^ (i2 >>> 13)) * (-1028477379);
        return i3 ^ (i3 >>> 16);
    }

    @Override // com.tapadn.xxhash.StreamingXXHash32
    public void update(byte[] bArr, int i, int i2) {
        SafeUtils.checkRange(bArr, i, i2);
        this.totalLen += (long) i2;
        int i3 = this.memSize;
        if (i3 + i2 < 16) {
            System.arraycopy(bArr, i, this.memory, i3, i2);
            this.memSize += i2;
            return;
        }
        int i4 = i2 + i;
        if (i3 > 0) {
            System.arraycopy(bArr, i, this.memory, i3, 16 - i3);
            int intLE = this.v1 + (UnsafeUtils.readIntLE(this.memory, 0) * (-2048144777));
            this.v1 = intLE;
            int iRotateLeft = Integer.rotateLeft(intLE, 13);
            this.v1 = iRotateLeft;
            this.v1 = iRotateLeft * (-1640531535);
            int intLE2 = this.v2 + (UnsafeUtils.readIntLE(this.memory, 4) * (-2048144777));
            this.v2 = intLE2;
            int iRotateLeft2 = Integer.rotateLeft(intLE2, 13);
            this.v2 = iRotateLeft2;
            this.v2 = iRotateLeft2 * (-1640531535);
            int intLE3 = this.v3 + (UnsafeUtils.readIntLE(this.memory, 8) * (-2048144777));
            this.v3 = intLE3;
            int iRotateLeft3 = Integer.rotateLeft(intLE3, 13);
            this.v3 = iRotateLeft3;
            this.v3 = iRotateLeft3 * (-1640531535);
            int intLE4 = this.v4 + (UnsafeUtils.readIntLE(this.memory, 12) * (-2048144777));
            this.v4 = intLE4;
            int iRotateLeft4 = Integer.rotateLeft(intLE4, 13);
            this.v4 = iRotateLeft4;
            this.v4 = iRotateLeft4 * (-1640531535);
            i += 16 - this.memSize;
            this.memSize = 0;
        }
        int i5 = i4 - 16;
        int iRotateLeft5 = this.v1;
        int iRotateLeft6 = this.v2;
        int iRotateLeft7 = this.v3;
        int iRotateLeft8 = this.v4;
        while (i <= i5) {
            iRotateLeft5 = Integer.rotateLeft(iRotateLeft5 + (UnsafeUtils.readIntLE(bArr, i) * (-2048144777)), 13) * (-1640531535);
            int i6 = i + 4;
            iRotateLeft6 = Integer.rotateLeft(iRotateLeft6 + (UnsafeUtils.readIntLE(bArr, i6) * (-2048144777)), 13) * (-1640531535);
            int i7 = i6 + 4;
            iRotateLeft7 = Integer.rotateLeft(iRotateLeft7 + (UnsafeUtils.readIntLE(bArr, i7) * (-2048144777)), 13) * (-1640531535);
            int i8 = i7 + 4;
            iRotateLeft8 = Integer.rotateLeft(iRotateLeft8 + (UnsafeUtils.readIntLE(bArr, i8) * (-2048144777)), 13) * (-1640531535);
            i = i8 + 4;
        }
        this.v1 = iRotateLeft5;
        this.v2 = iRotateLeft6;
        this.v3 = iRotateLeft7;
        this.v4 = iRotateLeft8;
        if (i < i4) {
            int i9 = i4 - i;
            System.arraycopy(bArr, i, this.memory, 0, i9);
            this.memSize = i9;
        }
    }
}
