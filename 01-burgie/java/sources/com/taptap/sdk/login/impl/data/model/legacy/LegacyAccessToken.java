package com.taptap.sdk.login.impl.data.model.legacy;

import com.taptap.sdk.login.api.SetAsStringSerializer;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: LegacyAccessToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234Bg\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JK\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J&\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201HÁ\u0001¢\u0006\u0002\b2R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013¨\u00065"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyAccessToken;", "", "seen1", "", "kid", "", "accessToken", "tokenType", "macKey", "macAlgorithm", "scopes", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getAccessToken$annotations", "()V", "getAccessToken", "()Ljava/lang/String;", "getKid$annotations", "getKid", "getMacAlgorithm$annotations", "getMacAlgorithm", "getMacKey$annotations", "getMacKey", "getScopes$annotations", "getScopes", "()Ljava/util/Set;", "getTokenType$annotations", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LegacyAccessToken {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accessToken;
    private final String kid;
    private final String macAlgorithm;
    private final String macKey;
    private final Set<String> scopes;
    private final String tokenType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LegacyAccessToken copy$default(LegacyAccessToken legacyAccessToken, String str, String str2, String str3, String str4, String str5, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyAccessToken.kid;
        }
        if ((i & 2) != 0) {
            str2 = legacyAccessToken.accessToken;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = legacyAccessToken.tokenType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = legacyAccessToken.macKey;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = legacyAccessToken.macAlgorithm;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            set = legacyAccessToken.scopes;
        }
        return legacyAccessToken.copy(str, str6, str7, str8, str9, set);
    }

    @SerialName("access_token")
    public static /* synthetic */ void getAccessToken$annotations() {
    }

    @SerialName("kid")
    public static /* synthetic */ void getKid$annotations() {
    }

    @SerialName("mac_algorithm")
    public static /* synthetic */ void getMacAlgorithm$annotations() {
    }

    @SerialName("mac_key")
    public static /* synthetic */ void getMacKey$annotations() {
    }

    @SerialName("scope")
    @Serializable(with = SetAsStringSerializer.class)
    public static /* synthetic */ void getScopes$annotations() {
    }

    @SerialName("token_type")
    public static /* synthetic */ void getTokenType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKid() {
        return this.kid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTokenType() {
        return this.tokenType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMacKey() {
        return this.macKey;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public final Set<String> component6() {
        return this.scopes;
    }

    public final LegacyAccessToken copy(String kid, String accessToken, String tokenType, String macKey, String macAlgorithm, Set<String> scopes) {
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        Intrinsics.checkNotNullParameter(macAlgorithm, "macAlgorithm");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        return new LegacyAccessToken(kid, accessToken, tokenType, macKey, macAlgorithm, scopes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyAccessToken)) {
            return false;
        }
        LegacyAccessToken legacyAccessToken = (LegacyAccessToken) other;
        return Intrinsics.areEqual(this.kid, legacyAccessToken.kid) && Intrinsics.areEqual(this.accessToken, legacyAccessToken.accessToken) && Intrinsics.areEqual(this.tokenType, legacyAccessToken.tokenType) && Intrinsics.areEqual(this.macKey, legacyAccessToken.macKey) && Intrinsics.areEqual(this.macAlgorithm, legacyAccessToken.macAlgorithm) && Intrinsics.areEqual(this.scopes, legacyAccessToken.scopes);
    }

    public int hashCode() {
        return (((((((((this.kid.hashCode() * 31) + this.accessToken.hashCode()) * 31) + this.tokenType.hashCode()) * 31) + this.macKey.hashCode()) * 31) + this.macAlgorithm.hashCode()) * 31) + this.scopes.hashCode();
    }

    public String toString() {
        return "LegacyAccessToken(kid=" + this.kid + ", accessToken=" + this.accessToken + ", tokenType=" + this.tokenType + ", macKey=" + this.macKey + ", macAlgorithm=" + this.macAlgorithm + ", scopes=" + this.scopes + ')';
    }

    /* JADX INFO: compiled from: LegacyAccessToken.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyAccessToken$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyAccessToken;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LegacyAccessToken> serializer() {
            return LegacyAccessToken$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LegacyAccessToken(int seen1, @SerialName("kid") String kid, @SerialName("access_token") String accessToken, @SerialName("token_type") String tokenType, @SerialName("mac_key") String macKey, @SerialName("mac_algorithm") String macAlgorithm, @SerialName("scope") @Serializable(with = SetAsStringSerializer.class) Set scopes, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (seen1 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 63, LegacyAccessToken$$serializer.INSTANCE.getDescriptor());
        }
        this.kid = kid;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.macKey = macKey;
        this.macAlgorithm = macAlgorithm;
        this.scopes = scopes;
    }

    public LegacyAccessToken(String kid, String accessToken, String tokenType, String macKey, String macAlgorithm, Set<String> scopes) {
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        Intrinsics.checkNotNullParameter(macAlgorithm, "macAlgorithm");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        this.kid = kid;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.macKey = macKey;
        this.macAlgorithm = macAlgorithm;
        this.scopes = scopes;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(LegacyAccessToken self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.kid);
        output.encodeStringElement(serialDesc, 1, self.accessToken);
        output.encodeStringElement(serialDesc, 2, self.tokenType);
        output.encodeStringElement(serialDesc, 3, self.macKey);
        output.encodeStringElement(serialDesc, 4, self.macAlgorithm);
        output.encodeSerializableElement(serialDesc, 5, SetAsStringSerializer.INSTANCE, self.scopes);
    }

    public final String getKid() {
        return this.kid;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final String getMacKey() {
        return this.macKey;
    }

    public final String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public final Set<String> getScopes() {
        return this.scopes;
    }
}
