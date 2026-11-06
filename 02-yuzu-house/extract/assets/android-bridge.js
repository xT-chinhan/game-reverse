(function() {
  window.CottonNativeCapabilities = { launcherPresetsOnly: true };
  const style = document.createElement("style");
  style.textContent = "html.yuzu-native-overlay,html.yuzu-native-overlay body{background:transparent!important;overflow:hidden!important;touch-action:none}html.yuzu-native-overlay body>*{visibility:hidden!important}html.yuzu-native-overlay #puppetFrameDock,html.yuzu-native-overlay #petActor{visibility:visible!important}html.yuzu-native-overlay #petFloatingBar{display:none!important}html.yuzu-native-overlay body.multiple-pets .multi-pet.selected{visibility:visible!important}html.yuzu-native-overlay .multi-pet-tools{visibility:hidden!important}html.yuzu-native-overlay .multi-pet.selected:after{display:none!important}";
  document.head.append(style);
  document.addEventListener("click", (e) => {
    var _a, _b, _c, _d;
    if (!((_b = (_a = e.target).closest) == null ? void 0 : _b.call(_a, "#petFloat")) || !YuzuAndroid.floatPet) return;
    const state = (_c = window.CottonPetHost) == null ? void 0 : _c.getStatus();
    if (!(state == null ? void 0 : state.active)) return;
    e.preventDefault();
    e.stopImmediatePropagation();
    CottonPetHost.prepareNativeOverlay();
    try {
      const multi = (_d = window.CottonMultiplePets) == null ? void 0 : _d.getStatus(), picked = multi == null ? void 0 : multi.pets.find((p) => p.id === multi.selected);
      const scale = state.mode === "live" ? state.liveSize : (picked == null ? void 0 : picked.scale) || state.petScale;
      if (YuzuAndroid.configurePetGroup) YuzuAndroid.configurePetGroup(state.mode === "pet" && !!(multi == null ? void 0 : multi.count));
      YuzuAndroid.floatPet(!!state.camera, !!state.microphone, scale, state.mode === "live");
    } catch (err) {
      CottonPetHost.cancelNativeOverlay();
      throw err;
    }
  }, true);
  window.addEventListener("cotton-pet-scale", (e) => {
    if (YuzuAndroid.resizePet) YuzuAndroid.resizePet(e.detail);
  });
  window.addEventListener("cotton-app-icon-change", (e) => {
    if (YuzuAndroid.icon) YuzuAndroid.icon(e.detail.id, e.detail.src);
  });
  let pendingSave = null;
  window.addEventListener("cotton-export-result", (e) => {
    var _a, _b;
    const pending = pendingSave;
    if (!pending) return;
    pendingSave = null;
    if ((_a = e.detail) == null ? void 0 : _a.success) pending.resolve(e.detail);
    else {
      const error = Error(((_b = e.detail) == null ? void 0 : _b.message) || "保存失败，请重试");
      error.nativeNotified = true;
      pending.reject(error);
    }
  });
  async function saveBlob(blob, name) {
    if (pendingSave) throw Error("请先完成上一次保存");
    let begun = false;
    const result = new Promise((resolve, reject) => {
      pendingSave = { resolve, reject };
    });
    result.catch(() => {
    });
    try {
      if (!YuzuAndroid.begin(name || "柚松屋导出", blob.type)) throw Error("无法开始保存，请重试");
      begun = true;
      for (let i = 0; i < blob.size; i += 49152) {
        const bytes = new Uint8Array(await blob.slice(i, i + 49152).arrayBuffer());
        let text = "";
        for (const v of bytes) text += String.fromCharCode(v);
        if (!YuzuAndroid.chunk(btoa(text))) throw Error("文件传输失败");
      }
      YuzuAndroid.complete();
      begun = false;
    } catch (error) {
      if (begun) YuzuAndroid.cancel();
      const pending = pendingSave;
      pendingSave = null;
      pending == null ? void 0 : pending.reject(error);
    }
    return result;
  }
  window.CottonAndroidExports = { saveBlob };
  const hooked = /* @__PURE__ */ new WeakSet();
  function hook(doc) {
    if (hooked.has(doc)) return;
    hooked.add(doc);
    const downloadable = (a) => a && a.hasAttribute("download") && (a.href.startsWith("blob:") || a.href.startsWith("data:"));
    async function save(a) {
      try {
        const blob = await (await doc.defaultView.fetch(a.href)).blob();
        await saveBlob(blob, a.download || "柚松屋导出");
      } catch (err) {
        if (!err.nativeNotified) alert(err.message);
      }
    }
    const anchors = doc.defaultView.HTMLAnchorElement.prototype, originalClick = anchors.click;
    anchors.click = function() {
      if (downloadable(this)) {
        void save(this);
        return;
      }
      return originalClick.apply(this, arguments);
    };
    doc.addEventListener("click", (e) => {
      var _a, _b;
      const a = (_b = (_a = e.target).closest) == null ? void 0 : _b.call(_a, "a[download]");
      if (!downloadable(a)) return;
      e.preventDefault();
      e.stopImmediatePropagation();
      void save(a);
    }, true);
    function frame(f) {
      if (!f.dataset.androidDownloads) {
        f.dataset.androidDownloads = "1";
        f.addEventListener("load", () => {
          try {
            hook(f.contentDocument);
          } catch (e) {
          }
        });
      }
      try {
        if (f.contentDocument) hook(f.contentDocument);
      } catch (e) {
      }
    }
    new MutationObserver((changes) => {
      for (const change of changes) for (const n of change.addedNodes) {
        if (n.nodeType !== 1) continue;
        if (n.tagName === "IFRAME") frame(n);
        for (const f of n.querySelectorAll("iframe")) frame(f);
      }
    }).observe(doc, { childList: true, subtree: true });
    for (const f of doc.querySelectorAll("iframe")) frame(f);
  }
  hook(document);
})();
