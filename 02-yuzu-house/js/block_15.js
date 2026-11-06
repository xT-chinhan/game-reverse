(function() {
  "use strict";
  window.addEventListener("message", (e) => {
    var _a, _b, _c;
    if (e.source !== ((_a = document.getElementById("cottonFrame")) == null ? void 0 : _a.contentWindow) || ((_b = e.data) == null ? void 0 : _b.channel) !== "cotton-theatre" || e.data.type !== "closet-theme") return;
    const overlay = document.getElementById("wardrobeOverlay");
    overlay.classList.remove("wardrobe-night");
    overlay.dataset.roomTime = ((_c = e.data.payload) == null ? void 0 : _c.night) ? "night" : "day";
  });
})();
