import { useEffect, useState } from 'react';
import { getCategories } from '../services/FilterCategories/getCategories';

const useFilterCategories = (name = '') => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    console.log('api call from filters');
    setCategories(getCategories(name));
  }, [name]);

  return categories;
};

export { useFilterCategories };
