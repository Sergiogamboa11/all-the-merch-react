import React, { useEffect, useState } from 'react'
import axios from 'axios'
import "./Product.css"
import Button from 'react-bootstrap/Button';

export const Product = () => {

  const [product, setProduct] = useState(undefined)
  const [isLoaded, setLoaded] = useState(false)
  let id = window.location.pathname.split('/');


  useEffect(() => {
    axios.get('http://localhost:9026/api/products/' + id[2]).then(res => {
      setProduct(res.data)
      setLoaded(true)
    })
  }, [])

  if (product) {
    return (
      <div className="shop-margins product-detail-container">
        <div className='product-detail'>
          <img className='product-detail-image' src={product.image} />
        </div>
        <div className='product-detail'>
          <h2 className='product-detail-title'>{product.name}</h2>
          <h4>${product.price}</h4>
          <div>
            <h5>Quantity:</h5>
            <input type="number" id="quantity" name="quantity" defaultValue="1" min="1" max="5"></input>
          </div>
          <Button variant="outline-success">Add to Cart</Button>{' '}
          <h3>Description</h3>
          <h5>{product.description}</h5>
        </div>
      </div>
    )
  }
  else if (!id[2] || isLoaded) {
    return <div>This product does not exist!</div>
  }

}
