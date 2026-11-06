package com.taptap.sdk.login.internal.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.internal.util.CodeUtil;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: LoginRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0001MB¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0002\u0010\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0002\u0010&J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¸\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010>J\t\u0010?\u001a\u00020@HÖ\u0001J\u0013\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010CH\u0096\u0002J\b\u0010D\u001a\u00020@H\u0016J\u0006\u0010E\u001a\u00020FJ\t\u0010G\u001a\u00020\u0003HÖ\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020@HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010+R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018¨\u0006N"}, d2 = {"Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "Landroid/os/Parcelable;", "state", "", "clientId", "scopes", "", TTDownloadField.TT_VERSION_CODE, "info", "trackInfo", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "preApproved", "", "phoneVerifyToken", "preferredLoginType", "loginVersion", "responseType", "redirectUri", "codeVerifier", "codeChallengeMethod", "isAuth", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/initializer/api/model/RegionType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getClientId", "()Ljava/lang/String;", "getCodeChallengeMethod", "getCodeVerifier", "getInfo", "()Z", "getLoginVersion", "getPhoneVerifyToken", "getPreApproved", "getPreferredLoginType", "getRedirectUri", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "getResponseType", "getScopes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getState", "getTrackInfo", "setTrackInfo", "(Ljava/lang/String;)V", "getVersionCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/initializer/api/model/RegionType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "describeContents", "", "equals", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "toBundle", "Landroid/os/Bundle;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class LoginRequest implements Parcelable {
    public static final String REQ_KEY_CLIENT_ID = "com.taptap.sdk.request.client_id";
    public static final String REQ_KEY_CODE_CHALLENGE = "com.taptap.sdk.request.code_challenge";
    public static final String REQ_KEY_CODE_CHALLENGE_METHOD = "com.taptap.sdk.request.code_challenge_method";
    public static final String REQ_KEY_EXTRA = "com.taptap.sdk.request.extra";
    public static final String REQ_KEY_INFO = "com.taptap.sdk.request.info";
    public static final String REQ_KEY_LOGIN_VERSION = "com.taptap.sdk.request.login_version";
    public static final String REQ_KEY_PERMISSIONS = "com.taptap.sdk.request.permissions";
    public static final String REQ_KEY_REDIRECT_URI = "com.taptap.sdk.request.redirect_uri";
    public static final String REQ_KEY_RESPONSE_TYPE = "com.taptap.sdk.request.response_type";
    public static final String REQ_KEY_SDK_VERSION = "com.taptap.sdk.request.sdk_version";
    public static final String REQ_KEY_STATE = "com.taptap.sdk.request.state";
    public static final String REQ_KEY_TRACK_INFO = "com.taptap.sdk.request.track_info";
    private final String clientId;
    private final String codeChallengeMethod;
    private final String codeVerifier;
    private final String info;
    private final boolean isAuth;
    private final String loginVersion;
    private final String phoneVerifyToken;
    private final boolean preApproved;
    private final String preferredLoginType;
    private final String redirectUri;
    private final RegionType regionType;
    private final String responseType;
    private final String[] scopes;
    private final String state;
    private String trackInfo;
    private final String versionCode;
    public static final Parcelable.Creator<LoginRequest> CREATOR = new Creator();

    /* JADX INFO: compiled from: LoginRequest.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LoginRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoginRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LoginRequest(parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readString(), parcel.readString(), RegionType.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoginRequest[] newArray(int i) {
            return new LoginRequest[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPreferredLoginType() {
        return this.preferredLoginType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getLoginVersion() {
        return this.loginVersion;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsAuth() {
        return this.isAuth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String[] getScopes() {
        return this.scopes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTrackInfo() {
        return this.trackInfo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RegionType getRegionType() {
        return this.regionType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getPreApproved() {
        return this.preApproved;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPhoneVerifyToken() {
        return this.phoneVerifyToken;
    }

    public final LoginRequest copy(String state, String clientId, String[] scopes, String versionCode, String info, String trackInfo, RegionType regionType, boolean preApproved, String phoneVerifyToken, String preferredLoginType, String loginVersion, String responseType, String redirectUri, String codeVerifier, String codeChallengeMethod, boolean isAuth) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(versionCode, "versionCode");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
        Intrinsics.checkNotNullParameter(regionType, "regionType");
        Intrinsics.checkNotNullParameter(loginVersion, "loginVersion");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        return new LoginRequest(state, clientId, scopes, versionCode, info, trackInfo, regionType, preApproved, phoneVerifyToken, preferredLoginType, loginVersion, responseType, redirectUri, codeVerifier, codeChallengeMethod, isAuth);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LoginRequest(state=");
        sb.append(this.state).append(", clientId=").append(this.clientId).append(", scopes=").append(Arrays.toString(this.scopes)).append(", versionCode=").append(this.versionCode).append(", info=").append(this.info).append(", trackInfo=").append(this.trackInfo).append(", regionType=").append(this.regionType).append(", preApproved=").append(this.preApproved).append(", phoneVerifyToken=").append(this.phoneVerifyToken).append(", preferredLoginType=").append(this.preferredLoginType).append(", loginVersion=").append(this.loginVersion).append(", responseType=");
        sb.append(this.responseType).append(", redirectUri=").append(this.redirectUri).append(", codeVerifier=").append(this.codeVerifier).append(", codeChallengeMethod=").append(this.codeChallengeMethod).append(", isAuth=").append(this.isAuth).append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.state);
        parcel.writeString(this.clientId);
        parcel.writeStringArray(this.scopes);
        parcel.writeString(this.versionCode);
        parcel.writeString(this.info);
        parcel.writeString(this.trackInfo);
        parcel.writeString(this.regionType.name());
        parcel.writeInt(this.preApproved ? 1 : 0);
        parcel.writeString(this.phoneVerifyToken);
        parcel.writeString(this.preferredLoginType);
        parcel.writeString(this.loginVersion);
        parcel.writeString(this.responseType);
        parcel.writeString(this.redirectUri);
        parcel.writeString(this.codeVerifier);
        parcel.writeString(this.codeChallengeMethod);
        parcel.writeInt(this.isAuth ? 1 : 0);
    }

    public LoginRequest(String state, String clientId, String[] scopes, String versionCode, String info, String trackInfo, RegionType regionType, boolean z, String str, String str2, String loginVersion, String responseType, String redirectUri, String codeVerifier, String codeChallengeMethod, boolean z2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(versionCode, "versionCode");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
        Intrinsics.checkNotNullParameter(regionType, "regionType");
        Intrinsics.checkNotNullParameter(loginVersion, "loginVersion");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        this.state = state;
        this.clientId = clientId;
        this.scopes = scopes;
        this.versionCode = versionCode;
        this.info = info;
        this.trackInfo = trackInfo;
        this.regionType = regionType;
        this.preApproved = z;
        this.phoneVerifyToken = str;
        this.preferredLoginType = str2;
        this.loginVersion = loginVersion;
        this.responseType = responseType;
        this.redirectUri = redirectUri;
        this.codeVerifier = codeVerifier;
        this.codeChallengeMethod = codeChallengeMethod;
        this.isAuth = z2;
    }

    public final String getState() {
        return this.state;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String[] getScopes() {
        return this.scopes;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getTrackInfo() {
        return this.trackInfo;
    }

    public final void setTrackInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackInfo = str;
    }

    public final RegionType getRegionType() {
        return this.regionType;
    }

    public final boolean getPreApproved() {
        return this.preApproved;
    }

    public final String getPhoneVerifyToken() {
        return this.phoneVerifyToken;
    }

    public final String getPreferredLoginType() {
        return this.preferredLoginType;
    }

    public final String getLoginVersion() {
        return this.loginVersion;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public /* synthetic */ LoginRequest(String str, String str2, String[] strArr, String str3, String str4, String str5, RegionType regionType, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, strArr, str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, regionType, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? "1" : str8, (i & 2048) != 0 ? "code" : str9, (i & 4096) != 0 ? "tapoauth://authorize" : str10, (i & 8192) != 0 ? TapHttpUtil.INSTANCE.getRandomString(128) : str11, (i & 16384) != 0 ? "S256" : str12, (i & 32768) != 0 ? false : z2);
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    public final boolean isAuth() {
        return this.isAuth;
    }

    public final Bundle toBundle() {
        String strEncodeToString;
        Bundle bundle = new Bundle();
        bundle.putString(REQ_KEY_CLIENT_ID, this.clientId);
        bundle.putString(REQ_KEY_STATE, this.state);
        bundle.putStringArray(REQ_KEY_PERMISSIONS, this.scopes);
        bundle.putString(REQ_KEY_SDK_VERSION, this.versionCode);
        bundle.putString(REQ_KEY_INFO, this.info);
        bundle.putString(REQ_KEY_TRACK_INFO, this.trackInfo);
        TapJson tapJson = TapJson.INSTANCE;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("preapproved", Integer.valueOf(this.preApproved ? 1 : 0)));
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        bundle.putString(REQ_KEY_EXTRA, strEncodeToString);
        bundle.putString(REQ_KEY_LOGIN_VERSION, this.loginVersion);
        bundle.putString(REQ_KEY_RESPONSE_TYPE, this.responseType);
        bundle.putString(REQ_KEY_REDIRECT_URI, this.redirectUri);
        bundle.putString(REQ_KEY_CODE_CHALLENGE, CodeUtil.INSTANCE.getCodeChallenge(this.codeVerifier));
        bundle.putString(REQ_KEY_CODE_CHALLENGE_METHOD, this.codeChallengeMethod);
        return bundle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.taptap.sdk.login.internal.bean.LoginRequest");
        LoginRequest loginRequest = (LoginRequest) other;
        return Intrinsics.areEqual(this.state, loginRequest.state) && Arrays.equals(this.scopes, loginRequest.scopes) && Intrinsics.areEqual(this.versionCode, loginRequest.versionCode) && Intrinsics.areEqual(this.info, loginRequest.info);
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + Arrays.hashCode(this.scopes)) * 31) + this.versionCode.hashCode()) * 31) + this.info.hashCode();
    }
}
