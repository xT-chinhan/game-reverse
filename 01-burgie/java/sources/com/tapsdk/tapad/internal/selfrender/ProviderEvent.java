package com.tapsdk.tapad.internal.selfrender;

import android.view.View;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderEvent {
    public static final int BIND_FAILED = 2;
    public static final int BIND_SUCCEEDED = 1;
    public static final int CLICKED = 4;
    public static final int CLICK_REQUEST_FAILED = 23;
    public static final int DESTROYED = 14;
    public static final int DOWNLOAD_COMPLETED = 11;
    public static final int DOWNLOAD_FAILED = 16;
    public static final int DOWNLOAD_PAUSED = 10;
    public static final int DOWNLOAD_PROGRESS = 15;
    public static final int DOWNLOAD_STARTED = 9;
    public static final int INSTALLED = 12;
    public static final int INTERACTION_ACTION = 26;
    public static final int INTERACTION_HOST_AWAY = 28;
    public static final int INTERACTION_NOT_STARTED = 27;
    public static final int INTERACTION_RETURNED = 24;
    public static final int INTERACTION_STARTED = 25;
    public static final int RENDER_FAILED = 13;
    public static final int SHOWN = 3;
    public static final int VIDEO_COMPLETED = 8;
    public static final int VIDEO_FAILED = 18;
    public static final int VIDEO_PAUSED = 6;
    public static final int VIDEO_PREPARED = 17;
    public static final int VIDEO_RESUMED = 7;
    public static final int VIDEO_STARTED = 5;
    public final String appName;
    public final long appSize;
    public final int argument;
    public final long currentBytes;
    public final String fileName;
    public final int interactionId;
    public final int kind;
    public final String message;
    public final View sourceView;
    public final long totalBytes;

    private ProviderEvent(int i, int i2, long j, long j2, long j3, String str, String str2, String str3, int i3, View view) {
        this.kind = i;
        this.argument = i2;
        this.appSize = Math.max(0L, j);
        this.totalBytes = Math.max(0L, j2);
        this.currentBytes = Math.max(0L, j3);
        this.appName = safe(str);
        this.fileName = safe(str2);
        this.message = safe(str3);
        this.interactionId = Math.max(0, i3);
        this.sourceView = view;
    }

    public static ProviderEvent clickRequestFailed(int i, int i2, String str) {
        return new ProviderEvent(23, i2, 0L, 0L, 0L, "", "", str, i, null);
    }

    public static ProviderEvent clicked(View view) {
        return clicked(view, 0);
    }

    public static ProviderEvent download(int i, int i2, long j, long j2, long j3, String str, String str2) {
        return new ProviderEvent(i, Math.max(0, Math.min(100, i2)), j, j2, j3, str, str2, "", 0, null);
    }

    public static ProviderEvent downloadFailed(int i, long j, long j2, long j3, String str, String str2, String str3) {
        return new ProviderEvent(16, i, j, j2, j3, str, str2, str3, 0, null);
    }

    public static ProviderEvent failed(int i, int i2, String str) {
        return new ProviderEvent(i, i2, 0L, 0L, 0L, "", "", str, 0, null);
    }

    public static ProviderEvent interactionNotStarted(int i) {
        return new ProviderEvent(27, 0, 0L, 0L, 0L, "", "", "", i, null);
    }

    public static ProviderEvent interactionReturned(int i) {
        return new ProviderEvent(24, 0, 0L, 0L, 0L, "", "", "", i, null);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public static ProviderEvent simple(int i) {
        return simple(i, 0);
    }

    public String toJson() {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("kind", this.kind).put("argument", this.argument).put("app_size", this.appSize).put("total_bytes", this.totalBytes).put("current_bytes", this.currentBytes).put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, this.appName).put("file_name", this.fileName).put("message", this.message);
            int i = this.interactionId;
            if (i > 0) {
                jSONObjectPut.put("interaction_id", i);
            }
            return jSONObjectPut.toString();
        } catch (Exception e) {
            return "{}";
        }
    }

    public static ProviderEvent clicked(View view, int i) {
        return new ProviderEvent(4, i, 0L, 0L, 0L, "", "", "", 0, view);
    }

    public static ProviderEvent simple(int i, int i2) {
        return new ProviderEvent(i, i2, 0L, 0L, 0L, "", "", "", 0, null);
    }
}
