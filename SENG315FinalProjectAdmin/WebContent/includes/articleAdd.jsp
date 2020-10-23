<h1 class="page-header">Add Article</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="articleTitle">Title</label>
    <input type="text" class="form-control" id="articleTitle" autofocus required>
</div>

<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Category</label>
    <input type="text" class="form-control" id="categoryID" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="authorName">Author ID</label>
    <input type="text" class="form-control" id="articleAuthorID" value=<%=userID %> readonly >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleImage">Article Image</label>
    <input type="text" class="form-control" id="articleImage" required >
</div>
<div class="form-group col-xs-12 col-md-12">
    <label for="articleContent">Content</label>
    <input type="text" class="form-control" id="articleContent" autofocus required>
</div>
 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addArticle()" id="articleAdd" data-toggle="tooltip" title="Add Article">Add Article</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>