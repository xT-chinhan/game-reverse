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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes3.dex */
public class CryptoUtils {
    public static final String DEFAULT_SECRETKEY_NAME = "default_secretkey_name";
    public static final String STORE_FILE_NAME = "crypto";
    private static final String TAG = "TapCryptoUtils";
    private static volatile CryptoUtils instance = null;
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
                TapLogger.logd(TAG, "First attempt failed, retrying... " + e.getMessage());
                try {
                    KeyStore keyStore2 = getKeyStore(file);
                    initKey(keyStore2, file);
                    instance = new CryptoUtils(keyStore2);
                } catch (Exception e1) {
                    TapLogger.loge(TAG, null, e1);
                    return null;
                }
            }
        }
        return instance;
    }

    private static void initKey(KeyStore keyStore, File file) throws Exception {
        if (!keyStore.containsAlias(DEFAULT_SECRETKEY_NAME)) {
            KeyGenerator keyGenerator = generateKeyGenerator();
            SecretKey secretKey = keyGenerator.generateKey();
            storeKey(keyStore, file, secretKey);
        }
    }

    private static void storeKey(KeyStore keyStore, File file, SecretKey secretKey) throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            keyStore.setKeyEntry(DEFAULT_SECRETKEY_NAME, secretKey, null, null);
            return;
        }
        keyStore.setKeyEntry(DEFAULT_SECRETKEY_NAME, secretKey, null, null);
        FileOutputStream fos = null;
        try {
            try {
                fos = new FileOutputStream(file);
                keyStore.store(fos, null);
                fos.close();
            } catch (Exception e) {
                TapLogger.logd(TAG, "Store key failed: " + e.getMessage());
                if (fos == null) {
                    return;
                }
            }
            fos.close();
        } catch (Throwable th) {
            if (fos != null) {
                fos.close();
            }
            throw th;
        }
    }

    private static KeyStore getKeyStore(File file) throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore;
        }
        KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
        if (!file.exists()) {
            boolean isSuccess = file.createNewFile();
            if (!isSuccess) {
                throw new SecurityException("创建内部存储文件失败");
            }
            keyStore2.load(null, null);
        } else if (file.length() <= 0) {
            keyStore2.load(null, null);
        } else {
            FileInputStream fis = null;
            try {
                try {
                    fis = new FileInputStream(file);
                    keyStore2.load(fis, null);
                    fis.close();
                } catch (Exception e) {
                    TapLogger.logd(TAG, "Load keystore failed: " + e.getMessage());
                    if (fis != null) {
                    }
                    return keyStore2;
                }
                fis.close();
            } catch (Throwable th) {
                if (fis != null) {
                    fis.close();
                }
                throw th;
            }
        }
        return keyStore2;
    }

    private static KeyGenerator generateKeyGenerator() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(DEFAULT_SECRETKEY_NAME, 3).setBlockModes("CBC").setUserAuthenticationRequired(false).setEncryptionPaddings("PKCS7Padding").build());
            return keyGenerator;
        }
        KeyGenerator keyGenerator2 = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        secureRandom.setSeed(generateSeed());
        keyGenerator2.init(128, secureRandom);
        return keyGenerator2;
    }

    private static byte[] generateSeed() {
        try {
            ByteArrayOutputStream seedBuffer = new ByteArrayOutputStream();
            DataOutputStream seedBufferOut = new DataOutputStream(seedBuffer);
            seedBufferOut.writeLong(System.currentTimeMillis());
            seedBufferOut.writeLong(System.nanoTime());
            seedBufferOut.writeInt(Process.myPid());
            seedBufferOut.writeInt(Process.myUid());
            seedBufferOut.write(Build.BOARD.getBytes());
            return seedBuffer.toByteArray();
        } catch (IOException e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    public String aesEncrypt(String content) {
        try {
            SecretKey secretKey = getSecretKey(this.keyStore);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKey);
            byte[] bytes = cipher.doFinal(StringUtils.string2BytesWithUTF8(content));
            return new EncryptData(Base64.encodeToString(bytes, 2), cipher.getIV()).toString();
        } catch (Exception e) {
            TapLogger.logd(TAG, "Encrypt failed: " + e.getMessage());
            return null;
        }
    }

    public String aesDecrypt(String data) {
        try {
            EncryptData encryptData = new EncryptData(data);
            SecretKey secretKey = getSecretKey(this.keyStore);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKey, new IvParameterSpec(encryptData.getIv()));
            byte[] bytes = cipher.doFinal(Base64.decode(encryptData.getEncryptString(), 2));
            return StringUtils.bytes2StringWithUTF8(bytes);
        } catch (Exception e) {
            TapLogger.logd(TAG, "Decrypt failed: " + e.getMessage());
            return null;
        }
    }

    private static SecretKey getSecretKey(KeyStore keyStore) {
        try {
            return (SecretKey) keyStore.getKey(DEFAULT_SECRETKEY_NAME, null);
        } catch (Exception e) {
            TapLogger.logd(TAG, "Get secret key failed: " + e.getMessage());
            return null;
        }
    }

    public static class EncryptData {
        String encryptString;
        byte[] iv;

        public EncryptData(String encryptString, byte[] iv) {
            this.encryptString = encryptString;
            this.iv = iv;
        }

        public EncryptData(String content) {
            if (!TextUtils.isEmpty(content)) {
                int iIndex = content.indexOf("[i]");
                this.encryptString = content.substring(0, iIndex);
                String ivStr = content.substring(iIndex + 3);
                this.iv = StringUtils.string2Bytes(ivStr);
            }
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

        public static String bytes2String(byte[] bytes) {
            return new String(bytes, StandardCharsets.ISO_8859_1);
        }

        public static byte[] string2Bytes(String content) {
            return content.getBytes(StandardCharsets.ISO_8859_1);
        }

        public static String bytes2StringWithUTF8(byte[] bytes) {
            return new String(bytes, StandardCharsets.UTF_8);
        }

        public static byte[] string2BytesWithUTF8(String content) {
            return content.getBytes(StandardCharsets.UTF_8);
        }
    }
}
