function listArticles(){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/list/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    		if(value.articleContent.length > 150){
    			value.articleContent = value.articleContent.substring(0,150) + "...";
    		}
    		
    		var lstResults = "<tr><td><a href ='./index.jsp?view=articleedit&edit="+value.articleID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a></td>" +
            "<td>"+value.articleID+"</td><td>"+value.articleTitle+"</td><td>"+value.categoryID+"</td>"+
    		"<td>"+value.articleAuthorID+"</td><td>"+value.articleCreateDate+"</td><td></td><td>"+value.articleContent+"</td></tr>";
       		
    		if($("#postBody").text()){
    			document.getElementById('postBody').innerHTML += lstResults;
    		}
    	});
	});
}

function addArticle(){
	
	var articleTitle = $("#articleTitle").val();
	var categoryID = $("#categoryID").val();
	var articleAuthorID = $("#articleAuthorID").val();
	var articleContent = $("#articleContent").val();
	var articleImage = $("#articleImage").val();
	
	var parms = { articleTitle:articleTitle, categoryID:categoryID, articleAuthorID:articleAuthorID, articleContent:articleContent, articleImage:articleImage};
	
	$.ajax({
		url: "./rest/articles/add/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	alert(response.message);
	});
}

function updateArticle(){
	
	var articleTitle = $("#articleTitle").val();
	var categoryID = $("#categoryID").val();
	var articleContent = $("#articleContent").val();
	var articleImage = $("#articleImage").val();
	
	var parms = { articleID:articleID, articleTitle:articleTitle, categoryID:categoryID, articleContent:articleContent, articleImage:articleImage};
	
	$.ajax({
		url: "./rest/articles/update/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location = "./index.jsp?view=articlelist";
	});
}

function getArticle(articleID){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/"+articleID,
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){
    	
    	$("#articleTitle").val(response.articleTitle);
    	$("#categoryID").val(response.categoryID);
    	$("#articleAuthorID").val(response.articleAuthorID);
    	$("#articleContent").val(response.articleContent);
    	$("#articleImage").val(response.articleImage);

	});
}