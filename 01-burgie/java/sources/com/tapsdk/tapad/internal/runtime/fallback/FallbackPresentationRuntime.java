package com.tapsdk.tapad.internal.runtime.fallback;

import com.tapsdk.tapad.b;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
final class FallbackPresentationRuntime {

    public static final class Effect {
        final int opcode;
        final int value;

        public Effect(int i, int i2) {
            this.opcode = i;
            this.value = i2;
        }
    }

    public static final class EffectBatch {
        final Effect[] effects;
        final int state;

        public EffectBatch(int i, Effect[] effectArr) {
            this.state = i;
            this.effects = (Effect[]) Arrays.copyOf(effectArr, effectArr.length);
        }
    }

    public static final class Reader {
        private final byte[] bytes;
        private int offset;

        public Reader(byte[] bArr) {
            this.bytes = bArr;
        }

        public byte[] bytes(int i) {
            if (i >= 0) {
                int i2 = this.offset;
                byte[] bArr = this.bytes;
                if (i2 <= bArr.length - i) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i2 + i);
                    this.offset += i;
                    return bArrCopyOfRange;
                }
            }
            throw FallbackPresentationRuntime.malformed();
        }

        public boolean finished() {
            return this.offset == this.bytes.length;
        }

        public int u16() {
            byte[] bArrBytes = bytes(2);
            return ((bArrBytes[1] & UByte.MAX_VALUE) << 8) | (bArrBytes[0] & UByte.MAX_VALUE);
        }

        public long u32() {
            return FallbackPresentationRuntime.readU32(bytes(4), 0);
        }

        public int u8() {
            return bytes(1)[0] & UByte.MAX_VALUE;
        }
    }

    private FallbackPresentationRuntime() {
    }

    public static EffectBatch close(int i, int i2, int i3) {
        return event(i, i2, 2, i3);
    }

    public static EffectBatch decode(byte[] bArr) {
        if (bArr == null || bArr.length < 16 || bArr.length > 64) {
            throw malformed();
        }
        Reader reader = new Reader(bArr);
        if (reader.u32() != 1481003588 || reader.u16() != 1) {
            throw malformed();
        }
        int iU8 = reader.u8();
        if (!validState(iU8) || reader.u8() != 0) {
            throw malformed();
        }
        int iU16 = reader.u16();
        if (iU16 > 2 || reader.u16() != 0) {
            throw malformed();
        }
        if (reader.u32() != bArr.length) {
            throw malformed();
        }
        Effect[] effectArr = new Effect[iU16];
        for (int i = 0; i < iU16; i++) {
            int iU17 = reader.u16();
            if (reader.u16() != 0) {
                throw malformed();
            }
            long jU32 = reader.u32();
            if (jU32 > 2147483647L) {
                throw malformed();
            }
            byte[] bArrBytes = reader.bytes((int) jU32);
            if (iU17 == 1 && bArrBytes.length == 4) {
                long u32 = readU32(bArrBytes, 0);
                if (u32 == 0 || u32 > 2147483647L) {
                    throw malformed();
                }
                effectArr[i] = new Effect(iU17, (int) u32);
            } else if (iU17 == 2 && bArrBytes.length == 4) {
                long u33 = readU32(bArrBytes, 0);
                if (u33 > 2147483647L) {
                    throw malformed();
                }
                effectArr[i] = new Effect(iU17, (int) u33);
            } else {
                if (iU17 != 3 || bArrBytes.length != 4 || bArrBytes[1] != 0 || bArrBytes[2] != 0 || bArrBytes[3] != 0 || !validTerminalReason(bArrBytes[0] & UByte.MAX_VALUE)) {
                    throw malformed();
                }
                effectArr[i] = new Effect(iU17, bArrBytes[0] & UByte.MAX_VALUE);
            }
        }
        if (reader.finished() && validGrammar(iU8, effectArr)) {
            return new EffectBatch(iU8, effectArr);
        }
        throw malformed();
    }

    private static EffectBatch decodeResult(int i, byte[] bArr, boolean z) throws DispatchException {
        if (i <= 0) {
            throw new DispatchException(i);
        }
        if (i > bArr.length || i > 64) {
            throw new DispatchException(-1);
        }
        try {
            EffectBatch effectBatchDecode = decode(Arrays.copyOf(bArr, i));
            if (z && !validStartBatch(effectBatchDecode)) {
                throw malformed();
            }
            return effectBatchDecode;
        } catch (IllegalArgumentException e) {
            throw new DispatchException(-1, e);
        }
    }

    public static EffectBatch destroy(int i, int i2) {
        return event(i, i2, 5, 0);
    }

    private static EffectBatch event(int i, int i2, int i3, int i4) throws DispatchException {
        byte[] bArr = new byte[64];
        try {
            return decodeResult(nativeEvent(i, i2, i3, i4, bArr), bArr, false);
        } catch (Throwable th) {
            throw new DispatchException(-1, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException malformed() {
        return new IllegalArgumentException("malformed fallback effect batch");
    }

    private static native int nativeEvent(int i, int i2, int i3, int i4, byte[] bArr);

    private static native int nativeStart(int i, int i2, long j, byte[] bArr, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: private */
    public static long readU32(byte[] bArr, int i) {
        return ((((long) bArr[i + 3]) & 255) << 24) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
    }

    public static EffectBatch rendererFailed(int i, int i2) {
        return event(i, i2, 3, 0);
    }

    public static EffectBatch start(int i, int i2, long j, byte[] bArr) throws DispatchException {
        if (bArr == null || bArr.length == 0) {
            throw new DispatchException(-1);
        }
        byte[] bArr2 = new byte[64];
        try {
            return decodeResult(nativeStart(i, i2, j, Arrays.copyOf(bArr, bArr.length), bArr2), bArr2, true);
        } catch (Throwable th) {
            throw new DispatchException(-1, th);
        }
    }

    private static boolean validGrammar(int i, Effect[] effectArr) {
        if (i == 0) {
            return effectArr.length == 0;
        }
        if (i == 1) {
            return effectArr.length == 0 || (effectArr.length == 2 && effectArr[0].opcode == 1 && effectArr[1].opcode == 2);
        }
        return effectArr.length == 0 || (effectArr.length == 1 && effectArr[0].opcode == 3);
    }

    public static boolean validStartBatch(EffectBatch effectBatch) {
        if (effectBatch == null) {
            return false;
        }
        int i = effectBatch.state;
        if (i == 1) {
            Effect[] effectArr = effectBatch.effects;
            return effectArr.length == 2 && effectArr[0].opcode == 1 && effectArr[1].opcode == 2;
        }
        if (i == 2) {
            Effect[] effectArr2 = effectBatch.effects;
            if (effectArr2.length == 1 && effectArr2[0].opcode == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean validState(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    private static boolean validTerminalReason(int i) {
        return i >= 1 && i <= 6;
    }

    public static EffectBatch watchdog(int i, int i2) {
        return event(i, i2, 4, 0);
    }

    public static final class DispatchException extends Exception {
        final int status;

        public DispatchException(int i) {
            super(b.a("fallback Rust dispatch failed: ", i));
            this.status = i;
        }

        public DispatchException(int i, Throwable th) {
            super(b.a("fallback Rust dispatch failed: ", i), th);
            this.status = i;
        }
    }
}
