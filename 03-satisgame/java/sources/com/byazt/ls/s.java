package com.byazt.ls;

import android.util.ArrayMap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
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
@com.byazt.cp.n(n = {0, 1, 32, 8})
public class s {

    @com.byazt.cp.n(n = {0, 1, 32, 546})
    private static class n extends Exception {
    }

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

    public static C0241s n(RandomAccessFile randomAccessFile, String str) throws sz, IOException {
        oa oaVar = w.n.get(str).get(-262969152);
        if (oaVar == null) {
            throw new sz("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
        }
        return n(randomAccessFile, oaVar, true);
    }

    private static C0241s n(RandomAccessFile randomAccessFile, oa oaVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferN = w.n(oaVar.n);
                int i = 0;
                C0241s c0241sN = null;
                while (byteBufferN.hasRemaining()) {
                    try {
                        c0241sN = n(w.n(byteBufferN), arrayMap, certificateFactory);
                        i++;
                    } catch (n unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0241sN == null) {
                    throw new SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    w.n(arrayMap, randomAccessFile, oaVar);
                }
                if (arrayMap.containsKey(3)) {
                    c0241sN.s = w.n((byte[]) arrayMap.get(3), randomAccessFile.length(), oaVar);
                }
                return c0241sN;
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0241s n(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws n, IOException, SecurityException {
        ByteBuffer byteBufferN = w.n(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferN2 = w.n(byteBuffer);
        byte[] bArrQg = w.qg(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrQg2 = null;
        int i3 = 0;
        int i4 = -1;
        byte[] bArrQg3 = null;
        while (byteBufferN2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferN3 = w.n(byteBufferN2);
                if (byteBufferN3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i5 = byteBufferN3.getInt();
                arrayList.add(Integer.valueOf(i5));
                if (n(i5) && (i4 == -1 || w.n(i5, i4) > 0)) {
                    bArrQg3 = w.qg(byteBufferN3);
                    i4 = i5;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e);
            }
        }
        if (i4 == -1) {
            if (i3 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strS = w.s(i4);
        Pair<String, ? extends AlgorithmParameterSpec> pairQ = w.q(i4);
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
            int i6 = 0;
            while (byteBufferN4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer byteBufferN5 = w.n(byteBufferN4);
                    if (byteBufferN5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = byteBufferN5.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    if (i7 == i4) {
                        bArrQg2 = w.qg(byteBufferN5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iN = w.n(i4);
            byte[] bArrPut = map.put(Integer.valueOf(iN), bArrQg2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrQg2)) {
                throw new SecurityException(w.qg(iN) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferN6 = w.n(byteBufferN);
            ArrayList arrayList3 = new ArrayList();
            int i8 = 0;
            while (byteBufferN6.hasRemaining()) {
                i8++;
                byte[] bArrQg4 = w.qg(byteBufferN6);
                try {
                    arrayList3.add(new cy((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrQg4)), bArrQg4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrQg, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            if (byteBufferN.getInt() != i) {
                throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            if (byteBufferN.getInt() != i2) {
                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            return n(w.n(byteBufferN), arrayList3, certificateFactory);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static C0241s n(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        qg qgVarN = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferN = w.n(byteBuffer);
            if (byteBufferN.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferN.remaining());
            }
            if (byteBufferN.getInt() == 1000370060) {
                if (qgVarN != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                qgVarN = n(byteBufferN, certificateFactory);
                try {
                    if (qgVarN.n.size() > 0 && !Arrays.equals(qgVarN.n.get(qgVarN.n.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                    }
                } catch (CertificateEncodingException e) {
                    throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new C0241s(x509CertificateArr, qgVarN);
    }

    private static qg n(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            cy cyVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferN = w.n(byteBuffer);
                ByteBuffer byteBufferN2 = w.n(byteBufferN);
                int i3 = byteBufferN.getInt();
                int i4 = byteBufferN.getInt();
                byte[] bArrQg = w.qg(byteBufferN);
                if (cyVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairQ = w.q(i2);
                    PublicKey publicKey = cyVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairQ.first);
                    signature.initVerify(publicKey);
                    if (pairQ.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) pairQ.second);
                    }
                    signature.update(byteBufferN2);
                    if (!signature.verify(bArrQg)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairQ.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferN2.rewind();
                byte[] bArrQg2 = w.qg(byteBufferN2);
                int i5 = byteBufferN2.getInt();
                if (cyVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                cyVar = new cy((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrQg2)), bArrQg2);
                if (hashSet.contains(cyVar)) {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(cyVar);
                arrayList.add(cyVar);
                arrayList2.add(Integer.valueOf(i3));
                i2 = i4;
            }
            return new qg(arrayList, arrayList2);
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

    @com.byazt.cp.n(n = {0, 1, 32, 782})
    public static class qg {
        public final List<X509Certificate> n;
        public final List<Integer> qg;

        public qg(List<X509Certificate> list, List<Integer> list2) {
            this.n = list;
            this.qg = list2;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ls.s$s, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 32, ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR})
    public static class C0241s {
        public final X509Certificate[] n;
        public final qg qg;
        public byte[] s;

        public C0241s(X509Certificate[] x509CertificateArr, qg qgVar) {
            this.n = x509CertificateArr;
            this.qg = qgVar;
        }
    }
}
