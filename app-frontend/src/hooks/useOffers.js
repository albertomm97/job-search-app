import { useEffect, useState } from 'react';

import { getOffers } from '../services/getOffers';

const useOffers = (filter) => {
  const [offers, setOffers] = useState([]);

  useEffect(() => {
    setOffers(getOffers(filter));
    console.log('api call from offers');
  }, [filter]);

  const jsonObjects = JSON.stringify(offers);
  localStorage.setItem('lastSearchedOffers', jsonObjects);

  return offers;
};

export { useOffers };
