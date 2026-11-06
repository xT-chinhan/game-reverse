package com.taptap.sdk.kit.internal.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.taptap.sdk.kit.internal.TapLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class CryptoUtils {
    public static final String DEFAULT_SECRETKEY_NAME = "default_secretkey_name";
    public static final String STORE_FILE_NAME = "crypto";
    private static final String TAG = "TapCryptoUtils";
    private static volatile CryptoUtils instance;
    private KeyStore keyStore;

    private CryptoUtils(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    public static synchronized CryptoUtils getInstance(Context context) {
        if (instance == null) {
            File file = new File(context.getFilesDir(), STORE_FILE_NAME);
            try {
                KeyStore keyStore = getKeyStore(file);
                initKey(keyStore, file);
                instance = new CryptoUtils(keyStore);
            } catch (Exception e) {
                TapLogger.loge(TAG, null, e);
                try {
                    KeyStore keyStore2 = getKeyStore(file);
                    initKey(keyStore2, file);
                    instance = new CryptoUtils(keyStore2);
                } catch (Exception e2) {
                    TapLogger.loge(TAG, null, e2);
                    return null;
                }
            }
        }
        return instance;
    }

    private static void initKey(KeyStore keyStore, File file) throws Exception {
        if (keyStore.containsAlias(DEFAULT_SECRETKEY_NAME)) {
            return;
        }
        storeKey(keyStore, file, generateKeyGenerator().generateKey());
    }

    private static void storeKey(KeyStore keyStore, File file, SecretKey secretKey) throws Exception {
        keyStore.setKeyEntry(DEFAULT_SECRETKEY_NAME, secretKey, null, null);
    }

    private static KeyStore getKeyStore(File file) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    private static KeyGenerator generateKeyGenerator() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(DEFAULT_SECRETKEY_NAME, 3).setBlockModes("CBC").setUserAuthenticationRequired(false).setEncryptionPaddings("PKCS7Padding").build());
        return keyGenerator;
    }

    private static byte[] generateSeed() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(Build.BOARD.getBytes());
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    public String aesEncrypt(String str) {
        try {
            SecretKey secretKey = getSecretKey(this.keyStore);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKey);
            return new EncryptData(Base64.encodeToString(cipher.doFinal(StringUtils.string2BytesWithUTF8(str)), 2), cipher.getIV()).toString();
        } catch (Exception e) {
            TapLogger.loge(TAG, null, e);
            return null;
        }
    }

    public String aesDecrypt(String str) {
        try {
            EncryptData encryptData = new EncryptData(str);
            SecretKey secretKey = getSecretKey(this.keyStore);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKey, new IvParameterSpec(encryptData.getIv()));
            return StringUtils.bytes2StringWithUTF8(cipher.doFinal(Base64.decode(encryptData.getEncryptString(), 2)));
        } catch (Exception e) {
            TapLogger.loge(TAG, "aesDecrypt", e);
            return null;
        }
    }

    private static SecretKey getSecretKey(KeyStore keyStore) {
        try {
            return (SecretKey) keyStore.getKey(DEFAULT_SECRETKEY_NAME, null);
        } catch (Exception e) {
            TapLogger.loge(TAG, null, e);
            return null;
        }
    }

    public static class EncryptData {
        String encryptString;
        byte[] iv;

        public EncryptData(String str, byte[] bArr) {
            this.encryptString = str;
            this.iv = bArr;
        }

        public EncryptData(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIndexOf = str.indexOf("[i]");
            this.encryptString = str.substring(0, iIndexOf);
            this.iv = StringUtils.string2Bytes(str.substring(iIndexOf + 3));
        }

        public byte[] getIv() {
            return this.iv;
        }

        public String getEncryptString() {
            return this.encryptString;
        }

        public String toString() {
            return this.encryptString + "[i]" + StringUtils.bytes2String(this.iv);
        }
    }

    private static class StringUtils {
        private StringUtils() {
        }

        public static String bytes2String(byte[] bArr) {
            return new String(bArr, StandardCharsets.ISO_8859_1);
        }

        public static byte[] string2Bytes(String str) {
            return str.getBytes(StandardCharsets.ISO_8859_1);
        }

        public static String bytes2StringWithUTF8(byte[] bArr) {
            return new String(bArr, StandardCharsets.UTF_8);
        }

        public static byte[] string2BytesWithUTF8(String str) {
            return str.getBytes(StandardCharsets.UTF_8);
        }
    }
}
