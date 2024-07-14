import React, { useEffect, useState } from 'react'
import axios from 'axios'
import "./Product.css"

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
      <div className="shop-margins">
        <h1 className='product-detail-title'>{product.name} - ${product.price}</h1>
        <div>
          <img className='product-detail-image' src={product.image} />
        </div>
      </div>
    )
  } 
  else if (!id[2] || isLoaded) {
    return <div>This product does not exist!</div>
  }

}
