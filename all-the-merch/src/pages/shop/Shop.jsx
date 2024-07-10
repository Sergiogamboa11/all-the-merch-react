import React, { useEffect, useState } from 'react'
import { ProductCard } from './ProductCard'
import "./Shop.css"
import axios from 'axios'

export const Shop = () => {

  const [products, setProducts] = useState([])

  useEffect(() => {
    axios.get('http://localhost:9026/api/products').then(res => {
      setProducts(res.data.map(p => p))
    })
  })

  return (
    <div className="shop-margins">

      <div className="title">
        Featured
      </div>
      <div className="products">
        {" "}
        {products.map((product) => (
          <ProductCard data={product} />
        ))
        }
      </div>
    </div>
  )
}