package com.varbto.utils.crash;

import android.content.Context;
import android.util.Log;
import com.varbto.internal.f;

/* JADX INFO: loaded from: classes3.dex */
public class CrashHandlerBuilder {
    public final Context a;
    public CrashAttributionService b;
    public CrashRecorder c;
    public boolean d = true;
    public boolean e = true;
    public boolean f = false;

    public CrashHandlerBuilder(Context context) {
        this.a = context.getApplicationContext();
    }

    public CrashHandler build() {
        if (f.a) {
            Log.d("CrashHandlerBuilder", "Building CrashHandler, saveStack: " + this.e + ", attribution: " + this.f);
        }
        if (!this.f) {
            this.b = null;
        } else if (this.b == null) {
            this.b = new DefaultCrashAttributionService();
        }
        if (this.c == null) {
            this.c = new LoggingCrashRecorder(this.a, this.e);
        }
        CrashHandler crashHandler = new CrashHandler(this.a, this.b, this.c);
        if (this.d) {
            if (f.a) {
                Log.d("CrashHandlerBuilder", "Installing crash handler immediately");
            }
            crashHandler.install();
        }
        if (f.a) {
            Log.d("CrashHandlerBuilder", "CrashHandler built successfully");
        }
        return crashHandler;
    }

    public CrashHandlerBuilder setAttributionService(CrashAttributionService crashAttributionService) {
        this.b = crashAttributionService;
        return this;
    }

    public CrashHandlerBuilder setCrashRecorder(CrashRecorder crashRecorder) {
        this.c = crashRecorder;
        return this;
    }

    public CrashHandlerBuilder setEnableAttribution(boolean z) {
        this.f = z;
        return this;
    }

    public CrashHandlerBuilder setSaveStackSwitch(boolean z) {
        this.e = z;
        return this;
    }

    public CrashHandlerBuilder setStartImmediately(boolean z) {
        this.d = z;
        return this;
    }
}
