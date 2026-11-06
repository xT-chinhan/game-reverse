package com.tapsdk.tapad.internal.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.utils.a$a, reason: collision with other inner class name */
    static class C0644a implements ObservableOnSubscribe<Activity> {
        C0644a() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Activity> observableEmitter) throws Exception {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                boolean z = false;
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(objInvoke);
                if (map == null) {
                    observableEmitter.onError(new Throwable("can't get top activity"));
                }
                if (map == null) {
                    observableEmitter.onError(new Throwable("can't get top activity"));
                    return;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity != null) {
                            TapADLogger.d("get Top Activity:" + activity.getComponentName() + "-" + activity.getClass().getSimpleName());
                        }
                        observableEmitter.onNext(activity);
                        z = true;
                        break;
                    }
                }
                if (z) {
                    TapADLogger.d("get Top Activity has result");
                    observableEmitter.onComplete();
                } else {
                    TapADLogger.d("get Top Activity has no result");
                    observableEmitter.onError(new Throwable("can't get top activity"));
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                TapADLogger.e("get Top Activity exception:" + e.getMessage());
                e.printStackTrace();
                observableEmitter.onError(new Throwable("can't get top activity"));
            }
        }
    }

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Observable<Activity> a() {
        return Observable.create(new C0644a());
    }

    public static boolean a(Activity activity) {
        return !b(activity);
    }

    public static boolean b(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
