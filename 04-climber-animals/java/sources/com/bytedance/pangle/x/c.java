package com.bytedance.pangle.x;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final HashMap<String, SparseArray<zb>> f721ms = new HashMap<>();

    static void ms(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, zb zbVar) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                ms(arrayMap, randomAccessFile.getFD(), zbVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            ms(map.get(3), randomAccessFile, zbVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void ms(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, zb zbVar) throws SecurityException {
        sl slVar = new sl(fileDescriptor, 0L, zbVar.xr);
        sl slVar2 = new sl(fileDescriptor, zbVar.ah, zbVar.d - zbVar.ah);
        ByteBuffer byteBufferDuplicate = zbVar.ka.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        y.ms(byteBufferDuplicate, zbVar.xr);
        x xVar = new x(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrMs = ms(iArr, new hi[]{slVar, slVar2, xVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrMs[i2])) {
                    throw new SecurityException(xr(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] ms(int[] iArr, hi[] hiVarArr) throws DigestException {
        String str;
        hi[] hiVarArr2 = hiVarArr;
        long j = 0;
        long jMs = 0;
        for (hi hiVar : hiVarArr2) {
            jMs += ms(hiVar.ms());
        }
        if (jMs >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jMs)));
        }
        int i = (int) jMs;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(ka(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            ms(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i3 = 0;
        while (true) {
            str = " digest not supported";
            if (i3 >= iArr.length) {
                break;
            }
            String strXr = xr(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strXr);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strXr + " digest not supported", e);
            }
        }
        ms msVar = new ms(messageDigestArr);
        int length2 = hiVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            hi hiVar2 = hiVarArr2[i4];
            int i7 = length2;
            int i8 = i6;
            ms msVar2 = msVar;
            String str2 = str;
            long jMs2 = hiVar2.ms();
            long j2 = j;
            while (jMs2 > j) {
                int iMin = (int) Math.min(jMs2, BaseConstants.MB_VALUE);
                ms(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                ms msVar3 = msVar2;
                try {
                    hiVar2.ms(msVar3, j2, iMin);
                    msVar2 = msVar3;
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i10];
                        int iKa = ka(i11);
                        hi hiVar3 = hiVar2;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        int i12 = length;
                        int iDigest = messageDigest.digest(bArr5, (i8 * iKa) + 5, iKa);
                        if (iDigest != iKa) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i10++;
                        bArr3 = bArr4;
                        hiVar2 = hiVar3;
                        length = i12;
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jMs2 -= j3;
                    i8++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                }
            }
            i5++;
            i4++;
            hiVarArr2 = hiVarArr;
            i6 = i8;
            msVar = msVar2;
            str = str2;
            length2 = i7;
            j = 0;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strXr2 = xr(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strXr2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strXr2 + str3, e3);
            }
        }
        return bArr6;
    }

    static byte[] ms(byte[] bArr, long j, zb zbVar) throws SecurityException {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() != j - (zbVar.ah - zbVar.xr)) {
            throw new SecurityException("APK content size did not verify");
        }
        return Arrays.copyOfRange(bArr, 0, 32);
    }

    private static void ms(byte[] bArr, RandomAccessFile randomAccessFile, zb zbVar) throws SecurityException {
        try {
            if (Arrays.equals(ms(bArr, randomAccessFile.length(), zbVar), ab.ms(randomAccessFile, zbVar, new ny() { // from class: com.bytedance.pangle.x.c.1
                @Override // com.bytedance.pangle.x.ny
                public ByteBuffer ms(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).xr)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    static Pair<ByteBuffer, Long> ms(RandomAccessFile randomAccessFile) throws u, IOException {
        Pair<ByteBuffer, Long> pairMs = y.ms(randomAccessFile);
        if (pairMs != null) {
            return pairMs;
        }
        throw new u("Not an APK file: ZIP End of Central Directory record not found");
    }

    static long ms(ByteBuffer byteBuffer, long j) throws u {
        long jMs = y.ms(byteBuffer);
        if (jMs > j) {
            throw new u("ZIP Central Directory offset out of range: " + jMs + ". ZIP End of Central Directory offset: " + j);
        }
        if (y.xr(byteBuffer) + jMs == j) {
            return jMs;
        }
        throw new u("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    private static long ms(long j) {
        return ((j + BaseConstants.MB_VALUE) - 1) / BaseConstants.MB_VALUE;
    }

    static int ms(int i, int i2) {
        return xr(ms(i), ms(i2));
    }

    private static int xr(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    static int ms(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static String xr(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    private static int ka(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    static String ah(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return "RSA";
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> d(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    static ByteBuffer ms(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    static ByteBuffer ms(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    static ByteBuffer ms(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return ms(byteBuffer, i);
    }

    static byte[] xr(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    static void ms(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    static Pair<ByteBuffer, Long> ms(RandomAccessFile randomAccessFile, long j) throws u, IOException {
        if (j < 32) {
            throw new u("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            return null;
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new u("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new u("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new u("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    static void ms(String str, RandomAccessFile randomAccessFile, int... iArr) throws u, IOException {
        ByteBuffer byteBuffer;
        String str2 = str;
        f721ms.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairMs = ms(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairMs.first;
        long jLongValue = ((Long) pairMs.second).longValue();
        if (y.ms(randomAccessFile, jLongValue)) {
            throw new u("ZIP64 APK not supported");
        }
        long jMs = ms(byteBuffer2, jLongValue);
        Pair<ByteBuffer, Long> pairMs2 = ms(randomAccessFile, jMs);
        if (pairMs2 == null) {
            return;
        }
        ByteBuffer byteBuffer3 = (ByteBuffer) pairMs2.first;
        long jLongValue2 = ((Long) pairMs2.second).longValue();
        ah(byteBuffer3);
        int i = 8;
        ByteBuffer byteBufferMs = ms(byteBuffer3, 8, byteBuffer3.capacity() - 24);
        HashSet hashSet = new HashSet();
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        while (byteBufferMs.hasRemaining() && byteBufferMs.remaining() >= i) {
            long j = byteBufferMs.getLong();
            if (j < 4 || j > 2147483647L) {
                return;
            }
            int i3 = (int) j;
            int iPosition = byteBufferMs.position() + i3;
            if (i3 > byteBufferMs.remaining()) {
                return;
            }
            int i4 = byteBufferMs.getInt();
            if (hashSet.contains(Integer.valueOf(i4))) {
                f721ms.get(str2).put(i4, new zb(ms(byteBufferMs, i3 - 4), jLongValue2, jMs, jLongValue, byteBuffer2));
                byteBuffer = byteBufferMs;
            } else {
                byteBuffer = byteBufferMs;
            }
            byteBuffer.position(iPosition);
            hashSet = hashSet;
            byteBufferMs = byteBuffer;
            jMs = jMs;
            i = i;
            str2 = str;
        }
    }

    private static void ah(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static class ms implements ch {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final MessageDigest[] f722ms;

        ms(MessageDigest[] messageDigestArr) {
            this.f722ms = messageDigestArr;
        }

        @Override // com.bytedance.pangle.x.ch
        public void ms(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.f722ms) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }
}
