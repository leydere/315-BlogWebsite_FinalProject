<h1 class="page-header">Categories</h1>

 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationID">Navigation ID</label>
	 <input type="text" class="form-control" id="navigationID" autofocus required>
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="categoryName">Category Name</label>
	 <input type="text" class="form-control" id="categoryName" autofocus required>     
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="categoryImage">Image</label>
	 <input type="text" class="form-control" id="categoryImage" autofocus required>     
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="categoryContent">Content</label>
	 <input type="text" class="form-control" id="categoryContent" autofocus required>     
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="categoryOrder">Order</label>
	 <input type="text" class="form-control" id="categoryOrder" autofocus required>     
 </div>
<div class="form-group col-xs-12 col-md-6">
	 <label for="categoryVisible">Visible</label>
	 <select class="form-control" id="categoryVisible">
	 	<option value= "1" selected >Yes</option>
	 	<option value= "0" >No</option>
	 </select>
</div>
<div class="form-group">
	<span>
     	<button class="btn btn-primary"  type="submit" onclick="addCategory()" id="categoryAdd" data-toggle="tooltip" title="Add Category">Add Category</button>
	</span>

 	<span>
     	<button class = "btn btn-link" type="button" onclick="window.location.reload(true)" data-toggle="tooltip" title="Cancels adding the Category, and refreshes this webpage.">Cancel</button>
   	</span>
</div>   
 
<table class = "table table-hover">
    <thead id="categoryBody">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Navigation</th>
        <th>Name</th>
        <th>Image</th>
        <th>Content</th>
        <th>Order</th>
        <th>Visible</th>
    </tr>
    </thead>
</table>

<div id="deleteCatModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">Confirmation</h5>
                 <button type="button" class="close" data-dismiss="modal">&times;</button>
             </div>
             <div class="modal-body">
             	<p class="text-secondary">Are you sure you want to delete this category?</p>
             	<label>ID</label>
             	<p id='catID' class="text-secondary"></p>
             	<label>Name</label>
             	<p id='catName' class="text-secondary"></p>
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                 <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteCategory()">Delete</button>
             </div>
         </div>
     </div>
</div>