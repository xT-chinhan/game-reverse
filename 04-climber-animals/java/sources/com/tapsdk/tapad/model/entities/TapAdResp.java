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
public final class TapAdResp {

    public enum ApkDownloadType implements Internal.EnumLite {
        ApkDownloadType_default(0),
        ApkDownloadType_not_parallel(1),
        UNRECOGNIZED(-1);

        public static final int ApkDownloadType_default_VALUE = 0;
        public static final int ApkDownloadType_not_parallel_VALUE = 1;
        private static final Internal.EnumLiteMap<ApkDownloadType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<ApkDownloadType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApkDownloadType findValueByNumber(int i) {
                return ApkDownloadType.forNumber(i);
            }
        }

        ApkDownloadType(int i) {
            this.value = i;
        }

        public static ApkDownloadType forNumber(int i) {
            if (i == 0) {
                return ApkDownloadType_default;
            }
            if (i != 1) {
                return null;
            }
            return ApkDownloadType_not_parallel;
        }

        public static Internal.EnumLiteMap<ApkDownloadType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ApkDownloadType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum ApkVerifyType implements Internal.EnumLite {
        ApkVerifyType_default(0),
        ApkVerifyType_not_verify(1),
        UNRECOGNIZED(-1);

        public static final int ApkVerifyType_default_VALUE = 0;
        public static final int ApkVerifyType_not_verify_VALUE = 1;
        private static final Internal.EnumLiteMap<ApkVerifyType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<ApkVerifyType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApkVerifyType findValueByNumber(int i) {
                return ApkVerifyType.forNumber(i);
            }
        }

        ApkVerifyType(int i) {
            this.value = i;
        }

        public static ApkVerifyType forNumber(int i) {
            if (i == 0) {
                return ApkVerifyType_default;
            }
            if (i != 1) {
                return null;
            }
            return ApkVerifyType_not_verify;
        }

        public static Internal.EnumLiteMap<ApkVerifyType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ApkVerifyType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum ExposureFieldType implements Internal.EnumLite {
        SCREEN_AREA_PERCENT(0),
        AD_AREA_PERCENT(1),
        AD_WIDTH_PIXEL(2),
        IMAGE_DISPLAY_MILLISECONDS(3),
        AD_DISPLAY_MILLISECONDS(4),
        VIDEO_PLAY_MILLISECONDS(5),
        UNRECOGNIZED(-1);

        public static final int AD_AREA_PERCENT_VALUE = 1;
        public static final int AD_DISPLAY_MILLISECONDS_VALUE = 4;
        public static final int AD_WIDTH_PIXEL_VALUE = 2;
        public static final int IMAGE_DISPLAY_MILLISECONDS_VALUE = 3;
        public static final int SCREEN_AREA_PERCENT_VALUE = 0;
        public static final int VIDEO_PLAY_MILLISECONDS_VALUE = 5;
        private static final Internal.EnumLiteMap<ExposureFieldType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<ExposureFieldType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ExposureFieldType findValueByNumber(int i) {
                return ExposureFieldType.forNumber(i);
            }
        }

        ExposureFieldType(int i) {
            this.value = i;
        }

        public static ExposureFieldType forNumber(int i) {
            if (i == 0) {
                return SCREEN_AREA_PERCENT;
            }
            if (i == 1) {
                return AD_AREA_PERCENT;
            }
            if (i == 2) {
                return AD_WIDTH_PIXEL;
            }
            if (i == 3) {
                return IMAGE_DISPLAY_MILLISECONDS;
            }
            if (i == 4) {
                return AD_DISPLAY_MILLISECONDS;
            }
            if (i != 5) {
                return null;
            }
            return VIDEO_PLAY_MILLISECONDS;
        }

        public static Internal.EnumLiteMap<ExposureFieldType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ExposureFieldType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum InteractionType implements Internal.EnumLite {
        InteractionType_unknown(0),
        InteractionType_appDownload(1),
        InteractionType_deeplink(2),
        InteractionType_landing_url(3),
        InteractionType_mini_program(4),
        UNRECOGNIZED(-1);

        public static final int InteractionType_appDownload_VALUE = 1;
        public static final int InteractionType_deeplink_VALUE = 2;
        public static final int InteractionType_landing_url_VALUE = 3;
        public static final int InteractionType_mini_program_VALUE = 4;
        public static final int InteractionType_unknown_VALUE = 0;
        private static final Internal.EnumLiteMap<InteractionType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<InteractionType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public InteractionType findValueByNumber(int i) {
                return InteractionType.forNumber(i);
            }
        }

        InteractionType(int i) {
            this.value = i;
        }

        public static InteractionType forNumber(int i) {
            if (i == 0) {
                return InteractionType_unknown;
            }
            if (i == 1) {
                return InteractionType_appDownload;
            }
            if (i == 2) {
                return InteractionType_deeplink;
            }
            if (i == 3) {
                return InteractionType_landing_url;
            }
            if (i != 4) {
                return null;
            }
            return InteractionType_mini_program;
        }

        public static Internal.EnumLiteMap<InteractionType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static InteractionType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum LandingType implements Internal.EnumLite {
        LandingType_default(0),
        LandingType_web_view(1),
        LandingType_web_view_302(2),
        UNRECOGNIZED(-1);

        public static final int LandingType_default_VALUE = 0;
        public static final int LandingType_web_view_302_VALUE = 2;
        public static final int LandingType_web_view_VALUE = 1;
        private static final Internal.EnumLiteMap<LandingType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<LandingType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LandingType findValueByNumber(int i) {
                return LandingType.forNumber(i);
            }
        }

        LandingType(int i) {
            this.value = i;
        }

        public static LandingType forNumber(int i) {
            if (i == 0) {
                return LandingType_default;
            }
            if (i == 1) {
                return LandingType_web_view;
            }
            if (i != 2) {
                return null;
            }
            return LandingType_web_view_302;
        }

        public static Internal.EnumLiteMap<LandingType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static LandingType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum MaterialType implements Internal.EnumLite {
        MaterialType_unknown(0),
        MaterialType_image(1),
        MaterialType_video(2),
        MaterialType_icon(3),
        MaterialType_multiImage(5),
        UNRECOGNIZED(-1);

        public static final int MaterialType_icon_VALUE = 3;
        public static final int MaterialType_image_VALUE = 1;
        public static final int MaterialType_multiImage_VALUE = 5;
        public static final int MaterialType_unknown_VALUE = 0;
        public static final int MaterialType_video_VALUE = 2;
        private static final Internal.EnumLiteMap<MaterialType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<MaterialType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MaterialType findValueByNumber(int i) {
                return MaterialType.forNumber(i);
            }
        }

        MaterialType(int i) {
            this.value = i;
        }

        public static MaterialType forNumber(int i) {
            if (i == 0) {
                return MaterialType_unknown;
            }
            if (i == 1) {
                return MaterialType_image;
            }
            if (i == 2) {
                return MaterialType_video;
            }
            if (i == 3) {
                return MaterialType_icon;
            }
            if (i != 5) {
                return null;
            }
            return MaterialType_multiImage;
        }

        public static Internal.EnumLiteMap<MaterialType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static MaterialType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum TriggerStyle implements Internal.EnumLite {
        TriggerStyle_default(0),
        TriggerStyle_shake(1),
        TriggerStyle_hot_area(2),
        TriggerStyle_hot_area_and_shake(3),
        UNRECOGNIZED(-1);

        public static final int TriggerStyle_default_VALUE = 0;
        public static final int TriggerStyle_hot_area_VALUE = 2;
        public static final int TriggerStyle_hot_area_and_shake_VALUE = 3;
        public static final int TriggerStyle_shake_VALUE = 1;
        private static final Internal.EnumLiteMap<TriggerStyle> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<TriggerStyle> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TriggerStyle findValueByNumber(int i) {
                return TriggerStyle.forNumber(i);
            }
        }

        TriggerStyle(int i) {
            this.value = i;
        }

        public static TriggerStyle forNumber(int i) {
            if (i == 0) {
                return TriggerStyle_default;
            }
            if (i == 1) {
                return TriggerStyle_shake;
            }
            if (i == 2) {
                return TriggerStyle_hot_area;
            }
            if (i != 3) {
                return null;
            }
            return TriggerStyle_hot_area_and_shake;
        }

        public static Internal.EnumLiteMap<TriggerStyle> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static TriggerStyle valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.tapadn.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum VideoType implements Internal.EnumLite {
        VideoType_unknown(0),
        VideoType_horizontal(1),
        VideoType_Vertical(2),
        UNRECOGNIZED(-1);

        public static final int VideoType_Vertical_VALUE = 2;
        public static final int VideoType_horizontal_VALUE = 1;
        public static final int VideoType_unknown_VALUE = 0;
        private static final Internal.EnumLiteMap<VideoType> internalValueMap = new a();
        private final int value;

        static class a implements Internal.EnumLiteMap<VideoType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.EnumLiteMap
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public VideoType findValueByNumber(int i) {
                return VideoType.forNumber(i);
            }
        }

        VideoType(int i) {
            this.value = i;
        }

        public static VideoType forNumber(int i) {
            if (i == 0) {
                return VideoType_unknown;
            }
            if (i == 1) {
                return VideoType_horizontal;
            }
            if (i != 2) {
                return null;
            }
            return VideoType_Vertical;
        }

        public static Internal.EnumLiteMap<VideoType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static VideoType valueOf(int i) {
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

    public interface a0 extends MessageLiteOrBuilder {
        int F0();

        int H2();

        int h0();

        int o1();
    }

    public static final class b extends GeneratedMessageLite<b, a> implements c {
        public static final int A0 = 37;
        public static final int B0 = 38;
        public static final int C0 = 39;
        public static final int D0 = 40;
        public static final int E0 = 41;
        private static final b F0;
        private static volatile Parser<b> G0 = null;
        public static final int Q = 1;
        public static final int R = 2;
        public static final int S = 3;
        public static final int T = 4;
        public static final int U = 5;
        public static final int V = 6;
        public static final int W = 7;
        public static final int X = 8;
        public static final int Y = 9;
        public static final int Z = 10;
        public static final int a0 = 11;
        public static final int b0 = 12;
        public static final int c0 = 13;
        public static final int d0 = 14;
        public static final int e0 = 15;
        public static final int f0 = 16;
        public static final int g0 = 17;
        public static final int h0 = 18;
        public static final int i0 = 19;
        public static final int j0 = 20;
        public static final int k0 = 21;
        public static final int l0 = 22;
        public static final int m0 = 23;
        public static final int n0 = 24;
        public static final int o0 = 25;
        public static final int p0 = 26;
        public static final int q0 = 29;
        public static final int r0 = 30;
        public static final int s0 = 31;
        public static final int t0 = 32;
        public static final int u0 = 27;
        public static final int v0 = 28;
        public static final int w0 = 33;
        public static final int x0 = 34;
        public static final int y0 = 35;
        public static final int z0 = 36;
        private l G;
        private f0 J;
        private d0 K;
        private int N;
        private t P;
        private int a;
        private long c;
        private int d;
        private f m;
        private z n;
        private r p;
        private r q;
        private x r;
        private long s;
        private int t;
        private long u;
        private int v;
        private int w;
        private v x;
        private j y;
        private String b = "";
        private Internal.ProtobufList<String> e = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> f = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> g = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> h = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> i = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> j = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> k = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> l = GeneratedMessageLite.emptyProtobufList();
        private String o = "";
        private Internal.ProtobufList<b0> z = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> A = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> B = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> C = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> D = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> E = GeneratedMessageLite.emptyProtobufList();
        private String F = "";
        private Internal.ProtobufList<String> H = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> I = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> L = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> M = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> O = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<b, a> implements c {
            private a() {
                super(b.F0);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String A(int i) {
                return ((b) this.instance).A(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString A0() {
                return ((b) this.instance).A0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> A5() {
                return Collections.unmodifiableList(((b) this.instance).A5());
            }

            public a A6() {
                copyOnWrite();
                ((b) this.instance).B6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int B0() {
                return ((b) this.instance).B0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> B2() {
                return Collections.unmodifiableList(((b) this.instance).B2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean B3() {
                return ((b) this.instance).B3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public t B4() {
                return ((b) this.instance).B4();
            }

            public a B6() {
                copyOnWrite();
                ((b) this.instance).C6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String C(int i) {
                return ((b) this.instance).C(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean C() {
                return ((b) this.instance).C();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public long C0() {
                return ((b) this.instance).C0();
            }

            public a C6() {
                copyOnWrite();
                ((b) this.instance).D6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public z D() {
                return ((b) this.instance).D();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int D4() {
                return ((b) this.instance).D4();
            }

            public a D6() {
                copyOnWrite();
                ((b) this.instance).E6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int E() {
                return ((b) this.instance).E();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String E(int i) {
                return ((b) this.instance).E(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> E2() {
                return Collections.unmodifiableList(((b) this.instance).E2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public l E4() {
                return ((b) this.instance).E4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String F(int i) {
                return ((b) this.instance).F(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public v F4() {
                return ((b) this.instance).F4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int F5() {
                return ((b) this.instance).F5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int G() {
                return ((b) this.instance).G();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String G(int i) {
                return ((b) this.instance).G(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean G2() {
                return ((b) this.instance).G2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int H3() {
                return ((b) this.instance).H3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String I(int i) {
                return ((b) this.instance).I(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public d0 J4() {
                return ((b) this.instance).J4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString K(int i) {
                return ((b) this.instance).K(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int K0() {
                return ((b) this.instance).K0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString L(int i) {
                return ((b) this.instance).L(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> L2() {
                return Collections.unmodifiableList(((b) this.instance).L2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int L4() {
                return ((b) this.instance).L4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString M(int i) {
                return ((b) this.instance).M(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String O(int i) {
                return ((b) this.instance).O(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int P1() {
                return ((b) this.instance).P1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int P4() {
                return ((b) this.instance).P4();
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

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> R2() {
                return Collections.unmodifiableList(((b) this.instance).R2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public r R3() {
                return ((b) this.instance).R3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString R4() {
                return ((b) this.instance).R4();
            }

            public a R5() {
                copyOnWrite();
                ((b) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String S(int i) {
                return ((b) this.instance).S(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> S4() {
                return Collections.unmodifiableList(((b) this.instance).S4());
            }

            public a S5() {
                copyOnWrite();
                ((b) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString T(int i) {
                return ((b) this.instance).T(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> T3() {
                return Collections.unmodifiableList(((b) this.instance).T3());
            }

            public a T5() {
                copyOnWrite();
                ((b) this.instance).U5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean U0() {
                return ((b) this.instance).U0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> U2() {
                return Collections.unmodifiableList(((b) this.instance).U2());
            }

            public a U5() {
                copyOnWrite();
                ((b) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int V() {
                return ((b) this.instance).V();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String V(int i) {
                return ((b) this.instance).V(i);
            }

            public a V5() {
                copyOnWrite();
                ((b) this.instance).W5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public j W2() {
                return ((b) this.instance).W2();
            }

            public a W5() {
                copyOnWrite();
                ((b) this.instance).X5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String X(int i) {
                return ((b) this.instance).X(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean X() {
                return ((b) this.instance).X();
            }

            public a X5() {
                copyOnWrite();
                ((b) this.instance).Y5();
                return this;
            }

            public a Y5() {
                copyOnWrite();
                ((b) this.instance).Z5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString Z(int i) {
                return ((b) this.instance).Z(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> Z() {
                return Collections.unmodifiableList(((b) this.instance).Z());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> Z0() {
                return Collections.unmodifiableList(((b) this.instance).Z0());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean Z1() {
                return ((b) this.instance).Z1();
            }

            public a Z5() {
                copyOnWrite();
                ((b) this.instance).a6();
                return this;
            }

            public a a(int i, b0.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, b0 b0Var) {
                copyOnWrite();
                ((b) this.instance).a(i, b0Var);
                return this;
            }

            public a a(int i, String str) {
                copyOnWrite();
                ((b) this.instance).a(i, str);
                return this;
            }

            public a a(long j) {
                copyOnWrite();
                ((b) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).a(byteString);
                return this;
            }

            public a a(TapAdReq.BidType bidType) {
                copyOnWrite();
                ((b) this.instance).a(bidType);
                return this;
            }

            public a a(b0.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(b0 b0Var) {
                copyOnWrite();
                ((b) this.instance).a(b0Var);
                return this;
            }

            public a a(d0.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(d0 d0Var) {
                copyOnWrite();
                ((b) this.instance).a(d0Var);
                return this;
            }

            public a a(f.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(f0.b bVar) {
                copyOnWrite();
                ((b) this.instance).a(bVar);
                return this;
            }

            public a a(f0 f0Var) {
                copyOnWrite();
                ((b) this.instance).a(f0Var);
                return this;
            }

            public a a(f fVar) {
                copyOnWrite();
                ((b) this.instance).a(fVar);
                return this;
            }

            public a a(j.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(j jVar) {
                copyOnWrite();
                ((b) this.instance).a(jVar);
                return this;
            }

            public a a(l.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(l lVar) {
                copyOnWrite();
                ((b) this.instance).a(lVar);
                return this;
            }

            public a a(r.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(r rVar) {
                copyOnWrite();
                ((b) this.instance).a(rVar);
                return this;
            }

            public a a(t.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(t tVar) {
                copyOnWrite();
                ((b) this.instance).a(tVar);
                return this;
            }

            public a a(v.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(v vVar) {
                copyOnWrite();
                ((b) this.instance).a(vVar);
                return this;
            }

            public a a(x.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(x xVar) {
                copyOnWrite();
                ((b) this.instance).a(xVar);
                return this;
            }

            public a a(z.a aVar) {
                copyOnWrite();
                ((b) this.instance).a(aVar);
                return this;
            }

            public a a(z zVar) {
                copyOnWrite();
                ((b) this.instance).a(zVar);
                return this;
            }

            public a a(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((b) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String a() {
                return ((b) this.instance).a();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> a1() {
                return Collections.unmodifiableList(((b) this.instance).a1());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> a3() {
                return Collections.unmodifiableList(((b) this.instance).a3());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> a4() {
                return Collections.unmodifiableList(((b) this.instance).a4());
            }

            public a a6() {
                copyOnWrite();
                ((b) this.instance).b6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString b() {
                return ((b) this.instance).b();
            }

            public a b(int i, b0.a aVar) {
                copyOnWrite();
                ((b) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, b0 b0Var) {
                copyOnWrite();
                ((b) this.instance).b(i, b0Var);
                return this;
            }

            public a b(int i, String str) {
                copyOnWrite();
                ((b) this.instance).b(i, str);
                return this;
            }

            public a b(long j) {
                copyOnWrite();
                ((b) this.instance).b(j);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).b(byteString);
                return this;
            }

            public a b(d0 d0Var) {
                copyOnWrite();
                ((b) this.instance).b(d0Var);
                return this;
            }

            public a b(f0 f0Var) {
                copyOnWrite();
                ((b) this.instance).b(f0Var);
                return this;
            }

            public a b(f fVar) {
                copyOnWrite();
                ((b) this.instance).b(fVar);
                return this;
            }

            public a b(j jVar) {
                copyOnWrite();
                ((b) this.instance).b(jVar);
                return this;
            }

            public a b(l lVar) {
                copyOnWrite();
                ((b) this.instance).b(lVar);
                return this;
            }

            public a b(r.a aVar) {
                copyOnWrite();
                ((b) this.instance).b(aVar);
                return this;
            }

            public a b(r rVar) {
                copyOnWrite();
                ((b) this.instance).b(rVar);
                return this;
            }

            public a b(t tVar) {
                copyOnWrite();
                ((b) this.instance).b(tVar);
                return this;
            }

            public a b(v vVar) {
                copyOnWrite();
                ((b) this.instance).b(vVar);
                return this;
            }

            public a b(x xVar) {
                copyOnWrite();
                ((b) this.instance).b(xVar);
                return this;
            }

            public a b(z zVar) {
                copyOnWrite();
                ((b) this.instance).b(zVar);
                return this;
            }

            public a b(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).b(iterable);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((b) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int b0() {
                return ((b) this.instance).b0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString b0(int i) {
                return ((b) this.instance).b0(i);
            }

            public a b6() {
                copyOnWrite();
                ((b) this.instance).c6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString c(int i) {
                return ((b) this.instance).c(i);
            }

            public a c(int i, String str) {
                copyOnWrite();
                ((b) this.instance).c(i, str);
                return this;
            }

            public a c(long j) {
                copyOnWrite();
                ((b) this.instance).c(j);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).c(byteString);
                return this;
            }

            public a c(r rVar) {
                copyOnWrite();
                ((b) this.instance).c(rVar);
                return this;
            }

            public a c(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).c(iterable);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((b) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString c0(int i) {
                return ((b) this.instance).c0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int c3() {
                return ((b) this.instance).c3();
            }

            public a c6() {
                copyOnWrite();
                ((b) this.instance).d6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString d(int i) {
                return ((b) this.instance).d(i);
            }

            public a d(int i, String str) {
                copyOnWrite();
                ((b) this.instance).d(i, str);
                return this;
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).d(byteString);
                return this;
            }

            public a d(r rVar) {
                copyOnWrite();
                ((b) this.instance).d(rVar);
                return this;
            }

            public a d(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).d(iterable);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((b) this.instance).d(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String d0(int i) {
                return ((b) this.instance).d0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> d2() {
                return Collections.unmodifiableList(((b) this.instance).d2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public f d5() {
                return ((b) this.instance).d5();
            }

            public a d6() {
                copyOnWrite();
                ((b) this.instance).e6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString e(int i) {
                return ((b) this.instance).e(i);
            }

            public a e(int i, String str) {
                copyOnWrite();
                ((b) this.instance).e(i, str);
                return this;
            }

            public a e(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).e(byteString);
                return this;
            }

            public a e(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).e(iterable);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((b) this.instance).e(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int e0() {
                return ((b) this.instance).e0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String e0(int i) {
                return ((b) this.instance).e0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int e2() {
                return ((b) this.instance).e2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int e4() {
                return ((b) this.instance).e4();
            }

            public a e6() {
                copyOnWrite();
                ((b) this.instance).f6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public long f() {
                return ((b) this.instance).f();
            }

            public a f(int i, String str) {
                copyOnWrite();
                ((b) this.instance).f(i, str);
                return this;
            }

            public a f(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).f(byteString);
                return this;
            }

            public a f(Iterable<? extends b0> iterable) {
                copyOnWrite();
                ((b) this.instance).f(iterable);
                return this;
            }

            public a f(String str) {
                copyOnWrite();
                ((b) this.instance).f(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public b0 f(int i) {
                return ((b) this.instance).f(i);
            }

            public a f6() {
                copyOnWrite();
                ((b) this.instance).g6();
                return this;
            }

            public a g(int i, String str) {
                copyOnWrite();
                ((b) this.instance).g(i, str);
                return this;
            }

            public a g(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).g(byteString);
                return this;
            }

            public a g(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).g(iterable);
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((b) this.instance).g(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString g0(int i) {
                return ((b) this.instance).g0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public x g0() {
                return ((b) this.instance).g0();
            }

            public a g6() {
                copyOnWrite();
                ((b) this.instance).h6();
                return this;
            }

            public a h(int i, String str) {
                copyOnWrite();
                ((b) this.instance).h(i, str);
                return this;
            }

            public a h(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).h(byteString);
                return this;
            }

            public a h(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).h(iterable);
                return this;
            }

            public a h(String str) {
                copyOnWrite();
                ((b) this.instance).h(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String h0(int i) {
                return ((b) this.instance).h0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean h5() {
                return ((b) this.instance).h5();
            }

            public a h6() {
                copyOnWrite();
                ((b) this.instance).i6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString i(int i) {
                return ((b) this.instance).i(i);
            }

            public a i(int i, String str) {
                copyOnWrite();
                ((b) this.instance).i(i, str);
                return this;
            }

            public a i(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).i(byteString);
                return this;
            }

            public a i(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).i(iterable);
                return this;
            }

            public a i(String str) {
                copyOnWrite();
                ((b) this.instance).i(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> i4() {
                return Collections.unmodifiableList(((b) this.instance).i4());
            }

            public a i6() {
                copyOnWrite();
                ((b) this.instance).j6();
                return this;
            }

            public a j(int i, String str) {
                copyOnWrite();
                ((b) this.instance).j(i, str);
                return this;
            }

            public a j(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).j(byteString);
                return this;
            }

            public a j(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).j(iterable);
                return this;
            }

            public a j(String str) {
                copyOnWrite();
                ((b) this.instance).j(str);
                return this;
            }

            public a j6() {
                copyOnWrite();
                ((b) this.instance).k6();
                return this;
            }

            public a k(int i, String str) {
                copyOnWrite();
                ((b) this.instance).k(i, str);
                return this;
            }

            public a k(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).k(byteString);
                return this;
            }

            public a k(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).k(iterable);
                return this;
            }

            public a k(String str) {
                copyOnWrite();
                ((b) this.instance).k(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String k(int i) {
                return ((b) this.instance).k(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString k0(int i) {
                return ((b) this.instance).k0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> k1() {
                return Collections.unmodifiableList(((b) this.instance).k1());
            }

            public a k6() {
                copyOnWrite();
                ((b) this.instance).l6();
                return this;
            }

            public a l(int i, String str) {
                copyOnWrite();
                ((b) this.instance).l(i, str);
                return this;
            }

            public a l(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).l(byteString);
                return this;
            }

            public a l(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).l(iterable);
                return this;
            }

            public a l(String str) {
                copyOnWrite();
                ((b) this.instance).l(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String l(int i) {
                return ((b) this.instance).l(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String l0(int i) {
                return ((b) this.instance).l0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int l5() {
                return ((b) this.instance).l5();
            }

            public a l6() {
                copyOnWrite();
                ((b) this.instance).m6();
                return this;
            }

            public a m(int i, String str) {
                copyOnWrite();
                ((b) this.instance).m(i, str);
                return this;
            }

            public a m(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).m(byteString);
                return this;
            }

            public a m(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).m(iterable);
                return this;
            }

            public a m(String str) {
                copyOnWrite();
                ((b) this.instance).m(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public long m1() {
                return ((b) this.instance).m1();
            }

            public a m6() {
                copyOnWrite();
                ((b) this.instance).n6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int n() {
                return ((b) this.instance).n();
            }

            public a n(int i, String str) {
                copyOnWrite();
                ((b) this.instance).n(i, str);
                return this;
            }

            public a n(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).n(byteString);
                return this;
            }

            public a n(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).n(iterable);
                return this;
            }

            public a n(String str) {
                copyOnWrite();
                ((b) this.instance).n(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString n0(int i) {
                return ((b) this.instance).n0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public f0 n0() {
                return ((b) this.instance).n0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int n3() {
                return ((b) this.instance).n3();
            }

            public a n6() {
                copyOnWrite();
                ((b) this.instance).o6();
                return this;
            }

            public a o(int i, String str) {
                copyOnWrite();
                ((b) this.instance).o(i, str);
                return this;
            }

            public a o(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).o(byteString);
                return this;
            }

            public a o(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).o(iterable);
                return this;
            }

            public a o(String str) {
                copyOnWrite();
                ((b) this.instance).o(str);
                return this;
            }

            public a o0(int i) {
                copyOnWrite();
                ((b) this.instance).p0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean o5() {
                return ((b) this.instance).o5();
            }

            public a o6() {
                copyOnWrite();
                ((b) this.instance).p6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString p(int i) {
                return ((b) this.instance).p(i);
            }

            public a p(int i, String str) {
                copyOnWrite();
                ((b) this.instance).p(i, str);
                return this;
            }

            public a p(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).p(byteString);
                return this;
            }

            public a p(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).p(iterable);
                return this;
            }

            public a p(String str) {
                copyOnWrite();
                ((b) this.instance).p(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public r p() {
                return ((b) this.instance).p();
            }

            public a p0(int i) {
                copyOnWrite();
                ((b) this.instance).q0(i);
                return this;
            }

            public a p6() {
                copyOnWrite();
                ((b) this.instance).q6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString q(int i) {
                return ((b) this.instance).q(i);
            }

            public a q(int i, String str) {
                copyOnWrite();
                ((b) this.instance).q(i, str);
                return this;
            }

            public a q(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).q(byteString);
                return this;
            }

            public a q(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).q(iterable);
                return this;
            }

            public a q(String str) {
                copyOnWrite();
                ((b) this.instance).q(str);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((b) this.instance).r0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean q0() {
                return ((b) this.instance).q0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int q5() {
                return ((b) this.instance).q5();
            }

            public a q6() {
                copyOnWrite();
                ((b) this.instance).r6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString r(int i) {
                return ((b) this.instance).r(i);
            }

            public a r(int i, String str) {
                copyOnWrite();
                ((b) this.instance).r(i, str);
                return this;
            }

            public a r(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).r(byteString);
                return this;
            }

            public a r(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).r(iterable);
                return this;
            }

            public a r(String str) {
                copyOnWrite();
                ((b) this.instance).r(str);
                return this;
            }

            public a r0(int i) {
                copyOnWrite();
                ((b) this.instance).s0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> r2() {
                return Collections.unmodifiableList(((b) this.instance).r2());
            }

            public a r6() {
                copyOnWrite();
                ((b) this.instance).s6();
                return this;
            }

            public a s(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).t(byteString);
                return this;
            }

            public a s(Iterable<String> iterable) {
                copyOnWrite();
                ((b) this.instance).s(iterable);
                return this;
            }

            public a s(String str) {
                copyOnWrite();
                ((b) this.instance).s(str);
                return this;
            }

            public a s0(int i) {
                copyOnWrite();
                ((b) this.instance).t0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String s2() {
                return ((b) this.instance).s2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String s4() {
                return ((b) this.instance).s4();
            }

            public a s6() {
                copyOnWrite();
                ((b) this.instance).t6();
                return this;
            }

            public a t(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).u(byteString);
                return this;
            }

            public a t(String str) {
                copyOnWrite();
                ((b) this.instance).t(str);
                return this;
            }

            public a t0(int i) {
                copyOnWrite();
                ((b) this.instance).u0(i);
                return this;
            }

            public a t6() {
                copyOnWrite();
                ((b) this.instance).u6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public ByteString u(int i) {
                return ((b) this.instance).u(i);
            }

            public a u(ByteString byteString) {
                copyOnWrite();
                ((b) this.instance).v(byteString);
                return this;
            }

            public a u(String str) {
                copyOnWrite();
                ((b) this.instance).u(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean u4() {
                return ((b) this.instance).u4();
            }

            public a u6() {
                copyOnWrite();
                ((b) this.instance).v6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String v(int i) {
                return ((b) this.instance).v(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int v0() {
                return ((b) this.instance).v0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public boolean v1() {
                return ((b) this.instance).v1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<String> v3() {
                return Collections.unmodifiableList(((b) this.instance).v3());
            }

            public a v6() {
                copyOnWrite();
                ((b) this.instance).w6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public String w(int i) {
                return ((b) this.instance).w(i);
            }

            public a w6() {
                copyOnWrite();
                ((b) this.instance).x6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int x() {
                return ((b) this.instance).x();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int x5() {
                return ((b) this.instance).x5();
            }

            public a x6() {
                copyOnWrite();
                ((b) this.instance).y6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public List<b0> y5() {
                return Collections.unmodifiableList(((b) this.instance).y5());
            }

            public a y6() {
                copyOnWrite();
                ((b) this.instance).z6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public TapAdReq.BidType z2() {
                return ((b) this.instance).z2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
            public int z5() {
                return ((b) this.instance).z5();
            }

            public a z6() {
                copyOnWrite();
                ((b) this.instance).A6();
                return this;
            }
        }

        static {
            b bVar = new b();
            F0 = bVar;
            bVar.makeImmutable();
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A6() {
            this.I = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B6() {
            this.j = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C6() {
            this.q = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D6() {
            this.f = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E6() {
            this.e = GeneratedMessageLite.emptyProtobufList();
        }

        private void F6() {
            if (this.g.isModifiable()) {
                return;
            }
            this.g = GeneratedMessageLite.mutableCopy(this.g);
        }

        private void G6() {
            if (this.i.isModifiable()) {
                return;
            }
            this.i = GeneratedMessageLite.mutableCopy(this.i);
        }

        private void H6() {
            if (this.h.isModifiable()) {
                return;
            }
            this.h = GeneratedMessageLite.mutableCopy(this.h);
        }

        private void I6() {
            if (this.C.isModifiable()) {
                return;
            }
            this.C = GeneratedMessageLite.mutableCopy(this.C);
        }

        private void J6() {
            if (this.B.isModifiable()) {
                return;
            }
            this.B = GeneratedMessageLite.mutableCopy(this.B);
        }

        private void K6() {
            if (this.z.isModifiable()) {
                return;
            }
            this.z = GeneratedMessageLite.mutableCopy(this.z);
        }

        private void L6() {
            if (this.L.isModifiable()) {
                return;
            }
            this.L = GeneratedMessageLite.mutableCopy(this.L);
        }

        private void M6() {
            if (this.D.isModifiable()) {
                return;
            }
            this.D = GeneratedMessageLite.mutableCopy(this.D);
        }

        private void N6() {
            if (this.O.isModifiable()) {
                return;
            }
            this.O = GeneratedMessageLite.mutableCopy(this.O);
        }

        private void O6() {
            if (this.k.isModifiable()) {
                return;
            }
            this.k = GeneratedMessageLite.mutableCopy(this.k);
        }

        public static a P(b bVar) {
            return F0.toBuilder().mergeFrom(bVar);
        }

        private void P6() {
            if (this.l.isModifiable()) {
                return;
            }
            this.l = GeneratedMessageLite.mutableCopy(this.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.m = null;
        }

        private void Q6() {
            if (this.M.isModifiable()) {
                return;
            }
            this.M = GeneratedMessageLite.mutableCopy(this.M);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.c = 0L;
        }

        private void R6() {
            if (this.A.isModifiable()) {
                return;
            }
            this.A = GeneratedMessageLite.mutableCopy(this.A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.d = 0;
        }

        private void S6() {
            if (this.H.isModifiable()) {
                return;
            }
            this.H = GeneratedMessageLite.mutableCopy(this.H);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.p = null;
        }

        private void T6() {
            if (this.E.isModifiable()) {
                return;
            }
            this.E = GeneratedMessageLite.mutableCopy(this.E);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.o = Y6().s4();
        }

        private void U6() {
            if (this.I.isModifiable()) {
                return;
            }
            this.I = GeneratedMessageLite.mutableCopy(this.I);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.g = GeneratedMessageLite.emptyProtobufList();
        }

        private void V6() {
            if (this.j.isModifiable()) {
                return;
            }
            this.j = GeneratedMessageLite.mutableCopy(this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.y = null;
        }

        private void W6() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.i = GeneratedMessageLite.emptyProtobufList();
        }

        private void X6() {
            if (this.e.isModifiable()) {
                return;
            }
            this.e = GeneratedMessageLite.mutableCopy(this.e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.h = GeneratedMessageLite.emptyProtobufList();
        }

        public static b Y6() {
            return F0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z5() {
            this.C = GeneratedMessageLite.emptyProtobufList();
        }

        public static b a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(F0, byteString, extensionRegistryLite);
        }

        public static b a(CodedInputStream codedInputStream) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(F0, codedInputStream);
        }

        public static b a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(F0, codedInputStream, extensionRegistryLite);
        }

        public static b a(InputStream inputStream) throws IOException {
            return (b) GeneratedMessageLite.parseDelimitedFrom(F0, inputStream);
        }

        public static b a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseDelimitedFrom(F0, inputStream, extensionRegistryLite);
        }

        public static b a(byte[] bArr) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(F0, bArr);
        }

        public static b a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(F0, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, b0.a aVar) {
            K6();
            this.z.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, b0 b0Var) {
            b0Var.getClass();
            K6();
            this.z.add(i, b0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, String str) {
            str.getClass();
            F6();
            this.g.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            F6();
            this.g.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TapAdReq.BidType bidType) {
            bidType.getClass();
            this.d = bidType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b0.a aVar) {
            K6();
            this.z.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b0 b0Var) {
            b0Var.getClass();
            K6();
            this.z.add(b0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d0.a aVar) {
            this.K = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d0 d0Var) {
            d0 d0Var2 = this.K;
            if (d0Var2 != null && d0Var2 != d0.T5()) {
                d0Var = d0.d(this.K).mergeFrom(d0Var).buildPartial();
            }
            this.K = d0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f.a aVar) {
            this.m = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f0.b bVar) {
            this.J = bVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f0 f0Var) {
            f0 f0Var2 = this.J;
            if (f0Var2 != null && f0Var2 != f0.Y5()) {
                f0Var = f0.h(this.J).mergeFrom(f0Var).buildPartial();
            }
            this.J = f0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f fVar) {
            f fVar2 = this.m;
            if (fVar2 != null && fVar2 != f.k6()) {
                fVar = f.s(this.m).mergeFrom(fVar).buildPartial();
            }
            this.m = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j.a aVar) {
            this.y = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j jVar) {
            j jVar2 = this.y;
            if (jVar2 != null && jVar2 != j.R5()) {
                jVar = j.b(this.y).mergeFrom(jVar).buildPartial();
            }
            this.y = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(l.a aVar) {
            this.G = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(l lVar) {
            l lVar2 = this.G;
            if (lVar2 != null && lVar2 != l.j6()) {
                lVar = l.j(this.G).mergeFrom(lVar).buildPartial();
            }
            this.G = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(r.a aVar) {
            this.p = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(r rVar) {
            r rVar2 = this.p;
            if (rVar2 != null && rVar2 != r.Z5()) {
                rVar = r.j(this.p).mergeFrom(rVar).buildPartial();
            }
            this.p = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(t.a aVar) {
            this.P = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(t tVar) {
            t tVar2 = this.P;
            if (tVar2 != null && tVar2 != t.V5()) {
                tVar = t.f(this.P).mergeFrom(tVar).buildPartial();
            }
            this.P = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(v.a aVar) {
            this.x = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(v vVar) {
            v vVar2 = this.x;
            if (vVar2 != null && vVar2 != v.T5()) {
                vVar = v.d(this.x).mergeFrom(vVar).buildPartial();
            }
            this.x = vVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(x.a aVar) {
            this.r = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(x xVar) {
            x xVar2 = this.r;
            if (xVar2 != null && xVar2 != x.Y5()) {
                xVar = x.g(this.r).mergeFrom(xVar).buildPartial();
            }
            this.r = xVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(z.a aVar) {
            this.n = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(z zVar) {
            z zVar2 = this.n;
            if (zVar2 != null && zVar2 != z.U5()) {
                zVar = z.e(this.n).mergeFrom(zVar).buildPartial();
            }
            this.n = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<String> iterable) {
            F6();
            AbstractMessageLite.addAll(iterable, this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            F6();
            this.g.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a6() {
            this.B = GeneratedMessageLite.emptyProtobufList();
        }

        public static a a7() {
            return F0.toBuilder();
        }

        public static b b(InputStream inputStream) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(F0, inputStream);
        }

        public static b b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b) GeneratedMessageLite.parseFrom(F0, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b0.a aVar) {
            K6();
            this.z.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b0 b0Var) {
            b0Var.getClass();
            K6();
            this.z.set(i, b0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, String str) {
            str.getClass();
            G6();
            this.i.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.u = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            G6();
            this.i.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(d0 d0Var) {
            d0Var.getClass();
            this.K = d0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f0 f0Var) {
            f0Var.getClass();
            this.J = f0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f fVar) {
            fVar.getClass();
            this.m = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(j jVar) {
            jVar.getClass();
            this.y = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(l lVar) {
            lVar.getClass();
            this.G = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(r.a aVar) {
            this.q = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(r rVar) {
            r rVar2 = this.q;
            if (rVar2 != null && rVar2 != r.Z5()) {
                rVar = r.j(this.q).mergeFrom(rVar).buildPartial();
            }
            this.q = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(t tVar) {
            tVar.getClass();
            this.P = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(v vVar) {
            vVar.getClass();
            this.x = vVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(x xVar) {
            xVar.getClass();
            this.r = xVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(z zVar) {
            zVar.getClass();
            this.n = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<String> iterable) {
            G6();
            AbstractMessageLite.addAll(iterable, this.i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            G6();
            this.i.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b6() {
            this.N = 0;
        }

        public static Parser<b> b7() {
            return F0.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i, String str) {
            str.getClass();
            H6();
            this.h.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(long j) {
            this.s = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            H6();
            this.h.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(r rVar) {
            rVar.getClass();
            this.p = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Iterable<String> iterable) {
            H6();
            AbstractMessageLite.addAll(iterable, this.h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            H6();
            this.h.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c6() {
            this.u = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i, String str) {
            str.getClass();
            I6();
            this.C.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            I6();
            this.C.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(r rVar) {
            rVar.getClass();
            this.q = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Iterable<String> iterable) {
            I6();
            AbstractMessageLite.addAll(iterable, this.C);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            str.getClass();
            I6();
            this.C.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d6() {
            this.G = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i, String str) {
            str.getClass();
            J6();
            this.B.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            J6();
            this.B.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Iterable<String> iterable) {
            J6();
            AbstractMessageLite.addAll(iterable, this.B);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            J6();
            this.B.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e6() {
            this.F = Y6().a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i, String str) {
            str.getClass();
            L6();
            this.L.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            L6();
            this.L.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Iterable<? extends b0> iterable) {
            K6();
            AbstractMessageLite.addAll(iterable, this.z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(String str) {
            str.getClass();
            L6();
            this.L.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f6() {
            this.z = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i, String str) {
            str.getClass();
            M6();
            this.D.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            M6();
            this.D.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(Iterable<String> iterable) {
            L6();
            AbstractMessageLite.addAll(iterable, this.L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            str.getClass();
            M6();
            this.D.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g6() {
            this.L = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i, String str) {
            str.getClass();
            N6();
            this.O.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            N6();
            this.O.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(Iterable<String> iterable) {
            M6();
            AbstractMessageLite.addAll(iterable, this.D);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(String str) {
            str.getClass();
            N6();
            this.O.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h6() {
            this.v = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i, String str) {
            str.getClass();
            O6();
            this.k.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            O6();
            this.k.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(Iterable<String> iterable) {
            N6();
            AbstractMessageLite.addAll(iterable, this.O);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(String str) {
            str.getClass();
            O6();
            this.k.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i6() {
            this.D = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i, String str) {
            str.getClass();
            P6();
            this.l.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            P6();
            this.l.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Iterable<String> iterable) {
            O6();
            AbstractMessageLite.addAll(iterable, this.k);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(String str) {
            str.getClass();
            P6();
            this.l.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j6() {
            this.O = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i, String str) {
            str.getClass();
            Q6();
            this.M.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            Q6();
            this.M.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(Iterable<String> iterable) {
            P6();
            AbstractMessageLite.addAll(iterable, this.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str) {
            str.getClass();
            Q6();
            this.M.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k6() {
            this.k = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i, String str) {
            str.getClass();
            R6();
            this.A.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            R6();
            this.A.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(Iterable<String> iterable) {
            Q6();
            AbstractMessageLite.addAll(iterable, this.M);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str) {
            str.getClass();
            R6();
            this.A.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l6() {
            this.l = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(int i, String str) {
            str.getClass();
            S6();
            this.H.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            S6();
            this.H.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(Iterable<String> iterable) {
            R6();
            AbstractMessageLite.addAll(iterable, this.A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(String str) {
            str.getClass();
            S6();
            this.H.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m6() {
            this.w = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(int i, String str) {
            str.getClass();
            T6();
            this.E.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            T6();
            this.E.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Iterable<String> iterable) {
            S6();
            AbstractMessageLite.addAll(iterable, this.H);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String str) {
            str.getClass();
            T6();
            this.E.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n6() {
            this.M = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(int i, String str) {
            str.getClass();
            U6();
            this.I.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            U6();
            this.I.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(Iterable<String> iterable) {
            T6();
            AbstractMessageLite.addAll(iterable, this.E);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(String str) {
            str.getClass();
            U6();
            this.I.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o6() {
            this.P = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i, String str) {
            str.getClass();
            V6();
            this.j.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            V6();
            this.j.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(Iterable<String> iterable) {
            U6();
            AbstractMessageLite.addAll(iterable, this.I);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(String str) {
            str.getClass();
            V6();
            this.j.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            K6();
            this.z.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p6() {
            this.x = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i, String str) {
            str.getClass();
            W6();
            this.f.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            W6();
            this.f.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(Iterable<String> iterable) {
            V6();
            AbstractMessageLite.addAll(iterable, this.j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(String str) {
            str.getClass();
            W6();
            this.f.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.d = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q6() {
            this.r = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(int i, String str) {
            str.getClass();
            X6();
            this.e.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            X6();
            this.e.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(Iterable<String> iterable) {
            W6();
            AbstractMessageLite.addAll(iterable, this.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(String str) {
            str.getClass();
            X6();
            this.e.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i) {
            this.N = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r6() {
            this.t = 0;
        }

        public static b s(ByteString byteString) throws InvalidProtocolBufferException {
            return (b) GeneratedMessageLite.parseFrom(F0, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(Iterable<String> iterable) {
            X6();
            AbstractMessageLite.addAll(iterable, this.e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(String str) {
            str.getClass();
            this.o = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i) {
            this.v = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s6() {
            this.A = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.o = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(String str) {
            str.getClass();
            this.F = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i) {
            this.w = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t6() {
            this.H = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.F = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(String str) {
            str.getClass();
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i) {
            this.t = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u6() {
            this.E = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v6() {
            this.n = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w6() {
            this.s = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x6() {
            this.b = Y6().s2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y6() {
            this.K = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z6() {
            this.J = null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String A(int i) {
            return this.h.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString A0() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> A5() {
            return this.O;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int B0() {
            return this.f.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> B2() {
            return this.H;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean B3() {
            return this.r != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public t B4() {
            t tVar = this.P;
            return tVar == null ? t.V5() : tVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String C(int i) {
            return this.E.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean C() {
            return this.p != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public long C0() {
            return this.u;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public z D() {
            z zVar = this.n;
            return zVar == null ? z.U5() : zVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int D4() {
            return this.O.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int E() {
            return this.A.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String E(int i) {
            return this.C.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> E2() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public l E4() {
            l lVar = this.G;
            return lVar == null ? l.j6() : lVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String F(int i) {
            return this.B.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public v F4() {
            v vVar = this.x;
            return vVar == null ? v.T5() : vVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int F5() {
            return this.E.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int G() {
            return this.v;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String G(int i) {
            return this.f.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean G2() {
            return this.n != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int H3() {
            return this.w;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String I(int i) {
            return this.D.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public d0 J4() {
            d0 d0Var = this.K;
            return d0Var == null ? d0.T5() : d0Var;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString K(int i) {
            return ByteString.copyFromUtf8(this.L.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int K0() {
            return this.l.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString L(int i) {
            return ByteString.copyFromUtf8(this.I.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> L2() {
            return this.D;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int L4() {
            return this.L.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString M(int i) {
            return ByteString.copyFromUtf8(this.D.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String O(int i) {
            return this.k.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int P1() {
            return this.C.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int P4() {
            return this.i.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> R2() {
            return this.A;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public r R3() {
            r rVar = this.p;
            return rVar == null ? r.Z5() : rVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString R4() {
            return ByteString.copyFromUtf8(this.o);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String S(int i) {
            return this.i.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> S4() {
            return this.E;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString T(int i) {
            return ByteString.copyFromUtf8(this.M.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> T3() {
            return this.C;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean U0() {
            return this.m != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> U2() {
            return this.l;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int V() {
            return this.e.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String V(int i) {
            return this.M.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public j W2() {
            j jVar = this.y;
            return jVar == null ? j.R5() : jVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String X(int i) {
            return this.l.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean X() {
            return this.y != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString Z(int i) {
            return ByteString.copyFromUtf8(this.i.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> Z() {
            return this.B;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> Z0() {
            return this.L;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean Z1() {
            return this.J != null;
        }

        public List<? extends c0> Z6() {
            return this.z;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String a() {
            return this.F;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> a1() {
            return this.j;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> a3() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> a4() {
            return this.M;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString b() {
            return ByteString.copyFromUtf8(this.F);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int b0() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString b0(int i) {
            return ByteString.copyFromUtf8(this.f.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString c(int i) {
            return ByteString.copyFromUtf8(this.B.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString c0(int i) {
            return ByteString.copyFromUtf8(this.g.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int c3() {
            return this.M.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString d(int i) {
            return ByteString.copyFromUtf8(this.e.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String d0(int i) {
            return this.I.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> d2() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public f d5() {
            f fVar = this.m;
            return fVar == null ? f.k6() : fVar;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            String stringRequireUtf8;
            Internal.ProtobufList<String> protobufList;
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b();
                case 2:
                    return F0;
                case 3:
                    this.e.makeImmutable();
                    this.f.makeImmutable();
                    this.g.makeImmutable();
                    this.h.makeImmutable();
                    this.i.makeImmutable();
                    this.j.makeImmutable();
                    this.k.makeImmutable();
                    this.l.makeImmutable();
                    this.z.makeImmutable();
                    this.A.makeImmutable();
                    this.B.makeImmutable();
                    this.C.makeImmutable();
                    this.D.makeImmutable();
                    this.E.makeImmutable();
                    this.H.makeImmutable();
                    this.I.makeImmutable();
                    this.L.makeImmutable();
                    this.M.makeImmutable();
                    this.O.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    b bVar = (b) obj2;
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !bVar.b.isEmpty(), bVar.b);
                    long j = this.c;
                    boolean z2 = j != 0;
                    long j2 = bVar.c;
                    this.c = visitor.visitLong(z2, j, j2 != 0, j2);
                    int i = this.d;
                    boolean z3 = i != 0;
                    int i2 = bVar.d;
                    this.d = visitor.visitInt(z3, i, i2 != 0, i2);
                    this.e = visitor.visitList(this.e, bVar.e);
                    this.f = visitor.visitList(this.f, bVar.f);
                    this.g = visitor.visitList(this.g, bVar.g);
                    this.h = visitor.visitList(this.h, bVar.h);
                    this.i = visitor.visitList(this.i, bVar.i);
                    this.j = visitor.visitList(this.j, bVar.j);
                    this.k = visitor.visitList(this.k, bVar.k);
                    this.l = visitor.visitList(this.l, bVar.l);
                    this.m = (f) visitor.visitMessage(this.m, bVar.m);
                    this.n = (z) visitor.visitMessage(this.n, bVar.n);
                    this.o = visitor.visitString(!this.o.isEmpty(), this.o, !bVar.o.isEmpty(), bVar.o);
                    this.p = (r) visitor.visitMessage(this.p, bVar.p);
                    this.q = (r) visitor.visitMessage(this.q, bVar.q);
                    this.r = (x) visitor.visitMessage(this.r, bVar.r);
                    long j3 = this.s;
                    boolean z4 = j3 != 0;
                    long j4 = bVar.s;
                    this.s = visitor.visitLong(z4, j3, j4 != 0, j4);
                    int i3 = this.t;
                    boolean z5 = i3 != 0;
                    int i4 = bVar.t;
                    this.t = visitor.visitInt(z5, i3, i4 != 0, i4);
                    long j5 = this.u;
                    boolean z6 = j5 != 0;
                    long j6 = bVar.u;
                    this.u = visitor.visitLong(z6, j5, j6 != 0, j6);
                    int i5 = this.v;
                    boolean z7 = i5 != 0;
                    int i6 = bVar.v;
                    this.v = visitor.visitInt(z7, i5, i6 != 0, i6);
                    int i7 = this.w;
                    boolean z8 = i7 != 0;
                    int i8 = bVar.w;
                    this.w = visitor.visitInt(z8, i7, i8 != 0, i8);
                    this.x = (v) visitor.visitMessage(this.x, bVar.x);
                    this.y = (j) visitor.visitMessage(this.y, bVar.y);
                    this.z = visitor.visitList(this.z, bVar.z);
                    this.A = visitor.visitList(this.A, bVar.A);
                    this.B = visitor.visitList(this.B, bVar.B);
                    this.C = visitor.visitList(this.C, bVar.C);
                    this.D = visitor.visitList(this.D, bVar.D);
                    this.E = visitor.visitList(this.E, bVar.E);
                    this.F = visitor.visitString(!this.F.isEmpty(), this.F, !bVar.F.isEmpty(), bVar.F);
                    this.G = (l) visitor.visitMessage(this.G, bVar.G);
                    this.H = visitor.visitList(this.H, bVar.H);
                    this.I = visitor.visitList(this.I, bVar.I);
                    this.J = (f0) visitor.visitMessage(this.J, bVar.J);
                    this.K = (d0) visitor.visitMessage(this.K, bVar.K);
                    this.L = visitor.visitList(this.L, bVar.L);
                    this.M = visitor.visitList(this.M, bVar.M);
                    int i9 = this.N;
                    boolean z9 = i9 != 0;
                    int i10 = bVar.N;
                    this.N = visitor.visitInt(z9, i9, i10 != 0, i10);
                    this.O = visitor.visitList(this.O, bVar.O);
                    this.P = (t) visitor.visitMessage(this.P, bVar.P);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= bVar.a;
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
                                    z = true;
                                    break;
                                case 10:
                                    this.b = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 16:
                                    this.c = codedInputStream.readInt64();
                                    break;
                                case 24:
                                    this.d = codedInputStream.readEnum();
                                    break;
                                case 34:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.e.isModifiable()) {
                                        this.e = GeneratedMessageLite.mutableCopy(this.e);
                                    }
                                    protobufList = this.e;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 42:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    protobufList = this.f;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 50:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.g.isModifiable()) {
                                        this.g = GeneratedMessageLite.mutableCopy(this.g);
                                    }
                                    protobufList = this.g;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 58:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.h.isModifiable()) {
                                        this.h = GeneratedMessageLite.mutableCopy(this.h);
                                    }
                                    protobufList = this.h;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 66:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.i.isModifiable()) {
                                        this.i = GeneratedMessageLite.mutableCopy(this.i);
                                    }
                                    protobufList = this.i;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 74:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.j.isModifiable()) {
                                        this.j = GeneratedMessageLite.mutableCopy(this.j);
                                    }
                                    protobufList = this.j;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 82:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.k.isModifiable()) {
                                        this.k = GeneratedMessageLite.mutableCopy(this.k);
                                    }
                                    protobufList = this.k;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 90:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.l.isModifiable()) {
                                        this.l = GeneratedMessageLite.mutableCopy(this.l);
                                    }
                                    protobufList = this.l;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 98:
                                    f fVar = this.m;
                                    f.a builder = fVar != null ? fVar.toBuilder() : null;
                                    f fVar2 = (f) codedInputStream.readMessage(f.m6(), extensionRegistryLite);
                                    this.m = fVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(fVar2);
                                        this.m = builder.buildPartial();
                                    }
                                    break;
                                case 106:
                                    z zVar = this.n;
                                    z.a builder2 = zVar != null ? zVar.toBuilder() : null;
                                    z zVar2 = (z) codedInputStream.readMessage(z.W5(), extensionRegistryLite);
                                    this.n = zVar2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(zVar2);
                                        this.n = builder2.buildPartial();
                                    }
                                    break;
                                case 114:
                                    this.o = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 122:
                                    r rVar = this.p;
                                    r.a builder3 = rVar != null ? rVar.toBuilder() : null;
                                    r rVar2 = (r) codedInputStream.readMessage(r.b6(), extensionRegistryLite);
                                    this.p = rVar2;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(rVar2);
                                        this.p = builder3.buildPartial();
                                    }
                                    break;
                                case 130:
                                    r rVar3 = this.q;
                                    r.a builder4 = rVar3 != null ? rVar3.toBuilder() : null;
                                    r rVar4 = (r) codedInputStream.readMessage(r.b6(), extensionRegistryLite);
                                    this.q = rVar4;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(rVar4);
                                        this.q = builder4.buildPartial();
                                    }
                                    break;
                                case 138:
                                    x xVar = this.r;
                                    x.a builder5 = xVar != null ? xVar.toBuilder() : null;
                                    x xVar2 = (x) codedInputStream.readMessage(x.c6(), extensionRegistryLite);
                                    this.r = xVar2;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(xVar2);
                                        this.r = builder5.buildPartial();
                                    }
                                    break;
                                case 144:
                                    this.s = codedInputStream.readInt64();
                                    break;
                                case 152:
                                    this.t = codedInputStream.readInt32();
                                    break;
                                case 160:
                                    this.u = codedInputStream.readInt64();
                                    break;
                                case 168:
                                    this.v = codedInputStream.readInt32();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD /* 176 */:
                                    this.w = codedInputStream.readInt32();
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                                    v vVar = this.x;
                                    v.a builder6 = vVar != null ? vVar.toBuilder() : null;
                                    v vVar2 = (v) codedInputStream.readMessage(v.V5(), extensionRegistryLite);
                                    this.x = vVar2;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(vVar2);
                                        this.x = builder6.buildPartial();
                                    }
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                                    j jVar = this.y;
                                    j.a builder7 = jVar != null ? jVar.toBuilder() : null;
                                    j jVar2 = (j) codedInputStream.readMessage(j.T5(), extensionRegistryLite);
                                    this.y = jVar2;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(jVar2);
                                        this.y = builder7.buildPartial();
                                    }
                                    break;
                                case 202:
                                    if (!this.z.isModifiable()) {
                                        this.z = GeneratedMessageLite.mutableCopy(this.z);
                                    }
                                    this.z.add((b0) codedInputStream.readMessage(b0.V5(), extensionRegistryLite));
                                    break;
                                case 210:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.A.isModifiable()) {
                                        this.A = GeneratedMessageLite.mutableCopy(this.A);
                                    }
                                    protobufList = this.A;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 218:
                                    this.F = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 226:
                                    l lVar = this.G;
                                    l.a builder8 = lVar != null ? lVar.toBuilder() : null;
                                    l lVar2 = (l) codedInputStream.readMessage(l.t6(), extensionRegistryLite);
                                    this.G = lVar2;
                                    if (builder8 != null) {
                                        builder8.mergeFrom(lVar2);
                                        this.G = builder8.buildPartial();
                                    }
                                    break;
                                case 234:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.B.isModifiable()) {
                                        this.B = GeneratedMessageLite.mutableCopy(this.B);
                                    }
                                    protobufList = this.B;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.C.isModifiable()) {
                                        this.C = GeneratedMessageLite.mutableCopy(this.C);
                                    }
                                    protobufList = this.C;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 250:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.D.isModifiable()) {
                                        this.D = GeneratedMessageLite.mutableCopy(this.D);
                                    }
                                    protobufList = this.D;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.E.isModifiable()) {
                                        this.E = GeneratedMessageLite.mutableCopy(this.E);
                                    }
                                    protobufList = this.E;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME /* 266 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.H.isModifiable()) {
                                        this.H = GeneratedMessageLite.mutableCopy(this.H);
                                    }
                                    protobufList = this.H;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME /* 274 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.I.isModifiable()) {
                                        this.I = GeneratedMessageLite.mutableCopy(this.I);
                                    }
                                    protobufList = this.I;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS /* 282 */:
                                    f0 f0Var = this.J;
                                    f0.b builder9 = f0Var != null ? f0Var.toBuilder() : null;
                                    f0 f0Var2 = (f0) codedInputStream.readMessage(f0.a6(), extensionRegistryLite);
                                    this.J = f0Var2;
                                    if (builder9 != null) {
                                        builder9.mergeFrom(f0Var2);
                                        this.J = builder9.buildPartial();
                                    }
                                    break;
                                case 290:
                                    d0 d0Var = this.K;
                                    d0.a builder10 = d0Var != null ? d0Var.toBuilder() : null;
                                    d0 d0Var2 = (d0) codedInputStream.readMessage(d0.V5(), extensionRegistryLite);
                                    this.K = d0Var2;
                                    if (builder10 != null) {
                                        builder10.mergeFrom(d0Var2);
                                        this.K = builder10.buildPartial();
                                    }
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX /* 298 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.L.isModifiable()) {
                                        this.L = GeneratedMessageLite.mutableCopy(this.L);
                                    }
                                    protobufList = this.L;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY /* 306 */:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.M.isModifiable()) {
                                        this.M = GeneratedMessageLite.mutableCopy(this.M);
                                    }
                                    protobufList = this.M;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case 312:
                                    this.N = codedInputStream.readInt32();
                                    break;
                                case 322:
                                    stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.O.isModifiable()) {
                                        this.O = GeneratedMessageLite.mutableCopy(this.O);
                                    }
                                    protobufList = this.O;
                                    protobufList.add(stringRequireUtf8);
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST /* 330 */:
                                    t tVar = this.P;
                                    t.a builder11 = tVar != null ? tVar.toBuilder() : null;
                                    t tVar2 = (t) codedInputStream.readMessage(t.X5(), extensionRegistryLite);
                                    this.P = tVar2;
                                    if (builder11 != null) {
                                        builder11.mergeFrom(tVar2);
                                        this.P = builder11.buildPartial();
                                    }
                                    break;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        z = true;
                                    }
                                    break;
                            }
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
                    if (G0 == null) {
                        synchronized (b.class) {
                            if (G0 == null) {
                                G0 = new GeneratedMessageLite.DefaultInstanceBasedParser(F0);
                            }
                            break;
                        }
                    }
                    return G0;
                default:
                    throw new UnsupportedOperationException();
            }
            return F0;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString e(int i) {
            return ByteString.copyFromUtf8(this.A.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int e0() {
            return this.j.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String e0(int i) {
            return this.L.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int e2() {
            return this.I.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int e4() {
            return this.H.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public long f() {
            return this.s;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public b0 f(int i) {
            return this.z.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString g0(int i) {
            return ByteString.copyFromUtf8(this.E.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public x g0() {
            x xVar = this.r;
            return xVar == null ? x.Y5() : xVar;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = !this.b.isEmpty() ? CodedOutputStream.computeStringSize(1, s2()) + 0 : 0;
            long j = this.c;
            if (j != 0) {
                iComputeStringSize += CodedOutputStream.computeInt64Size(2, j);
            }
            if (this.d != TapAdReq.BidType.BidType_cpm.getNumber()) {
                iComputeStringSize += CodedOutputStream.computeEnumSize(3, this.d);
            }
            int iComputeStringSizeNoTag = 0;
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.e.get(i2));
            }
            int size = iComputeStringSize + iComputeStringSizeNoTag + (E2().size() * 1);
            int iComputeStringSizeNoTag2 = 0;
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                iComputeStringSizeNoTag2 += CodedOutputStream.computeStringSizeNoTag(this.f.get(i3));
            }
            int size2 = size + iComputeStringSizeNoTag2 + (a3().size() * 1);
            int iComputeStringSizeNoTag3 = 0;
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                iComputeStringSizeNoTag3 += CodedOutputStream.computeStringSizeNoTag(this.g.get(i4));
            }
            int size3 = size2 + iComputeStringSizeNoTag3 + (r2().size() * 1);
            int iComputeStringSizeNoTag4 = 0;
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                iComputeStringSizeNoTag4 += CodedOutputStream.computeStringSizeNoTag(this.h.get(i5));
            }
            int size4 = size3 + iComputeStringSizeNoTag4 + (d2().size() * 1);
            int iComputeStringSizeNoTag5 = 0;
            for (int i6 = 0; i6 < this.i.size(); i6++) {
                iComputeStringSizeNoTag5 += CodedOutputStream.computeStringSizeNoTag(this.i.get(i6));
            }
            int size5 = size4 + iComputeStringSizeNoTag5 + (v3().size() * 1);
            int iComputeStringSizeNoTag6 = 0;
            for (int i7 = 0; i7 < this.j.size(); i7++) {
                iComputeStringSizeNoTag6 += CodedOutputStream.computeStringSizeNoTag(this.j.get(i7));
            }
            int size6 = size5 + iComputeStringSizeNoTag6 + (a1().size() * 1);
            int iComputeStringSizeNoTag7 = 0;
            for (int i8 = 0; i8 < this.k.size(); i8++) {
                iComputeStringSizeNoTag7 += CodedOutputStream.computeStringSizeNoTag(this.k.get(i8));
            }
            int size7 = size6 + iComputeStringSizeNoTag7 + (k1().size() * 1);
            int iComputeStringSizeNoTag8 = 0;
            for (int i9 = 0; i9 < this.l.size(); i9++) {
                iComputeStringSizeNoTag8 += CodedOutputStream.computeStringSizeNoTag(this.l.get(i9));
            }
            int size8 = size7 + iComputeStringSizeNoTag8 + (U2().size() * 1);
            if (this.m != null) {
                size8 += CodedOutputStream.computeMessageSize(12, d5());
            }
            if (this.n != null) {
                size8 += CodedOutputStream.computeMessageSize(13, D());
            }
            if (!this.o.isEmpty()) {
                size8 += CodedOutputStream.computeStringSize(14, s4());
            }
            if (this.p != null) {
                size8 += CodedOutputStream.computeMessageSize(15, R3());
            }
            if (this.q != null) {
                size8 += CodedOutputStream.computeMessageSize(16, p());
            }
            if (this.r != null) {
                size8 += CodedOutputStream.computeMessageSize(17, g0());
            }
            long j2 = this.s;
            if (j2 != 0) {
                size8 += CodedOutputStream.computeInt64Size(18, j2);
            }
            int i10 = this.t;
            if (i10 != 0) {
                size8 += CodedOutputStream.computeInt32Size(19, i10);
            }
            long j3 = this.u;
            if (j3 != 0) {
                size8 += CodedOutputStream.computeInt64Size(20, j3);
            }
            int i11 = this.v;
            if (i11 != 0) {
                size8 += CodedOutputStream.computeInt32Size(21, i11);
            }
            int i12 = this.w;
            if (i12 != 0) {
                size8 += CodedOutputStream.computeInt32Size(22, i12);
            }
            if (this.x != null) {
                size8 += CodedOutputStream.computeMessageSize(23, F4());
            }
            if (this.y != null) {
                size8 += CodedOutputStream.computeMessageSize(24, W2());
            }
            for (int i13 = 0; i13 < this.z.size(); i13++) {
                size8 += CodedOutputStream.computeMessageSize(25, this.z.get(i13));
            }
            int iComputeStringSizeNoTag9 = 0;
            for (int i14 = 0; i14 < this.A.size(); i14++) {
                iComputeStringSizeNoTag9 += CodedOutputStream.computeStringSizeNoTag(this.A.get(i14));
            }
            int size9 = size8 + iComputeStringSizeNoTag9 + (R2().size() * 2);
            if (!this.F.isEmpty()) {
                size9 += CodedOutputStream.computeStringSize(27, a());
            }
            if (this.G != null) {
                size9 += CodedOutputStream.computeMessageSize(28, E4());
            }
            int iComputeStringSizeNoTag10 = 0;
            for (int i15 = 0; i15 < this.B.size(); i15++) {
                iComputeStringSizeNoTag10 += CodedOutputStream.computeStringSizeNoTag(this.B.get(i15));
            }
            int size10 = size9 + iComputeStringSizeNoTag10 + (Z().size() * 2);
            int iComputeStringSizeNoTag11 = 0;
            for (int i16 = 0; i16 < this.C.size(); i16++) {
                iComputeStringSizeNoTag11 += CodedOutputStream.computeStringSizeNoTag(this.C.get(i16));
            }
            int size11 = size10 + iComputeStringSizeNoTag11 + (T3().size() * 2);
            int iComputeStringSizeNoTag12 = 0;
            for (int i17 = 0; i17 < this.D.size(); i17++) {
                iComputeStringSizeNoTag12 += CodedOutputStream.computeStringSizeNoTag(this.D.get(i17));
            }
            int size12 = size11 + iComputeStringSizeNoTag12 + (L2().size() * 2);
            int iComputeStringSizeNoTag13 = 0;
            for (int i18 = 0; i18 < this.E.size(); i18++) {
                iComputeStringSizeNoTag13 += CodedOutputStream.computeStringSizeNoTag(this.E.get(i18));
            }
            int size13 = size12 + iComputeStringSizeNoTag13 + (S4().size() * 2);
            int iComputeStringSizeNoTag14 = 0;
            for (int i19 = 0; i19 < this.H.size(); i19++) {
                iComputeStringSizeNoTag14 += CodedOutputStream.computeStringSizeNoTag(this.H.get(i19));
            }
            int size14 = size13 + iComputeStringSizeNoTag14 + (B2().size() * 2);
            int iComputeStringSizeNoTag15 = 0;
            for (int i20 = 0; i20 < this.I.size(); i20++) {
                iComputeStringSizeNoTag15 += CodedOutputStream.computeStringSizeNoTag(this.I.get(i20));
            }
            int size15 = size14 + iComputeStringSizeNoTag15 + (i4().size() * 2);
            if (this.J != null) {
                size15 += CodedOutputStream.computeMessageSize(35, n0());
            }
            if (this.K != null) {
                size15 += CodedOutputStream.computeMessageSize(36, J4());
            }
            int iComputeStringSizeNoTag16 = 0;
            for (int i21 = 0; i21 < this.L.size(); i21++) {
                iComputeStringSizeNoTag16 += CodedOutputStream.computeStringSizeNoTag(this.L.get(i21));
            }
            int size16 = size15 + iComputeStringSizeNoTag16 + (Z0().size() * 2);
            int iComputeStringSizeNoTag17 = 0;
            for (int i22 = 0; i22 < this.M.size(); i22++) {
                iComputeStringSizeNoTag17 += CodedOutputStream.computeStringSizeNoTag(this.M.get(i22));
            }
            int size17 = size16 + iComputeStringSizeNoTag17 + (a4().size() * 2);
            int i23 = this.N;
            if (i23 != 0) {
                size17 += CodedOutputStream.computeInt32Size(39, i23);
            }
            int iComputeStringSizeNoTag18 = 0;
            for (int i24 = 0; i24 < this.O.size(); i24++) {
                iComputeStringSizeNoTag18 += CodedOutputStream.computeStringSizeNoTag(this.O.get(i24));
            }
            int size18 = size17 + iComputeStringSizeNoTag18 + (A5().size() * 2);
            if (this.P != null) {
                size18 += CodedOutputStream.computeMessageSize(41, B4());
            }
            this.memoizedSerializedSize = size18;
            return size18;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String h0(int i) {
            return this.e.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean h5() {
            return this.G != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString i(int i) {
            return ByteString.copyFromUtf8(this.j.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> i4() {
            return this.I;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String k(int i) {
            return this.O.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString k0(int i) {
            return ByteString.copyFromUtf8(this.O.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> k1() {
            return this.k;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String l(int i) {
            return this.A.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String l0(int i) {
            return this.g.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int l5() {
            return this.D.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public long m1() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int n() {
            return this.h.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString n0(int i) {
            return ByteString.copyFromUtf8(this.k.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public f0 n0() {
            f0 f0Var = this.J;
            return f0Var == null ? f0.Y5() : f0Var;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int n3() {
            return this.k.size();
        }

        public c0 o0(int i) {
            return this.z.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean o5() {
            return this.P != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString p(int i) {
            return ByteString.copyFromUtf8(this.H.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public r p() {
            r rVar = this.q;
            return rVar == null ? r.Z5() : rVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString q(int i) {
            return ByteString.copyFromUtf8(this.C.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean q0() {
            return this.K != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int q5() {
            return this.g.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString r(int i) {
            return ByteString.copyFromUtf8(this.h.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> r2() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String s2() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String s4() {
            return this.o;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public ByteString u(int i) {
            return ByteString.copyFromUtf8(this.l.get(i));
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean u4() {
            return this.x != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String v(int i) {
            return this.H.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int v0() {
            return this.N;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public boolean v1() {
            return this.q != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<String> v3() {
            return this.i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public String w(int i) {
            return this.j.get(i);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(1, s2());
            }
            long j = this.c;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            if (this.d != TapAdReq.BidType.BidType_cpm.getNumber()) {
                codedOutputStream.writeEnum(3, this.d);
            }
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.writeString(4, this.e.get(i));
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                codedOutputStream.writeString(5, this.f.get(i2));
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                codedOutputStream.writeString(6, this.g.get(i3));
            }
            for (int i4 = 0; i4 < this.h.size(); i4++) {
                codedOutputStream.writeString(7, this.h.get(i4));
            }
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                codedOutputStream.writeString(8, this.i.get(i5));
            }
            for (int i6 = 0; i6 < this.j.size(); i6++) {
                codedOutputStream.writeString(9, this.j.get(i6));
            }
            for (int i7 = 0; i7 < this.k.size(); i7++) {
                codedOutputStream.writeString(10, this.k.get(i7));
            }
            for (int i8 = 0; i8 < this.l.size(); i8++) {
                codedOutputStream.writeString(11, this.l.get(i8));
            }
            if (this.m != null) {
                codedOutputStream.writeMessage(12, d5());
            }
            if (this.n != null) {
                codedOutputStream.writeMessage(13, D());
            }
            if (!this.o.isEmpty()) {
                codedOutputStream.writeString(14, s4());
            }
            if (this.p != null) {
                codedOutputStream.writeMessage(15, R3());
            }
            if (this.q != null) {
                codedOutputStream.writeMessage(16, p());
            }
            if (this.r != null) {
                codedOutputStream.writeMessage(17, g0());
            }
            long j2 = this.s;
            if (j2 != 0) {
                codedOutputStream.writeInt64(18, j2);
            }
            int i9 = this.t;
            if (i9 != 0) {
                codedOutputStream.writeInt32(19, i9);
            }
            long j3 = this.u;
            if (j3 != 0) {
                codedOutputStream.writeInt64(20, j3);
            }
            int i10 = this.v;
            if (i10 != 0) {
                codedOutputStream.writeInt32(21, i10);
            }
            int i11 = this.w;
            if (i11 != 0) {
                codedOutputStream.writeInt32(22, i11);
            }
            if (this.x != null) {
                codedOutputStream.writeMessage(23, F4());
            }
            if (this.y != null) {
                codedOutputStream.writeMessage(24, W2());
            }
            for (int i12 = 0; i12 < this.z.size(); i12++) {
                codedOutputStream.writeMessage(25, this.z.get(i12));
            }
            for (int i13 = 0; i13 < this.A.size(); i13++) {
                codedOutputStream.writeString(26, this.A.get(i13));
            }
            if (!this.F.isEmpty()) {
                codedOutputStream.writeString(27, a());
            }
            if (this.G != null) {
                codedOutputStream.writeMessage(28, E4());
            }
            for (int i14 = 0; i14 < this.B.size(); i14++) {
                codedOutputStream.writeString(29, this.B.get(i14));
            }
            for (int i15 = 0; i15 < this.C.size(); i15++) {
                codedOutputStream.writeString(30, this.C.get(i15));
            }
            for (int i16 = 0; i16 < this.D.size(); i16++) {
                codedOutputStream.writeString(31, this.D.get(i16));
            }
            for (int i17 = 0; i17 < this.E.size(); i17++) {
                codedOutputStream.writeString(32, this.E.get(i17));
            }
            for (int i18 = 0; i18 < this.H.size(); i18++) {
                codedOutputStream.writeString(33, this.H.get(i18));
            }
            for (int i19 = 0; i19 < this.I.size(); i19++) {
                codedOutputStream.writeString(34, this.I.get(i19));
            }
            if (this.J != null) {
                codedOutputStream.writeMessage(35, n0());
            }
            if (this.K != null) {
                codedOutputStream.writeMessage(36, J4());
            }
            for (int i20 = 0; i20 < this.L.size(); i20++) {
                codedOutputStream.writeString(37, this.L.get(i20));
            }
            for (int i21 = 0; i21 < this.M.size(); i21++) {
                codedOutputStream.writeString(38, this.M.get(i21));
            }
            int i22 = this.N;
            if (i22 != 0) {
                codedOutputStream.writeInt32(39, i22);
            }
            for (int i23 = 0; i23 < this.O.size(); i23++) {
                codedOutputStream.writeString(40, this.O.get(i23));
            }
            if (this.P != null) {
                codedOutputStream.writeMessage(41, B4());
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int x() {
            return this.t;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int x5() {
            return this.z.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public List<b0> y5() {
            return this.z;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public TapAdReq.BidType z2() {
            TapAdReq.BidType bidTypeForNumber = TapAdReq.BidType.forNumber(this.d);
            return bidTypeForNumber == null ? TapAdReq.BidType.UNRECOGNIZED : bidTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c
        public int z5() {
            return this.B.size();
        }
    }

    public static final class b0 extends GeneratedMessageLite<b0, a> implements c0 {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final b0 g;
        private static volatile Parser<b0> h;
        private long a;
        private String b = "";
        private int c;

        public static final class a extends GeneratedMessageLite.Builder<b0, a> implements c0 {
            private a() {
                super(b0.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a P5() {
                copyOnWrite();
                ((b0) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((b0) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((b0) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
            public ByteString X3() {
                return ((b0) this.instance).X3();
            }

            public a a(long j) {
                copyOnWrite();
                ((b0) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((b0) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((b0) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
            public int j0() {
                return ((b0) this.instance).j0();
            }

            public a o0(int i) {
                copyOnWrite();
                ((b0) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
            public String u0() {
                return ((b0) this.instance).u0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
            public long w() {
                return ((b0) this.instance).w();
            }
        }

        static {
            b0 b0Var = new b0();
            g = b0Var;
            b0Var.makeImmutable();
        }

        private b0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.a = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.b = T5().u0();
        }

        public static b0 T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<b0> V5() {
            return g.getParserForType();
        }

        public static b0 a(ByteString byteString) throws InvalidProtocolBufferException {
            return (b0) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static b0 a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b0) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static b0 a(CodedInputStream codedInputStream) throws IOException {
            return (b0) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static b0 a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b0) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static b0 a(InputStream inputStream) throws IOException {
            return (b0) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static b0 a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b0) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static b0 a(byte[] bArr) throws InvalidProtocolBufferException {
            return (b0) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static b0 a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (b0) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
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

        public static b0 b(InputStream inputStream) throws IOException {
            return (b0) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static b0 b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (b0) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        public static a d(b0 b0Var) {
            return g.toBuilder().mergeFrom(b0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.c = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
        public ByteString X3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new b0();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    b0 b0Var = (b0) obj2;
                    long j = this.a;
                    boolean z2 = j != 0;
                    long j2 = b0Var.a;
                    this.a = visitor.visitLong(z2, j, j2 != 0, j2);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !b0Var.b.isEmpty(), b0Var.b);
                    int i = this.c;
                    boolean z3 = i != 0;
                    int i2 = b0Var.c;
                    this.c = visitor.visitInt(z3, i, i2 != 0, i2);
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
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readInt32();
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
                        synchronized (b0.class) {
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
            if (!this.b.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(2, u0());
            }
            int i2 = this.c;
            if (i2 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(3, i2);
            }
            this.memoizedSerializedSize = iComputeInt64Size;
            return iComputeInt64Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
        public int j0() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
        public String u0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.c0
        public long w() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.a;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, u0());
            }
            int i = this.c;
            if (i != 0) {
                codedOutputStream.writeInt32(3, i);
            }
        }
    }

    public interface c extends MessageLiteOrBuilder {
        String A(int i);

        ByteString A0();

        List<String> A5();

        int B0();

        List<String> B2();

        boolean B3();

        t B4();

        String C(int i);

        boolean C();

        long C0();

        z D();

        int D4();

        int E();

        String E(int i);

        List<String> E2();

        l E4();

        String F(int i);

        v F4();

        int F5();

        int G();

        String G(int i);

        boolean G2();

        int H3();

        String I(int i);

        d0 J4();

        ByteString K(int i);

        int K0();

        ByteString L(int i);

        List<String> L2();

        int L4();

        ByteString M(int i);

        String O(int i);

        int P1();

        int P4();

        List<String> R2();

        r R3();

        ByteString R4();

        String S(int i);

        List<String> S4();

        ByteString T(int i);

        List<String> T3();

        boolean U0();

        List<String> U2();

        int V();

        String V(int i);

        j W2();

        String X(int i);

        boolean X();

        ByteString Z(int i);

        List<String> Z();

        List<String> Z0();

        boolean Z1();

        String a();

        List<String> a1();

        List<String> a3();

        List<String> a4();

        ByteString b();

        int b0();

        ByteString b0(int i);

        ByteString c(int i);

        ByteString c0(int i);

        int c3();

        ByteString d(int i);

        String d0(int i);

        List<String> d2();

        f d5();

        ByteString e(int i);

        int e0();

        String e0(int i);

        int e2();

        int e4();

        long f();

        b0 f(int i);

        ByteString g0(int i);

        x g0();

        String h0(int i);

        boolean h5();

        ByteString i(int i);

        List<String> i4();

        String k(int i);

        ByteString k0(int i);

        List<String> k1();

        String l(int i);

        String l0(int i);

        int l5();

        long m1();

        int n();

        ByteString n0(int i);

        f0 n0();

        int n3();

        boolean o5();

        ByteString p(int i);

        r p();

        ByteString q(int i);

        boolean q0();

        int q5();

        ByteString r(int i);

        List<String> r2();

        String s2();

        String s4();

        ByteString u(int i);

        boolean u4();

        String v(int i);

        int v0();

        boolean v1();

        List<String> v3();

        String w(int i);

        int x();

        int x5();

        List<b0> y5();

        TapAdReq.BidType z2();

        int z5();
    }

    public interface c0 extends MessageLiteOrBuilder {
        ByteString X3();

        int j0();

        String u0();

        long w();
    }

    public static final class d extends GeneratedMessageLite<d, a> implements e {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final d g;
        private static volatile Parser<d> h;
        private String a = "";
        private long b;
        private int c;

        public static final class a extends GeneratedMessageLite.Builder<d, a> implements e {
            private a() {
                super(d.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
            public int G0() {
                return ((d) this.instance).G0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
            public String H0() {
                return ((d) this.instance).H0();
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

            public a a(long j) {
                copyOnWrite();
                ((d) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((d) this.instance).b(byteString);
                return this;
            }

            public a a(ApkDownloadType apkDownloadType) {
                copyOnWrite();
                ((d) this.instance).a(apkDownloadType);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((d) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
            public ByteString g2() {
                return ((d) this.instance).g2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
            public long j2() {
                return ((d) this.instance).j2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
            public ApkDownloadType m2() {
                return ((d) this.instance).m2();
            }

            public a o0(int i) {
                copyOnWrite();
                ((d) this.instance).o0(i);
                return this;
            }
        }

        static {
            d dVar = new d();
            g = dVar;
            dVar.makeImmutable();
        }

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = T5().H0();
        }

        public static d T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<d> V5() {
            return g.getParserForType();
        }

        public static d a(ByteString byteString) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static d a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static d a(CodedInputStream codedInputStream) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static d a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static d a(InputStream inputStream) throws IOException {
            return (d) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static d a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static d a(byte[] bArr) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static d a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ApkDownloadType apkDownloadType) {
            apkDownloadType.getClass();
            this.c = apkDownloadType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.a = str;
        }

        public static d b(InputStream inputStream) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static d b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        public static a d(d dVar) {
            return g.toBuilder().mergeFrom(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.c = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
        public int G0() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
        public String H0() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    d dVar = (d) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !dVar.a.isEmpty(), dVar.a);
                    long j = this.b;
                    boolean z2 = j != 0;
                    long j2 = dVar.b;
                    this.b = visitor.visitLong(z2, j, j2 != 0, j2);
                    int i = this.c;
                    boolean z3 = i != 0;
                    int i2 = dVar.c;
                    this.c = visitor.visitInt(z3, i, i2 != 0, i2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.a = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 16) {
                                    this.b = codedInputStream.readInt64();
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readEnum();
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
                        synchronized (d.class) {
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

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
        public ByteString g2() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, H0());
            long j = this.b;
            if (j != 0) {
                iComputeStringSize += CodedOutputStream.computeInt64Size(2, j);
            }
            if (this.c != ApkDownloadType.ApkDownloadType_default.getNumber()) {
                iComputeStringSize += CodedOutputStream.computeEnumSize(3, this.c);
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
        public long j2() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e
        public ApkDownloadType m2() {
            ApkDownloadType apkDownloadTypeForNumber = ApkDownloadType.forNumber(this.c);
            return apkDownloadTypeForNumber == null ? ApkDownloadType.UNRECOGNIZED : apkDownloadTypeForNumber;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, H0());
            }
            long j = this.b;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            if (this.c != ApkDownloadType.ApkDownloadType_default.getNumber()) {
                codedOutputStream.writeEnum(3, this.c);
            }
        }
    }

    public static final class d0 extends GeneratedMessageLite<d0, a> implements e0 {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final d0 g;
        private static volatile Parser<d0> h;
        private int a;
        private int b;
        private int c;

        public static final class a extends GeneratedMessageLite.Builder<d0, a> implements e0 {
            private a() {
                super(d0.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
            public int N5() {
                return ((d0) this.instance).N5();
            }

            public a P5() {
                copyOnWrite();
                ((d0) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((d0) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((d0) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
            public int d1() {
                return ((d0) this.instance).d1();
            }

            public a o0(int i) {
                copyOnWrite();
                ((d0) this.instance).o0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((d0) this.instance).p0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((d0) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
            public int t4() {
                return ((d0) this.instance).t4();
            }
        }

        static {
            d0 d0Var = new d0();
            g = d0Var;
            d0Var.makeImmutable();
        }

        private d0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.c = 0;
        }

        public static d0 T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<d0> V5() {
            return g.getParserForType();
        }

        public static d0 a(ByteString byteString) throws InvalidProtocolBufferException {
            return (d0) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static d0 a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d0) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static d0 a(CodedInputStream codedInputStream) throws IOException {
            return (d0) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static d0 a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d0) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static d0 a(InputStream inputStream) throws IOException {
            return (d0) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static d0 a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d0) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static d0 a(byte[] bArr) throws InvalidProtocolBufferException {
            return (d0) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static d0 a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (d0) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
        }

        public static d0 b(InputStream inputStream) throws IOException {
            return (d0) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static d0 b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (d0) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        public static a d(d0 d0Var) {
            return g.toBuilder().mergeFrom(d0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.c = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
        public int N5() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
        public int d1() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new d0();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    d0 d0Var = (d0) obj2;
                    int i = this.a;
                    boolean z2 = i != 0;
                    int i2 = d0Var.a;
                    this.a = visitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.b;
                    boolean z3 = i3 != 0;
                    int i4 = d0Var.b;
                    this.b = visitor.visitInt(z3, i3, i4 != 0, i4);
                    int i5 = this.c;
                    boolean z4 = i5 != 0;
                    int i6 = d0Var.c;
                    this.c = visitor.visitInt(z4, i5, i6 != 0, i6);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readInt32();
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
                        synchronized (d0.class) {
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
            int i2 = this.a;
            int iComputeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.b;
            if (i3 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.c;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
            }
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.e0
        public int t4() {
            return this.c;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.a;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.b;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.c;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
        }
    }

    public interface e extends MessageLiteOrBuilder {
        int G0();

        String H0();

        ByteString g2();

        long j2();

        ApkDownloadType m2();
    }

    public interface e0 extends MessageLiteOrBuilder {
        int N5();

        int d1();

        int t4();
    }

    public static final class f extends GeneratedMessageLite<f, a> implements g {
        public static final int A = 8;
        public static final int B = 9;
        public static final int C = 10;
        public static final int D = 11;
        public static final int E = 12;
        public static final int F = 13;
        public static final int G = 14;
        public static final int H = 15;
        public static final int I = 16;
        public static final int J = 17;
        public static final int K = 18;
        private static final f L;
        private static volatile Parser<f> M = null;
        public static final int t = 1;
        public static final int u = 2;
        public static final int v = 3;
        public static final int w = 4;
        public static final int x = 5;
        public static final int y = 6;
        public static final int z = 7;
        private int a;
        private long b;
        private float k;
        private p l;
        private long m;
        private long p;
        private int s;
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private String g = "";
        private String h = "";
        private String i = "";
        private String j = "";
        private Internal.ProtobufList<d> n = GeneratedMessageLite.emptyProtobufList();
        private String o = "";
        private String q = "";
        private String r = "";

        public static final class a extends GeneratedMessageLite.Builder<f, a> implements g {
            private a() {
                super(f.L);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public d D(int i) {
                return ((f) this.instance).D(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public float H() {
                return ((f) this.instance).H();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString H5() {
                return ((f) this.instance).H5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String O4() {
                return ((f) this.instance).O4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString P() {
                return ((f) this.instance).P();
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

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public boolean R0() {
                return ((f) this.instance).R0();
            }

            public a R5() {
                copyOnWrite();
                ((f) this.instance).S5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String S1() {
                return ((f) this.instance).S1();
            }

            public a S5() {
                copyOnWrite();
                ((f) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String T() {
                return ((f) this.instance).T();
            }

            public a T5() {
                copyOnWrite();
                ((f) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((f) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public long V0() {
                return ((f) this.instance).V0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public int V1() {
                return ((f) this.instance).V1();
            }

            public a V5() {
                copyOnWrite();
                ((f) this.instance).W5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString W3() {
                return ((f) this.instance).W3();
            }

            public a W5() {
                copyOnWrite();
                ((f) this.instance).X5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public int X2() {
                return ((f) this.instance).X2();
            }

            public a X5() {
                copyOnWrite();
                ((f) this.instance).Y5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString Y1() {
                return ((f) this.instance).Y1();
            }

            public a Y5() {
                copyOnWrite();
                ((f) this.instance).Z5();
                return this;
            }

            public a Z5() {
                copyOnWrite();
                ((f) this.instance).a6();
                return this;
            }

            public a a(float f) {
                copyOnWrite();
                ((f) this.instance).a(f);
                return this;
            }

            public a a(int i, d.a aVar) {
                copyOnWrite();
                ((f) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, d dVar) {
                copyOnWrite();
                ((f) this.instance).a(i, dVar);
                return this;
            }

            public a a(long j) {
                copyOnWrite();
                ((f) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).b(byteString);
                return this;
            }

            public a a(ApkVerifyType apkVerifyType) {
                copyOnWrite();
                ((f) this.instance).a(apkVerifyType);
                return this;
            }

            public a a(d.a aVar) {
                copyOnWrite();
                ((f) this.instance).a(aVar);
                return this;
            }

            public a a(d dVar) {
                copyOnWrite();
                ((f) this.instance).a(dVar);
                return this;
            }

            public a a(p.a aVar) {
                copyOnWrite();
                ((f) this.instance).a(aVar);
                return this;
            }

            public a a(p pVar) {
                copyOnWrite();
                ((f) this.instance).a(pVar);
                return this;
            }

            public a a(Iterable<? extends d> iterable) {
                copyOnWrite();
                ((f) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((f) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public List<d> a2() {
                return Collections.unmodifiableList(((f) this.instance).a2());
            }

            public a a6() {
                copyOnWrite();
                ((f) this.instance).b6();
                return this;
            }

            public a b(int i, d.a aVar) {
                copyOnWrite();
                ((f) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, d dVar) {
                copyOnWrite();
                ((f) this.instance).b(i, dVar);
                return this;
            }

            public a b(long j) {
                copyOnWrite();
                ((f) this.instance).b(j);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).c(byteString);
                return this;
            }

            public a b(p pVar) {
                copyOnWrite();
                ((f) this.instance).b(pVar);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((f) this.instance).b(str);
                return this;
            }

            public a b6() {
                copyOnWrite();
                ((f) this.instance).c6();
                return this;
            }

            public a c(long j) {
                copyOnWrite();
                ((f) this.instance).c(j);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((f) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String c() {
                return ((f) this.instance).c();
            }

            public a c6() {
                copyOnWrite();
                ((f) this.instance).d6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString d() {
                return ((f) this.instance).d();
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((f) this.instance).d(str);
                return this;
            }

            public a d6() {
                copyOnWrite();
                ((f) this.instance).e6();
                return this;
            }

            public a e(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).f(byteString);
                return this;
            }

            public a e(String str) {
                copyOnWrite();
                ((f) this.instance).e(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ApkVerifyType e3() {
                return ((f) this.instance).e3();
            }

            public a e6() {
                copyOnWrite();
                ((f) this.instance).f6();
                return this;
            }

            public a f(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).g(byteString);
                return this;
            }

            public a f(String str) {
                copyOnWrite();
                ((f) this.instance).f(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString f5() {
                return ((f) this.instance).f5();
            }

            public a f6() {
                copyOnWrite();
                ((f) this.instance).g6();
                return this;
            }

            public a g(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).h(byteString);
                return this;
            }

            public a g(String str) {
                copyOnWrite();
                ((f) this.instance).g(str);
                return this;
            }

            public a g6() {
                copyOnWrite();
                ((f) this.instance).h6();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public long getApkSize() {
                return ((f) this.instance).getApkSize();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String getAppName() {
                return ((f) this.instance).getAppName();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String getAppVersion() {
                return ((f) this.instance).getAppVersion();
            }

            public a h(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).i(byteString);
                return this;
            }

            public a h(String str) {
                copyOnWrite();
                ((f) this.instance).h(str);
                return this;
            }

            public a i(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).j(byteString);
                return this;
            }

            public a i(String str) {
                copyOnWrite();
                ((f) this.instance).i(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public p i3() {
                return ((f) this.instance).i3();
            }

            public a j(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).k(byteString);
                return this;
            }

            public a j(String str) {
                copyOnWrite();
                ((f) this.instance).j(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString k() {
                return ((f) this.instance).k();
            }

            public a k(ByteString byteString) {
                copyOnWrite();
                ((f) this.instance).l(byteString);
                return this;
            }

            public a k(String str) {
                copyOnWrite();
                ((f) this.instance).k(str);
                return this;
            }

            public a o0(int i) {
                copyOnWrite();
                ((f) this.instance).p0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((f) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String q() {
                return ((f) this.instance).q();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String r3() {
                return ((f) this.instance).r3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public long r4() {
                return ((f) this.instance).r4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String s() {
                return ((f) this.instance).s();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String t5() {
                return ((f) this.instance).t5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString u3() {
                return ((f) this.instance).u3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString w2() {
                return ((f) this.instance).w2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public String y3() {
                return ((f) this.instance).y3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString y4() {
                return ((f) this.instance).y4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
            public ByteString z3() {
                return ((f) this.instance).z3();
            }
        }

        static {
            f fVar = new f();
            L = fVar;
            fVar.makeImmutable();
        }

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.o = k6().s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.p = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.n = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.s = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.e = k6().r3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.r = k6().t5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.h = k6().y3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.l = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.b = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z5() {
            this.c = k6().getAppName();
        }

        public static f a(ByteString byteString) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(L, byteString);
        }

        public static f a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(L, byteString, extensionRegistryLite);
        }

        public static f a(CodedInputStream codedInputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(L, codedInputStream);
        }

        public static f a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(L, codedInputStream, extensionRegistryLite);
        }

        public static f a(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(L, inputStream);
        }

        public static f a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseDelimitedFrom(L, inputStream, extensionRegistryLite);
        }

        public static f a(byte[] bArr) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(L, bArr);
        }

        public static f a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f) GeneratedMessageLite.parseFrom(L, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f) {
            this.k = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, d.a aVar) {
            i6();
            this.n.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, d dVar) {
            dVar.getClass();
            i6();
            this.n.add(i, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.p = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ApkVerifyType apkVerifyType) {
            apkVerifyType.getClass();
            this.s = apkVerifyType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d.a aVar) {
            i6();
            this.n.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            dVar.getClass();
            i6();
            this.n.add(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p.a aVar) {
            this.l = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar) {
            p pVar2 = this.l;
            if (pVar2 != null && pVar2 != p.T5()) {
                pVar = p.d(this.l).mergeFrom(pVar).buildPartial();
            }
            this.l = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends d> iterable) {
            i6();
            AbstractMessageLite.addAll(iterable, this.n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.o = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a6() {
            this.j = k6().q();
        }

        public static f b(InputStream inputStream) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(L, inputStream);
        }

        public static f b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f) GeneratedMessageLite.parseFrom(L, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, d.a aVar) {
            i6();
            this.n.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, d dVar) {
            dVar.getClass();
            i6();
            this.n.set(i, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.o = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(p pVar) {
            pVar.getClass();
            this.l = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b6() {
            this.i = k6().T();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(long j) {
            this.m = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.r = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c6() {
            this.g = k6().S1();
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
            this.h = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d6() {
            this.f = k6().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.h = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(String str) {
            str.getClass();
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e6() {
            this.q = k6().O4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(String str) {
            str.getClass();
            this.j = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f6() {
            this.m = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.j = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            str.getClass();
            this.i = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g6() {
            this.d = k6().c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.i = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(String str) {
            str.getClass();
            this.g = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h6() {
            this.k = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.g = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(String str) {
            str.getClass();
            this.f = str;
        }

        private void i6() {
            if (this.n.isModifiable()) {
                return;
            }
            this.n = GeneratedMessageLite.mutableCopy(this.n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(String str) {
            str.getClass();
            this.q = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.q = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str) {
            str.getClass();
            this.d = str;
        }

        public static f k6() {
            return L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        public static a l6() {
            return L.toBuilder();
        }

        public static Parser<f> m6() {
            return L.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            i6();
            this.n.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.s = i;
        }

        public static a s(f fVar) {
            return L.toBuilder().mergeFrom(fVar);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public d D(int i) {
            return this.n.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public float H() {
            return this.k;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString H5() {
            return ByteString.copyFromUtf8(this.i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String O4() {
            return this.q;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString P() {
            return ByteString.copyFromUtf8(this.j);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public boolean R0() {
            return this.l != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String S1() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String T() {
            return this.i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public long V0() {
            return this.m;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public int V1() {
            return this.n.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString W3() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public int X2() {
            return this.s;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString Y1() {
            return ByteString.copyFromUtf8(this.q);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public List<d> a2() {
            return this.n;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String c() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString d() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z2 = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f();
                case 2:
                    return L;
                case 3:
                    this.n.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    f fVar = (f) obj2;
                    long j = this.b;
                    boolean z3 = j != 0;
                    long j2 = fVar.b;
                    this.b = visitor.visitLong(z3, j, j2 != 0, j2);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !fVar.c.isEmpty(), fVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !fVar.d.isEmpty(), fVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, !fVar.e.isEmpty(), fVar.e);
                    this.f = visitor.visitString(!this.f.isEmpty(), this.f, !fVar.f.isEmpty(), fVar.f);
                    this.g = visitor.visitString(!this.g.isEmpty(), this.g, !fVar.g.isEmpty(), fVar.g);
                    this.h = visitor.visitString(!this.h.isEmpty(), this.h, !fVar.h.isEmpty(), fVar.h);
                    this.i = visitor.visitString(!this.i.isEmpty(), this.i, !fVar.i.isEmpty(), fVar.i);
                    this.j = visitor.visitString(!this.j.isEmpty(), this.j, !fVar.j.isEmpty(), fVar.j);
                    float f = this.k;
                    boolean z4 = f != 0.0f;
                    float f2 = fVar.k;
                    this.k = visitor.visitFloat(z4, f, f2 != 0.0f, f2);
                    this.l = (p) visitor.visitMessage(this.l, fVar.l);
                    long j3 = this.m;
                    boolean z5 = j3 != 0;
                    long j4 = fVar.m;
                    this.m = visitor.visitLong(z5, j3, j4 != 0, j4);
                    this.n = visitor.visitList(this.n, fVar.n);
                    this.o = visitor.visitString(!this.o.isEmpty(), this.o, !fVar.o.isEmpty(), fVar.o);
                    long j5 = this.p;
                    boolean z6 = j5 != 0;
                    long j6 = fVar.p;
                    this.p = visitor.visitLong(z6, j5, j6 != 0, j6);
                    this.q = visitor.visitString(!this.q.isEmpty(), this.q, !fVar.q.isEmpty(), fVar.q);
                    this.r = visitor.visitString(!this.r.isEmpty(), this.r, !fVar.r.isEmpty(), fVar.r);
                    int i = this.s;
                    boolean z7 = i != 0;
                    int i2 = fVar.s;
                    this.s = visitor.visitInt(z7, i, i2 != 0, i2);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= fVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z2) {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 8:
                                    this.b = codedInputStream.readInt64();
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
                                    this.j = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 85:
                                    this.k = codedInputStream.readFloat();
                                    continue;
                                case 90:
                                    p pVar = this.l;
                                    p.a builder = pVar != null ? pVar.toBuilder() : null;
                                    p pVar2 = (p) codedInputStream.readMessage(p.V5(), extensionRegistryLite);
                                    this.l = pVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar2);
                                        this.l = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 96:
                                    this.m = codedInputStream.readInt64();
                                    continue;
                                case 106:
                                    if (!this.n.isModifiable()) {
                                        this.n = GeneratedMessageLite.mutableCopy(this.n);
                                    }
                                    this.n.add((d) codedInputStream.readMessage(d.V5(), extensionRegistryLite));
                                    continue;
                                case 114:
                                    this.o = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 120:
                                    this.p = codedInputStream.readInt64();
                                    continue;
                                case 130:
                                    this.q = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 138:
                                    this.r = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 144:
                                    this.s = codedInputStream.readEnum();
                                    continue;
                                default:
                                    if (!codedInputStream.skipField(tag)) {
                                        break;
                                    }
                                    break;
                            }
                            z2 = true;
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
                    if (M == null) {
                        synchronized (f.class) {
                            if (M == null) {
                                M = new GeneratedMessageLite.DefaultInstanceBasedParser(L);
                            }
                            break;
                        }
                    }
                    return M;
                default:
                    throw new UnsupportedOperationException();
            }
            return L;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ApkVerifyType e3() {
            ApkVerifyType apkVerifyTypeForNumber = ApkVerifyType.forNumber(this.s);
            return apkVerifyTypeForNumber == null ? ApkVerifyType.UNRECOGNIZED : apkVerifyTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString f5() {
            return ByteString.copyFromUtf8(this.r);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public long getApkSize() {
            return this.p;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String getAppName() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String getAppVersion() {
            return this.f;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            long j = this.b;
            int iComputeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(2, getAppName());
            }
            if (!this.d.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(3, c());
            }
            if (!this.e.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(4, r3());
            }
            if (!this.f.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(5, getAppVersion());
            }
            if (!this.g.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(6, S1());
            }
            if (!this.h.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(7, y3());
            }
            if (!this.i.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(8, T());
            }
            if (!this.j.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(9, q());
            }
            float f = this.k;
            if (f != 0.0f) {
                iComputeInt64Size += CodedOutputStream.computeFloatSize(10, f);
            }
            if (this.l != null) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(11, i3());
            }
            long j2 = this.m;
            if (j2 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(12, j2);
            }
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(13, this.n.get(i2));
            }
            if (!this.o.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(14, s());
            }
            long j3 = this.p;
            if (j3 != 0) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(15, j3);
            }
            if (!this.q.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(16, O4());
            }
            if (!this.r.isEmpty()) {
                iComputeInt64Size += CodedOutputStream.computeStringSize(17, t5());
            }
            if (this.s != ApkVerifyType.ApkVerifyType_default.getNumber()) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(18, this.s);
            }
            this.memoizedSerializedSize = iComputeInt64Size;
            return iComputeInt64Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public p i3() {
            p pVar = this.l;
            return pVar == null ? p.T5() : pVar;
        }

        public List<? extends e> j6() {
            return this.n;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString k() {
            return ByteString.copyFromUtf8(this.f);
        }

        public e o0(int i) {
            return this.n.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String q() {
            return this.j;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String r3() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public long r4() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String s() {
            return this.o;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String t5() {
            return this.r;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString u3() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString w2() {
            return ByteString.copyFromUtf8(this.h);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.b;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, getAppName());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, c());
            }
            if (!this.e.isEmpty()) {
                codedOutputStream.writeString(4, r3());
            }
            if (!this.f.isEmpty()) {
                codedOutputStream.writeString(5, getAppVersion());
            }
            if (!this.g.isEmpty()) {
                codedOutputStream.writeString(6, S1());
            }
            if (!this.h.isEmpty()) {
                codedOutputStream.writeString(7, y3());
            }
            if (!this.i.isEmpty()) {
                codedOutputStream.writeString(8, T());
            }
            if (!this.j.isEmpty()) {
                codedOutputStream.writeString(9, q());
            }
            float f = this.k;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(10, f);
            }
            if (this.l != null) {
                codedOutputStream.writeMessage(11, i3());
            }
            long j2 = this.m;
            if (j2 != 0) {
                codedOutputStream.writeInt64(12, j2);
            }
            for (int i = 0; i < this.n.size(); i++) {
                codedOutputStream.writeMessage(13, this.n.get(i));
            }
            if (!this.o.isEmpty()) {
                codedOutputStream.writeString(14, s());
            }
            long j3 = this.p;
            if (j3 != 0) {
                codedOutputStream.writeInt64(15, j3);
            }
            if (!this.q.isEmpty()) {
                codedOutputStream.writeString(16, O4());
            }
            if (!this.r.isEmpty()) {
                codedOutputStream.writeString(17, t5());
            }
            if (this.s != ApkVerifyType.ApkVerifyType_default.getNumber()) {
                codedOutputStream.writeEnum(18, this.s);
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public String y3() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString y4() {
            return ByteString.copyFromUtf8(this.o);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g
        public ByteString z3() {
            return ByteString.copyFromUtf8(this.g);
        }
    }

    public static final class f0 extends GeneratedMessageLite<f0, b> implements g0 {
        public static final int i = 1;
        public static final int j = 2;
        public static final int k = 3;
        public static final int l = 4;
        public static final int m = 5;
        public static final int n = 6;
        public static final int o = 7;
        private static final Internal.ListAdapter.Converter<Integer, ExposureFieldType> p = new a();
        private static final f0 q;
        private static volatile Parser<f0> r;
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private Internal.IntList h = GeneratedMessageLite.emptyIntList();

        static class a implements Internal.ListAdapter.Converter<Integer, ExposureFieldType> {
            a() {
            }

            @Override // com.tapadn.protobuf.Internal.ListAdapter.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ExposureFieldType convert(Integer num) {
                ExposureFieldType exposureFieldTypeForNumber = ExposureFieldType.forNumber(num.intValue());
                return exposureFieldTypeForNumber == null ? ExposureFieldType.UNRECOGNIZED : exposureFieldTypeForNumber;
            }
        }

        public static final class b extends GeneratedMessageLite.Builder<f0, b> implements g0 {
            private b() {
                super(f0.q);
            }

            /* synthetic */ b(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int E5() {
                return ((f0) this.instance).E5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int I0() {
                return ((f0) this.instance).I0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int J1() {
                return ((f0) this.instance).J1();
            }

            public b P5() {
                copyOnWrite();
                ((f0) this.instance).Q5();
                return this;
            }

            public b Q5() {
                copyOnWrite();
                ((f0) this.instance).R5();
                return this;
            }

            public b R5() {
                copyOnWrite();
                ((f0) this.instance).S5();
                return this;
            }

            public b S5() {
                copyOnWrite();
                ((f0) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int T2() {
                return ((f0) this.instance).T2();
            }

            public b T5() {
                copyOnWrite();
                ((f0) this.instance).U5();
                return this;
            }

            public b U5() {
                copyOnWrite();
                ((f0) this.instance).V5();
                return this;
            }

            public b V5() {
                copyOnWrite();
                ((f0) this.instance).W5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int W(int i) {
                return ((f0) this.instance).W(i);
            }

            public b a(int i, int i2) {
                copyOnWrite();
                ((f0) this.instance).a(i, i2);
                return this;
            }

            public b a(int i, ExposureFieldType exposureFieldType) {
                copyOnWrite();
                ((f0) this.instance).a(i, exposureFieldType);
                return this;
            }

            public b a(ExposureFieldType exposureFieldType) {
                copyOnWrite();
                ((f0) this.instance).a(exposureFieldType);
                return this;
            }

            public b a(Iterable<? extends ExposureFieldType> iterable) {
                copyOnWrite();
                ((f0) this.instance).a(iterable);
                return this;
            }

            public b b(Iterable<Integer> iterable) {
                copyOnWrite();
                ((f0) this.instance).b(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int g3() {
                return ((f0) this.instance).g3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public List<ExposureFieldType> k5() {
                return ((f0) this.instance).k5();
            }

            public b o0(int i) {
                ((f0) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int o3() {
                return ((f0) this.instance).o3();
            }

            public b p0(int i) {
                copyOnWrite();
                ((f0) this.instance).p0(i);
                return this;
            }

            public b q0(int i) {
                copyOnWrite();
                ((f0) this.instance).q0(i);
                return this;
            }

            public b r0(int i) {
                copyOnWrite();
                ((f0) this.instance).r0(i);
                return this;
            }

            public b s0(int i) {
                copyOnWrite();
                ((f0) this.instance).s0(i);
                return this;
            }

            public b t0(int i) {
                copyOnWrite();
                ((f0) this.instance).t0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public int t3() {
                return ((f0) this.instance).t3();
            }

            public b u0(int i) {
                copyOnWrite();
                ((f0) this.instance).u0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public List<Integer> y1() {
                return Collections.unmodifiableList(((f0) this.instance).y1());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
            public ExposureFieldType z(int i) {
                return ((f0) this.instance).z(i);
            }
        }

        static {
            f0 f0Var = new f0();
            q = f0Var;
            f0Var.makeImmutable();
        }

        private f0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.f = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.e = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.h = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.g = 0;
        }

        private void X5() {
            if (this.h.isModifiable()) {
                return;
            }
            this.h = GeneratedMessageLite.mutableCopy(this.h);
        }

        public static f0 Y5() {
            return q;
        }

        public static b Z5() {
            return q.toBuilder();
        }

        public static f0 a(ByteString byteString) throws InvalidProtocolBufferException {
            return (f0) GeneratedMessageLite.parseFrom(q, byteString);
        }

        public static f0 a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f0) GeneratedMessageLite.parseFrom(q, byteString, extensionRegistryLite);
        }

        public static f0 a(CodedInputStream codedInputStream) throws IOException {
            return (f0) GeneratedMessageLite.parseFrom(q, codedInputStream);
        }

        public static f0 a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f0) GeneratedMessageLite.parseFrom(q, codedInputStream, extensionRegistryLite);
        }

        public static f0 a(InputStream inputStream) throws IOException {
            return (f0) GeneratedMessageLite.parseDelimitedFrom(q, inputStream);
        }

        public static f0 a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f0) GeneratedMessageLite.parseDelimitedFrom(q, inputStream, extensionRegistryLite);
        }

        public static f0 a(byte[] bArr) throws InvalidProtocolBufferException {
            return (f0) GeneratedMessageLite.parseFrom(q, bArr);
        }

        public static f0 a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (f0) GeneratedMessageLite.parseFrom(q, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, int i3) {
            X5();
            this.h.setInt(i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, ExposureFieldType exposureFieldType) {
            exposureFieldType.getClass();
            X5();
            this.h.setInt(i2, exposureFieldType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ExposureFieldType exposureFieldType) {
            exposureFieldType.getClass();
            X5();
            this.h.addInt(exposureFieldType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends ExposureFieldType> iterable) {
            X5();
            Iterator<? extends ExposureFieldType> it = iterable.iterator();
            while (it.hasNext()) {
                this.h.addInt(it.next().getNumber());
            }
        }

        public static Parser<f0> a6() {
            return q.getParserForType();
        }

        public static f0 b(InputStream inputStream) throws IOException {
            return (f0) GeneratedMessageLite.parseFrom(q, inputStream);
        }

        public static f0 b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (f0) GeneratedMessageLite.parseFrom(q, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<Integer> iterable) {
            X5();
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                this.h.addInt(it.next().intValue());
            }
        }

        public static b h(f0 f0Var) {
            return q.toBuilder().mergeFrom(f0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            X5();
            this.h.addInt(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            this.f = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i2) {
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i2) {
            this.e = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i2) {
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i2) {
            this.g = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int E5() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int I0() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int J1() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int T2() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int W(int i2) {
            return this.h.getInt(i2);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new f0();
                case 2:
                    return q;
                case 3:
                    this.h.makeImmutable();
                    return null;
                case 4:
                    return new b(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    f0 f0Var = (f0) obj2;
                    int i2 = this.b;
                    boolean z2 = i2 != 0;
                    int i3 = f0Var.b;
                    this.b = visitor.visitInt(z2, i2, i3 != 0, i3);
                    int i4 = this.c;
                    boolean z3 = i4 != 0;
                    int i5 = f0Var.c;
                    this.c = visitor.visitInt(z3, i4, i5 != 0, i5);
                    int i6 = this.d;
                    boolean z4 = i6 != 0;
                    int i7 = f0Var.d;
                    this.d = visitor.visitInt(z4, i6, i7 != 0, i7);
                    int i8 = this.e;
                    boolean z5 = i8 != 0;
                    int i9 = f0Var.e;
                    this.e = visitor.visitInt(z5, i8, i9 != 0, i9);
                    int i10 = this.f;
                    boolean z6 = i10 != 0;
                    int i11 = f0Var.f;
                    this.f = visitor.visitInt(z6, i10, i11 != 0, i11);
                    int i12 = this.g;
                    boolean z7 = i12 != 0;
                    int i13 = f0Var.g;
                    this.g = visitor.visitInt(z7, i12, i13 != 0, i13);
                    this.h = visitor.visitIntList(this.h, f0Var.h);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= f0Var.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.c = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.d = codedInputStream.readInt32();
                                } else if (tag == 32) {
                                    this.e = codedInputStream.readInt32();
                                } else if (tag == 40) {
                                    this.f = codedInputStream.readInt32();
                                } else if (tag == 48) {
                                    this.g = codedInputStream.readInt32();
                                } else if (tag == 56) {
                                    if (!this.h.isModifiable()) {
                                        this.h = GeneratedMessageLite.mutableCopy(this.h);
                                    }
                                    this.h.addInt(codedInputStream.readEnum());
                                } else if (tag == 58) {
                                    if (!this.h.isModifiable()) {
                                        this.h = GeneratedMessageLite.mutableCopy(this.h);
                                    }
                                    int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.h.addInt(codedInputStream.readEnum());
                                    }
                                    codedInputStream.popLimit(iPushLimit);
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
                    if (r == null) {
                        synchronized (f0.class) {
                            if (r == null) {
                                r = new GeneratedMessageLite.DefaultInstanceBasedParser(q);
                            }
                            break;
                        }
                    }
                    return r;
                default:
                    throw new UnsupportedOperationException();
            }
            return q;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int g3() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.b;
            int iComputeInt32Size = i3 != 0 ? CodedOutputStream.computeInt32Size(1, i3) + 0 : 0;
            int i4 = this.c;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i4);
            }
            int i5 = this.d;
            if (i5 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i5);
            }
            int i6 = this.e;
            if (i6 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, i6);
            }
            int i7 = this.f;
            if (i7 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, i7);
            }
            int i8 = this.g;
            if (i8 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(6, i8);
            }
            int iComputeEnumSizeNoTag = 0;
            for (int i9 = 0; i9 < this.h.size(); i9++) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(this.h.getInt(i9));
            }
            int size = iComputeInt32Size + iComputeEnumSizeNoTag + (this.h.size() * 1);
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public List<ExposureFieldType> k5() {
            return new Internal.ListAdapter(this.h, p);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int o3() {
            return this.h.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public int t3() {
            return this.e;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i2 = this.b;
            if (i2 != 0) {
                codedOutputStream.writeInt32(1, i2);
            }
            int i3 = this.c;
            if (i3 != 0) {
                codedOutputStream.writeInt32(2, i3);
            }
            int i4 = this.d;
            if (i4 != 0) {
                codedOutputStream.writeInt32(3, i4);
            }
            int i5 = this.e;
            if (i5 != 0) {
                codedOutputStream.writeInt32(4, i5);
            }
            int i6 = this.f;
            if (i6 != 0) {
                codedOutputStream.writeInt32(5, i6);
            }
            int i7 = this.g;
            if (i7 != 0) {
                codedOutputStream.writeInt32(6, i7);
            }
            for (int i8 = 0; i8 < this.h.size(); i8++) {
                codedOutputStream.writeEnum(7, this.h.getInt(i8));
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public List<Integer> y1() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.g0
        public ExposureFieldType z(int i2) {
            return p.convert(Integer.valueOf(this.h.getInt(i2)));
        }
    }

    public interface g extends MessageLiteOrBuilder {
        d D(int i);

        float H();

        ByteString H5();

        String O4();

        ByteString P();

        boolean R0();

        String S1();

        String T();

        long V0();

        int V1();

        ByteString W3();

        int X2();

        ByteString Y1();

        List<d> a2();

        String c();

        ByteString d();

        ApkVerifyType e3();

        ByteString f5();

        long getApkSize();

        String getAppName();

        String getAppVersion();

        p i3();

        ByteString k();

        String q();

        String r3();

        long r4();

        String s();

        String t5();

        ByteString u3();

        ByteString w2();

        String y3();

        ByteString y4();

        ByteString z3();
    }

    public interface g0 extends MessageLiteOrBuilder {
        int E5();

        int I0();

        int J1();

        int T2();

        int W(int i);

        int g3();

        List<ExposureFieldType> k5();

        int o3();

        int t3();

        List<Integer> y1();

        ExposureFieldType z(int i);
    }

    public static final class h extends GeneratedMessageLite<h, a> implements i {
        public static final int g = 1;
        public static final int h = 2;
        public static final int i = 3;
        public static final int j = 4;
        public static final int k = 5;
        private static final h l;
        private static volatile Parser<h> m;
        private int a;
        private int b;
        private String c = "";
        private String d = "";
        private String e = "";
        private Internal.ProtobufList<b> f = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<h, a> implements i {
            private a() {
                super(h.l);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public int M2() {
                return ((h) this.instance).M2();
            }

            public a P5() {
                copyOnWrite();
                ((h) this.instance).Q5();
                return this;
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

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public String V4() {
                return ((h) this.instance).V4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public List<b> Y() {
                return Collections.unmodifiableList(((h) this.instance).Y());
            }

            public a a(int i, b.a aVar) {
                copyOnWrite();
                ((h) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, b bVar) {
                copyOnWrite();
                ((h) this.instance).a(i, bVar);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).b(byteString);
                return this;
            }

            public a a(b.a aVar) {
                copyOnWrite();
                ((h) this.instance).a(aVar);
                return this;
            }

            public a a(b bVar) {
                copyOnWrite();
                ((h) this.instance).a(bVar);
                return this;
            }

            public a a(Iterable<? extends b> iterable) {
                copyOnWrite();
                ((h) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((h) this.instance).a(str);
                return this;
            }

            public a b(int i, b.a aVar) {
                copyOnWrite();
                ((h) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, b bVar) {
                copyOnWrite();
                ((h) this.instance).b(i, bVar);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((h) this.instance).c(byteString);
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

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public ByteString e() {
                return ((h) this.instance).e();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public String g() {
                return ((h) this.instance).g();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public String h3() {
                return ((h) this.instance).h3();
            }

            public a o0(int i) {
                copyOnWrite();
                ((h) this.instance).p0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((h) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public ByteString s0() {
                return ((h) this.instance).s0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public int t() {
                return ((h) this.instance).t();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public ByteString v2() {
                return ((h) this.instance).v2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
            public b y(int i) {
                return ((h) this.instance).y(i);
            }
        }

        static {
            h hVar = new h();
            l = hVar;
            hVar.makeImmutable();
        }

        private h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.f = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.c = X5().h3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.e = X5().V4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.d = X5().g();
        }

        private void V5() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        public static h X5() {
            return l;
        }

        public static a Y5() {
            return l.toBuilder();
        }

        public static Parser<h> Z5() {
            return l.getParserForType();
        }

        public static h a(ByteString byteString) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(l, byteString);
        }

        public static h a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(l, byteString, extensionRegistryLite);
        }

        public static h a(CodedInputStream codedInputStream) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(l, codedInputStream);
        }

        public static h a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(l, codedInputStream, extensionRegistryLite);
        }

        public static h a(InputStream inputStream) throws IOException {
            return (h) GeneratedMessageLite.parseDelimitedFrom(l, inputStream);
        }

        public static h a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseDelimitedFrom(l, inputStream, extensionRegistryLite);
        }

        public static h a(byte[] bArr) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(l, bArr);
        }

        public static h a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h) GeneratedMessageLite.parseFrom(l, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, b.a aVar) {
            V5();
            this.f.add(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, b bVar) {
            bVar.getClass();
            V5();
            this.f.add(i2, bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b.a aVar) {
            V5();
            this.f.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b bVar) {
            bVar.getClass();
            V5();
            this.f.add(bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends b> iterable) {
            V5();
            AbstractMessageLite.addAll(iterable, this.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.c = str;
        }

        public static h b(InputStream inputStream) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(l, inputStream);
        }

        public static h b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h) GeneratedMessageLite.parseFrom(l, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, b.a aVar) {
            V5();
            this.f.set(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, b bVar) {
            bVar.getClass();
            V5();
            this.f.set(i2, bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.e = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        public static a f(h hVar) {
            return l.toBuilder().mergeFrom(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            V5();
            this.f.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            this.b = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public int M2() {
            return this.f.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public String V4() {
            return this.e;
        }

        public List<? extends c> W5() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public List<b> Y() {
            return this.f;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return l;
                case 3:
                    this.f.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    h hVar = (h) obj2;
                    int i2 = this.b;
                    boolean z2 = i2 != 0;
                    int i3 = hVar.b;
                    this.b = visitor.visitInt(z2, i2, i3 != 0, i3);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !hVar.c.isEmpty(), hVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !hVar.d.isEmpty(), hVar.d);
                    this.e = visitor.visitString(!this.e.isEmpty(), this.e, !hVar.e.isEmpty(), hVar.e);
                    this.f = visitor.visitList(this.f, hVar.f);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= hVar.a;
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
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 18) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.d = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 34) {
                                    this.e = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 42) {
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    this.f.add((b) codedInputStream.readMessage(b.b7(), extensionRegistryLite));
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
                    if (m == null) {
                        synchronized (h.class) {
                            if (m == null) {
                                m = new GeneratedMessageLite.DefaultInstanceBasedParser(l);
                            }
                            break;
                        }
                    }
                    return m;
                default:
                    throw new UnsupportedOperationException();
            }
            return l;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public ByteString e() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public String g() {
            return this.d;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.b;
            int iComputeInt32Size = i3 != 0 ? CodedOutputStream.computeInt32Size(1, i3) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(2, h3());
            }
            if (!this.d.isEmpty()) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(3, g());
            }
            if (!this.e.isEmpty()) {
                iComputeInt32Size += CodedOutputStream.computeStringSize(4, V4());
            }
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.f.get(i4));
            }
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public String h3() {
            return this.c;
        }

        public c o0(int i2) {
            return this.f.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public ByteString s0() {
            return ByteString.copyFromUtf8(this.e);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public int t() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public ByteString v2() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i2 = this.b;
            if (i2 != 0) {
                codedOutputStream.writeInt32(1, i2);
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, h3());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, g());
            }
            if (!this.e.isEmpty()) {
                codedOutputStream.writeString(4, V4());
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                codedOutputStream.writeMessage(5, this.f.get(i3));
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i
        public b y(int i2) {
            return this.f.get(i2);
        }
    }

    public static final class h0 extends GeneratedMessageLite<h0, a> implements i0 {
        public static final int g = 1;
        public static final int h = 2;
        public static final int i = 3;
        public static final int j = 4;
        public static final int k = 5;
        public static final int l = 6;
        private static final h0 m;
        private static volatile Parser<h0> n;
        private p a;
        private String b = "";
        private int c;
        private int d;
        private long e;
        private int f;

        public static final class a extends GeneratedMessageLite.Builder<h0, a> implements i0 {
            private a() {
                super(h0.m);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public p D0() {
                return ((h0) this.instance).D0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public int F1() {
                return ((h0) this.instance).F1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public ByteString J5() {
                return ((h0) this.instance).J5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public String O5() {
                return ((h0) this.instance).O5();
            }

            public a P5() {
                copyOnWrite();
                ((h0) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((h0) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((h0) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((h0) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((h0) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((h0) this.instance).V5();
                return this;
            }

            public a a(long j) {
                copyOnWrite();
                ((h0) this.instance).a(j);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((h0) this.instance).b(byteString);
                return this;
            }

            public a a(VideoType videoType) {
                copyOnWrite();
                ((h0) this.instance).a(videoType);
                return this;
            }

            public a a(p.a aVar) {
                copyOnWrite();
                ((h0) this.instance).a(aVar);
                return this;
            }

            public a a(p pVar) {
                copyOnWrite();
                ((h0) this.instance).a(pVar);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((h0) this.instance).a(str);
                return this;
            }

            public a b(p pVar) {
                copyOnWrite();
                ((h0) this.instance).b(pVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public int h1() {
                return ((h0) this.instance).h1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public int l2() {
                return ((h0) this.instance).l2();
            }

            public a o0(int i) {
                copyOnWrite();
                ((h0) this.instance).o0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((h0) this.instance).p0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((h0) this.instance).q0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public boolean r() {
                return ((h0) this.instance).r();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public VideoType r5() {
                return ((h0) this.instance).r5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
            public long x3() {
                return ((h0) this.instance).x3();
            }
        }

        static {
            h0 h0Var = new h0();
            m = h0Var;
            h0Var.makeImmutable();
        }

        private h0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.e = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.b = W5().O5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.f = 0;
        }

        public static h0 W5() {
            return m;
        }

        public static a X5() {
            return m.toBuilder();
        }

        public static Parser<h0> Y5() {
            return m.getParserForType();
        }

        public static h0 a(ByteString byteString) throws InvalidProtocolBufferException {
            return (h0) GeneratedMessageLite.parseFrom(m, byteString);
        }

        public static h0 a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h0) GeneratedMessageLite.parseFrom(m, byteString, extensionRegistryLite);
        }

        public static h0 a(CodedInputStream codedInputStream) throws IOException {
            return (h0) GeneratedMessageLite.parseFrom(m, codedInputStream);
        }

        public static h0 a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h0) GeneratedMessageLite.parseFrom(m, codedInputStream, extensionRegistryLite);
        }

        public static h0 a(InputStream inputStream) throws IOException {
            return (h0) GeneratedMessageLite.parseDelimitedFrom(m, inputStream);
        }

        public static h0 a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h0) GeneratedMessageLite.parseDelimitedFrom(m, inputStream, extensionRegistryLite);
        }

        public static h0 a(byte[] bArr) throws InvalidProtocolBufferException {
            return (h0) GeneratedMessageLite.parseFrom(m, bArr);
        }

        public static h0 a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (h0) GeneratedMessageLite.parseFrom(m, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j2) {
            this.e = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(VideoType videoType) {
            videoType.getClass();
            this.d = videoType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p.a aVar) {
            this.a = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar) {
            p pVar2 = this.a;
            if (pVar2 != null && pVar2 != p.T5()) {
                pVar = p.d(this.a).mergeFrom(pVar).buildPartial();
            }
            this.a = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static h0 b(InputStream inputStream) throws IOException {
            return (h0) GeneratedMessageLite.parseFrom(m, inputStream);
        }

        public static h0 b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (h0) GeneratedMessageLite.parseFrom(m, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(p pVar) {
            pVar.getClass();
            this.a = pVar;
        }

        public static a g(h0 h0Var) {
            return m.toBuilder().mergeFrom(h0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            this.f = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public p D0() {
            p pVar = this.a;
            return pVar == null ? p.T5() : pVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public int F1() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public ByteString J5() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public String O5() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new h0();
                case 2:
                    return m;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    h0 h0Var = (h0) obj2;
                    this.a = (p) visitor.visitMessage(this.a, h0Var.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !h0Var.b.isEmpty(), h0Var.b);
                    int i2 = this.c;
                    boolean z2 = i2 != 0;
                    int i3 = h0Var.c;
                    this.c = visitor.visitInt(z2, i2, i3 != 0, i3);
                    int i4 = this.d;
                    boolean z3 = i4 != 0;
                    int i5 = h0Var.d;
                    this.d = visitor.visitInt(z3, i4, i5 != 0, i5);
                    long j2 = this.e;
                    boolean z4 = j2 != 0;
                    long j3 = h0Var.e;
                    this.e = visitor.visitLong(z4, j2, j3 != 0, j3);
                    int i6 = this.f;
                    boolean z5 = i6 != 0;
                    int i7 = h0Var.f;
                    this.f = visitor.visitInt(z5, i6, i7 != 0, i7);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    p pVar = this.a;
                                    p.a builder = pVar != null ? pVar.toBuilder() : null;
                                    p pVar2 = (p) codedInputStream.readMessage(p.V5(), extensionRegistryLite);
                                    this.a = pVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar2);
                                        this.a = builder.buildPartial();
                                    }
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readInt32();
                                } else if (tag == 32) {
                                    this.d = codedInputStream.readEnum();
                                } else if (tag == 40) {
                                    this.e = codedInputStream.readInt64();
                                } else if (tag == 48) {
                                    this.f = codedInputStream.readInt32();
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
                    if (n == null) {
                        synchronized (h0.class) {
                            if (n == null) {
                                n = new GeneratedMessageLite.DefaultInstanceBasedParser(m);
                            }
                            break;
                        }
                    }
                    return n;
                default:
                    throw new UnsupportedOperationException();
            }
            return m;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeMessageSize = this.a != null ? 0 + CodedOutputStream.computeMessageSize(1, D0()) : 0;
            if (!this.b.isEmpty()) {
                iComputeMessageSize += CodedOutputStream.computeStringSize(2, O5());
            }
            int i3 = this.c;
            if (i3 != 0) {
                iComputeMessageSize += CodedOutputStream.computeInt32Size(3, i3);
            }
            if (this.d != VideoType.VideoType_unknown.getNumber()) {
                iComputeMessageSize += CodedOutputStream.computeEnumSize(4, this.d);
            }
            long j2 = this.e;
            if (j2 != 0) {
                iComputeMessageSize += CodedOutputStream.computeInt64Size(5, j2);
            }
            int i4 = this.f;
            if (i4 != 0) {
                iComputeMessageSize += CodedOutputStream.computeInt32Size(6, i4);
            }
            this.memoizedSerializedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public int h1() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public int l2() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public boolean r() {
            return this.a != null;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public VideoType r5() {
            VideoType videoTypeForNumber = VideoType.forNumber(this.d);
            return videoTypeForNumber == null ? VideoType.UNRECOGNIZED : videoTypeForNumber;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != null) {
                codedOutputStream.writeMessage(1, D0());
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, O5());
            }
            int i2 = this.c;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            if (this.d != VideoType.VideoType_unknown.getNumber()) {
                codedOutputStream.writeEnum(4, this.d);
            }
            long j2 = this.e;
            if (j2 != 0) {
                codedOutputStream.writeInt64(5, j2);
            }
            int i3 = this.f;
            if (i3 != 0) {
                codedOutputStream.writeInt32(6, i3);
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.i0
        public long x3() {
            return this.e;
        }
    }

    public interface i extends MessageLiteOrBuilder {
        int M2();

        String V4();

        List<b> Y();

        ByteString e();

        String g();

        String h3();

        ByteString s0();

        int t();

        ByteString v2();

        b y(int i);
    }

    public interface i0 extends MessageLiteOrBuilder {
        p D0();

        int F1();

        ByteString J5();

        String O5();

        int h1();

        int l2();

        boolean r();

        VideoType r5();

        long x3();
    }

    public static final class j extends GeneratedMessageLite<j, a> implements k {
        public static final int b = 1;
        private static final j c;
        private static volatile Parser<j> d;
        private int a;

        public static final class a extends GeneratedMessageLite.Builder<j, a> implements k {
            private a() {
                super(j.c);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            public a P5() {
                copyOnWrite();
                ((j) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k
            public int l0() {
                return ((j) this.instance).l0();
            }

            public a o0(int i) {
                copyOnWrite();
                ((j) this.instance).o0(i);
                return this;
            }
        }

        static {
            j jVar = new j();
            c = jVar;
            jVar.makeImmutable();
        }

        private j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.a = 0;
        }

        public static j R5() {
            return c;
        }

        public static a S5() {
            return c.toBuilder();
        }

        public static Parser<j> T5() {
            return c.getParserForType();
        }

        public static j a(ByteString byteString) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(c, byteString);
        }

        public static j a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(c, byteString, extensionRegistryLite);
        }

        public static j a(CodedInputStream codedInputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(c, codedInputStream);
        }

        public static j a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(c, codedInputStream, extensionRegistryLite);
        }

        public static j a(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(c, inputStream);
        }

        public static j a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseDelimitedFrom(c, inputStream, extensionRegistryLite);
        }

        public static j a(byte[] bArr) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(c, bArr);
        }

        public static j a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j) GeneratedMessageLite.parseFrom(c, bArr, extensionRegistryLite);
        }

        public static a b(j jVar) {
            return c.toBuilder().mergeFrom(jVar);
        }

        public static j b(InputStream inputStream) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(c, inputStream);
        }

        public static j b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j) GeneratedMessageLite.parseFrom(c, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.a = i;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return c;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    j jVar = (j) obj2;
                    int i = this.a;
                    boolean z2 = i != 0;
                    int i2 = jVar.a;
                    this.a = visitor.visitInt(z2, i, i2 != 0, i2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 8) {
                                        this.a = codedInputStream.readInt32();
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
                    if (d == null) {
                        synchronized (j.class) {
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
            int i2 = this.a;
            int iComputeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k
        public int l0() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.a;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
        }
    }

    public static final class j0 extends GeneratedMessageLite<j0, a> implements k0 {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public static final int h = 4;
        private static final j0 i;
        private static volatile Parser<j0> j;
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";

        public static final class a extends GeneratedMessageLite.Builder<j0, a> implements k0 {
            private a() {
                super(j0.i);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public ByteString D1() {
                return ((j0) this.instance).D1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public ByteString G1() {
                return ((j0) this.instance).G1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public String M3() {
                return ((j0) this.instance).M3();
            }

            public a P5() {
                copyOnWrite();
                ((j0) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((j0) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((j0) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((j0) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public String U1() {
                return ((j0) this.instance).U1();
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((j0) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((j0) this.instance).a(str);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((j0) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((j0) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((j0) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((j0) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public String c() {
                return ((j0) this.instance).c();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public ByteString d() {
                return ((j0) this.instance).d();
            }

            public a d(ByteString byteString) {
                copyOnWrite();
                ((j0) this.instance).e(byteString);
                return this;
            }

            public a d(String str) {
                copyOnWrite();
                ((j0) this.instance).d(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public String f0() {
                return ((j0) this.instance).f0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
            public ByteString s5() {
                return ((j0) this.instance).s5();
            }
        }

        static {
            j0 j0Var = new j0();
            i = j0Var;
            j0Var.makeImmutable();
        }

        private j0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.d = U5().c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.c = U5().M3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = U5().f0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.b = U5().U1();
        }

        public static j0 U5() {
            return i;
        }

        public static a V5() {
            return i.toBuilder();
        }

        public static Parser<j0> W5() {
            return i.getParserForType();
        }

        public static j0 a(ByteString byteString) throws InvalidProtocolBufferException {
            return (j0) GeneratedMessageLite.parseFrom(i, byteString);
        }

        public static j0 a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j0) GeneratedMessageLite.parseFrom(i, byteString, extensionRegistryLite);
        }

        public static j0 a(CodedInputStream codedInputStream) throws IOException {
            return (j0) GeneratedMessageLite.parseFrom(i, codedInputStream);
        }

        public static j0 a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j0) GeneratedMessageLite.parseFrom(i, codedInputStream, extensionRegistryLite);
        }

        public static j0 a(InputStream inputStream) throws IOException {
            return (j0) GeneratedMessageLite.parseDelimitedFrom(i, inputStream);
        }

        public static j0 a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j0) GeneratedMessageLite.parseDelimitedFrom(i, inputStream, extensionRegistryLite);
        }

        public static j0 a(byte[] bArr) throws InvalidProtocolBufferException {
            return (j0) GeneratedMessageLite.parseFrom(i, bArr);
        }

        public static j0 a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (j0) GeneratedMessageLite.parseFrom(i, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.d = str;
        }

        public static j0 b(InputStream inputStream) throws IOException {
            return (j0) GeneratedMessageLite.parseFrom(i, inputStream);
        }

        public static j0 b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (j0) GeneratedMessageLite.parseFrom(i, inputStream, extensionRegistryLite);
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
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
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
            this.b = str;
        }

        public static a e(j0 j0Var) {
            return i.toBuilder().mergeFrom(j0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public ByteString D1() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public ByteString G1() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public String M3() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public String U1() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public String c() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public ByteString d() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new j0();
                case 2:
                    return i;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    j0 j0Var = (j0) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !j0Var.a.isEmpty(), j0Var.a);
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !j0Var.b.isEmpty(), j0Var.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !j0Var.c.isEmpty(), j0Var.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, true ^ j0Var.d.isEmpty(), j0Var.d);
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
                        synchronized (j0.class) {
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

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public String f0() {
            return this.a;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, f0());
            if (!this.b.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, U1());
            }
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, M3());
            }
            if (!this.d.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(4, c());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.k0
        public ByteString s5() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, f0());
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, U1());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(3, M3());
            }
            if (this.d.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(4, c());
        }
    }

    public interface k extends MessageLiteOrBuilder {
        int l0();
    }

    public interface k0 extends MessageLiteOrBuilder {
        ByteString D1();

        ByteString G1();

        String M3();

        String U1();

        String c();

        ByteString d();

        String f0();

        ByteString s5();
    }

    public static final class l extends GeneratedMessageLite<l, a> implements m {
        public static final int j = 1;
        public static final int k = 2;
        public static final int l = 3;
        public static final int m = 4;
        public static final int n = 5;
        public static final int o = 6;
        public static final int p = 7;
        public static final int q = 8;
        public static final int r = 9;
        private static final l s;
        private static volatile Parser<l> t;
        private Internal.ProtobufList<n> a = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> b = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> c = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> d = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> e = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> f = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> g = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> h = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<n> i = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<l, a> implements m {
            private a() {
                super(l.s);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int C1() {
                return ((l) this.instance).C1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> H1() {
                return Collections.unmodifiableList(((l) this.instance).H1());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> I2() {
                return Collections.unmodifiableList(((l) this.instance).I2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> K2() {
                return Collections.unmodifiableList(((l) this.instance).K2());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int L() {
                return ((l) this.instance).L();
            }

            public a P5() {
                copyOnWrite();
                ((l) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int Q() {
                return ((l) this.instance).Q();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n Q(int i) {
                return ((l) this.instance).Q(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int Q3() {
                return ((l) this.instance).Q3();
            }

            public a Q5() {
                copyOnWrite();
                ((l) this.instance).R5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n R(int i) {
                return ((l) this.instance).R(i);
            }

            public a R5() {
                copyOnWrite();
                ((l) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((l) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((l) this.instance).U5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n U(int i) {
                return ((l) this.instance).U(i);
            }

            public a U5() {
                copyOnWrite();
                ((l) this.instance).V5();
                return this;
            }

            public a V5() {
                copyOnWrite();
                ((l) this.instance).W5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> W0() {
                return Collections.unmodifiableList(((l) this.instance).W0());
            }

            public a W5() {
                copyOnWrite();
                ((l) this.instance).X5();
                return this;
            }

            public a X5() {
                copyOnWrite();
                ((l) this.instance).Y5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n Y(int i) {
                return ((l) this.instance).Y(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> Z4() {
                return Collections.unmodifiableList(((l) this.instance).Z4());
            }

            public a a(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).a(i, nVar);
                return this;
            }

            public a a(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).a(aVar);
                return this;
            }

            public a a(n nVar) {
                copyOnWrite();
                ((l) this.instance).a(nVar);
                return this;
            }

            public a a(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).a(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n a(int i) {
                return ((l) this.instance).a(i);
            }

            public a b(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).b(i, nVar);
                return this;
            }

            public a b(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).b(aVar);
                return this;
            }

            public a b(n nVar) {
                copyOnWrite();
                ((l) this.instance).b(nVar);
                return this;
            }

            public a b(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).b(iterable);
                return this;
            }

            public a c(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).c(i, aVar);
                return this;
            }

            public a c(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).c(i, nVar);
                return this;
            }

            public a c(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).c(aVar);
                return this;
            }

            public a c(n nVar) {
                copyOnWrite();
                ((l) this.instance).c(nVar);
                return this;
            }

            public a c(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).c(iterable);
                return this;
            }

            public a d(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).d(i, aVar);
                return this;
            }

            public a d(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).d(i, nVar);
                return this;
            }

            public a d(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).d(aVar);
                return this;
            }

            public a d(n nVar) {
                copyOnWrite();
                ((l) this.instance).d(nVar);
                return this;
            }

            public a d(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).d(iterable);
                return this;
            }

            public a e(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).e(i, aVar);
                return this;
            }

            public a e(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).e(i, nVar);
                return this;
            }

            public a e(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).e(aVar);
                return this;
            }

            public a e(n nVar) {
                copyOnWrite();
                ((l) this.instance).e(nVar);
                return this;
            }

            public a e(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).e(iterable);
                return this;
            }

            public a f(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).f(i, aVar);
                return this;
            }

            public a f(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).f(i, nVar);
                return this;
            }

            public a f(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).f(aVar);
                return this;
            }

            public a f(n nVar) {
                copyOnWrite();
                ((l) this.instance).f(nVar);
                return this;
            }

            public a f(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).f(iterable);
                return this;
            }

            public a g(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).g(i, aVar);
                return this;
            }

            public a g(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).g(i, nVar);
                return this;
            }

            public a g(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).g(aVar);
                return this;
            }

            public a g(n nVar) {
                copyOnWrite();
                ((l) this.instance).g(nVar);
                return this;
            }

            public a g(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).g(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n g(int i) {
                return ((l) this.instance).g(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int g4() {
                return ((l) this.instance).g4();
            }

            public a h(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).h(i, aVar);
                return this;
            }

            public a h(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).h(i, nVar);
                return this;
            }

            public a h(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).h(aVar);
                return this;
            }

            public a h(n nVar) {
                copyOnWrite();
                ((l) this.instance).h(nVar);
                return this;
            }

            public a h(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).h(iterable);
                return this;
            }

            public a i(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).i(i, aVar);
                return this;
            }

            public a i(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).i(i, nVar);
                return this;
            }

            public a i(n.a aVar) {
                copyOnWrite();
                ((l) this.instance).i(aVar);
                return this;
            }

            public a i(n nVar) {
                copyOnWrite();
                ((l) this.instance).i(nVar);
                return this;
            }

            public a i(Iterable<? extends n> iterable) {
                copyOnWrite();
                ((l) this.instance).i(iterable);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n i0(int i) {
                return ((l) this.instance).i0(i);
            }

            public a j(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).j(i, aVar);
                return this;
            }

            public a j(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).j(i, nVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n j0(int i) {
                return ((l) this.instance).j0(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> j4() {
                return Collections.unmodifiableList(((l) this.instance).j4());
            }

            public a k(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).k(i, aVar);
                return this;
            }

            public a k(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).k(i, nVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int k0() {
                return ((l) this.instance).k0();
            }

            public a l(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).l(i, aVar);
                return this;
            }

            public a l(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).l(i, nVar);
                return this;
            }

            public a m(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).m(i, aVar);
                return this;
            }

            public a m(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).m(i, nVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public n m0(int i) {
                return ((l) this.instance).m0(i);
            }

            public a n(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).n(i, aVar);
                return this;
            }

            public a n(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).n(i, nVar);
                return this;
            }

            public a o(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).o(i, aVar);
                return this;
            }

            public a o(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).o(i, nVar);
                return this;
            }

            public a o0(int i) {
                copyOnWrite();
                ((l) this.instance).x0(i);
                return this;
            }

            public a p(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).p(i, aVar);
                return this;
            }

            public a p(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).p(i, nVar);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((l) this.instance).y0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> p4() {
                return Collections.unmodifiableList(((l) this.instance).p4());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> p5() {
                return Collections.unmodifiableList(((l) this.instance).p5());
            }

            public a q(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).q(i, aVar);
                return this;
            }

            public a q(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).q(i, nVar);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((l) this.instance).z0(i);
                return this;
            }

            public a r(int i, n.a aVar) {
                copyOnWrite();
                ((l) this.instance).r(i, aVar);
                return this;
            }

            public a r(int i, n nVar) {
                copyOnWrite();
                ((l) this.instance).r(i, nVar);
                return this;
            }

            public a r0(int i) {
                copyOnWrite();
                ((l) this.instance).A0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public List<n> r1() {
                return Collections.unmodifiableList(((l) this.instance).r1());
            }

            public a s0(int i) {
                copyOnWrite();
                ((l) this.instance).B0(i);
                return this;
            }

            public a t0(int i) {
                copyOnWrite();
                ((l) this.instance).C0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int t1() {
                return ((l) this.instance).t1();
            }

            public a u0(int i) {
                copyOnWrite();
                ((l) this.instance).D0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int u1() {
                return ((l) this.instance).u1();
            }

            public a v0(int i) {
                copyOnWrite();
                ((l) this.instance).E0(i);
                return this;
            }

            public a w0(int i) {
                copyOnWrite();
                ((l) this.instance).F0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
            public int z0() {
                return ((l) this.instance).z0();
            }
        }

        static {
            l lVar = new l();
            s = lVar;
            lVar.makeImmutable();
        }

        private l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(int i) {
            c6();
            this.g.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(int i) {
            d6();
            this.h.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(int i) {
            e6();
            this.a.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(int i) {
            f6();
            this.d.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(int i) {
            g6();
            this.i.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(int i) {
            h6();
            this.b.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.f = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.e = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.g = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.h = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.a = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.d = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.i = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.b = GeneratedMessageLite.emptyProtobufList();
        }

        private void Z5() {
            if (this.c.isModifiable()) {
                return;
            }
            this.c = GeneratedMessageLite.mutableCopy(this.c);
        }

        public static l a(ByteString byteString) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(s, byteString);
        }

        public static l a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(s, byteString, extensionRegistryLite);
        }

        public static l a(CodedInputStream codedInputStream) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(s, codedInputStream);
        }

        public static l a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(s, codedInputStream, extensionRegistryLite);
        }

        public static l a(InputStream inputStream) throws IOException {
            return (l) GeneratedMessageLite.parseDelimitedFrom(s, inputStream);
        }

        public static l a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseDelimitedFrom(s, inputStream, extensionRegistryLite);
        }

        public static l a(byte[] bArr) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(s, bArr);
        }

        public static l a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (l) GeneratedMessageLite.parseFrom(s, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, n.a aVar) {
            Z5();
            this.c.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, n nVar) {
            nVar.getClass();
            Z5();
            this.c.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(n.a aVar) {
            Z5();
            this.c.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(n nVar) {
            nVar.getClass();
            Z5();
            this.c.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends n> iterable) {
            Z5();
            AbstractMessageLite.addAll(iterable, this.c);
        }

        private void a6() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        public static l b(InputStream inputStream) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(s, inputStream);
        }

        public static l b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (l) GeneratedMessageLite.parseFrom(s, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, n.a aVar) {
            a6();
            this.f.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, n nVar) {
            nVar.getClass();
            a6();
            this.f.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(n.a aVar) {
            a6();
            this.f.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(n nVar) {
            nVar.getClass();
            a6();
            this.f.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<? extends n> iterable) {
            a6();
            AbstractMessageLite.addAll(iterable, this.f);
        }

        private void b6() {
            if (this.e.isModifiable()) {
                return;
            }
            this.e = GeneratedMessageLite.mutableCopy(this.e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i, n.a aVar) {
            b6();
            this.e.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i, n nVar) {
            nVar.getClass();
            b6();
            this.e.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(n.a aVar) {
            b6();
            this.e.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(n nVar) {
            nVar.getClass();
            b6();
            this.e.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Iterable<? extends n> iterable) {
            b6();
            AbstractMessageLite.addAll(iterable, this.e);
        }

        private void c6() {
            if (this.g.isModifiable()) {
                return;
            }
            this.g = GeneratedMessageLite.mutableCopy(this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i, n.a aVar) {
            c6();
            this.g.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(int i, n nVar) {
            nVar.getClass();
            c6();
            this.g.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(n.a aVar) {
            c6();
            this.g.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(n nVar) {
            nVar.getClass();
            c6();
            this.g.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Iterable<? extends n> iterable) {
            c6();
            AbstractMessageLite.addAll(iterable, this.g);
        }

        private void d6() {
            if (this.h.isModifiable()) {
                return;
            }
            this.h = GeneratedMessageLite.mutableCopy(this.h);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i, n.a aVar) {
            d6();
            this.h.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i, n nVar) {
            nVar.getClass();
            d6();
            this.h.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(n.a aVar) {
            d6();
            this.h.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(n nVar) {
            nVar.getClass();
            d6();
            this.h.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Iterable<? extends n> iterable) {
            d6();
            AbstractMessageLite.addAll(iterable, this.h);
        }

        private void e6() {
            if (this.a.isModifiable()) {
                return;
            }
            this.a = GeneratedMessageLite.mutableCopy(this.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i, n.a aVar) {
            e6();
            this.a.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i, n nVar) {
            nVar.getClass();
            e6();
            this.a.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(n.a aVar) {
            e6();
            this.a.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(n nVar) {
            nVar.getClass();
            e6();
            this.a.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Iterable<? extends n> iterable) {
            e6();
            AbstractMessageLite.addAll(iterable, this.a);
        }

        private void f6() {
            if (this.d.isModifiable()) {
                return;
            }
            this.d = GeneratedMessageLite.mutableCopy(this.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i, n.a aVar) {
            f6();
            this.d.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i, n nVar) {
            nVar.getClass();
            f6();
            this.d.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(n.a aVar) {
            f6();
            this.d.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(n nVar) {
            nVar.getClass();
            f6();
            this.d.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(Iterable<? extends n> iterable) {
            f6();
            AbstractMessageLite.addAll(iterable, this.d);
        }

        private void g6() {
            if (this.i.isModifiable()) {
                return;
            }
            this.i = GeneratedMessageLite.mutableCopy(this.i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i, n.a aVar) {
            g6();
            this.i.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i, n nVar) {
            nVar.getClass();
            g6();
            this.i.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(n.a aVar) {
            g6();
            this.i.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(n nVar) {
            nVar.getClass();
            g6();
            this.i.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(Iterable<? extends n> iterable) {
            g6();
            AbstractMessageLite.addAll(iterable, this.i);
        }

        private void h6() {
            if (this.b.isModifiable()) {
                return;
            }
            this.b = GeneratedMessageLite.mutableCopy(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i, n.a aVar) {
            h6();
            this.b.add(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i, n nVar) {
            nVar.getClass();
            h6();
            this.b.add(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(n.a aVar) {
            h6();
            this.b.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(n nVar) {
            nVar.getClass();
            h6();
            this.b.add(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(Iterable<? extends n> iterable) {
            h6();
            AbstractMessageLite.addAll(iterable, this.b);
        }

        public static a j(l lVar) {
            return s.toBuilder().mergeFrom(lVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i, n.a aVar) {
            Z5();
            this.c.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i, n nVar) {
            nVar.getClass();
            Z5();
            this.c.set(i, nVar);
        }

        public static l j6() {
            return s;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i, n.a aVar) {
            a6();
            this.f.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i, n nVar) {
            nVar.getClass();
            a6();
            this.f.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i, n.a aVar) {
            b6();
            this.e.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i, n nVar) {
            nVar.getClass();
            b6();
            this.e.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(int i, n.a aVar) {
            c6();
            this.g.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(int i, n nVar) {
            nVar.getClass();
            c6();
            this.g.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(int i, n.a aVar) {
            d6();
            this.h.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(int i, n nVar) {
            nVar.getClass();
            d6();
            this.h.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(int i, n.a aVar) {
            e6();
            this.a.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(int i, n nVar) {
            nVar.getClass();
            e6();
            this.a.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i, n.a aVar) {
            f6();
            this.d.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(int i, n nVar) {
            nVar.getClass();
            f6();
            this.d.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i, n.a aVar) {
            g6();
            this.i.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i, n nVar) {
            nVar.getClass();
            g6();
            this.i.set(i, nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(int i, n.a aVar) {
            h6();
            this.b.set(i, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(int i, n nVar) {
            nVar.getClass();
            h6();
            this.b.set(i, nVar);
        }

        public static a s6() {
            return s.toBuilder();
        }

        public static Parser<l> t6() {
            return s.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(int i) {
            Z5();
            this.c.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(int i) {
            a6();
            this.f.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(int i) {
            b6();
            this.e.remove(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int C1() {
            return this.h.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> H1() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> I2() {
            return this.h;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> K2() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int L() {
            return this.g.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int Q() {
            return this.i.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n Q(int i) {
            return this.e.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int Q3() {
            return this.b.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n R(int i) {
            return this.d.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n U(int i) {
            return this.g.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> W0() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n Y(int i) {
            return this.c.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> Z4() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n a(int i) {
            return this.f.get(i);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            Parser<n> parserW5;
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new l();
                case 2:
                    return s;
                case 3:
                    this.a.makeImmutable();
                    this.b.makeImmutable();
                    this.c.makeImmutable();
                    this.d.makeImmutable();
                    this.e.makeImmutable();
                    this.f.makeImmutable();
                    this.g.makeImmutable();
                    this.h.makeImmutable();
                    this.i.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    l lVar = (l) obj2;
                    this.a = visitor.visitList(this.a, lVar.a);
                    this.b = visitor.visitList(this.b, lVar.b);
                    this.c = visitor.visitList(this.c, lVar.c);
                    this.d = visitor.visitList(this.d, lVar.d);
                    this.e = visitor.visitList(this.e, lVar.e);
                    this.f = visitor.visitList(this.f, lVar.f);
                    this.g = visitor.visitList(this.g, lVar.g);
                    this.h = visitor.visitList(this.h, lVar.h);
                    this.i = visitor.visitList(this.i, lVar.i);
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
                                    list = this.a;
                                    parserW5 = n.W5();
                                } else if (tag == 18) {
                                    if (!this.b.isModifiable()) {
                                        this.b = GeneratedMessageLite.mutableCopy(this.b);
                                    }
                                    list = this.b;
                                    parserW5 = n.W5();
                                } else if (tag == 26) {
                                    if (!this.c.isModifiable()) {
                                        this.c = GeneratedMessageLite.mutableCopy(this.c);
                                    }
                                    list = this.c;
                                    parserW5 = n.W5();
                                } else if (tag == 34) {
                                    if (!this.d.isModifiable()) {
                                        this.d = GeneratedMessageLite.mutableCopy(this.d);
                                    }
                                    list = this.d;
                                    parserW5 = n.W5();
                                } else if (tag == 42) {
                                    if (!this.e.isModifiable()) {
                                        this.e = GeneratedMessageLite.mutableCopy(this.e);
                                    }
                                    list = this.e;
                                    parserW5 = n.W5();
                                } else if (tag == 50) {
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    list = this.f;
                                    parserW5 = n.W5();
                                } else if (tag == 58) {
                                    if (!this.g.isModifiable()) {
                                        this.g = GeneratedMessageLite.mutableCopy(this.g);
                                    }
                                    list = this.g;
                                    parserW5 = n.W5();
                                } else if (tag == 66) {
                                    if (!this.h.isModifiable()) {
                                        this.h = GeneratedMessageLite.mutableCopy(this.h);
                                    }
                                    list = this.h;
                                    parserW5 = n.W5();
                                } else if (tag == 74) {
                                    if (!this.i.isModifiable()) {
                                        this.i = GeneratedMessageLite.mutableCopy(this.i);
                                    }
                                    list = this.i;
                                    parserW5 = n.W5();
                                } else if (!codedInputStream.skipField(tag)) {
                                }
                                list.add(codedInputStream.readMessage(parserW5, extensionRegistryLite));
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
                    if (t == null) {
                        synchronized (l.class) {
                            if (t == null) {
                                t = new GeneratedMessageLite.DefaultInstanceBasedParser(s);
                            }
                            break;
                        }
                    }
                    return t;
                default:
                    throw new UnsupportedOperationException();
            }
            return s;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n g(int i) {
            return this.i.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int g4() {
            return this.f.size();
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
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.b.get(i3));
            }
            for (int i4 = 0; i4 < this.c.size(); i4++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.c.get(i4));
            }
            for (int i5 = 0; i5 < this.d.size(); i5++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.d.get(i5));
            }
            for (int i6 = 0; i6 < this.e.size(); i6++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.e.get(i6));
            }
            for (int i7 = 0; i7 < this.f.size(); i7++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.f.get(i7));
            }
            for (int i8 = 0; i8 < this.g.size(); i8++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(7, this.g.get(i8));
            }
            for (int i9 = 0; i9 < this.h.size(); i9++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(8, this.h.get(i9));
            }
            for (int i10 = 0; i10 < this.i.size(); i10++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(9, this.i.get(i10));
            }
            this.memoizedSerializedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n i0(int i) {
            return this.h.get(i);
        }

        public List<? extends o> i6() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n j0(int i) {
            return this.b.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> j4() {
            return this.i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int k0() {
            return this.e.size();
        }

        public List<? extends o> k6() {
            return this.f;
        }

        public List<? extends o> l6() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public n m0(int i) {
            return this.a.get(i);
        }

        public List<? extends o> m6() {
            return this.g;
        }

        public List<? extends o> n6() {
            return this.h;
        }

        public o o0(int i) {
            return this.c.get(i);
        }

        public List<? extends o> o6() {
            return this.a;
        }

        public o p0(int i) {
            return this.f.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> p4() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> p5() {
            return this.a;
        }

        public List<? extends o> p6() {
            return this.d;
        }

        public o q0(int i) {
            return this.e.get(i);
        }

        public List<? extends o> q6() {
            return this.i;
        }

        public o r0(int i) {
            return this.g.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public List<n> r1() {
            return this.g;
        }

        public List<? extends o> r6() {
            return this.b;
        }

        public o s0(int i) {
            return this.h.get(i);
        }

        public o t0(int i) {
            return this.a.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int t1() {
            return this.c.size();
        }

        public o u0(int i) {
            return this.d.get(i);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int u1() {
            return this.a.size();
        }

        public o v0(int i) {
            return this.i.get(i);
        }

        public o w0(int i) {
            return this.b.get(i);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.a.size(); i++) {
                codedOutputStream.writeMessage(1, this.a.get(i));
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                codedOutputStream.writeMessage(2, this.b.get(i2));
            }
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                codedOutputStream.writeMessage(3, this.c.get(i3));
            }
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                codedOutputStream.writeMessage(4, this.d.get(i4));
            }
            for (int i5 = 0; i5 < this.e.size(); i5++) {
                codedOutputStream.writeMessage(5, this.e.get(i5));
            }
            for (int i6 = 0; i6 < this.f.size(); i6++) {
                codedOutputStream.writeMessage(6, this.f.get(i6));
            }
            for (int i7 = 0; i7 < this.g.size(); i7++) {
                codedOutputStream.writeMessage(7, this.g.get(i7));
            }
            for (int i8 = 0; i8 < this.h.size(); i8++) {
                codedOutputStream.writeMessage(8, this.h.get(i8));
            }
            for (int i9 = 0; i9 < this.i.size(); i9++) {
                codedOutputStream.writeMessage(9, this.i.get(i9));
            }
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.m
        public int z0() {
            return this.d.size();
        }
    }

    public interface m extends MessageLiteOrBuilder {
        int C1();

        List<n> H1();

        List<n> I2();

        List<n> K2();

        int L();

        int Q();

        n Q(int i);

        int Q3();

        n R(int i);

        n U(int i);

        List<n> W0();

        n Y(int i);

        List<n> Z4();

        n a(int i);

        n g(int i);

        int g4();

        n i0(int i);

        n j0(int i);

        List<n> j4();

        int k0();

        n m0(int i);

        List<n> p4();

        List<n> p5();

        List<n> r1();

        int t1();

        int u1();

        int z0();
    }

    public static final class n extends GeneratedMessageLite<n, a> implements o {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        private static final n h;
        private static volatile Parser<n> i;
        private int a;
        private String b = "";
        private Internal.ProtobufList<String> c = GeneratedMessageLite.emptyProtobufList();
        private int d;

        public static final class a extends GeneratedMessageLite.Builder<n, a> implements o {
            private a() {
                super(n.h);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public List<String> N1() {
                return Collections.unmodifiableList(((n) this.instance).N1());
            }

            public a P5() {
                copyOnWrite();
                ((n) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((n) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((n) this.instance).S5();
                return this;
            }

            public a a(int i, String str) {
                copyOnWrite();
                ((n) this.instance).a(i, str);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((n) this.instance).a(byteString);
                return this;
            }

            public a a(Iterable<String> iterable) {
                copyOnWrite();
                ((n) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((n) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public ByteString b(int i) {
                return ((n) this.instance).b(i);
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((n) this.instance).c(byteString);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((n) this.instance).b(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public int j5() {
                return ((n) this.instance).j5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public String l() {
                return ((n) this.instance).l();
            }

            public a o0(int i) {
                copyOnWrite();
                ((n) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public int p1() {
                return ((n) this.instance).p1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public String s(int i) {
                return ((n) this.instance).s(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
            public ByteString s3() {
                return ((n) this.instance).s3();
            }
        }

        static {
            n nVar = new n();
            h = nVar;
            nVar.makeImmutable();
        }

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = U5().l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.c = GeneratedMessageLite.emptyProtobufList();
        }

        private void T5() {
            if (this.c.isModifiable()) {
                return;
            }
            this.c = GeneratedMessageLite.mutableCopy(this.c);
        }

        public static n U5() {
            return h;
        }

        public static a V5() {
            return h.toBuilder();
        }

        public static Parser<n> W5() {
            return h.getParserForType();
        }

        public static n a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(h, byteString, extensionRegistryLite);
        }

        public static n a(CodedInputStream codedInputStream) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(h, codedInputStream);
        }

        public static n a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(h, codedInputStream, extensionRegistryLite);
        }

        public static n a(InputStream inputStream) throws IOException {
            return (n) GeneratedMessageLite.parseDelimitedFrom(h, inputStream);
        }

        public static n a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseDelimitedFrom(h, inputStream, extensionRegistryLite);
        }

        public static n a(byte[] bArr) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(h, bArr);
        }

        public static n a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(h, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, String str) {
            str.getClass();
            T5();
            this.c.set(i2, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            T5();
            this.c.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<String> iterable) {
            T5();
            AbstractMessageLite.addAll(iterable, this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            T5();
            this.c.add(str);
        }

        public static n b(ByteString byteString) throws InvalidProtocolBufferException {
            return (n) GeneratedMessageLite.parseFrom(h, byteString);
        }

        public static n b(InputStream inputStream) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(h, inputStream);
        }

        public static n b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (n) GeneratedMessageLite.parseFrom(h, inputStream, extensionRegistryLite);
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

        public static a d(n nVar) {
            return h.toBuilder().mergeFrom(nVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            this.d = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public List<String> N1() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public ByteString b(int i2) {
            return ByteString.copyFromUtf8(this.c.get(i2));
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new n();
                case 2:
                    return h;
                case 3:
                    this.c.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    n nVar = (n) obj2;
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !nVar.b.isEmpty(), nVar.b);
                    this.c = visitor.visitList(this.c, nVar.c);
                    int i2 = this.d;
                    boolean z2 = i2 != 0;
                    int i3 = nVar.d;
                    this.d = visitor.visitInt(z2, i2, i3 != 0, i3);
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
                                if (tag == 10) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.c.isModifiable()) {
                                        this.c = GeneratedMessageLite.mutableCopy(this.c);
                                    }
                                    this.c.add(stringRequireUtf8);
                                } else if (tag == 24) {
                                    this.d = codedInputStream.readInt32();
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
                    if (i == null) {
                        synchronized (n.class) {
                            if (i == null) {
                                i = new GeneratedMessageLite.DefaultInstanceBasedParser(h);
                            }
                            break;
                        }
                    }
                    return i;
                default:
                    throw new UnsupportedOperationException();
            }
            return h;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = !this.b.isEmpty() ? CodedOutputStream.computeStringSize(1, l()) + 0 : 0;
            int iComputeStringSizeNoTag = 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                iComputeStringSizeNoTag += CodedOutputStream.computeStringSizeNoTag(this.c.get(i3));
            }
            int size = iComputeStringSize + iComputeStringSizeNoTag + (N1().size() * 1);
            int i4 = this.d;
            if (i4 != 0) {
                size += CodedOutputStream.computeInt32Size(3, i4);
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public int j5() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public String l() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public int p1() {
            return this.c.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public String s(int i2) {
            return this.c.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.o
        public ByteString s3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(1, l());
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                codedOutputStream.writeString(2, this.c.get(i2));
            }
            int i3 = this.d;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
        }
    }

    public interface o extends MessageLiteOrBuilder {
        List<String> N1();

        ByteString b(int i);

        int j5();

        String l();

        int p1();

        String s(int i);

        ByteString s3();
    }

    public static final class p extends GeneratedMessageLite<p, a> implements q {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final p g;
        private static volatile Parser<p> h;
        private String a = "";
        private int b;
        private int c;

        public static final class a extends GeneratedMessageLite.Builder<p, a> implements q {
            private a() {
                super(p.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
            public String C4() {
                return ((p) this.instance).C4();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
            public int I1() {
                return ((p) this.instance).I1();
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

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
            public int T1() {
                return ((p) this.instance).T1();
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((p) this.instance).b(byteString);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((p) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
            public ByteString b5() {
                return ((p) this.instance).b5();
            }

            public a o0(int i) {
                copyOnWrite();
                ((p) this.instance).o0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((p) this.instance).p0(i);
                return this;
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
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.a = T5().C4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.b = 0;
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
        public void a(String str) {
            str.getClass();
            this.a = str;
        }

        public static p b(InputStream inputStream) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static p b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (p) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        public static a d(p pVar) {
            return g.toBuilder().mergeFrom(pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            this.b = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
        public String C4() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
        public int I1() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
        public int T1() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.q
        public ByteString b5() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
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
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !pVar.a.isEmpty(), pVar.a);
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = pVar.b;
                    this.b = visitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.c;
                    boolean z3 = i3 != 0;
                    int i4 = pVar.c;
                    this.c = visitor.visitInt(z3, i3, i4 != 0, i4);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.a = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 16) {
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readInt32();
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
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, C4());
            int i2 = this.b;
            if (i2 != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(2, i2);
            }
            int i3 = this.c;
            if (i3 != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(3, i3);
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, C4());
            }
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.c;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
        }
    }

    public interface q extends MessageLiteOrBuilder {
        String C4();

        int I1();

        int T1();

        ByteString b5();
    }

    public static final class r extends GeneratedMessageLite<r, a> implements s {
        public static final int j = 1;
        public static final int k = 2;
        public static final int l = 3;
        public static final int m = 4;
        public static final int n = 5;
        public static final int o = 6;
        public static final int p = 7;
        public static final int q = 8;
        public static final int r = 9;
        private static final r s;
        private static volatile Parser<r> t;
        private int a;
        private int d;
        private int e;
        private int g;
        private j0 h;
        private int i;
        private String b = "";
        private String c = "";
        private String f = "";

        public static final class a extends GeneratedMessageLite.Builder<r, a> implements s {
            private a() {
                super(r.s);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public int G3() {
                return ((r) this.instance).G3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public LandingType I5() {
                return ((r) this.instance).I5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public ByteString M() {
                return ((r) this.instance).M();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public int M0() {
                return ((r) this.instance).M0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public TriggerStyle N2() {
                return ((r) this.instance).N2();
            }

            public a P5() {
                copyOnWrite();
                ((r) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public j0 Q2() {
                return ((r) this.instance).Q2();
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

            public a S5() {
                copyOnWrite();
                ((r) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((r) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((r) this.instance).V5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public String V2() {
                return ((r) this.instance).V2();
            }

            public a V5() {
                copyOnWrite();
                ((r) this.instance).W5();
                return this;
            }

            public a W5() {
                copyOnWrite();
                ((r) this.instance).X5();
                return this;
            }

            public a X5() {
                copyOnWrite();
                ((r) this.instance).Y5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public ByteString Y3() {
                return ((r) this.instance).Y3();
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((r) this.instance).b(byteString);
                return this;
            }

            public a a(InteractionType interactionType) {
                copyOnWrite();
                ((r) this.instance).a(interactionType);
                return this;
            }

            public a a(LandingType landingType) {
                copyOnWrite();
                ((r) this.instance).a(landingType);
                return this;
            }

            public a a(TriggerStyle triggerStyle) {
                copyOnWrite();
                ((r) this.instance).a(triggerStyle);
                return this;
            }

            public a a(j0.a aVar) {
                copyOnWrite();
                ((r) this.instance).a(aVar);
                return this;
            }

            public a a(j0 j0Var) {
                copyOnWrite();
                ((r) this.instance).a(j0Var);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((r) this.instance).a(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public String a() {
                return ((r) this.instance).a();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public ByteString b() {
                return ((r) this.instance).b();
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((r) this.instance).c(byteString);
                return this;
            }

            public a b(j0 j0Var) {
                copyOnWrite();
                ((r) this.instance).b(j0Var);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((r) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((r) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((r) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public int f2() {
                return ((r) this.instance).f2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public int f3() {
                return ((r) this.instance).f3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public InteractionType getInteractionType() {
                return ((r) this.instance).getInteractionType();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public int i2() {
                return ((r) this.instance).i2();
            }

            public a o0(int i) {
                copyOnWrite();
                ((r) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public String o2() {
                return ((r) this.instance).o2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
            public boolean o4() {
                return ((r) this.instance).o4();
            }

            public a p0(int i) {
                copyOnWrite();
                ((r) this.instance).p0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((r) this.instance).q0(i);
                return this;
            }

            public a r0(int i) {
                copyOnWrite();
                ((r) this.instance).r0(i);
                return this;
            }

            public a s0(int i) {
                copyOnWrite();
                ((r) this.instance).s0(i);
                return this;
            }
        }

        static {
            r rVar = new r();
            s = rVar;
            rVar.makeImmutable();
        }

        private r() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.b = Z5().o2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.f = Z5().a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.e = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.i = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.g = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W5() {
            this.c = Z5().V2();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y5() {
            this.h = null;
        }

        public static r Z5() {
            return s;
        }

        public static r a(ByteString byteString) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(s, byteString);
        }

        public static r a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(s, byteString, extensionRegistryLite);
        }

        public static r a(CodedInputStream codedInputStream) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(s, codedInputStream);
        }

        public static r a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(s, codedInputStream, extensionRegistryLite);
        }

        public static r a(InputStream inputStream) throws IOException {
            return (r) GeneratedMessageLite.parseDelimitedFrom(s, inputStream);
        }

        public static r a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseDelimitedFrom(s, inputStream, extensionRegistryLite);
        }

        public static r a(byte[] bArr) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(s, bArr);
        }

        public static r a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (r) GeneratedMessageLite.parseFrom(s, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(InteractionType interactionType) {
            interactionType.getClass();
            this.a = interactionType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(LandingType landingType) {
            landingType.getClass();
            this.g = landingType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TriggerStyle triggerStyle) {
            triggerStyle.getClass();
            this.d = triggerStyle.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j0.a aVar) {
            this.h = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(j0 j0Var) {
            j0 j0Var2 = this.h;
            if (j0Var2 != null && j0Var2 != j0.U5()) {
                j0Var = j0.e(this.h).mergeFrom(j0Var).buildPartial();
            }
            this.h = j0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.b = str;
        }

        public static a a6() {
            return s.toBuilder();
        }

        public static r b(InputStream inputStream) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(s, inputStream);
        }

        public static r b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (r) GeneratedMessageLite.parseFrom(s, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(j0 j0Var) {
            j0Var.getClass();
            this.h = j0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.f = str;
        }

        public static Parser<r> b6() {
            return s.getParserForType();
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
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        public static a j(r rVar) {
            return s.toBuilder().mergeFrom(rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.e = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i) {
            this.i = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i) {
            this.a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i) {
            this.g = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i) {
            this.d = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public int G3() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public LandingType I5() {
            LandingType landingTypeForNumber = LandingType.forNumber(this.g);
            return landingTypeForNumber == null ? LandingType.UNRECOGNIZED : landingTypeForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public ByteString M() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public int M0() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public TriggerStyle N2() {
            TriggerStyle triggerStyleForNumber = TriggerStyle.forNumber(this.d);
            return triggerStyleForNumber == null ? TriggerStyle.UNRECOGNIZED : triggerStyleForNumber;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public j0 Q2() {
            j0 j0Var = this.h;
            return j0Var == null ? j0.U5() : j0Var;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public String V2() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public ByteString Y3() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public String a() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public ByteString b() {
            return ByteString.copyFromUtf8(this.f);
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new r();
                case 2:
                    return s;
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
                    int i3 = this.d;
                    boolean z3 = i3 != 0;
                    int i4 = rVar.d;
                    this.d = visitor.visitInt(z3, i3, i4 != 0, i4);
                    int i5 = this.e;
                    boolean z4 = i5 != 0;
                    int i6 = rVar.e;
                    this.e = visitor.visitInt(z4, i5, i6 != 0, i6);
                    this.f = visitor.visitString(!this.f.isEmpty(), this.f, !rVar.f.isEmpty(), rVar.f);
                    int i7 = this.g;
                    boolean z5 = i7 != 0;
                    int i8 = rVar.g;
                    this.g = visitor.visitInt(z5, i7, i8 != 0, i8);
                    this.h = (j0) visitor.visitMessage(this.h, rVar.h);
                    int i9 = this.i;
                    boolean z6 = i9 != 0;
                    int i10 = rVar.i;
                    this.i = visitor.visitInt(z6, i9, i10 != 0, i10);
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
                                    this.a = codedInputStream.readEnum();
                                } else if (tag == 18) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 32) {
                                    this.d = codedInputStream.readEnum();
                                } else if (tag == 40) {
                                    this.e = codedInputStream.readInt32();
                                } else if (tag == 50) {
                                    this.f = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 56) {
                                    this.g = codedInputStream.readEnum();
                                } else if (tag == 66) {
                                    j0 j0Var = this.h;
                                    j0.a builder = j0Var != null ? j0Var.toBuilder() : null;
                                    j0 j0Var2 = (j0) codedInputStream.readMessage(j0.W5(), extensionRegistryLite);
                                    this.h = j0Var2;
                                    if (builder != null) {
                                        builder.mergeFrom(j0Var2);
                                        this.h = builder.buildPartial();
                                    }
                                } else if (tag == 72) {
                                    this.i = codedInputStream.readInt32();
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
                    if (t == null) {
                        synchronized (r.class) {
                            if (t == null) {
                                t = new GeneratedMessageLite.DefaultInstanceBasedParser(s);
                            }
                            break;
                        }
                    }
                    return t;
                default:
                    throw new UnsupportedOperationException();
            }
            return s;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public int f2() {
            return this.i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public int f3() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public InteractionType getInteractionType() {
            InteractionType interactionTypeForNumber = InteractionType.forNumber(this.a);
            return interactionTypeForNumber == null ? InteractionType.UNRECOGNIZED : interactionTypeForNumber;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = this.a != InteractionType.InteractionType_unknown.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.a) : 0;
            if (!this.b.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(2, o2());
            }
            if (!this.c.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(3, V2());
            }
            if (this.d != TriggerStyle.TriggerStyle_default.getNumber()) {
                iComputeEnumSize += CodedOutputStream.computeEnumSize(4, this.d);
            }
            int i2 = this.e;
            if (i2 != 0) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(5, i2);
            }
            if (!this.f.isEmpty()) {
                iComputeEnumSize += CodedOutputStream.computeStringSize(6, a());
            }
            if (this.g != LandingType.LandingType_default.getNumber()) {
                iComputeEnumSize += CodedOutputStream.computeEnumSize(7, this.g);
            }
            if (this.h != null) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(8, Q2());
            }
            int i3 = this.i;
            if (i3 != 0) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(9, i3);
            }
            this.memoizedSerializedSize = iComputeEnumSize;
            return iComputeEnumSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public int i2() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public String o2() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.s
        public boolean o4() {
            return this.h != null;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != InteractionType.InteractionType_unknown.getNumber()) {
                codedOutputStream.writeEnum(1, this.a);
            }
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(2, o2());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(3, V2());
            }
            if (this.d != TriggerStyle.TriggerStyle_default.getNumber()) {
                codedOutputStream.writeEnum(4, this.d);
            }
            int i = this.e;
            if (i != 0) {
                codedOutputStream.writeInt32(5, i);
            }
            if (!this.f.isEmpty()) {
                codedOutputStream.writeString(6, a());
            }
            if (this.g != LandingType.LandingType_default.getNumber()) {
                codedOutputStream.writeEnum(7, this.g);
            }
            if (this.h != null) {
                codedOutputStream.writeMessage(8, Q2());
            }
            int i2 = this.i;
            if (i2 != 0) {
                codedOutputStream.writeInt32(9, i2);
            }
        }
    }

    public interface s extends MessageLiteOrBuilder {
        int G3();

        LandingType I5();

        ByteString M();

        int M0();

        TriggerStyle N2();

        j0 Q2();

        String V2();

        ByteString Y3();

        String a();

        ByteString b();

        int f2();

        int f3();

        InteractionType getInteractionType();

        int i2();

        String o2();

        boolean o4();
    }

    public static final class t extends GeneratedMessageLite<t, a> implements u {
        public static final int f = 1;
        public static final int g = 2;
        public static final int h = 3;
        public static final int i = 4;
        public static final int j = 5;
        private static final t k;
        private static volatile Parser<t> l;
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;

        public static final class a extends GeneratedMessageLite.Builder<t, a> implements u {
            private a() {
                super(t.k);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
            public int M1() {
                return ((t) this.instance).M1();
            }

            public a P5() {
                copyOnWrite();
                ((t) this.instance).Q5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
            public int Q0() {
                return ((t) this.instance).Q0();
            }

            public a Q5() {
                copyOnWrite();
                ((t) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((t) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((t) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((t) this.instance).U5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
            public int b2() {
                return ((t) this.instance).b2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
            public int g5() {
                return ((t) this.instance).g5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
            public int h4() {
                return ((t) this.instance).h4();
            }

            public a o0(int i) {
                copyOnWrite();
                ((t) this.instance).o0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((t) this.instance).p0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((t) this.instance).q0(i);
                return this;
            }

            public a r0(int i) {
                copyOnWrite();
                ((t) this.instance).r0(i);
                return this;
            }

            public a s0(int i) {
                copyOnWrite();
                ((t) this.instance).s0(i);
                return this;
            }
        }

        static {
            t tVar = new t();
            k = tVar;
            tVar.makeImmutable();
        }

        private t() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.e = 0;
        }

        public static t V5() {
            return k;
        }

        public static a W5() {
            return k.toBuilder();
        }

        public static Parser<t> X5() {
            return k.getParserForType();
        }

        public static t a(ByteString byteString) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(k, byteString);
        }

        public static t a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(k, byteString, extensionRegistryLite);
        }

        public static t a(CodedInputStream codedInputStream) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(k, codedInputStream);
        }

        public static t a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(k, codedInputStream, extensionRegistryLite);
        }

        public static t a(InputStream inputStream) throws IOException {
            return (t) GeneratedMessageLite.parseDelimitedFrom(k, inputStream);
        }

        public static t a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseDelimitedFrom(k, inputStream, extensionRegistryLite);
        }

        public static t a(byte[] bArr) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(k, bArr);
        }

        public static t a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (t) GeneratedMessageLite.parseFrom(k, bArr, extensionRegistryLite);
        }

        public static t b(InputStream inputStream) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(k, inputStream);
        }

        public static t b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (t) GeneratedMessageLite.parseFrom(k, inputStream, extensionRegistryLite);
        }

        public static a f(t tVar) {
            return k.toBuilder().mergeFrom(tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i2) {
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i2) {
            this.e = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
        public int M1() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
        public int Q0() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
        public int b2() {
            return this.c;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new t();
                case 2:
                    return k;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    t tVar = (t) obj2;
                    int i2 = this.a;
                    boolean z2 = i2 != 0;
                    int i3 = tVar.a;
                    this.a = visitor.visitInt(z2, i2, i3 != 0, i3);
                    int i4 = this.b;
                    boolean z3 = i4 != 0;
                    int i5 = tVar.b;
                    this.b = visitor.visitInt(z3, i4, i5 != 0, i5);
                    int i6 = this.c;
                    boolean z4 = i6 != 0;
                    int i7 = tVar.c;
                    this.c = visitor.visitInt(z4, i6, i7 != 0, i7);
                    int i8 = this.d;
                    boolean z5 = i8 != 0;
                    int i9 = tVar.d;
                    this.d = visitor.visitInt(z5, i8, i9 != 0, i9);
                    int i10 = this.e;
                    boolean z6 = i10 != 0;
                    int i11 = tVar.e;
                    this.e = visitor.visitInt(z6, i10, i11 != 0, i11);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    this.c = codedInputStream.readInt32();
                                } else if (tag == 32) {
                                    this.d = codedInputStream.readInt32();
                                } else if (tag == 40) {
                                    this.e = codedInputStream.readInt32();
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
                        synchronized (t.class) {
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

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
        public int g5() {
            return this.e;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.a;
            int iComputeInt32Size = i3 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i3) : 0;
            int i4 = this.b;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i4);
            }
            int i5 = this.c;
            if (i5 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i5);
            }
            int i6 = this.d;
            if (i6 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, i6);
            }
            int i7 = this.e;
            if (i7 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, i7);
            }
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.u
        public int h4() {
            return this.d;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i2 = this.a;
            if (i2 != 0) {
                codedOutputStream.writeInt32(1, i2);
            }
            int i3 = this.b;
            if (i3 != 0) {
                codedOutputStream.writeInt32(2, i3);
            }
            int i4 = this.c;
            if (i4 != 0) {
                codedOutputStream.writeInt32(3, i4);
            }
            int i5 = this.d;
            if (i5 != 0) {
                codedOutputStream.writeInt32(4, i5);
            }
            int i6 = this.e;
            if (i6 != 0) {
                codedOutputStream.writeInt32(5, i6);
            }
        }
    }

    public interface u extends MessageLiteOrBuilder {
        int M1();

        int Q0();

        int b2();

        int g5();

        int h4();
    }

    public static final class v extends GeneratedMessageLite<v, a> implements w {
        public static final int d = 1;
        public static final int e = 2;
        public static final int f = 3;
        private static final v g;
        private static volatile Parser<v> h;
        private String a = "";
        private int b;
        private p c;

        public static final class a extends GeneratedMessageLite.Builder<v, a> implements w {
            private a() {
                super(v.g);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
            public ByteString C3() {
                return ((v) this.instance).C3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
            public p E1() {
                return ((v) this.instance).E1();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
            public String F2() {
                return ((v) this.instance).F2();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
            public boolean N() {
                return ((v) this.instance).N();
            }

            public a P5() {
                copyOnWrite();
                ((v) this.instance).Q5();
                return this;
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

            public a a(ByteString byteString) {
                copyOnWrite();
                ((v) this.instance).b(byteString);
                return this;
            }

            public a a(p.a aVar) {
                copyOnWrite();
                ((v) this.instance).a(aVar);
                return this;
            }

            public a a(p pVar) {
                copyOnWrite();
                ((v) this.instance).a(pVar);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((v) this.instance).a(str);
                return this;
            }

            public a b(p pVar) {
                copyOnWrite();
                ((v) this.instance).b(pVar);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
            public int n2() {
                return ((v) this.instance).n2();
            }

            public a o0(int i) {
                copyOnWrite();
                ((v) this.instance).o0(i);
                return this;
            }
        }

        static {
            v vVar = new v();
            g = vVar;
            vVar.makeImmutable();
        }

        private v() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.a = T5().F2();
        }

        public static v T5() {
            return g;
        }

        public static a U5() {
            return g.toBuilder();
        }

        public static Parser<v> V5() {
            return g.getParserForType();
        }

        public static v a(ByteString byteString) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(g, byteString);
        }

        public static v a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(g, byteString, extensionRegistryLite);
        }

        public static v a(CodedInputStream codedInputStream) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(g, codedInputStream);
        }

        public static v a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(g, codedInputStream, extensionRegistryLite);
        }

        public static v a(InputStream inputStream) throws IOException {
            return (v) GeneratedMessageLite.parseDelimitedFrom(g, inputStream);
        }

        public static v a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseDelimitedFrom(g, inputStream, extensionRegistryLite);
        }

        public static v a(byte[] bArr) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(g, bArr);
        }

        public static v a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (v) GeneratedMessageLite.parseFrom(g, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p.a aVar) {
            this.c = aVar.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar) {
            p pVar2 = this.c;
            if (pVar2 != null && pVar2 != p.T5()) {
                pVar = p.d(this.c).mergeFrom(pVar).buildPartial();
            }
            this.c = pVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.a = str;
        }

        public static v b(InputStream inputStream) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(g, inputStream);
        }

        public static v b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (v) GeneratedMessageLite.parseFrom(g, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.a = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(p pVar) {
            pVar.getClass();
            this.c = pVar;
        }

        public static a d(v vVar) {
            return g.toBuilder().mergeFrom(vVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i) {
            this.b = i;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
        public ByteString C3() {
            return ByteString.copyFromUtf8(this.a);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
        public p E1() {
            p pVar = this.c;
            return pVar == null ? p.T5() : pVar;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
        public String F2() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
        public boolean N() {
            return this.c != null;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            a aVar = null;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new v();
                case 2:
                    return g;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    v vVar = (v) obj2;
                    this.a = visitor.visitString(!this.a.isEmpty(), this.a, !vVar.a.isEmpty(), vVar.a);
                    int i = this.b;
                    boolean z2 = i != 0;
                    int i2 = vVar.b;
                    this.b = visitor.visitInt(z2, i, i2 != 0, i2);
                    this.c = (p) visitor.visitMessage(this.c, vVar.c);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.a = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 16) {
                                    this.b = codedInputStream.readInt32();
                                } else if (tag == 26) {
                                    p pVar = this.c;
                                    p.a builder = pVar != null ? pVar.toBuilder() : null;
                                    p pVar2 = (p) codedInputStream.readMessage(p.V5(), extensionRegistryLite);
                                    this.c = pVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(pVar2);
                                        this.c = builder.buildPartial();
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
                        synchronized (v.class) {
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
            int iComputeStringSize = this.a.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, F2());
            int i2 = this.b;
            if (i2 != 0) {
                iComputeStringSize += CodedOutputStream.computeInt32Size(2, i2);
            }
            if (this.c != null) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(3, E1());
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.w
        public int n2() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.a.isEmpty()) {
                codedOutputStream.writeString(1, F2());
            }
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (this.c != null) {
                codedOutputStream.writeMessage(3, E1());
            }
        }
    }

    public interface w extends MessageLiteOrBuilder {
        ByteString C3();

        p E1();

        String F2();

        boolean N();

        int n2();
    }

    public static final class x extends GeneratedMessageLite<x, a> implements y {
        public static final int h = 1;
        public static final int i = 2;
        public static final int j = 3;
        public static final int k = 4;
        public static final int l = 5;
        public static final int m = 6;
        private static final x n;
        private static volatile Parser<x> o;
        private int a;
        private int e;
        private String b = "";
        private String c = "";
        private String d = "";
        private Internal.ProtobufList<p> f = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<h0> g = GeneratedMessageLite.emptyProtobufList();

        public static final class a extends GeneratedMessageLite.Builder<x, a> implements y {
            private a() {
                super(x.n);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public p B(int i) {
                return ((x) this.instance).B(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public List<h0> F() {
                return Collections.unmodifiableList(((x) this.instance).F());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public ByteString J3() {
                return ((x) this.instance).J3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public int L0() {
                return ((x) this.instance).L0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public int L5() {
                return ((x) this.instance).L5();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public h0 N(int i) {
                return ((x) this.instance).N(i);
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public ByteString O0() {
                return ((x) this.instance).O0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public MaterialType P0() {
                return ((x) this.instance).P0();
            }

            public a P5() {
                copyOnWrite();
                ((x) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((x) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((x) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((x) this.instance).T5();
                return this;
            }

            public a T5() {
                copyOnWrite();
                ((x) this.instance).U5();
                return this;
            }

            public a U5() {
                copyOnWrite();
                ((x) this.instance).V5();
                return this;
            }

            public a a(int i, h0.a aVar) {
                copyOnWrite();
                ((x) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, h0 h0Var) {
                copyOnWrite();
                ((x) this.instance).a(i, h0Var);
                return this;
            }

            public a a(int i, p.a aVar) {
                copyOnWrite();
                ((x) this.instance).a(i, aVar);
                return this;
            }

            public a a(int i, p pVar) {
                copyOnWrite();
                ((x) this.instance).a(i, pVar);
                return this;
            }

            public a a(ByteString byteString) {
                copyOnWrite();
                ((x) this.instance).b(byteString);
                return this;
            }

            public a a(MaterialType materialType) {
                copyOnWrite();
                ((x) this.instance).a(materialType);
                return this;
            }

            public a a(h0.a aVar) {
                copyOnWrite();
                ((x) this.instance).a(aVar);
                return this;
            }

            public a a(h0 h0Var) {
                copyOnWrite();
                ((x) this.instance).a(h0Var);
                return this;
            }

            public a a(p.a aVar) {
                copyOnWrite();
                ((x) this.instance).a(aVar);
                return this;
            }

            public a a(p pVar) {
                copyOnWrite();
                ((x) this.instance).a(pVar);
                return this;
            }

            public a a(Iterable<? extends p> iterable) {
                copyOnWrite();
                ((x) this.instance).a(iterable);
                return this;
            }

            public a a(String str) {
                copyOnWrite();
                ((x) this.instance).a(str);
                return this;
            }

            public a b(int i, h0.a aVar) {
                copyOnWrite();
                ((x) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, h0 h0Var) {
                copyOnWrite();
                ((x) this.instance).b(i, h0Var);
                return this;
            }

            public a b(int i, p.a aVar) {
                copyOnWrite();
                ((x) this.instance).b(i, aVar);
                return this;
            }

            public a b(int i, p pVar) {
                copyOnWrite();
                ((x) this.instance).b(i, pVar);
                return this;
            }

            public a b(ByteString byteString) {
                copyOnWrite();
                ((x) this.instance).c(byteString);
                return this;
            }

            public a b(Iterable<? extends h0> iterable) {
                copyOnWrite();
                ((x) this.instance).b(iterable);
                return this;
            }

            public a b(String str) {
                copyOnWrite();
                ((x) this.instance).b(str);
                return this;
            }

            public a c(ByteString byteString) {
                copyOnWrite();
                ((x) this.instance).d(byteString);
                return this;
            }

            public a c(String str) {
                copyOnWrite();
                ((x) this.instance).c(str);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public List<p> c5() {
                return Collections.unmodifiableList(((x) this.instance).c5());
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public String getDescription() {
                return ((x) this.instance).getDescription();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public String getTitle() {
                return ((x) this.instance).getTitle();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public String i0() {
                return ((x) this.instance).i0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public ByteString j3() {
                return ((x) this.instance).j3();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
            public int l1() {
                return ((x) this.instance).l1();
            }

            public a o0(int i) {
                copyOnWrite();
                ((x) this.instance).q0(i);
                return this;
            }

            public a p0(int i) {
                copyOnWrite();
                ((x) this.instance).r0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((x) this.instance).s0(i);
                return this;
            }
        }

        static {
            x xVar = new x();
            n = xVar;
            xVar.makeImmutable();
        }

        private x() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.d = Y5().getDescription();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.f = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.e = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.c = Y5().i0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U5() {
            this.b = Y5().getTitle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V5() {
            this.g = GeneratedMessageLite.emptyProtobufList();
        }

        private void W5() {
            if (this.f.isModifiable()) {
                return;
            }
            this.f = GeneratedMessageLite.mutableCopy(this.f);
        }

        private void X5() {
            if (this.g.isModifiable()) {
                return;
            }
            this.g = GeneratedMessageLite.mutableCopy(this.g);
        }

        public static x Y5() {
            return n;
        }

        public static x a(ByteString byteString) throws InvalidProtocolBufferException {
            return (x) GeneratedMessageLite.parseFrom(n, byteString);
        }

        public static x a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (x) GeneratedMessageLite.parseFrom(n, byteString, extensionRegistryLite);
        }

        public static x a(CodedInputStream codedInputStream) throws IOException {
            return (x) GeneratedMessageLite.parseFrom(n, codedInputStream);
        }

        public static x a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (x) GeneratedMessageLite.parseFrom(n, codedInputStream, extensionRegistryLite);
        }

        public static x a(InputStream inputStream) throws IOException {
            return (x) GeneratedMessageLite.parseDelimitedFrom(n, inputStream);
        }

        public static x a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (x) GeneratedMessageLite.parseDelimitedFrom(n, inputStream, extensionRegistryLite);
        }

        public static x a(byte[] bArr) throws InvalidProtocolBufferException {
            return (x) GeneratedMessageLite.parseFrom(n, bArr);
        }

        public static x a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (x) GeneratedMessageLite.parseFrom(n, bArr, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, h0.a aVar) {
            X5();
            this.g.add(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, h0 h0Var) {
            h0Var.getClass();
            X5();
            this.g.add(i2, h0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, p.a aVar) {
            W5();
            this.f.add(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2, p pVar) {
            pVar.getClass();
            W5();
            this.f.add(i2, pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MaterialType materialType) {
            materialType.getClass();
            this.e = materialType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h0.a aVar) {
            X5();
            this.g.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h0 h0Var) {
            h0Var.getClass();
            X5();
            this.g.add(h0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p.a aVar) {
            W5();
            this.f.add(aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(p pVar) {
            pVar.getClass();
            W5();
            this.f.add(pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Iterable<? extends p> iterable) {
            W5();
            AbstractMessageLite.addAll(iterable, this.f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            str.getClass();
            this.d = str;
        }

        public static x b(InputStream inputStream) throws IOException {
            return (x) GeneratedMessageLite.parseFrom(n, inputStream);
        }

        public static x b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (x) GeneratedMessageLite.parseFrom(n, inputStream, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, h0.a aVar) {
            X5();
            this.g.set(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, h0 h0Var) {
            h0Var.getClass();
            X5();
            this.g.set(i2, h0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, p.a aVar) {
            W5();
            this.f.set(i2, aVar.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i2, p pVar) {
            pVar.getClass();
            W5();
            this.f.set(i2, pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.d = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Iterable<? extends h0> iterable) {
            X5();
            AbstractMessageLite.addAll(iterable, this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            str.getClass();
            this.c = str;
        }

        public static a b6() {
            return n.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.c = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            str.getClass();
            this.b = str;
        }

        public static Parser<x> c6() {
            return n.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(ByteString byteString) {
            byteString.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.b = byteString.toStringUtf8();
        }

        public static a g(x xVar) {
            return n.toBuilder().mergeFrom(xVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            W5();
            this.f.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i2) {
            X5();
            this.g.remove(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i2) {
            this.e = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public p B(int i2) {
            return this.f.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public List<h0> F() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public ByteString J3() {
            return ByteString.copyFromUtf8(this.c);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public int L0() {
            return this.g.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public int L5() {
            return this.f.size();
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public h0 N(int i2) {
            return this.g.get(i2);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public ByteString O0() {
            return ByteString.copyFromUtf8(this.d);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public MaterialType P0() {
            MaterialType materialTypeForNumber = MaterialType.forNumber(this.e);
            return materialTypeForNumber == null ? MaterialType.UNRECOGNIZED : materialTypeForNumber;
        }

        public List<? extends q> Z5() {
            return this.f;
        }

        public List<? extends i0> a6() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public List<p> c5() {
            return this.f;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            Object objV5;
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new x();
                case 2:
                    return n;
                case 3:
                    this.f.makeImmutable();
                    this.g.makeImmutable();
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    x xVar = (x) obj2;
                    this.b = visitor.visitString(!this.b.isEmpty(), this.b, !xVar.b.isEmpty(), xVar.b);
                    this.c = visitor.visitString(!this.c.isEmpty(), this.c, !xVar.c.isEmpty(), xVar.c);
                    this.d = visitor.visitString(!this.d.isEmpty(), this.d, !xVar.d.isEmpty(), xVar.d);
                    int i2 = this.e;
                    boolean z2 = i2 != 0;
                    int i3 = xVar.e;
                    this.e = visitor.visitInt(z2, i2, i3 != 0, i3);
                    this.f = visitor.visitList(this.f, xVar.f);
                    this.g = visitor.visitList(this.g, xVar.g);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= xVar.a;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    this.b = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 18) {
                                    this.c = codedInputStream.readStringRequireUtf8();
                                } else if (tag == 26) {
                                    this.d = codedInputStream.readStringRequireUtf8();
                                } else if (tag != 32) {
                                    if (tag == 42) {
                                        if (!this.f.isModifiable()) {
                                            this.f = GeneratedMessageLite.mutableCopy(this.f);
                                        }
                                        list = this.f;
                                        objV5 = p.V5();
                                    } else if (tag == 50) {
                                        if (!this.g.isModifiable()) {
                                            this.g = GeneratedMessageLite.mutableCopy(this.g);
                                        }
                                        list = this.g;
                                        objV5 = h0.Y5();
                                    } else if (!codedInputStream.skipField(tag)) {
                                    }
                                    list.add(codedInputStream.readMessage((Parser) objV5, extensionRegistryLite));
                                } else {
                                    this.e = codedInputStream.readEnum();
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
                    if (o == null) {
                        synchronized (x.class) {
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

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public String getDescription() {
            return this.d;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int iComputeStringSize = !this.b.isEmpty() ? CodedOutputStream.computeStringSize(1, getTitle()) + 0 : 0;
            if (!this.c.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(2, i0());
            }
            if (!this.d.isEmpty()) {
                iComputeStringSize += CodedOutputStream.computeStringSize(3, getDescription());
            }
            if (this.e != MaterialType.MaterialType_unknown.getNumber()) {
                iComputeStringSize += CodedOutputStream.computeEnumSize(4, this.e);
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(5, this.f.get(i3));
            }
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(6, this.g.get(i4));
            }
            this.memoizedSerializedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public String getTitle() {
            return this.b;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public String i0() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public ByteString j3() {
            return ByteString.copyFromUtf8(this.b);
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.y
        public int l1() {
            return this.e;
        }

        public q o0(int i2) {
            return this.f.get(i2);
        }

        public i0 p0(int i2) {
            return this.g.get(i2);
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.b.isEmpty()) {
                codedOutputStream.writeString(1, getTitle());
            }
            if (!this.c.isEmpty()) {
                codedOutputStream.writeString(2, i0());
            }
            if (!this.d.isEmpty()) {
                codedOutputStream.writeString(3, getDescription());
            }
            if (this.e != MaterialType.MaterialType_unknown.getNumber()) {
                codedOutputStream.writeEnum(4, this.e);
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                codedOutputStream.writeMessage(5, this.f.get(i2));
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                codedOutputStream.writeMessage(6, this.g.get(i3));
            }
        }
    }

    public interface y extends MessageLiteOrBuilder {
        p B(int i);

        List<h0> F();

        ByteString J3();

        int L0();

        int L5();

        h0 N(int i);

        ByteString O0();

        MaterialType P0();

        List<p> c5();

        String getDescription();

        String getTitle();

        String i0();

        ByteString j3();

        int l1();
    }

    public static final class z extends GeneratedMessageLite<z, a> implements a0 {
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public static final int h = 4;
        private static final z i;
        private static volatile Parser<z> j;
        private int a;
        private int b;
        private int c;
        private int d;

        public static final class a extends GeneratedMessageLite.Builder<z, a> implements a0 {
            private a() {
                super(z.i);
            }

            /* synthetic */ a(a aVar) {
                this();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
            public int F0() {
                return ((z) this.instance).F0();
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
            public int H2() {
                return ((z) this.instance).H2();
            }

            public a P5() {
                copyOnWrite();
                ((z) this.instance).Q5();
                return this;
            }

            public a Q5() {
                copyOnWrite();
                ((z) this.instance).R5();
                return this;
            }

            public a R5() {
                copyOnWrite();
                ((z) this.instance).S5();
                return this;
            }

            public a S5() {
                copyOnWrite();
                ((z) this.instance).T5();
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
            public int h0() {
                return ((z) this.instance).h0();
            }

            public a o0(int i) {
                copyOnWrite();
                ((z) this.instance).o0(i);
                return this;
            }

            @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
            public int o1() {
                return ((z) this.instance).o1();
            }

            public a p0(int i) {
                copyOnWrite();
                ((z) this.instance).p0(i);
                return this;
            }

            public a q0(int i) {
                copyOnWrite();
                ((z) this.instance).q0(i);
                return this;
            }

            public a r0(int i) {
                copyOnWrite();
                ((z) this.instance).r0(i);
                return this;
            }
        }

        static {
            z zVar = new z();
            i = zVar;
            zVar.makeImmutable();
        }

        private z() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q5() {
            this.c = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R5() {
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S5() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T5() {
            this.a = 0;
        }

        public static z U5() {
            return i;
        }

        public static a V5() {
            return i.toBuilder();
        }

        public static Parser<z> W5() {
            return i.getParserForType();
        }

        public static z a(ByteString byteString) throws InvalidProtocolBufferException {
            return (z) GeneratedMessageLite.parseFrom(i, byteString);
        }

        public static z a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (z) GeneratedMessageLite.parseFrom(i, byteString, extensionRegistryLite);
        }

        public static z a(CodedInputStream codedInputStream) throws IOException {
            return (z) GeneratedMessageLite.parseFrom(i, codedInputStream);
        }

        public static z a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (z) GeneratedMessageLite.parseFrom(i, codedInputStream, extensionRegistryLite);
        }

        public static z a(InputStream inputStream) throws IOException {
            return (z) GeneratedMessageLite.parseDelimitedFrom(i, inputStream);
        }

        public static z a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (z) GeneratedMessageLite.parseDelimitedFrom(i, inputStream, extensionRegistryLite);
        }

        public static z a(byte[] bArr) throws InvalidProtocolBufferException {
            return (z) GeneratedMessageLite.parseFrom(i, bArr);
        }

        public static z a(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (z) GeneratedMessageLite.parseFrom(i, bArr, extensionRegistryLite);
        }

        public static z b(InputStream inputStream) throws IOException {
            return (z) GeneratedMessageLite.parseFrom(i, inputStream);
        }

        public static z b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (z) GeneratedMessageLite.parseFrom(i, inputStream, extensionRegistryLite);
        }

        public static a e(z zVar) {
            return i.toBuilder().mergeFrom(zVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(int i2) {
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i2) {
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i2) {
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i2) {
            this.a = i2;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
        public int F0() {
            return this.d;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
        public int H2() {
            return this.b;
        }

        @Override // com.tapadn.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            a aVar = null;
            boolean z = false;
            switch (a.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new z();
                case 2:
                    return i;
                case 3:
                    return null;
                case 4:
                    return new a(aVar);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    z zVar = (z) obj2;
                    int i2 = this.a;
                    boolean z2 = i2 != 0;
                    int i3 = zVar.a;
                    this.a = visitor.visitInt(z2, i2, i3 != 0, i3);
                    int i4 = this.b;
                    boolean z3 = i4 != 0;
                    int i5 = zVar.b;
                    this.b = visitor.visitInt(z3, i4, i5 != 0, i5);
                    int i6 = this.c;
                    boolean z4 = i6 != 0;
                    int i7 = zVar.c;
                    this.c = visitor.visitInt(z4, i6, i7 != 0, i7);
                    int i8 = this.d;
                    boolean z5 = i8 != 0;
                    int i9 = zVar.d;
                    this.d = visitor.visitInt(z5, i8, i9 != 0, i9);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            try {
                                int tag = codedInputStream.readTag();
                                if (tag != 0) {
                                    if (tag == 8) {
                                        this.a = codedInputStream.readInt32();
                                    } else if (tag == 16) {
                                        this.b = codedInputStream.readInt32();
                                    } else if (tag == 24) {
                                        this.c = codedInputStream.readInt32();
                                    } else if (tag == 32) {
                                        this.d = codedInputStream.readInt32();
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
                        synchronized (z.class) {
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

        @Override // com.tapadn.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.a;
            int iComputeInt32Size = i3 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i3) : 0;
            int i4 = this.b;
            if (i4 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, i4);
            }
            int i5 = this.c;
            if (i5 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, i5);
            }
            int i6 = this.d;
            if (i6 != 0) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(4, i6);
            }
            this.memoizedSerializedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
        public int h0() {
            return this.a;
        }

        @Override // com.tapsdk.tapad.model.entities.TapAdResp.a0
        public int o1() {
            return this.c;
        }

        @Override // com.tapadn.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i2 = this.a;
            if (i2 != 0) {
                codedOutputStream.writeInt32(1, i2);
            }
            int i3 = this.b;
            if (i3 != 0) {
                codedOutputStream.writeInt32(2, i3);
            }
            int i4 = this.c;
            if (i4 != 0) {
                codedOutputStream.writeInt32(3, i4);
            }
            int i5 = this.d;
            if (i5 != 0) {
                codedOutputStream.writeInt32(4, i5);
            }
        }
    }

    private TapAdResp() {
    }

    public static void a(ExtensionRegistryLite extensionRegistryLite) {
    }
}
