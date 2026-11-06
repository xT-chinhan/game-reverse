package com.taptap.sdk.login.impl.data.model;

import com.tapsdk.tapad.group.constants.Constants;
import java.util.List;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NewCloudLoginMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/login/impl/data/model/NewCloudLoginMessage.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class NewCloudLoginMessage$Data$$serializer implements GeneratedSerializer<NewCloudLoginMessage.Data> {
    public static final NewCloudLoginMessage$Data$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        NewCloudLoginMessage$Data$$serializer newCloudLoginMessage$Data$$serializer = new NewCloudLoginMessage$Data$$serializer();
        INSTANCE = newCloudLoginMessage$Data$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.login.impl.data.model.NewCloudLoginMessage.Data", newCloudLoginMessage$Data$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.client_id", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.permissions", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.state", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.sdk_version", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.screen.portrait", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.info", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.track_info", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.login_version", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.response_type", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.redirect_uri", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.code_challenge", true);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.code_challenge_method", false);
        pluginGeneratedSerialDescriptor.addElement("com.taptap.sdk.request.extra", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private NewCloudLoginMessage$Data$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, NewCloudLoginMessage.Data.$childSerializers[1], StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public NewCloudLoginMessage.Data deserialize(Decoder decoder) {
        List list;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strDecodeStringElement;
        String strDecodeStringElement2;
        boolean z;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = NewCloudLoginMessage.Data.$childSerializers;
        int i2 = 9;
        char c = 4;
        String strDecodeStringElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
            String strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
            String strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
            String strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
            String strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            String strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            str = strDecodeStringElement5;
            str2 = strDecodeStringElement6;
            str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            str7 = strDecodeStringElement11;
            str5 = strDecodeStringElement9;
            str4 = strDecodeStringElement8;
            str3 = strDecodeStringElement7;
            z = zDecodeBooleanElement;
            str6 = strDecodeStringElement10;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 12);
            i = 8191;
            list = list2;
            str9 = strDecodeStringElement4;
        } else {
            int i3 = 12;
            int i4 = 0;
            boolean zDecodeBooleanElement2 = false;
            boolean z2 = true;
            List list3 = null;
            String str10 = null;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            String strDecodeStringElement19 = null;
            String strDecodeStringElement20 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        i3 = 12;
                        i2 = 9;
                        c = 4;
                        break;
                    case 0:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i4 |= 1;
                        i3 = 12;
                        i2 = 9;
                        c = 4;
                        break;
                    case 1:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], list3);
                        i4 |= 2;
                        i3 = 12;
                        i2 = 9;
                        c = 4;
                        break;
                    case 2:
                        strDecodeStringElement12 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i4 |= 4;
                        i3 = 12;
                        c = 4;
                        break;
                    case 3:
                        strDecodeStringElement13 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i4 |= 8;
                        i3 = 12;
                        c = 4;
                        break;
                    case 4:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 4);
                        i4 |= 16;
                        c = 4;
                        i3 = 12;
                        break;
                    case 5:
                        strDecodeStringElement14 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 5);
                        i4 |= 32;
                        i3 = 12;
                        c = 4;
                        break;
                    case 6:
                        strDecodeStringElement15 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 6);
                        i4 |= 64;
                        i3 = 12;
                        c = 4;
                        break;
                    case 7:
                        strDecodeStringElement16 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 7);
                        i4 |= 128;
                        i3 = 12;
                        c = 4;
                        break;
                    case 8:
                        strDecodeStringElement17 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i4 |= 256;
                        i3 = 12;
                        c = 4;
                        break;
                    case 9:
                        strDecodeStringElement18 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i2);
                        i4 |= 512;
                        i3 = 12;
                        c = 4;
                        break;
                    case 10:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str10);
                        i4 |= 1024;
                        i3 = 12;
                        c = 4;
                        break;
                    case 11:
                        strDecodeStringElement19 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
                        i4 |= 2048;
                        break;
                    case 12:
                        strDecodeStringElement20 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i3);
                        i4 |= 4096;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list3;
            i = i4;
            str = strDecodeStringElement12;
            str2 = strDecodeStringElement13;
            str3 = strDecodeStringElement14;
            str4 = strDecodeStringElement15;
            str5 = strDecodeStringElement16;
            str6 = strDecodeStringElement17;
            str7 = strDecodeStringElement18;
            strDecodeStringElement = strDecodeStringElement19;
            strDecodeStringElement2 = strDecodeStringElement20;
            z = zDecodeBooleanElement2;
            str8 = str10;
            str9 = strDecodeStringElement3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new NewCloudLoginMessage.Data(i, str9, list, str, str2, z, str3, str4, str5, str6, str7, str8, strDecodeStringElement, strDecodeStringElement2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, NewCloudLoginMessage.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        NewCloudLoginMessage.Data.write$Self$tap_login_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
