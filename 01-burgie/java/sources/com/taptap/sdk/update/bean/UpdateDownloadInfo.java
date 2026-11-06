package com.taptap.sdk.update.bean;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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

/* JADX INFO: compiled from: UpdateResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006*"}, d2 = {"Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "", "seen1", "", "versionName", "", BreakpointSQLiteKey.URL, "urlTpl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUrlTpl$annotations", "getUrlTpl", "setUrlTpl", "getVersionName$annotations", "getVersionName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_update_release", "$serializer", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UpdateDownloadInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String url;
    private String urlTpl;
    private final String versionName;

    public UpdateDownloadInfo() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UpdateDownloadInfo copy$default(UpdateDownloadInfo updateDownloadInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateDownloadInfo.versionName;
        }
        if ((i & 2) != 0) {
            str2 = updateDownloadInfo.url;
        }
        if ((i & 4) != 0) {
            str3 = updateDownloadInfo.urlTpl;
        }
        return updateDownloadInfo.copy(str, str2, str3);
    }

    @SerialName(BreakpointSQLiteKey.URL)
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("url_tpl")
    public static /* synthetic */ void getUrlTpl$annotations() {
    }

    @SerialName(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)
    public static /* synthetic */ void getVersionName$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrlTpl() {
        return this.urlTpl;
    }

    public final UpdateDownloadInfo copy(String versionName, String url, String urlTpl) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTpl, "urlTpl");
        return new UpdateDownloadInfo(versionName, url, urlTpl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateDownloadInfo)) {
            return false;
        }
        UpdateDownloadInfo updateDownloadInfo = (UpdateDownloadInfo) other;
        return Intrinsics.areEqual(this.versionName, updateDownloadInfo.versionName) && Intrinsics.areEqual(this.url, updateDownloadInfo.url) && Intrinsics.areEqual(this.urlTpl, updateDownloadInfo.urlTpl);
    }

    public int hashCode() {
        return (((this.versionName.hashCode() * 31) + this.url.hashCode()) * 31) + this.urlTpl.hashCode();
    }

    public String toString() {
        return "UpdateDownloadInfo(versionName=" + this.versionName + ", url=" + this.url + ", urlTpl=" + this.urlTpl + ')';
    }

    /* JADX INFO: compiled from: UpdateResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/update/bean/UpdateDownloadInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/update/bean/UpdateDownloadInfo;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UpdateDownloadInfo> serializer() {
            return UpdateDownloadInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UpdateDownloadInfo(int seen1, @SerialName(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME) String versionName, @SerialName(BreakpointSQLiteKey.URL) String url, @SerialName("url_tpl") String urlTpl, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, UpdateDownloadInfo$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.versionName = "-";
        } else {
            this.versionName = versionName;
        }
        if ((seen1 & 2) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen1 & 4) == 0) {
            this.urlTpl = "";
        } else {
            this.urlTpl = urlTpl;
        }
    }

    public UpdateDownloadInfo(String versionName, String url, String urlTpl) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTpl, "urlTpl");
        this.versionName = versionName;
        this.url = url;
        this.urlTpl = urlTpl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_update_release(UpdateDownloadInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.versionName, "-");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.versionName);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.url, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 1, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.urlTpl, "")) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 2, self.urlTpl);
        }
    }

    public /* synthetic */ UpdateDownloadInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "-" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getUrlTpl() {
        return this.urlTpl;
    }

    public final void setUrlTpl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.urlTpl = str;
    }
}
