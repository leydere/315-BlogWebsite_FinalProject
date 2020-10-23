<h1 class="page-header">Add User</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="firstName">First Name</label>
    <input type="text" class="form-control" id="firstName" autofocus required>
</div>

<div class="form-group col-xs-12 col-md-6">
    <label for="lastName">Last Name</label>
    <input type="text" class="form-control" id="lastName" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="email">Email</label>
    <input type="text" class="form-control" id="email" required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" required >
</div>
<div class="form-group col-xs-12 col-md-12">
    <label for="password">Password</label>
    <input type="text" class="form-control" id="password" autofocus required>
</div>



 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addUser()" id="userAdd" data-toggle="tooltip" title="Add User">Add User</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>