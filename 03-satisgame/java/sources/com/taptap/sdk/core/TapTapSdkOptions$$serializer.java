package com.taptap.sdk.core;

import com.anythink.core.common.f.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.core.serialize.JSONObjectSerializer;
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
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/core/TapTapSdkOptions.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", e.a.d, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TapTapSdkOptions$$serializer implements GeneratedSerializer<TapTapSdkOptions> {
    public static final TapTapSdkOptions$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TapTapSdkOptions$$serializer tapTapSdkOptions$$serializer = new TapTapSdkOptions$$serializer();
        INSTANCE = tapTapSdkOptions$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.core.TapTapSdkOptions", tapTapSdkOptions$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("clientId", false);
        pluginGeneratedSerialDescriptor.addElement("clientToken", false);
        pluginGeneratedSerialDescriptor.addElement("region", false);
        pluginGeneratedSerialDescriptor.addElement("channel", true);
        pluginGeneratedSerialDescriptor.addElement("gameVersion", true);
        pluginGeneratedSerialDescriptor.addElement("autoIAPEventEnabled", true);
        pluginGeneratedSerialDescriptor.addElement("overrideBuiltInParameters", true);
        pluginGeneratedSerialDescriptor.addElement(TapEventParamConstants.PARAM_PROPERTIES, true);
        pluginGeneratedSerialDescriptor.addElement("oaidCert", true);
        pluginGeneratedSerialDescriptor.addElement("enableLog", true);
        pluginGeneratedSerialDescriptor.addElement("preferredLanguage", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TapTapSdkOptions$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JSONObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, TapTapLanguage.INSTANCE.serializer()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TapTapSdkOptions deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        int iDecodeIntElement;
        Object objDecodeNullableSerializableElement;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeNullableSerializableElement3;
        String strDecodeStringElement;
        Object objDecodeSerializableElement;
        Object objDecodeNullableSerializableElement4;
        int i;
        String str;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 10;
        int i3 = 9;
        int i4 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            Object objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, JSONObjectSerializer.INSTANCE, null);
            Object objDecodeNullableSerializableElement7 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 9);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, TapTapLanguage.INSTANCE.serializer(), null);
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement2;
            iDecodeIntElement = iDecodeIntElement2;
            strDecodeStringElement = strDecodeStringElement3;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement5;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement6;
            i = 2047;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement7;
            str = strDecodeStringElement2;
            zDecodeBooleanElement = zDecodeBooleanElement4;
        } else {
            boolean z3 = true;
            zDecodeBooleanElement = false;
            boolean zDecodeBooleanElement5 = false;
            iDecodeIntElement = 0;
            Object objDecodeSerializableElement2 = null;
            Object objDecodeNullableSerializableElement8 = null;
            objDecodeNullableSerializableElement = null;
            objDecodeNullableSerializableElement2 = null;
            objDecodeNullableSerializableElement3 = null;
            String strDecodeStringElement4 = null;
            strDecodeStringElement = null;
            boolean zDecodeBooleanElement6 = false;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i2 = 10;
                        break;
                    case 0:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 1:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i4 |= 2;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 2:
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                        i4 |= 4;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 3:
                        objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, objDecodeNullableSerializableElement3);
                        i4 |= 8;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 4:
                        objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, objDecodeNullableSerializableElement2);
                        i4 |= 16;
                        i2 = 10;
                        i3 = 9;
                        break;
                    case 5:
                        i4 |= 32;
                        zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        break;
                    case 6:
                        zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        objDecodeNullableSerializableElement8 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, JSONObjectSerializer.INSTANCE, objDecodeNullableSerializableElement8);
                        i4 |= 128;
                        break;
                    case 8:
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, objDecodeNullableSerializableElement);
                        i4 |= 256;
                        break;
                    case 9:
                        zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i3);
                        i4 |= 512;
                        break;
                    case 10:
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, TapTapLanguage.INSTANCE.serializer(), objDecodeSerializableElement2);
                        i4 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            objDecodeSerializableElement = objDecodeSerializableElement2;
            objDecodeNullableSerializableElement4 = objDecodeNullableSerializableElement8;
            i = i4;
            str = strDecodeStringElement4;
            boolean z4 = zDecodeBooleanElement5;
            z = zDecodeBooleanElement6;
            z2 = z4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TapTapSdkOptions(i, str, strDecodeStringElement, iDecodeIntElement, (String) objDecodeNullableSerializableElement3, (String) objDecodeNullableSerializableElement2, z2, z, (JSONObject) objDecodeNullableSerializableElement4, (String) objDecodeNullableSerializableElement, zDecodeBooleanElement, (TapTapLanguage) objDecodeSerializableElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TapTapSdkOptions value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TapTapSdkOptions.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
