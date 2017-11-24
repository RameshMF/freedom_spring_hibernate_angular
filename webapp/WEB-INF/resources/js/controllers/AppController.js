app.controller('AppController', function AppController($scope, $rootScope, $location) {

	$rootScope.activeDatabase = {};
	$rootScope.isAuthenticatedUser = false;
	$rootScope.isLoading = false;
	
	$scope.showDatabaseUsers = function() {
		$location.path("databaseUser");
	};

	$scope.showUserRecords = function() {
		$location.path("viewUsers");
	};

	$(document).ready(function() {
		$(document).on("click", ".push-sidebar", function() {
			var e = $(".sidebar");
			e.hasClass("visible") ? (e.removeClass("visible"), $(".page-inner").removeClass("sidebar-visible")) : (e.addClass("visible"), $(".page-inner").addClass("sidebar-visible"));
		});

		$(".sidebar .accordion-menu li .sub-menu").slideUp(0), $(".sidebar .accordion-menu li.open .sub-menu").slideDown(0), $(".small-sidebar .sidebar .accordion-menu li.open .sub-menu").hide(0), $(document).on("click", ".sidebar .accordion-menu > li.droplink > a", function() {
			if (!$("body").hasClass("small-sidebar") && !$("body").hasClass("page-horizontal-bar") && !$("body").hasClass("hover-menu")) {
				{
					var e = $(".sidebar .menu"),
					n = ($(".page-sidebar-inner"), $(".page-content"), $(this).next());
					$(this);
				}
				return e.find("li").removeClass("open"), $(".sub-menu").slideUp(200, function() {
					o();
				}), o(), n.is(":visible") ? n.slideUp(200, function() {
					o();
				}) : ($(this).parent("li").addClass("open"), $(this).next(".sub-menu").slideDown(200, function() {
					o();
				})), !1;
			}
		});

		$(document).on("click", ".sidebar .accordion-menu .sub-menu li.droplink > a", function() {
			{
				if($(this).hasClass("report_access"))
				{
					$(".admin_access").next().hide();
					$(".admin_access").parent().removeClass("open");
					$(".utility_access").next().hide();
					$(".utility_access").parent().removeClass("open");
				}
				else if($(this).hasClass("admin_access"))
				{
					$(".report_access").next().hide();
					$(".report_access").parent().removeClass("open");
					$(".utility_access").next().hide();
					$(".utility_access").parent().removeClass("open");
				}
				else if($(this).hasClass("utility_access"))
				{
					$(".report_access").next().hide();
					$(".report_access").parent().removeClass("open");
					$(".admin_access").next().hide();
					$(".admin_access").parent().removeClass("open");
				}
				var e = $(this).parent().parent(),
				n = ($(".page-sidebar-inner"), $(".page-content"), $(this).next());
				$(this);
			}
			return e.find("li").removeClass("open"), o(), n.is(":visible") ? n.slideUp(200, function() {
				o();
			}) : ($(this).parent("li").addClass("open"), $(this).next(".sub-menu").slideDown(200, function() {
				o();
			})), !1;
		});

		var o = function() {
			{
				var e, n = $(".page-inner"),
				a = $(".page-sidebar"),
				s = $("body"),
				i = $(".page-footer").outerHeight();
				$(".page-content").height();
			}
			n.attr("style", "min-height:" + a.height() + "px !important"), s.hasClass("page-sidebar-fixed") ? e = a.height() + i : (e = a.height() + i, e < $(window).height() && (e = $(window).height())), e >= n.height() && n.attr("style", "min-height:" + e + "px !important");
		};
		o();

		$(document).on("click", ".accordion-menu li", function() {
			var ch = $(".accordion-menu").children();
			$.each(ch,function(i,v){
				$(v).removeClass("active");
			});
			$(this).addClass("active");
		});

		$(document).on("click", ".sub-menu li", function() {
			var mainUl = $(".sub-menu li");
			$.each(mainUl,function(i,v){
				if($(v).hasClass("aonsubmenu")) {
					$(v).removeClass("aonsubmenu");
				}
			});
			$(this).removeClass("active").addClass("aonsubmenu");
			$(this).parent().parent().addClass("active");
			var subEle = $(this).parent().parent();
			if($(subEle).hasClass("open")) {
				$(subEle).parent().parent().addClass("active");
			}
			$(".dropdown").removeClass("open");
			$(".bootstrap-select").removeClass("open");
			return false;
		});
	});
	
});
