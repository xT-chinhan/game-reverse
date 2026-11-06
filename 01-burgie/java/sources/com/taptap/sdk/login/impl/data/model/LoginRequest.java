package com.taptap.sdk.login.impl.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0019HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÑ\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\t\u0010H\u001a\u00020\u0019HÖ\u0001J\u0013\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\u0019HÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\u0019\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010 R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u00102R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001c¨\u0006S"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "Landroid/os/Parcelable;", "state", "", "clientId", "scopes", "", "versionCode", "info", "trackInfo", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "preApproved", "", "phoneVerifyToken", "preferredLoginType", "loginVersion", "responseType", "redirectUri", "codeVerifier", "codeChallengeMethod", "isAuth", "loginType", "sessionId", "screenOrientation", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/initializer/api/model/RegionType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;I)V", "getClientId", "()Ljava/lang/String;", "getCodeChallengeMethod", "getCodeVerifier", "getInfo", "()Z", "getLoginType", "getLoginVersion", "getPhoneVerifyToken", "getPreApproved", "getPreferredLoginType", "getRedirectUri", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "getResponseType", "getScopes", "()Ljava/util/List;", "getScreenOrientation", "()I", "getSessionId", "getState", "getTrackInfo", "setTrackInfo", "(Ljava/lang/String;)V", "getVersionCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class LoginRequest implements Parcelable {
    public static final Parcelable.Creator<LoginRequest> CREATOR = new Creator();
    private final String clientId;
    private final String codeChallengeMethod;
    private final String codeVerifier;
    private final String info;
    private final boolean isAuth;
    private final String loginType;
    private final String loginVersion;
    private final String phoneVerifyToken;
    private final boolean preApproved;
    private final String preferredLoginType;
    private final String redirectUri;
    private final RegionType regionType;
    private final String responseType;
    private final List<String> scopes;
    private final int screenOrientation;
    private final String sessionId;
    private final String state;
    private String trackInfo;
    private final String versionCode;

    /* JADX INFO: compiled from: LoginRequest.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LoginRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoginRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LoginRequest(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), RegionType.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt());
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

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getLoginType() {
        return this.loginType;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final List<String> component3() {
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

    public final LoginRequest copy(String state, String clientId, List<String> scopes, String versionCode, String info, String trackInfo, RegionType regionType, boolean preApproved, String phoneVerifyToken, String preferredLoginType, String loginVersion, String responseType, String redirectUri, String codeVerifier, String codeChallengeMethod, boolean isAuth, String loginType, String sessionId, int screenOrientation) {
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
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new LoginRequest(state, clientId, scopes, versionCode, info, trackInfo, regionType, preApproved, phoneVerifyToken, preferredLoginType, loginVersion, responseType, redirectUri, codeVerifier, codeChallengeMethod, isAuth, loginType, sessionId, screenOrientation);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginRequest)) {
            return false;
        }
        LoginRequest loginRequest = (LoginRequest) other;
        return Intrinsics.areEqual(this.state, loginRequest.state) && Intrinsics.areEqual(this.clientId, loginRequest.clientId) && Intrinsics.areEqual(this.scopes, loginRequest.scopes) && Intrinsics.areEqual(this.versionCode, loginRequest.versionCode) && Intrinsics.areEqual(this.info, loginRequest.info) && Intrinsics.areEqual(this.trackInfo, loginRequest.trackInfo) && this.regionType == loginRequest.regionType && this.preApproved == loginRequest.preApproved && Intrinsics.areEqual(this.phoneVerifyToken, loginRequest.phoneVerifyToken) && Intrinsics.areEqual(this.preferredLoginType, loginRequest.preferredLoginType) && Intrinsics.areEqual(this.loginVersion, loginRequest.loginVersion) && Intrinsics.areEqual(this.responseType, loginRequest.responseType) && Intrinsics.areEqual(this.redirectUri, loginRequest.redirectUri) && Intrinsics.areEqual(this.codeVerifier, loginRequest.codeVerifier) && Intrinsics.areEqual(this.codeChallengeMethod, loginRequest.codeChallengeMethod) && this.isAuth == loginRequest.isAuth && Intrinsics.areEqual(this.loginType, loginRequest.loginType) && Intrinsics.areEqual(this.sessionId, loginRequest.sessionId) && this.screenOrientation == loginRequest.screenOrientation;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.state.hashCode() * 31) + this.clientId.hashCode()) * 31) + this.scopes.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.info.hashCode()) * 31) + this.trackInfo.hashCode()) * 31) + this.regionType.hashCode()) * 31) + Boolean.hashCode(this.preApproved)) * 31;
        String str = this.phoneVerifyToken;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.preferredLoginType;
        return ((((((((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.loginVersion.hashCode()) * 31) + this.responseType.hashCode()) * 31) + this.redirectUri.hashCode()) * 31) + this.codeVerifier.hashCode()) * 31) + this.codeChallengeMethod.hashCode()) * 31) + Boolean.hashCode(this.isAuth)) * 31) + this.loginType.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + Integer.hashCode(this.screenOrientation);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginRequest(state=").append(this.state).append(", clientId=").append(this.clientId).append(", scopes=").append(this.scopes).append(", versionCode=").append(this.versionCode).append(", info=").append(this.info).append(", trackInfo=").append(this.trackInfo).append(", regionType=").append(this.regionType).append(", preApproved=").append(this.preApproved).append(", phoneVerifyToken=").append(this.phoneVerifyToken).append(", preferredLoginType=").append(this.preferredLoginType).append(", loginVersion=").append(this.loginVersion).append(", responseType=");
        sb.append(this.responseType).append(", redirectUri=").append(this.redirectUri).append(", codeVerifier=").append(this.codeVerifier).append(", codeChallengeMethod=").append(this.codeChallengeMethod).append(", isAuth=").append(this.isAuth).append(", loginType=").append(this.loginType).append(", sessionId=").append(this.sessionId).append(", screenOrientation=").append(this.screenOrientation).append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.state);
        parcel.writeString(this.clientId);
        parcel.writeStringList(this.scopes);
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
        parcel.writeString(this.loginType);
        parcel.writeString(this.sessionId);
        parcel.writeInt(this.screenOrientation);
    }

    public LoginRequest(String state, String clientId, List<String> scopes, String versionCode, String info, String trackInfo, RegionType regionType, boolean preApproved, String phoneVerifyToken, String preferredLoginType, String loginVersion, String responseType, String redirectUri, String codeVerifier, String codeChallengeMethod, boolean isAuth, String loginType, String sessionId, int screenOrientation) {
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
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.state = state;
        this.clientId = clientId;
        this.scopes = scopes;
        this.versionCode = versionCode;
        this.info = info;
        this.trackInfo = trackInfo;
        this.regionType = regionType;
        this.preApproved = preApproved;
        this.phoneVerifyToken = phoneVerifyToken;
        this.preferredLoginType = preferredLoginType;
        this.loginVersion = loginVersion;
        this.responseType = responseType;
        this.redirectUri = redirectUri;
        this.codeVerifier = codeVerifier;
        this.codeChallengeMethod = codeChallengeMethod;
        this.isAuth = isAuth;
        this.loginType = loginType;
        this.sessionId = sessionId;
        this.screenOrientation = screenOrientation;
    }

    public /* synthetic */ LoginRequest(String str, String str2, List list, String str3, String str4, String str5, RegionType regionType, boolean z, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, String str13, String str14, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, regionType, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? null : str7, (i2 & 1024) != 0 ? "1" : str8, (i2 & 2048) != 0 ? PluginConstants.KEY_ERROR_CODE : str9, (i2 & 4096) != 0 ? "tapoauth://authorize" : str10, (i2 & 8192) != 0 ? TapHttpUtil.INSTANCE.getRandomString(128) : str11, (i2 & 16384) != 0 ? "S256" : str12, (i2 & 32768) != 0 ? false : z2, str13, str14, i);
    }

    public final String getState() {
        return this.state;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final List<String> getScopes() {
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

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    public final boolean isAuth() {
        return this.isAuth;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }
}
