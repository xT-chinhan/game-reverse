package com.taptap.sdk.db.event.utils;

import android.os.Looper;
import com.anythink.core.common.f.e;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.exception.TapInvalidDataException;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.serialization.json.JsonNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapCoreKit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/db/event/utils/TapCoreKit;", "", "()V", "MAX_LENGTH", "", "isMainThread", "", "()Z", "assertEventName", "", "eventName", "", "assertIsNotMainThread", "assertUserId", "userId", "checkKey", "errorTitle", e.a.b, "checkValue", e.a.d, "filterProperties", "dynamicProperties", "Lorg/json/JSONObject;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapCoreKit {
    public static final TapCoreKit INSTANCE = new TapCoreKit();
    private static final int MAX_LENGTH = 256;

    private TapCoreKit() {
    }

    @JvmStatic
    public static final void assertIsNotMainThread() {
        if (INSTANCE.isMainThread()) {
            throw new AssertionError("Call cannot be made on the main thread");
        }
    }

    public final void assertUserId(String userId) throws TapInvalidDataException {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String str = userId;
        if (!new Regex("^[a-zA-Z0-9_\\-+/=.,:]{1,160}$").matches(str)) {
            throw new TapInvalidDataException("The userId must match [^[a-zA-Z0-9_\\-+/=.,:]{1,160}$]");
        }
        if (str.length() == 0) {
            throw new TapInvalidDataException("The userId is empty.");
        }
        if (userId.length() > 160) {
            throw new TapInvalidDataException("The userId is too long, max length is 160.");
        }
    }

    @JvmStatic
    public static final void assertEventName(String eventName) {
        String str = eventName;
        if (str == null || str.length() == 0) {
            throw new TapInvalidDataException("The eventName is empty.");
        }
        if (eventName.length() > 256) {
            throw new TapInvalidDataException("The eventName is too long, max length is 256.");
        }
    }

    @JvmStatic
    public static final boolean checkKey(String errorTitle, String key) {
        Intrinsics.checkNotNullParameter(errorTitle, "errorTitle");
        String str = key;
        if (str == null || str.length() == 0) {
            TapLogger.logw$default(null, errorTitle + ", The key is empty. The error property has been removed", false, 5, null);
            return false;
        }
        if (key.length() <= 256) {
            return true;
        }
        TapLogger.logw$default(null, errorTitle + ", The key is too long, max length is 256. The error property has been removed.\n[key='" + key + "']", false, 5, null);
        return false;
    }

    public final boolean checkValue(String errorTitle, String key, Object value) throws JSONException {
        Intrinsics.checkNotNullParameter(errorTitle, "errorTitle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value instanceof CharSequence) {
            if (((CharSequence) value).length() > 256) {
                TapLogger.logw$default(null, errorTitle + ", The value is too long, max length is 256. The error property has been removed.\n[key='" + key + "', value='" + value + "']", false, 5, null);
                return false;
            }
        } else {
            if (value instanceof JsonNull ? true : value instanceof Number ? true : value instanceof Boolean ? true : value instanceof Date) {
                return true;
            }
            if (value instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) value;
                for (int length = jSONArray.length() - 1; -1 < length; length--) {
                    Object obj = jSONArray.get(length);
                    if (!(obj instanceof CharSequence)) {
                        TapLogger.logw$default(null, errorTitle + ", The value is JSONArray, it only supports children of the text type. The error property has been removed.\n [key='" + key + "', index = '" + length + "', value='" + obj + "']", false, 5, null);
                        jSONArray.remove(length);
                    }
                }
            } else {
                TapLogger.logw$default(null, errorTitle + ", The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date. The error property has been removed.\n[key='" + key + "', value='" + value + "']", false, 5, null);
                return false;
            }
        }
        return true;
    }

    public final void filterProperties(String errorTitle, JSONObject dynamicProperties) {
        Intrinsics.checkNotNullParameter(errorTitle, "errorTitle");
        if (dynamicProperties == null) {
            return;
        }
        Iterator<String> itKeys = dynamicProperties.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            if (!checkKey(errorTitle, key)) {
                itKeys.remove();
            } else {
                Object obj = dynamicProperties.get(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (!checkValue(errorTitle, key, obj)) {
                    itKeys.remove();
                }
            }
        }
    }

    private final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }
}
