import React, { useState } from 'react';

const Context = React.createContext({});

export function CompanyJobsContextProvider({ children }) {
  const [jobsOffered, setJobsOffered] = useState([]);

  return (
    <Context.Provider value={{ jobsOffered, setJobsOffered }}>
      {children}
    </Context.Provider>
  );
}

export default Context;
