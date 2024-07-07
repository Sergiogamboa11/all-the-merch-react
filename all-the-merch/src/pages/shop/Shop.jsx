import React from 'react'
import { PRODUCTS } from '../../products'
import { Product } from './Product'

export const Shop = () => {
  return (
    <div className="shop">

      <div className="title">
        <h1>
          AllTheMerch
        </h1>
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