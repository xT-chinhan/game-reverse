package com.taptap.sdk.initializer.data.response;

import com.tapsdk.tapad.group.constants.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: GateKeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/taptap/sdk/initializer/data/response/GateKeeper.Urls.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/taptap/sdk/initializer/data/response/GateKeeper$Urls;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Constants.VALUE_FIELD, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class GateKeeper$Urls$$serializer implements GeneratedSerializer<GateKeeper.Urls> {
    public static final GateKeeper$Urls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GateKeeper$Urls$$serializer gateKeeper$Urls$$serializer = new GateKeeper$Urls$$serializer();
        INSTANCE = gateKeeper$Urls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.initializer.data.response.GateKeeper.Urls", gateKeeper$Urls$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("achievement_my_list_url", true);
        pluginGeneratedSerialDescriptor.addElement("rep_share_url", true);
        pluginGeneratedSerialDescriptor.addElement("add_review_url", true);
        pluginGeneratedSerialDescriptor.addElement("relation_url", true);
        pluginGeneratedSerialDescriptor.addElement("relation_add_friend_url", true);
        pluginGeneratedSerialDescriptor.addElement("leaderboard_url", true);
        pluginGeneratedSerialDescriptor.addElement("relation_notifications_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GateKeeper$Urls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE, GateKeeper$Urls$Url$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GateKeeper.Urls deserialize(Decoder decoder) {
        GateKeeper.Urls.Url url;
        GateKeeper.Urls.Url url2;
        GateKeeper.Urls.Url url3;
        GateKeeper.Urls.Url url4;
        GateKeeper.Urls.Url url5;
        GateKeeper.Urls.Url url6;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 6;
        GateKeeper.Urls.Url url7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            GateKeeper.Urls.Url url8 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url9 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url10 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url11 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url12 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url13 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            GateKeeper.Urls.Url url14 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, GateKeeper$Urls$Url$$serializer.INSTANCE, null);
            i = WorkQueueKt.MASK;
            url7 = url8;
            url6 = url14;
            url5 = url13;
            url3 = url11;
            url4 = url12;
            url2 = url10;
            url = url9;
        } else {
            int i3 = 0;
            boolean z = true;
            GateKeeper.Urls.Url url15 = null;
            GateKeeper.Urls.Url url16 = null;
            url = null;
            url2 = null;
            url3 = null;
            url4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 6;
                        break;
                    case 0:
                        url7 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, GateKeeper$Urls$Url$$serializer.INSTANCE, url7);
                        i3 |= 1;
                        i2 = 6;
                        break;
                    case 1:
                        url = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, GateKeeper$Urls$Url$$serializer.INSTANCE, url);
                        i3 |= 2;
                        i2 = 6;
                        break;
                    case 2:
                        url2 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, GateKeeper$Urls$Url$$serializer.INSTANCE, url2);
                        i3 |= 4;
                        i2 = 6;
                        break;
                    case 3:
                        url3 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, GateKeeper$Urls$Url$$serializer.INSTANCE, url3);
                        i3 |= 8;
                        break;
                    case 4:
                        url4 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, GateKeeper$Urls$Url$$serializer.INSTANCE, url4);
                        i3 |= 16;
                        break;
                    case 5:
                        url15 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, GateKeeper$Urls$Url$$serializer.INSTANCE, url15);
                        i3 |= 32;
                        break;
                    case 6:
                        url16 = (GateKeeper.Urls.Url) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, GateKeeper$Urls$Url$$serializer.INSTANCE, url16);
                        i3 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            url5 = url15;
            url6 = url16;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new GateKeeper.Urls(i, url7, url, url2, url3, url4, url5, url6, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GateKeeper.Urls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        GateKeeper.Urls.write$Self$tap_core_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
