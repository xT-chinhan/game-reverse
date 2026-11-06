package com.taptap.sdk.update.bean;

import com.byazt.mg.PluginConstants;
import com.taptap.sdk.update.internal.UpdateTracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ForceUpdateResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0085\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B[\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J_\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\bHÖ\u0001J\u0006\u0010>\u001a\u00020?J&\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EHÁ\u0001¢\u0006\u0002\bFR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010#R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010,R$\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010,¨\u0006I"}, d2 = {"Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "", "seen1", "", "forceUpdateInfo", "Lcom/taptap/sdk/update/bean/ForceUpdateInfo;", "appId", "updateUri", "", "updateUrl", "developerName", "links", "", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "download", "Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "updateType", "appInfo", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/update/bean/ForceUpdateInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/update/bean/ForceUpdateInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;I)V", "getAppId$annotations", "()V", "getAppId", "()I", "getAppInfo", "()Ljava/lang/String;", "getDeveloperName$annotations", "getDeveloperName", "getDownload$annotations", "getDownload", "()Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "getForceUpdateInfo$annotations", "getForceUpdateInfo", "()Lcom/taptap/sdk/update/bean/ForceUpdateInfo;", "getLinks$annotations", "getLinks", "()Ljava/util/List;", "getUpdateType$annotations", "getUpdateType", "getUpdateUri$annotations", "getUpdateUri", "setUpdateUri", "(Ljava/lang/String;)V", "getUpdateUrl$annotations", "getUpdateUrl", "setUpdateUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "updateSessionId", "", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_update_release", "$serializer", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class ForceUpdateResult {
    private final int appId;
    private final String appInfo;
    private final String developerName;
    private final UpdateDownloadInfo download;
    private final ForceUpdateInfo forceUpdateInfo;
    private final List<UpdateFuncLink> links;
    private final int updateType;
    private String updateUri;
    private String updateUrl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(UpdateFuncLink$$serializer.INSTANCE), null, null, null};

    public ForceUpdateResult() {
        this(null, 0, null, null, null, null, null, 0, 255, null);
    }

    @SerialName(PluginConstants.KEY_APP_ID)
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName("developer_name")
    public static /* synthetic */ void getDeveloperName$annotations() {
    }

    @SerialName("download")
    public static /* synthetic */ void getDownload$annotations() {
    }

    @SerialName("latest_info")
    public static /* synthetic */ void getForceUpdateInfo$annotations() {
    }

    @SerialName("links")
    public static /* synthetic */ void getLinks$annotations() {
    }

    @SerialName("update_type")
    public static /* synthetic */ void getUpdateType$annotations() {
    }

    @SerialName("update_uri")
    public static /* synthetic */ void getUpdateUri$annotations() {
    }

    @SerialName("update_url")
    public static /* synthetic */ void getUpdateUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ForceUpdateInfo getForceUpdateInfo() {
        return this.forceUpdateInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdateUri() {
        return this.updateUri;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeveloperName() {
        return this.developerName;
    }

    public final List<UpdateFuncLink> component6() {
        return this.links;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UpdateDownloadInfo getDownload() {
        return this.download;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getUpdateType() {
        return this.updateType;
    }

    public final ForceUpdateResult copy(ForceUpdateInfo forceUpdateInfo, int appId, String updateUri, String updateUrl, String developerName, List<UpdateFuncLink> links, UpdateDownloadInfo download, int updateType) {
        Intrinsics.checkNotNullParameter(forceUpdateInfo, "forceUpdateInfo");
        Intrinsics.checkNotNullParameter(updateUri, "updateUri");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(download, "download");
        return new ForceUpdateResult(forceUpdateInfo, appId, updateUri, updateUrl, developerName, links, download, updateType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForceUpdateResult)) {
            return false;
        }
        ForceUpdateResult forceUpdateResult = (ForceUpdateResult) other;
        return Intrinsics.areEqual(this.forceUpdateInfo, forceUpdateResult.forceUpdateInfo) && this.appId == forceUpdateResult.appId && Intrinsics.areEqual(this.updateUri, forceUpdateResult.updateUri) && Intrinsics.areEqual(this.updateUrl, forceUpdateResult.updateUrl) && Intrinsics.areEqual(this.developerName, forceUpdateResult.developerName) && Intrinsics.areEqual(this.links, forceUpdateResult.links) && Intrinsics.areEqual(this.download, forceUpdateResult.download) && this.updateType == forceUpdateResult.updateType;
    }

    public int hashCode() {
        return (((((((((((((this.forceUpdateInfo.hashCode() * 31) + Integer.hashCode(this.appId)) * 31) + this.updateUri.hashCode()) * 31) + this.updateUrl.hashCode()) * 31) + this.developerName.hashCode()) * 31) + this.links.hashCode()) * 31) + this.download.hashCode()) * 31) + Integer.hashCode(this.updateType);
    }

    public String toString() {
        return "ForceUpdateResult(forceUpdateInfo=" + this.forceUpdateInfo + ", appId=" + this.appId + ", updateUri=" + this.updateUri + ", updateUrl=" + this.updateUrl + ", developerName=" + this.developerName + ", links=" + this.links + ", download=" + this.download + ", updateType=" + this.updateType + ')';
    }

    /* JADX INFO: compiled from: ForceUpdateResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/update/bean/ForceUpdateResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ForceUpdateResult> serializer() {
            return ForceUpdateResult$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ForceUpdateResult(int seen1, @SerialName("latest_info") ForceUpdateInfo forceUpdateInfo, @SerialName(PluginConstants.KEY_APP_ID) int appId, @SerialName("update_uri") String updateUri, @SerialName("update_url") String updateUrl, @SerialName("developer_name") String developerName, @SerialName("links") List links, @SerialName("download") UpdateDownloadInfo download, @SerialName("update_type") int updateType, String appInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, ForceUpdateResult$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.forceUpdateInfo = new ForceUpdateInfo(0, 0, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        } else {
            this.forceUpdateInfo = forceUpdateInfo;
        }
        if ((seen1 & 2) == 0) {
            this.appId = 0;
        } else {
            this.appId = appId;
        }
        if ((seen1 & 4) == 0) {
            this.updateUri = "";
        } else {
            this.updateUri = updateUri;
        }
        if ((seen1 & 8) == 0) {
            this.updateUrl = "";
        } else {
            this.updateUrl = updateUrl;
        }
        if ((seen1 & 16) == 0) {
            this.developerName = "";
        } else {
            this.developerName = developerName;
        }
        if ((seen1 & 32) == 0) {
            this.links = new ArrayList();
        } else {
            this.links = links;
        }
        if ((seen1 & 64) == 0) {
            this.download = new UpdateDownloadInfo((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        } else {
            this.download = download;
        }
        if ((seen1 & 128) == 0) {
            this.updateType = 0;
        } else {
            this.updateType = updateType;
        }
        if ((seen1 & 256) == 0) {
            this.appInfo = this.developerName + " 版本号: " + this.download.getVersionName();
        } else {
            this.appInfo = appInfo;
        }
    }

    public ForceUpdateResult(ForceUpdateInfo forceUpdateInfo, int appId, String updateUri, String updateUrl, String developerName, List<UpdateFuncLink> links, UpdateDownloadInfo download, int updateType) {
        Intrinsics.checkNotNullParameter(forceUpdateInfo, "forceUpdateInfo");
        Intrinsics.checkNotNullParameter(updateUri, "updateUri");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(download, "download");
        this.forceUpdateInfo = forceUpdateInfo;
        this.appId = appId;
        this.updateUri = updateUri;
        this.updateUrl = updateUrl;
        this.developerName = developerName;
        this.links = links;
        this.download = download;
        this.updateType = updateType;
        this.appInfo = developerName + " 版本号: " + download.getVersionName();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_update_release(ForceUpdateResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.forceUpdateInfo, new ForceUpdateInfo(0, 0, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null));
        if (z2) {
            output.encodeSerializableElement(serialDesc, 0, ForceUpdateInfo$$serializer.INSTANCE, self.forceUpdateInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appId != 0) {
            output.encodeIntElement(serialDesc, 1, self.appId);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.updateUri, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 2, self.updateUri);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.updateUrl, "");
        if (z4) {
            output.encodeStringElement(serialDesc, 3, self.updateUrl);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.developerName, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 4, self.developerName);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.links, new ArrayList());
        if (z6) {
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.links);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.download, new UpdateDownloadInfo((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null));
        if (z7) {
            output.encodeSerializableElement(serialDesc, 6, UpdateDownloadInfo$$serializer.INSTANCE, self.download);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.updateType != 0) {
            output.encodeIntElement(serialDesc, 7, self.updateType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.appInfo, self.developerName + " 版本号: " + self.download.getVersionName())) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 8, self.appInfo);
        }
    }

    public /* synthetic */ ForceUpdateResult(ForceUpdateInfo forceUpdateInfo, int i, String str, String str2, String str3, List list, UpdateDownloadInfo updateDownloadInfo, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ForceUpdateInfo(0, 0, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null) : forceUpdateInfo, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) == 0 ? str3 : "", (i3 & 32) != 0 ? new ArrayList() : list, (i3 & 64) != 0 ? new UpdateDownloadInfo((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : updateDownloadInfo, (i3 & 128) == 0 ? i2 : 0);
    }

    public final ForceUpdateInfo getForceUpdateInfo() {
        return this.forceUpdateInfo;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getUpdateUri() {
        return this.updateUri;
    }

    public final void setUpdateUri(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateUri = str;
    }

    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    public final void setUpdateUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateUrl = str;
    }

    public final String getDeveloperName() {
        return this.developerName;
    }

    public final List<UpdateFuncLink> getLinks() {
        return this.links;
    }

    public final UpdateDownloadInfo getDownload() {
        return this.download;
    }

    public final int getUpdateType() {
        return this.updateType;
    }

    public final String getAppInfo() {
        return this.appInfo;
    }

    public final void updateSessionId() {
        String sessionId = UpdateTracker.INSTANCE.getSessionId();
        this.updateUrl = StringsKt.replace(this.updateUrl, "{SID}", sessionId, true);
        this.updateUri = StringsKt.replace(this.updateUri, "{SID}", sessionId, true);
        UpdateDownloadInfo updateDownloadInfo = this.download;
        updateDownloadInfo.setUrl(StringsKt.replace(updateDownloadInfo.getUrl(), "{SID}", sessionId, true));
    }
}
