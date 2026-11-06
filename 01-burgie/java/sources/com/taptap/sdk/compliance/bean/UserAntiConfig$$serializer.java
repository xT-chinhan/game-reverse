package com.taptap.sdk.compliance.bean;

import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
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

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/compliance/bean/UserAntiConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/compliance/bean/UserAntiConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class UserAntiConfig$$serializer implements GeneratedSerializer<UserAntiConfig> {
    public static final UserAntiConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UserAntiConfig$$serializer userAntiConfig$$serializer = new UserAntiConfig$$serializer();
        INSTANCE = userAntiConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.compliance.bean.UserAntiConfig", userAntiConfig$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("real_name", true);
        pluginGeneratedSerialDescriptor.addElement("anti_addiction", true);
        pluginGeneratedSerialDescriptor.addElement("content_rating_check", true);
        pluginGeneratedSerialDescriptor.addElement(TapComplianceSettings.STRATEGY_LOCAL, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserAntiConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(UserState$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AntiPolicy$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AgeCheckResult$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Local$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UserAntiConfig deserialize(Decoder decoder) {
        UserState userState;
        int i;
        AntiPolicy antiPolicy;
        AgeCheckResult ageCheckResult;
        Local local;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            UserState userState2 = (UserState) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, UserState$$serializer.INSTANCE, null);
            AntiPolicy antiPolicy2 = (AntiPolicy) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AntiPolicy$$serializer.INSTANCE, null);
            userState = userState2;
            i = 15;
            ageCheckResult = (AgeCheckResult) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, AgeCheckResult$$serializer.INSTANCE, null);
            antiPolicy = antiPolicy2;
            local = (Local) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Local$$serializer.INSTANCE, null);
        } else {
            UserState userState3 = null;
            AntiPolicy antiPolicy3 = null;
            AgeCheckResult ageCheckResult2 = null;
            Local local2 = null;
            int i2 = 0;
            boolean z = true;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        userState3 = (UserState) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, UserState$$serializer.INSTANCE, userState3);
                        i2 |= 1;
                        break;
                    case 1:
                        antiPolicy3 = (AntiPolicy) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, AntiPolicy$$serializer.INSTANCE, antiPolicy3);
                        i2 |= 2;
                        break;
                    case 2:
                        ageCheckResult2 = (AgeCheckResult) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, AgeCheckResult$$serializer.INSTANCE, ageCheckResult2);
                        i2 |= 4;
                        break;
                    case 3:
                        local2 = (Local) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, Local$$serializer.INSTANCE, local2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            userState = userState3;
            i = i2;
            antiPolicy = antiPolicy3;
            ageCheckResult = ageCheckResult2;
            local = local2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new UserAntiConfig(i, userState, antiPolicy, ageCheckResult, local, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UserAntiConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        UserAntiConfig.write$Self$tap_compliance_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
