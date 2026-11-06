package com.taptap.sdk.openlog.model;

import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.z;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: OpenLogConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/openlog/model/OpenLogConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/openlog/model/OpenLogConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class OpenLogConfig$$serializer implements GeneratedSerializer<OpenLogConfig> {
    public static final OpenLogConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        OpenLogConfig$$serializer openLogConfig$$serializer = new OpenLogConfig$$serializer();
        INSTANCE = openLogConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.openlog.model.OpenLogConfig", openLogConfig$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("region", false);
        pluginGeneratedSerialDescriptor.addElement("log_level", false);
        pluginGeneratedSerialDescriptor.addElement("log_to_console", false);
        pluginGeneratedSerialDescriptor.addElement("enable_auto_test_log", false);
        pluginGeneratedSerialDescriptor.addElement("data_dir", false);
        pluginGeneratedSerialDescriptor.addElement(z.a, false);
        pluginGeneratedSerialDescriptor.addElement("platform", false);
        pluginGeneratedSerialDescriptor.addElement(z.d, false);
        pluginGeneratedSerialDescriptor.addElement("client_id", false);
        pluginGeneratedSerialDescriptor.addElement("client_token", false);
        pluginGeneratedSerialDescriptor.addElement("common", false);
        pluginGeneratedSerialDescriptor.addElement("app_duration", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OpenLogConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StaticDeviceInfo$$serializer.INSTANCE, AppDurationParams$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public OpenLogConfig deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppDurationParams appDurationParams;
        StaticDeviceInfo staticDeviceInfo;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i6 = 10;
        char c = 4;
        int i7 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            int iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            StaticDeviceInfo staticDeviceInfo2 = (StaticDeviceInfo) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, StaticDeviceInfo$$serializer.INSTANCE, null);
            appDurationParams = (AppDurationParams) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, AppDurationParams$$serializer.INSTANCE, null);
            staticDeviceInfo = staticDeviceInfo2;
            str6 = strDecodeStringElement6;
            str4 = strDecodeStringElement4;
            str3 = strDecodeStringElement3;
            str2 = strDecodeStringElement2;
            i2 = iDecodeIntElement4;
            str5 = strDecodeStringElement5;
            str = strDecodeStringElement;
            i3 = iDecodeIntElement3;
            i = 4095;
            i5 = iDecodeIntElement;
            i4 = iDecodeIntElement2;
        } else {
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            int iDecodeIntElement7 = 0;
            boolean z = true;
            AppDurationParams appDurationParams2 = null;
            StaticDeviceInfo staticDeviceInfo3 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            int iDecodeIntElement8 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        c = c;
                        z = false;
                        i6 = 10;
                        break;
                    case 0:
                        i7 |= 1;
                        c = c;
                        iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
                        i6 = 10;
                        break;
                    case 1:
                        i7 |= 2;
                        c = c;
                        iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i6 = 10;
                        break;
                    case 2:
                        iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                        i7 |= 4;
                        c = c;
                        i6 = 10;
                        break;
                    case 3:
                        i7 |= 8;
                        c = c;
                        iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
                        break;
                    case 4:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i7 |= 16;
                        c = 4;
                        break;
                    case 5:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i7 |= 32;
                        c = 4;
                        break;
                    case 6:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
                        i7 |= 64;
                        c = 4;
                        break;
                    case 7:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
                        i7 |= 128;
                        c = 4;
                        break;
                    case 8:
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i7 |= 256;
                        c = 4;
                        break;
                    case 9:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
                        i7 |= 512;
                        c = 4;
                        break;
                    case 10:
                        staticDeviceInfo3 = (StaticDeviceInfo) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, StaticDeviceInfo$$serializer.INSTANCE, staticDeviceInfo3);
                        i7 |= 1024;
                        c = 4;
                        break;
                    case 11:
                        appDurationParams2 = (AppDurationParams) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, AppDurationParams$$serializer.INSTANCE, appDurationParams2);
                        i7 |= 2048;
                        c = 4;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i7;
            i2 = iDecodeIntElement8;
            i3 = iDecodeIntElement7;
            str = strDecodeStringElement7;
            str2 = strDecodeStringElement8;
            str3 = strDecodeStringElement9;
            str4 = strDecodeStringElement10;
            str5 = strDecodeStringElement11;
            str6 = strDecodeStringElement12;
            appDurationParams = appDurationParams2;
            staticDeviceInfo = staticDeviceInfo3;
            i4 = iDecodeIntElement5;
            i5 = iDecodeIntElement6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new OpenLogConfig(i, i5, i4, i3, i2, str, str2, str3, str4, str5, str6, staticDeviceInfo, appDurationParams, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, OpenLogConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        OpenLogConfig.write$Self$tap_core_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
