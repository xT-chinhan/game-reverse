package com.tapsdk.tapad.internal;

import android.content.Context;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts;
import com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge;
import com.tapsdk.tapad.internal.utils.WXUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class WasmAdnCoreEnvironment {
    private WasmAdnCoreEnvironment() {
    }

    public static JSONObject createBootstrapPayload(Context context, TapAdConfig tapAdConfig) {
        if (context == null || tapAdConfig == null) {
            throw new IllegalArgumentException("context and config are required");
        }
        return AndroidDeviceFacts.collectAdnBootstrapFacts(context.getApplicationContext()).put("media_id", tapAdConfig.mMediaId).put("media_key", safe(tapAdConfig.mMediaKey)).put("media_version", mediaVersion(tapAdConfig)).put("base_data", safe(tapAdConfig.data)).put("media_global_settings", PublisherSettingsBridge.snapshot()).put("tap_client_id", safe(tapAdConfig.mTapClientId)).put("game_channel", safe(tapAdConfig.gameChannel)).put("aggregation_channel", safe(tapAdConfig.aggregationChannel)).put("support_wx_sdk", WXUtil.isWXOpenSDKIntegrated() ? 1 : 2).put("sdk_version_code", 50300001).put("wall_time_ms", System.currentTimeMillis());
    }

    private static String mediaVersion(TapAdConfig tapAdConfig) {
        String str;
        return (tapAdConfig == null || (str = tapAdConfig.mMediaVersion) == null || str.trim().isEmpty()) ? "1" : tapAdConfig.mMediaVersion;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }
}
