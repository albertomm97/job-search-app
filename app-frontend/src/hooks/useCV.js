import { useEffect, useState } from 'react';

import { getAllUserData } from '../services/CV/cvService';

const useCV = (filter) => {
  const [cv, setCV] = useState({});

  useEffect(() => {
    const userData = getAllUserData(filter);
    console.log('DENTRO DE USEEFFECT');
    setCV(userData);
  }, [filter]);

  return cv;
};

export { useCV };
