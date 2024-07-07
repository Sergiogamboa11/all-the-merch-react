import React from 'react'
import { PRODUCTS } from '../../products'
import { Product } from './Product'
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
          <Product data={product} />
        ))

        }
      </div>
    </div>
  )
}