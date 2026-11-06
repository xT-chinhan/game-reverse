package com.taptap.sdk.compliance.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BO\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB;\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J?\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J!\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÇ\u0001R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0018¨\u0006."}, d2 = {"Lcom/taptap/sdk/compliance/bean/TimeRangeConfig;", "", "seen1", "", "timeStart", "", "timeEnd", "text", "Lcom/taptap/sdk/compliance/bean/UITipsText;", "holidays", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/compliance/bean/UITipsText;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/compliance/bean/UITipsText;Ljava/util/List;)V", "getHolidays$annotations", "()V", "getHolidays", "()Ljava/util/List;", "getText$annotations", "getText", "()Lcom/taptap/sdk/compliance/bean/UITipsText;", "getTimeEnd$annotations", "getTimeEnd", "()Ljava/lang/String;", "getTimeStart$annotations", "getTimeStart", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TimeRangeConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> holidays;
    private final UITipsText text;
    private final String timeEnd;
    private final String timeStart;

    public TimeRangeConfig() {
        this((String) null, (String) null, (UITipsText) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeRangeConfig copy$default(TimeRangeConfig timeRangeConfig, String str, String str2, UITipsText uITipsText, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeRangeConfig.timeStart;
        }
        if ((i & 2) != 0) {
            str2 = timeRangeConfig.timeEnd;
        }
        if ((i & 4) != 0) {
            uITipsText = timeRangeConfig.text;
        }
        if ((i & 8) != 0) {
            list = timeRangeConfig.holidays;
        }
        return timeRangeConfig.copy(str, str2, uITipsText, list);
    }

    @SerialName("holidays")
    public static /* synthetic */ void getHolidays$annotations() {
    }

    @SerialName("text")
    public static /* synthetic */ void getText$annotations() {
    }

    @SerialName("time_end")
    public static /* synthetic */ void getTimeEnd$annotations() {
    }

    @SerialName("time_start")
    public static /* synthetic */ void getTimeStart$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTimeStart() {
        return this.timeStart;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTimeEnd() {
        return this.timeEnd;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UITipsText getText() {
        return this.text;
    }

    public final List<String> component4() {
        return this.holidays;
    }

    public final TimeRangeConfig copy(String timeStart, String timeEnd, UITipsText text, List<String> holidays) {
        return new TimeRangeConfig(timeStart, timeEnd, text, holidays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeRangeConfig)) {
            return false;
        }
        TimeRangeConfig timeRangeConfig = (TimeRangeConfig) other;
        return Intrinsics.areEqual(this.timeStart, timeRangeConfig.timeStart) && Intrinsics.areEqual(this.timeEnd, timeRangeConfig.timeEnd) && Intrinsics.areEqual(this.text, timeRangeConfig.text) && Intrinsics.areEqual(this.holidays, timeRangeConfig.holidays);
    }

    public int hashCode() {
        String str = this.timeStart;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.timeEnd;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        UITipsText uITipsText = this.text;
        int iHashCode3 = (iHashCode2 + (uITipsText == null ? 0 : uITipsText.hashCode())) * 31;
        List<String> list = this.holidays;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TimeRangeConfig(timeStart=" + this.timeStart + ", timeEnd=" + this.timeEnd + ", text=" + this.text + ", holidays=" + this.holidays + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/TimeRangeConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/TimeRangeConfig;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TimeRangeConfig> serializer() {
            return TimeRangeConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TimeRangeConfig(int i, @SerialName("time_start") String str, @SerialName("time_end") String str2, @SerialName("text") UITipsText uITipsText, @SerialName("holidays") List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TimeRangeConfig$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.timeStart = "";
        } else {
            this.timeStart = str;
        }
        if ((i & 2) == 0) {
            this.timeEnd = "";
        } else {
            this.timeEnd = str2;
        }
        if ((i & 4) == 0) {
            this.text = null;
        } else {
            this.text = uITipsText;
        }
        if ((i & 8) == 0) {
            this.holidays = null;
        } else {
            this.holidays = list;
        }
    }

    public TimeRangeConfig(String str, String str2, UITipsText uITipsText, List<String> list) {
        this.timeStart = str;
        this.timeEnd = str2;
        this.text = uITipsText;
        this.holidays = list;
    }

    @JvmStatic
    public static final void write$Self(TimeRangeConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.timeStart, "")) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.timeStart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.timeEnd, "")) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.timeEnd);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, UITipsText$$serializer.INSTANCE, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.holidays != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, new ArrayListSerializer(StringSerializer.INSTANCE), self.holidays);
        }
    }

    public /* synthetic */ TimeRangeConfig(String str, String str2, UITipsText uITipsText, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : uITipsText, (i & 8) != 0 ? null : list);
    }

    public final String getTimeStart() {
        return this.timeStart;
    }

    public final String getTimeEnd() {
        return this.timeEnd;
    }

    public final UITipsText getText() {
        return this.text;
    }

    public final List<String> getHolidays() {
        return this.holidays;
    }
}
