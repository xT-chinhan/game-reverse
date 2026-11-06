package com.taptap.sdk.gid.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.KVUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapGidStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/gid/internal/TapGidStorage;", "", "()V", "TAP_DEVICE_ID_SAVED_PARAM", "", "TAP_GID_SHARE_PREFERENCE", "TAP_GID_SP_CACHE_CN", "TAP_GID_SP_CACHE_GLOBAL", "clearDeprecatedSpGid", "", "context", "Landroid/content/Context;", "getDeprecatedSpGid", "getGidFromSp", "regionType", "", "saveGidToSp", TapEventParamConstants.PARAM_SUB_GID, "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapGidStorage {
    public static final TapGidStorage INSTANCE = new TapGidStorage();
    private static final String TAP_DEVICE_ID_SAVED_PARAM = "taptap_device_id_saved_param";
    private static final String TAP_GID_SHARE_PREFERENCE = "tap_gid_share_preference";
    private static final String TAP_GID_SP_CACHE_CN = "taptap_gid_cn_cache";
    private static final String TAP_GID_SP_CACHE_GLOBAL = "taptap_gid_global_cache";

    private TapGidStorage() {
    }

    public final void saveGidToSp(int regionType, String gid) {
        Intrinsics.checkNotNullParameter(gid, "gid");
        try {
            if (regionType == 0) {
                KVUtil.putString$default(KVUtil.INSTANCE, TAP_GID_SP_CACHE_CN, gid, null, 4, null);
            } else if (regionType != 1) {
            } else {
                KVUtil.putString$default(KVUtil.INSTANCE, TAP_GID_SP_CACHE_GLOBAL, gid, null, 4, null);
            }
        } catch (Exception e) {
            TapLogger.loge$default("TapGidStorage", null, e, 2, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0038  */
    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    public final String getGidFromSp(int regionType) {
        String string$default = "";
        try {
            if (regionType == 0) {
                string$default = KVUtil.getString$default(KVUtil.INSTANCE, TAP_GID_SP_CACHE_CN, "", null, 4, null);
            } else {
                if (regionType == 1) {
                    string$default = KVUtil.getString$default(KVUtil.INSTANCE, TAP_GID_SP_CACHE_GLOBAL, "", null, 4, null);
                }
                String str = string$default;
                return str.length() == 0 ? null : str;
            }
        } catch (Exception e) {
            TapLogger.loge$default("TapGidStorage", null, e, 2, null);
        }
        String str2 = string$default;
        return str2.length() == 0 ? null : str2;
    }

    public final void clearDeprecatedSpGid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(TAP_GID_SHARE_PREFERENCE, 0).edit();
            editorEdit.remove(TAP_DEVICE_ID_SAVED_PARAM);
            editorEdit.apply();
        } catch (Exception e) {
            TapLogger.loge$default("TapGidStorage", null, e, 2, null);
        }
    }

    public final String getDeprecatedSpGid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(TAP_GID_SHARE_PREFERENCE, 0).getString(TAP_DEVICE_ID_SAVED_PARAM, null);
    }
}
