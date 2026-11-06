package com.taptap.sdk.login;

import android.content.Context;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.login.impl.LoginTracker;
import com.taptap.sdk.login.impl.core.AccountManager;
import com.taptap.sdk.login.impl.core.LoginManager;
import com.taptap.sdk.login.impl.core.LoginRequestBuilder;
import com.taptap.sdk.login.impl.core.LoginResponseHandler;
import com.taptap.sdk.login.impl.data.model.Orientation;
import com.taptap.sdk.login.impl.repository.LoginRepository;
import com.taptap.sdk.login.impl.statemachine.state.LoginStateManager;
import com.taptap.sdk.startup.task.InitializeTask;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: LoginInitializeTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/LoginInitializeTask;", "Lcom/taptap/sdk/startup/task/InitializeTask;", "()V", "execute", "", d.R, "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginInitializeTask implements InitializeTask {
    @Override // com.taptap.sdk.startup.task.InitializeTask
    public void execute(Context context, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        AccountManager.INSTANCE.configure(new AccountManager.Builder(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)))).applyRepository(LoginRepository.INSTANCE.getInstance(options))).initialize();
        LoginManager.INSTANCE.configure(new LoginManager.Builder(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)))).applyRequestBuilder(new LoginRequestBuilder(options.getClientId(), options.getRegion(), Orientation.INSTANCE.from(options.getScreenOrientation()))).applyTracker(LoginTracker.INSTANCE).applyStateManager(new LoginStateManager()).applyResponseHandler(new LoginResponseHandler(LoginRepository.INSTANCE.getInstance(options), AccountManager.INSTANCE.getInstance())).applySdkOptions(options)).initialize();
        LoginTracker.INSTANCE.trackInit$tap_login_release();
    }
}
