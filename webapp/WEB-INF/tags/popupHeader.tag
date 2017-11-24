<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="popupId" required="false"%>
<div class="popupheader">
	<div id="cover" ng-show="isLoading"></div>
	<div>
	   <div class="pull-left popupModalTitle highlight-white fontSize16">${title}</div>
	 <!--  <div class="pull-right">
		<img alt="" class="popupHeaderIcon" src="resources/images/PALogoSmall.png">
	  </div> -->
	</div>
</div>
