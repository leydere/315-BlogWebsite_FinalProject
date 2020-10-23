<h1 class="page-header">Category Edit</h1>

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
     	<button class="btn btn-primary"  type="submit" onclick="updateCategory()" data-toggle="tooltip" title="Save Changes">Save Changes</button>
	</span>

 	<span>
     	<button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
   	</span>
</div>