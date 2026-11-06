package com.taptap.sdk.db.event.playgame;

import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.db.event.model.TapPlayGameDurationBean;
import com.taptap.sdk.db.event.model.TapUserDurationBean;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TapPlayGameDurationStore.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/db/event/playgame/TapPlayGameDurationStore;", "", "()V", "lastSaveTimestamp", "", "playGameDurationBean", "Lcom/taptap/sdk/db/event/model/TapPlayGameDurationBean;", "getPlayGameDurationBean$tap_db_release", "()Lcom/taptap/sdk/db/event/model/TapPlayGameDurationBean;", "playGameDurationBean$delegate", "Lkotlin/Lazy;", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "appendDeviceDuration", "", MediationConstant.EXTRA_DURATION, "appendUserDuration", "userId", "", "resetDeviceStore", "resetUserStore", "syncStore", "force", "", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapPlayGameDurationStore {
    private static final String SP_FILE_PLAY_GAME_DURATION_BEAN = "com.taptap.sdk.PlayGameDurationStore";
    private static final String SP_KEY_PLAY_GAME_DURATION_BEAN = "sp_key_play_game_duration_bean";
    private static final long SYNC_INTERVAL = 30000;
    private static final String TAG = "TapPlayGameDurationStore";
    private long lastSaveTimestamp;

    /* JADX INFO: renamed from: sp$delegate, reason: from kotlin metadata */
    private final Lazy sp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.taptap.sdk.db.event.playgame.TapPlayGameDurationStore$sp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return TapEventLogger.INSTANCE.getApplicationContext$tap_db_release().getSharedPreferences("com.taptap.sdk.PlayGameDurationStore", 0);
        }
    });

    /* JADX INFO: renamed from: playGameDurationBean$delegate, reason: from kotlin metadata */
    private final Lazy playGameDurationBean = LazyKt.lazy(new Function0<TapPlayGameDurationBean>() { // from class: com.taptap.sdk.db.event.playgame.TapPlayGameDurationStore$playGameDurationBean$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapPlayGameDurationBean invoke() {
            String string = this.this$0.getSp().getString("sp_key_play_game_duration_bean", "");
            TapJson tapJson = TapJson.INSTANCE;
            String str = string != null ? string : "";
            Object objDecodeFromString = null;
            if (!(str.length() == 0)) {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapPlayGameDurationBean.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, str);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                }
            }
            TapPlayGameDurationBean tapPlayGameDurationBean = (TapPlayGameDurationBean) objDecodeFromString;
            return tapPlayGameDurationBean == null ? new TapPlayGameDurationBean(0L, (List) null, 3, (DefaultConstructorMarker) null) : tapPlayGameDurationBean;
        }
    });

    public TapPlayGameDurationStore() {
        TapLogger.logd(TAG, "playGameDurationBean = " + getPlayGameDurationBean$tap_db_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getSp() {
        Object value = this.sp.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    public final TapPlayGameDurationBean getPlayGameDurationBean$tap_db_release() {
        return (TapPlayGameDurationBean) this.playGameDurationBean.getValue();
    }

    public final void appendUserDuration(String userId, long duration) {
        Object next;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Iterator<T> it = getPlayGameDurationBean$tap_db_release().getUserDuration().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((TapUserDurationBean) next).getUserId(), userId));
        TapUserDurationBean tapUserDurationBean = (TapUserDurationBean) next;
        if (tapUserDurationBean != null) {
            tapUserDurationBean.setDuration(tapUserDurationBean.getDuration() + duration);
        } else {
            getPlayGameDurationBean$tap_db_release().getUserDuration().add(new TapUserDurationBean(userId, duration));
        }
    }

    public final void appendDeviceDuration(long duration) {
        TapPlayGameDurationBean playGameDurationBean$tap_db_release = getPlayGameDurationBean$tap_db_release();
        playGameDurationBean$tap_db_release.setDeviceDuration(playGameDurationBean$tap_db_release.getDeviceDuration() + duration);
    }

    public static /* synthetic */ void syncStore$default(TapPlayGameDurationStore tapPlayGameDurationStore, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        tapPlayGameDurationStore.syncStore(z);
    }

    public final void syncStore(boolean force) {
        String strEncodeToString;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (force || jCurrentTimeMillis - this.lastSaveTimestamp > SYNC_INTERVAL) {
            SharedPreferences.Editor editorEdit = getSp().edit();
            TapJson tapJson = TapJson.INSTANCE;
            TapPlayGameDurationBean playGameDurationBean$tap_db_release = getPlayGameDurationBean$tap_db_release();
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapPlayGameDurationBean.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, playGameDurationBean$tap_db_release);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            editorEdit.putString(SP_KEY_PLAY_GAME_DURATION_BEAN, strEncodeToString).apply();
            this.lastSaveTimestamp = jCurrentTimeMillis;
            TapLogger.logd(TAG, "syncBean = " + getPlayGameDurationBean$tap_db_release());
        }
    }

    public final void resetUserStore() {
        TapLogger.logd(TAG, "resetUserStore");
        getPlayGameDurationBean$tap_db_release().getUserDuration().clear();
        syncStore(true);
    }

    public final void resetDeviceStore() {
        TapLogger.logd(TAG, "resetDeviceStore");
        getPlayGameDurationBean$tap_db_release().setDeviceDuration(0L);
        syncStore(true);
    }
}
