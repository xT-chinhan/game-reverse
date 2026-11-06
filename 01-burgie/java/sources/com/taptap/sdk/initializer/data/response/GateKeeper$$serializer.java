package com.taptap.sdk.initializer.data.response;

import com.tapsdk.tapad.group.constants.Constants;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: GateKeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/initializer/data/response/GateKeeper.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class GateKeeper$$serializer implements GeneratedSerializer<GateKeeper> {
    public static final GateKeeper$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GateKeeper$$serializer gateKeeper$$serializer = new GateKeeper$$serializer();
        INSTANCE = gateKeeper$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.initializer.data.response.GateKeeper", gateKeeper$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("switch", false);
        pluginGeneratedSerialDescriptor.addElement("taptap_app_id", true);
        pluginGeneratedSerialDescriptor.addElement("urls", true);
        pluginGeneratedSerialDescriptor.addElement("config", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GateKeeper$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{GateKeeper$Switch$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), GateKeeper$Urls$$serializer.INSTANCE, GateKeeper$SdkConfig$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GateKeeper deserialize(Decoder decoder) {
        GateKeeper.Switch r3;
        int i;
        Integer num;
        GateKeeper.Urls urls;
        GateKeeper.SdkConfig sdkConfig;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            GateKeeper.Switch r2 = (GateKeeper.Switch) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, GateKeeper$Switch$$serializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, null);
            r3 = r2;
            i = 15;
            urls = (GateKeeper.Urls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, GateKeeper$Urls$$serializer.INSTANCE, null);
            num = num2;
            sdkConfig = (GateKeeper.SdkConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, GateKeeper$SdkConfig$$serializer.INSTANCE, null);
        } else {
            GateKeeper.Switch r4 = null;
            Integer num3 = null;
            GateKeeper.Urls urls2 = null;
            GateKeeper.SdkConfig sdkConfig2 = null;
            int i2 = 0;
            boolean z = true;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        r4 = (GateKeeper.Switch) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, GateKeeper$Switch$$serializer.INSTANCE, r4);
                        i2 |= 1;
                        break;
                    case 1:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, IntSerializer.INSTANCE, num3);
                        i2 |= 2;
                        break;
                    case 2:
                        urls2 = (GateKeeper.Urls) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, GateKeeper$Urls$$serializer.INSTANCE, urls2);
                        i2 |= 4;
                        break;
                    case 3:
                        sdkConfig2 = (GateKeeper.SdkConfig) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, GateKeeper$SdkConfig$$serializer.INSTANCE, sdkConfig2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            r3 = r4;
            i = i2;
            num = num3;
            urls = urls2;
            sdkConfig = sdkConfig2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new GateKeeper(i, r3, num, urls, sdkConfig, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GateKeeper value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        GateKeeper.write$Self$tap_core_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
