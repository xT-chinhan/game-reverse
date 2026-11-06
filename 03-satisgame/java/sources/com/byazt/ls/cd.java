package com.byazt.ls;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 86})
public class cd extends X509Certificate {
    public final X509Certificate n;

    public cd(X509Certificate x509Certificate) {
        this.n = x509Certificate;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        return this.n.getCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return this.n.getExtensionValue(str);
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        return this.n.getNonCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        return this.n.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        this.n.checkValidity();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        this.n.checkValidity(date);
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.n.getVersion();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.n.getSerialNumber();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.n.getIssuerDN();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.n.getSubjectDN();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.n.getNotBefore();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.n.getNotAfter();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.n.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.n.getSignature();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.n.getSigAlgName();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.n.getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.n.getSigAlgParams();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        return this.n.getIssuerUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        return this.n.getSubjectUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.n.getKeyUsage();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        return this.n.getBasicConstraints();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.n.getEncoded();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.n.verify(publicKey);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        this.n.verify(publicKey, str);
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.n.toString();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return this.n.getPublicKey();
    }
}
