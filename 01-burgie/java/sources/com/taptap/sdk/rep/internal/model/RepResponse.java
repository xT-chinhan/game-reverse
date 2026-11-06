package com.taptap.sdk.rep.internal.model;

import com.bytedance.pangle.provider.ContentProviderManager;
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

/* JADX INFO: compiled from: RepResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lcom/taptap/sdk/rep/internal/model/RepResponse;", "", "seen1", "", ContentProviderManager.PROVIDER_URI, "", BreakpointSQLiteKey.URL, "chSrcPrefix", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChSrcPrefix$annotations", "()V", "getChSrcPrefix", "()Ljava/lang/String;", "getUri$annotations", "getUri", "getUrl$annotations", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_rep_release", "$serializer", "Companion", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class RepResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String chSrcPrefix;
    private final String uri;
    private final String url;

    public RepResponse() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RepResponse copy$default(RepResponse repResponse, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = repResponse.uri;
        }
        if ((i & 2) != 0) {
            str2 = repResponse.url;
        }
        if ((i & 4) != 0) {
            str3 = repResponse.chSrcPrefix;
        }
        return repResponse.copy(str, str2, str3);
    }

    @SerialName("ch_src_prefix")
    public static /* synthetic */ void getChSrcPrefix$annotations() {
    }

    @SerialName(ContentProviderManager.PROVIDER_URI)
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName(BreakpointSQLiteKey.URL)
    public static /* synthetic */ void getUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChSrcPrefix() {
        return this.chSrcPrefix;
    }

    public final RepResponse copy(String uri, String url, String chSrcPrefix) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(chSrcPrefix, "chSrcPrefix");
        return new RepResponse(uri, url, chSrcPrefix);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepResponse)) {
            return false;
        }
        RepResponse repResponse = (RepResponse) other;
        return Intrinsics.areEqual(this.uri, repResponse.uri) && Intrinsics.areEqual(this.url, repResponse.url) && Intrinsics.areEqual(this.chSrcPrefix, repResponse.chSrcPrefix);
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + this.url.hashCode()) * 31) + this.chSrcPrefix.hashCode();
    }

    public String toString() {
        return "RepResponse(uri=" + this.uri + ", url=" + this.url + ", chSrcPrefix=" + this.chSrcPrefix + ')';
    }

    /* JADX INFO: compiled from: RepResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/rep/internal/model/RepResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/rep/internal/model/RepResponse;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RepResponse> serializer() {
            return RepResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RepResponse(int seen1, @SerialName(ContentProviderManager.PROVIDER_URI) String uri, @SerialName(BreakpointSQLiteKey.URL) String url, @SerialName("ch_src_prefix") String chSrcPrefix, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, RepResponse$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.uri = "";
        } else {
            this.uri = uri;
        }
        if ((seen1 & 2) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen1 & 4) == 0) {
            this.chSrcPrefix = "";
        } else {
            this.chSrcPrefix = chSrcPrefix;
        }
    }

    public RepResponse(String uri, String url, String chSrcPrefix) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(chSrcPrefix, "chSrcPrefix");
        this.uri = uri;
        this.url = url;
        this.chSrcPrefix = chSrcPrefix;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_rep_release(RepResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.uri, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.uri);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.url, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 1, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.chSrcPrefix, "")) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 2, self.chSrcPrefix);
        }
    }

    public /* synthetic */ RepResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getChSrcPrefix() {
        return this.chSrcPrefix;
    }
}
