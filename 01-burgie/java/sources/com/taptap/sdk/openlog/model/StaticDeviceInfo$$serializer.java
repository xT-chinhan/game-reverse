package com.taptap.sdk.openlog.model;

import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: StaticDeviceInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/openlog/model/StaticDeviceInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/openlog/model/StaticDeviceInfo;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class StaticDeviceInfo$$serializer implements GeneratedSerializer<StaticDeviceInfo> {
    public static final StaticDeviceInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StaticDeviceInfo$$serializer staticDeviceInfo$$serializer = new StaticDeviceInfo$$serializer();
        INSTANCE = staticDeviceInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.openlog.model.StaticDeviceInfo", staticDeviceInfo$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("app_package_name", false);
        pluginGeneratedSerialDescriptor.addElement("app_version", false);
        pluginGeneratedSerialDescriptor.addElement("app_version_code", false);
        pluginGeneratedSerialDescriptor.addElement("pn", true);
        pluginGeneratedSerialDescriptor.addElement("platform", true);
        pluginGeneratedSerialDescriptor.addElement("device_id", false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_INSTALL_UUID, false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_ANDROID_ID, false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_DV, false);
        pluginGeneratedSerialDescriptor.addElement("md", false);
        pluginGeneratedSerialDescriptor.addElement("cpu", false);
        pluginGeneratedSerialDescriptor.addElement("cpu_abis", false);
        pluginGeneratedSerialDescriptor.addElement("os", true);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_SV, false);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_TOTAL_ROM, false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.SUB_TOTAL_RAM, false);
        pluginGeneratedSerialDescriptor.addElement("hardware", false);
        pluginGeneratedSerialDescriptor.addElement("sdk_locale", false);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.OPEN_ID, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StaticDeviceInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StaticDeviceInfo deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String strDecodeStringElement;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String strDecodeStringElement2;
        String str17;
        String str18;
        int i;
        String str19;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        char c = 7;
        int i4 = 8;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
            String str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            String str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 12);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 13);
            String strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 14);
            String strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 15);
            String strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 16);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 17);
            String str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, null);
            String strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 19);
            str2 = str24;
            str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 20, StringSerializer.INSTANCE, null);
            str7 = strDecodeStringElement5;
            str11 = strDecodeStringElement9;
            str17 = strDecodeStringElement15;
            i = 2097151;
            str5 = str21;
            str3 = str22;
            str9 = strDecodeStringElement7;
            str8 = strDecodeStringElement6;
            str4 = strDecodeStringElement4;
            str = str23;
            str16 = strDecodeStringElement14;
            str13 = strDecodeStringElement11;
            str18 = str20;
            str10 = strDecodeStringElement8;
            str6 = strDecodeStringElement3;
            str12 = strDecodeStringElement10;
            str15 = strDecodeStringElement13;
            str14 = strDecodeStringElement12;
        } else {
            String strDecodeStringElement16 = null;
            int i5 = 0;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            String strDecodeStringElement21 = null;
            String strDecodeStringElement22 = null;
            String strDecodeStringElement23 = null;
            String strDecodeStringElement24 = null;
            String strDecodeStringElement25 = null;
            String strDecodeStringElement26 = null;
            String strDecodeStringElement27 = null;
            String strDecodeStringElement28 = null;
            String strDecodeStringElement29 = null;
            String strDecodeStringElement30 = null;
            boolean z = true;
            String str30 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 8;
                        c = 7;
                        break;
                    case 0:
                        i5 |= 1;
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 = 8;
                        c = 7;
                        break;
                    case 1:
                        i5 |= 2;
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i4 = 8;
                        c = 7;
                        break;
                    case 2:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 |= 4;
                        i4 = 8;
                        c = 7;
                        break;
                    case 3:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i5 |= 8;
                        i4 = 8;
                        c = 7;
                        break;
                    case 4:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i5 |= 16;
                        i4 = 8;
                        c = 7;
                        break;
                    case 5:
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str25);
                        i5 |= 32;
                        i4 = 8;
                        c = 7;
                        break;
                    case 6:
                        strDecodeStringElement21 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
                        i5 |= 64;
                        c = c;
                        i4 = 8;
                        break;
                    case 7:
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str30);
                        i5 |= 128;
                        c = 7;
                        i4 = 8;
                        break;
                    case 8:
                        strDecodeStringElement22 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i4);
                        i5 |= 256;
                        c = 7;
                        break;
                    case 9:
                        strDecodeStringElement23 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
                        i5 |= 512;
                        c = 7;
                        break;
                    case 10:
                        str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str29);
                        i5 |= 1024;
                        c = 7;
                        break;
                    case 11:
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str27);
                        i5 |= 2048;
                        c = 7;
                        break;
                    case 12:
                        strDecodeStringElement24 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 12);
                        i5 |= 4096;
                        c = 7;
                        break;
                    case 13:
                        strDecodeStringElement25 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 13);
                        i5 |= 8192;
                        c = 7;
                        break;
                    case 14:
                        strDecodeStringElement26 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 14);
                        i5 |= 16384;
                        c = 7;
                        break;
                    case 15:
                        strDecodeStringElement27 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 15);
                        i2 = 32768;
                        i5 |= i2;
                        c = 7;
                        break;
                    case 16:
                        strDecodeStringElement28 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 16);
                        i2 = 65536;
                        i5 |= i2;
                        c = 7;
                        break;
                    case 17:
                        strDecodeStringElement29 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 17);
                        i5 |= 131072;
                        c = 7;
                        break;
                    case 18:
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str28);
                        i3 = 262144;
                        i5 |= i3;
                        c = 7;
                        break;
                    case 19:
                        strDecodeStringElement30 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 19);
                        i5 |= 524288;
                        c = 7;
                        break;
                    case 20:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 20, StringSerializer.INSTANCE, str26);
                        i3 = 1048576;
                        i5 |= i3;
                        c = 7;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str27;
            str2 = str28;
            str3 = str29;
            str4 = strDecodeStringElement16;
            str5 = str30;
            str6 = strDecodeStringElement17;
            strDecodeStringElement = strDecodeStringElement18;
            str7 = strDecodeStringElement19;
            str8 = strDecodeStringElement20;
            str9 = strDecodeStringElement21;
            str10 = strDecodeStringElement22;
            str11 = strDecodeStringElement23;
            str12 = strDecodeStringElement24;
            str13 = strDecodeStringElement25;
            str14 = strDecodeStringElement26;
            str15 = strDecodeStringElement27;
            str16 = strDecodeStringElement28;
            strDecodeStringElement2 = strDecodeStringElement29;
            str17 = strDecodeStringElement30;
            str18 = str25;
            i = i5;
            str19 = str26;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new StaticDeviceInfo(i, str6, str4, strDecodeStringElement, str7, str8, str18, str9, str5, str10, str11, str3, str, str12, str13, str14, str15, str16, strDecodeStringElement2, str2, str17, str19, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StaticDeviceInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        StaticDeviceInfo.write$Self$tap_core_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
