import { useEffect, useState } from 'react';

import { getOffers } from '../services/getOffers';

const useOffers = (filter) => {
  const [offers, setOffers] = useState([]);

  //console.log(filter);

  useEffect(() => {
    setOffers(getOffers());
    console.log('api call from offers');
  }, [filter]);

  return offers;
};

export { useOffers };
