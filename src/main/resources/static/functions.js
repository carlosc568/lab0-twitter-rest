$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(event){
		event.preventDefault();
		target = $(this).attr('action')
        query = $("#q").val()
		$.get(target, { q: query } )
            .done( function(data) {
            	 var template = $('#template').html();
            	  Mustache.parse(template);   // optional, speeds up future uses
            	  var rendered = Mustache.render(template, data);
            	  $("#resultsBlock").html(rendered);
            }).fail(function() {
                $("#resultsBlock").empty();
            });
	});
}

