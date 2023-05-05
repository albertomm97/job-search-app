import React, { useState } from 'react';

const Context = React.createContext({});

export function FilterOfferContextProvider({ children }) {
  const [filter, setFilter] = useState({});

  return (
    <Context.Provider value={{ filter, setFilter }}>
      {children}
    </Context.Provider>
  );
}

export default Context;
