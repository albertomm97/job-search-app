import React, { useContext } from 'react';
import OfferList from '../../components/Offer/OfferList';
import { useOffers } from '../../hooks/useOffers';

import FilterOfferContext from '../../context/FilterOfferContext';

const SearchResults = () => {
  const filterOffer = useContext(FilterOfferContext);
  filterOffer.keyword = filterOffer.keyword || '';

  console.log(filterOffer.filter);

  const offers = useOffers(filterOffer.filter);

  return <OfferList offers={offers} />;
};
export default SearchResults;
