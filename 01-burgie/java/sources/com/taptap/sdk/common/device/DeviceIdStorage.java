package com.taptap.sdk.common.device;

import android.content.SharedPreferences;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.base.utils.prefs.SharedPreferenceDelegate;
import com.taptap.sdk.kit.internal.TapLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceIdStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/common/device/DeviceIdStorage;", "", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferences", "(Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;)V", "<set-?>", "", "deviceId", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "deviceId$delegate", "Lcom/taptap/sdk/base/utils/prefs/SharedPreferenceDelegate;", "clearDeviceId", "", "migrateDeviceId", "migrateFromDefaultSp", "saveDeviceId", Constants.VALUE_FIELD, "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceIdStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DeviceIdStorage.class, "deviceId", "getDeviceId()Ljava/lang/String;", 0))};
    private static final String KEY_DEVICE_ID = "tapdb_game_mobile_identify";
    private static final String LEGACY_KEY_MATCHER = "__game_mobile__0__";
    private static final String TAG = "DeviceIdStorage";
    private static volatile boolean migrated;
    private final SharedPreferences defaultSharedPreferences;

    /* JADX INFO: renamed from: deviceId$delegate, reason: from kotlin metadata */
    private final SharedPreferenceDelegate deviceId;
    private final SharedPreferences sharedPreferences;

    public DeviceIdStorage(SharedPreferences defaultSharedPreferences, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.defaultSharedPreferences = defaultSharedPreferences;
        this.sharedPreferences = sharedPreferences;
        this.deviceId = new SharedPreferenceDelegate(sharedPreferences, KEY_DEVICE_ID, "");
    }

    private final String getDeviceId() {
        return (String) this.deviceId.getValue(this, $$delegatedProperties[0]);
    }

    private final void setDeviceId(String str) {
        this.deviceId.setValue(this, $$delegatedProperties[0], str);
    }

    public final String migrateDeviceId() {
        if (!migrated) {
            synchronized (this) {
                if (!migrated) {
                    migrateFromDefaultSp();
                    migrated = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        String it = getDeviceId();
        if (it.length() > 0) {
            return it;
        }
        return null;
    }

    public final void saveDeviceId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        setDeviceId(value);
        migrated = true;
        TapLogger.logd(TAG, "Device ID saved to private SP");
    }

    public final void clearDeviceId() {
        try {
            setDeviceId("");
            TapLogger.logd(TAG, "Device ID cleared");
        } catch (Exception e) {
            TapLogger.loge(TAG, "Error clearing device ID", e);
        }
    }

    private final void migrateFromDefaultSp() {
        try {
            if (getDeviceId().length() > 0) {
                TapLogger.logd(TAG, "Private SP already has data, skip migration");
                return;
            }
            SharedPreferences sharedPreferences = this.defaultSharedPreferences;
            if (sharedPreferences != null) {
                String standardData = sharedPreferences.getString(KEY_DEVICE_ID, null);
                String str = standardData;
                if (!(str == null || str.length() == 0)) {
                    setDeviceId(standardData);
                    TapLogger.logd(TAG, "Migrated from standard key");
                    return;
                }
            }
            SharedPreferences sharedPreferences2 = this.defaultSharedPreferences;
            if (sharedPreferences2 != null) {
                Map<String, ?> all = sharedPreferences2.getAll();
                Intrinsics.checkNotNullExpressionValue(all, "sharedPreferences.all");
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    if (StringsKt.contains$default((CharSequence) key, (CharSequence) LEGACY_KEY_MATCHER, false, 2, (Object) null) && (value instanceof String)) {
                        if (((CharSequence) value).length() > 0) {
                            setDeviceId((String) value);
                            TapLogger.logd(TAG, "Migrated from legacy key: " + key);
                            return;
                        }
                    }
                }
            }
            TapLogger.logd(TAG, "No data to migrate from default SP");
        } catch (Exception e) {
            TapLogger.loge(TAG, "Migration failed", e);
        }
    }
}
