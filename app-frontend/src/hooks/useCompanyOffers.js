import { useContext, useCallback, useEffect } from 'react';

import Context from '../context/CompanyJobsContext';

import { getJobsOffered } from '../services/CompanyDetails/jobsOfferedService';

const useCompanyOffers = (filter) => {
  const { jobsOffered, setJobsOffered } = useContext(Context);

  useEffect(() => {
    const jobs = getJobsOffered(filter);
    console.log('apicall useCOmpanyOFfers');
    setJobsOffered(jobs);
  }, [setJobsOffered]);

  return jobsOffered;
};

export { useCompanyOffers };
