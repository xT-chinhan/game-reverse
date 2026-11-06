package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
public class AppWrapper {
    public static Context wrappApp(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        if (!applicationContext.getClassLoader().equals(context.getClassLoader())) {
            return new WrappedApp(context);
        }
        return context.getApplicationContext();
    }

    private static class WrappedApp extends Application {
        private final Context mBaseContext;

        WrappedApp(Context context) {
            this.mBaseContext = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public ApplicationInfo getApplicationInfo() {
            return this.mBaseContext.getApplicationInfo();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return this.mBaseContext;
        }
    }
}
