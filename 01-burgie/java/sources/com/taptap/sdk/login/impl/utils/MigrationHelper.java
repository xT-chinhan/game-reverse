package com.taptap.sdk.login.impl.utils;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.impl.data.model.legacy.LegacyAccessToken;
import com.taptap.sdk.login.impl.data.model.legacy.LegacyProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: MigrationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/MigrationHelper;", "", "()V", "migrate", "Lcom/taptap/sdk/login/TapTapAccount;", "tokenString", "", "profileString", "convertAsToken", "Lcom/taptap/sdk/login/AccessToken;", "Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyAccessToken;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MigrationHelper {
    public static final MigrationHelper INSTANCE = new MigrationHelper();

    private MigrationHelper() {
    }

    public final TapTapAccount migrate(String tokenString, String profileString) {
        Object objDecodeFromString;
        Object objDecodeFromString2;
        Intrinsics.checkNotNullParameter(tokenString, "tokenString");
        Intrinsics.checkNotNullParameter(profileString, "profileString");
        TapJson this_$iv = TapJson.INSTANCE;
        if (tokenString.length() == 0) {
            objDecodeFromString = null;
        } else {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(LegacyAccessToken.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, tokenString);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                objDecodeFromString = null;
            }
        }
        LegacyAccessToken legacyAccessToken = (LegacyAccessToken) objDecodeFromString;
        if (legacyAccessToken == null) {
            return null;
        }
        TapJson this_$iv2 = TapJson.INSTANCE;
        if (profileString.length() == 0) {
            objDecodeFromString2 = null;
        } else {
            try {
                StringFormat $this$decodeFromString$iv$iv2 = this_$iv2.getJson();
                SerializersModule $this$serializer$iv$iv$iv2 = $this$decodeFromString$iv$iv2.getSerializersModule();
                KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv2, Reflection.typeOf(LegacyProfile.class));
                Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString2 = $this$decodeFromString$iv$iv2.decodeFromString(kSerializerSerializer2, profileString);
            } catch (Exception e$iv2) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv2, 2, null);
                objDecodeFromString2 = null;
            }
        }
        LegacyProfile legacyProfile = (LegacyProfile) objDecodeFromString2;
        if (legacyProfile == null) {
            return null;
        }
        try {
            try {
                return new TapTapAccount(convertAsToken(legacyAccessToken), legacyProfile.getOpenid(), legacyProfile.getUnionid(), legacyProfile.getName(), legacyProfile.getAvatar(), legacyProfile.getEmail());
            } catch (Throwable th) {
                return null;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private final AccessToken convertAsToken(LegacyAccessToken $this$convertAsToken) {
        return new AccessToken($this$convertAsToken.getKid(), $this$convertAsToken.getTokenType(), $this$convertAsToken.getMacKey(), $this$convertAsToken.getMacAlgorithm(), $this$convertAsToken.getScopes());
    }
}
