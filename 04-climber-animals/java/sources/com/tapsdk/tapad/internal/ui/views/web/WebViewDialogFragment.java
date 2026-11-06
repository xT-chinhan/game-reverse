package com.tapsdk.tapad.internal.ui.views.web;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.utils.j;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewDialogFragment extends com.tapsdk.tapad.internal.v.b.a {
    protected static final String ARGUMENT_ADINFO = "argument_list_adinfo";
    protected static final String ARGUMENT_AUTO_CLOSE = "argument_auto_close";
    protected static final String ARGUMENT_IS_LANDING_PAGE = "argument_is_landing_page";
    protected static final String ARGUMENT_LIST_DYNAMIC_HEADERS = "argument_list_dynamic_headers";
    protected static final String ARGUMENT_TITLE = "argument_title";
    protected static final String ARGUMENT_URL = "argument_url";
    public static final String TAG = "WebViewDialogFragment";
    public static final String WEIXIN = "weixin";
    private AdInfo adInfo;
    protected ADWebView containerWebView;
    protected ADWebView.e tdsWebViewClientDelegate;
    protected ImageView webBackImageView;
    protected ImageView webCloseImageView;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WebViewDialogFragment.this.containerWebView.canGoBack()) {
                WebViewDialogFragment.this.containerWebView.goBack();
            } else {
                WebViewDialogFragment.this.dismissIfShowing();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewDialogFragment.this.dismiss();
        }
    }

    class c implements ADWebView.e {
        c() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a(String str) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void b(String str) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void c(String str) {
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WebViewDialogFragment.this.dismissIfShowing();
        }
    }

    private void bindView(View view) {
        this.webBackImageView = (ImageView) view.findViewById(R.id.webBackImageView);
        this.webCloseImageView = (ImageView) view.findViewById(R.id.webCloseImageView);
        this.containerWebView = (ADWebView) view.findViewById(R.id.containerWebView);
    }

    private void loadWebView() {
        Bundle arguments;
        AdInfo adInfo;
        Activity activity = getActivity();
        if (activity == null || activity.isDestroyed() || (arguments = getArguments()) == null) {
            return;
        }
        String string = arguments.getString(ARGUMENT_URL, "");
        try {
            adInfo = (AdInfo) arguments.getParcelable(ARGUMENT_ADINFO);
        } catch (Throwable unused) {
            adInfo = null;
        }
        if (adInfo != null) {
            if (arguments.getBoolean(ARGUMENT_IS_LANDING_PAGE, true)) {
                this.containerWebView.setMonitorUrls(adInfo.innerBrowserMonitorUrls);
            }
            this.containerWebView.setTrackId(adInfo.trackId);
            this.containerWebView.setSampleRatio(adInfo.sampleRatioComplianceOpen);
            this.containerWebView.enableSdkDebugLog(adInfo.isEnableSdkLog().booleanValue());
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        ArrayList parcelableArrayList = arguments.getParcelableArrayList(ARGUMENT_LIST_DYNAMIC_HEADERS);
        HashMap map = new HashMap();
        if (parcelableArrayList != null) {
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                map.putAll(com.tapsdk.tapad.internal.network.c.a.a(parcelableArrayList));
            }
        }
        if (map.size() > 0) {
            this.containerWebView.loadUrl(string, map);
        } else {
            this.containerWebView.loadUrl(string);
        }
        if (arguments.getBoolean(ARGUMENT_AUTO_CLOSE, false)) {
            new Handler().postDelayed(new d(), com.anythink.basead.exoplayer.i.a.f);
        }
    }

    @Deprecated
    public static WebViewDialogFragment newInstance(String str, String str2, boolean z) {
        return newInstance(str, str2, z, null, null);
    }

    public static WebViewDialogFragment newInstance(String str, String str2, boolean z, AdInfo adInfo) {
        Bundle bundle = new Bundle();
        WebViewDialogFragment webViewDialogFragment = new WebViewDialogFragment();
        webViewDialogFragment.setArguments(bundle);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(ARGUMENT_TITLE, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(ARGUMENT_URL, str2);
        }
        bundle.putBoolean(ARGUMENT_AUTO_CLOSE, z);
        bundle.putBoolean(ARGUMENT_IS_LANDING_PAGE, false);
        if (adInfo != null) {
            bundle.putParcelable(ARGUMENT_ADINFO, adInfo);
        }
        return webViewDialogFragment;
    }

    public static WebViewDialogFragment newInstance(String str, String str2, boolean z, List<DynamicHeader> list) {
        return newInstance(str, str2, z, list, null);
    }

    public static WebViewDialogFragment newInstance(String str, String str2, boolean z, List<DynamicHeader> list, AdInfo adInfo) {
        Bundle bundle = new Bundle();
        WebViewDialogFragment webViewDialogFragment = new WebViewDialogFragment();
        webViewDialogFragment.setArguments(bundle);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(ARGUMENT_TITLE, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(ARGUMENT_URL, str2);
        }
        bundle.putBoolean(ARGUMENT_AUTO_CLOSE, z);
        if (list != null && list.size() > 0) {
            bundle.putParcelableArrayList(ARGUMENT_LIST_DYNAMIC_HEADERS, new ArrayList<>(list));
        }
        if (adInfo != null) {
            bundle.putParcelable(ARGUMENT_ADINFO, adInfo);
        }
        return webViewDialogFragment;
    }

    protected void initView() {
        Activity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        this.webBackImageView.setOnClickListener(new a());
        this.webCloseImageView.setOnClickListener(new b());
        ADWebView.e eVar = this.tdsWebViewClientDelegate;
        if (eVar != null) {
            this.containerWebView.setWebViewClientDelegate(eVar);
        } else {
            this.containerWebView.setWebViewClientDelegate(new c());
        }
        loadWebView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, android.R.style.Theme.DeviceDefault.NoActionBar.TranslucentDecor);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tapad_common_webview_fullscreen, viewGroup, false);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Activity activity = getActivity();
        Dialog dialog = getDialog();
        if (activity == null || activity.isDestroyed() || dialog == null || dialog.getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setAttributes(attributes);
        dialog.getWindow().setFlags(1024, 1024);
        j.c(getDialog().getWindow());
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindView(view);
        initView();
    }

    public void setWebViewClientDelegate(ADWebView.e eVar) {
        this.tdsWebViewClientDelegate = eVar;
    }
}
