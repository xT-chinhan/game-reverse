package com.taptap.sdk.initializer.gate;

import com.bytedance.pangle.provider.ContentProviderManager;
import com.kwad.sdk.api.model.AdnName;
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

/* JADX INFO: compiled from: TapGatekeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006&"}, d2 = {"Lcom/taptap/sdk/initializer/gate/Url;", "", "seen1", "", "webViewUrl", "", "browserUrl", "tapUri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrowserUrl$annotations", "()V", "getBrowserUrl", "()Ljava/lang/String;", "getTapUri$annotations", "getTapUri", "getWebViewUrl$annotations", "getWebViewUrl", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class Url {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String browserUrl;
    private final String tapUri;
    private final String webViewUrl;

    public Url() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Url copy$default(Url url, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = url.webViewUrl;
        }
        if ((i & 2) != 0) {
            str2 = url.browserUrl;
        }
        if ((i & 4) != 0) {
            str3 = url.tapUri;
        }
        return url.copy(str, str2, str3);
    }

    @SerialName("browser")
    public static /* synthetic */ void getBrowserUrl$annotations() {
    }

    @SerialName(ContentProviderManager.PROVIDER_URI)
    public static /* synthetic */ void getTapUri$annotations() {
    }

    @SerialName("webview")
    public static /* synthetic */ void getWebViewUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWebViewUrl() {
        return this.webViewUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBrowserUrl() {
        return this.browserUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTapUri() {
        return this.tapUri;
    }

    public final Url copy(String webViewUrl, String browserUrl, String tapUri) {
        Intrinsics.checkNotNullParameter(webViewUrl, "webViewUrl");
        Intrinsics.checkNotNullParameter(browserUrl, "browserUrl");
        Intrinsics.checkNotNullParameter(tapUri, "tapUri");
        return new Url(webViewUrl, browserUrl, tapUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Url)) {
            return false;
        }
        Url url = (Url) other;
        return Intrinsics.areEqual(this.webViewUrl, url.webViewUrl) && Intrinsics.areEqual(this.browserUrl, url.browserUrl) && Intrinsics.areEqual(this.tapUri, url.tapUri);
    }

    public int hashCode() {
        return (((this.webViewUrl.hashCode() * 31) + this.browserUrl.hashCode()) * 31) + this.tapUri.hashCode();
    }

    public String toString() {
        return "Url(webViewUrl=" + this.webViewUrl + ", browserUrl=" + this.browserUrl + ", tapUri=" + this.tapUri + ')';
    }

    /* JADX INFO: compiled from: TapGatekeeper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initializer/gate/Url$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/initializer/gate/Url;", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Url> serializer() {
            return Url$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Url(int i, @SerialName("webview") String str, @SerialName("browser") String str2, @SerialName(ContentProviderManager.PROVIDER_URI) String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, Url$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.webViewUrl = "";
        } else {
            this.webViewUrl = str;
        }
        if ((i & 2) == 0) {
            this.browserUrl = "";
        } else {
            this.browserUrl = str2;
        }
        if ((i & 4) == 0) {
            this.tapUri = "";
        } else {
            this.tapUri = str3;
        }
    }

    public Url(String webViewUrl, String browserUrl, String tapUri) {
        Intrinsics.checkNotNullParameter(webViewUrl, "webViewUrl");
        Intrinsics.checkNotNullParameter(browserUrl, "browserUrl");
        Intrinsics.checkNotNullParameter(tapUri, "tapUri");
        this.webViewUrl = webViewUrl;
        this.browserUrl = browserUrl;
        this.tapUri = tapUri;
    }

    @JvmStatic
    public static final void write$Self(Url self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.webViewUrl, "")) {
            output.encodeStringElement(serialDesc, 0, self.webViewUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.browserUrl, "")) {
            output.encodeStringElement(serialDesc, 1, self.browserUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.tapUri, "")) {
            output.encodeStringElement(serialDesc, 2, self.tapUri);
        }
    }

    public /* synthetic */ Url(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getWebViewUrl() {
        return this.webViewUrl;
    }

    public final String getBrowserUrl() {
        return this.browserUrl;
    }

    public final String getTapUri() {
        return this.tapUri;
    }
}
