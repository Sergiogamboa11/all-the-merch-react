import React from 'react'
import { PRODUCTS } from '../../products'
import { ProductCard } from './ProductCard'
import "./Shop.css"

export const Shop = () => {
  return (
    <div className="shop">

      <div className="title">
        AllTheMerch
      </div>
      <div className="products">
        {" "}
        {PRODUCTS.map((product) => (
          <ProductCard data={product} />
        ))
        }
      </div>
    </div>
  )
}