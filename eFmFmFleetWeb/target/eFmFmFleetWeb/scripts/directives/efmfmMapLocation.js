(function(){
    
    var efmfmMapLocation = function(){        
            return{
            restrict: 'E',
            scope :true,
            template: '<div></div>',
            replace:true,           
            link:function(scope, element, attrs, employee){                 
                var latlong;
                var myLatlng;
                var newAddress;
                var employeeName = 'Employee Name: ' + scope.employee.employeeName;
                
                if(scope.employee.cords==='N'){
                    latlong[0] = '13.0524139';
                    latlong[1] = '80.25082459';
                    myLatlng = new google.maps.LatLng(latlong[0], latlong[1]);
                    newAddress = scope.employee.employeeAddress;
                }
                else{
                    latlong = scope.employee.cords.split(',');
                    myLatlng = new google.maps.LatLng(latlong[0], latlong[1]);
                    newAddress = scope.employee.employeeAddress;
                }

                
                //Initializing Map
                var mapOptions = {
                    zoom: 11,
                    center: myLatlng
                  }                
                var map = new google.maps.Map(document.getElementById(attrs.id), mapOptions);

                //Creating Marker
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(latlong[0], latlong[1]),
                    map: map,
                    animation: google.maps.Animation.DROP,
                    draggable:true,
                    title: employeeName
                  });     
                
                //Getting Address for New Location
                //This function is called after the Pin is dragged to a new location
                function geocodePosition(pos) 
                {
                   geocoder = new google.maps.Geocoder();
                   geocoder.geocode
                    ({
                        latLng: pos
                    }, 
                        function(results, status) 
                        {
                            if (status == google.maps.GeocoderStatus.OK) 
                            {
                                newAddress = results[0].formatted_address;
                                console.log('NEW ADDRESS :: ' + newAddress);
                             //VERY IMPORTANT: $apply() will update the parent scope    
                              scope.$apply(function(){
                                    scope.employee.employeeAddress = newAddress;
                                });
                                document.getElementById("newAddress").value = newAddress; 
                            } 
                            else 
                            {
                                newAddress = 'Address not Found';
                                scope.$apply(function(){
                                    scope.employee.employeeAddress = newAddress;
                                });
                                document.getElementById("newAddress").value = newAddress; 
                         }
                 });}
     
                //Drag Event for the Pin
                google.maps.event.addListener(marker, 'dragend', function (event) {
                    var newlatlang = event.latLng.lat() + ',' + event.latLng.lng();
                    geocodePosition(marker.getPosition());                    
                    scope.$apply(function(){
                        scope.employee.cords = newlatlang;
                    });   
                    document.getElementById("latlangInput").value = newlatlang;  
                    
                });
            }
        };
        
        
   //*****************NOT WORKIMG : ISOLATED SCOPE is NOT Updating the Parent Scope  
//        return{
//            restrict: 'E',
//            scope : {
//            mapCords: '=',
//            },
//            template: '<div></div>',
//            replace:true,           
//            link:function(scope, element, attrs){ 
//                
//                var myLatlng = new google.maps.LatLng(13.0524139,80.25082459);
//                var latlong = scope.mapCords.split(',');
//                console.log(latlong[0]);
//                var mapOptions = {
//                    zoom: 11,
//                    center: myLatlng
//                  }                
//                var map = new google.maps.Map(document.getElementById(attrs.id), mapOptions);
//
//                var marker = new google.maps.Marker({
//                    position: new google.maps.LatLng(latlong[0], latlong[1]),
//                    map: map,
//                    animation: google.maps.Animation.DROP,
//                    draggable:true,
//                    title: 'Employee Location'
//                  });     
//                
//                google.maps.event.addListener(marker, 'dragend', function (event) {
//                    var newlatlang = event.latLng.lat() + ',' + event.latLng.lng();
//                    console.log('New LatLong:: ' + newlatlang);
//                    scope.mapCords = newlatlang;
//                    
//                    console.log('scope.mapCords:: ' + scope.mapCords);
//                   $parse(attrs.ngModel).assign(scope, newlatlang);
//             //       attrs.ngModel = newlatlang;
////                    console.log("scope.mapCords" + scope.mapCords);                    
//                //    attrs.ngModel = newlatlang;
//                    document.getElementById("latlangInput").value = newlatlang;
////                    document.getElementById("temp").value = newlatlang;
//                });
//            }
//        };
        
    };

 angular.module('efmfmApp').directive('efmfmMapLocation', efmfmMapLocation);
}());