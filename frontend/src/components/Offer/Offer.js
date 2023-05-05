import React from 'react';

import './Offer.css';

const Offer = ({ offer }) => {
  const separator = offer.isNew ? '| ' : '';

  //console.log(offer);

  return (
    <div className="offer">
      <img src="/logo192.png" alt="holi"></img>
      <div className="offer-details">
        <h4 className="offer-title">{offer.title}</h4>
        <p className="company-name">{offer.companyName}</p>
        <p>
          <span>{offer.place}</span> {separator}
          {offer.isNew && <span>New</span>}
        </p>
        <p className="description">{offer.description}</p>
        <p>
          <span>{offer.type}</span> | <span>{offer.experience}</span> |
          <span>{offer.category}</span> | <span>{offer.salary}</span>
        </p>
      </div>
    </div>
  );
};

export default Offer;
