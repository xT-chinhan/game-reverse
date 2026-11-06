package com.tapsdk.tapad.internal.tracker.experiment.entities;

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
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

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

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.tracker.experiment.entities.b$b, reason: collision with other inner class name */
    public static final class C0635b extends GeneratedMessageLite<C0635b, a> implements i {
        public static final int d = 1;
        public static final int e = 2;
        private static final C0635b f;
        private static volatile Parser<C0635b> g;
        private int a;
        private int b;
        private Internal.ProtobufList<c> c = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.tracker.experiment.entities.b$b$a */
        public static final class a extends GeneratedMessageLite.Builder<C0635b, a> implements i {
            private a() {
                super(C0635b.f);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
            public List<c> O() {
                return Collections.unmodifiableList(((C0635b) this.instance).O());
            }

            public a P5() {
                copyOnWrite();
                ((C0635b) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((C0635b) this.instance).R5();
                return this;
            }

            public a a(int i, c.a aVar) {
                copyOnWrite();
                ((C0635b) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, c cVar) {
                copyOnWrite();
                ((C0635b) this.instance).a(i, cVar);
                return this;
            }

            public a a(c.a aVar) {
                copyOnWrite();
                ((C0635b) this.instance).a(aVar);
                return this;
            }

            public a a(c cVar) {
                copyOnWrite();
                ((C0635b) this.instance).a(cVar);
                return this;
            }

            public a a(Iterable<? extends c> iterable) {
                copyOnWrite();
                ((C0635b) this.instance).a(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
            public int a0() {
                return ((C0635b) this.instance).a0();
            }

            public a b(int i, c.a aVar) {
                copyOnWrite();
                ((C0635b) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, c cVar) {
                copyOnWrite();
                ((C0635b) this.instance).b(i, cVar);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
            public int d0() {
                return ((C0635b) this.instance).d0();
            }

            public a o0(int i) {
                copyOnWrite();
                ((C0635b) this.instance).p0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((C0635b) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
            public c x(int i) {
                return ((C0635b) this.instance).x(i);
            }
        }

        static {
            C0635b c0635b = new C0635b();
            f = c0635b;
            c0635b.makeImmutable();
        }

        private C0635b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0;
        }

        private void S5() {
            if (this.c.isModifiable()) {
                return;
            }
            this.c = GeneratedMessageLite.mutableCopy(this.c);
        }

        public static C0635b U5() {
            return f;
        }

        public static a V5() {
            return f.toBuilder();
        }

        public static Parser<C0635b> W5() {
            return f.getParserForType();
        }

        public static C0635b a(ByteString byteString) throws InvalidProtocolBufferException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, byteString);
        }

        public static C0635b a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, byteString, extensionRegistryLite);
        }

        public static C0635b a(CodedInputStream codedInputStream) throws IOException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, codedInputStream);
        }

        public static C0635b a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, codedInputStream, extensionRegistryLite);
        }

        public static C0635b a(InputStream inputStream) throws IOException {
            return (C0635b) GeneratedMessageLite.parseDelimitedFrom(f, inputStream);
        }

        public static C0635b a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (C0635b) GeneratedMessageLite.parseDelimitedFrom(f, inputStream, extensionRegistryLite);
        }

        public static C0635b a(byte[] bArr) throws InvalidProtocolBufferException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, bArr);
        }

        public static C0635b a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, c.a aVar) {
            S5();
            this.c.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, c cVar) {
            cVar.getClass();
            S5();
            this.c.add(i, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c.a aVar) {
            S5();
            this.c.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            cVar.getClass();
            S5();
            this.c.add(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends c> iterable) {
            S5();
            AbstractMessageLite.addAll(iterable, this.c);
        }

        public static C0635b b(InputStream inputStream) throws IOException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, inputStream);
        }

        public static C0635b b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (C0635b) GeneratedMessageLite.parseFrom(f, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, c.a aVar) {
            S5();
            this.c.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, c cVar) {
            cVar.getClass();
            S5();
            this.c.set(i, cVar);
        }

        public static a c(C0635b c0635b) {
            return f.toBuilder().mergeFrom(c0635b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            S5();
            this.c.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.b = i;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
        public List<c> O() {
            return this.c;
        }

        public List<? extends d> T5() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
        public int a0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
        public int d0() {
            return this.c.size();
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new C0635b();
                case 2:
                    return f;
                case 3:
                    this.c.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    C0635b c0635b = (C0635b) obj2;
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = c0635b.b;
                    this.b = visitor.visitInt(z2, i, i2 != 0, i2);
                    this.c = visitor.visitList(this.c, c0635b.c);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= c0635b.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.b = codedInputStream.readUInt32();
                                } else if (tag == 18) {
                                    if (!this.c.isModifiable()) {
                                        this.c = GeneratedMessageLite.mutableCopy(this.c);
                                    }
                                    this.c.add((c) codedInputStream.readMessage(c.U5(), extensionRegistryLite));
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
                    if (g == null) {
                        synchronized (C0635b.class) {
                            if (g == null) {
                                g = new GeneratedMessageLite.DefaultInstanceBasedParser(f);
                            }
                            break;
                        }
                    }
                    return g;
                default:
                    throw new UnsupportedOperationException();
            }
            return f;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.b;
            int iComputeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                iComputeUInt32Size += CodedOutputStream.computeMessageSize(2, this.c.get(i3));
            }
            this.memoizedSerializedSize = iComputeUInt32Size;
            return iComputeUInt32Size;
        }

        public d o0(int i) {
            return this.c.get(i);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                codedOutputStream.writeMessage(2, this.c.get(i2));
            }
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.i
        public c x(int i) {
            return this.c.get(i);
        }
    }

    public static final class c extends GeneratedMessageLite<c, a> implements d {
        public static final int c = 1;
        public static final int d = 2;
        private static final c e;
        private static volatile Parser<c> f;
        private String a = "";
        private String b = "";

        public static final class a extends GeneratedMessageLite.Builder<c, a> implements d {
            private a() {
                super(c.e);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a P5() {
                copyOnWrite();
                ((c) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((c) this.instance).R5();
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((c) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((c) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((c) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((c) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
            public String getKey() {
                return ((c) this.instance).getKey();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
            public String getValue() {
                return ((c) this.instance).getValue();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
            public ByteString h() {
                return ((c) this.instance).h();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
            public ByteString j() {
                return ((c) this.instance).j();
            }
        }

        static {
            c cVar = new c();
            e = cVar;
            cVar.makeImmutable();
        }

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = S5().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = S5().getValue();
        }

        public static c S5() {
            return e;
        }

        public static a T5() {
            return e.toBuilder();
        }

        public static Parser<c> U5() {
            return e.getParserForType();
        }

        public static c a(ByteString byteString) throws InvalidProtocolBufferException {
            return (c) GeneratedMessageLite.parseFrom(e, byteString);
        }

        public static c a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (c) GeneratedMessageLite.parseFrom(e, byteString, extensionRegistryLite);
        }

        public static c a(CodedInputStream codedInputStream) throws IOException {
            return (c) GeneratedMessageLite.parseFrom(e, codedInputStream);
        }

        public static c a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (c) GeneratedMessageLite.parseFrom(e, codedInputStream, extensionRegistryLite);
        }

        public static c a(InputStream inputStream) throws IOException {
            return (c) GeneratedMessageLite.parseDelimitedFrom(e, inputStream);
        }

        public static c a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (c) GeneratedMessageLite.parseDelimitedFrom(e, inputStream, extensionRegistryLite);
        }

        public static c a(byte[] bArr) throws InvalidProtocolBufferException {
            return (c) GeneratedMessageLite.parseFrom(e, bArr);
        }

        public static c a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (c) GeneratedMessageLite.parseFrom(e, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.a = str;
        }

        public static c b(InputStream inputStream) throws IOException {
            return (c) GeneratedMessageLite.parseFrom(e, inputStream);
        }

        public static c b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (c) GeneratedMessageLite.parseFrom(e, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.b = str;
        }

        public static a c(c cVar) {
            return e.toBuilder().mergeFrom(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return e;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    c cVar = (c) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !cVar.a.isEmpty(), cVar.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, true ^ cVar.b.isEmpty(), cVar.b);
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
                        synchronized (c.class) {
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

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
        public String getKey() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getKey());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getValue());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
        public String getValue() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
        public ByteString h() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.d
        public ByteString j() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, getKey());
            }
            if (this.b.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getValue());
        }
    }

    public interface d extends MessageLiteOrBuilder {
        String getKey();

        String getValue();

        ByteString h();

        ByteString j();
    }

    public static final class e extends GeneratedMessageLite<e, a> implements h {
        public static final int h = 1;
        public static final int i = 2;
        public static final int j = 3;
        public static final int k = 4;
        public static final int l = 5;
        public static final int m = 6;
        private static final e n;
        private static volatile Parser<e> o;
        private int a;
        private Internal.ProtobufList<C0635b> b = GeneratedMessageLite.emptyProtobufList();
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private Internal.ProtobufList<j> g = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<e, a> implements h {
            private a() {
                super(e.n);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public String D2() {
                return ((e) this.instance).D2();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public ByteString I3() {
                return ((e) this.instance).I3();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public int J2() {
                return ((e) this.instance).J2();
            }

            public a P5() {
                copyOnWrite();
                ((e) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((e) this.instance).R5();
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public List<j> R1() {
                return Collections.unmodifiableList(((e) this.instance).R1());
            }

            public a R5() {
                copyOnWrite();
                ((e) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((e) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public List<C0635b> T0() {
                return Collections.unmodifiableList(((e) this.instance).T0());
            }

            public a T5() {
                copyOnWrite();
                ((e) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((e) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public String Z2() {
                return ((e) this.instance).Z2();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public String Z3() {
                return ((e) this.instance).Z3();
            }

            public a a(int i, C0635b.a aVar) {
                copyOnWrite();
                ((e) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, C0635b c0635b) {
                copyOnWrite();
                ((e) this.instance).a(i, c0635b);
                return this;
            }

            public a a(int i, j.a aVar) {
                copyOnWrite();
                ((e) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, j jVar) {
                copyOnWrite();
                ((e) this.instance).a(i, jVar);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((e) this.instance).b(byteString);
                return this;
            }

            public a a(C0635b.a aVar) {
                copyOnWrite();
                ((e) this.instance).a(aVar);
                return this;
            }

            public a a(C0635b c0635b) {
                copyOnWrite();
                ((e) this.instance).a(c0635b);
                return this;
            }

            public a a(j.a aVar) {
                copyOnWrite();
                ((e) this.instance).a(aVar);
                return this;
            }

            public a a(j jVar) {
                copyOnWrite();
                ((e) this.instance).a(jVar);
                return this;
            }

            public a a(Iterable<? extends j> iterable) {
                copyOnWrite();
                ((e) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((e) this.instance).a(str);
                return this;
            }

            public a b(int i, C0635b.a aVar) {
                copyOnWrite();
                ((e) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, C0635b c0635b) {
                copyOnWrite();
                ((e) this.instance).b(i, c0635b);
                return this;
            }

            public a b(int i, j.a aVar) {
                copyOnWrite();
                ((e) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, j jVar) {
                copyOnWrite();
                ((e) this.instance).b(i, jVar);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((e) this.instance).c(byteString);
                return this;
            }

            public a b(Iterable<? extends C0635b> iterable) {
                copyOnWrite();
                ((e) this.instance).b(iterable);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((e) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public ByteString b3() {
                return ((e) this.instance).b3();
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((e) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((e) this.instance).c(str);
                return this;
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((e) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((e) this.instance).d(str);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public int f4() {
                return ((e) this.instance).f4();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public j h(int i) {
                return ((e) this.instance).h(i);
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public ByteString m4() {
                return ((e) this.instance).m4();
            }

            public a o0(int i) {
                copyOnWrite();
                ((e) this.instance).q0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((e) this.instance).r0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public ByteString q2() {
                return ((e) this.instance).q2();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public C0635b t(int i) {
                return ((e) this.instance).t(i);
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
            public String w3() {
                return ((e) this.instance).w3();
            }
        }

        static {
            e eVar = new e();
            n = eVar;
            eVar.makeImmutable();
        }

        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = Y5().w3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.g = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.b = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.f = Y5().Z3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.e = Y5().Z2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.d = Y5().D2();
        }

        private void W5() {
            if (this.g.isModifiable()) {
                return;
            }
            this.g = GeneratedMessageLite.mutableCopy(this.g);
        }

        private void X5() {
            if (this.b.isModifiable()) {
                return;
            }
            this.b = GeneratedMessageLite.mutableCopy(this.b);
        }

        public static e Y5() {
            return n;
        }

        public static e a(ByteString byteString) throws InvalidProtocolBufferException {
            return (e) GeneratedMessageLite.parseFrom(n, byteString);
        }

        public static e a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (e) GeneratedMessageLite.parseFrom(n, byteString, extensionRegistryLite);
        }

        public static e a(CodedInputStream codedInputStream) throws IOException {
            return (e) GeneratedMessageLite.parseFrom(n, codedInputStream);
        }

        public static e a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (e) GeneratedMessageLite.parseFrom(n, codedInputStream, extensionRegistryLite);
        }

        public static e a(InputStream inputStream) throws IOException {
            return (e) GeneratedMessageLite.parseDelimitedFrom(n, inputStream);
        }

        public static e a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (e) GeneratedMessageLite.parseDelimitedFrom(n, inputStream, extensionRegistryLite);
        }

        public static e a(byte[] bArr) throws InvalidProtocolBufferException {
            return (e) GeneratedMessageLite.parseFrom(n, bArr);
        }

        public static e a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (e) GeneratedMessageLite.parseFrom(n, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, C0635b.a aVar) {
            X5();
            this.b.add(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, C0635b c0635b) {
            c0635b.getClass();
            X5();
            this.b.add(i2, c0635b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, j.a aVar) {
            W5();
            this.g.add(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, j jVar) {
            jVar.getClass();
            W5();
            this.g.add(i2, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(C0635b.a aVar) {
            X5();
            this.b.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(C0635b c0635b) {
            c0635b.getClass();
            X5();
            this.b.add(c0635b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j.a aVar) {
            W5();
            this.g.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j jVar) {
            jVar.getClass();
            W5();
            this.g.add(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends j> iterable) {
            W5();
            AbstractMessageLite.addAll(iterable, this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.c = str;
        }

        public static e b(InputStream inputStream) throws IOException {
            return (e) GeneratedMessageLite.parseFrom(n, inputStream);
        }

        public static e b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (e) GeneratedMessageLite.parseFrom(n, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, C0635b.a aVar) {
            X5();
            this.b.set(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, C0635b c0635b) {
            c0635b.getClass();
            X5();
            this.b.set(i2, c0635b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, j.a aVar) {
            W5();
            this.g.set(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, j jVar) {
            jVar.getClass();
            W5();
            this.g.set(i2, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<? extends C0635b> iterable) {
            X5();
            AbstractMessageLite.addAll(iterable, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.f = str;
        }

        public static a b6() {
            return n.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.e = str;
        }

        public static Parser<e> c6() {
            return n.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        public static a g(e eVar) {
            return n.toBuilder().mergeFrom(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            W5();
            this.g.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i2) {
            X5();
            this.b.remove(i2);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public String D2() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public ByteString I3() {
            return ByteString.copyFromUtf8(this.f);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public int J2() {
            return this.g.size();
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public List<j> R1() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public List<C0635b> T0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public String Z2() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public String Z3() {
            return this.f;
        }

        public List<? extends k> Z5() {
            return this.g;
        }

        public List<? extends i> a6() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public ByteString b3() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            Object objW5;
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new e();
                case 2:
                    return n;
                case 3:
                    this.b.makeImmutable();
                    this.g.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    e eVar = (e) obj2;
                    this.b = visitor.visitList(this.b, eVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !eVar.c.isEmpty(), eVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !eVar.d.isEmpty(), eVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, !eVar.e.isEmpty(), eVar.e);
                    this.f = visitor.visitString(!this.f.isEmpty(), this.f, true ^ eVar.f.isEmpty(), eVar.f);
                    this.g = visitor.visitList(this.g, eVar.g);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= eVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    if (!this.b.isModifiable()) {
                                        this.b = GeneratedMessageLite.mutableCopy(this.b);
                                    }
                                    list = this.b;
                                    objW5 = C0635b.W5();
                                } else if (tag == 18) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.d = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.e = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    this.f = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 50) {
                                    if (!this.g.isModifiable()) {
                                        this.g = GeneratedMessageLite.mutableCopy(this.g);
                                    }
                                    list = this.g;
                                    objW5 = j.U5();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                                list.add(codedInputStream.readMessage((Parser) objW5, extensionRegistryLite));
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
                    if (o == null) {
                        synchronized (e.class) {
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

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public int f4() {
            return this.b.size();
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeMessageSize = 0;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
            }
            if (!this.c.isEmpty()) {
                iComputeMessageSize += CodedOutputStream.computeStringSize(2, w3());
            }
            if (!this.d.isEmpty()) {
                iComputeMessageSize += CodedOutputStream.computeStringSize(3, D2());
            }
            if (!this.e.isEmpty()) {
                iComputeMessageSize += CodedOutputStream.computeStringSize(4, Z2());
            }
            if (!this.f.isEmpty()) {
                iComputeMessageSize += CodedOutputStream.computeStringSize(5, Z3());
            }
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.g.get(i4));
            }
            this.memoizedSerializedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public j h(int i2) {
            return this.g.get(i2);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public ByteString m4() {
            return ByteString.copyFromUtf8(this.d);
        }

        public k o0(int i2) {
            return this.g.get(i2);
        }

        public i p0(int i2) {
            return this.b.get(i2);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public ByteString q2() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public C0635b t(int i2) {
            return this.b.get(i2);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.h
        public String w3() {
            return this.c;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                codedOutputStream.writeMessage(1, this.b.get(i2));
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, w3());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, D2());
            }
            if (!this.e.isEmpty()) {
                codedOutputStream.writeString(4, Z2());
            }
            if (!this.f.isEmpty()) {
                codedOutputStream.writeString(5, Z3());
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                codedOutputStream.writeMessage(6, this.g.get(i3));
            }
        }
    }

    public static final class f extends GeneratedMessageLite<f, a> implements g {
        public static final int b = 1;
        private static final f c;
        private static volatile Parser<f> d;
        private Internal.ProtobufList<e> a = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<f, a> implements g {
            private a() {
                super(f.c);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
            public List<e> D5() {
                return Collections.unmodifiableList(((f) this.instance).D5());
            }

            public a P5() {
                copyOnWrite();
                ((f) this.instance).Q5();
                return this;
            }

            public a a(int i, e.a aVar) {
                copyOnWrite();
                ((f) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, e eVar) {
                copyOnWrite();
                ((f) this.instance).a(i, eVar);
                return this;
            }

            public a a(e.a aVar) {
                copyOnWrite();
                ((f) this.instance).a(aVar);
                return this;
            }

            public a a(e eVar) {
                copyOnWrite();
                ((f) this.instance).a(eVar);
                return this;
            }

            public a a(Iterable<? extends e> iterable) {
                copyOnWrite();
                ((f) this.instance).a(iterable);
                return this;
            }

            public a b(int i, e.a aVar) {
                copyOnWrite();
                ((f) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, e eVar) {
                copyOnWrite();
                ((f) this.instance).b(i, eVar);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
            public e j(int i) {
                return ((f) this.instance).j(i);
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
            public int k2() {
                return ((f) this.instance).k2();
            }

            public a o0(int i) {
                copyOnWrite();
                ((f) this.instance).p0(i);
                return this;
            }
        }

        static {
            f fVar = new f();
            c = fVar;
            fVar.makeImmutable();
        }

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = GeneratedMessageLite.emptyProtobufList();
        }

        private void R5() {
            if (this.a.isModifiable()) {
                return;
            }
            this.a = GeneratedMessageLite.mutableCopy(this.a);
        }

        public static f S5() {
            return c;
        }

        public static a U5() {
            return c.toBuilder();
        }

        public static Parser<f> V5() {
            return c.getParserForType();
        }

        public static f a(ByteString byteString) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(c, byteString);
        }

        public static f a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(c, byteString, extensionRegistryLite);
        }

        public static f a(CodedInputStream codedInputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(c, codedInputStream);
        }

        public static f a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(c, codedInputStream, extensionRegistryLite);
        }

        public static f a(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(c, inputStream);
        }

        public static f a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(c, inputStream, extensionRegistryLite);
        }

        public static f a(byte[] bArr) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(c, bArr);
        }

        public static f a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(c, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, e.a aVar) {
            R5();
            this.a.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, e eVar) {
            eVar.getClass();
            R5();
            this.a.add(i, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(e.a aVar) {
            R5();
            this.a.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(e eVar) {
            eVar.getClass();
            R5();
            this.a.add(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends e> iterable) {
            R5();
            AbstractMessageLite.addAll(iterable, this.a);
        }

        public static a b(f fVar) {
            return c.toBuilder().mergeFrom(fVar);
        }

        public static f b(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(c, inputStream);
        }

        public static f b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(c, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, e.a aVar) {
            R5();
            this.a.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, e eVar) {
            eVar.getClass();
            R5();
            this.a.set(i, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            R5();
            this.a.remove(i);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
        public List<e> D5() {
            return this.a;
        }

        public List<? extends h> T5() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return c;
                case 3:
                    this.a.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    this.a = ((GeneratedMessageLite.Visitor) obj).visitList(this.a, ((f) obj2).a);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    if (!this.a.isModifiable()) {
                                        this.a = GeneratedMessageLite.mutableCopy(this.a);
                                    }
                                    this.a.add((e) codedInputStream.readMessage(e.c6(), extensionRegistryLite));
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
                    if (d == null) {
                        synchronized (f.class) {
                            if (d == null) {
                                d = new GeneratedMessageLite.DefaultInstanceBasedParser(c);
                            }
                            break;
                        }
                    }
                    return d;
                default:
                    throw new UnsupportedOperationException();
            }
            return c;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.a.get(i2));
            }
            this.memoizedSerializedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
        public e j(int i) {
            return this.a.get(i);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.g
        public int k2() {
            return this.a.size();
        }

        public h o0(int i) {
            return this.a.get(i);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.a.size(); i++) {
                codedOutputStream.writeMessage(1, this.a.get(i));
            }
        }
    }

    public interface g extends MessageLiteOrBuilder {
        List<e> D5();

        e j(int i);

        int k2();
    }

    public interface h extends MessageLiteOrBuilder {
        String D2();

        ByteString I3();

        int J2();

        List<j> R1();

        List<C0635b> T0();

        String Z2();

        String Z3();

        ByteString b3();

        int f4();

        j h(int i);

        ByteString m4();

        ByteString q2();

        C0635b t(int i);

        String w3();
    }

    public interface i extends MessageLiteOrBuilder {
        List<c> O();

        int a0();

        int d0();

        c x(int i);
    }

    public static final class j extends GeneratedMessageLite<j, a> implements k {
        public static final int c = 1;
        public static final int d = 2;
        private static final j e;
        private static volatile Parser<j> f;
        private String a = "";
        private String b = "";

        public static final class a extends GeneratedMessageLite.Builder<j, a> implements k {
            private a() {
                super(j.e);
            }

            /* synthetic */ a(a aVar) {
                this();
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

            public a a(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((j) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((j) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((j) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
            public String getKey() {
                return ((j) this.instance).getKey();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
            public String getValue() {
                return ((j) this.instance).getValue();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
            public ByteString h() {
                return ((j) this.instance).h();
            }

            @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
            public ByteString j() {
                return ((j) this.instance).j();
            }
        }

        static {
            j jVar = new j();
            e = jVar;
            jVar.makeImmutable();
        }

        private j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = S5().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = S5().getValue();
        }

        public static j S5() {
            return e;
        }

        public static a T5() {
            return e.toBuilder();
        }

        public static Parser<j> U5() {
            return e.getParserForType();
        }

        public static j a(ByteString byteString) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(e, byteString);
        }

        public static j a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(e, byteString, extensionRegistryLite);
        }

        public static j a(CodedInputStream codedInputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(e, codedInputStream);
        }

        public static j a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(e, codedInputStream, extensionRegistryLite);
        }

        public static j a(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(e, inputStream);
        }

        public static j a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(e, inputStream, extensionRegistryLite);
        }

        public static j a(byte[] bArr) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(e, bArr);
        }

        public static j a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(e, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.a = str;
        }

        public static j b(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(e, inputStream);
        }

        public static j b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(e, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.b = str;
        }

        public static a c(j jVar) {
            return e.toBuilder().mergeFrom(jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return e;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    j jVar = (j) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !jVar.a.isEmpty(), jVar.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, true ^ jVar.b.isEmpty(), jVar.b);
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
                        synchronized (j.class) {
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

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
        public String getKey() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getKey());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, getValue());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
        public String getValue() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
        public ByteString h() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.internal.tracker.experiment.entities.b.k
        public ByteString j() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, getKey());
            }
            if (this.b.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getValue());
        }
    }

    public interface k extends MessageLiteOrBuilder {
        String getKey();

        String getValue();

        ByteString h();

        ByteString j();
    }

    private b() {
    }

    public static void a(ExtensionRegistryLite extensionRegistryLite) {
    }
}
