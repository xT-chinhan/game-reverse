package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.oaid.OAIDErrorReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
class OAIDSafeSharedPreference {
    private static final String GAID_KEY = "td_c7a3";
    private static final String LEGACY_GAID_KEY = "GAID";
    private static final String LEGACY_MSA_OAID_KEY = "MSA_OAID";
    private static final String LEGACY_OAID_KEY = "TapAD_OAID";
    private static final String MSA_OAID_KEY = "td_c7a2";
    private static final String OAID_ERROR_MSG_IS_PUSH_KEY = "TapAD_OAID_ERROR_IS_PUSH";
    private static final String OAID_ERROR_MSG_KEY = "TapAD_OAID_ERROR";
    private static final String OAID_KEY = "td_c7a1";
    private static final String OAID_SP_NAME_KEY = "TapAD_OAID_Manufacturer_SP_NAME";
    private static final String OAID_UNSUPPORTED_IS_PUSH_KEY = "TapAD_OAID_UNSUPPORTED_IS_PUSH";
    private static final String OAID_UNSUPPORTED_MSG_KEY = "TapAD_OAID_UNSUPPORTED_MSG";
    private final String encryptionKey;
    private OAIDErrorReporter errorReporter;
    final SharedPreferences sharedPreferences;

    public OAIDSafeSharedPreference(Context context) {
        this.sharedPreferences = context.getSharedPreferences(OAID_SP_NAME_KEY, 0);
        this.encryptionKey = OAIDCrypto.deriveKey(context.getPackageName());
    }

    private String readEncryptedOrMigrate(String str, String str2) {
        String strDecrypt;
        if (this.sharedPreferences.contains(str)) {
            String string = this.sharedPreferences.getString(str, "");
            return (TextUtils.isEmpty(string) || (strDecrypt = OAIDCrypto.decrypt(string, this.encryptionKey)) == null) ? "" : strDecrypt;
        }
        String string2 = this.sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string2)) {
            return "";
        }
        String strEncrypt = OAIDCrypto.encrypt(string2, this.encryptionKey);
        if (strEncrypt != null) {
            this.sharedPreferences.edit().putString(str, strEncrypt).remove(str2).commit();
        }
        return string2;
    }

    private void writeEncrypted(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.sharedPreferences.edit().putString(str, str2).apply();
            return;
        }
        String strEncrypt = OAIDCrypto.encrypt(str2, this.encryptionKey);
        if (strEncrypt != null) {
            this.sharedPreferences.edit().putString(str, strEncrypt).apply();
        }
    }

    public String getGAID() {
        return readEncryptedOrMigrate(GAID_KEY, LEGACY_GAID_KEY);
    }

    public String getMSAOAID() {
        return readEncryptedOrMigrate(MSA_OAID_KEY, LEGACY_MSA_OAID_KEY);
    }

    public String getOAID() {
        return readEncryptedOrMigrate(OAID_KEY, LEGACY_OAID_KEY);
    }

    public void reportOAIDError(String str) {
        String strA = c.a("oaid error: ", str);
        if (this.sharedPreferences.getBoolean(OAID_ERROR_MSG_IS_PUSH_KEY, false) && TextUtils.equals(this.sharedPreferences.getString(OAID_ERROR_MSG_KEY, ""), strA)) {
            return;
        }
        this.sharedPreferences.edit().putBoolean(OAID_ERROR_MSG_IS_PUSH_KEY, false).apply();
        this.sharedPreferences.edit().putString(OAID_ERROR_MSG_KEY, "").apply();
        HashMap map = new HashMap();
        map.put("oaid_error", strA);
        OAIDErrorReporter oAIDErrorReporter = this.errorReporter;
        if (oAIDErrorReporter != null && oAIDErrorReporter.sendLog(map)) {
            this.sharedPreferences.edit().putBoolean(OAID_ERROR_MSG_IS_PUSH_KEY, true).apply();
            this.sharedPreferences.edit().putString(OAID_ERROR_MSG_KEY, strA).apply();
        }
    }

    public void reportOAIDUnsupported(String str) {
        String strA = c.a("oaid unsupported: ", str);
        if (this.sharedPreferences.getBoolean(OAID_UNSUPPORTED_IS_PUSH_KEY, false) && TextUtils.equals(this.sharedPreferences.getString(OAID_UNSUPPORTED_MSG_KEY, ""), strA)) {
            return;
        }
        this.sharedPreferences.edit().putBoolean(OAID_UNSUPPORTED_IS_PUSH_KEY, false).apply();
        this.sharedPreferences.edit().putString(OAID_UNSUPPORTED_MSG_KEY, strA).apply();
        if (this.errorReporter == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("oaid_unsupported: ", strA);
        if (this.errorReporter.sendLog(map)) {
            this.sharedPreferences.edit().putBoolean(OAID_UNSUPPORTED_IS_PUSH_KEY, true).apply();
            this.sharedPreferences.edit().putString(OAID_UNSUPPORTED_MSG_KEY, strA).apply();
        }
    }

    public void setGaidKey(String str) {
        writeEncrypted(GAID_KEY, str);
    }

    public void setMsaOaidKey(String str) {
        writeEncrypted(MSA_OAID_KEY, str);
    }

    public void setOAID(String str) {
        writeEncrypted(OAID_KEY, str);
    }

    public OAIDSafeSharedPreference(Context context, OAIDErrorReporter oAIDErrorReporter) {
        this.sharedPreferences = context.getSharedPreferences(OAID_SP_NAME_KEY, 0);
        this.errorReporter = oAIDErrorReporter;
        this.encryptionKey = OAIDCrypto.deriveKey(context.getPackageName());
    }
}
