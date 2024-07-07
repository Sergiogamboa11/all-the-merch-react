import React from 'react'
import "./Product.css"

export const Product = (props) => {
    const { id, key, name, image, price } = props.data;
    return (
        <div className="product-container">
            <img className="product-image" src={image} />
            <div>{name}</div>
            <div>${price}</div>
        </div>
    )
}
