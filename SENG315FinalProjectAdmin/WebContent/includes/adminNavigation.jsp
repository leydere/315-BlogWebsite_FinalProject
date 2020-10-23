<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./index.jsp?view=navigationlist">
          <i class="fas fa-fw fa-sitemap"></i>
          <span>Navigations</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./index.jsp?view=categorylist">
          <i class="fas fa-fw fa-bars"></i>
          <span>Categories</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Articles</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <a class="dropdown-item" href="./index.jsp?view=articlelist">View Articles</a>
          <a class="dropdown-item" href="./index.jsp?view=articleadd">Add Article</a>
        </div>
      </li>
            <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="usersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-user"></i>
          <span>Users</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="usersDropdown">
          <a class="dropdown-item" href="./index.jsp?view=userlist">View Users</a>
          <a class="dropdown-item" href="./index.jsp?view=useradd">Add Users</a>
        </div>
      </li>

    </ul>

    <div id="content-wrapper">

