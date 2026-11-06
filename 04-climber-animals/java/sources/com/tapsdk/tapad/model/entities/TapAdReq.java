package com.tapsdk.tapad.model.entities;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapadn.protobuf.AbstractMessageLite;
import com.tapadn.protobuf.ByteString;
import com.tapadn.protobuf.CodedInputStream;
import com.tapadn.protobuf.CodedOutputStream;
import com.tapadn.protobuf.ExtensionRegistryLite;
import com.tapadn.protobuf.GeneratedMessageLite;
import com.tapadn.protobuf.Internal;
import com.tapadn.protobuf.InvalidProtocolBufferException;
import com.tapadn.protobuf.MessageLiteOrBuilder;
import com.tapadn.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapAdReq {

    public enum ADModel implements Internal.EnumLite {
        ADmodel_default(0),
        ADModel_intelligence_advertisement_Off(1),
        UNRECOGNIZED(-1);

        public static final int ADModel_intelligence_advertisement_Off_VALUE = 1;
        public static final int ADmodel_default_VALUE = 0;
        private static final Internal.EnumLiteMap<ADModel> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<ADModel> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ADModel findValueByNumber(int i) {
                return ADModel.forNumber(i);
            }
        }

        ADModel(int i) {
            this.value = i;
        }

        public static ADModel forNumber(int i) {
            if (i == 0) {
                return ADmodel_default;
            }
            if (i != 1) {
                return null;
            }
            return ADModel_intelligence_advertisement_Off;
        }

        public static Internal.EnumLiteMap<ADModel> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ADModel valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum BidType implements Internal.EnumLite {
        BidType_cpm(0),
        BidType_cpc(1),
        UNRECOGNIZED(-1);

        public static final int BidType_cpc_VALUE = 1;
        public static final int BidType_cpm_VALUE = 0;
        private static final Internal.EnumLiteMap<BidType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<BidType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BidType findValueByNumber(int i) {
                return BidType.forNumber(i);
            }
        }

        BidType(int i) {
            this.value = i;
        }

        public static BidType forNumber(int i) {
            if (i == 0) {
                return BidType_cpm;
            }
            if (i != 1) {
                return null;
            }
            return BidType_cpc;
        }

        public static Internal.EnumLiteMap<BidType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static BidType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum ConnectType implements Internal.EnumLite {
        ConnectType_unknown(0),
        ConnectType_ethernet(1),
        ConnectType_wifi(2),
        ConnectType_mobile(3),
        ConnectType_2G(4),
        ConnectType_3G(5),
        ConnectType_4G(6),
        ConnectType_5G(7),
        UNRECOGNIZED(-1);

        public static final int ConnectType_2G_VALUE = 4;
        public static final int ConnectType_3G_VALUE = 5;
        public static final int ConnectType_4G_VALUE = 6;
        public static final int ConnectType_5G_VALUE = 7;
        public static final int ConnectType_ethernet_VALUE = 1;
        public static final int ConnectType_mobile_VALUE = 3;
        public static final int ConnectType_unknown_VALUE = 0;
        public static final int ConnectType_wifi_VALUE = 2;
        private static final Internal.EnumLiteMap<ConnectType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<ConnectType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ConnectType findValueByNumber(int i) {
                return ConnectType.forNumber(i);
            }
        }

        ConnectType(int i) {
            this.value = i;
        }

        public static ConnectType forNumber(int i) {
            switch (i) {
                case 0:
                    return ConnectType_unknown;
                case 1:
                    return ConnectType_ethernet;
                case 2:
                    return ConnectType_wifi;
                case 3:
                    return ConnectType_mobile;
                case 4:
                    return ConnectType_2G;
                case 5:
                    return ConnectType_3G;
                case 6:
                    return ConnectType_4G;
                case 7:
                    return ConnectType_5G;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ConnectType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ConnectType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum DeviceType implements Internal.EnumLite {
        DeviceType_unknown(0),
        DeviceType_mobile(1),
        DeviceType_pad(2),
        UNRECOGNIZED(-1);

        public static final int DeviceType_mobile_VALUE = 1;
        public static final int DeviceType_pad_VALUE = 2;
        public static final int DeviceType_unknown_VALUE = 0;
        private static final Internal.EnumLiteMap<DeviceType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<DeviceType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DeviceType findValueByNumber(int i) {
                return DeviceType.forNumber(i);
            }
        }

        DeviceType(int i) {
            this.value = i;
        }

        public static DeviceType forNumber(int i) {
            if (i == 0) {
                return DeviceType_unknown;
            }
            if (i == 1) {
                return DeviceType_mobile;
            }
            if (i != 2) {
                return null;
            }
            return DeviceType_pad;
        }

        public static Internal.EnumLiteMap<DeviceType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static DeviceType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum OsType implements Internal.EnumLite {
        OsType_unknown(0),
        OsType_android(1),
        OsType_ios(2),
        UNRECOGNIZED(-1);

        public static final int OsType_android_VALUE = 1;
        public static final int OsType_ios_VALUE = 2;
        public static final int OsType_unknown_VALUE = 0;
        private static final Internal.EnumLiteMap<OsType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<OsType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public OsType findValueByNumber(int i) {
                return OsType.forNumber(i);
            }
        }

        OsType(int i) {
            this.value = i;
        }

        public static OsType forNumber(int i) {
            if (i == 0) {
                return OsType_unknown;
            }
            if (i == 1) {
                return OsType_android;
            }
            if (i != 2) {
                return null;
            }
            return OsType_ios;
        }

        public static Internal.EnumLiteMap<OsType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static OsType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class b extends GeneratedMessageLite<b, a> implements c {
        public static final int f = 1;
        public static final int g = 2;
        public static final int h = 3;
        public static final int i = 4;
        public static final int j = 5;
        private static final b k;
        private static volatile Parser<b> l;
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";

        public static final class a extends GeneratedMessageLite.Builder<b, a> implements c {
            private a() {
                super(b.k);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public String B5() {
                return ((b) this.instance).B5();
            }

            public a P5() {
                copyOnWrite();
                ((b) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((b) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((b) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public ByteString S() {
                return ((b) this.instance).S();
            }

            public a S5() {
                copyOnWrite();
                ((b) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((b) this.instance).U5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public String U3() {
                return ((b) this.instance).U3();
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((b) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((b) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((b) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public String c() {
                return ((b) this.instance).c();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public ByteString c0() {
                return ((b) this.instance).c0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public ByteString d() {
                return ((b) this.instance).d();
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((b) this.instance).d(str);
                return this;
            }

            public a e(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).f(byteString);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((b) this.instance).e(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public String getAppVersion() {
                return ((b) this.instance).getAppVersion();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public ByteString k() {
                return ((b) this.instance).k();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public ByteString r0() {
                return ((b) this.instance).r0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
            public String v4() {
                return ((b) this.instance).v4();
            }
        }

        static {
            b bVar = new b();
            k = bVar;
            bVar.makeImmutable();
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.d = V5().B5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = V5().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.c = V5().U3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.a = V5().c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.e = V5().v4();
        }

        public static b V5() {
            return k;
        }

        public static a W5() {
            return k.toBuilder();
        }

        public static Parser<b> X5() {
            return k.getParserForType();
        }

        public static b a(ByteString byteString) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(k, byteString);
        }

        public static b a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(k, byteString, extensionRegistryLite);
        }

        public static b a(CodedInputStream codedInputStream) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(k, codedInputStream);
        }

        public static b a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(k, codedInputStream, extensionRegistryLite);
        }

        public static b a(InputStream inputStream) throws IOException {
            return (b) GeneratedMessageLite.parseDelimitedFrom(k, inputStream);
        }

        public static b a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseDelimitedFrom(k, inputStream, extensionRegistryLite);
        }

        public static b a(byte[] bArr) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(k, bArr);
        }

        public static b a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(k, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.d = str;
        }

        public static b b(InputStream inputStream) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(k, inputStream);
        }

        public static b b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(k, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.e = str;
        }

        public static a f(b bVar) {
            return k.toBuilder().mergeFrom(bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public String B5() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public ByteString S() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public String U3() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public String c() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public ByteString c0() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public ByteString d() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return k;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    b bVar = (b) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !bVar.a.isEmpty(), bVar.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !bVar.b.isEmpty(), bVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !bVar.c.isEmpty(), bVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !bVar.d.isEmpty(), bVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, true ^ bVar.e.isEmpty(), bVar.e);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.a = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.d = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    this.e = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (l == null) {
                        synchronized (b.class) {
                            if (l == null) {
                                l = new GeneratedMessageLite.DefaultInstanceBasedParser(k);
                            }
                            break;
                        }
                    }
                    return l;
                default:
                    throw new UnsupportedOperationException();
            }
            return k;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public String getAppVersion() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, c());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getAppVersion());
            }
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, U3());
            }
            if (!this.d.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, B5());
            }
            if (!this.e.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, v4());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public ByteString k() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public ByteString r0() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.c
        public String v4() {
            return this.e;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, c());
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, getAppVersion());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(3, U3());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(4, B5());
            }
            if (this.e.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(5, v4());
        }
    }

    public interface c extends MessageLiteOrBuilder {
        String B5();

        ByteString S();

        String U3();

        String c();

        ByteString c0();

        ByteString d();

        String getAppVersion();

        ByteString k();

        ByteString r0();

        String v4();
    }

    public static final class d extends GeneratedMessageLite<d, a> implements e {
        public static final int h = 1;
        public static final int i = 2;
        public static final int j = 3;
        public static final int k = 4;
        public static final int l = 5;
        public static final int m = 6;
        private static final d n;
        private static volatile Parser<d> o;
        private int a;
        private p d;
        private j e;
        private String b = "";
        private String c = "";
        private Internal.ProtobufList<n> f = GeneratedMessageLite.emptyProtobufList();
        private String g = "";

        public static final class a extends GeneratedMessageLite.Builder<d, a> implements e {
            private a() {
                super(d.n);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public n P(int i) {
                return ((d) this.instance).P(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public ByteString P3() {
                return ((d) this.instance).P3();
            }

            public a P5() {
                copyOnWrite();
                ((d) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((d) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((d) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((d) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public j T4() {
                return ((d) this.instance).T4();
            }

            public a T5() {
                copyOnWrite();
                ((d) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((d) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public p Y4() {
                return ((d) this.instance).Y4();
            }

            public a a(int i, n.b bVar) {
                copyOnWrite();
                ((d) this.instance).a(i, bVar);
                return this;
            }

            public a a(int i, n nVar) {
                copyOnWrite();
                ((d) this.instance).a(i, nVar);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((d) this.instance).b(byteString);
                return this;
            }

            public a a(j.a aVar) {
                copyOnWrite();
                ((d) this.instance).a(aVar);
                return this;
            }

            public a a(j jVar) {
                copyOnWrite();
                ((d) this.instance).a(jVar);
                return this;
            }

            public a a(n.b bVar) {
                copyOnWrite();
                ((d) this.instance).a(bVar);
                return this;
            }

            public a a(n nVar) {
                copyOnWrite();
                ((d) this.instance).a(nVar);
                return this;
            }

            public a a(p.a aVar) {
                copyOnWrite();
                ((d) this.instance).a(aVar);
                return this;
            }

            public a a(p pVar) {
                copyOnWrite();
                ((d) this.instance).a(pVar);
                return this;
            }

            public a a(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((d) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((d) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public String a() {
                return ((d) this.instance).a();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public ByteString b() {
                return ((d) this.instance).b();
            }

            public a b(int i, n.b bVar) {
                copyOnWrite();
                ((d) this.instance).b(i, bVar);
                return this;
            }

            public a b(int i, n nVar) {
                copyOnWrite();
                ((d) this.instance).b(i, nVar);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((d) this.instance).c(byteString);
                return this;
            }

            public a b(j jVar) {
                copyOnWrite();
                ((d) this.instance).b(jVar);
                return this;
            }

            public a b(p pVar) {
                copyOnWrite();
                ((d) this.instance).b(pVar);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((d) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((d) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((d) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public int c1() {
                return ((d) this.instance).c1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public ByteString e() {
                return ((d) this.instance).e();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public String g() {
                return ((d) this.instance).g();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public String h2() {
                return ((d) this.instance).h2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public boolean i1() {
                return ((d) this.instance).i1();
            }

            public a o0(int i) {
                copyOnWrite();
                ((d) this.instance).p0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public List<n> w0() {
                return Collections.unmodifiableList(((d) this.instance).w0());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
            public boolean w5() {
                return ((d) this.instance).w5();
            }
        }

        static {
            d dVar = new d();
            n = dVar;
            dVar.makeImmutable();
        }

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.b = X5().h2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.e = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.g = X5().a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.f = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.d = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.c = X5().g();
        }

        private void W5() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        public static d X5() {
            return n;
        }

        public static a Z5() {
            return n.toBuilder();
        }

        public static d a(ByteString byteString) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(n, byteString);
        }

        public static d a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(n, byteString, extensionRegistryLite);
        }

        public static d a(CodedInputStream codedInputStream) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(n, codedInputStream);
        }

        public static d a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(n, codedInputStream, extensionRegistryLite);
        }

        public static d a(InputStream inputStream) throws IOException {
            return (d) GeneratedMessageLite.parseDelimitedFrom(n, inputStream);
        }

        public static d a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseDelimitedFrom(n, inputStream, extensionRegistryLite);
        }

        public static d a(byte[] bArr) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(n, bArr);
        }

        public static d a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(n, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, n.b bVar) {
            W5();
            this.f.add(i2, bVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, n nVar) {
            nVar.getClass();
            W5();
            this.f.add(i2, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j.a aVar) {
            this.e = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j jVar) {
            j jVar2 = this.e;
            if (jVar2 != null && jVar2 != j.r6()) {
                jVar = j.A(this.e).mergeFrom(jVar).buildPartial();
            }
            this.e = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(n.b bVar) {
            W5();
            this.f.add(bVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(n nVar) {
            nVar.getClass();
            W5();
            this.f.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p.a aVar) {
            this.d = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar) {
            p pVar2 = this.d;
            if (pVar2 != null && pVar2 != p.T5()) {
                pVar = p.d(this.d).mergeFrom(pVar).buildPartial();
            }
            this.d = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends n> iterable) {
            W5();
            AbstractMessageLite.addAll(iterable, this.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static Parser<d> a6() {
            return n.getParserForType();
        }

        public static d b(InputStream inputStream) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(n, inputStream);
        }

        public static d b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(n, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, n.b bVar) {
            W5();
            this.f.set(i2, bVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, n nVar) {
            nVar.getClass();
            W5();
            this.f.set(i2, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(j jVar) {
            jVar.getClass();
            this.e = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(p pVar) {
            pVar.getClass();
            this.d = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.g = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.g = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        public static a g(d dVar) {
            return n.toBuilder().mergeFrom(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            W5();
            this.f.remove(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public n P(int i2) {
            return this.f.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public ByteString P3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public j T4() {
            j jVar = this.e;
            return jVar == null ? j.r6() : jVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public p Y4() {
            p pVar = this.d;
            return pVar == null ? p.T5() : pVar;
        }

        public List<? extends o> Y5() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public String a() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public ByteString b() {
            return ByteString.copyFromUtf8(this.g);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public int c1() {
            return this.f.size();
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return n;
                case 3:
                    this.f.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    d dVar = (d) obj2;
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !dVar.b.isEmpty(), dVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !dVar.c.isEmpty(), dVar.c);
                    this.d = (p) visitor.visitMessage(this.d, dVar.d);
                    this.e = (j) visitor.visitMessage(this.e, dVar.e);
                    this.f = visitor.visitList(this.f, dVar.f);
                    this.g = visitor.visitString(!this.g.isEmpty(), this.g, true ^ dVar.g.isEmpty(), dVar.g);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= dVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        this.b = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 18) {
                                        this.c = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 26) {
                                        p pVar = this.d;
                                        p.a builder = pVar != null ? pVar.toBuilder() : null;
                                        p pVar2 = (p) codedInputStream.readMessage(p.V5(), extensionRegistryLite);
                                        this.d = pVar2;
                                        if (builder != null) {
                                            builder.mergeFrom(pVar2);
                                            this.d = builder.buildPartial();
                                        }
                                    } else if (tag == 34) {
                                        j jVar = this.e;
                                        j.a builder2 = jVar != null ? jVar.toBuilder() : null;
                                        j jVar2 = (j) codedInputStream.readMessage(j.t6(), extensionRegistryLite);
                                        this.e = jVar2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(jVar2);
                                            this.e = builder2.buildPartial();
                                        }
                                    } else if (tag == 42) {
                                        if (!this.f.isModifiable()) {
                                            this.f = GeneratedMessageLite.mutableCopy(this.f);
                                        }
                                        this.f.add((n) codedInputStream.readMessage(n.a6(), extensionRegistryLite));
                                    } else if (tag == 50) {
                                        this.g = codedInputStream.readStringRequireUtf8();
                                    } else if (!codedInputStream.skipField(tag)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (o == null) {
                        synchronized (d.class) {
                            if (o == null) {
                                o = new GeneratedMessageLite.DefaultInstanceBasedParser(n);
                            }
                            break;
                        }
                    }
                    return o;
                default:
                    throw new UnsupportedOperationException();
            }
            return n;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public ByteString e() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public String g() {
            return this.c;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = !this.b.isEmpty() ? CodedOutputStream.computeStringSize(1, h2()) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, g());
            }
            if (this.d != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(3, Y4());
            }
            if (this.e != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(4, T4());
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(5, this.f.get(i3));
            }
            if (!this.g.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, a());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public String h2() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public boolean i1() {
            return this.d != null;
        }

        public o o0(int i2) {
            return this.f.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public List<n> w0() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.e
        public boolean w5() {
            return this.e != null;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(1, h2());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, g());
            }
            if (this.d != null) {
                codedOutputStream.writeMessage(3, Y4());
            }
            if (this.e != null) {
                codedOutputStream.writeMessage(4, T4());
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                codedOutputStream.writeMessage(5, this.f.get(i2));
            }
            if (this.g.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(6, a());
        }
    }

    public interface e extends MessageLiteOrBuilder {
        n P(int i);

        ByteString P3();

        j T4();

        p Y4();

        String a();

        ByteString b();

        int c1();

        ByteString e();

        String g();

        String h2();

        boolean i1();

        List<n> w0();

        boolean w5();
    }

    public static final class f extends GeneratedMessageLite<f, a> implements g {
        public static final int c = 1;
        public static final int d = 2;
        private static final f e;
        private static volatile Parser<f> f;
        private String a = "";
        private String b = "";

        public static final class a extends GeneratedMessageLite.Builder<f, a> implements g {
            private a() {
                super(f.e);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
            public String A3() {
                return ((f) this.instance).A3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
            public String A4() {
                return ((f) this.instance).A4();
            }

            public a P5() {
                copyOnWrite();
                ((f) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((f) this.instance).R5();
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((f) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((f) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
            public ByteString g1() {
                return ((f) this.instance).g1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
            public ByteString m3() {
                return ((f) this.instance).m3();
            }
        }

        static {
            f fVar = new f();
            e = fVar;
            fVar.makeImmutable();
        }

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.b = S5().A4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.a = S5().A3();
        }

        public static f S5() {
            return e;
        }

        public static a T5() {
            return e.toBuilder();
        }

        public static Parser<f> U5() {
            return e.getParserForType();
        }

        public static f a(ByteString byteString) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(e, byteString);
        }

        public static f a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(e, byteString, extensionRegistryLite);
        }

        public static f a(CodedInputStream codedInputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(e, codedInputStream);
        }

        public static f a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(e, codedInputStream, extensionRegistryLite);
        }

        public static f a(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(e, inputStream);
        }

        public static f a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(e, inputStream, extensionRegistryLite);
        }

        public static f a(byte[] bArr) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(e, bArr);
        }

        public static f a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(e, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static f b(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(e, inputStream);
        }

        public static f b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(e, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.a = str;
        }

        public static a c(f fVar) {
            return e.toBuilder().mergeFrom(fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
        public String A3() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
        public String A4() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return e;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    f fVar = (f) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !fVar.a.isEmpty(), fVar.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, true ^ fVar.b.isEmpty(), fVar.b);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.a = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f == null) {
                        synchronized (f.class) {
                            if (f == null) {
                                f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                            }
                            break;
                        }
                    }
                    return f;
                default:
                    throw new UnsupportedOperationException();
            }
            return e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
        public ByteString g1() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, A3());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, A4());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.g
        public ByteString m3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, A3());
            }
            if (this.b.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, A4());
        }
    }

    public interface g extends MessageLiteOrBuilder {
        String A3();

        String A4();

        ByteString g1();

        ByteString m3();
    }

    public static final class h extends GeneratedMessageLite<h, a> implements i {
        public static final int m = 1;
        public static final int n = 2;
        public static final int o = 3;
        public static final int p = 4;
        public static final int q = 5;
        public static final int r = 6;
        public static final int s = 7;
        public static final int t = 8;
        public static final int u = 9;
        public static final int v = 10;
        public static final int w = 11;
        private static final h x;
        private static volatile Parser<h> y;
        private int a;
        private v k;
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private String g = "";
        private String h = "";
        private String i = "";
        private Internal.ProtobufList<f> j = GeneratedMessageLite.emptyProtobufList();
        private String l = "";

        public static final class a extends GeneratedMessageLite.Builder<h, a> implements i {
            private a() {
                super(h.x);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString C5() {
                return ((h) this.instance).C5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String D3() {
                return ((h) this.instance).D3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString I4() {
                return ((h) this.instance).I4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String J0() {
                return ((h) this.instance).J0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public boolean L1() {
                return ((h) this.instance).L1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public v N3() {
                return ((h) this.instance).N3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String N4() {
                return ((h) this.instance).N4();
            }

            public a P5() {
                copyOnWrite();
                ((h) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String Q1() {
                return ((h) this.instance).Q1();
            }

            public a Q5() {
                copyOnWrite();
                ((h) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((h) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String S2() {
                return ((h) this.instance).S2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public List<f> S3() {
                return Collections.unmodifiableList(((h) this.instance).S3());
            }

            public a S5() {
                copyOnWrite();
                ((h) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((h) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((h) this.instance).V5();
                return this;
            }

            public a V5() {
                copyOnWrite();
                ((h) this.instance).W5();
                return this;
            }

            public a W5() {
                copyOnWrite();
                ((h) this.instance).X5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String X1() {
                return ((h) this.instance).X1();
            }

            public a X5() {
                copyOnWrite();
                ((h) this.instance).Y5();
                return this;
            }

            public a Y5() {
                copyOnWrite();
                ((h) this.instance).Z5();
                return this;
            }

            public a Z5() {
                copyOnWrite();
                ((h) this.instance).a6();
                return this;
            }

            public a a(int i, f.a aVar) {
                copyOnWrite();
                ((h) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, f fVar) {
                copyOnWrite();
                ((h) this.instance).a(i, fVar);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).b(byteString);
                return this;
            }

            public a a(f.a aVar) {
                copyOnWrite();
                ((h) this.instance).a(aVar);
                return this;
            }

            public a a(f fVar) {
                copyOnWrite();
                ((h) this.instance).a(fVar);
                return this;
            }

            public a a(v.a aVar) {
                copyOnWrite();
                ((h) this.instance).a(aVar);
                return this;
            }

            public a a(v vVar) {
                copyOnWrite();
                ((h) this.instance).a(vVar);
                return this;
            }

            public a a(Iterable<? extends f> iterable) {
                copyOnWrite();
                ((h) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((h) this.instance).a(str);
                return this;
            }

            public a b(int i, f.a aVar) {
                copyOnWrite();
                ((h) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, f fVar) {
                copyOnWrite();
                ((h) this.instance).b(i, fVar);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).c(byteString);
                return this;
            }

            public a b(v vVar) {
                copyOnWrite();
                ((h) this.instance).b(vVar);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((h) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((h) this.instance).c(str);
                return this;
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((h) this.instance).d(str);
                return this;
            }

            public a e(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).f(byteString);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((h) this.instance).e(str);
                return this;
            }

            public a f(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).g(byteString);
                return this;
            }

            public a f(String str) {
                copyOnWrite();
                ((h) this.instance).f(str);
                return this;
            }

            public a g(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).h(byteString);
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((h) this.instance).g(str);
                return this;
            }

            public a h(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).i(byteString);
                return this;
            }

            public a h(String str) {
                copyOnWrite();
                ((h) this.instance).h(str);
                return this;
            }

            public a i(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).j(byteString);
                return this;
            }

            public a i(String str) {
                copyOnWrite();
                ((h) this.instance).i(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String i() {
                return ((h) this.instance).i();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String j1() {
                return ((h) this.instance).j1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public f m(int i) {
                return ((h) this.instance).m(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public int n5() {
                return ((h) this.instance).n5();
            }

            public a o0(int i) {
                copyOnWrite();
                ((h) this.instance).p0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString p2() {
                return ((h) this.instance).p2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString t0() {
                return ((h) this.instance).t0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString v5() {
                return ((h) this.instance).v5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString w1() {
                return ((h) this.instance).w1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString x2() {
                return ((h) this.instance).x2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString x4() {
                return ((h) this.instance).x4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public ByteString y0() {
                return ((h) this.instance).y0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
            public String y2() {
                return ((h) this.instance).y2();
            }
        }

        static {
            h hVar = new h();
            x = hVar;
            hVar.makeImmutable();
        }

        private h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.f = d6().Q1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.g = d6().S2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.j = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.b = d6().J0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.c = d6().X1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.d = d6().j1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.e = d6().D3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.h = d6().i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.l = d6().y2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z5() {
            this.i = d6().N4();
        }

        public static h a(ByteString byteString) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(x, byteString);
        }

        public static h a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(x, byteString, extensionRegistryLite);
        }

        public static h a(CodedInputStream codedInputStream) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(x, codedInputStream);
        }

        public static h a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(x, codedInputStream, extensionRegistryLite);
        }

        public static h a(InputStream inputStream) throws IOException {
            return (h) GeneratedMessageLite.parseDelimitedFrom(x, inputStream);
        }

        public static h a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseDelimitedFrom(x, inputStream, extensionRegistryLite);
        }

        public static h a(byte[] bArr) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(x, bArr);
        }

        public static h a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(x, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, f.a aVar) {
            b6();
            this.j.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, f fVar) {
            fVar.getClass();
            b6();
            this.j.add(i, fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f.a aVar) {
            b6();
            this.j.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f fVar) {
            fVar.getClass();
            b6();
            this.j.add(fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(v.a aVar) {
            this.k = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(v vVar) {
            v vVar2 = this.k;
            if (vVar2 != null && vVar2 != v.U5()) {
                vVar = v.e(this.k).mergeFrom(vVar).buildPartial();
            }
            this.k = vVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends f> iterable) {
            b6();
            AbstractMessageLite.addAll(iterable, this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a6() {
            this.k = null;
        }

        public static h b(InputStream inputStream) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(x, inputStream);
        }

        public static h b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(x, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, f.a aVar) {
            b6();
            this.j.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, f fVar) {
            fVar.getClass();
            b6();
            this.j.set(i, fVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(v vVar) {
            vVar.getClass();
            this.k = vVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.g = str;
        }

        private void b6() {
            if (this.j.isModifiable()) {
                return;
            }
            this.j = GeneratedMessageLite.mutableCopy(this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.g = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.c = str;
        }

        public static h d6() {
            return x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.d = str;
        }

        public static a e6() {
            return x.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(String str) {
            str.getClass();
            this.e = str;
        }

        public static Parser<h> f6() {
            return x.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            str.getClass();
            this.h = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.h = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(String str) {
            str.getClass();
            this.l = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.l = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(String str) {
            str.getClass();
            this.i = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.i = byteString.toStringUtf8();
        }

        public static a l(h hVar) {
            return x.toBuilder().mergeFrom(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            b6();
            this.j.remove(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString C5() {
            return ByteString.copyFromUtf8(this.f);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String D3() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString I4() {
            return ByteString.copyFromUtf8(this.h);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String J0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public boolean L1() {
            return this.k != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public v N3() {
            v vVar = this.k;
            return vVar == null ? v.U5() : vVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String N4() {
            return this.i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String Q1() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String S2() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public List<f> S3() {
            return this.j;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String X1() {
            return this.c;
        }

        public List<? extends g> c6() {
            return this.j;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return x;
                case 3:
                    this.j.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    h hVar = (h) obj2;
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !hVar.b.isEmpty(), hVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !hVar.c.isEmpty(), hVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !hVar.d.isEmpty(), hVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, !hVar.e.isEmpty(), hVar.e);
                    this.f = visitor.visitString(!this.f.isEmpty(), this.f, !hVar.f.isEmpty(), hVar.f);
                    this.g = visitor.visitString(!this.g.isEmpty(), this.g, !hVar.g.isEmpty(), hVar.g);
                    this.h = visitor.visitString(!this.h.isEmpty(), this.h, !hVar.h.isEmpty(), hVar.h);
                    this.i = visitor.visitString(!this.i.isEmpty(), this.i, !hVar.i.isEmpty(), hVar.i);
                    this.j = visitor.visitList(this.j, hVar.j);
                    this.k = (v) visitor.visitMessage(this.k, hVar.k);
                    this.l = visitor.visitString(!this.l.isEmpty(), this.l, true ^ hVar.l.isEmpty(), hVar.l);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= hVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 10:
                                    this.b = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 18:
                                    this.c = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 26:
                                    this.d = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 34:
                                    this.e = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 42:
                                    this.f = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 50:
                                    this.g = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 58:
                                    this.h = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 66:
                                    this.i = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 74:
                                    if (!this.j.isModifiable()) {
                                        this.j = GeneratedMessageLite.mutableCopy(this.j);
                                    }
                                    this.j.add((f) codedInputStream.readMessage(f.U5(), extensionRegistryLite));
                                    continue;
                                case 82:
                                    v vVar = this.k;
                                    v.a builder = vVar != null ? vVar.toBuilder() : null;
                                    v vVar2 = (v) codedInputStream.readMessage(v.W5(), extensionRegistryLite);
                                    this.k = vVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(vVar2);
                                        this.k = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 90:
                                    this.l = codedInputStream.readStringRequireUtf8();
                                    continue;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        break;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (y == null) {
                        synchronized (h.class) {
                            if (y == null) {
                                y = new GeneratedMessageLite.DefaultInstanceBasedParser(x);
                            }
                            break;
                        }
                    }
                    return y;
                default:
                    throw new UnsupportedOperationException();
            }
            return x;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !this.b.isEmpty() ? CodedOutputStream.computeStringSize(1, J0()) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, X1());
            }
            if (!this.d.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, j1());
            }
            if (!this.e.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, D3());
            }
            if (!this.f.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(5, Q1());
            }
            if (!this.g.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(6, S2());
            }
            if (!this.h.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(7, i());
            }
            if (!this.i.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(8, N4());
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(9, this.j.get(i2));
            }
            if (this.k != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(10, N3());
            }
            if (!this.l.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(11, y2());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String i() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String j1() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public f m(int i) {
            return this.j.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public int n5() {
            return this.j.size();
        }

        public g o0(int i) {
            return this.j.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString p2() {
            return ByteString.copyFromUtf8(this.g);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString t0() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString v5() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString w1() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(1, J0());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, X1());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, j1());
            }
            if (!this.e.isEmpty()) {
                codedOutputStream.writeString(4, D3());
            }
            if (!this.f.isEmpty()) {
                codedOutputStream.writeString(5, Q1());
            }
            if (!this.g.isEmpty()) {
                codedOutputStream.writeString(6, S2());
            }
            if (!this.h.isEmpty()) {
                codedOutputStream.writeString(7, i());
            }
            if (!this.i.isEmpty()) {
                codedOutputStream.writeString(8, N4());
            }
            for (int i = 0; i < this.j.size(); i++) {
                codedOutputStream.writeMessage(9, this.j.get(i));
            }
            if (this.k != null) {
                codedOutputStream.writeMessage(10, N3());
            }
            if (this.l.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(11, y2());
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString x2() {
            return ByteString.copyFromUtf8(this.l);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString x4() {
            return ByteString.copyFromUtf8(this.i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public ByteString y0() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.i
        public String y2() {
            return this.l;
        }
    }

    public interface i extends MessageLiteOrBuilder {
        ByteString C5();

        String D3();

        ByteString I4();

        String J0();

        boolean L1();

        v N3();

        String N4();

        String Q1();

        String S2();

        List<f> S3();

        String X1();

        String i();

        String j1();

        f m(int i);

        int n5();

        ByteString p2();

        ByteString t0();

        ByteString v5();

        ByteString w1();

        ByteString x2();

        ByteString x4();

        ByteString y0();

        String y2();
    }

    public static final class j extends GeneratedMessageLite<j, a> implements k {
        public static final int B = 1;
        public static final int C = 2;
        public static final int D = 3;
        public static final int E = 4;
        public static final int F = 5;
        public static final int G = 6;
        public static final int H = 7;
        public static final int I = 8;
        public static final int J = 9;
        public static final int K = 10;
        public static final int L = 11;
        public static final int M = 12;
        public static final int N = 13;
        public static final int O = 14;
        public static final int P = 15;
        public static final int Q = 16;
        public static final int R = 17;
        public static final int S = 18;
        public static final int T = 19;
        public static final int U = 20;
        public static final int V = 21;
        public static final int W = 22;
        public static final int X = 23;
        public static final int Y = 24;
        public static final int Z = 25;
        public static final int a0 = 26;
        private static final j b0;
        private static volatile Parser<j> c0;
        private int a;
        private int b;
        private int c;
        private int g;
        private int h;
        private h i;
        private l k;
        private r m;
        private int n;
        private long o;
        private long p;
        private long q;
        private String d = "";
        private String e = "";
        private String f = "";
        private Internal.ProtobufList<String> j = GeneratedMessageLite.emptyProtobufList();
        private String l = "";
        private String r = "";
        private String s = "";
        private String t = "";
        private String u = "";
        private String v = "";
        private String w = "";
        private String x = "";
        private String y = "";
        private String z = "";
        private String A = "";

        public static final class a extends GeneratedMessageLite.Builder<j, a> implements k {
            private a() {
                super(j.b0);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public boolean A2() {
                return ((j) this.instance).A2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString B1() {
                return ((j) this.instance).B1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int C2() {
                return ((j) this.instance).C2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String E0() {
                return ((j) this.instance).E0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String G5() {
                return ((j) this.instance).G5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String I() {
                return ((j) this.instance).I();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public boolean J() {
                return ((j) this.instance).J();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString K() {
                return ((j) this.instance).K();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public h K3() {
                return ((j) this.instance).K3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString K4() {
                return ((j) this.instance).K4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public long K5() {
                return ((j) this.instance).K5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public long L3() {
                return ((j) this.instance).L3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int M5() {
                return ((j) this.instance).M5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public l N0() {
                return ((j) this.instance).N0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public DeviceType O1() {
                return ((j) this.instance).O1();
            }

            public a P5() {
                copyOnWrite();
                ((j) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((j) this.instance).R5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int R() {
                return ((j) this.instance).R();
            }

            public a R5() {
                copyOnWrite();
                ((j) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String S0() {
                return ((j) this.instance).S0();
            }

            public a S5() {
                copyOnWrite();
                ((j) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((j) this.instance).U5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString U4() {
                return ((j) this.instance).U4();
            }

            public a U5() {
                copyOnWrite();
                ((j) this.instance).V5();
                return this;
            }

            public a V5() {
                copyOnWrite();
                ((j) this.instance).W5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String W() {
                return ((j) this.instance).W();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString W4() {
                return ((j) this.instance).W4();
            }

            public a W5() {
                copyOnWrite();
                ((j) this.instance).X5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString X0() {
                return ((j) this.instance).X0();
            }

            public a X5() {
                copyOnWrite();
                ((j) this.instance).Y5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String Y0() {
                return ((j) this.instance).Y0();
            }

            public a Y5() {
                copyOnWrite();
                ((j) this.instance).Z5();
                return this;
            }

            public a Z5() {
                copyOnWrite();
                ((j) this.instance).a6();
                return this;
            }

            public a a(int i, String str) {
                copyOnWrite();
                ((j) this.instance).a(i, str);
                return this;
            }

            public a a(long j) {
                copyOnWrite();
                ((j) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).a(byteString);
                return this;
            }

            public a a(ADModel aDModel) {
                copyOnWrite();
                ((j) this.instance).a(aDModel);
                return this;
            }

            public a a(DeviceType deviceType) {
                copyOnWrite();
                ((j) this.instance).a(deviceType);
                return this;
            }

            public a a(OsType osType) {
                copyOnWrite();
                ((j) this.instance).a(osType);
                return this;
            }

            public a a(h.a aVar) {
                copyOnWrite();
                ((j) this.instance).a(aVar);
                return this;
            }

            public a a(h hVar) {
                copyOnWrite();
                ((j) this.instance).a(hVar);
                return this;
            }

            public a a(l.a aVar) {
                copyOnWrite();
                ((j) this.instance).a(aVar);
                return this;
            }

            public a a(l lVar) {
                copyOnWrite();
                ((j) this.instance).a(lVar);
                return this;
            }

            public a a(r.a aVar) {
                copyOnWrite();
                ((j) this.instance).a(aVar);
                return this;
            }

            public a a(r rVar) {
                copyOnWrite();
                ((j) this.instance).a(rVar);
                return this;
            }

            public a a(Iterable<String> iterable) {
                copyOnWrite();
                ((j) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((j) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString a0(int i) {
                return ((j) this.instance).a0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public List<String> a5() {
                return Collections.unmodifiableList(((j) this.instance).a5());
            }

            public a a6() {
                copyOnWrite();
                ((j) this.instance).b6();
                return this;
            }

            public a b(long j) {
                copyOnWrite();
                ((j) this.instance).b(j);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).c(byteString);
                return this;
            }

            public a b(h hVar) {
                copyOnWrite();
                ((j) this.instance).b(hVar);
                return this;
            }

            public a b(l lVar) {
                copyOnWrite();
                ((j) this.instance).b(lVar);
                return this;
            }

            public a b(r rVar) {
                copyOnWrite();
                ((j) this.instance).b(rVar);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((j) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String b1() {
                return ((j) this.instance).b1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String b4() {
                return ((j) this.instance).b4();
            }

            public a b6() {
                copyOnWrite();
                ((j) this.instance).c6();
                return this;
            }

            public a c(long j) {
                copyOnWrite();
                ((j) this.instance).c(j);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((j) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString c4() {
                return ((j) this.instance).c4();
            }

            public a c6() {
                copyOnWrite();
                ((j) this.instance).d6();
                return this;
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((j) this.instance).d(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString d4() {
                return ((j) this.instance).d4();
            }

            public a d6() {
                copyOnWrite();
                ((j) this.instance).e6();
                return this;
            }

            public a e(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).f(byteString);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((j) this.instance).e(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String e1() {
                return ((j) this.instance).e1();
            }

            public a e6() {
                copyOnWrite();
                ((j) this.instance).f6();
                return this;
            }

            public a f(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).g(byteString);
                return this;
            }

            public a f(String str) {
                copyOnWrite();
                ((j) this.instance).f(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int f1() {
                return ((j) this.instance).f1();
            }

            public a f6() {
                copyOnWrite();
                ((j) this.instance).g6();
                return this;
            }

            public a g(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).h(byteString);
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((j) this.instance).g(str);
                return this;
            }

            public a g6() {
                copyOnWrite();
                ((j) this.instance).h6();
                return this;
            }

            public a h(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).i(byteString);
                return this;
            }

            public a h(String str) {
                copyOnWrite();
                ((j) this.instance).h(str);
                return this;
            }

            public a h6() {
                copyOnWrite();
                ((j) this.instance).i6();
                return this;
            }

            public a i(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).j(byteString);
                return this;
            }

            public a i(String str) {
                copyOnWrite();
                ((j) this.instance).i(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString i5() {
                return ((j) this.instance).i5();
            }

            public a i6() {
                copyOnWrite();
                ((j) this.instance).j6();
                return this;
            }

            public a j(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).k(byteString);
                return this;
            }

            public a j(String str) {
                copyOnWrite();
                ((j) this.instance).j(str);
                return this;
            }

            public a j6() {
                copyOnWrite();
                ((j) this.instance).k6();
                return this;
            }

            public a k(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).l(byteString);
                return this;
            }

            public a k(String str) {
                copyOnWrite();
                ((j) this.instance).k(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString k3() {
                return ((j) this.instance).k3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString k4() {
                return ((j) this.instance).k4();
            }

            public a k6() {
                copyOnWrite();
                ((j) this.instance).l6();
                return this;
            }

            public a l(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).m(byteString);
                return this;
            }

            public a l(String str) {
                copyOnWrite();
                ((j) this.instance).l(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public OsType l4() {
                return ((j) this.instance).l4();
            }

            public a l6() {
                copyOnWrite();
                ((j) this.instance).m6();
                return this;
            }

            public a m(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).n(byteString);
                return this;
            }

            public a m(String str) {
                copyOnWrite();
                ((j) this.instance).m(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString m5() {
                return ((j) this.instance).m5();
            }

            public a m6() {
                copyOnWrite();
                ((j) this.instance).n6();
                return this;
            }

            public a n(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).o(byteString);
                return this;
            }

            public a n(String str) {
                copyOnWrite();
                ((j) this.instance).n(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String n(int i) {
                return ((j) this.instance).n(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String n1() {
                return ((j) this.instance).n1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public r n4() {
                return ((j) this.instance).n4();
            }

            public a n6() {
                copyOnWrite();
                ((j) this.instance).o6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString o() {
                return ((j) this.instance).o();
            }

            public a o(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).p(byteString);
                return this;
            }

            public a o(String str) {
                copyOnWrite();
                ((j) this.instance).o(str);
                return this;
            }

            public a o0(int i) {
                copyOnWrite();
                ((j) this.instance).o0(i);
                return this;
            }

            public a o6() {
                copyOnWrite();
                ((j) this.instance).p6();
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((j) this.instance).p0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String p3() {
                return ((j) this.instance).p3();
            }

            public a q0(int i) {
                copyOnWrite();
                ((j) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public long q3() {
                return ((j) this.instance).q3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String q4() {
                return ((j) this.instance).q4();
            }

            public a r0(int i) {
                copyOnWrite();
                ((j) this.instance).r0(i);
                return this;
            }

            public a s0(int i) {
                copyOnWrite();
                ((j) this.instance).s0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ByteString s1() {
                return ((j) this.instance).s1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public boolean t2() {
                return ((j) this.instance).t2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int u() {
                return ((j) this.instance).u();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public ADModel u5() {
                return ((j) this.instance).u5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String w4() {
                return ((j) this.instance).w4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public int x1() {
                return ((j) this.instance).x1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
            public String z4() {
                return ((j) this.instance).z4();
            }
        }

        static {
            j jVar = new j();
            b0 = jVar;
            jVar.makeImmutable();
        }

        private j() {
        }

        public static a A(j jVar) {
            return b0.toBuilder().mergeFrom(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.n = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.t = r6().p3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.r = r6().b4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.u = r6().q4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.f = r6().Y0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.i = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.z = r6().I();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.w = r6().w4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z5() {
            this.k = null;
        }

        public static j a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(b0, byteString, extensionRegistryLite);
        }

        public static j a(CodedInputStream codedInputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(b0, codedInputStream);
        }

        public static j a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(b0, codedInputStream, extensionRegistryLite);
        }

        public static j a(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(b0, inputStream);
        }

        public static j a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(b0, inputStream, extensionRegistryLite);
        }

        public static j a(byte[] bArr) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(b0, bArr);
        }

        public static j a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(b0, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, String str) {
            str.getClass();
            q6();
            this.j.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.p = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            q6();
            this.j.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ADModel aDModel) {
            aDModel.getClass();
            this.n = aDModel.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(DeviceType deviceType) {
            deviceType.getClass();
            this.b = deviceType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(OsType osType) {
            osType.getClass();
            this.c = osType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h.a aVar) {
            this.i = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h hVar) {
            h hVar2 = this.i;
            if (hVar2 != null && hVar2 != h.d6()) {
                hVar = h.l(this.i).mergeFrom(hVar).buildPartial();
            }
            this.i = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(l.a aVar) {
            this.k = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(l lVar) {
            l lVar2 = this.k;
            if (lVar2 != null && lVar2 != l.S5()) {
                lVar = l.c(this.k).mergeFrom(lVar).buildPartial();
            }
            this.k = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(r.a aVar) {
            this.m = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(r rVar) {
            r rVar2 = this.m;
            if (rVar2 != null && rVar2 != r.T5()) {
                rVar = r.d(this.m).mergeFrom(rVar).buildPartial();
            }
            this.m = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<String> iterable) {
            q6();
            AbstractMessageLite.addAll(iterable, this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            q6();
            this.j.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a6() {
            this.A = r6().z4();
        }

        public static j b(ByteString byteString) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(b0, byteString);
        }

        public static j b(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(b0, inputStream);
        }

        public static j b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(b0, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.o = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(h hVar) {
            hVar.getClass();
            this.i = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(l lVar) {
            lVar.getClass();
            this.k = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(r rVar) {
            rVar.getClass();
            this.m = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.t = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b6() {
            this.j = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(long j) {
            this.q = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.t = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.r = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c6() {
            this.y = r6().E0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.r = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.u = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d6() {
            this.e = r6().S0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.u = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e6() {
            this.m = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(String str) {
            str.getClass();
            this.z = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f6() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.z = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            str.getClass();
            this.w = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g6() {
            this.d = r6().G5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.w = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(String str) {
            str.getClass();
            this.A = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h6() {
            this.x = r6().e1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.A = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(String str) {
            str.getClass();
            this.y = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i6() {
            this.h = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.y = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(String str) {
            str.getClass();
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j6() {
            this.g = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str) {
            str.getClass();
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k6() {
            this.p = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str) {
            str.getClass();
            this.x = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l6() {
            this.o = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.x = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(String str) {
            str.getClass();
            this.s = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m6() {
            this.q = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.s = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String str) {
            str.getClass();
            this.v = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n6() {
            this.s = r6().b1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.v = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(String str) {
            str.getClass();
            this.l = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.n = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o6() {
            this.v = r6().n1();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.l = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p6() {
            this.l = r6().W();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.c = i;
        }

        private void q6() {
            if (this.j.isModifiable()) {
                return;
            }
            this.j = GeneratedMessageLite.mutableCopy(this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i) {
            this.h = i;
        }

        public static j r6() {
            return b0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i) {
            this.g = i;
        }

        public static a s6() {
            return b0.toBuilder();
        }

        public static Parser<j> t6() {
            return b0.getParserForType();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public boolean A2() {
            return this.k != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString B1() {
            return ByteString.copyFromUtf8(this.w);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int C2() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String E0() {
            return this.y;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String G5() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String I() {
            return this.z;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public boolean J() {
            return this.m != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString K() {
            return ByteString.copyFromUtf8(this.f);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public h K3() {
            h hVar = this.i;
            return hVar == null ? h.d6() : hVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString K4() {
            return ByteString.copyFromUtf8(this.s);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public long K5() {
            return this.p;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public long L3() {
            return this.o;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int M5() {
            return this.n;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public l N0() {
            l lVar = this.k;
            return lVar == null ? l.S5() : lVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public DeviceType O1() {
            DeviceType deviceTypeForNumber = DeviceType.forNumber(this.b);
            return deviceTypeForNumber == null ? DeviceType.UNRECOGNIZED : deviceTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int R() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String S0() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString U4() {
            return ByteString.copyFromUtf8(this.l);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String W() {
            return this.l;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString W4() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString X0() {
            return ByteString.copyFromUtf8(this.u);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String Y0() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString a0(int i) {
            return ByteString.copyFromUtf8(this.j.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public List<String> a5() {
            return this.j;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String b1() {
            return this.s;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String b4() {
            return this.r;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString c4() {
            return ByteString.copyFromUtf8(this.r);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString d4() {
            return ByteString.copyFromUtf8(this.x);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return b0;
                case 3:
                    this.j.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    j jVar = (j) obj2;
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = jVar.b;
                    this.b = visitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.c;
                    boolean z3 = i3 != 0;
                    int i4 = jVar.c;
                    this.c = visitor.visitInt(z3, i3, i4 != 0, i4);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !jVar.d.isEmpty(), jVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, !jVar.e.isEmpty(), jVar.e);
                    this.f = visitor.visitString(!this.f.isEmpty(), this.f, !jVar.f.isEmpty(), jVar.f);
                    int i5 = this.g;
                    boolean z4 = i5 != 0;
                    int i6 = jVar.g;
                    this.g = visitor.visitInt(z4, i5, i6 != 0, i6);
                    int i7 = this.h;
                    boolean z5 = i7 != 0;
                    int i8 = jVar.h;
                    this.h = visitor.visitInt(z5, i7, i8 != 0, i8);
                    this.i = (h) visitor.visitMessage(this.i, jVar.i);
                    this.j = visitor.visitList(this.j, jVar.j);
                    this.k = (l) visitor.visitMessage(this.k, jVar.k);
                    this.l = visitor.visitString(!this.l.isEmpty(), this.l, !jVar.l.isEmpty(), jVar.l);
                    this.m = (r) visitor.visitMessage(this.m, jVar.m);
                    int i9 = this.n;
                    boolean z6 = i9 != 0;
                    int i10 = jVar.n;
                    this.n = visitor.visitInt(z6, i9, i10 != 0, i10);
                    long j = this.o;
                    boolean z7 = j != 0;
                    long j2 = jVar.o;
                    this.o = visitor.visitLong(z7, j, j2 != 0, j2);
                    long j3 = this.p;
                    boolean z8 = j3 != 0;
                    long j4 = jVar.p;
                    this.p = visitor.visitLong(z8, j3, j4 != 0, j4);
                    long j5 = this.q;
                    boolean z9 = j5 != 0;
                    long j6 = jVar.q;
                    this.q = visitor.visitLong(z9, j5, j6 != 0, j6);
                    this.r = visitor.visitString(!this.r.isEmpty(), this.r, !jVar.r.isEmpty(), jVar.r);
                    this.s = visitor.visitString(!this.s.isEmpty(), this.s, !jVar.s.isEmpty(), jVar.s);
                    this.t = visitor.visitString(!this.t.isEmpty(), this.t, !jVar.t.isEmpty(), jVar.t);
                    this.u = visitor.visitString(!this.u.isEmpty(), this.u, !jVar.u.isEmpty(), jVar.u);
                    this.v = visitor.visitString(!this.v.isEmpty(), this.v, !jVar.v.isEmpty(), jVar.v);
                    this.w = visitor.visitString(!this.w.isEmpty(), this.w, !jVar.w.isEmpty(), jVar.w);
                    this.x = visitor.visitString(!this.x.isEmpty(), this.x, !jVar.x.isEmpty(), jVar.x);
                    this.y = visitor.visitString(!this.y.isEmpty(), this.y, !jVar.y.isEmpty(), jVar.y);
                    this.z = visitor.visitString(!this.z.isEmpty(), this.z, !jVar.z.isEmpty(), jVar.z);
                    this.A = visitor.visitString(!this.A.isEmpty(), this.A, !jVar.A.isEmpty(), jVar.A);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= jVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 8:
                                    this.b = codedInputStream.readEnum();
                                    continue;
                                case 16:
                                    this.c = codedInputStream.readEnum();
                                    continue;
                                case 26:
                                    this.d = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 34:
                                    this.e = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 42:
                                    this.f = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 48:
                                    this.g = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.h = codedInputStream.readInt32();
                                    continue;
                                case 66:
                                    h hVar = this.i;
                                    h.a builder = hVar != null ? hVar.toBuilder() : null;
                                    h hVar2 = (h) codedInputStream.readMessage(h.f6(), extensionRegistryLite);
                                    this.i = hVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(hVar2);
                                        this.i = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 74:
                                    String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.j.isModifiable()) {
                                        this.j = GeneratedMessageLite.mutableCopy(this.j);
                                    }
                                    this.j.add(stringRequireUtf8);
                                    continue;
                                case 82:
                                    l lVar = this.k;
                                    l.a builder2 = lVar != null ? lVar.toBuilder() : null;
                                    l lVar2 = (l) codedInputStream.readMessage(l.U5(), extensionRegistryLite);
                                    this.k = lVar2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(lVar2);
                                        this.k = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 90:
                                    this.l = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 98:
                                    r rVar = this.m;
                                    r.a builder3 = rVar != null ? rVar.toBuilder() : null;
                                    r rVar2 = (r) codedInputStream.readMessage(r.V5(), extensionRegistryLite);
                                    this.m = rVar2;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(rVar2);
                                        this.m = builder3.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 104:
                                    this.n = codedInputStream.readEnum();
                                    continue;
                                case 112:
                                    this.o = codedInputStream.readInt64();
                                    continue;
                                case 120:
                                    this.p = codedInputStream.readInt64();
                                    continue;
                                case 128:
                                    this.q = codedInputStream.readInt64();
                                    continue;
                                case 138:
                                    this.r = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 146:
                                    this.s = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 154:
                                    this.t = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME /* 162 */:
                                    this.u = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 170:
                                    this.v = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD /* 178 */:
                                    this.w = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                                    this.x = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                                    this.y = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 202:
                                    this.z = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 210:
                                    this.A = codedInputStream.readStringRequireUtf8();
                                    continue;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        break;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (c0 == null) {
                        synchronized (j.class) {
                            if (c0 == null) {
                                c0 = new GeneratedMessageLite.DefaultInstanceBasedParser(b0);
                            }
                            break;
                        }
                    }
                    return c0;
                default:
                    throw new UnsupportedOperationException();
            }
            return b0;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String e1() {
            return this.x;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int f1() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = this.b != DeviceType.DeviceType_unknown.getNumber() ? CodedOutputStream.computeEnumSize(1, this.b) + 0 : 0;
            if (this.c != OsType.OsType_unknown.getNumber()) {
                iComputeEnumSize += CodedOutputStream.computeEnumSize(2, this.c);
            }
            if (!this.d.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(3, G5());
            }
            if (!this.e.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(4, S0());
            }
            if (!this.f.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(5, Y0());
            }
            int i2 = this.g;
            if (i2 != 0) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(6, i2);
            }
            int i3 = this.h;
            if (i3 != 0) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(7, i3);
            }
            if (this.i != null) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(8, K3());
            }
            int iComputeStringSizeNoTag = 0;
            for (int i4 = 0; i4 < this.j.size(); i4++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.j.get(i4));
            }
            int size = iComputeEnumSize + iComputeStringSizeNoTag + (a5().size() * 1);
            if (this.k != null) {
                size += CodedOutputStream.computeMessageSize(10, N0());
            }
            if (!this.l.isEmpty()) {
                size += CodedOutputStream.computeStringSize(11, W());
            }
            if (this.m != null) {
                size += CodedOutputStream.computeMessageSize(12, n4());
            }
            if (this.n != ADModel.ADmodel_default.getNumber()) {
                size += CodedOutputStream.computeEnumSize(13, this.n);
            }
            long j = this.o;
            if (j != 0) {
                size += CodedOutputStream.computeInt64Size(14, j);
            }
            long j2 = this.p;
            if (j2 != 0) {
                size += CodedOutputStream.computeInt64Size(15, j2);
            }
            long j3 = this.q;
            if (j3 != 0) {
                size += CodedOutputStream.computeInt64Size(16, j3);
            }
            if (!this.r.isEmpty()) {
                size += CodedOutputStream.computeStringSize(17, b4());
            }
            if (!this.s.isEmpty()) {
                size += CodedOutputStream.computeStringSize(18, b1());
            }
            if (!this.t.isEmpty()) {
                size += CodedOutputStream.computeStringSize(19, p3());
            }
            if (!this.u.isEmpty()) {
                size += CodedOutputStream.computeStringSize(20, q4());
            }
            if (!this.v.isEmpty()) {
                size += CodedOutputStream.computeStringSize(21, n1());
            }
            if (!this.w.isEmpty()) {
                size += CodedOutputStream.computeStringSize(22, w4());
            }
            if (!this.x.isEmpty()) {
                size += CodedOutputStream.computeStringSize(23, e1());
            }
            if (!this.y.isEmpty()) {
                size += CodedOutputStream.computeStringSize(24, E0());
            }
            if (!this.z.isEmpty()) {
                size += CodedOutputStream.computeStringSize(25, I());
            }
            if (!this.A.isEmpty()) {
                size += CodedOutputStream.computeStringSize(26, z4());
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString i5() {
            return ByteString.copyFromUtf8(this.t);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString k3() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString k4() {
            return ByteString.copyFromUtf8(this.y);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public OsType l4() {
            OsType osTypeForNumber = OsType.forNumber(this.c);
            return osTypeForNumber == null ? OsType.UNRECOGNIZED : osTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString m5() {
            return ByteString.copyFromUtf8(this.A);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String n(int i) {
            return this.j.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String n1() {
            return this.v;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public r n4() {
            r rVar = this.m;
            return rVar == null ? r.T5() : rVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString o() {
            return ByteString.copyFromUtf8(this.z);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String p3() {
            return this.t;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public long q3() {
            return this.q;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String q4() {
            return this.u;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ByteString s1() {
            return ByteString.copyFromUtf8(this.v);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public boolean t2() {
            return this.i != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int u() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public ADModel u5() {
            ADModel aDModelForNumber = ADModel.forNumber(this.n);
            return aDModelForNumber == null ? ADModel.UNRECOGNIZED : aDModelForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String w4() {
            return this.w;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.b != DeviceType.DeviceType_unknown.getNumber()) {
                codedOutputStream.writeEnum(1, this.b);
            }
            if (this.c != OsType.OsType_unknown.getNumber()) {
                codedOutputStream.writeEnum(2, this.c);
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, G5());
            }
            if (!this.e.isEmpty()) {
                codedOutputStream.writeString(4, S0());
            }
            if (!this.f.isEmpty()) {
                codedOutputStream.writeString(5, Y0());
            }
            int i = this.g;
            if (i != 0) {
                codedOutputStream.writeInt32(6, i);
            }
            int i2 = this.h;
            if (i2 != 0) {
                codedOutputStream.writeInt32(7, i2);
            }
            if (this.i != null) {
                codedOutputStream.writeMessage(8, K3());
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                codedOutputStream.writeString(9, this.j.get(i3));
            }
            if (this.k != null) {
                codedOutputStream.writeMessage(10, N0());
            }
            if (!this.l.isEmpty()) {
                codedOutputStream.writeString(11, W());
            }
            if (this.m != null) {
                codedOutputStream.writeMessage(12, n4());
            }
            if (this.n != ADModel.ADmodel_default.getNumber()) {
                codedOutputStream.writeEnum(13, this.n);
            }
            long j = this.o;
            if (j != 0) {
                codedOutputStream.writeInt64(14, j);
            }
            long j2 = this.p;
            if (j2 != 0) {
                codedOutputStream.writeInt64(15, j2);
            }
            long j3 = this.q;
            if (j3 != 0) {
                codedOutputStream.writeInt64(16, j3);
            }
            if (!this.r.isEmpty()) {
                codedOutputStream.writeString(17, b4());
            }
            if (!this.s.isEmpty()) {
                codedOutputStream.writeString(18, b1());
            }
            if (!this.t.isEmpty()) {
                codedOutputStream.writeString(19, p3());
            }
            if (!this.u.isEmpty()) {
                codedOutputStream.writeString(20, q4());
            }
            if (!this.v.isEmpty()) {
                codedOutputStream.writeString(21, n1());
            }
            if (!this.w.isEmpty()) {
                codedOutputStream.writeString(22, w4());
            }
            if (!this.x.isEmpty()) {
                codedOutputStream.writeString(23, e1());
            }
            if (!this.y.isEmpty()) {
                codedOutputStream.writeString(24, E0());
            }
            if (!this.z.isEmpty()) {
                codedOutputStream.writeString(25, I());
            }
            if (this.A.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(26, z4());
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public int x1() {
            return this.j.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.k
        public String z4() {
            return this.A;
        }
    }

    public interface k extends MessageLiteOrBuilder {
        boolean A2();

        ByteString B1();

        int C2();

        String E0();

        String G5();

        String I();

        boolean J();

        ByteString K();

        h K3();

        ByteString K4();

        long K5();

        long L3();

        int M5();

        l N0();

        DeviceType O1();

        int R();

        String S0();

        ByteString U4();

        String W();

        ByteString W4();

        ByteString X0();

        String Y0();

        ByteString a0(int i);

        List<String> a5();

        String b1();

        String b4();

        ByteString c4();

        ByteString d4();

        String e1();

        int f1();

        ByteString i5();

        ByteString k3();

        ByteString k4();

        OsType l4();

        ByteString m5();

        String n(int i);

        String n1();

        r n4();

        ByteString o();

        String p3();

        long q3();

        String q4();

        ByteString s1();

        boolean t2();

        int u();

        ADModel u5();

        String w4();

        int x1();

        String z4();
    }

    public static final class l extends GeneratedMessageLite<l, a> implements m {
        public static final int c = 1;
        public static final int d = 2;
        private static final l e;
        private static volatile Parser<l> f;
        private double a;
        private double b;

        public static final class a extends GeneratedMessageLite.Builder<l, a> implements m {
            private a() {
                super(l.e);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a P5() {
                copyOnWrite();
                ((l) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((l) this.instance).R5();
                return this;
            }

            public a a(double d) {
                copyOnWrite();
                ((l) this.instance).a(d);
                return this;
            }

            public a b(double d) {
                copyOnWrite();
                ((l) this.instance).b(d);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.m
            public double o0() {
                return ((l) this.instance).o0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.m
            public double p0() {
                return ((l) this.instance).p0();
            }
        }

        static {
            l lVar = new l();
            e = lVar;
            lVar.makeImmutable();
        }

        private l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0.0d;
        }

        public static l S5() {
            return e;
        }

        public static a T5() {
            return e.toBuilder();
        }

        public static Parser<l> U5() {
            return e.getParserForType();
        }

        public static l a(ByteString byteString) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(e, byteString);
        }

        public static l a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(e, byteString, extensionRegistryLite);
        }

        public static l a(CodedInputStream codedInputStream) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(e, codedInputStream);
        }

        public static l a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(e, codedInputStream, extensionRegistryLite);
        }

        public static l a(InputStream inputStream) throws IOException {
            return (l) GeneratedMessageLite.parseDelimitedFrom(e, inputStream);
        }

        public static l a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseDelimitedFrom(e, inputStream, extensionRegistryLite);
        }

        public static l a(byte[] bArr) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(e, bArr);
        }

        public static l a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(e, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d2) {
            this.a = d2;
        }

        public static l b(InputStream inputStream) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(e, inputStream);
        }

        public static l b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(e, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(double d2) {
            this.b = d2;
        }

        public static a c(l lVar) {
            return e.toBuilder().mergeFrom(lVar);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new l();
                case 2:
                    return e;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    l lVar = (l) obj2;
                    double d2 = this.a;
                    boolean z2 = d2 != 0.0d;
                    double d3 = lVar.a;
                    this.a = visitor.visitDouble(z2, d2, d3 != 0.0d, d3);
                    double d4 = this.b;
                    boolean z3 = d4 != 0.0d;
                    double d5 = lVar.b;
                    this.b = visitor.visitDouble(z3, d4, d5 != 0.0d, d5);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 9) {
                                    this.a = codedInputStream.readDouble();
                                } else if (tag == 17) {
                                    this.b = codedInputStream.readDouble();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f == null) {
                        synchronized (l.class) {
                            if (f == null) {
                                f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                            }
                            break;
                        }
                    }
                    return f;
                default:
                    throw new UnsupportedOperationException();
            }
            return e;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            double d2 = this.a;
            int iComputeDoubleSize = d2 != 0.0d ? 0 + CodedOutputStream.computeDoubleSize(1, d2) : 0;
            double d3 = this.b;
            if (d3 != 0.0d) {
                iComputeDoubleSize += CodedOutputStream.computeDoubleSize(2, d3);
            }
            this.memoizedSerializedSize = iComputeDoubleSize;
            return iComputeDoubleSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.m
        public double o0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.m
        public double p0() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            double d2 = this.a;
            if (d2 != 0.0d) {
                codedOutputStream.writeDouble(1, d2);
            }
            double d3 = this.b;
            if (d3 != 0.0d) {
                codedOutputStream.writeDouble(2, d3);
            }
        }
    }

    public interface m extends MessageLiteOrBuilder {
        double o0();

        double p0();
    }

    public static final class n extends GeneratedMessageLite<n, b> implements o {
        public static final int h = 1;
        public static final int i = 2;
        public static final int j = 3;
        public static final int k = 4;
        public static final int l = 5;
        private static final Internal.ListAdapter.Converter<Integer, BidType> m = new a();
        public static final int n = 6;
        private static final n o;
        private static volatile Parser<n> p;
        private int a;
        private long b;
        private long e;
        private long g;
        private String c = "";
        private Internal.ProtobufList<String> d = GeneratedMessageLite.emptyProtobufList();
        private Internal.IntList f = GeneratedMessageLite.emptyIntList();

        static class a implements Internal.ListAdapter.Converter<Integer, BidType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.ListAdapter.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BidType convert(Integer num) {
                BidType bidTypeForNumber = BidType.forNumber(num.intValue());
                return bidTypeForNumber == null ? BidType.UNRECOGNIZED : bidTypeForNumber;
            }
        }

        public static final class b extends GeneratedMessageLite.Builder<n, b> implements o {
            private b() {
                super(n.o);
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public List<BidType> F3() {
                return ((n) this.instance).F3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public ByteString G4() {
                return ((n) this.instance).G4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public int H(int i) {
                return ((n) this.instance).H(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public String J(int i) {
                return ((n) this.instance).J(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public int K1() {
                return ((n) this.instance).K1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public int O2() {
                return ((n) this.instance).O2();
            }

            public b P5() {
                copyOnWrite();
                ((n) this.instance).Q5();
                return this;
            }

            public b Q5() {
                copyOnWrite();
                ((n) this.instance).R5();
                return this;
            }

            public b R5() {
                copyOnWrite();
                ((n) this.instance).S5();
                return this;
            }

            public b S5() {
                copyOnWrite();
                ((n) this.instance).T5();
                return this;
            }

            public b T5() {
                copyOnWrite();
                ((n) this.instance).U5();
                return this;
            }

            public b U5() {
                copyOnWrite();
                ((n) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public String V3() {
                return ((n) this.instance).V3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public long W1() {
                return ((n) this.instance).W1();
            }

            public b a(int i, int i2) {
                copyOnWrite();
                ((n) this.instance).a(i, i2);
                return this;
            }

            public b a(int i, BidType bidType) {
                copyOnWrite();
                ((n) this.instance).a(i, bidType);
                return this;
            }

            public b a(int i, String str) {
                copyOnWrite();
                ((n) this.instance).a(i, str);
                return this;
            }

            public b a(long j) {
                copyOnWrite();
                ((n) this.instance).a(j);
                return this;
            }

            public b a(ByteString byteString) {
                copyOnWrite();
                ((n) this.instance).a(byteString);
                return this;
            }

            public b a(BidType bidType) {
                copyOnWrite();
                ((n) this.instance).a(bidType);
                return this;
            }

            public b a(Iterable<? extends BidType> iterable) {
                copyOnWrite();
                ((n) this.instance).a(iterable);
                return this;
            }

            public b a(String str) {
                copyOnWrite();
                ((n) this.instance).a(str);
                return this;
            }

            public b b(long j) {
                copyOnWrite();
                ((n) this.instance).b(j);
                return this;
            }

            public b b(ByteString byteString) {
                copyOnWrite();
                ((n) this.instance).c(byteString);
                return this;
            }

            public b b(Iterable<Integer> iterable) {
                copyOnWrite();
                ((n) this.instance).b(iterable);
                return this;
            }

            public b b(String str) {
                copyOnWrite();
                ((n) this.instance).b(str);
                return this;
            }

            public b c(long j) {
                copyOnWrite();
                ((n) this.instance).c(j);
                return this;
            }

            public b c(Iterable<String> iterable) {
                copyOnWrite();
                ((n) this.instance).c(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public List<String> c2() {
                return Collections.unmodifiableList(((n) this.instance).c2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public long f() {
                return ((n) this.instance).f();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public BidType f0(int i) {
                return ((n) this.instance).f0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public long l3() {
                return ((n) this.instance).l3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public ByteString o(int i) {
                return ((n) this.instance).o(i);
            }

            public b o0(int i) {
                ((n) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
            public List<Integer> z1() {
                return Collections.unmodifiableList(((n) this.instance).z1());
            }
        }

        static {
            n nVar = new n();
            o = nVar;
            nVar.makeImmutable();
        }

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.f = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.g = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.e = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.c = Y5().V3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.b = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.d = GeneratedMessageLite.emptyProtobufList();
        }

        private void W5() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        private void X5() {
            if (this.d.isModifiable()) {
                return;
            }
            this.d = GeneratedMessageLite.mutableCopy(this.d);
        }

        public static n Y5() {
            return o;
        }

        public static b Z5() {
            return o.toBuilder();
        }

        public static n a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(o, byteString, extensionRegistryLite);
        }

        public static n a(CodedInputStream codedInputStream) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(o, codedInputStream);
        }

        public static n a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(o, codedInputStream, extensionRegistryLite);
        }

        public static n a(InputStream inputStream) throws IOException {
            return (n) GeneratedMessageLite.parseDelimitedFrom(o, inputStream);
        }

        public static n a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseDelimitedFrom(o, inputStream, extensionRegistryLite);
        }

        public static n a(byte[] bArr) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(o, bArr);
        }

        public static n a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(o, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3) {
            W5();
            this.f.setInt(i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, BidType bidType) {
            bidType.getClass();
            W5();
            this.f.setInt(i2, bidType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, String str) {
            str.getClass();
            X5();
            this.d.set(i2, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j2) {
            this.g = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            X5();
            this.d.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BidType bidType) {
            bidType.getClass();
            W5();
            this.f.addInt(bidType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends BidType> iterable) {
            W5();
            Iterator<? extends BidType> it = iterable.iterator();
            while (it.hasNext()) {
                this.f.addInt(it.next().getNumber());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            X5();
            this.d.add(str);
        }

        public static Parser<n> a6() {
            return o.getParserForType();
        }

        public static n b(ByteString byteString) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(o, byteString);
        }

        public static n b(InputStream inputStream) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(o, inputStream);
        }

        public static n b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(o, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j2) {
            this.e = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<Integer> iterable) {
            W5();
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                this.f.addInt(it.next().intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(long j2) {
            this.b = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Iterable<String> iterable) {
            X5();
            AbstractMessageLite.addAll(iterable, this.d);
        }

        public static b g(n nVar) {
            return o.toBuilder().mergeFrom(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            W5();
            this.f.addInt(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public List<BidType> F3() {
            return new Internal.ListAdapter(this.f, m);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public ByteString G4() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public int H(int i2) {
            return this.f.getInt(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public String J(int i2) {
            return this.d.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public int K1() {
            return this.d.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public int O2() {
            return this.f.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public String V3() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public long W1() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public List<String> c2() {
            return this.d;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new n();
                case 2:
                    return o;
                case 3:
                    this.d.makeImmutable();
                    this.f.makeImmutable();
                    return null;
                case 4:
                    return new b(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    n nVar = (n) obj2;
                    long j2 = this.b;
                    boolean z2 = j2 != 0;
                    long j3 = nVar.b;
                    this.b = visitor.visitLong(z2, j2, j3 != 0, j3);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !nVar.c.isEmpty(), nVar.c);
                    this.d = visitor.visitList(this.d, nVar.d);
                    long j4 = this.e;
                    boolean z3 = j4 != 0;
                    long j5 = nVar.e;
                    this.e = visitor.visitLong(z3, j4, j5 != 0, j5);
                    this.f = visitor.visitIntList(this.f, nVar.f);
                    long j6 = this.g;
                    boolean z4 = j6 != 0;
                    long j7 = nVar.g;
                    this.g = visitor.visitLong(z4, j6, j7 != 0, j7);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= nVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.b = codedInputStream.readInt64();
                                } else if (tag == 18) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.d.isModifiable()) {
                                        this.d = GeneratedMessageLite.mutableCopy(this.d);
                                    }
                                    this.d.add(stringRequireUtf8);
                                } else if (tag == 32) {
                                    this.e = codedInputStream.readInt64();
                                } else if (tag == 40) {
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    this.f.addInt(codedInputStream.readEnum());
                                } else if (tag == 42) {
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.f.addInt(codedInputStream.readEnum());
                                    }
                                    codedInputStream.popLimit(iPushLimit);
                                } else if (tag == 48) {
                                    this.g = codedInputStream.readInt64();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (p == null) {
                        synchronized (n.class) {
                            if (p == null) {
                                p = new GeneratedMessageLite.DefaultInstanceBasedParser(o);
                            }
                            break;
                        }
                    }
                    return p;
                default:
                    throw new UnsupportedOperationException();
            }
            return o;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public long f() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public BidType f0(int i2) {
            return m.convert(Integer.valueOf(this.f.getInt(i2)));
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            long j2 = this.b;
            int iComputeInt64Size = j2 != 0 ? CodedOutputStream.computeInt64Size(1, j2) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(2, V3());
            }
            int iComputeStringSizeNoTag = 0;
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.d.get(i3));
            }
            int size = iComputeInt64Size + iComputeStringSizeNoTag + (c2().size() * 1);
            long j3 = this.e;
            if (j3 != 0) {
                size += CodedOutputStream.computeInt64Size(4, j3);
            }
            int iComputeEnumSizeNoTag = 0;
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(this.f.getInt(i4));
            }
            int size2 = size + iComputeEnumSizeNoTag + (this.f.size() * 1);
            long j4 = this.g;
            if (j4 != 0) {
                size2 += CodedOutputStream.computeInt64Size(6, j4);
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public long l3() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public ByteString o(int i2) {
            return ByteString.copyFromUtf8(this.d.get(i2));
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            long j2 = this.b;
            if (j2 != 0) {
                codedOutputStream.writeInt64(1, j2);
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, V3());
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeString(3, this.d.get(i2));
            }
            long j3 = this.e;
            if (j3 != 0) {
                codedOutputStream.writeInt64(4, j3);
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                codedOutputStream.writeEnum(5, this.f.getInt(i3));
            }
            long j4 = this.g;
            if (j4 != 0) {
                codedOutputStream.writeInt64(6, j4);
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.o
        public List<Integer> z1() {
            return this.f;
        }
    }

    public interface o extends MessageLiteOrBuilder {
        List<BidType> F3();

        ByteString G4();

        int H(int i);

        String J(int i);

        int K1();

        int O2();

        String V3();

        long W1();

        List<String> c2();

        long f();

        BidType f0(int i);

        long l3();

        ByteString o(int i);

        List<Integer> z1();
    }

    public static final class p extends GeneratedMessageLite<p, a> implements q {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final p g;
        private static volatile Parser<p> h;
        private long a;
        private b b;
        private t c;

        public static final class a extends GeneratedMessageLite.Builder<p, a> implements q {
            private a() {
                super(p.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a P5() {
                copyOnWrite();
                ((p) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((p) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((p) this.instance).S5();
                return this;
            }

            public a a(long j) {
                copyOnWrite();
                ((p) this.instance).a(j);
                return this;
            }

            public a a(b.a aVar) {
                copyOnWrite();
                ((p) this.instance).a(aVar);
                return this;
            }

            public a a(b bVar) {
                copyOnWrite();
                ((p) this.instance).a(bVar);
                return this;
            }

            public a a(t.a aVar) {
                copyOnWrite();
                ((p) this.instance).a(aVar);
                return this;
            }

            public a a(t tVar) {
                copyOnWrite();
                ((p) this.instance).a(tVar);
                return this;
            }

            public a b(b bVar) {
                copyOnWrite();
                ((p) this.instance).b(bVar);
                return this;
            }

            public a b(t tVar) {
                copyOnWrite();
                ((p) this.instance).b(tVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
            public boolean d3() {
                return ((p) this.instance).d3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
            public t m() {
                return ((p) this.instance).m();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
            public long m0() {
                return ((p) this.instance).m0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
            public b v() {
                return ((p) this.instance).v();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
            public boolean y() {
                return ((p) this.instance).y();
            }
        }

        static {
            p pVar = new p();
            g = pVar;
            pVar.makeImmutable();
        }

        private p() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = 0L;
        }

        public static p T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<p> V5() {
            return g.getParserForType();
        }

        public static p a(ByteString byteString) throws InvalidProtocolBufferException {
            return (p) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static p a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (p) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static p a(CodedInputStream codedInputStream) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static p a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static p a(InputStream inputStream) throws IOException {
            return (p) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static p a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (p) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static p a(byte[] bArr) throws InvalidProtocolBufferException {
            return (p) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static p a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (p) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b.a aVar) {
            this.b = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b bVar) {
            b bVar2 = this.b;
            if (bVar2 != null && bVar2 != b.V5()) {
                bVar = b.f(this.b).mergeFrom(bVar).buildPartial();
            }
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(t.a aVar) {
            this.c = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(t tVar) {
            t tVar2 = this.c;
            if (tVar2 != null && tVar2 != t.S5()) {
                tVar = t.c(this.c).mergeFrom(tVar).buildPartial();
            }
            this.c = tVar;
        }

        public static p b(InputStream inputStream) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static p b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(b bVar) {
            bVar.getClass();
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(t tVar) {
            tVar.getClass();
            this.c = tVar;
        }

        public static a d(p pVar) {
            return g.toBuilder().mergeFrom(pVar);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
        public boolean d3() {
            return this.b != null;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new p();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    p pVar = (p) obj2;
                    long j = this.a;
                    boolean z2 = j != 0;
                    long j2 = pVar.a;
                    this.a = visitor.visitLong(z2, j, j2 != 0, j2);
                    this.b = (b) visitor.visitMessage(this.b, pVar.b);
                    this.c = (t) visitor.visitMessage(this.c, pVar.c);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.a = codedInputStream.readInt64();
                                } else if (tag == 18) {
                                    b bVar = this.b;
                                    b.a builder = bVar != null ? bVar.toBuilder() : null;
                                    b bVar2 = (b) codedInputStream.readMessage(b.X5(), extensionRegistryLite);
                                    this.b = bVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(bVar2);
                                        this.b = builder.buildPartial();
                                    }
                                } else if (tag == 26) {
                                    t tVar = this.c;
                                    t.a builder2 = tVar != null ? tVar.toBuilder() : null;
                                    t tVar2 = (t) codedInputStream.readMessage(t.U5(), extensionRegistryLite);
                                    this.c = tVar2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(tVar2);
                                        this.c = builder2.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (h == null) {
                        synchronized (p.class) {
                            if (h == null) {
                                h = new GeneratedMessageLite.DefaultInstanceBasedParser(g);
                            }
                            break;
                        }
                    }
                    return h;
                default:
                    throw new UnsupportedOperationException();
            }
            return g;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            long j = this.a;
            int iComputeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            if (this.b != null) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, v());
            }
            if (this.c != null) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, m());
            }
            this.memoizedSerializedSize = iComputeInt64Size;
            return iComputeInt64Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
        public t m() {
            t tVar = this.c;
            return tVar == null ? t.S5() : tVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
        public long m0() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
        public b v() {
            b bVar = this.b;
            return bVar == null ? b.V5() : bVar;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.a;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, v());
            }
            if (this.c != null) {
                codedOutputStream.writeMessage(3, m());
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.q
        public boolean y() {
            return this.c != null;
        }
    }

    public interface q extends MessageLiteOrBuilder {
        boolean d3();

        t m();

        long m0();

        b v();

        boolean y();
    }

    public static final class r extends GeneratedMessageLite<r, a> implements s {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final r g;
        private static volatile Parser<r> h;
        private int a;
        private String b = "";
        private String c = "";

        public static final class a extends GeneratedMessageLite.Builder<r, a> implements s {
            private a() {
                super(r.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public String A() {
                return ((r) this.instance).A();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public int A1() {
                return ((r) this.instance).A1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public ConnectType B() {
                return ((r) this.instance).B();
            }

            public a P5() {
                copyOnWrite();
                ((r) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((r) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((r) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public String U() {
                return ((r) this.instance).U();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public ByteString Y2() {
                return ((r) this.instance).Y2();
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((r) this.instance).b(byteString);
                return this;
            }

            public a a(ConnectType connectType) {
                copyOnWrite();
                ((r) this.instance).a(connectType);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((r) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((r) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((r) this.instance).b(str);
                return this;
            }

            public a o0(int i) {
                copyOnWrite();
                ((r) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
            public ByteString u2() {
                return ((r) this.instance).u2();
            }
        }

        static {
            r rVar = new r();
            g = rVar;
            rVar.makeImmutable();
        }

        private r() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = T5().A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.c = T5().U();
        }

        public static r T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<r> V5() {
            return g.getParserForType();
        }

        public static r a(ByteString byteString) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static r a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static r a(CodedInputStream codedInputStream) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static r a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static r a(InputStream inputStream) throws IOException {
            return (r) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static r a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static r a(byte[] bArr) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static r a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConnectType connectType) {
            connectType.getClass();
            this.a = connectType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static r b(InputStream inputStream) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static r b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        public static a d(r rVar) {
            return g.toBuilder().mergeFrom(rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.a = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public String A() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public int A1() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public ConnectType B() {
            ConnectType connectTypeForNumber = ConnectType.forNumber(this.a);
            return connectTypeForNumber == null ? ConnectType.UNRECOGNIZED : connectTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public String U() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public ByteString Y2() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new r();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    r rVar = (r) obj2;
                    int i = this.a;
                    boolean z2 = i != 0;
                    int i2 = rVar.a;
                    this.a = visitor.visitInt(z2, i, i2 != 0, i2);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !rVar.b.isEmpty(), rVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !rVar.c.isEmpty(), rVar.c);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.a = codedInputStream.readEnum();
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (h == null) {
                        synchronized (r.class) {
                            if (h == null) {
                                h = new GeneratedMessageLite.DefaultInstanceBasedParser(g);
                            }
                            break;
                        }
                    }
                    return h;
                default:
                    throw new UnsupportedOperationException();
            }
            return g;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = this.a != ConnectType.ConnectType_unknown.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.a) : 0;
            if (!this.b.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(2, A());
            }
            if (!this.c.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(3, U());
            }
            this.memoizedSerializedSize = iComputeEnumSize;
            return iComputeEnumSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.s
        public ByteString u2() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != ConnectType.ConnectType_unknown.getNumber()) {
                codedOutputStream.writeEnum(1, this.a);
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, A());
            }
            if (this.c.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, U());
        }
    }

    public interface s extends MessageLiteOrBuilder {
        String A();

        int A1();

        ConnectType B();

        String U();

        ByteString Y2();

        ByteString u2();
    }

    public static final class t extends GeneratedMessageLite<t, a> implements u {
        public static final int c = 1;
        public static final int d = 2;
        private static final t e;
        private static volatile Parser<t> f;
        private long a;
        private String b = "";

        public static final class a extends GeneratedMessageLite.Builder<t, a> implements u {
            private a() {
                super(t.e);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
            public long P2() {
                return ((t) this.instance).P2();
            }

            public a P5() {
                copyOnWrite();
                ((t) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((t) this.instance).R5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
            public ByteString X4() {
                return ((t) this.instance).X4();
            }

            public a a(long j) {
                copyOnWrite();
                ((t) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((t) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((t) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
            public String x0() {
                return ((t) this.instance).x0();
            }
        }

        static {
            t tVar = new t();
            e = tVar;
            tVar.makeImmutable();
        }

        private t() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = S5().x0();
        }

        public static t S5() {
            return e;
        }

        public static a T5() {
            return e.toBuilder();
        }

        public static Parser<t> U5() {
            return e.getParserForType();
        }

        public static t a(ByteString byteString) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(e, byteString);
        }

        public static t a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(e, byteString, extensionRegistryLite);
        }

        public static t a(CodedInputStream codedInputStream) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(e, codedInputStream);
        }

        public static t a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(e, codedInputStream, extensionRegistryLite);
        }

        public static t a(InputStream inputStream) throws IOException {
            return (t) GeneratedMessageLite.parseDelimitedFrom(e, inputStream);
        }

        public static t a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseDelimitedFrom(e, inputStream, extensionRegistryLite);
        }

        public static t a(byte[] bArr) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(e, bArr);
        }

        public static t a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(e, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static t b(InputStream inputStream) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(e, inputStream);
        }

        public static t b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(e, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        public static a c(t tVar) {
            return e.toBuilder().mergeFrom(tVar);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
        public long P2() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
        public ByteString X4() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new t();
                case 2:
                    return e;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    t tVar = (t) obj2;
                    long j = this.a;
                    boolean z2 = j != 0;
                    long j2 = tVar.a;
                    this.a = visitor.visitLong(z2, j, j2 != 0, j2);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !tVar.b.isEmpty(), tVar.b);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.a = codedInputStream.readInt64();
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (f == null) {
                        synchronized (t.class) {
                            if (f == null) {
                                f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                            }
                            break;
                        }
                    }
                    return f;
                default:
                    throw new UnsupportedOperationException();
            }
            return e;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            long j = this.a;
            int iComputeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            if (!this.b.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(2, x0());
            }
            this.memoizedSerializedSize = iComputeInt64Size;
            return iComputeInt64Size;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.a;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (this.b.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, x0());
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.u
        public String x0() {
            return this.b;
        }
    }

    public interface u extends MessageLiteOrBuilder {
        long P2();

        ByteString X4();

        String x0();
    }

    public static final class v extends GeneratedMessageLite<v, a> implements w {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public static final int h = 4;
        private static final v i;
        private static volatile Parser<v> j;
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";

        public static final class a extends GeneratedMessageLite.Builder<v, a> implements w {
            private a() {
                super(v.i);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public String E3() {
                return ((v) this.instance).E3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public ByteString H4() {
                return ((v) this.instance).H4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public String M4() {
                return ((v) this.instance).M4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public ByteString O3() {
                return ((v) this.instance).O3();
            }

            public a P5() {
                copyOnWrite();
                ((v) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public ByteString Q4() {
                return ((v) this.instance).Q4();
            }

            public a Q5() {
                copyOnWrite();
                ((v) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((v) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((v) this.instance).T5();
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((v) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((v) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((v) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((v) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((v) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((v) this.instance).c(str);
                return this;
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((v) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((v) this.instance).d(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public String e5() {
                return ((v) this.instance).e5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public ByteString q1() {
                return ((v) this.instance).q1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
            public String z() {
                return ((v) this.instance).z();
            }
        }

        static {
            v vVar = new v();
            i = vVar;
            vVar.makeImmutable();
        }

        private v() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.d = U5().z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = U5().M4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = U5().e5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.c = U5().E3();
        }

        public static v U5() {
            return i;
        }

        public static a V5() {
            return i.toBuilder();
        }

        public static Parser<v> W5() {
            return i.getParserForType();
        }

        public static v a(ByteString byteString) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(i, byteString);
        }

        public static v a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(i, byteString, extensionRegistryLite);
        }

        public static v a(CodedInputStream codedInputStream) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(i, codedInputStream);
        }

        public static v a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(i, codedInputStream, extensionRegistryLite);
        }

        public static v a(InputStream inputStream) throws IOException {
            return (v) GeneratedMessageLite.parseDelimitedFrom(i, inputStream);
        }

        public static v a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseDelimitedFrom(i, inputStream, extensionRegistryLite);
        }

        public static v a(byte[] bArr) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(i, bArr);
        }

        public static v a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(i, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.d = str;
        }

        public static v b(InputStream inputStream) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(i, inputStream);
        }

        public static v b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(i, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.c = str;
        }

        public static a e(v vVar) {
            return i.toBuilder().mergeFrom(vVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public String E3() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public ByteString H4() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public String M4() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public ByteString O3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public ByteString Q4() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new v();
                case 2:
                    return i;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    v vVar = (v) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !vVar.a.isEmpty(), vVar.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !vVar.b.isEmpty(), vVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !vVar.c.isEmpty(), vVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, true ^ vVar.d.isEmpty(), vVar.d);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 10) {
                                        this.a = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 18) {
                                        this.b = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 26) {
                                        this.c = codedInputStream.readStringRequireUtf8();
                                    } else if (tag == 34) {
                                        this.d = codedInputStream.readStringRequireUtf8();
                                    } else if (!codedInputStream.skipField(tag)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw new RuntimeException(e3.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (j == null) {
                        synchronized (v.class) {
                            if (j == null) {
                                j = new GeneratedMessageLite.DefaultInstanceBasedParser(i);
                            }
                            break;
                        }
                    }
                    return j;
                default:
                    throw new UnsupportedOperationException();
            }
            return i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public String e5() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, e5());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, M4());
            }
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, E3());
            }
            if (!this.d.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, z());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public ByteString q1() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, e5());
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, M4());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(3, E3());
            }
            if (this.d.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(4, z());
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdReq.w
        public String z() {
            return this.d;
        }
    }

    public interface w extends MessageLiteOrBuilder {
        String E3();

        ByteString H4();

        String M4();

        ByteString O3();

        ByteString Q4();

        String e5();

        ByteString q1();

        String z();
    }

    private TapAdReq() {
    }

    public static void a(ExtensionRegistryLite extensionRegistryLite) {
    }
}
