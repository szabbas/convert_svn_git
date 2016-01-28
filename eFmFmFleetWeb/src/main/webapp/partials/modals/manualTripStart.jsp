<div ng-include = "'partials/showAlertMessageModalTemplate.jsp'"></div><div class="loading"></div>
<div class = "importEmployeeModal container-fluid">
    <div class = "row">
        <div class="modal-header modal-header1 col-md-12"> 
            <div class = "row">
                <div class = "icon-calendar edsModal-icon col-md-1 floatLeft"></div>
                <div class = "modalHeading col-md-8 floatLeft">Manual Trip Start End</div>
                <div class = "col-md-2 floatRight pointer">
                    <img src="images/portlet-remove-icon-white.png" class = "floatRight" ng-click = "cancel()">
                </div>    
            </div>
        </div>        
    </div>      
<div class="modal-body modalMainContent">     
  <form name = "addstartKmForm">  
	   <div class = "col-md-6 col-xs-12"> 
           <div>
           <label>Enter Trip Start Kilometer</label>
                <input type="text" 
                       ng-model="tripStart.kilometer" 
                       class="form-control" 
                       placeholder = "Start Kilometer"
                       required
                       ng-pattern = "regexDecimalNumbers"
                       name = "startKm"
                       ng-minlength="0"
                       ng-maxlength="50"
                 required
                 ng-class = "{error: addstartKmForm.startKm.$invalid && !addstartKmForm.startKm.$pristine}">
           </div>
       </div>
  </form>   
     <div class="modal-footer modalFooter">  
           <button type="button" 
                   class="btn btn-info floatLeft" 
                   id='imp_stud' 
                   ng-click = "enterStartKm(tripStart)"
                   ng-disabled="addstartKmForm.$invalid">Start Trip</button>
           <button type="button" class="btn btn-close floatLeft" ng-click = "cancel()">Cancel</button>
     </div>
</div>
</div>