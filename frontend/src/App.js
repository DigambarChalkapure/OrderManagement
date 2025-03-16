import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import './App.css';
import ProductList from './components/ProductList';
import CustomerList from './components/CustomerList';
import OrderList from './components/OrderList';
import Navbar from "./components/Navbar";

function App() {
  return (
    <div className="App">
    <Router>
    <Navbar/>
      <Routes>
        <Route path="/productlist" element = {<ProductList/>}/>
        <Route path="/customerlist" element = {<CustomerList/>}/>
        <Route path="/orderlist" element = {<OrderList/>}/>
      </Routes>
    </Router>
    </div>
  );
}

export default App;
