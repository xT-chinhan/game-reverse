package com.byazt.lro;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.utils.RSAUtils;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 5})
public final class uc {
    public static final HashMap<String, SparseArray<m>> pr = new HashMap<>();

    public static void pr(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) throws SecurityException {
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
                pr(arrayMap, randomAccessFile.getFD(), mVar);
                z = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (!map.containsKey(3)) {
            z2 = z;
        } else {
            pr(map.get(3), randomAccessFile, mVar);
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void pr(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) throws SecurityException {
        k kVar = new k(fileDescriptor, 0L, mVar.hw);
        k kVar2 = new k(fileDescriptor, mVar.hn, mVar.x - mVar.hn);
        ByteBuffer byteBufferDuplicate = mVar.c.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        qa.pr(byteBufferDuplicate, mVar.hw);
        zo zoVar = new zo(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrPr = pr(iArr, new w[]{kVar, kVar2, zoVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrPr[i2])) {
                    throw new SecurityException(hw(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] pr(int[] iArr, w[] wVarArr) throws DigestException {
        String str;
        w[] wVarArr2 = wVarArr;
        long j = 0;
        long jPr = 0;
        for (w wVar : wVarArr2) {
            jPr += pr(wVar.pr());
        }
        if (jPr >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jPr)));
        }
        int i = (int) jPr;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(c(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            pr(i, bArr2, 1);
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
            String strHw = hw(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strHw);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strHw + " digest not supported", e);
            }
        }
        pr prVar = new pr(messageDigestArr);
        int length2 = wVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            w wVar2 = wVarArr2[i4];
            int i7 = length2;
            int i8 = i6;
            pr prVar2 = prVar;
            String str2 = str;
            long jPr2 = wVar2.pr();
            long j2 = j;
            while (jPr2 > j) {
                int iMin = (int) Math.min(jPr2, 1048576L);
                pr(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                pr prVar3 = prVar2;
                try {
                    wVar2.pr(prVar3, j2, iMin);
                    int i10 = 0;
                    while (true) {
                        prVar2 = prVar3;
                        if (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i10];
                            int iC = c(i11);
                            w wVar3 = wVar2;
                            MessageDigest messageDigest = messageDigestArr[i10];
                            int i12 = length;
                            int iDigest = messageDigest.digest(bArr5, (i8 * iC) + 5, iC);
                            if (iDigest == iC) {
                                i10++;
                                prVar3 = prVar2;
                                bArr3 = bArr4;
                                wVar2 = wVar3;
                                length = i12;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                            }
                        }
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jPr2 -= j3;
                    i8++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                }
            }
            i5++;
            i4++;
            wVarArr2 = wVarArr;
            i6 = i8;
            prVar = prVar2;
            str = str2;
            length2 = i7;
            j = 0;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strHw2 = hw(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strHw2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strHw2 + str3, e3);
            }
        }
        return bArr6;
    }

    public static byte[] pr(byte[] bArr, long j, m mVar) throws SecurityException {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() == j - (mVar.hn - mVar.hw)) {
            return Arrays.copyOfRange(bArr, 0, 32);
        }
        throw new SecurityException("APK content size did not verify");
    }

    private static void pr(byte[] bArr, RandomAccessFile randomAccessFile, m mVar) throws SecurityException {
        try {
            if (!Arrays.equals(pr(bArr, randomAccessFile.length(), mVar), fw.pr(randomAccessFile, mVar, new aj() { // from class: com.byazt.lro.uc.1
                @Override // com.byazt.lro.aj
                public ByteBuffer pr(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).hw)) {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    public static Pair<ByteBuffer, Long> pr(RandomAccessFile randomAccessFile) throws g, IOException {
        Pair<ByteBuffer, Long> pairPr = qa.pr(randomAccessFile);
        if (pairPr == null) {
            throw new g("Not an APK file: ZIP End of Central Directory record not found");
        }
        return pairPr;
    }

    public static long pr(ByteBuffer byteBuffer, long j) throws g {
        long jPr = qa.pr(byteBuffer);
        if (jPr > j) {
            throw new g("ZIP Central Directory offset out of range: " + jPr + ". ZIP End of Central Directory offset: " + j);
        }
        if (qa.hw(byteBuffer) + jPr != j) {
            throw new g("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        return jPr;
    }

    private static long pr(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static int pr(int i, int i2) {
        return hw(pr(i), pr(i2));
    }

    private static int hw(int i, int i2) {
        switch (i) {
            case 1:
                switch (i2) {
                    case 1:
                        return 0;
                    case 2:
                    case 3:
                        return -1;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            case 2:
                switch (i2) {
                    case 1:
                    case 3:
                        return 1;
                    case 2:
                        return 0;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            case 3:
                switch (i2) {
                    case 1:
                        return 1;
                    case 2:
                        return -1;
                    case 3:
                        return 0;
                    default:
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            default:
                throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
    }

    public static int pr(int i) {
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case 513:
            case 769:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
                return 2;
            case 1057:
            case 1059:
            case 1061:
                return 3;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    public static String hw(int i) {
        switch (i) {
            case 1:
            case 3:
                return "SHA-256";
            case 2:
                return "SHA-512";
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
        }
    }

    private static int c(int i) {
        switch (i) {
            case 1:
            case 3:
                return 32;
            case 2:
                return 64;
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
        }
    }

    public static String hn(int i) {
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case 1057:
                return RSAUtils.KEY_ALGORITHM;
            case 513:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
            case 1059:
                return "EC";
            case 769:
            case 1061:
                return "DSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> x(int i) {
        switch (i) {
            case 257:
                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case 1057:
                return Pair.create("SHA256withRSA", null);
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return Pair.create("SHA512withRSA", null);
            case 513:
            case 1059:
                return Pair.create("SHA256withECDSA", null);
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
                return Pair.create("SHA512withECDSA", null);
            case 769:
            case 1061:
                return Pair.create("SHA256withDSA", null);
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    public static ByteBuffer pr(ByteBuffer byteBuffer, int i, int i2) {
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

    public static ByteBuffer pr(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
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

    public static ByteBuffer pr(ByteBuffer byteBuffer) throws IOException {
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
        return pr(byteBuffer, i);
    }

    public static byte[] hw(ByteBuffer byteBuffer) throws IOException {
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

    public static void pr(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static Pair<ByteBuffer, Long> pr(RandomAccessFile randomAccessFile, long j) throws g, IOException {
        if (j < 32) {
            throw new g("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
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
            throw new g("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new g("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new g("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    public static void pr(String str, RandomAccessFile randomAccessFile, int... iArr) throws g, IOException {
        String str2 = str;
        pr.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairPr = pr(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) pairPr.first;
        long jLongValue = ((Long) pairPr.second).longValue();
        if (qa.pr(randomAccessFile, jLongValue)) {
            throw new g("ZIP64 APK not supported");
        }
        long jPr = pr(byteBuffer, jLongValue);
        Pair<ByteBuffer, Long> pairPr2 = pr(randomAccessFile, jPr);
        if (pairPr2 == null) {
            return;
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) pairPr2.first;
        long jLongValue2 = ((Long) pairPr2.second).longValue();
        hn(byteBuffer2);
        int i = 8;
        ByteBuffer byteBufferPr = pr(byteBuffer2, 8, byteBuffer2.capacity() - 24);
        HashSet hashSet = new HashSet();
        for (int i2 : iArr) {
            hashSet.add(Integer.valueOf(i2));
        }
        while (byteBufferPr.hasRemaining() && byteBufferPr.remaining() >= i) {
            long j = byteBufferPr.getLong();
            if (j < 4 || j > 2147483647L) {
                return;
            }
            int i3 = (int) j;
            int iPosition = byteBufferPr.position() + i3;
            if (i3 > byteBufferPr.remaining()) {
                return;
            }
            int i4 = byteBufferPr.getInt();
            if (hashSet.contains(Integer.valueOf(i4))) {
                pr.get(str2).put(i4, new m(pr(byteBufferPr, i3 - 4), jLongValue2, jPr, jLongValue, byteBuffer));
            }
            ByteBuffer byteBuffer3 = byteBufferPr;
            byteBuffer3.position(iPosition);
            hashSet = hashSet;
            byteBufferPr = byteBuffer3;
            jPr = jPr;
            i = i;
            str2 = str;
        }
    }

    private static void hn(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 129})
    private static class pr implements vk {
        public final MessageDigest[] pr;

        public pr(MessageDigest[] messageDigestArr) {
            this.pr = messageDigestArr;
        }

        @Override // com.byazt.lro.vk
        public void pr(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.pr) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }
}
