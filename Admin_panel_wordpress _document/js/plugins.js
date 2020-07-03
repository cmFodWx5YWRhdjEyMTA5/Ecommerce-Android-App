$(document).ready(function() {

	$('#cssmenu > ul > li ul').each(function(index, e) {
		var count = $(e).find('li').length;
		var content = '<span class=\"cnt\">' + count + '</span>';
		$(e).closest('li').children('a').append(content);
	});
	$('#cssmenu ul ul li:odd').addClass('odd');
	$('#cssmenu ul ul li:even').addClass('even');
	$('#cssmenu > ul > li > a').click(function() {
		$('#cssmenu li').removeClass('active');
		$(this).closest('li').addClass('active');
		var checkElement = $(this).next();
		if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
			$(this).closest('li').removeClass('active');
			checkElement.slideUp('normal');
		}
		if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
			$('#cssmenu ul ul:visible').slideUp('normal');
			checkElement.slideDown('normal');
		}
		if ($(this).closest('li').find('ul').children().length == 0) {
			return true;
		} else {
			return false;
		}
	});

	$(document).on("scroll", onScroll);

	//smoothscroll
	$('a[href^="#"]').on('click', function(e) {
		e.preventDefault();
		$(document).off("scroll");

		$('a').each(function() {
			$(this).removeClass('active');
		})
		$(this).addClass('active');

		var target = this.hash,
			menu = target;
		$target = $(target);
		$('html, body').stop().animate({
			'scrollTop': $target.offset().top + 2
		}, 500, 'swing', function() {
			window.location.hash = target;
			$(document).on("scroll", onScroll);
		});
	});

	function onScroll(event) {
		var scrollPos = $(document).scrollTop();
		$('#cssmenu a').each(function() {
			var currLink = $(this);
			var refElement = $(currLink.attr("href"));
			if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
				$('#cssmenu ul li a').removeClass("active");
				currLink.addClass("active");
			} else {
				currLink.removeClass("active");
			}
		});
	}



});

(function($) {
	"use strict";
	window.prettyPrint && prettyPrint();



	jQuery("#load").fadeOut();
	jQuery("#loading").delay(0).fadeOut("slow");


	/************************************************
	RETINA DISPLAY
	************************************************/
	! function() {
		function t() {}

		function e(t) {
			return r.retinaImageSuffix + t
		}

		function i(t, i) {
			if (this.path = t || "", "undefined" != typeof i && null !== i) this.at_2x_path = i, this.perform_check = !1;
			else {
				if (void 0 !== document.createElement) {
					var n = document.createElement("a");
					n.href = this.path, n.pathname = n.pathname.replace(o, e), this.at_2x_path = n.href
				} else {
					var a = this.path.split("?");
					a[0] = a[0].replace(o, e), this.at_2x_path = a.join("?")
				}
				this.perform_check = !0
			}
		}

		function n(t) {
			this.el = t, this.path = new i(this.el.getAttribute("src"), this.el.getAttribute("data-at2x"));
			var e = this;
			this.path.check_2x_variant(function(t) {
				t && e.swap()
			})
		}
		var a = "undefined" == typeof exports ? window : exports,
			r = {
				retinaImageSuffix: "@2x",
				check_mime_type: !0,
				force_original_dimensions: !0
			};
		a.Retina = t, t.configure = function(t) {
			null === t && (t = {});
			for (var e in t) t.hasOwnProperty(e) && (r[e] = t[e])
		}, t.init = function(t) {
			null === t && (t = a);
			var e = t.onload || function() {};
			t.onload = function() {
				var t, i, a = document.getElementsByTagName("img"),
					r = [];
				for (t = 0; t < a.length; t += 1) i = a[t], i.getAttributeNode("data-no-retina") || r.push(new n(i));
				e()
			}
		}, t.isRetina = function() {
			var t = "(-webkit-min-device-pixel-ratio: 1.5), (min--moz-device-pixel-ratio: 1.5), (-o-min-device-pixel-ratio: 3/2), (min-resolution: 1.5dppx)";
			return a.devicePixelRatio > 1 ? !0 : a.matchMedia && a.matchMedia(t).matches ? !0 : !1
		};
		var o = /\.\w+$/;
		a.RetinaImagePath = i, i.confirmed_paths = [], i.prototype.is_external = function() {
			return !(!this.path.match(/^https?\:/i) || this.path.match("//" + document.domain))
		}, i.prototype.check_2x_variant = function(t) {
			var e, n = this;
			return this.is_external() ? t(!1) : this.perform_check || "undefined" == typeof this.at_2x_path || null === this.at_2x_path ? this.at_2x_path in i.confirmed_paths ? t(!0) : (e = new XMLHttpRequest, e.open("HEAD", this.at_2x_path), e.onreadystatechange = function() {
				if (4 !== e.readyState) return t(!1);
				if (e.status >= 200 && e.status <= 399) {
					if (r.check_mime_type) {
						var a = e.getResponseHeader("Content-Type");
						if (null === a || !a.match(/^image/i)) return t(!1)
					}
					return i.confirmed_paths.push(n.at_2x_path), t(!0)
				}
				return t(!1)
			}, e.send(), void 0) : t(!0)
		}, a.RetinaImage = n, n.prototype.swap = function(t) {
			function e() {
				i.el.complete ? (r.force_original_dimensions && (i.el.setAttribute("width", i.el.offsetWidth), i.el.setAttribute("height", i.el.offsetHeight)), i.el.setAttribute("src", t)) : setTimeout(e, 5)
			}
			"undefined" == typeof t && (t = this.path.at_2x_path);
			var i = this;
			e()
		}, t.isRetina() && t.init(a)
	}();
})(jQuery);