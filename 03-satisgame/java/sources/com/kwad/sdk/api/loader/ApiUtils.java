package com.kwad.sdk.api.loader;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public class ApiUtils {
    public static Application getApplicationByReflection() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
