import React, { useEffect, useState } from 'react'
import axios from 'axios'
import "./Product.css"

export const Product = (props) => {

  const [product, setProduct] = useState([])

  useEffect(() => {
    axios.get('http://localhost:9026/api/products/1').then(res => {
      setProduct(res.data)
    })
  }, [])

  return (
    <div className="shop-margins">
      <h1 className='product-detail-title'>{product.name} - ${product.price}</h1>
      <div>
        <img className='product-detail-image' src={product.image} />
      </div>
      <div>
      </div>
    </div>
  )
}
