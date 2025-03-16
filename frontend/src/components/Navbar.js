import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <ul class="navbar-nav">
        <li class="nav-item"><Link class="nav-link active" to="/customerlist">Customers</Link></li>
        <li class="nav-item"><Link class="nav-link active" to="/orderlist">Orders</Link></li>
        <li class="nav-item"><Link class="nav-link active" to="/productlist">Products</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;