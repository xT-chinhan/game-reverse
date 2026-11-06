package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tapsdk.tapad.oaid.impl.OAIDCrypto;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class AdnDeviceManager {
    static final int EID_FORMAT_V1 = 1;
    public static final String KEY_ADN_DID = "deviceInfo_adn_did";
    public static final String KEY_ANDROID_ID = "deviceInfo_android_id";
    public static final String KEY_EID = "deviceInfo_eid";
    static final String KEY_EID_FORMAT = "deviceInfo_eid_format";
    private static final String KEY_SERIAL = "deviceInfo_serial_encrypted";
    static final String LEGACY_EID_KEY = "eid";
    static final String LEGACY_EID_SP_NAME = "ionia_security";
    public static final String SP_NAME = "dirichlet_device_http_infos_cache";
    private static final String TAG = "AdnDeviceManager";
    private static volatile AdnDeviceManager instance;
    private final Context appContext;
    private volatile String cachedAdnDid;
    private volatile String cachedAndroidId;
    private volatile String cachedEid;
    private volatile String cachedSerial;
    private final Object lock = new Object();

    private AdnDeviceManager(Context context) {
        this.appContext = context.getApplicationContext();
    }

    private void clearStoredEid() {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(SP_NAME, 0).edit().remove(KEY_EID).remove(KEY_EID_FORMAT).commit();
        } catch (Throwable th) {
        }
    }

    private void dropLegacyEidStore() {
        Context context = this.appContext;
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                context.deleteSharedPreferences(LEGACY_EID_SP_NAME);
                return;
            }
            context.getSharedPreferences(LEGACY_EID_SP_NAME, 0).edit().clear().commit();
            File file = new File(this.appContext.getApplicationInfo().dataDir, "shared_prefs");
            File file2 = new File(file, "ionia_security.xml");
            File file3 = new File(file, "ionia_security.xml.bak");
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
        } catch (Throwable th) {
        }
    }

    private String eidKey() {
        Context context = this.appContext;
        if (context == null) {
            return null;
        }
        return OAIDCrypto.deriveKey(context.getPackageName());
    }

    public static AdnDeviceManager getInstance(Context context) {
        if (instance == null) {
            synchronized (AdnDeviceManager.class) {
                if (instance == null) {
                    instance = new AdnDeviceManager(context);
                }
            }
        }
        return instance;
    }

    public static boolean isValidEid(String str) {
        if (str == null || str.length() != 36 || !str.startsWith("eid_")) {
            return false;
        }
        for (int i = 4; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'a' || cCharAt > 'f')) {
                return false;
            }
        }
        return true;
    }

    private int readEidFormat() {
        Context context = this.appContext;
        if (context == null) {
            return -1;
        }
        try {
            return context.getSharedPreferences(SP_NAME, 0).getInt(KEY_EID_FORMAT, 0);
        } catch (Throwable th) {
            return -1;
        }
    }

    private String readLegacyEid() {
        Context context = this.appContext;
        if (context == null) {
            return "";
        }
        try {
            String string = context.getSharedPreferences(LEGACY_EID_SP_NAME, 0).getString(LEGACY_EID_KEY, "");
            return string == null ? "" : string;
        } catch (Throwable th) {
            return "";
        }
    }

    private String readStoredEid() {
        String string = readString(KEY_EID);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        int eidFormat = readEidFormat();
        if (eidFormat == 1) {
            String strDecrypt = OAIDCrypto.decrypt(string, eidKey());
            if (isValidEid(strDecrypt)) {
                return strDecrypt;
            }
            clearStoredEid();
            return "";
        }
        if (eidFormat != 0) {
            clearStoredEid();
            return "";
        }
        String strDecrypt2 = OAIDCrypto.decrypt(string, eidKey());
        if (isValidEid(strDecrypt2)) {
            writeCiphertextV1(string);
            return strDecrypt2;
        }
        if (isValidEid(string)) {
            writeEncryptedEid(string);
            return string;
        }
        clearStoredEid();
        return "";
    }

    private String readString(String str) {
        Context context = this.appContext;
        if (context == null) {
            return "";
        }
        try {
            String string = context.getSharedPreferences(SP_NAME, 0).getString(str, "");
            return string == null ? "" : string;
        } catch (Throwable th) {
            return "";
        }
    }

    private boolean writeCiphertextV1(String str) {
        Context context = this.appContext;
        if (context == null) {
            return false;
        }
        try {
            return context.getSharedPreferences(SP_NAME, 0).edit().putString(KEY_EID, str).putInt(KEY_EID_FORMAT, 1).commit();
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean writeEncryptedEid(String str) {
        String strEncrypt = OAIDCrypto.encrypt(str, eidKey());
        if (strEncrypt == null) {
            return false;
        }
        return writeCiphertextV1(strEncrypt);
    }

    private boolean writeString(String str, String str2) {
        Context context = this.appContext;
        if (context == null) {
            return false;
        }
        try {
            context.getSharedPreferences(SP_NAME, 0).edit().putString(str, str2).apply();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void clearCache() {
        synchronized (this.lock) {
            this.cachedAdnDid = null;
            this.cachedAndroidId = null;
            this.cachedSerial = null;
            this.cachedEid = null;
        }
    }

    public String getAdnDid() {
        if (this.cachedAdnDid != null) {
            return this.cachedAdnDid;
        }
        synchronized (this.lock) {
            if (this.cachedAdnDid != null) {
                return this.cachedAdnDid;
            }
            Context context = this.appContext;
            if (context == null) {
                return "";
            }
            try {
                String string = context.getSharedPreferences(SP_NAME, 0).getString(KEY_ADN_DID, "");
                this.cachedAdnDid = string;
                TextUtils.isEmpty(string);
                return string;
            } catch (Throwable th) {
                return "";
            }
        }
    }

    public String getAndroidId() {
        if (this.cachedAndroidId != null) {
            return this.cachedAndroidId;
        }
        synchronized (this.lock) {
            if (this.cachedAndroidId != null) {
                return this.cachedAndroidId;
            }
            String string = readString(KEY_ANDROID_ID);
            this.cachedAndroidId = string;
            return string;
        }
    }

    public String getEid() {
        if (this.cachedEid != null) {
            return this.cachedEid;
        }
        synchronized (this.lock) {
            if (this.cachedEid != null) {
                return this.cachedEid;
            }
            String storedEid = readStoredEid();
            if (TextUtils.isEmpty(storedEid)) {
                storedEid = readLegacyEid();
                if (isValidEid(storedEid)) {
                    if (writeEncryptedEid(storedEid)) {
                        dropLegacyEidStore();
                    }
                    this.cachedEid = storedEid;
                    return storedEid;
                }
            }
            dropLegacyEidStore();
            if (!isValidEid(storedEid)) {
                storedEid = "";
            }
            this.cachedEid = storedEid;
            return this.cachedEid;
        }
    }

    public String getSerial() {
        String str;
        synchronized (this.lock) {
            if (this.cachedSerial == null) {
                String string = readString(KEY_SERIAL);
                String strDecrypt = TextUtils.isEmpty(string) ? "" : OAIDCrypto.decrypt(string, eidKey());
                if (strDecrypt == null) {
                    strDecrypt = "";
                }
                this.cachedSerial = strDecrypt;
            }
            str = this.cachedSerial;
        }
        return str;
    }

    public void saveAdnDid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.lock) {
            Context context = this.appContext;
            if (context == null) {
                return;
            }
            try {
                context.getSharedPreferences(SP_NAME, 0).edit().putString(KEY_ADN_DID, str).apply();
                this.cachedAdnDid = str;
            } catch (Throwable th) {
            }
        }
    }

    public void saveAndroidId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.lock) {
            if (writeString(KEY_ANDROID_ID, str)) {
                this.cachedAndroidId = str;
            }
        }
    }

    public void saveEid(String str) {
        if (isValidEid(str)) {
            synchronized (this.lock) {
                if (writeEncryptedEid(str)) {
                    this.cachedEid = str;
                    dropLegacyEidStore();
                }
            }
        }
    }

    public void saveSerial(String str) {
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str)) {
            return;
        }
        synchronized (this.lock) {
            String strEncrypt = OAIDCrypto.encrypt(str, eidKey());
            if (!TextUtils.isEmpty(strEncrypt) && writeString(KEY_SERIAL, strEncrypt)) {
                this.cachedSerial = str;
            }
        }
    }
}
