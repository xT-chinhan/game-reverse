package com.taptap.sdk.core.unity.config;

import com.anythink.core.common.e.f;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CoreInitConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/core/unity/config/CoreInitConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/core/unity/config/CoreInitConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", f.a.d, "tap-core-unity_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CoreInitConfig$$serializer implements GeneratedSerializer<CoreInitConfig> {
    public static final CoreInitConfig$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CoreInitConfig$$serializer coreInitConfig$$serializer = new CoreInitConfig$$serializer();
        INSTANCE = coreInitConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.core.unity.config.CoreInitConfig", coreInitConfig$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("clientId", true);
        pluginGeneratedSerialDescriptor.addElement("clientToken", true);
        pluginGeneratedSerialDescriptor.addElement("region", true);
        pluginGeneratedSerialDescriptor.addElement("channel", true);
        pluginGeneratedSerialDescriptor.addElement("gameVersion", true);
        pluginGeneratedSerialDescriptor.addElement("autoIAPEventEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("overrideBuiltInParameters", true);
        pluginGeneratedSerialDescriptor.addElement(Common.Predefined.PROPERTIES, true);
        pluginGeneratedSerialDescriptor.addElement("oaidCert", true);
        pluginGeneratedSerialDescriptor.addElement("enableLog", true);
        pluginGeneratedSerialDescriptor.addElement("preferredLanguage", true);
        pluginGeneratedSerialDescriptor.addElement("disableReflectionOAID", true);
        pluginGeneratedSerialDescriptor.addElement("disableAutoLogDeviceLogin", true);
        pluginGeneratedSerialDescriptor.addElement("screenOrientation", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CoreInitConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CoreInitConfig deserialize(Decoder decoder) {
        int i;
        boolean zDecodeBooleanElement;
        int iDecodeIntElement;
        boolean zDecodeBooleanElement2;
        boolean z;
        boolean z2;
        String str;
        int i2;
        int i3;
        boolean z3;
        String str2;
        String str3;
        String str4;
        String str5;
        Object objDecodeNullableSerializableElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            boolean zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 9);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 10);
            i = 16383;
            str5 = strDecodeStringElement2;
            str4 = strDecodeStringElement3;
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 11);
            i3 = iDecodeIntElement3;
            z = zDecodeBooleanElement5;
            str2 = strDecodeStringElement6;
            z2 = zDecodeBooleanElement4;
            z3 = zDecodeBooleanElement3;
            str3 = strDecodeStringElement4;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
            str = strDecodeStringElement5;
            i2 = iDecodeIntElement2;
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 13);
        } else {
            int i4 = 13;
            boolean zDecodeBooleanElement6 = false;
            int iDecodeIntElement4 = 0;
            boolean zDecodeBooleanElement7 = false;
            boolean zDecodeBooleanElement8 = false;
            boolean zDecodeBooleanElement9 = false;
            boolean zDecodeBooleanElement10 = false;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            boolean z4 = true;
            int i5 = 0;
            Object objDecodeNullableSerializableElement2 = null;
            while (z4) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z4 = false;
                        break;
                    case 0:
                        i5 |= 1;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 = 13;
                        break;
                    case 1:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i5 |= 2;
                        i4 = 13;
                        break;
                    case 2:
                        iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                        i5 |= 4;
                        i4 = 13;
                        break;
                    case 3:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i5 |= 8;
                        i4 = 13;
                        break;
                    case 4:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i5 |= 16;
                        i4 = 13;
                        break;
                    case 5:
                        zDecodeBooleanElement9 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i5 |= 32;
                        i4 = 13;
                        break;
                    case 6:
                        zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
                        i5 |= 64;
                        i4 = 13;
                        break;
                    case 7:
                        objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, objDecodeNullableSerializableElement2);
                        i5 |= 128;
                        i4 = 13;
                        break;
                    case 8:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i5 |= 256;
                        break;
                    case 9:
                        zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 9);
                        i5 |= 512;
                        break;
                    case 10:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 10);
                        i5 |= 1024;
                        break;
                    case 11:
                        zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 11);
                        i5 |= 2048;
                        break;
                    case 12:
                        zDecodeBooleanElement10 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 12);
                        i5 |= 4096;
                        break;
                    case 13:
                        iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, i4);
                        i5 |= 8192;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i5;
            zDecodeBooleanElement = zDecodeBooleanElement10;
            iDecodeIntElement = iDecodeIntElement6;
            zDecodeBooleanElement2 = zDecodeBooleanElement6;
            z = zDecodeBooleanElement7;
            z2 = zDecodeBooleanElement8;
            str = strDecodeStringElement9;
            i2 = iDecodeIntElement5;
            i3 = iDecodeIntElement4;
            z3 = zDecodeBooleanElement9;
            str2 = strDecodeStringElement10;
            str3 = strDecodeStringElement8;
            str4 = strDecodeStringElement7;
            str5 = strDecodeStringElement;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CoreInitConfig(i, str5, str4, i2, str3, str, z3, z2, (String) objDecodeNullableSerializableElement, str2, z, i3, zDecodeBooleanElement2, zDecodeBooleanElement, iDecodeIntElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CoreInitConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CoreInitConfig.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
