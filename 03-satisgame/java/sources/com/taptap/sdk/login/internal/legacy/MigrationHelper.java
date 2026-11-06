package com.taptap.sdk.login.internal.legacy;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: MigrationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/internal/legacy/MigrationHelper;", "", "()V", "convertScopeStringToSet", "", "", "scopesString", "migrate", "Lcom/taptap/sdk/login/TapTapAccount;", "tokenString", "profileString", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MigrationHelper {
    public static final MigrationHelper INSTANCE = new MigrationHelper();

    private MigrationHelper() {
    }

    public final TapTapAccount migrate(String tokenString, String profileString) {
        Object objDecodeFromString;
        AccessToken accessToken;
        Object objDecodeFromString2;
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2;
        JsonPrimitive jsonPrimitive3;
        Intrinsics.checkNotNullParameter(tokenString, "tokenString");
        Intrinsics.checkNotNullParameter(profileString, "profileString");
        TapJson tapJson = TapJson.INSTANCE;
        if (tokenString.length() == 0) {
            objDecodeFromString = null;
        } else {
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(JsonObject.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = json.decodeFromString(kSerializerSerializer, tokenString);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                objDecodeFromString = null;
            }
        }
        JsonObject jsonObject = (JsonObject) objDecodeFromString;
        if (jsonObject == null) {
            return null;
        }
        try {
            try {
                accessToken = new AccessToken(JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "kid")).getContent(), JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "token_type")).getContent(), JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "mac_key")).getContent(), JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "mac_algorithm")).getContent(), convertScopeStringToSet(JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "scope")).getContent()));
            } catch (Throwable unused) {
                accessToken = null;
            }
        } catch (Throwable unused2) {
        }
        if (accessToken == null) {
            return null;
        }
        TapJson tapJson2 = TapJson.INSTANCE;
        if (profileString.length() == 0) {
            objDecodeFromString2 = null;
        } else {
            try {
                Json json2 = tapJson2.getJson();
                KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.typeOf(JsonObject.class));
                Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString2 = json2.decodeFromString(kSerializerSerializer2, profileString);
            } catch (Exception e2) {
                TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                objDecodeFromString2 = null;
            }
        }
        JsonObject jsonObject2 = (JsonObject) objDecodeFromString2;
        if (jsonObject2 == null) {
            return null;
        }
        try {
            String content = JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject2, Scopes.OPEN_ID)).getContent();
            String content2 = JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject2, "unionid")).getContent();
            JsonElement jsonElement = (JsonElement) jsonObject2.get((Object) TapEventParamConstants.PARAM_NAME);
            String content3 = (jsonElement == null || (jsonPrimitive3 = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : jsonPrimitive3.getContent();
            JsonElement jsonElement2 = (JsonElement) jsonObject2.get((Object) "avatar");
            String content4 = (jsonElement2 == null || (jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement2)) == null) ? null : jsonPrimitive2.getContent();
            JsonElement jsonElement3 = (JsonElement) jsonObject2.get((Object) "email");
            return new TapTapAccount(accessToken, content, content2, content3, content4, (jsonElement3 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement3)) == null) ? null : jsonPrimitive.getContent());
        } catch (Throwable unused3) {
            return null;
        }
    }

    private final Set<String> convertScopeStringToSet(String scopesString) {
        List listEmptyList;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(scopesString)) {
            try {
                List<String> listSplit = new Regex("\\s+").split(scopesString, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            if (!(listIterator.previous().length() == 0)) {
                                listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                break;
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                            break;
                        }
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                hashSet = new HashSet(Arrays.asList(Arrays.copyOf(strArr, strArr.length)));
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }
}
