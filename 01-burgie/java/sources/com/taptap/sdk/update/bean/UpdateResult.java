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

/* JADX INFO: compiled from: UpdateResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMB\u0087\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014Bg\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003Jk\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010>\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\u0006\u0010A\u001a\u00020\u0011J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\u0006\u0010C\u001a\u00020DJ&\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JHÁ\u0001¢\u0006\u0002\bKR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001cR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010'R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010+R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010+R\u001c\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u001cR$\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0017\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010+¨\u0006N"}, d2 = {"Lcom/taptap/sdk/update/bean/UpdateResult;", "", "seen1", "", "appId", "updateUri", "", "updateUriTpl", "updateUrl", "updateUrlTpl", "developerName", "links", "", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "download", "Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "notify", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;Z)V", "getAppId$annotations", "()V", "getAppId", "()I", "appInfo", "getAppInfo", "()Ljava/lang/String;", "getDeveloperName$annotations", "getDeveloperName", "getDownload$annotations", "getDownload", "()Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "getLinks$annotations", "getLinks", "()Ljava/util/List;", "getNotify$annotations", "getNotify", "()Z", "getUpdateUri$annotations", "getUpdateUri", "setUpdateUri", "(Ljava/lang/String;)V", "getUpdateUriTpl$annotations", "getUpdateUriTpl", "setUpdateUriTpl", "getUpdateUrl$annotations", "getUpdateUrl", "getUpdateUrlTpl$annotations", "getUpdateUrlTpl", "setUpdateUrlTpl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "isDataValid", "toString", "updateSessionId", "", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_update_release", "$serializer", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UpdateResult {
    private final int appId;
    private final String developerName;
    private final UpdateDownloadInfo download;
    private final List<UpdateFuncLink> links;
    private final boolean notify;
    private String updateUri;
    private String updateUriTpl;
    private final String updateUrl;
    private String updateUrlTpl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(UpdateFuncLink$$serializer.INSTANCE), null, null};

    public UpdateResult() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (UpdateDownloadInfo) null, false, 511, (DefaultConstructorMarker) null);
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

    @SerialName("links")
    public static /* synthetic */ void getLinks$annotations() {
    }

    @SerialName("notify")
    public static /* synthetic */ void getNotify$annotations() {
    }

    @SerialName("update_uri")
    public static /* synthetic */ void getUpdateUri$annotations() {
    }

    @SerialName("update_uri_tpl")
    public static /* synthetic */ void getUpdateUriTpl$annotations() {
    }

    @SerialName("update_url")
    public static /* synthetic */ void getUpdateUrl$annotations() {
    }

    @SerialName("update_url_tpl")
    public static /* synthetic */ void getUpdateUrlTpl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUpdateUri() {
        return this.updateUri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdateUriTpl() {
        return this.updateUriTpl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUpdateUrlTpl() {
        return this.updateUrlTpl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDeveloperName() {
        return this.developerName;
    }

    public final List<UpdateFuncLink> component7() {
        return this.links;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final UpdateDownloadInfo getDownload() {
        return this.download;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getNotify() {
        return this.notify;
    }

    public final UpdateResult copy(int appId, String updateUri, String updateUriTpl, String updateUrl, String updateUrlTpl, String developerName, List<UpdateFuncLink> links, UpdateDownloadInfo download, boolean notify) {
        Intrinsics.checkNotNullParameter(updateUri, "updateUri");
        Intrinsics.checkNotNullParameter(updateUriTpl, "updateUriTpl");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(updateUrlTpl, "updateUrlTpl");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(links, "links");
        return new UpdateResult(appId, updateUri, updateUriTpl, updateUrl, updateUrlTpl, developerName, links, download, notify);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateResult)) {
            return false;
        }
        UpdateResult updateResult = (UpdateResult) other;
        return this.appId == updateResult.appId && Intrinsics.areEqual(this.updateUri, updateResult.updateUri) && Intrinsics.areEqual(this.updateUriTpl, updateResult.updateUriTpl) && Intrinsics.areEqual(this.updateUrl, updateResult.updateUrl) && Intrinsics.areEqual(this.updateUrlTpl, updateResult.updateUrlTpl) && Intrinsics.areEqual(this.developerName, updateResult.developerName) && Intrinsics.areEqual(this.links, updateResult.links) && Intrinsics.areEqual(this.download, updateResult.download) && this.notify == updateResult.notify;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Integer.hashCode(this.appId) * 31) + this.updateUri.hashCode()) * 31) + this.updateUriTpl.hashCode()) * 31) + this.updateUrl.hashCode()) * 31) + this.updateUrlTpl.hashCode()) * 31) + this.developerName.hashCode()) * 31) + this.links.hashCode()) * 31;
        UpdateDownloadInfo updateDownloadInfo = this.download;
        return ((iHashCode + (updateDownloadInfo == null ? 0 : updateDownloadInfo.hashCode())) * 31) + Boolean.hashCode(this.notify);
    }

    public String toString() {
        return "UpdateResult(appId=" + this.appId + ", updateUri=" + this.updateUri + ", updateUriTpl=" + this.updateUriTpl + ", updateUrl=" + this.updateUrl + ", updateUrlTpl=" + this.updateUrlTpl + ", developerName=" + this.developerName + ", links=" + this.links + ", download=" + this.download + ", notify=" + this.notify + ')';
    }

    /* JADX INFO: compiled from: UpdateResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/update/bean/UpdateResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/update/bean/UpdateResult;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UpdateResult> serializer() {
            return UpdateResult$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UpdateResult(int seen1, @SerialName(PluginConstants.KEY_APP_ID) int appId, @SerialName("update_uri") String updateUri, @SerialName("update_uri_tpl") String updateUriTpl, @SerialName("update_url") String updateUrl, @SerialName("update_url_tpl") String updateUrlTpl, @SerialName("developer_name") String developerName, @SerialName("links") List links, @SerialName("download") UpdateDownloadInfo download, @SerialName("notify") boolean notify, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, UpdateResult$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.appId = 0;
        } else {
            this.appId = appId;
        }
        if ((seen1 & 2) == 0) {
            this.updateUri = "";
        } else {
            this.updateUri = updateUri;
        }
        if ((seen1 & 4) == 0) {
            this.updateUriTpl = "";
        } else {
            this.updateUriTpl = updateUriTpl;
        }
        if ((seen1 & 8) == 0) {
            this.updateUrl = "";
        } else {
            this.updateUrl = updateUrl;
        }
        if ((seen1 & 16) == 0) {
            this.updateUrlTpl = "";
        } else {
            this.updateUrlTpl = updateUrlTpl;
        }
        if ((seen1 & 32) == 0) {
            this.developerName = "";
        } else {
            this.developerName = developerName;
        }
        if ((seen1 & 64) == 0) {
            this.links = new ArrayList();
        } else {
            this.links = links;
        }
        if ((seen1 & 128) == 0) {
            this.download = null;
        } else {
            this.download = download;
        }
        if ((seen1 & 256) == 0) {
            this.notify = false;
        } else {
            this.notify = notify;
        }
    }

    public UpdateResult(int appId, String updateUri, String updateUriTpl, String updateUrl, String updateUrlTpl, String developerName, List<UpdateFuncLink> links, UpdateDownloadInfo download, boolean notify) {
        Intrinsics.checkNotNullParameter(updateUri, "updateUri");
        Intrinsics.checkNotNullParameter(updateUriTpl, "updateUriTpl");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(updateUrlTpl, "updateUrlTpl");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(links, "links");
        this.appId = appId;
        this.updateUri = updateUri;
        this.updateUriTpl = updateUriTpl;
        this.updateUrl = updateUrl;
        this.updateUrlTpl = updateUrlTpl;
        this.developerName = developerName;
        this.links = links;
        this.download = download;
        this.notify = notify;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_update_release(UpdateResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z = false;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.appId != 0) {
            output.encodeIntElement(serialDesc, 0, self.appId);
        }
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.updateUri, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 1, self.updateUri);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.updateUriTpl, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 2, self.updateUriTpl);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.updateUrl, "");
        if (z4) {
            output.encodeStringElement(serialDesc, 3, self.updateUrl);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.updateUrlTpl, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 4, self.updateUrlTpl);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.developerName, "");
        if (z6) {
            output.encodeStringElement(serialDesc, 5, self.developerName);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.links, new ArrayList());
        if (z7) {
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.links);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.download != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, UpdateDownloadInfo$$serializer.INSTANCE, self.download);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.notify) {
            z = true;
        }
        if (z) {
            output.encodeBooleanElement(serialDesc, 8, self.notify);
        }
    }

    public /* synthetic */ UpdateResult(int i, String str, String str2, String str3, String str4, String str5, List list, UpdateDownloadInfo updateDownloadInfo, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? new ArrayList() : list, (i2 & 128) != 0 ? null : updateDownloadInfo, (i2 & 256) == 0 ? z : false);
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

    public final String getUpdateUriTpl() {
        return this.updateUriTpl;
    }

    public final void setUpdateUriTpl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateUriTpl = str;
    }

    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    public final String getUpdateUrlTpl() {
        return this.updateUrlTpl;
    }

    public final void setUpdateUrlTpl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateUrlTpl = str;
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

    public final boolean getNotify() {
        return this.notify;
    }

    public final String getAppInfo() {
        String str;
        UpdateDownloadInfo it = this.download;
        if (it != null && (str = this.developerName + " 版本号: " + it.getVersionName()) != null) {
            return str;
        }
        return this.developerName;
    }

    public final boolean isDataValid() {
        if (this.updateUriTpl.length() > 0) {
            if (this.updateUrlTpl.length() > 0) {
                UpdateDownloadInfo updateDownloadInfo = this.download;
                String urlTpl = updateDownloadInfo != null ? updateDownloadInfo.getUrlTpl() : null;
                if (!(urlTpl == null || urlTpl.length() == 0)) {
                    UpdateDownloadInfo updateDownloadInfo2 = this.download;
                    String versionName = updateDownloadInfo2 != null ? updateDownloadInfo2.getVersionName() : null;
                    if (!(versionName == null || versionName.length() == 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void updateSessionId() {
        String strReplace;
        String urlTpl;
        String sessionId = UpdateTracker.INSTANCE.getSessionId();
        this.updateUriTpl = StringsKt.replace(this.updateUriTpl, "{SID}", sessionId, true);
        this.updateUrlTpl = StringsKt.replace(this.updateUrlTpl, "{SID}", sessionId, true);
        UpdateDownloadInfo updateDownloadInfo = this.download;
        if (updateDownloadInfo == null) {
            return;
        }
        if (updateDownloadInfo == null || (urlTpl = updateDownloadInfo.getUrlTpl()) == null || (strReplace = StringsKt.replace(urlTpl, "{SID}", sessionId, true)) == null) {
            strReplace = "";
        }
        updateDownloadInfo.setUrlTpl(strReplace);
    }
}
