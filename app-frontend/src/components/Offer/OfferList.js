import React from 'react';

import Offer from './Offer';

const OfferList = ({ offers }) => {
  return (
    <div className="offersContainer">
      {offers.map((offer) => {
        return <Offer key={offer.id} id={offer.id} offer={offer} />;
      })}
    </div>
  );
};

export default OfferList;
