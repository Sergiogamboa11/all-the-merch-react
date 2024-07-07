import React from 'react'
import "./ProductCard.css"
import Button from 'react-bootstrap/Button';

export const ProductCard = (props) => {
    const { name, image, price } = props.data;
    return (
        <Button variant="light" href="/product">
            <img className="product-image" src={image} />
            <div>{name}</div>
            <div>${price}</div>
        </Button>
    )
}
