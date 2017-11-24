<%@ taglib prefix="o" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="sessionTimeoutModal" tabindex="-1" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog messageModalDialog modal-lg">
		<div class="modal-content">
			<o:popupHeader title=""  />
			<div class="modal-body fontSize17">
				<div class="row text-center">
					<o:success message="Session timed out. Please login again." />
					<div class="messageBtn">
						<button class="btn btnSubmit btn-large btnOk" ng-click="closeModal('sessionTimeoutModal')" type="button">Ok</button>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

