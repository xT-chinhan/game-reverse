package com.tapsdk.tapad.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.BuildConfig;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdLocation;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.v;
import com.tapsdk.tapad.model.entities.AdExpoInfo;
import com.tapsdk.tapad.model.entities.AdExpoResult;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.TapAdReq;
import com.tapsdk.tapad.model.entities.TapAdResp;
import com.tapsdk.tapad.model.entities.TrackBackData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String e = "/bid/adn_sdk/api_v2";
    public static final long f = 3000;
    private static volatile boolean g = false;
    private final com.tapsdk.tapad.internal.i.a a;
    private final com.tapsdk.tapad.e.i b = new com.tapsdk.tapad.e.i();
    private final List<AdInfo> c = new ArrayList();
    public volatile long d = -1;

    /* JADX INFO: renamed from: com.tapsdk.tapad.e.a$a, reason: collision with other inner class name */
    class C0584a implements Function<List<AdInfo>, ObservableSource<? extends List<AdInfo>>> {
        final /* synthetic */ AdRequest a;
        final /* synthetic */ TapAdConfig b;
        final /* synthetic */ AdType c;

        C0584a(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
            this.a = adRequest;
            this.b = tapAdConfig;
            this.c = adType;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends List<AdInfo>> apply(List<AdInfo> list) throws Exception {
            return list.size() == 0 ? a.this.f(this.a, this.b, this.c) : Observable.just(list);
        }
    }

    class b implements ObservableOnSubscribe<List<AdInfo>> {
        final /* synthetic */ TapAdConfig a;
        final /* synthetic */ AdRequest b;
        final /* synthetic */ AdType c;

        b(TapAdConfig tapAdConfig, AdRequest adRequest, AdType adType) {
            this.a = tapAdConfig;
            this.b = adRequest;
            this.c = adType;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<List<AdInfo>> observableEmitter) {
            TapAdResp.h hVarA;
            List<AdInfo> listA;
            try {
                hVarA = TapAdResp.h.a(com.tapsdk.tapad.internal.t.f.b.a(a.this.a.b(a.this.b(this.a.mMediaId, this.b.spaceId, this.c)), this.a.mMediaKey.substring(32)));
            } catch (Exception unused) {
                hVarA = null;
            }
            TapAdResp.h hVar = hVarA;
            if (hVar == null || hVar.M2() <= 0) {
                listA = a.this.c;
            } else {
                try {
                    listA = a.this.a(hVar.Y(), this.b, this.a, this.c, hVar);
                } catch (Exception unused2) {
                    listA = a.this.c;
                }
            }
            observableEmitter.onNext(listA);
            observableEmitter.onComplete();
        }
    }

    class c implements Function<TapAdResp.h, ObservableSource<? extends Boolean>> {
        final /* synthetic */ TapAdConfig a;
        final /* synthetic */ AdRequest b;
        final /* synthetic */ AdType c;

        c(TapAdConfig tapAdConfig, AdRequest adRequest, AdType adType) {
            this.a = tapAdConfig;
            this.b = adRequest;
            this.c = adType;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends Boolean> apply(TapAdResp.h hVar) throws Exception {
            if (hVar != null) {
                try {
                    a.this.a.a(a.this.b(this.a.mMediaId, this.b.spaceId, this.c), com.tapsdk.tapad.internal.t.f.b.a(hVar.toByteArray(), this.a.mMediaKey.substring(32)));
                    if (hVar.M2() > 0) {
                        List<TapAdResp.b> listY = hVar.Y();
                        ArrayList arrayList = new ArrayList();
                        Iterator<TapAdResp.b> it = listY.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().s2());
                        }
                        a.this.a(arrayList, this.b, this.a, this.c);
                    }
                } catch (Throwable unused) {
                    return Observable.just(Boolean.TRUE);
                }
            }
            return Observable.just(Boolean.TRUE);
        }
    }

    class d implements Function<TapAdResp.h, ObservableSource<? extends List<AdInfo>>> {
        final /* synthetic */ TapAdConfig a;
        final /* synthetic */ AdRequest b;
        final /* synthetic */ AdType c;

        d(TapAdConfig tapAdConfig, AdRequest adRequest, AdType adType) {
            this.a = tapAdConfig;
            this.b = adRequest;
            this.c = adType;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends List<AdInfo>> apply(TapAdResp.h hVar) throws Exception {
            a.this.d = System.currentTimeMillis();
            if (hVar != null) {
                a.this.a.a(a.this.b(this.a.mMediaId, this.b.spaceId, this.c), com.tapsdk.tapad.internal.t.f.b.a(hVar.toByteArray(), this.a.mMediaKey.substring(32)));
                if (hVar.M2() > 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (TapAdResp.b bVar : hVar.Y()) {
                        arrayList2.add(bVar.s2());
                        arrayList.add(new AdInfo(bVar, new TrackBackData(hVar.g(), hVar.V4(), this.b.spaceId)));
                    }
                    a.this.a(arrayList2, this.b, this.a, this.c);
                    return Observable.just(arrayList);
                }
            }
            return Observable.just(a.this.c);
        }
    }

    class e implements Function<TapAdReq.d, Observable<TapAdResp.h>> {
        final /* synthetic */ AdRequest a;

        e(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable<TapAdResp.h> apply(TapAdReq.d dVar) throws Exception {
            com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.a);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            TapADLogger.d("AdLoaderModel start call queryAdInternalByTypeBp requestId:" + this.a.requestId);
            map2.put("Content-Encoding", "tap_cryptor");
            map2.put("Content-Type", "application/x-protobuf");
            return aVarA.a("/bid/adn_sdk/api_v2", map, map2, dVar);
        }
    }

    class f implements Function<TapAdResp.h, ObservableSource<? extends List<AdInfo>>> {
        final /* synthetic */ AdRequest a;

        f(AdRequest adRequest) {
            this.a = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends List<AdInfo>> apply(TapAdResp.h hVar) throws Exception {
            ArrayList arrayList = new ArrayList();
            for (TapAdResp.b bVar : hVar.Y()) {
                AdInfo adInfo = new AdInfo(bVar, new TrackBackData(hVar.g(), hVar.V4(), this.a.spaceId));
                arrayList.add(adInfo);
                com.tapsdk.tapad.internal.j.c.a(adInfo, bVar);
            }
            return Observable.just(arrayList);
        }
    }

    class g implements Function<Boolean, ObservableSource<? extends TapAdReq.d>> {
        final /* synthetic */ TapAdConfig a;
        final /* synthetic */ AdRequest b;

        /* JADX INFO: renamed from: com.tapsdk.tapad.e.a$g$a, reason: collision with other inner class name */
        class C0585a implements ObservableOnSubscribe<TapAdReq.d> {

            /* JADX INFO: renamed from: com.tapsdk.tapad.e.a$g$a$a, reason: collision with other inner class name */
            class C0586a implements Consumer<List<String>> {
                C0586a() {
                }

                @Override // io.reactivex.functions.Consumer
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(List<String> list) throws Exception {
                }
            }

            /* JADX INFO: renamed from: com.tapsdk.tapad.e.a$g$a$b */
            class b implements Consumer<Throwable> {
                b() {
                }

                @Override // io.reactivex.functions.Consumer
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void accept(Throwable th) throws Exception {
                }
            }

            C0585a() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<TapAdReq.d> observableEmitter) throws Exception {
                int i;
                TapAdConfig tapAdConfig = g.this.a;
                if (tapAdConfig != null && tapAdConfig.mCustomController != null) {
                    if (!a.g) {
                        boolean unused = a.g = true;
                        if (g.this.a.mCustomController.isCanUseLocation()) {
                            com.tapsdk.tapad.e.e.b().c();
                        } else {
                            com.tapsdk.tapad.e.e.b().a(g.this.a.mCustomController.getTapAdLocation());
                        }
                    }
                    com.tapsdk.tapad.e.g.d().b(g.this.a.mCustomController.alist()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0586a(), new b());
                }
                try {
                    if (com.tapsdk.tapad.e.d.d().b(g.this.a) == null) {
                        TapADLogger.e("configuration is null");
                    }
                } catch (Throwable unused2) {
                }
                try {
                    TapAdReq.p pVarBuild = TapAdReq.p.U5().a(g.this.a.mMediaId).b(TapAdReq.b.W5().b(com.tapsdk.tapad.internal.utils.d.f(com.tapsdk.tapad.c.a)).d(com.tapsdk.tapad.internal.utils.d.e(com.tapsdk.tapad.c.a)).c(g.this.a.gameChannel).a(g.this.a.aggregationChannel).e(com.tapsdk.tapad.internal.utils.i.a(com.tapsdk.tapad.c.a)).build()).b(TapAdReq.t.T5().a("3.16.3.45").a(31603045L).build()).build();
                    String uid = GUIDHelper.INSTANCE.getUID();
                    TapAdReq.v.a aVarV5 = TapAdReq.v.V5();
                    if (uid != null) {
                        aVarV5.a(uid);
                    }
                    String strB = l.a().b();
                    if (!TextUtils.isEmpty(strB)) {
                        aVarV5.d(strB);
                    }
                    String str = g.this.a.mTapClientId;
                    if (!TextUtils.isEmpty(str)) {
                        aVarV5.b(str);
                    }
                    TapAdReq.h.a aVarA = TapAdReq.h.e6().a(aVarV5);
                    int[] iArrB = com.tapsdk.tapad.internal.utils.d.b(com.tapsdk.tapad.c.a);
                    String devImei = g.this.a.mCustomController.getDevImei();
                    if (g.this.a.mCustomController.isCanUsePhoneState()) {
                        devImei = com.tapsdk.tapad.internal.utils.d.c(com.tapsdk.tapad.c.a);
                    }
                    if (!TextUtils.isEmpty(devImei)) {
                        aVarA.e(devImei);
                        aVarA.f(q.b(devImei).toLowerCase());
                    }
                    String strA = com.tapsdk.tapad.internal.utils.d.a(com.tapsdk.tapad.c.a, g.this.a);
                    if (!TextUtils.isEmpty(strA)) {
                        aVarA.a(strA);
                        aVarA.b(q.b(strA).toLowerCase());
                    }
                    String devOaid = !TextUtils.isEmpty(g.this.a.mCustomController.getDevOaid()) ? g.this.a.mCustomController.getDevOaid() : com.tapsdk.tapad.e.h.b().a();
                    if (!TextUtils.isEmpty(devOaid)) {
                        aVarA.g(devOaid);
                        aVarA.i(q.b(devOaid).toLowerCase());
                    }
                    String string = "";
                    aVarA.h(com.tapsdk.tapad.f.i.l.c == null ? "" : com.tapsdk.tapad.f.i.l.c);
                    try {
                        i = Integer.parseInt(com.tapsdk.tapad.internal.utils.k.a(com.tapsdk.tapad.c.a));
                    } catch (Exception unused3) {
                        i = 0;
                    }
                    TapAdReq.r rVarBuild = TapAdReq.r.U5().a(a.this.a(i)).build();
                    TapAdReq.j.a aVarS6 = TapAdReq.j.s6();
                    aVarS6.a(TapAdReq.OsType.OsType_android).k(com.tapsdk.tapad.internal.utils.d.i()).j(com.tapsdk.tapad.internal.utils.d.f()).e(com.tapsdk.tapad.internal.utils.d.e()).g(Build.FINGERPRINT == null ? "" : Build.FINGERPRINT).l(Build.PRODUCT == null ? "" : Build.PRODUCT).i(Build.MANUFACTURER == null ? "" : Build.MANUFACTURER).f(Build.DEVICE == null ? "" : Build.DEVICE).h(Build.HARDWARE == null ? "" : Build.HARDWARE).s0(iArrB[0]).r0(iArrB[1]).b(rVarBuild).b(aVarA.build()).a(1 == com.tapsdk.tapad.e.p.a.a(g.this.a) ? TapAdReq.ADModel.ADmodel_default : TapAdReq.ADModel.ADModel_intelligence_advertisement_Off).a(com.tapsdk.tapad.internal.utils.d.h(com.tapsdk.tapad.c.a) ? TapAdReq.DeviceType.DeviceType_pad : TapAdReq.DeviceType.DeviceType_mobile);
                    Pair<TapAdLocation, Long> pairA = com.tapsdk.tapad.e.e.b().a();
                    if (pairA != null && pairA.first != null) {
                        aVarS6.b(TapAdReq.l.T5().a(((TapAdLocation) pairA.first).latitude).b(((TapAdLocation) pairA.first).longitude).build());
                    }
                    if (g.this.a.mCustomController.alist()) {
                        String[] strArrC = com.tapsdk.tapad.e.g.d().c();
                        if (strArrC.length > 0) {
                            aVarS6.a(Arrays.asList(strArrC));
                        }
                    }
                    String strB2 = v.a().b(BuildConfig.BASE_SERVER_URL_CN);
                    if (TextUtils.isEmpty(strB2)) {
                        strB2 = v.a().a(BuildConfig.BASE_SERVER_URL_CN);
                    }
                    if (!TextUtils.isEmpty(strB2)) {
                        aVarS6.o(strB2);
                    }
                    TapAdReq.j jVarBuild = aVarS6.build();
                    TapAdReq.n.b bVarC = TapAdReq.n.Z5().c(g.this.b.spaceId);
                    if (!TextUtils.isEmpty(g.this.b.query)) {
                        bVarC.b(g.this.b.query);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.tapsdk.tapad.internal.utils.d.m()) {
                            jSONObject.put(Constants.o.a, 1);
                        } else {
                            jSONObject.put(Constants.o.a, 0);
                        }
                        string = jSONObject.toString();
                    } catch (JSONException unused4) {
                        TapADLogger.e("Get sandbox Environment Error");
                    }
                    TapAdReq.d.a aVarA2 = TapAdReq.d.Z5().a("v2.0").b(pVarBuild).c(g.this.b.requestId).b(jVarBuild).a(bVarC);
                    if (string.length() > 0) {
                        aVarA2.b(string);
                    }
                    observableEmitter.onNext(aVarA2.build());
                    observableEmitter.onComplete();
                } catch (Throwable th) {
                    try {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onError(th);
                        }
                    } catch (Throwable unused5) {
                    }
                    TapADLogger.w(th.getMessage(), th);
                }
            }
        }

        g(TapAdConfig tapAdConfig, AdRequest adRequest) {
            this.a = tapAdConfig;
            this.b = adRequest;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends TapAdReq.d> apply(Boolean bool) throws Exception {
            return Observable.create(new C0585a());
        }
    }

    class h implements Function<Boolean, ObservableSource<? extends Boolean>> {

        /* JADX INFO: renamed from: com.tapsdk.tapad.e.a$h$a, reason: collision with other inner class name */
        class C0587a implements ObservableOnSubscribe<Boolean> {
            C0587a() {
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                try {
                    v.a().c();
                    observableEmitter.onNext(Boolean.TRUE);
                    observableEmitter.onComplete();
                } catch (Throwable th) {
                    try {
                        observableEmitter.onError(th);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        h() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends Boolean> apply(Boolean bool) throws Exception {
            return Observable.create(new C0587a());
        }
    }

    static /* synthetic */ class i {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdType.values().length];
            a = iArr;
            try {
                iArr[AdType.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdType.RewardedAd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(Context context) {
        this.a = new com.tapsdk.tapad.internal.i.b(context);
    }

    private Observable<TapAdReq.d> a(TapAdConfig tapAdConfig, AdRequest adRequest) {
        return Observable.just(Boolean.TRUE).observeOn(AndroidSchedulers.mainThread()).flatMap(new h()).observeOn(Schedulers.newThread()).flatMap(new g(tapAdConfig, adRequest));
    }

    private String a(long j, int i2, AdType adType) {
        StringBuilder sbAppend;
        String str;
        String str2 = j + "" + i2;
        int i3 = i.a[adType.ordinal()];
        if (i3 == 1) {
            sbAppend = new StringBuilder().append(str2);
            str = "bannermap";
        } else if (i3 != 2) {
            sbAppend = new StringBuilder().append(str2);
            str = "splashmap";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = "rewardmap";
        }
        return sbAppend.append(str).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AdInfo> a(List<TapAdResp.b> list, AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType, TapAdResp.h hVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TapAdResp.b bVar = list.get(i2);
            if ((System.currentTimeMillis() / 1000) - bVar.C0() > 0) {
                b(adRequest, tapAdConfig, adType);
                a(adRequest, tapAdConfig, adType);
                throw new RuntimeException("no ad");
            }
            arrayList.add(bVar.s2());
        }
        AdExpoResult adExpoResultA = this.b.a(tapAdConfig, arrayList);
        HashSet hashSet = new HashSet();
        if (adExpoResultA != null && adExpoResultA.expoInfoList.size() > 0) {
            for (int i3 = 0; i3 < adExpoResultA.expoInfoList.size(); i3++) {
                AdExpoInfo adExpoInfo = adExpoResultA.expoInfoList.get(i3);
                if (adExpoInfo.expoStatus == 1) {
                    hashSet.add(adExpoInfo.trackId);
                }
            }
        }
        if (hashSet.size() == 0) {
            b(adRequest, tapAdConfig, adType);
            a(adRequest, tapAdConfig, adType);
            throw new RuntimeException("no ad");
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            TapAdResp.b bVar2 = list.get(i4);
            if (hashSet.contains(bVar2.s2())) {
                arrayList2.add(new AdInfo(bVar2, new TrackBackData(hVar.g(), hVar.V4(), adRequest.spaceId)));
            }
        }
        if (arrayList2.size() != 0) {
            return arrayList2;
        }
        throw new RuntimeException("no ad");
    }

    private void a(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        this.a.a(a(tapAdConfig.mMediaId, adRequest.spaceId, adType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        String strA = a(tapAdConfig.mMediaId, adRequest.spaceId, adType);
        a(adRequest, tapAdConfig, adType);
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        this.a.a(strA, Arrays.toString(strArr));
    }

    private Observable<TapAdResp.h> b(AdRequest adRequest, TapAdConfig tapAdConfig) {
        return a(tapAdConfig, adRequest).flatMap(new e(adRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(long j, int i2, AdType adType) {
        StringBuilder sbAppend;
        String str;
        String str2 = j + "" + i2;
        int i3 = i.a[adType.ordinal()];
        if (i3 == 1) {
            sbAppend = new StringBuilder().append(str2);
            str = "bannermaterial";
        } else if (i3 != 2) {
            sbAppend = new StringBuilder().append(str2);
            str = "splashmaterial";
        } else {
            sbAppend = new StringBuilder().append(str2);
            str = "rewardmaterial";
        }
        return sbAppend.append(str).toString();
    }

    private void b(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        this.a.a(b(tapAdConfig.mMediaId, adRequest.spaceId, adType));
    }

    private String[] c(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        String strB = this.a.b(a(tapAdConfig.mMediaId, adRequest.spaceId, adType));
        if (strB.length() <= 2) {
            return new String[0];
        }
        HashSet hashSet = new HashSet(Arrays.asList(strB.substring(1, strB.length() - 1).split(", ")));
        String[] strArr = new String[hashSet.size()];
        new ArrayList(hashSet).toArray(strArr);
        return strArr;
    }

    TapAdReq.ConnectType a(int i2) {
        switch (i2) {
            case 0:
                return TapAdReq.ConnectType.ConnectType_unknown;
            case 1:
                return TapAdReq.ConnectType.ConnectType_ethernet;
            case 2:
                return TapAdReq.ConnectType.ConnectType_wifi;
            case 3:
                return TapAdReq.ConnectType.ConnectType_mobile;
            case 4:
                return TapAdReq.ConnectType.ConnectType_2G;
            case 5:
                return TapAdReq.ConnectType.ConnectType_3G;
            case 6:
                return TapAdReq.ConnectType.ConnectType_4G;
            case 7:
                return TapAdReq.ConnectType.ConnectType_5G;
            default:
                return TapAdReq.ConnectType.ConnectType_unknown;
        }
    }

    public Observable<List<AdInfo>> a(AdRequest adRequest, TapAdConfig tapAdConfig) {
        return b(adRequest, tapAdConfig).flatMap(new f(adRequest));
    }

    public void a(String str, AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        String[] strArrC = c(adRequest, tapAdConfig, adType);
        if (strArrC.length > 0) {
            HashSet hashSet = new HashSet(Arrays.asList(strArrC));
            hashSet.remove(str);
            a(new ArrayList(hashSet), adRequest, tapAdConfig, adType);
        }
    }

    public List<String> d(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        return new ArrayList(Arrays.asList(c(adRequest, tapAdConfig, adType)));
    }

    public Observable<Boolean> e(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.d == -1 || jCurrentTimeMillis - this.d > f) {
            return b(adRequest, tapAdConfig).flatMap(new c(tapAdConfig, adRequest, adType));
        }
        this.d = jCurrentTimeMillis;
        return Observable.just(Boolean.FALSE);
    }

    public Observable<List<AdInfo>> f(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        return b(adRequest, tapAdConfig).flatMap(new d(tapAdConfig, adRequest, adType));
    }

    public Observable<List<AdInfo>> g(AdRequest adRequest, TapAdConfig tapAdConfig, AdType adType) {
        return Observable.create(new b(tapAdConfig, adRequest, adType)).flatMap(new C0584a(adRequest, tapAdConfig, adType));
    }
}
