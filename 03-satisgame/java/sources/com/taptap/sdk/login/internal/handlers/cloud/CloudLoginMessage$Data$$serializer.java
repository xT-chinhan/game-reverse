package com.taptap.sdk.login.internal.handlers.cloud;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.f.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CloudLoginMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/login/internal/handlers/cloud/CloudLoginMessage.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginMessage$Data;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", e.a.d, "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CloudLoginMessage$Data$$serializer implements GeneratedSerializer<CloudLoginMessage.Data> {
    public static final CloudLoginMessage$Data$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CloudLoginMessage$Data$$serializer cloudLoginMessage$Data$$serializer = new CloudLoginMessage$Data$$serializer();
        INSTANCE = cloudLoginMessage$Data$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.login.internal.handlers.cloud.CloudLoginMessage.Data", cloudLoginMessage$Data$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(TapEventParamConstants.PARAM_CLIENT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("scopes", false);
        pluginGeneratedSerialDescriptor.addElement(WebLoginFragment.QUERY_KEY_ID, false);
        pluginGeneratedSerialDescriptor.addElement("sdk_version", false);
        pluginGeneratedSerialDescriptor.addElement("portrait", false);
        pluginGeneratedSerialDescriptor.addElement(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, false);
        pluginGeneratedSerialDescriptor.addElement("sdk_track_info", false);
        pluginGeneratedSerialDescriptor.addElement("response_type", false);
        pluginGeneratedSerialDescriptor.addElement("code_challenge", true);
        pluginGeneratedSerialDescriptor.addElement("code_challenge_method", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CloudLoginMessage$Data$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CloudLoginMessage.Data deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String strDecodeStringElement3;
        int i;
        Object objDecodeNullableSerializableElement;
        Object objDecodeSerializableElement;
        String strDecodeStringElement4;
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        int i3 = 7;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), null);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            strDecodeStringElement = strDecodeStringElement5;
            strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            str = strDecodeStringElement10;
            str2 = strDecodeStringElement9;
            str3 = strDecodeStringElement8;
            strDecodeStringElement3 = strDecodeStringElement7;
            z = zDecodeBooleanElement;
            strDecodeStringElement2 = strDecodeStringElement6;
            i = 1023;
        } else {
            boolean z3 = true;
            boolean zDecodeBooleanElement2 = false;
            strDecodeStringElement = null;
            Object objDecodeSerializableElement2 = null;
            strDecodeStringElement2 = null;
            strDecodeStringElement3 = null;
            String strDecodeStringElement11 = null;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            Object objDecodeNullableSerializableElement2 = null;
            i = 0;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = 7;
                        break;
                    case 0:
                        z2 = true;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i |= 1;
                        i2 = 9;
                        i3 = 7;
                        break;
                    case 1:
                        z2 = true;
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), objDecodeSerializableElement2);
                        i |= 2;
                        i2 = 9;
                        i3 = 7;
                        break;
                    case 2:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i |= 4;
                        break;
                    case 3:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i |= 8;
                        break;
                    case 4:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i |= 16;
                        break;
                    case 5:
                        strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i |= 32;
                        break;
                    case 6:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
                        i |= 64;
                        break;
                    case 7:
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i |= 128;
                        break;
                    case 8:
                        objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, objDecodeNullableSerializableElement2);
                        i |= 256;
                        break;
                    case 9:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i2);
                        i |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
            objDecodeSerializableElement = objDecodeSerializableElement2;
            strDecodeStringElement4 = strDecodeStringElement14;
            str = strDecodeStringElement13;
            str2 = strDecodeStringElement12;
            str3 = strDecodeStringElement11;
            z = zDecodeBooleanElement2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CloudLoginMessage.Data(i, strDecodeStringElement, (String[]) objDecodeSerializableElement, strDecodeStringElement2, strDecodeStringElement3, z, str3, str2, str, (String) objDecodeNullableSerializableElement, strDecodeStringElement4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CloudLoginMessage.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CloudLoginMessage.Data.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
