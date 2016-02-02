<div class = "gdModal container-fluid">
    <div class = "row">
        <div class="modal-header modal-header1 col-md-12">
           <div class = "row"> 
            <div class = "icon-truck edsModal-icon col-md-1 floatLeft"></div>
            <div class = "modalHeading col-md-10 floatLeft">Total Accident Alerts</div>
            <div class = "col-md-1 floatRight pointer">
                <img src="images/portlet-remove-icon-white.png" class = "floatRight" ng-click = "cancel()">
            </div> 
           </div> 
        </div>        
    </div>  
    <div class = "row">
        <div class="modal-header2 col-md-12">
            <form><input class = "searchModal" 
                         ng-model = "searchRoadAlerts"
                         type="text" 
                         class="form-control" 
                         placeholder="Search..." 
                         id="formGroupInputSmall"></form>
        </div>
    </div>
    
<div class="modal-body modalMainContent">
    <table class="table table-bordered table-hover table-responsive container-fluid dashboardTable">
        <thead class ="tableHeading">
            <tr>
		   	  <th>Tittle</th>
		      <th>User Type</th>
              <th>Driver Name</th>
		      <th>Driver Number</th>
		      <th>Vehicle Number</th>
		      <th>Alert Type</th>		      
		      <th>Description</th>
		      <th>Zone Name</th>
		      
            </tr> 
        </thead>
        <tbody ng-show = "sosRoadAlertsData.length==0">
              <tr>
                 <td colspan = '8'>
                   <div class = "noData">No Employee Dropped</div>
                 </td>
              </tr>
        </tbody>
        <tbody ng-show = "sosRoadAlertsData.length>0">
            <tr ng-repeat = "roadAlert in sosRoadAlertsData | filter: searchRoadAlerts">
         	<td class = "col-md-1">{{roadAlert.tittle}}</td>
            	<td class = "col-md-1">{{roadAlert.userType}}</td>
                <td class = "col-md-2">{{roadAlert.driverName}}</td>                
                <td class = "col-md-2">{{roadAlert.driverNumber}}</td>                
                <td class = "col-md-1">{{roadAlert.vehicleNumber}}</td>                
                <td class = "col-md-1">{{roadAlert.alertType}}</td>                 
                <td class = "col-md-1">{{roadAlert.description}}</td>
                 <td class = "col-md-1">{{roadAlert.zoneName}}</td>
            </tr>
        </tbody>
        
    </table>
</div>
    
<div class="modal-footer modalFooter">     
    <button type="button" class="btn btn-success-gd" ng-click = "cancel()">Close</button>
</div>
</div>