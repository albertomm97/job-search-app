import { useEffect, useState } from 'react';

import { getOffers } from '../services/getOffers';

const useOffers = (filter) => {
  const [offers, setOffers] = useState([]);

  //console.log(filter);

  useEffect(() => {
    setOffers(getOffers());
  }, [filter]);

  return offers;
};

export { useOffers };
