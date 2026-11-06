package com.taptap.sdk.update.bean;

import com.anythink.core.common.e.f;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ForceUpdateResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/update/bean/ForceUpdateResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", f.a.d, "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ForceUpdateResult$$serializer implements GeneratedSerializer<ForceUpdateResult> {
    public static final ForceUpdateResult$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForceUpdateResult$$serializer forceUpdateResult$$serializer = new ForceUpdateResult$$serializer();
        INSTANCE = forceUpdateResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.update.bean.ForceUpdateResult", forceUpdateResult$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("latest_info", true);
        pluginGeneratedSerialDescriptor.addElement("app_id", true);
        pluginGeneratedSerialDescriptor.addElement("update_uri", true);
        pluginGeneratedSerialDescriptor.addElement("update_url", true);
        pluginGeneratedSerialDescriptor.addElement("developer_name", true);
        pluginGeneratedSerialDescriptor.addElement("links", true);
        pluginGeneratedSerialDescriptor.addElement("download", true);
        pluginGeneratedSerialDescriptor.addElement("update_type", true);
        pluginGeneratedSerialDescriptor.addElement("appInfo", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ForceUpdateResult$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ForceUpdateInfo$$serializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, new ArrayListSerializer(UpdateFuncLink$$serializer.INSTANCE), UpdateDownloadInfo$$serializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ForceUpdateResult deserialize(Decoder decoder) {
        Object objDecodeSerializableElement;
        Object objDecodeSerializableElement2;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        String strDecodeStringElement;
        int iDecodeIntElement;
        Object objDecodeSerializableElement3;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i3 = 7;
        int i4 = 6;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            objDecodeSerializableElement3 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ForceUpdateInfo$$serializer.INSTANCE, null);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, new ArrayListSerializer(UpdateFuncLink$$serializer.INSTANCE), null);
            Object objDecodeSerializableElement4 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, UpdateDownloadInfo$$serializer.INSTANCE, null);
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 7);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
            str = strDecodeStringElement2;
            str3 = strDecodeStringElement4;
            str2 = strDecodeStringElement3;
            i = iDecodeIntElement2;
            objDecodeSerializableElement = objDecodeSerializableElement4;
            i2 = 511;
        } else {
            boolean z = true;
            int iDecodeIntElement3 = 0;
            int i5 = 0;
            objDecodeSerializableElement = null;
            Object objDecodeSerializableElement5 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            Object objDecodeSerializableElement6 = null;
            int iDecodeIntElement4 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 6;
                        break;
                    case 0:
                        objDecodeSerializableElement5 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ForceUpdateInfo$$serializer.INSTANCE, objDecodeSerializableElement5);
                        i5 |= 1;
                        i3 = 7;
                        i4 = 6;
                        break;
                    case 1:
                        c = 2;
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                        i5 |= 2;
                        i3 = 7;
                        break;
                    case 2:
                        c = 2;
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 |= 4;
                        i3 = 7;
                        break;
                    case 3:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i5 |= 8;
                        i3 = 7;
                        break;
                    case 4:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i5 |= 16;
                        i3 = 7;
                        break;
                    case 5:
                        objDecodeSerializableElement6 = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, new ArrayListSerializer(UpdateFuncLink$$serializer.INSTANCE), objDecodeSerializableElement6);
                        i5 |= 32;
                        i3 = 7;
                        break;
                    case 6:
                        objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, UpdateDownloadInfo$$serializer.INSTANCE, objDecodeSerializableElement);
                        i5 |= 64;
                        break;
                    case 7:
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, i3);
                        i5 |= 128;
                        break;
                    case 8:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 8);
                        i5 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            objDecodeSerializableElement2 = objDecodeSerializableElement6;
            i = iDecodeIntElement4;
            i2 = i5;
            str = strDecodeStringElement5;
            str2 = strDecodeStringElement6;
            str3 = strDecodeStringElement7;
            strDecodeStringElement = strDecodeStringElement8;
            iDecodeIntElement = iDecodeIntElement3;
            objDecodeSerializableElement3 = objDecodeSerializableElement5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ForceUpdateResult(i2, (ForceUpdateInfo) objDecodeSerializableElement3, i, str, str2, str3, (List) objDecodeSerializableElement2, (UpdateDownloadInfo) objDecodeSerializableElement, iDecodeIntElement, strDecodeStringElement, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ForceUpdateResult value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ForceUpdateResult.write$Self(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
