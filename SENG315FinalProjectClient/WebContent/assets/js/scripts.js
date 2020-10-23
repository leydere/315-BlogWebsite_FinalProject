$(document).ready(function(){

	listNavigations();
	
	view = getQueryStringVariable('view');
	
	if(view == 'article'){
		articleID = getQueryStringVariable('articleID');
		getArticle(articleID);
	}else if(view == 'articlesbycat'){
		categoryID = getQueryStringVariable('categoryID');
		getCategory(categoryID);
		listArticlesByCategory(categoryID);
	}else{
		listArticles();
	}

});

var getQueryStringVariable = function ( field, url ) {
	var href = url ? url : window.location.href;
	var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
	var string = reg.exec(href);
	return string ? string[1] : null;
};


function listArticles(){
	
	var heading = "<h1 class='my-4'>eSports Central<small>Play to win</small></h1>";
	
	$("#articlePageHeading").append(heading);

	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/list/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {
    		
    		if(value.articleContent.length > 200){
    			value.articleContent = value.articleContent.substring(0,200) + "...";
    		}

    		var blogPosts = "<div class='card mb-4'>" +
            "<img id='imageId_"+value.articleAuthorId+"' class='card-img-top' src='./uploads/"+value.articleImage+"' alt='Card image cap'>" +
            "<div class='card-body'>" +
              "<h2 class='card-title'>" + value.articleTitle + "</h2>" +
              "<p class='card-text'>" + value.articleContent + "</p>" +
              "<a href='./index.jsp?view=article&articleID="+value.articleID+"' class='btn btn-info'>Read More &rarr;</a>" +
            "</div>" +
            "<div class='card-footer text-muted'>" +
              "Posted on January 1, 2017 by " +
              "<a id='usernameId_"+value.articleAuthorID+"' href='#'>"+value.articleAuthorID+"</a>" +
            "</div>" +
          "</div>";
    	
    		$("#blogBody").append(blogPosts);
    		
    	});
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
    	
    	$("#articleTitle").text(response.articleTitle);
    	$("#categoryID").text(response.categoryID);
    	$("#articleAuthorID").text(response.articleAuthorID);
    	$("#articleContent").text(response.articleContent);
    	$("#articleImage").attr("src","./uploads/"+response.articleImage);
    	$("#articleCreateDate").text(response.articleCreateDate);

	});
}

function listNavigations(){

	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/navigations/listvisible/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {

    		if(value.hasOwnProperty('categories')){
    			
    			navigations = "<li class='nav-item dropdown'><a class='nav-link dropdown-toggle' href='"+value.navigationURL+"' role='button' data-toggle='dropdown'>"+value.navigationName+"</a>";
    			navigations += "<div class='dropdown-menu'>";
    			
    			$.each(value.categories, function(k, v){
	    			navigations += "<a class='dropdown-item' href='index.jsp?view=articlesbycat&categoryID="+v.categoryID+"'>"+v.categoryName+"</a>";
    			});
    	
    			navigations += "</div></li>";
    			
    		}else{

    			navigations = "<li class='nav-item'><a class='nav-link' href='"+value.navigationURL+"'>"+value.navigationName+"</a></li>";
    		}
    		$("#navigationUL").append(navigations);
    		
    	});
	});
}

function getCategory(categoryID){
	
	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/categories/"+categoryID,
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){
      	
    	var heading = "<h1 class='my-4'>"+response.categoryName+"</h1><hr>"+
    	"<div class='row'><div><img class='img-responsive img-thumbnail img-rounded artImage' src='./uploads/"+response.categoryImage+"'>"+
    	response.categoryContent+"</div></div><hr>";
    	
    	$("#articlePageHeading").append(heading);

	});
}

function listArticlesByCategory(categoryID){

	$.ajax({
		url: "../SENG315FinalProjectAPIs/rest/articles/listByCategory/"+categoryID,
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {
    		
    		if(value.articleContent.length > 200){
    			value.articleContent = value.articleContent.substring(0,200) + "...";
    		}

    		var blogPosts = "<div class='card mb-4'>" +
            "<img id='imageId_"+value.articleAuthorId+"' class='card-img-top' src='./uploads/"+value.articleImage+"' alt='Card image cap'>" +
            "<div class='card-body'>" +
              "<h2 class='card-title'>" + value.articleTitle + "</h2>" +
              "<p class='card-text'>" + value.articleContent + "</p>" +
              "<a href='./index.jsp?view=article&articleID="+value.articleID+"' class='btn btn-info'>Read More &rarr;</a>" +
            "</div>" +
            "<div class='card-footer text-muted'>" +
              "Posted on January 1, 2017 by " +
              "<a id='usernameId_"+value.articleAuthorID+"' href='#'>"+value.articleAuthorID+"</a>" +
            "</div>" +
          "</div>";
    	
    		$("#blogBody").append(blogPosts);
    		
    	});
	});
}