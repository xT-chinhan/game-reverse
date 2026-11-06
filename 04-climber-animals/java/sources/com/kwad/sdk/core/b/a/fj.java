package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fj implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.a.C0504a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.a.C0504a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.a.C0504a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.a.C0504a c0504a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0504a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0504a.SDKVersion)) {
            c0504a.SDKVersion = "";
        }
        c0504a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0504a.aHz = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0504a.aHz)) {
            c0504a.aHz = "";
        }
        c0504a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0504a.sdkApiVersion)) {
            c0504a.sdkApiVersion = "";
        }
        c0504a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0504a.sdkType = jSONObject.optInt("sdkType");
        c0504a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0504a.appVersion)) {
            c0504a.appVersion = "";
        }
        c0504a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0504a.appName)) {
            c0504a.appName = "";
        }
        c0504a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0504a.appId)) {
            c0504a.appId = "";
        }
        c0504a.aNI = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0504a.aNI)) {
            c0504a.aNI = "";
        }
        c0504a.aIo = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0504a.aIo)) {
            c0504a.aIo = "";
        }
        c0504a.aIn = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0504a.aIn)) {
            c0504a.aIn = "";
        }
        c0504a.adg = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0504a.adg)) {
            c0504a.adg = "";
        }
        c0504a.adh = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0504a.adh)) {
            c0504a.adh = "";
        }
        c0504a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0504a.model)) {
            c0504a.model = "";
        }
        c0504a.LN = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0504a.LN)) {
            c0504a.LN = "";
        }
        c0504a.adi = jSONObject.optInt("osType");
        c0504a.adj = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0504a.adj)) {
            c0504a.adj = "";
        }
        c0504a.adk = jSONObject.optInt("osApi");
        c0504a.adl = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0504a.adl)) {
            c0504a.adl = "";
        }
        c0504a.adm = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0504a.adm)) {
            c0504a.adm = "";
        }
        c0504a.aNJ = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c0504a.aNJ)) {
            c0504a.aNJ = "";
        }
        c0504a.aNK = jSONObject.optBoolean("isDynamic");
        c0504a.Qw = jSONObject.optInt("screenWidth");
        c0504a.Qv = jSONObject.optInt("screenHeight");
        c0504a.aCk = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0504a.aCk)) {
            c0504a.aCk = "";
        }
        c0504a.aCl = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0504a.aCl)) {
            c0504a.aCl = "";
        }
        c0504a.aIk = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0504a.aIk)) {
            c0504a.aIk = "";
        }
        c0504a.aIB = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0504a.aIB)) {
            c0504a.aIB = "";
        }
        c0504a.adn = jSONObject.optInt("statusBarHeight");
        c0504a.ado = jSONObject.optInt("titleBarHeight");
        c0504a.aNL = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0504a.aNL)) {
            c0504a.aNL = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.a.C0504a c0504a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0504a.SDKVersion != null && !c0504a.SDKVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0504a.SDKVersion);
        }
        if (c0504a.SDKVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", c0504a.SDKVersionCode);
        }
        if (c0504a.aHz != null && !c0504a.aHz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0504a.aHz);
        }
        if (c0504a.sdkApiVersion != null && !c0504a.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0504a.sdkApiVersion);
        }
        if (c0504a.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", c0504a.sdkApiVersionCode);
        }
        if (c0504a.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", c0504a.sdkType);
        }
        if (c0504a.appVersion != null && !c0504a.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0504a.appVersion);
        }
        if (c0504a.appName != null && !c0504a.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", c0504a.appName);
        }
        if (c0504a.appId != null && !c0504a.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", c0504a.appId);
        }
        if (c0504a.aNI != null && !c0504a.aNI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0504a.aNI);
        }
        if (c0504a.aIo != null && !c0504a.aIo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0504a.aIo);
        }
        if (c0504a.aIn != null && !c0504a.aIn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0504a.aIn);
        }
        if (c0504a.adg != null && !c0504a.adg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0504a.adg);
        }
        if (c0504a.adh != null && !c0504a.adh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0504a.adh);
        }
        if (c0504a.model != null && !c0504a.model.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "model", c0504a.model);
        }
        if (c0504a.LN != null && !c0504a.LN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0504a.LN);
        }
        if (c0504a.adi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", c0504a.adi);
        }
        if (c0504a.adj != null && !c0504a.adj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0504a.adj);
        }
        if (c0504a.adk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", c0504a.adk);
        }
        if (c0504a.adl != null && !c0504a.adl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", c0504a.adl);
        }
        if (c0504a.adm != null && !c0504a.adm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0504a.adm);
        }
        if (c0504a.aNJ != null && !c0504a.aNJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uuid", c0504a.aNJ);
        }
        if (c0504a.aNK) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", c0504a.aNK);
        }
        if (c0504a.Qw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", c0504a.Qw);
        }
        if (c0504a.Qv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", c0504a.Qv);
        }
        if (c0504a.aCk != null && !c0504a.aCk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", c0504a.aCk);
        }
        if (c0504a.aCl != null && !c0504a.aCl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0504a.aCl);
        }
        if (c0504a.aIk != null && !c0504a.aIk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0504a.aIk);
        }
        if (c0504a.aIB != null && !c0504a.aIB.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", c0504a.aIB);
        }
        if (c0504a.adn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", c0504a.adn);
        }
        if (c0504a.ado != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", c0504a.ado);
        }
        if (c0504a.aNL != null && !c0504a.aNL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0504a.aNL);
        }
        return jSONObject;
    }
}
