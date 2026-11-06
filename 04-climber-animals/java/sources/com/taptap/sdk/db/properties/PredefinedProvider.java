package com.taptap.sdk.db.properties;

import android.os.Build;
import android.util.Log;
import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.db.EventContext;
import com.taptap.sdk.db.TapDB;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.kit.internal.utils.OSUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PredefinedProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/db/properties/PredefinedProvider;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "gidService", "Lcom/taptap/sdk/common/services/GidService;", "provide", "", "", "eventContext", "Lcom/taptap/sdk/db/EventContext;", "isAutomatically", "", "(Lcom/taptap/sdk/db/EventContext;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PredefinedProvider {
    private final GidService gidService;
    private final TapTapSdkOptions options;

    /* JADX INFO: compiled from: PredefinedProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.properties.PredefinedProvider$provide$1, reason: invalid class name */
    /* JADX INFO: compiled from: PredefinedProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.properties.PredefinedProvider", f = "PredefinedProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {93, 95, 99, 105}, m = "provide", n = {"this", "eventContext", Common.Predefined.PROPERTIES, "isAutomatically", "this", "eventContext", Common.Predefined.PROPERTIES, "isAutomatically", "this", "eventContext", Common.Predefined.PROPERTIES, "isAutomatically", "this", "eventContext", Common.Predefined.PROPERTIES, "isAutomatically"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PredefinedProvider.this.provide(null, false, this);
        }
    }

    public PredefinedProvider(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        this.gidService = (GidService) ServiceManager.INSTANCE.getService(GidService.class);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0399  */
    /* JADX WARN: Code duplicated, block: B:40:0x03ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:43:0x03be  */
    /* JADX WARN: Code duplicated, block: B:46:0x03e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:49:0x0400 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0401  */
    /* JADX WARN: Code duplicated, block: B:52:0x0421  */
    /* JADX WARN: Code duplicated, block: B:54:0x0427  */
    /* JADX WARN: Code duplicated, block: B:56:0x0442 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0443  */
    /* JADX WARN: Code duplicated, block: B:61:0x0506  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object provide(EventContext eventContext, boolean z, Continuation<? super Map<String, ? extends Object>> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        HashMap map;
        HashMap map2;
        String gameVersion;
        String str;
        PredefinedProvider predefinedProvider;
        String str2;
        EventContext eventContext2;
        boolean z2;
        HashMap map3;
        GidService gidService;
        String str3;
        EventContext eventContext3;
        HashMap map4;
        Map map5;
        String str4;
        Object tdid;
        PredefinedProvider predefinedProvider2;
        EventContext eventContext4;
        HashMap map6;
        int i;
        Object oaid;
        boolean z3;
        HashMap map7;
        Map map8;
        PredefinedProvider predefinedProvider3;
        Object gaid;
        Pair pair;
        HashMap map9;
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
        Object gid = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(gid);
            map = new HashMap();
            map2 = map;
            Pair pair2 = TuplesKt.to("os", "Android");
            map2.put(pair2.getFirst(), pair2.getSecond());
            Pair pair3 = TuplesKt.to("dv", DeviceUtils.getDeviceBrand());
            map2.put(pair3.getFirst(), pair3.getSecond());
            Pair pair4 = TuplesKt.to("md", DeviceUtils.getDeviceModel());
            map2.put(pair4.getFirst(), pair4.getSecond());
            Pair pair5 = TuplesKt.to(Common.Predefined.SUB_INSTALL_UUID, TapIdentifierUtil.INSTANCE.getInstallUUID());
            map2.put(pair5.getFirst(), pair5.getSecond());
            int[] deviceSize = DeviceUtils.getDeviceSize(this.options.getContext());
            Pair pair6 = TuplesKt.to("width", Boxing.boxInt(deviceSize[0]));
            map2.put(pair6.getFirst(), pair6.getSecond());
            Pair pair7 = TuplesKt.to("height", Boxing.boxInt(deviceSize[1]));
            map2.put(pair7.getFirst(), pair7.getSecond());
            Pair pair8 = TuplesKt.to("sv", DeviceUtils.getOS());
            map2.put(pair8.getFirst(), pair8.getSecond());
            Pair pair9 = TuplesKt.to("provider", DeviceUtils.getCarrier(this.options.getContext()));
            map2.put(pair9.getFirst(), pair9.getSecond());
            String gameVersion2 = this.options.getGameVersion();
            if (gameVersion2 == null || gameVersion2.length() == 0) {
                gameVersion = DeviceUtils.getPackageVersion(this.options.getContext());
            } else {
                gameVersion = this.options.getGameVersion();
            }
            Pair pair10 = TuplesKt.to("app_version", gameVersion);
            map2.put(pair10.getFirst(), pair10.getSecond());
            Pair pair11 = TuplesKt.to("sdk_version", "4.8.1-beta.7");
            map2.put(pair11.getFirst(), pair11.getSecond());
            Pair pair12 = TuplesKt.to("network_type", NetworkUtil.getConnectedType(this.options.getContext()));
            map2.put(pair12.getFirst(), pair12.getSecond());
            Pair pair13 = TuplesKt.to("mobile_type", NetworkUtil.getNetworkType(this.options.getContext()));
            map2.put(pair13.getFirst(), pair13.getSecond());
            Pair pair14 = TuplesKt.to("cpu", DeviceUtils.getCPUAbi());
            map2.put(pair14.getFirst(), pair14.getSecond());
            Pair pair15 = TuplesKt.to("rom", Boxing.boxLong(DeviceUtils.getRemainingRomSize()));
            map2.put(pair15.getFirst(), pair15.getSecond());
            Pair pair16 = TuplesKt.to("ram", Boxing.boxLong(DeviceUtils.getRemainingRamSize(this.options.getContext())));
            map2.put(pair16.getFirst(), pair16.getSecond());
            Pair pair17 = TuplesKt.to(Common.Predefined.SUB_TOTAL_ROM, Boxing.boxLong(DeviceUtils.getDeviceTotalRom(this.options.getContext())));
            map2.put(pair17.getFirst(), pair17.getSecond());
            Pair pair18 = TuplesKt.to(Common.Predefined.SUB_TOTAL_RAM, Boxing.boxLong(DeviceUtils.getDeviceTotalRam(this.options.getContext())));
            map2.put(pair18.getFirst(), pair18.getSecond());
            Pair pair19 = TuplesKt.to(Common.Predefined.SUB_HARDWARE, DeviceUtils.getCPUHardware());
            map2.put(pair19.getFirst(), pair19.getSecond());
            Pair pair20 = TuplesKt.to(Common.Predefined.SUB_LANG_SYSTEM, Locale.getDefault().getLanguage());
            map2.put(pair20.getFirst(), pair20.getSecond());
            Pair pair21 = TuplesKt.to(Common.Predefined.SUB_OS_TYPE, DeviceUtils.getOSType());
            map2.put(pair21.getFirst(), pair21.getSecond());
            Pair pair22 = TuplesKt.to(Common.Predefined.SUB_MOS, OSUtil.getCustomOS(Build.BRAND));
            map2.put(pair22.getFirst(), pair22.getSecond());
            Pair pair23 = TuplesKt.to(Common.Predefined.SUB_MOSV, OSUtil.getCustomOSVersion(Build.BRAND));
            map2.put(pair23.getFirst(), pair23.getSecond());
            Pair pair24 = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID5, TapIdentifierUtil.INSTANCE.getUniqueDeviceId(this.options.getContext()));
            map2.put(pair24.getFirst(), pair24.getSecond());
            Pair pair25 = TuplesKt.to("channel", this.options.getChannel());
            map2.put(pair25.getFirst(), pair25.getSecond());
            Pair pair26 = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID1, DeviceUtils.getIMEI(this.options.getContext()));
            map2.put(pair26.getFirst(), pair26.getSecond());
            Pair pair27 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(this.options.getContext()));
            map2.put(pair27.getFirst(), pair27.getSecond());
            GidService gidService2 = this.gidService;
            str = Common.Predefined.GID;
            if (gidService2 != null) {
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = eventContext;
                anonymousClass1.L$2 = map;
                anonymousClass1.L$3 = map2;
                anonymousClass1.L$4 = Common.Predefined.GID;
                anonymousClass1.Z$0 = z;
                anonymousClass1.label = 1;
                gid = gidService2.getGid(anonymousClass1);
                if (gid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                predefinedProvider = this;
                eventContext2 = eventContext;
                z2 = z;
            } else {
                predefinedProvider = this;
                str2 = null;
                eventContext2 = eventContext;
                z2 = z;
            }
            Pair pair28 = TuplesKt.to(str, str2);
            map2.put(pair28.getFirst(), pair28.getSecond());
            map3 = map;
            gidService = predefinedProvider.gidService;
            str3 = Common.Predefined.TDID;
            if (gidService != null) {
                anonymousClass1.L$0 = predefinedProvider;
                anonymousClass1.L$1 = eventContext2;
                anonymousClass1.L$2 = map;
                anonymousClass1.L$3 = map3;
                anonymousClass1.L$4 = Common.Predefined.TDID;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 2;
                tdid = gidService.getTdid(anonymousClass1);
                if (tdid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                HashMap map10 = map;
                map5 = map3;
                gid = tdid;
                predefinedProvider2 = predefinedProvider;
                eventContext4 = eventContext2;
                map4 = map10;
                str4 = (String) gid;
                EventContext eventContext5 = eventContext4;
                predefinedProvider = predefinedProvider2;
                eventContext3 = eventContext5;
            } else {
                eventContext3 = eventContext2;
                map4 = map;
                map5 = map3;
                str4 = null;
            }
            Pair pair29 = TuplesKt.to(str3, str4);
            map5.put(pair29.getFirst(), pair29.getSecond());
            map6 = map4;
            i = WhenMappings.$EnumSwitchMapping$0[predefinedProvider.options.getRegion().ordinal()];
            if (i == 1) {
                TapDB companion = TapDB.INSTANCE.getInstance();
                anonymousClass1.L$0 = predefinedProvider;
                anonymousClass1.L$1 = eventContext3;
                anonymousClass1.L$2 = map4;
                anonymousClass1.L$3 = map6;
                anonymousClass1.L$4 = null;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 3;
                oaid = companion.getOAID(anonymousClass1);
                if (oaid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z3 = z2;
                map7 = map4;
                map8 = map6;
                gid = oaid;
                predefinedProvider3 = predefinedProvider;
                String str5 = (String) gid;
                Log.i("PredefinedProvider", "oaid: " + str5);
                pair = TuplesKt.to("oaid", str5);
                map8.put(pair.getFirst(), pair.getSecond());
                map9 = map7;
                Pair pair30 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
                map9.put(pair30.getFirst(), pair30.getSecond());
                Pair pair31 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
                map9.put(pair31.getFirst(), pair31.getSecond());
                Pair pair32 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
                map9.put(pair32.getFirst(), pair32.getSecond());
                Pair pair33 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
                map9.put(pair33.getFirst(), pair33.getSecond());
                Pair pair34 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
                map9.put(pair34.getFirst(), pair34.getSecond());
                Pair pair35 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
                map9.put(pair35.getFirst(), pair35.getSecond());
                if (z3) {
                    Pair pair36 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                    map9.put(pair36.getFirst(), pair36.getSecond());
                }
                return map7;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            TapDB companion2 = TapDB.INSTANCE.getInstance();
            anonymousClass1.L$0 = predefinedProvider;
            anonymousClass1.L$1 = eventContext3;
            anonymousClass1.L$2 = map4;
            anonymousClass1.L$3 = map6;
            anonymousClass1.L$4 = null;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.label = 4;
            gaid = companion2.getGAID(anonymousClass1);
            if (gaid == coroutine_suspended) {
                return coroutine_suspended;
            }
            z3 = z2;
            map7 = map4;
            map8 = map6;
            gid = gaid;
            predefinedProvider3 = predefinedProvider;
            String str6 = (String) gid;
            Log.i("PredefinedProvider", "gaid: " + str6);
            pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, str6);
            map8.put(pair.getFirst(), pair.getSecond());
            map9 = map7;
            Pair pair37 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
            map9.put(pair37.getFirst(), pair37.getSecond());
            Pair pair38 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
            map9.put(pair38.getFirst(), pair38.getSecond());
            Pair pair39 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
            map9.put(pair39.getFirst(), pair39.getSecond());
            Pair pair310 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
            map9.put(pair310.getFirst(), pair310.getSecond());
            Pair pair311 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
            map9.put(pair311.getFirst(), pair311.getSecond());
            Pair pair312 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
            map9.put(pair312.getFirst(), pair312.getSecond());
            if (z3) {
                Pair pair313 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                map9.put(pair313.getFirst(), pair313.getSecond());
            }
            return map7;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    z3 = anonymousClass1.Z$0;
                    map8 = (Map) anonymousClass1.L$3;
                    map7 = (HashMap) anonymousClass1.L$2;
                    eventContext3 = (EventContext) anonymousClass1.L$1;
                    predefinedProvider3 = (PredefinedProvider) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(gid);
                    String str7 = (String) gid;
                    Log.i("PredefinedProvider", "oaid: " + str7);
                    pair = TuplesKt.to("oaid", str7);
                    map8.put(pair.getFirst(), pair.getSecond());
                    map9 = map7;
                    Pair pair314 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
                    map9.put(pair314.getFirst(), pair314.getSecond());
                    Pair pair315 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
                    map9.put(pair315.getFirst(), pair315.getSecond());
                    Pair pair316 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
                    map9.put(pair316.getFirst(), pair316.getSecond());
                    Pair pair317 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
                    map9.put(pair317.getFirst(), pair317.getSecond());
                    Pair pair318 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
                    map9.put(pair318.getFirst(), pair318.getSecond());
                    Pair pair319 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
                    map9.put(pair319.getFirst(), pair319.getSecond());
                    if (z3) {
                        Pair pair3110 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                        map9.put(pair3110.getFirst(), pair3110.getSecond());
                    }
                    return map7;
                }
                if (i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z3 = anonymousClass1.Z$0;
                map8 = (Map) anonymousClass1.L$3;
                map7 = (HashMap) anonymousClass1.L$2;
                eventContext3 = (EventContext) anonymousClass1.L$1;
                predefinedProvider3 = (PredefinedProvider) anonymousClass1.L$0;
                ResultKt.throwOnFailure(gid);
                String str8 = (String) gid;
                Log.i("PredefinedProvider", "gaid: " + str8);
                pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, str8);
                map8.put(pair.getFirst(), pair.getSecond());
                map9 = map7;
                Pair pair3111 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
                map9.put(pair3111.getFirst(), pair3111.getSecond());
                Pair pair3112 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
                map9.put(pair3112.getFirst(), pair3112.getSecond());
                Pair pair3113 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
                map9.put(pair3113.getFirst(), pair3113.getSecond());
                Pair pair3114 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
                map9.put(pair3114.getFirst(), pair3114.getSecond());
                Pair pair3115 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
                map9.put(pair3115.getFirst(), pair3115.getSecond());
                Pair pair3116 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
                map9.put(pair3116.getFirst(), pair3116.getSecond());
                if (z3) {
                    Pair pair3117 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                    map9.put(pair3117.getFirst(), pair3117.getSecond());
                }
                return map7;
            }
            z2 = anonymousClass1.Z$0;
            str3 = (String) anonymousClass1.L$4;
            map5 = (Map) anonymousClass1.L$3;
            map4 = (HashMap) anonymousClass1.L$2;
            eventContext4 = (EventContext) anonymousClass1.L$1;
            predefinedProvider2 = (PredefinedProvider) anonymousClass1.L$0;
            ResultKt.throwOnFailure(gid);
            str4 = (String) gid;
            EventContext eventContext6 = eventContext4;
            predefinedProvider = predefinedProvider2;
            eventContext3 = eventContext6;
            Pair pair210 = TuplesKt.to(str3, str4);
            map5.put(pair210.getFirst(), pair210.getSecond());
            map6 = map4;
            i = WhenMappings.$EnumSwitchMapping$0[predefinedProvider.options.getRegion().ordinal()];
            if (i == 1) {
                TapDB companion3 = TapDB.INSTANCE.getInstance();
                anonymousClass1.L$0 = predefinedProvider;
                anonymousClass1.L$1 = eventContext3;
                anonymousClass1.L$2 = map4;
                anonymousClass1.L$3 = map6;
                anonymousClass1.L$4 = null;
                anonymousClass1.Z$0 = z2;
                anonymousClass1.label = 3;
                oaid = companion3.getOAID(anonymousClass1);
                if (oaid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z3 = z2;
                map7 = map4;
                map8 = map6;
                gid = oaid;
                predefinedProvider3 = predefinedProvider;
                String str9 = (String) gid;
                Log.i("PredefinedProvider", "oaid: " + str9);
                pair = TuplesKt.to("oaid", str9);
                map8.put(pair.getFirst(), pair.getSecond());
                map9 = map7;
                Pair pair3118 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
                map9.put(pair3118.getFirst(), pair3118.getSecond());
                Pair pair3119 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
                map9.put(pair3119.getFirst(), pair3119.getSecond());
                Pair pair31110 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
                map9.put(pair31110.getFirst(), pair31110.getSecond());
                Pair pair31111 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
                map9.put(pair31111.getFirst(), pair31111.getSecond());
                Pair pair31112 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
                map9.put(pair31112.getFirst(), pair31112.getSecond());
                Pair pair31113 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
                map9.put(pair31113.getFirst(), pair31113.getSecond());
                if (z3) {
                    Pair pair31114 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                    map9.put(pair31114.getFirst(), pair31114.getSecond());
                }
                return map7;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            TapDB companion4 = TapDB.INSTANCE.getInstance();
            anonymousClass1.L$0 = predefinedProvider;
            anonymousClass1.L$1 = eventContext3;
            anonymousClass1.L$2 = map4;
            anonymousClass1.L$3 = map6;
            anonymousClass1.L$4 = null;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.label = 4;
            gaid = companion4.getGAID(anonymousClass1);
            if (gaid == coroutine_suspended) {
                return coroutine_suspended;
            }
            z3 = z2;
            map7 = map4;
            map8 = map6;
            gid = gaid;
            predefinedProvider3 = predefinedProvider;
            String str10 = (String) gid;
            Log.i("PredefinedProvider", "gaid: " + str10);
            pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, str10);
            map8.put(pair.getFirst(), pair.getSecond());
            map9 = map7;
            Pair pair31115 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
            map9.put(pair31115.getFirst(), pair31115.getSecond());
            Pair pair31116 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
            map9.put(pair31116.getFirst(), pair31116.getSecond());
            Pair pair31117 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
            map9.put(pair31117.getFirst(), pair31117.getSecond());
            Pair pair31118 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
            map9.put(pair31118.getFirst(), pair31118.getSecond());
            Pair pair31119 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
            map9.put(pair31119.getFirst(), pair31119.getSecond());
            Pair pair311110 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
            map9.put(pair311110.getFirst(), pair311110.getSecond());
            if (z3) {
                Pair pair311111 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                map9.put(pair311111.getFirst(), pair311111.getSecond());
            }
            return map7;
        }
        z2 = anonymousClass1.Z$0;
        str = (String) anonymousClass1.L$4;
        map2 = (Map) anonymousClass1.L$3;
        map = (HashMap) anonymousClass1.L$2;
        eventContext2 = (EventContext) anonymousClass1.L$1;
        predefinedProvider = (PredefinedProvider) anonymousClass1.L$0;
        ResultKt.throwOnFailure(gid);
        str2 = (String) gid;
        Pair pair211 = TuplesKt.to(str, str2);
        map2.put(pair211.getFirst(), pair211.getSecond());
        map3 = map;
        gidService = predefinedProvider.gidService;
        str3 = Common.Predefined.TDID;
        if (gidService != null) {
            anonymousClass1.L$0 = predefinedProvider;
            anonymousClass1.L$1 = eventContext2;
            anonymousClass1.L$2 = map;
            anonymousClass1.L$3 = map3;
            anonymousClass1.L$4 = Common.Predefined.TDID;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.label = 2;
            tdid = gidService.getTdid(anonymousClass1);
            if (tdid == coroutine_suspended) {
                return coroutine_suspended;
            }
            HashMap map11 = map;
            map5 = map3;
            gid = tdid;
            predefinedProvider2 = predefinedProvider;
            eventContext4 = eventContext2;
            map4 = map11;
            str4 = (String) gid;
            EventContext eventContext7 = eventContext4;
            predefinedProvider = predefinedProvider2;
            eventContext3 = eventContext7;
        } else {
            eventContext3 = eventContext2;
            map4 = map;
            map5 = map3;
            str4 = null;
        }
        Pair pair212 = TuplesKt.to(str3, str4);
        map5.put(pair212.getFirst(), pair212.getSecond());
        map6 = map4;
        i = WhenMappings.$EnumSwitchMapping$0[predefinedProvider.options.getRegion().ordinal()];
        if (i == 1) {
            TapDB companion5 = TapDB.INSTANCE.getInstance();
            anonymousClass1.L$0 = predefinedProvider;
            anonymousClass1.L$1 = eventContext3;
            anonymousClass1.L$2 = map4;
            anonymousClass1.L$3 = map6;
            anonymousClass1.L$4 = null;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.label = 3;
            oaid = companion5.getOAID(anonymousClass1);
            if (oaid == coroutine_suspended) {
                return coroutine_suspended;
            }
            z3 = z2;
            map7 = map4;
            map8 = map6;
            gid = oaid;
            predefinedProvider3 = predefinedProvider;
            String str11 = (String) gid;
            Log.i("PredefinedProvider", "oaid: " + str11);
            pair = TuplesKt.to("oaid", str11);
            map8.put(pair.getFirst(), pair.getSecond());
            map9 = map7;
            Pair pair311112 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
            map9.put(pair311112.getFirst(), pair311112.getSecond());
            Pair pair311113 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
            map9.put(pair311113.getFirst(), pair311113.getSecond());
            Pair pair311114 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
            map9.put(pair311114.getFirst(), pair311114.getSecond());
            Pair pair311115 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
            map9.put(pair311115.getFirst(), pair311115.getSecond());
            Pair pair311116 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
            map9.put(pair311116.getFirst(), pair311116.getSecond());
            Pair pair311117 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
            map9.put(pair311117.getFirst(), pair311117.getSecond());
            if (z3) {
                Pair pair311118 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
                map9.put(pair311118.getFirst(), pair311118.getSecond());
            }
            return map7;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        TapDB companion6 = TapDB.INSTANCE.getInstance();
        anonymousClass1.L$0 = predefinedProvider;
        anonymousClass1.L$1 = eventContext3;
        anonymousClass1.L$2 = map4;
        anonymousClass1.L$3 = map6;
        anonymousClass1.L$4 = null;
        anonymousClass1.Z$0 = z2;
        anonymousClass1.label = 4;
        gaid = companion6.getGAID(anonymousClass1);
        if (gaid == coroutine_suspended) {
            return coroutine_suspended;
        }
        z3 = z2;
        map7 = map4;
        map8 = map6;
        gid = gaid;
        predefinedProvider3 = predefinedProvider;
        String str12 = (String) gid;
        Log.i("PredefinedProvider", "gaid: " + str12);
        pair = TuplesKt.to(Common.Predefined.SUB_DEVICE_ID2, str12);
        map8.put(pair.getFirst(), pair.getSecond());
        map9 = map7;
        Pair pair311119 = TuplesKt.to("open_id", TapIdentifierUtil.INSTANCE.getOpenId());
        map9.put(pair311119.getFirst(), pair311119.getSecond());
        Pair pair3111110 = TuplesKt.to("android_id", TapIdentifierUtil.getAndroidID(predefinedProvider3.options.getContext()));
        map9.put(pair3111110.getFirst(), pair3111110.getSecond());
        Pair pair3111111 = TuplesKt.to("t_log_id", UUID.randomUUID().toString());
        map9.put(pair3111111.getFirst(), pair3111111.getSecond());
        Pair pair3111112 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, eventContext3.getSessionId());
        map9.put(pair3111112.getFirst(), pair3111112.getSecond());
        Pair pair3111113 = TuplesKt.to("timestamp", Boxing.boxLong(System.currentTimeMillis()));
        map9.put(pair3111113.getFirst(), pair3111113.getSecond());
        Pair pair3111114 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Boxing.boxLong(eventContext3.getEventIndex().incrementAndGet()));
        map9.put(pair3111114.getFirst(), pair3111114.getSecond());
        if (z3) {
            Pair pair3111115 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, Boxing.boxBoolean(true));
            map9.put(pair3111115.getFirst(), pair3111115.getSecond());
        }
        return map7;
    }
}
