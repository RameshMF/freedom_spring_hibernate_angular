<div class="navbar" data-ng-controller="HeaderController">
    <div class="navbar-inner">
        <div class="sidebar-pusher">
            <a href=""  data-toggle="dropdown"  class="dropdown-toggle push-sidebar">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <div class="logo-box">
            <a href="" class="logo-text logo-custom"><span><img class="imglogo" id="logo-main" src="resources/images/freedom-icon.png"  alt=""></span></a>
        </div>
		<div class="top-menu">
			<ul class="list-inline top-nav noMargin dropdown-menu-right">
				<li>
					<label>Site:</label>
				</li>
              	<li>
			        <select class="selectpicker show-tick" data-width="130px">
			          	<option>Test</option>
	                    <option>Main</option>
			        </select>
               	</li>
				<li class="dropdown">
				    <button type="button" title="Alarm" class="btn btn-default dropdown-toggle"  data-toggle="dropdown"><i class="fa fa-bell"></i><span class="badge badge-danger pull-right dropdown-toggle">29</span>
					</button>	
					<ul class="dropdown-menu title-caret  dropdown-menu-right" role="menu">
						<li class="dropdown-menu-list slimscroll tasks">
							<ul class="list-unstyled">
								<li>
									<a href="">
										<span class="pull-left text-color">Main</span>
										<span class="pull-right text-color">13</span>
									</a>
								</li>
								<li>
									<a href="">
										<span class="pull-left text-color">empty</span>
										<span class="pull-right text-color">9</span>
									</a>
								</li>
								<li>
									<a href="">
										<span class="pull-left text-color">ABC</span>
										<span class="pull-right text-color">4</span>
									</a>
								</li>
								<li>
									<a href="">
										<span class="pull-left text-color">null</span>
										<span class="pull-right text-color">3</span>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="dropdown">
					<button type="button" title="Muster" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><i class="fa fa-asterisk"></i>
					</button>
					<ul class="dropdown-menu dropdown-list  dropdown-menu-right" role="menu">
						<li role="presentation"><a href="">Muster/Anti Passback</a></li>
	                    <li role="presentation"><a href="">Emer. Mustering</a></li>
					</ul>
				</li>
				<li class="dropdown">
				    <button type="button" title="Settings" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-cogs"></i>
					</button>
					<ul class="dropdown-menu  dropdown-menu-right" role="menu">
						<li role="presentation" class="disabled"><a href="">Admin: admin</a></li>
						<li role="presentation" class="disabled"><a href="">Server Mode: Main</a></li>
						<li role="presentation" class="disabled"><a href="">Hostname: ip-192-168-0-78</a></li>
						<li role="presentation"><a href="" ng-click="showDatabaseConfig()" class="editButton">Database Config</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation" ng-click="userLogout()"><a href=""><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
					</ul>
				</li>
			</ul>
			<form id="logoutForm" action="<%=request.getContextPath()%>/user/logout" method="POST"></form>
		</div>
    </div>
</div>