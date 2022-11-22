import React from 'react';

import CompanyData from '../../components/CompanyDetails/CompanyData';
import JobsOffered from '../../components/CompanyDetails/JobsOffered';

import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';

const CompanyDetail = () => {
  const [, navigate] = useLocation();
  const { isLogged, type } = useUser();

  if (!isLogged || type !== 'company') navigate('/');

  return (
    <div className="cvPartsContainer center">
      <h2>Company Details</h2>
      <div>
        <CompanyData />
        <JobsOffered />
      </div>
    </div>
  );
};

export default CompanyDetail;
