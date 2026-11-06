package com.tapsdk.tapad.internal.ionia;

import com.tapsdk.tapad.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
final class Codec {

    public static final class CodecException extends RuntimeException {
        public CodecException(String str) {
            super(str);
        }
    }

    public static final class Envelope {
        final byte[] payload;
        final int status;

        public Envelope(int i, byte[] bArr) {
            this.status = i;
            this.payload = bArr;
        }

        public Reader reader() {
            return new Reader(this.payload);
        }
    }

    public static final class Reader {
        private final ByteBuffer buf;

        public Reader(byte[] bArr) {
            if (bArr == null) {
                throw new CodecException("data is null");
            }
            this.buf = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        public byte[] readBytes() {
            int u32 = readU32();
            if (u32 < 0) {
                throw new CodecException(b.a("negative length: ", u32));
            }
            if (u32 > this.buf.remaining()) {
                throw new CodecException("length " + u32 + " > remaining " + this.buf.remaining());
            }
            byte[] bArr = new byte[u32];
            this.buf.get(bArr);
            return bArr;
        }

        public String readStr() {
            return new String(readBytes(), StandardCharsets.UTF_8);
        }

        public int readU32() {
            if (this.buf.remaining() >= 4) {
                return this.buf.getInt();
            }
            throw new CodecException("u32 underrun");
        }

        public long readU64() {
            if (this.buf.remaining() >= 8) {
                return this.buf.getLong();
            }
            throw new CodecException("u64 underrun");
        }

        public int remaining() {
            return this.buf.remaining();
        }
    }

    public static final class Writer {
        private byte[] buf;
        private int pos;

        public Writer() {
            this(64);
        }

        private void ensure(int i) {
            int i2 = this.pos + i;
            byte[] bArr = this.buf;
            if (i2 <= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[Math.max(bArr.length * 2, i2)];
            System.arraycopy(this.buf, 0, bArr2, 0, this.pos);
            this.buf = bArr2;
        }

        public byte[] finish() {
            int i = this.pos;
            byte[] bArr = new byte[i];
            System.arraycopy(this.buf, 0, bArr, 0, i);
            return bArr;
        }

        public Writer writeBytes(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            writeU32(bArr.length);
            ensure(bArr.length);
            System.arraycopy(bArr, 0, this.buf, this.pos, bArr.length);
            this.pos += bArr.length;
            return this;
        }

        public Writer writeStr(String str) {
            if (str == null) {
                str = "";
            }
            return writeBytes(str.getBytes(StandardCharsets.UTF_8));
        }

        public Writer writeU32(int i) {
            ensure(4);
            byte[] bArr = this.buf;
            int i2 = this.pos;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
            bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
            this.pos = i2 + 4;
            return this;
        }

        public Writer writeU64(long j) {
            ensure(8);
            byte[] bArr = this.buf;
            int i = this.pos;
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >>> 8) & 255);
            bArr[i + 2] = (byte) ((j >>> 16) & 255);
            bArr[i + 3] = (byte) ((j >>> 24) & 255);
            bArr[i + 4] = (byte) ((j >>> 32) & 255);
            bArr[i + 5] = (byte) ((j >>> 40) & 255);
            bArr[i + 6] = (byte) ((j >>> 48) & 255);
            bArr[i + 7] = (byte) ((j >>> 56) & 255);
            this.pos = i + 8;
            return this;
        }

        public Writer(int i) {
            this.buf = new byte[Math.max(16, i)];
        }
    }

    private Codec() {
    }

    public static Envelope parseEnvelope(byte[] bArr) {
        if (bArr != null && bArr.length >= 8) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            int i = byteBufferOrder.getInt();
            int i2 = byteBufferOrder.getInt();
            if (i2 >= 0 && i2 <= byteBufferOrder.remaining()) {
                byte[] bArr2 = new byte[i2];
                byteBufferOrder.get(bArr2);
                return new Envelope(i, bArr2);
            }
        }
        return null;
    }
}
