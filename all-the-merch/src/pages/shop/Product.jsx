import React from 'react'

export const Product = (props) => {
    const { id, key, name, image, price } = props.data;
    return (
        <div>
            <div>{name}</div>
            <div>{image}</div>
            <div>{price}</div>
        </div>
    )
}
