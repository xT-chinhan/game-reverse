package com.tapsdk.tapad.e;

import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.network.ResponseBean;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.v;
import com.tapsdk.tapad.model.entities.AdConfiguration;
import com.tapsdk.tapad.model.entities.FeatureFlag;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private final AtomicInteger a;
    private volatile boolean b;
    private volatile AdConfiguration c;

    class a implements ObservableOnSubscribe<AdConfiguration> {
        final /* synthetic */ TapAdConfig a;

        a(TapAdConfig tapAdConfig) {
            this.a = tapAdConfig;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<AdConfiguration> observableEmitter) throws Exception {
            observableEmitter.onNext(d.this.b(this.a));
            observableEmitter.onComplete();
        }
    }

    class b extends com.tapsdk.tapad.internal.network.c.c<ResponseBean<AdConfiguration>> {
        b() {
        }
    }

    static class c {
        public static d a = new d(null);

        c() {
        }
    }

    private d() {
        this.a = new AtomicInteger(0);
        this.b = false;
        this.c = null;
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private void a(List<FeatureFlag> list) {
        for (int i = 0; i < list.size(); i++) {
            FeatureFlag featureFlag = list.get(i);
            if (featureFlag.name.length() > 0 && featureFlag.value.length() > 0) {
                try {
                    com.tapsdk.tapad.internal.j.a.b().a(featureFlag.name, Integer.valueOf(Integer.parseInt(featureFlag.value)));
                } catch (Exception unused) {
                    com.tapsdk.tapad.internal.j.a.b().a(featureFlag.name, featureFlag.value);
                }
            }
        }
    }

    public static d d() {
        return c.a;
    }

    public Observable<AdConfiguration> a(TapAdConfig tapAdConfig) {
        return Observable.create(new a(tapAdConfig));
    }

    public String a() {
        return this.c != null ? this.c.defaultImages.horizontalDefaultImageInfo.imageUrl : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized AdConfiguration b(TapAdConfig tapAdConfig) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException {
        TapADLogger.d("queryAdConfigurationSync");
        if (this.b) {
            TapADLogger.e("configuration api is abnormal");
            return this.c;
        }
        if (this.c != null) {
            TapADLogger.d("configuration got from memory cache");
            return this.c;
        }
        com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.a);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("Content-Type", "text/plain; charset=utf-8");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.n, tapAdConfig.mMediaId);
        jSONObject.put("version", "3.16.3.45");
        jSONObject.put("version_code", 31603045);
        try {
            ResponseBean responseBean = (ResponseBean) aVarA.a(new b(), "/sdk-config/global_config", map, map2, jSONObject);
            if (responseBean != null && responseBean.data != 0) {
                this.c = (AdConfiguration) responseBean.data;
                if (this.c.featureFlags != null && this.c.featureFlags.flags.size() > 0) {
                    a(this.c.featureFlags.flags);
                }
                v.a().a(new JSONArray((String) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.g, String.class, "")));
                TapADLogger.d("configuration fetched from network success");
            }
            this.a.set(0);
        } catch (com.tapsdk.tapad.internal.network.b.a e) {
            TapADLogger.e("configuration fetched from network fail status code:" + e.a);
            int i = e.a;
            if (i >= 500 && i < 600 && this.a.addAndGet(1) >= 3) {
                this.b = true;
            }
        }
        return this.c;
    }

    public String b() {
        return this.c != null ? this.c.defaultImages.verticalDefaultImageInfo.imageUrl : "";
    }

    public AdConfiguration c() {
        return this.c;
    }

    public long e() {
        if (this.c != null) {
            return this.c.splashTimeoutDurationInMillis;
        }
        return -1L;
    }
}
