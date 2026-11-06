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
public class xr {
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

    public static X509Certificate[][] ms(RandomAccessFile randomAccessFile, String str) throws u, SecurityException, IOException {
        zb zbVar = c.f721ms.get(str).get(1896449818);
        if (zbVar == null) {
            throw new u("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
        }
        return ms(randomAccessFile, zbVar, true).f729ms;
    }

    private static ms ms(RandomAccessFile randomAccessFile, zb zbVar, boolean z) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferMs = c.ms(zbVar.f730ms);
                int i = 0;
                while (byteBufferMs.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(ms(c.ms(byteBufferMs), arrayMap, certificateFactory));
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
                    c.ms(arrayMap, randomAccessFile, zbVar);
                }
                return new ms((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? c.ms((byte[]) arrayMap.get(3), randomAccessFile.length(), zbVar) : null);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] ms(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferMs = c.ms(byteBuffer);
        ByteBuffer byteBufferMs2 = c.ms(byteBuffer);
        byte[] bArrXr = c.xr(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrXr2 = null;
        int i = 0;
        int i2 = -1;
        byte[] bArrXr3 = null;
        while (byteBufferMs2.hasRemaining()) {
            i++;
            try {
                ByteBuffer byteBufferMs3 = c.ms(byteBufferMs2);
                if (byteBufferMs3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferMs3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (ms(i3) && (i2 == -1 || c.ms(i3, i2) > 0)) {
                    bArrXr3 = c.xr(byteBufferMs3);
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
        String strAh = c.ah(i2);
        Pair<String, ? extends AlgorithmParameterSpec> pairD = c.d(i2);
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
            int i4 = 0;
            while (byteBufferMs4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferMs5 = c.ms(byteBufferMs4);
                    if (byteBufferMs5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferMs5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i2) {
                        bArrXr2 = c.xr(byteBufferMs5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iMs = c.ms(i2);
            byte[] bArrPut = map.put(Integer.valueOf(iMs), bArrXr2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrXr2)) {
                throw new SecurityException(c.xr(iMs) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferMs6 = c.ms(byteBufferMs);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferMs6.hasRemaining()) {
                i6++;
                byte[] bArrXr4 = c.xr(byteBufferMs6);
                try {
                    arrayList3.add(new ao((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrXr4)), bArrXr4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrXr, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            ms(c.ms(byteBufferMs));
            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void ms(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferMs = c.ms(byteBuffer);
            if (byteBufferMs.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferMs.remaining());
            }
            if (byteBufferMs.getInt() == -1091571699) {
                if (byteBufferMs.remaining() < 4) {
                    throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferMs.remaining());
                }
                if (byteBufferMs.getInt() == 3) {
                    throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final X509Certificate[][] f729ms;
        public final byte[] xr;

        public ms(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f729ms = x509CertificateArr;
            this.xr = bArr;
        }
    }
}
