<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<div data-ng-show="isAuthenticatedUser"><o:pageHeader></o:pageHeader></div>
<div class="page-inner" data-ng-show="isPageShow">

	<div id="main-wrapper">
		<div class="row">
			<div class="col-md-7 center">
	            <div class="login-box">
	                <p class="logo-name text-center">FREEDOM Database-Configuration</p>
	             </div>
			</div>
			<br/>
			<div class="row center">
				<div class="col-md-offset-3 col-md-5 col-sm-8 col-sm-offset-1">				
					<form class="form-horizontal" ng-submit="submitDatabaseConfig()" role="form" name="userDatabaseConfig">
			  		<div class="form-group ">
						    <label class="control-label col-sm-4 col-md-4" for="databaseType">Database Type:</label>
						    <div class="col-sm-8 col-md-8">
						    	<select class="form-control" ng-model="activeDatabase.databaseType" required>
						    		<option value="MySQL">MySQL</option>
						    		<option value="PostgreSQL">PostgreSQL</option>
						    	</select>		     
						    </div>
					</div>
						  
						   <div class="form-group">
						   <label class="control-label col-sm-4" for="isssl">isSSL:</label>
						   		<div class="checkbox col-sm-8 col-md-2" required>
				                       <label>
				                           <input id='isssl' name="isssl" type="checkbox" ng-model="activeDatabase.isSsl">
				                       </label>
				                 </div>                       
				              </div>		   
						  
						  <div class="form-group">
						    <label class="control-label col-sm-4" for="hostName">Host:</label>
						    <div class="col-sm-8 col-md-8">
						      <input type="text" name="host" ng-model="activeDatabase.hostName" class="form-control" id="host" placeholder="" required>
						    </div>
						  </div>
						  
						  
						  <div class="form-group">
						    <label class="control-label col-sm-4 col-md-4" for="port">Port:</label>
						    <div class="col-sm-8 col-md-8 ">
						      <input type="text" name="port" ng-model="activeDatabase.port" class="form-control" id="port" placeholder="" required>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label class="control-label col-sm-4 col-sm-4" for="username">User:</label>
						    <div class="col-sm-8 col-sm-8 ">
						      <input type="text" name="user" ng-model="activeDatabase.username" class="form-control" id="user" placeholder="" required>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label class="control-label col-sm-4 col-md-4" for="password">Password:</label>
						    <div class="col-sm-8 col-md-8">
						      <input type="text" name="dbpassword" ng-model="activeDatabase.password" class="form-control" id="dbpassword" placeholder="" required>
						    </div>
						  </div>
						
						  <div class="form-group">
						    <label class="control-label col-sm-4 col-md-4" for="databaseName">Database Name:</label>
						    <div class="col-sm-8 col-md-8">
						      <input type="text"  name="dbname" ng-model="activeDatabase.databaseName" class="form-control" id="dbname" placeholder="" required>
						    </div>
						  </div>
						  
						  <div class="form-group text-center">
						  		<div class="col-sm-offset-4 col-md-offset-4 col-sm-8 col-md-8">
	  								<button type="submit" class="btn btn-sm btn-success btn-block" ng-disabled="userDatabaseConfig.$invalid">Submit</button>
	   							</div>
	   						</div>
						  
						</form>
	
					</div>
				</div>
			</div>
	</div>
</div>

 <div class="modal fade" id="MessageModal" tabindex="-1" data-backdrop="static" data-keyboard="false" role="dialog" aria-labelledby="basicModal" aria-hidden="true"  >
	<div class="modal-dialog messageModalDialog modal-lg">
		<div class="modal-content">
			<o:popupHeader title=""  />
			<div class="modal-body fontSize17">
				<div class="row text-center">
						<o:success message="{{successMessage}}" />
					<div class="messageBtn">
					  <button class="btn btnSubmit btn-large btnOk" ng-click="closeModal('MessageModal')" type="button">Ok</button>
			       </div>
				</div>
			</div>
		</div>
	</div>
</div>

<div data-ng-show="isAuthenticatedUser"><o:pageFooter></o:pageFooter></div>