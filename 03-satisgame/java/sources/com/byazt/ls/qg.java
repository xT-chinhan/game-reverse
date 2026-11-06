package com.byazt.ls;

import android.util.ArrayMap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 26})
public class qg {
    private static boolean n(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
            return true;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    public static X509Certificate[][] n(RandomAccessFile randomAccessFile, String str) throws sz, SecurityException, IOException {
        oa oaVar = w.n.get(str).get(1896449818);
        if (oaVar == null) {
            throw new sz("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
        }
        return n(randomAccessFile, oaVar, true).n;
    }

    private static n n(RandomAccessFile randomAccessFile, oa oaVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferN = w.n(oaVar.n);
                int i = 0;
                while (byteBufferN.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(n(w.n(byteBufferN), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    w.n(arrayMap, randomAccessFile, oaVar);
                }
                return new n((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? w.n((byte[]) arrayMap.get(3), randomAccessFile.length(), oaVar) : null);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] n(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferN = w.n(byteBuffer);
        ByteBuffer byteBufferN2 = w.n(byteBuffer);
        byte[] bArrQg = w.qg(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrQg2 = null;
        int i = 0;
        int i2 = -1;
        byte[] bArrQg3 = null;
        while (byteBufferN2.hasRemaining()) {
            i++;
            try {
                ByteBuffer byteBufferN3 = w.n(byteBufferN2);
                if (byteBufferN3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferN3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (n(i3) && (i2 == -1 || w.n(i3, i2) > 0)) {
                    bArrQg3 = w.qg(byteBufferN3);
                    i2 = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i)), e);
            }
        }
        if (i2 == -1) {
            if (i == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strS = w.s(i2);
        Pair<String, ? extends AlgorithmParameterSpec> pairQ = w.q(i2);
        String str = (String) pairQ.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairQ.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strS).generatePublic(new X509EncodedKeySpec(bArrQg));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferN);
            if (!signature.verify(bArrQg3)) {
                throw new SecurityException(str + " signature did not verify");
            }
            byteBufferN.clear();
            ByteBuffer byteBufferN4 = w.n(byteBufferN);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferN4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferN5 = w.n(byteBufferN4);
                    if (byteBufferN5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferN5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i2) {
                        bArrQg2 = w.qg(byteBufferN5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iN = w.n(i2);
            byte[] bArrPut = map.put(Integer.valueOf(iN), bArrQg2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrQg2)) {
                throw new SecurityException(w.qg(iN) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferN6 = w.n(byteBufferN);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferN6.hasRemaining()) {
                i6++;
                byte[] bArrQg4 = w.qg(byteBufferN6);
                try {
                    arrayList3.add(new cy((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrQg4)), bArrQg4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrQg, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            n(w.n(byteBufferN));
            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void n(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferN = w.n(byteBuffer);
            if (byteBufferN.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferN.remaining());
            }
            if (byteBufferN.getInt() == -1091571699) {
                if (byteBufferN.remaining() < 4) {
                    throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferN.remaining());
                }
                if (byteBufferN.getInt() == 3) {
                    throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 32, 48})
    public static class n {
        public final X509Certificate[][] n;
        public final byte[] qg;

        public n(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.n = x509CertificateArr;
            this.qg = bArr;
        }
    }
}
