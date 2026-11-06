package com.tapsdk.tapad;

import android.content.Context;
import com.kuaishou.weapon.p0.g;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.e.h;
import com.tapsdk.tapad.e.m;
import com.tapsdk.tapad.exceptions.AdException;
import com.tapsdk.tapad.f.i.l;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdConfiguration;
import com.tapsdk.tapad.model.entities.UserActionResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class TapAdManager {
    private static volatile boolean initialized = false;
    public volatile Context appContext;
    public volatile TapAdConfig tapAdConfig;
    private final Set<TapAdNative> tapAdNativeSet = new HashSet();
    private final m userActionModel = new m();

    class a implements Consumer<AdConfiguration> {
        a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AdConfiguration adConfiguration) throws Exception {
        }
    }

    class b implements Consumer<Throwable> {
        b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class c implements Consumer<UserActionResult> {
        final /* synthetic */ Callback a;

        c(Callback callback) {
            this.a = callback;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(UserActionResult userActionResult) throws Exception {
            this.a.onSuccess();
        }
    }

    class d implements Consumer<Throwable> {
        final /* synthetic */ Callback a;

        d(Callback callback) {
            this.a = callback;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.onError(new AdException(th));
        }
    }

    public static class e {
        public static TapAdManager a = new TapAdManager();
    }

    public static TapAdManager get() {
        return e.a;
    }

    public TapAdNative createAdNative(Context context) {
        return new com.tapsdk.tapad.d(context, this.tapAdConfig);
    }

    public void init(Context context, TapAdConfig tapAdConfig) {
        synchronized (TapAdManager.class) {
            if (!initialized && tapAdConfig != null) {
                this.tapAdConfig = tapAdConfig;
                if (tapAdConfig.mIsDebug) {
                    com.tapsdk.tapad.internal.j.a.b();
                }
                this.appContext = context.getApplicationContext();
                GUIDHelper.INSTANCE.init(context);
                new com.tapsdk.tapad.internal.i.b(context).a(com.tapsdk.tapad.internal.l.b.a.c, "0");
                if (tapAdConfig.mCustomController != null) {
                    h.a(com.tapsdk.tapad.e.p.a.b(tapAdConfig));
                    if (tapAdConfig.mCustomController.getDevOaid() == null || tapAdConfig.mCustomController.getDevOaid().length() == 0) {
                        h.b().d();
                    } else {
                        h.b().a(tapAdConfig.mCustomController.getDevOaid());
                    }
                }
                com.tapsdk.tapad.e.d.d().a(tapAdConfig).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new b());
                initialized = true;
                com.tapsdk.tapad.internal.o.a.a.a();
                if (this.appContext != null && ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.m, Integer.class, 1)).intValue() == 1) {
                    h.b().b(new l(context.getApplicationContext()));
                }
                com.tapsdk.tapad.internal.o.a.b.a.a().a(tapAdConfig);
                com.tapsdk.tapad.internal.o.a.b.a.a().c();
            }
        }
    }

    public void releaseAdNative(TapAdNative tapAdNative) {
        this.tapAdNativeSet.remove(tapAdNative);
    }

    public void requestPermissionIfNecessary(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : Arrays.asList("android.permission.READ_PHONE_STATE", g.g)) {
            if (!com.tapsdk.tapad.internal.utils.m.a(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            try {
                com.tapsdk.tapad.internal.utils.m.a(com.tapsdk.tapad.internal.utils.a.a(context), arrayList);
            } catch (Throwable th) {
                TapADLogger.e("request permission error:" + th);
            }
        }
    }

    public void uploadUserAction(UserAction[] userActionArr, Callback callback) {
        this.userActionModel.a(userActionArr, get().tapAdConfig).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(callback), new d(callback));
    }
}
