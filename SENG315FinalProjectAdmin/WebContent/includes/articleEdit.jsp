<h1 class="page-header">Edit Article</h1>

<div class="form-group col-xs-12 col-md-6">
        <label for="articleTitle">Title</label>
        <input type="text" class="form-control" id="articleTitle" value="" required autofocus>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Category</label>
    <input class="form-control" id="categoryID" required></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="authorID">Author ID</label>
    <input type="text" class="form-control" id="articleAuthorID" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleImage">Article Image</label>
    <input type="text" class="form-control" id="articleImage" required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="articleContent">Content</label>
    <input type="text" class="form-control" id="articleContent" autofocus required>
</div>


<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=updateArticle(); data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>