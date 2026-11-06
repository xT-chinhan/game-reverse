package com.bytedance.pangle.x;

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
public class ah {

    private static class ms extends Exception {
    }

    private static boolean ms(int i) {
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

    public static C0228ah ms(RandomAccessFile randomAccessFile, String str) throws u, IOException {
        zb zbVar = c.f721ms.get(str).get(-262969152);
        if (zbVar == null) {
            throw new u("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
        }
        return ms(randomAccessFile, zbVar, true);
    }

    private static C0228ah ms(RandomAccessFile randomAccessFile, zb zbVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferMs = c.ms(zbVar.f730ms);
                int i = 0;
                C0228ah c0228ahMs = null;
                while (byteBufferMs.hasRemaining()) {
                    try {
                        c0228ahMs = ms(c.ms(byteBufferMs), arrayMap, certificateFactory);
                        i++;
                    } catch (ms unused) {
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
                if (i <= 0 || c0228ahMs == null) {
                    throw new SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z) {
                    c.ms(arrayMap, randomAccessFile, zbVar);
                }
                if (arrayMap.containsKey(3)) {
                    c0228ahMs.ah = c.ms((byte[]) arrayMap.get(3), randomAccessFile.length(), zbVar);
                }
                return c0228ahMs;
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0228ah ms(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException, ms {
        ByteBuffer byteBufferMs = c.ms(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferMs2 = c.ms(byteBuffer);
        byte[] bArrXr = c.xr(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrXr2 = null;
        int i3 = 0;
        int i4 = -1;
        byte[] bArrXr3 = null;
        while (byteBufferMs2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferMs3 = c.ms(byteBufferMs2);
                if (byteBufferMs3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i5 = byteBufferMs3.getInt();
                arrayList.add(Integer.valueOf(i5));
                if (ms(i5) && (i4 == -1 || c.ms(i5, i4) > 0)) {
                    bArrXr3 = c.xr(byteBufferMs3);
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
        String strAh = c.ah(i4);
        Pair<String, ? extends AlgorithmParameterSpec> pairD = c.d(i4);
        String str = (String) pairD.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairD.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strAh).generatePublic(new X509EncodedKeySpec(bArrXr));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferMs);
            if (!signature.verify(bArrXr3)) {
                throw new SecurityException(str + " signature did not verify");
            }
            byteBufferMs.clear();
            ByteBuffer byteBufferMs4 = c.ms(byteBufferMs);
            ArrayList arrayList2 = new ArrayList();
            int i6 = 0;
            while (byteBufferMs4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer byteBufferMs5 = c.ms(byteBufferMs4);
                    if (byteBufferMs5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = byteBufferMs5.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    if (i7 == i4) {
                        bArrXr2 = c.xr(byteBufferMs5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iMs = c.ms(i4);
            byte[] bArrPut = map.put(Integer.valueOf(iMs), bArrXr2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrXr2)) {
                throw new SecurityException(c.xr(iMs) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferMs6 = c.ms(byteBufferMs);
            ArrayList arrayList3 = new ArrayList();
            int i8 = 0;
            while (byteBufferMs6.hasRemaining()) {
                i8++;
                byte[] bArrXr4 = c.xr(byteBufferMs6);
                try {
                    arrayList3.add(new ao((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrXr4)), bArrXr4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrXr, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            if (byteBufferMs.getInt() != i) {
                throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            if (byteBufferMs.getInt() != i2) {
                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            return ms(c.ms(byteBufferMs), arrayList3, certificateFactory);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static C0228ah ms(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        xr xrVarMs = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferMs = c.ms(byteBuffer);
            if (byteBufferMs.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferMs.remaining());
            }
            if (byteBufferMs.getInt() == 1000370060) {
                if (xrVarMs != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                xrVarMs = ms(byteBufferMs, certificateFactory);
                try {
                    if (xrVarMs.f719ms.size() > 0 && !Arrays.equals(xrVarMs.f719ms.get(xrVarMs.f719ms.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                    }
                } catch (CertificateEncodingException e) {
                    throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new C0228ah(x509CertificateArr, xrVarMs);
    }

    private static xr ms(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            ao aoVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferMs = c.ms(byteBuffer);
                ByteBuffer byteBufferMs2 = c.ms(byteBufferMs);
                int i3 = byteBufferMs.getInt();
                int i4 = byteBufferMs.getInt();
                byte[] bArrXr = c.xr(byteBufferMs);
                if (aoVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairD = c.d(i2);
                    PublicKey publicKey = aoVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairD.first);
                    signature.initVerify(publicKey);
                    if (pairD.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) pairD.second);
                    }
                    signature.update(byteBufferMs2);
                    if (!signature.verify(bArrXr)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairD.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferMs2.rewind();
                byte[] bArrXr2 = c.xr(byteBufferMs2);
                int i5 = byteBufferMs2.getInt();
                if (aoVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                aoVar = new ao((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrXr2)), bArrXr2);
                if (hashSet.contains(aoVar)) {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(aoVar);
                arrayList.add(aoVar);
                arrayList2.add(Integer.valueOf(i3));
                i2 = i4;
            }
            return new xr(arrayList, arrayList2);
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

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final List<X509Certificate> f719ms;
        public final List<Integer> xr;

        public xr(List<X509Certificate> list, List<Integer> list2) {
            this.f719ms = list;
            this.xr = list2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.x.ah$ah, reason: collision with other inner class name */
    public static class C0228ah {
        public byte[] ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final X509Certificate[] f718ms;
        public final xr xr;

        public C0228ah(X509Certificate[] x509CertificateArr, xr xrVar) {
            this.f718ms = x509CertificateArr;
            this.xr = xrVar;
        }
    }
}
