package com.byazt.lro;

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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 13})
public class hw {
    public static X509Certificate[][] pr(RandomAccessFile randomAccessFile, String str) throws g, SecurityException, IOException {
        m mVar = uc.pr.get(str).get(1896449818);
        if (mVar == null) {
            throw new g("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
        }
        return pr(randomAccessFile, mVar, true).pr;
    }

    private static pr pr(RandomAccessFile randomAccessFile, m mVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferPr = uc.pr(mVar.pr);
                int i = 0;
                while (byteBufferPr.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(pr(uc.pr(byteBufferPr), arrayMap, certificateFactory));
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
                    uc.pr(arrayMap, randomAccessFile, mVar);
                }
                byte[] bArrPr = null;
                if (arrayMap.containsKey(3)) {
                    bArrPr = uc.pr((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                }
                return new pr((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), bArrPr);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] pr(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferPr = uc.pr(byteBuffer);
        ByteBuffer byteBufferPr2 = uc.pr(byteBuffer);
        byte[] bArrHw = uc.hw(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrHw2 = null;
        byte[] bArrHw3 = null;
        int i = -1;
        int i2 = 0;
        while (byteBufferPr2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferPr3 = uc.pr(byteBufferPr2);
                if (byteBufferPr3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferPr3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (pr(i3)) {
                    if (i == -1 || uc.pr(i3, i) > 0) {
                        bArrHw3 = uc.hw(byteBufferPr3);
                        i = i3;
                    }
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strHn = uc.hn(i);
        Pair<String, ? extends AlgorithmParameterSpec> pairX = uc.x(i);
        String str = (String) pairX.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairX.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strHn).generatePublic(new X509EncodedKeySpec(bArrHw));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferPr);
            if (!signature.verify(bArrHw3)) {
                throw new SecurityException(str + " signature did not verify");
            }
            byteBufferPr.clear();
            ByteBuffer byteBufferPr4 = uc.pr(byteBufferPr);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferPr4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferPr5 = uc.pr(byteBufferPr4);
                    if (byteBufferPr5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferPr5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i) {
                        bArrHw2 = uc.hw(byteBufferPr5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iPr = uc.pr(i);
            byte[] bArrPut = map.put(Integer.valueOf(iPr), bArrHw2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrHw2)) {
                throw new SecurityException(uc.hw(iPr) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferPr6 = uc.pr(byteBufferPr);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferPr6.hasRemaining()) {
                i6++;
                byte[] bArrHw4 = uc.hw(byteBufferPr6);
                try {
                    arrayList3.add(new nt((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHw4)), bArrHw4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrHw, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            pr(uc.pr(byteBufferPr));
            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void pr(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferPr = uc.pr(byteBuffer);
            if (byteBufferPr.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferPr.remaining());
            }
            switch (byteBufferPr.getInt()) {
                case -1091571699:
                    if (byteBufferPr.remaining() < 4) {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferPr.remaining());
                    }
                    if (byteBufferPr.getInt() == 3) {
                        throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                    }
                    break;
                    break;
            }
        }
    }

    private static boolean pr(int i) {
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
            case 513:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
            case 769:
            case 1057:
            case 1059:
            case 1061:
                return true;
            default:
                return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public final byte[] hw;
        public final X509Certificate[][] pr;

        public pr(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.pr = x509CertificateArr;
            this.hw = bArr;
        }
    }
}
