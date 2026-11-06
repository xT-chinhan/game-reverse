package com.tapsdk.tapad.internal.oaid.sources;

import android.content.Context;
import com.tapsdk.tapad.internal.oaid.OAIDErrorReporterImpl;
import com.tapsdk.tapad.oaid.impl.OAIDFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class OaidSourceHelper {
    private static final String TAG = "OaidSourceHelper";
    private static volatile OAIDFactory cachedFactory;
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    private OaidSourceHelper() {
    }

    public static OAIDFactory getFactory(Context context) {
        if (context == null) {
            return cachedFactory;
        }
        if (cachedFactory != null) {
            return cachedFactory;
        }
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                try {
                    cachedFactory = OAIDFactory.createCacheOnly(applicationContext, new OAIDErrorReporterImpl());
                } catch (Exception e) {
                    cachedFactory = OAIDFactory.createCacheOnly(applicationContext, null);
                }
            } else {
                atomicBoolean.set(false);
            }
        }
        return cachedFactory;
    }
}
