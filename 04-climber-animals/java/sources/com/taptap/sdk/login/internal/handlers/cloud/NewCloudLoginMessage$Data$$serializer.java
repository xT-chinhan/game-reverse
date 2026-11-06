package com.taptap.sdk.login.internal.handlers.cloud;

import com.anythink.core.common.e.f;
import com.taptap.sdk.login.internal.bean.LoginRequest;
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

/* JADX INFO: compiled from: NewCloudLoginMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/login/internal/handlers/cloud/NewCloudLoginMessage.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/NewCloudLoginMessage$Data;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", f.a.d, "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class NewCloudLoginMessage$Data$$serializer implements GeneratedSerializer<NewCloudLoginMessage.Data> {
    public static final NewCloudLoginMessage$Data$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NewCloudLoginMessage$Data$$serializer newCloudLoginMessage$Data$$serializer = new NewCloudLoginMessage$Data$$serializer();
        INSTANCE = newCloudLoginMessage$Data$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.login.internal.handlers.cloud.NewCloudLoginMessage.Data", newCloudLoginMessage$Data$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_CLIENT_ID, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_PERMISSIONS, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_STATE, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_SDK_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.screen.portrait", false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_INFO, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_TRACK_INFO, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_LOGIN_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_RESPONSE_TYPE, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_REDIRECT_URI, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_CODE_CHALLENGE, true);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_CODE_CHALLENGE_METHOD, false);
        pluginGeneratedSerialDescriptor.addElement(LoginRequest.REQ_KEY_EXTRA, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NewCloudLoginMessage$Data$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public NewCloudLoginMessage.Data deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        String str;
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        String str6;
        String str7;
        String str8;
        Object objDecodeNullableSerializableElement;
        int i;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 9;
        int i3 = 7;
        int i4 = 3;
        String strDecodeStringElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            i = 8191;
            str8 = strDecodeStringElement4;
            str = strDecodeStringElement5;
            str3 = strDecodeStringElement11;
            str5 = strDecodeStringElement9;
            str4 = strDecodeStringElement8;
            str6 = strDecodeStringElement7;
            str7 = strDecodeStringElement6;
            str2 = strDecodeStringElement10;
            z = zDecodeBooleanElement;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 12);
        } else {
            int i5 = 12;
            objDecodeSerializableElement = null;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            boolean z2 = true;
            int i6 = 0;
            boolean zDecodeBooleanElement2 = false;
            Object objDecodeNullableSerializableElement2 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 0:
                        c = 2;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i6 |= 1;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        i4 = 3;
                        break;
                    case 1:
                        c = 2;
                        objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), objDecodeSerializableElement);
                        i6 |= 2;
                        i5 = 12;
                        i2 = 9;
                        i3 = 7;
                        i4 = 3;
                        break;
                    case 2:
                        i6 |= 4;
                        i4 = i4;
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 = 12;
                        break;
                    case 3:
                        int i7 = i4;
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i7);
                        i6 |= 8;
                        i4 = i7;
                        i5 = 12;
                        break;
                    case 4:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i6 |= 16;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 5:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i6 |= 32;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 6:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
                        i6 |= 64;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 7:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i6 |= 128;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 8:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i6 |= 256;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 9:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i2);
                        i6 |= 512;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 10:
                        objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, objDecodeNullableSerializableElement2);
                        i6 |= 1024;
                        i5 = 12;
                        i4 = 3;
                        break;
                    case 11:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
                        i6 |= 2048;
                        break;
                    case 12:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i5);
                        i6 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = strDecodeStringElement12;
            strDecodeStringElement = strDecodeStringElement19;
            strDecodeStringElement2 = strDecodeStringElement20;
            str2 = strDecodeStringElement17;
            str3 = strDecodeStringElement18;
            str4 = strDecodeStringElement15;
            str5 = strDecodeStringElement16;
            z = zDecodeBooleanElement2;
            str6 = strDecodeStringElement14;
            str7 = strDecodeStringElement13;
            str8 = strDecodeStringElement3;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement2;
            i = i6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new NewCloudLoginMessage.Data(i, str8, (String[]) objDecodeSerializableElement, str, str7, z, str6, str4, str5, str2, str3, (String) objDecodeNullableSerializableElement, strDecodeStringElement, strDecodeStringElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, NewCloudLoginMessage.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        NewCloudLoginMessage.Data.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
