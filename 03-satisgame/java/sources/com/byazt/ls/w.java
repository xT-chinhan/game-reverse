package com.byazt.ls;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, 32, 13})
public final class w {
    public static final HashMap<String, SparseArray<oa>> n = new HashMap<>();

    public static void n(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, oa oaVar) throws SecurityException {
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
                n(arrayMap, randomAccessFile.getFD(), oaVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            n(map.get(3), randomAccessFile, oaVar);
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void n(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, oa oaVar) throws SecurityException {
        d dVar = new d(fileDescriptor, 0L, oaVar.qg);
        d dVar2 = new d(fileDescriptor, oaVar.s, oaVar.q - oaVar.s);
        ByteBuffer byteBufferDuplicate = oaVar.l.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        um.n(byteBufferDuplicate, oaVar.qg);
        fs fsVar = new fs(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrN = n(iArr, new cp[]{dVar, dVar2, fsVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrN[i2])) {
                    throw new SecurityException(qg(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] n(int[] iArr, cp[] cpVarArr) throws DigestException {
        String str;
        cp[] cpVarArr2 = cpVarArr;
        long j = 0;
        long jN = 0;
        for (cp cpVar : cpVarArr2) {
            jN += n(cpVar.n());
        }
        if (jN >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jN)));
        }
        int i = (int) jN;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(l(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            n(i, bArr2, 1);
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
            String strQg = qg(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strQg);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strQg + " digest not supported", e);
            }
        }
        n nVar = new n(messageDigestArr);
        int length2 = cpVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            cp cpVar2 = cpVarArr2[i4];
            int i7 = length2;
            int i8 = i6;
            n nVar2 = nVar;
            String str2 = str;
            long jN2 = cpVar2.n();
            long j2 = j;
            while (jN2 > j) {
                int iMin = (int) Math.min(jN2, 1048576L);
                n(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                n nVar3 = nVar2;
                try {
                    cpVar2.n(nVar3, j2, iMin);
                    nVar2 = nVar3;
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i10];
                        int iL = l(i11);
                        cp cpVar3 = cpVar2;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        int i12 = length;
                        int iDigest = messageDigest.digest(bArr5, (i8 * iL) + 5, iL);
                        if (iDigest != iL) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i10++;
                        bArr3 = bArr4;
                        cpVar2 = cpVar3;
                        length = i12;
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jN2 -= j3;
                    i8++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                }
            }
            i5++;
            i4++;
            cpVarArr2 = cpVarArr;
            i6 = i8;
            nVar = nVar2;
            str = str2;
            length2 = i7;
            j = 0;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strQg2 = qg(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strQg2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strQg2 + str3, e3);
            }
        }
        return bArr6;
    }

    public static byte[] n(byte[] bArr, long j, oa oaVar) throws SecurityException {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() != j - (oaVar.s - oaVar.qg)) {
            throw new SecurityException("APK content size did not verify");
        }
        return Arrays.copyOfRange(bArr, 0, 32);
    }

    private static void n(byte[] bArr, RandomAccessFile randomAccessFile, oa oaVar) throws SecurityException {
        try {
            if (Arrays.equals(n(bArr, randomAccessFile.length(), oaVar), x.n(randomAccessFile, oaVar, new rv() { // from class: com.byazt.ls.w.1
                @Override // com.byazt.ls.rv
                public ByteBuffer n(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).qg)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    public static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile) throws sz, IOException {
        Pair<ByteBuffer, Long> pairN = um.n(randomAccessFile);
        if (pairN != null) {
            return pairN;
        }
        throw new sz("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static long n(ByteBuffer byteBuffer, long j) throws sz {
        long jN = um.n(byteBuffer);
        if (jN > j) {
            throw new sz("ZIP Central Directory offset out of range: " + jN + ". ZIP End of Central Directory offset: " + j);
        }
        if (um.qg(byteBuffer) + jN == j) {
            return jN;
        }
        throw new sz("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    private static long n(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static int n(int i, int i2) {
        return qg(n(i), n(i2));
    }

    private static int qg(int i, int i2) {
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

    public static int n(int i) {
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

    public static String qg(int i) {
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

    private static int l(int i) {
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

    public static String s(int i) {
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

    public static Pair<String, ? extends AlgorithmParameterSpec> q(int i) {
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

    public static ByteBuffer n(ByteBuffer byteBuffer, int i, int i2) {
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

    public static ByteBuffer n(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
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

    public static ByteBuffer n(ByteBuffer byteBuffer) throws IOException {
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
        return n(byteBuffer, i);
    }

    public static byte[] qg(ByteBuffer byteBuffer) throws IOException {
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

    public static void n(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile, long j) throws sz, IOException {
        if (j < 32) {
            throw new sz("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
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
            throw new sz("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new sz("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new sz("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    public static void n(String str, RandomAccessFile randomAccessFile, int... iArr) throws sz, IOException {
        ByteBuffer byteBuffer;
        String str2 = str;
        n.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairN = n(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairN.first;
        long jLongValue = ((Long) pairN.second).longValue();
        if (um.n(randomAccessFile, jLongValue)) {
            throw new sz("ZIP64 APK not supported");
        }
        long jN = n(byteBuffer2, jLongValue);
        Pair<ByteBuffer, Long> pairN2 = n(randomAccessFile, jN);
        if (pairN2 == null) {
            return;
        }
        ByteBuffer byteBuffer3 = (ByteBuffer) pairN2.first;
        long jLongValue2 = ((Long) pairN2.second).longValue();
        s(byteBuffer3);
        int i = 8;
        ByteBuffer byteBufferN = n(byteBuffer3, 8, byteBuffer3.capacity() - 24);
        HashSet hashSet = new HashSet();
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        while (byteBufferN.hasRemaining() && byteBufferN.remaining() >= i) {
            long j = byteBufferN.getLong();
            if (j < 4 || j > 2147483647L) {
                return;
            }
            int i3 = (int) j;
            int iPosition = byteBufferN.position() + i3;
            if (i3 > byteBufferN.remaining()) {
                return;
            }
            int i4 = byteBufferN.getInt();
            if (hashSet.contains(Integer.valueOf(i4))) {
                n.get(str2).put(i4, new oa(n(byteBufferN, i3 - 4), jLongValue2, jN, jLongValue, byteBuffer2));
                byteBuffer = byteBufferN;
            } else {
                byteBuffer = byteBufferN;
            }
            byteBuffer.position(iPosition);
            hashSet = hashSet;
            byteBufferN = byteBuffer;
            jN = jN;
            i = i;
            str2 = str;
        }
    }

    private static void s(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    @com.byazt.cp.n(n = {0, 1, 32, 108})
    private static class n implements tj {
        public final MessageDigest[] n;

        public n(MessageDigest[] messageDigestArr) {
            this.n = messageDigestArr;
        }

        @Override // com.byazt.ls.tj
        public void n(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.n) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }
}
