package com.taptap.sdk.db.properties;

import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.db.TapDB;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.servicemanager.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsyncPredefinedProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0086@¢\u0006\u0002\u0010\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/db/properties/AsyncPredefinedProvider;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "gidService", "Lcom/taptap/sdk/common/services/GidService;", "provide", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AsyncPredefinedProvider {
    private static final String TAG = "AsyncPredefinedProvider";
    private final GidService gidService;
    private final TapTapSdkOptions options;

    /* JADX INFO: compiled from: AsyncPredefinedProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.properties.AsyncPredefinedProvider$provide$1, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncPredefinedProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.properties.AsyncPredefinedProvider", f = "AsyncPredefinedProvider.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 5}, l = {28, 30, 32, 34, 38, 44}, m = "provide", n = {"this", Common.Predefined.PROPERTIES, "this", Common.Predefined.PROPERTIES, "this", Common.Predefined.PROPERTIES, "this", Common.Predefined.PROPERTIES, Common.Predefined.PROPERTIES, Common.Predefined.PROPERTIES}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AsyncPredefinedProvider.this.provide(this);
        }
    }

    public AsyncPredefinedProvider(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        this.gidService = (GidService) ServiceManager.INSTANCE.getService(GidService.class);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:35:0x0102  */
    /* JADX WARN: Code duplicated, block: B:37:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0118  */
    /* JADX WARN: Code duplicated, block: B:42:0x013a  */
    /* JADX WARN: Code duplicated, block: B:44:0x014b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x014f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0173  */
    /* JADX WARN: Code duplicated, block: B:51:0x0179  */
    /* JADX WARN: Code duplicated, block: B:53:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0191  */
    /* JADX WARN: Code duplicated, block: B:56:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object provide(Continuation<? super Map<String, ? extends Object>> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        AsyncPredefinedProvider asyncPredefinedProvider;
        HashMap properties;
        String str;
        Object gid;
        AsyncPredefinedProvider asyncPredefinedProvider2;
        HashMap map;
        String str2;
        GidService gidService;
        String str3;
        Object gid2;
        HashMap properties2;
        String str4;
        GidService gidService2;
        HashMap properties3;
        String str5;
        Object tdid;
        HashMap map2;
        String str6;
        GidService gidService3;
        String str7;
        Object tdid2;
        HashMap map3;
        Object oaid;
        Map map4;
        HashMap properties4;
        Object gaid;
        Pair pair;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                asyncPredefinedProvider = this;
                properties = new HashMap();
                GidService gidService4 = asyncPredefinedProvider.gidService;
                if (gidService4 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.label = 1;
                    gid = gidService4.getGid(anonymousClass2);
                    if (gid == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = (String) gid;
                } else {
                    str = null;
                }
                asyncPredefinedProvider2 = asyncPredefinedProvider;
                String gid3 = str;
                TapLogger.logi(TAG, "GID: " + gid3);
                map = properties;
                str2 = Common.Predefined.GID;
                gidService = asyncPredefinedProvider2.gidService;
                if (gidService != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.L$2 = map;
                    anonymousClass2.L$3 = Common.Predefined.GID;
                    anonymousClass2.label = 2;
                    gid2 = gidService.getGid(anonymousClass2);
                    if (gid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    properties2 = properties;
                    str4 = Common.Predefined.GID;
                    str3 = (String) gid2;
                    HashMap map5 = properties2;
                    str2 = str4;
                    properties = map5;
                } else {
                    str3 = null;
                }
                Pair pair2 = TuplesKt.to(str2, str3);
                map.put(pair2.getFirst(), pair2.getSecond());
                gidService2 = asyncPredefinedProvider2.gidService;
                if (gidService2 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.L$2 = null;
                    anonymousClass2.L$3 = null;
                    anonymousClass2.label = 3;
                    tdid = gidService2.getTdid(anonymousClass2);
                    if (tdid == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = (String) tdid;
                    properties3 = properties;
                } else {
                    properties3 = properties;
                    str5 = null;
                }
                String tdid3 = str5;
                TapLogger.logi(TAG, "TDID: " + tdid3);
                map2 = properties3;
                str6 = Common.Predefined.TDID;
                gidService3 = asyncPredefinedProvider2.gidService;
                if (gidService3 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties3;
                    anonymousClass2.L$2 = map2;
                    anonymousClass2.L$3 = Common.Predefined.TDID;
                    anonymousClass2.label = 4;
                    tdid2 = gidService3.getTdid(anonymousClass2);
                    if (tdid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str7 = (String) tdid2;
                } else {
                    str7 = null;
                }
                Pair pair3 = TuplesKt.to(str6, str7);
                map2.put(pair3.getFirst(), pair3.getSecond());
                map3 = properties3;
                switch (WhenMappings.$EnumSwitchMapping$0[asyncPredefinedProvider2.options.getRegion().ordinal()]) {
                    case 1:
                        TapDB companion = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 5;
                        oaid = companion.getOAID(anonymousClass2);
                        if (oaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String oaid2 = (String) oaid;
                        TapLogger.logi(TAG, "oaid: " + oaid2);
                        pair = TuplesKt.to("oaid", oaid2);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    case 2:
                        TapDB companion2 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 6;
                        gaid = companion2.getGAID(anonymousClass2);
                        if (gaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String gaid2 = (String) gaid;
                        TapLogger.logi(TAG, "gaid: " + gaid2);
                        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid2);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 1:
                properties = (HashMap) anonymousClass2.L$1;
                asyncPredefinedProvider = (AsyncPredefinedProvider) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                gid = $result;
                str = (String) gid;
                asyncPredefinedProvider2 = asyncPredefinedProvider;
                String gid4 = str;
                TapLogger.logi(TAG, "GID: " + gid4);
                map = properties;
                str2 = Common.Predefined.GID;
                gidService = asyncPredefinedProvider2.gidService;
                if (gidService != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.L$2 = map;
                    anonymousClass2.L$3 = Common.Predefined.GID;
                    anonymousClass2.label = 2;
                    gid2 = gidService.getGid(anonymousClass2);
                    if (gid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    properties2 = properties;
                    str4 = Common.Predefined.GID;
                    str3 = (String) gid2;
                    HashMap map6 = properties2;
                    str2 = str4;
                    properties = map6;
                } else {
                    str3 = null;
                }
                Pair pair4 = TuplesKt.to(str2, str3);
                map.put(pair4.getFirst(), pair4.getSecond());
                gidService2 = asyncPredefinedProvider2.gidService;
                if (gidService2 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.L$2 = null;
                    anonymousClass2.L$3 = null;
                    anonymousClass2.label = 3;
                    tdid = gidService2.getTdid(anonymousClass2);
                    if (tdid == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = (String) tdid;
                    properties3 = properties;
                } else {
                    properties3 = properties;
                    str5 = null;
                }
                String tdid4 = str5;
                TapLogger.logi(TAG, "TDID: " + tdid4);
                map2 = properties3;
                str6 = Common.Predefined.TDID;
                gidService3 = asyncPredefinedProvider2.gidService;
                if (gidService3 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties3;
                    anonymousClass2.L$2 = map2;
                    anonymousClass2.L$3 = Common.Predefined.TDID;
                    anonymousClass2.label = 4;
                    tdid2 = gidService3.getTdid(anonymousClass2);
                    if (tdid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str7 = (String) tdid2;
                } else {
                    str7 = null;
                }
                Pair pair5 = TuplesKt.to(str6, str7);
                map2.put(pair5.getFirst(), pair5.getSecond());
                map3 = properties3;
                switch (WhenMappings.$EnumSwitchMapping$0[asyncPredefinedProvider2.options.getRegion().ordinal()]) {
                    case 1:
                        TapDB companion3 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 5;
                        oaid = companion3.getOAID(anonymousClass2);
                        if (oaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String oaid3 = (String) oaid;
                        TapLogger.logi(TAG, "oaid: " + oaid3);
                        pair = TuplesKt.to("oaid", oaid3);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    case 2:
                        TapDB companion4 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 6;
                        gaid = companion4.getGAID(anonymousClass2);
                        if (gaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String gaid3 = (String) gaid;
                        TapLogger.logi(TAG, "gaid: " + gaid3);
                        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid3);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 2:
                str4 = (String) anonymousClass2.L$3;
                map = (Map) anonymousClass2.L$2;
                properties2 = (HashMap) anonymousClass2.L$1;
                asyncPredefinedProvider2 = (AsyncPredefinedProvider) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                gid2 = $result;
                str3 = (String) gid2;
                HashMap map7 = properties2;
                str2 = str4;
                properties = map7;
                Pair pair6 = TuplesKt.to(str2, str3);
                map.put(pair6.getFirst(), pair6.getSecond());
                gidService2 = asyncPredefinedProvider2.gidService;
                if (gidService2 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties;
                    anonymousClass2.L$2 = null;
                    anonymousClass2.L$3 = null;
                    anonymousClass2.label = 3;
                    tdid = gidService2.getTdid(anonymousClass2);
                    if (tdid == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = (String) tdid;
                    properties3 = properties;
                } else {
                    properties3 = properties;
                    str5 = null;
                }
                String tdid5 = str5;
                TapLogger.logi(TAG, "TDID: " + tdid5);
                map2 = properties3;
                str6 = Common.Predefined.TDID;
                gidService3 = asyncPredefinedProvider2.gidService;
                if (gidService3 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties3;
                    anonymousClass2.L$2 = map2;
                    anonymousClass2.L$3 = Common.Predefined.TDID;
                    anonymousClass2.label = 4;
                    tdid2 = gidService3.getTdid(anonymousClass2);
                    if (tdid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str7 = (String) tdid2;
                } else {
                    str7 = null;
                }
                Pair pair7 = TuplesKt.to(str6, str7);
                map2.put(pair7.getFirst(), pair7.getSecond());
                map3 = properties3;
                switch (WhenMappings.$EnumSwitchMapping$0[asyncPredefinedProvider2.options.getRegion().ordinal()]) {
                    case 1:
                        TapDB companion5 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 5;
                        oaid = companion5.getOAID(anonymousClass2);
                        if (oaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String oaid4 = (String) oaid;
                        TapLogger.logi(TAG, "oaid: " + oaid4);
                        pair = TuplesKt.to("oaid", oaid4);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    case 2:
                        TapDB companion6 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 6;
                        gaid = companion6.getGAID(anonymousClass2);
                        if (gaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String gaid4 = (String) gaid;
                        TapLogger.logi(TAG, "gaid: " + gaid4);
                        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid4);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 3:
                properties = (HashMap) anonymousClass2.L$1;
                AsyncPredefinedProvider asyncPredefinedProvider3 = (AsyncPredefinedProvider) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                asyncPredefinedProvider2 = asyncPredefinedProvider3;
                tdid = $result;
                str5 = (String) tdid;
                properties3 = properties;
                String tdid6 = str5;
                TapLogger.logi(TAG, "TDID: " + tdid6);
                map2 = properties3;
                str6 = Common.Predefined.TDID;
                gidService3 = asyncPredefinedProvider2.gidService;
                if (gidService3 != null) {
                    anonymousClass2.L$0 = asyncPredefinedProvider2;
                    anonymousClass2.L$1 = properties3;
                    anonymousClass2.L$2 = map2;
                    anonymousClass2.L$3 = Common.Predefined.TDID;
                    anonymousClass2.label = 4;
                    tdid2 = gidService3.getTdid(anonymousClass2);
                    if (tdid2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str7 = (String) tdid2;
                } else {
                    str7 = null;
                }
                Pair pair8 = TuplesKt.to(str6, str7);
                map2.put(pair8.getFirst(), pair8.getSecond());
                map3 = properties3;
                switch (WhenMappings.$EnumSwitchMapping$0[asyncPredefinedProvider2.options.getRegion().ordinal()]) {
                    case 1:
                        TapDB companion7 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 5;
                        oaid = companion7.getOAID(anonymousClass2);
                        if (oaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String oaid5 = (String) oaid;
                        TapLogger.logi(TAG, "oaid: " + oaid5);
                        pair = TuplesKt.to("oaid", oaid5);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    case 2:
                        TapDB companion8 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 6;
                        gaid = companion8.getGAID(anonymousClass2);
                        if (gaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String gaid5 = (String) gaid;
                        TapLogger.logi(TAG, "gaid: " + gaid5);
                        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid5);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 4:
                str6 = (String) anonymousClass2.L$3;
                map2 = (Map) anonymousClass2.L$2;
                properties3 = (HashMap) anonymousClass2.L$1;
                asyncPredefinedProvider2 = (AsyncPredefinedProvider) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                tdid2 = $result;
                str7 = (String) tdid2;
                Pair pair9 = TuplesKt.to(str6, str7);
                map2.put(pair9.getFirst(), pair9.getSecond());
                map3 = properties3;
                switch (WhenMappings.$EnumSwitchMapping$0[asyncPredefinedProvider2.options.getRegion().ordinal()]) {
                    case 1:
                        TapDB companion9 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 5;
                        oaid = companion9.getOAID(anonymousClass2);
                        if (oaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String oaid6 = (String) oaid;
                        TapLogger.logi(TAG, "oaid: " + oaid6);
                        pair = TuplesKt.to("oaid", oaid6);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    case 2:
                        TapDB companion10 = TapDB.INSTANCE.getInstance();
                        anonymousClass2.L$0 = properties3;
                        anonymousClass2.L$1 = map3;
                        anonymousClass2.L$2 = null;
                        anonymousClass2.L$3 = null;
                        anonymousClass2.label = 6;
                        gaid = companion10.getGAID(anonymousClass2);
                        if (gaid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map4 = map3;
                        properties4 = properties3;
                        String gaid6 = (String) gaid;
                        TapLogger.logi(TAG, "gaid: " + gaid6);
                        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid6);
                        map4.put(pair.getFirst(), pair.getSecond());
                        return properties4;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 5:
                map4 = (Map) anonymousClass2.L$1;
                properties4 = (HashMap) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                oaid = $result;
                String oaid7 = (String) oaid;
                TapLogger.logi(TAG, "oaid: " + oaid7);
                pair = TuplesKt.to("oaid", oaid7);
                map4.put(pair.getFirst(), pair.getSecond());
                return properties4;
            case 6:
                map4 = (Map) anonymousClass2.L$1;
                properties4 = (HashMap) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                gaid = $result;
                String gaid7 = (String) gaid;
                TapLogger.logi(TAG, "gaid: " + gaid7);
                pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, gaid7);
                map4.put(pair.getFirst(), pair.getSecond());
                return properties4;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
