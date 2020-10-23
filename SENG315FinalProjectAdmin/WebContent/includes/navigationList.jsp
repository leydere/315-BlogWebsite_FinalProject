<h1 class="page-header">Navigations</h1>

 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationName">Navigation Name</label>
	 <input type="text" class="form-control" name="navigationName" id="navigationName" autofocus required>
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationURL">URL</label>
	 <input type="text" class="form-control" name="navURL" id="navigationURL" autofocus required>     
 </div>
 <div class="form-group col-xs-12 col-md-6">
	 <label for="navigationOrder">Order</label>
	 <input type="text" class="form-control" name="navigationOrder" id="navigationOrder" autofocus required>     
</div>
<div class="form-group col-xs-12 col-md-6">
	 <label for="navigationVisible">Visible</label>
	 <select class="form-control" id="navigationVisible" name="navigationVisible">
	 	<option value= "1" selected >Yes</option>
	 	<option value= "0" >No</option>
	 </select>
</div>
<div class="form-group">
	<span>
     	<button class="btn btn-primary"  type="submit" onclick="addNavigation()" id="navigationAdd" data-toggle="tooltip" title="Add Navigation">Add Navigation</button>
	</span>

 	<span>
     	<button class = "btn btn-link" type="button" onclick="window.location.reload(true)" data-toggle="tooltip" title="Cancels adding the Navigation, and refreshes this webpage.">Cancel</button>
   	</span>
</div>   
 
<table class = "table table-hover">
    <thead id="navigationBody">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Name</th>
        <th>URL</th>
        <th>Order</th>
        <th>Visible</th>
    </tr>
    </thead>
</table>
<div id="deleteNavModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">Confirmation</h5>
                 <button type="button" class="close" data-dismiss="modal">&times;</button>
             </div>
             <div class="modal-body">
             	<p class="text-secondary">Are you sure you want to delete this navigation?</p>
             	<label>ID</label>
             	<p id='navID' class="text-secondary"></p>
             	<label>Name</label>
             	<p id='navName' class="text-secondary"></p>
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                 <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteNavigation()">Delete</button>
             </div>
         </div>
     </div>
</div>