import { useEffect, useState } from "react";

const OrderList = () =>{

    const[orders, setOrders] = useState([]);
    const[keys, setKeys] = useState([]);
    const[loading, setLoading] = useState(true);
    const[error, setError] = useState(null);

    useEffect(()=>{
        fetch("http://localhost:8080/orders")
        .then((res)=>{
            if(!res.ok){
                throw new Error("Failed to fetch Orders");
            }
            return res.json();
        }).then((data)=>{
                setOrders(data);
                setLoading(false);
                setKeys(Object.keys(data[0]));
                //console.log(data[0]);
        }).catch((error)=>{
                setError(error.message);
                setLoading(false);
        })
    },[])
    if(loading) return <h3>Loading....</h3>
    if(error) return <h3>Error: {error}</h3>
    return(
        <div>
      <table className="table table-striped table-hover">
        <thead>
            <tr>
            {
                <>
                <th scope="col">{keys[0]}</th>
                <th scope="col">{keys[1]}</th>
                <th scope="col">{keys[2]}</th>
                <th scope="col">{keys[3]}</th>
                <th scope="col">{keys[4]}</th>
                <th scope="col">{keys[5]}</th>
                </>
            }
            </tr>
        </thead>
        <tbody>
        {orders.map((order,key) => (
            <tr>
                <th key={key} scope="row">{order.id}</th>
                <td>{order.orderNumber}</td>
                <td>{order.orderDate}</td>
                <td>{order.totalAmount}</td>
                <td>{order.orderStatus}</td>
                <td>{order.paymentStatus}</td>
            </tr>
        ))}
            
        </tbody>
        </table>
    </div>
    );
}

export default OrderList;