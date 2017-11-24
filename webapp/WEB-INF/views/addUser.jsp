<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<o:pageHeader></o:pageHeader>
<div class="page-inner">
	<div class="col-lg-9 col-md-9 col-xs-12 col-sm-12 noPadding panal-border">
		<div class="page-breadcrumb">
	         <ol class="breadcrumb noPadding">
	             <li>Home</li>
	             <li>Add User</li>
	         </ol>
	     </div>
	     <div class="page-title">
	         <h3>Add User</h3>
	     </div>
		<div class="panel panel-default">
	     	<div class="panel-body">
	     		<form role="form" class="form-horizontal col-lg-12 col-md-12 margin-customize noPadding" name="addUserForm">
					<div class="noPadding">
						<div class="col-lg-11 col-md-11 noPadding">
							<div class="form-group ">
								<label for="lastName" class="col-lg-4 col-md-4 control-label">Last Name</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="Last Name">
								</div>
							</div>
							<div class="form-group ">
								<label for="firstName" class="col-lg-4 col-md-4 control-label">First Name</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="First Name">
								</div>
							</div>
							<div class="form-group ">
								<label for="displayInDirectory" class="col-lg-4 col-md-4 control-label">Display in Directory</label>
								<div class="col-lg-5 col-md-5" ng-init="radio1=1">
									<input type="radio" name="displayInDirectory" value="1">Yes</input> 
									<input type="radio" ng-model="radio1" name="displayInDirectory" value="0">No</input>
								</div>
							</div>
							<div class="form-group ">
								<label for="selectSuite" class="col-lg-4 col-md-4 control-label">Suite</label>
								<div class="col-lg-5 col-md-5">
									<select name="selectSuite" class="form-control">
										<option>None</option>
									</select>
								</div>
							</div>
							<div class="form-group ">
								<label for="firstName" class="col-lg-4 col-md-4 control-label">MESH Card Number</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="MESH Card Number">
								</div>
							</div>
							<div class="form-group ">
								<label for="firstName" class="col-lg-4 col-md-4 control-label">Wiegand Card Number</label>
								<div class="col-lg-5 col-md-5 margin-res">
									<input class="form-control" placeholder="Wiegand Card Number">
								</div>
								<div class="col-lg-2 col-md-2 ">
							         <button type="button" class="btn btn-primary custom-read-btn col-xs-12">Read Card</button>
								</div>
							</div>
							<div class="form-group ">
								<label for="firstName" class="col-lg-4 col-md-4 control-label">PIN</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="PIN">
								</div>
							</div>

							<div class="form-group ">
								<label for="email" class="col-lg-4 col-md-4 control-label">Email</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="Email">
								</div>
							</div>
							<div class="form-group ">
								<label for="telephone" class="col-lg-4 col-md-4 control-label">Telephone</label>
								<div class="col-lg-5 col-md-5">
									<input class="form-control" placeholder="Telephone" >
								</div>
							</div>

							<div class="form-group ">
								<label for="User Access Group"class="col-lg-4 col-md-4 control-label">User Access Group</label>

								<div class="col-lg-8 col-md-8 noPadding">
									<div class="ms-container ">
										<div class="ms-selectable col-lg-5 col-md-5 margin-res">
											<h4 class="headingAccess">Available</h4>
											<input class="form-control">
											<ul class="ms-list margin-res">
												<li class="ms-optgroup-label"><span> Main</span></li>
												<select class=" form-control all_options" multiple="multiple" name="all_options">
													<option value="1">11-Access Level 4</option>
													<option value="2">13-Access Level 7</option>
													<option value="3">11-Access Level 4</option>
													<option value="4">13-Access Level 7</option>
													<option value="5">11-Access Level 4</option>
													<option value="6">13-Access Level 7</option>
													<option value="7">11-Access Level 4</option>
													<option value="8">13-Access Level 7</option>
												</select>
											</ul>
											<div align="col-sm-12 noPadding">
									          <button class="go_in btn btn-primary w100">Add 
									          <span class="fa fa-angle-double-right"></span>
											</button>
											</div>
										</div>
										<div class="ms-selectable col-lg-5 col-md-5 ">
											<h4 class="headingAccess">Selected</h4>
											<input class="form-control">
											<ul class="ms-list margin-res">
												<li class="ms-optgroup-label"><span> Main</span></li>
												<select class=" chosen_options form-control" multiple="multiple" name="chosen_options">
													<option value="9">11-Access Level 4</option>
												</select>
											</ul>
											<div class="col-sm-12 noPadding">
												<button class="go_out btn btn-primary col-sm-12 w100">
													<span class="fa fa-angle-double-left"> Remove </span>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group ">
								<label for="Floor Access Group"
									class="col-lg-4 col-md-4 control-label">Floor Access Group</label>
								<div class="col-lg-8 col-md-8 noPadding">
									<div class="ms-container">
										<div class="ms-selectable col-lg-5 col-md-5 margin-res">
											<h4 class="headingAccess">Available</h4>
											<input class="form-control">
											<ul class="ms-list margin-res">
												<li class="ms-optgroup-label"><span> Main</span></li>
												<select class=" form-control all_floor_options" multiple="multiple" name="all_floor_options ">
													<option value="1">11-Access Level 4</option>
													<option value="2">13-Access Level 7</option>
													<option value="3">11-Access Level 4</option>
													<option value="4">13-Access Level 7</option>
													<option value="5">11-Access Level 4</option>
													<option value="6">13-Access Level 7</option>
													<option value="7">11-Access Level 4</option>
													<option value="8">13-Access Level 7</option>
												</select>
											</ul>
											<div align="col-sm-12 noPadding">
												<button class="floorAccessAdd btn btn-primary w100">Add 
												<span class="fa fa-angle-double-right"></span>
												</button>
											</div>
										</div>
										<div class="ms-selectable col-lg-5 col-md-5 ">
											<h4 class="headingAccess">Selected</h4>
											<input class="form-control" type="text">
											<ul class="ms-list margin-res">
												<li class="ms-optgroup-label"><span> Main</span></li>
												<select class=" chosen_floor_options form-control" multiple="multiple" name="chosen_floor_options">
													<option value="1">11-Access Level 4</option>
												</select>
											</ul>
											<div class="col-sm-12 noPadding">
												<button class="floorAccessRemove btn btn-primary w100">
													<span class="fa fa-angle-double-left"> Remove</span>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-group ">
								<label for="startDatepicker" class="col-lg-4 col-md-4 control-label">Start Date</label>
								<div class="col-lg-8 col-md-8">
									<input id="startDatepicker" class="date-picker" type="text" name="startDatepicker">
								</div>
							</div>
							<div class="form-group ">
								<label for="endDatepicker" class="col-lg-4 col-md-4 control-label">End Date</label>
								<div class="col-lg-8 col-md-8">
									<input id="endDatepicker" class="date-picker" type="text" name="endDatepicker">
								</div>
							</div>
							<div class="form-group ">
								<label for="accountDisabled"
									class="col-lg-4 col-md-4 control-label">Account Disabled</label>
								<div class="col-lg-8 col-md-8">
									<input placeholder="Wiegand Card Number" type="checkbox">
								</div>
							</div>
							<div class="form-group ">
								<label for="accessibility"
									class="col-lg-4 col-md-4 control-label">Accessibility</label>
								<div class="col-lg-8 col-md-8">
			                       	<input placeholder="Wiegand Card Number" type="checkbox">
								</div>
							</div>
							<div class="form-group ">
								<label for="enableAdminFunctions"
									class="col-lg-4 col-md-4 control-label">Enable Admin Functions</label>
								<div class="col-lg-5 col-md-5">
									<input type="radio" ng-model="showHideAdminDetails" name="enableAdminFunctions" ng-value="true">Yes</input>
									 <input type="radio" ng-model="showHideAdminDetails" name="enableAdminFunctions" ng-value="false">No</input>
								</div>
							</div>
						</div>
						<div ng-show="showHideAdminDetails">
						   <div class="col-lg-10 col-md-10">
									<div class="col-lg-12">
										<h4 class="page-header">View/Edit Admin User</h4>
									</div>
									<div class="form-group ">
										<label for="userId" class="col-lg-4 col-md-4 control-label">User ID</label>
										 <div class="col-lg-5 col-md-5">
								               <input class="form-control" placeholder="User ID">
										  </div>
									</div>
			     					<div class="form-group ">
										<label for="password" class="col-lg-4 col-md-4 control-label">Password</label>
										<div class="col-lg-5 col-md-5">
											<input class="form-control" placeholder="Password" name="password" type="password" >
										</div>
									</div>
									<div class="form-group ">
										<label for="verifyPassword" class="col-lg-4 col-md-4 control-label">Verify Password</label>
										 <div class="col-lg-5 col-md-5">
												<input class="form-control" placeholder="Verify Password" type="password" >
										 </div>
									</div>
									<div class="form-group ">
										<label for="business" class="col-lg-4 col-md-4 control-label">Business</label>
										<div class="col-lg-5 col-md-5" ng-init="radio2=1">
											  <input type="radio" checked="checked" ng-model="radio2" name="business" value="1">Yes</input> 
											  <input type="radio" name="business" value="0">No</input>
											  <textarea class="form-control" name="txtAreaBusiness"/>
										</div>
									</div>
									<div class="form-group ">
										<label for="sites" class="col-lg-4 col-md-4 control-label">Sites</label>
										<div class="col-lg-5 col-md-5" ng-init="sites='Full Access'">
											<select class="form-control" ng-model="sites" name="sites">
													<option>Full Access</option>
													<option>Read Only</option>
											</select>
										</div>
										</div>
									<div class="form-group ">
										<label for="suites" class="col-lg-4 col-md-4 control-label">Suites</label>
										<div class="col-lg-5 col-md-5" ng-init="suites='No Access'">
											<select class="form-control" ng-model="suites" name="suites">
												<option>Full Access</option>
													<option>No Access</option>
											</select>
										</div>
									</div>
									<div class="form-group ">
										<label for="users" class="col-lg-4 col-md-4 control-label">Users</label>
										<div class="col-lg-5 col-md-5" ng-init="users='No Access'">
											<select class="form-control" ng-model="users" name="users">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
											</select>
										</div>
									</div>
									<div class="form-group ">
										<label for="access" class="col-lg-4 col-md-4 control-label">Access</label>
										<div class="col-lg-5 col-md-5" ng-init="access='Read Only'">
											<select class="form-control" ng-model="access" name="access">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
											</select>
									    </div>
									</div>
									<div class="form-group ">
										<label for="controlledAreas" class="col-lg-4 col-md-4 control-label">Controlled Areas</label>
										<div class="col-lg-5 col-md-5" ng-init="controlAreas='Full Access'">
											<select class="form-control" ng-model="controlAreas" name="controlledAreas">
													<option>Full Access</option>
													<option>Read Only</option>
											</select>
										</div>
									</div>
									<div class="form-group ">
										<label for="schedules" class="col-lg-4 col-md-4 control-label">Schedules</label>
											<div class="col-lg-5 col-md-5" ng-init="schedules='No Access'">
												<select class="form-control" ng-model="schedules" name="schedules">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
										<label for="log" class="col-lg-4 col-md-4 control-label">Log</label>
											<div class="col-lg-5 col-md-5" ng-init="log='Full Access'">
										     	<select class="form-control" ng-model="log" name="log">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
										<label for="adminUsers" class="col-lg-4 col-md-4 control-label">Admin Users</label>
										   <div class="col-lg-5 col-md-5" ng-init="adminUsers='No Access'">
												<select class="form-control" ng-model="adminUsers" name="adminUsers">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
												</select>
										  </div>
									</div>
									<div class="form-group ">
										<label for="commPorts" class="col-lg-4 col-md-4 control-label">Comm Ports</label>
										   <div class="col-lg-5 col-md-5" ng-init="commPorts='No Access'">
										    <select class="form-control" ng-model="commPorts" name="commPorts">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
											</select>
										   </div>
									</div>
									<div class="form-group ">
											<label for="devices" class="col-lg-4 col-md-4 control-label">Devices</label>
											   <div class="col-lg-5 col-md-5" ng-init="devices='No Access'">
												  <select class="form-control" ng-model="devices" name="devices">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
												  </select>
											   </div>
									</div>
									<div class="form-group ">
											<label for="panels" class="col-lg-4 col-md-4 control-label">Panels</label>
											   <div class="col-lg-5 col-md-5" ng-init="panels='No Access'">
												<select class="form-control" ng-model="panels" name="panels">
													<option>Full Access</option>
													<option>Read Only</option>
													<option>No Access</option>
												</select>
											   </div>
									</div>
									<div class="form-group ">
											<label for="backup" class="col-lg-4 col-md-4 control-label">Backup</label>
											<div class="col-lg-5 col-md-5" ng-init="backup='No Access'">
												<select class="form-control" ng-model="backup" name="backup">
													<option>Full Access</option>
													<option>No Access</option>
												</select>

											</div>
									</div>
									<div class="form-group ">
											<label for="restoreData"
												class="col-lg-4 col-md-4 control-label">Restore/Data</label>
											<div class="col-lg-5 col-md-5"
												ng-init="restoreData='No Access'">
												<select class="form-control" ng-model="restoreData" name="restoreData">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
											<label for="audit" class="col-lg-4 col-md-4 control-label">Audit</label>
											<div class="col-lg-5 col-md-5" ng-init="audit='No Access'">
												<select class="form-control" ng-model="audit" name="audit">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
										<label for="riskLevel" class="col-lg-4 col-md-4 control-label">Risk Level</label>
											<div class="col-lg-5 col-md-5" ng-init="riskLevel='No Access'">
												<select class="form-control" ng-model="riskLevel" name="riskLevel">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
										<label for="utilities" class="col-lg-4 col-md-4 control-label">Utilities</label>
											<div class="col-lg-5 col-md-5"
												ng-init="utilities='No Access'">
												<select class="form-control" ng-model="utilities" name="utilities">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
									        </div>
									</div>
									<div class="form-group ">
										<label for="utilities" class="col-lg-4 col-md-4 control-label">PIV</label>
											<div class="col-lg-5 col-md-5" ng-init="piv='No Access'">
												<select class="form-control" ng-model="piv" name="piv">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
									<div class="form-group ">
										<label for="utilities" class="col-lg-4 col-md-4 control-label">NVR Servers</label>
											<div class="col-lg-5 col-md-5" ng-init="nvrServers='No Access'">
												<select class="form-control" ng-model="nvrServers" name="nvrServers">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
										</div>
										
									<div class="form-group ">
										<label for="muster" class="col-lg-4 col-md-4 control-label">Mustering</label>
											<div class="col-lg-5 col-md-5"ng-init="mustering='No Access'">
												<select class="form-control" ng-model="mustering" name="mustering">
													<option>Full Access</option>
													<option>No Access</option>
												</select>
											</div>
									</div>
							   </div>
						  </div>
			         </div>
				</form>    		
	       </div>
	  </div>
		<div class="page-action">
			<span class="page-action-span">Actions</span>
			<button type="button" class="btn btn-success" ng-click="addNewUser()"><span class="fa fa-check" accesskey="s"><span class="p-l">Save</span></span></button>
			<button type="button" class="btn btn-warning" ng-click="cancelUser()"><span class="fa fa-ban" accesskey="c"><span class="p-l">Cancel</span></span></button>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 noPadding">
		<div class="panel panel-default">
 			<div class="panel-body">
 				<div class="panel info-box panel-default">
		            <div class="panel-body noPadding">
		                <div class="info-box-stats">
		                    <p class="counter">107,200</p>
		                    <span class="info-box-title">User activity this month</span>
		                </div>
		                <div class="info-box-icon">
		                    <i class="fa fa-user"></i>
		                </div>
		                <div class="info-box-progress">
		                    <div class="progress progress-xs progress-squared bs-n">
		                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
		        <div class="panel info-box panel-default">
                     <div class="panel-body noPadding">
                         <div class="info-box-stats">
                             <p class="counter">340,230</p>
                             <span class="info-box-title">Page views</span>
                         </div>
                         <div class="info-box-icon">
                             <i class="icon-eye"></i>
                         </div>
                         <div class="info-box-progress">
                             <div class="progress progress-xs progress-squared bs-n">
                                 <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
                 <div class="panel info-box panel-default">
                     <div class="panel-body noPadding">
                         <div class="info-box-stats">
                             <p>$<span class="counter">653,000</span></p>
                             <span class="info-box-title">Monthly revenue goal</span>
                         </div>
                         <div class="info-box-icon">
                             <i class="icon-basket"></i>
                         </div>
                         <div class="info-box-progress">
                             <div class="progress progress-xs progress-squared bs-n">
                                 <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
                 <div class="panel info-box panel-default">
                     <div class="panel-body noPadding">
                         <div class="info-box-stats">
                             <p class="counter">47,500</p>
                             <span class="info-box-title">New emails recieved</span>
                         </div>
                         <div class="info-box-icon">
                             <i class="icon-envelope"></i>
                         </div>
                         <div class="info-box-progress">
                             <div class="progress progress-xs progress-squared bs-n">
                                 <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
                 <div class="panel info-box panel-default">
		            <div class="panel-body noPadding">
		                <div class="info-box-stats">
		                    <p class="counter">107,200</p>
		                    <span class="info-box-title">User activity this month</span>
		                </div>
		                <div class="info-box-icon">
		                    <i class="fa fa-user"></i>
		                </div>
		                <div class="info-box-progress">
		                    <div class="progress progress-xs progress-squared bs-n">
		                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
 			</div>
        </div>
	</div>
</div>
<o:pageFooter></o:pageFooter>
<script>
	$(function() {
		$("#startDatepicker").datepicker();
		$("#endDatepicker").datepicker();
	});
</script>

