import { useEffect, useState } from "react";

const ProductList = () =>{

    const[products, setProduct] = useState([]);
    const[keys, setKeys] = useState([]);
    const[loading, setLoading] = useState(true);
    const[error, setError] = useState(null);


    useEffect(
        () => {
            fetch("http://localhost:8080/products")
            .then((res) => {
                if(!res.ok){
                    throw new Error("Failed to fetch products");
                }
                return res.json();
            })
            .then((data)=>{
                setProduct(data);
                setKeys(Object.keys(data[0]));
                setLoading(false);
                //console.log(data);
            }).catch((error)=>{
                setError(error.message);
                setLoading(false);
            })
        },[]
    )
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
                </>
            }
            </tr>
        </thead>
        <tbody>
        {products.map((product,key) => (
            <tr>
                <th key={key} scope="row">{product.productId}</th>
                <td>{product.productName}</td>
                <td>{product.brand}</td>
                <td>{product.category}</td>
                <td>{product.price}</td>
            </tr>
        ))}
            
        </tbody>
        </table>
    </div>
    );
}

export default ProductList;