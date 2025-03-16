import { useEffect, useState } from "react";

const CustomerList = () =>{

    const[customers, setCustomers] = useState([]);
    const[keys, setKeys] = useState([]);
    const[loading, setLoading ] = useState(true);
    const[error, setError] = useState(null);
     
    useEffect(()=>{
        fetch("http://localhost:8080/customers")
        .then((res)=>{
            if(!res.ok){
                throw new Error("Failed to Fetch Customers data");
            }
            return res.json();
        }).then((data)=>{
            setCustomers(data);
            setKeys(Object.keys(data[0]))
            setLoading(false);
            //console.log(data);

        }).catch((error)=>{
            setError(error.message);
            setLoading(false);
        })
    } ,[])
    if(loading) return <h3>Loading....</h3>
    if(error) return <h3>Error: {error}</h3>
    return(
        <div>
      <table className="table table-striped table-hover">
        <thead>
            <tr>
            {   <>
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
        {customers.map((customers,key) => (
            <tr>
                <th key={key} scope="row">{customers.customerId}</th>
                <td>{customers.f_name}</td>
                <td>{customers.l_name}</td>
                <td>{customers.username}</td>
                <td>{customers.phoneNumber}</td>
                <td>{customers.gender}</td>
            </tr>
        ))}
            
        </tbody>
        </table>
        </div>
    )
}

export default CustomerList;