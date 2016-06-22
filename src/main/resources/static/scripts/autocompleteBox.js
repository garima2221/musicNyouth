/**
 * 
 */

			
			$(document).ready(function() {
    $(function() {
        $("#student").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "/getTags",
                    type: "GET",
                    data: request,
                    error: function(e) {
                        console.log(e);
                      },

                    dataType: "json",
                    

                    success: function(data) {
                    	response($.map(data, function(v,i){
                    	    return {
                    	                label: v.studentName,
                    	                value: v.studentName
                    	               };
                    	}));
                    }
               });              
            }   
        });
    });
});
