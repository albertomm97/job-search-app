import React from 'react';

import Offer from './Offer';

import { Link } from 'wouter';

const OfferList = ({ offers }) => {
  //console.log(`offers: ${offers}`);
  //console.log(offers);
  return (
    <div className="offersContainer">
      {Array.isArray(offers) ? (
        offers.map((offer) => {
          return (
            <Link key={offer.id} to={`/job-offer/${offer.id}`}>
              <a className="offerLink">
                <Offer key={offer.id} id={offer.id} offer={offer} />
              </a>
            </Link>
          );
        })
      ) : (
        <Link key={offers.id} to={`/job-offer/${offers.id}`}>
          <a className="offerLink">
            <Offer key={offers.id} id={offers.id} offer={offers} />
          </a>
        </Link>
      )}
    </div>
  );
};

export default OfferList;
