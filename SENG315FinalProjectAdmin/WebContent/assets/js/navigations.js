function listNavigations(){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/navigations/list/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		var lstResults = "<tr><td><a href ='./index.jsp?view=navedit&edit="+value.navigationID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a>" +
    		"<a href = '#' onclick=deleteNavModal('"+value.navigationID+"','"+encodeURIComponent(value.navigationName)+"') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
            "<td>"+value.navigationID+"</td><td>"+value.navigationName+"</td><td>"+value.navigationURL+"</td><td>"+value.navigationOrder+"</td>"+
    		"<td>"+value.navigationVisible+"</td></tr>";
       		
    		if($("#navigationBody").text()){
    			document.getElementById('navigationBody').innerHTML += lstResults;
    		}
    	});
	});
}

function addNavigation(){
	
	var navigationName = $("#navigationName").val();
	var navigationURL = $("#navigationURL").val();
	var navigationOrder = $("#navigationOrder").val();
	var navigationVisible = $("#navigationVisible").val();
	
	var parms = { navigationName:navigationName, navigationURL:navigationURL, navigationOrder:navigationOrder, navigationVisible:navigationVisible};
	
	$.ajax({
		url: "./rest/navigations/add/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location.reload(true);
	});
}

function getNavigation(navigationID){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/navigations/"+navigationID,
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){
    	
    	$("#navigationName").val(response.navigationName);
    	$("#navigationURL").val(response.navigationURL);
    	$("#navigationOrder").val(response.navigationOrder);
    	$("#navigationVisible").val(response.navigationVisible);

	});
}

function updateNavigation(){
	
	var navigationName = $("#navigationName").val();
	var navigationURL = $("#navigationURL").val();
	var navigationOrder = $("#navigationOrder").val();
	var navigationVisible = $("#navigationVisible").val();
	
	var parms = { navigationID:navigationID, navigationName:navigationName, navigationURL:navigationURL, navigationOrder:navigationOrder, navigationVisible:navigationVisible};
	
	$.ajax({
		url: "./rest/navigations/update/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location = "./index.jsp?view=navigationlist";
	});
}

function deleteNavModal(navID,navName){
	
	$("#deleteNavModal").modal('show');
	
	$('#navID').text(navID);
	$('#navName').text(decodeURIComponent(navName));
}

function deleteNavigation(){
	
	var navigationID = $("#navID").text();
	
	var parms = { navigationID:navigationID };
	
	$.ajax({
		url: "./rest/navigations/delete/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location = "./index.jsp?view=navigationlist";
	});
}