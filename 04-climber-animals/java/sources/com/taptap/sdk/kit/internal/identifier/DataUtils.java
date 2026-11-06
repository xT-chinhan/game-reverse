package com.taptap.sdk.kit.internal.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.CryptoUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
class DataUtils {
    private static final String ENCODE_PREFIX = "_encode_identify_prefix_";
    private static final String TAG = "DataUtils";

    DataUtils() {
    }

    private static String handleSecurityData(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return str2;
        }
        CryptoUtils cryptoUtils = CryptoUtils.getInstance(context);
        if (cryptoUtils != null) {
            if (str2.startsWith(ENCODE_PREFIX)) {
                String strAesDecrypt = cryptoUtils.aesDecrypt(str2.substring(24));
                if (strAesDecrypt == null) {
                    PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
                }
                return strAesDecrypt;
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, ENCODE_PREFIX + cryptoUtils.aesEncrypt(str2)).apply();
            return str2;
        }
        TapLogger.logd(TAG, " data should be decrypt but util is null");
        return str2.startsWith(ENCODE_PREFIX) ? "" : str2;
    }

    public static String getDeviceId(Context context) {
        String strHandleSecurityData;
        String strHandleSecurityData2;
        String string;
        String strHandleSecurityData3;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences != null) {
            String str = null;
            try {
                string = defaultSharedPreferences.getString("tapdb_game_mobile_identify", null);
                if (string != null) {
                    try {
                        string = handleSecurityData(context, "tapdb_game_mobile_identify", string);
                        if (string != null) {
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        TapLogger.loge(TAG, "getDeviceId", e);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                string = null;
            }
            Map<String, ?> all = defaultSharedPreferences.getAll();
            for (String str2 : all.keySet()) {
                if (str2.contains("__game_mobile__0__")) {
                    string = (String) all.get(str2);
                    str = str2;
                    break;
                }
            }
            if (string != null && (strHandleSecurityData3 = handleSecurityData(context, str, string)) != null) {
                return strHandleSecurityData3;
            }
        }
        String tapDBId = getTapDBId(TapIdentifierUtil.getAndroidID(context));
        if (!TextUtils.isEmpty(tapDBId) && tapDBId.length() <= 256 && (strHandleSecurityData2 = handleSecurityData(context, "tapdb_game_mobile_identify", tapDBId)) != null) {
            return strHandleSecurityData2;
        }
        String string2 = UUID.randomUUID().toString();
        return (TextUtils.isEmpty(string2) || string2.length() > 256 || (strHandleSecurityData = handleSecurityData(context, "tapdb_game_mobile_identify", string2)) == null) ? string2 : strHandleSecurityData;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    private static String getTapDBId(String str) {
        String[] strArr = {"0000000000000000", "ffffffffffffffff"};
        if (str != null) {
            if (str.matches("^[0-9a-zA-Z]{8,16}$")) {
                int length = str.length();
                if (length < 16) {
                    for (int i = 0; i < 16 - length; i++) {
                        str = "0" + str;
                    }
                }
                if (Arrays.asList(strArr).contains(str)) {
                    str = null;
                }
            } else {
                str = null;
            }
        }
        return str != null ? str : UUID.randomUUID().toString();
    }
}
