package com.taptap.sdk.login.impl.ui.fragment;

import android.app.Fragment;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginTypes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DefaultTapLoginFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/DefaultTapLoginFragmentProvider;", "Lcom/taptap/sdk/login/impl/ui/fragment/TapLoginFragmentProvider;", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "(Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;)V", "generateTrackInfo", "", "trackInfo", "loginType", "provide", "Landroid/app/Fragment;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultTapLoginFragmentProvider implements TapLoginFragmentProvider {
    private final TapFragmentLoginCallback callback;

    /* JADX INFO: compiled from: DefaultTapLoginFragmentProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTypes.values().length];
            try {
                iArr[LoginTypes.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LoginTypes.CLOUD_GAME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LoginTypes.WEB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultTapLoginFragmentProvider(TapFragmentLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // com.taptap.sdk.login.impl.ui.fragment.TapLoginFragmentProvider
    public Fragment provide(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LoginRequest newRequest = request.copy((524255 & 1) != 0 ? request.state : null, (524255 & 2) != 0 ? request.clientId : null, (524255 & 4) != 0 ? request.scopes : null, (524255 & 8) != 0 ? request.versionCode : null, (524255 & 16) != 0 ? request.info : null, (524255 & 32) != 0 ? request.trackInfo : generateTrackInfo(request.getTrackInfo(), request.getLoginType()), (524255 & 64) != 0 ? request.regionType : null, (524255 & 128) != 0 ? request.preApproved : false, (524255 & 256) != 0 ? request.phoneVerifyToken : null, (524255 & 512) != 0 ? request.preferredLoginType : null, (524255 & 1024) != 0 ? request.loginVersion : null, (524255 & 2048) != 0 ? request.responseType : null, (524255 & 4096) != 0 ? request.redirectUri : null, (524255 & 8192) != 0 ? request.codeVerifier : null, (524255 & 16384) != 0 ? request.codeChallengeMethod : null, (524255 & 32768) != 0 ? request.isAuth : false, (524255 & 65536) != 0 ? request.loginType : null, (524255 & 131072) != 0 ? request.sessionId : null, (524255 & 262144) != 0 ? request.screenOrientation : 0);
        switch (WhenMappings.$EnumSwitchMapping$0[LoginTypes.INSTANCE.from(request.getLoginType()).ordinal()]) {
            case 1:
                return ClientLoginFragment.INSTANCE.newInstance(newRequest, this.callback);
            case 2:
                return CloudGameFragment.INSTANCE.newInstance(newRequest, this.callback);
            case 3:
                return WebLoginFragment.INSTANCE.newInstance(newRequest, this.callback);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String generateTrackInfo(String trackInfo, String loginType) throws JSONException {
        JSONObject $this$generateTrackInfo_u24lambda_u240 = new JSONObject(trackInfo);
        $this$generateTrackInfo_u24lambda_u240.put("tapsdk_login_type", loginType);
        String string = $this$generateTrackInfo_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(trackInfo)\n  …}\n            .toString()");
        return string;
    }
}
