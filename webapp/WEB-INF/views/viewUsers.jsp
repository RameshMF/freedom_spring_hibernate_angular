<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>
<o:pageHeader></o:pageHeader>
<div class="page-inner">
	<div class="col-lg-9 col-md-9 col-xs-12 col-sm-12 noPadding panal-border">
			<div class="page-breadcrumb">
		         <ol class="breadcrumb noPadding">
		             <li>Home</li>
		             <li>Users</li>
		         </ol>
		     </div>
		     <div class="page-title">
		         <h3>Users</h3>
		     </div>
			<div class="panel panel-default">
	     		<div class="panel-body">
                  	<table id="viewUsersTable" class="table table-striped table-bordered dt-responsive nowrap" style="width: 100%; cellspacing: 0;">
						<thead>
                           <tr>
                               <!-- <th>User Id</th> -->
                               <th>Key</th>
                               <th>Value</th>
                              <!--  <th>Command</th> -->
                           </tr>
                       </thead>
					</table>
	     		</div>
	     	</div>
		<div class="page-action">
			<span class="page-action-span">Actions</span>
			<button type="button" id="disableButton" disabled='disabled' class="btn btn-warning" data-ng-click="updateUserRecord()"><span class="fa fa-check"><span class="p-l">Update</span></span></button>
			<button type="button" class="btn btn-danger" data-ng-click="cancelUserRecord()"><span class="fa fa-ban"><span class="p-l">Cancel</span></span></button>
		</div>
	</div>
	
		<div class="col-lg-3 col-md-3 col-xs-12 col-sm-12 noPadding">
		<div class="panel panel-default">
 			<div class="panel-body">
 				<div class="panel info-box panel-default">
		            <div class="panel-body noPadding">
		                <div class="info-box-stats">
		                    <p class="counter">105,200</p>
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

<div class="modal fade" id="viewMessageModal" tabindex="-1" data-backdrop="static" data-keyboard="false" role="dialog" aria-labelledby="basicModal" aria-hidden="true"  >
	<div class="modal-dialog messageModalDialog modal-lg">
		<div class="modal-content">
			<o:popupHeader title=""  />
			<div class="modal-body fontSize17">
				<div class="row text-center">
						<o:success message="{{successMessage}}" />
					<div class="messageBtn">
					  <button class="btn btnSubmit btn-large btnOk" ng-click="closeModal('viewMessageModal')" type="button">Ok</button>
			       </div>
				</div>
			</div>
		</div>
	</div>
</div>
