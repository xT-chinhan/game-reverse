package com.taptap.sdk.login.impl.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.impl.data.model.Actions;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity;
import com.taptap.sdk.login.impl.utils.CodeUtil;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ClientLoginFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\f\u0010\u001b\u001a\u00020\u0010*\u00020\u0006H\u0002J\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/ClientLoginFragment;", "Landroid/app/Fragment;", "()V", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ContainerViewManager.NAME, "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewCreated", "view", "convertAsBundle", "convertAsResponse", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClientLoginFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_RESPONSE = "com.taptap.sdk.response";
    private static final int REQUEST_CODE = 10;
    private static final String REQ_KEY_REQUEST = "com.taptap.sdk.request";
    private TapFragmentLoginCallback callback;
    private LoginRequest request;

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        LoginRequest loginRequest = arguments != null ? (LoginRequest) arguments.getParcelable(TapTapLoginActivity.EXTRAS_REQUEST) : null;
        this.request = loginRequest instanceof LoginRequest ? loginRequest : null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.activty_tap_login, container, false);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LoginRequest value = (LoginRequest) getArguments().getParcelable(TapTapLoginActivity.EXTRAS_REQUEST);
        if (value == null) {
            value = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable(TapTapLoginActivity.EXTRAS_REQUEST) : null;
        }
        this.request = value;
        if (savedInstanceState == null && value != null) {
            Actions action = Actions.INSTANCE.from(value.getRegionType());
            Intent intent = new Intent(action.getAction());
            intent.putExtra(REQ_KEY_REQUEST, convertAsBundle(value));
            getActivity().startActivityForResult(intent, 10);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            switch (resultCode) {
                case -1:
                    Bundle extra = data != null ? data.getBundleExtra(KEY_RESPONSE) : null;
                    if (extra == null) {
                        TapFragmentLoginCallback tapFragmentLoginCallback = this.callback;
                        if (tapFragmentLoginCallback != null) {
                            tapFragmentLoginCallback.onFail(new TapTapException("Fail to login"));
                        }
                    } else {
                        TapFragmentLoginCallback tapFragmentLoginCallback2 = this.callback;
                        if (tapFragmentLoginCallback2 != null) {
                            tapFragmentLoginCallback2.onSuccess(this.request, convertAsResponse(extra));
                        }
                    }
                    break;
                case 0:
                    TapFragmentLoginCallback tapFragmentLoginCallback3 = this.callback;
                    if (tapFragmentLoginCallback3 != null) {
                        tapFragmentLoginCallback3.onCancel(this.request);
                    }
                    break;
                default:
                    TapFragmentLoginCallback tapFragmentLoginCallback4 = this.callback;
                    if (tapFragmentLoginCallback4 != null) {
                        tapFragmentLoginCallback4.onFail(new TapTapException("Fail to login"));
                    }
                    break;
            }
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        LoginRequest value = this.request;
        if (value != null) {
            outState.putParcelable(TapTapLoginActivity.EXTRAS_REQUEST, value);
        }
    }

    private static final String convertAsBundle$encodeExtra(LoginRequest loginRequest) {
        TapJson tapJson = TapJson.INSTANCE;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("preapproved", Integer.valueOf(loginRequest.getPreApproved() ? 1 : 0)));
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return json.encodeToString(kSerializerSerializer, mapMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            return null;
        }
    }

    private final Bundle convertAsBundle(LoginRequest $this$convertAsBundle) {
        Bundle $this$convertAsBundle_u24lambda_u242 = new Bundle();
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.client_id", $this$convertAsBundle.getClientId());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.state", $this$convertAsBundle.getState());
        Collection $this$toTypedArray$iv = $this$convertAsBundle.getScopes();
        $this$convertAsBundle_u24lambda_u242.putStringArray("com.taptap.sdk.request.permissions", (String[]) $this$toTypedArray$iv.toArray(new String[0]));
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.sdk_version", $this$convertAsBundle.getVersionCode());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.info", $this$convertAsBundle.getInfo());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.track_info", $this$convertAsBundle.getTrackInfo());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.extra", convertAsBundle$encodeExtra($this$convertAsBundle));
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.login_version", $this$convertAsBundle.getLoginVersion());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.response_type", $this$convertAsBundle.getResponseType());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.redirect_uri", $this$convertAsBundle.getRedirectUri());
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.code_challenge", CodeUtil.INSTANCE.getCodeChallenge($this$convertAsBundle.getCodeVerifier()));
        $this$convertAsBundle_u24lambda_u242.putString("com.taptap.sdk.request.code_challenge_method", $this$convertAsBundle.getCodeChallengeMethod());
        return $this$convertAsBundle_u24lambda_u242;
    }

    private static final AccessToken convertAsResponse$convertAsAccessToken(Bundle $this$convertAsResponse_u24convertAsAccessToken) {
        String jsonStr = $this$convertAsResponse_u24convertAsAccessToken.getString("com.taptap.sdk.response.token");
        Object objDecodeFromString = null;
        if (jsonStr == null) {
            return null;
        }
        TapJson this_$iv = TapJson.INSTANCE;
        if (!(jsonStr.length() == 0)) {
            try {
                StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(AccessToken.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, jsonStr);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
        }
        AccessToken accessToken = (AccessToken) objDecodeFromString;
        return accessToken == null ? (AccessToken) $this$convertAsResponse_u24convertAsAccessToken.getParcelable("com.taptap.sdk.response.token.parcel") : accessToken;
    }

    private final LoginResponse convertAsResponse(Bundle $this$convertAsResponse) {
        String str;
        String str2;
        String str3;
        String id = $this$convertAsResponse.getString("com.taptap.sdk.response.state");
        if (id == null) {
            return null;
        }
        AccessToken accessTokenConvertAsResponse$convertAsAccessToken = convertAsResponse$convertAsAccessToken($this$convertAsResponse);
        String string = $this$convertAsResponse.getString("com.taptap.sdk.response.code");
        if (string != null) {
            str = string;
        } else {
            str = "";
        }
        String string2 = $this$convertAsResponse.getString("com.taptap.sdk.response.error");
        if (string2 != null) {
            str2 = string2;
        } else {
            str2 = "";
        }
        boolean z = $this$convertAsResponse.getBoolean("com.taptap.sdk.response.cancel", false);
        String string3 = $this$convertAsResponse.getString("com.taptap.sdk.response.server_uri");
        if (string3 != null) {
            str3 = string3;
        } else {
            str3 = "";
        }
        return new LoginResponse(id, accessTokenConvertAsResponse$convertAsAccessToken, str, str2, z, str3);
    }

    /* JADX INFO: compiled from: ClientLoginFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/ClientLoginFragment$Companion;", "", "()V", "KEY_RESPONSE", "", "REQUEST_CODE", "", "REQ_KEY_REQUEST", "newInstance", "Lcom/taptap/sdk/login/impl/ui/fragment/ClientLoginFragment;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClientLoginFragment newInstance(LoginRequest request, TapFragmentLoginCallback callback) {
            Intrinsics.checkNotNullParameter(request, "request");
            ClientLoginFragment fragment = new ClientLoginFragment();
            Bundle $this$newInstance_u24lambda_u240 = new Bundle();
            $this$newInstance_u24lambda_u240.putParcelable(TapTapLoginActivity.EXTRAS_REQUEST, request);
            fragment.setArguments($this$newInstance_u24lambda_u240);
            fragment.callback = callback;
            return fragment;
        }
    }
}
