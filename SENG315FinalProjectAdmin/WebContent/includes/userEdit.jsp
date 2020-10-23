<h1 class="page-header">Edit User</h1>

<div class="form-group col-xs-12 col-md-6">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" id="firstName" value="" required autofocus>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="lastName">Last Name</label>
    <input class="form-control" id="lastName" required></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="email">Email</label>
    <input type="text" class="form-control" id="email" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="password">Password</label>
    <input type="text" class="form-control" id="password" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
	 <label for="active">Active</label>
	 <select class="form-control" id="active">
	 	<option value= "1" selected >Yes</option>
	 	<option value= "0" >No</option>
	 </select>
</div>


<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=updateUser(); data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>