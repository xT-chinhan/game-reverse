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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 20})
public class hn {

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 116})
    private static class pr extends Exception {
    }

    public static C0125hn pr(RandomAccessFile randomAccessFile, String str) throws g, IOException {
        m mVar = uc.pr.get(str).get(-262969152);
        if (mVar == null) {
            throw new g("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
        }
        return pr(randomAccessFile, mVar, true);
    }

    private static C0125hn pr(RandomAccessFile randomAccessFile, m mVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferPr = uc.pr(mVar.pr);
                int i = 0;
                C0125hn c0125hnPr = null;
                while (byteBufferPr.hasRemaining()) {
                    try {
                        c0125hnPr = pr(uc.pr(byteBufferPr), arrayMap, certificateFactory);
                        i++;
                    } catch (pr e) {
                    } catch (IOException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0125hnPr == null) {
                    throw new SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    uc.pr(arrayMap, randomAccessFile, mVar);
                }
                if (arrayMap.containsKey(3)) {
                    c0125hnPr.hn = uc.pr((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                }
                return c0125hnPr;
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }

    private static C0125hn pr(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws pr, IOException, SecurityException {
        ByteBuffer byteBufferPr = uc.pr(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferPr2 = uc.pr(byteBuffer);
        byte[] bArrHw = uc.hw(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrHw2 = null;
        byte[] bArrHw3 = null;
        int i3 = -1;
        int i4 = 0;
        while (byteBufferPr2.hasRemaining()) {
            i4++;
            try {
                ByteBuffer byteBufferPr3 = uc.pr(byteBufferPr2);
                if (byteBufferPr3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i5 = byteBufferPr3.getInt();
                arrayList.add(Integer.valueOf(i5));
                if (pr(i5)) {
                    if (i3 == -1 || uc.pr(i5, i3) > 0) {
                        bArrHw3 = uc.hw(byteBufferPr3);
                        i3 = i5;
                    }
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i4)), e);
            }
        }
        if (i3 == -1) {
            if (i4 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strHn = uc.hn(i3);
        Pair<String, ? extends AlgorithmParameterSpec> pairX = uc.x(i3);
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
            int i6 = 0;
            while (byteBufferPr4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer byteBufferPr5 = uc.pr(byteBufferPr4);
                    if (byteBufferPr5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = byteBufferPr5.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    if (i7 == i3) {
                        bArrHw2 = uc.hw(byteBufferPr5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iPr = uc.pr(i3);
            byte[] bArrPut = map.put(Integer.valueOf(iPr), bArrHw2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrHw2)) {
                throw new SecurityException(uc.hw(iPr) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferPr6 = uc.pr(byteBufferPr);
            ArrayList arrayList3 = new ArrayList();
            int i8 = 0;
            while (byteBufferPr6.hasRemaining()) {
                i8++;
                byte[] bArrHw4 = uc.hw(byteBufferPr6);
                try {
                    arrayList3.add(new nt((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHw4)), bArrHw4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrHw, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            if (byteBufferPr.getInt() != i) {
                throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            if (byteBufferPr.getInt() != i2) {
                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            return pr(uc.pr(byteBufferPr), arrayList3, certificateFactory);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static C0125hn pr(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        hw hwVarPr = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferPr = uc.pr(byteBuffer);
            if (byteBufferPr.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferPr.remaining());
            }
            switch (byteBufferPr.getInt()) {
                case 1000370060:
                    if (hwVarPr != null) {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                    hwVarPr = pr(byteBufferPr, certificateFactory);
                    try {
                        if (hwVarPr.pr.size() > 0 && !Arrays.equals(hwVarPr.pr.get(hwVarPr.pr.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                            throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                        }
                    } catch (CertificateEncodingException e) {
                        throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                    }
                    break;
            }
        }
        return new C0125hn(x509CertificateArr, hwVarPr);
    }

    private static hw pr(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            nt ntVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferPr = uc.pr(byteBuffer);
                ByteBuffer byteBufferPr2 = uc.pr(byteBufferPr);
                int i3 = byteBufferPr.getInt();
                int i4 = byteBufferPr.getInt();
                byte[] bArrHw = uc.hw(byteBufferPr);
                if (ntVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairX = uc.x(i2);
                    PublicKey publicKey = ntVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairX.first);
                    signature.initVerify(publicKey);
                    if (pairX.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) pairX.second);
                    }
                    signature.update(byteBufferPr2);
                    if (!signature.verify(bArrHw)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairX.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferPr2.rewind();
                byte[] bArrHw2 = uc.hw(byteBufferPr2);
                int i5 = byteBufferPr2.getInt();
                if (ntVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                ntVar = new nt((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrHw2)), bArrHw2);
                if (hashSet.contains(ntVar)) {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(ntVar);
                arrayList.add(ntVar);
                arrayList2.add(Integer.valueOf(i3));
                i2 = i4;
            }
            return new hw(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
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

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 506})
    public static class hw {
        public final List<Integer> hw;
        public final List<X509Certificate> pr;

        public hw(List<X509Certificate> list, List<Integer> list2) {
            this.pr = list;
            this.hw = list2;
        }
    }

    /* JADX INFO: renamed from: com.byazt.lro.hn$hn, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET})
    public static class C0125hn {
        public byte[] hn;
        public final hw hw;
        public final X509Certificate[] pr;

        public C0125hn(X509Certificate[] x509CertificateArr, hw hwVar) {
            this.pr = x509CertificateArr;
            this.hw = hwVar;
        }
    }
}
