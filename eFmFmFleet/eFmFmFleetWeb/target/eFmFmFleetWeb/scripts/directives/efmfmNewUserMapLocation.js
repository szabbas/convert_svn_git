(function(){    
    var efmfmNewUserMapLocation = function(){        
            return{
            restrict: 'E',
            scope :true,
            template: '<div></div>',
            replace:true,           
            link:function(scope, element, attrs, user){
                console.log("In the efmfmNewUserMapLocation directives");
                var newAddress = '';
                var newArea = '';
                var center = new google.maps.LatLng(12.844873,80.226535);
                var mapOptions = {
                center: center,
                zoom: 10,
                mapTypeControl: false,
                streetViewControl: false,
                mapTypeId: google.maps.MapTypeId.ROADMAP
                };
            
                map = new google.maps.Map(document.getElementById(attrs.id), mapOptions); 
                
                //Creating Marker
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(12.844873,80.226535),
                    map: map,
                    animation: google.maps.Animation.DROP,
                    draggable:true
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
                                console.log(results[0].address_components[1].long_name);
                                newAddress = results[0].formatted_address;
                                newArea = results[0].address_components[1].long_name;
                                console.log('NEW ADDRESS :: ' + newAddress);
                             //VERY IMPORTANT: $apply() will update the parent scope    
                              scope.$apply(function(){
                                    scope.user.address = newAddress;
                                  scope.user.area = newArea;
                                });
                                document.getElementById("newAddress").value = newAddress; 
                            } 
                            else 
                            {
                                newAddress = 'Address not Found';
                                newArea = 'Area Not Found';
                                scope.$apply(function(){
                                    scope.user.address = newAddress;
                                    scope.user.area = newArea;
                                });
                                document.getElementById("newAddress").value = newAddress; 
                         }
                 });} 
     
                //Drag Event for the Pin
                google.maps.event.addListener(marker, 'dragend', function (event) {
                    var newlatlang = event.latLng.lat() + ',' + event.latLng.lng();
                    geocodePosition(marker.getPosition());                    
                    scope.$apply(function(){
                        scope.user.cords = newlatlang;
                    });   
                    document.getElementById("latlangInput").value = newlatlang;  
                    
                });
            }
        };
        
    };

 angular.module('efmfmApp').directive('efmfmNewUserMapLocation', efmfmNewUserMapLocation);
}());