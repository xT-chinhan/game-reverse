package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.basesec.BasesecFragment0;
import com.kwad.sdk.utils.basesec.BasesecFragment1;
import com.kwad.sdk.utils.basesec.BasesecFragment2;
import com.kwad.sdk.utils.basesec.KeyRecoveryUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
public class LiteEncryptUtils {
    public static final String KEY_AES = "aes_key";
    public static final String KEY_PRIVATE = "rsa_private_key";
    public static final String KEY_PUBLISH = "rsa_public_key";
    public static final String TAG = "EncryptUtils";
    private static volatile String sAESKey = "";
    private static volatile String sRSEPrivateKey = "";
    private static volatile String sRSEPublicKey = "";

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EncryptKeyType {
        public static final int TYPE_AES_KEY = 0;
        public static final int TYPE_RES_PRIVATE_KEY = 2;
        public static final int TYPE_RES_PUBLIC_KEY = 1;
        public static final int TYPE_UNKNOWN = -1;
    }

    public static String getKey(Context context, int i) {
        return getKey(i);
    }

    public static String getKey(int i) {
        if (i == 0) {
            if (!TextUtils.isEmpty(sAESKey)) {
                return sAESKey;
            }
            sAESKey = KeyRecoveryUtils.recoverToString(BasesecFragment0.getAesFragment(), BasesecFragment1.getAesFragment(), BasesecFragment2.getAesFragment());
            logIfInvalid(sAESKey, "TYPE_AES_KEY");
            return sAESKey;
        }
        if (i == 1) {
            if (!TextUtils.isEmpty(sRSEPublicKey)) {
                return sRSEPublicKey;
            }
            sRSEPublicKey = KeyRecoveryUtils.recoverToString(BasesecFragment0.getRsaPubFragment(), BasesecFragment1.getRsaPubFragment(), BasesecFragment2.getRsaPubFragment());
            logIfInvalid(sRSEPublicKey, "TYPE_RES_PUBLIC_KEY");
            return sRSEPublicKey;
        }
        if (i == 2) {
            if (!TextUtils.isEmpty(sRSEPrivateKey)) {
                return sRSEPrivateKey;
            }
            sRSEPrivateKey = KeyRecoveryUtils.recoverToString(BasesecFragment0.getRsaPrvFragment(), BasesecFragment1.getRsaPrvFragment(), BasesecFragment2.getRsaPrvFragment());
            logIfInvalid(sRSEPrivateKey, "TYPE_RES_PRIVATE_KEY");
            return sRSEPrivateKey;
        }
        Log.e(TAG, "LiteEncryptUtils getKey unknown type: " + i);
        return "";
    }

    private static void logIfInvalid(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "LiteEncryptUtils getKey invalid: " + str2);
        }
    }
}
